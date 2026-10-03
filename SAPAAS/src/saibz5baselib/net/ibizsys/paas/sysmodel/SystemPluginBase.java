package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;

/**
 * 系统插件基类
 * @author Administrator
 *
 */
public class SystemPluginBase extends PluginBase implements ISystemPlugin {

	private ISystemModel iSystemModel = null;
	private ISystemServicePlugin iSystemServicePlugin = null;
	private ISystemApplicationPlugin iSystemApplicationPlugin = null;
	private ISystemViewMsgGroupPlugin iSystemViewMsgGroupPlugin  = null;
	private ISystemPlugin prevSystemPlugin = null;
	
	
	@Override
	public void init(ISystemModel iSystemModel, String strPluginParams) throws Exception {
		this.iSystemModel = iSystemModel;
		this.init(strPluginParams);
	}

	/**
	 * 获取系统模型对象
	 * @return
	 */
	protected ISystemModel getSystemModel(){
		return this.iSystemModel;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemPlugin#getServicePlugin()
	 */
	@Override
	public IServicePlugin getServicePlugin() {
		if(iSystemServicePlugin != null)
			return iSystemServicePlugin;
		else {
			if(this.prevSystemPlugin!=null)
				return this.prevSystemPlugin.getServicePlugin();
		}
		return null;
	}
	
	protected void registerServicePlugin(String strDEName,IServicePlugin iServicePlugin)throws Exception{
		if(iSystemServicePlugin == null){
			iSystemServicePlugin = createSystemServicePlugin();
			iSystemServicePlugin.setPrevPlugin(this.getPrevPlugin());
		}
		
		iSystemServicePlugin.registerServicePlugin(strDEName, iServicePlugin);
	}

	/**
	 * 建立系统服务插件
	 * @return
	 * @throws Exception
	 */
	protected ISystemServicePlugin createSystemServicePlugin() throws Exception{
		return new SystemServicePlugin();
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemPlugin#getViewMsgGroupPlugin()
	 */
	@Override
	public IViewMsgGroupPlugin getViewMsgGroupPlugin() {
		if(iSystemViewMsgGroupPlugin != null)
			return iSystemViewMsgGroupPlugin;
		else {
			if(this.prevSystemPlugin!=null)
				return this.prevSystemPlugin.getViewMsgGroupPlugin();
		}
		return null;
	}
	
	protected void registerViewMsgGroupPlugin(String strUniqueTag,IViewMsgGroupPlugin iViewMsgGroupPlugin)throws Exception{
		if(iSystemViewMsgGroupPlugin == null){
			iSystemViewMsgGroupPlugin = createSystemViewMsgGroupPlugin();
			iSystemViewMsgGroupPlugin.setPrevPlugin(this.getPrevPlugin());
		}
		
		iSystemViewMsgGroupPlugin.registerViewMsgGroupPlugin(strUniqueTag, iViewMsgGroupPlugin);
	}

	/**
	 * 建立系统视图消息组插件
	 * @return
	 * @throws Exception
	 */
	protected ISystemViewMsgGroupPlugin createSystemViewMsgGroupPlugin() throws Exception{
		return new SystemViewMsgGroupPlugin();
	}
	
	

	@Override
	public void setPrevPlugin(IPlugin iPlugin) {
		super.setPrevPlugin(iPlugin);
		if(iPlugin instanceof ISystemPlugin){
			prevSystemPlugin = (ISystemPlugin)iPlugin;
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemPlugin#getApplicationPlugin()
	 */
	@Override
	public IApplicationPlugin getApplicationPlugin() {
		 if(iSystemApplicationPlugin != null)
			return iSystemApplicationPlugin;
		else {
			if(this.prevSystemPlugin!=null)
				return this.prevSystemPlugin.getApplicationPlugin();
		}
		 return null;
	}
	
	
	
}
