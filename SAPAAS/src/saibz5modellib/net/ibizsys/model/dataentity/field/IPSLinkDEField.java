package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.der.IPSDERBase;


/**
 * 链接属性辅助对象接口
 * @author Administrator
 *
 */
public interface IPSLinkDEField extends IPSDEField
{
	/**
	 * 获取相关属性的辅助对象
	 * @return
	 */
	IPSDEField getRelatedPSDEField() throws Exception;
	
	
	/**
	 * 获取实际属性对象（以通过连接方式递归获取）
	 * @return
	 */
	IPSDEField getRealPSDEField() throws Exception;
	
	
	
	/**
	 * 获取实际属性对象（以通过连接方式递归获取）
	 * @param bFirstPhisical 第一个物理属性即退出
	 * @return
	 */
	IPSDEField getRealPSDEField(boolean bFirstPhisical) throws Exception;
	
	
	/**
	 * 获取关系
	 * @return
	 */
	IPSDERBase getPSDER() throws Exception;
	
	
//	/**
//	 * 是否自定义链接
//	 * @return
//	 */
//	boolean isCustomJoin();
//	
//	
//	
	/**
	 * 获取关系编号
	 * @return
	 */
	String getDERId();
}
