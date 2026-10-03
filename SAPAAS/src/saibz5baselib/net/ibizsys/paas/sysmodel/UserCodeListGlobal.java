package net.ibizsys.paas.sysmodel;

import java.util.HashMap;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;

/**
 * 用户代码表全部存储对象
 * 
 * @author Administrator
 *
 */
public class UserCodeListGlobal {
	private HashMap<String, ICodeList> codeListMap = new HashMap<String, ICodeList>();
	private String strPersonId = "";

	/**
	 * 构造函数
	 * 
	 * @param strPersonId 用户标识
	 */
	public UserCodeListGlobal(String strPersonId) throws Exception {
		this.strPersonId = strPersonId;
		if (StringHelper.isNullOrEmpty(this.strPersonId)) throw new Exception(StringHelper.format("当前用户标识无效"));
	}

	/**
	 * 获取当前用户标识
	 * 
	 * @return
	 */
	public String getCurUserId() {
		return strPersonId;
	}

	/**
	 * 获取用户代码表对象
	 * 
	 * @param iCodeList
	 * @return
	 * @throws Exception
	 */
	public synchronized ICodeList getUserCodeList(ICodeList iCodeList) throws Exception {
		SessionFactory sessionFactory = null;
		ICodeListModel iCodeListModel = null;
		if (iCodeList instanceof ICodeListModel) {
			iCodeListModel = (ICodeListModel) iCodeList;
		}
		if (iCodeListModel != null) {
			sessionFactory = iCodeListModel.getSessionFactory();
		}

		String strFullKeyId = "";
		if (sessionFactory == null) {
			strFullKeyId = iCodeList.getId();
		} else
			strFullKeyId = StringHelper.format("%1$s|%2$s", iCodeList.getId(), sessionFactory.toString());

		synchronized (codeListMap) {
			ICodeList iUserCodeList = codeListMap.get(strFullKeyId);
			if (iUserCodeList != null) return iUserCodeList;

			// 建立新对象
			ICodeList newCodeList = iCodeList.getClass().newInstance();
			if (newCodeList instanceof ICodeListModel) {
				ICodeListModel newCodeListModel = (ICodeListModel) newCodeList;
				newCodeListModel.from((ICodeListModel) iCodeList);
				newCodeListModel.setSessionFactory(sessionFactory);
			}

			if (newCodeList instanceof IUserCodeListModel) {
				IUserCodeListModel newCodeListModel = (IUserCodeListModel) newCodeList;
				newCodeListModel.setCurUserId(getCurUserId());
			}

			codeListMap.put(strFullKeyId, newCodeList);
			return newCodeList;
		}
	}
}
