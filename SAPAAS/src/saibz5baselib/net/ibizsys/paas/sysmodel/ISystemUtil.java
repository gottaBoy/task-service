package net.ibizsys.paas.sysmodel;

/**
 * 系统辅助功能接口
 * @author Administrator
 *
 */
public interface ISystemUtil {

	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	/**
	 * 获取辅助类型
	 * @return
	 */
	String getUtilType();
	
	
	/**
	 * 设置辅助功能参数
	 * @param strParamKey
	 * @param objValue
	 */
	void setUtilParam(String strParamKey,Object objValue);
	
	
	
	/**
	 * 获取系统功能对象
	 * @return
	 */
	ISystemModel getSystemModel();
}
