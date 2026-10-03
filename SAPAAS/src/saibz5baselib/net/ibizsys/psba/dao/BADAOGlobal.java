package net.ibizsys.psba.dao;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 大数据DAO全局存储对象
 * 
 * @author lionlau
 *
 */
public class BADAOGlobal {
	private static final Log log = LogFactory.getLog(BADAOGlobal.class);
	private static HashMap<String, IBADAO> daoMap = new HashMap<String, IBADAO>();
	
	/**
	 * 注册全局DAO对象
	 * 
	 * @param strDAOClsType
	 * @param iDAO
	 */
	public static void registerBADAO(String strDAOClsType, IBADAO iDAO) {
		synchronized (daoMap) {
			if (!daoMap.containsKey(strDAOClsType)) {
				daoMap.put(strDAOClsType, iDAO);
			}
		}

	}

	/**
	 * 获取全局DAO对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IBADAO getBADAO(Class cls) throws Exception {
		return getBADAO(cls.getCanonicalName());
	}

	/**
	 * 获取全局DAO对象
	 * 
	 * @param strDAOClsType
	 * @return
	 * @throws Exception
	 */
	public static IBADAO getBADAO(String strDAOClsType) throws Exception {
		synchronized (daoMap) {
			IBADAO iDAO = daoMap.get(strDAOClsType);
			if (iDAO == null) throw new Exception(StringHelper.format("无法获取指定BADAO[%1$s]", strDAOClsType));
			return iDAO;
		}
	}

	

}
