package net.ibizsys.paas.service;

import java.util.ArrayList;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.sf.json.JSONObject;

/**
 * 服务对象插件
 * @author Administrator
 *
 */
public interface IServicePlugin extends IPlugin {

	/**
	 * 执行获取草稿信息
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doGetDraft(IService iService,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	/**
	 * 执行获取草稿信息（数据复制）
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doGetDraftFrom(IService iService,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	/**
	 * 执行建立操作
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doCreate(IService iService,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	
	/**
	 * 执行更新操作
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doUpdate(IService iService,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	/**
	 * 执行删除操作
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doRemove(IService iService,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	
	
	/**
	 * 执行建立操作
	 * @param iService
	 * @param nActionPos
	 * @param iServiceCreateParam
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doCreate(IService iService,int nActionPos,IServiceCreateParam<?> iServiceCreateParam,Object objParam)throws Exception;
	
	
	
	/**
	 * 执行更新操作
	 * @param iService
	 * @param nActionPos
	 * @param iServiceUpdateParam
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doUpdate(IService iService,int nActionPos,IServiceUpdateParam<?> iServiceUpdateParam,Object objParam)throws Exception;
	
	
	/**
	 * 执行删除操作
	 * @param iService
	 * @param nActionPos
	 * @param iServiceRemoveParam
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doRemove(IService iService,int nActionPos,IServiceRemoveParam<?> iServiceRemoveParam,Object objParam)throws Exception;
	
	
	/**
	 * 执行拷贝处理
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doCopyDetails(IService iService,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	

	/**
	 * 执行模型导出
	 * @param iService
	 * @param nActionPos
	 * @param iEntity
	 * @param list
	 * @param nExportModelMode 导出模型模式
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doExportModel(IService iService,int nActionPos,IEntity iEntity,ArrayList<JSONObject> list,int nExportModelMode,Object objParam)throws Exception;
	
	
	
	/**
	 * 执行模型导入
	 * @param iService
	 * @param nActionPos
	 * @param jo
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doImportModel(IService iService,int nActionPos,JSONObject jo,Object objParam)throws Exception;
	
	

	
	
	/**
	 * 执行自定义行为
	 * @param iService
	 * @param strActionName
	 * @param nActionPos
	 * @param iEntity
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doCustomAction(IService iService,String strActionName,int nActionPos,IEntity iEntity,Object objParam)throws Exception;
	
	
	

	/**
	 * 检查数据对象
	 * @param iService
	 * @param nActionPos
	 * @param et
	 * @param bCreate
	 * @param bTempMode
	 * @param entityError
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doCheckEntity(IService iService,int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError,Object objParam)throws Exception;
	
	
	
	
	/**
	 * 是否为更新准备最后一次数据，优化操作
	 * @param iService
	 * @param objParam
	 * @return
	 */
	PluginActionResult isPrepareLastForUpdate (IService iService,Object objParam);
	
	/**
	 * 是否为删除准备最后一次数据，优化操作
	 * @param iService
	 * @param objParam
	 * @return
	 */
	PluginActionResult isPrepareLastForRemove (IService iService,Object objParam);
	
	
	
}
