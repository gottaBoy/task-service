/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.sysmodel.ISystemRuntime
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psmsg.util.MsgTemplateHelper
 *  net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel
 *  net.ibizsys.psrt.srv.common.entity.MsgAccount
 *  net.ibizsys.psrt.srv.common.entity.MsgSendQueue
 *  net.ibizsys.psrt.srv.common.entity.MsgTemplate
 *  net.ibizsys.psrt.srv.common.service.MsgAccountService
 *  net.ibizsys.psrt.srv.common.service.MsgSendQueueService
 *  net.ibizsys.psrt.srv.common.service.MsgTemplateService
 *  net.ibizsys.psrt.srv.wf.entity.WFAction
 *  net.ibizsys.psrt.srv.wf.entity.WFActor
 *  net.ibizsys.psrt.srv.wf.entity.WFIAAction
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.entity.WFStep
 *  net.ibizsys.psrt.srv.wf.entity.WFStepActor
 *  net.ibizsys.psrt.srv.wf.entity.WFStepBase
 *  net.ibizsys.psrt.srv.wf.entity.WFStepData
 *  net.ibizsys.psrt.srv.wf.entity.WFStepInst
 *  net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor
 *  net.ibizsys.psrt.srv.wf.entity.WFUser
 *  net.ibizsys.psrt.srv.wf.entity.WFUserAssist
 *  net.ibizsys.psrt.srv.wf.entity.WFWorkList
 *  net.ibizsys.psrt.srv.wf.service.WFIAActionService
 *  net.ibizsys.psrt.srv.wf.service.WFInstanceService
 *  net.ibizsys.psrt.srv.wf.service.WFStepActorService
 *  net.ibizsys.psrt.srv.wf.service.WFStepDataService
 *  net.ibizsys.psrt.srv.wf.service.WFStepInstService
 *  net.ibizsys.psrt.srv.wf.service.WFStepService
 *  net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService
 *  net.ibizsys.psrt.srv.wf.service.WFUserService
 *  net.ibizsys.psrt.srv.wf.service.WFWorkListService
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFException
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.Session
 *  org.hibernate.SessionFactory
 *  org.hibernate.jdbc.Work
 */
package net.ibizsys.pswf.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.wf.entity.WFAction;
import net.ibizsys.psrt.srv.wf.entity.WFActor;
import net.ibizsys.psrt.srv.wf.entity.WFIAAction;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFStepBase;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.entity.WFStepInst;
import net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;
import net.ibizsys.psrt.srv.wf.service.WFIAActionService;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.psrt.srv.wf.service.WFStepInstService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFActionContext2;
import net.ibizsys.pswf.core.IWFDataCtrl;
import net.ibizsys.pswf.core.IWFDataCtrl2;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.IWFProcSubWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.WFActionContext;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

