package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;


@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String usuario = getUsuario(req);
		String uri = req.getRequestURI();
        		
		System.out.println("Usuario " + usuario + " acessando a URI " + uri);		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {			
	}
	
	 private String getUsuario(HttpServletRequest req) {
		 Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioLogado");
	     		 
		 if (usuarioLogado != null)
	            return usuarioLogado.getEmail();
	        
	        return "<deslogado>";
	    }
}
