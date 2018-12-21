package com.fun.framework.configure;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {
    public static int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        count = count + 1;
//        context.setAttribute("count", count);
        log.info("sessionCreated---count="+count+","+session.getId());
//        se.getSession().setMaxInactiveInterval(5);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count = count - 1;
        ServletContext context = se.getSession().getServletContext();
        se.getSession().removeAttribute("sessionId_"+se.getSession().getId());
//        context.setAttribute("count", count);
        log.info("sessionDestroyed---count="+count);
    }

}