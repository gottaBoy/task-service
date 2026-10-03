package net.ibizsys.pscoreux.srv.plugin;

import net.ibizsys.paas.sysmodel.SystemPluginBase;
import net.ibizsys.pscore.srv.PSCoreSysModel;

/**
 * 系统插件
 * @author Administrator
 *
 */
public class PSCoreSysModelPlugin extends SystemPluginBase {

	@Override
	protected void onInit() throws Exception {
		
		//注册实体服务插件
		this.registerServicePlugin(PSCoreSysModel.PSDATAENTITY, new PSDataEntityServicePlugin());
		this.registerServicePlugin(PSCoreSysModel.PSDEDATAQUERY, new PSDEDataQueryServicePlugin());
		this.registerServicePlugin(PSCoreSysModel.PSDER, new PSDERServicePlugin());
		this.registerServicePlugin(PSCoreSysModel.PSWFDE, new PSWFDEServicePlugin());
//		this.registerServicePlugin(PSCoreSysModel.PSSYSPFPLUGIN,new PSSysPFPluginServicePlugin());
		this.registerServicePlugin(PSCoreSysModel.PSDEUIACTION, new PSDEUIActionServicePlugin());
		this.registerServicePlugin(PSCoreSysModel.PSAPPMENU, new PSAppMenuServicePlugin());
		this.registerServicePlugin(PSCoreSysModel.PSDEFIELD, new PSDEFieldServicePlugin());
		super.onInit();
	}
	
	
}
