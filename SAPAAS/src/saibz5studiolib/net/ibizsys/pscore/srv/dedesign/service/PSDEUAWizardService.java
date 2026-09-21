/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.xml.SimpleXmlWriter
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.SimpleXmlWriter;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETemplField;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEUAWizardService
extends PSDEUAWizardServiceBase {
    public static final String WIZARDMODE_BATADDAPPVIEW = "BATADDAPPVIEW";
    public static final String WIZARDMODE_BATADDAPPVIEW2 = "BATADDAPPVIEW2";
    public static final String WIZARDMODE_BATADDAPPVIEW3 = "BATADDAPPVIEW3";
    public static final String WIZARDMODE_BATADDAPPVIEW4 = "BATADDAPPVIEW4";
    public static final String WIZARDMODE_BATADDDEDQCODEEXP = "BATADDDEDQCODEEXP";
    public static final String WIZARDMODE_BATMODIFYDEFUIMODE = "BATMODIFYDEFUIMODE";
    public static final String WIZARDMODE_BATMODIFYDEFIELD = "BATMODIFYDEFIELD";
    public static final String WIZARDMODE_MODIFYXMLMODEL = "MODIFYXMLMODEL";
    public static final String WIZARDMODE_BATMODIFYDE = "BATMODIFYDE";
    public static final String WIZARDMODE_BATMODIFYDEVIEWCTRL = "BATMODIFYDEVIEWCTRL";
    public static final String WIZARDMODE_BATAPPLYDETEMPL = "BATAPPLYDETEMPL";
    public static final String WIZARDMODE_BATMODIFYLANRES = "BATMODIFYLANRES";
    private static final Log log = LogFactory.getLog(PSDEUAWizardService.class);

    @Override
    public void getBatAddAppViewDraft(PSDEUAWizard pSDEUAWizard) throws Exception {
        String string = WebContext.getParentKey((IWebContext)this.getWebContext());
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        PSDataEntity pSDataEntity = new PSDataEntity();
        pSDataEntity.setPSDataEntityId(string);
        pSDataEntityService.get((IEntity)pSDataEntity);
        pSDEUAWizard.setPSSystemId(pSDataEntity.getPSSystemId());
        pSDEUAWizard.setPSSystemName(pSDataEntity.getPSSystemName());
    }

    @Override
    public void batAddAppView(PSDEUAWizard pSDEUAWizard) throws Exception {
        boolean bl = true;
        bl = DataObject.getBoolValue((Integer)pSDEUAWizard.getWizardParam(), (boolean)true);
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATADDAPPVIEW, (boolean)true) == 0) {
            String[] stringArray;
            PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            for (String string : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
                PSAppDEView pSAppDEView = new PSAppDEView();
                pSAppDEView.setPSDEViewBaseId(string);
                pSAppDEView.setPSSysAppId(pSDEUAWizard.getPSSysAppId());
                pSAppDEView.setPSSysAppName(pSDEUAWizard.getPSSysAppName());
                pSAppDEView.setPSAppModuleId(pSDEUAWizard.getPSAppModuleId());
                pSAppDEView.setPSAppModuleName(pSDEUAWizard.getPSAppModuleName());
                if (bl && pSAppDEViewService.checkKey(pSAppDEView) == 1) continue;
                pSAppDEViewService.save((IEntity)pSAppDEView);
            }
            return;
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATADDAPPVIEW2, (boolean)true) == 0) {
            String[] stringArray;
            PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
            for (String string : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(string);
                ArrayList<PSDEViewBase> arrayList = pSDEViewBaseService.selectByPSDE(pSDataEntity);
                for (PSDEViewBase pSDEViewBase : arrayList) {
                    PSAppDEView pSAppDEView = new PSAppDEView();
                    pSAppDEView.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    pSAppDEView.setPSSysAppId(pSDEUAWizard.getPSSysAppId());
                    pSAppDEView.setPSSysAppName(pSDEUAWizard.getPSSysAppName());
                    pSAppDEView.setPSAppModuleId(pSDEUAWizard.getPSAppModuleId());
                    pSAppDEView.setPSAppModuleName(pSDEUAWizard.getPSAppModuleName());
                    if (bl && pSAppDEViewService.checkKey(pSAppDEView) == 1) continue;
                    pSAppDEViewService.save((IEntity)pSAppDEView);
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATADDAPPVIEW3, (boolean)true) == 0) {
            String[] stringArray;
            PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            for (String string : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
                PSAppDynaDEView pSAppDynaDEView = new PSAppDynaDEView();
                pSAppDynaDEView.setPSDynaDEViewTemplId(string);
                pSAppDynaDEView.setPSSysAppId(pSDEUAWizard.getPSSysAppId());
                pSAppDynaDEView.setPSSysAppName(pSDEUAWizard.getPSSysAppName());
                pSAppDynaDEView.setPSAppModuleId(pSDEUAWizard.getPSAppModuleId());
                pSAppDynaDEView.setPSAppModuleName(pSDEUAWizard.getPSAppModuleName());
                if (bl && pSAppDynaDEViewService.checkKey(pSAppDynaDEView) == 1) continue;
                pSAppDynaDEViewService.save((IEntity)pSAppDynaDEView);
            }
            return;
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATADDAPPVIEW4, (boolean)true) == 0) {
            String[] stringArray;
            PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSDynaDEViewTemplService pSDynaDEViewTemplService = (PSDynaDEViewTemplService)ServiceGlobal.getService(PSDynaDEViewTemplService.class, (SessionFactory)this.getSessionFactory());
            for (String string : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
                PSDynaDETempl pSDynaDETempl = new PSDynaDETempl();
                pSDynaDETempl.setPSDynaDETemplId(string);
                ArrayList<PSDynaDEViewTempl> arrayList = pSDynaDEViewTemplService.selectByPSDynaDETempl(pSDynaDETempl);
                for (PSDynaDEViewTempl pSDynaDEViewTempl : arrayList) {
                    PSAppDynaDEView pSAppDynaDEView = new PSAppDynaDEView();
                    pSAppDynaDEView.setPSDynaDEViewTemplId(pSDynaDEViewTempl.getPSDynaDEViewTemplId());
                    pSAppDynaDEView.setPSSysAppId(pSDEUAWizard.getPSSysAppId());
                    pSAppDynaDEView.setPSSysAppName(pSDEUAWizard.getPSSysAppName());
                    pSAppDynaDEView.setPSAppModuleId(pSDEUAWizard.getPSAppModuleId());
                    pSAppDynaDEView.setPSAppModuleName(pSDEUAWizard.getPSAppModuleName());
                    if (bl && pSAppDynaDEViewService.checkKey(pSAppDynaDEView) == 1) continue;
                    pSAppDynaDEViewService.save((IEntity)pSAppDynaDEView);
                }
            }
            return;
        }
    }

    @Override
    protected void onAfterCreate(PSDEUAWizard pSDEUAWizard) throws Exception {
        PSDCDETempl pSDCDETempl;
        PSDCDETemplService pSDCDETemplService;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        IDataEntityModel iDataEntityModel;
        String string;
        String string2;
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATAPPLYDETEMPL, (boolean)true) == 0) {
            string2 = pSDEUAWizard.getActionData();
            string = pSDEUAWizard.getWizardParam4();
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                iDataEntityModel = string2.split("[;]");
                pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDCDETemplService = (PSDCDETemplService)ServiceGlobal.getService(PSDCDETemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                pSDCDETempl = new PSDCDETempl();
                pSDCDETempl.setPSDCDETemplId(string);
                if (!pSDCDETemplService.get((IEntity)pSDCDETempl, true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6a21\u677f"));
                }
                for (Object object : iDataEntityModel) {
                    ArrayList<PSDCDETemplField> arrayList = pSDCDETempl.getPSDCDETemplFields();
                    for (PSDCDETemplField pSDCDETemplField : arrayList) {
                        PSDEField pSDEField = new PSDEField();
                        pSDEField.setPSDEId((String)object);
                        pSDEField.setPSDEFieldName(pSDCDETemplField.getPSDCDETemplFieldName().toUpperCase());
                        if (pSCoreSysServiceBase.select(pSDEField, true)) continue;
                        pSDCDETemplField.copyTo((IDataObject)pSDEField, false);
                        try {
                            pSCoreSysServiceBase.create(pSDEField);
                        }
                        catch (Exception exception) {
                            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDCDETemplField.getPSDCDETemplFieldName(), (Object)exception.getMessage()));
                        }
                    }
                }
            }
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATADDDEDQCODEEXP, (boolean)true) == 0) {
            string2 = pSDEUAWizard.getActionData();
            string = pSDEUAWizard.getWizardParam3();
            iDataEntityModel = PropertiesHelper.load((String)string);
            pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
            pSDCDETemplService = new SelectCond();
            pSDCDETemplService.set("PSDEDQCODEID", string2);
            pSCoreSysServiceBase.remove((ISelectCond)pSDCDETemplService, true);
            int n = 1;
            for (Object e : iDataEntityModel.keySet()) {
                Object object;
                String string3 = PropertiesHelper.getProperty((Properties)iDataEntityModel, (String)e.toString());
                if (StringHelper.isNullOrEmpty((String)string3)) continue;
                object = new PSDEDQCodeExp();
                ((PSDEDQCodeExpBase)object).setPSDEDQCodeExpName(e.toString());
                ((PSDEDQCodeExpBase)object).setExpCode(string3);
                ((PSDEDQCodeExpBase)object).setPSDEDQCodeId(string2);
                ((PSDEDQCodeExpBase)object).setOrderValue(n);
                if (pSCoreSysServiceBase.checkKey(object) == 0) {
                    pSCoreSysServiceBase.create(object);
                }
                ++n;
            }
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_MODIFYXMLMODEL, (boolean)true) == 0) {
            string2 = pSDEUAWizard.getActionData();
            string = pSDEUAWizard.getActionData2();
            iDataEntityModel = DEModelGlobal.getDEModel((String)string);
            pSCoreSysServiceBase = (PSCoreSysServiceBase)iDataEntityModel.getService(this.getSessionFactory());
            pSDCDETemplService = iDataEntityModel.createEntity();
            pSDCDETemplService.set(iDataEntityModel.getKeyDEField().getName(), string2);
            pSDCDETempl = null;
            pSDCDETempl = StringHelper.isNullOrEmpty((String)pSDEUAWizard.getWizardParam3()) ? new XmlNode() : XmlNode.loadFromXML((String)pSDEUAWizard.getWizardParam3());
            pSCoreSysServiceBase.importXmlModel(pSDCDETemplService, (XmlNode)pSDCDETempl);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ctrl", (Object)"form");
            jSONObject.put("action", (Object)"reload");
            pSDEUAWizard.set("srfviewinvoke", jSONObject.toString());
        }
        super.onAfterCreate(pSDEUAWizard);
    }

    @Override
    public void getDraft(PSDEUAWizard pSDEUAWizard) throws Exception {
        super.getDraft(pSDEUAWizard);
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATADDDEDQCODEEXP, (boolean)true) == 0) {
            String string = pSDEUAWizard.getActionData();
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSDEDQCODEID", (Object)string);
            selectCond.setOrderInfo("ORDER BY ORDERVALUE");
            PSDEDQCodeExpService pSDEDQCodeExpService = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
            ArrayList arrayList = pSDEDQCodeExpService.select((ISelectCond)selectCond);
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            for (PSDEDQCodeExp pSDEDQCodeExp : arrayList) {
                stringBuilderEx.append("%1$s=%2$s\r\n", (Object)pSDEDQCodeExp.getPSDEDQCodeExpName(), (Object)pSDEDQCodeExp.getExpCode());
            }
            pSDEUAWizard.setWizardParam3(stringBuilderEx.toString());
            return;
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_MODIFYXMLMODEL, (boolean)true) == 0) {
            String string = pSDEUAWizard.getActionData();
            String string2 = pSDEUAWizard.getActionData2();
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)string2);
            PSCoreSysServiceBase pSCoreSysServiceBase = (PSCoreSysServiceBase)iDataEntityModel.getService(this.getSessionFactory());
            IEntity iEntity = iDataEntityModel.createEntity();
            iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)string);
            XmlNode xmlNode = pSCoreSysServiceBase.exportXmlModel(iEntity, null);
            StringBuilder stringBuilder = new StringBuilder();
            SimpleXmlWriter simpleXmlWriter = new SimpleXmlWriter(stringBuilder);
            simpleXmlWriter.writeRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
            simpleXmlWriter.writeRaw("\r\n");
            xmlNode.save(simpleXmlWriter);
            pSDEUAWizard.setWizardParam3(stringBuilder.toString());
            return;
        }
    }

    @Override
    protected void onBeforeCreate(PSDEUAWizard pSDEUAWizard) throws Exception {
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATMODIFYDEFUIMODE, (boolean)true) == 0) {
            this.batModifyDEFUIMode(pSDEUAWizard);
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATMODIFYDEFIELD, (boolean)true) == 0) {
            this.batModifyDEField(pSDEUAWizard);
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATMODIFYDE, (boolean)true) == 0) {
            this.batModifyDE(pSDEUAWizard);
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATMODIFYDEVIEWCTRL, (boolean)true) == 0) {
            this.batModifyDEViewCtrl(pSDEUAWizard);
        }
        if (StringHelper.compare((String)pSDEUAWizard.getWizardMode(), (String)WIZARDMODE_BATMODIFYLANRES, (boolean)true) == 0) {
            this.batModifySysLanRes(pSDEUAWizard);
        }
        super.onBeforeCreate(pSDEUAWizard);
    }

    protected void batModifyDEFUIMode(PSDEUAWizard pSDEUAWizard) throws Exception {
        String[] stringArray;
        if (StringHelper.isNullOrEmpty((String)pSDEUAWizard.getActionData())) {
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        String string = null;
        String string2 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"editorflag", (int)0) == 1) {
            bl = true;
            string = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"editortype", null);
        }
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"valueformatflag", (int)0) == 1) {
            bl2 = true;
            string2 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"valueformat", null);
        }
        PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        for (String string3 : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
            if (!bl) continue;
            PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
            pSDEFUIMode.setPSDEFUIModeId(string3);
            if (bl) {
                pSDEFUIMode.setEditorType(string);
            }
            if (bl2) {
                pSDEFUIMode.setValueFormat(string2);
            }
            pSDEFUIModeService.update(pSDEFUIMode, false);
        }
    }

    protected void batModifyDEField(PSDEUAWizard pSDEUAWizard) throws Exception {
        String[] stringArray;
        if (StringHelper.isNullOrEmpty((String)pSDEUAWizard.getActionData())) {
            return;
        }
        boolean bl = false;
        String string = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"logicnameflag", (int)0) == 1) {
            bl = true;
            string = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"logicname", null);
        }
        boolean bl2 = false;
        String string2 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"codenameflag", (int)0) == 1) {
            bl2 = true;
            string2 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"codename", null);
        }
        boolean bl3 = false;
        String string3 = null;
        String string4 = null;
        Integer n = null;
        Integer n2 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"datatypeflag", (int)0) == 1) {
            bl3 = true;
            string3 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"WIZARDPARAM5", null);
            string4 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"WIZARDPARAM4", null);
            n = DataObject.getIntegerValue((Object)pSDEUAWizard.get("length"), null);
            n2 = DataObject.getIntegerValue((Object)pSDEUAWizard.get("precision"), null);
        }
        boolean bl4 = false;
        String string5 = null;
        String string6 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"codelistflag", (int)0) == 1) {
            bl4 = true;
            string5 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"pscodelistid", null);
            string6 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"pscodelistName", null);
        }
        boolean bl5 = false;
        String string7 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"memoflag", (int)0) == 1) {
            bl5 = true;
            string7 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"memo", null);
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        for (String string8 : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
            if (!bl && !bl2 && !bl3 && !bl4 && !bl5) continue;
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(string8);
            if (bl) {
                pSDEField.setLogicName(string);
            }
            if (bl2) {
                pSDEField.setCodeName(string2);
            }
            if (bl3) {
                if (string3 != null) {
                    pSDEField.setPSDataTypeId(string3);
                    pSDEField.setPSDataTypeName(string4);
                }
                pSDEField.setLength(n);
                pSDEField.setPrecision2(n2);
            }
            if (bl4) {
                pSDEField.setPSCodeListId(string5);
                pSDEField.setPSCodeListName(string6);
            }
            if (bl5) {
                pSDEField.setMemo(string7);
            }
            pSDEFieldService.update(pSDEField, false);
        }
    }

    protected void batModifyDEViewCtrl(PSDEUAWizard pSDEUAWizard) throws Exception {
        String[] stringArray;
        if (StringHelper.isNullOrEmpty((String)pSDEUAWizard.getActionData())) {
            return;
        }
        boolean bl = false;
        String string = null;
        String string2 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"achandlerflag", (int)0) == 1) {
            bl = true;
            string = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"psachandlerid", null);
            string2 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"psachandlername", null);
        }
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        for (String string3 : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
            if (!bl) continue;
            PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
            pSDEViewCtrl.setPSDEViewCtrlId(string3);
            if (bl) {
                pSDEViewCtrl.setPSACHandlerId(string);
                pSDEViewCtrl.setPSACHandlerName(string2);
            }
            pSDEViewCtrlService.update(pSDEViewCtrl, false);
        }
    }

    protected void batModifyDE(PSDEUAWizard pSDEUAWizard) throws Exception {
        Object object;
        Object object2;
        if (StringHelper.isNullOrEmpty((String)pSDEUAWizard.getActionData())) {
            return;
        }
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        boolean bl = false;
        String string = null;
        String string2 = null;
        int n = 0;
        boolean bl2 = false;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"clonedeflag", (int)0) == 1) {
            JSONArray jSONArray;
            bl = true;
            string = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"psdeid", null);
            string2 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"WIZARDPARAM4", null);
            n = DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"defflag", (int)0);
            bl2 = DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"derflag", (int)0) == 1;
            object2 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            object = new PSDataEntity();
            ((PSDataEntityBase)object).setPSDataEntityId(string);
            pSDataEntityService.get((IEntity)object);
            Object object3 = null;
            if (n == 3) {
                object3 = new HashMap();
                if (!StringHelper.isNullOrEmpty((String)pSDEUAWizard.getWizardParam3())) {
                    jSONArray = JSONArray.fromString((String)pSDEUAWizard.getWizardParam3());
                    for (int i = 0; i < jSONArray.length(); ++i) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string3 = jSONObject.optString("id");
                        Object object4 = jSONObject.optString("name");
                        ((HashMap)object3).put(string3, object4);
                    }
                }
            }
            for (Object object4 : jSONArray = pSDEUAWizard.getActionData().split("[;]")) {
                Object object5;
                EntityBase entityBase;
                Object object6;
                Object object7;
                Object object8;
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId((String)object4);
                pSDataEntityService.get((IEntity)pSDataEntity);
                if (n > 0) {
                    object8 = ((PSDataEntityBase)object).getPSDEFields();
                    object7 = ((ArrayList)object8).iterator();
                    while (object7.hasNext()) {
                        object6 = object7.next();
                        if (n == 1 && (DataObject.getIntegerValue((Object)((PSDEFieldBase)object6).getPKey(), (Integer)0) != 0 || DataObject.getIntegerValue((Object)((PSDEFieldBase)object6).getMajorField(), (Integer)0) != 0) || !StringHelper.isNullOrEmpty((String)((PSDEFieldBase)object6).getPSDERId()) || object3 != null && !((HashMap)object3).containsKey(((PSDEFieldBase)object6).getPSDEFieldId())) continue;
                        entityBase = new PSDEField();
                        object6.copyTo((IDataObject)entityBase, false);
                        object2.removeUncopyValues((IEntity)entityBase, false);
                        entityBase.setPSDEId(pSDataEntity.getPSDataEntityId());
                        entityBase.setPSDEName(pSDataEntity.getPSDataEntityName());
                        entityBase.setValidFlag(1);
                        try {
                            ((PSCoreSysServiceBase)object2).create(entityBase, false);
                        }
                        catch (Exception exception) {
                            if (exception instanceof ErrorException && ((object5 = (ErrorException)((Object)exception)).getErrorCode() == 6 || object5.getErrorCode() == 7) || exception instanceof EntityException && ((object5 = (EntityException)exception).getErrorCode() == 6 || object5.getErrorCode() == 7)) continue;
                            throw exception;
                        }
                    }
                }
                if (!bl2) continue;
                object8 = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                object7 = ((PSDataEntityBase)object).getMinorPSDERs();
                object6 = ((ArrayList)object7).iterator();
                while (object6.hasNext()) {
                    Object object9;
                    entityBase = (PSDER)object6.next();
                    PSDER pSDER = new PSDER();
                    entityBase.copyTo((IDataObject)pSDER, false);
                    object8.removeUncopyValues((IEntity)pSDER, false);
                    pSDER.setMinorPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDER.setMinorPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDER.setValidFlag(1);
                    try {
                        object8.fillEntityKeyValue((IEntity)pSDER);
                        if (((PSCoreSysServiceBase)object8).checkKey(pSDER) == 1) {
                            object8.get((IEntity)pSDER);
                        } else {
                            ((PSCoreSysServiceBaseBase)((Object)object8)).create(pSDER);
                        }
                    }
                    catch (Exception exception) {
                        if (exception instanceof ErrorException && ((object9 = (ErrorException)((Object)exception)).getErrorCode() == 6 || object9.getErrorCode() == 6) || exception instanceof EntityException && ((object9 = (EntityException)exception).getErrorCode() == 6 || object9.getErrorCode() == 6)) continue;
                        throw exception;
                    }
                    object5 = ((PSDataEntityBase)object).getPSDEFields();
                    object9 = ((ArrayList)object5).iterator();
                    while (object9.hasNext()) {
                        PSDEField pSDEField = (PSDEField)object9.next();
                        if (StringHelper.compare((String)pSDEField.getPSDERId(), (String)entityBase.getPSDERId(), (boolean)false) != 0) continue;
                        PSDEField pSDEField2 = new PSDEField();
                        pSDEField.copyTo((IDataObject)pSDEField2, false);
                        object2.removeUncopyValues((IEntity)pSDEField2, false);
                        pSDEField2.setPSDEId(pSDataEntity.getPSDataEntityId());
                        pSDEField2.setPSDEName(pSDataEntity.getPSDataEntityName());
                        pSDEField2.setPSDERId(pSDER.getPSDERId());
                        pSDEField2.setPSDERName(pSDER.getPSDERName());
                        pSDEField2.setValidFlag(1);
                        try {
                            ((PSCoreSysServiceBase)object2).create(pSDEField2, false);
                        }
                        catch (Exception exception) {
                            ErrorException errorException;
                            if (exception instanceof ErrorException && ((errorException = (ErrorException)((Object)exception)).getErrorCode() == 6 || errorException.getErrorCode() == 6) || exception instanceof EntityException && ((errorException = (EntityException)exception).getErrorCode() == 6 || errorException.getErrorCode() == 6)) continue;
                            throw exception;
                        }
                    }
                }
            }
        }
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"saasmodeflag", (int)0) == 1) {
            object2 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"saasmode", null);
            for (String string4 : object = pSDEUAWizard.getActionData().split("[;]")) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(string4);
                if (StringHelper.isNullOrEmpty((String)object2)) {
                    pSDataEntity.setSaaSMode(null);
                } else {
                    pSDataEntity.setSaaSMode(Integer.parseInt((String)object2));
                }
                pSDataEntityService.update(pSDataEntity, false);
            }
        }
    }

    @Override
    protected void onGetDEMFCfg(PSDEUAWizard pSDEUAWizard) throws Exception {
        PSDataEntity pSDataEntity = new PSDataEntity();
        pSDataEntity.setSessionFactory(this.getSessionFactory());
        pSDataEntity.setPSDataEntityId(pSDEUAWizard.getPSUAWizardId());
        pSDataEntity.get();
        pSDEUAWizard.set("psdeid", pSDataEntity.getPSDataEntityId());
        pSDEUAWizard.set("psdename", pSDataEntity.getPSDataEntityName());
        pSDEUAWizard.set("ENAMULTIFORM", pSDataEntity.getEnaMultiForm());
        PSDEField pSDEField = new PSDEField();
        pSDEField.setSessionFactory(this.getSessionFactory());
        pSDEField.setPSDEId(pSDEUAWizard.getPSUAWizardId());
        pSDEField.setMultiFormField(1);
        if (pSDEField.select(true)) {
            pSDEUAWizard.set("psdefid", pSDEField.getPSDEFieldId());
            pSDEUAWizard.set("psdefname", pSDEField.getPSDEFieldName());
        }
    }

    @Override
    protected void onUpdateDEMFCfg(PSDEUAWizard pSDEUAWizard) throws Exception {
        PSDataEntity pSDataEntity = new PSDataEntity();
        pSDataEntity.setSessionFactory(this.getSessionFactory());
        pSDataEntity.setPSDataEntityId(pSDEUAWizard.getPSUAWizardId());
        pSDataEntity.set("ENAMULTIFORM", pSDEUAWizard.get("ENAMULTIFORM"));
        pSDataEntity.update();
        String string = DataObject.getStringValue((Object)pSDEUAWizard.get("psdefid"));
        PSDEField pSDEField = new PSDEField();
        pSDEField.setSessionFactory(this.getSessionFactory());
        pSDEField.setPSDEId(pSDEUAWizard.getPSUAWizardId());
        pSDEField.setMultiFormField(1);
        if (pSDEField.select(true)) {
            if (StringHelper.compare((String)pSDEField.getPSDEFieldId(), (String)string, (boolean)false) != 0) {
                PSDEField pSDEField2 = new PSDEField();
                pSDEField2.setSessionFactory(this.getSessionFactory());
                pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
                pSDEField2.setMultiFormField(0);
                pSDEField2.update();
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    pSDEField.reset();
                    pSDEField.setSessionFactory(this.getSessionFactory());
                    pSDEField.setPSDEFieldId(string);
                    pSDEField.setMultiFormField(1);
                    pSDEField.update();
                }
            }
        } else if (!StringHelper.isNullOrEmpty((String)string)) {
            pSDEField.reset();
            pSDEField.setSessionFactory(this.getSessionFactory());
            pSDEField.setPSDEFieldId(string);
            pSDEField.setMultiFormField(1);
            pSDEField.update();
        }
        this.onGetDEMFCfg(pSDEUAWizard);
    }

    protected void batModifySysLanRes(PSDEUAWizard pSDEUAWizard) throws Exception {
        String[] stringArray;
        if (StringHelper.isNullOrEmpty((String)pSDEUAWizard.getActionData())) {
            return;
        }
        boolean bl = false;
        boolean bl2 = true;
        String string = null;
        String string2 = null;
        if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"moduleflag", (int)0) == 1) {
            bl = true;
            string = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"psmoduleid", null);
            string2 = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"psmodulename", null);
            if (DataObject.getIntegerValue((IDataObject)pSDEUAWizard, (String)"ignoreexistmoduleflag", (int)1) == 1) {
                bl2 = true;
            }
        }
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        for (String string3 : stringArray = pSDEUAWizard.getActionData().split("[;]")) {
            if (!bl) continue;
            PSLanguageRes pSLanguageRes = new PSLanguageRes();
            pSLanguageRes.setPSLanguageResId(string3);
            if (bl2 && (!pSLanguageResService.get((IEntity)pSLanguageRes, true) || !StringHelper.isNullOrEmpty((String)pSLanguageRes.getPSModuleId()))) continue;
            if (bl) {
                pSLanguageRes.setPSModuleId(string);
                pSLanguageRes.setPSModuleName(string2);
            }
            pSLanguageResService.update(pSLanguageRes, false);
        }
    }
}

