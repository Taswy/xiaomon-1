package tulingapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;

import util.WeChatUtil;

import net.sf.json.JSONObject;

public class util {
	
	public static JSONObject get(String content , String userid) throws ClientProtocolException, IOException {
		String url = "http://www.tuling123.com/openapi/api?key=KEY&info=INFO&userid=USERID";
		url = url.replace("KEY", "aa011fd6a83a0de7b4b3be108c08b3a2");
		System.out.println(content);
		url = url.replace("INFO", content);
		url = url.replace("USERID", userid);
		JSONObject jsonObject = WeChatUtil.getStr(url);
		return jsonObject;
		
	}
	
	public static String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			byte[] bs = str.getBytes();
			return new String(bs, newCharset);
		}
		return null;
	}

}
