package pay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/product/payment-confirm")
public class PaymentConfirm extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//入力値取得
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			String address1 = request.getParameter("address1");
			String orderaddress = null;
			String cardnum1 = request.getParameter("cardnum1");
			String cardnum2 = request.getParameter("cardnum2");
			String cardnum3 = request.getParameter("cardnum3");
			String cardnum4 = request.getParameter("cardnum4");
			String cardname = request.getParameter("cardname");
			String expirymm = request.getParameter("expirymm");
			String expiryyyy = request.getParameter("expiryyyy");
			String csvno = request.getParameter("csvno");
			
			//お届け先が住所以外の場合
			if(request.getParameter("orderaddress") == "address2") {
				orderaddress = request.getParameter("address2");
			}
			
			//カート情報取得
			HttpSession session = request.getSession();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}
