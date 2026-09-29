/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectFilter
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectFieldFilter
 *  net.ibizsys.paas.db.SelectGroupFilter
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.demodel.ISqlCommandModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSBackService;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSCounter;
import net.ibizsys.pscore.srv.config.entity.PSCounterBase;
import net.ibizsys.pscore.srv.config.entity.PSCounterType;
import net.ibizsys.pscore.srv.config.entity.PSCounterTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSCssCatTempl;
import net.ibizsys.pscore.srv.config.entity.PSCssCatTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSCssTempl;
import net.ibizsys.pscore.srv.config.entity.PSCssTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFunc;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFuncBase;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.config.entity.PSDEDQPDCond;
import net.ibizsys.pscore.srv.config.entity.PSDEDQPDCondBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinType;
import net.ibizsys.pscore.srv.config.entity.PSEditorStyle;
import net.ibizsys.pscore.srv.config.entity.PSEditorStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSEditorTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.entity.PSImageTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.entity.PSLanguageBase;
import net.ibizsys.pscore.srv.config.entity.PSPDTAppFunc;
import net.ibizsys.pscore.srv.config.entity.PSPDTAppFuncBase;
import net.ibizsys.pscore.srv.config.entity.PSPDTView;
import net.ibizsys.pscore.srv.config.entity.PSPDTViewBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginType;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPortlet;
import net.ibizsys.pscore.srv.config.entity.PSPortletBase;
import net.ibizsys.pscore.srv.config.entity.PSPortletType;
import net.ibizsys.pscore.srv.config.entity.PSPortletTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSSAHandler;
import net.ibizsys.pscore.srv.config.entity.PSSAHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSFACHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandler;
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVerBase;
import net.ibizsys.pscore.srv.config.entity.PSSampleValue;
import net.ibizsys.pscore.srv.config.entity.PSSampleValueBase;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSysLanItem;
import net.ibizsys.pscore.srv.config.entity.PSSysLanResBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysTBItem;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbarBase;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.entity.PSSysUIActionBase;
import net.ibizsys.pscore.srv.config.entity.PSVTCatDetail;
import net.ibizsys.pscore.srv.config.entity.PSVTCatDetailBase;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.entity.PSValueRuleBase;
import net.ibizsys.pscore.srv.config.entity.PSVarType;
import net.ibizsys.pscore.srv.config.entity.PSVarTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCat;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCatBase;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSBackServiceService;
import net.ibizsys.pscore.srv.config.service.PSCodeListTemplService;
import net.ibizsys.pscore.srv.config.service.PSCounterService;
import net.ibizsys.pscore.srv.config.service.PSCounterTypeService;
import net.ibizsys.pscore.srv.config.service.PSCssCatTemplService;
import net.ibizsys.pscore.srv.config.service.PSCssTemplService;
import net.ibizsys.pscore.srv.config.service.PSDBValueFuncService;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.config.service.PSDEDQPDCondService;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService;
import net.ibizsys.pscore.srv.config.service.PSEditorStyleService;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSImageTemplService;
import net.ibizsys.pscore.srv.config.service.PSLanguageService;
import net.ibizsys.pscore.srv.config.service.PSPDTAppFuncService;
import net.ibizsys.pscore.srv.config.service.PSPDTViewService;
import net.ibizsys.pscore.srv.config.service.PSPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSPFPluginTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFPluginTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSPortletService;
import net.ibizsys.pscore.srv.config.service.PSPortletTypeService;
import net.ibizsys.pscore.srv.config.service.PSSAHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFACHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFSAHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.config.service.PSSampleValueService;
import net.ibizsys.pscore.srv.config.service.PSSysACHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSysLanItemService;
import net.ibizsys.pscore.srv.config.service.PSSysLanResService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSysToolbarService;
import net.ibizsys.pscore.srv.config.service.PSSysUIActionService;
import net.ibizsys.pscore.srv.config.service.PSVTCatDetailService;
import net.ibizsys.pscore.srv.config.service.PSValueRuleService;
import net.ibizsys.pscore.srv.config.service.PSVarTypeService;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeCatService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterPF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterPFBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserRecent;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSAHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSAHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolder;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderService;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSRTHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.xml.CodeItemConfig;
import net.ibizsys.pscore.srv.xml.CodeListConfig;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSystemService
extends PSSystemServiceBase {
    private static final String CURSYSTEMID = "SRFCURSYSTEMID";
    private static HashMap<String, String> defaultPSDEOPPrivMap = new HashMap();
    private static final Log log;

    public boolean get(PSSystem pSSystem, boolean bl) throws Exception {
        String string = pSSystem.getPSSystemId();
        if (StringHelper.compare((String)string, (String)CURSYSTEMID, (boolean)true) == 0) {
            string = this.getWebContext().getAppDataValue("pssystemid");
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u7cfb\u7edf\u6807\u8bc6"));
            }
            pSSystem.setPSSystemId(string);
        }
        return super.get(pSSystem, bl);
    }

    @Override
    protected void onInitModel(PSSystem pSSystem) throws Exception {
        super.onInitModel(pSSystem);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        this.initPSLanguage();
        this.initPSLanguageRes(pSSystem, hashMap);
        this.initPSVarType();
        this.initPSDEJoinType();
        this.initPSDEDQPDCond();
        this.initPSDBValueOP();
        this.initPSEditorType();
        this.initPSAppType();
        this.initPSSF();
        this.initPSPF();
        this.initPSSAHandler();
        this.initPSSysACHandler();
        this.initPSCounterType();
        this.initPSPFPluginType();
        this.initPSPortletType();
        this.initPSBackService();
        this.initPSPDTAppFunc();
        this.initPSDBValueFunc(pSSystem);
        this.initPSDEOPPriv(pSSystem, hashMap);
        this.initPSCodeListTempl(pSSystem);
        this.initPSSysImages(pSSystem, hashMap);
        this.initPSSysCssCats(pSSystem);
        this.initPSSysCsses(pSSystem);
        this.initPSSysValueRules(pSSystem);
        this.initPSDEUIActions(pSSystem, hashMap);
        this.initPSDEToolbars(pSSystem, hashMap);
        this.initPSSysSAHandlers(pSSystem);
        this.initPSACHandlers(pSSystem);
        this.initPSSysPDTViews(pSSystem);
        this.initPSSysPFPlugins(pSSystem, hashMap);
        this.initPSSysEditorStyles(pSSystem);
        this.initPSSysCounters(pSSystem);
        this.initPSSysPortlets(pSSystem, hashMap);
        this.initPSSysSampleValues(pSSystem);
    }

    protected void initPSVarType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSVarTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSVarType> hashMap = new HashMap<String, PSVarType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSVarTypeBase)serializable).getPSVarTypeId(), (PSVarType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSVarTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSVarType pSVarType = (PSVarType)iterator.next();
                if (hashMap.containsKey(pSVarType.getPSVarTypeId())) continue;
                EntityBase.setIgnoreCheck(pSVarType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSVarType, (boolean)true);
                iService.create(pSVarType);
                hashMap.put(pSVarType.getPSVarTypeId(), pSVarType);
                arrayList.add(pSVarType);
            }
        }
    }

    protected void initPSBackService() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSBackServiceService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            IService iService2 = ServiceGlobal.getService(PSBackServiceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList arrayList2 = iService2.select((ISelectCond)selectCond);
            for (Object item : arrayList2) {
                PSBackService pSBackService = (PSBackService)item;
                iService.save(pSBackService);
            }
        }
    }

    protected void initPSDEJoinType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDEJoinTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            IService iService2 = ServiceGlobal.getService(PSDEJoinTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList arrayList = iService2.select((ISelectCond)selectCond);
            for (Object item : arrayList) {
                PSDEJoinType pSDEJoinType = (PSDEJoinType)item;
                EntityBase.setIgnoreCheck(pSDEJoinType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSDEJoinType, (boolean)true);
                iService.save(pSDEJoinType);
            }
        }
    }

    protected void initPSDEDQPDCond() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDEDQPDCondService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDEDQPDCond> hashMap = new HashMap<String, PSDEDQPDCond>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSDEDQPDCondBase)serializable).getPSDEDQPDCondId(), (PSDEDQPDCond)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDEDQPDCondService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDEDQPDCond pSDEDQPDCond = (PSDEDQPDCond)iterator.next();
                if (hashMap.containsKey(pSDEDQPDCond.getPSDEDQPDCondId())) continue;
                EntityBase.setIgnoreCheck(pSDEDQPDCond, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSDEDQPDCond, (boolean)true);
                iService.create(pSDEDQPDCond);
                hashMap.put(pSDEDQPDCond.getPSDEDQPDCondId(), pSDEDQPDCond);
                arrayList.add(pSDEDQPDCond);
            }
        }
    }

    protected void initPSDBValueOP() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDBValueOP> hashMap = new HashMap<String, PSDBValueOP>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSDBValueOPBase)serializable).getPSDBValueOPId(), (PSDBValueOP)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDBValueOP pSDBValueOP = (PSDBValueOP)iterator.next();
                EntityBase.setIgnoreCheck(pSDBValueOP, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSDBValueOP, (boolean)true);
                if (!hashMap.containsKey(pSDBValueOP.getPSDBValueOPId())) {
                    iService.create(pSDBValueOP, false);
                } else {
                    iService.update(pSDBValueOP, false);
                }
                hashMap.put(pSDBValueOP.getPSDBValueOPId(), pSDBValueOP);
                arrayList.add(pSDBValueOP);
            }
        }
    }

    protected void initPSDEFDataType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDEFDataType> hashMap = new HashMap<String, PSDEFDataType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSDEFDataTypeBase)serializable).getPSDEFDataTypeId(), (PSDEFDataType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDEFDataType pSDEFDataType = (PSDEFDataType)iterator.next();
                EntityBase.setIgnoreCheck(pSDEFDataType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSDEFDataType, (boolean)true);
                if (!hashMap.containsKey(pSDEFDataType.getPSDEFDataTypeId())) {
                    iService.create(pSDEFDataType, false);
                } else {
                    iService.update(pSDEFDataType, false);
                }
                hashMap.put(pSDEFDataType.getPSDEFDataTypeId(), pSDEFDataType);
                arrayList.add(pSDEFDataType);
            }
        }
    }

    protected void initPSEditorType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSEditorType> hashMap = new HashMap<String, PSEditorType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSEditorTypeBase)serializable).getPSEditorTypeId(), (PSEditorType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSEditorType pSEditorType = (PSEditorType)iterator.next();
                EntityBase.setIgnoreCheck(pSEditorType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSEditorType, (boolean)true);
                if (!hashMap.containsKey(pSEditorType.getPSEditorTypeId())) {
                    iService.create(pSEditorType, false);
                } else {
                    iService.update(pSEditorType, false);
                }
                hashMap.put(pSEditorType.getPSEditorTypeId(), pSEditorType);
                arrayList.add(pSEditorType);
            }
        }
    }

    protected void initPSPFPluginType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPFPluginTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPFPluginType> hashMap = new HashMap<String, PSPFPluginType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSPFPluginTypeBase)serializable).getPSPFPluginTypeId(), (PSPFPluginType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPFPluginTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPFPluginType pSPFPluginType = (PSPFPluginType)iterator.next();
                EntityBase.setIgnoreCheck(pSPFPluginType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSPFPluginType, (boolean)true);
                if (!hashMap.containsKey(pSPFPluginType.getPSPFPluginTypeId())) {
                    iService.create(pSPFPluginType, false);
                } else {
                    iService.update(pSPFPluginType, false);
                }
                hashMap.put(pSPFPluginType.getPSPFPluginTypeId(), pSPFPluginType);
                arrayList.add(pSPFPluginType);
            }
        }
    }

    protected void initPSPortletType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPortletTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPortletType> hashMap = new HashMap<String, PSPortletType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSPortletTypeBase)serializable).getPSPortletTypeId(), (PSPortletType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPortletTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPortletType pSPortletType = (PSPortletType)iterator.next();
                EntityBase.setIgnoreCheck(pSPortletType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSPortletType, (boolean)true);
                if (!hashMap.containsKey(pSPortletType.getPSPortletTypeId())) {
                    iService.create(pSPortletType, false);
                } else {
                    iService.update(pSPortletType, false);
                }
                hashMap.put(pSPortletType.getPSPortletTypeId(), pSPortletType);
                arrayList.add(pSPortletType);
            }
        }
    }

    protected void initPSSF() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSF> hashMap = new HashMap<String, PSSF>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSSFBase)serializable).getPSSFId(), (PSSF)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSF pSSF = (PSSF)iterator.next();
                EntityBase.setIgnoreCheck(pSSF, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSSF, (boolean)true);
                if (!hashMap.containsKey(pSSF.getPSSFId())) {
                    iService.create(pSSF, false);
                } else {
                    iService.update(pSSF, false);
                }
                hashMap.put(pSSF.getPSSFId(), pSSF);
                arrayList.add(pSSF);
            }
        }
    }

    protected void initPSSFStyle(PSSystem pSSystem) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSFStyle> hashMap = new HashMap<String, PSSFStyle>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSSFStyleBase)serializable).getPSSFStyleId(), (PSSFStyle)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSFStyle pSSFStyle = (PSSFStyle)iterator.next();
                if (!StringHelper.isNullOrEmpty((String)pSSFStyle.getPSDevCenterId()) && StringHelper.compare((String)pSSFStyle.getPSDevCenterId(), (String)pSSystem.getPSDevCenterId(), (boolean)true) != 0) continue;
                EntityBase.setIgnoreCheck(pSSFStyle, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSSFStyle, (boolean)true);
                if (!hashMap.containsKey(pSSFStyle.getPSSFStyleId())) {
                    iService.create(pSSFStyle, false);
                } else {
                    iService.update(pSSFStyle, false);
                }
                hashMap.put(pSSFStyle.getPSSFStyleId(), pSSFStyle);
                arrayList.add(pSSFStyle);
            }
        }
    }

    protected void initPSSFStyleVer(PSSystem pSSystem) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVCENTERID", (Object)pSSystem.getPSDevCenterId());
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSFStyleVer> hashMap = new HashMap<String, PSSFStyleVer>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSSFStyleVerBase)serializable).getPSSFStyleVerId(), (PSSFStyleVer)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            selectCond.set("PSDEVCENTERID", (Object)pSSystem.getPSDevCenterId());
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSFStyleVer pSSFStyleVer = (PSSFStyleVer)iterator.next();
                if (!StringHelper.isNullOrEmpty((String)pSSFStyleVer.getPSDevCenterId()) && StringHelper.compare((String)pSSFStyleVer.getPSDevCenterId(), (String)pSSystem.getPSDevCenterId(), (boolean)true) != 0) continue;
                EntityBase.setIgnoreCheck(pSSFStyleVer, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSSFStyleVer, (boolean)true);
                if (!hashMap.containsKey(pSSFStyleVer.getPSSFStyleVerId())) {
                    iService.create(pSSFStyleVer, false);
                } else {
                    iService.update(pSSFStyleVer, false);
                }
                hashMap.put(pSSFStyleVer.getPSSFStyleVerId(), pSSFStyleVer);
                arrayList.add(pSSFStyleVer);
            }
        }
    }

    protected void initPSPF() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPF> hashMap = new HashMap<String, PSPF>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSPFBase)serializable).getPSPFId(), (PSPF)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPF pSPF = (PSPF)iterator.next();
                EntityBase.setIgnoreCheck(pSPF, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSPF, (boolean)true);
                if (!hashMap.containsKey(pSPF.getPSPFId())) {
                    iService.create(pSPF, false);
                } else {
                    iService.update(pSPF, false);
                }
                hashMap.put(pSPF.getPSPFId(), pSPF);
                arrayList.add(pSPF);
            }
        }
    }

    protected void initPSPFStyle(PSSystem pSSystem) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPFStyle> hashMap = new HashMap<String, PSPFStyle>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSPFStyleBase)serializable).getPSPFStyleId(), (PSPFStyle)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPFStyle pSPFStyle = (PSPFStyle)iterator.next();
                if (!StringHelper.isNullOrEmpty((String)pSPFStyle.getPSDevCenterId()) && StringHelper.compare((String)pSPFStyle.getPSDevCenterId(), (String)pSSystem.getPSDevCenterId(), (boolean)true) != 0) continue;
                pSPFStyle.setTemplPSPFStyleId(null);
                pSPFStyle.setTemplPSPFStyleName(null);
                EntityBase.setIgnoreCheck(pSPFStyle, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSPFStyle, (boolean)true);
                if (!hashMap.containsKey(pSPFStyle.getPSPFStyleId())) {
                    iService.create(pSPFStyle, false);
                } else {
                    iService.update(pSPFStyle, false);
                }
                hashMap.put(pSPFStyle.getPSPFStyleId(), pSPFStyle);
                arrayList.add(pSPFStyle);
            }
        }
    }

    protected void initPSDevCenterPF(PSSystem pSSystem) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDevCenterPFService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVCENTERID", (Object)pSSystem.getPSDevCenterId());
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDevCenterPF> hashMap = new HashMap<String, PSDevCenterPF>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSDevCenterPFBase)serializable).getPSDevCenterPFId(), (PSDevCenterPF)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDevCenterPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            selectCond.set("PSDEVCENTERID", (Object)pSSystem.getPSDevCenterId());
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDevCenterPF pSDevCenterPF = (PSDevCenterPF)iterator.next();
                EntityBase.setIgnoreCheck(pSDevCenterPF, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSDevCenterPF, (boolean)true);
                if (!hashMap.containsKey(pSDevCenterPF.getPSDevCenterPFId())) {
                    iService.create(pSDevCenterPF, false);
                } else {
                    iService.update(pSDevCenterPF, false);
                }
                hashMap.put(pSDevCenterPF.getPSDevCenterPFId(), pSDevCenterPF);
                arrayList.add(pSDevCenterPF);
            }
        }
    }

    protected void initPSAppType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSAppType> hashMap = new HashMap<String, PSAppType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSAppTypeBase)serializable).getPSAppTypeId(), (PSAppType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSAppType pSAppType = (PSAppType)iterator.next();
                EntityBase.setIgnoreCheck(pSAppType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSAppType, (boolean)true);
                if (hashMap.containsKey(pSAppType.getPSAppTypeId())) continue;
                iService.create(pSAppType);
                hashMap.put(pSAppType.getPSAppTypeId(), pSAppType);
                arrayList.add(pSAppType);
            }
        }
    }

    protected void initPSSAHandler() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSAHandler> hashMap = new HashMap<String, PSSAHandler>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSSAHandlerBase)serializable).getPSSAHandlerId(), (PSSAHandler)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSAHandlerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSAHandler pSSAHandler = (PSSAHandler)iterator.next();
                EntityBase.setIgnoreCheck(pSSAHandler, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSSAHandler, (boolean)true);
                if (hashMap.containsKey(pSSAHandler.getPSSAHandlerId())) continue;
                iService.create(pSSAHandler);
                hashMap.put(pSSAHandler.getPSSAHandlerId(), pSSAHandler);
                arrayList.add(pSSAHandler);
            }
        }
    }

    protected void initPSSysACHandler() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSysACHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSysACHandler> hashMap = new HashMap<String, PSSysACHandler>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSSysACHandlerBase)serializable).getPSSysACHandlerId(), (PSSysACHandler)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSysACHandlerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSysACHandler pSSysACHandler = (PSSysACHandler)iterator.next();
                EntityBase.setIgnoreCheck(pSSysACHandler, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSSysACHandler, (boolean)true);
                if (hashMap.containsKey(pSSysACHandler.getPSSysACHandlerId())) continue;
                iService.create(pSSysACHandler);
                hashMap.put(pSSysACHandler.getPSSysACHandlerId(), pSSysACHandler);
                arrayList.add(pSSysACHandler);
            }
        }
    }

    protected void initPSSysSAHandlers(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSFSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSSFSAHandler> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSSFSAHandler> hashMap = new HashMap<String, PSSFSAHandler>();
        for (PSSFSAHandler handler : arrayList) {
            hashMap.put(handler.getPSSFSAHandlerId(), handler);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSFSAHandlerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList<PSSFSAHandler> handlers = iService.select((ISelectCond)selectCond);
            for (PSSFSAHandler handler : handlers) {
                iService2.save(handler);
                hashMap.put(handler.getPSSFSAHandlerId(), handler);
            }
        }
        iService = (PSSysSAHandlerService)ServiceGlobal.getService(PSSysSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSFSAHANDLERID");
        HashMap<String, PSSysSAHandler> existing = new HashMap<String, PSSysSAHandler>();
        for (PSSysSAHandler handler : (ArrayList<PSSysSAHandler>)iService.select((ISelectCond)selectCond)) {
            existing.put(handler.getPSSysSAHandlerId(), handler);
            if (StringHelper.isNullOrEmpty((String)handler.getPSSFSAHandlerId())) continue;
            existing.put(handler.getPSSFSAHandlerId(), handler);
        }
        for (PSSFSAHandler handler : hashMap.values()) {
            String string2;
            if (StringHelper.compare((String)handler.getPSSFId(), (String)pSSystem.getPSSFId(), (boolean)false) != 0 || existing.containsKey(handler.getPSSFSAHandlerId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)handler.getPSSFSAHandlerId()))) continue;
            this.initPSSysSAHandler(pSSystem, handler);
        }
    }

    protected void initPSSysSAHandler(PSSystem pSSystem, PSSFSAHandler pSSFSAHandler) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysSAHandlerService pSSysSAHandlerService = (PSSysSAHandlerService)ServiceGlobal.getService(PSSysSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        PSSysSAHandler pSSysSAHandler = new PSSysSAHandler();
        pSSFSAHandler.copyTo((IDataObject)pSSysSAHandler, false);
        pSSysSAHandler.setPSSysSAHandlerId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSFSAHandler.getPSSFSAHandlerId()));
        pSSysSAHandler.setPSSysSAHandlerName(pSSFSAHandler.getPSSFSAHandlerName());
        pSSysSAHandler.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSAHandler.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysSAHandler, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysSAHandler, (boolean)true);
        pSSysSAHandlerService.create(pSSysSAHandler);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysSAHandlerService.getDEModel().getLogicName(), (Object)pSSysSAHandlerService.getDEModel().getDataInfo(pSSysSAHandler)));
    }

    protected void initPSACHandlers(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSSFACHandler> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSSFACHandler> hashMap = new HashMap<String, PSSFACHandler>();
        for (PSSFACHandler handler : arrayList) {
            hashMap.put(handler.getPSSFACHandlerId(), handler);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList<PSSFACHandler> handlers = iService.select((ISelectCond)selectCond);
            for (PSSFACHandler handler : handlers) {
                EntityBase.setIgnoreCheck(handler, (boolean)true);
                EntityBase.setIgnoreCheckKey(handler, (boolean)true);
                iService2.save(handler);
                hashMap.put(handler.getPSSFACHandlerId(), handler);
                arrayList.add(handler);
            }
        }
        iService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSFACHANDLERID");
        HashMap<String, PSACHandler> existing = new HashMap<String, PSACHandler>();
        for (PSACHandler handler : (ArrayList<PSACHandler>)iService.select((ISelectCond)selectCond)) {
            existing.put(handler.getPSACHandlerId(), handler);
            if (StringHelper.isNullOrEmpty((String)handler.getPSSFACHandlerId())) continue;
            existing.put(handler.getPSSFACHandlerId(), handler);
        }
        for (PSSFACHandler handler : arrayList) {
            String string2;
            if (StringHelper.compare((String)handler.getPSSFId(), (String)pSSystem.getPSSFId(), (boolean)false) != 0 || existing.containsKey(handler.getPSSFACHandlerId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)handler.getPSSFACHandlerId()))) continue;
            this.initPSACHandler(pSSystem, handler);
        }
    }

    protected void initPSACHandler(PSSystem pSSystem, PSSFACHandler pSSFACHandler) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        PSACHandler pSACHandler = new PSACHandler();
        pSSFACHandler.copyTo((IDataObject)pSACHandler, false);
        pSACHandler.setPSACHandlerId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSFACHandler.getPSSFACHandlerId()));
        pSACHandler.setPSACHandlerName(pSSFACHandler.getPSSFACHandlerName());
        pSACHandler.setPSSystemId(pSSystem.getPSSystemId());
        pSACHandler.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSACHandler, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSACHandler, (boolean)true);
        if (pSACHandlerService.checkKey(pSACHandler) == 0) {
            pSACHandlerService.create(pSACHandler);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSACHandlerService.getDEModel().getLogicName(), (Object)pSACHandlerService.getDEModel().getDataInfo(pSACHandler)));
        }
    }

    protected void initPSViewType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSViewType> hashMap = new HashMap<String, PSViewType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSViewTypeBase)serializable).getPSViewTypeId(), (PSViewType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSViewType pSViewType = (PSViewType)iterator.next();
                EntityBase.setIgnoreCheck(pSViewType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSViewType, (boolean)true);
                if (!hashMap.containsKey(pSViewType.getPSViewTypeId())) {
                    iService.create(pSViewType);
                    hashMap.put(pSViewType.getPSViewTypeId(), pSViewType);
                    arrayList.add(pSViewType);
                    continue;
                }
                iService.update(pSViewType);
                hashMap.put(pSViewType.getPSViewTypeId(), pSViewType);
                arrayList.add(pSViewType);
            }
        }
    }

    protected void initPSViewTypeCat() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSViewTypeCatService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSViewTypeCat> hashMap = new HashMap<String, PSViewTypeCat>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSViewTypeCatBase)serializable).getPSViewTypeCatId(), (PSViewTypeCat)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSViewTypeCatService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSViewTypeCat pSViewTypeCat = (PSViewTypeCat)iterator.next();
                EntityBase.setIgnoreCheck(pSViewTypeCat, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSViewTypeCat, (boolean)true);
                if (!hashMap.containsKey(pSViewTypeCat.getPSViewTypeCatId())) {
                    iService.create(pSViewTypeCat);
                    hashMap.put(pSViewTypeCat.getPSViewTypeCatId(), pSViewTypeCat);
                    arrayList.add(pSViewTypeCat);
                    continue;
                }
                iService.update(pSViewTypeCat);
                hashMap.put(pSViewTypeCat.getPSViewTypeCatId(), pSViewTypeCat);
                arrayList.add(pSViewTypeCat);
            }
        }
    }

    protected void initPSVTCatDetail() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSVTCatDetailService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSVTCatDetail> hashMap = new HashMap<String, PSVTCatDetail>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSVTCatDetailBase)serializable).getPSVTCatDetailId(), (PSVTCatDetail)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSVTCatDetailService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSVTCatDetail pSVTCatDetail = (PSVTCatDetail)iterator.next();
                EntityBase.setIgnoreCheck(pSVTCatDetail, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSVTCatDetail, (boolean)true);
                if (!hashMap.containsKey(pSVTCatDetail.getPSVTCatDetailId())) {
                    iService.create(pSVTCatDetail);
                    hashMap.put(pSVTCatDetail.getPSVTCatDetailId(), pSVTCatDetail);
                    arrayList.add(pSVTCatDetail);
                    continue;
                }
                iService.update(pSVTCatDetail);
                hashMap.put(pSVTCatDetail.getPSVTCatDetailId(), pSVTCatDetail);
                arrayList.add(pSVTCatDetail);
            }
        }
    }

    protected void initPSDEUIActions(PSSystem pSSystem, Map<String, String> map) throws Exception {
        IService iService;
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSSysUIAction> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSSysUIAction> hashMap = new HashMap<String, PSSysUIAction>();
        for (PSSysUIAction action : arrayList) {
            hashMap.put(action.getPSSysUIActionId(), action);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSSysUIAction action : (ArrayList<PSSysUIAction>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(action, (boolean)true);
                EntityBase.setIgnoreCheckKey(action, (boolean)true);
                if (!hashMap.containsKey(action.getPSSysUIActionId())) {
                    iService2.create(action);
                    hashMap.put(action.getPSSysUIActionId(), action);
                    arrayList.add(action);
                    continue;
                }
                PSSysUIAction entityBase2 = hashMap.get(action.getPSSysUIActionId());
                boolean bl = false;
                if (StringHelper.isNullOrEmpty((String)entityBase2.getCapPSSysLanResId()) && !StringHelper.isNullOrEmpty((String)action.getCapPSSysLanResId())) {
                    bl = true;
                    entityBase2.setCapPSSysLanResId(action.getCapPSSysLanResId());
                }
                if (StringHelper.isNullOrEmpty((String)entityBase2.getTipPSSysLanResId()) && !StringHelper.isNullOrEmpty((String)action.getTipPSSysLanResId())) {
                    bl = true;
                    entityBase2.setTipPSSysLanResId(action.getTipPSSysLanResId());
                }
                if (!bl) continue;
                iService2.update(entityBase2);
                hashMap.put(action.getPSSysUIActionId(), entityBase2);
                arrayList.add(entityBase2);
            }
        }
        iService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSYSUIACTIONID");
        HashMap<String, PSDEUIAction> existing = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction entityBase2 : (ArrayList<PSDEUIAction>)iService.select((ISelectCond)selectCond)) {
            existing.put(entityBase2.getPSDEUIActionId(), entityBase2);
            if (StringHelper.isNullOrEmpty((String)entityBase2.getPSSysUIActionId())) continue;
            existing.put(entityBase2.getPSSysUIActionId(), entityBase2);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSUIACTION", (Object)entityBase2.getPSSysUIActionId()), entityBase2.getPSDEUIActionId());
        }
        for (PSSysUIAction entityBase2 : arrayList) {
            String string2;
            if (existing.containsKey(entityBase2.getPSSysUIActionId())) continue;
            String string3 = KeyValueHelper.genUniqueId((String)string, (String)entityBase2.getPSSysUIActionId());
            if (!existing.containsKey(string3)) {
                this.initPSDEUIAction(pSSystem, entityBase2, map);
                map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSUIACTION", (Object)entityBase2.getPSSysUIActionId()), string3);
                continue;
            }
            PSDEUIAction pSDEUIAction = existing.get(string3);
            boolean bl = false;
            if (StringHelper.isNullOrEmpty((String)pSDEUIAction.getCapPSLanResId()) && !StringHelper.isNullOrEmpty((String)entityBase2.getCapPSSysLanResId())) {
                bl = true;
                string2 = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSLANRES", (Object)entityBase2.getCapPSSysLanResId()));
                pSDEUIAction.setCapPSLanResId(string2);
            }
            if (StringHelper.isNullOrEmpty((String)pSDEUIAction.getTipPSLanResId()) && !StringHelper.isNullOrEmpty((String)entityBase2.getTipPSSysLanResId())) {
                bl = true;
                string2 = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSLANRES", (Object)entityBase2.getTipPSSysLanResId()));
                pSDEUIAction.setTipPSLanResId(string2);
            }
            if (!bl) continue;
            iService.update(pSDEUIAction);
        }
    }

    protected void initPSDEUIAction(PSSystem pSSystem, PSSysUIAction pSSysUIAction, Map<String, String> map) throws Exception {
        String string;
        String string2 = pSSystem.getPSSystemId();
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEUIAction pSDEUIAction = new PSDEUIAction();
        pSSysUIAction.copyTo((IDataObject)pSDEUIAction, false);
        pSDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSysUIAction.getPSSysUIActionId()));
        pSDEUIAction.setPSDEUIActionName(pSSysUIAction.getPSSysUIActionName());
        pSDEUIAction.setPSSystemId(pSSystem.getPSSystemId());
        pSDEUIAction.setPSSystemName(pSSystem.getPSSystemName());
        pSDEUIAction.setUIActionType("SYS");
        pSDEUIAction.setTemplMode(1);
        if (!StringHelper.isNullOrEmpty((String)pSSysUIAction.getPSImageTemplId())) {
            string = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSIMAGETEMPL", (Object)pSSysUIAction.getPSImageTemplId()));
            pSDEUIAction.setPSSysImageId(string);
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUIAction.getCapPSSysLanResId())) {
            string = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSLANRES", (Object)pSSysUIAction.getCapPSSysLanResId()));
            pSDEUIAction.setCapPSLanResId(string);
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUIAction.getTipPSSysLanResId())) {
            string = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSLANRES", (Object)pSSysUIAction.getTipPSSysLanResId()));
            pSDEUIAction.setTipPSLanResId(string);
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUIAction.getDEOPPriv()) && !StringHelper.isNullOrEmpty((String)(string = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSDEOPPRIV", (Object)pSSysUIAction.getDEOPPriv()))))) {
            PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSDEOPPrivId(string);
            if (pSDEOPPrivService.get(pSDEOPPriv, true)) {
                pSDEUIAction.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
                pSDEUIAction.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
            }
        }
        EntityBase.setIgnoreCheck(pSDEUIAction, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSDEUIAction, (boolean)true);
        pSDEUIActionService.create(pSDEUIAction);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSDEUIActionService.getDEModel().getLogicName(), (Object)pSDEUIActionService.getDEModel().getDataInfo(pSDEUIAction)));
    }

    protected void initPSSysValueRules(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSValueRule> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSValueRule> hashMap = new HashMap<String, PSValueRule>();
        for (PSValueRule rule : arrayList) {
            hashMap.put(rule.getPSValueRuleId(), rule);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSValueRule rule : (ArrayList<PSValueRule>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(rule, (boolean)true);
                EntityBase.setIgnoreCheckKey(rule, (boolean)true);
                if (hashMap.containsKey(rule.getPSValueRuleId())) continue;
                iService2.create(rule);
                hashMap.put(rule.getPSValueRuleId(), rule);
                arrayList.add(rule);
            }
        }
        iService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSVALUERULEID");
        HashMap<String, PSSysValueRule> existing = new HashMap<String, PSSysValueRule>();
        for (PSSysValueRule rule : (ArrayList<PSSysValueRule>)iService.select((ISelectCond)selectCond)) {
            existing.put(rule.getPSSysValueRuleId(), rule);
            if (StringHelper.isNullOrEmpty((String)rule.getPSValueRuleId())) continue;
            existing.put(rule.getPSValueRuleId(), rule);
        }
        for (PSValueRule rule : arrayList) {
            String string2;
            if (existing.containsKey(rule.getPSValueRuleId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)rule.getPSValueRuleId()))) continue;
            this.initPSSysValueRule(pSSystem, rule);
        }
    }

    protected void initPSSysValueRule(PSSystem pSSystem, PSValueRule pSValueRule) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        PSSysValueRule pSSysValueRule = new PSSysValueRule();
        pSValueRule.copyTo((IDataObject)pSSysValueRule, false);
        pSSysValueRule.setPSSysValueRuleId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSValueRule.getPSValueRuleId()));
        pSSysValueRule.setPSSysValueRuleName(pSValueRule.getPSValueRuleName());
        pSSysValueRule.setPSSystemId(pSSystem.getPSSystemId());
        pSSysValueRule.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysValueRule, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysValueRule, (boolean)true);
        pSSysValueRuleService.create(pSSysValueRule);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysValueRuleService.getDEModel().getLogicName(), (Object)pSSysValueRuleService.getDEModel().getDataInfo(pSSysValueRule)));
    }

    protected void initPSSysImages(PSSystem pSSystem, Map<String, String> map) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSImageTempl> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSImageTempl> hashMap = new HashMap<String, PSImageTempl>();
        for (PSImageTempl image : arrayList) {
            hashMap.put(image.getPSImageTemplId(), image);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSImageTempl image : (ArrayList<PSImageTempl>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(image, (boolean)true);
                EntityBase.setIgnoreCheckKey(image, (boolean)true);
                if (hashMap.containsKey(image.getPSImageTemplId())) continue;
                iService2.create(image);
                hashMap.put(image.getPSImageTemplId(), image);
                arrayList.add(image);
            }
        }
        iService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSIMAGETEMPLID");
        HashMap<String, PSSysImage> existing = new HashMap<String, PSSysImage>();
        for (PSSysImage image : (ArrayList<PSSysImage>)iService.select((ISelectCond)selectCond)) {
            existing.put(image.getPSSysImageId(), image);
            if (StringHelper.isNullOrEmpty((String)image.getPSImageTemplId())) continue;
            existing.put(image.getPSImageTemplId(), image);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSIMAGETEMPL", (Object)image.getPSImageTemplId()), image.getPSSysImageId());
        }
        for (PSImageTempl image : arrayList) {
            String string2;
            if (existing.containsKey(image.getPSImageTemplId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)image.getPSImageTemplId()))) continue;
            this.initPSSysImage(pSSystem, image);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSIMAGETEMPL", (Object)image.getPSImageTemplId()), string2);
        }
    }

    protected void initPSSysImage(PSSystem pSSystem, PSImageTempl pSImageTempl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        PSSysImage pSSysImage = new PSSysImage();
        pSImageTempl.copyTo((IDataObject)pSSysImage, false);
        pSSysImage.setPSSysImageId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSImageTempl.getPSImageTemplId()));
        pSSysImage.setPSSysImageName(pSImageTempl.getPSImageTemplName());
        pSSysImage.setPSSystemId(pSSystem.getPSSystemId());
        pSSysImage.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysImage, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysImage, (boolean)true);
        pSSysImageService.create(pSSysImage, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysImageService.getDEModel().getLogicName(), (Object)pSSysImageService.getDEModel().getDataInfo(pSSysImage)));
    }

    protected void initPSSysCssCats(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSCssCatTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSCssCatTempl> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSCssCatTempl> hashMap = new HashMap<String, PSCssCatTempl>();
        for (PSCssCatTempl category : arrayList) {
            hashMap.put(category.getPSCssCatTemplId(), category);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSCssCatTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSCssCatTempl category : (ArrayList<PSCssCatTempl>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(category, (boolean)true);
                EntityBase.setIgnoreCheckKey(category, (boolean)true);
                if (hashMap.containsKey(category.getPSCssCatTemplId())) continue;
                iService2.create(category);
                hashMap.put(category.getPSCssCatTemplId(), category);
                arrayList.add(category);
            }
        }
        iService = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCSSCATTEMPLID");
        HashMap<String, PSSysCssCat> existing = new HashMap<String, PSSysCssCat>();
        for (PSSysCssCat category : (ArrayList<PSSysCssCat>)iService.select((ISelectCond)selectCond)) {
            existing.put(category.getPSSysCssCatId(), category);
            if (StringHelper.isNullOrEmpty((String)category.getPSCssCatTemplId())) continue;
            existing.put(category.getPSCssCatTemplId(), category);
        }
        for (PSCssCatTempl category : arrayList) {
            String string2;
            if (existing.containsKey(category.getPSCssCatTemplId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)category.getPSCssCatTemplId()))) continue;
            this.initPSSysCssCat(pSSystem, category);
        }
    }

    protected void initPSSysCssCat(PSSystem pSSystem, PSCssCatTempl pSCssCatTempl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysCssCatService pSSysCssCatService = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)this.getSessionFactory());
        PSSysCssCat pSSysCssCat = new PSSysCssCat();
        pSCssCatTempl.copyTo((IDataObject)pSSysCssCat, false);
        pSSysCssCat.setPSSysCssCatId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSCssCatTempl.getPSCssCatTemplId()));
        pSSysCssCat.setPSSysCssCatName(pSCssCatTempl.getPSCssCatTemplName());
        pSSysCssCat.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCssCat.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysCssCat, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysCssCat, (boolean)true);
        pSSysCssCatService.create(pSSysCssCat, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysCssCatService.getDEModel().getLogicName(), (Object)pSSysCssCatService.getDEModel().getDataInfo(pSSysCssCat)));
    }

    protected void initPSSysCsses(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSCssTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSCssTempl> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSCssTempl> hashMap = new HashMap<String, PSCssTempl>();
        for (PSCssTempl css : arrayList) {
            hashMap.put(css.getPSCssTemplId(), css);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSCssTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSCssTempl css : (ArrayList<PSCssTempl>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(css, (boolean)true);
                EntityBase.setIgnoreCheckKey(css, (boolean)true);
                if (hashMap.containsKey(css.getPSCssTemplId())) continue;
                iService2.create(css);
                hashMap.put(css.getPSCssTemplId(), css);
                arrayList.add(css);
            }
        }
        iService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCSSTEMPLID");
        HashMap<String, PSSysCss> existing = new HashMap<String, PSSysCss>();
        for (PSSysCss css : (ArrayList<PSSysCss>)iService.select((ISelectCond)selectCond)) {
            existing.put(css.getPSSysCssId(), css);
            if (StringHelper.isNullOrEmpty((String)css.getPSCssTemplId())) continue;
            existing.put(css.getPSCssTemplId(), css);
        }
        for (PSCssTempl css : arrayList) {
            String string2;
            if (existing.containsKey(css.getPSCssTemplId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)css.getPSCssTemplId()))) continue;
            this.initPSSysCss(pSSystem, css);
        }
    }

    protected void initPSSysCss(PSSystem pSSystem, PSCssTempl pSCssTempl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        PSSysCss pSSysCss = new PSSysCss();
        pSCssTempl.copyTo((IDataObject)pSSysCss, false);
        pSSysCss.setPSSysCssId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSCssTempl.getPSCssTemplId()));
        pSSysCss.setPSSysCssName(pSCssTempl.getPSCssTemplName());
        pSSysCss.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCss.setPSSystemName(pSSystem.getPSSystemName());
        if (!StringHelper.isNullOrEmpty((String)pSCssTempl.getPSCssCatTemplId())) {
            pSSysCss.setPSSysCssCatId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSCssTempl.getPSCssCatTemplId()));
            pSSysCss.setPSSysCssCatName(pSCssTempl.getPSCssCatTemplName());
        }
        EntityBase.setIgnoreCheck(pSSysCss, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysCss, (boolean)true);
        pSSysCssService.create(pSSysCss, false);
    }

    protected void initPSSysCounters(PSSystem pSSystem) throws Exception {
        String string = pSSystem.getPSSystemId();
        IService iService = ServiceGlobal.getService(PSCounterService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSCounter> counters = iService.select((ISelectCond)selectCond);
        HashMap<String, PSCounter> hashMap = new HashMap<String, PSCounter>();
        for (PSCounter counter : counters) {
            hashMap.put(counter.getPSCounterId(), counter);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            IService iService2 = ServiceGlobal.getService(PSCounterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList<PSCounter> majorCounters = iService2.select((ISelectCond)selectCond);
            for (PSCounter counter : majorCounters) {
                if (!hashMap.containsKey(counter.getPSCounterId())) {
                    EntityBase.setIgnoreCheck(counter, (boolean)true);
                    EntityBase.setIgnoreCheckKey(counter, (boolean)true);
                    iService.create(counter);
                    hashMap.put(counter.getPSCounterId(), counter);
                    counters.add(counter);
                    continue;
                }
                PSCounter localCounter = hashMap.get(counter.getPSCounterId());
                if (StringHelper.compare((String)localCounter.getBaseClsParams(), (String)counter.getBaseClsParams(), (boolean)false) != 0) {
                    counter.copyTo((IDataObject)localCounter, true);
                    EntityBase.setIgnoreCheck(localCounter, (boolean)true);
                    EntityBase.setIgnoreCheckKey(localCounter, (boolean)true);
                    iService.update(localCounter, false);
                }
                hashMap.put(counter.getPSCounterId(), localCounter);
            }
            counters = majorCounters;
        }
        IService iService2 = ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCOUNTERID");
        HashMap<String, PSSysCounter> existing = new HashMap<String, PSSysCounter>();
        for (PSSysCounter sysCounter : (ArrayList<PSSysCounter>)iService2.select((ISelectCond)selectCond)) {
            existing.put(sysCounter.getPSSysCounterId(), sysCounter);
            if (StringHelper.isNullOrEmpty((String)sysCounter.getPSCounterId())) continue;
            existing.put(sysCounter.getPSCounterId(), sysCounter);
        }
        for (PSCounter counter : counters) {
            if (existing.containsKey(counter.getPSCounterId())) continue;
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)counter.getPSCounterId());
            if (!existing.containsKey(string2)) {
                this.initPSSysCounter(pSSystem, counter, true);
                continue;
            }
            PSSysCounter pSSysCounter = existing.get(string2);
            if (StringHelper.compare((String)pSSysCounter.getBaseClsParams(), (String)counter.getBaseClsParams(), (boolean)false) == 0) continue;
            this.initPSSysCounter(pSSystem, counter, false);
        }
    }

    protected void initPSSysCounter(PSSystem pSSystem, PSCounter pSCounter, boolean bl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        PSSysCounter pSSysCounter = new PSSysCounter();
        pSCounter.copyTo((IDataObject)pSSysCounter, false);
        pSSysCounter.setPSSysCounterId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSCounter.getPSCounterId()));
        pSSysCounter.setPSSysCounterName(pSCounter.getPSCounterName());
        pSSysCounter.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCounter.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysCounter, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysCounter, (boolean)true);
        if (bl) {
            pSSysCounterService.create(pSSysCounter, false);
        } else {
            pSSysCounterService.update(pSSysCounter, false);
        }
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysCounterService.getDEModel().getLogicName(), (Object)pSSysCounterService.getDEModel().getDataInfo(pSSysCounter)));
    }

    protected void initPSSysPortlets(PSSystem pSSystem, Map<String, String> map) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSPortletService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSPortlet> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSPortlet> hashMap = new HashMap<String, PSPortlet>();
        for (PSPortlet portlet : arrayList) {
            hashMap.put(portlet.getPSPortletId(), portlet);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSPortletService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSPortlet portlet : (ArrayList<PSPortlet>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(portlet, (boolean)true);
                EntityBase.setIgnoreCheckKey(portlet, (boolean)true);
                if (hashMap.containsKey(portlet.getPSPortletId())) continue;
                iService2.create(portlet);
                hashMap.put(portlet.getPSPortletId(), portlet);
                arrayList.add(portlet);
            }
        }
        iService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSPORTLETID");
        HashMap<String, PSSysPortlet> existing = new HashMap<String, PSSysPortlet>();
        for (PSSysPortlet portlet : (ArrayList<PSSysPortlet>)iService.select((ISelectCond)selectCond)) {
            existing.put(portlet.getPSSysPortletId(), portlet);
            if (StringHelper.isNullOrEmpty((String)portlet.getPSPortletId())) continue;
            existing.put(portlet.getPSPortletId(), portlet);
        }
        for (PSPortlet portlet : arrayList) {
            String string2;
            if (existing.containsKey(portlet.getPSPortletId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)portlet.getPSPortletId()))) continue;
            this.initPSSysPortlet(pSSystem, portlet, map);
        }
    }

    protected void initPSSysPortlet(PSSystem pSSystem, PSPortlet pSPortlet, Map<String, String> map) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        PSSysPortlet pSSysPortlet = new PSSysPortlet();
        pSPortlet.copyTo((IDataObject)pSSysPortlet, false);
        pSSysPortlet.setPSSysPortletId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSPortlet.getPSPortletId()));
        pSSysPortlet.setPSSysPortletName(pSPortlet.getPSPortletName());
        if (!StringHelper.isNullOrEmpty((String)pSPortlet.getPSPFPluginId())) {
            String string2 = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSPFPLUGIN", (Object)pSPortlet.getPSPFPluginId()));
            pSSysPortlet.setPSSysPFPluginId(string2);
            pSSysPortlet.setPSSysPFPluginName(pSPortlet.getPSPFPluginName());
        }
        pSSysPortlet.setPSSystemId(pSSystem.getPSSystemId());
        pSSysPortlet.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysPortlet, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysPortlet, (boolean)true);
        pSSysPortletService.create(pSSysPortlet);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPortletService.getDEModel().getLogicName(), (Object)pSSysPortletService.getDEModel().getDataInfo(pSSysPortlet)));
    }

    protected void initPSDEToolbars(PSSystem pSSystem, Map<String, String> map) throws Exception {
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)this.getSessionFactory());
        IService iService3 = ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSSysToolbar> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSSysToolbar> hashMap = new HashMap<String, PSSysToolbar>();
        for (PSSysToolbar toolbar : arrayList) {
            hashMap.put(toolbar.getPSSysToolbarId(), toolbar);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            IService iService = ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSSysTBItemService majorItemService = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSSysToolbar toolbar : (ArrayList<PSSysToolbar>)iService.select((ISelectCond)selectCond)) {
                if (hashMap.containsKey(toolbar.getPSSysToolbarId())) continue;
                ArrayList<PSSysTBItem> items = majorItemService.selectByPSSysToolbar(toolbar);
                PSSysTBItemService.sortHierarchyEntities(items, (String)"PSSYSTBITEMID", (String)"PPSSYSTBITEMID");
                EntityBase.setIgnoreCheck(toolbar, (boolean)true);
                EntityBase.setIgnoreCheckKey(toolbar, (boolean)true);
                iService2.create(toolbar);
                hashMap.put(toolbar.getPSSysToolbarId(), toolbar);
                arrayList.add(toolbar);
                for (PSSysTBItem pSSysTBItem : items) {
                    EntityBase.setIgnoreCheck(pSSysTBItem, (boolean)true);
                    EntityBase.setIgnoreCheckKey(pSSysTBItem, (boolean)true);
                    iService3.create(pSSysTBItem);
                }
            }
        }
        IService iService = ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSYSTOOLBARID");
        HashMap<String, PSDEToolbar> existing = new HashMap<String, PSDEToolbar>();
        for (PSDEToolbar toolbar : (ArrayList<PSDEToolbar>)iService.select((ISelectCond)selectCond)) {
            existing.put(toolbar.getPSDEToolbarId(), toolbar);
            if (StringHelper.isNullOrEmpty((String)toolbar.getPSSysToolbarId())) continue;
            existing.put(toolbar.getPSSysToolbarId(), toolbar);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSTOOLBAR", (Object)toolbar.getPSSysToolbarId()), toolbar.getPSDEToolbarId());
        }
        for (PSSysToolbar toolbar : arrayList) {
            String toolbarId = KeyValueHelper.genUniqueId((String)string, (String)toolbar.getPSSysToolbarId());
            if (existing.containsKey(toolbar.getPSSysToolbarId()) || existing.containsKey(toolbarId)) continue;
            this.initPSDEToolbar(pSSystem, toolbar, map);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSTOOLBAR", (Object)toolbar.getPSSysToolbarId()), toolbarId);
        }
    }

    protected void initPSDEToolbar(PSSystem pSSystem, PSSysToolbar pSSysToolbar, Map<String, String> map) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        PSDEToolbar pSDEToolbar = new PSDEToolbar();
        pSSysToolbar.copyTo((IDataObject)pSDEToolbar, false);
        pSDEToolbar.setPSDEToolbarId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSysToolbar.getPSSysToolbarId()));
        pSDEToolbar.setPSDEToolbarName(pSSysToolbar.getPSSysToolbarName());
        pSDEToolbar.setPSSystemId(pSSystem.getPSSystemId());
        pSDEToolbar.setPSSystemName(pSSystem.getPSSystemName());
        pSDEToolbar.setTemplToolbar(1);
        EntityBase.setIgnoreCheck(pSDEToolbar, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSDEToolbar, (boolean)true);
        pSDEToolbarService.create(pSDEToolbar);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSDEToolbarService.getDEModel().getLogicName(), (Object)pSDEToolbarService.getDEModel().getDataInfo(pSDEToolbar)));
        PSSysTBItemService pSSysTBItemService = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTBItem> arrayList = pSSysTBItemService.selectByPSSysToolbar(pSSysToolbar);
        PSSysTBItemService.sortHierarchyEntities(arrayList, (String)"PSSYSTBITEMID", (String)"PPSSYSTBITEMID");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        int n = 0;
        while (arrayList.size() > 0) {
            String string2;
            ++n;
            String string3 = "";
            PSSysTBItem pSSysTBItem = arrayList.remove(0);
            if (!StringHelper.isNullOrEmpty((String)pSSysTBItem.getPPSSysTBItemId()) && StringHelper.isNullOrEmpty((String)(string3 = (String)hashMap.get(pSSysTBItem.getPPSSysTBItemId())))) {
                arrayList.add(pSSysTBItem);
                continue;
            }
            PSDETBItem pSDETBItem = new PSDETBItem();
            pSSysTBItem.copyTo((IDataObject)pSDETBItem, true);
            pSDETBItem.setPSDETBItemName(StringHelper.format((String)"tbitem%1$s", (Object)n));
            pSDETBItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                pSDETBItem.setPPSDETBItemId(string3);
            }
            if (!StringHelper.isNullOrEmpty((String)(string2 = pSSysTBItem.getPSSysUIActionId()))) {
                String string4 = map.get(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSUIACTION", (Object)string2));
                pSDETBItem.setPSDEUIActionId(string4);
            }
            EntityBase.setIgnoreCheck(pSDETBItem, (boolean)true);
            EntityBase.setIgnoreCheckKey(pSDETBItem, (boolean)true);
            pSDETBItemService.create(pSDETBItem);
            hashMap.put(pSSysTBItem.getPSSysTBItemId(), pSDETBItem.getPSDETBItemId());
        }
    }

    protected void initPSSysPFPlugins(PSSystem pSSystem, Map<String, String> map) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)this.getSessionFactory());
        IService iService3 = ServiceGlobal.getService(PSPFPluginTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSPFPlugin> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSPFPlugin> hashMap = new HashMap<String, PSPFPlugin>();
        for (PSPFPlugin plugin : arrayList) {
            hashMap.put(plugin.getPSPFPluginId(), plugin);
        }
        arrayList.clear();
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            selectCond.set("ALLDCFLAG", (Object)1);
            selectCond.set("VALIDFLAG", (Object)1);
            ArrayList<PSPFPlugin> plugins = iService.select((ISelectCond)selectCond);
            if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevCenterId())) {
                selectCond.reset();
                selectCond.set("ALLDCFLAG", (Object)0);
                selectCond.set("VALIDFLAG", (Object)1);
                selectCond.set("PSDCID", (Object)pSSystem.getPSDevCenterId());
                plugins.addAll((ArrayList<PSPFPlugin>)iService.select((ISelectCond)selectCond));
            }
            for (PSPFPlugin plugin : plugins) {
                EntityBase.setIgnoreCheck(plugin, (boolean)true);
                EntityBase.setIgnoreCheckKey(plugin, (boolean)true);
                if (!hashMap.containsKey(plugin.getPSPFPluginId())) {
                    iService2.create(plugin);
                }
                arrayList.add(plugin);
            }
        }
        iService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSPFPLUGINID");
        HashMap<String, PSSysPFPlugin> existing = new HashMap<String, PSSysPFPlugin>();
        for (PSSysPFPlugin plugin : (ArrayList<PSSysPFPlugin>)iService.select((ISelectCond)selectCond)) {
            existing.put(plugin.getPSSysPFPluginId(), plugin);
            if (StringHelper.isNullOrEmpty((String)plugin.getPSPFPluginId())) continue;
            existing.put(plugin.getPSPFPluginId(), plugin);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSPFPLUGIN", (Object)plugin.getPSPFPluginId()), plugin.getPSSysPFPluginId());
        }
        for (PSPFPlugin plugin : arrayList) {
            if (existing.containsKey(plugin.getPSPFPluginId())) continue;
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)plugin.getPSPFPluginId());
            if (!existing.containsKey(string2)) {
                this.initPSSysPFPlugin(pSSystem, plugin, true);
            } else {
                this.initPSSysPFPlugin(pSSystem, plugin, false);
            }
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSPFPLUGIN", (Object)plugin.getPSPFPluginId()), string2);
        }
    }

    protected void initPSSysPFPlugin(PSSystem pSSystem, PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
        PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
        pSPFPlugin.copyTo((IDataObject)pSSysPFPlugin, false);
        pSSysPFPlugin.setPSSysPFPluginId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSPFPlugin.getPSPFPluginId()));
        pSSysPFPlugin.setPSSysPFPluginName(pSPFPlugin.getPSPFPluginName());
        pSSysPFPlugin.setPSSystemId(pSSystem.getPSSystemId());
        pSSysPFPlugin.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysPFPlugin, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysPFPlugin, (boolean)true);
        if (bl) {
            pSSysPFPluginService.create(pSSysPFPlugin);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPFPluginService.getDEModel().getLogicName(), (Object)pSSysPFPluginService.getDEModel().getDataInfo(pSSysPFPlugin)));
        }
        PSPFPluginTemplService pSPFPluginTemplService = (PSPFPluginTemplService)ServiceGlobal.getService(PSPFPluginTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPFPluginTempl> arrayList = pSPFPluginTemplService.selectByPSPFPlugin(pSPFPlugin);
        while (arrayList.size() > 0) {
            String string2 = "";
            PSPFPluginTempl pSPFPluginTempl = arrayList.remove(0);
            PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
            pSPFPluginTempl.copyTo((IDataObject)pSSysPFPITempl, true);
            pSSysPFPITempl.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
            pSSysPFPITempl.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
            EntityBase.setIgnoreCheck(pSSysPFPITempl, (boolean)true);
            EntityBase.setIgnoreCheckKey(pSSysPFPITempl, (boolean)true);
            if (pSSysPFPITemplService.checkKey(pSSysPFPITempl) != 0) continue;
            pSSysPFPITemplService.create(pSSysPFPITempl);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPFPITemplService.getDEModel().getLogicName(), (Object)pSSysPFPITemplService.getDEModel().getDataInfo(pSSysPFPITempl)));
        }
    }

    protected void initPSDEOPPriv(PSSystem pSSystem, Map<String, String> map) throws Exception {
        PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        for (String string : defaultPSDEOPPrivMap.keySet()) {
            PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)"__EMTPY__", (String)string));
            PSDEOPPriv pSDEOPPriv2 = new PSDEOPPriv();
            pSDEOPPriv2.setPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)"__EMTPY__", (String)string, (String)"__EMTPY__"));
            if (pSDEOPPrivService.checkKey(pSDEOPPriv) == 0) {
                if (pSDEOPPrivService.checkKey(pSDEOPPriv2) == 0) {
                    String string2 = defaultPSDEOPPrivMap.get(string);
                    pSDEOPPriv.setPSSystemId(pSSystem.getPSSystemId());
                    pSDEOPPriv.setPSSystemName(pSSystem.getPSSystemName());
                    pSDEOPPriv.setPSDEId(null);
                    pSDEOPPriv.setPSDEName(null);
                    pSDEOPPriv.setPSDEOPPrivName(string);
                    pSDEOPPriv.setLogicName(string2);
                    EntityBase.setIgnoreCheck(pSDEOPPriv, (boolean)true);
                    EntityBase.setIgnoreCheckKey(pSDEOPPriv, (boolean)true);
                    pSDEOPPrivService.create(pSDEOPPriv);
                    ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSDEOPPrivService.getDEModel().getLogicName(), (Object)pSDEOPPrivService.getDEModel().getDataInfo(pSDEOPPriv)));
                    continue;
                }
                map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSDEOPPRIV", (Object)string), pSDEOPPriv2.getPSDEOPPrivId());
                continue;
            }
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSDEOPPRIV", (Object)string), pSDEOPPriv.getPSDEOPPrivId());
        }
    }

    protected void initPSCodeListTempl(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSCodeListTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSCodeListTempl> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSCodeListTempl> hashMap = new HashMap<String, PSCodeListTempl>();
        for (PSCodeListTempl template : arrayList) {
            hashMap.put(template.getPSCodeListTemplId(), template);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSCodeListTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSCodeListTempl template : (ArrayList<PSCodeListTempl>)iService.select((ISelectCond)selectCond)) {
                if (hashMap.containsKey(template.getPSCodeListTemplId())) continue;
                EntityBase.setIgnoreCheck(template, (boolean)true);
                EntityBase.setIgnoreCheckKey(template, (boolean)true);
                iService2.create(template);
                hashMap.put(template.getPSCodeListTemplId(), template);
                arrayList.add(template);
            }
        }
        iService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCODELISTTEMPLID");
        HashMap<String, PSCodeList> existing = new HashMap<String, PSCodeList>();
        for (PSCodeList codeList : (ArrayList<PSCodeList>)iService.select((ISelectCond)selectCond)) {
            existing.put(codeList.getPSCodeListId(), codeList);
            if (StringHelper.isNullOrEmpty((String)codeList.getPSCodeListTemplId())) continue;
            existing.put(codeList.getPSCodeListTemplId(), codeList);
        }
        for (PSCodeListTempl template : arrayList) {
            String string2;
            if (existing.containsKey(template.getPSCodeListTemplId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)template.getPSCodeListTemplId()))) continue;
            this.initPSCodeList(pSSystem, template);
        }
    }

    protected void initPSCodeList(PSSystem pSSystem, PSCodeListTempl pSCodeListTempl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        PSCodeList pSCodeList = new PSCodeList();
        pSCodeListTempl.copyTo((IDataObject)pSCodeList, false);
        pSCodeList.setPSCodeListName(pSCodeListTempl.getPSCodeListTemplName());
        pSCodeList.setPSCodeListId(KeyValueHelper.genUniqueId((String)string, (String)pSCodeListTempl.getPSCodeListTemplId()));
        pSCodeList.setPSSystemId(string);
        pSCodeList.setCLType("STATIC");
        pSCodeList.setCodeListSN(pSCodeListTempl.getPSCodeListTemplId());
        pSCodeList.setPSCodeListTemplId(pSCodeListTempl.getPSCodeListTemplId());
        pSCodeList.setUserScope(0);
        pSCodeList.setCodeName(pSCodeListTempl.getCodeName());
        EntityBase.setIgnoreCheck(pSCodeList, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSCodeList, (boolean)true);
        pSCodeListService.create(pSCodeList);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSCodeListService.getDEModel().getLogicName(), (Object)pSCodeListService.getDEModel().getDataInfo(pSCodeList)));
        if (StringHelper.isNullOrEmpty((String)pSCodeListTempl.getCLModel())) {
            return;
        }
        CodeListConfig codeListConfig = new CodeListConfig();
        codeListConfig.loadXML(pSCodeListTempl.getCLModel());
        for (int i = 0; i < codeListConfig.getCodeItems().size(); ++i) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)codeListConfig.getCodeItems().get(i));
            this.initPSCodeItem(pSCodeList, null, codeItemConfig, i);
        }
    }

    protected void initPSCodeItem(PSCodeList pSCodeList, PSCodeItem pSCodeItem, CodeItemConfig codeItemConfig, int n) throws Exception {
        IService iService = ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        PSCodeItem pSCodeItem2 = new PSCodeItem();
        pSCodeItem2.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSCodeItem2.setCodeItemValue(codeItemConfig.getValue());
        pSCodeItem2.setPSCodeItemName(codeItemConfig.getText());
        pSCodeItem2.setOrderValue(n);
        if (pSCodeItem != null) {
            pSCodeItem2.setPPSCodeItemId(pSCodeItem.getPSCodeItemId());
        }
        EntityBase.setIgnoreCheck(pSCodeItem2, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSCodeItem2, (boolean)true);
        iService.create(pSCodeItem2);
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        for (int i = 0; i < codeItemConfig.getCodeItems().size(); ++i) {
            CodeItemConfig codeItemConfig2 = (CodeItemConfig)((Object)codeItemConfig.getCodeItems().get(i));
            this.initPSCodeItem(pSCodeList, pSCodeItem2, codeItemConfig2, i);
        }
    }

    protected void initPSSysPDTViews(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSPDTViewService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSPDTView> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSPDTView> hashMap = new HashMap<String, PSPDTView>();
        for (PSPDTView view : arrayList) {
            hashMap.put(view.getPSPDTViewId(), view);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSPDTViewService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSPDTView view : (ArrayList<PSPDTView>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(view, (boolean)true);
                EntityBase.setIgnoreCheckKey(view, (boolean)true);
                if (hashMap.containsKey(view.getPSPDTViewId())) continue;
                iService2.create(view);
                hashMap.put(view.getPSPDTViewId(), view);
                arrayList.add(view);
            }
        }
        iService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSPDTVIEWID");
        HashMap<String, PSSysPDTView> existing = new HashMap<String, PSSysPDTView>();
        for (PSSysPDTView view : (ArrayList<PSSysPDTView>)iService.select((ISelectCond)selectCond)) {
            existing.put(view.getPSSysPDTViewId(), view);
            if (StringHelper.isNullOrEmpty((String)view.getPSPDTViewId())) continue;
            existing.put(view.getPSPDTViewId(), view);
        }
        for (PSPDTView view : arrayList) {
            String string2;
            if (existing.containsKey(view.getPSPDTViewId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)view.getPSPDTViewId()))) continue;
            this.initPSSysPDTView(pSSystem, view);
        }
    }

    protected void initPSSysPDTView(PSSystem pSSystem, PSPDTView pSPDTView) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
        PSSysPDTView pSSysPDTView = new PSSysPDTView();
        pSPDTView.copyTo((IDataObject)pSSysPDTView, false);
        pSSysPDTView.setPSSysPDTViewId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSPDTView.getPSPDTViewId()));
        pSSysPDTView.setPSSysPDTViewName(pSPDTView.getPSPDTViewName());
        pSSysPDTView.setPSSystemId(pSSystem.getPSSystemId());
        pSSysPDTView.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysPDTView, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysPDTView, (boolean)true);
        pSSysPDTViewService.create(pSSysPDTView);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPDTViewService.getDEModel().getLogicName(), (Object)pSSysPDTViewService.getDEModel().getDataInfo(pSSysPDTView)));
    }

    protected void initPSSysViewLogics(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSViewLogicType> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSViewLogicType> hashMap = new HashMap<String, PSViewLogicType>();
        for (PSViewLogicType viewLogic : arrayList) {
            hashMap.put(viewLogic.getPSViewLogicTypeId(), viewLogic);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSViewLogicType viewLogic : (ArrayList<PSViewLogicType>)iService.select((ISelectCond)selectCond)) {
                if (StringHelper.compare((String)viewLogic.getPSViewLogicTypeId(), (String)"VIEW_DELOGIC", (boolean)true) == 0) continue;
                EntityBase.setIgnoreCheck(viewLogic, (boolean)true);
                EntityBase.setIgnoreCheckKey(viewLogic, (boolean)true);
                if (hashMap.containsKey(viewLogic.getPSViewLogicTypeId())) continue;
                iService2.create(viewLogic);
                hashMap.put(viewLogic.getPSViewLogicTypeId(), viewLogic);
                arrayList.add(viewLogic);
            }
        }
        iService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        HashMap<String, PSSysViewLogic> existing = new HashMap<String, PSSysViewLogic>();
        for (PSSysViewLogic viewLogic : (ArrayList<PSSysViewLogic>)iService.select((ISelectCond)selectCond)) {
            existing.put(viewLogic.getPSSysViewLogicId(), viewLogic);
        }
        for (PSViewLogicType viewLogic : arrayList) {
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)viewLogic.getPSViewLogicTypeId());
            if (existing.containsKey(string2)) continue;
            this.initPSSysViewLogic(pSSystem, viewLogic);
        }
    }

    protected void initPSSysViewLogic(PSSystem pSSystem, PSViewLogicType pSViewLogicType) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysViewLogicService pSSysViewLogicService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewLogic pSSysViewLogic = new PSSysViewLogic();
        pSViewLogicType.copyTo((IDataObject)pSSysViewLogic, false);
        pSSysViewLogic.setPSSysViewLogicId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSViewLogicType.getPSViewLogicTypeId()));
        pSSysViewLogic.setPSSysViewLogicName(pSViewLogicType.getPSViewLogicTypeName());
        pSSysViewLogic.setPSSystemId(pSSystem.getPSSystemId());
        pSSysViewLogic.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysViewLogic, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysViewLogic, (boolean)true);
        pSSysViewLogicService.create(pSSysViewLogic);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysViewLogicService.getDEModel().getLogicName(), (Object)pSSysViewLogicService.getDEModel().getDataInfo(pSSysViewLogic)));
    }

    protected void initPSSysEditorStyles(PSSystem pSSystem) throws Exception {
        IService iService;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSEditorStyle> arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSEditorStyle> hashMap = new HashMap<String, PSEditorStyle>();
        for (PSEditorStyle style : arrayList) {
            hashMap.put(style.getPSEditorStyleId(), style);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSEditorStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            for (PSEditorStyle style : (ArrayList<PSEditorStyle>)iService.select((ISelectCond)selectCond)) {
                EntityBase.setIgnoreCheck(style, (boolean)true);
                EntityBase.setIgnoreCheckKey(style, (boolean)true);
                if (hashMap.containsKey(style.getPSEditorStyleId())) continue;
                iService2.create(style);
                hashMap.put(style.getPSEditorStyleId(), style);
                arrayList.add(style);
            }
        }
        iService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSEDITORSTYLEID");
        HashMap<String, PSSysEditorStyle> existing = new HashMap<String, PSSysEditorStyle>();
        for (PSSysEditorStyle style : (ArrayList<PSSysEditorStyle>)iService.select((ISelectCond)selectCond)) {
            existing.put(style.getPSSysEditorStyleId(), style);
            if (StringHelper.isNullOrEmpty((String)style.getPSEditorStyleId())) continue;
            existing.put(style.getPSEditorStyleId(), style);
        }
        for (PSEditorStyle style : arrayList) {
            String string2;
            if (existing.containsKey(style.getPSEditorStyleId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)style.getPSEditorStyleId()))) continue;
            this.initPSSysEditorStyle(pSSystem, style);
        }
    }

    protected void initPSSysEditorStyle(PSSystem pSSystem, PSEditorStyle pSEditorStyle) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysEditorStyleService pSSysEditorStyleService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        PSSysEditorStyle pSSysEditorStyle = new PSSysEditorStyle();
        pSEditorStyle.copyTo((IDataObject)pSSysEditorStyle, false);
        pSSysEditorStyle.setPSSysEditorStyleId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSEditorStyle.getPSEditorStyleId()));
        pSSysEditorStyle.setPSSysEditorStyleName(pSEditorStyle.getPSEditorStyleName());
        pSSysEditorStyle.setPSSystemId(pSSystem.getPSSystemId());
        pSSysEditorStyle.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysEditorStyle, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysEditorStyle, (boolean)true);
        pSSysEditorStyleService.create(pSSysEditorStyle, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysEditorStyleService.getDEModel().getLogicName(), (Object)pSSysEditorStyleService.getDEModel().getDataInfo(pSSysEditorStyle)));
    }

    protected void initPSPDTAppFunc() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPDTAppFuncService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSPDTAppFunc> arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPDTAppFunc> hashMap = new HashMap<String, PSPDTAppFunc>();
        for (PSPDTAppFunc pSPDTAppFunc : arrayList) {
            hashMap.put(pSPDTAppFunc.getPSPDTAppFuncId(), pSPDTAppFunc);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            IService iService2 = ServiceGlobal.getService(PSPDTAppFuncService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList<PSPDTAppFunc> majorFuncs = iService2.select((ISelectCond)selectCond);
            Iterator<PSPDTAppFunc> iterator = majorFuncs.iterator();
            while (iterator.hasNext()) {
                PSPDTAppFunc pSPDTAppFunc = iterator.next();
                EntityBase.setIgnoreCheck(pSPDTAppFunc, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSPDTAppFunc, (boolean)true);
                if (!hashMap.containsKey(pSPDTAppFunc.getPSPDTAppFuncId())) {
                    iService.create(pSPDTAppFunc);
                    hashMap.put(pSPDTAppFunc.getPSPDTAppFuncId(), pSPDTAppFunc);
                    arrayList.add(pSPDTAppFunc);
                    continue;
                }
                iService.update(pSPDTAppFunc);
                hashMap.put(pSPDTAppFunc.getPSPDTAppFuncId(), pSPDTAppFunc);
                arrayList.add(pSPDTAppFunc);
            }
        }
    }

    protected void initPSSysSampleValues(PSSystem pSSystem) throws Exception {
        String string = pSSystem.getPSSystemId();
        IService iService = ServiceGlobal.getService(PSSampleValueService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSSampleValue> values = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSampleValue> hashMap = new HashMap<String, PSSampleValue>();
        for (PSSampleValue value : values) {
            hashMap.put(value.getPSSampleValueId(), value);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            IService iService2 = ServiceGlobal.getService(PSSampleValueService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            ArrayList<PSSampleValue> majorValues = iService2.select((ISelectCond)selectCond);
            for (PSSampleValue value : majorValues) {
                EntityBase.setIgnoreCheck(value, (boolean)true);
                EntityBase.setIgnoreCheckKey(value, (boolean)true);
                if (!hashMap.containsKey(value.getPSSampleValueId())) {
                    iService.create(value);
                    hashMap.put(value.getPSSampleValueId(), value);
                    values.add(value);
                    continue;
                }
                hashMap.put(value.getPSSampleValueId(), value);
            }
            values = majorValues;
        }
        IService iService2 = ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSAMPLEVALUEID");
        HashMap<String, PSSysSampleValue> existing = new HashMap<String, PSSysSampleValue>();
        for (PSSysSampleValue sysValue : (ArrayList<PSSysSampleValue>)iService2.select((ISelectCond)selectCond)) {
            existing.put(sysValue.getPSSysSampleValueId(), sysValue);
            if (StringHelper.isNullOrEmpty((String)sysValue.getPSSampleValueId())) continue;
            existing.put(sysValue.getPSSampleValueId(), sysValue);
        }
        for (PSSampleValue value : values) {
            String string2;
            if (existing.containsKey(value.getPSSampleValueId()) || existing.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)value.getPSSampleValueId()))) continue;
            this.initPSSysSampleValue(pSSystem, value);
        }
    }

    protected void initPSSysSampleValue(PSSystem pSSystem, PSSampleValue pSSampleValue) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
        PSSysSampleValue pSSysSampleValue = new PSSysSampleValue();
        pSSampleValue.copyTo((IDataObject)pSSysSampleValue, false);
        pSSysSampleValue.setPSSysSampleValueId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSampleValue.getPSSampleValueId()));
        pSSysSampleValue.setPSSysSampleValueName(pSSampleValue.getPSSampleValueName());
        pSSysSampleValue.setPSSystemId(pSSystem.getPSSystemId());
        pSSysSampleValue.setPSSystemName(pSSystem.getPSSystemName());
        EntityBase.setIgnoreCheck(pSSysSampleValue, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysSampleValue, (boolean)true);
        pSSysSampleValueService.create(pSSysSampleValue);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysSampleValueService.getDEModel().getLogicName(), (Object)pSSysSampleValueService.getDEModel().getDataInfo(pSSysSampleValue)));
    }

    protected void initPSCounterType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSCounterTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSCounterType> hashMap = new HashMap<String, PSCounterType>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSCounterTypeBase)serializable).getPSCounterTypeId(), (PSCounterType)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSCounterTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSCounterType pSCounterType = (PSCounterType)iterator.next();
                EntityBase.setIgnoreCheck(pSCounterType, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSCounterType, (boolean)true);
                if (!hashMap.containsKey(pSCounterType.getPSCounterTypeId())) {
                    iService.create(pSCounterType, false);
                } else {
                    iService.update(pSCounterType, false);
                }
                hashMap.put(pSCounterType.getPSCounterTypeId(), pSCounterType);
                arrayList.add(pSCounterType);
            }
        }
    }

    protected void initPSLanguage() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSLanguage> hashMap = new HashMap<String, PSLanguage>();
        for (Object serializable : arrayList) {
            hashMap.put(((PSLanguageBase)serializable).getPSLanguageId(), (PSLanguage)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSLanguage pSLanguage = (PSLanguage)iterator.next();
                EntityBase.setIgnoreCheck(pSLanguage, (boolean)true);
                EntityBase.setIgnoreCheckKey(pSLanguage, (boolean)true);
                if (!hashMap.containsKey(pSLanguage.getPSLanguageId())) {
                    iService.create(pSLanguage, false);
                } else {
                    iService.update(pSLanguage, false);
                }
                hashMap.put(pSLanguage.getPSLanguageId(), pSLanguage);
                arrayList.add(pSLanguage);
            }
        }
    }

    protected void initPSLanguageRes(PSSystem pSSystem, Map<String, String> map) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList<PSSysLanResBase> arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysLanResBase resource : arrayList) {
            String resourceKey = StringHelper.format((String)"PSSYSLANRES#%1$s", (Object)resource.getPSSysLanResId());
            String resourceId = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)resource.getPSSysLanResId());
            map.put(resourceKey, resourceId);
            PSLanguageRes entityBase = new PSLanguageRes();
            entityBase.setPSSystemId(pSSystem.getPSSystemId());
            entityBase.setLanResType(resource.getLanResType());
            entityBase.setUserData(resource.getUserData());
            if (!pSLanguageResService.select(entityBase, true)) {
                entityBase.setPSLanguageResId(resourceId);
                EntityBase.setIgnoreCheck(entityBase, (boolean)true);
                EntityBase.setIgnoreCheckKey(entityBase, (boolean)true);
                if (pSLanguageResService.checkKey(entityBase) != 0) continue;
                entityBase.setPSLanguageResName(resource.getPSSysLanResName());
                entityBase.setPSSystemId(pSSystem.getPSSystemId());
                entityBase.setPSSystemName(pSSystem.getPSSystemName());
                entityBase.setLanResType(resource.getLanResType());
                entityBase.setUserData(resource.getUserData());
                entityBase.setContent(resource.getContent());
                pSLanguageResService.create(entityBase, false);
                continue;
            }
            if (StringHelper.compare((String)resourceId, (String)entityBase.getPSLanguageResId(), (boolean)true) == 0) continue;
            hashMap.put(resource.getPSSysLanResId(), "");
            map.put(resourceKey, entityBase.getPSLanguageResId());
        }
        IService iService2 = ServiceGlobal.getService(PSSysLanItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSLanguageItemService itemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysLanItem item : (ArrayList<PSSysLanItem>)iService2.select((ISelectCond)selectCond)) {
            if (hashMap.containsKey(item.getPSSysLanResId())) continue;
            PSLanguageItem pSLanguageItem = new PSLanguageItem();
            pSLanguageItem.setPSLanguageItemId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)item.getPSSysLanItemId()));
            if (itemService.checkKey(pSLanguageItem) != 0) continue;
            pSLanguageItem.setPSLanguageItemName(item.getPSSysLanItemId());
            pSLanguageItem.setPSSystemId(pSSystem.getPSSystemId());
            pSLanguageItem.setPSSystemName(pSSystem.getPSSystemName());
            pSLanguageItem.setPSLanguageId(item.getPSLanguageId());
            pSLanguageItem.setPSLanguageName(item.getPSLanguageName());
            pSLanguageItem.setPSLanguageResId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)item.getPSSysLanResId()));
            pSLanguageItem.setPSLanguageResName(item.getPSSysLanResName());
            pSLanguageItem.setContent(item.getContent());
            EntityBase.setIgnoreCheck(pSLanguageItem, (boolean)true);
            EntityBase.setIgnoreCheckKey(pSLanguageItem, (boolean)true);
            itemService.create(pSLanguageItem, false);
        }
    }

    @Override
    protected void onIncreaseDECnt(PSSystem pSSystem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSSystem pSSystem2 = new PSSystem();
        pSSystem2.setPSSystemId(pSSystem.getPSSystemId());
        this.getPSSystemDECnt(pSSystem2);
        int n = DataObject.getIntegerValue((IDataObject)pSSystem, (String)"DECNT", (int)1);
        n = pSSystem2.getEntityCnt() + n;
        pSSystem.setEntityCnt(n);
        PSDCSysLic pSDCSysLic = this.getPSSystemLic(pSSystem);
        if (pSDCSysLic != null) {
            pSCoreSysServiceBase = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            ((PSDCSysLicService)pSCoreSysServiceBase).testLic(pSDCSysLic, "MAXENTITYCNT", n);
        }
        this.sysUpdate(pSSystem, true);
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(pSSystem.getPSDevSlnSysId());
            pSDevSlnSys.setEntityCnt(n);
            pSCoreSysServiceBase.sysUpdate(pSDevSlnSys, false);
        }
    }

    @Override
    protected void onDecreaseDECnt(PSSystem pSSystem) throws Exception {
        PSSystem pSSystem2 = new PSSystem();
        pSSystem2.setPSSystemId(pSSystem.getPSSystemId());
        this.getPSSystemDECnt(pSSystem2);
        int n = DataObject.getIntegerValue((IDataObject)pSSystem, (String)"DECNT", (int)1);
        n = pSSystem2.getEntityCnt() - n;
        if (n < 0) {
            n = 0;
        }
        pSSystem.setEntityCnt(n);
        this.sysUpdate(pSSystem, true);
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(pSSystem.getPSDevSlnSysId());
            pSDevSlnSys.setEntityCnt(n);
            pSDevSlnSysService.sysUpdate(pSDevSlnSys, false);
        }
    }

    protected void getPSSystemDECnt(PSSystem pSSystem) throws Exception {
        this.get(pSSystem);
        if (DataObject.getIntegerValue((Object)pSSystem.getEntityCnt(), -1) < 0) {
            PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDataEntity> arrayList = pSDataEntityService.selectByPSSystem(pSSystem);
            int n = 0;
            for (PSDataEntity pSDataEntity : arrayList) {
                if (PSRTHelper.isRTDE(pSDataEntity.getPSDataEntityName())) continue;
                ++n;
            }
            pSSystem.setEntityCnt(n);
        }
    }

    public PSDCSysLic getPSSystemLic(PSSystem pSSystem) throws Exception {
        this.get(pSSystem);
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(pSSystem.getPSDevSlnSysId());
            pSDevSlnSysService.get(pSDevSlnSys);
            return pSDevSlnSys.getPSDCSysLic();
        }
        return null;
    }

    @Override
    protected boolean onMergeChild_PSSysApps(PSSystem pSSystem) throws Exception {
        PSDCSysLic pSDCSysLic;
        boolean bl = super.onMergeChild_PSSysApps(pSSystem);
        if (bl && (pSDCSysLic = this.getPSSystemLic(pSSystem)) != null) {
            PSDCSysLicService pSDCSysLicService = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSDCSysLicService.testLic(pSDCSysLic, "MAXWEBAPPCNT", pSSystem.getWebPSAppsCnt());
            pSDCSysLicService.testLic(pSDCSysLic, "MAXMOBAPPCNT", pSSystem.getMobPSAppsCnt());
        }
        return bl;
    }

    @Override
    protected boolean onMergeChild_PSSysSFPubs(PSSystem pSSystem) throws Exception {
        PSDCSysLic pSDCSysLic;
        boolean bl = super.onMergeChild_PSSysSFPubs(pSSystem);
        if (bl && (pSDCSysLic = this.getPSSystemLic(pSSystem)) != null) {
            PSDCSysLicService pSDCSysLicService = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSDCSysLicService.testLic(pSDCSysLic, "MAXSFPUBCNT", pSSystem.getPSSFPubsCnt());
        }
        return bl;
    }

    @Override
    protected boolean onMergeChild_PSWorkflows(PSSystem pSSystem) throws Exception {
        PSDCSysLic pSDCSysLic;
        boolean bl = super.onMergeChild_PSWorkflows(pSSystem);
        if (bl && (pSDCSysLic = this.getPSSystemLic(pSSystem)) != null) {
            PSDCSysLicService pSDCSysLicService = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSDCSysLicService.testLic(pSDCSysLic, "MAXWFCNT", pSSystem.getPSWFsCnt());
        }
        return bl;
    }

    protected void initPSDBValueFunc(PSSystem pSSystem) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return;
        }
        String string = pSSystem.getPSSystemId();
        IService iService = ServiceGlobal.getService(PSDBValueFuncService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectContext selectContext = new SelectContext();
        SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
        selectGroupFilter.setCondOp("AND");
        selectContext.setSelectFilter((ISelectFilter)selectGroupFilter);
        SelectFieldFilter validFilter = new SelectFieldFilter();
        validFilter.setDEFName("VALIDFLAG");
        validFilter.setCondOp("EQ");
        validFilter.setCondObjectValue((Object)1);
        selectGroupFilter.getSelectFilterList(true).add(validFilter);
        SelectGroupFilter scopeFilter = new SelectGroupFilter();
        scopeFilter.setCondOp("OR");
        SelectFieldFilter allDCFilter = new SelectFieldFilter();
        allDCFilter.setDEFName("ALLDCFLAG");
        allDCFilter.setCondOp("EQ");
        allDCFilter.setCondObjectValue((Object)1);
        scopeFilter.getSelectFilterList(true).add(allDCFilter);
        SelectFieldFilter devCenterFilter = new SelectFieldFilter();
        devCenterFilter.setDEFName("PSDEVCENTERID");
        devCenterFilter.setCondOp("EQ");
        devCenterFilter.setCondObjectValue((Object)pSSystem.getPSDevCenterId());
        scopeFilter.getSelectFilterList(true).add(devCenterFilter);
        selectGroupFilter.getSelectFilterList(true).add(scopeFilter);
        ArrayList<PSDBValueFunc> functions = iService.select((ISelectCond)selectContext);
        HashMap<String, PSDBValueFunc> functionsById = new HashMap<String, PSDBValueFunc>();
        for (PSDBValueFunc function : functions) {
            functionsById.put(function.getPSDBValueFuncId(), function);
        }
        PSSysDBVFService sysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        selectContext.reset();
        HashMap<String, PSSysDBVF> hashMap = new HashMap<String, PSSysDBVF>();
        for (PSSysDBVF sysFunction : (ArrayList<PSSysDBVF>)sysDBVFService.select((ISelectCond)selectContext)) {
            hashMap.put(sysFunction.getPSSysDBVFId(), sysFunction);
            if (StringHelper.isNullOrEmpty((String)sysFunction.getPSDBVFId())) continue;
            hashMap.put(sysFunction.getPSDBVFId(), sysFunction);
        }
        for (PSDBValueFunc function : functions) {
            String string2;
            if (hashMap.containsKey(function.getPSDBValueFuncId()) || hashMap.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)function.getPSDBValueFuncId()))) continue;
            this.initPSSysDBVF(pSSystem, function);
        }
    }

    protected void initPSSysDBVF(PSSystem pSSystem, PSDBValueFunc pSDBValueFunc) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        PSSysDBVF pSSysDBVF = new PSSysDBVF();
        pSDBValueFunc.copyTo((IDataObject)pSSysDBVF, false);
        pSSysDBVF.setPSSysDBVFName(pSDBValueFunc.getPSDBValueFuncName());
        pSSysDBVF.setPSSysDBVFId(KeyValueHelper.genUniqueId((String)string, (String)pSDBValueFunc.getPSDBValueFuncId()));
        pSSysDBVF.setPSSystemId(string);
        if (DataObject.getBoolValue((Integer)pSDBValueFunc.getAllDCFlag(), (boolean)false)) {
            pSSysDBVF.setVFType("PS");
        } else {
            pSSysDBVF.setVFType("UX");
        }
        pSSysDBVF.setPSDBVFId(pSDBValueFunc.getPSDBValueFuncId());
        pSSysDBVF.setPSDBVFName(pSDBValueFunc.getPSDBValueFuncName());
        pSSysDBVF.setInputStdDataType(pSDBValueFunc.getInputStdDataType());
        pSSysDBVF.setOutputStdDataType(pSDBValueFunc.getOutputStdDataType());
        pSSysDBVF.setCodeName(pSDBValueFunc.getCodeName());
        pSSysDBVF.setUXCodeName(pSDBValueFunc.getUXCodeName());
        EntityBase.setIgnoreCheck(pSSysDBVF, (boolean)true);
        EntityBase.setIgnoreCheckKey(pSSysDBVF, (boolean)true);
        pSSysDBVFService.create(pSSysDBVF, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysDBVFService.getDEModel().getLogicName(), (Object)pSSysDBVFService.getDEModel().getDataInfo(pSSysDBVF)));
    }

    @Override
    protected void onGetCur(PSSystem pSSystem) throws Exception {
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u4e0a\u4e0b\u6587\u6570\u636e\u65e0\u6548"));
        }
        String string = jSONObject.optString("pssystemid");
        pSSystem.setPSSystemId(string);
        this.get(pSSystem);
    }

    public DBCallResult executeBatchCreate(ArrayList<IEntity> arrayList, int n, IDataEntityModel iDataEntityModel) throws Exception {
        ISqlCommandModel iSqlCommandModel = PSSystemService.getCreateSqlCommandModel(this.getDAO().getRealDBDialect(), iDataEntityModel);
        final String[] stringArray = new String[]{iSqlCommandModel.getSql()};
        ArrayList<SqlParamList> arrayList2 = new ArrayList<SqlParamList>();
        for (IEntity iEntity : arrayList) {
            SqlParamList sqlParamList = new SqlParamList();
            iSqlCommandModel.fillSqlParams(iEntity, null, sqlParamList);
            arrayList2.add(sqlParamList);
        }
        final SqlParamList[] sqlParamListArray = arrayList2.toArray(new SqlParamList[arrayList2.size()]);
        final int batchSize = n;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemService.this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                callResult.setUserObject((Object)PSSystemService.this.getDAO().executeRawSqlBatch(null, stringArray, sqlParamListArray, batchSize));
            }
        });
        return (DBCallResult)callResult.getUserObject();
    }

    public void executeResetSysModel() throws Exception {
        this.executeResetSysModel(null);
    }

    public void executeResetSysModel(final String string) throws Exception {
        IDataEntityModel iDataEntityModel;
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            throw new Exception(StringHelper.format((String)"\u6a21\u578b\u6570\u636e\u6e90\u6709\u8bef\uff0c\u4e0d\u80fd\u4e3a\u4e3b\u6570\u636e\u6e90"));
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator = this.getSystemModel().getDataEntityModels();
        if (iterator != null) {
            while (iterator.hasNext()) {
                iDataEntityModel = (IDataEntityModel)iterator.next();
                IService iService = iDataEntityModel.getService(this.getSessionFactory());
                if (iService.getSessionFactory() != this.getSessionFactory()) continue;
                hashMap.put(iDataEntityModel.getTableName(), "");
                if (iDataEntityModel.isEnableTempData()) {
                    hashMap.put(iDataEntityModel.getTableName() + "_TMP", "");
                }
                if (iDataEntityModel.getInheritDEModel() == null) continue;
                hashMap.put(iDataEntityModel.getInheritDEModel().getTableName(), "");
                if (!iDataEntityModel.getInheritDEModel().isEnableTempData()) continue;
                hashMap.put(iDataEntityModel.getInheritDEModel().getTableName() + "_TMP", "");
            }
        }
        hashMap.put("T_SRFFILE", "");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemService.this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                for (String string2 : hashMap.keySet()) {
                    try {
                        if (!StringHelper.isNullOrEmpty((String)string)) {
                            PSSysModelInstGlobal.active(string);
                        }
                        PSSystemService.this.getDAO().executeRawSql(null, StringHelper.format((String)"truncate table %1$s;", (Object)string2), null);
                    }
                    catch (Exception exception) {
                        log.error((Object)exception);
                    }
                }
            }
        });
    }

    @Override
    public PSMOSFile[] listFiles(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            return this.listFileCats(pSMOSFile, string, iPSMOSFileFilter);
        }
        if (string.indexOf("//") == 0) {
            return null;
        }
        if (string.indexOf("{RECENTS}") == 0) {
            return this.listRecentFiles(pSMOSFile, string, iPSMOSFileFilter);
        }
        if (string.indexOf("{BOOKMARKS}") == 0) {
            return this.listBookmarkFiles(pSMOSFile, string, iPSMOSFileFilter);
        }
        if (string.indexOf("{MODELREPOS}") == 0) {
            return null;
        }
        return super.listFiles(pSMOSFile, string, iPSMOSFileFilter);
    }

    protected PSMOSFile[] listFileCats(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        PSMOSFile pSMOSFile2 = new PSMOSFile();
        pSMOSFile2.setPSMOSFileId("{RECENTS}");
        pSMOSFile2.setPSMOSFileName("\u6700\u8fd1\u8bbf\u95ee");
        pSMOSFile2.setFileTag("RECENTS");
        pSMOSFile2.setFolderFlag(1);
        pSMOSFile2.setOrderValue(100);
        arrayList.add(pSMOSFile2);
        pSMOSFile2 = new PSMOSFile();
        pSMOSFile2.setPSMOSFileId("{BOOKMARKS}");
        pSMOSFile2.setPSMOSFileName("\u4e66\u7b7e");
        pSMOSFile2.setFileTag("BOOKMARKS");
        pSMOSFile2.setFolderFlag(1);
        pSMOSFile2.setOrderValue(200);
        arrayList.add(pSMOSFile2);
        pSMOSFile2 = new PSMOSFile();
        pSMOSFile2.setPSMOSFileId("/");
        pSMOSFile2.setPSMOSFileName("\u6b64\u7cfb\u7edf");
        pSMOSFile2.setFileTag("MODEL");
        pSMOSFile2.setFolderFlag(3);
        pSMOSFile2.setPSModelType("PSSYSTEM");
        pSMOSFile2.setPSModelId(pSMOSFile.getPSModelId());
        pSMOSFile2.setOrderValue(300);
        arrayList.add(pSMOSFile2);
        pSMOSFile2 = new PSMOSFile();
        pSMOSFile2.setPSMOSFileId("{MODELREPOS}");
        pSMOSFile2.setPSMOSFileName("\u6a21\u578b\u4ed3\u5e93");
        pSMOSFile2.setFileTag("MODELREPOS");
        pSMOSFile2.setFolderFlag(1);
        pSMOSFile2.setOrderValue(400);
        arrayList.add(pSMOSFile2);
        return arrayList.toArray(new PSMOSFile[arrayList.size()]);
    }

    public PSMOSFile[] listBookmarkFiles(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        PSSysModelFolderService pSSysModelFolderService = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
        PSSysModelFolderItemService pSSysModelFolderItemService = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
        String[] stringArray = string.split("[/]");
        PSSysModelFolderBase pSSysModelFolderBase = null;
        String string3 = "{BOOKMARKS}";
        for (int i = 1; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                string2 = string2.trim();
            }
            if (StringHelper.isNullOrEmpty((String)string2)) break;
            SelectCond pathCond = new SelectCond();
            if (pSSysModelFolderBase == null) {
                pathCond.setIsNull("PPSSYSMODELFOLDERID");
            } else {
                pathCond.set("PPSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
            }
            pathCond.set("PSSYSMODELFOLDERNAME", (Object)string2);
            ArrayList<PSSysModelFolder> matchedFolders = pSSysModelFolderService.select((ISelectCond)pathCond);
            if (matchedFolders.size() == 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8def\u5f84\uff1a%1$s", (Object)string));
            }
            pSSysModelFolderBase = matchedFolders.get(0);
            string3 = string3 + "/" + string2;
        }
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        SelectCond selectCond = new SelectCond();
        selectCond.setOrderInfo("ORDER BY PSSYSMODELFOLDERNAME");
        if (pSSysModelFolderBase == null) {
            selectCond.setIsNull("PPSSYSMODELFOLDERID");
        } else {
            selectCond.set("PPSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        }
        ArrayList<PSSysModelFolder> folders = pSSysModelFolderService.select((ISelectCond)selectCond);
        for (PSSysModelFolder folder : folders) {
            PSMOSFile file = new PSMOSFile();
            file.setPSMOSFileId(string3 + "/" + folder.getPSSysModelFolderName());
            file.setPSMOSFileName(folder.getPSSysModelFolderName());
            file.setFolderFlag(1);
            file.setFileTag("MODEL");
            file.setPSModelType("PSSYSMODELFOLDER");
            file.setPSModelId(folder.getPSSysModelFolderId());
            arrayList.add(file);
        }
        selectCond.reset();
        selectCond.setOrderInfo("ORDER BY PSSYSMODELFOLDERITEMNAME");
        if (pSSysModelFolderBase == null) {
            selectCond.setIsNull("PSSYSMODELFOLDERID");
        } else {
            selectCond.set("PSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        }
        selectCond.setIsNotNull("PSOBJTYPE");
        selectCond.setIsNotNull("PSOBJID");
        ArrayList<PSSysModelFolderItem> items = pSSysModelFolderItemService.select((ISelectCond)selectCond);
        for (PSSysModelFolderItem item : items) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileId(string3 + "/" + item.getPSSysModelFolderItemName());
            pSMOSFile2.setPSMOSFileName(item.getPSSysModelFolderItemName() + "@" + PSModelV2Helper.getModelV2LogicName(item.getPSObjType()));
            pSMOSFile2.setFolderFlag(0);
            pSMOSFile2.setFileTag("MODEL");
            pSMOSFile2.setPSModelType("PSSYSMODELFOLDERITEM");
            pSMOSFile2.setPSModelId(item.getPSSysModelFolderItemId());
            arrayList.add(pSMOSFile2);
        }
        return arrayList.toArray(new PSMOSFile[arrayList.size()]);
    }

    public PSMOSFile[] listRecentFiles(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (this.getWebContext() == null || StringHelper.isNullOrEmpty((String)this.getWebContext().getCurUserId())) {
            return null;
        }
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        PSDevUserRecentService pSDevUserRecentService = (PSDevUserRecentService)ServiceGlobal.getService(PSDevUserRecentService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.setMaxRowCount(20);
        selectCond.set("OBJTYPE", (Object)"PSDATAENTITY");
        selectCond.set("PSDEVUSERID", (Object)this.getWebContext().getCurUserId());
        selectCond.setOrderInfo("ORDER BY UPDATEDATE DESC");
        ArrayList<PSDevUserRecent> arrayList2 = pSDevUserRecentService.select((ISelectCond)selectCond);
        for (PSDevUserRecent pSDevUserRecent : arrayList2) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileId("{RECENTS}/" + pSDevUserRecent.getObjName());
            pSMOSFile2.setPSMOSFileName(pSDevUserRecent.getObjName());
            pSMOSFile2.setFolderFlag(0);
            pSMOSFile2.setFileTag("MODEL");
            pSMOSFile2.setPSModelType("PSDEVUSERRECENT");
            pSMOSFile2.setPSModelId(pSDevUserRecent.getPSDevUserRecentId());
            arrayList.add(pSMOSFile2);
        }
        return arrayList.toArray(new PSMOSFile[arrayList.size()]);
    }

    static {
        defaultPSDEOPPrivMap.put("CREATE", "\u5efa\u7acb");
        defaultPSDEOPPrivMap.put("UPDATE", "\u66f4\u65b0");
        defaultPSDEOPPrivMap.put("DELETE", "\u5220\u9664");
        defaultPSDEOPPrivMap.put("READ", "\u8bfb\u53d6");
        defaultPSDEOPPrivMap.put("WFSTART", "\u6d41\u7a0b\u542f\u52a8");
        defaultPSDEOPPrivMap.put("NONE", "\u65e0\u63a7\u5236");
        defaultPSDEOPPrivMap.put("DENY", "\u62d2\u7edd");
        log = LogFactory.getLog(PSSystemService.class);
    }
}
