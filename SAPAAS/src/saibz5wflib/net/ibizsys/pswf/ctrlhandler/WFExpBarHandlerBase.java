package net.ibizsys.pswf.ctrlhandler;

import java.util.HashMap;

import net.ibizsys.paas.ctrlhandler.ExpBarHandlerBase;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.pswf.ctrlmodel.IWFExpBarModel;

/**
 * 流程导航栏后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class WFExpBarHandlerBase extends ExpBarHandlerBase implements IWFExpBarHandler {

	/**
	 * 获取工作流导航栏模型
	 * 
	 * @return
	 */
	protected abstract IWFExpBarModel getWFExpBarModel();

	// private HashMap<String, String> wfStateMap = new HashMap<String, String>();

	private HashMap<String, String> extCntStateMap = new HashMap<String, String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ExpBarHandlerBase#getExpBarModel()
	 */
	@Override
	protected IExpBarModel getExpBarModel() {
		return this.getWFExpBarModel();
	}

}
