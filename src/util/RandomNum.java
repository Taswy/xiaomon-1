package util;

public class RandomNum {
	static public int randomNum(int sum){
		if(sum==0){
			return 0;
		}
		return (int)(Math.random() * sum); 
	}
}
