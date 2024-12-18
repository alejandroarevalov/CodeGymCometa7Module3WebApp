import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/error")
public class ServletError extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter escritor = res.getWriter();
        escritor.println("<html>");
        escritor.println("<head>");
        escritor.println("<body>");
        escritor.println("<h1 style=\"background-color: red\">No puedes ejecutar mi servlet</h1>");
        escritor.println("</body>");
        escritor.println("</head>");
        escritor.println("</html>");
        escritor.close();
    }
}
