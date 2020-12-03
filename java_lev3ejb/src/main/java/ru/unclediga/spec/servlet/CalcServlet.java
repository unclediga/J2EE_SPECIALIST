package ru.unclediga.spec.servlet;

import ru.unclediga.spec.service.CalcService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {
    @Inject
    private CalcService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html lang=\"en\"><body>");
        out.println("<h3> 2 + 2 = " + service.calculate(2, 2, '+') + "</h3>");
        out.println("<h3> 3 * 3 = " + service.calculate(3, 3, '*') + "</h3>");
        out.println("</body></html>");
    }
}
