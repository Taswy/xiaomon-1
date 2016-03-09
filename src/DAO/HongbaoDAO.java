package DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import po.Hongbao;

/**
 * A data access object (DAO) providing persistence and search support for
 * Hongbao entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.Hongbao
 * @author MyEclipse Persistence Tools
 */
public class HongbaoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(HongbaoDAO.class);
	// property constants
	public static final String KOULING = "kouling";
	public static final String STAUTS = "stauts";

	public void save(Hongbao transientInstance) {
		log.debug("saving Hongbao instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Hongbao persistentInstance) {
		log.debug("deleting Hongbao instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Hongbao findById(java.lang.Integer id) {
		log.debug("getting Hongbao instance with id: " + id);
		try {
			Hongbao instance = (Hongbao) getSession().get("po.Hongbao", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Hongbao instance) {
		log.debug("finding Hongbao instance by example");
		try {
			List results = getSession().createCriteria("po.Hongbao")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Hongbao instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Hongbao as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKouling(Object kouling) {
		return findByProperty(KOULING, kouling);
	}

	public List findByStauts(Object stauts) {
		return findByProperty(STAUTS, stauts);
	}

	public List findAll() {
		log.debug("finding all Hongbao instances");
		try {
			String queryString = "from Hongbao";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Hongbao merge(Hongbao detachedInstance) {
		log.debug("merging Hongbao instance");
		try {
			Hongbao result = (Hongbao) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Hongbao instance) {
		log.debug("attaching dirty Hongbao instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Hongbao instance) {
		log.debug("attaching clean Hongbao instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}