package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.shoes;

public class SpringApp {
    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("shoeContext.xml");


        springxml.beans.shoes shoes = context.getBean("shoes", springxml.beans.shoes.class);


        //System.out.println(shoes.getShoeID());
        System.out.println(shoes.getStyle());
        System.out.println(shoes.getColor());
        System.out.println(shoes.getRetail());
        System.out.println(shoes.getDate());
        System.out.println(shoes.getDescription());
        context.close();
    }
}
