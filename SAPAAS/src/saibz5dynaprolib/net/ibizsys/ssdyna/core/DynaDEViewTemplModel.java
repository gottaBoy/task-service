package net.ibizsys.ssdyna.core;

import java.util.Iterator;

import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.core.ModelBase2Impl;

/**
 * 动态实体视图模板
 * @author Administrator
 *
 */
public class DynaDEViewTemplModel extends ModelBase2Impl implements IDynaDEViewTemplModel{

	private java.util.ArrayList<AppViewModel> appViewModelList = null;
	
	@Override
	public void registerAppDynaDEView(String strAppId, String strAppViewId, String strUrl, Object userData) throws Exception {
		if(this.appViewModelList == null) {
			this.appViewModelList = new java.util.ArrayList<AppViewModel>();
		}
		
		AppViewModel appViewModel = new AppViewModel();
		appViewModel.setAppId(strAppId);
		appViewModel.setId(strAppViewId);
		appViewModel.setViewUrl(strUrl);
		appViewModel.setUserData(userData);
		
		this.appViewModelList.add(appViewModel);
	}

	/**
	 * 设置动态实体视图模板标识
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}
	
	/**
	 * 设置动态实体视图模板名称
	 * @param strId
	 */
	public void setName(String strName) {
		this.strName = strName;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.ssdyna.core.IDynaDEViewTemplModel#getAppDynaDEViews()
	 */
	@Override
	public Iterator<AppViewModel> getAppDynaDEViews() {
		if(this.appViewModelList == null || this.appViewModelList.size() == 0) {
			return null;
		}
		return this.appViewModelList.iterator();
	}
	
	
}
