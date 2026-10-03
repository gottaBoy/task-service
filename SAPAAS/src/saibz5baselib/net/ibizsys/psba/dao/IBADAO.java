package net.ibizsys.psba.dao;

import java.util.ArrayList;

import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psba.core.IBADialect;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;

/**
 * 大数据体系数据访问对象
 * 
 * @author Administrator
 *
 * @param <ET>
 */
public interface IBADAO<ET extends IBAEntity> {

	
	/**
	 * 获取当前访问上下文
	 * 
	 * @return
	 */
	IWebContext getWebContext();
	
	
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
	 * 获取大数据库适配器
	 * 
	 * @return
	 */
	IBADialect getRealBADialect();

	
	
	
	
	/**
	 * 执行建立数据命令
	 * 
	 * @param et
	 * @param colsets
	 * @return
	 * @throws Exception
	 */
	void executeCreateCmd( IBAEntity et, String[] colsets) throws Exception;

	/**
	 * 执行更新数据命令
	 * 
	 * @param et
	 * @param colsets
	 * @return
	 * @throws Exception
	 */
	void executeUpdateCmd(IBAEntity et, String[] colsets) throws Exception;

	/**
	 * 执行获取数据命令
	 * 
	 * @param et
	 * @param colsets
	 * @return
	 * @throws Exception
	 */
	void executeGetCmd(IBAEntity et, String[] colsets) throws Exception;

	/**
	 * 执行删除数据命令
	 * 
	 * @param et
	 * @return
	 * @throws Exception
	 */
	void executeRemoveCmd(IBAEntity et) throws Exception;
	
	
	

	/**
	 * 执行查询数据命令
	 * @param iBASelectContext
	 * @return
	 * @throws Exception
	 */
	ArrayList<IBAEntity> executeSelectCmd(IBASelectContext iBASelectContext) throws Exception;
	
	

	/**
	 * 异步执行查询数据命令
	 * @param iBASelectContext
	 * @param iBAAsyncSelectHandler
	 * @throws Exception
	 */
	void executeSelectCmdAsync(IBASelectContext iBASelectContext,IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception;

	
	
	/**
	 * 执行查询数据命令，使用回调 
	 * @param iBASelectContext
	 * @param iBAAsyncSelectHandler
	 * @throws Exception
	 */
	void executeSelectCmd(IBASelectContext iBASelectContext,IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception;
	
	
	/**
	 * 获取大数据数据对象操作辅助对象
	 * @return
	 * @throws Exception
	 */
	IBAEntityActionHelper getBAEntityActionHelper()throws Exception;
	
	
	
	
	
	
	/**
	 * 执行批建立数据命令
	 * 
	 * @param ets
	 * @param colsets
	 * @return
	 * @throws Exception
	 */
	void executeBatchCreateCmd(IBAEntity[] ets, String[] colsets) throws Exception;
}
