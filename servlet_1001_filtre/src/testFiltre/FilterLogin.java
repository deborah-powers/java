package testFiltre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

// @WebFilter ("/ServletLogin")
public class FilterLogin implements Filter {
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// récupérer les infos du front
		String username = request.getParameter ("username");
		String password = request.getParameter ("password");
		// vérifier si l'utilisateur est bon
		if (username.equals ("jazz") && password.equals ("jazz")){
			response.getWriter().println ("<p>Bonjour "+ username +", je suis le filtre login !</p>");
		}
		else{
			response.getWriter().println ("<p>Bonjour "+ username +", je suis le filtre login. je ne te connais pas.</p>");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setStatus (302);
			httpResponse.sendRedirect ("/10-02-filtre-1/formulaireLogin.html");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
