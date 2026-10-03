package net.ibizsys.psba.core;

import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.IBAEntity;

/**
 * 数据库架构模型接口对象
 * 
 * @author Administrator
 *
 */
public interface IBASchemeModel extends IBAModelBase, IBAScheme,IBASchemeRuntime {

	/**
	 * 注册大数据表
	 * 
	 * @param iBATable
	 */
	void registerBATable(IBATable iBATable);

	/**
	 * 获取系统模型对象
	 * 
	 * @return
	 */
	ISystemModel getSystemModel();
	
	
	/**
	 * 获取大数据表数据访问对象
	 * @param iBATable
	 * @return
	 * @throws Exception
	 */
	IBADAO getBADAO(IBATable iBATable) throws Exception;
	
	/**
	 * 建立大数据表实体对象
	 * @param iBATable  表
	 * @return
	 */
	IBAEntity createBAEntity(IBATable iBATable) throws Exception;
}
