package net.ibizsys.paas.sysmodel;

import java.util.Properties;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.PropertiesHelper;

/**
 * 系统逻辑基类
 * @author Administrator
 *
 */
public abstract class SystemLogicModelBase extends ModelBaseImpl implements ISystemLogicModel {

	private ISystemModel iSystemModel = null;
	private String strLogicParams = null;
	protected Properties logicParams = null;
	private String strUniqueTag = null;
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.iSystemModel  = iSystemModel;
		this.onInit();
	}
	

	
	@Override
	protected void onInit() throws Exception {
		this.logicParams = PropertiesHelper.load(this.strLogicParams);
		super.onInit();
	}
	
	
	/**
	 * 设置逻辑参数
	 * @param strLogicParams
	 */
	public void setLogicParams(String strLogicParams) throws Exception{
		this.strLogicParams = strLogicParams;
	}
	
	/**
	 * 获取逻辑参数
	 * @return
	 */
	protected Properties getLogicParams(){
		return this.logicParams;
	}

	@Override
	public ISystemModel getSystemModel() {
		return iSystemModel;
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemLogicModel#getUniqueTag()
	 */
	@Override
	public String getUniqueTag() {
		return this.strUniqueTag;
	}

	
	/**
	 * 设置唯一业务标识
	 * @param strUniqueTag
	 */
	public void setUniqueTag(String strUniqueTag){
		this.strUniqueTag = strUniqueTag;
	}


	@Override
	public void execute(IActionContext iActionContext, Object objParam) throws Exception {
		onExecute(iActionContext,objParam);
	}

	/**
	 * 执行系统逻辑
	 * @param iActionContext
	 * @param objParam
	 * @throws Exception
	 */
	protected abstract void onExecute(IActionContext iActionContext, Object objParam) throws Exception;
	
}
