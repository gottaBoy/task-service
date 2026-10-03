package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceCreateParam;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceRemoveParam;
import net.ibizsys.paas.service.IServiceUpdateParam;
import net.ibizsys.paas.service.ServicePluginBase;
import net.sf.json.JSONObject;

/**
 * 系统服务插件（代理）
 * @author Administrator
 *
 */
public class SystemServicePlugin extends ServicePluginBase implements ISystemServicePlugin {
	
	protected HashMap<String, IServicePlugin> iServicePluginMap = new HashMap<String, IServicePlugin>();
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemServicePlugin#registerServicePlugin(java.lang.String, net.ibizsys.paas.service.IServicePlugin)
	 */
	public void registerServicePlugin(String strDEName,IServicePlugin iServicePlugin)throws Exception{
		iServicePluginMap.put(strDEName, iServicePlugin);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doCreate(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doCreate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doCreate( iService,  nActionPos,  iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doCreate(iService, nActionPos, iEntity, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doUpdate(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doUpdate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doUpdate( iService,  nActionPos,  iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doUpdate(iService, nActionPos, iEntity, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doRemove(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doRemove(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doRemove( iService,  nActionPos,  iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doRemove(iService, nActionPos, iEntity, objParam);
	}

	
	
	
	@Override
	public PluginActionResult doCreate(IService iService, int nActionPos, IServiceCreateParam<?> iServiceCreateParam, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doCreate( iService,  nActionPos,  iServiceCreateParam,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doCreate(iService, nActionPos, iServiceCreateParam, objParam);
	}
	
	
	@Override
	public PluginActionResult doUpdate(IService iService, int nActionPos, IServiceUpdateParam<?> iServiceUpdateParam, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doUpdate( iService,  nActionPos,  iServiceUpdateParam,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doUpdate(iService, nActionPos, iServiceUpdateParam, objParam);
	}
	
	
	@Override
	public PluginActionResult doRemove(IService iService, int nActionPos, IServiceRemoveParam<?> iServiceRemoveParam, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doRemove( iService,  nActionPos,  iServiceRemoveParam,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doRemove(iService, nActionPos, iServiceRemoveParam, objParam);
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doCopyDetails(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doCopyDetails( iService,  nActionPos,  iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doGetDraft(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doGetDraft( iService,  nActionPos,  iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doGetDraft(iService, nActionPos, iEntity, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doGetDraftFrom(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doGetDraftFrom(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doGetDraftFrom( iService,  nActionPos,  iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doGetDraftFrom(iService, nActionPos, iEntity, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doExportModel(net.ibizsys.paas.service.IService, int, net.ibizsys.paas.entity.IEntity, java.util.ArrayList, int, java.lang.Object)
	 */
	@Override
	public PluginActionResult doExportModel(IService iService, int nActionPos, IEntity iEntity, ArrayList<JSONObject> list, int nExportModelMode, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doExportModel( iService,  nActionPos,  iEntity,list,  nExportModelMode,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doExportModel(iService, nActionPos, iEntity, list, nExportModelMode, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doImportModel(net.ibizsys.paas.service.IService, int, net.sf.json.JSONObject, java.lang.Object)
	 */
	@Override
	public PluginActionResult doImportModel(IService iService, int nActionPos, JSONObject jo, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doImportModel( iService,  nActionPos, jo,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doImportModel(iService, nActionPos, jo, objParam);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.ServicePluginBase#doCustomAction(net.ibizsys.paas.service.IService, java.lang.String, int, net.ibizsys.paas.entity.IEntity, java.lang.Object)
	 */
	@Override
	public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doCustomAction( iService,strActionName,  nActionPos, iEntity,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
	}

	@Override
	public PluginActionResult doCheckEntity(IService iService, int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError, Object objParam) throws Exception {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.doCheckEntity( iService,nActionPos,  et, bCreate,  bTempMode,  entityError,  objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doCheckEntity(iService, nActionPos, et, bCreate, bTempMode, entityError, objParam);
	}

	@Override
	public PluginActionResult isPrepareLastForUpdate(IService iService, Object objParam) {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.isPrepareLastForUpdate( iService, objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.isPrepareLastForUpdate(iService, objParam);
	}

	@Override
	public PluginActionResult isPrepareLastForRemove(IService iService, Object objParam) {
		IServicePlugin iServicePlugin = iServicePluginMap.get(iService.getDEModel().getName());
		if(iServicePlugin == null){
			iServicePlugin = iServicePluginMap.get("");
		}
		if(iServicePlugin!=null){
			PluginActionResult pluginActionResult =	iServicePlugin.isPrepareLastForRemove( iService, objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.isPrepareLastForRemove(iService, objParam);
	}
	
	
	
	
	
}
