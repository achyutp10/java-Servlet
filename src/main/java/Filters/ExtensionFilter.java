package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtensionFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the requested URL
        String url = httpRequest.getRequestURL().toString();

        // Check if the URL ends with ".jsp"
        if (url.endsWith(".jsp")) {
            // Redirect to the same URL without the ".jsp" extension
            httpResponse.sendRedirect(url.replace(".jsp", ""));
        } else {
            // Continue with the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Clean up resources, if any
    }

}
