import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MiServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Inicializando servlet...");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Llamando al servlet de ejemplo.");
        PrintWriter escritor = response.getWriter();
        response.setContentType("text/html");
        escritor.println("<h1 style=\"background-color: BLUE;\">Hola estudiantes!</h1>");
        escritor.close();
    }

    @Override
    public void destroy() {
        // Liberacion de recursos al finalizar la ejecucion
        System.out.println("Terminando ejecucion del servlet");
    }
}
