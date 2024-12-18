import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/segundoservlet")
public class SegundoServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Iniciando servlet de clase " + this.getClass().getName());
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String metodoHttp = request.getMethod();
        System.out.println("Metodo http utilizado para la solucitud: " + metodoHttp);
        String url = request.getRequestURL().toString();
        System.out.println("URL solicitada: " + url);
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            System.out.println(params.nextElement());
        }
        Map<String, String[]> mapaParametros = request.getParameterMap();
        for(Map.Entry<String, String[]> entry : mapaParametros.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue()[0]);
        }

        // Crear la respuesta
        String respuesta = "Solicitud procesada exitosamente";
        response.setContentType("text/plain");
        response.setContentLength(respuesta.length());
        response.setStatus(201);
        response.getWriter().println(respuesta);
        response.getWriter().close();
    }

    @Override
    public void destroy() {
        System.out.println("Terminando servlet de clase " + this.getClass().getName());
    }
}
