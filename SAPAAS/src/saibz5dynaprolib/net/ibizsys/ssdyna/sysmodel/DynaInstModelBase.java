package net.ibizsys.ssdyna.sysmodel;

import java.util.HashMap;

import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;

/**
 * 动态实例
 * @author Administrator
 *
 */
public abstract class DynaInstModelBase extends ModelBase2Impl implements IDynaInstModel{

	private IDynaSysModel iDynaSysModel = null;
//	private IPSDynaInst iPSDynaInst = null;
	private HashMap<String,IDynaDEModel> dynaDEModelMap = new HashMap<String,IDynaDEModel>();
	private HashMap<String,IAppViewModel> appViewModelMap = new HashMap<String,IAppViewModel>();
	private HashMap<String,IDynaWFModel> dynaWFModelMap = new HashMap<String,IDynaWFModel>();
	private HashMap<String,IDynaViewControllerInst> dynaViewControllerInstMap = new HashMap<String,IDynaViewControllerInst>();
	private String strDynaTag = null;
	
	@Override
	public void init(IDynaSysModel iDynaSysModel, IPSDynaInst iPSDynaInst) throws Exception {
		this.iDynaSysModel = iDynaSysModel;
//		this.iPSDynaInst = iPSDynaInst;
		this.strId = iPSDynaInst.getId();
		this.strName = iPSDynaInst.getName();
		this.strDynaTag = iPSDynaInst.getDynaTag();
		this.onInit();
//		this.iPSDynaInst = null;
	}
	
	@Override
	public String getDynaTag() {
		return this.strDynaTag;
	}

	
//	@Override
//	public IDataEntityModel getDataEntityModel(String strDEName, boolean bIncludeOtherSys) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public IDynaService getDynaService(IPSDataEntity iPSDataEntity, SessionFactory sessionFactory) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean containsDynaDEModel(String strDEName) throws Exception {
		return this.dynaDEModelMap.containsKey(strDEName);
	}

	@Override
	public IDynaDEModel getDynaDEModel(String strDEName,boolean bTryMode) throws Exception {
		IDynaDEModel iDynaDEModel = this.dynaDEModelMap.get(strDEName);
		if(iDynaDEModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定动态实体[%1$s]",strDEName));
		}
		return iDynaDEModel;
	}

	@Override
	public void registerDynaDEModel(IDynaDEModel iDynaDEModel) throws Exception {
		dynaDEModelMap.put(iDynaDEModel.getId(), iDynaDEModel);
	}

//	@Override
//	public IPSDynaInst getPSDynaInst() throws Exception {
//		if(this.iPSDynaInst!=null) {
//			return this.iPSDynaInst;
//		}
//		else {
//			return this.getDynaSysModel().getDynaModelStorage().getPSSystem().getPSDynaInst(this.getId());
//		}
//	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.ssdyna.sysmodel.IDynaInstModel#getDynaSysModel()
	 */
	@Override
	public IDynaSysModel getDynaSysModel() {
		return this.iDynaSysModel;
	}
	
	@Override
	public void registerDynaAppViewModel(IAppViewModel iAppViewModel) throws Exception {
		appViewModelMap.put(iAppViewModel.getId(), iAppViewModel);
	}


	@Override
	public boolean containsDynaAppViewModel(String strDynaAppViewModelId) {
		return this.appViewModelMap.containsKey(strDynaAppViewModelId);
	}


	@Override
	public IAppViewModel getDynaAppViewModel(String strDynaAppViewModelId,boolean bTryMode) throws Exception {
		IAppViewModel iAppViewModel = this.appViewModelMap.get(strDynaAppViewModelId);
		if(iAppViewModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定动态应用视图[%1$s]",strDynaAppViewModelId));
		}
		return iAppViewModel;
	}
	
	@Override
	public boolean containsDynaWFModel(String strDEName) throws Exception {
		return this.dynaWFModelMap.containsKey(strDEName);
	}

	@Override
	public IDynaWFModel getDynaWFModel(String strDEName) throws Exception {
		IDynaWFModel iDynaWFModel = this.dynaWFModelMap.get(strDEName);
		if(iDynaWFModel == null) {
			throw new Exception(StringHelper.format("无法获取指定动态工作流[%1$s]",strDEName));
		}
		return iDynaWFModel;
	}

	@Override
	public void registerDynaWFModel(IDynaWFModel iDynaWFModel) throws Exception {
		dynaWFModelMap.put(iDynaWFModel.getId(), iDynaWFModel);
	}

	
	
	@Override
	public boolean containsDynaViewControllerInst(String strDynaViewControllerInstId) throws Exception {
		return this.dynaViewControllerInstMap.containsKey(strDynaViewControllerInstId);
	}

	@Override
	public IDynaViewControllerInst getDynaViewControllerInst(String strDynaViewControllerInstId,boolean bTryMode) throws Exception {
		IDynaViewControllerInst iDynaViewControllerInst = this.dynaViewControllerInstMap.get(strDynaViewControllerInstId);
		if(iDynaViewControllerInst == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定动态视图控制器实例[%1$s]",strDynaViewControllerInstId));
		}
		return iDynaViewControllerInst;
	}

	@Override
	public void registerDynaViewControllerInst(IDynaViewControllerInst iDynaViewControllerInst) throws Exception {
		dynaViewControllerInstMap.put(iDynaViewControllerInst.getId(), iDynaViewControllerInst);
	}
	
}
