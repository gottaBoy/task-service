package net.ibizsys.paas.core;

/**
 * 实体主状态对象接口
 * 
 * @author Administrator
 *
 */
public interface IDEMainState extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 是否为行为允许模式
	 * 
	 * @return
	 */
	@Deprecated
	boolean isAllowMode();
	
	
	/**
	 * 是否为行为允许模式
	 * 
	 * @return
	 */
	boolean isActionAllowMode();
	
	
	/**
	 * 是否为操作标识允许模式
	 * 
	 * @return
	 */
	boolean isOPPrivAllowMode();

	/**
	 * 是否为默认状态
	 * 
	 * @return
	 */
	boolean isDefault();

	/**
	 * 获取主状态标记
	 * 
	 * @return
	 */
	String getMSTag();

	/**
	 * 判断是否允许操作指定行为
	 * 
	 * @param strDEActionName
	 * @return
	 * @throws Exception
	 */
	boolean testDEAction(String strDEActionName) throws Exception;
	
	
	
	/**
	 * 判断是否允许操作操作标识
	 * 
	 * @param strDEOPPrivName
	 * @return
	 * @throws Exception
	 */
	boolean testDEOPPriv(String strDEOPPrivName) throws Exception;
	
}
