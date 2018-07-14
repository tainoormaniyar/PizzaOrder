package com.pizza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class PizzaDAOForGettingData {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
	public List<PizzaDAOBean> getLast5Orders() {
		String sql = "select * from (select * from pizza order by pizza_id desc limit 5) sub order by pizza_id asc";

        List<PizzaDAOBean> pizzaList = jdbcTemplate.query(sql, new ResultSetExtractor<List<PizzaDAOBean>>()
        {
            @Override
            public List<PizzaDAOBean> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<PizzaDAOBean> list = new ArrayList<PizzaDAOBean>();
                while (rs.next())
                {
                	PizzaDAOBean pizza = new PizzaDAOBean();
                    pizza.setPizza_id(rs.getInt(1));
                    pizza.setCrust(rs.getString(2));
                    pizza.setToppingstype(rs.getString(3));
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
