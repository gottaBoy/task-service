package net.ibizsys.paas.core;

/**
 * 运行插件基类
 * @author Administrator
 *
 */
public abstract class PluginBase implements IPlugin{

	private String strPluginParams = null;
	private IPlugin iPlugin = null;
	
	@Override
	public void init(String strPluginParams) throws Exception {
		this.strPluginParams = strPluginParams;
		onInit();
	}
	
	/**
	 * 初始化触发
	 * @throws Exception
	 */
	protected void onInit()throws Exception{
		
	}
	
	
	/**
	 * 获取插件参数
	 * @return
	 */
	protected String getPluginParams(){
		return this.strPluginParams;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IPlugin#setPrevPlugin(net.ibizsys.paas.core.IPlugin)
	 */
	@Override
	public void setPrevPlugin(IPlugin iPlugin) {
		this.iPlugin = iPlugin;
	}
	
	
	/**
	 * 获取上一个插件
	 * @return
	 */
	protected IPlugin getPrevPlugin(){
		return this.iPlugin;
	}

}
