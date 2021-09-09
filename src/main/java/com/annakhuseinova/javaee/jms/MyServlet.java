package com.annakhuseinova.javaee.jms;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class MyServlet extends HttpServlet {

    @EJB
    private MyMessageProducer producer;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "Hello message from Java EE Server using JMS!";
        producer.sendMessage(message);
        resp.getWriter().write("Published the message: " + message);
    }
}
