package ru.unclediga.spec.servlet;

import ru.unclediga.spec.model.Customer;
import ru.unclediga.spec.service.AppConfig;
import ru.unclediga.spec.service.CustomerService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Inject
    AppConfig config;
    @Inject
    CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String customerId = req.getParameter("id");
        if (customerId != null) {
            final Customer customer = customerService.getById(Long.parseLong(customerId));
            req.setAttribute("CUSTOMER", customer);
            req.setAttribute("URL", config.getMyUrl());
            req.setAttribute("RATE", config.getRate());
            req.setAttribute("PARAMS", config.getProperties());
            req.getRequestDispatcher("customer.jsp").forward(req, resp);
        }else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            final PrintWriter out = resp.getWriter();
            out.write("<html><body><h2>Not Found!</h2></body></html>");
        }
    }
}
