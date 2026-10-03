package net.ibizsys.pswf.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.ctrlmodel.ExpBarModelBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

/**
 * 流程导航栏模型
 * 
 * @author lionlau
 *
 */
public abstract class WFExpBarModelBase extends ExpBarModelBase implements IWFExpBarModel {
	
	
	
	/**
	 * 工作流模型
	 */
	private IWFModel iWFModel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ExpBarModelBase#getControlType()
	 */
	@Override
	public String getControlType() {
		return ControlTypes.WFExpBar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.ctrlmodel.IWFExpBarModel#getWFModel()
	 */
	@Override
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
	 * @see net.ibizsys.pswf.ctrlmodel.IWFExpBarModel#getWFVersionModel()
	 */
	@Override
	public IWFVersionModel getWFVersionModel() {
		return this.getWFModel().getLastWFVersionModel();
	}

}
