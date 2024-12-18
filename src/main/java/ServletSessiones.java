import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sesiones")
public class ServletSessiones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter escritor = response.getWriter();

        // Obtener el objeto de sesion
        HttpSession sesion = request.getSession();

        // Contador de visitas
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorVisitas");

        if (contadorVisitas == null) {
            contadorVisitas = 0;
        }
        contadorVisitas++;
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        // Escribir respuesta
        escritor.println("<html>");
        escritor.println("<head><title>Contador de visitas</title></head>");
        escritor.println("<body>");
        escritor.println("<h1>Id de sesion: " + sesion.getId() + "</h1>");
        escritor.println("<h1>Numero de visitas: " + contadorVisitas + "</h1>");
        escritor.println("</body>");
        escritor.println("</html>");
        escritor.close();
    }
}
