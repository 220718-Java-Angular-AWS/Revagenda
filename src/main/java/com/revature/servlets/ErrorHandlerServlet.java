package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Exception exception = (Exception) req.getAttribute("javax.servlet.error.exception");

        Class exceptionClass = (Class) req.getAttribute("javax.servlet.error.exception_type");

        Integer status_code = (Integer) req.getAttribute("javax.servlet.error.status_code");

        String errorMessage = (String) req.getAttribute("javax.servlet.error.message");

        String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");

        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        out.println("Exception: " + exception);
        out.println("Exception Type: " + exceptionClass);
        out.println("HttpError Status code: " + status_code);
        out.println("ErrorMessage: " + errorMessage);
        out.println("Request URI: " + requestUri);
        out.println("Servlet Name: " + servletName);
    }
}
