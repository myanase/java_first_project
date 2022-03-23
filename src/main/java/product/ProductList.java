package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

@WebServlet("/product/list")
public class ProductList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
		    //変数設定
			String sort = request.getParameter("sort");
			String genre = request.getParameter("genre");
		    String keyword = request.getParameter("keyword");
		    
			//DAOから値を取得してくる
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search(sort, genre, keyword);
			
			//サーブレットからjspに値を渡す
			request.setAttribute("list", list);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
