package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.DynaViewControllerInstBase;


/**
 * 动态视图工作流基类
 * @author Administrator
 *
 */
public abstract class DynaWFViewControllerInstBase extends DynaViewControllerInstBase implements IDynaWFViewControllerInst
{
	private boolean bWFIAMode = false;
	private String strWFStepValue = null;
	
	public DynaWFViewControllerInstBase() throws Exception {
		super();

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.view.IWFView#isWFIAMode()
	 */
	@Override
	public boolean isWFIAMode() {
		return this.bWFIAMode;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.view.IWFView#getWFStepValue()
	 */
	@Override
	public String getWFStepValue() {
		return this.strWFStepValue;
	}

	/**
	 * 设置是否为流程交互模式
	 * @param bWFIAMode
	 */
	public void setWFIAMode(boolean bWFIAMode) {
		this.bWFIAMode = bWFIAMode;
	}

	/**
	 * 设置流程步骤值
	 * @param strWFStepValue
	 */
	public void setWFStepValue(String strWFStepValue) {
		this.strWFStepValue = strWFStepValue;
	}

	
	
	
}
