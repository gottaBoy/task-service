package net.ibizsys.paas.core;

import net.ibizsys.paas.codelist.ICodeList;

/**
 * 系统接口
 * 
 * @author lionlau
 *
 */
public interface ISystem extends IModelBase {
	
	/**
	 * 获取数据实体
	 * 
	 * @param strDataEntityId
	 * @return
	 * @throws Exception
	 */
	IDataEntity getDataEntity(String strDataEntityId) throws Exception;

	/**
	 * 获取指定关系
	 * 
	 * @param strDERId
	 * @return
	 * @throws Exception
	 */
	IDERBase getDER(String strDERId) throws Exception;

	/**
	 * 获取代码表
	 * 
	 * @param strCodeListId
	 * @return
	 * @throws Exception
	 */
	ICodeList getCodeList(String strCodeListId) throws Exception;

}
