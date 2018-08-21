package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.dao.UserDao;
import com.pojo.User;;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String account = request.getParameter("account");
		String password = request.getParameter("password");

		System.out.println(account + "--" + password);

		if (StringUtil.isEmpty(password) || StringUtil.isEmpty(account)) {

			// session
			HttpSession session = request.getSession();
			session.setAttribute("error", "不能为空");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			System.out.println("kong");
			return;
		}
		HttpSession session = request.getSession();
		String vc = request.getParameter("VC"); // 获取页面输入的验证码
		String vc0 = (String) request.getSession().getAttribute("VC"); // 获取session对象里保存的验证码
		int key = 0;
		// 比较两个验证码字符串
		if (vc0 != null && vc != null && vc0.equals(vc)) {
			// 调用业务层方法完成用户的注册，并返回结果

			// 从后端往前台传数据
			session.setAttribute("error", "验证码正确");
			key = 1;

		} else {
			session.setAttribute("error", "验证码错误！");
			response.sendRedirect(request.getContextPath() + "/login.jsp");

		}

		if (key == 1) {
			User user = new User();
			user.setAccount(account);
			user.setPassword(password);

			User curr_user = UserDao.queryUserByLogin(user);
			if (null == curr_user) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("error", "用户名或密码错误，请重新输入");
				session1.setAttribute("account", account);
				session1.setAttribute("password", password);
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				System.out.println("error");
			} else {
				//
				HttpSession session1 = request.getSession();
				session1.setAttribute("currentUser", "登陆成功");
				// ת
				response.sendRedirect(request.getContextPath() + "/main.jsp");
				System.out.println("yes");
			}
		}

	}

}
