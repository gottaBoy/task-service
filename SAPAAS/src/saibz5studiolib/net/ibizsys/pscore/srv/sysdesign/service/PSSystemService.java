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
        return super.get((IEntity)pSSystem, bl);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSVarType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSVarType, (boolean)true);
                iService.create((IEntity)pSVarType);
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
            for (PSBackService pSBackService : arrayList2) {
                iService.save((IEntity)pSBackService);
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
            for (PSDEJoinType pSDEJoinType : arrayList) {
                EntityBase.setIgnoreCheck((IEntity)pSDEJoinType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSDEJoinType, (boolean)true);
                iService.save((IEntity)pSDEJoinType);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSDEDQPDCond, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSDEDQPDCond, (boolean)true);
                iService.create((IEntity)pSDEDQPDCond);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSDBValueOP, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSDBValueOP, (boolean)true);
                if (!hashMap.containsKey(pSDBValueOP.getPSDBValueOPId())) {
                    iService.create((IEntity)pSDBValueOP, false);
                } else {
                    iService.update((IEntity)pSDBValueOP, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSDEFDataType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSDEFDataType, (boolean)true);
                if (!hashMap.containsKey(pSDEFDataType.getPSDEFDataTypeId())) {
                    iService.create((IEntity)pSDEFDataType, false);
                } else {
                    iService.update((IEntity)pSDEFDataType, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSEditorType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSEditorType, (boolean)true);
                if (!hashMap.containsKey(pSEditorType.getPSEditorTypeId())) {
                    iService.create((IEntity)pSEditorType, false);
                } else {
                    iService.update((IEntity)pSEditorType, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSPFPluginType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSPFPluginType, (boolean)true);
                if (!hashMap.containsKey(pSPFPluginType.getPSPFPluginTypeId())) {
                    iService.create((IEntity)pSPFPluginType, false);
                } else {
                    iService.update((IEntity)pSPFPluginType, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSPortletType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSPortletType, (boolean)true);
                if (!hashMap.containsKey(pSPortletType.getPSPortletTypeId())) {
                    iService.create((IEntity)pSPortletType, false);
                } else {
                    iService.update((IEntity)pSPortletType, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSSF, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSSF, (boolean)true);
                if (!hashMap.containsKey(pSSF.getPSSFId())) {
                    iService.create((IEntity)pSSF, false);
                } else {
                    iService.update((IEntity)pSSF, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSSFStyle, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSSFStyle, (boolean)true);
                if (!hashMap.containsKey(pSSFStyle.getPSSFStyleId())) {
                    iService.create((IEntity)pSSFStyle, false);
                } else {
                    iService.update((IEntity)pSSFStyle, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSSFStyleVer, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSSFStyleVer, (boolean)true);
                if (!hashMap.containsKey(pSSFStyleVer.getPSSFStyleVerId())) {
                    iService.create((IEntity)pSSFStyleVer, false);
                } else {
                    iService.update((IEntity)pSSFStyleVer, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSPF, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSPF, (boolean)true);
                if (!hashMap.containsKey(pSPF.getPSPFId())) {
                    iService.create((IEntity)pSPF, false);
                } else {
                    iService.update((IEntity)pSPF, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSPFStyle, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSPFStyle, (boolean)true);
                if (!hashMap.containsKey(pSPFStyle.getPSPFStyleId())) {
                    iService.create((IEntity)pSPFStyle, false);
                } else {
                    iService.update((IEntity)pSPFStyle, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSDevCenterPF, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSDevCenterPF, (boolean)true);
                if (!hashMap.containsKey(pSDevCenterPF.getPSDevCenterPFId())) {
                    iService.create((IEntity)pSDevCenterPF, false);
                } else {
                    iService.update((IEntity)pSDevCenterPF, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSAppType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSAppType, (boolean)true);
                if (hashMap.containsKey(pSAppType.getPSAppTypeId())) continue;
                iService.create((IEntity)pSAppType);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSSAHandler, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSSAHandler, (boolean)true);
                if (hashMap.containsKey(pSSAHandler.getPSSAHandlerId())) continue;
                iService.create((IEntity)pSSAHandler);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSSysACHandler, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSSysACHandler, (boolean)true);
                if (hashMap.containsKey(pSSysACHandler.getPSSysACHandlerId())) continue;
                iService.create((IEntity)pSSysACHandler);
                hashMap.put(pSSysACHandler.getPSSysACHandlerId(), pSSysACHandler);
                arrayList.add(pSSysACHandler);
            }
        }
    }

    protected void initPSSysSAHandlers(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSFSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSSFSAHandlerBase)serializable2).getPSSFSAHandlerId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSFSAHandlerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSSFSAHandler)object.next();
                iService2.save((IEntity)iterator);
                hashMap.put(((PSSFSAHandlerBase)((Object)iterator)).getPSSFSAHandlerId(), iterator);
            }
        }
        iService = (PSSysSAHandlerService)ServiceGlobal.getService(PSSysSAHandlerService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSFSAHANDLERID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysSAHandler)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysSAHandlerId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSSFSAHandlerId())) continue;
            ((HashMap)object).put(entityBase.getPSSFSAHandlerId(), entityBase);
        }
        for (EntityBase entityBase : hashMap.values()) {
            String string2;
            if (StringHelper.compare((String)entityBase.getPSSFId(), (String)pSSystem.getPSSFId(), (boolean)false) != 0 || ((HashMap)object).containsKey(entityBase.getPSSFSAHandlerId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSSFSAHandlerId()))) continue;
            this.initPSSysSAHandler(pSSystem, (PSSFSAHandler)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysSAHandler, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysSAHandler, (boolean)true);
        pSSysSAHandlerService.create(pSSysSAHandler);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysSAHandlerService.getDEModel().getLogicName(), (Object)pSSysSAHandlerService.getDEModel().getDataInfo((IEntity)pSSysSAHandler)));
    }

    protected void initPSACHandlers(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSSFACHandlerBase)serializable2).getPSSFACHandlerId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSSFACHandler)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                iService2.save(iterator);
                hashMap.put(((PSSFACHandlerBase)((Object)iterator)).getPSSFACHandlerId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSFACHANDLERID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSACHandler)iterator.next();
            ((HashMap)object).put(entityBase.getPSACHandlerId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSSFACHandlerId())) continue;
            ((HashMap)object).put(entityBase.getPSSFACHandlerId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (StringHelper.compare((String)entityBase.getPSSFId(), (String)pSSystem.getPSSFId(), (boolean)false) != 0 || ((HashMap)object).containsKey(entityBase.getPSSFACHandlerId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSSFACHandlerId()))) continue;
            this.initPSACHandler(pSSystem, (PSSFACHandler)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSACHandler, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSACHandler, (boolean)true);
        if (pSACHandlerService.checkKey(pSACHandler) == 0) {
            pSACHandlerService.create(pSACHandler);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSACHandlerService.getDEModel().getLogicName(), (Object)pSACHandlerService.getDEModel().getDataInfo((IEntity)pSACHandler)));
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSViewType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSViewType, (boolean)true);
                if (!hashMap.containsKey(pSViewType.getPSViewTypeId())) {
                    iService.create((IEntity)pSViewType);
                    hashMap.put(pSViewType.getPSViewTypeId(), pSViewType);
                    arrayList.add(pSViewType);
                    continue;
                }
                iService.update((IEntity)pSViewType);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSViewTypeCat, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSViewTypeCat, (boolean)true);
                if (!hashMap.containsKey(pSViewTypeCat.getPSViewTypeCatId())) {
                    iService.create((IEntity)pSViewTypeCat);
                    hashMap.put(pSViewTypeCat.getPSViewTypeCatId(), pSViewTypeCat);
                    arrayList.add(pSViewTypeCat);
                    continue;
                }
                iService.update((IEntity)pSViewTypeCat);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSVTCatDetail, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSVTCatDetail, (boolean)true);
                if (!hashMap.containsKey(pSVTCatDetail.getPSVTCatDetailId())) {
                    iService.create((IEntity)pSVTCatDetail);
                    hashMap.put(pSVTCatDetail.getPSVTCatDetailId(), pSVTCatDetail);
                    arrayList.add(pSVTCatDetail);
                    continue;
                }
                iService.update((IEntity)pSVTCatDetail);
                hashMap.put(pSVTCatDetail.getPSVTCatDetailId(), pSVTCatDetail);
                arrayList.add(pSVTCatDetail);
            }
        }
    }

    protected void initPSDEUIActions(PSSystem pSSystem, Map<String, String> map) throws Exception {
        EntityBase entityBase2;
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSSysUIActionBase)serializable2).getPSSysUIActionId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSSysUIAction)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (!hashMap.containsKey(((PSSysUIActionBase)((Object)iterator)).getPSSysUIActionId())) {
                    iService2.create(iterator);
                    hashMap.put(((PSSysUIActionBase)((Object)iterator)).getPSSysUIActionId(), iterator);
                    arrayList.add(iterator);
                    continue;
                }
                entityBase2 = (PSSysUIAction)hashMap.get(((PSSysUIActionBase)((Object)iterator)).getPSSysUIActionId());
                boolean bl = false;
                if (StringHelper.isNullOrEmpty((String)entityBase2.getCapPSSysLanResId()) && !StringHelper.isNullOrEmpty((String)((PSSysUIActionBase)((Object)iterator)).getCapPSSysLanResId())) {
                    bl = true;
                    entityBase2.setCapPSSysLanResId(((PSSysUIActionBase)((Object)iterator)).getCapPSSysLanResId());
                }
                if (StringHelper.isNullOrEmpty((String)entityBase2.getTipPSSysLanResId()) && !StringHelper.isNullOrEmpty((String)((PSSysUIActionBase)((Object)iterator)).getTipPSSysLanResId())) {
                    bl = true;
                    entityBase2.setTipPSSysLanResId(((PSSysUIActionBase)((Object)iterator)).getTipPSSysLanResId());
                }
                if (!bl) continue;
                iService2.update((IEntity)entityBase2);
                hashMap.put(((PSSysUIActionBase)((Object)iterator)).getPSSysUIActionId(), entityBase2);
                arrayList.add(entityBase2);
            }
        }
        iService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSYSUIACTIONID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            entityBase2 = (PSDEUIAction)iterator.next();
            ((HashMap)object).put(entityBase2.getPSDEUIActionId(), entityBase2);
            if (StringHelper.isNullOrEmpty((String)entityBase2.getPSSysUIActionId())) continue;
            ((HashMap)object).put(entityBase2.getPSSysUIActionId(), entityBase2);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSUIACTION", (Object)entityBase2.getPSSysUIActionId()), entityBase2.getPSDEUIActionId());
        }
        for (EntityBase entityBase2 : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase2.getPSSysUIActionId())) continue;
            String string3 = KeyValueHelper.genUniqueId((String)string, (String)entityBase2.getPSSysUIActionId());
            if (!((HashMap)object).containsKey(string3)) {
                this.initPSDEUIAction(pSSystem, (PSSysUIAction)entityBase2, map);
                map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSUIACTION", (Object)entityBase2.getPSSysUIActionId()), string3);
                continue;
            }
            PSDEUIAction pSDEUIAction = (PSDEUIAction)((HashMap)object).get(string3);
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
            if (pSDEOPPrivService.get((IEntity)pSDEOPPriv, true)) {
                pSDEUIAction.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
                pSDEUIAction.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
            }
        }
        EntityBase.setIgnoreCheck((IEntity)pSDEUIAction, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSDEUIAction, (boolean)true);
        pSDEUIActionService.create(pSDEUIAction);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSDEUIActionService.getDEModel().getLogicName(), (Object)pSDEUIActionService.getDEModel().getDataInfo((IEntity)pSDEUIAction)));
    }

    protected void initPSSysValueRules(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSValueRuleBase)serializable2).getPSValueRuleId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSValueRule)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSValueRuleBase)((Object)iterator)).getPSValueRuleId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSValueRuleBase)((Object)iterator)).getPSValueRuleId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSVALUERULEID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysValueRule)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysValueRuleId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSValueRuleId())) continue;
            ((HashMap)object).put(entityBase.getPSValueRuleId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSValueRuleId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSValueRuleId()))) continue;
            this.initPSSysValueRule(pSSystem, (PSValueRule)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysValueRule, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysValueRule, (boolean)true);
        pSSysValueRuleService.create(pSSysValueRule);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysValueRuleService.getDEModel().getLogicName(), (Object)pSSysValueRuleService.getDEModel().getDataInfo((IEntity)pSSysValueRule)));
    }

    protected void initPSSysImages(PSSystem pSSystem, Map<String, String> map) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSImageTemplBase)serializable2).getPSImageTemplId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSImageTempl)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSImageTemplBase)((Object)iterator)).getPSImageTemplId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSImageTemplBase)((Object)iterator)).getPSImageTemplId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSIMAGETEMPLID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysImage)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysImageId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSImageTemplId())) continue;
            ((HashMap)object).put(entityBase.getPSImageTemplId(), entityBase);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSIMAGETEMPL", (Object)entityBase.getPSImageTemplId()), entityBase.getPSSysImageId());
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSImageTemplId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSImageTemplId()))) continue;
            this.initPSSysImage(pSSystem, (PSImageTempl)entityBase);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSIMAGETEMPL", (Object)entityBase.getPSImageTemplId()), string2);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysImage, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysImage, (boolean)true);
        pSSysImageService.create(pSSysImage, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysImageService.getDEModel().getLogicName(), (Object)pSSysImageService.getDEModel().getDataInfo((IEntity)pSSysImage)));
    }

    protected void initPSSysCssCats(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSCssCatTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSCssCatTemplBase)serializable2).getPSCssCatTemplId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSCssCatTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSCssCatTempl)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSCssCatTemplBase)((Object)iterator)).getPSCssCatTemplId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSCssCatTemplBase)((Object)iterator)).getPSCssCatTemplId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCSSCATTEMPLID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysCssCat)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysCssCatId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSCssCatTemplId())) continue;
            ((HashMap)object).put(entityBase.getPSCssCatTemplId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSCssCatTemplId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSCssCatTemplId()))) continue;
            this.initPSSysCssCat(pSSystem, (PSCssCatTempl)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysCssCat, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysCssCat, (boolean)true);
        pSSysCssCatService.create(pSSysCssCat, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysCssCatService.getDEModel().getLogicName(), (Object)pSSysCssCatService.getDEModel().getDataInfo((IEntity)pSSysCssCat)));
    }

    protected void initPSSysCsses(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSCssTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSCssTemplBase)serializable2).getPSCssTemplId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSCssTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSCssTempl)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSCssTemplBase)((Object)iterator)).getPSCssTemplId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSCssTemplBase)((Object)iterator)).getPSCssTemplId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCSSTEMPLID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysCss)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysCssId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSCssTemplId())) continue;
            ((HashMap)object).put(entityBase.getPSCssTemplId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSCssTemplId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSCssTemplId()))) continue;
            this.initPSSysCss(pSSystem, (PSCssTempl)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysCss, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysCss, (boolean)true);
        pSSysCssService.create(pSSysCss, false);
    }

    protected void initPSSysCounters(PSSystem pSSystem) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        Serializable serializable;
        String string = pSSystem.getPSSystemId();
        IService iService = ServiceGlobal.getService(PSCounterService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        Serializable serializable2 = iService.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        IService iService2 = ((ArrayList)serializable2).iterator();
        while (iService2.hasNext()) {
            serializable = (PSCounter)iService2.next();
            hashMap.put(((PSCounterBase)serializable).getPSCounterId(), serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService2 = ServiceGlobal.getService(PSCounterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable).iterator();
            while (object2.hasNext()) {
                object = (PSCounter)object2.next();
                if (!hashMap.containsKey(((PSCounterBase)object).getPSCounterId())) {
                    EntityBase.setIgnoreCheck((IEntity)object, (boolean)true);
                    EntityBase.setIgnoreCheckKey(object, (boolean)true);
                    iService.create(object);
                    hashMap.put(((PSCounterBase)object).getPSCounterId(), object);
                    ((ArrayList)serializable2).add(object);
                    continue;
                }
                entityBase = (PSCounter)hashMap.get(((PSCounterBase)object).getPSCounterId());
                if (StringHelper.compare((String)entityBase.getBaseClsParams(), (String)((PSCounterBase)object).getBaseClsParams(), (boolean)false) != 0) {
                    object.copyTo((IDataObject)entityBase, true);
                    EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)true);
                    EntityBase.setIgnoreCheckKey((IEntity)entityBase, (boolean)true);
                    iService.update((IEntity)entityBase, false);
                }
                hashMap.put(((PSCounterBase)object).getPSCounterId(), entityBase);
            }
            serializable2 = serializable;
        }
        iService2 = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCOUNTERID");
        serializable = iService2.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable).iterator();
        while (object.hasNext()) {
            entityBase = (PSSysCounter)object.next();
            ((HashMap)object2).put(entityBase.getPSSysCounterId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSCounterId())) continue;
            ((HashMap)object2).put(entityBase.getPSCounterId(), entityBase);
        }
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            entityBase = (PSCounter)object.next();
            if (((HashMap)object2).containsKey(entityBase.getPSCounterId())) continue;
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSCounterId());
            if (!((HashMap)object2).containsKey(string2)) {
                this.initPSSysCounter(pSSystem, (PSCounter)entityBase, true);
                continue;
            }
            PSSysCounter pSSysCounter = (PSSysCounter)((HashMap)object2).get(string2);
            if (StringHelper.compare((String)pSSysCounter.getBaseClsParams(), (String)entityBase.getBaseClsParams(), (boolean)false) == 0) continue;
            this.initPSSysCounter(pSSystem, (PSCounter)entityBase, false);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysCounter, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysCounter, (boolean)true);
        if (bl) {
            pSSysCounterService.create(pSSysCounter, false);
        } else {
            pSSysCounterService.update(pSSysCounter, false);
        }
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysCounterService.getDEModel().getLogicName(), (Object)pSSysCounterService.getDEModel().getDataInfo((IEntity)pSSysCounter)));
    }

    protected void initPSSysPortlets(PSSystem pSSystem, Map<String, String> map) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSPortletService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSPortletBase)serializable2).getPSPortletId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSPortletService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSPortlet)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSPortletBase)((Object)iterator)).getPSPortletId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSPortletBase)((Object)iterator)).getPSPortletId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSPORTLETID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysPortlet)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysPortletId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSPortletId())) continue;
            ((HashMap)object).put(entityBase.getPSPortletId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSPortletId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSPortletId()))) continue;
            this.initPSSysPortlet(pSSystem, (PSPortlet)entityBase, map);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysPortlet, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysPortlet, (boolean)true);
        pSSysPortletService.create(pSSysPortlet);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPortletService.getDEModel().getLogicName(), (Object)pSSysPortletService.getDEModel().getDataInfo((IEntity)pSSysPortlet)));
    }

    protected void initPSDEToolbars(PSSystem pSSystem, Map<String, String> map) throws Exception {
        Object object;
        EntityBase entityBase2;
        Iterator iterator;
        Cloneable cloneable;
        IService iService;
        Object object22;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)this.getSessionFactory());
        IService iService3 = ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, EntityBase> hashMap = new HashMap<String, EntityBase>();
        for (Object object22 : arrayList) {
            hashMap.put(((PSSysToolbarBase)object22).getPSSysToolbarId(), (EntityBase)object22);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            object22 = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            cloneable = iService.select((ISelectCond)selectCond);
            iterator = ((ArrayList)cloneable).iterator();
            while (iterator.hasNext()) {
                entityBase2 = (PSSysToolbar)iterator.next();
                if (hashMap.containsKey(entityBase2.getPSSysToolbarId())) continue;
                object = ((PSSysTBItemServiceBase)object22).selectByPSSysToolbar((PSSysToolbarBase)entityBase2);
                PSSysTBItemService.sortHierarchyEntities(object, (String)"PSSYSTBITEMID", (String)"PPSSYSTBITEMID");
                EntityBase.setIgnoreCheck((IEntity)entityBase2, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)entityBase2, (boolean)true);
                iService2.create((IEntity)entityBase2);
                hashMap.put(entityBase2.getPSSysToolbarId(), entityBase2);
                arrayList.add(entityBase2);
                Iterator iterator2 = ((ArrayList)object).iterator();
                while (iterator2.hasNext()) {
                    PSSysTBItem pSSysTBItem = (PSSysTBItem)iterator2.next();
                    EntityBase.setIgnoreCheck((IEntity)pSSysTBItem, (boolean)true);
                    EntityBase.setIgnoreCheckKey((IEntity)pSSysTBItem, (boolean)true);
                    iService3.create((IEntity)pSSysTBItem);
                }
            }
        }
        iService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSYSTOOLBARID");
        object22 = iService.select((ISelectCond)selectCond);
        cloneable = new HashMap();
        iterator = ((ArrayList)object22).iterator();
        while (iterator.hasNext()) {
            entityBase2 = (PSDEToolbar)iterator.next();
            ((HashMap)cloneable).put(entityBase2.getPSDEToolbarId(), entityBase2);
            if (StringHelper.isNullOrEmpty((String)entityBase2.getPSSysToolbarId())) continue;
            ((HashMap)cloneable).put(entityBase2.getPSSysToolbarId(), entityBase2);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSTOOLBAR", (Object)entityBase2.getPSSysToolbarId()), entityBase2.getPSDEToolbarId());
        }
        for (EntityBase entityBase2 : arrayList) {
            if (((HashMap)cloneable).containsKey(entityBase2.getPSSysToolbarId()) || ((HashMap)cloneable).containsKey(object = KeyValueHelper.genUniqueId((String)string, (String)entityBase2.getPSSysToolbarId()))) continue;
            this.initPSDEToolbar(pSSystem, (PSSysToolbar)entityBase2, map);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSSYSTOOLBAR", (Object)entityBase2.getPSSysToolbarId()), (String)object);
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
        EntityBase.setIgnoreCheck((IEntity)pSDEToolbar, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSDEToolbar, (boolean)true);
        pSDEToolbarService.create(pSDEToolbar);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSDEToolbarService.getDEModel().getLogicName(), (Object)pSDEToolbarService.getDEModel().getDataInfo((IEntity)pSDEToolbar)));
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
            EntityBase.setIgnoreCheck((IEntity)pSDETBItem, (boolean)true);
            EntityBase.setIgnoreCheckKey((IEntity)pSDETBItem, (boolean)true);
            pSDETBItemService.create(pSDETBItem);
            hashMap.put(pSSysTBItem.getPSSysTBItemId(), pSDETBItem.getPSDETBItemId());
        }
    }

    protected void initPSSysPFPlugins(PSSystem pSSystem, Map<String, String> map) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)this.getSessionFactory());
        IService iService3 = ServiceGlobal.getService(PSPFPluginTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, PSPFPlugin> hashMap = new HashMap<String, PSPFPlugin>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSPFPluginBase)serializable2).getPSPFPluginId(), (PSPFPlugin)serializable2);
        }
        arrayList.clear();
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            selectCond.set("ALLDCFLAG", (Object)1);
            selectCond.set("VALIDFLAG", (Object)1);
            serializable2 = iService.select((ISelectCond)selectCond);
            if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevCenterId())) {
                selectCond.reset();
                selectCond.set("ALLDCFLAG", (Object)0);
                selectCond.set("VALIDFLAG", (Object)1);
                selectCond.set("PSDCID", (Object)pSSystem.getPSDevCenterId());
                object2 = iService.select((ISelectCond)selectCond);
                ((ArrayList)serializable2).addAll(object2);
            }
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSPFPlugin)object2.next();
                EntityBase.setIgnoreCheck((IEntity)object, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)object, (boolean)true);
                if (!hashMap.containsKey(((PSPFPluginBase)object).getPSPFPluginId())) {
                    iService2.create((IEntity)object);
                }
                arrayList.add(object);
            }
        }
        iService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSPFPLUGINID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSSysPFPlugin)object.next();
            ((HashMap)object2).put(entityBase.getPSSysPFPluginId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSPFPluginId())) continue;
            ((HashMap)object2).put(entityBase.getPSPFPluginId(), entityBase);
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSPFPLUGIN", (Object)entityBase.getPSPFPluginId()), entityBase.getPSSysPFPluginId());
        }
        for (EntityBase entityBase : arrayList) {
            if (((HashMap)object2).containsKey(entityBase.getPSPFPluginId())) continue;
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSPFPluginId());
            if (!((HashMap)object2).containsKey(string2)) {
                this.initPSSysPFPlugin(pSSystem, (PSPFPlugin)entityBase, true);
            } else {
                this.initPSSysPFPlugin(pSSystem, (PSPFPlugin)entityBase, false);
            }
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSPFPLUGIN", (Object)entityBase.getPSPFPluginId()), string2);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysPFPlugin, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysPFPlugin, (boolean)true);
        if (bl) {
            pSSysPFPluginService.create(pSSysPFPlugin);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPFPluginService.getDEModel().getLogicName(), (Object)pSSysPFPluginService.getDEModel().getDataInfo((IEntity)pSSysPFPlugin)));
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
            EntityBase.setIgnoreCheck((IEntity)pSSysPFPITempl, (boolean)true);
            EntityBase.setIgnoreCheckKey((IEntity)pSSysPFPITempl, (boolean)true);
            if (pSSysPFPITemplService.checkKey(pSSysPFPITempl) != 0) continue;
            pSSysPFPITemplService.create(pSSysPFPITempl);
            ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPFPITemplService.getDEModel().getLogicName(), (Object)pSSysPFPITemplService.getDEModel().getDataInfo((IEntity)pSSysPFPITempl)));
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
                    EntityBase.setIgnoreCheck((IEntity)pSDEOPPriv, (boolean)true);
                    EntityBase.setIgnoreCheckKey((IEntity)pSDEOPPriv, (boolean)true);
                    pSDEOPPrivService.create(pSDEOPPriv);
                    ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSDEOPPrivService.getDEModel().getLogicName(), (Object)pSDEOPPrivService.getDEModel().getDataInfo((IEntity)pSDEOPPriv)));
                    continue;
                }
                map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSDEOPPRIV", (Object)string), pSDEOPPriv2.getPSDEOPPrivId());
                continue;
            }
            map.put(StringHelper.format((String)"%1$s#%2$s", (Object)"PSDEOPPRIV", (Object)string), pSDEOPPriv.getPSDEOPPrivId());
        }
    }

    protected void initPSCodeListTempl(PSSystem pSSystem) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSCodeListTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSCodeListTemplBase)serializable2).getPSCodeListTemplId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSCodeListTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSCodeListTempl)object2.next();
                if (hashMap.containsKey(((PSCodeListTemplBase)object).getPSCodeListTemplId())) continue;
                EntityBase.setIgnoreCheck((IEntity)object, (boolean)true);
                EntityBase.setIgnoreCheckKey(object, (boolean)true);
                iService2.create(object);
                hashMap.put(((PSCodeListTemplBase)object).getPSCodeListTemplId(), object);
                arrayList.add(object);
            }
        }
        iService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSCODELISTTEMPLID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSCodeList)object.next();
            ((HashMap)object2).put(entityBase.getPSCodeListId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSCodeListTemplId())) continue;
            ((HashMap)object2).put(entityBase.getPSCodeListTemplId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object2).containsKey(entityBase.getPSCodeListTemplId()) || ((HashMap)object2).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSCodeListTemplId()))) continue;
            this.initPSCodeList(pSSystem, (PSCodeListTempl)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSCodeList, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSCodeList, (boolean)true);
        pSCodeListService.create(pSCodeList);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSCodeListService.getDEModel().getLogicName(), (Object)pSCodeListService.getDEModel().getDataInfo((IEntity)pSCodeList)));
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
        EntityBase.setIgnoreCheck((IEntity)pSCodeItem2, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSCodeItem2, (boolean)true);
        iService.create((IEntity)pSCodeItem2);
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        for (int i = 0; i < codeItemConfig.getCodeItems().size(); ++i) {
            CodeItemConfig codeItemConfig2 = (CodeItemConfig)((Object)codeItemConfig.getCodeItems().get(i));
            this.initPSCodeItem(pSCodeList, pSCodeItem2, codeItemConfig2, i);
        }
    }

    protected void initPSSysPDTViews(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSPDTViewService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSPDTViewBase)serializable2).getPSPDTViewId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSPDTViewService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSPDTView)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSPDTViewBase)((Object)iterator)).getPSPDTViewId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSPDTViewBase)((Object)iterator)).getPSPDTViewId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSPDTVIEWID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysPDTView)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysPDTViewId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSPDTViewId())) continue;
            ((HashMap)object).put(entityBase.getPSPDTViewId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSPDTViewId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSPDTViewId()))) continue;
            this.initPSSysPDTView(pSSystem, (PSPDTView)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysPDTView, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysPDTView, (boolean)true);
        pSSysPDTViewService.create(pSSysPDTView);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysPDTViewService.getDEModel().getLogicName(), (Object)pSSysPDTViewService.getDEModel().getDataInfo((IEntity)pSSysPDTView)));
    }

    protected void initPSSysViewLogics(PSSystem pSSystem) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSViewLogicTypeBase)serializable2).getPSViewLogicTypeId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSViewLogicType)object2.next();
                if (StringHelper.compare((String)((PSViewLogicTypeBase)object).getPSViewLogicTypeId(), (String)"VIEW_DELOGIC", (boolean)true) == 0) continue;
                EntityBase.setIgnoreCheck(object, (boolean)true);
                EntityBase.setIgnoreCheckKey(object, (boolean)true);
                if (hashMap.containsKey(((PSViewLogicTypeBase)object).getPSViewLogicTypeId())) continue;
                iService2.create(object);
                hashMap.put(((PSViewLogicTypeBase)object).getPSViewLogicTypeId(), object);
                arrayList.add(object);
            }
        }
        iService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSSysViewLogic)object.next();
            ((HashMap)object2).put(entityBase.getPSSysViewLogicId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSViewLogicTypeId());
            if (((HashMap)object2).containsKey(string2)) continue;
            this.initPSSysViewLogic(pSSystem, (PSViewLogicType)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysViewLogic, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysViewLogic, (boolean)true);
        pSSysViewLogicService.create(pSSysViewLogic);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysViewLogicService.getDEModel().getLogicName(), (Object)pSSysViewLogicService.getDEModel().getDataInfo((IEntity)pSSysViewLogic)));
    }

    protected void initPSSysEditorStyles(PSSystem pSSystem) throws Exception {
        Iterator iterator;
        Object object;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSEditorStyleBase)serializable2).getPSEditorStyleId(), serializable2);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService = ServiceGlobal.getService(PSEditorStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable2).iterator();
            while (object.hasNext()) {
                iterator = (PSEditorStyle)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (hashMap.containsKey(((PSEditorStyleBase)((Object)iterator)).getPSEditorStyleId())) continue;
                iService2.create(iterator);
                hashMap.put(((PSEditorStyleBase)((Object)iterator)).getPSEditorStyleId(), iterator);
                arrayList.add(iterator);
            }
        }
        iService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSEDITORSTYLEID");
        serializable2 = iService.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            EntityBase entityBase = (PSSysEditorStyle)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysEditorStyleId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSEditorStyleId())) continue;
            ((HashMap)object).put(entityBase.getPSEditorStyleId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2;
            if (((HashMap)object).containsKey(entityBase.getPSEditorStyleId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSEditorStyleId()))) continue;
            this.initPSSysEditorStyle(pSSystem, (PSEditorStyle)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysEditorStyle, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysEditorStyle, (boolean)true);
        pSSysEditorStyleService.create(pSSysEditorStyle, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysEditorStyleService.getDEModel().getLogicName(), (Object)pSSysEditorStyleService.getDEModel().getDataInfo((IEntity)pSSysEditorStyle)));
    }

    protected void initPSPDTAppFunc() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPDTAppFuncService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPDTAppFunc> hashMap = new HashMap<String, PSPDTAppFunc>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSPDTAppFuncBase)serializable).getPSPDTAppFuncId(), (PSPDTAppFunc)serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPDTAppFuncService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPDTAppFunc pSPDTAppFunc = (PSPDTAppFunc)iterator.next();
                EntityBase.setIgnoreCheck((IEntity)pSPDTAppFunc, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSPDTAppFunc, (boolean)true);
                if (!hashMap.containsKey(pSPDTAppFunc.getPSPDTAppFuncId())) {
                    iService.create((IEntity)pSPDTAppFunc);
                    hashMap.put(pSPDTAppFunc.getPSPDTAppFuncId(), pSPDTAppFunc);
                    arrayList.add(pSPDTAppFunc);
                    continue;
                }
                iService.update((IEntity)pSPDTAppFunc);
                hashMap.put(pSPDTAppFunc.getPSPDTAppFuncId(), pSPDTAppFunc);
                arrayList.add(pSPDTAppFunc);
            }
        }
    }

    protected void initPSSysSampleValues(PSSystem pSSystem) throws Exception {
        EntityBase entityBase;
        Iterator iterator;
        Object object;
        Serializable serializable;
        String string = pSSystem.getPSSystemId();
        IService iService = ServiceGlobal.getService(PSSampleValueService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        Serializable serializable2 = iService.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        IService iService2 = ((ArrayList)serializable2).iterator();
        while (iService2.hasNext()) {
            serializable = (PSSampleValue)iService2.next();
            hashMap.put(((PSSampleValueBase)serializable).getPSSampleValueId(), serializable);
        }
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            iService2 = ServiceGlobal.getService(PSSampleValueService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            object = ((ArrayList)serializable).iterator();
            while (object.hasNext()) {
                iterator = (PSSampleValue)object.next();
                EntityBase.setIgnoreCheck((IEntity)iterator, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)iterator, (boolean)true);
                if (!hashMap.containsKey(((PSSampleValueBase)((Object)iterator)).getPSSampleValueId())) {
                    iService.create(iterator);
                    hashMap.put(((PSSampleValueBase)((Object)iterator)).getPSSampleValueId(), iterator);
                    ((ArrayList)serializable2).add(iterator);
                    continue;
                }
                hashMap.put(((PSSampleValueBase)((Object)iterator)).getPSSampleValueId(), iterator);
            }
            serializable2 = serializable;
        }
        iService2 = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.setIsNotNull("PSSAMPLEVALUEID");
        serializable = iService2.select((ISelectCond)selectCond);
        object = new HashMap();
        iterator = ((ArrayList)serializable).iterator();
        while (iterator.hasNext()) {
            entityBase = (PSSysSampleValue)iterator.next();
            ((HashMap)object).put(entityBase.getPSSysSampleValueId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSSampleValueId())) continue;
            ((HashMap)object).put(entityBase.getPSSampleValueId(), entityBase);
        }
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            String string2;
            entityBase = (PSSampleValue)iterator.next();
            if (((HashMap)object).containsKey(entityBase.getPSSampleValueId()) || ((HashMap)object).containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSSampleValueId()))) continue;
            this.initPSSysSampleValue(pSSystem, (PSSampleValue)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysSampleValue, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysSampleValue, (boolean)true);
        pSSysSampleValueService.create(pSSysSampleValue);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysSampleValueService.getDEModel().getLogicName(), (Object)pSSysSampleValueService.getDEModel().getDataInfo((IEntity)pSSysSampleValue)));
    }

    protected void initPSCounterType() throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSCounterTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSCounterType> hashMap = new HashMap<String, PSCounterType>();
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSCounterType, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSCounterType, (boolean)true);
                if (!hashMap.containsKey(pSCounterType.getPSCounterTypeId())) {
                    iService.create((IEntity)pSCounterType, false);
                } else {
                    iService.update((IEntity)pSCounterType, false);
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
        for (Serializable serializable : arrayList) {
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
                EntityBase.setIgnoreCheck((IEntity)pSLanguage, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)pSLanguage, (boolean)true);
                if (!hashMap.containsKey(pSLanguage.getPSLanguageId())) {
                    iService.create((IEntity)pSLanguage, false);
                } else {
                    iService.update((IEntity)pSLanguage, false);
                }
                hashMap.put(pSLanguage.getPSLanguageId(), pSLanguage);
                arrayList.add(pSLanguage);
            }
        }
    }

    protected void initPSLanguageRes(PSSystem pSSystem, Map<String, String> map) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        Serializable serializable2;
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        for (Serializable serializable2 : arrayList) {
            object2 = StringHelper.format((String)"PSSYSLANRES#%1$s", (Object)((PSSysLanResBase)serializable2).getPSSysLanResId());
            object = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)((PSSysLanResBase)serializable2).getPSSysLanResId());
            map.put((String)object2, (String)object);
            entityBase = new PSLanguageRes();
            entityBase.setPSSystemId(pSSystem.getPSSystemId());
            entityBase.setLanResType(((PSSysLanResBase)serializable2).getLanResType());
            entityBase.setUserData(((PSSysLanResBase)serializable2).getUserData());
            if (!pSLanguageResService.select(entityBase, true)) {
                entityBase.setPSLanguageResId((String)object);
                EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)entityBase, (boolean)true);
                if (pSLanguageResService.checkKey(entityBase) != 0) continue;
                entityBase.setPSLanguageResName(((PSSysLanResBase)serializable2).getPSSysLanResName());
                entityBase.setPSSystemId(pSSystem.getPSSystemId());
                entityBase.setPSSystemName(pSSystem.getPSSystemName());
                entityBase.setLanResType(((PSSysLanResBase)serializable2).getLanResType());
                entityBase.setUserData(((PSSysLanResBase)serializable2).getUserData());
                entityBase.setContent(((PSSysLanResBase)serializable2).getContent());
                pSLanguageResService.create(entityBase, false);
                continue;
            }
            if (StringHelper.compare((String)object, (String)entityBase.getPSLanguageResId(), (boolean)true) == 0) continue;
            hashMap.put(((PSSysLanResBase)serializable2).getPSSysLanResId(), "");
            map.put((String)object2, entityBase.getPSLanguageResId());
        }
        IService iService2 = ServiceGlobal.getService(PSSysLanItemService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        serializable2 = iService2.select((ISelectCond)selectCond);
        object2 = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            entityBase = (PSSysLanItem)object.next();
            if (hashMap.containsKey(entityBase.getPSSysLanResId())) continue;
            PSLanguageItem pSLanguageItem = new PSLanguageItem();
            pSLanguageItem.setPSLanguageItemId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)entityBase.getPSSysLanItemId()));
            if (((PSCoreSysServiceBase)object2).checkKey(pSLanguageItem) != 0) continue;
            pSLanguageItem.setPSLanguageItemName(entityBase.getPSSysLanItemId());
            pSLanguageItem.setPSSystemId(pSSystem.getPSSystemId());
            pSLanguageItem.setPSSystemName(pSSystem.getPSSystemName());
            pSLanguageItem.setPSLanguageId(entityBase.getPSLanguageId());
            pSLanguageItem.setPSLanguageName(entityBase.getPSLanguageName());
            pSLanguageItem.setPSLanguageResId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)entityBase.getPSSysLanResId()));
            pSLanguageItem.setPSLanguageResName(entityBase.getPSSysLanResName());
            pSLanguageItem.setContent(entityBase.getContent());
            EntityBase.setIgnoreCheck((IEntity)pSLanguageItem, (boolean)true);
            EntityBase.setIgnoreCheckKey((IEntity)pSLanguageItem, (boolean)true);
            ((PSCoreSysServiceBase)object2).create(pSLanguageItem, false);
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
        this.get((IEntity)pSSystem);
        if (DataObject.getIntegerValue((Object)pSSystem.getEntityCnt(), (Integer)-1) < 0) {
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
        this.get((IEntity)pSSystem);
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(pSSystem.getPSDevSlnSysId());
            pSDevSlnSysService.get((IEntity)pSDevSlnSys);
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
        EntityBase entityBase;
        Serializable serializable;
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return;
        }
        String string = pSSystem.getPSSystemId();
        IService iService = ServiceGlobal.getService(PSDBValueFuncService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectContext selectContext = new SelectContext();
        SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
        selectGroupFilter.setCondOp("AND");
        selectContext.setSelectFilter((ISelectFilter)selectGroupFilter);
        Object object = new SelectFieldFilter();
        object.setDEFName("VALIDFLAG");
        object.setCondOp("EQ");
        object.setCondObjectValue((Object)1);
        selectGroupFilter.getSelectFilterList(true).add(object);
        object = new SelectGroupFilter();
        object.setCondOp("OR");
        Object object2 = new SelectFieldFilter();
        object2.setDEFName("ALLDCFLAG");
        object2.setCondOp("EQ");
        object2.setCondObjectValue((Object)1);
        object.getSelectFilterList(true).add(object2);
        object2 = new SelectFieldFilter();
        object2.setDEFName("PSDEVCENTERID");
        object2.setCondOp("EQ");
        object2.setCondObjectValue((Object)pSSystem.getPSDevCenterId());
        object.getSelectFilterList(true).add(object2);
        selectGroupFilter.getSelectFilterList(true).add(object);
        object = iService.select((ISelectCond)selectContext);
        object2 = new HashMap();
        Object object3 = ((ArrayList)object).iterator();
        while (object3.hasNext()) {
            serializable = (PSDBValueFunc)object3.next();
            ((HashMap)object2).put(((PSDBValueFuncBase)serializable).getPSDBValueFuncId(), serializable);
        }
        object3 = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
        selectContext.reset();
        serializable = object3.select((ISelectCond)selectContext);
        HashMap<String, EntityBase> hashMap = new HashMap<String, EntityBase>();
        Iterator iterator = ((ArrayList)serializable).iterator();
        while (iterator.hasNext()) {
            entityBase = (PSSysDBVF)iterator.next();
            hashMap.put(entityBase.getPSSysDBVFId(), entityBase);
            if (StringHelper.isNullOrEmpty((String)entityBase.getPSDBVFId())) continue;
            hashMap.put(entityBase.getPSDBVFId(), entityBase);
        }
        iterator = ((ArrayList)object).iterator();
        while (iterator.hasNext()) {
            String string2;
            entityBase = (PSDBValueFunc)iterator.next();
            if (hashMap.containsKey(entityBase.getPSDBValueFuncId()) || hashMap.containsKey(string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSDBValueFuncId()))) continue;
            this.initPSSysDBVF(pSSystem, (PSDBValueFunc)entityBase);
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
        EntityBase.setIgnoreCheck((IEntity)pSSysDBVF, (boolean)true);
        EntityBase.setIgnoreCheckKey((IEntity)pSSysDBVF, (boolean)true);
        pSSysDBVFService.create(pSSysDBVF, false);
        ActionSessionManager.appendActionInfo((String)StringHelper.format((String)"[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)pSSysDBVFService.getDEModel().getLogicName(), (Object)pSSysDBVFService.getDEModel().getDataInfo((IEntity)pSSysDBVF)));
    }

    @Override
    protected void onGetCur(PSSystem pSSystem) throws Exception {
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u4e0a\u4e0b\u6587\u6570\u636e\u65e0\u6548"));
        }
        String string = jSONObject.optString("pssystemid");
        pSSystem.setPSSystemId(string);
        this.get((IEntity)pSSystem);
    }

    public DBCallResult executeBatchCreate(ArrayList<IEntity> arrayList, int n, IDataEntityModel iDataEntityModel) throws Exception {
        SqlParamList sqlParamList;
        ISqlCommandModel iSqlCommandModel = PSSystemService.getCreateSqlCommandModel(this.getDAO().getRealDBDialect(), iDataEntityModel);
        String[] stringArray = new String[]{iSqlCommandModel.getSql()};
        ArrayList<SqlParamList> arrayList2 = new ArrayList<SqlParamList>();
        for (IEntity iEntity : arrayList) {
            sqlParamList = new SqlParamList();
            iSqlCommandModel.fillSqlParams(iEntity, null, sqlParamList);
            arrayList2.add(sqlParamList);
        }
        SqlParamList[] sqlParamListArray = arrayList2.toArray(new SqlParamList[arrayList2.size()]);
        int n2 = n;
        sqlParamList = new CallResult();
        this.doServiceWork(new IServiceWork((CallResult)sqlParamList, stringArray, sqlParamListArray, n2){
            final /* synthetic */ CallResult val$callResult;
            final /* synthetic */ String[] val$sqls2;
            final /* synthetic */ SqlParamList[] val$sqlParamLists2;
            final /* synthetic */ int val$nBatchSize2;
            {
                this.val$callResult = callResult;
                this.val$sqls2 = stringArray;
                this.val$sqlParamLists2 = sqlParamListArray;
                this.val$nBatchSize2 = n;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemService.this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                this.val$callResult.setUserObject((Object)PSSystemService.this.getDAO().executeRawSqlBatch(null, this.val$sqls2, this.val$sqlParamLists2, this.val$nBatchSize2));
            }
        });
        return (DBCallResult)sqlParamList.getUserObject();
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
        iDataEntityModel = new CallResult();
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
        EntityBase entityBase;
        Object object;
        Object object2;
        Object object3;
        String string2;
        PSSysModelFolderService pSSysModelFolderService = (PSSysModelFolderService)ServiceGlobal.getService(PSSysModelFolderService.class, (SessionFactory)this.getSessionFactory());
        PSSysModelFolderItemService pSSysModelFolderItemService = (PSSysModelFolderItemService)ServiceGlobal.getService(PSSysModelFolderItemService.class, (SessionFactory)this.getSessionFactory());
        String[] stringArray = string.split("[/]");
        PSSysModelFolderBase pSSysModelFolderBase = null;
        String string3 = "{BOOKMARKS}";
        for (int i = 1; i < stringArray.length; ++i) {
            string2 = stringArray[i];
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                string2 = string2.trim();
            }
            if (StringHelper.isNullOrEmpty((String)string2)) break;
            object3 = new SelectCond();
            if (pSSysModelFolderBase == null) {
                object3.setIsNull("PPSSYSMODELFOLDERID");
            } else {
                object3.set("PPSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
            }
            object3.set("PSSYSMODELFOLDERNAME", (Object)string2);
            object2 = pSSysModelFolderService.select((ISelectCond)object3);
            if (((ArrayList)object2).size() == 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8def\u5f84\uff1a%1$s", (Object)string));
            }
            pSSysModelFolderBase = (PSSysModelFolder)((ArrayList)object2).get(0);
            string3 = string3 + "/" + string2;
        }
        ArrayList<EntityBase> arrayList = new ArrayList<EntityBase>();
        string2 = new SelectCond();
        string2.setOrderInfo("ORDER BY PSSYSMODELFOLDERNAME");
        if (pSSysModelFolderBase == null) {
            string2.setIsNull("PPSSYSMODELFOLDERID");
        } else {
            string2.set("PPSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        }
        object3 = pSSysModelFolderService.select((ISelectCond)string2);
        object2 = ((ArrayList)object3).iterator();
        while (object2.hasNext()) {
            object = (PSSysModelFolder)object2.next();
            entityBase = new PSMOSFile();
            entityBase.setPSMOSFileId(string3 + "/" + ((PSSysModelFolderBase)object).getPSSysModelFolderName());
            entityBase.setPSMOSFileName(((PSSysModelFolderBase)object).getPSSysModelFolderName());
            entityBase.setFolderFlag(1);
            entityBase.setFileTag("MODEL");
            entityBase.setPSModelType("PSSYSMODELFOLDER");
            entityBase.setPSModelId(((PSSysModelFolderBase)object).getPSSysModelFolderId());
            arrayList.add(entityBase);
        }
        string2.reset();
        string2.setOrderInfo("ORDER BY PSSYSMODELFOLDERITEMNAME");
        if (pSSysModelFolderBase == null) {
            string2.setIsNull("PSSYSMODELFOLDERID");
        } else {
            string2.set("PSSYSMODELFOLDERID", (Object)pSSysModelFolderBase.getPSSysModelFolderId());
        }
        string2.setIsNotNull("PSOBJTYPE");
        string2.setIsNotNull("PSOBJID");
        object2 = pSSysModelFolderItemService.select((ISelectCond)string2);
        object = ((ArrayList)object2).iterator();
        while (object.hasNext()) {
            entityBase = (PSSysModelFolderItem)object.next();
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileId(string3 + "/" + entityBase.getPSSysModelFolderItemName());
            pSMOSFile2.setPSMOSFileName(entityBase.getPSSysModelFolderItemName() + "@" + PSModelV2Helper.getModelV2LogicName(entityBase.getPSObjType()));
            pSMOSFile2.setFolderFlag(0);
            pSMOSFile2.setFileTag("MODEL");
            pSMOSFile2.setPSModelType("PSSYSMODELFOLDERITEM");
            pSMOSFile2.setPSModelId(entityBase.getPSSysModelFolderItemId());
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
        ArrayList arrayList2 = pSDevUserRecentService.select((ISelectCond)selectCond);
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

