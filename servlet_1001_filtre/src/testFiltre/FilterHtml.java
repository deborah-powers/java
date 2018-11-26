package testFiltre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter ("/ServletLogin")
public class FilterHtml implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		response.setContentType ("text/html");
		response.getWriter().println ("<!DOCTYPE html><html><head><meta charset='ISO-8859-1'><title>test de filtre</title></head><body>");
		response.getWriter().println ("<p>Bonjour, je suis le filtre html !</p>");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// place your code here
		response.getWriter().println ("</body></html>");
	}
}