public class WFDataCtrl
implements IWFDataCtrl,
IWFDataCtrl2 {
    private static final Log log = LogFactory.getLog(WFDataCtrl.class);
    protected WFInstanceService wfInstanceService = null;
    protected WFStepDataService wfStepDataService = null;
    protected WFStepService wfStepService = null;
    protected WFStepActorService wfStepActorService = null;
    protected WFStepInstService wfStepInstService = null;
    protected WFIAActionService wfIAActionService = null;
    protected WFWorkListService wfWorkListService = null;
    protected WFUserService wfUserService = null;
    protected WFTmpStepActorService wfTmpStepActorService = null;
    protected MsgTemplateService msgTemplateService = null;
    protected MsgAccountService msgAccountService = null;
    protected MsgSendQueueService msgSendQueueService = null;
    protected IWFModel iWFModel = null;
    protected boolean bUserCandidate = true;
    protected boolean bNoLogSystem = true;
    protected static final String USER_SYSTEM = "SYSTEM";
    public static final String CONNECTION_PARALLELSUBWF = "PARALLELSUBWF";

    @Override
    public void init(IWFModel iWFModel) throws Exception {
        this.wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class);
        this.wfStepDataService = (WFStepDataService)ServiceGlobal.getService(WFStepDataService.class);
        this.wfStepService = (WFStepService)ServiceGlobal.getService(WFStepService.class);
        this.wfStepActorService = (WFStepActorService)ServiceGlobal.getService(WFStepActorService.class);
        this.wfIAActionService = (WFIAActionService)ServiceGlobal.getService(WFIAActionService.class);
        this.wfWorkListService = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class);
        this.wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class);
        this.wfTmpStepActorService = (WFTmpStepActorService)ServiceGlobal.getService(WFTmpStepActorService.class);
        this.msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class);
        this.msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class);
        this.msgSendQueueService = (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class);
        this.wfStepInstService = (WFStepInstService)ServiceGlobal.getService(WFStepInstService.class);
        this.iWFModel = iWFModel;
        this.prepareRTEnv();
    }

    protected void prepareRTEnv() throws Exception {
    }

    protected IWFModel getWFModel() {
        return this.iWFModel;
    }

    @Override
    public WFInstance getWFInstance(IWFActionContext2 iWFActionContext, WFInstance wfInstance, boolean bTryMode) throws Exception {
        String strWFInstanceId = "";
        if (wfInstance == null) {
            wfInstance = new WFInstance();
        } else {
            strWFInstanceId = wfInstance.getWFInstanceId();
        }
        if (StringHelper.isNullOrEmpty((String)strWFInstanceId)) {
            ArrayList wfInstanceList;
            wfInstance.reset();
            String strDataKey = iWFActionContext.getWFActionParam().getUserData();
            String strDEName = iWFActionContext.getWFActionParam().getUserData4();
            SelectCond selectCond = new SelectCond();
            selectCond.setConditon("WFWORKFLOWID", (Object)iWFActionContext.getWFModel().getId());
            selectCond.setConditon("USERDATA", (Object)strDataKey);
            if (!StringHelper.isNullOrEmpty((String)strDEName)) {
                selectCond.setConditon("USERDATA4", (Object)strDEName);
            }
            if ((wfInstanceList = this.wfInstanceService.select((ISelectCond)selectCond)).size() == 0) {
                if (bTryMode) {
                    return null;
                }
                throw new WFException(37, this.getLocalization("CTRL.WFSERVICE.ERR000037", null, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u4e0d\u5b58\u5728")));
            }
            WFInstance wfInst2 = null;
            for (WFInstance wfInst : wfInstanceList) {
                if (DataObject.getBoolValue((Integer)wfInst.getIsClose(), (boolean)false)) continue;
                wfInst2 = wfInst;
                break;
            }
            if (wfInst2 == null) {
                if (bTryMode) {
                    return null;
                }
                throw new WFException(36, this.getLocalization("CTRL.WFSERVICE.ERR000036", null, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u64cd\u4f5c")));
            }
            wfInst2.copyTo((IDataObject)wfInstance, false);
        } else {
            this.wfInstanceService.get((IEntity)wfInstance);
        }
        return wfInstance;
    }

    @Override
    public void getWFIAAction(IWFActionContext2 iWFActionContext, String strWFStepId, String strActionName, WFIAAction iaAction) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.set("WFSTEPID", (Object)strWFStepId);
        selectCond.set("ACTIONNAME", (Object)strActionName);
        ArrayList wfIAActionList = this.wfIAActionService.select((ISelectCond)selectCond);
        if (wfIAActionList.size() == 0) {
            throw new Exception("\u627e\u4e0d\u5230\u6307\u5b9a\u7684\u4e92\u52a8\u884c\u4e3a");
        }
        ((WFIAAction)wfIAActionList.get(0)).copyTo((IDataObject)iaAction, true);
    }

    @Override
    public void getWFUserAssist(IWFActionContext2 iWFActionContext, String strWFStepActorId, String strAssistUserId, WFUserAssist userAssist) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 getWFIAAction");
    }

    @Override
    public void getWFUserAssists(IWFActionContext2 iWFActionContext, String strWFStepActorId, String strAssistUserId, ArrayList<WFUserAssist> userAssists) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 getWFUserAssists");
    }

    @Override
    public void getWFAction(String strWFID, String strWFActionId, WFAction action) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 getWFAction");
    }

    @Override
    public int getWFStepDataCount(IWFActionContext2 iWFActionContext, String strWFStepId, String strActionName) throws Exception {
        String strSQL = StringHelper.format((String)"select count(*) as RDCOUNT from T_SRFWFSTEPDATA where  WFSTEPID='%1$s' AND UPPER(CONNECTIONNAME) = UPPER('%2$s')", (Object)strWFStepId, (Object)strActionName);
        DataObject dataObject = new DataObject();
        this.executeRawSql(strSQL, null, dataObject);
        return DataObject.getIntegerValue((IDataObject)dataObject, (String)"RDCOUNT", (int)0);
    }

    @Override
    public int getWFStepActorCount(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception {
        String strSQL = StringHelper.format((String)"select count(*) as RDCOUNT from t_srfwfSTEPACTOR where  WFSTEPID='%1$s'", (Object)strWFStepId);
        DataObject dataObject = new DataObject();
        this.executeRawSql(strSQL, null, dataObject);
        return DataObject.getIntegerValue((IDataObject)dataObject, (String)"RDCOUNT", (int)0);
    }

    @Override
    public void getWFStepActors(IWFActionContext2 iWFActionContext, String strWFStepId, ArrayList<WFStepActor> list) throws Exception {
        WFStep wfStep = new WFStep();
        wfStep.setWFStepId(strWFStepId);
        list.addAll(this.wfStepActorService.selectByWFStep((WFStepBase)wfStep));
    }

    @Override
    public void getWFStepDatas(IWFActionContext2 iWFActionContext, String strWFStepId, ArrayList<WFStepData> list) throws Exception {
        String strSql = "";
        strSql = WebConfig.getCurrent().isLowCaseSql() ? StringHelper.format((String)"select actorid,actorname,actorname2,connectionname,createdate,createman,memo,nextto,originalwfuserid,originalwfusername,sdparam,sdparam2,updatedate,updateman,userdata,userdatadesc,wfactionlanrestag,wfinstanceid,wfinstancename,wfplogicname,wfstepdataid,wfstepdataname,wfstepid,wfsteplanrestag,wfstepname from t_srfwfstepdata where wfstepid='%1$s' and (connectionname <> 'SRFWFRESUBMIT' and connectionname <> 'SRFWFTIMEOUT')", (Object)strWFStepId) : StringHelper.format((String)"select * from t_srfwfSTEPDATA where WFSTEPID='%1$s' AND (CONNECTIONNAME <> 'SRFWFRESUBMIT' AND CONNECTIONNAME <> 'SRFWFTIMEOUT')", (Object)strWFStepId);
        this.executeRawSql(strSql, null, list, WFStepData.class);
    }

    @Override
    public int getWFStepRoleCount(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 getWFStepRoleCount");
    }

    @Override
    public void removeNoDataWFStepActor(IWFActionContext2 iWFActionContext, String strWFStepId, String strRoleId) throws Exception {
        String strSQL = StringHelper.format((String)"UPDATE T_SRFWFWORKLIST SET CANCELFLAG=1,UPDATEDATE=? WHERE WFSTEPID = ? AND WFINSTANCEID=? and cancelflag=0  AND WFACTORID IN (SELECT t.ACTORID FROM t_srfwfstepactor t WHERE t.ROLEID= ? AND t.WFSTEPID= ?)");
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addDateTime((Object)DateHelper.getCurTime());
        sqlParamList.addString(strWFStepId);
        sqlParamList.addString(iWFActionContext.getActiveWFInstanceId());
        sqlParamList.addString(strRoleId);
        sqlParamList.addString(strWFStepId);
        this.executeRawSql(strSQL, sqlParamList);
    }

    @Override
    public void getWFUserEntity(IWFActionContext2 iWFActionContext, IEntity iEntity) throws Exception {
        IDEField orgNameDEField;
        String strDataKey = iWFActionContext.getWFActionParam().getUserData();
        String strDEName = iWFActionContext.getWFActionParam().getUserData4();
        if ((StringHelper.isNullOrEmpty((String)strDataKey) || StringHelper.isNullOrEmpty((String)strDEName)) && iWFActionContext.getActiveWFInstance() != null) {
            strDataKey = iWFActionContext.getActiveWFInstance().getUserData();
            strDEName = iWFActionContext.getActiveWFInstance().getUserData4();
        }
        IDataEntityModel iDataEntityModel = iWFActionContext.getWFModel().getSystemModel().getDataEntityModel(strDEName);
        IService iService = iDataEntityModel.getService();
        iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)strDataKey);
        iService.get(iEntity);
        String strDataInfo = iDataEntityModel.getDataInfo(iEntity);
        iEntity.set("srfdatainfo", (Object)StringHelper.format((String)"%1$s|%2$s", (Object)iDataEntityModel.getLogicName(), (Object)strDataInfo));
        iEntity.set("srfmajortext", (Object)strDataInfo);
        IDEField orgIdDEField = iDataEntityModel.getDEFieldByPDT("ORGID", true);
        if (orgIdDEField != null) {
            iEntity.set("srforgid", iEntity.get(orgIdDEField.getName()));
        }
        if ((orgNameDEField = iDataEntityModel.getDEFieldByPDT("ORGNAME", true)) != null) {
            iEntity.set("srforgname", iEntity.get(orgNameDEField.getName()));
        }
    }

    @Override
    public void updateWFUserDataRunStep(IWFActionContext2 iWFActionContext, String strWFStepValue) throws Exception {
        String strWFActorsField;
        WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, wfInstance.getWFWorkflowId(), wfInstance.getUserData4());
        IDEWF iDEWF = null;
        String strWFStepColumnName = "";
        iDEWF = iDEModel.getDEWF(wfInstance.getWFWorkflowId());
        strWFStepColumnName = iDEWF.getWFStepField();
        IEntity iEntity = iDEModel.createEntity();
        iEntity.set(iDEModel.getKeyDEField().getName(), (Object)wfInstance.getUserData());
        iEntity.set(strWFStepColumnName, (Object)strWFStepValue);
        if (iDEWF != null && !StringHelper.isNullOrEmpty((String)(strWFActorsField = iDEWF.getWFActorsField()))) {
            iEntity.set(strWFActorsField, (Object)"");
        }
        IService deDataCtrl = iDEModel.getService();
        deDataCtrl.updateWFInfo(IService.UPDATEWFINFOMODE_UPDATESTATE.intValue(), (IWFActionContext)iWFActionContext, iEntity);
    }

    protected IDataEntityModel getUserDataDEModel(IWFActionContext2 iWFActionContext, String strWFWorkflowId, String strDEName) throws Exception {
        IDataEntityModel iDataEntityModel = iWFActionContext.getWFModel().getSystemModel().getDataEntityModel(strDEName);
        return iDataEntityModel;
    }

    @Override
    public void addWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        String strWFIdDEF;
        String strWFVerDEF;
        String strUDStateDEF;
        String strWFStateDEF;
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
        IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());
        DataObject.getBoolValue((Integer)instance.getParallelInst(), (boolean)false);
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        IService udService = iDEModel.getService();
        udService.get(dataEntity);
        instance.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        instance.setStartTime(new Timestamp(new Date().getTime()));
        this.wfInstanceService.create((IEntity)instance);
        dataEntity.reset();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        String strWFInstDEF = iDEWF.getWFInstField();
        if (!StringHelper.isNullOrEmpty((String)strWFInstDEF)) {
            dataEntity.set(strWFInstDEF, (Object)instance.getWFInstanceId());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStateDEF = iDEWF.getWFStateField()))) {
            dataEntity.set(strWFStateDEF, (Object)1);
        }
        if (!StringHelper.isNullOrEmpty((String)(strUDStateDEF = iDEWF.getUDStateField())) && !StringHelper.isNullOrEmpty((String)iDEWF.getEntityWFState())) {
            dataEntity.set(strUDStateDEF, (Object)iDEWF.getEntityWFState());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFVerDEF = iDEWF.getWFVerField()))) {
            dataEntity.set(strWFVerDEF, (Object)instance.getWFVersion());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFIdDEF = iDEWF.getWorkflowField()))) {
            dataEntity.set(strWFIdDEF, (Object)instance.getWFWorkflowId());
        }
        udService.updateWFInfo(IService.UPDATEWFINFOMODE_INIT.intValue(), (IWFActionContext)iWFActionContext, dataEntity);
    }

    @Override
    public void finishWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        this.wfInstanceService.get((IEntity)instance);
        if (DataObject.getBoolValue((Integer)instance.getIsClose(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u5b8c\u6210");
        }
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(instance.getWFInstanceId());
        wfInstance.setEndTime(new Timestamp(new Date().getTime()));
        wfInstance.setIsClose(Integer.valueOf(1));
        wfInstance.setIsFinish(Integer.valueOf(1));
        wfInstance.setActiveStepId(null);
        wfInstance.setActiveStepName(null);
        this.wfInstanceService.update((IEntity)wfInstance);
        wfInstance.copyTo((IDataObject)instance, true);
        this.cancelSendWFStepActorInformMsg(iWFActionContext, instance);
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
        IService iService = iDEModel.getService();
        DataObject.getBoolValue((Integer)instance.getParallelInst(), (boolean)false);
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)iDEWF.getWFInstField())) {
            dataEntity.set(iDEWF.getWFInstField(), null);
        }
        if (!StringHelper.isNullOrEmpty((String)iDEWF.getWFStateField())) {
            dataEntity.set(iDEWF.getWFStateField(), (Object)2);
        }
        if (!StringHelper.isNullOrEmpty((String)iDEWF.getWFActorsField())) {
            dataEntity.set(iDEWF.getWFActorsField(), null);
        }
        if (!StringHelper.isNullOrEmpty((String)iDEWF.getWFStepField())) {
            dataEntity.set(iDEWF.getWFStepField(), null);
        }
        iService.updateWFInfo(IService.UPDATEWFINFOMODE_FINISH.intValue(), (IWFActionContext)iWFActionContext, dataEntity);
    }

    @Override
    public void resetWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        String strWFIdDEF;
        String strWFVerDEF;
        String strUDStateDEF;
        String strWFStateDEF;
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
        IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());
        int nversion = instance.getWFVersion();
        this.wfInstanceService.get((IEntity)instance);
        if (DataObject.getBoolValue((Integer)instance.getIsClose(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u91cd\u7f6e");
        }
        this.cancelSendWFStepActorInformMsg(iWFActionContext, instance);
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(instance.getWFInstanceId());
        wfInstance.setEndTime(new Timestamp(new Date().getTime()));
        wfInstance.setIsClose(Integer.valueOf(0));
        wfInstance.setIsFinish(Integer.valueOf(0));
        wfInstance.setIsError(Integer.valueOf(0));
        wfInstance.setErrorInfo(null);
        wfInstance.setActiveStepId(null);
        wfInstance.setActiveStepName(null);
        wfInstance.setWFVersion(Integer.valueOf(nversion));
        wfInstance.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        this.wfInstanceService.update((IEntity)wfInstance);
        wfInstance.copyTo((IDataObject)instance, true);
        this.cancelOnResetWFInstance(instance);
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        IService udService = iDEModel.getService();
        udService.get(dataEntity);
        dataEntity.reset();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        String strWFInstDEF = iDEWF.getWFInstField();
        if (!StringHelper.isNullOrEmpty((String)strWFInstDEF)) {
            dataEntity.set(strWFInstDEF, (Object)instance.getWFInstanceId());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStateDEF = iDEWF.getWFStateField()))) {
            dataEntity.set(strWFStateDEF, (Object)1);
        }
        if (!StringHelper.isNullOrEmpty((String)(strUDStateDEF = iDEWF.getUDStateField())) && !StringHelper.isNullOrEmpty((String)iDEWF.getEntityWFState())) {
            dataEntity.set(strUDStateDEF, (Object)iDEWF.getEntityWFState());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFVerDEF = iDEWF.getWFVerField()))) {
            dataEntity.set(strWFVerDEF, (Object)instance.getWFVersion());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFIdDEF = iDEWF.getWorkflowField()))) {
            dataEntity.set(strWFIdDEF, (Object)instance.getWFWorkflowId());
        }
        udService.updateWFInfo(IService.UPDATEWFINFOMODE_INIT.intValue(), (IWFActionContext)iWFActionContext, dataEntity);
    }

    protected void cancelOnResetWFInstance(WFInstance wfInstance) throws Exception {
        this.wfWorkListService.cancelByWFInstance(wfInstance);
    }

    @Override
    public void errorWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 errorWFInstance");
    }

    @Override
    public void removeWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 removeWFInstance");
    }

    @Override
    public void userCloseWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        String strWFStateDEF;
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
        IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());
        this.cancelSendWFStepActorInformMsg(iWFActionContext, instance);
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(instance.getWFInstanceId());
        wfInstance.setEndTime(new Timestamp(new Date().getTime()));
        wfInstance.setIsClose(Integer.valueOf(1));
        wfInstance.setIsCancel(Integer.valueOf(1));
        wfInstance.setIsError(Integer.valueOf(0));
        wfInstance.setCancelReason(instance.getCancelReason());
        wfInstance.setActiveStepId(null);
        wfInstance.setActiveStepName(null);
        wfInstance.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        this.wfInstanceService.update((IEntity)wfInstance);
        wfInstance.copyTo((IDataObject)instance, true);
        this.cancelOnUserCloseWFInstance(instance);
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        IService udService = iDEModel.getService();
        udService.get(dataEntity);
        dataEntity.reset();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        String strWFInstDEF = iDEWF.getWFInstField();
        if (!StringHelper.isNullOrEmpty((String)strWFInstDEF)) {
            dataEntity.set(strWFInstDEF, null);
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStateDEF = iDEWF.getWFStateField()))) {
            dataEntity.set(strWFStateDEF, (Object)31);
        }
        udService.updateWFInfo(IService.UPDATEWFINFOMODE_CANCEL.intValue(), (IWFActionContext)iWFActionContext, dataEntity);
    }

    protected void cancelOnUserCloseWFInstance(WFInstance wfInstance) throws Exception {
        this.wfWorkListService.cancelByWFInstance(wfInstance);
    }

    @Override
    public void addWFStep(IWFActionContext2 iWFActionContext, WFStep step) throws Exception {
        if (StringHelper.isNullOrEmpty((String)step.getWFStepName())) {
            step.setWFStepName("step");
        }
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(step.getWFInstanceId());
        this.wfInstanceService.get((IEntity)wfInstance);
        String strFromWFStepId = wfInstance.getActiveStepId();
        if (!StringHelper.isNullOrEmpty((String)strFromWFStepId)) {
            WFStep wfStep = new WFStep();
            wfStep.setWFStepId(strFromWFStepId);
            this.wfStepService.get((IEntity)wfStep);
            if (!DataObject.getBoolValue((Integer)wfStep.getIsFinish(), (boolean)false)) {
                throw new Exception("\u4e0a\u4e00\u4e2a\u6b65\u9aa4\u8fd8\u672a\u5b8c\u6210");
            }
        }
        int nTraceStep = 1;
        nTraceStep = wfInstance.getTraceStep() == null ? 1 : wfInstance.getTraceStep() + 1;
        step.setIsFinish(Integer.valueOf(0));
        step.setTraceStep(Integer.valueOf(nTraceStep));
        step.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        this.wfStepService.create((IEntity)step);
        wfInstance.reset();
        wfInstance.setWFInstanceId(step.getWFInstanceId());
        wfInstance.setActiveStepId(step.getWFStepId());
        wfInstance.setActiveStepName(step.getWFPName());
        wfInstance.setTraceStep(Integer.valueOf(nTraceStep));
        wfInstance.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        this.wfInstanceService.update((IEntity)wfInstance, false);
    }

    @Override
    public void addWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception {
        SqlParamList sqlParamList;
        String strSQL;
        WFUser wfUser;
        ArrayList wfStepActorList;
        SelectCond selectCond;
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(stepData.getWFInstanceId());
        this.wfInstanceService.get((IEntity)wfInstance);
        if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
            throw new WFException(36, this.getLocalization("CTRL.WFSERVICE.ERR000036", null, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u64cd\u4f5c")));
        }
        if (StringHelper.compare((String)wfInstance.getActiveStepName(), (String)stepData.getWFStepId(), (boolean)true) != 0) {
            throw new Exception("\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u6267\u884c\u6b65\u9aa4\u4e0d\u76f8\u7b26");
        }
        WFIAAction wfIAAction = null;
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) != 0 && StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFTIMEOUT", (boolean)true) != 0) {
            selectCond = new SelectCond();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTIONNAME", (Object)stepData.getConnectionName());
            ArrayList wfIAActionList = this.wfIAActionService.select((ISelectCond)selectCond);
            if (wfIAActionList.size() == 0) {
                throw new Exception("\u627e\u4e0d\u5230\u6307\u5b9a\u7684\u4e92\u52a8\u884c\u4e3a");
            }
            wfIAAction = (WFIAAction)wfIAActionList.get(0);
        }
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFTIMEOUT", (boolean)true) != 0) {
            selectCond = new SelectCond();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTORID", (Object)stepData.getActorId());
            selectCond.setFetchFirst(true);
            wfStepActorList = this.wfStepActorService.select((ISelectCond)selectCond);
            if (wfStepActorList.size() == 0) {
                throw new Exception("\u7528\u6237\u65e0\u6cd5\u6267\u884c\u5f53\u524d\u6b65\u9aa4\uff0c\u4e0d\u5728\u53ef\u6267\u884c\u7528\u6237\u7684\u8303\u56f4\u5185");
            }
            WFStepActor wfStepActor = (WFStepActor)wfStepActorList.get(0);
            stepData.setOriginalWFUserId(wfStepActor.getOriginalWFUserId());
            stepData.setOriginalWFUserName(wfStepActor.getOriginalWFUserName());
            selectCond.reset();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTORID", (Object)stepData.getActorId());
            ArrayList wfStepDataList = this.wfStepDataService.select((ISelectCond)selectCond);
            for (WFStepData wfStepData : wfStepDataList) {
                if (StringHelper.compare((String)wfStepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) == 0) continue;
                throw new Exception("\u7528\u6237\u5df2\u7ecf\u5b8c\u6210\u4e86\u5f53\u524d\u6b65\u9aa4\u7684\u64cd\u4f5c\uff0c\u65e0\u6cd5\u518d\u6b21\u5b8c\u6210");
            }
        }
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) == 0) {
            selectCond = new SelectCond();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTORID", (Object)stepData.getSDParam());
            wfStepActorList = this.wfStepActorService.select((ISelectCond)selectCond);
            if (wfStepActorList.size() > 0) {
                throw new Exception("\u65e0\u6cd5\u8f6c\u79fb\u5de5\u4f5c\u5230\u6307\u5b9a\u7528\u6237\uff0c\u8be5\u7528\u6237\u5df2\u7ecf\u5b58\u5728\u6b64\u9879\u5de5\u4f5c");
            }
        }
        stepData.setWFStepId(wfInstance.getActiveStepId());
        if (StringHelper.isNullOrEmpty((String)stepData.getActorName()) && StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFTIMEOUT", (boolean)true) != 0) {
            wfUser = new WFUser();
            wfUser.setWFUserId(stepData.getActorId());
            this.wfUserService.get((IEntity)wfUser);
            stepData.setActorName(wfUser.getWFUserName());
        }
        if (!StringHelper.isNullOrEmpty((String)stepData.getSDParam2()) && StringHelper.isNullOrEmpty((String)stepData.getActorName2())) {
            wfUser = new WFUser();
            wfUser.setWFUserId(stepData.getSDParam2());
            this.wfUserService.get((IEntity)wfUser);
            stepData.setActorName2(wfUser.getWFUserName());
        }
        this.wfStepDataService.create((IEntity)stepData);
        wfInstance.reset();
        wfInstance.setLastActorId(stepData.getActorId());
        wfInstance.setLastAction(stepData.getWFStepDataName());
        wfInstance.setLastWFStepId(stepData.getWFStepId());
        wfInstance.setWFInstanceId(stepData.getWFInstanceId());
        this.wfInstanceService.update((IEntity)wfInstance, false);
        this.cancelOnAddWFStepData(stepData);
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) == 0) {
            strSQL = StringHelper.format((String)"update t_SRFWFSTEPACTOR set ACTORID=?,READFLAG=NULL,FIRSTREADTIME=NULL where (WFSTEPID = ? AND ACTORID = ? ) ");
            sqlParamList = new SqlParamList();
            sqlParamList.addString(stepData.getSDParam());
            sqlParamList.addString(stepData.getWFStepId());
            sqlParamList.addString(stepData.getActorId());
            this.executeRawSql(strSQL, sqlParamList);
        } else if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFTIMEOUT", (boolean)true) != 0) {
            strSQL = StringHelper.format((String)"update t_SRFWFSTEPACTOR set ISFINISH=1 ,FINISHDATE=%1$s where (WFSTEPID = ? AND ACTORID = ? ) ", (Object)this.getDBDialect().getFuncSQL("CURDATETIME", false, null));
            sqlParamList = new SqlParamList();
            sqlParamList.addString(stepData.getWFStepId());
            sqlParamList.addString(stepData.getActorId());
            this.executeRawSql(strSQL, sqlParamList);
        }
    }

    protected void cancelOnAddWFStepData(WFStepData stepData) throws Exception {
        this.wfWorkListService.cancelByWFStepData(stepData);
    }

    @Override
    public void testWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception {
        SelectCond selectCond;
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(stepData.getWFInstanceId());
        this.wfInstanceService.get((IEntity)wfInstance);
        if (DataObject.getBoolValue((Integer)wfInstance.getIsClose(), (boolean)false)) {
            throw new WFException(36, this.getLocalization("CTRL.WFSERVICE.ERR000036", null, StringHelper.format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u64cd\u4f5c")));
        }
        if (StringHelper.compare((String)wfInstance.getActiveStepName(), (String)stepData.getWFStepId(), (boolean)true) != 0) {
            throw new Exception("\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u6267\u884c\u6b65\u9aa4\u4e0d\u76f8\u7b26");
        }
        WFIAAction wfIAAction = null;
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) != 0 && StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFTIMEOUT", (boolean)true) != 0) {
            selectCond = new SelectCond();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTIONNAME", (Object)stepData.getConnectionName());
            ArrayList wfIAActionList = this.wfIAActionService.select((ISelectCond)selectCond);
            if (wfIAActionList.size() == 0) {
                throw new Exception("\u627e\u4e0d\u5230\u6307\u5b9a\u7684\u4e92\u52a8\u884c\u4e3a");
            }
            wfIAAction = (WFIAAction)wfIAActionList.get(0);
        }
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFTIMEOUT", (boolean)true) != 0) {
            selectCond = new SelectCond();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTORID", (Object)stepData.getActorId());
            ArrayList wfStepActorList = this.wfStepActorService.select((ISelectCond)selectCond);
            if (wfStepActorList.size() == 0) {
                throw new Exception("\u7528\u6237\u65e0\u6cd5\u6267\u884c\u5f53\u524d\u6b65\u9aa4\uff0c\u4e0d\u5728\u53ef\u6267\u884c\u7528\u6237\u7684\u8303\u56f4\u5185");
            }
            selectCond.reset();
            selectCond.set("WFSTEPID", (Object)wfInstance.getActiveStepId());
            selectCond.set("ACTORID", (Object)stepData.getActorId());
            ArrayList wfStepDataList = this.wfStepDataService.select((ISelectCond)selectCond);
            if (wfStepActorList.size() != 0) {
                for (WFStepData wfStepData : wfStepDataList) {
                    if (StringHelper.compare((String)wfStepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) == 0) continue;
                    throw new Exception("\u7528\u6237\u5df2\u7ecf\u5b8c\u6210\u4e86\u5f53\u524d\u6b65\u9aa4\u7684\u64cd\u4f5c\uff0c\u65e0\u6cd5\u518d\u6b21\u5b8c\u6210");
                }
            }
        }
    }

    @Override
    public void finishWFStep(IWFActionContext2 iWFActionContext, WFStep step) throws Exception {
        WFStep wfStep2 = new WFStep();
        wfStep2.setWFStepId(step.getWFStepId());
        this.wfStepService.get((IEntity)wfStep2);
        if (DataObject.getBoolValue((Integer)wfStep2.getIsFinish(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u5df2\u7ecf\u5b8c\u6210\uff0c\u65e0\u6cd5\u518d\u6b21\u5b8c\u6210");
        }
        wfStep2.reset();
        wfStep2.setIsFinish(Integer.valueOf(1));
        wfStep2.setEndTime(new Timestamp(new Date().getTime()));
        wfStep2.setWFStepId(step.getWFStepId());
        this.wfStepService.update((IEntity)wfStep2);
        wfStep2.copyTo((IDataObject)step, true);
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(step.getWFInstanceId());
        wfInstance.setActiveStepId(null);
        wfInstance.setActiveStepName(null);
        this.wfInstanceService.update((IEntity)wfInstance);
        this.cancelOnFinishWFStep(wfStep2);
    }

    protected void cancelOnFinishWFStep(WFStep step) throws Exception {
        this.wfWorkListService.cancelByWFStep(step);
    }

    @Override
    public boolean addWFStepActor(IWFActionContext2 iWFActionContext, WFStepActor stepActor) throws Exception {
        String strWFLanResTag;
        WFActionContext wfActionContext;
        WFStep wfStep;
        stepActor.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        stepActor.setOriginalWFUserId(null);
        stepActor.setOriginalWFUserName(null);
        boolean bRecvInform = true;
        boolean bIgnoreCandidate = DataObject.getBoolValue((IDataObject)stepActor, (String)"IGNORESUBSTITUTE", (Boolean)false);
        if (this.bUserCandidate && !bIgnoreCandidate) {
            WFUser wfUser = this.reCalcRecvWorkWFUser(stepActor.getActorId());
            if (wfUser != null) {
                if (StringHelper.compare((String)wfUser.getWFUserId(), (String)stepActor.getActorId(), (boolean)true) != 0) {
                    stepActor.setOriginalWFUserId(stepActor.getActorId());
                    stepActor.setOriginalWFUserName(stepActor.getWFStepActorName());
                    stepActor.setActorId(wfUser.getWFUserId());
                    stepActor.setWFStepActorName(wfUser.getWFUserName());
                    bRecvInform = DataObject.getBoolValue((Integer)wfUser.getRecvInform(), (boolean)true);
                }
            } else {
                return false;
            }
        }
        WFStepActor stepActor2 = new WFStepActor();
        this.wfStepActorService.fillEntityKeyValue((IEntity)stepActor);
        stepActor2.setWFStepActorId(stepActor.getWFStepActorId());
        boolean bUpdate = this.wfStepActorService.get((IEntity)stepActor2, true);
        if (bUpdate) {
            if (!DataObject.getBoolValue((Integer)stepActor2.getIsFinish(), (boolean)false)) {
                return false;
            }
            stepActor.setIsFinish(null);
            stepActor.setFinishDate(null);
            stepActor.setFirstReadTime(null);
            stepActor.setReminderCount(null);
            SelectCond selectCond = new SelectCond();
            selectCond.reset();
            selectCond.set("WFSTEPID", (Object)stepActor2.getWFStepId());
            selectCond.set("ACTORID", (Object)stepActor2.getActorId());
            ArrayList wfStepDataList = this.wfStepDataService.select((ISelectCond)selectCond);
            for (WFStepData wfStepData : wfStepDataList) {
                if (StringHelper.compare((String)wfStepData.getConnectionName(), (String)"SRFWFRESUBMIT", (boolean)true) == 0) continue;
                WFStepData wfStepData2 = new WFStepData();
                wfStepData2.setConnectionName("SRFWFRESUBMIT");
                wfStepData2.setNextTo(wfStepData.getConnectionName());
                wfStepData2.setWFStepDataId(wfStepData.getWFStepDataId());
                this.wfStepDataService.update((IEntity)wfStepData2, false);
            }
        }
        if (bUpdate) {
            this.wfStepActorService.update((IEntity)stepActor, false);
        } else {
            this.wfStepActorService.create((IEntity)stepActor, false);
        }
        stepActor.set("RECVINFORM", (Object)(bRecvInform ? 1 : 0));
        WFWorkList wfWorkList = new WFWorkList();
        wfWorkList.setWFInstanceId(iWFActionContext.getActiveWFInstanceId());
        wfWorkList.setWFWorkListName(stepActor.getWFStepActorName());
        wfWorkList.setWFActorId(stepActor.getActorId());
        wfWorkList.setWFStepId(stepActor.getWFStepId());
        wfWorkList.setWFInstanceName(iWFActionContext.getActiveWFInstance().getWFInstanceName());
        wfWorkList.setWFStepName(stepActor.getWFStepName());
        wfWorkList.setUserData(iWFActionContext.getActiveWFInstance().getUserData());
        wfWorkList.setUserData2(iWFActionContext.getActiveWFInstance().getUserData2());
        wfWorkList.setUserData3(iWFActionContext.getActiveWFInstance().getUserData3());
        wfWorkList.setUserData4(iWFActionContext.getActiveWFInstance().getUserData4());
        wfWorkList.setOriginalWFUserId(stepActor.getOriginalWFUserId());
        wfWorkList.setOriginalWFUserName(stepActor.getOriginalWFUserName());
        if (iWFActionContext.getActiveEntity() != null) {
            wfWorkList.setUserDataInfo(DataObject.getStringValue((Object)iWFActionContext.getActiveEntity().get("srfmajortext")));
        }
        wfWorkList.setWFInstanceName(iWFActionContext.getActiveWFInstance().getWFInstanceName());
        wfWorkList.setWFWorkflowId(iWFActionContext.getActiveWFInstance().getWFWorkflowId());
        wfWorkList.setWFWorkflowName(iWFActionContext.getActiveWFInstance().getWFWorkflowName());
        if (iWFActionContext instanceof WFActionContext && (wfStep = (wfActionContext = (WFActionContext)iWFActionContext).getActiveWFStep()) != null && !StringHelper.isNullOrEmpty((String)wfStep.getWFStepLanResTag())) {
            wfWorkList.setWFStepLanResTag(wfStep.getWFStepLanResTag());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFLanResTag = this.getWFModel().getNameLanResTag()))) {
            wfWorkList.setWFLanResTag(strWFLanResTag);
        }
        this.wfWorkListService.create((IEntity)wfWorkList, false);
        return true;
    }

    @Override
    public void addWFIAAction(IWFActionContext2 iWFActionContext, WFIAAction iaAction) throws Exception {
        iaAction.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        this.wfIAActionService.create((IEntity)iaAction);
    }

    @Override
    public void addWFTmpStepActors(IWFActionContext2 iWFActionContext, ArrayList<WFTmpStepActor> tmpStepActors) throws Exception {
        HashMap<String, WFTmpStepActor> wfTmpStepActorMap = new HashMap<String, WFTmpStepActor>();
        for (WFTmpStepActor tmpStepActor : tmpStepActors) {
            tmpStepActor.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
            if (this.bUserCandidate) {
                WFUser wfUser = this.reCalcRecvWorkWFUser(tmpStepActor.getWFActorId());
                if (wfUser == null) continue;
                if (StringHelper.compare((String)wfUser.getWFUserId(), (String)tmpStepActor.getWFActorId(), (boolean)true) != 0) {
                    tmpStepActor.setWFActorId(wfUser.getWFUserId());
                    tmpStepActor.setWFTmpStepActorName(wfUser.getWFUserName());
                }
            }
            if (wfTmpStepActorMap.containsKey(tmpStepActor.getWFActorId())) continue;
            this.wfTmpStepActorService.create((IEntity)tmpStepActor);
            wfTmpStepActorMap.put(tmpStepActor.getWFActorId(), tmpStepActor);
        }
    }

    @Override
    public void removeWFTmpStepActors(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception {
        String strSQL = StringHelper.format((String)"delete from T_SRFWFTMPSTEPACTOR where PREVWFSTEPID='%1$s'", (Object)strWFStepId);
        this.executeRawSql(strSQL, null);
    }

    @Override
    public void sendWFStepActorInformMsg(IWFActionContext2 iWFActionContext, ArrayList<String> actors, String strMsgTemplateId, int nMsgType) throws Exception {
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
        IService iService = iDEModel.getService();
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)iWFActionContext.getActiveWFInstance().getUserData());
        iService.get(dataEntity);
        MsgTemplate msgTemplate = new MsgTemplate();
        msgTemplate.setMsgTemplateId(strMsgTemplateId);
        if (!this.msgTemplateService.get((IEntity)msgTemplate, true)) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u6d88\u606f\u6a21\u677f[%1$s]\u5931\u8d25", (Object)strMsgTemplateId));
        }
        boolean bMailGroupSend = DataObject.getBoolValue((Integer)msgTemplate.getMailGroupSend(), (boolean)false);
        String strMailAddress = "";
        ArrayList<MsgSendQueue> msqs = new ArrayList<MsgSendQueue>();
        MsgAccount msgAccount = new MsgAccount();
        for (String strActorId : actors) {
            MsgSendQueue msq;
            msgAccount.setMsgAccountId(strActorId);
            if (!this.msgAccountService.get((IEntity)msgAccount, true)) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25", (Object)strActorId));
            }
            if ((nMsgType & MsgTypeCodeListModel.INTERNAL) != 0) {
                msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.INTERNAL, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, (MsgAccount)msgAccount, (String)USER_SYSTEM);
                msq.setDstUsers(msgAccount.getMsgAccountId());
                msq.setIsError(Integer.valueOf(0));
                msq.setIsSend(Integer.valueOf(0));
                msqs.add(msq);
            }
            if ((nMsgType & MsgTypeCodeListModel.EMAIL) != 0) {
                if (!bMailGroupSend) {
                    msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.EMAIL, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, (MsgAccount)msgAccount, (String)USER_SYSTEM);
                    msq.setDstAddresses(msgAccount.getMailAddress());
                    msq.setIsError(Integer.valueOf(0));
                    msq.setIsSend(Integer.valueOf(0));
                    msqs.add(msq);
                } else {
                    if (!StringHelper.isNullOrEmpty((String)strMailAddress)) {
                        strMailAddress = String.valueOf(strMailAddress) + ";";
                    }
                    strMailAddress = String.valueOf(strMailAddress) + msgAccount.getMailAddress();
                }
            }
            if ((nMsgType & MsgTypeCodeListModel.MSN) != 0) {
                msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.MSN, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, (MsgAccount)msgAccount, (String)USER_SYSTEM);
                msq.setDstAddresses(msgAccount.getMsnEmail());
                msq.setIsError(Integer.valueOf(0));
                msq.setIsSend(Integer.valueOf(0));
                msqs.add(msq);
            }
            if ((nMsgType & MsgTypeCodeListModel.SAIM) != 0) {
                msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.SAIM, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, (MsgAccount)msgAccount, (String)USER_SYSTEM);
                msq.setDstUsers(strActorId);
                msq.setIsError(Integer.valueOf(0));
                msq.setIsSend(Integer.valueOf(0));
                String strValue = "wfinstance:" + iWFActionContext.getActiveWFInstanceId();
                msq.setUserData(strValue);
                msq.setUserData3("1001");
                msqs.add(msq);
            }
            if ((nMsgType & MsgTypeCodeListModel.SMS) != 0) {
                msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.SMS, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, (MsgAccount)msgAccount, (String)USER_SYSTEM);
                msq.setDstAddresses(msgAccount.getMobile());
                msq.setIsError(Integer.valueOf(0));
                msq.setIsSend(Integer.valueOf(0));
                msqs.add(msq);
            }
            if ((nMsgType & MsgTypeCodeListModel.WT) == 0) continue;
            msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.WT, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, (MsgAccount)msgAccount, (String)USER_SYSTEM);
            msq.setDstAddresses(msgAccount.getWXAddr());
            msq.setDstUsers(strActorId);
            msq.setIsError(Integer.valueOf(0));
            msq.setIsSend(Integer.valueOf(0));
            msq.setUserData(iWFActionContext.getActiveWFInstanceId());
            msq.setUserData2(iWFActionContext.getWFModel().getWXAccountId());
            msq.setUserData3(iWFActionContext.getWFModel().getWXEntAppId());
            msqs.add(msq);
        }
        if ((nMsgType & MsgTypeCodeListModel.EMAIL) != 0 && bMailGroupSend) {
            MsgSendQueue msq = MsgTemplateHelper.getMsgSendQueue((int)MsgTypeCodeListModel.EMAIL, (MsgTemplate)msgTemplate, (IEntity)dataEntity, null, null, (String)USER_SYSTEM);
            msq.setDstAddresses(strMailAddress);
            msq.setIsError(Integer.valueOf(0));
            msq.setIsSend(Integer.valueOf(0));
            msqs.add(msq);
        }
        for (MsgSendQueue msq : msqs) {
            try {
                this.msgSendQueueService.create((IEntity)msq, false);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u4fdd\u5b58\u6d88\u606f\u5f02\u6b65\u961f\u5217\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()));
            }
        }
    }

    protected void createMsgSendQueue(MsgSendQueue msq) throws Exception {
        this.msgSendQueueService.create((IEntity)msq, false);
    }

    @Override
    public Timestamp calcTimeout(Timestamp srcTime, String strTimeoutType, int nAmount, String strWorkdayType) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(srcTime);
        if (StringHelper.compare((String)strTimeoutType, (String)"MINUTE", (boolean)true) == 0) {
            calendar.add(13, nAmount * 60);
        } else if (StringHelper.compare((String)strTimeoutType, (String)"HOUR", (boolean)true) == 0) {
            calendar.add(10, nAmount);
        } else if (StringHelper.compare((String)strTimeoutType, (String)"DAY", (boolean)true) == 0) {
            calendar.add(5, nAmount);
        } else {
            if (StringHelper.compare((String)strTimeoutType, (String)"WORKDAY", (boolean)true) == 0) {
                throw new Exception("\u672a\u5b9e\u73b0 [\u5de5\u4f5c\u65e5] \u8d85\u65f6\u65f6\u95f4");
            }
            throw new Exception("\u6ca1\u6709\u8d85\u65f6\u7c7b\u578b");
        }
        return new Timestamp(calendar.getTime().getTime());
    }

    @Override
    public void testIAAction(String strStepId, String strActionName, String strOpPersonId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 testIAAction");
    }

    @Override
    public void execRawSql(String strSQL) throws Exception {
        this.executeRawSql(strSQL, null);
    }

    @Override
    public void getWFActor(IWFActionContext2 iWFActionContext, WFActor wfActor) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 getWFActor");
    }

    @Override
    public void getWFSystemUser(IWFActionContext2 iWFActionContext, String strActorId, ArrayList<WFUser> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 getWFSystemUser");
    }

    @Override
    public boolean testStartWF(IWFActionContext2 iWFActionContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 testStartWF");
    }

    @Override
    public boolean testRestartWF(IWFActionContext2 iWFActionContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 testRestartWF");
    }

    @Override
    public boolean testCancelWF(IWFActionContext2 iWFActionContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 testCancelWF");
    }

    @Override
    public void getEmbedWorkflows(IWFActionContext2 iWFActionContext, IWFEmbedWFProcessModel iWFEmbedWorkflowModel, ArrayList<WFActionParam> wfParams) throws Exception {
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
        IService iService = iDEModel.getService();
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)iWFActionContext.getActiveWFInstance().getUserData());
        Iterator<IWFProcSubWFModel> wfProcSubWFModels = iWFEmbedWorkflowModel.getWFProcSubWFModels();
        if (wfProcSubWFModels != null) {
            while (wfProcSubWFModels.hasNext()) {
                IWFProcSubWFModel iWFProcSubWFModel = wfProcSubWFModels.next();
                IDataEntityModel embedWFDEModel = DEModelGlobal.getDEModel((String)iWFProcSubWFModel.getDEName());
                IService embedWFDEService = embedWFDEModel.getService();
                DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
                deDataSetFetchContext.setPageSize(9999);
                deDataSetFetchContext.setActiveDataObject((ISimpleDataObject)dataEntity);
                DBFetchResult dbFetchResult = embedWFDEService.fetchDataSet(iWFProcSubWFModel.getDEDSName(), (IDEDataSetFetchContext)deDataSetFetchContext);
                IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
                int nCachedRowCount = iDataTable.getCachedRowCount();
                int i = 0;
                while (i < nCachedRowCount) {
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    WFActionParam wfParam = new WFActionParam();
                    wfParam.setWorkflowId(iWFProcSubWFModel.getWFId());
                    wfParam.setUserData(DataObject.getStringValue((Object)iDataRow.get(embedWFDEModel.getKeyDEField().getName()), null));
                    wfParam.setUserData4(embedWFDEModel.getId());
                    wfParam.setSuspendMode(iWFProcSubWFModel.isSuspendDefault());
                    wfParams.add(wfParam);
                    ++i;
                }
            }
        }
    }

    @Override
    public void getParallelSubWFs(IWFActionContext2 iWFActionContext, IWFParallelSubWFProcessModel iWFParallelSubWFModel, ArrayList<WFActionParam> wfParams) throws Exception {
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, iWFActionContext.getActiveWFInstance().getWFWorkflowId(), iWFActionContext.getActiveWFInstance().getUserData4());
        IService iService = iDEModel.getService();
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)iWFActionContext.getActiveWFInstance().getUserData());
        Iterator<IWFProcSubWFModel> wfProcSubWFModels = iWFParallelSubWFModel.getWFProcSubWFModels();
        if (wfProcSubWFModels != null) {
            while (wfProcSubWFModels.hasNext()) {
                IWFProcSubWFModel iWFProcSubWFModel = wfProcSubWFModels.next();
                IDataEntityModel embedWFDEModel = DEModelGlobal.getDEModel((String)iWFProcSubWFModel.getDEName());
                IService embedWFDEService = embedWFDEModel.getService();
                DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
                deDataSetFetchContext.setPageSize(9999);
                deDataSetFetchContext.setActiveDataObject((ISimpleDataObject)dataEntity);
                DBFetchResult dbFetchResult = embedWFDEService.fetchDataSet(iWFProcSubWFModel.getDEDSName(), (IDEDataSetFetchContext)deDataSetFetchContext);
                IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
                int nCachedRowCount = iDataTable.getCachedRowCount();
                int i = 0;
                while (i < nCachedRowCount) {
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    WFActionParam wfParam = new WFActionParam();
                    wfParam.setWorkflowId(iWFProcSubWFModel.getWFId());
                    wfParam.setWFVersionId(iWFProcSubWFModel.getWFVerId());
                    wfParam.setUserData(DataObject.getStringValue((Object)iDataRow.get(embedWFDEModel.getKeyDEField().getName()), null));
                    wfParam.setUserData2(iWFActionContext.getActiveWFInstance().getUserData());
                    wfParam.setUserData3(iWFActionContext.getActiveWFInstance().getUserData4());
                    wfParam.setUserData4(embedWFDEModel.getId());
                    wfParam.setConnection("PARALLELSUBWF:" + iWFProcSubWFModel.getWFId());
                    wfParams.add(wfParam);
                    ++i;
                }
            }
        }
    }

    @Override
    public void addWFStepInst(IWFActionContext2 iWFActionContext, WFStepInst wfStepInst) throws Exception {
        wfStepInst.remove("CLOSEFLAG");
        wfStepInst.remove("RETURNDATA");
        this.wfStepInstService.create((IEntity)wfStepInst);
    }

    @Override
    public void closeWFStepInst(IWFActionContext2 iWFActionContext, WFStepInst wfStepInst) throws Exception {
        this.wfStepInstService.update((IEntity)wfStepInst);
    }

    @Override
    public int getWFStepInstCount(IWFActionContext2 iWFActionContext, String strWFStepId, String strReturnValue) throws Exception {
        String strSql = StringHelper.format((String)"select count(*) as RDCOUNT from t_srfwfSTEPINST where WFSTEPID='%1$s' AND CLOSEFLAG IS NOT NULL AND RETURNDATA ='%2$s'", (Object)strWFStepId, (Object)strReturnValue);
        SimpleEntity simpleEntity = new SimpleEntity();
        this.executeRawSql(strSql, null, (DataObject)simpleEntity);
        return DataObject.getIntegerValue((IDataObject)simpleEntity, (String)"RDCOUNT", (int)0);
    }

    @Override
    public int getWFStepInstCount(IWFActionContext2 iWFActionContext, String strWFStepId) throws Exception {
        String strSql = StringHelper.format((String)"select count(*) as RDCOUNT from t_srfwfSTEPINST where WFSTEPID='%1$s' ", (Object)strWFStepId);
        SimpleEntity simpleEntity = new SimpleEntity();
        this.executeRawSql(strSql, null, (DataObject)simpleEntity);
        return DataObject.getIntegerValue((IDataObject)simpleEntity, (String)"RDCOUNT", (int)0);
    }

    @Override
    public void getUnfinishedWFStepInsts(IWFActionContext2 iWFActionContext, String strWFStepId, ArrayList<WFStepInst> stepInsts) throws Exception {
        String strSql = "";
        strSql = WebConfig.getCurrent().isLowCaseSql() ? StringHelper.format((String)"select closeflag,createdate,createman,returndata,updatedate,updateman,wfinstanceid,wfinstancename,wfstepid,wfstepinstid,wfstepinstname,wfsteplanrestag,wfstepname  from t_srfwfstepinst where wfstepid='%1$s' and closeflag is  null ", (Object)strWFStepId) : StringHelper.format((String)"select *  from t_srfwfSTEPINST where WFSTEPID='%1$s' AND CLOSEFLAG IS  NULL ", (Object)strWFStepId);
        this.executeRawSql(strSql, null, stepInsts, WFStepInst.class);
    }

    @Override
    public void updateCurWFStepActors(IWFActionContext2 iWFActionContext) throws Exception {
        WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, wfInstance.getWFWorkflowId(), wfInstance.getUserData4());
        IDEWF iDEWF = iDEModel.getDEWF(this.getWFModel().getId());
        if (StringHelper.isNullOrEmpty((String)iDEWF.getWFActorsField())) {
            return;
        }
        String strSQL = "";
        SqlParamList callParamList = new SqlParamList();
        strSQL = "select t1.WFSTEPID,t1.WFSTEPACTORID,t1.WFSTEPACTORNAME,t2.WFUSERNAME,t2.WFUSERID,t3.WFINSTANCEID from t_srfwfstepactor t1 INNER JOIN T_SRFWFUSER t2 ON t1.ACTORID = t2.WFUSERID INNER JOIN T_SRFWFINSTANCE t3 ON t1.WFSTEPID = t3.ACTIVESTEPID AND  (t3.ISCLOSE IS  NULL OR t3.ISCLOSE <> 1) AND  t3.WFINSTANCEID = ? LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=t1.ACTORID and  t5.WFSTEPID = t3.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT')  where t5.WFSTEPDATAID IS NULL ";
        callParamList.addString(wfInstance.getWFInstanceId());
        ArrayList wfUserList = new ArrayList();
        this.executeRawSql(strSQL, callParamList, wfUserList, null);
        String strCurWFStepActors = "";
        HashMap userMap = new HashMap();
        for (DataObject wfUser : wfUserList) {
            if (this.bNoLogSystem && StringHelper.compare((String)DataObject.getStringValue((Object)wfUser.get("WFUSERID"), (String)""), (String)USER_SYSTEM, (boolean)true) == 0) continue;
            String strStepActorName = DataObject.getStringValue((Object)wfUser.get("WFSTEPACTORNAME"), (String)"");
            String strUserName = DataObject.getStringValue((Object)wfUser.get("WFUSERNAME"), (String)"");
            String strStepActorId = DataObject.getStringValue((Object)wfUser.get("WFUSERID"), (String)"");
            String strCurWFStepActor = "";
            strCurWFStepActor = StringHelper.compare((String)strStepActorName, (String)strUserName, (boolean)true) == 0 || StringHelper.compare((String)strStepActorName, (String)"WFSTEPACTORNAME", (boolean)true) == 0 ? strUserName : StringHelper.format((String)"(%1$s)%2$s", (Object)strStepActorName, (Object)strUserName);
            if (userMap.containsKey(strCurWFStepActor)) continue;
            if (!StringHelper.isNullOrEmpty((String)strCurWFStepActors)) {
                strCurWFStepActors = String.valueOf(strCurWFStepActors) + ",";
            }
            strCurWFStepActors = String.valueOf(strCurWFStepActors) + strCurWFStepActor;
        }
        IEntity userData = iDEModel.createEntity();
        userData.set(iDEModel.getKeyDEField().getName(), (Object)wfInstance.getUserData());
        userData.set(iDEWF.getWFActorsField(), (Object)strCurWFStepActors);
        userData.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        IService iService = iDEModel.getService();
        iService.updateWFInfo(IService.UPDATEWFINFOMODE_UPDATESTATE.intValue(), (IWFActionContext)iWFActionContext, userData);
    }

    @Override
    public void markWFStepActorReadFlag(IWFActionContext2 iWFActionContext, WFStepActor wfStepActor) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0 markWFStepActorReadFlag");
    }

    @Override
    public String getEmbedWorkflowReturnValue(IWFActionContext2 iWFActionContext, WFInstance childWFInstance2, IEntity dataEntity, IWFProcessModel iWFProcessModel) throws Exception {
        String strDEName = childWFInstance2.getUserData4();
        if (StringHelper.isNullOrEmpty((String)strDEName)) {
            this.wfInstanceService.get((IEntity)childWFInstance2);
            strDEName = childWFInstance2.getUserData4();
        }
        IDataEntityModel iEntityModel = DEModelGlobal.getDEModel((String)strDEName);
        IDEWF iDEWF = iEntityModel.getDEWF(childWFInstance2.getWFWorkflowId());
        return DataObject.getStringValue((Object)dataEntity.get(iDEWF.getWFRetField()), null);
    }

    @Override
    public void addRawWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception {
        stepData.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        if (StringHelper.compare((String)stepData.getConnectionName(), (String)"SRFWFSTART", (boolean)true) == 0) {
            WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
            IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, wfInstance.getWFWorkflowId(), wfInstance.getUserData4());
            IDEWF iDEWF = iDEModel.getDEWF(wfInstance.getWFWorkflowId());
            if (StringHelper.isNullOrEmpty((String)stepData.getWFStepDataName())) {
                String strWFStartName = iDEWF.getWFStartName();
                if (StringHelper.isNullOrEmpty((String)strWFStartName)) {
                    strWFStartName = "\u542f\u52a8\u6d41\u7a0b";
                }
                stepData.setWFStepDataName(strWFStartName);
            }
        }
        if (StringHelper.isNullOrEmpty((String)stepData.getActorName())) {
            WFUser wfUser = new WFUser();
            wfUser.setWFUserId(stepData.getActorId());
            if (this.wfUserService.get((IEntity)wfUser, true)) {
                stepData.setActorName(wfUser.getWFUserName());
            } else {
                stepData.setActorName("\u672a\u77e5\u7528\u6237");
            }
        }
        this.wfStepDataService.create((IEntity)stepData);
    }

    @Override
    public void getLastWFStepData(IWFActionContext2 iWFActionContext, WFStepData stepData) throws Exception {
        WFInstance wfInstance = iWFActionContext.getActiveWFInstance();
        String strSQL = "";
        strSQL = WebConfig.getCurrent().isLowCaseSql() ? StringHelper.format((String)"select t1.actorid,t1.actorname,t1.actorname2,t1.connectionname,t1.createdate,t1.createman,t1.memo,t1.nextto,t1.originalwfuserid,t1.originalwfusername,t1.sdparam,t1.sdparam2,t1.updatedate,t1.updateman,t1.userdata,t1.userdatadesc,t1.wfactionlanrestag,t1.wfinstanceid,t1.wfinstancename,t1.wfplogicname,t1.wfstepdataid,t1.wfstepdataname,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,t2.wfpname from t_srfwfstepdata t1  left join t_srfwfstep t2 on t1.wfstepid = t2.wfstepid   where t1.wfinstanceid='%1$s'  order by t1.updatedate desc", (Object)wfInstance.getWFInstanceId()) : StringHelper.format((String)"SELECT T1.*,T2.WFPNAME FROM T_SRFWFSTEPDATA T1  LEFT JOIN T_SRFWFSTEP T2 ON T1.WFSTEPID = T2.WFSTEPID   WHERE T1.WFINSTANCEID='%1$s'  ORDER BY T1.UPDATEDATE DESC", (Object)wfInstance.getWFInstanceId());
        this.executeRawSql(strSQL, null, (DataObject)stepData);
    }

    @Override
    public void cancelStartWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        String strWFStepDEF;
        String strWFStateDEF;
        IDataEntityModel iDEModel = this.getUserDataDEModel(iWFActionContext, instance.getWFWorkflowId(), instance.getUserData4());
        IDEWF iDEWF = iDEModel.getDEWF(instance.getWFWorkflowId());
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(instance.getWFInstanceId());
        wfInstance.setEndTime(new Timestamp(new Date().getTime()));
        wfInstance.setIsClose(Integer.valueOf(1));
        wfInstance.setIsCancel(Integer.valueOf(1));
        wfInstance.setIsError(Integer.valueOf(0));
        wfInstance.setCancelReason(instance.getCancelReason());
        wfInstance.setActiveStepId(null);
        wfInstance.setActiveStepName(null);
        wfInstance.set("SRF_PERSONID", (Object)iWFActionContext.getOpPersonId());
        this.wfInstanceService.update((IEntity)wfInstance);
        wfInstance.copyTo((IDataObject)instance, true);
        this.cancelOnCancelStartWFInstance(instance);
        this.cancelSendWFStepActorInformMsg(iWFActionContext, instance);
        IEntity dataEntity = iDEModel.createEntity();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        IService udService = iDEModel.getService();
        udService.get(dataEntity);
        dataEntity.reset();
        dataEntity.set(iDEModel.getKeyDEField().getName(), (Object)instance.getUserData());
        String strWFInstDEF = iDEWF.getWFInstField();
        if (!StringHelper.isNullOrEmpty((String)strWFInstDEF)) {
            dataEntity.set(strWFInstDEF, (Object)instance.getWFInstanceId());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStateDEF = iDEWF.getWFStateField()))) {
            dataEntity.set(strWFStateDEF, (Object)0);
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStepDEF = iDEWF.getWFStepField()))) {
            dataEntity.set(strWFStepDEF, null);
        }
        udService.updateWFInfo(IService.UPDATEWFINFOMODE_CANCELSTART.intValue(), (IWFActionContext)iWFActionContext, dataEntity);
    }

    protected void cancelOnCancelStartWFInstance(WFInstance wfInstance) throws Exception {
        this.wfWorkListService.cancelByWFInstance(wfInstance);
    }

    protected WFUser reCalcRecvWorkWFUser(String strWFUserId) throws Exception {
        WFUser wfUserCur = new WFUser();
        wfUserCur.setWFUserId(strWFUserId);
        if (!this.wfUserService.get((IEntity)wfUserCur, true)) {
            throw new WFException(34, this.getLocalization("CTRL.WFSERVICE.ERR000034", new Object[]{strWFUserId}, StringHelper.format((String)"\u627e\u4e0d\u5230\u6307\u5b9a\u5de5\u4f5c\u6d41\u7528\u6237[%1$s]", (Object)strWFUserId)));
        }
        if (!DataObject.getBoolValue((Integer)wfUserCur.getValidFlag(), (boolean)true)) {
            throw new WFException(33, this.getLocalization("CTRL.WFSERVICE.ERR000033", new Object[]{wfUserCur.getWFUserName()}, StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7528\u6237[%1$s]\u6ca1\u6709\u542f\u7528", (Object)wfUserCur.getWFUserName())));
        }
        if (DataObject.getBoolValue((Integer)wfUserCur.getIsRecvWork(), (boolean)true)) {
            return wfUserCur;
        }
        String strSql = "";
        strSql = WebConfig.getCurrent().isLowCaseSql() ? StringHelper.format((String)"select t1.createdate,t1.createman,t1.isrecvwork,t1.memo,t1.recvinform,t1.updatedate,t1.updateman,t1.validflag,t1.wfuserid,t1.wfusername from t_srfwfuser t1  inner join t_srfwfusercandidate t2 on t2.wfminoruserid = t1.wfuserid \twhere (t1.isrecvwork is null or t1.isrecvwork=1 ) and (t1.validflag is null or t1.validflag = 1 ) and  t2.wfmajoruserid=?  order by t2.candidateorder ") : StringHelper.format((String)"select t1.* from T_SRFWFUSER t1  INNER JOIN T_SRFWFUSERCANDIDATE t2 on t2.WFMINORUSERID = t1.WFUSERID \twhere (t1.ISRECVWORK IS NULL OR t1.ISRECVWORK=1 ) AND (t1.VALIDFLAG IS NULL OR t1.VALIDFLAG = 1 ) and  t2.WFMAJORUSERID=?  ORDER BY t2.CANDIDATEORDER ");
        try {
            SqlParamList sqlParamList = new SqlParamList();
            sqlParamList.addString(strWFUserId);
            WFUser wfUser = new WFUser();
            this.executeRawSql(strSql, sqlParamList, (DataObject)wfUser);
            return wfUser;
        }
        catch (Exception ex) {
            ex = this.getExceptionRealCause(ex);
            if (ex instanceof ErrorException) {
                ErrorException errorException = (ErrorException)ex;
                if (errorException.getErrorCode() != 3) {
                    throw ex;
                }
                throw new WFException(35, this.getLocalization("CTRL.WFSERVICE.ERR000035", new Object[]{wfUserCur.getWFUserName()}, StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7528\u6237[%1$s]\u4e0d\u63a5\u6536\u5de5\u4f5c\uff0c\u4e14\u6ca1\u6709\u6307\u5b9a\u5f85\u529e\u7528\u6237", (Object)wfUserCur.getWFUserName())));
            }
            throw ex;
        }
    }

    protected void cancelSendWFStepActorInformMsg(IWFActionContext2 iWFActionContext, WFInstance wfInstane) throws Exception {
    }

    protected SessionFactory getSessionFactory() {
        return ((ISystemRuntime)this.getWFModel().getSystemModel()).getSessionFactory();
    }

    protected Session getCurrentSession() throws Exception {
        return SessionFactoryManager.getCurrentSession((SessionFactory)this.getSessionFactory());
    }

    protected void executeRawSql(String strSQL, SqlParamList sqlParamList, DataObject dataObject) throws Exception {
        Session session = this.getCurrentSession();
        log.debug((Object)StringHelper.format((String)"\u6267\u884cSQL\r\n%1$s", (Object)strSQL));
        final SqlParamList sqlParamList2 = sqlParamList;
        final String strSQL2 = strSQL;
        final DataObject dataObject2 = dataObject;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                try {
                    DBCallResult dbCallResult = WFDataCtrl.this.getDBDialect().callSql(connection, strSQL2, sqlParamList2, -1);
                    if (dbCallResult.isOk()) {
                        dbCallResult.getDataSet().cacheDataRow();
                    }
                    if (dbCallResult.isError()) {
                        throw new ErrorException(1, dbCallResult.getErrorInfo());
                    }
                    if (dbCallResult.getDataSet().getDataTableCount() == 0 || dbCallResult.getDataSet().getDataTable(0).getCachedRowCount() == 0) {
                        throw new ErrorException(3);
                    }
                    DataObject.fromDataRow((IDataObject)dataObject2, (IDataRow)dbCallResult.getDataSet().getDataTable(0).getCachedRow(0));
                }
                catch (Exception e) {
                    throw new SQLException(e);
                }
            }
        });
    }

    protected void executeRawSql(String strSQL, SqlParamList sqlParamList, ArrayList list, Class classType) throws Exception {
        Session session = this.getCurrentSession();
        log.debug((Object)StringHelper.format((String)"\u6267\u884cSQL\r\n%1$s", (Object)strSQL));
        final SqlParamList sqlParamList2 = sqlParamList;
        final String strSQL2 = strSQL;
        final Class classType2 = classType;
        final ArrayList arrayList = list;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                try {
                    DBCallResult dbCallResult = WFDataCtrl.this.getDBDialect().callSql(connection, strSQL2, sqlParamList2, -1);
                    if (dbCallResult.isOk()) {
                        dbCallResult.getDataSet().cacheDataRow();
                    }
                    if (dbCallResult.isError()) {
                        throw new ErrorException(1, dbCallResult.getErrorInfo());
                    }
                    IDataTable iDataTable = dbCallResult.getDataSet().getDataTable(0);
                    int nRows = iDataTable.getCachedRowCount();
                    int i = 0;
                    while (i < nRows) {
                        IDataRow iDataRow = iDataTable.getCachedRow(i);
                        DataObject dataObject = null;
                        dataObject = classType2 == null ? new DataObject() : (DataObject)ObjectHelper.create((Class)classType2);
                        DataObject.fromDataRow((IDataObject)dataObject, (IDataRow)iDataRow);
                        arrayList.add(dataObject);
                        ++i;
                    }
                }
                catch (Exception e) {
                    throw new SQLException(e);
                }
            }
        });
    }

    protected void executeRawSql(String strSQL, SqlParamList sqlParamList) throws Exception {
        Session session = this.getCurrentSession();
        log.debug((Object)StringHelper.format((String)"\u6267\u884cSQL\r\n%1$s", (Object)strSQL));
        final SqlParamList sqlParamList2 = sqlParamList;
        final String strSQL2 = strSQL;
        session.doWork(new Work(){

            public void execute(Connection connection) throws SQLException {
                try {
                    DBCallResult dbCallResult = WFDataCtrl.this.getDBDialect().callSql(connection, strSQL2, sqlParamList2, -1);
                    if (dbCallResult.isOk() && dbCallResult.getDataSet() != null) {
                        dbCallResult.getDataSet().close();
                    }
                    if (dbCallResult.isError()) {
                        throw new ErrorException(1, dbCallResult.getErrorInfo());
                    }
                }
                catch (Exception e) {
                    throw new SQLException(e);
                }
            }
        });
    }

    protected IDBDialect getDBDialect() {
        return ((ISystemRuntime)this.getWFModel().getSystemModel()).getDBDialect();
    }

    protected Exception getExceptionRealCause(Exception ex) {
        if (ex.getCause() == null) {
            return ex;
        }
        Throwable throwable = ex.getCause();
        if (throwable instanceof Exception) {
            return this.getExceptionRealCause((Exception)throwable);
        }
        return ex;
    }

    protected ISystemRuntime getSystemRuntime() {
        return (ISystemRuntime)this.getWFModel().getSystemModel();
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

    @Override
    public void suspendWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        this.wfInstanceService.get((IEntity)instance);
        if (DataObject.getBoolValue((Integer)instance.getIsClose(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u6302\u8d77");
        }
        if (DataObject.getBoolValue((Integer)instance.getSuspendFlag(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u6302\u8d77\uff0c\u65e0\u6cd5\u518d\u6b21\u6302\u8d77");
        }
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(instance.getWFInstanceId());
        wfInstance.setSuspendFlag(Integer.valueOf(1));
        this.wfInstanceService.update((IEntity)wfInstance);
        wfInstance.copyTo((IDataObject)instance, true);
    }

    @Override
    public void resumeWFInstance(IWFActionContext2 iWFActionContext, WFInstance instance) throws Exception {
        this.wfInstanceService.get((IEntity)instance);
        if (DataObject.getBoolValue((Integer)instance.getIsClose(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u7ee7\u7eed");
        }
        if (!DataObject.getBoolValue((Integer)instance.getSuspendFlag(), (boolean)false)) {
            throw new Exception("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u6ca1\u6709\u88ab\u6302\u8d77\uff0c\u65e0\u6cd5\u7ee7\u7eed");
        }
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(instance.getWFInstanceId());
        wfInstance.setSuspendFlag(Integer.valueOf(0));
        this.wfInstanceService.update((IEntity)wfInstance);
        wfInstance.copyTo((IDataObject)instance, true);
    }
}

