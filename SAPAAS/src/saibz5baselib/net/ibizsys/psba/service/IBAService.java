package net.ibizsys.psba.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;

/**
 * 大数据表服务对象
 * @author Administrator
 *
 */
public interface IBAService {
	/**
	 * 获取大数据架构模型
	 * 
	 * @return
	 */
	IBASchemeModel getBASchemeModel();

	/**
	 * 获取对应的大数据表模型
	 * 
	 * @return
	 */
	IBATableModel getBATableModel();
	
	
	
	/**
	 * 导入实体数据
	 * @param et
	 * @throws Exception
	 */
	void importDEData(IEntity et) throws Exception;


 
}
