package util;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Hongbao;
import po.User;
import DAO.UserDAO;

public class UserUtil {
	private static Session session;
	private static UserDAO usrDao = new UserDAO();

	public static String receive(String openid) {
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		List users = usrDao.findByProperty("openid", openid);
		Iterator<User> userIt = users.iterator();
		if (userIt.hasNext()) {

			User user = userIt.next();
			System.out.println(openid);
			if (user.getUserStatus()) {
				HongbaoUtil hbutil = new HongbaoUtil();
				Hongbao hb = hbutil.randomHongbao(tx);
				if (hb != null) {
					//获取红包
					String kouling = hb.getKouling();
					
					hbutil.deleteHongbao(hb,tx);
					//̬改变领取状态
					user.setUserStatus(false);
					session.update(user);
					session.flush();
					tx.commit();
					session.close();
					return kouling;
				}else{
					session.close();
					return "红包领完了";
				}
			}else{
				session.close();
				return "领过了";
			}
		}else{
			User user = new User();
			user.setOpenid(openid);
			System.out.println(openid);
			user.setUserStatus(true);
			
			HongbaoUtil hbutil = new HongbaoUtil();
			Hongbao hb = hbutil.randomHongbao(tx);
			if (hb != null) {
				//获取红包
				String kouling = hb.getKouling();
				
				hbutil.deleteHongbao(hb,tx);
				//̬改变领取状态
				user.setUserStatus(false);
				session.save(user);
				session.flush();
				tx.commit();
				session.close();
				return kouling;
			}else{
				session.close();
				return "红包领完了";
			}
		}
		
	}
	
}
