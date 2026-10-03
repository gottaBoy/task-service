package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IValueRule;
import net.ibizsys.paas.entity.IEntity;

/**
 * 值规则模型接口
 * 
 * @author lionlau
 *
 */
public interface ISystemValueRuleModel extends IValueRule {

	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	
	/**
	 * 获取唯一业务标识
	 * @return
	 */
	String getUniqueTag();
	
	/**
	 * 检查规则
	 * @param et
	 * @param strFieldName
	 * @param bTempMode
	 * @param objParam
	 * @param strRuleInfo
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	boolean check(IEntity et,String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception;
}
