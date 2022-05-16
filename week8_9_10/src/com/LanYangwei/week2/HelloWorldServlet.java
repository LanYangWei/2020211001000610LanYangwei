package com.LanYangwei.week2;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {// now its a servlet
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //when a click click the link --- request come here -- GET

    //we want to send Hello to client
    //we need to write hello in response
    PrintWriter out=response.getWriter();
    out.println("Hello Client!!!");
    //thats all

}
}
