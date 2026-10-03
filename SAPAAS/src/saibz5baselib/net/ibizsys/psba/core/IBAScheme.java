package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.core.ISystem;

/**
 * 大数据库架构接口对象
 * 
 * @author Administrator
 *
 */
public interface IBAScheme extends IModelBase {

	/**
	 * 获取大数据表模型集合
	 * 
	 * @return
	 */
	java.util.Iterator<IBATable> getBATables();

	/**
	 * 获取表模型
	 * 
	 * @param strName
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IBATable getBATable(String strName, boolean bTryMode) throws Exception;

	/**
	 * 获取系统模型对象
	 * 
	 * @return
	 */
	ISystem getSystem();
	
	

	
	
}
