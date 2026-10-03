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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;

public class PSWFDEServicePlugin extends ServicePluginBase{

	private static final Log log = LogFactory.getLog(PSWFDEServicePlugin.class);

	@Override
	public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(nActionPos == IPlugin.ACTIONPOS_AFTERAFTER){
			PSWFDE psWFDE = (PSWFDE) iEntity;
			if(!StringHelper.isNullOrEmpty(psWFDE.getPSDEId())){
				PSDEFieldService psDEFieldService = (PSDEFieldService) ServiceGlobal.getService(PSDEFieldService.class,iService.getSessionFactory());
				if(psDEFieldService != null){
					//设置工作流实体的默认工作流属性信息
					ArrayList<PSDEField> psDEFieldList = psDEFieldService.selectByDataEntity(psWFDE.getPSDEId());
					for(PSDEField psDEField : psDEFieldList){
						if(StringHelper.compare(psDEField.getBizTag(), "WFINSTANCEID", true) == 0 ){
							psWFDE.setWFInstPSDEFId(psDEField.getPSDEFieldId());
							psWFDE.setWFInstPSDEFName(psDEField.getPSDEFieldName());
						}else if(StringHelper.compare(psDEField.getBizTag(), "WFSTATE", true) == 0){
							psWFDE.setWFStatePSDEFId(psDEField.getPSDEFieldId());
							psWFDE.setWFStatePSDEFName(psDEField.getPSDEFieldName());
						}else if(StringHelper.compare(psDEField.getBizTag(), "WFSTEP", true) == 0){
							psWFDE.setWFStepPSDEFId(psDEField.getPSDEFieldId());
							psWFDE.setWFStepPSDEFName(psDEField.getPSDEFieldName());
						}else if(StringHelper.compare(psDEField.getBizTag(), "WFVERSION", true) == 0){
							psWFDE.setWFVerPSDEFId(psDEField.getPSDEFieldId());
							psWFDE.setWFVerPSDEFName(psDEField.getPSDEFieldName());
						}else if(StringHelper.compare(psDEField.getBizTag(), "WFUSERSTATE", true) == 0){
							psWFDE.setStatePSDEFId(psDEField.getPSDEFieldId());
							psWFDE.setStatePSDEFName(psDEField.getPSDEFieldName());
						}
					}
				}
			}
			return PluginActionResult.Continue;
		}
		
		return super.doGetDraft(iService, nActionPos, iEntity, objParam);
	}
}
