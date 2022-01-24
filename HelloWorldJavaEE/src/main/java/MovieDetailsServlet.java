

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
		 case "/insert":
		 break;
		 case "/delete":
		 break;
		 case "/edit":
		 break;
		 case "/update":
		 break;
		 default:
		 listMovies(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
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
