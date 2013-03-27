package br.edu.infnet.avaliacaoAcademica.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.edu.infnet.avaliacaoAcademica.AvailableNavigableUrls;
import br.edu.infnet.avaliacaoAcademica.managedBean.LoginMB;

/**
 * Implementação de filtro para verificar se o usuário está logado ao navegar entre as páginas do sistema.
 */
@WebFilter(urlPatterns = "/facets/*")
public class CheckLoggedUserFilter implements Filter {

    @Override
    public void destroy() {}
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletrequest = (HttpServletRequest) request;
        String urlRequested = servletrequest.getRequestURL().toString();
        boolean isLogged = (servletrequest.getSession().getAttribute(SessionProperty.LOGGED_USER.getPropertyName()) != null);

        if ((!isLogged) && (!urlRequested.endsWith(LoginMB.class.getName()))) {
            servletrequest.getRequestDispatcher(AvailableNavigableUrls.LOGIN.getUrl()).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
