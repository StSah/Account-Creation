var express=require("express");
var app=express();
app.use(express.static(__dirname + '/View'));

app.use(express.static(__dirname + '/Script'));
app.get("/",(req,res,next)=>{
    res.redirect('signUp.html');
})
app.listen(3000,()=>{
    console.log("server started at 3000");
})