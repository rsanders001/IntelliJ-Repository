/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/shoeDatabase";
    private final String USER = "rsanders9";
    private final String PW = "000486070";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement pstmt = null;
        ResultSet rset = null;



        try{
            String searchTerm = request.getParameter("searchTerm");

            String path = getServletContext().getRealPath("DATABASE_PATH");

            conn = DriverManager.getConnection(DRIVER_NAME + path, USER, PW);

            String sql = "SELECT shoeID FROM shoes WHERE shoeID = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, searchTerm);

            rset = pstmt.exectuteQuery();

            StringBuilder html = new StringBuilder("<html><body>");

            while(rset.next()){
                int id = rset.getInt(1);
                html.append("<p>").append(id).append("</p>");
            }

            html.append("</body></html>");
            response.getWriter().print(html.toString());


        }catch (SQLException | ClassNotFoundException e){
            response.getWriter().print(e.getMessage());
        }
    }
}
*/