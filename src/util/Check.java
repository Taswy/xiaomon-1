package util;
import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;

public class Check {
	public static final String token ="token";
	public static boolean checkSignature(String signature , String timestamp, String nonce){
	//��token��timestamp��nonce�������������ֵ�������
	String[] arr = new String[]{token , timestamp , nonce};
	Arrays.sort(arr);
	
	//�����������ַ���ƴ�ӳ�һ���ַ�������sha1����
	StringBuffer content = new StringBuffer();
	for (String string : arr) {
		content.append(string);
	}
	
	// �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
	return signature.equals(DigestUtils.sha1Hex(content.toString()));
		
	}

}
