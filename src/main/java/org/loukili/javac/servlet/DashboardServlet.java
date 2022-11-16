package org.loukili.javac.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "dashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
  private String message;

  public void init() {
    message = "Hello World!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
  }

  public void destroy() {
  }
}
