package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService;

/**
 * 数据实体服务插件
 * @author Administrator
 *
 */
public class PSDataEntityServicePlugin extends ServicePluginBase {

	public static final String TAG_WFINSTANCEID="WFINSTANCEID";
	public static final String TAG_WFSTATE="WFSTATE";
	public static final String TAG_WFSTEP="WFSTEP";
	public static final String TAG_WFVERSION="WFVERSION";
	public static final String TAG_WFUSERSTATE="WFUSERSTATE";
	
	
	@Override
	public PluginActionResult doRemove(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		//移除关联数据 PSDEVIEWCTRL（视图部件）、PSDEVIEWRV（引用视图）、PSDEVIEWLOGIC（视图逻辑）
		if(nActionPos == IPlugin.ACTIONPOS_BEFOREBEFORE){
			PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService) ServiceGlobal.getService(PSDEViewBaseService.class, iService.getSessionFactory());
			PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService) ServiceGlobal.getService(PSDEViewCtrlService.class, iService.getSessionFactory());
			PSDEViewRVService psDEViewRVService = (PSDEViewRVService) ServiceGlobal.getService(PSDEViewRVService.class, iService.getSessionFactory());
			PSDEViewLogicService psDEViewLogicService = (PSDEViewLogicService) ServiceGlobal.getService(PSDEViewLogicService.class, iService.getSessionFactory());

