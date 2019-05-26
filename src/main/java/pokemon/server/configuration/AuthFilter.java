package pokemon.server.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

import pokemon.server.service.AuthenticationService;

@Order(1)
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        AuthenticationService service = new AuthenticationService();
        String username = service.getAuthentication((HttpServletRequest) request);

        if (username != null && !"".equals(username)) {
            request.setAttribute("username", username);
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(401);
        }

    }

}