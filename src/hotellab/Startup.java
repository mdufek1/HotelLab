/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotellab;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Mike
 */
public class Startup {
    public static void main(String[] args) {
        final AbstractApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");

        HotelService hs = (HotelService)ctx.getBean("HotelService");

    
        System.out.println(hs.getAllHotels());
}}

