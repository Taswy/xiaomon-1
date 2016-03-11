package util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * 要求：
 * 1.产生100个红包
 * 2.红包口令中可以存在红包的大小
 * 3.红包的金额可以在口令的特定的某几位出现
 *
 */
public class HongbaoFactory {
	public List factory(int min, int max, int num,double money) {
		double sum = 0;
		List list = new ArrayList<Double>();
		for (int i = 0; i < num; i++) {
			Random random = new Random();
			int s = random.nextInt(max) % (max - min + 1) + min;
			double mny = Math.random()+s;
			sum+=mny;
			list.add(fake(mny,2));
		}
		double remain = (money-sum)/(100-num);
		for(int i = 0;i < 100 - num;i++){
			double d = remain + Math.random();
			list.add(fake(d,2));
		}
		System.out.println(sum);
		return list;
	}
	public String fake(double d,int level){

		DecimalFormat df = new DecimalFormat("0");
		
		String str = df.format(d*100);
		int i = Integer.valueOf(str);
		int flag = level+2;
		String result = "";
		while(i>0){
			result = (String.valueOf(i%10) + String.valueOf(RandomNum.randomNum(10)))+result;
			i/=10;
			flag--;
		}
		while(flag-->0){
			result = ("0" + String.valueOf(RandomNum.randomNum(10)))+result;
		}
		String r0 = "";
		System.out.println(result);
		return result;
	}
}
