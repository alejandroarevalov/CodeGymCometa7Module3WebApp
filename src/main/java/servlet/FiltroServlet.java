package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/segundoservlet")
public class FiltroServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtro entra en ejecucion");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String encabezadoPersonalizado = request.getHeader("X-Encabezado-Personalizado");
        if (encabezadoPersonalizado == null || encabezadoPersonalizado.isEmpty()) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(400);
            response.getWriter().print("Solicitud malformada. Recuerde enviar el encabezado");
            response.getWriter().close();
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
