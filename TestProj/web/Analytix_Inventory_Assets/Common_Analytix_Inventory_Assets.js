/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    function menuHide()
    {
          document.getElementById("main_menu_container").style.display="none";        
    }

    function contentLoader(jspname,container)
    {
                                           xmlup=new XMLHttpRequest();	
                                           xmlup.onreadystatechange=
                                           function()
                                           {
                                                   if(xmlup.readyState === 4 && xmlup.status === 200)	
                                                           {
                                                                document.getElementById(container).innerHTML= xmlup.responseText;
                                                           }
                                                   else
                                                   {
                                                   }
                                           };
                                           xmlup.open("get",jspname,false);		
                                           xmlup.send();
        
    }
    
  function ItemTotalCalculation(qntvalue)
  {
      
      var quantity = parseInt(qntvalue);
      var price = parseInt(document.getElementById("pricePerItem").value);      

      document.getElementById("totalItemAmount").value = quantity * price;
      
  }
  
  function makeNull()
  {
      document.getElementById("totalItemAmount").value="";      
  }