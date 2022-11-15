package org.loukili.javac.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.loukili.javac.entity.Exercise;
import org.loukili.javac.entity.ExerciseStatus;
import org.loukili.javac.service.ExerciseService;
import org.loukili.javac.service.ICRUDService;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ExerciseServlet", urlPatterns = {"/exercises", "/create-exercise", "/insert-exercise", "/update-exercise", "/edit-exercise"})
public class ExerciseServlet extends HttpServlet {
  ICRUDService<Exercise> exerciseService;
  public void init(){
    exerciseService = new ExerciseService();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getServletPath();
    try{
      switch (action){
        case "/create-exercise":
          createForm(request, response);
          break;
        case "/insert-exercise":
          storeActivity(request, response);
          break;
        case "/edit-exercise":
          editForm(request, response);
          break;
        case "/update-exercise":
          updateActivity(request, response);
          break;
        case "/exercises":
          listActivities(request, response);
          break;
      }
    } catch (SQLException | ParseException ex) {
      throw  new ServletException();
    }
  }

  private void listActivities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Exercise> listExercises = exerciseService.getAll();
    request.setAttribute("exercises", listExercises);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exercises/index.jsp");
    dispatcher.forward(request, response);
  }

  private void updateActivity(HttpServletRequest request, HttpServletResponse response) {

  }

  private void editForm(HttpServletRequest request, HttpServletResponse response) {

  }

  private void storeActivity(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, ServletException, IOException{
    Exercise exercise = new Exercise();
    exercise.setYear(Integer.valueOf(request.getParameter("year")));
    exercise.setTitle(request.getParameter("title"));
    exercise.setExerciseStatus(ExerciseStatus.valueOf(request.getParameter("exercise-status")));
    exercise.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("start-date")));
    exercise.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end-date")));
    exerciseService.add(exercise);
    System.out.println("here");
    response.sendRedirect("exercises");
  }

  private void createForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    request.setAttribute("status", ExerciseStatus.values());
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exercises/create.jsp");
    dispatcher.forward(request, response);
  }


}
