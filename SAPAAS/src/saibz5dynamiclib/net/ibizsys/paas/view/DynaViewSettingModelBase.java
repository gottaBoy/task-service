package net.ibizsys.paas.view;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;

/**
 * 动态视图设置对象接口默认实现基类
 * @author Administrator
 *
 */
public abstract class DynaViewSettingModelBase extends ModelBase3Impl implements IDynaViewSettingModel {

	private String strDynaViewDEName = null;
	private String strDynaViewInstDEName = null;
	private IDynaSystemSettingModel iDynaSystemSettingModel = null;
	
	@Override
	public void init(IDynaSystemSettingModel iDynaSystemSettingModel) throws Exception {
		this.iDynaSystemSettingModel = iDynaSystemSettingModel;
		this.onInit();
	}
	
	@Override
	public IDynaSystemSettingModel getDynaSystemSettingModel() {
		return this.iDynaSystemSettingModel;
	}
	
	@Override
	public IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController iDynaViewController, String strDynaViewInstId) throws Exception {
		DSDynaViewInstService dsDynaViewInstService = (DSDynaViewInstService)ServiceGlobal.getService(DSDynaViewInstService.class,iDynaViewController.getSessionFactory());
		DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
		dsDynaViewInst.setDSDynaViewInstId(strDynaViewInstId);
		if(!dsDynaViewInstService.get(dsDynaViewInst, true)){
			throw new Exception(StringHelper.format("无法获取指定应用视图实例[%1$s]",strDynaViewInstId));
		}
		IDynaViewControllerInst iDynaViewControllerInst = null;
		if(!StringHelper.isNullOrEmpty(dsDynaViewInst.getViewInstObj())){
			iDynaViewControllerInst = (IDynaViewControllerInst)ObjectHelper.create(dsDynaViewInst.getViewInstObj());
		}
		else{
			iDynaViewControllerInst = createDynaViewControllerInst(dsDynaViewInst);
		}
		
		iDynaViewControllerInst.init(iDynaViewController, dsDynaViewInst,this);
		return iDynaViewControllerInst;
	}
	
	
	protected IDynaViewControllerInst createDynaViewControllerInst(DSDynaViewInst dsDynaViewInst)throws Exception{
		throw new Exception("没有实现");
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDynaViewSetting#getDynaViewDEName()
	 */
	@Override
	public String getDynaViewDEName() {
		return this.strDynaViewDEName;
	}

	/**
	 * 设置动态视图实体名称
	 * @param strDynaViewDEName
	 */
	public void setDynaViewDEName(String strDynaViewDEName) {
		this.strDynaViewDEName = strDynaViewDEName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDynaViewInstSetting#getDynaViewInstDEName()
	 */
	@Override
	public String getDynaViewInstDEName() {
		return this.strDynaViewInstDEName;
	}

	/**
	 * 设置动态视图实例实体名称
	 * @param strDynaViewInstDEName
	 */
	public void setDynaViewInstDEName(String strDynaViewInstDEName) {
		this.strDynaViewInstDEName = strDynaViewInstDEName;
	}
}
