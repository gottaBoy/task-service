package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;

//拷贝应用框架插件时，同时拷贝 系统应用插件模板 
public class PSSysPFPluginServicePlugin extends ServicePluginBase {
	private static final Log log = LogFactory.getLog(PSSysPFPluginServicePlugin.class);
	
	@Override
	public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		
		if(nActionPos == IPlugin.ACTIONPOS_ENTER)
		{
			//获取插件和模板service
			PSSysPFPITemplService psSysPFPITemplService=(PSSysPFPITemplService) ServiceGlobal.getService(PSSysPFPITemplService.class,iService.getSessionFactory());
			PSSysPFPlugin psSysPFPlugin=new PSSysPFPlugin();
			
			//把id传给新建的插件，为了下一步通过该插件查找它里面的数据
			psSysPFPlugin.setPSSysPFPluginId((String) objParam);
			
			PSSysPFPlugin psSysPFPluginNew=(PSSysPFPlugin) iEntity;
			
			//通过插件查询该插件下所有模板
			ArrayList<PSSysPFPITempl> list=psSysPFPITemplService.selectByPSSysPFPlugin(psSysPFPlugin);
			for (PSSysPFPITempl psSysPFPITempl : list) {
				//设置模板id
				psSysPFPITempl.resetPSSysPFPITemplId();
				//设置模板所属的插件的id
				psSysPFPITempl.setPSSysPFPluginId(psSysPFPluginNew.getPSSysPFPluginId());
				//设置模板所属的插件的name
				psSysPFPITempl.setPSSysPFPluginName(psSysPFPluginNew.getPSSysPFPluginName());
				//创建模板
				psSysPFPITemplService.create(psSysPFPITempl);
			}
			
			return PluginActionResult.Continue;
			
		}
		return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
	}
}