			//查询实体引用视图，并删除相关数据
			ArrayList<PSDEViewBase> psDeViewBaseList = psDEViewBaseService.selectByPSDE((PSDataEntity)iEntity);
			for(PSDEViewBase psDEViewBase:psDeViewBaseList){
				//取消视图部件默认标记
				SelectCond cond = new SelectCond();
				cond.set(PSDEViewCtrl.FIELD_PSDEVIEWBASEID, psDEViewBase.getPSDEViewBaseId());
				cond.setConditon(PSDEViewCtrl.FIELD_DEFAULTFLAG, 1);
				ArrayList<PSDEViewCtrl> updatePSDEViewCtrlList = psDEViewCtrlService.select(cond);
				for(PSDEViewCtrl psDEViewCtrl : updatePSDEViewCtrlList){
					psDEViewCtrl.setDefaultFlag(0);
					psDEViewCtrlService.update(psDEViewCtrl);
				}
				//删除引用视图部件
				ArrayList<PSDEViewCtrl> psDEViewCtrlList = psDEViewCtrlService.selectByPSDEViewBase(psDEViewBase);
				psDEViewCtrlService.remove(psDEViewCtrlList);
				
				//删除引用视图
				ArrayList<PSDEViewRV> psDeViewRVList = psDEViewRVService.selectByMajorPSDEView(psDEViewBase);
				psDEViewRVService.remove(psDeViewRVList);
				
				//删除视图逻辑
				ArrayList<PSDEViewLogic> psDEViewLogicList = psDEViewLogicService.selectByPSDEViewBase(psDEViewBase);
				psDEViewLogicService.remove(psDEViewLogicList);
			}
			return PluginActionResult.Continue;
		}
		return super.doRemove(iService, nActionPos, iEntity, objParam);
	}
	
	@Override
	public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity,
			Object objParam) throws Exception {
		if(nActionPos == IPlugin.ACTIONPOS_LEAVE && StringHelper.compare(strActionName, PSCoreSysServiceBase.ACTION_INITMODEL, true)==0){
			PSDataEntity psDataEntity = (PSDataEntity)iEntity;
			
			if(DataObject.getBoolValue(psDataEntity.getEnableWFModel(),false)){
				//获取实体标识
				String strPSDataEntityId = psDataEntity.getPSDataEntityId();
				PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, iService.getSessionFactory());
				PSDEField psDEField = new PSDEField();
				
				//添加工作流实例属性
				psDEField.setPSDEId(strPSDataEntityId);
				psDEField.setBizTag(TAG_WFINSTANCEID);
				if(!psDEFieldService.select(psDEField, true)){
					psDEField.setPSDEFieldName(TAG_WFINSTANCEID);
					psDEField.setCodeName("WFInstanceId");
					psDEField.setLogicName("工作流实例");
					psDEField.setDEFType(IDEField.DEFTYPE_PHISICAL);
					psDEField.setPSDataTypeId(IDEField.DATATYPE_TEXT);
					psDEField.setPSDataTypeName("文本，可指定长度");
					psDEField.setAllowEmpty(1);
					psDEFieldService.save(psDEField);
				}
				
				//添加工作流状态属性
				psDEField.reset();
				psDEField.setPSDEId(strPSDataEntityId);
				psDEField.setBizTag(TAG_WFSTATE);
				if(!psDEFieldService.select(psDEField, true)){
					psDEField.setPSDEFieldName(TAG_WFSTATE);
					psDEField.setCodeName("WFState");
					psDEField.setLogicName("工作流状态");
					psDEField.setDEFType(IDEField.DEFTYPE_PHISICAL);
					psDEField.setPSDataTypeId(IDEField.DATATYPE_WFSTATE);
					psDEField.setPSDataTypeName("工作流处理状态");
					psDEField.setAllowEmpty(1);
					psDEFieldService.save(psDEField);
				}
				
				//添加工作流步骤属性
				psDEField.reset();
				psDEField.setPSDEId(strPSDataEntityId);
				psDEField.setBizTag(TAG_WFSTEP);
				if(!psDEFieldService.select(psDEField, true)){
					psDEField.setPSDEFieldName(TAG_WFSTEP);
					psDEField.setCodeName("WFStep");
					psDEField.setLogicName("工作流步骤");
					psDEField.setDEFType(IDEField.DEFTYPE_PHISICAL);
					psDEField.setPSDataTypeId(IDEField.DATATYPE_SSCODELIST);
					psDEField.setPSDataTypeName("单项选择(文本值)");
					psDEField.setAllowEmpty(1);
					psDEFieldService.save(psDEField);
				}
				
				//添加流程版本属性
				psDEField.reset();
				psDEField.setPSDEId(strPSDataEntityId);
				psDEField.setBizTag(TAG_WFVERSION);
				if(!psDEFieldService.select(psDEField, true)){
					psDEField.setPSDEFieldName(TAG_WFVERSION);
					psDEField.setCodeName("WFVersion");
					psDEField.setLogicName("流程版本");
					psDEField.setDEFType(IDEField.DEFTYPE_PHISICAL);
					psDEField.setPSDataTypeId(IDEField.DATATYPE_TEXT);
					psDEField.setPSDataTypeName("文本，可指定长度");
					psDEField.setAllowEmpty(1);
					psDEFieldService.save(psDEField);
				}

				//添加业务状态属性
				psDEField.reset();
				psDEField.setPSDEId(strPSDataEntityId);
				psDEField.setBizTag(TAG_WFUSERSTATE);
				if(!psDEFieldService.select(psDEField, true)){
					psDEField.setPSDEFieldName(psDataEntity.getPSDataEntityName()+TAG_WFSTATE);
					String strPSDECodeName = psDataEntity.getCodeName();
					if(StringHelper.isNullOrEmpty(strPSDECodeName))
						strPSDECodeName = psDataEntity.getPSDataEntityName();
					psDEField.setCodeName(StringHelper.format("%1$sWFState",strPSDECodeName));
					psDEField.setLogicName("业务状态");
					psDEField.setDEFType(IDEField.DEFTYPE_PHISICAL);
					psDEField.setPSDataTypeId(IDEField.DATATYPE_SSCODELIST);
					psDEField.setPSDataTypeName("单项选择(文本值)");
					psDEField.setAllowEmpty(1);
					psDEFieldService.save(psDEField);
				}
				
			}
			return PluginActionResult.Continue;
		}
		
		return super.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
	}
}
