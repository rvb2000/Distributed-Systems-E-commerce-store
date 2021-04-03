const express = require('express');
const eurekaHelper = require('./eurekaHelper');

const conf = require("./config.json");

const uri = conf.database.uri;

const MongoClient = require('mongodb').MongoClient;
var client = new MongoClient(uri,{ useUnifiedTopology: true});


const productApi = require('./controllers/productCatalogController');
const app = express();
app.use(express.json());
app.use(express.urlencoded());






// app.get('/', productApi.ping);
// app.post('/', productApi.ping2);
app.get('/search',productApi.autocomplete);
app.post('/search',productApi.searchProduct);
app.get('/product',productApi.searchProductById);
app.post('/product/seller',productApi.searchProductsBySellerId);



//Register to Eureka
eurekaHelper.registerWithEureka(conf.application.name, conf.server.port);


var coll;
var server = app.listen(conf.server.port, async()=>{
    // if(!err){
    //     console.log("Server running at port " + server.address().port);
    // }

    try{
        console.log("Server running at port " + server.address().port);
        await client.connect();
        coll = client.db(conf.database.name).collection(conf.database.collection);
        app.coll=coll;
        console.log("Database Connected Successfully");
    }catch(e){
        console.log(e);
    }
});

