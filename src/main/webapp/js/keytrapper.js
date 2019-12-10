/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.onkeypress = stopRKey; 
document.onkeydown = KeyCheck;  
 
function stopRKey(evt) { 
  var evt = (evt) ? evt : ((event) ? event : null); 
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
  if ((evt.keyCode == 13) && (node.type=="text"))  {
      return false;
  }     
} 
  
function KeyCheck(evt){
   var evt = (evt) ? evt : ((event) ? event : null); 
   var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
   if ((evt.keyCode == 8) && (node.type!="text"))   {
        return false;    
    }   
}
    
 
