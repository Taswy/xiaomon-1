package util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import po.User;

public class Test {
	public static void main(String[] args) {
		// UserUtil u = new UserUtil();
		//
		// System.out.println(u.receive("111111"));
		// System.out.println(u.receive("111111"));
		// new Test().genRan(100,300);
		
		ArrayList list = new HongbaoFactory().factory(1,6,50,200,new ArrayList<String>());
		//new HongbaoUtil().addHongbao(list);
//		new Test().fake(3.1234, 2);
	}

	
}
