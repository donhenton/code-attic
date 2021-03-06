package com.dhenton9000.spring.mybatis.h2.demo;

import com.dhenton9000.restaurants.dao.RestaurantsDao;
import com.dhenton9000.restaurants.model.Restaurant;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:inmemory-h2-spring.xml"})
//@Transactional
public class H2Test {

    private static final Logger logger = LoggerFactory.getLogger(H2Test.class);
    private static ClassPathXmlApplicationContext context = null;

//    @BeforeClass
//    public static void setUp() {
//     
//        
//         context = new ClassPathXmlApplicationContext("inmemory-h2-spring.xml");
//      //  context.getBean(InMemoryDBInitializer.class);
//    }
    @Ignore
    public void testRestaurantDao() {
        RestaurantsDao mapper = (RestaurantsDao) context.getBean("restaurantsMapper");
        List<Restaurant> restaurants = mapper.getAll();
        assertEquals(50, restaurants.size());

    }
}
