package pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/product/payment")
public class Payment extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//個数情報取得、セッションに登録
		HttpSession session = request.getSession();
		String[] cart = (String[])session.getAttribute("checkid[]");
		int cartnum = cart.length;
		HashMap<String, String> cartmap = new HashMap<String, String>();
		
		for(String proId: cart) {
			int proIdnum = Integer.parseInt(proId);
			cartmap.put(proId, request.getParameter("count"+proIdnum));
		}
		session.setAttribute("cartmap", cartmap);
		
		
		//ログイン中かどうか確認
		
		//非会員の場合
		request.getRequestDispatcher("/pay/payment_nonuser.jsp").forward(request, response);

		try {
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
