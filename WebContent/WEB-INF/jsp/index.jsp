<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Pizza Order</title>
   </head>

   <body>
      <h2>Pizza Order</h2>
      <p>Home Screen for Pizza Order</p>
      
      <form:form method = "POST" action = "/PizzaOrder/indian">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Indian"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "POST" action = "/PizzaOrder/italian">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Italian"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "POST" action = "/PizzaOrder/orders">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Orders"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
   
</html>