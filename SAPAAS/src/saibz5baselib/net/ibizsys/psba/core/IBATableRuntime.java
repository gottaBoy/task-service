package net.ibizsys.psba.core;

import net.ibizsys.psba.entity.IBAEntity;

/**
 * 大数据表运行时对象接口
 * @author Administrator
 *
 */
public interface IBATableRuntime {
	/**
	 * 建立大数据表数据对象
	 * @return
	 */
	IBAEntity createBAEntity()throws Exception;
	
	
	/**
	 * @param strRowKey
	 * @return
	 * @throws Exception
	 */
	IBAEntity getBAEntity(String strRowKey)throws Exception;
	
	

	/**
	 * 获取大数据表数据对象
	 * @param strRowKey
	 * @param families 列族
	 * @return
	 * @throws Exception
	 */
	IBAEntity getBAEntity(String strRowKey,String[] families)throws Exception;
	
	
	
	/**
	 * 获取大数据表数据对象
	 * @param strRowKey
	 * @param families 列族
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IBAEntity getBAEntity(String strRowKey,String[] families,boolean bTryMode)throws Exception;
}
