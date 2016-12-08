/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
$(document).ready(function(){
    $("#searchBtn").click(lookup);
    
});

  function lookup(){
    var lookupword=$('#Lookupwords').val();
       $.ajax({
          type:"POST",
          url:"/Dictionary/dictServlet",
          data:{"search":lookupword},
          dataType: "json",
          success:function(result){
             var i;
             
             var str="";
             for(i=0;i<result.length;i++){
                 str+="<p>"+(i+1)+result[i]+"</p>";
                 
             }
             $("#definition").html(str);
        }});
         } 
})();
