package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import org.junit.Test;

/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCode")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告诉客户端不使用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);
		//生成随机的验证码字符串
		String code = getValidateCode();
		//将验证码字符串存入session对象
		request.getSession().setAttribute("VC", code);
		//生成验证码图片
		BufferedImage img = drawValidateCode(code);
		
		//将图片对象以流的方式输出的客户端
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 生成随机的验证码文字
	 * @return
	 */
	private String getValidateCode(){
		StringBuffer strBuff = new StringBuffer(); 
		Random rand = new Random();
		for(int i=0;i<4;i++){
			char c = (char)(rand.nextInt(9)+48);
			strBuff.append(c);			
		}
		return strBuff.toString();
	}
	/**
	 * 生成验证码图片
	 * @param code
	 * @return
	 * @throws IOException
	 */
	private BufferedImage drawValidateCode(String code) throws IOException {
		int width = 110;
		int height = 25;
		
		//在内存中创建一个图像对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建一个画笔
		Graphics g = img.getGraphics();
		
		//给图片添加背景色
		g.setColor(Color.PINK);//设置一个颜色
		g.fillRect(1, 1, width-2, height-2);//填充颜色
		
		//给边框一个色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);//设置边框的显示坐标
		
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		
		//给图片添加文本		
		int position = 14;
		char[] charArr = code.toCharArray();		
		for (int i = 0; i < charArr.length; i++) {
			g.drawString(charArr[i]+"", position, 20);//给图片填充文本
			position+=14;
		}
		
		//添加5条干扰线
		g.setColor(Color.GREEN);
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		
		return img;
	}

}
