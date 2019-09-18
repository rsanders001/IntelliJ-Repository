import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "search", urlPatterns = "/search")
public class search extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/shoeDatabase";
    private final String USERNAME = "rsanders9";
    private final String PASSWORD = "000486070";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            String searchTerm = request.getParameter("shoeID");

            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(DATABASE_PATH);

            StringBuilder sql = new StringBuilder("SELECT * ");
            sql.append(" FROM shoes");
            sql.append(" WHERE shoeID = ?");


            // Create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            // Create a statement to execute SQL
            pstmt = conn.prepareStatement(sql.toString());
            // Fill the prepared statement params
            pstmt.setString(1, searchTerm);
            // Execute a SELECT query and get a result set
            rset = pstmt.executeQuery();

            StringBuilder output = new StringBuilder();

            output.append("<html><body><ul>");


            while (rset.next()) {

                String shoeID = rset.getString(1);
                String style = rset.getString(2);
                String color = rset.getString(3);
                String retail = rset.getString(4);
                String releaseDate = rset.getString(5);
                String description = rset.getString(6);
                // Append it as a list item
                output.append("<li>").append(shoeID + " : " + style + " : " + color + " : " + retail + " : " + releaseDate + " : " + description).append("</li>");
            }
            output.append("</ul></body></html>");
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {

            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}