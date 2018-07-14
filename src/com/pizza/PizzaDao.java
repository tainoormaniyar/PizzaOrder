package com.pizza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class PizzaDao {
	
	private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new PizzaBean
    public void savePizzaBean(PizzaBean pizza)
    {
        String sql = "insert into pizza values(?,?,?,?,?)";
        StringBuilder totalToppings=new StringBuilder();
        System.out.println("In DAo");
        System.out.println(pizza.getCrust());
        System.out.println(pizza.getToppingstype().toString());
        for(String s:pizza.getToppingstype()){
        	totalToppings.append(" "+s);
        }
        totalToppings.toString();
        System.out.println(pizza.getQuantity());
        System.out.println(pizza
        		
        		.getPrice());
        jdbcTemplate.update(sql,0,pizza.getCrust(),totalToppings,pizza.getQuantity(),pizza.getPrice());
    }

    // Getting a particular PizzaBean
    public PizzaBean getPizzaBeanById(int id)
    {
        String sql = "select * from pizza where id=?";
        PizzaBean pizza = (PizzaBean) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper()
        {
            @Override
            public PizzaBean mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                PizzaBean pizza = new PizzaBean();
                pizza.setPizza_id(rs.getInt(1));
                pizza.setCrust(rs.getString(2));
                pizza.setToppingstype(rs.getString(3).split("\\+s"));
                pizza.setQuantity(rs.getInt(4));
                pizza.setPrice(rs.getInt(5));
                return pizza;
            }
        });
        return pizza;
    }

    // Getting all the PizzaBeans
    public List<PizzaBean> getAllPizzaBeans()
    {
        String sql = "select * from pizza";

        List<PizzaBean> pizzaList = jdbcTemplate.query(sql, new ResultSetExtractor<List<PizzaBean>>()
        {
            @Override
            public List<PizzaBean> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<PizzaBean> list = new ArrayList<PizzaBean>();
                while (rs.next())
                {
                	PizzaBean pizza = new PizzaBean();
                    pizza.setPizza_id(rs.getInt(1));
                    pizza.setCrust(rs.getString(2));
                    pizza.setToppingstype(rs.getString(3).split("\\+s"));
                    pizza.setQuantity(rs.getInt(4));
                    pizza.setPrice(rs.getInt(5));
                    list.add(pizza);
                }
                return list;
            }

        });
        return pizzaList;
    }

	public int getTotalOrders() {
		String s = "select count(*) from pizza;";
		ResultSet rs= null;
		return 0;
	}

	public List<PizzaBean> getTotalItalianPizzaOrdersFromDB() {
		String sql = "select * from pizza where toppingstype  like '%Pepperoni%'  OR toppingstype like  '%Mushrooms%' OR toppingstype like '%Olives%'";

        List<PizzaBean> pizzaList = jdbcTemplate.query(sql, new ResultSetExtractor<List<PizzaBean>>()
        {
            @Override
            public List<PizzaBean> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<PizzaBean> list = new ArrayList<PizzaBean>();
                String s;
                while (rs.next())
                {
                	PizzaBean pizza = new PizzaBean();
                    pizza.setPizza_id(rs.getInt(1));
                    pizza.setCrust(rs.getString(2));
                    pizza.setToppingstype(rs.getString(3).split("\\+s"));
                    pizza.setQuantity(rs.getInt(4));
                    pizza.setPrice(rs.getInt(5));
                    list.add(pizza);
                    
                }
                return list;
            }

        });
        return pizzaList;
	}
	//select * from pizza where toppingstype  like '%Pepperoni%'  OR toppingstype like  '%Mushrooms%' OR toppingstype like '%Olives%';
	//select * from pizza where toppingstype  like '%Paneer%'  OR toppingstype like  '%Olives%' OR toppingstype like '%Red pepper%';

	public List<PizzaBean> getTotalIndianPizzaOrdersFromDB() {
		String sql = "select * from pizza where toppingstype  like '%Paneer%'  OR toppingstype like  '%Olives%' OR toppingstype like '%Red pepper%'";

        List<PizzaBean> pizzaList = jdbcTemplate.query(sql, new ResultSetExtractor<List<PizzaBean>>()
        {
            @Override
            public List<PizzaBean> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<PizzaBean> list = new ArrayList<PizzaBean>();
                while (rs.next())
                {
                	PizzaBean pizza = new PizzaBean();
                    pizza.setPizza_id(rs.getInt(1));
                    pizza.setCrust(rs.getString(2));
                    pizza.setToppingstype(rs.getString(3).split("\\+s"));
                    pizza.setQuantity(rs.getInt(4));
                    pizza.setPrice(rs.getInt(5));
                    list.add(pizza);
                }
                return list;
            }
        });
        return pizzaList;
	}

	
}
