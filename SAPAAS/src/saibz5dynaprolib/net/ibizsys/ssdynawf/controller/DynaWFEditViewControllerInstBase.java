package net.ibizsys.ssdynawf.controller;

import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.ssdyna.controller.DynaEditViewControllerInstBase;

public abstract class DynaWFEditViewControllerInstBase extends DynaEditViewControllerInstBase implements IWFDEViewController{

	/**
	 * 工作流模型
	 */
	private IWFModel iWFModel = null;

	/**
	 * 实体工作流模型
	 */
	private IDEWF iDEWF = null;

	/**
	 * 是否为工作模式
	 */
	private boolean bWFIAMode = false;

	/**
	 * 交互的流程步骤值
	 */
	private String strWFStepValue = "";

	/**
	 * 流程版本
	 */
	private int nWFVersion = -1;
	
	
	public DynaWFEditViewControllerInstBase() throws Exception {
		super();
	}
	
	
	
	@Override
	protected void onPrepareDynaViewController() throws Exception {

		super.onPrepareDynaViewController();
		
		if (this.getPSAppView().isEnableWF() && this.getPSAppView() instanceof IPSAppDEWFView) {
			IPSAppDEWFView iPSAppDEWFView = (IPSAppDEWFView) this.getPSAppView();
			this.setWFModel(this.getSystemModel().getWFModel(iPSAppDEWFView.getPSWorkflow().getId()));
			if (iPSAppDEWFView.isWFIAMode()) {
				IPSAppDEWFActionView iPSAppDEWFActionView = (IPSAppDEWFActionView) iPSAppDEWFView;
				this.setWFIAMode(true);
				this.setWFStepValue(iPSAppDEWFActionView.getWFStepValue());
			}
			if (iPSAppDEWFView.getPSDEWF() != null) {
				this.setDEWF(this.getDEModel().getDEWF(iPSAppDEWFView.getPSDEWF().getId()));
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFModel()
	 */
	public IWFModel getWFModel() {
		return iWFModel;
	}

	/**
	 * 设置流程模型
	 * 
	 * @param iWFModel
	 */
	protected void setWFModel(IWFModel iWFModel) {
		this.iWFModel = iWFModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFVersionModel()
	 */
	@Override
	public IWFVersionModel getWFVersionModel() {
		return this.getWFModel().getLastWFVersionModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#isWFIAMode()
	 */
	@Override
	public boolean isWFIAMode() {
		return this.bWFIAMode;
	}

	/**
	 * 设置是否为流程交互模式
	 * 
	 * @param bWFIAMode
	 */
	protected void setWFIAMode(boolean bWFIAMode) {
		this.bWFIAMode = bWFIAMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFDEViewController#getDEWF()
	 */
	@Override
	public IDEWF getDEWF() {
		return this.iDEWF;
	}

	/**
	 * 设置流程实体对象
	 * 
	 * @param iDEWF
	 */
	protected void setDEWF(IDEWF iDEWF) {
		this.iDEWF = iDEWF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFStepValue()
	 */
	@Override
	public String getWFStepValue() {
		return this.strWFStepValue;
	}

	/**
	 * 设置当前的流程步骤值
	 * 
	 * @param strWFStepValue
	 */
	public void setWFStepValue(String strWFStepValue) {
		this.strWFStepValue = strWFStepValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFVersion()
	 */
	@Override
	public int getWFVersion() {
		return this.nWFVersion;
	}

	/**
	 * 设置流程版本
	 * 
	 * @param nWFVersion
	 */
	public void setWFVersion(int nWFVersion) {
		this.nWFVersion = nWFVersion;
	}
}
