package pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.CartDAO;

@WebServlet("/product/cart")
public class Cart extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//チェックボックス選択値取得
			String[] checkId;
			//session取得、sessionに設定
			HttpSession session = request.getSession();
			if(session.getAttribute("checkid[]") != null) {
				String[] newcheck = request.getParameterValues("cartcheck");
				String[] old = (String[])session.getAttribute("checkid[]");
				
				checkId = new String[newcheck.length + old.length];
				System.arraycopy(newcheck, 0, checkId, 0, newcheck.length);
				System.arraycopy(old, 0, checkId, newcheck.length, old.length); 				
			}else {
				checkId = request.getParameterValues("cartcheck");
			}
			session.setAttribute("checkid[]", checkId);
			
			//DAOから対象の商品を取得してくる
			CartDAO dao = new CartDAO();
			List<Product> cart = dao.search(checkId);
			
			//sessionに入れて、jspへ
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("/pay/cart.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}
