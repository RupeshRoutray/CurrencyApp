package com.pragim.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pragim.dao.CurrencyDao;
import com.pragim.dao.CurrencyDaoImpl;
import com.pragim.model.Country;

/**
 * Servlet implementation class CurrencyCtrl
 */
@WebServlet("/getcountries")
public class CurrencyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		CurrencyDao dao = new CurrencyDaoImpl();
		
		String bname = request.getParameter("button");
		String name = request.getParameter("cname");
		String lang = request.getParameter("lang");
		String currency = request.getParameter("currency");
		String id = request.getParameter("id");
		
		if("delete".equalsIgnoreCase(bname)) {
			
			String[] parameterValues = request.getParameterValues("cid");
			String deleteCountry = dao.deleteCountry(parameterValues);
			request.setAttribute("message", deleteCountry);
		}
		if("add".equalsIgnoreCase(bname)) {
			String addCountry = dao.addCountry(name, lang, currency);
			request.setAttribute("message", addCountry);
		}
		if("edit".equalsIgnoreCase(bname)) {
			Country country = dao.selectCountryById(Integer.parseInt(id));
			request.setAttribute("countryObj", country);
		}
		if("update".equalsIgnoreCase(bname)) {
			String country = dao.updateCountry(Integer.parseInt(id),name,lang,currency);
			request.setAttribute("message", country);
			
		}
		
		
		
		List<Country> data = dao.getCurrnecyOfAllCountries();
		request.setAttribute("curlist", data);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}

}
