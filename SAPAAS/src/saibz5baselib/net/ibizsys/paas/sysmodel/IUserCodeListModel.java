package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.codelist.IUserCodeList;

/**
 * 用户代码表模型接口
 * 
 * @author Administrator
 *
 */
public interface IUserCodeListModel extends IUserCodeList {
	/**
	 * 设置当前用户标识
	 * 
	 * @param strUserId
	 * @return
	 */
	void setCurUserId(String strUserId);

	/**
	 * 获取当前用户标识
	 * 
	 * @return
	 */
	String getCurUserId();

}
