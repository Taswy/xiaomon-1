package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import tulingapi.util;
import util.WeChatUtil;

public class test {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		JSONObject jsonObject = util.get("天气", "123456789");
		System.out.println(jsonObject.getString("code"));
		System.out.println(jsonObject.getString("text"));
		
	}

	
}
