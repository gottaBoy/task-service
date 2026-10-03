package net.ibizsys.psba.entity;

import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;

/**
 * 大数据实体操作辅助对象
 * @author Administrator
 *
 */
public interface IBAEntityActionHelper extends IEntityActionHelper {

	
	/**
	 * 获取大数据架构模型对象
	 * @return
	 */
	IBASchemeModel getBASchemeModel();
	
	
	/**
	 * 获取大数据表模型对象
	 * @return
	 */
	IBATableModel getBATableModel();
	
	/**
	 * 建立数据对象
	 * @param iEntity
	 * @param colsets 指定列族集合
	 * @throws Exception
	 */
	void create(IBAEntity iEntity,String[] colsets)throws Exception;

	
	
	
	/**
	 * 更新数据对象
	 * @param iEntity
	 * @param colsets 指定列族集合
	 * @throws Exception
	 */
	void update(IBAEntity iEntity,String[] colsets)throws Exception;
	
	
	
	
	
	/**
	 * 保存数据对象
	 * @param iEntity
	 * @param colsets 指定列族集合
	 * @throws Exception
	 */
	void save(IBAEntity iEntity,String[] colsets)throws Exception;
	
	

	
	
	/**
	 * 获取数据对象
	 * @param iEntity
	 * @param colsets 指定列族集合
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	boolean get(IBAEntity iEntity,String[] colsets,boolean bTryMode)throws Exception;
}
