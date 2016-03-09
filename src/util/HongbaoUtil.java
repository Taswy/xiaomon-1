package util;

import java.util.ArrayList;
import java.util.List;

import util.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.HongbaoDAO;
import po.Hongbao;

public class HongbaoUtil {

	private Session session;
	private HongbaoDAO hbDao = new HongbaoDAO();
	private List<Hongbao> hbs = null;

	public Hongbao randomHongbao(Transaction tx) {
		hbs = hbDao.findAll();//检索红包
		int size = hbs.size();
		if(size == 0){
			return null;
		}
		int result = RandomNum.randomNum(size);//产生随机红包
		System.out.println(result);
		
		return hbs.get(result);
	}

	public boolean deleteHongbao(Hongbao hb,Transaction tx) {
		try {
			
			hbDao.delete(hb);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
		}
	}
}
