/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEFieldModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.PFPluginTypeCodeListModel
 *  net.ibizsys.pscore.srv.config.service.PSDEFTypeService
 *  net.ibizsys.pscore.srv.config.service.PSEditorTypeService
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDERService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRTDEFInputTip
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRTDEFInputTipService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.PFPluginTypeCodeListModel;
import net.ibizsys.pscore.srv.config.service.PSDEFTypeService;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRTDEFInputTip;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRTDEFInputTipService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysRTDEFInputTipDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysRTDEFInputTipDataCtrl.class);
    public static final String CUSTOMCALL_BUILDLIST = "BUILDLIST";
    public static final String CUSTOMCALL_SYNCLIST = "SYNCLIST";
    public static final String CUSTOMCALL_INITEX = "INITEX";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BUILDLIST, (boolean)true) == 0) {
            return this.buildList(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCLIST, (boolean)true) == 0) {
            return this.syncList(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITEX, (boolean)true) == 0) {
            return this.initEx(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult buildList(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSysRTDEFInputTipDataCtrl.this.onBuildList();
                    PSSysRTDEFInputTipDataCtrl.this.onBuildDEFGroups();
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onBuildList() throws Exception {
        try {
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
            PSCoreSysServiceBase.setEnableMergeCount((boolean)false);
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
            PSSysRTDEFInputTipService psSysRTDEFInputTipService = (PSSysRTDEFInputTipService)ServiceGlobal.getService(PSSysRTDEFInputTipService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.addSelectField("UNIQUETAG");
            selectContext.addSelectField("PSSYSRTDEFINPUTTIPID");
            selectContext.addSelectField("VALIDFLAG");
            selectContext.addSelectField("ORDERVALUE");
            selectContext.addSelectField("PSDEID");
            selectContext.set("VALIDFLAG", (Object)1);
            ArrayList<PSSysRTDEFInputTip> psSysRTDEFInputTipList = psSysRTDEFInputTipService.select((ISelectCond)selectContext);
            HashMap<String, PSSysRTDEFInputTip> psSysRTDEFInputTipMap = new HashMap<String, PSSysRTDEFInputTip>();
            for (PSSysRTDEFInputTip psSysRTDEFInputTip : psSysRTDEFInputTipList) {
                psSysRTDEFInputTipMap.put(psSysRTDEFInputTip.getUniqueTag(), psSysRTDEFInputTip);
            }
            PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectContext.reset();
            selectContext.addSelectField("PSDEFIELDID");
            selectContext.addSelectField("PSDEFIELDNAME");
            selectContext.addSelectField("PSDENAME");
            selectContext.addSelectField("PSDEID");
            selectContext.setIsNotNull("MEMO");
            selectContext.set("PSSYSTEMID", (Object)"86E2A266-4D1E-49F0-A12D-D636905457A3");
            ArrayList<PSDEField> psDEFieldList = psDEFieldService.select((ISelectCond)selectContext);
            HashMap<String, PSDEField> psDEFieldMap = new HashMap<String, PSDEField>();
            for (PSDEField psDEField : psDEFieldList) {
                psDEFieldMap.put(psDEField.getPSDEFieldId(), psDEField);
            }
            PSDEFInputTipService psDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectContext.reset();
            selectContext.addSelectField("UNIQUETAG");
            selectContext.addSelectField("PSDEFID");
            selectContext.addSelectField("DEFAULTFLAG");
            selectContext.addSelectField("VALIDFLAG");
            selectContext.addSelectField("PSDEFINPUTTIPID");
            selectContext.addSelectField("PSDENAME");
            selectContext.setIsNotNull("PSDEFID");
            ArrayList<PSDEFInputTip> psDEFInputTipList = psDEFInputTipService.select((ISelectCond)selectContext);
            HashMap<String, PSDEFInputTip> psDEFInputTipMap = new HashMap<String, PSDEFInputTip>();
            HashMap<String, PSDEFInputTip> psDEFInputTipMap2 = new HashMap<String, PSDEFInputTip>();
            for (PSDEFInputTip pSDEFInputTip : psDEFInputTipList) {
                psDEFInputTipMap.put(pSDEFInputTip.getUniqueTag(), pSDEFInputTip);
                if (DataObject.getIntegerValue((Object)pSDEFInputTip.getDefaultFlag(), (Integer)1) != 1) continue;
                psDEFInputTipMap2.put(pSDEFInputTip.getPSDEFId(), pSDEFInputTip);
            }
            for (PSDEField pSDEField : psDEFieldList) {
                String strTag = StringHelper.Format((String)"%1$s__%2$s", (Object)pSDEField.getPSDEName(), (Object)pSDEField.getPSDEFieldName());
                PSDEFInputTip psDEFInputTip = (PSDEFInputTip)psDEFInputTipMap.remove(strTag);
                if (psDEFInputTip == null) {
                    psDEFInputTip = new PSDEFInputTip();
                    psDEFInputTip.setPSDEFInputTipSetId("99D6C6E5-D2E0-4B82-A265-5D05FE880E94");
                    psDEFInputTip.setPSDEFInputTipName("\u9ed8\u8ba4\u63d0\u793a");
                    psDEFInputTip.setUniqueTag(strTag);
                    psDEFInputTip.setPSDEId(pSDEField.getPSDEId());
                    psDEFInputTip.setPSDEName(pSDEField.getPSDEName());
                    psDEFInputTip.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
                    psDEFInputTip.setPSDEFId(pSDEField.getPSDEFieldId());
                    psDEFInputTip.setPSDEFName(pSDEField.getPSDEFieldName());
                    psDEFInputTip.setValidFlag(Integer.valueOf(1));
                    if (!psDEFInputTipMap2.containsKey(pSDEField.getPSDEFieldId())) {
                        psDEFInputTip.setDefaultFlag(Integer.valueOf(1));
                    } else {
                        psDEFInputTip.setDefaultFlag(Integer.valueOf(0));
                    }
                    psDEFInputTip.setCodeName("DefaultEx");
                    psDEFInputTipService.create(psDEFInputTip, false);
                    log.info((Object)StringHelper.Format((String)"\u65b0\u5efa\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s|%2$s]", (Object)pSDEField.getPSDEName(), (Object)pSDEField.getPSDEFieldName()));
                } else if (!DataObject.getBoolValue((Integer)psDEFInputTip.getValidFlag(), (boolean)true)) {
                    PSDEFInputTip psDEFInputTip2 = new PSDEFInputTip();
                    psDEFInputTip2.setPSDEFInputTipId(psDEFInputTip.getPSDEFInputTipId());
                    psDEFInputTip2.setValidFlag(Integer.valueOf(1));
                    psDEFInputTipService.sysUpdate(psDEFInputTip2, false);
                    log.info((Object)StringHelper.Format((String)"\u66f4\u65b0\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s|%2$s]\u4e3a\u542f\u7528", (Object)pSDEField.getPSDEName(), (Object)pSDEField.getPSDEFieldName()));
                }
                PSSysRTDEFInputTip psSysRTDEFInputTip = (PSSysRTDEFInputTip)psSysRTDEFInputTipMap.remove(strTag);
                if (psSysRTDEFInputTip == null || DataObject.getIntegerValue((Object)psSysRTDEFInputTip.getOrderValue(), (Integer)0) >= 1000) continue;
                PSSysRTDEFInputTip psSysRTDEFInputTip2 = new PSSysRTDEFInputTip();
                psSysRTDEFInputTip2.setPSSysRTDEFInputTipId(psSysRTDEFInputTip.getPSSysRTDEFInputTipId());
                psSysRTDEFInputTip2.setValidFlag(Integer.valueOf(0));
                psSysRTDEFInputTipService.update(psSysRTDEFInputTip2, false);
            }
            for (Map.Entry entry : psDEFInputTipMap.entrySet()) {
                PSDEFInputTip psDEFInputTip2 = new PSDEFInputTip();
                psDEFInputTip2.setPSDEFInputTipId(((PSDEFInputTip)entry.getValue()).getPSDEFInputTipId());
                psDEFInputTip2.setValidFlag(Integer.valueOf(0));
                psDEFInputTipService.sysUpdate(psDEFInputTip2, false);
            }
            for (Map.Entry entry : psSysRTDEFInputTipMap.entrySet()) {
                PSSysRTDEFInputTip psSysRTDEFInputTip = (PSSysRTDEFInputTip)entry.getValue();
                if (StringHelper.IsNullOrEmpty((String)psSysRTDEFInputTip.getPSDEId()) || DataObject.getIntegerValue((Object)psSysRTDEFInputTip.getOrderValue(), (Integer)0) >= 1000) continue;
                PSSysRTDEFInputTip psSysRTDEFInputTip2 = new PSSysRTDEFInputTip();
                psSysRTDEFInputTip2.setPSSysRTDEFInputTipId(((PSSysRTDEFInputTip)entry.getValue()).getPSSysRTDEFInputTipId());
                psSysRTDEFInputTip2.setValidFlag(Integer.valueOf(0));
                psSysRTDEFInputTipService.update(psSysRTDEFInputTip2, false);
            }
            PSCoreSysServiceBase.endImpSysModel();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            PSCoreSysServiceBase.endImpSysModel();
        }
    }

    public CallResult syncList(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSysRTDEFInputTipDataCtrl.this.onSyncList();
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5217\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncList() throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)"2108CA9E-0BCB-4CBE-BE75-707040B5E27F");
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        ArrayList psSystemList = psSystemService.select((ISelectCond)new SelectCond());
        if (psSystemList.size() != 1) {
            return;
        }
        try {
            PSSysModelInstGlobal.activeAlways((String)"2108CA9E-0BCB-4CBE-BE75-707040B5E27F");
            PSSystem psSystem = (PSSystem)psSystemList.get(0);
            PSCoreSysServiceBase.setEnableMergeCount((boolean)false);
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
            PSDEFInputTipService psDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.reset();
            selectContext.addSelectField("UNIQUETAG");
            selectContext.addSelectField("PSDEFID");
            selectContext.addSelectField("PSDEFNAME");
            selectContext.addSelectField("DEFAULTFLAG");
            selectContext.addSelectField("VALIDFLAG");
            selectContext.addSelectField("PSDEFINPUTTIPID");
            selectContext.addSelectField("PSDEID");
            selectContext.addSelectField("PSDENAME");
            selectContext.setIsNotNull("UNIQUETAG");
            selectContext.setIsNotNull("PSDEFID");
            selectContext.set("VALIDFLAG", (Object)1);
            ArrayList<PSDEFInputTip> psDEFInputTipList = psDEFInputTipService.select((ISelectCond)selectContext);
            PSDEFInputTipService psDEFInputTipService2 = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)sessionFactory);
            selectContext.reset();
            selectContext.addSelectField("UNIQUETAG");
            selectContext.addSelectField("PSDEFID");
            selectContext.addSelectField("DEFAULTFLAG");
            selectContext.addSelectField("VALIDFLAG");
            selectContext.addSelectField("PSDEFINPUTTIPID");
            selectContext.addSelectField("PSDENAME");
            selectContext.setIsNotNull("PSDEFID");
            ArrayList<PSDEFInputTip> psDEFInputTipList2 = psDEFInputTipService2.select((ISelectCond)selectContext);
            HashMap<String, PSDEFInputTip> psDEFInputTipMap = new HashMap<String, PSDEFInputTip>();
            HashMap<String, PSDEFInputTip> psDEFInputTipMap2 = new HashMap<String, PSDEFInputTip>();
            for (PSDEFInputTip pSDEFInputTip : psDEFInputTipList2) {
                psDEFInputTipMap.put(pSDEFInputTip.getUniqueTag(), pSDEFInputTip);
                if (DataObject.getIntegerValue((Object)pSDEFInputTip.getDefaultFlag(), (Integer)1) != 1) continue;
                psDEFInputTipMap2.put(pSDEFInputTip.getPSDEFId(), pSDEFInputTip);
            }
            for (PSDEFInputTip pSDEFInputTip : psDEFInputTipList) {
                String strTag = pSDEFInputTip.getUniqueTag();
                PSDEFInputTip psDEFInputTip = (PSDEFInputTip)psDEFInputTipMap.remove(strTag);
                if (psDEFInputTip == null) {
                    psDEFInputTip = new PSDEFInputTip();
                    psDEFInputTip.setPSDEFInputTipSetId("99D6C6E5-D2E0-4B82-A265-5D05FE880E94");
                    psDEFInputTip.setPSDEFInputTipName("\u9ed8\u8ba4\u63d0\u793a");
                    psDEFInputTip.setUniqueTag(strTag);
                    psDEFInputTip.setPSDEId(pSDEFInputTip.getPSDEId());
                    psDEFInputTip.setPSDEName(pSDEFInputTip.getPSDEName());
                    psDEFInputTip.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
                    psDEFInputTip.setPSDEFId(pSDEFInputTip.getPSDEFId());
                    psDEFInputTip.setPSDEFName(pSDEFInputTip.getPSDEFName());
                    psDEFInputTip.setValidFlag(Integer.valueOf(1));
                    if (!psDEFInputTipMap2.containsKey(pSDEFInputTip.getPSDEFId())) {
                        psDEFInputTip.setDefaultFlag(Integer.valueOf(1));
                    } else {
                        psDEFInputTip.setDefaultFlag(Integer.valueOf(0));
                    }
                    psDEFInputTip.setCodeName("DefaultEx");
                    try {
                        psDEFInputTipService2.create(psDEFInputTip, false);
                        log.info((Object)StringHelper.Format((String)"\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s|%2$s]", (Object)pSDEFInputTip.getPSDEName(), (Object)pSDEFInputTip.getPSDEFName()));
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.Format((String)"\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s|%2$s]\u5efa\u7acb\u5f02\u5e38", (Object)pSDEFInputTip.getPSDEName(), (Object)pSDEFInputTip.getPSDEFName()));
                    }
                    continue;
                }
                if (DataObject.getBoolValue((Integer)psDEFInputTip.getValidFlag(), (boolean)true)) continue;
                PSDEFInputTip psDEFInputTip2 = new PSDEFInputTip();
                psDEFInputTip2.setPSDEFInputTipId(psDEFInputTip.getPSDEFInputTipId());
                psDEFInputTip2.setValidFlag(Integer.valueOf(1));
                psDEFInputTipService2.sysUpdate(psDEFInputTip2, false);
                log.info((Object)StringHelper.Format((String)"\u66f4\u65b0\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s|%2$s]\u4e3a\u542f\u7528", (Object)pSDEFInputTip.getPSDEName(), (Object)pSDEFInputTip.getPSDEFName()));
            }
            for (Map.Entry entry : psDEFInputTipMap.entrySet()) {
                PSDEFInputTip psDEFInputTip2 = new PSDEFInputTip();
                psDEFInputTip2.setPSDEFInputTipId(((PSDEFInputTip)entry.getValue()).getPSDEFInputTipId());
                psDEFInputTip2.setValidFlag(Integer.valueOf(0));
                psDEFInputTipService.sysUpdate(psDEFInputTip2, false);
            }
            PSCoreSysServiceBase.endImpSysModel();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            PSCoreSysServiceBase.endImpSysModel();
        }
    }

    public CallResult initEx(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSysRTDEFInputTipDataCtrl.this.onInitEx();
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u6a21\u578b\u6269\u5c55\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitEx() throws Exception {
        try {
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
            PSCoreSysServiceBase.setEnableMergeCount((boolean)false);
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
            PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDEDQCondService psDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.setPSDataEntityId("850bff46135ea742014684051bf67889");
            psDataEntityService.get(psDataEntity);
            ArrayList<PSDEDataSet> psDEDataSets = psDataEntity.getPSDEDataSets();
            ArrayList<PSDEDataQuery> psDEDataQueries = psDataEntity.getPSDEDataQueries();
            HashMap<String, String> psDEDQCondMap = new HashMap<String, String>();
            HashMap<String, String> psDEDataSetMap = new HashMap<String, String>();
            block2: for (PSDEDataQuery psDEDataQuery : psDEDataQueries) {
                ArrayList<PSDEDQCond> psDEDQCondList = psDEDQCondService.selectByPSDEDQ((PSDEDataQueryBase)psDEDataQuery);
                for (PSDEDQCond psDEDQCond : psDEDQCondList) {
                    if (StringHelper.Compare((String)psDEDQCond.getPSDEFName(), (String)"PLUGINTYPE", (boolean)false) != 0) continue;
                    psDEDQCondMap.put(psDEDQCond.getPSDEDQId(), psDEDQCond.getCondValue());
                    continue block2;
                }
            }
            block4: for (PSDEDataSet psDEDataSet : psDEDataSets) {
                ArrayList<PSDEDSDQ> psDEDSDQs = psDEDataSet.getPSDEDSDQs();
                for (PSDEDSDQ psDEDSDQ : psDEDSDQs) {
                    String strValue = (String)psDEDQCondMap.get(psDEDSDQ.getPSDEDQId());
                    if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                    psDEDataSetMap.put(psDEDataSet.getPSDEDataSetId(), strValue);
                    continue block4;
                }
            }
            PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            ICodeList psPFPluginTypeCodeList = PFPluginTypeCodeListModel.getInstance();
            SelectContext selectContext = new SelectContext();
            selectContext.reset();
            selectContext.addSelectField("PSDERID");
            selectContext.addSelectField("DERFIELDNAME");
            selectContext.addSelectField("PSDEDATASETID");
            selectContext.addSelectField("MINORPSDEID");
            selectContext.addSelectField("MINORPSDENAME");
            selectContext.set("MAJORPSDEID", (Object)"850bff46135ea742014684051bf67889");
            selectContext.set("PSSYSTEMID", (Object)"86E2A266-4D1E-49F0-A12D-D636905457A3");
            PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            ArrayList<PSDER> psDERList = psDERService.select((ISelectCond)selectContext);
            for (PSDER psDER : psDERList) {
                String strValue;
                if (StringHelper.IsNullOrEmpty((String)psDER.getPSDEDataSetId()) || StringHelper.IsNullOrEmpty((String)(strValue = (String)psDEDataSetMap.get(psDER.getPSDEDataSetId())))) continue;
                String strText = psPFPluginTypeCodeList.getCodeListText(strValue, true);
                selectContext.reset();
                selectContext.addSelectField("PSDEFIELDID");
                selectContext.addSelectField("LOGICNAME");
                selectContext.addSelectField("PSDEID");
                selectContext.setIsNull("MEMO");
                selectContext.set("PSDEID", (Object)psDER.getMinorPSDEId());
                selectContext.set("PSDERID", (Object)psDER.getPSDERId());
                selectContext.set("PSDATATYPEID", (Object)"PICKUPTEXT");
                ArrayList psDEFieldList = psDEFieldService.select((ISelectCond)selectContext);
                if (psDEFieldList.size() == 0) continue;
                PSDEField psDEField = (PSDEField)psDEFieldList.get(0);
                String strMemo = null;
                strMemo = StringHelper.Compare((String)psDER.getDERFieldName(), (String)"PSSYSPFPLUGINID", (boolean)true) == 0 ? StringHelper.Format((String)"\u6307\u5b9a%1$s\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010%2$s\u3011", (Object)psDEField.getPSDE().getLogicName(), (Object)strText) : StringHelper.Format((String)"\u6307\u5b9a%1$s\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010%2$s\u3011", (Object)psDEField.getLogicName(), (Object)strText);
                PSDEField psDEField2 = new PSDEField();
                psDEField2.setPSDEFieldId(psDEField.getPSDEFieldId());
                psDEField2.setMemo(strMemo);
                psDEFieldService.sysUpdate(psDEField2, false);
            }
            PSCoreSysServiceBase.endImpSysModel();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            PSCoreSysServiceBase.endImpSysModel();
        }
    }

    protected void onBuildDEFGroups() throws Exception {
        try {
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
            PSCoreSysServiceBase.setEnableMergeCount((boolean)false);
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
            PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.addSelectField("PDVTPARAM");
            selectContext.addSelectField("PREDEFINEVIEWTYPE");
            selectContext.addSelectField("PSDEVIEWBASEID");
            selectContext.addSelectField("PSDEID");
            selectContext.set("PSSYSTEMID", (Object)psSystem.getPSSystemId());
            selectContext.set("PREDEFINEVIEWTYPE", (Object)"EDITVIEW");
            ArrayList<PSDEViewBase> psDEViewBaseList = psDEViewBaseService.select((ISelectCond)selectContext);
            HashMap<String, PSDEViewBase> psDEViewBaseMap = new HashMap<String, PSDEViewBase>();
            for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
                psDEViewBaseMap.put(psDEViewBase.getPSDEViewBaseId(), psDEViewBase);
            }
            PSDEFGroupService psDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            selectContext.reset();
            selectContext.set("PSDEVIEWCTRLTYPE", (Object)"FORM");
            ArrayList<PSDEViewCtrl> psDEViewCtrlList = psDEViewCtrlService.select((ISelectCond)selectContext);
            for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
                PSDEViewBase psDEViewBase = (PSDEViewBase)psDEViewBaseMap.get(psDEViewCtrl.getPSDEViewBaseId());
                if (psDEViewBase == null || StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEFormId())) continue;
                String strName = null;
                String strPredefinedParam = psDEViewBase.getPDVTParam();
                if (StringHelper.IsNullOrEmpty((String)strPredefinedParam)) {
                    strPredefinedParam = "_DEFAULT";
                    strName = "\u901a\u7528";
                } else {
                    IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)psDEViewBase.getPSDEId());
                    Iterator defields = iDataEntityModel.getDEFields();
                    while (defields.hasNext()) {
                        IDEFieldModel iDEFieldModel = (IDEFieldModel)defields.next();
                        if (!iDEFieldModel.isMultiFormDEField() && !iDEFieldModel.isIndexTypeDEField() || StringHelper.IsNullOrEmpty((String)iDEFieldModel.getCodeListId())) continue;
                        ICodeList iCodeList = CodeListGlobal.getCodeList((String)iDEFieldModel.getCodeListId());
                        Iterator codeItems = iCodeList.getCodeItems();
                        if (codeItems != null) {
                            while (codeItems.hasNext()) {
                                ICodeItem iCodeItem = (ICodeItem)codeItems.next();
                                if (StringHelper.Compare((String)iCodeItem.getValue(), (String)strPredefinedParam, (boolean)false) != 0) continue;
                                strName = iCodeItem.getText();
                                break;
                            }
                        }
                        if (!StringHelper.IsNullOrEmpty((String)strName)) break;
                    }
                }
                PSDEFGroup psDEFGroup = new PSDEFGroup();
                psDEFGroup.setPSDEFGroupId(KeyValueHelper.genUniqueId((String)psDEViewBase.getPSDEId(), (String)strPredefinedParam));
                if (psDEFGroupService.get(psDEFGroup, true)) {
                    if (StringHelper.Compare((String)strPredefinedParam, (String)"_DEFAULT", (boolean)false) == 0 || StringHelper.IsNullOrEmpty((String)strName) || StringHelper.Compare((String)psDEFGroup.getPSDEFGroupName(), (String)strName, (boolean)false) == 0) continue;
                    psDEFGroup.setPSDEFGroupName(strName);
                    psDEFGroupService.update(psDEFGroup);
                    continue;
                }
                if (!StringHelper.IsNullOrEmpty((String)strName)) {
                    psDEFGroup.setPSDEFGroupName(strName);
                } else {
                    psDEFGroup.setPSDEFGroupName(strPredefinedParam);
                }
                psDEFGroup.setPSDEId(psDEViewBase.getPSDEId());
                psDEFGroup.setCodeName(strPredefinedParam);
                if (StringHelper.Compare((String)strPredefinedParam, (String)"_DEFAULT", (boolean)false) != 0) {
                    psDEFGroup.setCodeName2(strPredefinedParam);
                }
                psDEFGroup.setGroupType("FORMITEMS");
                psDEFGroup.setPSDEFormId(psDEViewCtrl.getPSDEFormId());
                try {
                    psDEFGroupService.create(psDEFGroup);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            PSCoreSysServiceBase.endImpSysModel();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            PSCoreSysServiceBase.endImpSysModel();
        }
    }

    protected void onBuildGlobalModel() throws Exception {
        ArrayList<IService> globalServiceList = new ArrayList<IService>();
        globalServiceList.add(ServiceGlobal.getService(PSDEFTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()));
        globalServiceList.add(ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()));
        String strGlobalFolder = "C:\\SRFEX_TEMP\\2019-09-14\\MODEL.global";
        for (IService iService : globalServiceList) {
            SelectCond selectCond = new SelectCond();
            ArrayList list = iService.select((ISelectCond)selectCond);
            for (Object objItem : list) {
                IEntity iEntity = (IEntity)objItem;
                if (DataObject.getIntegerValue((IDataObject)iEntity, (String)"ENABLE", (int)1) != 1 || DataObject.getIntegerValue((IDataObject)iEntity, (String)"VALIDFLAG", (int)1) != 1) continue;
                iEntity.remove("CREATEMAN");
                iEntity.remove("UPDATEMAN");
                iEntity.remove("CREATEDATE");
                iEntity.remove("UPDATEDATE");
                File folder = new File(String.format("%1$s/%2$s/%3$s", strGlobalFolder, Inflector.getInstance().pluralize((Object)iService.getDEModel().getName()).toUpperCase(), iEntity.get(iService.getDEModel().getKeyDEField().getName())));
                folder.mkdirs();
                String strFullPath = String.format("%1$s/%2$s.json", folder.getAbsolutePath(), iService.getDEModel().getName());
                String strJSONString = PSModelV2Helper.toJSONString((IEntity)iEntity, (boolean)true);
                PSModelV2Helper.writeFile((String)strFullPath, (String)strJSONString);
            }
        }
    }
}

