/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.HibernateTransaction
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.sysmodel.ISystemRuntime
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.psrt.srv.wf.entity.WFActor
 *  net.ibizsys.psrt.srv.wf.entity.WFIAAction
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.entity.WFStep
 *  net.ibizsys.psrt.srv.wf.entity.WFStepActor
 *  net.ibizsys.psrt.srv.wf.entity.WFStepData
 *  net.ibizsys.psrt.srv.wf.entity.WFStepInst
 *  net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor
 *  net.ibizsys.psrt.srv.wf.entity.WFUserAssist
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcess
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFService2
 *  net.ibizsys.pswf.core.IWFServiceWork
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFActionResult
 *  net.ibizsys.pswf.core.WFException
 *  net.ibizsys.pswf.core.WFModelGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.hibernate.Transaction
 */
package net.ibizsys.pswf.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.HibernateTransaction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.psrt.srv.wf.entity.WFActor;
import net.ibizsys.psrt.srv.wf.entity.WFIAAction;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.entity.WFStepInst;
import net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFDataCtrl;
import net.ibizsys.pswf.core.IWFDataCtrl2;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModel;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFProcRoleUser;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFService2;
import net.ibizsys.pswf.core.IWFServiceWork;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionContext;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;
import net.ibizsys.pswf.core.WFDataCtrl;
import net.ibizsys.pswf.core.WFException;
import net.ibizsys.pswf.core.WFModelGlobal;
import net.ibizsys.pswf.core.WFProcRoleUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class WFServiceBase
implements IWFService,
IWFService2 {
    private static final Log log = LogFactory.getLog(WFServiceBase.class);
    private IWFDataCtrl iWFDataCtrl = null;
    private IWFDataCtrl2 iWFDataCtrl2 = null;
    public static final int ACTORTYPE_WFACTOR = 1;
    public static final int ACTORTYPE_UDACTOR = 2;
    public static final int CLOSEFLAG_NORMAL = 0;
    public static final int CLOSEFLAG_USERCLOSE = 1;
    public static final String TAG_SRFWFIAGOTO = "SRFWFIAGOTO";
    public static final String TAG_SRFWFTIMEOUT = "SRFWFTIMEOUT";
    public static final String TAG_SRFWFSTART = "SRFWFSTART";
    public static final String TAG_SRFWFRESTART = "SRFWFRESTART";
    public static final String TAG_SRFWFROLLBACK = "SRFWFROLLBACK";
    public static final String EMBEDWFRETURN_USERCLOSE = "%%SRF_USERCLOSE%%";
    public static final String TAG_SRFWFSUSPEND = "SRFWFSUSPEND";
    public static final String TAG_SRFWFRESUME = "SRFWFRESUME";
    private IWFModel iWFModel = null;

    public void init(IWFModel iWFModel) throws Exception {
        this.iWFModel = iWFModel;
        this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFServiceBase.this.iWFDataCtrl = WFServiceBase.this.createWFDataCtrl();
                WFServiceBase.this.iWFDataCtrl.init(WFServiceBase.this.getWFModel());
                if (WFServiceBase.this.iWFDataCtrl instanceof IWFDataCtrl2) {
                    WFServiceBase.this.iWFDataCtrl2 = (IWFDataCtrl2)WFServiceBase.this.iWFDataCtrl;
                }
                return null;
            }
        });
    }

    protected IWFDataCtrl createWFDataCtrl() throws Exception {
        return new WFDataCtrl();
    }

    protected IWFModel getWFModel() {
        return this.iWFModel;
    }

    protected ISystemModel getSystemModel() {
        return this.getWFModel().getSystemModel();
    }

    public SessionFactory getSessionFactory() {
        return ((ISystemRuntime)this.getSystemModel()).getSessionFactory();
    }

    public WFActionResult start(WFActionParam wfParam) throws Exception {
        final WFActionParam wfActionParam = wfParam;
        log.debug((Object)"\u5f00\u59cb[start]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                String strLogicName;
                WFStepData stepData;
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, true);
                if (wfInstance != null) {
                    throw new WFException(1, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000001", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u5df2\u7ecf\u5b58\u5728", (Object)iEntity.get("srfdatainfo"))));
                }
                if (StringHelper.isNullOrEmpty((String)wfActionParam.getWFVersionId())) {
                    wfActionContext.setWFVersionModel(WFServiceBase.this.getWFModel().getLastWFVersionModel(wfActionParam.getWFMode()));
                } else {
                    wfActionContext.setWFVersionModel(WFServiceBase.this.getWFModel().getWFVersionModel(wfActionParam.getWFVersionId()));
                }
                if (!WFServiceBase.this.testStart(wfActionContext)) {
                    throw new WFException(2, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000002", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u542f\u52a8\u68c0\u67e5\u5931\u8d25", (Object)iEntity.get("srfdatainfo"))));
                }
                wfInstance = new WFInstance();
                wfInstance.setWFInstanceId(KeyValueHelper.genGuidEx());
                wfInstance.setWFInstanceName(StringHelper.format((String)"%1$s[%2$s]", (Object)WFServiceBase.this.getWFModel().getName(), (Object)DateHelper.toDateTimeString((Date)new Date())));
                wfInstance.setPWFInstanceId(wfActionParam.getPInstanceId());
                wfInstance.setPStepId(wfActionParam.getStepId());
                wfInstance.setWFWorkflowId(WFServiceBase.this.getWFModel().getId());
                wfInstance.setWFVersion(Integer.valueOf(wfActionContext.getWFVersionModel().getWFVersion()));
                wfInstance.setUserData(wfActionParam.getUserData());
                wfInstance.setUserData2(wfActionParam.getUserData2());
                wfInstance.setUserData3(wfActionParam.getUserData3());
                wfInstance.setUserData4(wfActionParam.getUserData4());
                wfInstance.setUserDataInfo(DataObject.getStringValue((IDataObject)iEntity, (String)"srfmajortext", null));
                wfInstance.setOrgId(DataObject.getStringValue((IDataObject)iEntity, (String)"srforgid", null));
                wfInstance.setOrgName(DataObject.getStringValue((IDataObject)iEntity, (String)"srforgname", null));
                wfInstance.setOwner(wfActionParam.getOpPersonId());
                wfInstance.setImportanceFlag(Integer.valueOf(0));
                if (!StringHelper.isNullOrEmpty((String)wfActionParam.getConnection()) && wfActionParam.getConnection().indexOf("PARALLELSUBWF") == 0) {
                    wfInstance.setParallelInst(Integer.valueOf(1));
                    wfInstance.setUserTag(wfActionParam.getConnection().substring(14));
                }
                if (wfActionParam.isSuspendMode()) {
                    wfInstance.setSuspendFlag(Integer.valueOf(1));
                }
                WFServiceBase.this.getWFDataCtrl().addWFInstance(wfActionContext, wfInstance);
                wfActionContext.setActiveWFInstance(wfInstance);
                wfActionParam.setInstanceId(wfInstance.getWFInstanceId());
                if (!DataObject.getBoolValue((Integer)wfInstance.getParallelInst(), (boolean)false)) {
                    stepData = new WFStepData();
                    strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.START", "\u542f\u52a8\u6d41\u7a0b");
                    stepData.setWFStepDataName(strLogicName);
                    stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.START");
                    stepData.setWFPLogicName(strLogicName);
                    stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.START");
                    stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                    stepData.setConnectionName(WFServiceBase.TAG_SRFWFSTART);
                    stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                    stepData.setActorId(wfActionContext.getOpPersonId());
                    stepData.setActorName(wfActionContext.getOpPersonName());
                    WFServiceBase.this.getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
                }
                if (!wfActionParam.isSuspendMode()) {
                    WFServiceBase.this.internalExecute(wfActionContext, null);
                } else {
                    stepData = new WFStepData();
                    strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.SUSPEND", "\u6d41\u7a0b\u6302\u8d77");
                    stepData.setWFStepDataName(strLogicName);
                    stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.SUSPEND");
                    stepData.setWFPLogicName(strLogicName);
                    stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.SUSPEND");
                    stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                    stepData.setConnectionName(WFServiceBase.TAG_SRFWFSUSPEND);
                    stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                    stepData.setActorId(wfActionContext.getOpPersonId());
                    stepData.setActorName(wfActionContext.getOpPersonName());
                    WFServiceBase.this.getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
                }
                return wfActionContext.createWFActionResult();
            }
        });
    }

    public WFActionResult submit(WFActionParam wfParam) throws Exception {
        final WFActionParam wfActionParam = wfParam;
        log.debug((Object)"\u5f00\u59cb[submit]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                if (!StringHelper.isNullOrEmpty((String)wfActionContext.getUserTag())) {
                    wfActionContext.getNextIAStepActorMap().clear();
                    String[] actorids = wfActionContext.getUserTag().split("[;]");
                    int i = 0;
                    while (i < actorids.length) {
                        if (!StringHelper.isNullOrEmpty((String)actorids[i])) {
                            wfActionContext.getNextIAStepActorMap().put(actorids[i], "");
                        }
                        ++i;
                    }
                }
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(3, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000003", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u4ea4\u4e92\u5904\u7406", (Object)iEntity.get("srfdatainfo"))));
                }
                if (StringHelper.compare((String)wfActionParam.getStepId(), (String)wfInstance.getActiveStepName(), (boolean)true) != 0) {
                    throw new WFException(4, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000004", new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()}, StringHelper.format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)iEntity.get("srfdatainfo"), (Object)wfActionParam.getStepId(), (Object)wfInstance.getActiveStepName())));
                }
                String strCurWFStepId = wfInstance.getActiveStepId();
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
                wfActionContext.setActiveWFInstance(wfInstance);
                wfActionContext.setWFVersionModel(iWFVersionModel);
                WFStepData stepData = new WFStepData();
                stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                stepData.setWFStepId(wfActionParam.getStepId());
                stepData.setConnectionName(wfActionParam.getConnection());
                stepData.setMemo(wfActionParam.getDescription());
                stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                boolean bNoConnection = false;
                if (curWFProcessModel instanceof IWFInteractiveProcessModel) {
                    IWFInteractiveLinkModel iWFInteractiveLinkModel;
                    IWFInteractiveProcessModel iaProcessConfig = (IWFInteractiveProcessModel)curWFProcessModel;
                    if (!StringHelper.isNullOrEmpty((String)wfActionContext.getUserTag2())) {
                        ArrayList<WFUserAssist> userAssists = new ArrayList<WFUserAssist>();
                        WFServiceBase.this.getWFDataCtrl().getWFUserAssists(wfActionContext, wfActionContext.getUserTag2(), wfActionContext.getOpPersonId(), userAssists);
                        WFUserAssist userAssist = new WFUserAssist();
                        WFServiceBase.this.getWFDataCtrl().getWFUserAssist(wfActionContext, wfActionContext.getUserTag2(), wfActionContext.getOpPersonId(), userAssist);
                        userAssists.add(userAssist);
                        if (userAssists.size() == 0) {
                            throw new WFException(5, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000005", null, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u5728\u6307\u5b9a\u7684\u4ee3\u529e\u7528\u6237\u8303\u56f4")));
                        }
                        boolean bTestOK = false;
                        for (WFUserAssist userAssist2 : userAssists) {
                            String strWFStep = userAssist2.getWFStep();
                            if (!StringHelper.isNullOrEmpty((String)strWFStep)) {
                                String[] step = strWFStep.split("[;]");
                                int i = 0;
                                while (i < step.length) {
                                    String strStep = step[i];
                                    if (StringHelper.compare((String)strStep, (String)"*", (boolean)true) == 0) {
                                        bTestOK = true;
                                        break;
                                    }
                                    if (StringHelper.compare((String)strStep, (String)iaProcessConfig.getWFStepValue(), (boolean)true) == 0) {
                                        bTestOK = true;
                                        break;
                                    }
                                    ++i;
                                }
                                if (!bTestOK) continue;
                                wfActionContext.setOpPersonId(userAssist2.getWFMajorUserId());
                                stepData.setSDParam2(userAssist2.getWFMinorUserId());
                                break;
                            }
                            bTestOK = true;
                            wfActionContext.setOpPersonId(userAssist2.getWFMajorUserId());
                            stepData.setSDParam2(userAssist2.getWFMinorUserId());
                            break;
                        }
                        if (!bTestOK) {
                            throw new WFException(6, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000006", null, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u80fd\u4e3a\u5de5\u4f5c\u7528\u6237\u4ee3\u529e\u6307\u5b9a\u4e8b\u9879")));
                        }
                    }
                    if (StringHelper.isNullOrEmpty((String)wfActionParam.getConnection())) {
                        if (wfActionParam.isTestMode()) {
                            bNoConnection = true;
                            if (iaProcessConfig.getWFInteractiveLinkModels() == null) {
                                throw new WFException(7, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000007", null, StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u4ea4\u4e92\u64cd\u4f5c")));
                            }
                            iWFInteractiveLinkModel = null;
                            Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
                            if (wfInteractiveLinkModels.hasNext()) {
                                iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
                            }
                            if (iWFInteractiveLinkModel == null) {
                                throw new WFException(7, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000007", null, StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u4ea4\u4e92\u64cd\u4f5c")));
                            }
                            String strLogicName = iWFInteractiveLinkModel.getLogicName();
                            String strLNLanResTag = iWFInteractiveLinkModel.getLNLanResTag();
                            if (!StringHelper.isNullOrEmpty((String)strLNLanResTag)) {
                                stepData.setWFActionLanResTag(strLNLanResTag);
                                strLogicName = WFServiceBase.this.getLocalization(strLNLanResTag, strLogicName);
                            }
                            stepData.setWFStepDataName(strLogicName);
                            String strWFStepName = curWFProcessModel.getName();
                            String strWFStepLanResTag = curWFProcessModel.getNameLanResTag();
                            if (!StringHelper.isNullOrEmpty((String)strWFStepLanResTag)) {
                                stepData.setWFStepLanResTag(strWFStepLanResTag);
                                strWFStepName = WFServiceBase.this.getLocalization(strWFStepLanResTag, strWFStepName);
                            }
                            stepData.setWFPLogicName(strWFStepName);
                            if (!StringHelper.isNullOrEmpty((String)iWFInteractiveLinkModel.getActionField())) {
                                String strActionValue = DataObject.getStringValue((IDataObject)iEntity, (String)iWFInteractiveLinkModel.getActionField(), null);
                                String strActionLanResTag = "";
                                if (!StringHelper.isNullOrEmpty((String)strActionValue)) {
                                    String strCodeItemLanResTag;
                                    ICodeList codeList = iWFInteractiveLinkModel.getActionCodeList();
                                    if (codeList != null && !StringHelper.isNullOrEmpty((String)(strCodeItemLanResTag = WFServiceBase.this.getCodeItemLanResTag(codeList, strActionValue = WFServiceBase.this.getCodeItemText(codeList, strActionValue))))) {
                                        stepData.setWFActionLanResTag(strActionLanResTag);
                                        strActionValue = WFServiceBase.this.getLocalization(strCodeItemLanResTag, strActionValue);
                                    }
                                    if (!StringHelper.isNullOrEmpty((String)strActionValue)) {
                                        stepData.setWFStepDataName(strActionValue);
                                    }
                                }
                            }
                            stepData.setConnectionName(iWFInteractiveLinkModel.getName());
                        }
                    } else {
                        iWFInteractiveLinkModel = iaProcessConfig.getWFInteractiveLinkModel(wfActionParam.getConnection(), true);
                        if (iWFInteractiveLinkModel != null) {
                            String strLogicName = iWFInteractiveLinkModel.getLogicName();
                            String strLNLanResTag = iWFInteractiveLinkModel.getLNLanResTag();
                            if (!StringHelper.isNullOrEmpty((String)strLNLanResTag)) {
                                stepData.setWFActionLanResTag(strLNLanResTag);
                                strLogicName = WFServiceBase.this.getLocalization(strLNLanResTag, strLogicName);
                            }
                            stepData.setWFStepDataName(strLogicName);
                            String strWFStepName = curWFProcessModel.getName();
                            String strWFStepLanResTag = curWFProcessModel.getNameLanResTag();
                            if (!StringHelper.isNullOrEmpty((String)strWFStepLanResTag)) {
                                stepData.setWFStepLanResTag(strWFStepLanResTag);
                                strWFStepName = WFServiceBase.this.getLocalization(strWFStepLanResTag, strWFStepName);
                            }
                            stepData.setWFPLogicName(strWFStepName);
                            if (!StringHelper.isNullOrEmpty((String)iWFInteractiveLinkModel.getActionField())) {
                                String strActionValue = DataObject.getStringValue((IDataObject)iEntity, (String)iWFInteractiveLinkModel.getActionField(), null);
                                String strActionLanResTag = "";
                                if (!StringHelper.isNullOrEmpty((String)strActionValue)) {
                                    String strCodeItemLanResTag;
                                    ICodeList codeList = iWFInteractiveLinkModel.getActionCodeList();
                                    if (codeList != null && !StringHelper.isNullOrEmpty((String)(strCodeItemLanResTag = WFServiceBase.this.getCodeItemLanResTag(codeList, strActionValue = WFServiceBase.this.getCodeItemText(codeList, strActionValue))))) {
                                        stepData.setWFActionLanResTag(strActionLanResTag);
                                        strActionValue = WFServiceBase.this.getLocalization(strCodeItemLanResTag, strActionValue);
                                    }
                                    if (!StringHelper.isNullOrEmpty((String)strActionValue)) {
                                        stepData.setWFStepDataName(strActionValue);
                                    }
                                }
                            }
                            if (!wfActionParam.isTestMode()) {
                                WFServiceBase.this.internalPrepareIAAddedWFStepActor(wfActionContext, iaProcessConfig, iWFInteractiveLinkModel);
                            }
                        }
                    }
                }
                stepData.setActorId(wfActionContext.getOpPersonId());
                stepData.setActorName(wfActionContext.getOpPersonName());
                if (wfActionParam.isTestMode()) {
                    WFServiceBase.this.getWFDataCtrl().testWFStepData(wfActionContext, stepData);
                    WFActionResult wfActionResult = new WFActionResult();
                    wfActionResult.setInstanceId(wfInstance.getWFInstanceId());
                    return wfActionResult;
                }
                WFServiceBase.this.getWFDataCtrl().addWFStepData(wfActionContext, stepData);
                WFServiceBase.this.getWFDataCtrl().updateCurWFStepActors(wfActionContext);
                WFIAAction iaAction = new WFIAAction();
                WFServiceBase.this.getWFDataCtrl().getWFIAAction(wfActionContext, stepData.getWFStepId(), stepData.getConnectionName(), iaAction);
                int nCount = WFServiceBase.this.getWFDataCtrl().getWFStepDataCount(wfActionContext, stepData.getWFStepId(), stepData.getConnectionName());
                boolean bGoNext = false;
                String strNextCondition = iaAction.getNextCondition();
                String[] conds = strNextCondition.split("[|]");
                if (conds.length >= 1) {
                    strNextCondition = conds[0];
                }
                if (StringHelper.compare((String)strNextCondition, (String)"UDF", (boolean)true) == 0) {
                    if (conds.length < 2) {
                        throw new WFException(18, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000018", null, StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6570\u636e\u5c5e\u6027")));
                    }
                    String strFieldName = conds[1];
                    String strDefault = "ANY";
                    if (conds.length >= 3) {
                        strDefault = conds[2];
                    }
                    if ((conds = (strNextCondition = DataObject.getStringValue((IDataObject)wfActionContext.getActiveEntity(), (String)strFieldName, (String)strDefault)).split("[|]")).length >= 1) {
                        strNextCondition = conds[0];
                    }
                }
                if (StringHelper.compare((String)strNextCondition, (String)"CUSTOM", (boolean)true) == 0) {
                    throw new WFException(19, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000019", null, StringHelper.format((String)"\u6682\u65f6\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49\u8fde\u63a5")));
                }
                boolean bRoleMode = false;
                String strRoleNextCond = "ANY";
                TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
                if (conds.length >= 2) {
                    String strRoleCond = conds[1];
                    String[] role = strRoleCond.split("[;]");
                    if (StringHelper.compare((String)role[0], (String)"ROLE", (boolean)true) == 0) {
                        bRoleMode = true;
                    }
                    if (role.length >= 2) {
                        strRoleNextCond = role[1];
                    }
                }
                if (conds.length >= 3) {
                    String strOtherIA = conds[2];
                    if (!StringHelper.isNullOrEmpty((String)(strOtherIA = strOtherIA.toUpperCase()))) {
                        String[] ias = strOtherIA.split("[;]");
                        int i = 0;
                        while (i < ias.length) {
                            if (StringHelper.compare((String)ias[i], (String)stepData.getConnectionName(), (boolean)true) != 0) {
                                otherIAMap.put(ias[i], 0);
                            }
                            ++i;
                        }
                    }
                }
                if (bRoleMode) {
                    ArrayList<WFStepActor> stepActorList = new ArrayList<WFStepActor>();
                    WFServiceBase.this.getWFDataCtrl().getWFStepActors(wfActionContext, stepData.getWFStepId(), stepActorList);
                    ArrayList stepDataList = new ArrayList();
                    WFServiceBase.this.getWFDataCtrl().getWFStepDatas(wfActionContext, stepData.getWFStepId(), stepDataList);
                    TreeMap<Object, Integer> roleCountMap = new TreeMap<Object, Integer>();
                    TreeMap<String, String> actorRoleMap = new TreeMap<String, String>();
                    for (WFStepActor wfStepActor : stepActorList) {
                        Object strRoleId = wfStepActor.getRoleId();
                        int nCurCount = 0;
                        if (roleCountMap.containsKey(strRoleId)) {
                            nCurCount = (Integer)roleCountMap.get(strRoleId);
                        }
                        roleCountMap.put(strRoleId, ++nCurCount);
                        actorRoleMap.put(wfStepActor.getActorId(), wfStepActor.getRoleId());
                    }
                    TreeMap roleStepCountMap = new TreeMap();
                    for (String strRoleId : roleCountMap.keySet()) {
                        roleStepCountMap.put(strRoleId, new TreeMap());
                    }
                    String strCurRoleId = "";
                    Iterator<Object> nCurCount = stepDataList.iterator();
                    while (nCurCount.hasNext()) {
                        WFStepData wfStepData = (WFStepData)nCurCount.next();
                        String strRoleId = (String)actorRoleMap.get(wfStepData.getActorId());
                        TreeMap roleActionMap = (TreeMap)roleStepCountMap.get(strRoleId);
                        int nCurCount2 = 0;
                        if (roleActionMap.containsKey(wfStepData.getConnectionName())) {
                            nCurCount2 = (Integer)roleActionMap.get(wfStepData.getConnectionName());
                        }
                        roleActionMap.put(wfStepData.getConnectionName(), nCurCount2 + 1);
                        if (StringHelper.compare((String)wfStepData.getActorId(), (String)stepData.getActorId(), (boolean)true) != 0) continue;
                        strCurRoleId = strRoleId;
                    }
                    nCount = 0;
                    for (Object strRoleId : roleCountMap.keySet()) {
                        if (!WFServiceBase.this.testRoleConnection(stepData.getConnectionName(), (Integer)roleCountMap.get(strRoleId), (TreeMap)roleStepCountMap.get(strRoleId), strRoleNextCond, "")) continue;
                        ++nCount;
                        if (StringHelper.compare((String)strCurRoleId, (String)strRoleId, (boolean)true) != 0) continue;
                        WFServiceBase.this.getWFDataCtrl().removeNoDataWFStepActor(wfActionContext, stepData.getWFStepId(), strCurRoleId);
                    }
                    if (StringHelper.compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
                        if (nCount > 0) {
                            bGoNext = true;
                        }
                    } else {
                        int nActionCount = -1;
                        int nRoleCount = roleCountMap.size();
                        double fPercent = 0.0;
                        if (StringHelper.compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                            nActionCount = nRoleCount;
                        } else if (strNextCondition.indexOf("%") != -1) {
                            strNextCondition = strNextCondition.replaceAll("[%]", "");
                            fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                            fPercent /= 100.0;
                        } else {
                            try {
                                nActionCount = Integer.parseInt(strNextCondition);
                            }
                            catch (Exception ex) {
                                fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                            }
                        }
                        if (nActionCount >= 1) {
                            if (nCount >= nActionCount) {
                                bGoNext = true;
                            }
                        } else if (fPercent > 0.0 && nRoleCount != 0 && (double)nCount / (double)nRoleCount >= fPercent) {
                            bGoNext = true;
                        }
                    }
                } else if (StringHelper.compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
                    if (nCount > 0) {
                        bGoNext = true;
                    }
                } else {
                    for (String strIA : otherIAMap.keySet()) {
                        int nIAActionCount = WFServiceBase.this.getWFDataCtrl().getWFStepDataCount(wfActionContext, stepData.getWFStepId(), strIA);
                        nCount += nIAActionCount;
                    }
                    int nActionCount = -1;
                    int nActorCount = WFServiceBase.this.getWFDataCtrl().getWFStepActorCount(wfActionContext, stepData.getWFStepId());
                    double fPercent = 0.0;
                    if (StringHelper.compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                        nActionCount = nActorCount;
                    } else if (strNextCondition.indexOf("%") != -1) {
                        strNextCondition = strNextCondition.replaceAll("[%]", "");
                        fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                        fPercent /= 100.0;
                    } else {
                        try {
                            nActionCount = Integer.parseInt(strNextCondition);
                        }
                        catch (Exception ex) {
                            fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                        }
                    }
                    if (nActionCount >= 1) {
                        if (nCount >= nActionCount) {
                            bGoNext = true;
                        }
                    } else if (fPercent > 0.0 && nActorCount != 0 && (double)nCount / (double)nActorCount >= fPercent) {
                        bGoNext = true;
                    }
                }
                if (bGoNext) {
                    WFStep activeStep = new WFStep();
                    activeStep.setWFStepId(stepData.getWFStepId());
                    wfActionContext.setActiveWFStep(activeStep);
                    WFServiceBase.this.internalExecuteProcess(wfActionContext, curWFProcessModel);
                    WFServiceBase.this.internalFinishProcess(wfActionContext, curWFProcessModel);
                    IWFProcessModel nextProcessConfig = wfActionContext.getWFVersionModel().getWFProcessModel(iaAction.getNextTo(), false);
                    WFServiceBase.this.internalExecute(wfActionContext, nextProcessConfig);
                    WFServiceBase.this.getWFDataCtrl().removeWFTmpStepActors(wfActionContext, strCurWFStepId);
                    wfActionContext.getNextIAStepActorMap().clear();
                    return wfActionContext.createWFActionResult();
                }
                return wfActionContext.createWFActionResult();
            }
        });
    }

    public WFActionResult close(WFActionParam wfParam) throws Exception {
        final WFActionParam wfActionParam = wfParam;
        log.debug((Object)"\u5f00\u59cb[close]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                if (!StringHelper.isNullOrEmpty((String)wfActionContext.getUserTag())) {
                    wfActionContext.getNextIAStepActorMap().clear();
                    String[] actorids = wfActionContext.getUserTag().split("[;]");
                    int i = 0;
                    while (i < actorids.length) {
                        if (!StringHelper.isNullOrEmpty((String)actorids[i])) {
                            wfActionContext.getNextIAStepActorMap().put(actorids[i], "");
                        }
                        ++i;
                    }
                }
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(20, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000020", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u518d\u6b21\u5173\u95ed", (Object)iEntity.get("srfdatainfo"))));
                }
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                wfActionContext.setActiveWFInstance(wfInstance);
                wfActionContext.setWFVersionModel(iWFVersionModel);
                String strActiveStepId = wfInstance.getActiveStepId();
                if (!WFServiceBase.this.testClose(wfActionContext)) {
                    throw new WFException(21, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000021", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u4e0d\u5141\u8bb8\u5173\u95ed", (Object)iEntity.get("srfdatainfo"))));
                }
                wfInstance.setCancelReason(wfActionParam.getDescription());
                WFServiceBase.this.getWFDataCtrl().userCloseWFInstance(wfActionContext, wfInstance);
                WFServiceBase.this.getWFDataCtrl().updateCurWFStepActors(wfActionContext);
                if (!StringHelper.isNullOrEmpty((String)wfInstance.getPWFInstanceId()) && wfActionParam.isSubmitEmbedWF()) {
                    return WFServiceBase.this.submitEmbedWorkflow(wfActionContext, wfInstance.getPWFInstanceId(), wfActionContext.getActiveEntity(), false);
                }
                WFServiceBase.this.userCloseUnfinishEmbedWorkflows(wfActionContext, strActiveStepId, false, "\u7236\u6d41\u7a0b\u5b9e\u4f8b\u5df2\u7ecf\u88ab\u5173\u95ed");
                return wfActionContext.createWFActionResult();
            }
        });
    }

    public WFActionResult restart(WFActionParam wfParam) throws Exception {
        final WFActionParam wfActionParam = wfParam;
        log.debug((Object)"\u5f00\u59cb[restart]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, true);
                if (wfInstance == null) {
                    return WFServiceBase.this.start(wfActionParam);
                }
                wfActionContext.setActiveWFInstance(wfInstance);
                IWFVersionModel lastWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getLastWFVersionModel(lastWFVersionModel.getWFMode());
                wfActionContext.setWFVersionModel(iWFVersionModel);
                if (!WFServiceBase.this.testRestart(wfActionContext)) {
                    throw new WFException(22, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000022", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u4e0d\u5141\u8bb8\u91cd\u542f", (Object)iEntity.get("srfdatainfo"))));
                }
                WFServiceBase.this.userCloseUnfinishEmbedWorkflows(wfActionContext, wfInstance.getActiveStepId(), false, "\u7236\u6d41\u7a0b\u91cd\u65b0\u542f\u52a8");
                wfInstance.setWFVersion(Integer.valueOf(iWFVersionModel.getWFVersion()));
                WFServiceBase.this.getWFDataCtrl().resetWFInstance(wfActionContext, wfInstance);
                if (!DataObject.getBoolValue((Integer)wfInstance.getParallelInst(), (boolean)false)) {
                    WFStepData stepData = new WFStepData();
                    String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.RESTART", "\u91cd\u65b0\u542f\u52a8\u6d41\u7a0b");
                    stepData.setWFStepDataName(strLogicName);
                    stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.RESTART");
                    stepData.setWFPLogicName(strLogicName);
                    stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.RESTART");
                    stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                    stepData.setConnectionName(WFServiceBase.TAG_SRFWFSTART);
                    stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                    stepData.setActorId(wfActionContext.getOpPersonId());
                    stepData.setActorName(wfActionContext.getOpPersonName());
                    WFServiceBase.this.getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
                }
                WFServiceBase.this.internalExecute(wfActionContext, null);
                return wfActionContext.createWFActionResult();
            }
        });
    }

    public WFActionResult calcNextIAProcessActor(WFActionParam wpParam) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        log.debug((Object)"\u5f00\u59cb[calcNextIAProcessActor]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(3, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000003", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u4ea4\u4e92\u5904\u7406", (Object)iEntity.get("srfdatainfo"))));
                }
                if (StringHelper.compare((String)wfActionParam.getStepId(), (String)wfInstance.getActiveStepName(), (boolean)true) != 0) {
                    throw new WFException(4, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000004", new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()}, StringHelper.format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)iEntity.get("srfdatainfo"), (Object)wfActionParam.getStepId(), (Object)wfInstance.getActiveStepName())));
                }
                String strWFStepId = wfInstance.getActiveStepId();
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
                String strNext = "";
                if (curWFProcessModel instanceof IWFInteractiveProcessModel) {
                    IWFInteractiveProcessModel iaProcessConfig = (IWFInteractiveProcessModel)curWFProcessModel;
                    IWFInteractiveLinkModel iWFInteractiveLinkModel = iaProcessConfig.getWFInteractiveLinkModel(wfActionParam.getConnection(), false);
                    strNext = iWFInteractiveLinkModel.getNext();
                }
                IWFInteractiveProcessModel nextIAProcessModel = null;
                while (!StringHelper.isNullOrEmpty((String)strNext)) {
                    IWFProcessModel nextProcessConfig = iWFVersionModel.getWFProcessModel(strNext, false);
                    if (nextProcessConfig.isTerminalProcess()) {
                        throw new WFException(23, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000023", null, StringHelper.format((String)"\u5f53\u524d\u5904\u7406\u540e\u7eed\u4e3a\u7ed3\u675f\u5904\u7406\uff0c\u4e0d\u5b58\u5728\u4ea4\u4e92\u64cd\u4f5c\u5904\u7406")));
                    }
                    if (nextProcessConfig instanceof IWFProcessModel) {
                        IWFProcessModel iWFProcessModel = nextProcessConfig;
                        strNext = WFServiceBase.this.calcWFProcessNext(wfActionContext, iWFProcessModel);
                        continue;
                    }
                    if (nextProcessConfig instanceof IWFInteractiveProcessModel) {
                        nextIAProcessModel = (IWFInteractiveProcessModel)nextProcessConfig;
                        break;
                    }
                    throw new WFException(24, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000024", null, StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5f53\u524d\u5904\u7406\u540e\u7eed\u7684\u4ea4\u4e92\u5904\u7406")));
                }
                if (nextIAProcessModel == null) {
                    throw new WFException(25, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000025", null, StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5904\u7406\u540e\u7eed\u7684\u4ea4\u4e92\u5904\u7406")));
                }
                Iterator<IWFProcRoleModel> wfProcRoleModels = nextIAProcessModel.getWFProcRoleModels();
                if (wfProcRoleModels != null) {
                    while (wfProcRoleModels.hasNext()) {
                        IWFProcRoleModel iWFProcRoleModel = wfProcRoleModels.next();
                        Iterator<IWFProcRoleUser> wfProcRoleUserModels = WFServiceBase.this.getWFProcRoleUserModels(wfActionContext, iWFProcRoleModel);
                        if (wfProcRoleUserModels == null) continue;
                        ArrayList<WFTmpStepActor> tmpStepActors = new ArrayList<WFTmpStepActor>();
                        while (wfProcRoleUserModels.hasNext()) {
                            IWFProcRoleUser iWFProcRoleUser = wfProcRoleUserModels.next();
                            WFTmpStepActor tmpStepActor = new WFTmpStepActor();
                            tmpStepActor.setWFActorId(iWFProcRoleUser.getWFUserId());
                            tmpStepActor.setWFActorName(iWFProcRoleUser.getWFUserName());
                            tmpStepActor.setPrevProcess(wfActionContext.getUserTag());
                            tmpStepActor.setPrevWFStepId(strWFStepId);
                            tmpStepActor.setConnection(wfActionParam.getConnection());
                            tmpStepActors.add(tmpStepActor);
                        }
                        WFServiceBase.this.getWFDataCtrl().addWFTmpStepActors(wfActionContext, tmpStepActors);
                    }
                }
                return wfActionContext.createWFActionResult();
            }
        });
    }

    public WFActionResult rollbackIAAction(WFActionParam wpParam) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        log.debug((Object)"\u5f00\u59cb[rollbackIAAction]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(8, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000008", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406", (Object)iEntity.get("srfdatainfo"))));
                }
                wfActionContext.setActiveWFInstance(wfInstance);
                WFStepData lastWFStepData = new WFStepData();
                WFServiceBase.this.getWFDataCtrl().getLastWFStepData(wfActionContext, lastWFStepData);
                if (StringHelper.compare((String)lastWFStepData.getActorId(), (String)wfActionContext.getOpPersonId(), (boolean)false) != 0) {
                    throw new WFException(26, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000026", null, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u5de5\u4f5c\u6d41\u6700\u540e\u4e00\u6b21\u64cd\u4f5c\u8005\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406")));
                }
                if (StringHelper.compare((String)lastWFStepData.getConnectionName(), (String)WFServiceBase.TAG_SRFWFROLLBACK, (boolean)true) == 0) {
                    throw new WFException(27, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000027", null, StringHelper.format((String)"\u65e0\u6cd5\u5bf9\u64a4\u56de\u5904\u7406\u8fdb\u884c\u518d\u64a4\u56de")));
                }
                if (StringHelper.compare((String)lastWFStepData.getConnectionName(), (String)WFServiceBase.TAG_SRFWFTIMEOUT, (boolean)true) == 0) {
                    throw new WFException(28, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000028", null, StringHelper.format((String)"\u65e0\u6cd5\u5bf9\u8d85\u65f6\u5904\u7406\u8fdb\u884c\u64a4\u56de")));
                }
                if (StringHelper.compare((String)lastWFStepData.getConnectionName(), (String)WFServiceBase.TAG_SRFWFSTART, (boolean)true) == 0) {
                    WFServiceBase.this.cancelStart(wfActionContext);
                    WFStepData stepData = new WFStepData();
                    String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.ROLLBACK", "\u6d41\u7a0b\u64a4\u56de");
                    stepData.setWFStepDataName(strLogicName);
                    stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.ROLLBACK");
                    stepData.setWFPLogicName(strLogicName);
                    stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.ROLLBACK");
                    stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                    stepData.setConnectionName(WFServiceBase.TAG_SRFWFROLLBACK);
                    stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                    stepData.setActorId(wfActionContext.getOpPersonId());
                    stepData.setActorName(wfActionContext.getOpPersonName());
                    stepData.setMemo(wfActionParam.getDescription());
                    stepData.setWFStepId(wfInstance.getActiveStepId());
                    WFServiceBase.this.getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
                    return wfActionContext.createWFActionResult();
                }
                if (StringHelper.isNullOrEmpty((String)lastWFStepData.getWFStepId())) {
                    throw new WFException(29, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000029", null, StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u4e0a\u4e00\u4e2a\u6b65\u9aa4")));
                }
                ArrayList<WFStepData> stepDataList = new ArrayList<WFStepData>();
                WFServiceBase.this.getWFDataCtrl().getWFStepDatas(wfActionContext, lastWFStepData.getWFStepId(), stepDataList);
                if (stepDataList.size() > 1) {
                    throw new WFException(30, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000030", null, StringHelper.format((String)"\u5de5\u4f5c\u6d41\u4e0a\u4e00\u4e2a\u6b65\u9aa4\u6709\u591a\u4e2a\u64cd\u4f5c\u8005\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406")));
                }
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                wfActionContext.setWFVersionModel(iWFVersionModel);
                String strWFPName = wfInstance.getActiveStepName();
                IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(strWFPName, false);
                WFStep activeStep = new WFStep();
                activeStep.setWFStepId(wfInstance.getActiveStepId());
                wfActionContext.setActiveWFStep(activeStep);
                WFServiceBase.this.internalExecuteProcess(wfActionContext, curWFProcessModel);
                WFServiceBase.this.internalFinishProcess(wfActionContext, curWFProcessModel);
                WFStepData stepData = new WFStepData();
                String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.ROLLBACK", "\u6d41\u7a0b\u64a4\u56de");
                stepData.setWFStepDataName(strLogicName);
                stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.ROLLBACK");
                stepData.setWFPLogicName(strLogicName);
                stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.ROLLBACK");
                stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                stepData.setConnectionName(WFServiceBase.TAG_SRFWFROLLBACK);
                stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                stepData.setActorId(wfActionContext.getOpPersonId());
                stepData.setActorName(wfActionContext.getOpPersonName());
                stepData.setMemo(wfActionParam.getDescription());
                stepData.setWFStepId(wfInstance.getActiveStepId());
                WFServiceBase.this.getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
                strWFPName = DataObject.getStringValue((IDataObject)lastWFStepData, (String)"WFPNAME", (String)"");
                IWFProcessModel nextProcessConfig = iWFVersionModel.getWFProcessModel(strWFPName, false);
                wfActionContext.getRollbackStepActors().clear();
                WFServiceBase.this.getWFDataCtrl().getWFStepActors(wfActionContext, lastWFStepData.getWFStepId(), wfActionContext.getRollbackStepActors());
                WFServiceBase.this.internalExecute(wfActionContext, nextProcessConfig);
                return wfActionContext.createWFActionResult();
            }
        });
    }

    public WFActionResult timeoutIAAction(WFActionParam wpParam) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        log.debug((Object)"\u5f00\u59cb[timeoutIAAction]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                boolean bIAGoto = false;
                String strConnection = wfActionParam.getConnection();
                if (StringHelper.compare((String)strConnection, (String)WFServiceBase.TAG_SRFWFIAGOTO, (boolean)true) == 0) {
                    wfActionParam.setConnection(WFServiceBase.TAG_SRFWFTIMEOUT);
                    bIAGoto = true;
                }
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(10, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000010", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u8d85\u65f6\u5904\u7406", (Object)iEntity.get("srfdatainfo"))));
                }
                wfActionContext.setActiveWFInstance(wfInstance);
                if (!bIAGoto && StringHelper.compare((String)wfActionParam.getStepId(), (String)wfInstance.getActiveStepName(), (boolean)true) != 0) {
                    throw new WFException(4, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000004", new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()}, StringHelper.format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)iEntity.get("srfdatainfo"), (Object)wfActionParam.getStepId(), (Object)wfInstance.getActiveStepName())));
                }
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                wfActionContext.setWFVersionModel(iWFVersionModel);
                IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
                WFStepData stepData = new WFStepData();
                stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                stepData.setWFStepId(wfInstance.getActiveStepName());
                stepData.setConnectionName(wfActionParam.getConnection());
                stepData.setMemo(wfActionParam.getDescription());
                stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                IWFProcessModel nextProcessConfig = null;
                if (!bIAGoto) {
                    String strTimeoutNext = "";
                    if (!curWFProcessModel.isEnableTimeout()) {
                        throw new WFException(31, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000031", new Object[]{wfInstance.getActiveStepName()}, StringHelper.format((String)"\u6307\u5b9a\u5904\u7406[%1$s]\u4e0d\u652f\u6301\u8d85\u65f6\u5904\u7406", (Object)wfInstance.getActiveStepName())));
                    }
                    strTimeoutNext = curWFProcessModel.getTimeoutNext();
                    if (StringHelper.isNullOrEmpty((String)strTimeoutNext)) {
                        throw new WFException(32, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000032", new Object[]{wfInstance.getActiveStepName()}, StringHelper.format((String)"\u6307\u5b9a\u5904\u7406[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d85\u65f6\u8def\u5f84", (Object)wfInstance.getActiveStepName())));
                    }
                    if (curWFProcessModel instanceof IWFEmbedWFProcessModelBase) {
                        WFServiceBase.this.userCloseUnfinishEmbedWorkflows(wfActionContext, wfInstance.getActiveStepId(), false, "\u7236\u6d41\u7a0b\u8d85\u65f6\u7ed3\u675f\u5f53\u524d\u6b65\u9aa4");
                    }
                    String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.TIMEOUT", "\u8d85\u65f6\u5904\u7406");
                    stepData.setWFStepDataName(strLogicName);
                    stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.TIMEOUT");
                    stepData.setWFPLogicName(strLogicName);
                    stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.TIMEOUT");
                    nextProcessConfig = iWFVersionModel.getWFProcessModel(strTimeoutNext, false);
                } else {
                    nextProcessConfig = iWFVersionModel.getWFProcessModelByWFStepValue(wfActionParam.getStepId(), false);
                    if (nextProcessConfig instanceof IWFEmbedWFProcessModelBase) {
                        WFServiceBase.this.userCloseUnfinishEmbedWorkflows(wfActionContext, wfInstance.getActiveStepId(), false, "\u7236\u6d41\u7a0b\u6b65\u9aa4\u8df3\u8f6c\u7ed3\u675f\u5f53\u524d\u6b65\u9aa4");
                    }
                    String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.GOTO", "\u6b65\u9aa4\u8df3\u8f6c\u5904\u7406");
                    stepData.setWFStepDataName(strLogicName);
                    stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.GOTO");
                    stepData.setWFPLogicName(strLogicName);
                    stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.GOTO");
                }
                stepData.setActorId(wfActionContext.getOpPersonId());
                stepData.setActorName(wfActionContext.getOpPersonName());
                WFServiceBase.this.getWFDataCtrl().addWFStepData(wfActionContext, stepData);
                WFStep activeStep = new WFStep();
                activeStep.setWFStepId(stepData.getWFStepId());
                wfActionContext.setActiveWFStep(activeStep);
                WFServiceBase.this.internalExecuteProcess(wfActionContext, curWFProcessModel);
                WFServiceBase.this.internalFinishProcess(wfActionContext, curWFProcessModel);
                WFServiceBase.this.internalExecute(wfActionContext, nextProcessConfig);
                return wfActionContext.createWFActionResult();
            }
        });
    }

    protected boolean testRoleConnection(String strConnection, int nRoleActorCount, TreeMap<String, Integer> connCountMap, String strNextCondition, String strIAUnion) throws Exception {
        int nCount = 0;
        if (connCountMap.containsKey(strConnection)) {
            nCount = connCountMap.get(strConnection);
        }
        if (StringHelper.compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
            if (nCount > 0) {
                return true;
            }
        } else {
            TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
            String strOtherIA = strIAUnion;
            if (!StringHelper.isNullOrEmpty((String)strOtherIA)) {
                strOtherIA = strOtherIA.toUpperCase();
                String[] ias = strOtherIA.split("[;]");
                int i = 0;
                while (i < ias.length) {
                    if (StringHelper.compare((String)ias[i], (String)strConnection, (boolean)true) != 0) {
                        otherIAMap.put(ias[i], 0);
                    }
                    ++i;
                }
                for (String strIA : otherIAMap.keySet()) {
                    if (!connCountMap.containsKey(strIA)) continue;
                    nCount += connCountMap.get(strIA).intValue();
                }
            }
            int nActionCount = -1;
            int nActorCount = nRoleActorCount;
            double fPercent = 0.0;
            if (StringHelper.compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                nActionCount = nActorCount;
            } else if (strNextCondition.indexOf("%") != -1) {
                strNextCondition = strNextCondition.replaceAll("[%]", "");
                fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                fPercent /= 100.0;
            } else {
                try {
                    nActionCount = Integer.parseInt(strNextCondition);
                }
                catch (Exception ex) {
                    fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                }
            }
            if (nActionCount >= 1 ? nCount >= nActionCount : fPercent > 0.0 && nActorCount != 0 && (double)nCount / (double)nActorCount >= fPercent) {
                return true;
            }
        }
        return false;
    }

    public WFActionResult resubmitAction(WFActionParam wpParam) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        log.debug((Object)"\u5f00\u59cb[resubmitAction]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                boolean bIAGoto = false;
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(11, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000011", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u5de5\u4f5c\u8f6c\u79fb", (Object)iEntity.get("srfdatainfo"))));
                }
                wfActionContext.setActiveWFInstance(wfInstance);
                if (StringHelper.compare((String)wfActionParam.getStepId(), (String)wfInstance.getActiveStepName(), (boolean)true) != 0) {
                    throw new WFException(4, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000004", new Object[]{iEntity.get("srfdatainfo"), wfActionParam.getStepId(), wfInstance.getActiveStepName()}, StringHelper.format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)iEntity.get("srfdatainfo"), (Object)wfActionParam.getStepId(), (Object)wfInstance.getActiveStepName())));
                }
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                wfActionContext.setWFVersionModel(iWFVersionModel);
                IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
                WFStepData stepData = new WFStepData();
                stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                stepData.setWFStepId(wfActionParam.getStepId());
                stepData.setActorId(wfActionContext.getOpPersonId());
                stepData.setActorName(wfActionContext.getOpPersonName());
                stepData.setMemo(wfActionParam.getDescription());
                stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                IWFInteractiveProcessModel iaProcessConfig = null;
                if (curWFProcessModel instanceof IWFInteractiveProcessModel) {
                    iaProcessConfig = (IWFInteractiveProcessModel)curWFProcessModel;
                    Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
                    if (wfInteractiveLinkModels == null) {
                        throw new WFException(7, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000007", null, StringHelper.format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u4ea4\u4e92\u64cd\u4f5c")));
                    }
                    IWFInteractiveLinkModel iWFInteractiveLinkModel = null;
                    if (wfInteractiveLinkModels.hasNext()) {
                        iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
                        String strLogicName = iWFInteractiveLinkModel.getLogicName();
                        String strLNLanResTag = iWFInteractiveLinkModel.getLNLanResTag();
                        if (!StringHelper.isNullOrEmpty((String)strLNLanResTag)) {
                            stepData.setWFActionLanResTag(strLNLanResTag);
                            strLogicName = WFServiceBase.this.getLocalization(strLNLanResTag, strLogicName);
                        }
                        stepData.setWFStepDataName(strLogicName);
                        String strWFStepName = curWFProcessModel.getName();
                        String strWFStepLanResTag = curWFProcessModel.getNameLanResTag();
                        if (!StringHelper.isNullOrEmpty((String)strWFStepLanResTag)) {
                            stepData.setWFStepLanResTag(strWFStepLanResTag);
                            strWFStepName = WFServiceBase.this.getLocalization(strWFStepLanResTag, strWFStepName);
                        }
                        stepData.setWFPLogicName(strWFStepName);
                        stepData.setWFStepLanResTag(iWFInteractiveLinkModel.getLNLanResTag());
                        if (!StringHelper.isNullOrEmpty((String)iWFInteractiveLinkModel.getActionField())) {
                            String strActionValue = DataObject.getStringValue((IDataObject)iEntity, (String)iWFInteractiveLinkModel.getActionField(), null);
                            String strActionLanResTag = "";
                            if (!StringHelper.isNullOrEmpty((String)strActionValue)) {
                                String strCodeItemLanResTag;
                                ICodeList codeList = iWFInteractiveLinkModel.getActionCodeList();
                                if (codeList != null && !StringHelper.isNullOrEmpty((String)(strCodeItemLanResTag = WFServiceBase.this.getCodeItemLanResTag(codeList, strActionValue = WFServiceBase.this.getCodeItemText(codeList, strActionValue))))) {
                                    stepData.setWFActionLanResTag(strActionLanResTag);
                                    strActionValue = WFServiceBase.this.getLocalization(strCodeItemLanResTag, strActionValue);
                                }
                                if (!StringHelper.isNullOrEmpty((String)strActionValue)) {
                                    stepData.setWFStepDataName(strActionValue);
                                }
                            }
                        }
                        stepData.setConnectionName(iWFInteractiveLinkModel.getName());
                    }
                }
                WFServiceBase.this.getWFDataCtrl().testWFStepData(wfActionContext, stepData);
                WFActor wfActor = new WFActor();
                wfActor.setWFActorId(wfActionParam.getConnection());
                WFServiceBase.this.getWFDataCtrl().getWFActor(wfActionContext, wfActor);
                String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.RESUBMIT", new Object[]{wfActor.getWFActorName()}, StringHelper.format((String)"\u5c06\u5de5\u4f5c\u8f6c\u79fb\u81f3[%1$s]", (Object)wfActor.getWFActorName()));
                stepData.setWFStepDataName(strLogicName);
                stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.RESUBMIT");
                stepData.setWFPLogicName(strLogicName);
                stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.RESUBMIT");
                stepData.setConnectionName("SRFWFRESUBMIT");
                stepData.setSDParam(wfActionParam.getConnection());
                WFServiceBase.this.getWFDataCtrl().addWFStepData(wfActionContext, stepData);
                WFServiceBase.this.getWFDataCtrl().updateCurWFStepActors(wfActionContext);
                if (iaProcessConfig != null && iaProcessConfig.isSendInform()) {
                    ArrayList<String> actors = new ArrayList<String>();
                    actors.add(wfActionParam.getConnection());
                    WFServiceBase.this.getWFDataCtrl().sendWFStepActorInformMsg(wfActionContext, actors, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
                }
                return wfActionContext.createWFActionResult();
            }
        });
    }

    protected void cancelStart(WFActionContext wfActionContext) throws Exception {
        wfActionContext.getActiveWFInstance().setCancelReason(wfActionContext.getWFActionParam().getDescription());
        String strActiveStepId = wfActionContext.getActiveWFInstance().getActiveStepId();
        this.getWFDataCtrl().cancelStartWFInstance(wfActionContext, wfActionContext.getActiveWFInstance());
        this.userCloseUnfinishEmbedWorkflows(wfActionContext, strActiveStepId, false, "\u7236\u6d41\u7a0b\u5b9e\u4f8b\u5df2\u7ecf\u88ab\u5173\u95ed");
    }

    public WFActionResult markReadFlag(WFActionParam wpParam) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        log.debug((Object)"\u5f00\u59cb[markReadFlag]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                boolean bIAGoto = false;
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(9, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000009", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u6807\u8bb0\u5df2\u8bfb\u64cd\u4f5c", (Object)iEntity.get("srfdatainfo"))));
                }
                wfActionContext.setActiveWFInstance(wfInstance);
                WFStepActor wfStepActor = new WFStepActor();
                wfStepActor.setActorId(wfActionContext.getOpPersonId());
                wfStepActor.setWFStepId(wfActionParam.getStepId());
                WFServiceBase.this.getWFDataCtrl().markWFStepActorReadFlag(wfActionContext, wfStepActor);
                return wfActionContext.createWFActionResult();
            }
        });
    }

    protected boolean testUDActor(WFActionContext wfActionContext, String strUDActorId, String strUserId) throws Exception {
        String strUDUserId = DataObject.getStringValue((IDataObject)wfActionContext.getActiveEntity(), (String)strUDActorId, null);
        if (strUDUserId == null) {
            return false;
        }
        return StringHelper.compare((String)strUDUserId, (String)strUserId, (boolean)false) == 0;
    }

    protected void internalExecute(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception {
        if (iWFProcessModel == null) {
            iWFProcessModel = wfActionContext.getWFVersionModel().getStartWFProcessModel();
        }
        if (iWFProcessModel == null) {
            throw new WFException(12, this.getLocalization("CTRL.WFSERVICE.ERR000012", null, "\u6ca1\u6709\u627e\u5230\u6d41\u7a0b\u5f00\u59cb\u8282\u70b9"));
        }
        if (iWFProcessModel.isAsynchronousProcess() && !wfActionContext.isThreadMode()) {
            WFServiceThread engineThread = new WFServiceThread(wfActionContext, iWFProcessModel);
            engineThread.start();
            return;
        }
        int nLoopCount = 0;
        do {
            this.internalPrepareProcess(wfActionContext, iWFProcessModel);
            if (iWFProcessModel.isTerminalProcess()) {
                this.internalFinishProcess(wfActionContext, iWFProcessModel);
                this.internalFinishWorkflow(wfActionContext);
                return;
            }
            if (iWFProcessModel.isSuspendProcess()) {
                return;
            }
            wfActionContext.setCurNext("");
            this.internalExecuteProcess(wfActionContext, iWFProcessModel);
            this.internalFinishProcess(wfActionContext, iWFProcessModel);
            if (StringHelper.isNullOrEmpty((String)wfActionContext.getCurNext())) {
                throw new WFException(13, this.getLocalization("CTRL.WFSERVICE.ERR000013", new Object[]{iWFProcessModel.getLogicName(), iWFProcessModel.getName()}, StringHelper.format((String)"[%1$s][%2$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9", (Object)iWFProcessModel.getLogicName(), (Object)iWFProcessModel.getName())));
            }
            iWFProcessModel = wfActionContext.getWFVersionModel().getWFProcessModel(wfActionContext.getCurNext(), false);
            if (++nLoopCount < wfActionContext.getMaxLoopCount()) continue;
            throw new WFException(14, this.getLocalization("CTRL.WFSERVICE.ERR000014", new Object[]{wfActionContext.getMaxLoopCount()}, StringHelper.format((String)"\u5904\u7406\u5df2\u7ecf\u8d85\u8fc7[%1$s]\u6b21\uff0c\u7cfb\u7edf\u4e2d\u65ad", (Object)wfActionContext.getMaxLoopCount())));
        } while (!iWFProcessModel.isAsynchronousProcess() || wfActionContext.isThreadMode());
        WFServiceThread engineThread = new WFServiceThread(wfActionContext, iWFProcessModel);
        engineThread.start();
    }

    protected void internalPrepareProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception {
        Date curDate = new Date();
        wfActionContext.setActiveWFStep(null);
        WFStep wfStep = new WFStep();
        wfStep.setWFStepId(KeyValueHelper.genGuidEx());
        wfStep.setWFInstanceId(wfActionContext.getActiveWFInstanceId());
        wfStep.setWFPName(iWFProcessModel.getId());
        String strLogicName = iWFProcessModel.getLogicName();
        String strNameLanResTag = iWFProcessModel.getNameLanResTag();
        if (!StringHelper.isNullOrEmpty((String)strNameLanResTag)) {
            wfStep.setWFStepLanResTag(strNameLanResTag);
            strLogicName = this.getLocalization(strNameLanResTag, strLogicName);
        }
        wfStep.setWFPLogicName(strLogicName);
        wfStep.setIsInteractive(Integer.valueOf(iWFProcessModel.isSuspendProcess() ? 1 : 0));
        wfStep.setWFVersion(Integer.valueOf(wfActionContext.getWFVersionModel().getWFVersion()));
        wfStep.setStartTime(new Timestamp(curDate.getTime()));
        wfStep.setWFStepName(iWFProcessModel.getWFStepValue());
        if (iWFProcessModel.isEnableTimeout()) {
            int nTimeout = iWFProcessModel.getTimeout();
            if (!StringHelper.isNullOrEmpty((String)iWFProcessModel.getTimeoutField())) {
                nTimeout = DataObject.getIntegerValue((IDataObject)wfActionContext.getActiveEntity(), (String)iWFProcessModel.getTimeoutField(), (int)nTimeout);
                log.debug((Object)StringHelper.format((String)"\u8ba1\u7b97\u5de5\u4f5c\u6d41\u8d85\u65f6\uff08\u52a8\u6001\u5c5e\u6027\uff09[%1$s]=[%2$s]", (Object)iWFProcessModel.getTimeoutField(), (Object)nTimeout));
            }
            if (nTimeout > 0) {
                Timestamp deadLine = this.getWFDataCtrl().calcTimeout(new Timestamp(curDate.getTime()), iWFProcessModel.getTimeoutType(), nTimeout, iWFProcessModel.getWorkTimeType());
                wfStep.setDeadLine(deadLine);
            }
        }
        this.getWFDataCtrl().addWFStep(wfActionContext, wfStep);
        wfActionContext.setActiveWFStep(wfStep);
        if (iWFProcessModel.isSuspendProcess()) {
            WFStepInst stepInst;
            ArrayList<WFActionParam> startWFInstances;
            this.getWFDataCtrl().updateWFUserDataRunStep(wfActionContext, iWFProcessModel.getWFStepValue());
            this.refreshUserEntity(wfActionContext);
            if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
                HashMap<String, String> wfStepActorMap = new HashMap<String, String>();
                HashMap<String, Integer> wfUserRecInformMap = new HashMap<String, Integer>();
                IWFInteractiveProcessModel iaProcessConfig = (IWFInteractiveProcessModel)iWFProcessModel;
                if (wfActionContext.getRollbackStepActors().size() > 0) {
                    for (WFStepActor lastWFStepActor : wfActionContext.getRollbackStepActors()) {
                        WFStepActor stepActor = new WFStepActor();
                        stepActor.setWFStepActorName(lastWFStepActor.getWFStepActorName());
                        stepActor.setRoleId(lastWFStepActor.getRoleId());
                        stepActor.setWFStepId(wfStep.getWFStepId());
                        stepActor.setIsReadOnly(Integer.valueOf(0));
                        stepActor.setActorId(lastWFStepActor.getActorId());
                        stepActor.setActorType(Integer.valueOf(1));
                        if (!this.getWFDataCtrl().addWFStepActor(wfActionContext, stepActor)) continue;
                        wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue((IDataObject)stepActor, (String)"RECVINFORM", (int)1));
                        wfStepActorMap.put(stepActor.getActorId(), stepActor.getActorId());
                    }
                    wfActionContext.getRollbackStepActors().clear();
                } else {
                    Iterator<String> udActors;
                    IWFInteractiveLinkModel iWFInteractiveLinkModel;
                    Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels;
                    String strActions;
                    boolean bActorIAActionControl = iaProcessConfig.isActorIAActionControl();
                    Iterator<IWFProcRoleModel> wfProcRoleModels = iaProcessConfig.getWFProcRoleModels();
                    if (wfProcRoleModels != null) {
                        while (wfProcRoleModels.hasNext()) {
                            IWFProcRoleModel iWFProcRoleModel = wfProcRoleModels.next();
                            Iterator<IWFProcRoleUser> wfProcRoleUserModels = this.getWFProcRoleUserModels(wfActionContext, iWFProcRoleModel);
                            if (wfProcRoleUserModels == null) continue;
                            while (wfProcRoleUserModels.hasNext()) {
                                IWFProcRoleUser iWFProcRoleUser = wfProcRoleUserModels.next();
                                if (wfActionContext.isEnableNextIAStepActors() && !wfActionContext.getNextIAStepActorMap().containsKey(iWFProcRoleUser.getWFUserId())) continue;
                                WFStepActor stepActor = new WFStepActor();
                                stepActor.setWFStepActorName(iWFProcRoleUser.getWFUserName());
                                stepActor.setWFStepId(wfStep.getWFStepId());
                                stepActor.setIsReadOnly(Integer.valueOf(0));
                                stepActor.setActorId(iWFProcRoleUser.getWFUserId());
                                stepActor.setActorType(Integer.valueOf(1));
                                stepActor.setRoleId(iWFProcRoleUser.getWFRoleId());
                                stepActor.set("IGNORESUBSTITUTE", iWFProcRoleUser.get("IGNORESUBSTITUTE"));
                                stepActor.set("ORIGINALWFUSERID", iWFProcRoleUser.get("ORIGINALWFUSERID"));
                                if (bActorIAActionControl) {
                                    strActions = "";
                                    wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
                                    if (wfInteractiveLinkModels != null) {
                                        while (wfInteractiveLinkModels.hasNext()) {
                                            iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
                                            if (iWFInteractiveLinkModel.isActorIAActionControl() && !iWFInteractiveLinkModel.containsWFProcRole(iWFProcRoleModel)) continue;
                                            if (!StringHelper.isNullOrEmpty((String)strActions)) {
                                                strActions = String.valueOf(strActions) + ";";
                                            }
                                            strActions = String.valueOf(strActions) + StringHelper.format((String)"(%1$s)", (Object)iWFInteractiveLinkModel.getName());
                                        }
                                    }
                                    if (StringHelper.isNullOrEmpty((String)strActions)) {
                                        strActions = "NONE";
                                    }
                                    stepActor.setIAActions(strActions);
                                }
                                if (!this.getWFDataCtrl().addWFStepActor(wfActionContext, stepActor)) continue;
                                wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue((IDataObject)stepActor, (String)"RECVINFORM", (int)1));
                                wfStepActorMap.put(iWFProcRoleUser.getWFUserId(), stepActor.getActorId());
                            }
                        }
                    }
                    if ((udActors = iaProcessConfig.getUDActors()) != null) {
                        while (udActors.hasNext()) {
                            String strFieldName = udActors.next();
                            WFStepActor stepActor = new WFStepActor();
                            stepActor.setWFStepId(wfStep.getWFStepId());
                            stepActor.setIsReadOnly(Integer.valueOf(0));
                            Object objRealUserId = wfActionContext.getActiveEntity().get(strFieldName);
                            if (objRealUserId == null) {
                                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u4ece\u7528\u6237\u6570\u636e\u4e2d\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strFieldName));
                                continue;
                            }
                            stepActor.setActorId(objRealUserId.toString());
                            stepActor.setActorType(Integer.valueOf(2));
                            if (bActorIAActionControl) {
                                strActions = "";
                                wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
                                if (wfInteractiveLinkModels != null) {
                                    while (wfInteractiveLinkModels.hasNext()) {
                                        iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
                                        if (iWFInteractiveLinkModel.isActorIAActionControl() && !iWFInteractiveLinkModel.containsUDActor(strFieldName)) continue;
                                        if (!StringHelper.isNullOrEmpty((String)strActions)) {
                                            strActions = String.valueOf(strActions) + ";";
                                        }
                                        strActions = String.valueOf(strActions) + StringHelper.format((String)"(%1$s)", (Object)iWFInteractiveLinkModel.getName());
                                    }
                                }
                                if (StringHelper.isNullOrEmpty((String)strActions)) {
                                    strActions = "NONE";
                                }
                                stepActor.setIAActions(strActions);
                            }
                            if (!this.getWFDataCtrl().addWFStepActor(wfActionContext, stepActor)) continue;
                            wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue((IDataObject)stepActor, (String)"RECVINFORM", (int)1));
                            wfStepActorMap.put(objRealUserId.toString(), stepActor.getActorId());
                        }
                    }
                }
                int nOrderFlag = 1;
                Iterator<IWFInteractiveLinkModel> wfInteractiveLinkModels = iaProcessConfig.getWFInteractiveLinkModels();
                if (wfInteractiveLinkModels != null) {
                    while (wfInteractiveLinkModels.hasNext()) {
                        IWFInteractiveLinkModel iWFInteractiveLinkModel = wfInteractiveLinkModels.next();
                        WFIAAction iaAction = new WFIAAction();
                        iaAction.setWFIAActionId(KeyValueHelper.genGuidEx());
                        iaAction.setWFStepId(wfStep.getWFStepId());
                        iaAction.setActionName(iWFInteractiveLinkModel.getName());
                        iaAction.setActionLogicName(iWFInteractiveLinkModel.getLogicName());
                        iaAction.setActionCount(Integer.valueOf(iWFInteractiveLinkModel.getActionCount()));
                        iaAction.setOrderFlag(Integer.valueOf(nOrderFlag));
                        iaAction.setNextTo(iWFInteractiveLinkModel.getNext());
                        iaAction.setNextCondition(iWFInteractiveLinkModel.getNextCondition());
                        this.getWFDataCtrl().addWFIAAction(wfActionContext, iaAction);
                        ++nOrderFlag;
                    }
                }
                if (iaProcessConfig.isSendInform()) {
                    HashMap<String, String> wfStepActorMapReal = new HashMap<String, String>();
                    for (String strActorId : wfStepActorMap.keySet()) {
                        String strRealActorId = (String)wfStepActorMap.get(strActorId);
                        if (StringHelper.isNullOrEmpty((String)strRealActorId)) {
                            strRealActorId = strActorId;
                        }
                        wfStepActorMapReal.put(strRealActorId, "");
                    }
                    ArrayList<String> actors = new ArrayList<String>();
                    for (String strActorId : wfStepActorMapReal.keySet()) {
                        Integer nRecvInform = (Integer)wfUserRecInformMap.get(strActorId);
                        if (nRecvInform != null && nRecvInform != 1) continue;
                        actors.add(strActorId);
                    }
                    this.getWFDataCtrl().sendWFStepActorInformMsg(wfActionContext, actors, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
                }
                this.getWFDataCtrl().updateCurWFStepActors(wfActionContext);
            }
            if (iWFProcessModel instanceof IWFEmbedWFProcessModel) {
                ArrayList<WFActionParam> wfParams = new ArrayList<WFActionParam>();
                this.getWFDataCtrl().getEmbedWorkflows(wfActionContext, (IWFEmbedWFProcessModel)iWFProcessModel, wfParams);
                startWFInstances = new ArrayList<WFActionParam>();
                for (WFActionParam wfParam : wfParams) {
                    wfParam.setPInstanceId(wfActionContext.getActiveWFInstanceId());
                    wfParam.setStepId(wfStep.getWFStepId());
                    wfParam.setOpPersonId(wfActionContext.getOpPersonId());
                    wfParam.setOpPersonName(wfActionContext.getOpPersonName());
                    wfParam.setWFMode(wfActionContext.getWFVersionModel().getWFMode());
                    this.startEmbedWorkflow(wfParam);
                    startWFInstances.add(wfParam);
                }
                for (WFActionParam startItem : startWFInstances) {
                    stepInst = new WFStepInst();
                    stepInst.setWFStepInstId(KeyValueHelper.genUniqueId((String)startItem.getInstanceId(), (String)wfStep.getWFStepId()));
                    stepInst.setWFInstanceId(startItem.getInstanceId());
                    stepInst.setWFStepId(wfStep.getWFStepId());
                    this.getWFDataCtrl().addWFStepInst(wfActionContext, stepInst);
                }
            }
            if (iWFProcessModel instanceof IWFParallelSubWFProcessModel) {
                ArrayList<WFActionParam> wfParams = new ArrayList<WFActionParam>();
                this.getWFDataCtrl().getParallelSubWFs(wfActionContext, (IWFParallelSubWFProcessModel)iWFProcessModel, wfParams);
                startWFInstances = new ArrayList();
                for (WFActionParam wfParam : wfParams) {
                    wfParam.setPInstanceId(wfActionContext.getActiveWFInstanceId());
                    wfParam.setStepId(wfStep.getWFStepId());
                    wfParam.setOpPersonId(wfActionContext.getOpPersonId());
                    wfParam.setOpPersonName(wfActionContext.getOpPersonName());
                    wfParam.setConnection(wfParam.getConnection());
                    wfParam.setWFMode(wfActionContext.getWFVersionModel().getWFMode());
                    this.startEmbedWorkflow(wfParam);
                    startWFInstances.add(wfParam);
                }
                for (WFActionParam startItem : startWFInstances) {
                    stepInst = new WFStepInst();
                    stepInst.setWFStepInstId(KeyValueHelper.genUniqueId((String)startItem.getInstanceId(), (String)wfStep.getWFStepId()));
                    stepInst.setWFInstanceId(startItem.getInstanceId());
                    stepInst.setWFStepId(wfStep.getWFStepId());
                    this.getWFDataCtrl().addWFStepInst(wfActionContext, stepInst);
                }
            }
        }
    }

    protected void internalFinishProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception {
        if (wfActionContext.getActiveWFStep() == null) {
            throw new WFException(15, this.getLocalization("CTRL.WFSERVICE.ERR000015", null, "\u5f53\u524d\u5904\u7406\u6b65\u9aa4\u65e0\u6548"));
        }
        WFStep wfStep = new WFStep();
        wfActionContext.getActiveWFStep().copyTo((IDataObject)wfStep, true);
        this.getWFDataCtrl().finishWFStep(wfActionContext, wfStep);
    }

    protected void internalFinishWorkflow(WFActionContext wfActionContext) throws Exception {
        this.getWFDataCtrl().finishWFInstance(wfActionContext, wfActionContext.getActiveWFInstance());
        this.getWFDataCtrl().updateCurWFStepActors(wfActionContext);
        if (!StringHelper.isNullOrEmpty((String)wfActionContext.getActiveWFInstance().getPWFInstanceId())) {
            this.refreshUserEntity(wfActionContext);
            this.submitEmbedWorkflow(wfActionContext, wfActionContext.getActiveWFInstance().getPWFInstanceId(), wfActionContext.getActiveEntity(), true);
            return;
        }
    }

    protected void internalExecuteProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception {
        IWFProcess iWFProcess = iWFProcessModel.getWFProcess();
        wfActionContext.setCurWFProcessModel(iWFProcessModel);
        iWFProcess.executeBefore((IWFActionContext)wfActionContext);
        iWFProcess.execute((IWFActionContext)wfActionContext);
        iWFProcess.executeAfter((IWFActionContext)wfActionContext);
    }

    protected void internalExecuteInteractiveProcess(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) throws Exception {
        wfActionContext.setCurNext("");
        wfActionContext.setFinishInteractiveProcess(false);
        this.internalExecuteProcess(wfActionContext, iWFProcessModel);
        if (!wfActionContext.isFinishInteractiveProcess()) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)wfActionContext.getCurNext())) {
            throw new WFException(16, this.getLocalization("CTRL.WFSERVICE.ERR000016", new Object[]{iWFProcessModel.getName()}, StringHelper.format((String)"[%1$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9", (Object)iWFProcessModel.getName())));
        }
        iWFProcessModel = wfActionContext.getWFVersionModel().getWFProcessModel(wfActionContext.getCurNext(), false);
        this.internalExecuteProcess(wfActionContext, iWFProcessModel);
    }

    protected IEntity getUserEntity(WFActionContext wfActionContext) throws Exception {
        String strUserData4 = wfActionContext.getWFActionParam().getUserData4();
        if (StringHelper.isNullOrEmpty((String)strUserData4) && wfActionContext.getActiveWFInstance() != null) {
            strUserData4 = wfActionContext.getActiveWFInstance().getUserData4();
        }
        IEntity tempDataEntity = this.getWFModel().createEntity(strUserData4);
        this.getWFDataCtrl().getWFUserEntity(wfActionContext, tempDataEntity);
        return tempDataEntity;
    }

    protected void refreshUserEntity(WFActionContext wfActionContext) throws Exception {
        String strUserData4 = wfActionContext.getWFActionParam().getUserData4();
        if (StringHelper.isNullOrEmpty((String)strUserData4) && wfActionContext.getActiveWFInstance() != null) {
            strUserData4 = wfActionContext.getActiveWFInstance().getUserData4();
        }
        IEntity tempDataEntity = this.getWFModel().createEntity(strUserData4);
        this.getWFDataCtrl().getWFUserEntity(wfActionContext, tempDataEntity);
        tempDataEntity.copyTo((IDataObject)wfActionContext.getActiveEntity(), true);
    }

    protected WFActionResult startEmbedWorkflow(WFActionParam wfParam) throws Exception {
        IWFService iWFService = WFModelGlobal.getWFModel((String)wfParam.getWorkflowId()).getWFService();
        return iWFService.start(wfParam);
    }

    protected WFActionResult closeEmbedWorkflow(WFActionParam wfParam) throws Exception {
        IWFService iWFService = WFModelGlobal.getWFModel((String)wfParam.getWorkflowId()).getWFService();
        return iWFService.close(wfParam);
    }

    protected void closeEmbedWorkflows(ArrayList<WFActionParam> wfParams, String strReason) throws Exception {
        for (WFActionParam startItem : wfParams) {
            startItem.setDescription(strReason);
            this.closeEmbedWorkflow(startItem);
        }
    }

    protected WFActionResult submitEmbedWorkflow(WFActionContext wfActionContext, String strPWFInstanceId, IEntity dataEntity, boolean bNormalClose) throws Exception {
        WFInstance pWFInstance = new WFInstance();
        pWFInstance.setWFInstanceId(strPWFInstanceId);
        this.getWFDataCtrl().getWFInstance(wfActionContext, pWFInstance, false);
        IWFService iWFService = WFModelGlobal.getWFModel((String)pWFInstance.getWFWorkflowId()).getWFService();
        WFActionParam wfParam = new WFActionParam();
        wfParam.setOpPersonId(wfActionContext.getOpPersonId());
        wfParam.setInstanceId(strPWFInstanceId);
        wfParam.setStepId(wfActionContext.getActiveWFInstance().getPStepId());
        return iWFService.submitEmbedWorkflow(wfParam, wfActionContext.getActiveWFInstance(), dataEntity, bNormalClose);
    }

    public WFActionResult submitEmbedWorkflow(WFActionParam wpParam, WFInstance childWFInstance, IEntity dataEntity, boolean bNormalClose) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        final boolean bNormalClose2 = bNormalClose;
        final IEntity dataEntity2 = dataEntity;
        final WFInstance childWFInstance2 = childWFInstance;
        log.debug((Object)"\u5f00\u59cb[submitEmbedWorkflow]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                boolean bIAGoto = false;
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                WFInstance wfInstance = new WFInstance();
                wfInstance.setWFInstanceId(wfActionParam.getInstanceId());
                wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, wfInstance, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(17, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000017", new Object[]{wfActionParam.getInstanceId()}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u63d0\u4ea4\u5904\u7406", (Object)wfActionParam.getInstanceId())));
                }
                wfActionContext.setActiveWFInstance(wfInstance);
                if (StringHelper.isNullOrEmpty((String)wfActionParam.getUserData())) {
                    wfActionParam.setUserData(wfInstance.getUserData());
                }
                if (StringHelper.isNullOrEmpty((String)wfActionParam.getUserData4())) {
                    wfActionParam.setUserData4(wfInstance.getUserData4());
                }
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                if (StringHelper.compare((String)wfActionParam.getStepId(), (String)wfInstance.getActiveStepId(), (boolean)true) != 0) {
                    throw new WFException(4, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000004", new Object[]{wfActionParam.getInstanceId(), wfActionParam.getStepId(), wfInstance.getActiveStepId()}, StringHelper.format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)wfActionParam.getInstanceId(), (Object)wfActionParam.getStepId(), (Object)wfInstance.getActiveStepId())));
                }
                String strCurWFStepId = wfInstance.getActiveStepId();
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                IWFProcessModel curWFProcessModel = iWFVersionModel.getWFProcessModel(wfInstance.getActiveStepName(), false);
                wfActionContext.setWFVersionModel(iWFVersionModel);
                String strReturnValue = WFServiceBase.this.getWFDataCtrl().getEmbedWorkflowReturnValue(wfActionContext, childWFInstance2, dataEntity2, curWFProcessModel);
                IWFEmbedWFProcessModelBase baseEmbedConfig = (IWFEmbedWFProcessModelBase)curWFProcessModel;
                WFStepInst stepInst = new WFStepInst();
                stepInst.setWFStepInstId(KeyValueHelper.genUniqueId((String)childWFInstance2.getWFInstanceId(), (String)wfActionParam.getStepId()));
                stepInst.setWFStepId(wfActionParam.getStepId());
                stepInst.setWFInstanceId(childWFInstance2.getWFInstanceId());
                if (bNormalClose2) {
                    stepInst.setCloseFlag(Integer.valueOf(0));
                    stepInst.setReturnData(strReturnValue);
                } else {
                    stepInst.setCloseFlag(Integer.valueOf(1));
                    stepInst.setReturnData(WFServiceBase.EMBEDWFRETURN_USERCLOSE);
                }
                WFServiceBase.this.getWFDataCtrl().closeWFStepInst(wfActionContext, stepInst);
                IWFEmbedWFReturnModel wfReturnConfig = baseEmbedConfig.getWFEmbedWFReturnModelByValue(stepInst.getReturnData(), false);
                int nCount = WFServiceBase.this.getWFDataCtrl().getWFStepInstCount(wfActionContext, stepInst.getWFStepId(), stepInst.getReturnData());
                boolean bGoNext = false;
                String strNextCondition = wfReturnConfig.getNextCondition();
                String[] conds = strNextCondition.split("[|]");
                if (conds.length >= 1) {
                    strNextCondition = conds[0];
                }
                TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
                if (conds.length >= 2) {
                    String strOtherIA = conds[1];
                    if (!StringHelper.isNullOrEmpty((String)(strOtherIA = strOtherIA.toUpperCase()))) {
                        String[] ias = strOtherIA.split("[;]");
                        int i = 0;
                        while (i < ias.length) {
                            if (StringHelper.compare((String)ias[i], (String)stepInst.getReturnData(), (boolean)true) != 0) {
                                otherIAMap.put(ias[i], 0);
                            }
                            ++i;
                        }
                    }
                }
                if (StringHelper.compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
                    if (nCount > 0) {
                        bGoNext = true;
                    }
                } else {
                    for (String strIA : otherIAMap.keySet()) {
                        int nIAActionCount = WFServiceBase.this.getWFDataCtrl().getWFStepInstCount(wfActionContext, stepInst.getWFStepId(), strIA);
                        nCount += nIAActionCount;
                    }
                    int nActionCount = -1;
                    int nActorCount = WFServiceBase.this.getWFDataCtrl().getWFStepInstCount(wfActionContext, stepInst.getWFStepId());
                    double fPercent = 0.0;
                    if (StringHelper.compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                        nActionCount = nActorCount;
                    } else if (strNextCondition.indexOf("%") != -1) {
                        strNextCondition = strNextCondition.replaceAll("[%]", "");
                        fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                        fPercent /= 100.0;
                    } else {
                        try {
                            nActionCount = Integer.parseInt(strNextCondition);
                        }
                        catch (Exception ex) {
                            fPercent = (Double)DataTypeHelper.testDouble((String)strNextCondition);
                        }
                    }
                    if (nActionCount >= 1) {
                        if (nCount >= nActionCount) {
                            bGoNext = true;
                        }
                    } else if (fPercent > 0.0 && nActorCount != 0 && (double)nCount / (double)nActorCount >= fPercent) {
                        bGoNext = true;
                    }
                }
                if (bGoNext) {
                    WFServiceBase.this.userCloseUnfinishEmbedWorkflows(wfActionContext, wfActionParam.getStepId(), false, "\u7236\u6d41\u7a0b\u6b65\u9aa4\u5df2\u7ecf\u7ed3\u675f");
                    WFStep activeStep = new WFStep();
                    activeStep.setWFStepId(stepInst.getWFStepId());
                    wfActionContext.setActiveWFStep(activeStep);
                    WFServiceBase.this.internalExecuteProcess(wfActionContext, curWFProcessModel);
                    WFServiceBase.this.internalFinishProcess(wfActionContext, curWFProcessModel);
                    IWFProcessModel nextProcessConfig = iWFVersionModel.getWFProcessModel(wfReturnConfig.getNext(), false);
                    WFServiceBase.this.internalExecute(wfActionContext, nextProcessConfig);
                    return wfActionContext.createWFActionResult();
                }
                return wfActionContext.createWFActionResult();
            }
        });
    }

    protected void userCloseUnfinishEmbedWorkflows(WFActionContext wfActionContext, String strActiveStepId, boolean bSubmitEmbedWF, String strDescription) throws Exception {
        ArrayList<WFStepInst> wfStepInsts = new ArrayList<WFStepInst>();
        this.getWFDataCtrl().getUnfinishedWFStepInsts(wfActionContext, strActiveStepId, wfStepInsts);
        if (wfStepInsts.size() == 0) {
            return;
        }
        for (WFStepInst wfStepInst : wfStepInsts) {
            WFInstance tempWFInst = new WFInstance();
            tempWFInst.setWFInstanceId(wfStepInst.getWFInstanceId());
            this.getWFDataCtrl().getWFInstance(wfActionContext, tempWFInst, false);
            WFActionParam wfParam = new WFActionParam();
            wfParam.setOpPersonId(wfActionContext.getOpPersonId());
            wfParam.setDescription(strDescription);
            wfParam.setWorkflowId(tempWFInst.getWFWorkflowId());
            wfParam.setInstanceId(tempWFInst.getWFInstanceId());
            wfParam.setUserData(tempWFInst.getUserData());
            wfParam.setUserData2(tempWFInst.getUserData2());
            wfParam.setUserData3(tempWFInst.getUserData3());
            wfParam.setUserData4(tempWFInst.getUserData4());
            wfParam.setSubmitEmbedWF(bSubmitEmbedWF);
            IWFService iWFService = WFModelGlobal.getWFModel((String)tempWFInst.getWFWorkflowId()).getWFService();
            iWFService.close(wfParam);
        }
    }

    protected WFActionResult doWFServiceWork(IWFServiceWork iWFServiceWork) throws Exception {
        return this.doWFServiceWork(-1, iWFServiceWork);
    }

    protected WFActionResult doWFServiceWork(int nMode, IWFServiceWork iServiceWork) throws Exception {
        long nBeginTime = System.currentTimeMillis();
        try {
            SessionFactoryManager.addRef();
            Transaction curTransaction = SessionFactoryManager.getCurrentTransaction((SessionFactory)this.getSessionFactory());
            WFActionResult wfActionResult = iServiceWork.execute((ITransaction)new HibernateTransaction(curTransaction));
            SessionFactoryManager.releaseRef((boolean)true);
            log.debug((Object)StringHelper.format((String)"\u4f5c\u4e1a \u8017\u65f6[%1$s]", (Object)(System.currentTimeMillis() - nBeginTime)));
            return wfActionResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected IWFDataCtrl getWFDataCtrl() {
        return this.iWFDataCtrl;
    }

    protected IWFDataCtrl2 getWFDataCtrl2() {
        return this.iWFDataCtrl2;
    }

    protected boolean testStart(IWFActionContext iWFActionContext) throws Exception {
        return true;
    }

    protected boolean testRestart(IWFActionContext iWFActionContext) throws Exception {
        return true;
    }

    protected boolean testClose(IWFActionContext iWFActionContext) throws Exception {
        return true;
    }

    protected String calcWFProcessNext(IWFActionContext iWFActionContext, IWFProcessModel iWFProcessModel) throws Exception {
        return null;
    }

    protected Iterator<IWFProcRoleUser> getWFProcRoleUserModels(IWFActionContext iWFActionContext, IWFProcRoleModel iWFProcRoleModel) throws Exception {
        ArrayList<IWFProcRoleUser> iWFProcRoleUserList = new ArrayList<IWFProcRoleUser>();
        Iterator<IWFRoleUser> wfRoleUsers = iWFProcRoleModel.getWFRoleUserModels(iWFActionContext);
        if (wfRoleUsers != null) {
            while (wfRoleUsers.hasNext()) {
                iWFProcRoleUserList.add(WFProcRoleUser.fromWFRoleUser(wfRoleUsers.next(), iWFProcRoleModel));
            }
        }
        return iWFProcRoleUserList.iterator();
    }

    protected Iterator<IWFProcRoleUser> getAddedWFProcRoleUserModels(IWFActionContext iWFActionContext, IWFInteractiveLinkModel iWFInteractiveLinkModel) throws Exception {
        ArrayList<IWFProcRoleUser> iWFProcRoleUserList = new ArrayList<IWFProcRoleUser>();
        Iterator<IWFRoleUser> wfRoleUsers = iWFInteractiveLinkModel.getAddedWFRoleUserModels(iWFActionContext);
        if (wfRoleUsers != null) {
            while (wfRoleUsers.hasNext()) {
                iWFProcRoleUserList.add(WFProcRoleUser.fromWFRoleUser(wfRoleUsers.next(), iWFInteractiveLinkModel.getAddedWFRoleId()));
            }
        }
        return iWFProcRoleUserList.iterator();
    }

    protected void internalPrepareIAAddedWFStepActor(WFActionContext wfActionContext, IWFInteractiveProcessModel iaProcessConfig, IWFInteractiveLinkModel wfIALinkModel) throws Exception {
        Iterator<IWFRoleUser> wfRoleUsers = wfIALinkModel.getAddedWFRoleUserModels(wfActionContext);
        if (wfRoleUsers == null) {
            return;
        }
        HashMap<String, String> wfStepActorMap = new HashMap<String, String>();
        HashMap<String, Integer> wfUserRecInformMap = new HashMap<String, Integer>();
        Iterator<IWFProcRoleUser> wfProcRoleUserModels = this.getAddedWFProcRoleUserModels(wfActionContext, wfIALinkModel);
        if (wfProcRoleUserModels != null) {
            while (wfProcRoleUserModels.hasNext()) {
                IWFProcRoleUser iWFProcRoleUser = wfProcRoleUserModels.next();
                WFStepActor stepActor = new WFStepActor();
                stepActor.setWFStepActorName(iWFProcRoleUser.getWFUserName());
                stepActor.setWFStepId(wfActionContext.getActiveWFInstance().getActiveStepId());
                stepActor.setIsReadOnly(Integer.valueOf(0));
                stepActor.setActorId(iWFProcRoleUser.getWFUserId());
                stepActor.setActorType(Integer.valueOf(1));
                stepActor.setRoleId(iWFProcRoleUser.getWFRoleId());
                stepActor.set("IGNORESUBSTITUTE", iWFProcRoleUser.get("IGNORESUBSTITUTE"));
                stepActor.set("ORIGINALWFUSERID", iWFProcRoleUser.get("ORIGINALWFUSERID"));
                if (!this.getWFDataCtrl().addWFStepActor(wfActionContext, stepActor)) continue;
                wfUserRecInformMap.put(stepActor.getActorId(), DataObject.getIntegerValue((IDataObject)stepActor, (String)"RECVINFORM", (int)1));
                wfStepActorMap.put(iWFProcRoleUser.getWFUserId(), stepActor.getActorId());
            }
        }
        if (iaProcessConfig.isSendInform()) {
            HashMap<String, String> wfStepActorMapReal = new HashMap<String, String>();
            for (String strActorId : wfStepActorMap.keySet()) {
                String strRealActorId = (String)wfStepActorMap.get(strActorId);
                if (StringHelper.isNullOrEmpty((String)strRealActorId)) {
                    strRealActorId = strActorId;
                }
                wfStepActorMapReal.put(strRealActorId, "");
            }
            ArrayList<String> actors = new ArrayList<String>();
            for (String strActorId : wfStepActorMapReal.keySet()) {
                Integer nRecvInform = (Integer)wfUserRecInformMap.get(strActorId);
                if (nRecvInform != null && nRecvInform != 1) continue;
                actors.add(strActorId);
            }
            this.getWFDataCtrl().sendWFStepActorInformMsg(wfActionContext, actors, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
        }
        this.getWFDataCtrl().updateCurWFStepActors(wfActionContext);
    }

    protected ISystemRuntime getSystemRuntime() {
        return (ISystemRuntime)this.getSystemModel();
    }

    protected String getLocalization() {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization();
        }
        return this.getSystemRuntime().getLocalization();
    }

    protected String getLocalization(String strResId, Object[] params, String strDefault) {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization(strResId, params, strDefault);
        }
        return strDefault;
    }

    protected String getLocalization(String strResId, String strDefault) {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization(strResId, null, strDefault);
        }
        return strDefault;
    }

    protected String getCodeItemText(ICodeList codelist, String strValue) {
        if (codelist != null) {
            try {
                return codelist.getCodeListText(strValue, true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strValue;
    }

    protected String getCodeItemLanResTag(ICodeList codelist, String strValue) {
        if (codelist != null) {
            try {
                ICodeItem codeItem = codelist.getCodeItem(strValue, true);
                if (codeItem != null) {
                    return codeItem.getTextLanResTag();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public WFActionResult suspend(WFActionParam wpParam) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public WFActionResult resume(WFActionParam wpParam) throws Exception {
        final WFActionParam wfActionParam = wpParam;
        log.debug((Object)"\u5f00\u59cb[markReadFlag]\u4f5c\u4e1a");
        return this.doWFServiceWork(new IWFServiceWork(){

            public WFActionResult execute(ITransaction iTransaction) throws Exception {
                WFActionContext wfActionContext = new WFActionContext();
                wfActionContext.setWFModel(WFServiceBase.this.getWFModel());
                wfActionContext.setWFActionParam(wfActionParam);
                wfActionContext.setUserTag(wfActionParam.getUserTag());
                wfActionContext.setUserTag2(wfActionParam.getUserTag2());
                wfActionContext.getReturnInfoSB().reset();
                IEntity iEntity = WFServiceBase.this.getUserEntity(wfActionContext);
                wfActionContext.setActiveEntity(iEntity);
                WFInstance wfInstance = WFServiceBase.this.getWFDataCtrl().getWFInstance(wfActionContext, null, false);
                if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
                    throw new WFException(40, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000040", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u7ee7\u7eed\u64cd\u4f5c", (Object)iEntity.get("srfdatainfo"))));
                }
                if (!DataObject.getBoolValue((Integer)wfInstance.getSuspendFlag(), (boolean)false)) {
                    throw new WFException(41, WFServiceBase.this.getLocalization("CTRL.WFSERVICE.ERR000041", new Object[]{iEntity.get("srfdatainfo")}, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u6ca1\u6709\u88ab\u6302\u8d77\uff0c\u65e0\u6cd5\u8fdb\u884c\u7ee7\u7eed\u64cd\u4f5c", (Object)iEntity.get("srfdatainfo"))));
                }
                IWFVersionModel iWFVersionModel = WFServiceBase.this.getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
                wfActionContext.setActiveWFInstance(wfInstance);
                wfActionContext.setWFVersionModel(iWFVersionModel);
                WFServiceBase.this.getWFDataCtrl2().resumeWFInstance(wfActionContext, wfInstance);
                WFStepData stepData = new WFStepData();
                String strLogicName = WFServiceBase.this.getLocalization("CTRL.WFSERVICE.STEP.RESUME", "\u6d41\u7a0b\u7ee7\u7eed");
                stepData.setWFStepDataName(strLogicName);
                stepData.setWFActionLanResTag("CTRL.WFSERVICE.STEP.RESUME");
                stepData.setWFPLogicName(strLogicName);
                stepData.setWFStepLanResTag("CTRL.WFSERVICE.STEP.RESUME");
                stepData.setWFStepDataId(KeyValueHelper.genGuidEx());
                stepData.setConnectionName(WFServiceBase.TAG_SRFWFRESUME);
                stepData.setWFInstanceId(wfInstance.getWFInstanceId());
                stepData.setActorId(wfActionContext.getOpPersonId());
                stepData.setActorName(wfActionContext.getOpPersonName());
                WFServiceBase.this.getWFDataCtrl().addRawWFStepData(wfActionContext, stepData);
                WFServiceBase.this.internalExecute(wfActionContext, null);
                return wfActionContext.createWFActionResult();
            }
        });
    }

    private class WFServiceThread
    extends Thread {
        protected IWFProcessModel iWFProcessModel = null;
        protected WFActionContext wfActionContext = null;
        protected IWebContext iWebContext = null;

        public WFServiceThread(WFActionContext wfActionContext, IWFProcessModel iWFProcessModel) {
            this.wfActionContext = wfActionContext;
            this.iWFProcessModel = iWFProcessModel;
            if (WebContext.getCurrent() != null) {
                SimpleWebContext simpleWebContext = new SimpleWebContext();
                simpleWebContext.cloneSession(WebContext.getCurrent());
                simpleWebContext.setSessionValue("SRFPERSONID", (Object)WebContext.getCurrent().getCurUserId());
                simpleWebContext.setSessionValue("SRFUSERNAME", (Object)WebContext.getCurrent().getCurUserName());
                this.iWebContext = simpleWebContext;
            }
        }

        @Override
        public void run() {
            try {
                ServiceWorkHelper.getInstance((IWebContext)this.iWebContext).execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                        WFServiceThread.this.wfActionContext.setThreadMode(true);
                        WFServiceBase.this.internalExecute(WFServiceThread.this.wfActionContext, WFServiceThread.this.iWFProcessModel);
                    }
                });
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
    }
}

