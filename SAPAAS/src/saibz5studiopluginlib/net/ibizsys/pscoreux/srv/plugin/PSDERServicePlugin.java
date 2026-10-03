package net.ibizsys.pscoreux.srv.plugin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;

public class PSDERServicePlugin extends ServicePluginBase {

	private static final Log log = LogFactory.getLog(PSDERServicePlugin.class);

	@Override
	public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam)
			throws Exception {
		if(nActionPos == IPlugin.ACTIONPOS_AFTERAFTER){
			
			boolean isExtract=PSCoreSysServiceBase.isExtractDefault(iService.getSessionFactory());
			if(isExtract){
				PSDEDataSetService psDEDataSetService=(PSDEDataSetService) ServiceGlobal.getService(PSDEDataSetService.class, iService.getSessionFactory());
				PSDEACModeService psDEACModeService=(PSDEACModeService) ServiceGlobal.getService(PSDEACModeService.class,iService.getSessionFactory());
				PSDEViewBaseService psDEViewBaseService=(PSDEViewBaseService) ServiceGlobal.getService(PSDEViewBaseService.class, iService.getSessionFactory());
				PSDER psDER=(PSDER) iEntity; 
				String strMajorPSDEId = psDER.getMajorPSDEId();
				if(!StringHelper.isNullOrEmpty(strMajorPSDEId)){
					//默认填充实体自填模式
					if(StringHelper.isNullOrEmpty(psDER.getPSDEACModeId())){
						PSDEACMode psDEACMode=new PSDEACMode();
						psDEACMode.setPSDEId(strMajorPSDEId);
						psDEACMode.setDefaultMode(1);
						if(psDEACModeService.select(psDEACMode, true)){
							psDER.setPSDEACModeId(psDEACMode.getPSDEACModeId());
							psDER.setPSDEACModeName(psDEACMode.getPSDEACModeName());
						}
					}
					if(StringHelper.isNullOrEmpty(psDER.getSDPSDEViewID())){
						//默认填充单项数据选择视图
						PSDEViewBase psDEViewBase= new PSDEViewBase();
						psDEViewBase.setPSDEId(strMajorPSDEId);
						psDEViewBase.setPredefinedViewType("PICKUPVIEW");
						if(psDEViewBaseService.select(psDEViewBase, true)){
							psDER.setSDPSDEViewID(psDEViewBase.getPSDEViewBaseId());
							psDER.setSDPSDEViewName(psDEViewBase.getPSDEViewBaseName());
						}
					}
					if(StringHelper.isNullOrEmpty(psDER.getMDPSDEViewId())){
						//默认填充多项数据选择视图
						PSDEViewBase psDEViewBase= new PSDEViewBase();
						psDEViewBase.setPSDEId(strMajorPSDEId);
						psDEViewBase.setPredefinedViewType("MPICKUPVIEW");
						if(psDEViewBaseService.select(psDEViewBase, true)){
							psDER.setMDPSDEViewId(psDEViewBase.getPSDEViewBaseId());
							psDER.setMDPSDEViewName(psDEViewBase.getPSDEViewBaseName());
						}
					}
					//默认填充关系数据集合
					if(StringHelper.isNullOrEmpty(psDER.getPSDEDataSetId())){
						PSDEDataSet psDEDataSet=new PSDEDataSet();
						psDEDataSet.setPSDEId(strMajorPSDEId);
						psDEDataSet.setDefaultMode(1);
						if(psDEDataSetService.select(psDEDataSet, true)){
							psDER.setPSDEDataSetId(psDEDataSet.getPSDEDataSetId());
							psDER.setPSDEDataSetName(psDEDataSet.getPSDEDataSetName());
						}
					}
				}
				
				return PluginActionResult.Continue;
			}
		}		
		return super.doGetDraft(iService, nActionPos, iEntity, objParam);
	}
}
