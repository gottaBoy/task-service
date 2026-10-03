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
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSLanguageService;
import net.ibizsys.pscore.srv.config.service.PSLanguageServiceBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDataEntityDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeListBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDE;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
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
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFWorkTime;
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
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null || ViewController.getCurrent() == null) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e");
        }
        if (!pSDynaSys.isFullEntity()) {
            this.get(pSDynaSys);
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
        ArrayList<JSONObject> items = new ArrayList<JSONObject>();
        PSSystemService systemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        PSSystem system = new PSSystem();
        system.setPSSystemId(pSDynaSys.getPSDynaSysId());
        systemService.get(system);
        PSSystem exportSystem = new PSSystem();
        exportSystem.setPSSystemId(system.getPSSystemId());
        exportSystem.setPSSystemName(system.getPSSystemName());
        JSONObject model = this.toSimpleJsonObject(exportSystem, systemService.getDEModel());
        if (model != null) {
            items.add(model);
        }
        PSModuleService moduleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        for (PSModule module : moduleService.selectByPSSystem(exportSystem)) {
            model = this.toSimpleJsonObject(module, moduleService.getDEModel());
            if (model != null) {
                items.add(model);
            }
        }
        PSLanguageService languageService = (PSLanguageService)ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)this.getSessionFactory());
        for (PSLanguage language : languageService.select((ISelectCond)new SelectCond())) {
            model = this.toSimpleJsonObject(language, languageService.getDEModel());
            if (model != null) {
                items.add(model);
            }
        }
        PSAppTypeService appTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
        for (PSAppType appType : appTypeService.select((ISelectCond)new SelectCond())) {
            model = this.toSimpleJsonObject(appType, appTypeService.getDEModel());
            if (model != null) {
                items.add(model);
            }
        }
        SelectCond cond = new SelectCond();
        cond.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        PSSysCssService cssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysCss css : cssService.select((ISelectCond)cond)) {
            cssService.exportModel(css, items);
        }
        cond = new SelectCond();
        cond.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        cond.set("PSDEID", SelectCond.ISNULL);
        PSDEOPPrivService opPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEOPPriv opPriv : opPrivService.select((ISelectCond)cond)) {
            opPrivService.exportModel(opPriv, items);
        }
        PSDynaSys exportDynaSys = new PSDynaSys();
        exportDynaSys.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        exportDynaSys.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
        model = this.toSimpleJsonObject(exportDynaSys, this.getDEModel());
        if (model != null) {
            items.add(model);
        }
        cond = new SelectCond();
        cond.set("UIACTIONTYPE", "SYS");
        cond.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        cond.set("PSWFID", SelectCond.ISNULL);
        PSDEUIActionService uiActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEUIAction uiAction : uiActionService.select((ISelectCond)cond)) {
            if (uiAction.getPSSysImage() != null) {
                pSSysImageService.exportModel(uiAction.getPSSysImage(), items);
            }
            uiActionService.exportModel(uiAction, items);
        }
        cond = new SelectCond();
        cond.set("PSDEID", SelectCond.ISNULL);
        cond.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        PSDEToolbarService toolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEToolbar toolbar : toolbarService.select((ISelectCond)cond)) {
            if (toolbar.isFullEntity()) {
                toolbar.resetPSSysToolbarId();
                toolbar.resetPSSysToolbarName();
                toolbar.resetPSSysPFPluginId();
                toolbar.resetPSSysPFPluginName();
            }
            toolbarService.exportModel(toolbar, items);
        }
        cond = new SelectCond();
        cond.set("PSSYSTEMID", pSDynaSys.getPSDynaSysId());
        cond.set("PSDEID", SelectCond.ISNULL);
        cond.set("PSDYNAINSTID", SelectCond.ISNULL);
        for (PSCodeList codeList : pSCodeListService.select((ISelectCond)cond)) {
            pSCodeListService.exportModel(codeList, items);
        }
        cond = new SelectCond();
        cond.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        PSDynaCodeListService dynaCodeListService = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
        for (PSDynaCodeList dynaCodeList : dynaCodeListService.select((ISelectCond)cond)) {
            dynaCodeListService.exportModel(dynaCodeList, items);
            PSCodeList codeList = new PSCodeList();
            codeList.setPSCodeListId(dynaCodeList.getPSDynaCodeListId());
            pSCodeListService.exportModel(codeList, items);
        }
        cond = new SelectCond();
        cond.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        PSDynaDEService dynaDEService = (PSDynaDEService)ServiceGlobal.getService(PSDynaDEService.class, (SessionFactory)this.getSessionFactory());
        for (PSDynaDE dynaDE : dynaDEService.select((ISelectCond)cond)) {
            dynaDEService.exportModel(dynaDE, items);
            PSDataEntity dataEntity = new PSDataEntity();
            dataEntity.setPSDataEntityId(dynaDE.getPSDynaDEId());
            pSDataEntityService.get(dataEntity);
            dataEntity.resetLNPSLanResId();
            dataEntity.resetLNPSLanResName();
            pSDataEntityService.exportModel(dataEntity, items);
            for (PSDynaDEForm dynaDEForm : dynaDE.getPSDynaDEForms()) {
                pSDynaDEFormService.exportModel(dynaDEForm, items);
            }
        }
        for (PSWFRole role : pSWFRoleService.select((ISelectCond)new SelectCond())) {
            pSWFRoleService.exportModel(role, items);
        }
        for (PSWFWorkTime workTime : pSWFWorkTimeService.select((ISelectCond)new SelectCond())) {
            pSWFWorkTimeService.exportModel(workTime, items);
        }
        cond = new SelectCond();
        cond.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        PSDynaWFService dynaWFService = (PSDynaWFService)ServiceGlobal.getService(PSDynaWFService.class, (SessionFactory)this.getSessionFactory());
        for (PSDynaWF dynaWF : dynaWFService.select((ISelectCond)cond)) {
            dynaWFService.exportModel(dynaWF, items);
            PSWorkflow workflow = new PSWorkflow();
            workflow.setPSWorkflowId(dynaWF.getPSDynaWFId());
            pSWorkflowService.exportModel(workflow, items);
            for (PSWFDE wfDE : workflow.getPSWFDEs()) {
                pSWFDEService.exportModel(wfDE, items);
            }
        }
        cond = new SelectCond();
        cond.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        PSDynaWFVerService dynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        for (PSDynaWFVer dynaWFVer : dynaWFVerService.select((ISelectCond)cond)) {
            dynaWFVerService.exportModel(dynaWFVer, items);
            PSWFVersion version = new PSWFVersion();
            version.setPSWFVersionId(dynaWFVer.getPSDynaWFVerId());
            if (!pSWFVersionService.get(version, true)) continue;
            pSWFVersionService.exportModel(version, items);
        }
        cond = new SelectCond();
        cond.set("PSDYNASYSID", pSDynaSys.getPSDynaSysId());
        PSDynaAppService dynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
        PSDynaAppViewService dynaAppViewService = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        for (PSDynaApp dynaApp : dynaAppService.select((ISelectCond)cond)) {
            dynaAppService.exportModel(dynaApp, items);
            PSSysApp sysApp = new PSSysApp();
            sysApp.setPSSysAppId(dynaApp.getPSDynaAppId());
            pSSysAppService.get(sysApp);
            sysApp.resetPSPFId();
            sysApp.resetPSPFName();
            sysApp.resetPSPFStyleId();
            sysApp.resetPSPFStyleName();
            model = this.toSimpleJsonObject(sysApp, pSSysAppService.getDEModel());
            if (model != null) {
                items.add(model);
            }
            for (PSDynaAppView dynaAppView : dynaApp.getPSDynaAppViews()) {
                dynaAppViewService.exportModel(dynaAppView, items);
                PSAppView appView = new PSAppView();
                appView.setPSAppViewId(dynaAppView.getPSDynaAppViewId());
                if (!pSAppViewService.get(appView, true)) continue;
                pSAppViewService.exportModel(appView, items);
            }
        }
        HashMap<String, String> excluded = new HashMap<String, String>();
        excluded.put("PSDEDBCFG", "");
        excluded.put("PSDEFDTCOL", "");
        excluded.put("PSDEDATAQUERY", "");
        excluded.put("PSDEDQJOIN", "");
        excluded.put("PSDEDQCODE", "");
        excluded.put("PSDEDQCODEEXP", "");
        excluded.put("PSDEFSFITEM", "");
        excluded.put("PSDEDSDQ", "");
        excluded.put("PSDEDRGROUP", "");
        excluded.put("PSDEACMODE", "");
        excluded.put("PSDELIST", "");
        excluded.put("PSDEDATARELATION", "");
        excluded.put("PSDEDRDETAIL", "");
        excluded.put("PSDEVIEWRV", "");
        ArrayList<JSONObject> filteredItems = new ArrayList<JSONObject>();
        for (JSONObject item : items) {
            String modelName = item.optString("srfdename");
            if (!StringHelper.isNullOrEmpty(modelName) && excluded.containsKey(modelName.toUpperCase())) continue;
            filteredItems.add(item);
        }
        JSONObject backup = new JSONObject();
        backup.put("items", (Object)filteredItems.toArray());
        String timestamp = StringHelper.format((String)"%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", (Object)new Date());
        String tmpFile = FileHelper.getTmpFileName((IWebContext)this.getWebContext(), timestamp, ".ibzbak");
        OutputStreamWriter writer = new OutputStreamWriter((OutputStream)new FileOutputStream(tmpFile, false), "UTF-8");
        writer.write(backup.toString());
        writer.flush();
        writer.close();
        String downloadUrl = ViewController.getCurrent().getAppModel().getUtilPageUrl("DOWNLOADTMPFILE");
        String downloadPath = StringHelper.format((String)"%1$sFILEID=%2$s", (Object)downloadUrl, (Object)WebUtility.encodeURLParamValue(timestamp + ".ibzbak"));
        AjaxActionResult ajaxActionResult = WebContext.getCurrent().getCurAjaxActionResult();
        ajaxActionResult.setDownloadPath(downloadPath);
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
