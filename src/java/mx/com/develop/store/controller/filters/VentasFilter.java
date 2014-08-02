package mx.com.develop.store.controller.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "ventasFilter", urlPatterns = {"/ventas/*"}, dispatcherTypes = {DispatcherType.REQUEST},
        initParams = {
            @WebInitParam(name = "clientAttributeInSession", value = "cliente")
        })
public class VentasFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void destroy() {
        System.out.println("VentasFilter.destroy()");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("VentasFilter.doFilter() -- request");
        String clientAttributeInSession = filterConfig.getInitParameter("clientAttributeInSession");
        System.out.println("InitParam: clientAttributeInSession=" + clientAttributeInSession);

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(clientAttributeInSession) != null) {
            chain.doFilter(req, res);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(req, res);
        }

        System.out.println("VentasFilter.doFilter() -- response");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("VentasFilter.init()");
        this.filterConfig = filterConfig;
    }

}
