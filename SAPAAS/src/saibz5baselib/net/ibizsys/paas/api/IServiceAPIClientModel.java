package net.ibizsys.paas.api;

import java.util.ArrayList;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 服务接口客户端模型对象
 * @author Administrator
 *
 */
public interface IServiceAPIClientModel extends IServiceAPIClient {
	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	/**
	 * 获取唯一标记
	 * @return
	 */
	String getUniqueTag();
	
	

	
	/**
	 * 调用实体行为
	 * @param strActionTag
	 * @param iEntity
	 * @throws Exception
	 */
	void execute(String strActionTag,IEntity iEntity)throws Exception;
	
	
	
	
	/**
	 * 简单数据选择操作
	 * @param strActionTag
	 * @param iSelectCond
	 * @throws Exception
	 */
	ArrayList<IEntity> select(String strActionTag,ISelectCond iSelectCond)throws Exception;
	
	
	
	
	/**
	 * 获取数据查询
	 * @param strActionTag
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	FetchResult fetch(String strActionTag,IDEDataSetFetchContext iDEDataSetFetchContext)throws Exception;
	
	
	/**
	 * 调用实体行为
	 * @param iServiceCallContext 服务调用上下文
	 * @param strActionTag
	 * @param iEntity
	 * @throws Exception
	 */
	void execute(IServiceCallContext iServiceCallContext,String strActionTag,IEntity iEntity)throws Exception;
	
	
	
	
	/**
	 * 简单数据选择操作
	 * @param iServiceCallContext 服务调用上下文
	 * @param strActionTag
	 * @param iSelectCond
	 * @throws Exception
	 */
	ArrayList<IEntity> select(IServiceCallContext iServiceCallContext,String strActionTag,ISelectCond iSelectCond)throws Exception;
	
	
	
	
	/**
	 * 获取数据查询
	 * @param iServiceCallContext 服务调用上下文
	 * @param strActionTag
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	FetchResult fetch(IServiceCallContext iServiceCallContext,String strActionTag,IDEDataSetFetchContext iDEDataSetFetchContext)throws Exception;
}
