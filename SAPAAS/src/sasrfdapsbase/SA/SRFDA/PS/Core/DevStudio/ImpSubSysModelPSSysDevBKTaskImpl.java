/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSSubSys
 *  net.ibizsys.pscore.srv.config.entity.PSSubSysVer
 *  net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin
 *  net.ibizsys.pscore.srv.config.service.PSSubSysService
 *  net.ibizsys.pscore.srv.config.service.PSSubSysVerService
 *  net.ibizsys.pscore.srv.config.service.PSSysPFPluginService
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCat
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.Util.PSModelCloneHelper;
import SA.SRFDA.PS.Core.Util.PSModelSyncHelper;
import SA.SRFDA.PS.Core.Util.PSModelSyncHelper2;
import SA.SRFDA.PS.Core.Util.PSModelSyncHelper3;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVer;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ImpSubSysModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(ImpSubSysModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSystem psSystem2 = new PSSystem();
        psSystem2.setPSSystemId(this.psSysDevBKTask.getTASKPARAM());
        psSystemService.get((IEntity)psSystem2);
        try {
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSystem2.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            SessionFactoryManager.addRef();
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem2);
            String strResult = this.initSyncModel(psSystem2);
            PSCoreSysServiceBase.endImpSysModel();
            SessionFactoryManager.releaseRef((boolean)true);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strResult;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.endImpSysModel();
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected String initSyncModel(PSSystem psSystem) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
        psDevSlnSys.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!psDevSlnSys.get(true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf[%1$s]", (Object)this.getPSDevSlnSysId()));
        }
        PSSysRefService psSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysRefList = psSysRefService.selectByPSSystem((PSSystemBase)psSystem, "ORDER BY ORDERVALUE");
        for (PSSysRef psSysRef : psSysRefList) {
            if (!DataObject.getBoolValue((Integer)psSysRef.getValidFlag(), (boolean)true) || !StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM2()) && StringHelper.compare((String)this.psSysDevBKTask.getTASKPARAM2(), (String)psSysRef.getPSSysRefId(), (boolean)false) != 0) continue;
            sBuilderEx.append("\u5bfc\u5165\u7cfb\u7edf\u5f15\u7528[%1$s]\r\n", (Object)psSysRef.getPSSysRefName());
            sBuilderEx.append(this.impSubSysModel(psSysRef, psSystem, psDevSlnSys));
        }
        sBuilderEx.append("\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b\u5b8c\u6210\u3002");
        return sBuilderEx.toString();
    }

    protected String impSubSysModel(PSSysRef psSysRef, PSSystem psSystem, PSDevSlnSys psDevSlnSys) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        String strSubSysModelInstId = "";
        int nCurVersion = -1;
        String strClsPkgParams = "";
        boolean bSubSys = false;
        PSDevSlnSys refPSDevSlnSys = null;
        SessionFactory sysRefSessionFactory = null;
        PSSysSFPub defaultPSSysSFPub = null;
        int nImpOpt = 0;
        if (StringHelper.isNullOrEmpty((String)psSysRef.getSysRefType()) || StringHelper.compare((String)psSysRef.getSysRefType(), (String)"SUBSYS", (boolean)true) == 0) {
            PSSubSysService psSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class);
            PSSubSys psSubSys = new PSSubSys();
            psSubSys.setPSSubSysId(psSysRef.getPSSubSysId());
            if (!psSubSysService.get((IEntity)psSubSys, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b50\u7cfb\u7edf[%1$s]", (Object)psSysRef.getPSSysRefName()));
            }
            PSSubSysVerService psSubSysVerService = (PSSubSysVerService)ServiceGlobal.getService(PSSubSysVerService.class);
            PSSubSysVer psSubSysVer = new PSSubSysVer();
            psSubSysVer.setPSSubSysId(psSubSys.getPSSubSysId());
            psSubSysVer.setVersion(psSubSys.getVersion());
            if (!psSubSysVerService.select((IEntity)psSubSysVer, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b50\u7cfb\u7edf[%1$s]\u7248\u672c[%2$s]", (Object)psSysRef.getPSSysRefName(), (Object)psSubSys.getVersion()));
            }
            nCurVersion = psSubSys.getVersion();
            strSubSysModelInstId = psSubSysVer.getPSSysModelInstId();
            strClsPkgParams = psSubSysVer.getClsPkgParams();
            bSubSys = true;
            sysRefSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)strSubSysModelInstId);
            if (!StringHelper.isNullOrEmpty((String)strSubSysModelInstId) && bSubSys) {
                PSSysModelInstGlobal.activeAlways((String)strSubSysModelInstId);
            }
        } else if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            PSDevSlnSysRef psDevSlnSysRef = new PSDevSlnSysRef();
            psDevSlnSysRef.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevSlnSysRef.setRefPSDevSlnSysId(psSysRef.getPSDevSlnSysId());
            psDevSlnSysRef.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
            if (!psDevSlnSysRef.select(true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528[%1$s]", (Object)psSysRef.getPSDevSlnSysName()));
            }
            if (DataObject.getBoolValue((Integer)psDevSlnSysRef.getIgnoreImpUIModel(), (boolean)false)) {
                nImpOpt |= 2;
            }
            if (DataObject.getBoolValue((Integer)psDevSlnSysRef.getIgnoreImpWFModel(), (boolean)false)) {
                nImpOpt |= 4;
            }
            if (DataObject.getBoolValue((Integer)psDevSlnSysRef.getIgnoreImpDBModel(), (boolean)false)) {
                nImpOpt |= 8;
            }
            if (DataObject.getBoolValue((Integer)psDevSlnSysRef.getImpCoreModelOnly(), (boolean)false)) {
                nImpOpt |= 1;
            }
            if (DataObject.getBoolValue((Integer)psDevSlnSysRef.getSetModuleFlag(), (boolean)false)) {
                nImpOpt |= 0x10;
            }
            refPSDevSlnSys = new PSDevSlnSys();
            refPSDevSlnSys.setPSDevSlnSysId(psSysRef.getPSDevSlnSysId());
            refPSDevSlnSys.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
            if (!refPSDevSlnSys.get(true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u5f00\u53d1\u7cfb\u7edf[%1$s]\uff0c\u6807\u8bc6\u4e3a[%2$s]", (Object)psSysRef.getPSDevSlnSysName(), (Object)psSysRef.getPSDevSlnSysId()));
            }
            strSubSysModelInstId = refPSDevSlnSys.getPSSysModelInstId();
            sysRefSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)strSubSysModelInstId);
            PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            PSDevSlnSysSrv psDevSlnSysSrv = null;
            if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)psSysRef.getPSDevSlnSysSrvId())) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u4f53\u7cfb"));
                }
                psDevSlnSysSrv = new PSDevSlnSysSrv();
                psDevSlnSysSrv.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
                psDevSlnSysSrv.setPSDevSlnSysSrvId(psSysRef.getPSDevSlnSysSrvId());
                if (!psDevSlnSysSrv.get(true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u4f53\u7cfb[%1$s]\uff0c\u6807\u8bc6\u4e3a[%2$s]", (Object)psSysRef.getPSDevSlnSysSrvName(), (Object)psSysRef.getPSDevSlnSysSrvId()));
                }
                defaultPSSysSFPub = new PSSysSFPub();
                defaultPSSysSFPub.setSessionFactory(sysRefSessionFactory);
                defaultPSSysSFPub.setPSSysSFPubId(psDevSlnSysSrv.getPSSysSFPubId());
                if (!defaultPSSysSFPub.get(true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u4f53\u7cfb[%1$s]", (Object)psDevSlnSysSrv.getPSSysSFPubId()));
                }
            }
        } else {
            if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"ETLSOURCE", (boolean)true) == 0 || StringHelper.compare((String)psSysRef.getSysRefType(), (String)"ETLMODEL", (boolean)true) == 0 || StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYSCLOUD", (boolean)true) == 0) {
                PSDevSlnSysRef psDevSlnSysRef = new PSDevSlnSysRef();
                psDevSlnSysRef.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
                psDevSlnSysRef.setRefPSDevSlnSysId(psSysRef.getPSDevSlnSysId());
                psDevSlnSysRef.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                if (!psDevSlnSysRef.select(true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528[%1$s]", (Object)psSysRef.getPSDevSlnSysName()));
                }
                refPSDevSlnSys = new PSDevSlnSys();
                refPSDevSlnSys.setPSDevSlnSysId(psSysRef.getPSDevSlnSysId());
                refPSDevSlnSys.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
                if (!refPSDevSlnSys.get(true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u5f00\u53d1\u7cfb\u7edf[%1$s]\uff0c\u6807\u8bc6\u4e3a[%2$s]", (Object)psSysRef.getPSDevSlnSysName(), (Object)psSysRef.getPSDevSlnSysId()));
                }
                if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"ETLSOURCE", (boolean)true) == 0) {
                    PSModelSyncHelper psModelSyncHelper = new PSModelSyncHelper(psDevSlnSys, null);
                    return psModelSyncHelper.sync(psDevSlnSysRef, refPSDevSlnSys);
                }
                if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"ETLMODEL", (boolean)true) == 0) {
                    PSModelSyncHelper2 psModelSyncHelper2 = new PSModelSyncHelper2(psDevSlnSys, null);
                    return psModelSyncHelper2.sync(psDevSlnSysRef, refPSDevSlnSys);
                }
                if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYSCLOUD", (boolean)true) == 0) {
                    PSModelSyncHelper3 psModelSyncHelper3 = new PSModelSyncHelper3(psDevSlnSys, null);
                    return psModelSyncHelper3.sync(psDevSlnSysRef, refPSDevSlnSys);
                }
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7cfb\u7edf\u5f15\u7528\u7c7b\u578b[%1$s]", (Object)psSysRef.getSysRefType()));
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b50\u7cfb\u7edf\u7c7b\u578b[%1$s]", (Object)psSysRef.getSysRefType()));
        }
        boolean bError = false;
        boolean bIgnoreExists = false;
        if (bSubSys && StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM2())) {
            HashMap<String, PSModule> psModuleMap = this.impPSModule(sysRefSessionFactory, psSysRef, psSystem, defaultPSSysSFPub, bIgnoreExists);
            try {
                ImportSessionManager.openSession();
                this.impPSSubSysServiceAPI(sysRefSessionFactory, psSysRef, psSystem, psModuleMap);
                if (!bSubSys) {
                    PSSysModelInstGlobal.active((String)strSubSysModelInstId);
                }
                HashMap<String, PSDataEntity> psDataEntityMap = this.impPSDataEntity(sysRefSessionFactory, psSysRef, psSystem, psModuleMap);
                if (!bSubSys) {
                    PSSysModelInstGlobal.active((String)strSubSysModelInstId);
                }
                ImportSessionManager.closeSession();
            }
            catch (Exception ex) {
                ImportSessionManager.closeSession();
                throw ex;
            }
            SessionFactoryManager.releaseRef((boolean)true);
            SessionFactoryManager.addRef();
            ArrayList<Object> allJsonList = new ArrayList<Object>();
            ArrayList<JSONObject> jsonList = this.impPSLanguageRes(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSCodeList(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysPFPlugin(sysRefSessionFactory, psSysRef, psSystem, bIgnoreExists, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysCounter(sysRefSessionFactory, psSysRef, psSystem, bIgnoreExists, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSDEUIAction(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            if ((jsonList = this.impPSDEUIActionGroup(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap)) != null) {
                allJsonList.addAll(jsonList);
                if (!bSubSys) {
                    PSSysModelInstGlobal.active((String)strSubSysModelInstId);
                }
            }
            jsonList = this.impPSDEToolbar(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSubViewType(sysRefSessionFactory, psSysRef, psSystem, bIgnoreExists, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysEditorStyle(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysPDTView(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysImage(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysCssCat(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysCss(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSACHandler(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSDataEntity2(sysRefSessionFactory, psSysRef, psSystem, false, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            jsonList = this.impPSSysPortlet(sysRefSessionFactory, psSysRef, psSystem, true, psModuleMap);
            allJsonList.addAll(jsonList);
            if (!bSubSys) {
                PSSysModelInstGlobal.active((String)strSubSysModelInstId);
            }
            try {
                ImportSessionManager.openSession();
                ArrayList<JSONObject> allJsonList2 = new ArrayList<JSONObject>();
                boolean bRetryMode = true;
                int nLastErrorCount = 0;
                SessionFactory curSysSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
                while (true) {
                    if (allJsonList.size() > 0) {
                        JSONObject item = (JSONObject)allJsonList.remove(0);
                        String strDEId = item.optString("srfdename", "");
                        if (StringHelper.isNullOrEmpty((String)strDEId)) {
                            sBuilderEx.append("[%1$s]\u6ca1\u6709\u6307\u5b9a\u5bf9\u5e94\u7684\u6570\u636e\u5bf9\u8c61\r\n");
                            continue;
                        }
                        if (!bSubSys) {
                            PSSysModelInstGlobal.active((String)strSubSysModelInstId);
                        }
                        IService iService = null;
                        try {
                            iService = DEModelGlobal.getDEModel((String)strDEId).getService(curSysSessionFactory);
                            String string = iService.importModel(item);
                        }
                        catch (Exception ex) {
                            if (bRetryMode) {
                                allJsonList2.add(item);
                                continue;
                            }
                            bError = true;
                            if (iService != null) {
                                sBuilderEx.append("[%2$s:%3$s]\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%4$s\r\n%5$s\r\n", (Object)0, (Object)iService.getDEModel().getName(), (Object)iService.getDEModel().getLogicName(), (Object)ex.getMessage(), (Object)item.toString());
                                continue;
                            }
                            sBuilderEx.append("\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%2$s\r\n", (Object)0, (Object)ex.getMessage());
                        }
                        continue;
                    }
                    if (allJsonList2.size() == 0 || !bRetryMode) break;
                    if (allJsonList2.size() == nLastErrorCount) {
                        bRetryMode = false;
                    }
                    nLastErrorCount = allJsonList2.size();
                    allJsonList.addAll(allJsonList2);
                    allJsonList2.clear();
                    sBuilderEx.reset();
                }
                ImportSessionManager.closeSession();
            }
            catch (Exception ex) {
                ImportSessionManager.closeSession();
                throw ex;
            }
        }
        try {
            ImportSessionManager.openSession();
            PSModelCloneHelper psModelCloneHelper = new PSModelCloneHelper(psSystem, sysRefSessionFactory, PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()), strSubSysModelInstId, this.getPSSysModelInstId(), nImpOpt);
            sBuilderEx.append(psModelCloneHelper.cloneSysRef(psSysRef, defaultPSSysSFPub));
            ImportSessionManager.closeSession();
        }
        catch (Exception ex) {
            ImportSessionManager.closeSession();
            throw ex;
        }
        if (StringHelper.isNullOrEmpty((String)strClsPkgParams)) {
            HashMap<String, String> pkgMap = new HashMap<String, String>();
            String strDefaultPkg = "";
            if (defaultPSSysSFPub != null) {
                pkgMap.put(StringHelper.format((String)"PKG.%1$s", (Object)defaultPSSysSFPub.getPSSFStyleId()), defaultPSSysSFPub.getPKGCodeName());
                if (StringHelper.isNullOrEmpty((String)strDefaultPkg)) {
                    strDefaultPkg = defaultPSSysSFPub.getPKGCodeName();
                }
            } else {
                PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)sysRefSessionFactory);
                ArrayList psSysSFPubList = psSysSFPubService.selectByPSSystem((PSSystemBase)psSystem);
                for (PSSysSFPub psSysSFPub : psSysSFPubList) {
                    if (!DataObject.getBoolValue((Integer)psSysSFPub.getDefaultPub(), (boolean)false)) continue;
                    pkgMap.put(StringHelper.format((String)"PKG.%1$s", (Object)psSysSFPub.getPSSFStyleId()), psSysSFPub.getPKGCodeName());
                    if (!StringHelper.isNullOrEmpty((String)strDefaultPkg)) continue;
                    strDefaultPkg = psSysSFPub.getPKGCodeName();
                }
            }
            StringBuilderEx clsPkgSb = new StringBuilderEx();
            if (!StringHelper.isNullOrEmpty((String)strDefaultPkg)) {
                clsPkgSb.append("PKG=%1$s\r\n", (Object)strDefaultPkg);
            }
            for (String strKey : pkgMap.keySet()) {
                String strValue = (String)pkgMap.get(strKey);
                clsPkgSb.append("%1$s=%2$s\r\n", (Object)strKey, (Object)strValue);
            }
            strClsPkgParams = clsPkgSb.toString();
        }
        PSSysRefService psSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysRef psSysRef2 = new PSSysRef();
        psSysRef2.setPSSysRefId(psSysRef.getPSSysRefId());
        psSysRef2.setVersion(Integer.valueOf(nCurVersion));
        psSysRef2.setClsPkgParams(strClsPkgParams);
        psSysRefService.update((IEntity)psSysRef2);
        DBCallResult dbCallResult = psSysRefService.executeRaw("DELETE FROM T_SRFPSSYSMODELLOG", null);
        if (dbCallResult.isError()) {
            sBuilderEx.append("\u6e05\u9664\u6a21\u578b\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)dbCallResult.getErrorInfo());
        }
        return sBuilderEx.toString();
    }

    protected HashMap<String, PSModule> impPSModule(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, PSSysSFPub psSysSFPub, boolean bIgnoreExist) throws Exception {
        PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)sysRefSessionFactory);
        PSModuleService psModuleService2 = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        boolean bDefaultSysSFPub = false;
        if (psSysSFPub != null) {
            bDefaultSysSFPub = DataObject.getBoolValue((Integer)psSysSFPub.getDefaultPub(), (boolean)true);
        }
        ArrayList psModuleList = psModuleService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psModuleList2 = psModuleService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSModule> psModuleMap = new HashMap<String, PSModule>();
        HashMap<String, PSModule> psModuleMap2 = new HashMap<String, PSModule>();
        for (PSModule psModule2 : psModuleList2) {
            psModuleMap2.put(psModule2.getPSModuleId(), psModule2);
        }
        for (PSModule psModule : psModuleList) {
            if (DataObject.getBoolValue((Integer)psModule.getSubSysModule(), (boolean)false) || psSysSFPub != null && (StringHelper.isNullOrEmpty((String)psModule.getPSSysSFPubId()) ? !bDefaultSysSFPub : StringHelper.compare((String)psModule.getPSSysSFPubId(), (String)psSysSFPub.getPSSysSFPubId(), (boolean)false) != 0)) continue;
            psModuleMap.put(psModule.getPSModuleId(), psModule);
            boolean bExists = false;
            if (psModuleMap2.containsKey(psModule.getPSModuleId())) {
                if (bIgnoreExist) continue;
                bExists = true;
            }
            psModule.setPSSysSFPubId(null);
            psModule.setPSSysSFPubName(null);
            psModule.setSubSysModule(Integer.valueOf(1));
            psModule.setPSSysRefId(psSysRef.getPSSysRefId());
            psModule.setPSSysRefName(psSysRef.getPSSysRefName());
            psModule.setLockFlag(Integer.valueOf(1));
            if (bExists) {
                psModuleService2.update((IEntity)psModule, false);
                continue;
            }
            psModuleService2.create((IEntity)psModule, false);
        }
        return psModuleMap;
    }

    protected HashMap<String, PSSubSysServiceAPI> impPSSubSysServiceAPI(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, HashMap<String, PSModule> psModuleMap) throws Exception {
        PSSubSysServiceAPIService psSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)sysRefSessionFactory);
        PSSubSysServiceAPIService psSubSysServiceAPIService2 = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSubSysServiceAPIList = psSubSysServiceAPIService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSubSysServiceAPIList2 = psSubSysServiceAPIService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSubSysServiceAPI> psSubSysServiceAPIMap = new HashMap<String, PSSubSysServiceAPI>();
        HashMap<String, PSSubSysServiceAPI> psSubSysServiceAPIMap2 = new HashMap<String, PSSubSysServiceAPI>();
        for (PSSubSysServiceAPI psSubSysServiceAPI2 : psSubSysServiceAPIList2) {
            psSubSysServiceAPIMap2.put(psSubSysServiceAPI2.getPSSubSysServiceAPIId(), psSubSysServiceAPI2);
        }
        for (PSSubSysServiceAPI psSubSysServiceAPI : psSubSysServiceAPIList) {
            if (!psModuleMap.containsKey(psSubSysServiceAPI.getPSModuleId())) continue;
            psSubSysServiceAPIMap.put(psSubSysServiceAPI.getPSSubSysServiceAPIId(), psSubSysServiceAPI);
            if (psSubSysServiceAPIMap2.containsKey(psSubSysServiceAPI.getPSSubSysServiceAPIId())) continue;
            psSubSysServiceAPIService2.create((IEntity)psSubSysServiceAPI, false);
        }
        return psSubSysServiceAPIMap;
    }

    protected HashMap<String, PSDataEntity> impPSDataEntity(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, HashMap<String, PSModule> psModuleMap) throws Exception {
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sysRefSessionFactory);
        PSDataEntityService psDataEntityService2 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psDataEntityList2 = psDataEntityService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
        HashMap<String, PSDataEntity> psDataEntityMap2 = new HashMap<String, PSDataEntity>();
        for (PSDataEntity psDataEntity2 : psDataEntityList2) {
            psDataEntityMap2.put(psDataEntity2.getPSDataEntityId(), psDataEntity2);
        }
        for (PSDataEntity psDataEntity : psDataEntityList) {
            if (!psModuleMap.containsKey(psDataEntity.getPSModuleId())) continue;
            psDataEntityMap.put(psDataEntity.getPSDataEntityId(), psDataEntity);
            if (psDataEntityMap2.containsKey(psDataEntity.getPSDataEntityId())) continue;
            psDataEntity.resetLNPSLanResId();
            psDataEntity.setDEType(Integer.valueOf(1));
            psDataEntityService2.create((IEntity)psDataEntity, false);
        }
        return psDataEntityMap;
    }

    protected ArrayList<JSONObject> impPSLanguageRes(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        PSLanguageResService psLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)sysRefSessionFactory);
        PSLanguageResService psLanguageResService2 = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psLanguageResList = psLanguageResService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psLanguageResList2 = psLanguageResService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSLanguageRes> psLanguageResMap = new HashMap<String, PSLanguageRes>();
        HashMap<String, PSLanguageRes> psLanguageResMap2 = new HashMap<String, PSLanguageRes>();
        for (PSLanguageRes psLanguageRes2 : psLanguageResList2) {
            psLanguageResMap2.put(psLanguageRes2.getPSLanguageResId(), psLanguageRes2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSLanguageRes psLanguageRes : psLanguageResList) {
            if (!psModuleMap.containsKey(psLanguageRes.getPSModuleId())) continue;
            psLanguageResMap.put(psLanguageRes.getPSLanguageResId(), psLanguageRes);
            boolean bExists = false;
            if (psLanguageResMap2.containsKey(psLanguageRes.getPSLanguageResId())) {
                if (bIgnoreExist) continue;
                bExists = true;
            }
            psLanguageResService.exportModel((IEntity)psLanguageRes, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSCodeList(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSCodeListService psCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)sysRefSessionFactory);
        PSCodeListService psCodeListService2 = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psCodeListList = psCodeListService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psCodeListList2 = psCodeListService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSCodeList> psCodeListMap = new HashMap<String, PSCodeList>();
        HashMap<String, PSCodeList> psCodeListMap2 = new HashMap<String, PSCodeList>();
        for (PSCodeList psCodeList2 : psCodeListList2) {
            psCodeListMap2.put(psCodeList2.getPSCodeListId(), psCodeList2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSCodeList psCodeList : psCodeListList) {
            if (!psModuleMap.containsKey(psCodeList.getPSModuleId())) continue;
            psCodeListMap.put(psCodeList.getPSCodeListId(), psCodeList);
            boolean bExists = false;
            if (psCodeListMap2.containsKey(psCodeList.getPSCodeListId())) {
                if (bIgnoreExist) continue;
                bExists = true;
            }
            psCodeListService.exportModel((IEntity)psCodeList, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysPFPlugin(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysPFPluginService psSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)sysRefSessionFactory);
        PSSysPFPluginService psSysPFPluginService2 = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysPFPluginList = psSysPFPluginService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysPFPluginList2 = psSysPFPluginService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysPFPlugin> psSysPFPluginMap = new HashMap<String, PSSysPFPlugin>();
        HashMap<String, PSSysPFPlugin> psSysPFPluginMap2 = new HashMap<String, PSSysPFPlugin>();
        for (PSSysPFPlugin psSysPFPlugin2 : psSysPFPluginList2) {
            psSysPFPluginMap2.put(psSysPFPlugin2.getPSSysPFPluginId(), psSysPFPlugin2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysPFPlugin psSysPFPlugin : psSysPFPluginList) {
            if (!psModuleMap.containsKey(psSysPFPlugin.getPSModuleId())) continue;
            psSysPFPluginMap.put(psSysPFPlugin.getPSSysPFPluginId(), psSysPFPlugin);
            if (psSysPFPluginMap2.containsKey(psSysPFPlugin.getPSSysPFPluginId()) && bIgnoreExist) continue;
            psSysPFPluginService.exportModel((IEntity)psSysPFPlugin, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysCounter(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysCounterService psSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)sysRefSessionFactory);
        PSSysCounterService psSysCounterService2 = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysCounterList = psSysCounterService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysCounterList2 = psSysCounterService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysCounter> psSysCounterMap = new HashMap<String, PSSysCounter>();
        HashMap<String, PSSysCounter> psSysCounterMap2 = new HashMap<String, PSSysCounter>();
        for (PSSysCounter psSysCounter2 : psSysCounterList2) {
            psSysCounterMap2.put(psSysCounter2.getPSSysCounterId(), psSysCounter2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysCounter psSysCounter : psSysCounterList) {
            if (!psModuleMap.containsKey(psSysCounter.getPSModuleId())) continue;
            psSysCounterMap.put(psSysCounter.getPSSysCounterId(), psSysCounter);
            if (psSysCounterMap2.containsKey(psSysCounter.getPSSysCounterId()) && bIgnoreExist) continue;
            psSysCounterService.exportModel((IEntity)psSysCounter, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSDEUIAction(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sysRefSessionFactory);
        PSDEUIActionService psDEUIActionService2 = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psDEUIActionList = psDEUIActionService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psDEUIActionList2 = psDEUIActionService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSDEUIAction> psDEUIActionMap = new HashMap<String, PSDEUIAction>();
        HashMap<String, PSDEUIAction> psDEUIActionMap2 = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction psDEUIAction2 : psDEUIActionList2) {
            psDEUIActionMap2.put(psDEUIAction2.getPSDEUIActionId(), psDEUIAction2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            if (!bSubSys && (StringHelper.isNullOrEmpty((String)psDEUIAction.getPSModuleId()) || !psModuleMap.containsKey(psDEUIAction.getPSModuleId()) || !StringHelper.isNullOrEmpty((String)psDEUIAction.getPSWFId()))) continue;
            psDEUIActionMap.put(psDEUIAction.getPSDEUIActionId(), psDEUIAction);
            if (psDEUIActionMap2.containsKey(psDEUIAction.getPSDEUIActionId()) && bIgnoreExist) continue;
            psDEUIActionService.exportModel((IEntity)psDEUIAction, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSDEUIActionGroup(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        if (bSubSys) {
            return null;
        }
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sysRefSessionFactory);
        PSDEUAGroupService psDEUAGroupService2 = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psDEUAGroupList = psDEUAGroupService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psDEUAGroupList2 = psDEUAGroupService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSDEUAGroup> psDEUAGroupMap = new HashMap<String, PSDEUAGroup>();
        HashMap<String, PSDEUAGroup> psDEUAGroupMap2 = new HashMap<String, PSDEUAGroup>();
        for (PSDEUAGroup psDEUAGroup2 : psDEUAGroupList2) {
            psDEUAGroupMap2.put(psDEUAGroup2.getPSDEUAGroupId(), psDEUAGroup2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSDEUAGroup psDEUAGroup : psDEUAGroupList) {
            if (!bSubSys && (StringHelper.isNullOrEmpty((String)psDEUAGroup.getPSModuleId()) || !psModuleMap.containsKey(psDEUAGroup.getPSModuleId()) || !StringHelper.isNullOrEmpty((String)psDEUAGroup.getPSWFId()))) continue;
            psDEUAGroupMap.put(psDEUAGroup.getPSDEUAGroupId(), psDEUAGroup);
            if (psDEUAGroupMap2.containsKey(psDEUAGroup.getPSDEUAGroupId()) && bIgnoreExist) continue;
            psDEUAGroupService.exportModel((IEntity)psDEUAGroup, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSDEToolbar(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSDEToolbarService psDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)sysRefSessionFactory);
        PSDEToolbarService psDEToolbarService2 = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psDEToolbarList = psDEToolbarService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psDEToolbarList2 = psDEToolbarService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSDEToolbar> psDEToolbarMap = new HashMap<String, PSDEToolbar>();
        HashMap<String, PSDEToolbar> psDEToolbarMap2 = new HashMap<String, PSDEToolbar>();
        for (PSDEToolbar psDEToolbar2 : psDEToolbarList2) {
            psDEToolbarMap2.put(psDEToolbar2.getPSDEToolbarId(), psDEToolbar2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSDEToolbar psDEToolbar : psDEToolbarList) {
            psDEToolbarMap.put(psDEToolbar.getPSDEToolbarId(), psDEToolbar);
            if (psDEToolbarMap2.containsKey(psDEToolbar.getPSDEToolbarId()) && bIgnoreExist) continue;
            psDEToolbarService.exportModel((IEntity)psDEToolbar, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSubViewType(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSubViewTypeService psSubViewTypeService = (PSSubViewTypeService)ServiceGlobal.getService(PSSubViewTypeService.class, (SessionFactory)sysRefSessionFactory);
        PSSubViewTypeService psSubViewTypeService2 = (PSSubViewTypeService)ServiceGlobal.getService(PSSubViewTypeService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSubViewTypeList = psSubViewTypeService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSubViewTypeList2 = psSubViewTypeService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSubViewType> psSubViewTypeMap = new HashMap<String, PSSubViewType>();
        HashMap<String, PSSubViewType> psSubViewTypeMap2 = new HashMap<String, PSSubViewType>();
        for (PSSubViewType psSubViewType2 : psSubViewTypeList2) {
            psSubViewTypeMap2.put(psSubViewType2.getPSSubViewTypeId(), psSubViewType2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSubViewType psSubViewType : psSubViewTypeList) {
            if (!psModuleMap.containsKey(psSubViewType.getPSModuleId())) continue;
            psSubViewTypeMap.put(psSubViewType.getPSSubViewTypeId(), psSubViewType);
            if (psSubViewTypeMap2.containsKey(psSubViewType.getPSSubViewTypeId()) && bIgnoreExist) continue;
            psSubViewTypeService.exportModel((IEntity)psSubViewType, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysEditorStyle(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysEditorStyleService psSysEditorStyleService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)sysRefSessionFactory);
        PSSysEditorStyleService psSysEditorStyleService2 = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysEditorStyleList = psSysEditorStyleService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysEditorStyleList2 = psSysEditorStyleService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysEditorStyle> psSysEditorStyleMap = new HashMap<String, PSSysEditorStyle>();
        HashMap<String, PSSysEditorStyle> psSysEditorStyleMap2 = new HashMap<String, PSSysEditorStyle>();
        for (PSSysEditorStyle psSysEditorStyle2 : psSysEditorStyleList2) {
            psSysEditorStyleMap2.put(psSysEditorStyle2.getPSSysEditorStyleId(), psSysEditorStyle2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysEditorStyle psSysEditorStyle : psSysEditorStyleList) {
            psSysEditorStyleMap.put(psSysEditorStyle.getPSSysEditorStyleId(), psSysEditorStyle);
            if (psSysEditorStyleMap2.containsKey(psSysEditorStyle.getPSSysEditorStyleId()) && bIgnoreExist) continue;
            psSysEditorStyleService.exportModel((IEntity)psSysEditorStyle, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysPDTView(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysPDTViewService psSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)sysRefSessionFactory);
        PSSysPDTViewService psSysPDTViewService2 = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysPDTViewList = psSysPDTViewService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysPDTViewList2 = psSysPDTViewService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysPDTView> psSysPDTViewMap = new HashMap<String, PSSysPDTView>();
        HashMap<String, PSSysPDTView> psSysPDTViewMap2 = new HashMap<String, PSSysPDTView>();
        for (PSSysPDTView psSysPDTView2 : psSysPDTViewList2) {
            psSysPDTViewMap2.put(psSysPDTView2.getPSSysPDTViewId(), psSysPDTView2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysPDTView psSysPDTView : psSysPDTViewList) {
            psSysPDTViewMap.put(psSysPDTView.getPSSysPDTViewId(), psSysPDTView);
            if (psSysPDTViewMap2.containsKey(psSysPDTView.getPSSysPDTViewId()) && bIgnoreExist) continue;
            psSysPDTViewService.exportModel((IEntity)psSysPDTView, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysImage(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysImageService psSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)sysRefSessionFactory);
        PSSysImageService psSysImageService2 = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysImageList = psSysImageService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysImageList2 = psSysImageService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysImage> psSysImageMap = new HashMap<String, PSSysImage>();
        HashMap<String, PSSysImage> psSysImageMap2 = new HashMap<String, PSSysImage>();
        for (PSSysImage psSysImage2 : psSysImageList2) {
            psSysImageMap2.put(psSysImage2.getPSSysImageId(), psSysImage2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysImage psSysImage : psSysImageList) {
            psSysImageMap.put(psSysImage.getPSSysImageId(), psSysImage);
            if (psSysImageMap2.containsKey(psSysImage.getPSSysImageId()) && bIgnoreExist) continue;
            psSysImageService.exportModel((IEntity)psSysImage, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysCssCat(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysCssCatService psSysCssCatService = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)sysRefSessionFactory);
        PSSysCssCatService psSysCssCatService2 = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysCssCatList = psSysCssCatService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysCssCatList2 = psSysCssCatService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysCssCat> psSysCssCatMap = new HashMap<String, PSSysCssCat>();
        HashMap<String, PSSysCssCat> psSysCssCatMap2 = new HashMap<String, PSSysCssCat>();
        for (PSSysCssCat psSysCssCat2 : psSysCssCatList2) {
            psSysCssCatMap2.put(psSysCssCat2.getPSSysCssCatId(), psSysCssCat2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysCssCat psSysCssCat : psSysCssCatList) {
            psSysCssCatMap.put(psSysCssCat.getPSSysCssCatId(), psSysCssCat);
            if (psSysCssCatMap2.containsKey(psSysCssCat.getPSSysCssCatId()) && bIgnoreExist) continue;
            psSysCssCatService.exportModel((IEntity)psSysCssCat, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysCss(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysCssService psSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)sysRefSessionFactory);
        PSSysCssService psSysCssService2 = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysCssList = psSysCssService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysCssList2 = psSysCssService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysCss> psSysCssMap = new HashMap<String, PSSysCss>();
        HashMap<String, PSSysCss> psSysCssMap2 = new HashMap<String, PSSysCss>();
        for (PSSysCss psSysCss2 : psSysCssList2) {
            psSysCssMap2.put(psSysCss2.getPSSysCssId(), psSysCss2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysCss psSysCss : psSysCssList) {
            psSysCssMap.put(psSysCss.getPSSysCssId(), psSysCss);
            if (psSysCssMap2.containsKey(psSysCss.getPSSysCssId()) && bIgnoreExist) continue;
            psSysCssService.exportModel((IEntity)psSysCss, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSACHandler(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSACHandlerService psACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)sysRefSessionFactory);
        PSACHandlerService psACHandlerService2 = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psACHandlerList = psACHandlerService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psACHandlerList2 = psACHandlerService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSACHandler> psACHandlerMap = new HashMap<String, PSACHandler>();
        HashMap<String, PSACHandler> psACHandlerMap2 = new HashMap<String, PSACHandler>();
        for (PSACHandler psACHandler2 : psACHandlerList2) {
            psACHandlerMap2.put(psACHandler2.getPSACHandlerId(), psACHandler2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSACHandler psACHandler : psACHandlerList) {
            psACHandlerMap.put(psACHandler.getPSACHandlerId(), psACHandler);
            if (psACHandlerMap2.containsKey(psACHandler.getPSACHandlerId()) && bIgnoreExist) continue;
            psACHandlerService.exportModel((IEntity)psACHandler, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSSysPortlet(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSSysPortletService psSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)sysRefSessionFactory);
        PSSysPortletService psSysPortletService2 = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psSysPortletList = psSysPortletService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysPortletList2 = psSysPortletService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSSysPortlet> psSysPortletMap = new HashMap<String, PSSysPortlet>();
        HashMap<String, PSSysPortlet> psSysPortletMap2 = new HashMap<String, PSSysPortlet>();
        for (PSSysPortlet psSysPortlet2 : psSysPortletList2) {
            psSysPortletMap2.put(psSysPortlet2.getPSSysPortletId(), psSysPortlet2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSSysPortlet psSysPortlet : psSysPortletList) {
            psSysPortletMap.put(psSysPortlet.getPSSysPortletId(), psSysPortlet);
            if (psSysPortletMap2.containsKey(psSysPortlet.getPSSysPortletId()) && bIgnoreExist) continue;
            psSysPortletService.exportModel((IEntity)psSysPortlet, list);
        }
        return list;
    }

    protected ArrayList<JSONObject> impPSDataEntity2(SessionFactory sysRefSessionFactory, PSSysRef psSysRef, PSSystem psSystem, boolean bIgnoreExist, HashMap<String, PSModule> psModuleMap) throws Exception {
        boolean bSubSys = true;
        if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"DEVSYS", (boolean)true) == 0) {
            bSubSys = false;
        }
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sysRefSessionFactory);
        PSDataEntityService psDataEntityService2 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psDataEntityList2 = psDataEntityService2.selectByPSSystem((PSSystemBase)psSystem);
        HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
        HashMap<String, PSDataEntity> psDataEntityMap2 = new HashMap<String, PSDataEntity>();
        for (PSDataEntity psDataEntity2 : psDataEntityList2) {
            psDataEntityMap2.put(psDataEntity2.getPSDataEntityId(), psDataEntity2);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSDataEntity psDataEntity : psDataEntityList) {
            if (!psModuleMap.containsKey(psDataEntity.getPSModuleId())) continue;
            psDataEntityMap.put(psDataEntity.getPSDataEntityId(), psDataEntity);
            if (psDataEntityMap2.containsKey(psDataEntity.getPSDataEntityId()) && bIgnoreExist) continue;
            psDataEntityService.exportModel((IEntity)psDataEntity, list);
        }
        return list;
    }
}

