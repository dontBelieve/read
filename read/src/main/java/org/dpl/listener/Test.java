package org.dpl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Test implements ServletContextListener {
	
	  @Override
	    public void contextInitialized(ServletContextEvent ServletContextevent) {
	        String initParam = ServletContextevent.getServletContext().getInitParameter("initParam");
	        System.out.println("contextInitialized initParam= " + initParam);
	    }

	    @Override
	    public void contextDestroyed(ServletContextEvent ServletContextevent) {

	        //销毁的时候可以做一些释放数据库的操作
	        System.out.println("contextDestroyed");
	    }
}
