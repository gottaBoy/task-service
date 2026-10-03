package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;

public class PSDEDataQueryServicePlugin extends ServicePluginBase {
	
	private static final Log log = LogFactory.getLog(PSDEDataQueryServicePlugin.class);

	@Override
	public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(nActionPos == IPlugin.ACTIONPOS_ENTER){
			if(StringHelper.isNullOrEmpty(objParam))
				return PluginActionResult.Continue;
			
			//实体数据查询Service
			PSDEDataQueryService psDEDataQueryService = (PSDEDataQueryService) ServiceGlobal.getService(PSDEDataQueryService.class,iService.getSessionFactory());
			PSDEDataQuery psdeDataQueryNew = (PSDEDataQuery) iEntity;
			
			PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
			psDEDataQuery.setPSDEDataQueryId((String) objParam);
			
			if(psDEDataQueryService.select(psDEDataQuery,true)) {
				if(DataObject.getBoolValue(psDEDataQuery.getCustomMode(),false)) {
					//实体数据查询代码Service
					PSDEDQCodeService psDEDQCodeService = (PSDEDQCodeService) ServiceGlobal.getService(PSDEDQCodeService.class, iService.getSessionFactory());
					//实体查询代码表达式Service
					PSDEDQCodeExpService psDEDQCodeExpService = (PSDEDQCodeExpService) ServiceGlobal.getService(PSDEDQCodeExpService.class, iService.getSessionFactory());
					//实体查询代码条件Service
					PSDEDQCodeCondService psDEDQCodeCondService = (PSDEDQCodeCondService) ServiceGlobal.getService(PSDEDQCodeCondService.class, iService.getSessionFactory());
					//需要拷贝的实体数据查询代码
					ArrayList<PSDEDQCode> psDEDQCodeList = psDEDQCodeService.selectByPSDEDQ(psDEDataQuery);
					
					for (PSDEDQCode psDEDQCode : psDEDQCodeList) {
						//需要拷贝的实体查询代码表达式
						ArrayList<PSDEDQCodeExp> psDEDQCodeExpList = psDEDQCodeExpService.selectByPSDEDQCode(psDEDQCode);
						//需要拷贝的实体查询代码条件
						ArrayList<PSDEDQCodeCond> psDEDQCodeCondList = psDEDQCodeCondService.selectByPSDEDQCode(psDEDQCode);
						
						psDEDQCode.resetPSDEDQCodeId();
						psDEDQCode.setPSDEDQId(psdeDataQueryNew.getPSDEDataQueryId());
						psDEDQCode.setPSDEDQName(psdeDataQueryNew.getPSDEDataQueryName());
						psDEDQCodeService.create(psDEDQCode);
						for (PSDEDQCodeExp psDEDQCodeExp : psDEDQCodeExpList) {
							psDEDQCodeExp.resetPSDEDQCodeExpId();
							psDEDQCodeExp.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
							psDEDQCodeExp.setPSDEDQCodeName(psDEDQCode.getPSDEDQCodeName());
							psDEDQCodeExpService.create(psDEDQCodeExp);
						}
						for (PSDEDQCodeCond psDEDQCodeCond : psDEDQCodeCondList) {
							psDEDQCodeCond.resetPSDEDQCodeCondId();
							psDEDQCodeCond.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
							psDEDQCodeCond.setPSDEDQCodeName(psDEDQCode.getPSDEDQCodeName());
							psDEDQCodeCondService.create(psDEDQCodeCond);
						}
					}
				}
			} else {
				log.error(StringHelper.format("数据查选拷贝源[%1$s]不存在!", objParam));
				return PluginActionResult.Continue;
			}
			
			return PluginActionResult.Replace;
		}
		return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
	}
	
}
