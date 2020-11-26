package ru.unclediga.spec.servlet;

import ru.unclediga.spec.res.MyCustomResource;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "CustomResourceServlet", urlPatterns = "/custom/*")
public class CustomResourceServlet extends HttpServlet {
    @Resource(name = "bean/MyBeanFactory")
    private MyCustomResource customResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html lang=\"en\"><body>");

        out.println("<h3> context path: [" + req.getContextPath() + "]</h3>");
        out.println("<h3> request URI: [" + req.getRequestURI() + "]</h3>");
        out.println("<h3> servlet path: [" + req.getServletPath() + "]</h3>");
        final String pathInfo = req.getPathInfo();
        out.println("<h3> path info : [" + pathInfo + "]</h3>");
        /*
        context path: [/lev3]
        request URI: [/lev3/custom/1]
        servlet path: [/custom]
        path info : [/1]
        */
        if (pathInfo == null) {
            out.println("<h2> CustomResource (inject) = " + customResource.getValue() + "</h2>");
        } else {
            final InitialContext context;
            MyCustomResource resource;
            try {
                context = new InitialContext();
                final Context envCtx = (Context) context.lookup("java:comp/env");
                resource = (MyCustomResource) envCtx.lookup("bean/MyBeanFactory");
                context.close();
            } catch (NamingException e) {
                (resource = new MyCustomResource()).setValue(e.getMessage());
            }
            out.println("<h2> CustomResource (lookup) = " + resource.getValue() + "</h2>");
        }
        out.println("</body></html>");
    }
}
