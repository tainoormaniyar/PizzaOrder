package com.pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PizzaController {
	
	@Autowired
	PizzaDao pizzaDao;
	@Autowired
	PizzaDAOForGettingData pizzaDAOForGetingDataFromDB;
	
	@RequestMapping("/") 
    public String home(){
        return "index"; 
    } 
   
   @RequestMapping(value = "/italian", method = RequestMethod.POST)
   public String italian() {
      return "italian";
   }
   @RequestMapping(value = "/indian", method = RequestMethod.POST)
   public String indian() {
      return "indian";
   }
   @RequestMapping(value = "/orders", method = RequestMethod.POST)
   public ModelAndView orders(@ModelAttribute("pizza") PizzaDAOBean pizza) {
	   List<PizzaDAOBean> list =pizzaDAOForGetingDataFromDB.getLast5Orders();
      return new ModelAndView("orders","list",list);
   }
   
   @RequestMapping(value = "Orderitalian", method = RequestMethod.POST)
   public ModelAndView orderItalian(@ModelAttribute("pizza")PizzaBean pizza) {
	   System.out.println("In controller");
	   System.out.println(pizza.getCrust());
       for(String s:pizza.getToppingstype()){
    	   System.out.println(s);
       }
       System.out.println(pizza.getQuantity());
       System.out.println(pizza.getPrice());
	   int italianPizzaBasePrice = 100;
	   int toppingsPrice =pizza.getToppingstype().length;
	   toppingsPrice=toppingsPrice*50;
	   pizza.setPrice((italianPizzaBasePrice+toppingsPrice)*pizza.getQuantity());
	   pizzaDao.savePizzaBean(pizza);
	   return new ModelAndView("priceCalculate","model",pizza);  
   }
   @RequestMapping(value = "Orderindian", method = RequestMethod.POST)
   public ModelAndView orderIndian(@ModelAttribute("pizza")PizzaBean pizza) {
	   System.out.println("In orderindian controller");
	   System.out.println(pizza.getCrust());
       for(String s:pizza.getToppingstype()){
    	   System.out.println(s);
       }
       System.out.println(pizza.getQuantity());
       System.out.println(pizza.getPrice());
	   int indianPizzaBasePrice = 100;
	   int toppingsPrice =pizza.toppingstype.length;
	   toppingsPrice=toppingsPrice*50;
	   pizza.setPrice((indianPizzaBasePrice+toppingsPrice)*pizza.getQuantity());
	   pizzaDao.savePizzaBean(pizza);
	   return new ModelAndView("priceCalculate","model",pizza);  
   }
   
   //getTotalOrders
   @RequestMapping(value="getTotalOrders",method=RequestMethod.POST)
   public ModelAndView getTotalOrders(){
	   List<PizzaBean> TotalOrders = pizzaDao.getAllPizzaBeans();
	   System.out.println("Total number of orders is "+ TotalOrders.size());
	   int orders=TotalOrders.size();
	   ModelAndView mv =new ModelAndView("totalOrders");
	   mv.addObject("model","Total number of orders is "+ TotalOrders.size());
	   return mv;  
   }
   
   @RequestMapping(value="getTotalItalianPizzaOrders",method=RequestMethod.POST)
   public ModelAndView getTotalItalianPizzaOrders(){
	   List<PizzaBean> totalItalianOrders =pizzaDao.getTotalItalianPizzaOrdersFromDB();
	   System.out.println("Total number of Italian pizza orders are "+ totalItalianOrders.size());
	   int italianOrders = totalItalianOrders.size();
	   ModelAndView mv =new ModelAndView("totalItalianOrdersPage");
	   mv.addObject("model","Total number of Italian pizza orders are "+ totalItalianOrders.size());
	   return mv;
   }
   
   @RequestMapping(value="getTotalIndianPizzaOrders",method=RequestMethod.POST)
   public ModelAndView getTotalIndianPizza(){
	   List<PizzaBean> totalIndianOrders =pizzaDao.getTotalIndianPizzaOrdersFromDB();
	   System.out.println("Total number of Indian pizza orders are "+ totalIndianOrders.size());
	   int indianOrders = totalIndianOrders.size();
	   ModelAndView mv =new ModelAndView("totalIndianOrdersPage");
	   mv.addObject("model","Total number of Indian pizza orders are "+ totalIndianOrders.size());
	   return mv;
   }
   
   @RequestMapping(value = "buyitalianpizza", method = RequestMethod.POST)
   public ModelAndView buyItalian(@ModelAttribute("pizza")PizzaBean pizza) {
	   int italianPizzaBasePrice = 100;
	   int toppingsPrice =pizza.toppingstype.length;
	   toppingsPrice=toppingsPrice*50;
	   int totalPriceOfPizza= (italianPizzaBasePrice+toppingsPrice);
	   return new ModelAndView("priceCalculate","model",pizza);  
   }
   
   
   
   
}
