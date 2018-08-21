package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.pojo.User;

/**
 * Servlet implementation class RelativeServlet
 */
@WebServlet("/RelativeServlet")
public class RelativeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelativeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");;
		String account = request.getParameter("account");;
		String name = request.getParameter("name");;
		String phone = request.getParameter("phone");;
		String date = request.getParameter("date");;
		String Remarks = request.getParameter("Remarks");;
		String oldman = request.getParameter("oldman");;
		

	

		if ( StringUtil.isEmpty(account)||StringUtil.isEmpty(name) || StringUtil.isEmpty(phone)||StringUtil.isEmpty(date) || StringUtil.isEmpty(Remarks)||StringUtil.isEmpty(oldman)) {

			// session
			HttpSession session = request.getSession();
			session.setAttribute("error", "不能为空");
			response.sendRedirect(request.getContextPath() + "/relative.jsp");
			System.out.println("填写信息不全 ");
			return;
		}

		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setJueseid(jueseid);
		// 检查用户名是否存在
		User if_user = UserDao.JdbcSearchTest(user);
		if (null == if_user) {
			HttpSession session = request.getSession();
			session.setAttribute("error", "用户名已存在！");
			response.sendRedirect(request.getContextPath() + "/userREG.jsp");
			System.out.println("用户名已存在！");
			return;
		} else {
			// 创建用户
			User curr_user = UserDao.JdbcAddTest(user);
			if (null == curr_user) {
				HttpSession session = request.getSession();
				session.setAttribute("error", "错误");
				session.setAttribute("account", account);
				session.setAttribute("password", password);
				response.sendRedirect(request.getContextPath() + "/userREG.jsp");
				System.out.println("error");
			} else {
				//
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", "注册成功");
				//跳转到信息填写页面
				//检查用户角色
				if(jueseid.equals("1")) {
					//亲人信息添加
					response.sendRedirect(request.getContextPath() + "/relative.jsp");
				}else if (jueseid.equals("2")) {
					//服务商信息添加
					response.sendRedirect(request.getContextPath() + "/service.jsp");
				}
				

			}

		}

	}

}
