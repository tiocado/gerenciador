package br.com.alura.gerenciador.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout implements Tarefa {	
	
	public String executa(HttpServletRequest req, HttpServletResponse response) {
		HttpSession session = req.getSession();
        session.removeAttribute("usuarioLogado");		
		return "/WEB-INF/paginas/logout.html";		
		
	};
	
}