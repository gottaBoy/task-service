package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.DynaEditViewControllerInstBase;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态流程编辑视图控制器实例基对象
 * @author Administrator
 *
 */
public abstract class DynaWFEditViewControllerInstBase extends DynaEditViewControllerInstBase implements IDynaWFDEViewControllerInst{

	public DynaWFEditViewControllerInstBase() throws Exception {
		super();
	}
	
	
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

	
	@Override
	protected void onInit() throws Exception {
		if(this.getDynaViewController() instanceof IWFDEViewController){
			IWFDEViewController iWFDEViewController = (IWFDEViewController)this.getDynaViewController();
			this.setWFModel(iWFDEViewController.getWFModel());
			this.setDEWF(iWFDEViewController.getDEWF());
		}
		super.onInit();
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

	
	@Override
	protected void onLoadJsonObject(ObjectNode viewModelNode) throws Exception {
		super.onLoadJsonObject(viewModelNode);

		this.setWFIAMode(JsonNodeHelper.getBoolean(viewModelNode, ATTR_WFIAMODE, this.isWFIAMode()));
		this.setWFStepValue(JsonNodeHelper.getString(viewModelNode, ATTR_WFSTEPVALUE, this.getWFStepValue()));
	}
	
}
