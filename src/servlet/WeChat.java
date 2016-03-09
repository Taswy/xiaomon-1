package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import tulingapi.util;
import util.Check;
import util.MessageUtil;
import util.UserUtil;
import SendMessage.TextMessage;

public class WeChat extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		System.out.println(signature);
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
		PrintWriter out = response.getWriter();
		if (Check.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
		PrintWriter out = response.getWriter();
		Map<String, String> map = MessageUtil.xmlToMap(request);
		String MsgType = map.get("MsgType");
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		if (MsgType.equals("text")) {
			String Content = map.get("Content");
			if (Content.equals("红包")) {
				String message;
				TextMessage textMessage = new SendMessage.TextMessage(FromUserName, ToUserName);
				SimpleDateFormat f = new SimpleDateFormat("ddHHmmss"); 
				long time = Long.valueOf(f.format(new Date()));
				if (time < 8223000) {
					textMessage.setContent("22:30准时开抢！\n时间还没有到哦！");
				}
				else {
					String status = UserUtil.receive(FromUserName);
					if (status.equals("领过了")) {
						textMessage.setContent("已经领过啦，快让其他小伙伴来领取！");
					}else if (status.equals("红包领完了")) {
						textMessage.setContent("来迟了！红包已经领完了！");
					}
					else {
						textMessage.setContent("红包口令是："+status);
					}
					
				}
				message = MessageUtil.MessageToXml(textMessage,"");
				System.out.println(message);
				out.print(message);
			}else {
				String message;
				TextMessage textMessage = new SendMessage.TextMessage(FromUserName, ToUserName);
				JSONObject jsonObject = util.get(Content, FromUserName);
				String code = jsonObject.getString("code");
				String text = jsonObject.getString("text");
				System.out.println(code);
				System.out.println(text);
				if (code.equals("200000")) {
					text = text+"\n"+jsonObject.getString("url");
				}
				textMessage.setContent(text);
				message = MessageUtil.MessageToXml(textMessage,"");
				System.out.println(message);
				out.print(message);
			}
		}
		
	}

}
