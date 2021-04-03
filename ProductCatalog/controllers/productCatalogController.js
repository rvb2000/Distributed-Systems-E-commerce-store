
// const MongoClient = require('mongodb').MongoClient;
// const client= new MongoClient(uri,{useUnifiedTopology:true});
// var coll;
// var temp = async()=>{
//   try{
//     await client.connect();
//    coll = client.db('sample_mflix').collection('movies');
//    console.log("Database connected successfully!!!");
//  }catch(e){
//    console.log(e);
//  }
 
// };
// temp();


/*
 * Requires the MongoDB Node.js Driver
 * https://mongodb.github.io/node-mongodb-native
 */

const conf = require('../config.json');

exports.ping = async(req,res)=>{
    res.send("working fine");
}
exports.ping2 =async (req,res)=>{
  res.send(req.body.name);
}

exports.autocomplete = async(req,res)=>{
  
try{
  const agg =conf.searchAggragate.autocomplete;
  
  //res.send(req.params['text']);
  if(!req.query.text){
    res.status(400).send("Bad Request");
  }else{
   
 var coll = req.app.coll;
  agg[0].$search.autocomplete.query=req.query.text;

   //MongoClient.connect(uri, { useNewUrlParser: true, useUnifiedTopology: true }, function(connectErr, client) {
    
     // const coll = client.db('sample_mflix').collection('movies');
      coll.aggregate(agg).toArray()
                          // .then(result=> result.map(ele=>{
                          //   return {label:ele.title, value:ele.title};
                          // }))
                          .then(result=>{
                            let ar = new Array();
                            result.forEach(element => {
                              ar.push(element.title);
                            });
                           //console.log(ar);
                          res.send(ar);
                            //res.send(result);
                            // //console.log(result[0]);
                             console.log("Query -'" + req.query.text + "' result found-" + result.length);
                             //client.close();
                          });
   // });

  }
}catch(e){
  res.status(500).send({message:e.message});
}
  
}

exports.searchProduct= async(req,res)=>{
 
try{
  const agg =conf.searchAggragate.fullTextSearch;
  

  //res.send(req.body.text);
  if(!req.body.text){
    res.status(400).send("Bad Request");
  }else{
  agg[0].$search.text.query=req.body.text;

  // MongoClient.connect(uri, { useNewUrlParser: true, useUnifiedTopology: true }, function(connectErr, client) {
    var coll = req.app.coll;
      //const coll = client.db('sample_mflix').collection('movies');
      coll.aggregate(agg).toArray()
                          .then(result=>{
                            res.send(result);
                            // //console.log(result[0]);
                             console.log("Query -'" + req.body.text + "' result found-" + result.length);
                            // client.close();
                          });
   // });
  }
}catch(e){
  res.status(500).send({message:e.message});
}
}

exports.searchProductById = async(req,res)=>{

  try{
  let id = req.query.id;
  if(!id){
    res.status(400).send({"message":"Bad Request !!!"});
  }else{
    var coll = req.app.coll;
    coll.find({'id':id}).toArray()
    .then(result=>res.send(result));
     
  }
}catch(e){
  res.status(500).send({'message':e.message});
}
}

exports.searchProductsBySellerId = async(req,res)=>{

  try{
  let id = req.body.sellerId;
  if(!id){
    res.status(400).send({"message":"Bad Request !!!"});
  }else{
    var coll = req.app.coll;
    coll.find({'sellerId':id}).toArray()
    .then(result=>res.send(result));
     
  }
}catch(e){
  res.status(500).send({'message':e.message});
}
}