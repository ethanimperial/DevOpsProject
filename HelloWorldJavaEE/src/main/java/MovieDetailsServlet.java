

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class MovieDetailsServlet
 */
@WebServlet("/MovieDetailsServlet")
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Step 1: Prepare list of variables used for database connections
		private String jdbcURL = "jdbc:mysql://localhost:3306/userdetails";
		private String jdbcUsername = "root";
		private String jdbcPassword = "password";

		// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
		// database
		private static final String INSERT_MOVIES_SQL = "INSERT INTO MovieDetails"
				+ " (title, story, cast, genre,"
				+ "rating, duration, releasedate,ticketurl,"
				+ "trailerurl,image) VALUES " + " (?, ?, ?, ?, ? ,?, ?, ? ,?, ?);";
		private static final String SELECT_MOVIE_BY_ID = "select title,story,cast,genre,rating,duration,releasedate,ticketurl,trailerurl,image from MovieDetails where title =?";
		private static final String SELECT_ALL_MOVIES = "select * from MovieDetails ";
		private static final String DELETE_MOVIES_SQL = "delete from MovieDetails where title = ?;";
		private static final String UPDATE_MOVIES_SQL = "update MovieDetails set title = ?,story= ?, cast =?,genre =?,"
				+ "rating=?, duration= ?, releasedate=?,"
				+ "ticketurl=?, trailerurl=?, image = ?  where title = ?;";

		// Step 3: Implement the getConnection method which facilitates connection to
		// the database via JDBC
		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}
			
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		 try {
			 
			 switch (action) {
			 case "/MovieDetailsServlet/delete":
			 deleteMovie(request, response);
			 break;
			 
			 case "/MovieDetailsServlet/edit":
				 showEditForm(request, response);
				 break;
				 
			 case "/MovieDetailsServlet/update":
				 updateMovie(request, response);
				 break;


			
			 case "/MovieDetailsServlet/dashboard":
			 listMovies(request, response);
			 break;
			 }

		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
	}
	
	
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
	//get parameter passed in the URL
	String title = request.getParameter("title");
	Movie existingMovie = new Movie("", "", "", "", "", "", "", "","","");
	// Step 1: Establishing a Connection
	try (Connection connection = getConnection();
	// Step 2:Create a statement using connection object
	PreparedStatement preparedStatement =
	connection.prepareStatement(SELECT_MOVIE_BY_ID);) {
	preparedStatement.setString(1, title);
	// Step 3: Execute the query or update query
	ResultSet rs = preparedStatement.executeQuery();
	// Step 4: Process the ResultSet object
	while (rs.next()) {
	title = rs.getString("title");
	String story = rs.getString("story");
	String cast = rs.getString("cast");
	String genre = rs.getString("genre");
	String rating = rs.getString("rating");
	String duration = rs.getString("duration");
	String releasedate = rs.getString("releasedate");
	String ticketurl = rs.getString("ticketurl");
	String trailerurl = rs.getString("trailerurl");
	String image = rs.getString("image");
	existingMovie = new Movie(title, story, cast, genre, rating,
			duration, releasedate, ticketurl, trailerurl, image);
	}
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	}
	//Step 5: Set existingUser to request and serve up the userEdit form
	request.setAttribute("movie", existingMovie);
	request.getRequestDispatcher("/movieEdit.jsp").forward(request, response);
	}
	
	//method to update the user table base on the form data
	private void updateMovie(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	String oriTitle = request.getParameter("oriTitle");
	 String title = request.getParameter("title");
	 String story = request.getParameter("story");
	 String cast = request.getParameter("cast");
	 String genre = request.getParameter("genre");
	 String rating = request.getParameter("rating");
	 String duration = request.getParameter("duration");
	 String releasedate = request.getParameter("releasedate");
	 String ticketurl = request.getParameter("ticketurl");
	 String trailerurl = request.getParameter("trailerurl");
	 String image = request.getParameter("image");

	 //Step 2: Attempt connection with database and execute update user SQL query
	 try (Connection connection = getConnection(); PreparedStatement statement =
	connection.prepareStatement(UPDATE_MOVIES_SQL);) {
	 statement.setString(1, title);
	 statement.setString(2, story);
	 statement.setString(3, cast);
	 statement.setString(4, genre);
	 statement.setString(5, rating);
	 statement.setString(6, duration);
	 statement.setString(7, releasedate);
	 statement.setString(8, ticketurl);
	 statement.setString(9, trailerurl);
	 statement.setString(10, image);
	 statement.setString(11, oriTitle);
	 int i = statement.executeUpdate();
	 }
	
	 response.sendRedirect("http://localhost:8080/MovieReviewApp/MovieDetailsServlet/dashboard");
	}
	
	
	//method to delete user
	private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	 String name = request.getParameter("title");
	 //Step 2: Attempt connection with database and execute delete user SQL query
	 try (Connection connection = getConnection(); PreparedStatement statement =
	connection.prepareStatement(DELETE_MOVIES_SQL);) {
	 statement.setString(1, name);
	 int i = statement.executeUpdate();
	 }
	 //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
	 response.sendRedirect("http://localhost:8080/MovieReviewApp/MovieDetailsServlet/dashboard");
	}
	

	private void listMovies(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{
	List <Movie> movies = new ArrayList <>();
	 try (Connection connection = getConnection();
	
	 PreparedStatement preparedStatement =
	connection.prepareStatement(SELECT_ALL_MOVIES);) {
	
	 ResultSet rs = preparedStatement.executeQuery();
	 
	 while (rs.next()) {
	 String title = rs.getString("title");
	 String story = rs.getString("story");
	 String cast = rs.getString("cast");
	 String genre = rs.getString("genre");
	 String rating = rs.getString("rating");
	 String duration = rs.getString("duration");
	 String releasedate = rs.getString("releasedate");
	 String ticketurl = rs.getString("ticketurl");
	 String trailerurl = rs.getString("trailerurl");
	 String image = rs.getString("image");
	 movies.add(new Movie(title, story, cast, genre,
			 rating, duration, releasedate, ticketurl,
			 trailerurl, image));
	 }
	 } catch (SQLException e) {
	 System.out.println(e.getMessage());
	 }
	
	request.setAttribute("listMovies", movies);
	request.getRequestDispatcher("/movieManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
