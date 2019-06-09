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

@Order(1) // Ordem de execução do filtro
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Casting de ServletResponse para HttpServletResponse
        HttpServletResponse res = (HttpServletResponse) response;
        // Casting de ServletRequest para HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;

        // Define os headers que possibilitam Cross-Origin Resource Sharing
        // Especifica as origens habilitadas
        res.setHeader("Access-Control-Allow-Origin", "*");
        // Define os métodos HTTP habilitados
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT,  DELETE");
        // Indica o tempo máximo que os headers podem ser colocados em cache pelo client
        res.setHeader("Access-Control-Max-Age", "3600");
        // Indica ao client quais são os headers aos quais ele tem acesso
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type"); 

        // Verifica se a requisição capturada é do tipo OPTIONS
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            // Retorna com o status code 200 (OK)
            res.setStatus(HttpServletResponse.SC_OK);
        } else {
            // Instancia o servico de autenticação
            AuthenticationService service = new AuthenticationService();
            // Autentica o usuário e retorna seu username
            String username = service.getAuthentication((HttpServletRequest) request);

            // Verifica se o serviço de autenticação retornou um usuário válido
            if (username != null && !"".equals(username)) {
                // Cria um atributo chamado username na requisição e passa o username do usuário autenticado
                request.setAttribute("username", username);
                // Passa a requisição e a resposta para o controller
                chain.doFilter(request, response);
            } else {
                // Returna com o status code 401 (UNAUTHORIZED)
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        }

        
    }

}