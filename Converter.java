package com.inf;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Converter
 */
@WebServlet("/Converter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final double EXCHANGE_RATE=80.8739;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Converter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>Currency Conversion</title></head>");
		out.println("<body>\n");
		String amount=request.getParameter("amount");
		try
		{
			NumberFormat nf=NumberFormat.getInstance();
			double convertedValue=nf.parse(amount).doubleValue();
			convertedValue *=EXCHANGE_RATE;
			nf.setMaximumFractionDigits(2);
			nf.setMinimumFractionDigits(2);
			out.println("<big>"+"$"+amount+" =Rs "+nf.format(convertedValue) +"</big>");
		}
		catch (Exception e) {
			e.printStackTrace();
			out.println("Number format Exception");
			
			// TODO: handle exception
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
