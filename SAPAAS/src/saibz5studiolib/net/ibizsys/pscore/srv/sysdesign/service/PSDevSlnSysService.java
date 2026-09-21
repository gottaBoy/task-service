/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfgBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService;
import net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysBase;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRefBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLicBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevSlnSysKey;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstRefService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStepBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrvBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemASBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLinkBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService;
import net.ibizsys.pscore.srv.util.IPSDCASOwnerListener;
import net.ibizsys.pscore.srv.util.IPSDCDBInstOwnerListener;
import net.ibizsys.pscore.srv.util.IPSDCSVNOwnerListener;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabHelper;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysService
extends PSDevSlnSysServiceBase
implements IPSDCDBInstOwnerListener,
IPSDCASOwnerListener,
IPSDCSVNOwnerListener {
    private static final Log log = LogFactory.getLog(PSDevSlnSysService.class);
    private static Random random = new Random();
    public static final String DEFAULTSYSTEMID = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
    public static final String SRCPSSYSMODELINSTID = "srcpssysmodelinstid";
    public static final String DSTPSSYSMODELINSTID = "dstpssysmodelinstid";
    public static final String ACTIONPARAM_IGNORECALCRESSTATE = "IGNORECALCRESSTATE";
    public static final String PARAM_IGNOREPSDEVCENTERTS = "IGNOREPSDEVCENTERTS";
    private static final HashMap<Integer, Integer> psResStateLevelMap = new HashMap();

    @Override
    public void getDraft(PSDevSlnSys pSDevSlnSys) throws Exception {
        super.getDraft(pSDevSlnSys);
        if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
            PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys.getMainPSDevSlnSys();
            pSDevSlnSys2.copyTo((IDataObject)pSDevSlnSys, true);
            pSDevSlnSys.resetPSDevSlnSysId();
            pSDevSlnSys.resetPSDevSlnSysName();
            pSDevSlnSys.resetPSSysModelInstId();
            pSDevSlnSys.resetPSSysModelInstName();
            pSDevSlnSys.resetSysVer();
            pSDevSlnSys.resetPSDevCenterASId();
            pSDevSlnSys.resetPSDevCenterASId2();
            pSDevSlnSys.resetPSDevCenterAS3Id();
            pSDevSlnSys.resetPSDevCenterAS4Id();
            pSDevSlnSys.resetPSDevCenterASName();
            pSDevSlnSys.resetPSDevCenterASName2();
            pSDevSlnSys.resetPSDevCenterAS3Name();
            pSDevSlnSys.resetPSDevCenterAS4Name();
            pSDevSlnSys.resetVCType();
            pSDevSlnSys.setMainPSDevSlnSysId(pSDevSlnSys2.getPSDevSlnSysId());
            pSDevSlnSys.setMainPSDevSlnSysName(pSDevSlnSys2.getPSDevSlnSysName());
        }
    }

    @Override
    protected void onBeforeCreate(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            Object object;
            Object object2;
            boolean bl = false;
            PSDevCenter pSDevCenter = null;
            if (!DataObject.getBoolValue((Integer)pSDevSlnSys.getShareFlag(), (boolean)false)) {
                if (pSDevSlnSys.getPSDevSln() != null && pSDevSlnSys.getPSDevSln().getPSDevCenter() != null) {
                    pSDevCenter = pSDevSlnSys.getPSDevSln().getPSDevCenter();
                    bl = DataObject.getBoolValue((Integer)pSDevCenter.getEnableWorkspace(), (boolean)false);
                }
                PSDevCenterHelper.testCreate(pSDevCenter, "DEVSYSCNT", false);
            }
            if (PSDevSlnSysService.isCloudMode()) {
                bl = true;
                pSDevSlnSys.setEnableMySQL5(1);
                pSDevSlnSys.setTemplEngine("V2");
                pSDevSlnSys.setEnableDynaSys(1);
                pSDevSlnSys.setSaaSMode(4);
                if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSFId())) {
                    pSDevSlnSys.setPSSFId("J2EE6");
                    pSDevSlnSys.setPSSFName("Java\u4f53\u7cfb\u67b6\u6784");
                }
            } else if (bl && !PSDevSlnSysService.isEnableGitBranch() && !StringHelper.isNullOrEmpty((String)pSDevSlnSys.getMainPSDevSlnSysId()) && StringHelper.isNullOrEmpty((String)pSDevSlnSys.getSysTag()) && StringHelper.isNullOrEmpty((String)pSDevSlnSys.getSysTag2())) {
                bl = false;
            }
            if (bl) {
                pSDevSlnSys.setDevSysState(35);
            } else if (pSDevSlnSys.getDevSysState() == null || pSDevSlnSys.getDevSysState() == 10) {
                pSDevSlnSys.setDevSysState(30);
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getStudioVer())) {
                if (pSDevCenter == null && pSDevSlnSys.getPSDevSln() != null && pSDevSlnSys.getPSDevSln().getPSDevCenter() != null) {
                    pSDevCenter = pSDevSlnSys.getPSDevSln().getPSDevCenter();
                }
                if (pSDevCenter != null) {
                    pSDevSlnSys.setStudioVer(pSDevCenter.getStudioVer());
                    if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getStudioTag())) {
                        pSDevSlnSys.setStudioTag(pSDevCenter.getStudioTag());
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getStudioTag2())) {
                        pSDevSlnSys.setStudioTag2(pSDevCenter.getStudioTag2());
                    }
                }
            }
            if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDCSysLicId())) {
                object2 = new PSDCSysLic();
                ((PSDCSysLicBase)object2).setPSDCSysLicId(pSDevSlnSys.getPSDCSysLicId());
                object = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)this.getSessionFactory());
                object.get((IEntity)object2);
                ((PSDCSysLicService)object).testLic((PSDCSysLic)object2, "MAXSYSCNT", ((PSDCSysLicBase)object2).getCurSysCnt() + 1);
            }
            this.fillPSDevSlnSysInfo(pSDevSlnSys, false);
            if (!DataObject.getBoolValue((Integer)pSDevSlnSys.getShareFlag(), (boolean)false)) {
                if (bl) {
                    object2 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                    object = new PSSysModelInst();
                    ((PSSysModelInstBase)object).setPSDevCenterId(pSDevCenter.getPSDevCenterId());
                    ((PSSysModelInstBase)object).setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                    ((PSSysModelInstBase)object).setPSSvrDomainId(pSDevCenter.getPSSvrDomainId());
                    String string = StringHelper.format((String)"[\u5f00\u53d1\u7cfb\u7edf]%1$s\\%2$s", (Object)pSDevSlnSys.getPSDevSlnName(), (Object)pSDevSlnSys.getPSDevSlnSysName());
                    ((PSSysModelInstBase)object).setRefInfo(string);
                    ((PSSysModelInstServiceBase)object2).createDraft((PSSysModelInst)object);
                    pSDevSlnSys.setPSSysModelInstId(((PSSysModelInstBase)object).getPSSysModelInstId());
                    pSDevSlnSys.setPSSysModelInstName(((PSSysModelInstBase)object).getPSSysModelInstName());
                } else if (pSDevSlnSys.getDevSysState() != 35) {
                    this.fillPSSysModelInst(pSDevSlnSys);
                }
            }
            if (pSDevSlnSys.getPSDevSln() != null) {
                pSDevSlnSys.setPSSystemId(pSDevSlnSys.getPSDevSln().getPSSystemId());
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSystemId())) {
                pSDevSlnSys.setPSSystemId(DEFAULTSYSTEMID);
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSystemId())) {
                pSDevSlnSys.setPSSystemId(KeyValueHelper.genGuidEx());
            }
        }
        super.onBeforeCreate(pSDevSlnSys);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            this.fillPSDevSlnSysInfo(pSDevSlnSys, true);
            if (pSDevSlnSys.getDevSysState() == null || pSDevSlnSys.getDevSysState() == 10) {
                pSDevSlnSys.setDevSysState(30);
            }
        }
        super.onBeforeUpdate(pSDevSlnSys);
    }

    @Override
    protected void onAfterCreate(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 20) {
                String string = PSDevSlnSysService.getCurrentPSSystemId();
                String string2 = PSDevSlnSysService.getCurrentPSDevSlnSysId();
                PSDevSlnSysService.setCurrentPSSystemId(pSDevSlnSys.getPSSystemId());
                PSDevSlnSysService.setCurrentPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
                try {
                    if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) == 30) {
                        this.syncPSSysModelInst(pSDevSlnSys, true, false);
                    } else {
                        this.syncPSSysModelInst2(pSDevSlnSys, true, false);
                    }
                    PSDevSlnSysService.setCurrentPSSystemId(string);
                    PSDevSlnSysService.setCurrentPSDevSlnSysId(string2);
                }
                catch (Exception exception) {
                    PSDevSlnSysService.setCurrentPSSystemId(string);
                    PSDevSlnSysService.setCurrentPSDevSlnSysId(string2);
                    throw exception;
                }
            } else {
                final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
                SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

                    public void commit() {
                        try {
                            PSDevSlnSysService.this.executeAction("X_ADDBINDSYSMODELTASK", (IEntity)pSDevSlnSys2);
                        }
                        catch (Exception exception) {
                            log.error((Object)exception);
                        }
                    }

                    public void rollback() {
                    }
                });
            }
            PSDevCenterHelper.updatetPSDCResRep(pSDevSlnSys.getPSDevSln().getPSDevCenter(), "DEVSYSCNT");
        }
        super.onAfterCreate(pSDevSlnSys);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) == 30) {
                this.syncPSSysModelInst(pSDevSlnSys, false, false);
            } else {
                this.syncPSSysModelInst2(pSDevSlnSys, false, false);
            }
        }
        super.onAfterUpdate(pSDevSlnSys);
    }

    protected void fillPSSysModelInst(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 20) {
            PSDevCenter pSDevCenter;
            PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("INSTSTATE", (Object)"20");
            PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
            PSDevCenter pSDevCenter2 = pSDevCenter = pSDevSln == null ? null : pSDevSln.getPSDevCenter();
            if (pSDevCenter != null) {
                selectCond.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            }
            if (pSDevCenter != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId())) {
                selectCond.set("PSSVRDOMAINID", (Object)pSDevCenter.getPSSvrDomainId());
            }
            selectCond.set("SYSTYPE", (Object)"DEVSYS");
            String string = DataObject.getStringValue((Object)pSDevSlnSys.get(SRCPSSYSMODELINSTID));
            String string2 = DataObject.getStringValue((Object)pSDevSlnSys.get(DSTPSSYSMODELINSTID));
            if (!StringHelper.isNullOrEmpty((String)string)) {
                selectCond.set("INSTSTATE", (Object)"10");
            } else if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                selectCond.set("PSDBSERVERID", (Object)pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInst().getPSDBServerId());
                selectCond.set("INSTSTATE", (Object)"10");
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                selectCond.set("PSSYSMODELINSTID", (Object)string2);
            }
            selectCond.setMaxRowCount(100);
            ArrayList arrayList = pSSysModelInstService.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                    selectCond.remove("PSDBSERVERID");
                    arrayList = pSSysModelInstService.select((ISelectCond)selectCond);
                }
                if (arrayList.size() == 0) {
                    throw new Exception(StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u65e0\u53ef\u7528\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\uff0c\u8bf7\u8054\u7cfb\u4e2d\u5fc3\u7ba1\u7406\u5458\u786e\u8ba4"));
                }
            }
            int n = random.nextInt(100) % arrayList.size();
            PSSysModelInst pSSysModelInst = (PSSysModelInst)arrayList.get(n);
            pSSysModelInst.setPSDevCenterId(pSDevSlnSys.getPSDevSln().getPSDevCenterId());
            pSSysModelInst.setPSDevCenterName(pSDevSlnSys.getPSDevSln().getPSDevCenterName());
            String string3 = StringHelper.format((String)"[\u5f00\u53d1\u65b9\u6848]%1$s\\%2$s", (Object)pSDevSlnSys.getPSDevSlnName(), (Object)pSDevSlnSys.getPSDevSlnSysName());
            pSSysModelInst.setRefInfo(string3);
            int n2 = -1;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                try {
                    PSSysModelInst pSSysModelInst2 = new PSSysModelInst();
                    pSSysModelInst2.setPSSysModelInstId(string);
                    pSSysModelInstService.get((IEntity)pSSysModelInst2);
                    pSSysModelInst.set("SRCPSSYSMODELINSTID", string);
                    n2 = pSSysModelInst2.getModelVer();
                    pSSysModelInst.set("PSDEVCENTERTSID", pSDevSlnSys.getPSDevCenterTSId());
                    pSSysModelInstService.executeAction("X_CLONE", (IEntity)pSSysModelInst);
                }
                catch (Exception exception) {
                    pSSysModelInst.setInstState("41");
                    pSSysModelInstService.update(pSSysModelInst, false);
                    SessionFactoryManager.commit();
                    log.error((Object)StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
                }
            }
            if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                try {
                    pSSysModelInst.set("SRCPSSYSMODELINSTID", pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInstId());
                    n2 = pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInst().getModelVer();
                    if (pSDevSlnSys.getPPSDevSlnSys() != null) {
                        pSSysModelInst.set("SRCPSSYSMODELINSTID", pSDevSlnSys.getPPSDevSlnSys().getPSSysModelInstId());
                        n2 = pSDevSlnSys.getPPSDevSlnSys().getPSSysModelInst().getModelVer();
                    }
                    pSSysModelInst.set("PSDEVCENTERTSID", pSDevSlnSys.getMainPSDevSlnSys().getPSDevCenterTSId());
                    pSSysModelInstService.executeAction("X_CLONE", (IEntity)pSSysModelInst);
                }
                catch (Exception exception) {
                    pSSysModelInst.setInstState("41");
                    pSSysModelInstService.update(pSSysModelInst, false);
                    SessionFactoryManager.commit();
                    log.error((Object)StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
                }
            }
            pSDevSlnSys.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
            pSDevSlnSys.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
            if (n2 != -1) {
                pSSysModelInst.setModelVer(n2);
            }
            pSSysModelInst.setInstState("30");
            pSSysModelInstService.update(pSSysModelInst);
        } else if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSysModelInstId())) {
            PSDevCenter pSDevCenter;
            PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("INSTSTATE", (Object)"20");
            PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
            PSDevCenter pSDevCenter3 = pSDevCenter = pSDevSln == null ? null : pSDevSln.getPSDevCenter();
            if (pSDevCenter != null) {
                selectCond.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            }
            if (pSDevCenter != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId())) {
                selectCond.set("PSSVRDOMAINID", (Object)pSDevCenter.getPSSvrDomainId());
            }
            selectCond.set("SYSTYPE", (Object)"DEVSYS");
            String string = DataObject.getStringValue((Object)pSDevSlnSys.get(SRCPSSYSMODELINSTID));
            String string4 = DataObject.getStringValue((Object)pSDevSlnSys.get(DSTPSSYSMODELINSTID));
            if (!StringHelper.isNullOrEmpty((String)string)) {
                selectCond.set("INSTSTATE", (Object)"10");
            } else if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                selectCond.set("PSDBSERVERID", (Object)pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInst().getPSDBServerId());
                selectCond.set("INSTSTATE", (Object)"10");
            }
            if (!StringHelper.isNullOrEmpty((String)string4)) {
                selectCond.set("PSSYSMODELINSTID", (Object)string4);
            }
            selectCond.setMaxRowCount(100);
            ArrayList arrayList = pSSysModelInstService.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                    selectCond.remove("PSDBSERVERID");
                    arrayList = pSSysModelInstService.select((ISelectCond)selectCond);
                }
                if (arrayList.size() == 0) {
                    throw new Exception(StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u65e0\u53ef\u7528\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\uff0c\u8bf7\u8054\u7cfb\u4e2d\u5fc3\u7ba1\u7406\u5458\u786e\u8ba4"));
                }
            }
            int n = random.nextInt(100) % arrayList.size();
            PSSysModelInst pSSysModelInst = (PSSysModelInst)arrayList.get(n);
            pSSysModelInst.setPSDevCenterId(pSDevSlnSys.getPSDevSln().getPSDevCenterId());
            pSSysModelInst.setPSDevCenterName(pSDevSlnSys.getPSDevSln().getPSDevCenterName());
            String string5 = StringHelper.format((String)"[\u5f00\u53d1\u7cfb\u7edf]%1$s\\%2$s", (Object)pSDevSlnSys.getPSDevSlnName(), (Object)pSDevSlnSys.getPSDevSlnSysName());
            pSSysModelInst.setRefInfo(string5);
            int n3 = -1;
            pSDevSlnSys.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
            pSDevSlnSys.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
            if (n3 != -1) {
                pSSysModelInst.setModelVer(n3);
            }
            pSSysModelInst.setInstState("30");
            pSSysModelInstService.update(pSSysModelInst);
        } else {
            int n = -1;
            String string = "";
            PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = new PSSysModelInst();
            pSSysModelInst.setPSSysModelInstId(pSDevSlnSys.getPSSysModelInstId());
            if (!StringHelper.isNullOrEmpty((String)string)) {
                try {
                    PSSysModelInst pSSysModelInst3 = new PSSysModelInst();
                    pSSysModelInst3.setPSSysModelInstId(string);
                    pSSysModelInstService.get((IEntity)pSSysModelInst3);
                    pSSysModelInst.set("SRCPSSYSMODELINSTID", string);
                    n = pSSysModelInst3.getModelVer();
                    pSSysModelInst.set("PSDEVCENTERTSID", pSDevSlnSys.getPSDevCenterTSId());
                    pSSysModelInstService.executeAction("X_CLONE", (IEntity)pSSysModelInst);
                }
                catch (Exception exception) {
                    pSSysModelInst.setInstState("41");
                    pSSysModelInstService.update(pSSysModelInst, false);
                    SessionFactoryManager.commit();
                    log.error((Object)StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
                }
            }
            if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                try {
                    pSSysModelInst.set("SRCPSSYSMODELINSTID", pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInstId());
                    n = pSDevSlnSys.getMainPSDevSlnSys().getPSSysModelInst().getModelVer();
                    if (pSDevSlnSys.getPPSDevSlnSys() != null) {
                        pSSysModelInst.set("SRCPSSYSMODELINSTID", pSDevSlnSys.getPPSDevSlnSys().getPSSysModelInstId());
                        n = pSDevSlnSys.getPPSDevSlnSys().getPSSysModelInst().getModelVer();
                    }
                    pSSysModelInst.set("PSDEVCENTERTSID", pSDevSlnSys.getMainPSDevSlnSys().getPSDevCenterTSId());
                    pSSysModelInstService.executeAction("X_CLONE", (IEntity)pSSysModelInst);
                }
                catch (Exception exception) {
                    pSSysModelInst.setInstState("41");
                    pSSysModelInstService.update(pSSysModelInst, false);
                    SessionFactoryManager.commit();
                    log.error((Object)StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u514b\u9686\u7cfb\u7edf\u6a21\u578b\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
                }
            }
            if (n != -1) {
                pSSysModelInst.setModelVer(n);
            }
            pSSysModelInst.setInstState("30");
            pSSysModelInstService.update(pSSysModelInst);
        }
    }

    protected void fillPSDevSlnSysInfo(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        PSDevSlnSysRes pSDevSlnSysRes = pSDevSlnSys.getPSDevSlnSysRes();
        PSDevSlnSys pSDevSlnSys2 = null;
        if (bl) {
            pSDevSlnSys2 = (PSDevSlnSys)this.getLast((IEntity)pSDevSlnSys);
            if (!pSDevSlnSys.isDevSysStateDirty()) {
                pSDevSlnSys.setDevSysState(pSDevSlnSys2.getDevSysState());
            }
            if (!pSDevSlnSys.isEnableDB2Dirty()) {
                pSDevSlnSys.setEnableDB2(pSDevSlnSys2.getEnableDB2());
            }
            if (!pSDevSlnSys.isEnableHBaseDirty()) {
                pSDevSlnSys.setEnableHBase(pSDevSlnSys2.getEnableHBase());
            }
            if (!pSDevSlnSys.isEnableMySQL5Dirty()) {
                pSDevSlnSys.setEnableMySQL5(pSDevSlnSys2.getEnableMySQL5());
            }
            if (!pSDevSlnSys.isEnableOracleDirty()) {
                pSDevSlnSys.setEnableOracle(pSDevSlnSys2.getEnableOracle());
            }
            if (!pSDevSlnSys.isEnablePGSQLDirty()) {
                pSDevSlnSys.setEnablePGSQL(pSDevSlnSys2.getEnablePGSQL());
            }
            if (!pSDevSlnSys.isEnablePPASDirty()) {
                pSDevSlnSys.setEnablePPAS(pSDevSlnSys2.getEnablePPAS());
            }
            if (!pSDevSlnSys.isEnableSqlServerDirty()) {
                pSDevSlnSys.setEnableSqlServer(pSDevSlnSys2.getEnableSqlServer());
            }
            if (!pSDevSlnSys.isEnableSQLiteDirty()) {
                pSDevSlnSys.setEnableSQLite(pSDevSlnSys2.getEnableSQLite());
            }
            if (!pSDevSlnSys.isEnableDMDirty()) {
                pSDevSlnSys.setEnableDM(pSDevSlnSys2.getEnableDM());
            }
            if (!pSDevSlnSys.isEnableHANADirty()) {
                pSDevSlnSys.setEnableHANA(pSDevSlnSys2.getEnableHANA());
            }
        }
        if (pSDevSlnSys.isMainPSDevSlnSysNameDirty() && pSDevSlnSys.isMainPSDevSlnSysIdDirty() && pSDevSlnSys.isSysVerDirty() && !StringHelper.isNullOrEmpty((String)pSDevSlnSys.getMainPSDevSlnSysName())) {
            if (pSDevSlnSys.getMainPSDevSlnSys() != null) {
                pSDevSlnSys.setPSDevSlnId(pSDevSlnSys.getMainPSDevSlnSys().getPSDevSlnId());
                pSDevSlnSys.setPSDevSlnName(pSDevSlnSys.getMainPSDevSlnSys().getPSDevSlnName());
            }
            pSDevSlnSys.setPSDevSlnSysName(StringHelper.format((String)"%1$s_%2$s", (Object)pSDevSlnSys.getMainPSDevSlnSysName(), (Object)pSDevSlnSys.getSysVer().replace(".", "_")));
        }
        String string = "";
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableMySQL5(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "MYSQL5";
            if (pSDevSlnSys.isMySQLPSDCDBInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getMySQLPSDCDBInstId(), (String)pSDevSlnSys.getMySQLPSDCDBInstId(), (boolean)false) != 0) && pSDevSlnSys.getMySQLPSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getMySQLPSDCDBInst().getDBType(), (String)"MYSQL5", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"MySQL"));
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableSqlServer(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "SQLSERVER";
            if (pSDevSlnSys.isMSSQLPSDCDBInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getMSSQLPSDCDBInstId(), (String)pSDevSlnSys.getMSSQLPSDCDBInstId(), (boolean)false) != 0) && pSDevSlnSys.getMSSQLPSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getMSSQLPSDCDBInst().getDBType(), (String)"SQLSERVER", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"SqlServer"));
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableOracle(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "ORACLE";
            if (pSDevSlnSys.isOraPSDCDBInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getOraPSDCDBInstId(), (String)pSDevSlnSys.getOraPSDCDBInstId(), (boolean)false) != 0) && pSDevSlnSys.getOraPSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getOraPSDCDBInst().getDBType(), (String)"ORACLE", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"Oracle"));
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableDB2(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "DB2";
            if (pSDevSlnSys.isDB2PSDCDBInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getDB2PSDCDBInstId(), (String)pSDevSlnSys.getDB2PSDCDBInstId(), (boolean)false) != 0) && pSDevSlnSys.getDB2PSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getDB2PSDCDBInst().getDBType(), (String)"DB2", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"DB2"));
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnablePGSQL(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "POSTGRESQL";
            if (pSDevSlnSys.isPGSQLPSDCDBInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getPGSQLPSDCDBInstId(), (String)pSDevSlnSys.getPGSQLPSDCDBInstId(), (boolean)false) != 0) && pSDevSlnSys.getPGSQLPSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getPGSQLPSDCDBInst().getDBType(), (String)"POSTGRESQL", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"PostgreSQL"));
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnablePPAS(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "PPAS";
            if (pSDevSlnSys.isPPASPSDCDBInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getPPASPSDCDBInstId(), (String)pSDevSlnSys.getPPASPSDCDBInstId(), (boolean)false) != 0) && pSDevSlnSys.getPPASPSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getPPASPSDCDBInst().getDBType(), (String)"PPAS", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"PPAS"));
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableSQLite(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "SQLITE";
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableDM(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "DM";
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableHANA(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "HANA";
        }
        pSDevSlnSys.setDBTypes(string);
        String string2 = "";
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableHBase(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                string2 = string2 + ";";
            }
            string2 = string2 + "HBASE";
            if (pSDevSlnSys.isHBasePSDCBDInstIdDirty() && (pSDevSlnSys2 == null || StringHelper.compare((String)pSDevSlnSys2.getHBasePSDCBDInstId(), (String)pSDevSlnSys.getHBasePSDCBDInstId(), (boolean)false) != 0) && pSDevSlnSys.getHBasePSDCDBInst() != null && StringHelper.compare((String)pSDevSlnSys.getHBasePSDCDBInst().getBDType(), (String)"HBASE", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"HBase"));
            }
        }
        if (pSDevSlnSys.get(PARAM_IGNOREPSDEVCENTERTS) == null && StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevCenterTSId()) && (!bl || pSDevSlnSys.isPSDevCenterTSIdDirty())) {
            PSDevCenterTS pSDevCenterTS = null;
            if (pSDevSlnSys.getPPSDevSlnSys() != null) {
                pSDevCenterTS = pSDevSlnSys.getPPSDevSlnSys().getPSDevCenterTS();
            }
            if (pSDevCenterTS == null && pSDevSlnSys.getMainPSDevSlnSys() != null) {
                pSDevCenterTS = pSDevSlnSys.getMainPSDevSlnSys().getPSDevCenterTS();
            }
            if (pSDevCenterTS == null) {
                PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
                ArrayList<PSDevCenterTS> arrayList = pSDevCenterTSService.selectByPSDevCenter(pSDevSlnSys.getPSDevSln().getPSDevCenter());
                if (arrayList.size() == 0) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4ece\u5e94\u7528\u4e2d\u5fc3\u9009\u62e9\u4efb\u52a1\u670d\u52a1\u5668"));
                }
                int n = 0;
                if (arrayList.size() > 1) {
                    ArrayList<PSDevCenterTS> arrayList2 = new ArrayList<PSDevCenterTS>();
                    for (PSDevCenterTS pSDevCenterTS2 : arrayList) {
                        if (!DataObject.getBoolValue((Integer)pSDevCenterTS2.getValidFlag(), (boolean)true)) continue;
                        if (StringHelper.isNullOrEmpty((String)pSDevCenterTS2.getServerUsage())) {
                            arrayList2.add(pSDevCenterTS2);
                            continue;
                        }
                        if (StringHelper.compare((String)pSDevCenterTS2.getServerUsage(), (String)"SYSPUB", (boolean)false) != 0) continue;
                        arrayList2.add(pSDevCenterTS2);
                    }
                    if (arrayList2.size() > 0) {
                        arrayList.clear();
                        arrayList.addAll(arrayList2);
                    }
                    if (arrayList.size() > 1) {
                        n = random.nextInt(100) % arrayList.size();
                    }
                }
                pSDevCenterTS = arrayList.get(n);
            }
            if (pSDevCenterTS == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4ece\u5e94\u7528\u4e2d\u5fc3\u9009\u62e9\u4efb\u52a1\u670d\u52a1\u5668"));
            }
            pSDevSlnSys.setPSDevCenterTSId(pSDevCenterTS.getPSDevCenterTSId());
            pSDevSlnSys.setPSDevCenterTSName(pSDevCenterTS.getPSDevCenterTSName());
        }
        if (pSDevSlnSysRes != null) {
            pSDevSlnSys.setPSDevCenterSVNId(pSDevSlnSysRes.getPSDevCenterSVNId());
            pSDevSlnSys.setPSDevCenterSVNName(pSDevSlnSysRes.getPSDevCenterSVNName());
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected void syncPSSysModelInst(PSDevSlnSys pSDevSlnSys) throws Exception {
        this.syncPSSysModelInst(pSDevSlnSys, false, false);
    }

    protected void syncPSSysModelInst(PSDevSlnSys pSDevSlnSys, boolean bl, boolean bl2) throws Exception {
        this.syncPSSysModelInst(pSDevSlnSys, bl, bl2, bl);
    }

    /*
     * WARNING - void declaration
     */
    protected void syncPSSysModelInst(PSDevSlnSys pSDevSlnSys, boolean bl, boolean bl2, boolean bl3) throws Exception {
        Object object;
        Object object2;
        void var37_51;
        Object object5;
        Serializable serializable2;
        Object object6;
        HashMap<String, String> hashMap;
        Object object7;
        Object object8;
        HashMap hashMap2;
        String string;
        ActionSessionManager.getCurrentSession().setActionParam(ACTIONPARAM_IGNORECALCRESSTATE, (Object)"");
        PSDevSlnSys pSDevSlnSys2 = null;
        if (!bl) {
            pSDevSlnSys2 = (PSDevSlnSys)this.getLast((IEntity)pSDevSlnSys);
        }
        boolean bl4 = false;
        if (pSDevSlnSys.isShareFlagDirty()) {
            bl4 = DataObject.getBoolValue((Integer)pSDevSlnSys.getShareFlag(), (boolean)false);
        } else if (pSDevSlnSys2 != null) {
            bl4 = DataObject.getBoolValue((Integer)pSDevSlnSys2.getShareFlag(), (boolean)false);
        }
        this.syncPSDevSlnSysRefs(pSDevSlnSys);
        if (bl4) {
            this.syncSharePSSysModelInst(pSDevSlnSys);
            return;
        }
        int n = 0;
        if (pSDevSlnSys.isEnableDynaSysDirty()) {
            n = DataObject.getIntegerValue((Object)pSDevSlnSys.getEnableDynaSys(), (Integer)0);
        } else if (pSDevSlnSys2 != null) {
            n = DataObject.getIntegerValue((Object)pSDevSlnSys2.getEnableDynaSys(), (Integer)0);
        }
        int n2 = 0;
        if (pSDevSlnSys.isSaaSModeDirty()) {
            n2 = DataObject.getIntegerValue((Object)pSDevSlnSys.getSaaSMode(), (Integer)0);
        } else if (pSDevSlnSys2 != null) {
            n2 = DataObject.getIntegerValue((Object)pSDevSlnSys2.getSaaSMode(), (Integer)0);
        }
        String string2 = null;
        if (pSDevSlnSys.isSysVerDirty()) {
            string2 = pSDevSlnSys.getSysVer();
        } else if (pSDevSlnSys2 != null) {
            string2 = pSDevSlnSys2.getSysVer();
        }
        String string3 = pSDevSlnSys.getPSDevSlnSysName();
        String string4 = pSDevSlnSys.getPSDevSlnName();
        if (StringHelper.isNullOrEmpty((String)string3) || StringHelper.isNullOrEmpty((String)string4)) {
            if (pSDevSlnSys2 != null) {
                string3 = pSDevSlnSys2.getPSDevSlnSysName();
                string4 = pSDevSlnSys2.getPSDevSlnName();
            } else {
                string3 = "\u672a\u77e5\u7cfb\u7edf\u540d\u79f0";
            }
        }
        if (StringHelper.isNullOrEmpty((String)(string = pSDevSlnSys.getPSSystemId()))) {
            string = pSDevSlnSys2 != null ? pSDevSlnSys2.getPSSystemId() : DEFAULTSYSTEMID;
        }
        PSDevSlnSysRes pSDevSlnSysRes = null;
        if (pSDevSlnSys.isPSDevSlnSysResIdDirty()) {
            pSDevSlnSysRes = pSDevSlnSys.getPSDevSlnSysRes();
        } else if (pSDevSlnSys2 != null) {
            pSDevSlnSysRes = pSDevSlnSys2.getPSDevSlnSysRes();
        }
        String string5 = null;
        string5 = StringHelper.isNullOrEmpty((String)string4) ? string3 : StringHelper.format((String)"%1$s\\%2$s", (Object)string4, (Object)string3);
        ArrayList<IEntity> arrayList = new ArrayList<IEntity>();
        PSSystem pSSystem = new PSSystem();
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSys.getPSSysModelInst());
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)sessionFactory);
        PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)sessionFactory);
        PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)sessionFactory);
        PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)sessionFactory);
        PSSystemASService pSSystemASService = (PSSystemASService)ServiceGlobal.getService(PSSystemASService.class, (SessionFactory)sessionFactory);
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)sessionFactory);
        PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)sessionFactory);
        PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)sessionFactory);
        PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)sessionFactory);
        PSSysBDInstCfgService pSSysBDInstCfgService = (PSSysBDInstCfgService)ServiceGlobal.getService(PSSysBDInstCfgService.class, (SessionFactory)sessionFactory);
        PSDynaSysService pSDynaSysService = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, (SessionFactory)sessionFactory);
        if (bl) {
            hashMap2 = new PSSystem();
            ((PSSystemBase)((Object)hashMap2)).setPSSystemId(pSDevSlnSys.getPSSystemId());
            if (pSSystemService.get((PSSystem)((Object)hashMap2), true)) {
                hashMap2.reset();
                ((PSSystemBase)((Object)hashMap2)).setPSSystemId(pSDevSlnSys.getPSSystemId());
                ((PSSystemBase)((Object)hashMap2)).setEnableDynaSys(pSDevSlnSys.getEnableDynaSys());
                ((PSSystemBase)((Object)hashMap2)).setPSDevSlnId(null);
                ((PSSystemBase)((Object)hashMap2)).setPSDevSlnSysId(null);
                ((PSSystemBase)((Object)hashMap2)).setPSDevCenterTSId(null);
                ((PSSystemBase)((Object)hashMap2)).setPSDevCenterTSName(null);
                pSSystemService.update(hashMap2, false);
                object8 = pSSystemDBCfgService.select((ISelectCond)new SelectCond());
                object7 = ((ArrayList)object8).iterator();
                while (object7.hasNext()) {
                    hashMap = (PSSystemDBCfg)object7.next();
                    ((PSSystemDBCfgBase)((Object)hashMap)).setPSDevCenterDBInstId(null);
                    ((PSSystemDBCfgBase)((Object)hashMap)).setPSDevCenterDBInstName(null);
                    ((PSSystemDBCfgBase)((Object)hashMap)).setPSDBDevInstId(null);
                    ((PSSystemDBCfgBase)((Object)hashMap)).setPSDBDevInstName(null);
                    pSSystemDBCfgService.update(hashMap, false);
                }
                object7 = pSSystemASService.select((ISelectCond)new SelectCond());
                hashMap = ((ArrayList)object7).iterator();
                while (hashMap.hasNext()) {
                    object6 = (PSSystemAS)hashMap.next();
                    ((PSSystemASBase)object6).setPSAppServerId(null);
                    ((PSSystemASBase)object6).setPSDevCenterASId(null);
                    ((PSSystemASBase)object6).setPSDevCenterASName(null);
                    pSSystemASService.update(object6, false);
                }
                hashMap = pSSysBDInstCfgService.select((ISelectCond)new SelectCond());
                object6 = ((ArrayList)((Object)hashMap)).iterator();
                while (object6.hasNext()) {
                    serializable2 = (PSSysBDInstCfg)object6.next();
                    ((PSSysBDInstCfgBase)serializable2).setPSDCBDInstId(null);
                    ((PSSysBDInstCfgBase)serializable2).setPSDCBDInstName(null);
                    pSSysBDInstCfgService.update(serializable2, false);
                }
            }
        }
        if (bl) {
            hashMap2 = pSDevSlnService.select((ISelectCond)new SelectCond());
            object8 = ((ArrayList)((Object)hashMap2)).iterator();
            while (object8.hasNext()) {
                object7 = (PSDevSln)object8.next();
                if (StringHelper.compare((String)((PSDevSlnBase)object7).getPSDevSlnId(), (String)pSDevSlnSys.getPSDevSlnId(), (boolean)false) == 0) continue;
                try {
                    pSDevSlnService.remove((IEntity)object7);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                }
            }
        }
        if (bl) {
            hashMap2 = pSDevCenterService.select((ISelectCond)new SelectCond());
            object8 = ((ArrayList)((Object)hashMap2)).iterator();
            while (object8.hasNext()) {
                object7 = (PSDevCenter)object8.next();
                if (StringHelper.compare((String)((PSDevCenterBase)object7).getPSDevCenterId(), (String)pSDevSlnSys.getPSDevSln().getPSDevCenterId(), (boolean)false) == 0) continue;
                try {
                    pSDevCenterService.remove((IEntity)object7);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u5e94\u7528\u4e2d\u5fc3\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                }
            }
        }
        if (bl) {
            hashMap2 = pSDevSlnSys.getPSDevSln();
            object8 = ((PSDevSlnBase)((Object)hashMap2)).getPSDevCenter();
            object7 = new PSDevCenter();
            object8.copyTo((IDataObject)object7, true);
            hashMap = ((PSDevCenterBase)object8).getPSSvrDomain();
            if (hashMap != null) {
                object6 = new PSSvrDomain();
                hashMap.copyTo((IDataObject)object6, true);
                pSSvrDomainService.save((IEntity)object6, false);
            }
            ((PSDevCenterBase)object7).setV6PSSvnInstRepoId(null);
            ((PSDevCenterBase)object7).setV6PSSvnInstRepoName(null);
            ((PSDevCenterBase)object7).setPSPMSServerId(null);
            ((PSDevCenterBase)object7).setPSPMSServerName(null);
            pSDevCenterService.save((IEntity)object7, false);
            object6 = new PSDevSln();
            hashMap2.copyTo((IDataObject)object6, true);
            ((PSDevSlnBase)object6).setAdminPSDevUserId(null);
            ((PSDevSlnBase)object6).setAdminPSDevUserName(null);
            ((PSDevSlnBase)object6).setPSDCDeployCenterId(null);
            ((PSDevSlnBase)object6).setPSDCDeployCenterName(null);
            ((PSDevSlnBase)object6).setPSDCWorkshopServerId(null);
            ((PSDevSlnBase)object6).setPSDCWorkshopServerName(null);
            ((PSDevSlnBase)object6).setPSSystemId(null);
            ((PSDevSlnBase)object6).setVCUser(null);
            ((PSDevSlnBase)object6).setVCPassword(null);
            pSDevSlnService.save((IEntity)object6, false);
        }
        hashMap2 = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)sessionFactory);
        object8 = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)sessionFactory);
        if (pSDevSlnSys.getPSDevCenterTS() != null) {
            object7 = pSDevSlnSys.getPSDevCenterTS().getPSTaskServer();
            hashMap = new PSTaskServer();
            object7.copyTo((IDataObject)hashMap, false);
            ((PSTaskServerBase)((Object)hashMap)).setPSMobAppPackServerId(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSMobAppPackServerName(null);
            ((PSTaskServerBase)((Object)hashMap)).setNo2PSMobAppPSId(null);
            ((PSTaskServerBase)((Object)hashMap)).setNo2PSMobAppPSName(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSDeployCenterId(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSDeployCenterName(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSWorkshopServerId(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSWorkshopServerName(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSSvrDomainId(null);
            ((PSTaskServerBase)((Object)hashMap)).setPSSvrDomainName(null);
            object8.save((IEntity)hashMap);
            object6 = new PSDevCenterTS();
            pSDevSlnSys.getPSDevCenterTS().copyTo((IDataObject)object6, false);
            hashMap2.save((IEntity)object6);
        }
        hashMap2 = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)sessionFactory);
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSFId())) {
            object8 = new PSSF();
            ((PSSFBase)object8).setPSSFId(pSDevSlnSys.getPSSFId());
            if (((PSCoreSysServiceBase)((Object)hashMap2)).checkKey(object8) == 0) {
                pSDevSlnSys.getPSSF().copyTo((IDataObject)object8, false);
                ((PSCoreSysServiceBase)((Object)hashMap2)).update(object8, false);
            }
        }
        hashMap2 = pSDevSlnSys.getPSDevSln();
        if (bl) {
            pSDevSlnSys.copyTo((IDataObject)pSSystem, true);
            pSSystem.setPSDevCenterId(((PSDevSlnBase)((Object)hashMap2)).getPSDevCenterId());
            pSSystem.setPSDevCenterName(((PSDevSlnBase)((Object)hashMap2)).getPSDevCenterName());
            pSSystem.setPSSystemName(pSDevSlnSys.getPSDevSlnSysName());
            pSSystemService.save((IEntity)pSSystem);
            pSSystemService.mergeChild("", "", pSSystem.getPSSystemId());
        } else {
            pSSystem.setPSSystemId(pSDevSlnSys.getPSSystemId());
            pSSystem.setDBTypes(pSDevSlnSys.getDBTypes());
            pSSystem.setPSDevCenterId(((PSDevSlnBase)((Object)hashMap2)).getPSDevCenterId());
            pSSystem.setPSDevCenterName(((PSDevSlnBase)((Object)hashMap2)).getPSDevCenterName());
            pSSystem.setPSSystemName(pSDevSlnSys.getPSDevSlnSysName());
            pSSystemService.save((IEntity)pSSystem);
        }
        hashMap2 = new HashMap();
        object8 = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        object7 = new SelectCond();
        object7.set("PSSYSTEMID", (Object)string);
        hashMap = pSSystemASService.select((ISelectCond)object7);
        object6 = ((ArrayList)((Object)hashMap)).iterator();
        while (object6.hasNext()) {
            serializable2 = (PSSystemAS)object6.next();
            object5 = ((PSSystemASBase)serializable2).getPSDevCenterASId();
            if (StringHelper.isNullOrEmpty((String)object5)) continue;
            PSDevCenterAS serializable3 = new PSDevCenterAS();
            serializable3.setPSDevCenterASId((String)object5);
            object8.get((IEntity)serializable3);
            if (!StringHelper.isNullOrEmpty((String)serializable3.getRefObjType()) && StringHelper.compare((String)serializable3.getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)serializable3.getRefObjId()) && StringHelper.compare((String)serializable3.getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0) continue;
            serializable3.setRefFlag(0);
            serializable3.setRefObjType(null);
            serializable3.setRefObjId(null);
            serializable3.setRefObjName(null);
            ((PSCoreSysServiceBase)object8).update(serializable3, false);
        }
        object6 = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)sessionFactory);
        serializable2 = pSDevSlnSys.getPSDevCenterASId();
        object5 = pSDevSlnSys.getPSDevCenterASName();
        if (StringHelper.isNullOrEmpty((String)((Object)serializable2)) && pSDevSlnSysRes != null) {
            if (pSDevSlnSysRes.getResPos() == 1 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getPSDevCenterASId())) {
                serializable2 = pSDevSlnSysRes.getPSDevCenterASId();
                object5 = pSDevSlnSysRes.getPSDevCenterASName();
            } else if (pSDevSlnSysRes.getResPos() == 2 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getUPSDevCenterASId())) {
                serializable2 = pSDevSlnSysRes.getUPSDevCenterASId();
                object5 = pSDevSlnSysRes.getUPSDevCenterASName();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)((Object)serializable2))) {
            if (hashMap2.containsKey(serializable2)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string5, (Object)object5));
            }
            hashMap2.put(serializable2, object5);
            PSDevCenterAS exception = new PSDevCenterAS();
            exception.setPSDevCenterASId((String)((Object)serializable2));
            object8.get((IEntity)exception);
            if (DataObject.getBoolValue((Integer)exception.getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)exception.getRefObjType()) && StringHelper.compare((String)exception.getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)exception.getRefObjId()) && StringHelper.compare((String)exception.getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)exception.getPSDevCenterASName(), (Object)exception.getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)exception);
            exception.reset();
            exception.setPSDevCenterASId((String)((Object)serializable2));
            exception.setRefFlag(1);
            exception.setRefObjType("PSDEVSLNSYS");
            exception.setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            exception.setRefObjName(string5);
            ((PSCoreSysServiceBaseBase)((Object)object8)).update(exception);
            object6.save((IEntity)exception);
        }
        String string6 = pSDevSlnSys.getPSDevCenterASId2();
        Iterator<PSSysApp> iterator = pSDevSlnSys.getPSDevCenterASName2();
        if (StringHelper.isNullOrEmpty((String)string6) && pSDevSlnSysRes != null) {
            if (pSDevSlnSysRes.getResPos() == 1 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getPSDevCenterASId2())) {
                String string7 = pSDevSlnSysRes.getPSDevCenterASId2();
                iterator = pSDevSlnSysRes.getPSDevCenterASName2();
            } else if (pSDevSlnSysRes.getResPos() == 2 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getUPSDevCenterASId2())) {
                String string8 = pSDevSlnSysRes.getUPSDevCenterASId2();
                iterator = pSDevSlnSysRes.getUPSDevCenterASName2();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)var37_51)) {
            if (hashMap2.containsKey(var37_51)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string5, (Object)iterator));
            }
            hashMap2.put(var37_51, iterator);
            PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
            pSDevCenterAS.setPSDevCenterASId((String)var37_51);
            object8.get((IEntity)pSDevCenterAS);
            if (DataObject.getBoolValue((Integer)pSDevCenterAS.getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)pSDevCenterAS.getRefObjType()) && StringHelper.compare((String)pSDevCenterAS.getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)pSDevCenterAS.getRefObjId()) && StringHelper.compare((String)pSDevCenterAS.getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)pSDevCenterAS.getPSDevCenterASName(), (Object)pSDevCenterAS.getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)pSDevCenterAS);
            pSDevCenterAS.reset();
            pSDevCenterAS.setPSDevCenterASId((String)var37_51);
            pSDevCenterAS.setRefFlag(1);
            pSDevCenterAS.setRefObjType("PSDEVSLNSYS");
            pSDevCenterAS.setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevCenterAS.setRefObjName(string5);
            ((PSCoreSysServiceBaseBase)((Object)object8)).update(pSDevCenterAS);
            object6.save((IEntity)pSDevCenterAS);
        }
        String string9 = pSDevSlnSys.getPSDevCenterAS3Id();
        Object object3 = pSDevSlnSys.getPSDevCenterAS3Name();
        if (!StringHelper.isNullOrEmpty((String)string9)) {
            if (hashMap2.containsKey(string9)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string5, (Object)object3));
            }
            hashMap2.put(string9, object3);
            PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
            pSDevCenterAS.setPSDevCenterASId(string9);
            object8.get((IEntity)pSDevCenterAS);
            if (DataObject.getBoolValue((Integer)pSDevCenterAS.getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)pSDevCenterAS.getRefObjType()) && StringHelper.compare((String)pSDevCenterAS.getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)pSDevCenterAS.getRefObjId()) && StringHelper.compare((String)pSDevCenterAS.getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)pSDevCenterAS.getPSDevCenterASName(), (Object)pSDevCenterAS.getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)pSDevCenterAS);
            pSDevCenterAS.reset();
            pSDevCenterAS.setPSDevCenterASId(string9);
            pSDevCenterAS.setRefFlag(1);
            pSDevCenterAS.setRefObjType("PSDEVSLNSYS");
            pSDevCenterAS.setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevCenterAS.setRefObjName(string5);
            ((PSCoreSysServiceBaseBase)((Object)object8)).update(pSDevCenterAS);
            object6.save((IEntity)pSDevCenterAS);
        }
        String string10 = pSDevSlnSys.getPSDevCenterAS4Id();
        Object object4 = pSDevSlnSys.getPSDevCenterAS4Name();
        if (!StringHelper.isNullOrEmpty((String)string10)) {
            if (hashMap2.containsKey(string10)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string5, (Object)object4));
            }
            hashMap2.put(string10, object4);
            object2 = new PSDevCenterAS();
            ((PSDevCenterASBase)object2).setPSDevCenterASId(string10);
            object8.get((IEntity)object2);
            if (DataObject.getBoolValue((Integer)((PSDevCenterASBase)object2).getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)object2).getRefObjType()) && StringHelper.compare((String)((PSDevCenterASBase)object2).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)object2).getRefObjId()) && StringHelper.compare((String)((PSDevCenterASBase)object2).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)((PSDevCenterASBase)object2).getPSDevCenterASName(), (Object)((PSDevCenterASBase)object2).getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)object2);
            object2.reset();
            ((PSDevCenterASBase)object2).setPSDevCenterASId(string10);
            ((PSDevCenterASBase)object2).setRefFlag(1);
            ((PSDevCenterASBase)object2).setRefObjType("PSDEVSLNSYS");
            ((PSDevCenterASBase)object2).setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevCenterASBase)object2).setRefObjName(string5);
            ((PSCoreSysServiceBaseBase)((Object)object8)).update(object2);
            object6.save((IEntity)object2);
        }
        object2 = new PSSystemAS();
        ((PSSystemASBase)object2).setPSSystemId(pSSystem.getPSSystemId());
        ((PSSystemASBase)object2).setPSSystemName(pSSystem.getPSSystemName());
        ((PSSystemASBase)object2).setASId("AS01");
        if (!StringHelper.isNullOrEmpty((String)((Object)serializable2))) {
            ((PSSystemASBase)object2).setPSSystemASName((String)object5);
            ((PSSystemASBase)object2).setPSDevCenterASId((String)((Object)serializable2));
            ((PSSystemASBase)object2).setPSDevCenterASName((String)object5);
        } else {
            ((PSSystemASBase)object2).setPSSystemASName("\u672a\u6307\u5b9a");
            ((PSSystemASBase)object2).setPSDevCenterASId(null);
            ((PSSystemASBase)object2).setPSDevCenterASName(null);
        }
        pSSystemASService.save((IEntity)object2);
        object2 = new PSSystemAS();
        ((PSSystemASBase)object2).setPSSystemId(pSSystem.getPSSystemId());
        ((PSSystemASBase)object2).setPSSystemName(pSSystem.getPSSystemName());
        ((PSSystemASBase)object2).setASId("AS02");
        if (!StringHelper.isNullOrEmpty((String)var37_51)) {
            ((PSSystemASBase)object2).setPSSystemASName((String)((Object)iterator));
            ((PSSystemASBase)object2).setPSDevCenterASId((String)var37_51);
            ((PSSystemASBase)object2).setPSDevCenterASName((String)((Object)iterator));
        } else {
            ((PSSystemASBase)object2).setPSSystemASName("\u672a\u6307\u5b9a");
            ((PSSystemASBase)object2).setPSDevCenterASId(null);
            ((PSSystemASBase)object2).setPSDevCenterASName(null);
        }
        pSSystemASService.save((IEntity)object2);
        object2 = new PSSystemAS();
        ((PSSystemASBase)object2).setPSSystemId(pSSystem.getPSSystemId());
        ((PSSystemASBase)object2).setPSSystemName(pSSystem.getPSSystemName());
        ((PSSystemASBase)object2).setASId("AS03");
        if (!StringHelper.isNullOrEmpty((String)string9)) {
            ((PSSystemASBase)object2).setPSSystemASName((String)object3);
            ((PSSystemASBase)object2).setPSDevCenterASId(string9);
            ((PSSystemASBase)object2).setPSDevCenterASName((String)object3);
        } else {
            ((PSSystemASBase)object2).setPSSystemASName("\u672a\u6307\u5b9a");
            ((PSSystemASBase)object2).setPSDevCenterASId(null);
            ((PSSystemASBase)object2).setPSDevCenterASName(null);
        }
        pSSystemASService.save((IEntity)object2);
        object2 = new PSSystemAS();
        ((PSSystemASBase)object2).setPSSystemId(pSSystem.getPSSystemId());
        ((PSSystemASBase)object2).setPSSystemName(pSSystem.getPSSystemName());
        ((PSSystemASBase)object2).setASId("AS04");
        if (!StringHelper.isNullOrEmpty((String)string10)) {
            ((PSSystemASBase)object2).setPSSystemASName((String)object4);
            ((PSSystemASBase)object2).setPSDevCenterASId(string10);
            ((PSSystemASBase)object2).setPSDevCenterASName((String)object4);
        } else {
            ((PSSystemASBase)object2).setPSSystemASName("\u672a\u6307\u5b9a");
            ((PSSystemASBase)object2).setPSDevCenterASId(null);
            ((PSSystemASBase)object2).setPSDevCenterASName(null);
        }
        pSSystemASService.save((IEntity)object2);
        object8 = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)sessionFactory);
        object7 = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)sessionFactory);
        hashMap = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        object6 = (PSDCDBInstRefService)ServiceGlobal.getService(PSDCDBInstRefService.class, (SessionFactory)this.getSessionFactory());
        serializable2 = pSSystemDBCfgService.selectByPSSystem(pSSystem);
        object5 = new ArrayList();
        ArrayList<PSSystemDBCfg> arrayList2 = new ArrayList<PSSystemDBCfg>();
        iterator = new HashMap();
        HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableMySQL5(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("MYSQL5", null);
            if (pSDevSlnSys.getMySQLPSDCDBInst() != null) {
                ((HashMap)((Object)iterator)).put("MYSQL5", pSDevSlnSys.getMySQLPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getMySQLPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("MYSQL5", pSDevSlnSysRes.getMySQLPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUMySQLPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("MYSQL5", pSDevSlnSysRes.getUMySQLPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableDB2(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("DB2", null);
            if (pSDevSlnSys.getDB2PSDCDBInst() != null) {
                ((HashMap)((Object)iterator)).put("DB2", pSDevSlnSys.getDB2PSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getDB2PSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("DB2", pSDevSlnSysRes.getDB2PSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUDB2PSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("DB2", pSDevSlnSysRes.getUDB2PSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableOracle(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("ORACLE", null);
            if (pSDevSlnSys.getOraPSDCDBInst() != null) {
                ((HashMap)((Object)iterator)).put("ORACLE", pSDevSlnSys.getOraPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getOraPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("ORACLE", pSDevSlnSysRes.getOraPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUOraPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("ORACLE", pSDevSlnSysRes.getUOraPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableSqlServer(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("SQLSERVER", null);
            if (pSDevSlnSys.getMSSQLPSDCDBInst() != null) {
                ((HashMap)((Object)iterator)).put("SQLSERVER", pSDevSlnSys.getMSSQLPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getMSSqlPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("SQLSERVER", pSDevSlnSysRes.getMSSqlPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUMSSqlPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("SQLSERVER", pSDevSlnSysRes.getUMSSqlPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnablePGSQL(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("POSTGRESQL", null);
            if (pSDevSlnSys.getPGSQLPSDCDBInst() != null) {
                ((HashMap)((Object)iterator)).put("POSTGRESQL", pSDevSlnSys.getPGSQLPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getPGSQLPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("POSTGRESQL", pSDevSlnSysRes.getPGSQLPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUPGSQLPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("POSTGRESQL", pSDevSlnSysRes.getUPGSQLPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnablePPAS(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("PPAS", null);
            if (pSDevSlnSys.getPPASPSDCDBInst() != null) {
                ((HashMap)((Object)iterator)).put("PPAS", pSDevSlnSys.getPPASPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getPPASPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("PPAS", pSDevSlnSysRes.getPPASPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUPPASPSDCDBInst() != null) {
                    ((HashMap)((Object)iterator)).put("PPAS", pSDevSlnSysRes.getUPPASPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableSQLite(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("SQLITE", null);
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableDM(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("DM", null);
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableHANA(), (boolean)false)) {
            ((HashMap)((Object)iterator)).put("HANA", null);
        }
        object3 = ((ArrayList)serializable2).iterator();
        while (object3.hasNext()) {
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)object3.next();
            if (!((HashMap)((Object)iterator)).containsKey(pSSystemDBCfg.getPSSystemDBCfgName())) {
                arrayList2.add(pSSystemDBCfg);
            }
            if ((object4 = (PSDevCenterDBInst)((HashMap)((Object)iterator)).get(pSSystemDBCfg.getPSSystemDBCfgName())) == null) {
                ((ArrayList)object5).add(pSSystemDBCfg);
                continue;
            }
            if (StringHelper.compare((String)pSSystemDBCfg.getPSDevCenterDBInstId(), (String)((PSDevCenterDBInstBase)object4).getPSDevCenterDBInstId(), (boolean)true) == 0 || StringHelper.isNullOrEmpty((String)pSSystemDBCfg.getPSDevCenterDBInstId())) continue;
            ((ArrayList)object5).add(pSSystemDBCfg);
        }
        object3 = ((ArrayList)object5).iterator();
        while (object3.hasNext()) {
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)object3.next();
            hashMap3.put(pSSystemDBCfg.getPSDevCenterDBInstId(), "");
        }
        for (PSSystemDBCfg pSSystemDBCfg : arrayList2) {
            try {
                pSSystemDBCfgService.remove((IEntity)pSSystemDBCfg);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u7cfb\u7edf\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
        }
        for (String string11 : ((HashMap)((Object)iterator)).keySet()) {
            object4 = (PSDevCenterDBInst)((HashMap)((Object)iterator)).get(string11);
            if (object4 != null) {
                if (!StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)object4).getPSDevCenterASId()) && !hashMap2.containsKey(((PSDevCenterDBInstBase)object4).getPSDevCenterASId())) {
                    throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5fc5\u987b\u5728\u5e94\u7528\u5bb9\u5668[%2$s]\u4e0b\u4f7f\u7528", (Object)((PSDevCenterDBInstBase)object4).getPSDevCenterDBInstName(), (Object)((PSDevCenterDBInstBase)object4).getPSDevCenterASName()));
                }
                this.addToPSResList(arrayList, (IEntity)object4);
                if (((PSDevCenterDBInstBase)object4).getPSDBDevInst() != null) {
                    object2 = ((PSDevCenterDBInstBase)object4).getPSDBDevInst();
                    ((PSDBDevInstBase)object2).setPSSvrDomainId(null);
                    ((PSDBDevInstBase)object2).setPSSvrDomainName(null);
                    ((PSDBDevInstBase)object2).setPasswd("******");
                    ((PSDBDevInstBase)object2).setDMPassWD("******");
                    object8.save((IEntity)object2);
                }
                object7.save((IEntity)object4);
            }
            object2 = new PSSystemDBCfg();
            ((PSSystemDBCfgBase)object2).setPSSystemDBCfgName(string11);
            if (object4 != null && ((PSDevCenterDBInstBase)object4).getPSDBDevInst() != null) {
                ((PSSystemDBCfgBase)object2).setPSDBDevInstId(((PSDevCenterDBInstBase)object4).getPSDBDevInst().getPSDBDevInstId());
                ((PSSystemDBCfgBase)object2).setPSDBDevInstName(((PSDevCenterDBInstBase)object4).getPSDBDevInst().getPSDBDevInstName());
            } else {
                ((PSSystemDBCfgBase)object2).setPSDBDevInstId(null);
                ((PSSystemDBCfgBase)object2).setPSDBDevInstName(null);
            }
            ((PSSystemDBCfgBase)object2).setPSSystemId(pSSystem.getPSSystemId());
            ((PSSystemDBCfgBase)object2).setPSSystemName(pSSystem.getPSSystemName());
            if (object4 != null) {
                ((PSSystemDBCfgBase)object2).setPSDevCenterDBInstId(((PSDevCenterDBInstBase)object4).getPSDevCenterDBInstId());
                ((PSSystemDBCfgBase)object2).setPSDevCenterDBInstName(((PSDevCenterDBInstBase)object4).getPSDevCenterDBInstName());
            } else {
                ((PSSystemDBCfgBase)object2).setPSDevCenterDBInstId(null);
                ((PSSystemDBCfgBase)object2).setPSDevCenterDBInstName(null);
            }
            pSSystemDBCfgService.save((IEntity)object2, false);
            if (object4 == null) continue;
            object = ((PSDevCenterDBInstBase)object4).getPSDevCenterDBInstName();
            if (StringHelper.isNullOrEmpty((String)object)) {
                object = "\u6570\u636e\u5e93\u5b9e\u4f8b\u540d\u79f0";
            }
            hashMap3.put(((PSDevCenterDBInstBase)object4).getPSDevCenterDBInstId(), object);
        }
        for (String string12 : hashMap3.keySet()) {
            boolean bl5;
            object4 = (String)hashMap3.get(string12);
            object2 = new PSDevCenterDBInst();
            ((PSDevCenterDBInstBase)object2).setPSDevCenterDBInstId(string12);
            object = new PSDCDBInstRef();
            ((PSDCDBInstRefBase)object).setRefObjType("PSDEVSLNSYS");
            ((PSDCDBInstRefBase)object).setPSDevCenterDBInstId(string12);
            ((PSDCDBInstRefBase)object).setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            object6.fillEntityKeyValue((IEntity)object);
            boolean bl6 = bl5 = ((PSCoreSysServiceBase)object6).checkKey(object) == 0;
            if (!StringHelper.isNullOrEmpty((String)object4)) {
                if (!bl5) continue;
                PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
                ((PSDCDBInstRefBase)object).setPSDevCenterId(pSDevSln.getPSDevCenterId());
                ((PSDCDBInstRefBase)object).setPSDevCenterName(pSDevSln.getPSDevCenterName());
                ((PSDCDBInstRefBase)object).setPSDevCenterDBInstName((String)object4);
                ((PSDCDBInstRefBase)object).setRefObjName(string3);
                ((PSDCDBInstRefBase)object).setPSDCDBInstRefName(string5);
                ((PSCoreSysServiceBase)object6).create(object, false);
                continue;
            }
            if (bl5) continue;
            try {
                object6.remove((IEntity)object);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
        }
        object8 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        boolean bl7 = true;
        if (pSDevSlnSys2 != null && !StringHelper.isNullOrEmpty((String)pSDevSlnSys2.getPSDevCenterSVNId())) {
            if (StringHelper.compare((String)pSDevSlnSys2.getPSDevCenterSVNId(), (String)pSDevSlnSys.getPSDevCenterSVNId(), (boolean)false) != 0) {
                hashMap = new PSDevCenterSVN();
                ((PSDevCenterSVNBase)((Object)hashMap)).setPSDevCenterSVNId(pSDevSlnSys2.getPSDevCenterSVNId());
                object8.get((IEntity)hashMap);
                if ((StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)((Object)hashMap)).getRefObjType()) || StringHelper.compare((String)((PSDevCenterSVNBase)((Object)hashMap)).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) == 0) && (StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)((Object)hashMap)).getRefObjId()) || StringHelper.compare((String)((PSDevCenterSVNBase)((Object)hashMap)).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) == 0)) {
                    ((PSDevCenterSVNBase)((Object)hashMap)).setRefFlag(0);
                    ((PSDevCenterSVNBase)((Object)hashMap)).setRefObjId(null);
                    ((PSDevCenterSVNBase)((Object)hashMap)).setRefObjName(null);
                    ((PSDevCenterSVNBase)((Object)hashMap)).setRefObjType(null);
                    ((PSCoreSysServiceBaseBase)((Object)object8)).update(hashMap);
                }
            } else {
                bl7 = false;
            }
        }
        if (bl7) {
            hashMap = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)sessionFactory);
            if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevCenterSVNId())) {
                object6 = new PSDevCenterSVN();
                ((PSDevCenterSVNBase)object6).setPSDevCenterSVNId(pSDevSlnSys.getPSDevCenterSVNId());
                object8.get((IEntity)object6);
                if (DataObject.getBoolValue((Integer)((PSDevCenterSVNBase)object6).getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)object6).getRefObjType()) && StringHelper.compare((String)((PSDevCenterSVNBase)object6).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)object6).getRefObjId()) && StringHelper.compare((String)((PSDevCenterSVNBase)object6).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                    throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u7248\u672c\u5e93[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)((PSDevCenterSVNBase)object6).getPSDevCenterSVNName(), (Object)((PSDevCenterSVNBase)object6).getRefObjName()));
                }
                this.addToPSResList(arrayList, (IEntity)object6);
                object6.reset();
                ((PSDevCenterSVNBase)object6).setPSDevCenterSVNId(pSDevSlnSys.getPSDevCenterSVNId());
                ((PSDevCenterSVNBase)object6).setRefFlag(1);
                ((PSDevCenterSVNBase)object6).setRefObjType("PSDEVSLNSYS");
                ((PSDevCenterSVNBase)object6).setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
                ((PSDevCenterSVNBase)object6).setRefObjName(string5);
                ((PSCoreSysServiceBaseBase)((Object)object8)).update(object6);
                hashMap.save((IEntity)object6);
            }
        }
        object8 = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
        PSSysRefService pSSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)sessionFactory);
        hashMap = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)sessionFactory);
        boolean bl8 = true;
        if (pSDevSlnSys2 != null && !StringHelper.isNullOrEmpty((String)pSDevSlnSys2.getSFPSSubSysId())) {
            if (StringHelper.compare((String)pSDevSlnSys2.getSFPSSubSysId(), (String)pSDevSlnSys.getSFPSSubSysId(), (boolean)false) != 0) {
                serializable2 = new PSSubSys();
                ((PSSubSysBase)serializable2).setPSSubSysId(pSDevSlnSys2.getSFPSSubSysId());
                object5 = pSSysRefService.selectByPSSubSys((PSSubSysBase)serializable2);
                Iterator<PSSysRef> iterator2 = ((ArrayList)object5).iterator();
                while (iterator2.hasNext()) {
                    iterator = iterator2.next();
                    try {
                        pSSysRefService.remove((IEntity)iterator);
                    }
                    catch (Exception exception) {
                        log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u7cfb\u7edf\u5f15\u7528\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    }
                }
                try {
                    hashMap.remove((IEntity)serializable2);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u5b50\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                }
            } else {
                bl8 = false;
            }
        }
        if (bl8 && !StringHelper.isNullOrEmpty((String)pSDevSlnSys.getSFPSSubSysId())) {
            serializable2 = new PSSubSys();
            ((PSSubSysBase)serializable2).setPSSubSysId(pSDevSlnSys.getSFPSSubSysId());
            object8.get((IEntity)serializable2);
            hashMap.save((IEntity)serializable2);
            object5 = new PSSysRef();
            ((PSSysRefBase)object5).setPSSubSysId(((PSSubSysBase)serializable2).getPSSubSysId());
            ((PSSysRefBase)object5).setPSSubSysName(((PSSubSysBase)serializable2).getPSSubSysName());
            ((PSSysRefBase)object5).setPSSystemId(pSSystem.getPSSystemId());
            ((PSSysRefBase)object5).setPSSystemName(pSSystem.getPSSystemName());
            ((PSSysRefBase)object5).setPSSysRefName(((PSSubSysBase)serializable2).getPSSubSysName());
            ((PSSysRefBase)object5).setMemo(((PSSubSysBase)serializable2).getMemo());
            ((PSSysRefBase)object5).setSysRefType("SUBSYS");
            ((PSSysRefBase)object5).setRealSysId(((PSSubSysBase)serializable2).getPSSubSysId());
            ((PSSysRefBase)object5).setOrderValue(0);
            ((PSSysRefBase)object5).setSFFWFlag(((PSSubSysBase)serializable2).getSFFWFlag());
            pSSysRefService.save((IEntity)object5);
        }
        object8 = new PSDevSlnSys();
        ((PSDevSlnSysBase)object8).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        this.calcPSDevSlnSysResState((PSDevSlnSys)object8, arrayList);
        this.sysUpdate(object8, false);
        pSDevSlnSys.setDevResInfo(((PSDevSlnSysBase)object8).getDevResInfo());
        pSDevSlnSys.setDevResState(((PSDevSlnSysBase)object8).getDevResState());
        pSDevSlnSys.setResReadyTime(((PSDevSlnSysBase)object8).getResReadyTime());
        object8 = new PSDynaSys();
        ((PSDynaSysBase)object8).setPSDynaSysId(string);
        boolean bl9 = pSDynaSysService.get((IEntity)object8, true);
        if (!bl9 && n > 0) {
            ((PSDynaSysBase)object8).setPSDynaSysName(pSDevSlnSys.getPSDevSlnSysName());
            ((PSDynaSysBase)object8).setLogicName(pSDevSlnSys.getLogicName());
            pSDynaSysService.create(object8, false);
        }
        hashMap = new PSSystem();
        ((PSSystemBase)((Object)hashMap)).setPSSystemId(string);
        ((PSSystemBase)((Object)hashMap)).setEnableDynaSys(n);
        ((PSSystemBase)((Object)hashMap)).setSaaSMode(n2);
        ((PSSystemBase)((Object)hashMap)).setSysVer(string2);
        pSSystemService.update(hashMap, false);
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSystemId())) {
            object8 = new PSSystem();
            ((PSSystemBase)object8).setPSSystemId(pSDevSlnSys.getPSSystemId());
            ArrayList<PSSysSFPub> arrayList22 = pSSysSFPubService.selectByPSSystem((PSSystemBase)object8);
            hashMap = new HashMap<String, String>();
            HashMap<String, String> hashMap32 = new HashMap<String, String>();
            serializable2 = new HashMap();
            for (PSSysSFPub pSSysSFPub : arrayList22) {
                if (!StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSFStyleId())) {
                    hashMap.put(pSSysSFPub.getPSSFStyleId(), "");
                }
                if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSFStyleVerId())) continue;
                hashMap32.put(pSSysSFPub.getPSSFStyleVerId(), "");
            }
            object5 = (PSAppViewServiceProxy)ServiceGlobal.getService(PSAppViewServiceProxy.class, (SessionFactory)sessionFactory);
            ArrayList<PSSysApp> arrayList3 = pSSysAppService.selectByPSSystem((PSSystemBase)object8);
            for (PSSysApp pSSysApp : arrayList3) {
                serializable2.put(pSSysApp.getPSPFStyleId(), "");
                object3 = pSSysApp.getPSAppUIStyles();
                Iterator iterator3 = ((ArrayList)object3).iterator();
                while (iterator3.hasNext()) {
                    object4 = (PSAppUIStyle)iterator3.next();
                    serializable2.put(((PSAppUIStyleBase)object4).getPSPFStyleId(), "");
                }
                SelectCond selectCond = new SelectCond();
                selectCond.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
                selectCond.setIsNotNull("PSPFSTYLEID");
                object4 = object5.select((ISelectCond)selectCond);
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    object = (PSAppView)object2.next();
                    serializable2.put(((PSAppViewBase)object).getPSPFStyleId(), "");
                }
            }
            for (String string13 : hashMap.keySet()) {
                if (StringHelper.isNullOrEmpty((String)string13)) continue;
                this.syncPSSFStyle2(string13, sessionFactory);
            }
            for (String string14 : hashMap32.keySet()) {
                if (StringHelper.isNullOrEmpty((String)string14)) continue;
                this.syncPSSFStyleVer(string14, sessionFactory);
            }
            for (String string15 : serializable2.keySet()) {
                if (StringHelper.isNullOrEmpty((String)string15)) continue;
                this.syncPSPFStyle(string15, sessionFactory);
            }
        }
        if (bl3) {
            pSSystemService.executeRaw("UPDATE T_SRFPSSYSDBDETAIL SET PUBDBVER = 0  ", null);
        }
    }

    protected void syncPSSysModelInst2(PSDevSlnSys pSDevSlnSys, boolean bl, boolean bl2) throws Exception {
        EntityBase entityBase;
        Object object;
        Iterator iterator;
        HashMap<String, PSDevCenterDBInst> hashMap;
        String string;
        ActionSessionManager.getCurrentSession().setActionParam(ACTIONPARAM_IGNORECALCRESSTATE, (Object)"");
        PSDevSlnSys pSDevSlnSys2 = null;
        if (!bl) {
            pSDevSlnSys2 = (PSDevSlnSys)this.getLast((IEntity)pSDevSlnSys);
        }
        boolean bl3 = false;
        if (pSDevSlnSys.isShareFlagDirty()) {
            bl3 = DataObject.getBoolValue((Integer)pSDevSlnSys.getShareFlag(), (boolean)false);
        } else if (pSDevSlnSys2 != null) {
            bl3 = DataObject.getBoolValue((Integer)pSDevSlnSys2.getShareFlag(), (boolean)false);
        }
        if (bl3) {
            this.syncSharePSSysModelInst(pSDevSlnSys);
            return;
        }
        int n = 0;
        if (pSDevSlnSys.isEnableDynaSysDirty()) {
            n = DataObject.getIntegerValue((Object)pSDevSlnSys.getEnableDynaSys(), (Integer)0);
        } else if (pSDevSlnSys2 != null) {
            n = DataObject.getIntegerValue((Object)pSDevSlnSys2.getEnableDynaSys(), (Integer)0);
        }
        String string2 = pSDevSlnSys.getPSDevSlnSysName();
        String string3 = pSDevSlnSys.getPSDevSlnName();
        if (StringHelper.isNullOrEmpty((String)string2) || StringHelper.isNullOrEmpty((String)string3)) {
            if (pSDevSlnSys2 != null) {
                string2 = pSDevSlnSys2.getPSDevSlnSysName();
                string3 = pSDevSlnSys2.getPSDevSlnName();
            } else {
                string2 = "\u672a\u77e5\u7cfb\u7edf\u540d\u79f0";
            }
        }
        if (StringHelper.isNullOrEmpty((String)(string = pSDevSlnSys.getPSSystemId()))) {
            string = pSDevSlnSys2 != null ? pSDevSlnSys2.getPSSystemId() : DEFAULTSYSTEMID;
        }
        PSDevSlnSysRes pSDevSlnSysRes = null;
        if (pSDevSlnSys.isPSDevSlnSysResIdDirty()) {
            pSDevSlnSysRes = pSDevSlnSys.getPSDevSlnSysRes();
        } else if (pSDevSlnSys2 != null) {
            pSDevSlnSysRes = pSDevSlnSys2.getPSDevSlnSysRes();
        }
        String string4 = null;
        string4 = StringHelper.isNullOrEmpty((String)string3) ? string2 : StringHelper.format((String)"%1$s\\%2$s", (Object)string3, (Object)string2);
        ArrayList<IEntity> arrayList = new ArrayList<IEntity>();
        PSSystem pSSystem = new PSSystem();
        Serializable serializable = pSDevSlnSys.getPSDevSln();
        pSDevSlnSys.copyTo((IDataObject)pSSystem, true);
        pSSystem.setPSDevCenterId(((PSDevSlnBase)serializable).getPSDevCenterId());
        pSSystem.setPSDevCenterName(((PSDevSlnBase)serializable).getPSDevCenterName());
        pSSystem.setPSSystemName(pSDevSlnSys.getPSDevSlnSysName());
        serializable = new HashMap();
        Object object2 = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        Object object3 = new SelectCond();
        object3.set("PSSYSTEMID", (Object)string);
        Serializable serializable2 = pSDevSlnSys.getPSDevCenterASId();
        HashMap<String, String> hashMap2 = pSDevSlnSys.getPSDevCenterASName();
        if (StringHelper.isNullOrEmpty((String)((Object)serializable2)) && pSDevSlnSysRes != null) {
            if (pSDevSlnSysRes.getResPos() == 1 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getPSDevCenterASId())) {
                serializable2 = pSDevSlnSysRes.getPSDevCenterASId();
                hashMap2 = pSDevSlnSysRes.getPSDevCenterASName();
            } else if (pSDevSlnSysRes.getResPos() == 2 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getUPSDevCenterASId())) {
                serializable2 = pSDevSlnSysRes.getUPSDevCenterASId();
                hashMap2 = pSDevSlnSysRes.getUPSDevCenterASName();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)((Object)serializable2))) {
            if (((HashMap)serializable).containsKey(serializable2)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string4, (Object)hashMap2));
            }
            ((HashMap)serializable).put(serializable2, hashMap2);
            hashMap = new PSDevCenterAS();
            ((PSDevCenterASBase)((Object)hashMap)).setPSDevCenterASId((String)((Object)serializable2));
            object2.get((IEntity)hashMap);
            if (DataObject.getBoolValue((Integer)((PSDevCenterASBase)((Object)hashMap)).getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)((Object)hashMap)).getRefObjType()) && StringHelper.compare((String)((PSDevCenterASBase)((Object)hashMap)).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)((Object)hashMap)).getRefObjId()) && StringHelper.compare((String)((PSDevCenterASBase)((Object)hashMap)).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)((PSDevCenterASBase)((Object)hashMap)).getPSDevCenterASName(), (Object)((PSDevCenterASBase)((Object)hashMap)).getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)hashMap);
            hashMap.reset();
            ((PSDevCenterASBase)((Object)hashMap)).setPSDevCenterASId((String)((Object)serializable2));
            ((PSDevCenterASBase)((Object)hashMap)).setRefFlag(1);
            ((PSDevCenterASBase)((Object)hashMap)).setRefObjType("PSDEVSLNSYS");
            ((PSDevCenterASBase)((Object)hashMap)).setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevCenterASBase)((Object)hashMap)).setRefObjName(string4);
            ((PSCoreSysServiceBaseBase)((Object)object2)).update(hashMap);
        }
        hashMap = pSDevSlnSys.getPSDevCenterASId2();
        Object object4 = pSDevSlnSys.getPSDevCenterASName2();
        if (StringHelper.isNullOrEmpty((String)((Object)hashMap)) && pSDevSlnSysRes != null) {
            if (pSDevSlnSysRes.getResPos() == 1 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getPSDevCenterASId2())) {
                hashMap = pSDevSlnSysRes.getPSDevCenterASId2();
                object4 = pSDevSlnSysRes.getPSDevCenterASName2();
            } else if (pSDevSlnSysRes.getResPos() == 2 && !StringHelper.isNullOrEmpty((String)pSDevSlnSysRes.getUPSDevCenterASId2())) {
                hashMap = pSDevSlnSysRes.getUPSDevCenterASId2();
                object4 = pSDevSlnSysRes.getUPSDevCenterASName2();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)((Object)hashMap))) {
            if (((HashMap)serializable).containsKey(hashMap)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string4, (Object)object4));
            }
            ((HashMap)serializable).put(hashMap, object4);
            iterator = new PSDevCenterAS();
            ((PSDevCenterASBase)((Object)iterator)).setPSDevCenterASId((String)((Object)hashMap));
            object2.get((IEntity)iterator);
            if (DataObject.getBoolValue((Integer)((PSDevCenterASBase)((Object)iterator)).getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)((Object)iterator)).getRefObjType()) && StringHelper.compare((String)((PSDevCenterASBase)((Object)iterator)).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)((Object)iterator)).getRefObjId()) && StringHelper.compare((String)((PSDevCenterASBase)((Object)iterator)).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)((PSDevCenterASBase)((Object)iterator)).getPSDevCenterASName(), (Object)((PSDevCenterASBase)((Object)iterator)).getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)iterator);
            iterator.reset();
            ((PSDevCenterASBase)((Object)iterator)).setPSDevCenterASId((String)((Object)hashMap));
            ((PSDevCenterASBase)((Object)iterator)).setRefFlag(1);
            ((PSDevCenterASBase)((Object)iterator)).setRefObjType("PSDEVSLNSYS");
            ((PSDevCenterASBase)((Object)iterator)).setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevCenterASBase)((Object)iterator)).setRefObjName(string4);
            ((PSCoreSysServiceBaseBase)((Object)object2)).update(iterator);
        }
        iterator = pSDevSlnSys.getPSDevCenterAS3Id();
        Object object52 = pSDevSlnSys.getPSDevCenterAS3Name();
        if (!StringHelper.isNullOrEmpty((String)((Object)iterator))) {
            if (((HashMap)serializable).containsKey(iterator)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string4, (Object)object52));
            }
            ((HashMap)serializable).put(iterator, object52);
            object = new PSDevCenterAS();
            ((PSDevCenterASBase)object).setPSDevCenterASId((String)((Object)iterator));
            object2.get((IEntity)object);
            if (DataObject.getBoolValue((Integer)((PSDevCenterASBase)object).getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)object).getRefObjType()) && StringHelper.compare((String)((PSDevCenterASBase)object).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)((PSDevCenterASBase)object).getRefObjId()) && StringHelper.compare((String)((PSDevCenterASBase)object).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)((PSDevCenterASBase)object).getPSDevCenterASName(), (Object)((PSDevCenterASBase)object).getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)object);
            object.reset();
            ((PSDevCenterASBase)object).setPSDevCenterASId((String)((Object)iterator));
            ((PSDevCenterASBase)object).setRefFlag(1);
            ((PSDevCenterASBase)object).setRefObjType("PSDEVSLNSYS");
            ((PSDevCenterASBase)object).setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevCenterASBase)object).setRefObjName(string4);
            ((PSCoreSysServiceBaseBase)((Object)object2)).update(object);
        }
        object = pSDevSlnSys.getPSDevCenterAS4Id();
        Object object6 = pSDevSlnSys.getPSDevCenterAS4Name();
        if (!StringHelper.isNullOrEmpty((String)object)) {
            if (((HashMap)serializable).containsKey(object)) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u591a\u6b21\u5f15\u7528\u5e94\u7528\u5bb9\u5668[%2$s]", (Object)string4, (Object)object6));
            }
            ((HashMap)serializable).put(object, object6);
            entityBase = new PSDevCenterAS();
            entityBase.setPSDevCenterASId((String)object);
            object2.get((IEntity)entityBase);
            if (DataObject.getBoolValue((Integer)entityBase.getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)entityBase.getRefObjType()) && StringHelper.compare((String)entityBase.getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)entityBase.getRefObjId()) && StringHelper.compare((String)entityBase.getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u5bb9\u5668[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)entityBase.getPSDevCenterASName(), (Object)entityBase.getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)entityBase);
            entityBase.reset();
            entityBase.setPSDevCenterASId((String)object);
            entityBase.setRefFlag(1);
            entityBase.setRefObjType("PSDEVSLNSYS");
            entityBase.setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            entityBase.setRefObjName(string4);
            ((PSCoreSysServiceBaseBase)((Object)object2)).update(entityBase);
        }
        object2 = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        object3 = (PSDCDBInstRefService)ServiceGlobal.getService(PSDCDBInstRefService.class, (SessionFactory)this.getSessionFactory());
        serializable2 = new ArrayList();
        hashMap2 = new ArrayList();
        hashMap = new HashMap<String, PSDevCenterDBInst>();
        object4 = new HashMap();
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableMySQL5(), (boolean)false)) {
            if (pSDevSlnSys.getMySQLPSDCDBInst() != null) {
                hashMap.put("MYSQL5", pSDevSlnSys.getMySQLPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getMySQLPSDCDBInst() != null) {
                    hashMap.put("MYSQL5", pSDevSlnSysRes.getMySQLPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUMySQLPSDCDBInst() != null) {
                    hashMap.put("MYSQL5", pSDevSlnSysRes.getUMySQLPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableDB2(), (boolean)false)) {
            if (pSDevSlnSys.getDB2PSDCDBInst() != null) {
                hashMap.put("DB2", pSDevSlnSys.getDB2PSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getDB2PSDCDBInst() != null) {
                    hashMap.put("DB2", pSDevSlnSysRes.getDB2PSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUDB2PSDCDBInst() != null) {
                    hashMap.put("DB2", pSDevSlnSysRes.getUDB2PSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableOracle(), (boolean)false)) {
            if (pSDevSlnSys.getOraPSDCDBInst() != null) {
                hashMap.put("ORACLE", pSDevSlnSys.getOraPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getOraPSDCDBInst() != null) {
                    hashMap.put("ORACLE", pSDevSlnSysRes.getOraPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUOraPSDCDBInst() != null) {
                    hashMap.put("ORACLE", pSDevSlnSysRes.getUOraPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableSqlServer(), (boolean)false)) {
            if (pSDevSlnSys.getMSSQLPSDCDBInst() != null) {
                hashMap.put("SQLSERVER", pSDevSlnSys.getMSSQLPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getMSSqlPSDCDBInst() != null) {
                    hashMap.put("SQLSERVER", pSDevSlnSysRes.getMSSqlPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUMSSqlPSDCDBInst() != null) {
                    hashMap.put("SQLSERVER", pSDevSlnSysRes.getUMSSqlPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnablePGSQL(), (boolean)false)) {
            if (pSDevSlnSys.getPGSQLPSDCDBInst() != null) {
                hashMap.put("POSTGRESQL", pSDevSlnSys.getPGSQLPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getPGSQLPSDCDBInst() != null) {
                    hashMap.put("POSTGRESQL", pSDevSlnSysRes.getPGSQLPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUPGSQLPSDCDBInst() != null) {
                    hashMap.put("POSTGRESQL", pSDevSlnSysRes.getUPGSQLPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnablePPAS(), (boolean)false)) {
            if (pSDevSlnSys.getPPASPSDCDBInst() != null) {
                hashMap.put("PPAS", pSDevSlnSys.getPPASPSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getPPASPSDCDBInst() != null) {
                    hashMap.put("PPAS", pSDevSlnSysRes.getPPASPSDCDBInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUPPASPSDCDBInst() != null) {
                    hashMap.put("PPAS", pSDevSlnSysRes.getUPPASPSDCDBInst());
                }
            }
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableSQLite(), (boolean)false)) {
            hashMap.put("SQLITE", null);
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableDM(), (boolean)false)) {
            hashMap.put("DM", null);
        }
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableHANA(), (boolean)false)) {
            hashMap.put("HANA", null);
        }
        iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            object52 = (PSSystemDBCfg)iterator.next();
            ((HashMap)object4).put(((PSSystemDBCfgBase)object52).getPSDevCenterDBInstId(), "");
        }
        for (Object object52 : hashMap.keySet()) {
            object = (PSDevCenterDBInst)hashMap.get(object52);
            if (object != null) {
                if (!StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)object).getPSDevCenterASId()) && !((HashMap)serializable).containsKey(((PSDevCenterDBInstBase)object).getPSDevCenterASId())) {
                    throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5fc5\u987b\u5728\u5e94\u7528\u5bb9\u5668[%2$s]\u4e0b\u4f7f\u7528", (Object)((PSDevCenterDBInstBase)object).getPSDevCenterDBInstName(), (Object)((PSDevCenterDBInstBase)object).getPSDevCenterASName()));
                }
                this.addToPSResList(arrayList, (IEntity)object);
            }
            if (object == null) continue;
            object6 = ((PSDevCenterDBInstBase)object).getPSDevCenterDBInstName();
            if (StringHelper.isNullOrEmpty((String)object6)) {
                object6 = "\u6570\u636e\u5e93\u5b9e\u4f8b\u540d\u79f0";
            }
            ((HashMap)object4).put(((PSDevCenterDBInstBase)object).getPSDevCenterDBInstId(), object6);
        }
        for (Object object52 : ((HashMap)object4).keySet()) {
            boolean bl4;
            object = (String)((HashMap)object4).get(object52);
            object6 = new PSDevCenterDBInst();
            ((PSDevCenterDBInstBase)object6).setPSDevCenterDBInstId((String)object52);
            entityBase = new PSDCDBInstRef();
            entityBase.setRefObjType("PSDEVSLNSYS");
            entityBase.setPSDevCenterDBInstId((String)object52);
            entityBase.setRefObjId(pSDevSlnSys.getPSDevSlnSysId());
            object3.fillEntityKeyValue((IEntity)entityBase);
            boolean bl5 = bl4 = ((PSCoreSysServiceBase)object3).checkKey(entityBase) == 0;
            if (!StringHelper.isNullOrEmpty((String)object)) {
                if (!bl4) continue;
                PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
                entityBase.setPSDevCenterId(pSDevSln.getPSDevCenterId());
                entityBase.setPSDevCenterName(pSDevSln.getPSDevCenterName());
                entityBase.setPSDevCenterDBInstName((String)object);
                entityBase.setRefObjName(string2);
                entityBase.setPSDCDBInstRefName(string4);
                ((PSCoreSysServiceBase)object3).create(entityBase, false);
                continue;
            }
            if (bl4) continue;
            try {
                object3.remove((IEntity)entityBase);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5220\u9664\u539f\u6709\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
        }
        object2 = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
        object3 = new ArrayList();
        serializable2 = new HashMap<String, PSDCBDInst>();
        hashMap2 = new HashMap<String, String>();
        if (DataObject.getBoolValue((Integer)pSDevSlnSys.getEnableHBase(), (boolean)false)) {
            if (pSDevSlnSys.getHBasePSDCDBInst() != null) {
                ((HashMap)serializable2).put("HBASE", pSDevSlnSys.getHBasePSDCDBInst());
            } else if (pSDevSlnSysRes != null) {
                if (pSDevSlnSysRes.getResPos() == 1 && pSDevSlnSysRes.getHBasePSDCBDInst() != null) {
                    ((HashMap)serializable2).put("HBASE", pSDevSlnSysRes.getHBasePSDCBDInst());
                } else if (pSDevSlnSysRes.getResPos() == 2 && pSDevSlnSysRes.getUHBasePSDCBDInst() != null) {
                    ((HashMap)serializable2).put("HBASE", pSDevSlnSysRes.getUHBasePSDCBDInst());
                }
            }
        }
        boolean bl6 = ((HashMap)serializable2).size() > 0;
        object4 = ((ArrayList)object3).iterator();
        while (object4.hasNext()) {
            iterator = (PSSysBDInstCfg)object4.next();
            hashMap2.put(((PSSysBDInstCfgBase)((Object)iterator)).getPSDCBDInstId(), "");
        }
        object4 = "";
        for (Object object52 : ((HashMap)serializable2).keySet()) {
            object = (PSDCBDInst)((HashMap)serializable2).get(object52);
            ((PSDCBDInstBase)object).setPSBDDevInstId(null);
            ((PSDCBDInstBase)object).setPSBDDevInstName(null);
            hashMap2.put(((PSDCBDInstBase)object).getPSDCBDInstId(), "");
            if (!StringHelper.isNullOrEmpty((String)object4)) {
                object4 = (String)object4 + ";";
            }
            object4 = (String)object4 + (String)object52;
        }
        for (Object object52 : hashMap2.keySet()) {
            object = new PSDCBDInst();
            ((PSDCBDInstBase)object).setPSDCBDInstId((String)object52);
            if (!object2.get((IEntity)object, true)) continue;
            ((PSDCBDInstService)object2).calcRefInfo((PSDCBDInst)object);
        }
        object2 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        boolean bl7 = true;
        if (pSDevSlnSys2 != null && !StringHelper.isNullOrEmpty((String)pSDevSlnSys2.getPSDevCenterSVNId())) {
            if (StringHelper.compare((String)pSDevSlnSys2.getPSDevCenterSVNId(), (String)pSDevSlnSys.getPSDevCenterSVNId(), (boolean)false) != 0) {
                serializable2 = new PSDevCenterSVN();
                ((PSDevCenterSVNBase)serializable2).setPSDevCenterSVNId(pSDevSlnSys2.getPSDevCenterSVNId());
                object2.get((IEntity)serializable2);
                if ((StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)serializable2).getRefObjType()) || StringHelper.compare((String)((PSDevCenterSVNBase)serializable2).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) == 0) && (StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)serializable2).getRefObjId()) || StringHelper.compare((String)((PSDevCenterSVNBase)serializable2).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) == 0)) {
                    ((PSDevCenterSVNBase)serializable2).setRefFlag(0);
                    ((PSDevCenterSVNBase)serializable2).setRefObjId(null);
                    ((PSDevCenterSVNBase)serializable2).setRefObjName(null);
                    ((PSDevCenterSVNBase)serializable2).setRefObjType(null);
                    ((PSCoreSysServiceBaseBase)((Object)object2)).update(serializable2);
                }
            } else {
                bl7 = false;
            }
        }
        if (bl7 && !StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevCenterSVNId())) {
            serializable2 = new PSDevCenterSVN();
            ((PSDevCenterSVNBase)serializable2).setPSDevCenterSVNId(pSDevSlnSys.getPSDevCenterSVNId());
            object2.get((IEntity)serializable2);
            if (DataObject.getBoolValue((Integer)((PSDevCenterSVNBase)serializable2).getRefFlag(), (boolean)false) && (!StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)serializable2).getRefObjType()) && StringHelper.compare((String)((PSDevCenterSVNBase)serializable2).getRefObjType(), (String)"PSDEVSLNSYS", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)((PSDevCenterSVNBase)serializable2).getRefObjId()) && StringHelper.compare((String)((PSDevCenterSVNBase)serializable2).getRefObjId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)false) != 0)) {
                throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u7248\u672c\u5e93[%1$s]\u5df2\u7ecf\u88ab[%2$s]\u4f7f\u7528\uff0c\u65e0\u6cd5\u518d\u6b21\u4f7f\u7528", (Object)((PSDevCenterSVNBase)serializable2).getPSDevCenterSVNName(), (Object)((PSDevCenterSVNBase)serializable2).getRefObjName()));
            }
            this.addToPSResList(arrayList, (IEntity)serializable2);
        }
        object2 = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
        bl7 = true;
        if (pSDevSlnSys2 != null && !StringHelper.isNullOrEmpty((String)pSDevSlnSys2.getSFPSSubSysId()) && StringHelper.compare((String)pSDevSlnSys2.getSFPSSubSysId(), (String)pSDevSlnSys.getSFPSSubSysId(), (boolean)false) == 0) {
            bl7 = false;
        }
        if (bl7 && !StringHelper.isNullOrEmpty((String)pSDevSlnSys.getSFPSSubSysId())) {
            serializable2 = new PSSubSys();
            ((PSSubSysBase)serializable2).setPSSubSysId(pSDevSlnSys.getSFPSSubSysId());
            object2.get((IEntity)serializable2);
        }
        object2 = new PSDevSlnSys();
        ((PSDevSlnSysBase)object2).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        this.calcPSDevSlnSysResState((PSDevSlnSys)object2, arrayList);
        this.sysUpdate(object2, false);
        pSDevSlnSys.setDevResInfo(((PSDevSlnSysBase)object2).getDevResInfo());
        pSDevSlnSys.setDevResState(((PSDevSlnSysBase)object2).getDevResState());
        pSDevSlnSys.setResReadyTime(((PSDevSlnSysBase)object2).getResReadyTime());
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

    @Override
    protected void internalRemove(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && this.doMovePSDevSlnSys(pSDevSlnSys)) {
            return;
        }
        super.internalRemove(pSDevSlnSys);
    }

    protected boolean doMovePSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        Object object;
        Object object2;
        if (StringHelper.isNullOrEmpty((String)PSDevSlnSysService.getRecyclePSDCId())) {
            return false;
        }
        PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getLast((IEntity)pSDevSlnSys);
        PSDevSln pSDevSln = pSDevSlnSys2.getPSDevSln();
        PSDevSln pSDevSln2 = new PSDevSln();
        pSDevSln2.setPSDevSlnName(StringHelper.format((String)"S%1$s", (Object)KeyValueHelper.genUniqueId((String)pSDevSlnSys.getPSDevSlnSysId(), (String)Integer.toString(random.nextInt(99999999)))));
        pSDevSln2.setCodeName(pSDevSln2.getPSDevSlnName());
        pSDevSln2.setPSDevCenterId(PSDevSlnSysService.getRecyclePSDCId());
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (pSDevSln != null) {
            stringBuilderEx.append("PSDEVCENTERID=%1$s\r\n", (Object)pSDevSln.getPSDevCenterId());
            stringBuilderEx.append("PSDEVCENTERNAME%1$s\r\n", (Object)pSDevSln.getPSDevCenterName());
            stringBuilderEx.append("PSDEVSLNID=%1$s\r\n", (Object)pSDevSln.getPSDevSlnId());
            stringBuilderEx.append("PSDEVSLNNAME=%1$s\r\n", (Object)pSDevSln.getPSDevSlnName());
        }
        stringBuilderEx.append("PSDEVSLNSYSID=%1$s\r\n", (Object)pSDevSlnSys2.getPSDevSlnSysId());
        stringBuilderEx.append("PSDEVSLNSYSNAME=%1$s\r\n", (Object)pSDevSlnSys2.getPSDevSlnSysName());
        pSDevSln2.setMemo(stringBuilderEx.toString());
        try {
            object2 = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
            ((PSCoreSysServiceBaseBase)((Object)object2)).create(pSDevSln2);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u56de\u6536\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u56de\u6536\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys2.getPSSysModelInstId())) {
            try {
                object2 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                object = new PSSysModelInst();
                ((PSSysModelInstBase)object).setPSSysModelInstId(pSDevSlnSys2.getPSSysModelInstId());
                ((PSSysModelInstBase)object).setPSDevCenterId(pSDevSln2.getPSDevCenterId());
                ((PSSysModelInstBase)object).setPSDevCenterName(pSDevSln2.getPSDevCenterName());
                ((PSCoreSysServiceBaseBase)((Object)object2)).sysUpdate(object, false);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u6a21\u578b\u4ed3\u5e93\u5f52\u5c5e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u6a21\u578b\u4ed3\u5e93\u5f52\u5c5e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        try {
            object2 = new PSDevSlnSys();
            ((PSDevSlnSysBase)object2).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevSlnSysBase)object2).setPSDevSlnId(pSDevSln2.getPSDevSlnId());
            ((PSDevSlnSysBase)object2).setPSDevSlnName(pSDevSln2.getPSDevSlnName());
            ((PSDevSlnSysBase)object2).setPSDevCenterId(pSDevSln2.getPSDevCenterId());
            ((PSDevSlnSysBase)object2).setPSDevCenterName(pSDevSln2.getPSDevCenterName());
            this.sysUpdate(object2, false);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u5f52\u5c5e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u5f52\u5c5e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        object2 = null;
        object = null;
        if (PSDevSlnSysService.isEnableGitLabPlugin()) {
            try {
                object2 = PSDevSlnSysService.getPSGitLabPlugin().moveCodeProjectByPSDevSlnSys(pSDevSlnSys2, pSDevSln2);
                object = PSDevSlnSysService.getPSGitLabPlugin().moveModelProjectByPSDevSlnSys(pSDevSlnSys2, pSDevSln2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u8f6c\u79fb\u4ee3\u7801\u4ed3\u5e93\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u8f6c\u79fb\u4ee3\u7801\u4ed3\u5e93\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        try {
            if (pSDevSlnSys2.getPSDevCenterSVN() != null) {
                PSGitLabHelper.movePSDevCenterSVN(pSDevSlnSys2.getPSDevCenterSVN(), (Project)object2, pSDevSln2);
            }
            if (pSDevSlnSys2.getModelPSDevCenterSVN() != null) {
                PSGitLabHelper.movePSDevCenterSVN(pSDevSlnSys2.getModelPSDevCenterSVN(), (Project)object, pSDevSln2);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u8f6c\u79fb\u5e73\u53f0\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u8f6c\u79fb\u5e73\u53f0\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        return true;
    }

    @Override
    protected void onAfterRemove(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getLast((IEntity)pSDevSlnSys);
            PSDevCenterHelper.updatetPSDCResRep(pSDevSlnSys2.getPSDevSln().getPSDevCenter(), "DEVSYSCNT");
        }
        super.onAfterRemove(pSDevSlnSys);
    }

    public void resetLoadTimeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final String string = pSTaskServer.getPSTaskServerId();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                String string2 = "UPDATE T_SRFPSDEVSLNSYS SET LOADTIME = NULL WHERE PSTASKSERVERID = ?";
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(string);
                PSDevSlnSysService.this.getDAO().executeRawSql(null, string2, sqlParamList);
            }
        });
    }

    @Override
    protected void onSwitchPSRes(PSDevSlnSys pSDevSlnSys) throws Exception {
        this.get((IEntity)pSDevSlnSys);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevSlnSysResId())) {
            return;
        }
        PSDevSlnSysRes pSDevSlnSysRes = new PSDevSlnSysRes();
        pSDevSlnSysRes.setPSDevSlnSysResId(pSDevSlnSys.getPSDevSlnSysResId());
        PSDevSlnSysResService pSDevSlnSysResService = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysResService.get((IEntity)pSDevSlnSysRes);
        if (pSDevSlnSysRes.getResPos() == 1) {
            return;
        }
        pSDevSlnSysRes.reset();
        pSDevSlnSysRes.setPSDevSlnSysResId(pSDevSlnSys.getPSDevSlnSysResId());
        pSDevSlnSysRes.setResPos(1);
        pSDevSlnSysResService.update(pSDevSlnSysRes);
        this.syncPSSysModelInst(pSDevSlnSys, false, true);
    }

    @Override
    protected void onSwitchUserRes(PSDevSlnSys pSDevSlnSys) throws Exception {
        this.get((IEntity)pSDevSlnSys);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevSlnSysResId())) {
            return;
        }
        PSDevSlnSysRes pSDevSlnSysRes = new PSDevSlnSysRes();
        pSDevSlnSysRes.setPSDevSlnSysResId(pSDevSlnSys.getPSDevSlnSysResId());
        PSDevSlnSysResService pSDevSlnSysResService = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysResService.get((IEntity)pSDevSlnSysRes);
        if (pSDevSlnSysRes.getResPos() == 2) {
            return;
        }
        pSDevSlnSysRes.reset();
        pSDevSlnSysRes.setPSDevSlnSysResId(pSDevSlnSys.getPSDevSlnSysResId());
        pSDevSlnSysRes.setResPos(2);
        pSDevSlnSysResService.update(pSDevSlnSysRes);
        this.syncPSSysModelInst(pSDevSlnSys, false, true);
    }

    @Override
    protected void onAdminVisit(PSDevSlnSys pSDevSlnSys) throws Exception {
        super.onAdminVisit(pSDevSlnSys);
    }

    public PSDevSlnSysKey createAdminKey(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSDevSlnSysService.this.onCreateAdminKey(pSDevSlnSys2));
            }
        });
        return (PSDevSlnSysKey)callResult.getUserObject();
    }

    protected PSDevSlnSysKey onCreateAdminKey(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ADMINVISIT]");
    }

    @Override
    public void onPSDCASChanged(PSDevCenterAS pSDevCenterAS, PSDevCenterAS pSDevCenterAS2) throws Exception {
        if (ActionSessionManager.getCurrentSession().containsActionParam(ACTIONPARAM_IGNORECALCRESSTATE)) {
            return;
        }
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(pSDevCenterAS.getRefObjId());
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevSlnSysId()) && pSDevCenterAS2 != null) {
            pSDevSlnSys.setPSDevSlnSysId(pSDevCenterAS2.getRefObjId());
        }
        this.update(pSDevSlnSys);
    }

    @Override
    public void onPSDCDBInstChanged(PSDCDBInstRef pSDCDBInstRef, PSDevCenterDBInst pSDevCenterDBInst, PSDevCenterDBInst pSDevCenterDBInst2) throws Exception {
        if (ActionSessionManager.getCurrentSession().containsActionParam(ACTIONPARAM_IGNORECALCRESSTATE)) {
            return;
        }
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        String string = pSDCDBInstRef.getRefObjId();
        pSDevSlnSys.setPSDevSlnSysId(string);
        this.update(pSDevSlnSys);
    }

    @Override
    public void onPSDCSVNChanged(PSDevCenterSVN pSDevCenterSVN, PSDevCenterSVN pSDevCenterSVN2) throws Exception {
        if (ActionSessionManager.getCurrentSession().containsActionParam(ACTIONPARAM_IGNORECALCRESSTATE)) {
            return;
        }
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(pSDevCenterSVN.getRefObjId());
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevSlnSysId()) && pSDevCenterSVN2 != null) {
            pSDevSlnSys.setPSDevSlnSysId(pSDevCenterSVN2.getRefObjId());
        }
        this.update(pSDevSlnSys);
    }

    protected void addToPSResList(ArrayList<IEntity> arrayList, IEntity iEntity) throws Exception {
        IEntity iEntity2 = (IEntity)iEntity.getClass().newInstance();
        iEntity.copyTo((IDataObject)iEntity2, false);
        arrayList.add(iEntity2);
    }

    protected void calcPSDevSlnSysResState(PSDevSlnSys pSDevSlnSys, ArrayList<IEntity> arrayList) throws Exception {
        int n = 11;
        ICodeList iCodeList = CodeListGlobal.getCodeList(DevCenterResStateCodeListModel.class);
        Timestamp timestamp = null;
        boolean bl = true;
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        for (IEntity iEntity : arrayList) {
            EntityBase entityBase;
            int n2 = DataObject.getIntegerValue((IDataObject)iEntity, (String)"RESSTATE", (int)20);
            if (bl) {
                n = n2;
            } else if (psResStateLevelMap.get(n2) > psResStateLevelMap.get(n)) {
                n = n2;
            }
            String string = iCodeList.getCodeListText(Integer.toString(n2), true);
            Timestamp timestamp2 = DataObject.getTimestampValue((IDataObject)iEntity, (String)"RESREADYTIME", null);
            if (timestamp2 != null) {
                if (timestamp == null) {
                    timestamp = timestamp2;
                } else if (timestamp2.getTime() > timestamp.getTime()) {
                    timestamp = timestamp2;
                }
            }
            if (bl) {
                bl = false;
            } else {
                stringBuilderEx.append("\r\n");
            }
            if (iEntity instanceof PSDevCenterAS) {
                entityBase = (PSDevCenterAS)iEntity;
                stringBuilderEx.append("\u5e94\u7528\u5bb9\u5668[%1$s] %2$s", (Object)entityBase.getPSDevCenterASName(), (Object)string);
            } else if (iEntity instanceof PSDevCenterDBInst) {
                entityBase = (PSDevCenterDBInst)iEntity;
                stringBuilderEx.append("\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s] %2$s", (Object)entityBase.getPSDevCenterDBInstName(), (Object)string);
            } else {
                if (!(iEntity instanceof PSDevCenterSVN)) continue;
                entityBase = (PSDevCenterSVN)iEntity;
                stringBuilderEx.append("\u4ee3\u7801\u4ed3\u5e93[%1$s] %2$s", (Object)entityBase.getPSDevCenterSVNName(), (Object)string);
            }
            if (timestamp2 == null) continue;
            stringBuilderEx.append(",\u8d44\u6e90\u5c31\u7eea\u65f6\u95f4[%1$s]", (Object)DateHelper.toDateTimeString((Date)timestamp2));
        }
        if (n != 42) {
            timestamp = null;
        }
        pSDevSlnSys.setDevResInfo(stringBuilderEx.toString());
        pSDevSlnSys.setDevResState(n);
        pSDevSlnSys.setResReadyTime(timestamp);
    }

    public void remove(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysService.this.doRealRemove(pSDevSlnSys2);
            }
        }, true);
    }

    protected void doRealRemove(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            this.get((IEntity)pSDevSlnSys);
            if (StringHelper.isNullOrEmpty((String)PSDevSlnSysService.getRecyclePSDCId())) {
                if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 42) {
                    throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u7981\u6b62\u5220\u9664");
                }
            } else {
                int n = DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30);
                switch (n) {
                    case 20: 
                    case 21: 
                    case 30: 
                    case 31: {
                        throw new Exception(StringHelper.format((String)"\u72b6\u6001\u4e3a[\u521b\u5efa\u4e2d]\u3001[\u6062\u590d\u4e2d]\u3001[\u6b63\u5e38]\u3001[\u8fd0\u7ef4\u4e2d]\u7684\u5f00\u53d1\u7cfb\u7edf\u7981\u6b62\u5220\u9664"));
                    }
                }
            }
            if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDCWorkspaceId())) {
                throw new Exception(StringHelper.format((String)"\u5df2\u7ecf\u7ed1\u5b9a\u751f\u4ea7\u7ebf\u7684\u5f00\u53d1\u7cfb\u7edf\u7981\u6b62\u5220\u9664"));
            }
            pSDevSlnSys.setPSDevSlnSysResId(null);
            pSDevSlnSys.setPSDevSlnSysResName(null);
            pSDevSlnSys.setPSDCSysLicId(null);
            pSDevSlnSys.setEnableMySQL5(0);
            pSDevSlnSys.setMySQLPSDCDBInstId(null);
            pSDevSlnSys.setEnableDB2(0);
            pSDevSlnSys.setDB2PSDCDBInstId(null);
            pSDevSlnSys.setEnableHBase(0);
            pSDevSlnSys.setHBasePSDCBDInstId(null);
            pSDevSlnSys.setEnableOracle(0);
            pSDevSlnSys.setOraPSDCDBInstId(null);
            pSDevSlnSys.setEnablePGSQL(0);
            pSDevSlnSys.setPGSQLPSDCDBInstId(null);
            pSDevSlnSys.setEnablePPAS(0);
            pSDevSlnSys.setPPASPSDCDBInstId(null);
            pSDevSlnSys.setEnableSqlServer(0);
            pSDevSlnSys.setMSSQLPSDCDBInstId(null);
            pSDevSlnSys.setEnableSQLite(0);
            pSDevSlnSys.setEnableDM(0);
            pSDevSlnSys.setEnableHANA(0);
            pSDevSlnSys.setPSDevCenterASId(null);
            pSDevSlnSys.setPSDevCenterASId2(null);
            pSDevSlnSys.setPSDevCenterAS3Id(null);
            pSDevSlnSys.setPSDevCenterAS4Id(null);
            pSDevSlnSys.setPSDevCenterId(null);
            pSDevSlnSys.setPSDevCenterTSId(null);
            pSDevSlnSys.setPSTaskServerId(null);
            pSDevSlnSys.setPSTaskServerName(null);
            pSDevSlnSys.setPSDCRobotId(null);
            pSDevSlnSys.setPSDCRobotName(null);
            pSDevSlnSys.set(PARAM_IGNOREPSDEVCENTERTS, 1);
            this.update(pSDevSlnSys, true);
            SelectContext selectContext = new SelectContext();
            selectContext.addSelectField("PSDEVSLNSYSBAKID");
            selectContext.set("PSDEVSLNSYSID", (Object)pSDevSlnSys.getPSDevSlnSysId());
            selectContext.set("OFFLINEFLAG", (Object)1);
            PSDevSlnSysBakService pSDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
            ArrayList arrayList = pSDevSlnSysBakService.select((ISelectCond)selectContext);
            for (PSDevSlnSysBak pSDevSlnSysBak : arrayList) {
                pSDevSlnSysBak.setOfflineFlag(0);
                pSDevSlnSysBakService.sysUpdate(pSDevSlnSysBak, false);
            }
        }
        super.remove((IEntity)pSDevSlnSys);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSys pSDevSlnSys) throws Exception {
        super.onBeforeRemove(pSDevSlnSys);
    }

    @Override
    protected void onRebindSystem(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            this.get((IEntity)pSDevSlnSys);
            this.syncPSSysModelInst(pSDevSlnSys, true, false, false);
        }
    }

    public void movePSDevSlnSys(PSDevSlnSys pSDevSlnSys, PSDevCenter pSDevCenter, PSDevSln pSDevSln) throws Exception {
        if (!this.get((IEntity)pSDevSlnSys, true)) {
            return;
        }
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        final PSDevSln pSDevSln2 = pSDevSln;
        ServiceWorkHelper.getInstance((IWebContext)this.getWebContext()).execute(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase pSCoreSysServiceBase;
                PSDevSln pSDevSln = pSDevSlnSys2.getPSDevSln();
                PSDCSysLic pSDCSysLic = pSDevSlnSys2.getPSDCSysLic();
                pSDevSlnSys2.setPSDevSlnSysResId(null);
                pSDevSlnSys2.setPSDevSlnSysResName(null);
                pSDevSlnSys2.setPSDevCenterSVNId(null);
                pSDevSlnSys2.setROPSDevCenterSvnId(null);
                pSDevSlnSys2.setModelPSDevCenterSVNId(null);
                pSDevSlnSys2.setPSDCSysLicId(null);
                pSDevSlnSys2.setEnableMySQL5(0);
                pSDevSlnSys2.setMySQLPSDCDBInstId(null);
                pSDevSlnSys2.setEnableDB2(0);
                pSDevSlnSys2.setDB2PSDCDBInstId(null);
                pSDevSlnSys2.setEnableHBase(0);
                pSDevSlnSys2.setHBasePSDCBDInstId(null);
                pSDevSlnSys2.setEnableOracle(0);
                pSDevSlnSys2.setOraPSDCDBInstId(null);
                pSDevSlnSys2.setEnablePGSQL(0);
                pSDevSlnSys2.setPGSQLPSDCDBInstId(null);
                pSDevSlnSys2.setEnablePPAS(0);
                pSDevSlnSys2.setPPASPSDCDBInstId(null);
                pSDevSlnSys2.setEnableSqlServer(0);
                pSDevSlnSys2.setMSSQLPSDCDBInstId(null);
                pSDevSlnSys2.setEnableSQLite(0);
                pSDevSlnSys2.setEnableDM(0);
                pSDevSlnSys2.setEnableHANA(0);
                pSDevSlnSys2.setPSDevCenterASId(null);
                pSDevSlnSys2.setPSDevCenterASId2(null);
                pSDevSlnSys2.setPSDevCenterAS3Id(null);
                pSDevSlnSys2.setPSDevCenterAS4Id(null);
                pSDevSlnSys2.setPSDevCenterId(null);
                pSDevSlnSys2.setPSDevCenterTSId(null);
                pSDevSlnSys2.setPSTaskServerId(null);
                pSDevSlnSys2.setPSTaskServerName(null);
                pSDevSlnSys2.setPSDCRobotId(null);
                pSDevSlnSys2.setPSDCRobotName(null);
                if (pSDevSln2 != null) {
                    pSDevSlnSys2.setPSDevSlnId(pSDevSln2.getPSDevSlnId());
                    pSDevSlnSys2.setPSDevSlnName(pSDevSln2.getPSDevSlnName());
                }
                pSDevSlnSys2.set(PSDevSlnSysService.PARAM_IGNOREPSDEVCENTERTS, 1);
                PSDevSlnSysService.this.update(pSDevSlnSys2, false);
                if (pSDevSln2 == null) {
                    pSCoreSysServiceBase = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)PSDevSlnSysService.this.getSessionFactory());
                    pSDevSln.setMemo(StringHelper.format((String)"\u6765\u6e90[%1$s][%2$s]", (Object)pSDevSln.getPSDevCenterName(), (Object)pSDevSln.getPSDevSlnName()));
                    pSDevSln.setPSDevSlnName(pSDevSln.getPSDevSlnName() + StringHelper.format((String)"_%1$s", (Object)new Random().nextInt(9999999)));
                    pSDevSln.setCodeName(pSDevSln.getCodeName() + StringHelper.format((String)"_%1$s", (Object)new Random().nextInt(9999999)));
                    pSDevSln.setPSDevCenterId(pSDevCenter2.getPSDevCenterId());
                    pSDevSln.setPSDevCenterName(pSDevCenter2.getPSDevCenterName());
                    pSCoreSysServiceBase.sysUpdate(pSDevSln, false);
                }
                if (pSDCSysLic != null) {
                    pSCoreSysServiceBase = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, (SessionFactory)PSDevSlnSysService.this.getSessionFactory());
                    pSCoreSysServiceBase.mergeChild(null, null, pSDCSysLic.getPSDCSysLicId());
                }
            }
        });
    }

    @Override
    protected void onBindSysModel(PSDevSlnSys pSDevSlnSys) throws Exception {
        this.get((IEntity)pSDevSlnSys);
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)30) != 20) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u7ed1\u5b9a\u7cfb\u7edf\u6a21\u578b", (Object)pSDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(pSDevSlnSys.getDevSysState().toString()).getText()));
        }
        this.fillPSSysModelInst(pSDevSlnSys);
        pSDevSlnSys.setDevSysState(30);
        this.internalUpdate(pSDevSlnSys);
        this.onRebindSystem(pSDevSlnSys);
    }

    @Override
    protected void onCreateAsync(PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSys.setDevSysState(20);
        this.create(pSDevSlnSys);
    }

    @Override
    protected void onGetCur(PSDevSlnSys pSDevSlnSys) throws Exception {
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u4e0a\u4e0b\u6587\u6570\u636e\u65e0\u6548"));
        }
        String string = jSONObject.optString("psdevslnsysid");
        pSDevSlnSys.setPSDevSlnSysId(string);
        this.get((IEntity)pSDevSlnSys);
    }

    protected void syncSharePSSysModelInst(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void syncPSDevSlnSysRefs(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnPipelineStep> arrayList;
        Object object;
        Object object22;
        Object object3;
        ArrayList<PSDevSlnSysRefLink> arrayList2;
        Object object4;
        Object object5;
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSys.getPSSysModelInst());
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)sessionFactory);
        PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)sessionFactory);
        PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)sessionFactory);
        PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnSysRefService pSDevSlnSysRefService = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnSysRefLinkService pSDevSlnSysRefLinkService = (PSDevSlnSysRefLinkService)ServiceGlobal.getService(PSDevSlnSysRefLinkService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnSysApp> arrayList6 = pSDevSlnSysAppService.selectByPSDevSlnSys(pSDevSlnSys);
        ArrayList<PSDevSlnSysSrv> arrayList7 = pSDevSlnSysSrvService.selectByPSDevSlnSys(pSDevSlnSys);
        ArrayList<PSDevSlnSysAPI> arrayList8 = pSDevSlnSysAPIService.selectByPSDevSlnSys(pSDevSlnSys);
        HashMap<String, PSDevSlnSysApp> hashMap2 = new HashMap<String, PSDevSlnSysApp>();
        for (PSDevSlnSysApp hashMap3 : arrayList6) {
            hashMap2.put(hashMap3.getPSDevSlnSysAppId(), hashMap3);
        }
        HashMap hashMap4 = new HashMap();
        for (PSDevSlnSysSrv pSDevSlnSysSrv : arrayList7) {
            hashMap4.put(pSDevSlnSysSrv.getPSDevSlnSysSrvId(), pSDevSlnSysSrv);
        }
        HashMap<String, PSDevSlnSysAPI> hashMap = new HashMap<String, PSDevSlnSysAPI>();
        for (PSDevSlnSysAPI pSDevSlnSysAPI : arrayList8) {
            hashMap.put(pSDevSlnSysAPI.getPSDevSlnSysAPIId(), pSDevSlnSysAPI);
        }
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(pSDevSlnSys.getPSSystemId());
        ArrayList<PSSysApp> arrayList4 = pSSysAppService.selectByPSSystem(pSSystem);
        for (PSSysApp pSSysApp : arrayList4) {
            PSDevSlnSysApp pSDevSlnSysApp;
            object5 = new PSDevSlnSysApp();
            pSSysApp.copyTo((IDataObject)object5, false);
            ((PSDevSlnSysAppBase)object5).setValidFlag(1);
            ((PSDevSlnSysAppBase)object5).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevSlnSysAppBase)object5).setPSDevSlnSysAppName(pSSysApp.getPSSysAppName());
            pSDevSlnSysAppService.save((IEntity)object5, false);
            if (hashMap2.size() <= 0 || (pSDevSlnSysApp = (PSDevSlnSysApp)hashMap2.remove(((PSDevSlnSysAppBase)object5).getPSDevSlnSysAppId())) != null) continue;
            arrayList3.add(object5);
        }
        if (hashMap2.size() > 0) {
            block4: for (PSDevSlnSysApp pSDevSlnSysApp : arrayList3) {
                for (Map.Entry entry : hashMap2.entrySet()) {
                    if (StringHelper.compare((String)pSDevSlnSysApp.getAppPKGName(), (String)((PSDevSlnSysApp)entry.getValue()).getAppPKGName(), (boolean)true) != 0) continue;
                    object4 = (PSDevSlnSysApp)entry.getValue();
                    hashMap2.remove(entry.getKey());
                    ArrayList<PSDevSlnMSDepApp> arrayList5 = ((PSDevSlnSysAppBase)object4).getPSDevSlnMSDepApps();
                    for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList5) {
                        arrayList2 = new PSDevSlnMSDepApp();
                        ((PSDevSlnMSDepAppBase)((Object)arrayList2)).setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
                        ((PSDevSlnMSDepAppBase)((Object)arrayList2)).setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
                        pSDevSlnMSDepAppService.sysUpdate(arrayList2, false);
                    }
                    object3 = ((PSDevSlnSysAppBase)object4).getPSDevSlnMSDepFuncItems();
                    Iterator iterator = ((ArrayList)object3).iterator();
                    while (iterator.hasNext()) {
                        arrayList2 = (PSDevSlnMSDepFuncItem)iterator.next();
                        object22 = new PSDevSlnMSDepFuncItem();
                        ((PSDevSlnMSDepFuncItemBase)object22).setPSDevSlnMSDepFuncItemId(((PSDevSlnMSDepFuncItemBase)((Object)arrayList2)).getPSDevSlnMSDepFuncItemId());
                        ((PSDevSlnMSDepFuncItemBase)object22).setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
                        pSDevSlnMSDepFuncItemService.sysUpdate(object22, false);
                    }
                    ArrayList<PSDevSlnTempl> arrayList9 = ((PSDevSlnSysAppBase)object4).getPSDevSlnTempls();
                    for (Object object22 : arrayList9) {
                        PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                        pSDevSlnTempl.setPSDevSlnTemplId(((PSDevSlnTemplBase)object22).getPSDevSlnTemplId());
                        pSDevSlnTempl.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
                        pSDevSlnTemplService.sysUpdate(pSDevSlnTempl, false);
                    }
                    arrayList2 = ((PSDevSlnSysAppBase)object4).getPSDevSlnPipelineSteps();
                    object22 = arrayList2.iterator();
                    while (object22.hasNext()) {
                        PSDevSlnPipelineStep pSDevSlnPipelineStep = (PSDevSlnPipelineStep)object22.next();
                        object = new PSDevSlnPipelineStep();
                        ((PSDevSlnPipelineStepBase)object).setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
                        ((PSDevSlnPipelineStepBase)object).setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
                        pSDevSlnPipelineStepService.sysUpdate(object, false);
                    }
                    pSDevSlnSysAppService.remove((IEntity)object4);
                    continue block4;
                }
            }
            for (Map.Entry entry : hashMap2.entrySet()) {
                if (!DataObject.getBoolValue((Integer)((PSDevSlnSysApp)entry.getValue()).getValidFlag(), (boolean)true)) continue;
                object5 = new PSDevSlnSysApp();
                ((PSDevSlnSysAppBase)object5).setPSDevSlnSysAppId((String)entry.getKey());
                ((PSDevSlnSysAppBase)object5).setValidFlag(0);
                pSDevSlnSysAppService.sysUpdate(object5, false);
            }
        }
        Iterator iterator = new ArrayList();
        ArrayList<PSSysSFPub> arrayList10 = pSSysSFPubService.selectByPSSystem(pSSystem);
        for (PSSysSFPub pSSysSFPub : arrayList10) {
            PSDevSlnSysSrv pSDevSlnSysSrv;
            object4 = new PSDevSlnSysSrv();
            pSSysSFPub.copyTo((IDataObject)object4, false);
            ((PSDevSlnSysSrvBase)object4).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevSlnSysSrvBase)object4).setPSDevSlnSysSrvName(pSSysSFPub.getPSSysSFPubName());
            ((PSDevSlnSysSrvBase)object4).setValidFlag(1);
            pSDevSlnSysSrvService.save((IEntity)object4, false);
            if (hashMap4.size() <= 0 || (pSDevSlnSysSrv = (PSDevSlnSysSrv)hashMap4.remove(((PSDevSlnSysSrvBase)object4).getPSDevSlnSysSrvId())) != null) continue;
            ((ArrayList)((Object)iterator)).add((Object)object4);
        }
        if (hashMap4.size() > 0) {
            object5 = ((ArrayList)((Object)iterator)).iterator();
            block12: while (object5.hasNext()) {
                PSDevSlnSysSrv pSDevSlnSysSrv = (PSDevSlnSysSrv)object5.next();
                for (Map.Entry entry : hashMap4.entrySet()) {
                    if (StringHelper.compare((String)pSDevSlnSysSrv.getCodeName(), (String)((PSDevSlnSysSrv)entry.getValue()).getCodeName(), (boolean)true) != 0 || StringHelper.compare((String)pSDevSlnSysSrv.getPKGCodeName(), (String)((PSDevSlnSysSrv)entry.getValue()).getPKGCodeName(), (boolean)true) != 0) continue;
                    object3 = (PSDevSlnSysSrv)entry.getValue();
                    hashMap4.remove(entry.getKey());
                    ArrayList<PSDevSlnSysRef> arrayList11 = ((PSDevSlnSysSrvBase)object3).getPSDevSlnSysRefs();
                    for (Object object22 : arrayList11) {
                        PSDevSlnSysRef pSDevSlnSysRef = new PSDevSlnSysRef();
                        pSDevSlnSysRef.setPSDevSlnSysRefId(((PSDevSlnSysRefBase)object22).getPSDevSlnSysRefId());
                        pSDevSlnSysRef.setRefPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
                        pSDevSlnSysRefService.sysUpdate(pSDevSlnSysRef, false);
                    }
                    arrayList2 = ((PSDevSlnSysSrvBase)object3).getPSDevSlnSysRefLinks();
                    for (PSDevSlnSysRefLink pSDevSlnSysRefLink : arrayList2) {
                        object = new PSDevSlnSysRefLink();
                        ((PSDevSlnSysRefLinkBase)object).setPSDevSlnSysRefLinkId(pSDevSlnSysRefLink.getPSDevSlnSysRefLinkId());
                        ((PSDevSlnSysRefLinkBase)object).setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
                        pSDevSlnSysRefLinkService.sysUpdate(object, false);
                    }
                    object22 = ((PSDevSlnSysSrvBase)object3).getPSDevSlnTempls();
                    Iterator iterator2 = ((ArrayList)object22).iterator();
                    while (iterator2.hasNext()) {
                        object = (PSDevSlnTempl)iterator2.next();
                        PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                        pSDevSlnTempl.setPSDevSlnTemplId(((PSDevSlnTemplBase)object).getPSDevSlnTemplId());
                        pSDevSlnTempl.setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
                        pSDevSlnTemplService.sysUpdate(pSDevSlnTempl, false);
                    }
                    ArrayList<PSDevSlnPipelineStep> arrayList12 = ((PSDevSlnSysSrvBase)object3).getPSDevSlnPipelineSteps();
                    for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList12) {
                        arrayList = new PSDevSlnPipelineStep();
                        ((PSDevSlnPipelineStepBase)((Object)arrayList)).setPSDevSlnPipelineStepId(pSDevSlnPipelineStep.getPSDevSlnPipelineStepId());
                        ((PSDevSlnPipelineStepBase)((Object)arrayList)).setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
                        pSDevSlnPipelineStepService.sysUpdate(arrayList, false);
                    }
                    pSDevSlnSysSrvService.remove((IEntity)object3);
                    continue block12;
                }
            }
            for (Map.Entry entry : hashMap4.entrySet()) {
                if (!DataObject.getBoolValue((Integer)((PSDevSlnSysSrv)entry.getValue()).getValidFlag(), (boolean)true)) continue;
                object4 = new PSDevSlnSysSrv();
                ((PSDevSlnSysSrvBase)object4).setPSDevSlnSysSrvId((String)entry.getKey());
                ((PSDevSlnSysSrvBase)object4).setValidFlag(0);
                pSDevSlnSysSrvService.sysUpdate(object4, false);
            }
        }
        object5 = new ArrayList();
        ArrayList<PSSysServiceAPI> arrayList13 = pSSysServiceAPIService.selectByPSSystem(pSSystem);
        for (PSSysServiceAPI pSSysServiceAPI : arrayList13) {
            PSDevSlnSysAPI pSDevSlnSysAPI;
            object3 = new PSDevSlnSysAPI();
            pSSysServiceAPI.copyTo((IDataObject)object3, false);
            ((PSDevSlnSysAPIBase)object3).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSDevSlnSysAPIBase)object3).setPSDevSlnSysAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
            pSDevSlnSysAPIService.save((IEntity)object3, false);
            if (hashMap.size() <= 0 || (pSDevSlnSysAPI = (PSDevSlnSysAPI)hashMap.remove(((PSDevSlnSysAPIBase)object3).getPSDevSlnSysAPIId())) != null) continue;
            ((ArrayList)object5).add(object3);
        }
        if (hashMap.size() > 0) {
            object4 = ((ArrayList)object5).iterator();
            block20: while (object4.hasNext()) {
                PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)object4.next();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (StringHelper.compare((String)pSDevSlnSysAPI.getPSSysServiceAPIName(), (String)((PSDevSlnSysAPI)entry.getValue()).getPSSysServiceAPIName(), (boolean)true) != 0) continue;
                    arrayList2 = (PSDevSlnSysAPI)entry.getValue();
                    hashMap.remove(entry.getKey());
                    object22 = new PSDevSlnSysAPI();
                    ((PSDevSlnSysAPIBase)object22).setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
                    ((PSDevSlnSysAPIBase)object22).setClientPSDevSlnSysId(((PSDevSlnSysAPIBase)((Object)arrayList2)).getClientPSDevSlnSysId());
                    ((PSDevSlnSysAPIBase)object22).setClient2PSDevSlnSysId(((PSDevSlnSysAPIBase)((Object)arrayList2)).getClient2PSDevSlnSysId());
                    ((PSDevSlnSysAPIBase)object22).setClientPSDevSlnSysName(((PSDevSlnSysAPIBase)((Object)arrayList2)).getClientPSDevSlnSysName());
                    ((PSDevSlnSysAPIBase)object22).setClient2PSDevSlnSysName(((PSDevSlnSysAPIBase)((Object)arrayList2)).getClient2PSDevSlnSysName());
                    pSDevSlnSysAPIService.sysUpdate(object22, false);
                    ArrayList<PSDevSlnSysRef> arrayList14 = ((PSDevSlnSysAPIBase)((Object)arrayList2)).getPSDevSlnSysRefs();
                    for (PSDevSlnSysRef pSDevSlnSysRef : arrayList14) {
                        arrayList = new PSDevSlnSysRef();
                        ((PSDevSlnSysRefBase)((Object)arrayList)).setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
                        ((PSDevSlnSysRefBase)((Object)arrayList)).setRefPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
                        pSDevSlnSysRefService.sysUpdate(arrayList, false);
                    }
                    object = ((PSDevSlnSysAPIBase)((Object)arrayList2)).getPSDevSlnMSDepAPIs();
                    Iterator iterator3 = ((ArrayList)object).iterator();
                    while (iterator3.hasNext()) {
                        arrayList = (PSDevSlnMSDepAPI)iterator3.next();
                        PSDevSlnMSDepAPI pSDevSlnMSDepAPI = new PSDevSlnMSDepAPI();
                        pSDevSlnMSDepAPI.setPSDevSlnMSDepAPIId(((PSDevSlnMSDepAPIBase)((Object)arrayList)).getPSDevSlnMSDepAPIId());
                        pSDevSlnMSDepAPI.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
                        pSDevSlnMSDepAPIService.sysUpdate(pSDevSlnMSDepAPI, false);
                    }
                    ArrayList<PSDevSlnMSDepFuncItem> arrayList15 = ((PSDevSlnSysAPIBase)((Object)arrayList2)).getPSDevSlnMSDepFuncItems();
                    for (PSDevSlnMSDepFuncItem pSDevSlnMSDepFuncItem : arrayList15) {
                        EntityBase entityBase = new PSDevSlnMSDepFuncItem();
                        entityBase.setPSDevSlnMSDepFuncItemId(pSDevSlnMSDepFuncItem.getPSDevSlnMSDepFuncItemId());
                        entityBase.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
                        pSDevSlnMSDepFuncItemService.sysUpdate(entityBase, false);
                    }
                    arrayList = ((PSDevSlnSysAPIBase)((Object)arrayList2)).getPSDevSlnPipelineSteps();
                    for (EntityBase entityBase : arrayList) {
                        PSDevSlnPipelineStep pSDevSlnPipelineStep = new PSDevSlnPipelineStep();
                        pSDevSlnPipelineStep.setPSDevSlnPipelineStepId(entityBase.getPSDevSlnPipelineStepId());
                        pSDevSlnPipelineStep.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
                        pSDevSlnPipelineStepService.sysUpdate(pSDevSlnPipelineStep, false);
                    }
                    pSDevSlnSysAPIService.remove((IEntity)arrayList2);
                    continue block20;
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!DataObject.getBoolValue((Integer)((PSDevSlnSysAPI)entry.getValue()).getValidFlag(), (boolean)true)) continue;
                object3 = new PSDevSlnSysAPI();
                ((PSDevSlnSysAPIBase)object3).setPSDevSlnSysAPIId((String)entry.getKey());
                ((PSDevSlnSysAPIBase)object3).setValidFlag(0);
                pSDevSlnSysAPIService.sysUpdate(object3, false);
            }
        }
    }

    @Override
    protected boolean isUpdateModelKeeper(PSDevSlnSys pSDevSlnSys) throws Exception {
        return PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).isPSDevSlnSysEnabled();
    }

    @Override
    protected void onUpdateModelKeeper(PSDevSlnSys pSDevSlnSys) throws Exception {
        final String string = pSDevSlnSys.getPSDevSlnSysId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                    pSDevSlnSys.setPSDevSlnSysId(string);
                    PSDevSlnSysService.this.get((IEntity)pSDevSlnSys);
                    PSCoreEntityKeeperGlobal.getCurrent(PSDevSlnSysService.this.getSessionFactory()).updatePSDevSlnSys(pSDevSlnSys);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onOffline(PSDevSlnSys pSDevSlnSys) throws Exception {
        this.get((IEntity)pSDevSlnSys);
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.ONLINE) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u8fde\u7ebf\u72b6\u6001"));
        }
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSDevSlnSys.getPSDevCenterId());
        if (!pSDevCenterService.get((IEntity)pSDevCenter, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u6240\u5c5e\u5e94\u7528\u4e2d\u5fc3"));
        }
        boolean bl = false;
        bl = DataObject.getBoolValue((Integer)pSDevCenter.getEnableWorkspace(), (boolean)false);
        if (!bl) {
            throw new Exception("\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u672a\u542f\u7528\u751f\u4ea7\u7ebf\u6a21\u5f0f");
        }
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDCWorkspaceId())) {
            this.executeAction("X_ADDOFFLINESYSMODELTASK", (IEntity)pSDevSlnSys);
        } else {
            PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
            pSDCWorkspace.setPSDCWorkspaceId(pSDevSlnSys.getPSDCWorkspaceId());
            pSDCWorkspace.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDCWorkspace.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
            pSDCWorkspaceService.uninstallSys(pSDCWorkspace);
        }
    }

    protected void syncPSPFStyle(String string, SessionFactory sessionFactory) throws Exception {
        PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)sessionFactory);
        PSPFStyle pSPFStyle = new PSPFStyle();
        pSPFStyle.setPSPFStyleId(string);
        if (pSPFStyleService.get((IEntity)pSPFStyle, true)) {
            return;
        }
        PSPFStyleService pSPFStyleService2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFStyle pSPFStyle2 = new PSPFStyle();
        pSPFStyle2.setPSPFStyleId(string);
        if (!pSPFStyleService2.get((IEntity)pSPFStyle2, true)) {
            if (PSDevSlnSysService.isCloudMode()) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]\uff0c\u5ffd\u7565\u540c\u6b65", (Object)string));
                return;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]", (Object)string));
        }
        PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)sessionFactory);
        PSPF pSPF = new PSPF();
        pSPF.setPSPFId(pSPFStyle2.getPSPFId());
        if (!pSPFService.get((IEntity)pSPF, true)) {
            PSPFService pSPFService2 = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSPF pSPF2 = new PSPF();
            pSPF2.setPSPFId(pSPFStyle2.getPSPFId());
            if (!pSPFService2.get((IEntity)pSPF2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSAppType pSAppType = new PSAppType();
            pSAppType.setPSAppTypeId(pSPF2.getPSAppTypeId());
            if (!pSAppTypeService.get((IEntity)pSAppType, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService2 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)sessionFactory);
            pSAppTypeService2.save((IEntity)pSAppType, false);
            pSPF.setPSAppTypeId(pSAppType.getPSAppTypeId());
            pSPF.setPSAppTypeName(pSAppType.getPSAppTypeName());
            pSPF.setPSPFId(pSPF2.getPSPFId());
            pSPF.setPSPFName(pSPF2.getPSPFName());
            pSPF.setValidFlag(1);
            pSPFService.create(pSPF);
        }
        pSPFStyle.setPSPFStyleId(pSPFStyle2.getPSPFStyleId());
        pSPFStyle.setPSPFStyleName(pSPFStyle2.getPSPFStyleName());
        pSPFStyle.setPSPFId(pSPFStyle2.getPSPFId());
        pSPFStyle.setPSPFName(pSPFStyle2.getPSPFName());
        pSPFStyle.setStyleCode(pSPFStyle2.getStyleCode());
        pSPFStyle.setStyleEngine(pSPFStyle2.getStyleEngine());
        pSPFStyleService.create(pSPFStyle);
    }

    protected void syncPSSFStyle2(String string, SessionFactory sessionFactory) throws Exception {
        PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)sessionFactory);
        PSSFStyle pSSFStyle = new PSSFStyle();
        pSSFStyle.setPSSFStyleId(string);
        if (pSSFStyleService.get((IEntity)pSSFStyle, true)) {
            return;
        }
        PSSFStyleService pSSFStyleService2 = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFStyle pSSFStyle2 = new PSSFStyle();
        pSSFStyle2.setPSSFStyleId(string);
        if (!pSSFStyleService2.get((IEntity)pSSFStyle2, true)) {
            if (PSDevSlnSysService.isCloudMode()) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]\uff0c\u5ffd\u7565\u540c\u6b65", (Object)string));
                return;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]", (Object)string));
        }
        PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)sessionFactory);
        PSSF pSSF = new PSSF();
        pSSF.setPSSFId(pSSFStyle2.getPSSFId());
        if (!pSSFService.get((IEntity)pSSF, true)) {
            PSSFService pSSFService2 = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSSF pSSF2 = new PSSF();
            pSSF2.setPSSFId(pSSFStyle2.getPSSFId());
            if (!pSSFService2.get((IEntity)pSSF2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f[%1$s]", (Object)pSSFStyle2.getPSSFId()));
            }
            pSSF.setPSSFId(pSSF2.getPSSFId());
            pSSF.setPSSFName(pSSF2.getPSSFName());
            pSSF.setCodeFlag(pSSF2.getCodeFlag());
            pSSF.setDocFlag(pSSF2.getDocFlag());
            pSSF.setValidFlag(1);
            pSSFService.create(pSSF);
        }
        pSSFStyle.setPSSFStyleId(pSSFStyle2.getPSSFStyleId());
        pSSFStyle.setPSSFStyleName(pSSFStyle2.getPSSFStyleName());
        pSSFStyle.setPSSFId(pSSFStyle2.getPSSFId());
        pSSFStyle.setPSSFName(pSSFStyle2.getPSSFName());
        pSSFStyle.setStyleEngine(pSSFStyle2.getStyleEngine());
        pSSFStyleService.create(pSSFStyle);
    }

    protected void syncPSSFStyleVer(String string, SessionFactory sessionFactory) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)sessionFactory);
        PSSFStyleVer pSSFStyleVer = new PSSFStyleVer();
        pSSFStyleVer.setPSSFStyleVerId(string);
        if (pSSFStyleVerService.get((IEntity)pSSFStyleVer, true)) {
            return;
        }
        PSSFStyleVerService pSSFStyleVerService2 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFStyleVer pSSFStyleVer2 = new PSSFStyleVer();
        pSSFStyleVer2.setPSSFStyleVerId(string);
        if (!pSSFStyleVerService2.get((IEntity)pSSFStyleVer2, true)) {
            if (PSDevSlnSysService.isCloudMode()) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f\u6837\u5f0f\u7248\u672c[%1$s]\uff0c\u5ffd\u7565\u540c\u6b65", (Object)string));
                return;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f\u6837\u5f0f\u7248\u672c[%1$s]", (Object)string));
        }
        pSSFStyleVer.setPSSFStyleVerId(pSSFStyleVer2.getPSSFStyleVerId());
        pSSFStyleVer.setPSSFStyleVerName(pSSFStyleVer2.getPSSFStyleVerName());
        pSSFStyleVer.setPSSFId(pSSFStyleVer2.getPSSFId());
        pSSFStyleVer.setPSSFStyleId(pSSFStyleVer2.getPSSFStyleId());
        pSSFStyleVer.setPSSFStyleName(pSSFStyleVer2.getPSSFStyleName());
        pSSFStyleVerService.create(pSSFStyleVer);
    }

    @Override
    protected void internalCreate(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDevCenterSVNId()) && StringHelper.isNullOrEmpty((String)pSDevSlnSys.getModelPSDevCenterSVNId()) && PSDevSlnSysService.isEnableGitLabPlugin()) {
            PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
            if (pSDevSln == null) {
                throw new Exception("\u7cfb\u7edf\u5f00\u53d1\u65b9\u6848\u65e0\u6548");
            }
            PSDevCenter pSDevCenter = pSDevSln.getPSDevCenter();
            if (pSDevCenter == null) {
                throw new Exception("\u7cfb\u7edf\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548");
            }
            if (pSDevCenter.getV6PSSvnInstRepo() != null) {
                Object object;
                PSDevCenterSVN pSDevCenterSVN;
                PSDevCenterSVN pSDevCenterSVN2;
                Object object2;
                Object object3;
                Object object4;
                PSDevSlnSys pSDevSlnSys2 = null;
                String string = null;
                String string2 = "";
                if (PSDevSlnSysService.isCloudMode()) {
                    if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPPSDevSlnSysId())) {
                        pSDevSlnSys2 = pSDevSlnSys.getPPSDevSlnSys();
                    } else if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getMainPSDevSlnSysId())) {
                        pSDevSlnSys2 = pSDevSlnSys.getMainPSDevSlnSys();
                    }
                    if (pSDevSlnSys2 != null && (object4 = pSDevSlnSys2.getModelPSDevCenterSVN()) != null && ((PSDevCenterSVNBase)object4).getPSSVNInstRepo() != null && (object3 = ((PSDevCenterSVNBase)object4).getPSSVNInstRepo().getPSSVNServer()) != null) {
                        string = ((PSSVNServerBase)object3).getGITUserName();
                        string2 = ((PSSVNServerBase)object3).getGITPassword();
                        if (StringHelper.isNullOrEmpty((String)string2)) {
                            string2 = "";
                        }
                    }
                }
                object4 = pSDevSlnSys.getSysFolder();
                pSDevSlnSys.set("importurl", object4);
                if (pSDevSlnSys2 != null && (object3 = pSDevSlnSys2.getModelPSDevCenterSVN()) != null) {
                    int n;
                    pSDevSlnSys.set("importurl", ((PSDevCenterSVNBase)object3).getGitPath());
                    if (!StringHelper.isNullOrEmpty(string) && (n = ((String)(object2 = ((PSDevCenterSVNBase)object3).getGitPath())).indexOf("//")) != -1) {
                        String string3 = ((String)object2).substring(0, n + 2);
                        string3 = string3 + String.format("%1$s:%2$s@", string, string2);
                        string3 = string3 + ((String)object2).substring(n + 2);
                        pSDevSlnSys.set("importurl", string3);
                    }
                }
                object3 = PSDevSlnSysService.getPSGitLabPlugin().createModelProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevSlnSys.setSysFolder(null);
                pSDevSlnSys.set("importurl", null);
                if (pSDevSlnSys2 != null && (object2 = pSDevSlnSys2.getPSDevCenterSVN()) != null) {
                    String string4;
                    int n;
                    pSDevSlnSys.set("importurl", ((PSDevCenterSVNBase)object2).getGitPath());
                    if (!StringHelper.isNullOrEmpty((String)string) && (n = (string4 = ((PSDevCenterSVNBase)object2).getGitPath()).indexOf("//")) != -1) {
                        String string5 = string4.substring(0, n + 2);
                        string5 = string5 + String.format("%1$s:%2$s@", string, string2);
                        string5 = string5 + string4.substring(n + 2);
                        pSDevSlnSys.set("importurl", string5);
                    }
                }
                object2 = PSDevSlnSysService.getPSGitLabPlugin().createCodeProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevSlnSys.set("importurl", null);
                if (pSDevSlnSys2 != null && (pSDevCenterSVN2 = pSDevSlnSys2.getRTModelPSDevCenterSVN()) != null) {
                    String string6;
                    int n;
                    pSDevSlnSys.set("importurl", pSDevCenterSVN2.getGitPath());
                    if (!StringHelper.isNullOrEmpty((String)string) && (n = (string6 = pSDevCenterSVN2.getGitPath()).indexOf("//")) != -1) {
                        String string7 = string6.substring(0, n + 2);
                        string7 = string7 + String.format("%1$s:%2$s@", string, string2);
                        string7 = string7 + string6.substring(n + 2);
                        pSDevSlnSys.set("importurl", string7);
                    }
                }
                Project project = PSDevSlnSysService.getPSGitLabPlugin().createRuntimeProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevSlnSys.set("importurl", null);
                if (pSDevSlnSys2 != null && (pSDevCenterSVN = pSDevSlnSys2.getDocPSDevCenterSVN()) != null) {
                    String string8;
                    int n;
                    pSDevSlnSys.set("importurl", pSDevCenterSVN.getGitPath());
                    if (!StringHelper.isNullOrEmpty((String)string) && (n = (string8 = pSDevCenterSVN.getGitPath()).indexOf("//")) != -1) {
                        object = string8.substring(0, n + 2);
                        object = (String)object + String.format("%1$s:%2$s@", string, string2);
                        object = (String)object + string8.substring(n + 2);
                        pSDevSlnSys.set("importurl", object);
                    }
                }
                Project project2 = PSDevSlnSysService.getPSGitLabPlugin().createDocProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevSlnSys.set("importurl", null);
                PSDevCenterSVN pSDevCenterSVN3 = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, (Project)object2);
                PSDevCenterSVN pSDevCenterSVN4 = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, (Project)object3);
                object = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project);
                PSDevCenterSVN pSDevCenterSVN5 = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project2);
                pSDevSlnSys.setPSDevCenterSVNId(pSDevCenterSVN3.getPSDevCenterSVNId());
                pSDevSlnSys.setPSDevCenterSVNName(pSDevCenterSVN3.getPSDevCenterSVNName());
                pSDevSlnSys.setModelPSDevCenterSVNId(pSDevCenterSVN4.getPSDevCenterSVNId());
                pSDevSlnSys.setModelPSDevCenterSVNName(pSDevCenterSVN4.getPSDevCenterSVNName());
                pSDevSlnSys.setDocPSDevCenterSVNId(pSDevCenterSVN5.getPSDevCenterSVNId());
                pSDevSlnSys.setDocPSDevCenterSVNName(pSDevCenterSVN5.getPSDevCenterSVNName());
                if (!PSDevSlnSysService.isCloudMode()) {
                    pSDevSlnSys.setRTModelPSDevCenterSVNId(((PSDevCenterSVNBase)object).getPSDevCenterSVNId());
                    pSDevSlnSys.setRTModelPSDevCenterSVNName(((PSDevCenterSVNBase)object).getPSDevCenterSVNName());
                }
            }
        }
        super.internalCreate(pSDevSlnSys);
    }

    @Override
    public void executeAction(String string, IEntity iEntity) throws Exception {
        if (this.isMajorSessionFactory()) {
            final String string2 = string;
            final IEntity iEntity2 = iEntity;
            this.doServiceWork(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysService.this.onTestSysAction(string2, iEntity2);
                }
            });
        }
        super.executeAction(string, iEntity);
    }

    protected void onTestSysAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)"X_ADDBACKUPSYSMODELTASK", (boolean)false) == 0) {
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            iEntity.copyTo((IDataObject)pSDevSlnSys, false);
            this.get((IEntity)pSDevSlnSys);
            if (StringHelper.compare((String)string, (String)"X_ADDBACKUPSYSMODELTASK", (boolean)false) == 0) {
                PSDevCenterHelper.testCreate(pSDevSlnSys.getPSDevSln().getPSDevCenter(), "SYSBAKCNT", false);
            }
        } else {
            return;
        }
    }

    @Override
    protected void onFixPSDCSVNs(PSDevSlnSys pSDevSlnSys) throws Exception {
        if (!this.isMajorSessionFactory()) {
            return;
        }
        if (!PSDevSlnSysService.isEnableGitLabPlugin()) {
            return;
        }
        this.get((IEntity)pSDevSlnSys);
        PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception("\u7cfb\u7edf\u5f00\u53d1\u65b9\u6848\u65e0\u6548");
        }
        PSDevCenter pSDevCenter = pSDevSln.getPSDevCenter();
        if (pSDevCenter == null) {
            throw new Exception("\u7cfb\u7edf\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548");
        }
        if (pSDevCenter.getV6PSSvnInstRepo() != null) {
            PSDevCenterSVN pSDevCenterSVN;
            Project project;
            boolean bl = false;
            PSDevSlnSys pSDevSlnSys2 = new PSDevSlnSys();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getModelPSDevCenterSVNId())) {
                project = PSDevSlnSysService.getPSGitLabPlugin().createModelProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project);
                pSDevSlnSys2.setModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
                pSDevSlnSys2.setModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                bl = true;
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getRTModelPSDevCenterSVNId())) {
                project = PSDevSlnSysService.getPSGitLabPlugin().createRuntimeProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project);
                pSDevSlnSys2.setRTModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
                pSDevSlnSys2.setRTModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                bl = true;
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getDocPSDevCenterSVNId())) {
                project = PSDevSlnSysService.getPSGitLabPlugin().createDocProjectByPSDevSlnSys(pSDevSlnSys);
                pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project);
                pSDevSlnSys2.setDocPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
                pSDevSlnSys2.setDocPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                bl = true;
            }
            if (bl) {
                this.sysUpdate(pSDevSlnSys2, false);
            }
        }
    }

    @Override
    public void rawOffline(PSDevSlnSys pSDevSlnSys) throws Exception {
        Object object;
        Object object2;
        this.get((IEntity)pSDevSlnSys);
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSysModelInstId())) {
            object2 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
            object = new PSSysModelInst();
            ((PSSysModelInstBase)object).setPSSysModelInstId(pSDevSlnSys.getPSSysModelInstId());
            ((PSSysModelInstBase)object).setInstState("35");
            ((PSCoreSysServiceBaseBase)((Object)object2)).update(object);
        }
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSDCWorkspaceId())) {
            object2 = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
            object = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)this.getSessionFactory());
            PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
            pSDCWorkspace.setPSDCWorkspaceId(pSDevSlnSys.getPSDCWorkspaceId());
            if (object2.get((IEntity)pSDCWorkspace, true)) {
                EntityBase entityBase;
                PSWorkspace pSWorkspace = new PSWorkspace();
                pSWorkspace.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
                if (object.get((IEntity)pSWorkspace, true)) {
                    entityBase = new PSWorkspace();
                    entityBase.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
                    entityBase.setCurAction(null);
                    entityBase.setActionOwner(null);
                    ((PSCoreSysServiceBaseBase)((Object)object)).sysUpdate(entityBase, false);
                }
                entityBase = new PSDCWorkspace();
                entityBase.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
                entityBase.setPSDevSlnSysId(null);
                ((PSCoreSysServiceBaseBase)((Object)object2)).sysUpdate(entityBase, false);
            }
        }
        object2 = new PSDevSlnSys();
        ((PSDevSlnSysBase)object2).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        ((PSDevSlnSysBase)object2).setDevSysState(35);
        ((PSDevSlnSysBase)object2).setCurAction("NONE");
        ((PSDevSlnSysBase)object2).setPSDCWorkspaceId(null);
        ((PSDevSlnSysBase)object2).setActionOwner(null);
        EntityBase.setLastUpdateDate((IEntity)object2, (Timestamp)pSDevSlnSys.getUpdateDate());
        this.sysUpdate(object2, true);
        PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys((PSDevSlnSys)object2);
    }

    static {
        psResStateLevelMap.put(40, 100);
        psResStateLevelMap.put(41, 90);
        psResStateLevelMap.put(42, 80);
        psResStateLevelMap.put(10, 60);
        psResStateLevelMap.put(11, 50);
        psResStateLevelMap.put(20, 0);
    }
}

