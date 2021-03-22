package br.org.catolicasc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.catolicasc.dao.AutomovelDao;
import br.org.catolicasc.model.Automovel;

/**
 * Servlet implementation class AdicionaAutomovel
 */
@WebServlet("/adicionaAutomovel")
public class AdicionaAutomovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AutomovelDao automovelDao = new AutomovelDao();
		Automovel automovel = new Automovel();
		automovel.setModelo(request.getParameter("modelo"));
		automovel.setMarca(request.getParameter("marca"));
		automovel.setObservacoes(request.getParameter("observacao"));
		automovel.setAnoFabricacao(Integer.valueOf(request.getParameter("anoDeFabricacao")));
		automovelDao.salvar(automovel);
		
		PrintWriter out = response.getWriter();
		automovelDao.listar();
		out.println("<html>");
		out.println("<body>");
		for (Automovel auto : automovelDao.listar()) {
			out.println(auto.getModelo() + " - " + auto.getMarca() + " - " + auto.getAnoFabricacao() + "<br>");
		}
		out.println("</body>");
		out.println("</html>");
		
		
	}

}

