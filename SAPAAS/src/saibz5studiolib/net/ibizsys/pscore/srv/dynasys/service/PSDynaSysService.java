/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.FileHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dynasys.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppModuleDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSLanguageService;
import net.ibizsys.pscore.srv.config.service.PSLanguageServiceBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDataEntityDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeListBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFDEDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDynaSysService
extends PSDynaSysServiceBase {
    private static final Log log = LogFactory.getLog(PSDynaSysService.class);

    @Override
    protected void onInitDynaModel(PSDynaSys pSDynaSys) throws Exception {
    }

    @Override
    protected void onExportDynaModel(PSDynaSys pSDynaSys) throws Exception {
        EntityBase entityBase;
        Object object7;
        Object object2;
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null || ViewController.getCurrent() == null) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e");
        }
        if (!pSDynaSys.isFullEntity()) {
            this.get((IEntity)pSDynaSys);
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)PSAppModuleDEModel.class.getName());
        IDataEntityModel iDataEntityModel2 = DEModelGlobal.getDEModel((String)PSDataEntityDEModel.class.getName());
        IDataEntityModel iDataEntityModel3 = DEModelGlobal.getDEModel((String)PSWFDEDEModel.class.getName());
        PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
        PSWFWorkTimeService pSWFWorkTimeService = (PSWFWorkTimeService)ServiceGlobal.getService(PSWFWorkTimeService.class, (SessionFactory)this.getSessionFactory());
        PSWFRoleService pSWFRoleService = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
        PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        PSDynaDEFormService pSDynaDEFormService = (PSDynaDEFormService)ServiceGlobal.getService(PSDynaDEFormService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<Object> arrayList = new ArrayList<Object>();
        HashMap<String, String> hashMap = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<Object> arrayList2 = new PSSystem();
        ((PSSystemBase)((Object)arrayList2)).setPSSystemId(pSDynaSys.getPSDynaSysId());
        hashMap.get((IEntity)arrayList2);
        JSONObject jSONObject = new PSSystem();
        jSONObject.setPSSystemId(((PSSystemBase)((Object)arrayList2)).getPSSystemId());
        jSONObject.setPSSystemName(((PSSystemBase)((Object)arrayList2)).getPSSystemName());
        Object object32 = this.toSimpleJsonObject((IEntity)jSONObject, ((PSSystemServiceBase)((Object)hashMap)).getDEModel());
        if (object32 != null) {
            arrayList.add(object32);
        }
        Object object42 = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        Object object5 = ((PSModuleServiceBase)object42).selectByPSSystem((PSSystemBase)jSONObject);
        Object object6 = ((ArrayList)object5).iterator();
        while (object6.hasNext()) {
            object2 = object6.next();
            object32 = this.toSimpleJsonObject((IEntity)object2, ((PSModuleServiceBase)object42).getDEModel());
            if (object32 == null) continue;
            arrayList.add(object32);
        }
        object6 = (PSLanguageService)ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)this.getSessionFactory());
        object2 = object6.select((ISelectCond)new SelectCond());
        for (Object object7 : object2) {
            object32 = this.toSimpleJsonObject((IEntity)object7, ((PSLanguageServiceBase)object6).getDEModel());
            if (object32 == null) continue;
            arrayList.add(object32);
        }
        AjaxActionResult ajaxActionResult = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
        object7 = ajaxActionResult.select((ISelectCond)new SelectCond());
        Object object82 = ((ArrayList)object7).iterator();
        while (object82.hasNext()) {
            entityBase = (PSAppType)object82.next();
            object32 = this.toSimpleJsonObject((IEntity)entityBase, ajaxActionResult.getDEModel());
            if (object32 == null) continue;
            arrayList.add(object32);
        }
        hashMap = new SelectCond();
        hashMap.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            arrayList2.exportModel((IEntity)object42, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        hashMap.set("PSDEID", SelectCond.ISNULL);
        arrayList2 = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            arrayList2.exportModel((IEntity)object42, arrayList);
        }
        hashMap = new PSDynaSys();
        ((PSDynaSysBase)((Object)hashMap)).setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        ((PSDynaSysBase)((Object)hashMap)).setPSDynaSysName(pSDynaSys.getPSDynaSysName());
        arrayList2 = this.toSimpleJsonObject((IEntity)hashMap, this.getDEModel());
        if (arrayList2 != null) {
            arrayList.add(arrayList2);
        }
        hashMap = new SelectCond();
        hashMap.set("UIACTIONTYPE", "SYS");
        hashMap.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        hashMap.set("PSWFID", SelectCond.ISNULL);
        arrayList2 = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            if (((PSDEUIActionBase)object42).getPSSysImage() != null) {
                pSSysImageService.exportModel((IEntity)((PSDEUIActionBase)object42).getPSSysImage(), arrayList);
            }
            arrayList2.exportModel((IEntity)object42, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSDEID", SelectCond.ISNULL);
        hashMap.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            if (object42.isFullEntity()) {
                ((PSDEToolbarBase)object42).resetPSSysToolbarId();
                ((PSDEToolbarBase)object42).resetPSSysToolbarName();
                ((PSDEToolbarBase)object42).resetPSSysPFPluginId();
                ((PSDEToolbarBase)object42).resetPSSysPFPluginName();
            }
            arrayList2.exportModel((IEntity)object42, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        hashMap.set("PSDEID", SelectCond.ISNULL);
        hashMap.set("PSDYNAINSTID", SelectCond.ISNULL);
        arrayList2 = pSCodeListService.select((ISelectCond)hashMap);
        for (Object object32 : arrayList2) {
            pSCodeListService.exportModel((IEntity)object32, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            arrayList2.exportModel((IEntity)object42, arrayList);
            object5 = new PSCodeList();
            ((PSCodeListBase)object5).setPSCodeListId(((PSDynaCodeListBase)object42).getPSDynaCodeListId());
            pSCodeListService.exportModel((IEntity)object5, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            arrayList2.exportModel((IEntity)object42, arrayList);
            object5 = new PSDataEntity();
            ((PSDataEntityBase)object5).setPSDataEntityId(((PSDynaDEBase)object42).getPSDynaDEId());
            pSDataEntityService.get((IEntity)object5);
            ((PSDataEntityBase)object5).resetLNPSLanResId();
            ((PSDataEntityBase)object5).resetLNPSLanResName();
            pSDataEntityService.exportModel((IEntity)object5, arrayList);
            object6 = ((PSDynaDEBase)object42).getPSDynaDEForms();
            object2 = ((ArrayList)object6).iterator();
            while (object2.hasNext()) {
                ajaxActionResult = (PSDynaDEForm)object2.next();
                pSDynaDEFormService.exportModel((IEntity)ajaxActionResult, arrayList);
            }
        }
        hashMap = new SelectCond();
        arrayList2 = pSWFRoleService.select((ISelectCond)hashMap);
        for (Object object32 : arrayList2) {
            pSWFRoleService.exportModel((IEntity)object32, arrayList);
        }
        hashMap = new SelectCond();
        arrayList2 = pSWFWorkTimeService.select((ISelectCond)hashMap);
        for (Object object32 : arrayList2) {
            pSWFWorkTimeService.exportModel((IEntity)object32, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSDynaWFService)ServiceGlobal.getService(PSDynaWFService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            arrayList2.exportModel((IEntity)object42, arrayList);
            object5 = new PSWorkflow();
            ((PSWorkflowBase)object5).setPSWorkflowId(((PSDynaWFBase)object42).getPSDynaWFId());
            pSWorkflowService.exportModel((IEntity)object5, arrayList);
            object6 = ((PSWorkflowBase)object5).getPSWFDEs();
            object2 = ((ArrayList)object6).iterator();
            while (object2.hasNext()) {
                ajaxActionResult = (PSWFDE)object2.next();
                pSWFDEService.exportModel((IEntity)ajaxActionResult, arrayList);
            }
        }
        hashMap = new SelectCond();
        hashMap.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = arrayList2.select((ISelectCond)hashMap);
        for (Object object42 : jSONObject) {
            arrayList2.exportModel((IEntity)object42, arrayList);
            object5 = new PSWFVersion();
            ((PSWFVersionBase)object5).setPSWFVersionId(((PSDynaWFVerBase)object42).getPSDynaWFVerId());
            if (!pSWFVersionService.get((IEntity)object5, true)) continue;
            pSWFVersionService.exportModel((IEntity)object5, arrayList);
        }
        hashMap = new SelectCond();
        hashMap.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        arrayList2 = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
        jSONObject = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        object32 = arrayList2.select((ISelectCond)hashMap);
        object42 = ((ArrayList)object32).iterator();
        while (object42.hasNext()) {
            object5 = (PSDynaApp)object42.next();
            arrayList2.exportModel((IEntity)object5, arrayList);
            object6 = new PSSysApp();
            ((PSSysAppBase)object6).setPSSysAppId(((PSDynaAppBase)object5).getPSDynaAppId());
            pSSysAppService.get((IEntity)object6);
            ((PSSysAppBase)object6).resetPSPFId();
            ((PSSysAppBase)object6).resetPSPFName();
            ((PSSysAppBase)object6).resetPSPFStyleId();
            ((PSSysAppBase)object6).resetPSPFStyleName();
            object2 = this.toSimpleJsonObject((IEntity)object6, pSSysAppService.getDEModel());
            if (object2 != null) {
                arrayList.add(object2);
            }
            ajaxActionResult = ((PSDynaAppBase)object5).getPSDynaAppViews();
            for (Object object82 : ajaxActionResult) {
                jSONObject.exportModel((IEntity)object82, arrayList);
                entityBase = new PSAppView();
                entityBase.setPSAppViewId(((PSDynaAppViewBase)object82).getPSDynaAppViewId());
                if (!pSAppViewService.get((IEntity)entityBase, true)) continue;
                pSAppViewService.exportModel((IEntity)entityBase, arrayList);
            }
        }
        hashMap = new HashMap<String, String>();
        hashMap.put("PSDEDBCFG", "");
        hashMap.put("PSDEFDTCOL", "");
        hashMap.put("PSDEDATAQUERY", "");
        hashMap.put("PSDEDQJOIN", "");
        hashMap.put("PSDEDQCODE", "");
        hashMap.put("PSDEDQCODEEXP", "");
        hashMap.put("PSDEFSFITEM", "");
        hashMap.put("PSDEDSDQ", "");
        hashMap.put("PSDEDRGROUP", "");
        hashMap.put("PSDEACMODE", "");
        hashMap.put("PSDELIST", "");
        hashMap.put("PSDEDATARELATION", "");
        hashMap.put("PSDEDRDETAIL", "");
        hashMap.put("PSDEVIEWRV", "");
        arrayList2 = new ArrayList<Object>();
        for (Object object32 : arrayList) {
            object42 = object32.optString("srfdename");
            if (!StringHelper.isNullOrEmpty((String)object42) && hashMap.containsKey(((String)object42).toUpperCase())) continue;
            arrayList2.add(object32);
        }
        jSONObject = new JSONObject();
        jSONObject.put("items", (Object)arrayList2.toArray());
        object32 = StringHelper.format((String)"%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", (Object)new Date());
        object42 = FileHelper.getTmpFileName((IWebContext)this.getWebContext(), (String)object32, (String)".ibzbak");
        object5 = new OutputStreamWriter((OutputStream)new FileOutputStream((String)object42, false), "UTF-8");
        ((Writer)object5).write(jSONObject.toString());
        ((OutputStreamWriter)object5).flush();
        ((OutputStreamWriter)object5).close();
        object6 = ViewController.getCurrent().getAppModel().getUtilPageUrl("DOWNLOADTMPFILE");
        object2 = StringHelper.format((String)"%1$sFILEID=%2$s", (Object)object6, (Object)WebUtility.encodeURLParamValue((String)((String)object32 + ".ibzbak")));
        ajaxActionResult = WebContext.getCurrent().getCurAjaxActionResult();
        ajaxActionResult.setDownloadPath((String)object2);
    }

    protected JSONObject toSimpleJsonObject(IEntity iEntity, IDataEntityModel iDataEntityModel) throws Exception {
        String string = DataObject.toJSONString((IDataObject)iEntity, (boolean)false);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("srfdeid", (Object)iDataEntityModel.getId());
        jSONObject.put("srfdename", (Object)iDataEntityModel.getName());
        jSONObject.put("srfvalue", (Object)string);
        return jSONObject;
    }
}

