package org.example.listener;

import org.example.pojo.Type;
import org.example.service.TypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;


@WebListener
public class TypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext ac = new ClassPathXmlApplicationContext
                ("applicationContext_*.xml");
        TypeService typeSe = (TypeService) ac.getBean("type_service_impl");
        List<Type> typeList = typeSe.selectAll();
        servletContextEvent.getServletContext().setAttribute("typeList",typeList);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
