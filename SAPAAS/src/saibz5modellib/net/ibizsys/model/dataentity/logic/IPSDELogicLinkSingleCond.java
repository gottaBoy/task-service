package net.ibizsys.model.dataentity.logic;


/**
 *  实体逻辑链接单项条件对象接口
 * @author Administrator
 *
 */
public interface IPSDELogicLinkSingleCond extends IPSDELogicLinkCond
{
	/**
	 * 获取目标参数
	 * @return
	 */
	IPSDELogicParam getDstLogicParam() throws Exception;
	
	
	
	/**
	 * 获取目标属性名称
	 * @return
	 * @throws Exception
	 */
	String getDstFieldName() throws Exception;
	
	

	/**
	 * 获取值操作符号标识
	 * @return
	 */
	String getPSDBValueOPId();
	
	
	/**
	 * 获取值
	 * @return
	 */
	String getValue();
	
	
	
}
