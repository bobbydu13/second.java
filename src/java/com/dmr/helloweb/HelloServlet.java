/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.helloweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dmr
 */
public class HelloServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Salut");
        
        Cookie c = new Cookie("MA_CLEF","TOTO");
        Cookie c1 = new Cookie("SALUT","DEDE");
        Cookie c2 = new Cookie("BRUNO","SOLO");
        response.addCookie(c);
        response.addCookie(c1);
        response.addCookie(c2);
        
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.print(headerName+" : "+headerValue+"<br/>");
            
        }
        
        Cookie cookies[] = request.getCookies();
        for(int cpt = 0; cpt<cookies.length; cpt++){
            String name = cookies[cpt].getName();
            String value = cookies[cpt].getValue();
            
            out.print(name+" : "+value+ "<br/>");
        }
        
        
        HttpSession http = request.getSession();
        http.setAttribute("USERNAME", "Admin");// cote serveur
    }

}