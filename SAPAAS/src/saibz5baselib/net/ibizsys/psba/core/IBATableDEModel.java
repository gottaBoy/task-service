package net.ibizsys.psba.core;

import net.ibizsys.paas.data.ISimpleDataObject;

/**
 * 大数据库架构表实体模型对象接口
 * 
 * @author Administrator
 *
 */
public interface IBATableDEModel extends IBAModelBase, IBATableDE {

	/**
	 * 获取传入数据对象的行键值
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	String getRowKey(ISimpleDataObject iEntity)throws Exception;
	
}
