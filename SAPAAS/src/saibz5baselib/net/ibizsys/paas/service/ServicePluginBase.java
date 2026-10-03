package net.ibizsys.paas.service;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.sf.json.JSONObject;

/**
 * 实体服务插件
 * @author Administrator
 *
 */
public abstract class ServicePluginBase extends PluginBase implements IServicePlugin{

	private IServicePlugin prevServicePlugin = null;
	
	private SessionFactory sessionFactory = null;
	
	
	@Override
	public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doGetDraft(iService, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doGetDraftFrom(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doGetDraftFrom(iService, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doCreate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doCreate(iService, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doUpdate(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doUpdate(iService, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doRemove(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doRemove(iService, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doCreate(IService iService, int nActionPos, IServiceCreateParam<?> iServiceCreateParam, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doCreate(iService, nActionPos, iServiceCreateParam, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doUpdate(IService iService, int nActionPos, IServiceUpdateParam<?> iServiceUpdateParam, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doUpdate(iService, nActionPos, iServiceUpdateParam, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doRemove(IService iService, int nActionPos, IServiceRemoveParam<?> iServiceRemoveParam, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doRemove(iService, nActionPos, iServiceRemoveParam, objParam);
		return PluginActionResult.Continue;
	}
	
	
	
	@Override
	public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doCopyDetails(iService, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}
	
	
	@Override
	public PluginActionResult doExportModel(IService iService, int nActionPos, IEntity iEntity, ArrayList<JSONObject> list, int nExportModelMode, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doExportModel(iService, nActionPos, iEntity, list,nExportModelMode,objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doImportModel(IService iService, int nActionPos, JSONObject jo, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doImportModel(iService, nActionPos,jo,objParam);
		return PluginActionResult.Continue;
	}
	
	
	
	

	@Override
	public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doCustomAction(iService,strActionName, nActionPos, iEntity, objParam);
		return PluginActionResult.Continue;
	}
	
	
	
	
	

	@Override
	public PluginActionResult doCheckEntity(IService iService, int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError, Object objParam) throws Exception {
		if(prevServicePlugin!=null)
			return prevServicePlugin.doCheckEntity(iService,nActionPos,  et,  bCreate,  bTempMode,  entityError,  objParam);
		return PluginActionResult.Continue;
	}
	
	
	
	

	@Override
	public PluginActionResult isPrepareLastForUpdate(IService iService, Object objParam) {
		if(prevServicePlugin!=null)
			return prevServicePlugin.isPrepareLastForUpdate(iService, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult isPrepareLastForRemove(IService iService, Object objParam) {
		if(prevServicePlugin!=null)
			return prevServicePlugin.isPrepareLastForRemove(iService, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public void setPrevPlugin(IPlugin iPlugin) {
		super.setPrevPlugin(iPlugin);
		if(iPlugin instanceof IServicePlugin){
			prevServicePlugin = (IServicePlugin)iPlugin;
		}
		if(iPlugin instanceof ISystemPlugin){
			prevServicePlugin = ((ISystemPlugin)iPlugin).getServicePlugin();
		}
	}

	/**
	 * 获取数据源
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 设置数据源
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
