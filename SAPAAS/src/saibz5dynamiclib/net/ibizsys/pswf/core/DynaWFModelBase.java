package net.ibizsys.pswf.core;

import java.util.HashMap;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 动态工作流模型对象实现基类
 * @author Administrator
 *
 */
public abstract class DynaWFModelBase extends WFModelBase implements IDynaWFModel{

	private HashMap<String,DynaWFInstModel> dynaWFInstModelMap = new HashMap<String,DynaWFInstModel>();
	
	@Override
	public void registerDynaWFVersionModel(IDynaWFVersionModel iDynaWFVersionModel) throws Exception {
		String strDynaSysInstId = iDynaWFVersionModel.getDynaInstId();
		DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
		dynaWFInstModel.registerWFVersionModel(iDynaWFVersionModel);
	}

	@Override
	public IWFVersionModel getLastWFVersionModel() {
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
				return dynaWFInstModel.getLastWFVersionModel();
			}
		}
		return super.getLastWFVersionModel();
	}
	


	@Override
	public IWFVersionModel getLastWFVersionModel(String strWFMode) throws Exception {
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
				return dynaWFInstModel.getLastWFVersionModel(strWFMode);
			}
		}
		return super.getLastWFVersionModel(strWFMode);
	}

	@Override
	public IWFVersionModel getWFVersionModel(String strWFVersionId) throws Exception {
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
				return dynaWFInstModel.getWFVersionModel(strWFVersionId);
			}
		}
		return super.getWFVersionModel(strWFVersionId);
	}
	
	
	
	protected DynaWFInstModel getDynaWFInstModel(String strDynaSysInstId){
		DynaWFInstModel dynaWFInstModel = dynaWFInstModelMap.get(strDynaSysInstId);
		if(dynaWFInstModel == null){
			dynaWFInstModel = new DynaWFInstModel(this,strDynaSysInstId);
			dynaWFInstModelMap.put(strDynaSysInstId, dynaWFInstModel);
		}
		return dynaWFInstModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IDynaWFModel#resetCurrentDynaSysInst()
	 */
	@Override
	public void resetCurrentDynaSysInst() {
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				dynaWFInstModelMap.remove(strDynaSysInstId);
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IDynaWFModel#resetAllDynaSysInst()
	 */
	@Override
	public void resetAllDynaSysInst() {
		dynaWFInstModelMap.clear();
	}

	@Override
	public IWFVersionModel getWFVersionModelByWFVersion(int nVersion) throws Exception {
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				DynaWFInstModel dynaWFInstModel = this.getDynaWFInstModel(strDynaSysInstId);
				return dynaWFInstModel.getWFVersionModelByWFVersion(nVersion);
			}
		}
		return super.getWFVersionModelByWFVersion(nVersion);
	}
	
	@Override
	public IDynaWFVersionModel createDynaWFVersionModel(IEntity iEntity) throws Exception {
		return new DefaultDynaWFVersionModel();
	}
	
}
