/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  javax.servlet.ServletContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SRFWF.Ctrl;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SRFWF.Client.WFParam;
import SRFWF.Ctrl.Data.WFAction;
import SRFWF.Ctrl.Data.WFActor;
import SRFWF.Ctrl.Data.WFIAAction;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Ctrl.Data.WFStep;
import SRFWF.Ctrl.Data.WFStepActor;
import SRFWF.Ctrl.Data.WFStepData;
import SRFWF.Ctrl.Data.WFStepInst;
import SRFWF.Ctrl.Data.WFTmpStepActor;
import SRFWF.Ctrl.Data.WFUser;
import SRFWF.Ctrl.Data.WFUserAssist;
import SRFWF.Ctrl.Data.WFWorkflow;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFCustomIAConnectionRule;
import SRFWF.Ctrl.ISRFWFDataCtrl;
import SRFWF.Ctrl.ISRFWFDataCtrlEx;
import SRFWF.Ctrl.ISRFWFDynamicUser;
import SRFWF.Ctrl.ISRFWFEngine;
import SRFWF.Ctrl.ISRFWFProcess;
import SRFWF.Ctrl.ISRFWFWorkflowHelper;
import SRFWF.Ctrl.SRFWFModelStorage;
import SRFWF.Model.WFBaseConnectionConfig;
import SRFWF.Model.WFBaseEmbedWFConfig;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFConfig;
import SRFWF.Model.WFEmbedWFReturnConfig;
import SRFWF.Model.WFEmbedWorkflowConfig;
import SRFWF.Model.WFEndProcessConfig;
import SRFWF.Model.WFHopProcessConfig;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFInteractiveProcessConfig;
import SRFWF.Model.WFParallelSubWFConfig;
import SRFWF.Model.WFProcessConfig;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFWFDefaultEngine
implements ISRFWFEngine,
ISRFWFContext {
    private static Log log = LogFactory.getLog(SRFWFDefaultEngine.class);
    protected ISRFWFDataCtrl wfDataCtrl = null;
    protected ISRFWFDataCtrlEx wfDataCtrlEx = null;
    protected WFWorkflow workflow = new WFWorkflow();
    protected WFConfig wfConfig = null;
    protected String strCurUserId = "";
    protected BaseDataEntity activeDataEntity = new BaseDataEntity();
    protected WFInstance wfInstance = new WFInstance();
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected String strCurNext = "";
    protected WFBaseProcessConfig curProcessConfig = null;
    protected int nMaxLoopCount = 100;
    protected String strInteractiveConnection = "";
    protected boolean bFinishInteractiveProcess = false;
    protected WFStep activeStep = null;
    protected ServletContext servletContext = null;
    protected ContextHelper contextHelper = null;
    public static final String TAG_SRFWFMODELSTORAGE = "SRFWFMODELSTORAGE";
    public static final String TAG_SRFWFDATACTRL = "SRFWFDATACTRL";
    public static final String TAG_SRFWFIAGOTO = "SRFWFIAGOTO";
    public static final String TAG_SRFWFTIMEOUT = "SRFWFTIMEOUT";
    public static final String TAG_SRFWFSTART = "SRFWFSTART";
    public static final String TAG_SRFWFRESTART = "SRFWFRESTART";
    public static final String TAG_SRFWFROLLBACK = "SRFWFROLLBACK";
    protected SRFWFModelStorage wfModelStorage = null;
    protected StringBuilderEx runInfo = new StringBuilderEx();
    protected String strUserTag = "";
    protected String strUserTag2 = "";
    protected TreeMap<String, String> nextIAStepActorMap = null;
    protected TreeMap<String, Object> attributes = null;
    public static final String EMBEDWFRETURN_USERCLOSE = "%%SRF_USERCLOSE%%";
    protected ISRFWFWorkflowHelper iWFWorkflowHelper = null;
    protected Vector<WFStepActor> rollbackStepActors = new Vector();
    protected boolean bThreadMode = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper, String strWorkflowId) {
        CallResult ret;
        this.dbCallerHelper = dbCallerHelper;
        this.servletContext = servletContext;
        this.contextHelper = new ContextHelper(servletContext);
        SRFWFDefaultEngine sRFWFDefaultEngine = this;
        synchronized (sRFWFDefaultEngine) {
            Object objModelStorage = servletContext.getAttribute(TAG_SRFWFMODELSTORAGE);
            if (objModelStorage == null || !(objModelStorage instanceof SRFWFModelStorage)) {
                this.wfModelStorage = new SRFWFModelStorage();
                servletContext.setAttribute(TAG_SRFWFMODELSTORAGE, (Object)this.wfModelStorage);
            } else {
                this.wfModelStorage = (SRFWFModelStorage)objModelStorage;
            }
        }
        this.wfDataCtrl = this.CreateWFDataCtrl();
        if (this.wfDataCtrl == null) {
            ret = new CallResult();
            ret.setRetCode(1);
            ret.setErrorInfo("\u65e0\u6cd5\u5efa\u7acb\u5de5\u4f5c\u6d41\u5f15\u64ce\u6570\u636e\u5bf9\u8c61");
            this.Log(1, this, "\u65e0\u6cd5\u5efa\u7acb\u5de5\u4f5c\u6d41\u5f15\u64ce\u6570\u636e\u5bf9\u8c61");
            return ret;
        }
        if (this.wfDataCtrl instanceof ISRFWFDataCtrlEx) {
            this.wfDataCtrlEx = (ISRFWFDataCtrlEx)this.wfDataCtrl;
        }
        if ((ret = this.wfDataCtrl.GetWFWorkflow(strWorkflowId, this.workflow)) == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("Init", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u914d\u7f6e\u6570\u636e[%1$s]", (Object)strWorkflowId), ret);
        }
        if (this.workflow.getWFSTATE() != 1) {
            return this.LogAndReturn("Init", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u914d\u7f6e[%1$s]\u5f53\u524d\u5904\u4e8e\u975e\u6b63\u5e38\u4f7f\u7528\u72b6\u6001", (Object)strWorkflowId), ret);
        }
        try {
            this.iWFWorkflowHelper = this.wfModelStorage.FindWFHelper(this.workflow);
        }
        catch (Exception e) {
            CallResult ret2 = new CallResult();
            return this.LogAndReturn("Init", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strWorkflowId, (Object)e.getMessage()), ret2);
        }
        return ret;
    }

    protected ISRFWFDataCtrl CreateWFDataCtrl() {
        Object objDataCtrl = this.servletContext.getAttribute(TAG_SRFWFDATACTRL);
        if (objDataCtrl != null && objDataCtrl instanceof ISRFWFDataCtrl) {
            ISRFWFDataCtrl iDataCtrl = (ISRFWFDataCtrl)objDataCtrl;
            return iDataCtrl;
        }
        String strDataCtrlObject = this.contextHelper.getWebExConfig().GetValue("SRFWF", "WFDATACTRL", "");
        if (StringHelper.IsNullOrEmpty((String)strDataCtrlObject)) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u5f15\u64ce\u6570\u636e\u5bf9\u8c61"));
            return null;
        }
        objDataCtrl = ObjectHelper.Create((String)strDataCtrlObject);
        if (objDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5de5\u4f5c\u6d41\u5f15\u64ce\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)objDataCtrl));
            return null;
        }
        if (objDataCtrl instanceof ISRFWFDataCtrl) {
            ISRFWFDataCtrl wfDataCtrl = (ISRFWFDataCtrl)objDataCtrl;
            wfDataCtrl.Init(this.servletContext, this.dbCallerHelper);
            if (wfDataCtrl.isMultiUse()) {
                this.servletContext.setAttribute(TAG_SRFWFDATACTRL, (Object)wfDataCtrl);
            }
            return wfDataCtrl;
        }
        log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ISRFWFDataCtrl]", (Object)objDataCtrl));
        return null;
    }

    @Override
    public CallResult StartNew(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        CallResult ret = this.GetUserData(wpParam);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("StartNew", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.workflow);
        if (this.wfConfig == null) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.workflow.getWFWORKFLOWID()), null);
        }
        ret = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (ret == null) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), null);
        }
        if (ret.getRetCode() == 0) {
            ret.setRetCode(7);
            ret.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6570\u636e[%1$s]\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5b58\u5728", (Object)wpParam.getUserData()));
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u6307\u5b9a\u6570\u636e[%1$s]\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5df2\u7ecf\u5b58\u5728", (Object)wpParam.getUserData()), ret);
        }
        if (ret.getRetCode() != 3) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), ret);
        }
        this.wfInstance.setWFINSTANCEID(Helper.GenGuidEx());
        this.wfInstance.setWFINSTANCENAME(StringHelper.Format((String)"%1$s[%2$s]", (Object)this.workflow.getWFNAME(), (Object)DateParser.toDateTimeString((Date)new Date())));
        this.wfInstance.setPWFINSTANCEID(wpParam.getPInstanceId());
        this.wfInstance.setPSTEPID(wpParam.getStepId());
        this.wfInstance.setWFWORKFLOWID(this.workflow.getWFWORKFLOWID());
        this.wfInstance.setWFVERSION(this.workflow.getWFVERSION());
        this.wfInstance.setUSERDATA(wpParam.getUserData());
        this.wfInstance.setUSERDATA2(wpParam.getUserData2());
        this.wfInstance.setUSERDATA3(wpParam.getUserData3());
        this.wfInstance.setUSERDATA4(wpParam.getUserData4());
        this.wfInstance.setOWNER(wpParam.getOpPersonId());
        this.wfInstance.setIMPORTANCEFLAG(0);
        this.wfInstance.setWFMODEL(this.workflow.getWFMODEL());
        if (!StringHelper.IsNullOrEmpty((String)wpParam.getConnection()) && wpParam.getConnection().indexOf("PARALLELSUBWF") == 0) {
            this.wfInstance.setPARALLELINST(true);
            this.wfInstance.setUSERTAG(wpParam.getConnection().substring(14));
        }
        if (this.wfDataCtrlEx != null && (ret = this.wfDataCtrlEx.TestStartWF(this)).getRetCode() != 0) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u542f\u52a8\u68c0\u67e5\u5931\u8d25", (Object)wpParam.getUserData()), ret);
        }
        ret = this.wfDataCtrl.AddWFInstance(this.wfInstance, wpParam.getOpPersonId());
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u5efa\u7acb\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5931\u8d25"), ret);
        }
        String strSQL = this.workflow.getUSERDATACMD2();
        if (!(StringHelper.IsNullOrEmpty((String)strSQL) || (ret = this.wfDataCtrl.ExecRawSql(strSQL = StringHelper.Format((String)strSQL, (Object)wpParam.getUserData(), (Object)wpParam.getUserData2(), (Object)wpParam.getUserData3(), (Object)wpParam.getUserData4(), (Object)this.strCurUserId, (Object)this.wfInstance.getWFINSTANCEID()))) != null && ret.getRetCode() == 0)) {
            this.wfDataCtrl.RemoveWFInstance(this.wfInstance, wpParam.getOpPersonId());
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u9644\u52a0\u5b9e\u4f8b\u6570\u636e\u81f3\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
        }
        wpParam.setInstanceId(this.wfInstance.getWFINSTANCEID());
        if (this.wfDataCtrlEx != null && !this.wfInstance.getPARALLELINST()) {
            WFStepData stepData = new WFStepData();
            stepData.setWFSTEPDATANAME("\u542f\u52a8\u6d41\u7a0b");
            stepData.setWFSTEPDATAID(Helper.GenGuidEx());
            stepData.setCONNECTIONNAME(TAG_SRFWFSTART);
            stepData.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
            stepData.setACTORID(this.strCurUserId);
            this.wfDataCtrlEx.AddRawWFStepData(this, stepData);
            if (ret == null || ret.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("StartNew", "", ret);
            }
        }
        if ((ret = this.InternalExecute(null)) == null || ret.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("StartNew", "", ret);
        }
        this.Log(0, this, "\u542f\u52a8\u65b0\u6d41\u7a0b\u6210\u529f");
        return ret;
    }

    @Override
    public CallResult Restart(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        CallResult ret = this.GetUserData(wpParam);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("Restart", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.workflow);
        if (this.wfConfig == null) {
            return this.LogAndReturn("Init", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.workflow.getWFWORKFLOWID()), null);
        }
        CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (callResult != null && callResult.getRetCode() == 3) {
            return this.StartNew(wpParam);
        }
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("Restart", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        if (this.wfDataCtrlEx != null && (ret = this.wfDataCtrlEx.TestRestartWF(this)).getRetCode() != 0) {
            return this.LogAndReturn("Restart", StringHelper.Format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u91cd\u542f\u5931\u8d25", (Object)wpParam.getUserData()), ret);
        }
        this.UserCloseUnfinishEmbedWorkflows(this.wfInstance.getACTIVESTEPID(), false, "\u7236\u6d41\u7a0b\u91cd\u65b0\u542f\u52a8");
        this.wfInstance.setWFVERSION(this.workflow.getWFVERSION());
        this.wfInstance.setWFMODEL(this.workflow.getWFMODEL());
        callResult = this.wfDataCtrl.ResetWFInstance(this.wfInstance, this.strCurUserId);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("Restart", StringHelper.Format((String)"\u91cd\u7f6e\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        String strSQL = this.workflow.getRestartCmd();
        if (!(StringHelper.IsNullOrEmpty((String)strSQL) || (ret = this.wfDataCtrl.ExecRawSql(strSQL = StringHelper.Format((String)strSQL, (Object)wpParam.getUserData(), (Object)wpParam.getUserData2(), (Object)wpParam.getUserData3(), (Object)wpParam.getUserData4(), (Object)this.strCurUserId, (Object)this.wfInstance.getWFINSTANCEID()))) != null && ret.getRetCode() == 0)) {
            return this.LogAndReturn("Restart", StringHelper.Format((String)"\u5b9e\u4f8b\u88ab\u91cd\u65b0\u542f\u52a8\uff0c\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
        }
        if (this.wfDataCtrlEx != null && !this.wfInstance.getPARALLELINST()) {
            WFStepData stepData = new WFStepData();
            stepData.setWFSTEPDATANAME("\u91cd\u65b0\u542f\u52a8\u6d41\u7a0b");
            stepData.setWFSTEPDATAID(Helper.GenGuidEx());
            stepData.setCONNECTIONNAME(TAG_SRFWFSTART);
            stepData.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
            stepData.setACTORID(this.strCurUserId);
            this.wfDataCtrlEx.AddRawWFStepData(this, stepData);
            if (ret == null || ret.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("Restart", "", ret);
            }
        }
        if ((ret = this.InternalExecute(null)) == null || ret.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("Restart", "", ret);
        }
        return ret;
    }

    public CallResult CalcNextIAProcessActor(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        CallResult ret = this.GetUserData(wpParam);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("CalcNextIAProcessActor", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u67e5\u8be2\u4e0b\u4e00\u4e2a\u4ea4\u4e92\u5904\u7406\u64cd\u4f5c\u7528\u6237", (Object)wpParam.getUserData()), null);
        }
        if (StringHelper.Compare((String)wpParam.getStepId(), (String)this.wfInstance.getACTIVESTEPNAME(), (boolean)true) != 0) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)wpParam.getUserData(), (Object)wpParam.getStepId(), (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        String strWFStepId = this.wfInstance.getACTIVESTEPID();
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
        if (this.wfConfig == null) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.wfInstance.getWFINSTANCEID()), null);
        }
        WFBaseProcessConfig curProcessConfig = this.wfConfig.FindProcessConfigByName(this.wfInstance.getACTIVESTEPNAME());
        if (curProcessConfig == null) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        String strNext = "";
        if (curProcessConfig instanceof WFInteractiveProcessConfig) {
            WFInteractiveProcessConfig iaProcessConfig = (WFInteractiveProcessConfig)curProcessConfig;
            WFInteractiveActionConfig iaActionConfig = iaProcessConfig.getIAActionsConfig().FindIAActionConfigByName(wpParam.getConnection());
            if (iaActionConfig == null) {
                return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u4ea4\u4e92\u64cd\u4f5c"), null);
            }
            strNext = iaActionConfig.getNext();
        }
        WFInteractiveProcessConfig nextIAProcessConfig = null;
        while (!StringHelper.IsNullOrEmpty((String)strNext)) {
            WFBaseProcessConfig nextProcessConfig = this.wfConfig.FindProcessConfigByName(strNext);
            if (nextProcessConfig == null) {
                return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406[%1$s]\u914d\u7f6e", (Object)strNext), null);
            }
            if (nextProcessConfig instanceof WFEndProcessConfig) {
                return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u5f53\u524d\u5904\u7406\u540e\u7eed\u4e3a\u7ed3\u675f\u5904\u7406\uff0c\u4e0d\u5b58\u5728\u4ea4\u4e92\u64cd\u4f5c\u5904\u7406", (Object)strNext), null);
            }
            if (nextProcessConfig instanceof WFProcessConfig) {
                WFProcessConfig processConfig = (WFProcessConfig)nextProcessConfig;
                strNext = processConfig.getNext();
                continue;
            }
            if (nextProcessConfig instanceof WFInteractiveProcessConfig) {
                nextIAProcessConfig = (WFInteractiveProcessConfig)nextProcessConfig;
                break;
            }
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5f53\u524d\u5904\u7406\u540e\u7eed\u7684\u4ea4\u4e92\u5904\u7406", (Object)strNext), null);
        }
        if (nextIAProcessConfig == null) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5904\u7406\u540e\u7eed\u7684\u4ea4\u4e92\u5904\u7406", (Object)strNext), null);
        }
        TreeMap<String, String> wfStepActorMap = new TreeMap<String, String>();
        String strActors = nextIAProcessConfig.getActors();
        if (!StringHelper.IsNullOrEmpty((String)strActors)) {
            String[] actors = strActors.split(";");
            int nCount = actors.length;
            int i = 0;
            while (i < nCount) {
                Vector<WFUser> wfUsers;
                WFActor wfActor = new WFActor();
                ret = this.wfDataCtrl.GetWFActor(actors[i], wfActor);
                if (ret == null || ret.getRetCode() != 0) {
                    return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u64cd\u4f5c\u8005[%1$s]\u5931\u8d25", (Object)actors[i]), ret);
                }
                if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"USER", (boolean)true) == 0) {
                    wfStepActorMap.put(wfActor.getWFACTORID(), "");
                } else if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"USERGROUP", (boolean)true) == 0) {
                    wfUsers = new Vector<WFUser>();
                    ret = this.wfDataCtrl.GetWFUserGroupDetail(actors[i], wfUsers);
                    if (ret == null || ret.getRetCode() != 0) {
                        return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u7528\u6237\u7ec4[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)actors[i]), ret);
                    }
                    for (WFUser wfUser : wfUsers) {
                        wfStepActorMap.put(wfUser.getWFUSERID(), "");
                    }
                } else if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"SYSTEMUSER", (boolean)true) == 0) {
                    wfUsers = new Vector();
                    ret = this.wfDataCtrl.GetWFSystemUser(this, actors[i], wfUsers);
                    if (ret == null || ret.getRetCode() != 0) {
                        return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u7cfb\u7edf\u7528\u6237[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)actors[i]), ret);
                    }
                    for (WFUser wfUser : wfUsers) {
                        wfStepActorMap.put(wfUser.getWFUSERID(), "");
                    }
                } else if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"DYNAMICUSER", (boolean)true) == 0) {
                    String strDynamicUserObject = wfActor.getWFACTORPARAM();
                    if (StringHelper.IsNullOrEmpty((String)strDynamicUserObject)) {
                        return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u6ca1\u6709\u6307\u5b9a\u5904\u7406\u5bf9\u8c61", (Object)wfActor.getWFACTORID()), ret);
                    }
                    Object objDynamicUser = ObjectHelper.Create((String)strDynamicUserObject);
                    if (objDynamicUser == null) {
                        return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u5efa\u7acb\u5bf9\u8c61[%2$s]\u5931\u8d25", (Object)wfActor.getWFACTORID(), (Object)strDynamicUserObject), ret);
                    }
                    if (!(objDynamicUser instanceof ISRFWFDynamicUser)) {
                        return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)wfActor.getWFACTORID(), (Object)strDynamicUserObject), ret);
                    }
                    ISRFWFDynamicUser iDynamicUser = (ISRFWFDynamicUser)objDynamicUser;
                    Vector<WFUser> wfUsers2 = new Vector<WFUser>();
                    ret = iDynamicUser.GetUsers(this, wfActor, wfUsers2);
                    if (ret == null || ret.getRetCode() != 0) {
                        return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)actors[i]), ret);
                    }
                    for (WFUser wfUser : wfUsers2) {
                        wfStepActorMap.put(wfUser.getWFUSERID(), "");
                    }
                }
                ++i;
            }
        }
        Vector<WFTmpStepActor> tmpStepActors = new Vector<WFTmpStepActor>();
        for (String strUserId : wfStepActorMap.keySet()) {
            WFTmpStepActor tmpStepActor = new WFTmpStepActor();
            tmpStepActor.setWFACTORID(strUserId);
            tmpStepActor.setWFACTORNAME(strUserId);
            tmpStepActor.setPREVPROCESS(this.strUserTag);
            tmpStepActor.setPREVWFSTEPID(strWFStepId);
            tmpStepActor.setCONNECTION(wpParam.getConnection());
            tmpStepActors.add(tmpStepActor);
        }
        callResult = this.wfDataCtrl.AddWFTmpStepActors(tmpStepActors, this.strCurUserId);
        if (callResult.IsError()) {
            return this.LogAndReturn("CalcNextIAProcessActor", StringHelper.Format((String)"\u589e\u52a0\u6b65\u9aa4\u4e34\u65f6\u5de5\u4f5c\u8005\u53d1\u751f\u9519\u8bef"), callResult);
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public CallResult SubmitIAAction(boolean bTest, WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        if (!StringHelper.IsNullOrEmpty((String)this.strUserTag)) {
            this.nextIAStepActorMap = new TreeMap();
            String[] actorids = this.strUserTag.split("[;]");
            int i = 0;
            while (i < actorids.length) {
                if (!StringHelper.IsNullOrEmpty((String)actorids[i])) {
                    this.nextIAStepActorMap.put(actorids[i], "");
                }
                ++i;
            }
        }
        this.runInfo.Reset();
        CallResult callResult = this.GetUserData(wpParam);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("SubmitIAAction", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", callResult);
        }
        callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u4ea4\u4e92\u5904\u7406", (Object)wpParam.getUserData()), null);
        }
        if (StringHelper.Compare((String)wpParam.getStepId(), (String)this.wfInstance.getACTIVESTEPNAME(), (boolean)true) != 0) {
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)wpParam.getUserData(), (Object)wpParam.getStepId(), (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        String strCurWFStepId = this.wfInstance.getACTIVESTEPID();
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
        if (this.wfConfig == null) {
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.wfInstance.getWFINSTANCEID()), null);
        }
        WFBaseProcessConfig curProcessConfig = this.wfConfig.FindProcessConfigByName(this.wfInstance.getACTIVESTEPNAME());
        if (curProcessConfig == null) {
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        WFStepData stepData = new WFStepData();
        stepData.setWFSTEPDATAID(Helper.GenGuidEx());
        stepData.setWFSTEPID(wpParam.getStepId());
        stepData.setCONNECTIONNAME(wpParam.getConnection());
        stepData.setDESCRIPTION(wpParam.getDescription());
        stepData.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
        boolean bNoConnection = false;
        if (curProcessConfig instanceof WFInteractiveProcessConfig) {
            WFInteractiveActionConfig iaActionConfig;
            WFInteractiveProcessConfig iaProcessConfig = (WFInteractiveProcessConfig)curProcessConfig;
            if (!StringHelper.IsNullOrEmpty((String)this.strUserTag2)) {
                Vector<WFUserAssist> userAssists = new Vector<WFUserAssist>();
                callResult = this.wfDataCtrl.GetWFUserAssists(this.wfInstance, this.strUserTag2, this.strCurUserId, this.workflow.getWFWORKFLOWID(), userAssists);
                if (callResult.IsError()) {
                    callResult.setErrorInfo("");
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u5f53\u524d\u7528\u6237\u4ee3\u529e\u7528\u6237\u8303\u56f4\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()), callResult);
                }
                WFUserAssist userAssist = new WFUserAssist();
                callResult = this.wfDataCtrl.GetWFUserAssist(this.strUserTag2, this.strCurUserId, this.workflow.getWFWORKFLOWID(), userAssist);
                if (callResult.IsError()) {
                    if (callResult.getRetCode() != 3) {
                        callResult.setErrorInfo("");
                        return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u5f53\u524d\u7528\u6237\u4ee3\u529e\u7528\u6237\u8303\u56f4\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()), callResult);
                    }
                } else {
                    userAssists.add(userAssist);
                }
                if (userAssists.size() == 0) {
                    callResult.setErrorInfo("");
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u5728\u6307\u5b9a\u7684\u4ee3\u529e\u7528\u6237\u8303\u56f4"), callResult);
                }
                boolean bTestOK = false;
                for (WFUserAssist userAssist2 : userAssists) {
                    String strWFStep = userAssist2.getWFSTEP();
                    if (!StringHelper.IsNullOrEmpty((String)strWFStep)) {
                        String[] step = strWFStep.split("[;]");
                        int i = 0;
                        while (i < step.length) {
                            String strStep = step[i];
                            if (StringHelper.Compare((String)strStep, (String)"*", (boolean)true) == 0) {
                                bTestOK = true;
                                break;
                            }
                            if (StringHelper.Compare((String)strStep, (String)iaProcessConfig.getCodeListItemValue(), (boolean)true) == 0) {
                                bTestOK = true;
                                break;
                            }
                            ++i;
                        }
                        if (!bTestOK) continue;
                        this.strCurUserId = userAssist2.getWFMAJORUSERID();
                        stepData.setSDPARAM2(userAssist2.getWFMINORUSERID());
                        break;
                    }
                    bTestOK = true;
                    this.strCurUserId = userAssist2.getWFMAJORUSERID();
                    stepData.setSDPARAM2(userAssist2.getWFMINORUSERID());
                    break;
                }
                if (!bTestOK) {
                    callResult.setRetCode(2);
                    callResult.setErrorInfo("\u5f53\u524d\u7528\u6237\u4e0d\u80fd\u4e3a\u5de5\u4f5c\u7528\u6237\u4ee3\u529e\u6307\u5b9a\u4e8b\u9879\u3002");
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u80fd\u4e3a\u5de5\u4f5c\u7528\u6237\u4ee3\u529e\u6307\u5b9a\u4e8b\u9879\u3002"), callResult);
                }
            }
            if (StringHelper.IsNullOrEmpty((String)wpParam.getConnection())) {
                if (bTest) {
                    bNoConnection = true;
                    if (iaProcessConfig.getIAActionsConfig().size() == 0) {
                        return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u4ea4\u4e92\u64cd\u4f5c"), null);
                    }
                    iaActionConfig = (WFInteractiveActionConfig)((Object)iaProcessConfig.getIAActionsConfig().get(0));
                    stepData.setWFSTEPDATANAME(iaActionConfig.getLogicName());
                    stepData.setCONNECTIONNAME(iaActionConfig.getName());
                }
            } else {
                iaActionConfig = iaProcessConfig.getIAActionsConfig().FindIAActionConfigByName(wpParam.getConnection());
                if (iaActionConfig != null) {
                    stepData.setWFSTEPDATANAME(iaActionConfig.getLogicName());
                }
            }
        }
        stepData.setACTORID(this.strCurUserId);
        if (bTest) {
            callResult = this.wfDataCtrl.TestWFStepData(stepData, this.strCurUserId);
            if (callResult == null || callResult.getRetCode() != 0) {
                if (bNoConnection) {
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u5224\u65ad\u6267\u884c\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
                }
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u51c6\u5907\u6267\u884c\u4ea4\u4e92\u6b65\u9aa4[%1$s]\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
            }
            callResult.setRetCode(0);
            callResult.setUserObject((Object)this.wfInstance.getWFINSTANCEID());
            return callResult;
        }
        callResult = this.wfDataCtrl.AddWFStepData(stepData, this.strCurUserId);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u6b65\u9aa4[%1$s]\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
        }
        if (this.wfDataCtrlEx != null && ((callResult = this.wfDataCtrlEx.UpdateCurWFStepActors(this)) == null || callResult.getRetCode() != 0)) {
            return this.LogAndReturn("InternalFinishWorkflow", StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f8b\u6b65\u9aa4\u4ea4\u4e92\u7528\u6237\u5931\u8d25"), callResult);
        }
        WFIAAction iaAction = new WFIAAction();
        callResult = this.wfDataCtrl.GetWFIAAction(stepData.getWFSTEPID(), stepData.getCONNECTIONNAME(), iaAction);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
        }
        callResult = this.wfDataCtrl.GetWFStepDataCount(stepData.getWFSTEPID(), stepData.getCONNECTIONNAME());
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c\u6570\u636e\u6570\u91cf[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
        }
        boolean bGoNext = false;
        int nCount = (Integer)callResult.getUserObject();
        String strNextCondition = iaAction.getNEXTCONDITION();
        String[] conds = strNextCondition.split("[|]");
        if (conds.length >= 1) {
            strNextCondition = conds[0];
        }
        if (StringHelper.Compare((String)strNextCondition, (String)"UDF", (boolean)true) == 0) {
            if (conds.length < 2) {
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u6570\u636e\u5c5e\u6027"), callResult);
            }
            String strFieldName = conds[1];
            String strDefault = "ANY";
            if (conds.length >= 3) {
                strDefault = conds[2];
            }
            if ((conds = (strNextCondition = this.activeDataEntity.GetParamStringValue(strFieldName, strDefault)).split("[|]")).length >= 1) {
                strNextCondition = conds[0];
            }
        }
        if (StringHelper.Compare((String)strNextCondition, (String)"CUSTOM", (boolean)true) == 0) {
            ISRFWFCustomIAConnectionRule iCustomIAConnectionRule;
            if (conds.length < 2) {
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u4ea4\u4e92\u8fde\u63a5\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61"), callResult);
            }
            String strObjectName = conds[1];
            Object objCustom = ObjectHelper.Create((String)strObjectName);
            if (objCustom == null) {
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6307\u5b9a\u4ea4\u4e92\u8fde\u63a5\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strObjectName), callResult);
            }
            if (!(objCustom instanceof ISRFWFCustomIAConnectionRule)) {
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u4ea4\u4e92\u8fde\u63a5\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObjectName), callResult);
            }
            String strParam = "";
            if (conds.length <= 3) {
                strParam = conds[2];
            }
            if ((callResult = (iCustomIAConnectionRule = (ISRFWFCustomIAConnectionRule)objCustom).Test(this, this.wfDataCtrl, stepData, iaAction, strParam)) == null || callResult.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6267\u884c\u8fde\u63a5\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strObjectName), callResult);
            }
            bGoNext = (Boolean)callResult.getUserObject();
        } else {
            boolean bRoleMode = false;
            String strRoleNextCond = "ANY";
            TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
            if (conds.length >= 2) {
                String strRoleCond = conds[1];
                String[] role = strRoleCond.split("[;]");
                if (StringHelper.Compare((String)role[0], (String)"ROLE", (boolean)true) == 0) {
                    bRoleMode = true;
                }
                if (role.length >= 2) {
                    strRoleNextCond = role[1];
                }
            }
            if (conds.length >= 3) {
                String strOtherIA = conds[2];
                if (!StringHelper.IsNullOrEmpty((String)(strOtherIA = strOtherIA.toUpperCase()))) {
                    String[] ias = strOtherIA.split("[;]");
                    int i = 0;
                    while (i < ias.length) {
                        if (StringHelper.Compare((String)ias[i], (String)stepData.getCONNECTIONNAME(), (boolean)true) != 0) {
                            otherIAMap.put(ias[i], 0);
                        }
                        ++i;
                    }
                }
            }
            if (bRoleMode) {
                Vector<WFStepActor> stepActorList = new Vector<WFStepActor>();
                callResult = this.wfDataCtrl.GetWFStepActor(stepData.getWFSTEPID(), stepActorList);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c\u7528\u6237\u96c6\u5408[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
                }
                Vector stepDataList = new Vector();
                callResult = this.wfDataCtrl.GetWFStepData(stepData.getWFSTEPID(), stepDataList);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c\u7528\u6237\u64cd\u4f5c\u7ed3\u679c[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
                }
                TreeMap<Object, Integer> roleCountMap = new TreeMap<Object, Integer>();
                TreeMap<String, String> actorRoleMap = new TreeMap<String, String>();
                for (WFStepActor wfStepActor : stepActorList) {
                    Object strRoleId = wfStepActor.getROLEID();
                    int nCurCount = 0;
                    if (roleCountMap.containsKey(strRoleId)) {
                        nCurCount = (Integer)roleCountMap.get(strRoleId);
                    }
                    roleCountMap.put(strRoleId, ++nCurCount);
                    actorRoleMap.put(wfStepActor.getACTORID(), wfStepActor.getROLEID());
                }
                TreeMap roleStepCountMap = new TreeMap();
                for (String strRoleId : roleCountMap.keySet()) {
                    roleStepCountMap.put(strRoleId, new TreeMap());
                }
                String strCurRoleId = "";
                Iterator<Object> nCurCount = stepDataList.iterator();
                while (nCurCount.hasNext()) {
                    WFStepData wfStepData = (WFStepData)((Object)nCurCount.next());
                    String strRoleId = (String)actorRoleMap.get(wfStepData.getACTORID());
                    TreeMap roleActionMap = (TreeMap)roleStepCountMap.get(strRoleId);
                    int nCurCount2 = 0;
                    if (roleActionMap.containsKey(wfStepData.getCONNECTIONNAME())) {
                        nCurCount2 = (Integer)roleActionMap.get(wfStepData.getCONNECTIONNAME());
                    }
                    roleActionMap.put(wfStepData.getCONNECTIONNAME(), nCurCount2 + 1);
                    if (StringHelper.Compare((String)wfStepData.getACTORID(), (String)stepData.getACTORID(), (boolean)true) != 0) continue;
                    strCurRoleId = strRoleId;
                }
                nCount = 0;
                for (Object strRoleId : roleCountMap.keySet()) {
                    if (!this.TestRoleConnection(stepData.getCONNECTIONNAME(), (Integer)roleCountMap.get(strRoleId), (TreeMap)roleStepCountMap.get(strRoleId), strRoleNextCond, "")) continue;
                    ++nCount;
                    if (StringHelper.Compare((String)strCurRoleId, (String)strRoleId, (boolean)true) != 0) continue;
                    this.wfDataCtrl.RemoveNoDataWFStepActor(stepData.getWFSTEPID(), strCurRoleId);
                }
                if (StringHelper.Compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
                    if (nCount > 0) {
                        bGoNext = true;
                    }
                } else {
                    int nActionCount = -1;
                    int nRoleCount = roleCountMap.size();
                    double fPercent = 0.0;
                    if (StringHelper.Compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                        nActionCount = nRoleCount;
                    } else if (strNextCondition.indexOf("%") != -1) {
                        strNextCondition = strNextCondition.replaceAll("[%]", "");
                        fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
                        fPercent /= 100.0;
                    } else {
                        try {
                            nActionCount = Integer.parseInt(strNextCondition);
                        }
                        catch (Exception ex) {
                            fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
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
            } else if (StringHelper.Compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
                if (nCount > 0) {
                    bGoNext = true;
                }
            } else {
                for (String strIA : otherIAMap.keySet()) {
                    callResult = this.wfDataCtrl.GetWFStepDataCount(stepData.getWFSTEPID(), strIA);
                    if (callResult == null || callResult.getRetCode() != 0) {
                        this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                        return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c\u6570\u636e\u6570\u91cf[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
                    }
                    int nIAActionCount = (Integer)callResult.getUserObject();
                    nCount += nIAActionCount;
                }
                callResult = this.wfDataCtrl.GetWFStepActorCount(stepData.getWFSTEPID());
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                    return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c\u7528\u6237\u6570\u91cf[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
                }
                int nActionCount = -1;
                int nActorCount = (Integer)callResult.getUserObject();
                double fPercent = 0.0;
                if (StringHelper.Compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                    nActionCount = nActorCount;
                } else if (strNextCondition.indexOf("%") != -1) {
                    strNextCondition = strNextCondition.replaceAll("[%]", "");
                    fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
                    fPercent /= 100.0;
                } else {
                    try {
                        nActionCount = Integer.parseInt(strNextCondition);
                    }
                    catch (Exception ex) {
                        fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
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
        }
        if (bGoNext) {
            this.activeStep = new WFStep();
            this.activeStep.setWFSTEPID(stepData.getWFSTEPID());
            callResult = this.InternalExecuteProcess(curProcessConfig);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u5904\u7406[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
            }
            callResult = this.InternalFinishProcess(curProcessConfig);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u5b8c\u6210\u4ea4\u4e92\u5904\u7406[%1$s]\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
            }
            WFBaseProcessConfig nextProcessConfig = this.wfConfig.FindProcessConfigByName(iaAction.getNEXTTO());
            if (nextProcessConfig == null) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitIAAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)iaAction.getNEXTTO()), null);
            }
            callResult = this.InternalExecute(nextProcessConfig);
            this.wfDataCtrl.RemoveWFTmpStepActors(strCurWFStepId, this.strCurUserId);
            this.nextIAStepActorMap = null;
            callResult.setUserObject((Object)this.runInfo.toString());
            return callResult;
        }
        callResult.setRetCode(0);
        callResult.setUserObject((Object)this.runInfo.toString());
        return callResult;
    }

    public CallResult RollbackIAAction(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        this.runInfo.Reset();
        if (this.wfDataCtrlEx == null) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u5f53\u524d\u6d41\u7a0b\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u4e0d\u652f\u6301\u64a4\u56de\u5904\u7406"), null);
        }
        String strConnection = wpParam.getConnection();
        CallResult ret = this.GetUserData(wpParam);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("RollbackIAAction", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        ret = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), ret);
        }
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406", (Object)wpParam.getUserData()), null);
        }
        WFStepData lastWFStepData = new WFStepData();
        ret = this.wfDataCtrlEx.GetLastWFStepData(this, lastWFStepData);
        if (ret.IsError()) {
            if (Errors.IsSpecialError((int)ret.getRetCode(), (int)3)) {
                return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u6700\u540e\u4e00\u6b21\u64cd\u4f5c\u6570\u636e\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406", (Object)wpParam.getUserData()), null);
            }
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u6700\u540e\u4e00\u6b21\u64cd\u4f5c\u6570\u636e", (Object)wpParam.getUserData()), ret);
        }
        if (StringHelper.Compare((String)lastWFStepData.getACTORID(), (String)this.strCurUserId, (boolean)false) != 0) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u5de5\u4f5c\u6d41\u6700\u540e\u4e00\u6b21\u64cd\u4f5c\u8005\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406", (Object)wpParam.getUserData()), null);
        }
        if (StringHelper.Compare((String)lastWFStepData.getCONNECTIONNAME(), (String)TAG_SRFWFROLLBACK, (boolean)true) == 0) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u5bf9\u64a4\u56de\u5904\u7406\u8fdb\u884c\u518d\u64a4\u56de", (Object)wpParam.getUserData()), null);
        }
        if (StringHelper.Compare((String)lastWFStepData.getCONNECTIONNAME(), (String)TAG_SRFWFTIMEOUT, (boolean)true) == 0) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u5bf9\u8d85\u65f6\u5904\u7406\u8fdb\u884c\u64a4\u56de", (Object)wpParam.getUserData()), null);
        }
        if (StringHelper.Compare((String)lastWFStepData.getCONNECTIONNAME(), (String)TAG_SRFWFSTART, (boolean)true) == 0) {
            return this.CancelStartNew(wpParam);
        }
        if (StringHelper.IsNullOrEmpty((String)lastWFStepData.getWFSTEPID())) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u4e0a\u4e00\u4e2a\u6b65\u9aa4", (Object)wpParam.getUserData()), ret);
        }
        Vector<WFStepData> stepDataList = new Vector<WFStepData>();
        ret = this.wfDataCtrl.GetWFStepData(lastWFStepData.getWFSTEPID(), stepDataList);
        if (ret.IsError()) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u4e0a\u4e00\u4e2a\u6b65\u9aa4\u64cd\u4f5c\u6570\u636e", (Object)wpParam.getUserData()), ret);
        }
        if (stepDataList.size() > 1) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u4e0a\u4e00\u4e2a\u6b65\u9aa4\u6709\u591a\u4e2a\u64cd\u4f5c\u8005\uff0c\u65e0\u6cd5\u8fdb\u884c\u64a4\u56de\u5904\u7406", (Object)wpParam.getUserData()), null);
        }
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
        if (this.wfConfig == null) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.wfInstance.getWFINSTANCEID()), null);
        }
        String strWFPName = this.wfInstance.getACTIVESTEPNAME();
        WFBaseProcessConfig curProcessConfig = this.wfConfig.FindProcessConfigByName(strWFPName);
        if (curProcessConfig == null) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)strWFPName), null);
        }
        this.activeStep = new WFStep();
        this.activeStep.setWFSTEPID(this.wfInstance.getACTIVESTEPID());
        ret = this.InternalExecuteProcess(curProcessConfig);
        if (ret == null || ret.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u5904\u7406[%1$s]\u64a4\u56de\u5904\u7406\u5931\u8d25", (Object)lastWFStepData.getWFSTEPID()), ret);
        }
        ret = this.InternalFinishProcess(curProcessConfig);
        if (ret == null || ret.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u5b8c\u6210\u4ea4\u4e92\u5904\u7406[%1$s]\u64a4\u56de\u5904\u7406\u5931\u8d25", (Object)lastWFStepData.getWFSTEPID()), ret);
        }
        WFStepData stepData = new WFStepData();
        stepData.setWFSTEPDATANAME("\u6d41\u7a0b\u64a4\u56de");
        stepData.setWFSTEPDATAID(Helper.GenGuidEx());
        stepData.setCONNECTIONNAME(TAG_SRFWFROLLBACK);
        stepData.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
        stepData.setACTORID(this.strCurUserId);
        stepData.setDESCRIPTION(wpParam.getDescription());
        stepData.setWFSTEPID(this.wfInstance.getACTIVESTEPID());
        ret = this.wfDataCtrlEx.AddRawWFStepData(this, stepData);
        if (ret == null || ret.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("RollbackIAAction", "", ret);
        }
        strWFPName = lastWFStepData.GetParamStringValue("WFPNAME", "");
        WFBaseProcessConfig nextProcessConfig = this.wfConfig.FindProcessConfigByName(strWFPName);
        if (nextProcessConfig == null) {
            return this.LogAndReturn("RollbackIAAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)strWFPName), null);
        }
        this.rollbackStepActors.clear();
        ret = this.wfDataCtrl.GetWFStepActor(lastWFStepData.getWFSTEPID(), this.rollbackStepActors);
        if (ret == null || ret.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("RollbackIAAction", "\u83b7\u53d6\u4e0a\u4e00\u6b21\u64cd\u4f5c\u7528\u6237\u5931\u8d25", ret);
        }
        ret = this.InternalExecute(nextProcessConfig);
        ret.setUserObject((Object)this.runInfo.toString());
        return ret;
    }

    public CallResult TimeoutIAAction(WFParam wpParam) {
        CallResult ret;
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        this.runInfo.Reset();
        boolean bIAGoto = false;
        String strConnection = wpParam.getConnection();
        if (StringHelper.Compare((String)strConnection, (String)TAG_SRFWFIAGOTO, (boolean)true) == 0) {
            wpParam.setConnection(TAG_SRFWFTIMEOUT);
            bIAGoto = true;
        }
        if ((ret = this.GetUserData(wpParam)) == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("TimeoutIAAction", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u8d85\u65f6\u5904\u7406", (Object)wpParam.getUserData()), null);
        }
        if (!bIAGoto && StringHelper.Compare((String)wpParam.getStepId(), (String)this.wfInstance.getACTIVESTEPNAME(), (boolean)true) != 0) {
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)wpParam.getUserData(), (Object)wpParam.getStepId(), (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
        if (this.wfConfig == null) {
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.wfInstance.getWFINSTANCEID()), null);
        }
        WFBaseProcessConfig curProcessConfig = this.wfConfig.FindProcessConfigByName(this.wfInstance.getACTIVESTEPNAME());
        if (curProcessConfig == null) {
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        WFStepData stepData = new WFStepData();
        stepData.setWFSTEPDATAID(Helper.GenGuidEx());
        stepData.setWFSTEPID(this.wfInstance.getACTIVESTEPNAME());
        stepData.setCONNECTIONNAME(wpParam.getConnection());
        stepData.setDESCRIPTION(wpParam.getDescription());
        stepData.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
        WFBaseProcessConfig nextProcessConfig = null;
        if (!bIAGoto) {
            String strTimeoutNext = "";
            if (curProcessConfig instanceof WFInteractiveProcessConfig) {
                WFInteractiveProcessConfig iaProcessConfig = (WFInteractiveProcessConfig)curProcessConfig;
                strTimeoutNext = iaProcessConfig.getTimeoutNext();
            }
            if (curProcessConfig instanceof WFBaseEmbedWFConfig) {
                this.UserCloseUnfinishEmbedWorkflows(this.wfInstance.getACTIVESTEPID(), false, "\u7236\u6d41\u7a0b\u8d85\u65f6\u7ed3\u675f\u5f53\u524d\u6b65\u9aa4");
                WFBaseEmbedWFConfig embedWorkflowConfig = (WFBaseEmbedWFConfig)curProcessConfig;
                strTimeoutNext = embedWorkflowConfig.getTimeoutNext();
            }
            if (StringHelper.IsNullOrEmpty((String)strTimeoutNext)) {
                return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u6307\u5b9a\u5904\u7406[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d85\u65f6\u8def\u5f84", (Object)this.wfInstance.getACTIVESTEPNAME()), null);
            }
            stepData.setWFSTEPDATANAME("\u8d85\u65f6\u5904\u7406");
            nextProcessConfig = this.wfConfig.FindProcessConfigByName(strTimeoutNext);
            if (nextProcessConfig == null) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)strTimeoutNext), null);
            }
        } else {
            nextProcessConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(wpParam.getStepId());
            if (nextProcessConfig == null) {
                return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6d41\u7a0b\u6b65\u9aa4\u503c[%1$s]\u5bf9\u5e94\u7684\u5904\u7406", (Object)wpParam.getStepId()), null);
            }
            if (curProcessConfig instanceof WFBaseEmbedWFConfig) {
                this.UserCloseUnfinishEmbedWorkflows(this.wfInstance.getACTIVESTEPID(), false, "\u7236\u6d41\u7a0b\u6b65\u9aa4\u8df3\u8f6c\u7ed3\u675f\u5f53\u524d\u6b65\u9aa4");
            }
            stepData.setWFSTEPDATANAME("\u6b65\u9aa4\u8df3\u8f6c\u5904\u7406");
        }
        stepData.setACTORID(this.strCurUserId);
        callResult = this.wfDataCtrl.AddWFStepData(stepData, this.strCurUserId);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u6b65\u9aa4[%1$s]\u8d85\u65f6\u5904\u7406\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
        }
        this.activeStep = new WFStep();
        this.activeStep.setWFSTEPID(stepData.getWFSTEPID());
        callResult = this.InternalExecuteProcess(curProcessConfig);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u5904\u7406[%1$s]\u8d85\u65f6\u5904\u7406\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
        }
        callResult = this.InternalFinishProcess(curProcessConfig);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("TimeoutIAAction", StringHelper.Format((String)"\u5b8c\u6210\u4ea4\u4e92\u5904\u7406[%1$s]\u8d85\u65f6\u5904\u7406\u5931\u8d25", (Object)stepData.getWFSTEPID()), callResult);
        }
        callResult = this.InternalExecute(nextProcessConfig);
        callResult.setUserObject((Object)this.runInfo.toString());
        return callResult;
    }

    protected boolean TestRoleConnection(String strConnection, int nRoleActorCount, TreeMap<String, Integer> connCountMap, String strNextCondition, String strIAUnion) {
        int nCount = 0;
        if (connCountMap.containsKey(strConnection)) {
            nCount = connCountMap.get(strConnection);
        }
        if (StringHelper.Compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
            if (nCount > 0) {
                return true;
            }
        } else {
            TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
            String strOtherIA = strIAUnion;
            if (!StringHelper.IsNullOrEmpty((String)strOtherIA)) {
                strOtherIA = strOtherIA.toUpperCase();
                String[] ias = strOtherIA.split("[;]");
                int i = 0;
                while (i < ias.length) {
                    if (StringHelper.Compare((String)ias[i], (String)strConnection, (boolean)true) != 0) {
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
            if (StringHelper.Compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                nActionCount = nActorCount;
            } else if (strNextCondition.indexOf("%") != -1) {
                strNextCondition = strNextCondition.replaceAll("[%]", "");
                fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
                fPercent /= 100.0;
            } else {
                try {
                    nActionCount = Integer.parseInt(strNextCondition);
                }
                catch (Exception ex) {
                    fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
                }
            }
            if (nActionCount >= 1 ? nCount >= nActionCount : fPercent > 0.0 && nActorCount != 0 && (double)nCount / (double)nActorCount >= fPercent) {
                return true;
            }
        }
        return false;
    }

    public CallResult ResubmitAction(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        CallResult ret = this.GetUserData(wpParam);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("ResubmitAction", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u91cd\u65b0\u6307\u6d3e\u7528\u6237\u5904\u7406", (Object)wpParam.getUserData()), null);
        }
        if (StringHelper.Compare((String)wpParam.getStepId(), (String)this.wfInstance.getACTIVESTEPNAME(), (boolean)true) != 0) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)wpParam.getUserData(), (Object)wpParam.getStepId(), (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
        if (this.wfConfig == null) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.wfInstance.getWFINSTANCEID()), null);
        }
        WFBaseProcessConfig curProcessConfig = this.wfConfig.FindProcessConfigByName(this.wfInstance.getACTIVESTEPNAME());
        if (curProcessConfig == null) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        WFStepData stepData = new WFStepData();
        stepData.setWFSTEPDATAID(Helper.GenGuidEx());
        stepData.setWFSTEPID(wpParam.getStepId());
        stepData.setACTORID(this.strCurUserId);
        stepData.setDESCRIPTION(wpParam.getDescription());
        stepData.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
        WFInteractiveProcessConfig iaProcessConfig = null;
        if (curProcessConfig instanceof WFInteractiveProcessConfig) {
            iaProcessConfig = (WFInteractiveProcessConfig)curProcessConfig;
            if (iaProcessConfig.getIAActionsConfig().size() == 0) {
                return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u4ea4\u4e92\u64cd\u4f5c"), null);
            }
            WFInteractiveActionConfig iaActionConfig = (WFInteractiveActionConfig)((Object)iaProcessConfig.getIAActionsConfig().get(0));
            stepData.setWFSTEPDATANAME(iaActionConfig.getLogicName());
            stepData.setCONNECTIONNAME(iaActionConfig.getName());
        }
        if ((callResult = this.wfDataCtrl.TestWFStepData(stepData, this.strCurUserId)) == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u5224\u65ad\u6267\u884c\u91cd\u65b0\u6307\u6d3e\u7528\u6237\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
        }
        WFActor wfActor = new WFActor();
        wfActor.setWFACTORID(wpParam.getConnection());
        callResult = this.wfDataCtrl.GetWFActor(wpParam.getConnection(), wfActor);
        if (ret == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u67e5\u8be2\u6307\u5b9a\u5de5\u4f5c\u6d41\u7528\u6237[%1$s]\u5931\u8d25", (Object)wpParam.getConnection()), ret);
        }
        stepData.setWFSTEPDATANAME(StringHelper.Format((String)"\u5c06\u5de5\u4f5c\u8f6c\u79fb\u81f3[%1$s]", (Object)wfActor.getWFACTORNAME()));
        stepData.setCONNECTIONNAME("SRFWFRESUBMIT");
        stepData.setSDPARAM(wpParam.getConnection());
        callResult = this.wfDataCtrl.AddWFStepData(stepData, this.strCurUserId);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u6267\u884c\u6307\u6d3e\u4ea4\u4e92\u6b65\u9aa4[%1$s]\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
        }
        if (this.wfDataCtrlEx != null && ((ret = this.wfDataCtrlEx.UpdateCurWFStepActors(this)) == null || ret.getRetCode() != 0)) {
            return this.LogAndReturn("ResubmitAction", StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f8b\u6b65\u9aa4\u4ea4\u4e92\u7528\u6237\u5931\u8d25"), ret);
        }
        if (iaProcessConfig != null && iaProcessConfig.isSendInform()) {
            Vector<String> actors = new Vector<String>();
            actors.add(wpParam.getConnection());
            this.wfDataCtrl.SendWFStepActorInformMsg(actors, this.wfInstance, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public CallResult UserClose(WFParam wpParam) {
        return this.UserClose(wpParam, true);
    }

    public CallResult UserClose(WFParam wpParam, boolean bSubmitEmbedWF) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        CallResult ret = this.GetUserData(wpParam);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("UserClose", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", ret);
        }
        CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        String strActiveStepId = this.wfInstance.getACTIVESTEPID();
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u518d\u6b21\u5173\u95ed", (Object)wpParam.getUserData()), null);
        }
        if (this.wfDataCtrlEx != null && (ret = this.wfDataCtrlEx.TestCancelWF(this)).getRetCode() != 0) {
            return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u6570\u636e[%1$s]\u6d41\u7a0b\u53d6\u6d88\u5931\u8d25", (Object)wpParam.getUserData()), ret);
        }
        this.wfInstance.setCANCELREASON(wpParam.getDescription());
        callResult = this.wfDataCtrl.UserCloseWFInstance(this.wfInstance, this.strCurUserId);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u5f3a\u884c\u5173\u95ed\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
        }
        String strSQL = this.workflow.getUSERDATACMD5();
        if (!(StringHelper.IsNullOrEmpty((String)strSQL) || (ret = this.wfDataCtrl.ExecRawSql(strSQL = StringHelper.Format((String)strSQL, (Object)this.wfInstance.getUSERDATA(), (Object)this.wfInstance.getUSERDATA2(), (Object)this.wfInstance.getUSERDATA3(), (Object)this.wfInstance.getUSERDATA4(), (Object)this.strCurUserId))) != null && ret.getRetCode() == 0)) {
            return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u5b9e\u4f8b\u88ab\u5f3a\u884c\u5173\u95ed\uff0c\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
        }
        if (this.wfDataCtrlEx != null && ((ret = this.wfDataCtrlEx.UpdateCurWFStepActors(this)) == null || ret.getRetCode() != 0)) {
            return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f8b\u6b65\u9aa4\u4ea4\u4e92\u7528\u6237\u5931\u8d25"), ret);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.wfInstance.getPWFINSTANCEID()) && bSubmitEmbedWF) {
            return this.EmbedWorkflowSubmit(this.wfInstance.getPWFINSTANCEID(), this.getActiveObject(), false);
        }
        callResult = this.UserCloseUnfinishEmbedWorkflows(strActiveStepId, false, "\u7236\u6d41\u7a0b\u5b9e\u4f8b\u5df2\u7ecf\u88ab\u5173\u95ed");
        return callResult;
    }

    protected CallResult CancelStartNew(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        CallResult callResult = new CallResult();
        this.wfInstance.setCANCELREASON(wpParam.getDescription());
        String strActiveStepId = this.wfInstance.getACTIVESTEPID();
        if (this.wfDataCtrlEx != null && ((callResult = this.wfDataCtrlEx.CancelStartWFInstance(this.wfInstance, this.strCurUserId)) == null || callResult.getRetCode() != 0)) {
            return this.LogAndReturn("CancelStart", StringHelper.Format((String)"\u53d6\u6d88\u542f\u52a8\u6d41\u7a0b\u5b9e\u4f8b\u5931\u8d25"), callResult);
        }
        callResult = this.UserCloseUnfinishEmbedWorkflows(strActiveStepId, false, "\u7236\u6d41\u7a0b\u5b9e\u4f8b\u5df2\u7ecf\u88ab\u5173\u95ed");
        return callResult;
    }

    public CallResult MarkReadFlag(WFParam wpParam) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        WFStepActor wfStepActor = new WFStepActor();
        wfStepActor.setACTORID(this.strCurUserId);
        wfStepActor.setWFSTEPID(wpParam.getStepId());
        if (this.wfDataCtrlEx != null) {
            CallResult callResult = this.GetUserData(wpParam);
            if (callResult == null || callResult.getRetCode() != 0) {
                return this.LogAndReturn("MarkReadFlag", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", callResult);
            }
            callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
            if (callResult == null || callResult.getRetCode() != 0) {
                return this.LogAndReturn("UserClose", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
            }
            callResult = this.wfDataCtrlEx.MarkWFStepActorReadFlag(this, wfStepActor);
            if (callResult.getRetCode() != 0) {
                return this.LogAndReturn("MarkReadFlag", StringHelper.Format((String)"\u6570\u636e[%1$s]\u6807\u8bb0\u7528\u6237\u8bfb\u53d6\u6570\u636e\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
            }
        }
        return new CallResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult GetIAProcess(WFParam wpParam) {
        boolean bUserData = false;
        if (!StringHelper.IsNullOrEmpty((String)wpParam.getUserData())) {
            CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getWorkflowId(), wpParam.getUserData(), wpParam.getUserData2(), wpParam.getUserData3(), wpParam.getUserData4(), this.wfInstance);
            if (callResult == null || callResult.getRetCode() != 0) {
                return this.LogAndReturn("GetIAProcess", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getUserData()), callResult);
            }
            this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
            if (this.iWFWorkflowHelper != null) {
                BaseDataEntity tempDataEntity = new BaseDataEntity();
                callResult = this.wfDataCtrl.GetWFUserData(this.workflow, wpParam, tempDataEntity);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return this.LogAndReturn("GetUserData", StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25"), callResult);
                }
                tempDataEntity.CopyTo(this.activeDataEntity, false);
            }
            this.RefreshUserData();
            bUserData = true;
        } else {
            this.wfConfig = this.wfModelStorage.FindWFConfig(this.workflow);
        }
        if (this.wfConfig == null) {
            return this.LogAndReturn("GetIAProcess", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25"), null);
        }
        WFBaseProcessConfig processConfig = null;
        if (!StringHelper.IsNullOrEmpty((String)wpParam.getStepId())) {
            processConfig = this.wfConfig.FindProcessConfigByName(wpParam.getStepId());
        }
        if (processConfig == null && !StringHelper.IsNullOrEmpty((String)wpParam.getCodeListItemValue())) {
            processConfig = this.wfConfig.FindProcessConfigByCodeListItemValue(wpParam.getCodeListItemValue());
        }
        if (processConfig == null || !(processConfig instanceof WFInteractiveProcessConfig)) {
            return this.LogAndReturn("GetIAActions", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5904\u7406\u914d\u7f6e[%1$s][%2$s]", (Object)wpParam.getStepId(), (Object)wpParam.getCodeListItemValue()), null);
        }
        processConfig.SetValue("VERSION", this.wfConfig.GetExtValue("VERSION", "1"));
        WFInteractiveProcessConfig iaProcessConfig = (WFInteractiveProcessConfig)processConfig;
        String strUserActions = iaProcessConfig.getUserActions();
        if (!StringHelper.IsNullOrEmpty((String)strUserActions)) {
            WFInteractiveProcessConfig wFInteractiveProcessConfig = iaProcessConfig;
            synchronized (wFInteractiveProcessConfig) {
                if (iaProcessConfig.getUserActionList().size() == 0) {
                    String[] userActions = strUserActions.split(";");
                    int i = 0;
                    while (i < userActions.length) {
                        WFAction action = new WFAction();
                        CallResult ret = this.wfDataCtrl.GetWFAction(this.workflow.getWFWORKFLOWID(), userActions[i], action);
                        if (ret != null && ret.getRetCode() == 0) {
                            iaProcessConfig.getUserActionList().add(action);
                        }
                        ++i;
                    }
                }
            }
        }
        CallResult ret = new CallResult();
        ret.setRetCode(0);
        ret.setErrorInfo("");
        ret.setUserObject((Object)processConfig);
        boolean bActorIAActionControl = iaProcessConfig.isActorIAActionControl();
        if (bActorIAActionControl) {
            WFInteractiveProcessConfig iaProcessConfig2;
            iaProcessConfig = iaProcessConfig2 = (WFInteractiveProcessConfig)((Object)iaProcessConfig.clone());
            ArrayList<WFInteractiveActionConfig> removeList = new ArrayList<WFInteractiveActionConfig>();
            Iterator iterator = iaProcessConfig.getIAActionsConfig().iterator();
            while (iterator.hasNext()) {
                WFInteractiveActionConfig iaActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
                if (!iaActionConfig.isActorIAActionControl()) continue;
                boolean bActorHavePrivilege = false;
                Iterator<String> actorIds = iaActionConfig.ListActorIds();
                while (actorIds.hasNext()) {
                    String strActorId = actorIds.next();
                    try {
                        if (!this.TestWFActor(strActorId, wpParam.getOpPersonId(), bUserData)) continue;
                        bActorHavePrivilege = true;
                        break;
                    }
                    catch (Exception ex) {
                        return this.LogAndReturn("GetIAActions", StringHelper.Format((String)"\u5224\u65ad\u5f53\u524d\u7528\u6237\u662f\u5426\u5728\u4ea4\u4e92\u7528\u6237\u4e2d\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), null);
                    }
                }
                if (bActorHavePrivilege) continue;
                if (bUserData) {
                    Iterator<String> udActorIds = iaActionConfig.ListUDActorIds();
                    while (udActorIds.hasNext()) {
                        String strActorId = udActorIds.next();
                        try {
                            if (!this.TestUDActor(strActorId, wpParam.getOpPersonId())) continue;
                            bActorHavePrivilege = true;
                        }
                        catch (Exception ex) {
                            return this.LogAndReturn("GetIAActions", StringHelper.Format((String)"\u5224\u65ad\u5f53\u524d\u7528\u6237\u662f\u5426\u5728\u4ea4\u4e92\u7528\u6237\u4e2d\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), null);
                        }
                    }
                }
                if (bActorHavePrivilege) continue;
                removeList.add(iaActionConfig);
            }
            for (WFInteractiveActionConfig removeItem : removeList) {
                iaProcessConfig.getIAActionsConfig().remove((Object)removeItem);
            }
            String strUserTag = wpParam.getOpPersonId();
            if (bUserData) {
                strUserTag = String.valueOf(strUserTag) + "|" + wpParam.getUserData();
            }
            strUserTag = Helper.GenMD5((String)strUserTag);
            iaProcessConfig.SetExtValue("USERTAG", strUserTag);
            ret.setUserObject((Object)iaProcessConfig);
        }
        if (this.iWFWorkflowHelper != null) {
            try {
                iaProcessConfig = this.iWFWorkflowHelper.ReCalcInteractiveProcess(this, iaProcessConfig);
                ret.setUserObject((Object)iaProcessConfig);
            }
            catch (Exception e) {
                ret.setRetCode(1);
                ret.setErrorInfo(e.getMessage());
                log.error((Object)StringHelper.Format((String)"\u91cd\u65b0\u8ba1\u7b97\u4ea4\u4e92\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            }
        }
        return ret;
    }

    protected boolean TestWFActor(String strWFActorId, String strUserId, boolean bActiveData) throws Exception {
        WFActor wfActor = new WFActor();
        CallResult ret = this.wfDataCtrl.GetWFActor(strWFActorId, wfActor);
        if (ret == null || ret.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u64cd\u4f5c\u8005[%1$s]\u5931\u8d25", (Object)strUserId));
        }
        if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"USER", (boolean)true) == 0) {
            return StringHelper.Compare((String)strWFActorId, (String)strUserId, (boolean)true) == 0;
        }
        if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"USERGROUP", (boolean)true) == 0) {
            Vector<WFUser> wfUsers = new Vector<WFUser>();
            ret = this.wfDataCtrl.GetWFUserGroupDetail(strWFActorId, wfUsers);
            if (ret == null || ret.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u7528\u6237\u7ec4[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)strUserId));
            }
            for (WFUser wfUser : wfUsers) {
                if (StringHelper.Compare((String)wfUser.getWFUSERID(), (String)strUserId, (boolean)true) != 0) continue;
                return true;
            }
            return false;
        }
        if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"SYSTEMUSER", (boolean)true) == 0) {
            Vector<WFUser> wfUsers = new Vector<WFUser>();
            ret = this.wfDataCtrl.GetWFSystemUser(this, strWFActorId, wfUsers);
            if (ret == null || ret.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u7cfb\u7edf\u7528\u6237[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)strUserId));
            }
            for (WFUser wfUser : wfUsers) {
                if (StringHelper.Compare((String)wfUser.getWFUSERID(), (String)strUserId, (boolean)true) != 0) continue;
                return true;
            }
            return false;
        }
        if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"DYNAMICUSER", (boolean)true) == 0) {
            String strDynamicUserObject = wfActor.getWFACTORPARAM();
            if (StringHelper.IsNullOrEmpty((String)strDynamicUserObject)) {
                throw new Exception(StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u6ca1\u6709\u6307\u5b9a\u5904\u7406\u5bf9\u8c61", (Object)strUserId));
            }
            Object objDynamicUser = ObjectHelper.Create((String)strDynamicUserObject);
            if (objDynamicUser == null) {
                throw new Exception(StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u5efa\u7acb\u5bf9\u8c61[%2$s]\u5931\u8d25", (Object)wfActor.getWFACTORID(), (Object)strDynamicUserObject));
            }
            if (!(objDynamicUser instanceof ISRFWFDynamicUser)) {
                throw new Exception(StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)wfActor.getWFACTORID(), (Object)strDynamicUserObject));
            }
            ISRFWFDynamicUser iDynamicUser = (ISRFWFDynamicUser)objDynamicUser;
            Vector<WFUser> wfUsers = new Vector<WFUser>();
            ret = iDynamicUser.GetUsers(this, wfActor, wfUsers);
            if (ret == null || ret.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)wfActor.getWFACTORID()));
            }
            for (WFUser wfUser : wfUsers) {
                if (StringHelper.Compare((String)wfUser.getWFUSERID(), (String)strUserId, (boolean)true) != 0) continue;
                return true;
            }
            return false;
        }
        return false;
    }

    protected boolean TestUDActor(String strUDActorId, String strUserId) throws Exception {
        String strUDUserId = this.getActiveObject().GetParamStringValue(strUDActorId, "");
        return StringHelper.Compare((String)strUDUserId, (String)strUserId, (boolean)false) == 0;
    }

    @Override
    public BaseDataEntity getActiveObject() {
        return this.activeDataEntity;
    }

    @Override
    public String getCurUserId() {
        return this.strCurUserId;
    }

    @Override
    public BaseDBCallerHelperEx getDBCallerHelperEx() {
        return this.dbCallerHelper;
    }

    @Override
    public void Log(int logLevel, Object obj, String strLogInfo) {
        String strTotalLogInfo = StringHelper.Format((String)"[%1$s]%2$s", (Object)obj, (Object)strLogInfo);
        switch (logLevel) {
            case 0: {
                LoggerEx.info((Log)log, (Object)strTotalLogInfo, null, (Object)this, (Object)obj.getClass().getName(), (Object)this.wfInstance.getWFWORKFLOWID(), (Object)this.wfInstance.getWFINSTANCEID(), (Object)this.wfInstance.getUSERDATA());
                break;
            }
            case 1: {
                LoggerEx.error((Log)log, (Object)strTotalLogInfo, null, (Object)this, (Object)obj.getClass().getName(), (Object)this.wfInstance.getWFWORKFLOWID(), (Object)this.wfInstance.getWFINSTANCEID(), (Object)this.wfInstance.getUSERDATA());
                break;
            }
            case 2: {
                LoggerEx.fatal((Log)log, (Object)strTotalLogInfo, null, (Object)this, (Object)obj.getClass().getName(), (Object)this.wfInstance.getWFWORKFLOWID(), (Object)this.wfInstance.getWFINSTANCEID(), (Object)this.wfInstance.getUSERDATA());
                break;
            }
            case 4: {
                LoggerEx.warn((Log)log, (Object)strTotalLogInfo, null, (Object)this, (Object)obj.getClass().getName(), (Object)this.wfInstance.getWFWORKFLOWID(), (Object)this.wfInstance.getWFINSTANCEID(), (Object)this.wfInstance.getUSERDATA());
            }
        }
    }

    @Override
    public void setNext(String strCurNext) {
        this.strCurNext = strCurNext;
    }

    @Override
    public WFBaseProcessConfig getCurProcessConfig() {
        return this.curProcessConfig;
    }

    @Override
    public String getInteractiveConnection() {
        return this.strInteractiveConnection;
    }

    @Override
    public void setFinishInteractiveProcess(boolean finish) {
        this.bFinishInteractiveProcess = finish;
    }

    @Override
    public ContextHelper getContextHelper() {
        return this.contextHelper;
    }

    protected CallResult InternalExecute(WFBaseProcessConfig processConfig) {
        if (processConfig == null) {
            processConfig = this.wfConfig.GetStartProcessConfig();
        }
        if (processConfig == null) {
            return this.LogAndReturn("InternalExecute", "\u6ca1\u6709\u627e\u5230\u8d77\u59cb\u7684\u6267\u884c\u8282\u70b9", null);
        }
        if (processConfig.isAsynchronousProcess() && !this.bThreadMode) {
            SRFWFDefaultEngineThread engineThread = new SRFWFDefaultEngineThread(processConfig);
            engineThread.start();
            return new CallResult();
        }
        int nLoopCount = 0;
        do {
            CallResult result;
            if ((result = this.InternalPrepareProcess(processConfig)) == null || result.getRetCode() != 0) {
                return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"\u51c6\u5907\u6267\u884c\u5904\u7406[%1$s][%2$s]", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), result);
            }
            if (processConfig.isTerminalProcess()) {
                result = this.InternalFinishProcess(processConfig);
                if (result == null || result.getRetCode() != 0) {
                    return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"\u5b8c\u6210\u6267\u884c\u5904\u7406[%1$s][%2$s]", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), result);
                }
                return this.InternalFinishWorkflow();
            }
            if (processConfig.isSuspendProcess()) {
                return new CallResult();
            }
            this.strCurNext = "";
            result = this.InternalExecuteProcess(processConfig);
            if (result == null || result.getRetCode() != 0) {
                return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"\u6267\u884c\u5904\u7406[%1$s][%2$s]", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), result);
            }
            result = this.InternalFinishProcess(processConfig);
            if (result == null || result.getRetCode() != 0) {
                return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"\u5b8c\u6210\u6267\u884c\u5904\u7406[%1$s][%2$s]", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), result);
            }
            if (StringHelper.IsNullOrEmpty((String)this.strCurNext)) {
                return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"[%1$s][%2$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), null);
            }
            processConfig = this.wfConfig.FindProcessConfigByName(this.strCurNext);
            if (processConfig == null) {
                return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d[%1$s]\u5904\u7406\u8282\u70b9", (Object)this.strCurNext), null);
            }
            if (++nLoopCount < this.nMaxLoopCount) continue;
            return this.LogAndReturn("InternalExecute", StringHelper.Format((String)"\u5904\u7406\u5df2\u7ecf\u8d85\u8fc7[%1$s]\u6b21\uff0c\u7cfb\u7edf\u4e2d\u65ad", (Object)this.nMaxLoopCount), null);
        } while (!processConfig.isAsynchronousProcess() || this.bThreadMode);
        SRFWFDefaultEngineThread engineThread = new SRFWFDefaultEngineThread(processConfig);
        engineThread.start();
        return new CallResult();
    }

    protected CallResult InternalPrepareProcess(WFBaseProcessConfig processConfig) {
        block94: {
            try {
                WFStepInst stepInst;
                Vector<WFParam> startWFInstances;
                Vector<WFParam> wfParams;
                CallResult ret;
                CallResult ret2;
                int nTimeout;
                if (processConfig instanceof WFHopProcessConfig) {
                    return new CallResult();
                }
                Date curDate = new Date();
                this.activeStep = null;
                WFStep wfStep = new WFStep();
                wfStep.setWFSTEPID(Helper.GenGuidEx());
                wfStep.setWFINSTANCEID(this.wfInstance.getWFINSTANCEID());
                wfStep.setWFPNAME(processConfig.getName());
                wfStep.setWFPLOGICNAME(processConfig.getLogicName());
                wfStep.setISINTERACTIVE(processConfig.isSuspendProcess());
                wfStep.setWFVERSION(this.workflow.getWFVERSION());
                wfStep.setSTARTTIME(new Timestamp(curDate.getTime()));
                if (processConfig instanceof WFInteractiveProcessConfig) {
                    WFInteractiveProcessConfig iaProcessConfig = (WFInteractiveProcessConfig)processConfig;
                    wfStep.setWFSTEPNAME(iaProcessConfig.getCodeListItemValue());
                    nTimeout = iaProcessConfig.getTimeout();
                    if (!StringHelper.IsNullOrEmpty((String)iaProcessConfig.getTimeoutField())) {
                        nTimeout = this.activeDataEntity.GetParamIntValue(iaProcessConfig.getTimeoutField(), nTimeout);
                        log.debug((Object)StringHelper.Format((String)"\u8ba1\u7b97\u5de5\u4f5c\u6d41\u8d85\u65f6\uff08\u52a8\u6001\u5c5e\u6027\uff09[%1$s]=[%2$s]", (Object)iaProcessConfig.getTimeoutField(), (Object)nTimeout));
                    }
                    if (nTimeout > 0) {
                        ret2 = this.wfDataCtrl.CalcTimeout(new Timestamp(curDate.getTime()), iaProcessConfig.getTimeoutType(), nTimeout, iaProcessConfig.getWorktimeType());
                        if (ret2 == null || ret2.getRetCode() != 0) {
                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u8ba1\u7b97\u8d85\u65f6\u65f6\u95f4", (Object)processConfig.getName()), ret2);
                        }
                        wfStep.SetParamValue("DEADLINE", ret2.getUserObject());
                    }
                }
                if (processConfig instanceof WFEmbedWorkflowConfig) {
                    WFEmbedWorkflowConfig embedWorkflowConfig = (WFEmbedWorkflowConfig)processConfig;
                    wfStep.setWFSTEPNAME(embedWorkflowConfig.getCodeListItemValue());
                    nTimeout = embedWorkflowConfig.getTimeout();
                    if (!StringHelper.IsNullOrEmpty((String)embedWorkflowConfig.getTimeoutField())) {
                        nTimeout = this.activeDataEntity.GetParamIntValue(embedWorkflowConfig.getTimeoutField(), nTimeout);
                        log.debug((Object)StringHelper.Format((String)"\u8ba1\u7b97\u5de5\u4f5c\u6d41\u8d85\u65f6\uff08\u52a8\u6001\u5c5e\u6027\uff09[%1$s]=[%2$s]", (Object)embedWorkflowConfig.getTimeoutField(), (Object)nTimeout));
                    }
                    if (nTimeout > 0) {
                        ret2 = this.wfDataCtrl.CalcTimeout(new Timestamp(curDate.getTime()), embedWorkflowConfig.getTimeoutType(), nTimeout, embedWorkflowConfig.getWorktimeType());
                        if (ret2 == null || ret2.getRetCode() != 0) {
                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u8ba1\u7b97\u8d85\u65f6\u65f6\u95f4", (Object)processConfig.getName()), ret2);
                        }
                        wfStep.SetParamValue("DEADLINE", ret2.getUserObject());
                    }
                }
                if (processConfig instanceof WFParallelSubWFConfig) {
                    WFParallelSubWFConfig parallelSubWFConfig = (WFParallelSubWFConfig)processConfig;
                    wfStep.setWFSTEPNAME(parallelSubWFConfig.getCodeListItemValue());
                    nTimeout = parallelSubWFConfig.getTimeout();
                    if (!StringHelper.IsNullOrEmpty((String)parallelSubWFConfig.getTimeoutField())) {
                        nTimeout = this.activeDataEntity.GetParamIntValue(parallelSubWFConfig.getTimeoutField(), nTimeout);
                        log.debug((Object)StringHelper.Format((String)"\u8ba1\u7b97\u5de5\u4f5c\u6d41\u8d85\u65f6\uff08\u52a8\u6001\u5c5e\u6027\uff09[%1$s]=[%2$s]", (Object)parallelSubWFConfig.getTimeoutField(), (Object)nTimeout));
                    }
                    if (nTimeout > 0) {
                        ret2 = this.wfDataCtrl.CalcTimeout(new Timestamp(curDate.getTime()), parallelSubWFConfig.getTimeoutType(), nTimeout, parallelSubWFConfig.getWorktimeType());
                        if (ret2 == null || ret2.getRetCode() != 0) {
                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u8ba1\u7b97\u8d85\u65f6\u65f6\u95f4", (Object)processConfig.getName()), ret2);
                        }
                        wfStep.SetParamValue("DEADLINE", ret2.getUserObject());
                    }
                }
                if ((ret = this.wfDataCtrl.AddWFStep(wfStep, this.strCurUserId)) == null || ret.getRetCode() != 0) {
                    return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4", (Object)processConfig.getName()), ret);
                }
                this.activeStep = wfStep;
                if (!processConfig.isSuspendProcess()) break block94;
                String strSQL = this.workflow.getUSERDATACMD3();
                if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                    ret = this.wfDataCtrl.ExecRawSql(strSQL = StringHelper.Format((String)strSQL, (Object)this.wfInstance.getUSERDATA(), (Object)this.wfInstance.getUSERDATA2(), (Object)this.wfInstance.getUSERDATA3(), (Object)this.wfInstance.getUSERDATA4(), (Object)this.strCurUserId, (Object)processConfig.getName(), (Object)processConfig.getCodeListItemValue()));
                    if (ret == null || ret.getRetCode() != 0) {
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u66f4\u65b0\u6267\u884c\u6b65\u9aa4\u81f3\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
                    }
                } else {
                    this.wfDataCtrl.UpdateWFUserDataRunStep(this.wfInstance, processConfig.getCodeListItemValue(), this.strCurUserId);
                }
                if ((ret = this.RefreshUserData()) == null || ret.getRetCode() != 0) {
                    return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u5237\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
                }
                if (processConfig instanceof WFInteractiveProcessConfig) {
                    Object strUDActors;
                    Object actors;
                    Hashtable<Object, String> wfStepActorMap = new Hashtable<Object, String>();
                    WFInteractiveProcessConfig iaProcessConfig = (WFInteractiveProcessConfig)processConfig;
                    if (this.rollbackStepActors.size() > 0) {
                        for (WFStepActor lastWFStepActor : this.rollbackStepActors) {
                            WFStepActor stepActor = new WFStepActor();
                            stepActor.setWFSTEPACTORNAME(lastWFStepActor.getWFSTEPACTORNAME());
                            stepActor.setROLEID(lastWFStepActor.getROLEID());
                            stepActor.setWFSTEPACTORID(Helper.GenGuidEx());
                            stepActor.setWFSTEPID(wfStep.getWFSTEPID());
                            stepActor.setISREADONLY(false);
                            stepActor.setACTORID(lastWFStepActor.getACTORID());
                            stepActor.setACTORTYPE(1);
                            ret = this.wfDataCtrl.AddWFStepActor(stepActor, this.strCurUserId);
                            if (ret == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
                                return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u89d2\u8272[%1$s]\u5931\u8d25", (Object)lastWFStepActor.getACTORID()), ret);
                            }
                            wfStepActorMap.put(stepActor.getACTORID(), stepActor.getACTORID());
                        }
                        this.rollbackStepActors.clear();
                    } else {
                        WFStepActor stepActor;
                        boolean bActorIAActionControl = iaProcessConfig.isActorIAActionControl();
                        String strActors = iaProcessConfig.getActors();
                        if (!StringHelper.IsNullOrEmpty((String)strActors)) {
                            actors = strActors.split(";");
                            int nCount = ((String[])actors).length;
                            int i = 0;
                            while (i < nCount) {
                                WFInteractiveActionConfig iaActionConfig;
                                Iterator iterator;
                                String strActions;
                                WFStepActor stepActor2;
                                Vector<WFUser> wfUsers;
                                WFActor wfActor = new WFActor();
                                ret = this.wfDataCtrl.GetWFActor(actors[i], wfActor);
                                if (ret == null || ret.getRetCode() != 0) {
                                    return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u64cd\u4f5c\u8005[%1$s]\u5931\u8d25", (Object)actors[i]), ret);
                                }
                                if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"USER", (boolean)true) == 0) {
                                    if (this.nextIAStepActorMap == null || this.nextIAStepActorMap.containsKey(wfActor.getWFACTORID())) {
                                        stepActor = new WFStepActor();
                                        stepActor.setWFSTEPACTORNAME(wfActor.getWFACTORNAME());
                                        stepActor.setROLEID(wfActor.getWFACTORID());
                                        stepActor.setWFSTEPACTORID(Helper.GenGuidEx());
                                        stepActor.setWFSTEPID(wfStep.getWFSTEPID());
                                        stepActor.setISREADONLY(false);
                                        stepActor.setACTORID((String)actors[i]);
                                        stepActor.setACTORTYPE(1);
                                        if (bActorIAActionControl) {
                                            String strActions2 = "";
                                            Iterator iterator2 = iaProcessConfig.getIAActionsConfig().iterator();
                                            while (iterator2.hasNext()) {
                                                Object iaActionConfig2 = (WFInteractiveActionConfig)((Object)iterator2.next());
                                                if (((WFInteractiveActionConfig)((Object)iaActionConfig2)).isActorIAActionControl() && !((WFInteractiveActionConfig)((Object)iaActionConfig2)).isContainsActor((String)actors[i])) continue;
                                                if (!StringHelper.IsNullOrEmpty((String)strActions2)) {
                                                    strActions2 = String.valueOf(strActions2) + ";";
                                                }
                                                strActions2 = String.valueOf(strActions2) + StringHelper.Format((String)"(%1$s)", (Object)((WFBaseConnectionConfig)((Object)iaActionConfig2)).getName());
                                            }
                                            if (StringHelper.IsNullOrEmpty((String)strActions2)) {
                                                strActions2 = "NONE";
                                            }
                                            stepActor.setIAACTIONS(strActions2);
                                        }
                                        if ((ret = this.wfDataCtrl.AddWFStepActor(stepActor, this.strCurUserId)) == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
                                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u89d2\u8272[%1$s]\u5931\u8d25", (Object)actors[i]), ret);
                                        }
                                        wfStepActorMap.put(actors[i], stepActor.getACTORID());
                                    }
                                } else if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"USERGROUP", (boolean)true) == 0) {
                                    wfUsers = new Vector<WFUser>();
                                    ret = this.wfDataCtrl.GetWFUserGroupDetail((String)actors[i], wfUsers);
                                    if (ret == null || ret.getRetCode() != 0) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u7528\u6237\u7ec4[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)actors[i]), ret);
                                    }
                                    for (WFUser wfUser : wfUsers) {
                                        if (this.nextIAStepActorMap != null && !this.nextIAStepActorMap.containsKey(wfUser.getWFUSERID())) continue;
                                        stepActor2 = new WFStepActor();
                                        stepActor2.setWFSTEPACTORNAME(wfActor.getWFACTORNAME());
                                        stepActor2.setROLEID(wfActor.getWFACTORID());
                                        stepActor2.setWFSTEPACTORID(Helper.GenGuidEx());
                                        stepActor2.setWFSTEPID(wfStep.getWFSTEPID());
                                        stepActor2.setISREADONLY(false);
                                        stepActor2.setACTORID(wfUser.getWFUSERID());
                                        stepActor2.setACTORTYPE(1);
                                        if (bActorIAActionControl) {
                                            strActions = "";
                                            iterator = iaProcessConfig.getIAActionsConfig().iterator();
                                            while (iterator.hasNext()) {
                                                iaActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
                                                if (iaActionConfig.isActorIAActionControl() && !iaActionConfig.isContainsActor((String)actors[i])) continue;
                                                if (!StringHelper.IsNullOrEmpty((String)strActions)) {
                                                    strActions = String.valueOf(strActions) + ";";
                                                }
                                                strActions = String.valueOf(strActions) + StringHelper.Format((String)"(%1$s)", (Object)iaActionConfig.getName());
                                            }
                                            if (StringHelper.IsNullOrEmpty((String)strActions)) {
                                                strActions = "NONE";
                                            }
                                            stepActor2.setIAACTIONS(strActions);
                                        }
                                        if ((ret = this.wfDataCtrl.AddWFStepActor(stepActor2, this.strCurUserId)) == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
                                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u89d2\u8272[%1$s]\u5931\u8d25", (Object)wfUser.getWFUSERID()), ret);
                                        }
                                        wfStepActorMap.put(wfUser.getWFUSERID(), stepActor2.getACTORID());
                                    }
                                } else if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"SYSTEMUSER", (boolean)true) == 0) {
                                    wfUsers = new Vector();
                                    ret = this.wfDataCtrl.GetWFSystemUser(this, (String)actors[i], wfUsers);
                                    if (ret == null || ret.getRetCode() != 0) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u7cfb\u7edf\u7528\u6237[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)actors[i]), ret);
                                    }
                                    for (WFUser wfUser : wfUsers) {
                                        if (this.nextIAStepActorMap != null && !this.nextIAStepActorMap.containsKey(wfUser.getWFUSERID())) continue;
                                        stepActor2 = new WFStepActor();
                                        stepActor2.setWFSTEPACTORNAME(wfActor.getWFACTORNAME());
                                        stepActor2.setROLEID(wfActor.getWFACTORID());
                                        stepActor2.setWFSTEPACTORID(Helper.GenGuidEx());
                                        stepActor2.setWFSTEPID(wfStep.getWFSTEPID());
                                        stepActor2.setISREADONLY(false);
                                        stepActor2.setACTORID(wfUser.getWFUSERID());
                                        stepActor2.setACTORTYPE(1);
                                        if (bActorIAActionControl) {
                                            strActions = "";
                                            iterator = iaProcessConfig.getIAActionsConfig().iterator();
                                            while (iterator.hasNext()) {
                                                iaActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
                                                if (iaActionConfig.isActorIAActionControl() && !iaActionConfig.isContainsActor((String)actors[i])) continue;
                                                if (!StringHelper.IsNullOrEmpty((String)strActions)) {
                                                    strActions = String.valueOf(strActions) + ";";
                                                }
                                                strActions = String.valueOf(strActions) + StringHelper.Format((String)"(%1$s)", (Object)iaActionConfig.getName());
                                            }
                                            if (StringHelper.IsNullOrEmpty((String)strActions)) {
                                                strActions = "NONE";
                                            }
                                            stepActor2.setIAACTIONS(strActions);
                                        }
                                        if ((ret = this.wfDataCtrl.AddWFStepActor(stepActor2, this.strCurUserId)) == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
                                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u89d2\u8272[%1$s]\u5931\u8d25", (Object)wfUser.getWFUSERID()), ret);
                                        }
                                        wfStepActorMap.put(wfUser.getWFUSERID(), stepActor2.getACTORID());
                                    }
                                } else if (StringHelper.Compare((String)wfActor.getWFACTORTYPE(), (String)"DYNAMICUSER", (boolean)true) == 0) {
                                    String strDynamicUserObject = wfActor.getWFACTORPARAM();
                                    if (StringHelper.IsNullOrEmpty((String)strDynamicUserObject)) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u6ca1\u6709\u6307\u5b9a\u5904\u7406\u5bf9\u8c61", (Object)wfActor.getWFACTORID()), ret);
                                    }
                                    Object objDynamicUser = ObjectHelper.Create((String)strDynamicUserObject);
                                    if (objDynamicUser == null) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u5efa\u7acb\u5bf9\u8c61[%2$s]\u5931\u8d25", (Object)wfActor.getWFACTORID(), (Object)strDynamicUserObject), ret);
                                    }
                                    if (!(objDynamicUser instanceof ISRFWFDynamicUser)) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)wfActor.getWFACTORID(), (Object)strDynamicUserObject), ret);
                                    }
                                    ISRFWFDynamicUser iDynamicUser = (ISRFWFDynamicUser)objDynamicUser;
                                    Vector<WFUser> wfUsers2 = new Vector<WFUser>();
                                    ret = iDynamicUser.GetUsers(this, wfActor, wfUsers2);
                                    if (ret == null || ret.getRetCode() != 0) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237[%1$s]\u660e\u7ec6\u5931\u8d25", (Object)actors[i]), ret);
                                    }
                                    for (WFUser wfUser : wfUsers2) {
                                        if (this.nextIAStepActorMap != null && !this.nextIAStepActorMap.containsKey(wfUser.getWFUSERID())) continue;
                                        WFStepActor stepActor3 = new WFStepActor();
                                        stepActor3.setWFSTEPACTORNAME(wfActor.getWFACTORNAME());
                                        stepActor3.setROLEID(wfActor.getWFACTORID());
                                        if (!StringHelper.IsNullOrEmpty((String)wfUser.getROLEID())) {
                                            stepActor3.setROLEID(wfUser.getROLEID());
                                        }
                                        stepActor3.setWFSTEPACTORID(Helper.GenGuidEx());
                                        stepActor3.setWFSTEPID(wfStep.getWFSTEPID());
                                        stepActor3.setISREADONLY(false);
                                        stepActor3.setACTORID(wfUser.getWFUSERID());
                                        stepActor3.setACTORTYPE(1);
                                        if (bActorIAActionControl) {
                                            String strActions3 = "";
                                            Iterator iterator3 = iaProcessConfig.getIAActionsConfig().iterator();
                                            while (iterator3.hasNext()) {
                                                WFInteractiveActionConfig iaActionConfig3 = (WFInteractiveActionConfig)((Object)iterator3.next());
                                                if (iaActionConfig3.isActorIAActionControl() && !iaActionConfig3.isContainsActor((String)actors[i])) continue;
                                                if (!StringHelper.IsNullOrEmpty((String)strActions3)) {
                                                    strActions3 = String.valueOf(strActions3) + ";";
                                                }
                                                strActions3 = String.valueOf(strActions3) + StringHelper.Format((String)"(%1$s)", (Object)iaActionConfig3.getName());
                                            }
                                            if (StringHelper.IsNullOrEmpty((String)strActions3)) {
                                                strActions3 = "NONE";
                                            }
                                            stepActor3.setIAACTIONS(strActions3);
                                        }
                                        if ((ret = this.wfDataCtrl.AddWFStepActor(stepActor3, this.strCurUserId)) == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
                                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u89d2\u8272[%1$s]\u5931\u8d25", (Object)wfUser.getWFUSERID()), ret);
                                        }
                                        wfStepActorMap.put(wfUser.getWFUSERID(), stepActor3.getACTORID());
                                    }
                                }
                                ++i;
                            }
                        }
                        if (!StringHelper.IsNullOrEmpty((String)(strUDActors = iaProcessConfig.getUDActors()))) {
                            String[] actors2 = ((String)strUDActors).split(";");
                            int nCount = actors2.length;
                            int i = 0;
                            while (i < nCount) {
                                stepActor = new WFStepActor();
                                stepActor.setWFSTEPACTORID(Helper.GenGuidEx());
                                stepActor.setWFSTEPID(wfStep.getWFSTEPID());
                                stepActor.setISREADONLY(false);
                                Object objRealUserId = this.activeDataEntity.GetParamValue(actors2[i]);
                                if (objRealUserId == null) {
                                    this.Log(1, this, StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u7528\u6237\u6570\u636e\u4e2d\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)actors2[i]));
                                } else {
                                    stepActor.setACTORID(objRealUserId.toString());
                                    stepActor.setACTORTYPE(2);
                                    if (bActorIAActionControl) {
                                        String strActions = "";
                                        Iterator iterator = iaProcessConfig.getIAActionsConfig().iterator();
                                        while (iterator.hasNext()) {
                                            WFInteractiveActionConfig iaActionConfig = (WFInteractiveActionConfig)((Object)iterator.next());
                                            if (iaActionConfig.isActorIAActionControl() && !iaActionConfig.isContainsUDActor(actors2[i])) continue;
                                            if (!StringHelper.IsNullOrEmpty((String)strActions)) {
                                                strActions = String.valueOf(strActions) + ";";
                                            }
                                            strActions = String.valueOf(strActions) + StringHelper.Format((String)"(%1$s)", (Object)iaActionConfig.getName());
                                        }
                                        if (StringHelper.IsNullOrEmpty((String)strActions)) {
                                            strActions = "NONE";
                                        }
                                        stepActor.setIAACTIONS(strActions);
                                    }
                                    if ((ret = this.wfDataCtrl.AddWFStepActor(stepActor, this.strCurUserId)) == null || ret.getRetCode() != 0 && ret.getRetCode() != 1007) {
                                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u89d2\u8272[%1$s]\u5931\u8d25", (Object)actors2[i]), ret);
                                    }
                                    wfStepActorMap.put(objRealUserId.toString(), stepActor.getACTORID());
                                }
                                ++i;
                            }
                        }
                    }
                    int nOrderFlag = 1;
                    strUDActors = iaProcessConfig.getIAActionsConfig().iterator();
                    while (strUDActors.hasNext()) {
                        WFInteractiveActionConfig iaActionConfig = (WFInteractiveActionConfig)((Object)strUDActors.next());
                        WFIAAction iaAction = new WFIAAction();
                        iaAction.setWFIAACTIONID(Helper.GenGuidEx());
                        iaAction.setWFSTEPID(wfStep.getWFSTEPID());
                        iaAction.setACTIONNAME(iaActionConfig.getName());
                        iaAction.setACTIONLOGICNAME(iaActionConfig.getLogicName());
                        iaAction.setACTIONCOUNT(iaActionConfig.getActionCount());
                        iaAction.setPAGEPATH(iaActionConfig.getPagePath());
                        iaAction.setPANELID(iaActionConfig.getPanelId());
                        iaAction.setFAHELPER(iaActionConfig.getFAHelper());
                        iaAction.setORDERFLAG(nOrderFlag);
                        iaAction.setNEXTTO(iaActionConfig.getNext());
                        iaAction.setNEXTCONDITION(iaActionConfig.getNextCondition());
                        ret = this.wfDataCtrl.AddWFIAAction(iaAction, this.strCurUserId);
                        if (ret == null || ret.getRetCode() != 0) {
                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u63d2\u5165\u5b9e\u4f8b\u6b65\u9aa4\u4ea4\u4e92\u884c\u4e3a[%1$s]", (Object)iaActionConfig.getLogicName()), ret);
                        }
                        ++nOrderFlag;
                    }
                    if (iaProcessConfig.isSendInform()) {
                        Hashtable<String, String> wfStepActorMapReal = new Hashtable<String, String>();
                        for (String strActorId : wfStepActorMap.keySet()) {
                            String strRealActorId = (String)wfStepActorMap.get(strActorId);
                            if (StringHelper.IsNullOrEmpty((String)strRealActorId)) {
                                strRealActorId = strActorId;
                            }
                            wfStepActorMapReal.put(strRealActorId, "");
                        }
                        actors = new Vector();
                        for (String strActorId : wfStepActorMapReal.keySet()) {
                            ((Vector)actors).add(strActorId);
                        }
                        this.wfDataCtrl.SendWFStepActorInformMsg((Vector<String>)actors, this.wfInstance, iaProcessConfig.getMsgTemplateId(), iaProcessConfig.getMsgType());
                    }
                    if (this.wfDataCtrlEx != null && ((ret = this.wfDataCtrlEx.UpdateCurWFStepActors(this)) == null || ret.getRetCode() != 0)) {
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f8b\u6b65\u9aa4\u4ea4\u4e92\u7528\u6237\u5931\u8d25"), ret);
                    }
                }
                if (processConfig instanceof WFEmbedWorkflowConfig) {
                    if (this.wfDataCtrlEx == null) {
                        ret.setRetCode(1);
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u5f53\u524d\u6570\u636e\u5bf9\u8c61\u4e0d\u652f\u6301\u5d4c\u5957\u5de5\u4f5c\u6d41"), ret);
                    }
                    wfParams = new Vector<WFParam>();
                    ret = this.wfDataCtrlEx.GetEmbedWorkflows(this, (WFEmbedWorkflowConfig)processConfig, wfParams);
                    if (ret.IsError()) {
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u83b7\u53d6\u5d4c\u5957\u5de5\u4f5c\u6d41\u5931\u8d25"), ret);
                    }
                    startWFInstances = new Vector<WFParam>();
                    for (WFParam wfParam : wfParams) {
                        wfParam.setPInstanceId(this.getInstance().getWFINSTANCEID());
                        wfParam.setStepId(wfStep.getWFSTEPID());
                        ret = this.StartEmbedWorkflow(wfParam);
                        if (ret.IsError()) {
                            this.CloseEmbedWorkflows(startWFInstances, "\u65e0\u6cd5\u542f\u52a8\u5176\u5b83\u76f8\u5173\u5d4c\u5957\u6d41\u7a0b\uff0c\u5173\u95ed\u5f53\u524d\u6d41\u7a0b\u3002");
                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u542f\u52a8\u5d4c\u5957\u5de5\u4f5c\u6d41\u5931\u8d25"), ret);
                        }
                        startWFInstances.add(wfParam);
                    }
                    for (WFParam startItem : startWFInstances) {
                        stepInst = new WFStepInst();
                        stepInst.setWFSTEPINSTID(Helper.GenGuidEx());
                        stepInst.setWFINSTANCEID(startItem.getInstanceId());
                        stepInst.setWFSTEPID(wfStep.getWFSTEPID());
                        ret = this.wfDataCtrlEx.AddWFStepInst(this, stepInst);
                        if (!ret.IsError()) continue;
                        this.CloseEmbedWorkflows(startWFInstances, "\u9644\u52a0\u5d4c\u5957\u5de5\u4f5c\u6d41\u5230\u5f53\u524d\u6b65\u9aa4\u5931\u8d25\uff0c\u5173\u95ed\u5f53\u524d\u6d41\u7a0b\u3002");
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u9644\u52a0\u5d4c\u5957\u5de5\u4f5c\u6d41\u5230\u5f53\u524d\u6b65\u9aa4\u5931\u8d25"), ret);
                    }
                }
                if (processConfig instanceof WFParallelSubWFConfig) {
                    if (this.wfDataCtrlEx == null) {
                        ret.setRetCode(1);
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u5f53\u524d\u6570\u636e\u5bf9\u8c61\u4e0d\u652f\u6301\u5e76\u884c\u5b50\u6d41\u7a0b"), ret);
                    }
                    wfParams = new Vector();
                    ret = this.wfDataCtrlEx.GetParallelSubWFs(this, (WFParallelSubWFConfig)processConfig, wfParams);
                    if (ret.IsError()) {
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u83b7\u53d6\u5e76\u884c\u5b50\u6d41\u7a0b\u5931\u8d25"), ret);
                    }
                    startWFInstances = new Vector();
                    for (WFParam wfParam : wfParams) {
                        wfParam.setPInstanceId(this.getInstance().getWFINSTANCEID());
                        wfParam.setStepId(wfStep.getWFSTEPID());
                        ret = this.StartEmbedWorkflow(wfParam);
                        if (ret.IsError()) {
                            this.CloseEmbedWorkflows(startWFInstances, "\u65e0\u6cd5\u542f\u52a8\u5176\u5b83\u76f8\u5173\u5e76\u884c\u5b50\u6d41\u7a0b\uff0c\u5173\u95ed\u5f53\u524d\u6d41\u7a0b\u3002");
                            return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u542f\u52a8\u5e76\u884c\u5b50\u6d41\u7a0b\u5931\u8d25"), ret);
                        }
                        startWFInstances.add(wfParam);
                    }
                    for (WFParam startItem : startWFInstances) {
                        stepInst = new WFStepInst();
                        stepInst.setWFSTEPINSTID(Helper.GenGuidEx());
                        stepInst.setWFINSTANCEID(startItem.getInstanceId());
                        stepInst.setWFSTEPID(wfStep.getWFSTEPID());
                        ret = this.wfDataCtrlEx.AddWFStepInst(this, stepInst);
                        if (!ret.IsError()) continue;
                        this.CloseEmbedWorkflows(startWFInstances, "\u9644\u52a0\u5e76\u884c\u5b50\u6d41\u7a0b\u5230\u5f53\u524d\u6b65\u9aa4\u5931\u8d25\uff0c\u5173\u95ed\u5f53\u524d\u6d41\u7a0b\u3002");
                        return this.LogAndReturn("InternalPrepareProcess", StringHelper.Format((String)"\u9644\u52a0\u5e76\u884c\u5b50\u6d41\u7a0b\u5230\u5f53\u524d\u6b65\u9aa4\u5931\u8d25"), ret);
                    }
                }
            }
            catch (Exception ex) {
                return this.LogAndReturn2("InternalPrepareProcess", "BeforeExecute", ex);
            }
        }
        return new CallResult();
    }

    protected CallResult InternalFinishProcess(WFBaseProcessConfig processConfig) {
        try {
            if (processConfig instanceof WFHopProcessConfig) {
                return new CallResult();
            }
            if (this.activeStep == null) {
                return this.LogAndReturn2("InternalFinishProcess", "\u5f53\u524d\u6b65\u9aa4\u65e0\u6548", null);
            }
            WFStep wfStep = new WFStep();
            this.activeStep.CopyTo(wfStep, true);
            CallResult ret = this.wfDataCtrl.FinishWFStep(wfStep, this.strCurUserId);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("InternalFinishProcess", StringHelper.Format((String)"\u5b8c\u6210\u5b9e\u4f8b\u6b65\u9aa4", (Object)processConfig.getName()), ret);
            }
        }
        catch (Exception ex) {
            return this.LogAndReturn2("InternalFinishProcess", "", ex);
        }
        return new CallResult();
    }

    protected CallResult InternalFinishWorkflow() {
        try {
            CallResult ret = this.wfDataCtrl.FinishWFInstance(this.wfInstance, this.strCurUserId);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("InternalFinishWorkflow", StringHelper.Format((String)"\u5b8c\u6210\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)this.wfInstance.getWFINSTANCEID()), ret);
            }
            String strSQL = this.workflow.getUSERDATACMD4();
            if (!(StringHelper.IsNullOrEmpty((String)strSQL) || (ret = this.wfDataCtrl.ExecRawSql(strSQL = StringHelper.Format((String)strSQL, (Object)this.wfInstance.getUSERDATA(), (Object)this.wfInstance.getUSERDATA2(), (Object)this.wfInstance.getUSERDATA3(), (Object)this.wfInstance.getUSERDATA4(), (Object)this.strCurUserId))) != null && ret.getRetCode() == 0)) {
                return this.LogAndReturn("InternalFinishWorkflow", StringHelper.Format((String)"\u5b9e\u4f8b\u6267\u884c\u5b8c\u6bd5\u66f4\u65b0\u7528\u6237\u6570\u636e"), ret);
            }
            if (this.wfDataCtrlEx != null && ((ret = this.wfDataCtrlEx.UpdateCurWFStepActors(this)) == null || ret.getRetCode() != 0)) {
                return this.LogAndReturn("InternalFinishWorkflow", StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f8b\u6b65\u9aa4\u4ea4\u4e92\u7528\u6237\u5931\u8d25"), ret);
            }
            if (!StringHelper.IsNullOrEmpty((String)this.wfInstance.getPWFINSTANCEID())) {
                this.RefreshUserData();
                return this.EmbedWorkflowSubmit(this.wfInstance.getPWFINSTANCEID(), this.getActiveObject(), true);
            }
        }
        catch (Exception ex) {
            return this.LogAndReturn2("InternalFinishWorkflow", "", ex);
        }
        return new CallResult();
    }

    protected CallResult InternalExecuteProcess(WFBaseProcessConfig processConfig) {
        CallResult ret;
        if (processConfig instanceof WFHopProcessConfig) {
            this.strCurNext = ((WFHopProcessConfig)processConfig).getNext();
            return new CallResult();
        }
        String strProcessObject = processConfig.getObject();
        if (StringHelper.IsNullOrEmpty((String)strProcessObject)) {
            return this.LogAndReturn("InternalExecuteProcess", "\u5904\u7406\u5bf9\u8c61\u65e0\u6548", null);
        }
        Object objProcess = ObjectHelper.Create((String)strProcessObject);
        if (objProcess == null) {
            return this.LogAndReturn("InternalExecuteProcess", StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strProcessObject), null);
        }
        ISRFWFProcess iWFProcess = null;
        if (!(objProcess instanceof ISRFWFProcess)) {
            return this.LogAndReturn("InternalExecuteProcess", StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3ISRFWFProcess", (Object)strProcessObject), null);
        }
        iWFProcess = (ISRFWFProcess)objProcess;
        this.curProcessConfig = processConfig;
        try {
            ret = iWFProcess.BeforeExecute(this);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("InternalExecuteProcess", "BeforeExecute", ret);
            }
        }
        catch (Exception ex) {
            return this.LogAndReturn2("InternalExecuteProcess", "BeforeExecute", ex);
        }
        try {
            ret = iWFProcess.Execute(this);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("InternalExecuteProcess", "Execute", ret);
            }
        }
        catch (Exception ex) {
            return this.LogAndReturn2("InternalExecuteProcess", "Execute", ex);
        }
        try {
            ret = iWFProcess.AfterExecute(this);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("InternalExecuteProcess", "AfterExecute", ret);
            }
        }
        catch (Exception ex) {
            return this.LogAndReturn2("InternalExecuteProcess", "AfterExecute", ex);
        }
        return new CallResult();
    }

    protected CallResult InternalExecuteInteractiveProcess(WFBaseProcessConfig processConfig) {
        this.strCurNext = "";
        this.bFinishInteractiveProcess = false;
        CallResult callResult = this.InternalExecuteProcess(processConfig);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("InternalExecuteInteractiveProcess", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u5904\u7406[%1$s]\u5931\u8d25", (Object)processConfig.getName()), callResult);
        }
        if (!this.bFinishInteractiveProcess) {
            return new CallResult();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strCurNext)) {
            return this.LogAndReturn("InternalExecuteInteractiveProcess", StringHelper.Format((String)"[%1$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9", (Object)processConfig.getName()), null);
        }
        processConfig = this.wfConfig.FindProcessConfigByName(this.strCurNext);
        if (processConfig == null) {
            return this.LogAndReturn("InternalExecuteInteractiveProcess", StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d[%1$s]\u5904\u7406\u8282\u70b9", (Object)this.strCurNext), null);
        }
        return this.InternalExecuteProcess(processConfig);
    }

    protected CallResult LogAndReturn(String strFunc, String strErrorInfo, CallResult ret) {
        String strRealErrorInfo = "";
        strRealErrorInfo = !StringHelper.IsNullOrEmpty((String)strErrorInfo) ? (ret == null || StringHelper.IsNullOrEmpty((String)ret.getErrorInfo()) ? strErrorInfo : StringHelper.Format((String)"%1$s\uff0c%2$s", (Object)strErrorInfo, (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()))) : StringHelper.Format((String)"%1$s", (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()));
        this.Log(1, this, strRealErrorInfo);
        if (ret != null) {
            ret.setErrorInfo(strRealErrorInfo);
            return ret;
        }
        CallResult callResult = new CallResult();
        if (ret == null) {
            callResult.setRetCode(1);
        } else {
            callResult.setRetCode(ret.getRetCode());
        }
        callResult.setErrorInfo(strRealErrorInfo);
        return callResult;
    }

    protected CallResult LogAndReturn2(String strFunc, String strErrorInfo, Exception ex) {
        String strRealErrorInfo = StringHelper.Format((String)"%1$s\uff0c%2$s", (Object)strErrorInfo, (Object)ex.getMessage());
        this.Log(1, this, strRealErrorInfo);
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        callResult.setErrorInfo(strRealErrorInfo);
        return callResult;
    }

    public int getMaxLoopCount() {
        return this.nMaxLoopCount;
    }

    public void setMaxLoopCount(int maxLoopCount) {
        this.nMaxLoopCount = maxLoopCount;
    }

    protected CallResult GetUserData(WFParam wpParam) {
        BaseDataEntity tempDataEntity = new BaseDataEntity();
        if (!StringHelper.IsNullOrEmpty((String)this.workflow.getUSERDATACMD())) {
            String strSql = StringHelper.Format((String)this.workflow.getUSERDATACMD(), (Object)wpParam.getUserData(), (Object)wpParam.getUserData2(), (Object)wpParam.getUserData3(), (Object)wpParam.getUserData4(), (Object)this.strCurUserId);
            CallResult ret = this.wfDataCtrl.GetWFUserData(strSql, tempDataEntity);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("GetUserData", StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25[%1$s]", (Object)strSql), ret);
            }
            tempDataEntity.CopyTo(this.activeDataEntity, false);
            return ret;
        }
        CallResult ret = this.wfDataCtrl.GetWFUserData(this.workflow, wpParam, tempDataEntity);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("GetUserData", StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
        }
        tempDataEntity.CopyTo(this.activeDataEntity, false);
        return ret;
    }

    protected CallResult RefreshUserData() {
        WFParam wpParam = new WFParam();
        wpParam.setUserData(this.wfInstance.getUSERDATA());
        wpParam.setUserData2(this.wfInstance.getUSERDATA2());
        wpParam.setUserData3(this.wfInstance.getUSERDATA3());
        wpParam.setUserData4(this.wfInstance.getUSERDATA4());
        BaseDataEntity tempDataEntity = new BaseDataEntity();
        if (!StringHelper.IsNullOrEmpty((String)this.workflow.getUSERDATACMD())) {
            String strSql = StringHelper.Format((String)this.workflow.getUSERDATACMD(), (Object)wpParam.getUserData(), (Object)wpParam.getUserData2(), (Object)wpParam.getUserData3(), (Object)wpParam.getUserData4(), (Object)this.strCurUserId);
            CallResult ret = this.wfDataCtrl.GetWFUserData(strSql, tempDataEntity);
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("GetUserData", StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25[%1$s]", (Object)strSql), ret);
            }
            tempDataEntity.CopyTo(this.activeDataEntity, false);
            return ret;
        }
        CallResult ret = this.wfDataCtrl.GetWFUserData(this.workflow, wpParam, tempDataEntity);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("GetUserData", StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25"), ret);
        }
        tempDataEntity.CopyTo(this.activeDataEntity, false);
        return ret;
    }

    @Override
    public String GetWorkflowId() {
        return this.workflow.getWFWORKFLOWID();
    }

    @Override
    public void AppendReturnInfo(String strInfo) {
        if (!StringHelper.IsNullOrEmpty((String)this.runInfo.toString())) {
            this.runInfo.Append("\r\n");
        }
        this.runInfo.Append(strInfo);
    }

    @Override
    public WFInstance getInstance() {
        return this.wfInstance;
    }

    @Override
    public String GetUserTag() {
        return this.strUserTag;
    }

    @Override
    public String GetUserTag2() {
        return this.strUserTag2;
    }

    @Override
    public Object getAttribute(String strName) {
        if (this.attributes == null) {
            return null;
        }
        return this.attributes.get(strName);
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
        if (this.attributes == null) {
            this.attributes = new TreeMap();
        }
        this.attributes.put(strName, objValue);
    }

    protected CallResult StartEmbedWorkflow(WFParam wfParam) {
        wfParam.setOpPersonId(this.strCurUserId);
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        CallResult callResult = defaultEngine.Init(this.servletContext, this.dbCallerHelper, wfParam.getWorkflowId());
        if (callResult.IsError()) {
            return callResult;
        }
        return defaultEngine.StartNew(wfParam);
    }

    protected CallResult CloseEmbedWorkflow(WFParam wfParam) {
        wfParam.setOpPersonId(this.strCurUserId);
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        CallResult callResult = defaultEngine.Init(this.servletContext, this.dbCallerHelper, wfParam.getWorkflowId());
        if (callResult.IsError()) {
            return callResult;
        }
        return defaultEngine.UserClose(wfParam);
    }

    protected void CloseEmbedWorkflows(Vector<WFParam> wfParams, String strReason) {
        for (WFParam startItem : wfParams) {
            startItem.setDescription(strReason);
            this.CloseEmbedWorkflow(startItem);
        }
    }

    protected CallResult EmbedWorkflowSubmit(String strPWFInstanceId, BaseDataEntity dataEntity, boolean bNormalClose) {
        WFInstance pWFInstance = new WFInstance();
        CallResult callResult = this.wfDataCtrl.GetWFInstance(strPWFInstanceId, pWFInstance);
        if (callResult.IsError()) {
            this.Log(1, this, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strPWFInstanceId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
        callResult = defaultEngine.Init(this.servletContext, this.dbCallerHelper, pWFInstance.getWFWORKFLOWID());
        if (callResult.IsError()) {
            return callResult;
        }
        WFParam wfParam = new WFParam();
        wfParam.setOpPersonId(this.strCurUserId);
        wfParam.setInstanceId(strPWFInstanceId);
        wfParam.setStepId(this.wfInstance.getPSTEPID());
        return defaultEngine.SubmitEmbedWorkflow(wfParam, this.wfInstance.getWFINSTANCEID(), dataEntity, bNormalClose);
    }

    public CallResult SubmitEmbedWorkflow(WFParam wpParam, String strWFInstanceId, BaseDataEntity dataEntity, boolean bNormalClose) {
        this.strCurUserId = wpParam.getOpPersonId();
        this.strUserTag = wpParam.getUserTag();
        this.strUserTag2 = wpParam.getUserTag2();
        this.runInfo.Reset();
        if (this.wfDataCtrlEx == null) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u5f53\u524d\u6570\u636e\u5bf9\u8c61\u4e0d\u652f\u6301\u5d4c\u5957\u5de5\u4f5c\u6d41"), null);
        }
        CallResult callResult = this.wfDataCtrl.GetWFInstance(wpParam.getInstanceId(), this.wfInstance);
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)wpParam.getInstanceId()), callResult);
        }
        callResult = this.RefreshUserData();
        if (callResult == null || callResult.getRetCode() != 0) {
            return this.LogAndReturn("SubmitEmbedWorkflow", "\u83b7\u53d6\u7528\u6237\u6570\u636e\u5931\u8d25", callResult);
        }
        if (this.wfInstance.isCLOSE()) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u8fdb\u884c\u4ea4\u4e92\u5904\u7406", (Object)wpParam.getInstanceId()), null);
        }
        if (StringHelper.Compare((String)wpParam.getStepId(), (String)this.wfInstance.getACTIVESTEPID(), (boolean)true) != 0) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u63d0\u4ea4\u5b9e\u4f8b[%1$s]\u5904\u7406\u6b65\u9aa4[%2$s]\u4e0e\u5f53\u524d\u6b65\u9aa4[%3$s]\u4e0d\u4e00\u81f4", (Object)wpParam.getInstanceId(), (Object)wpParam.getStepId(), (Object)this.wfInstance.getACTIVESTEPID()), null);
        }
        this.wfConfig = this.wfModelStorage.FindWFConfig(this.wfInstance);
        if (this.wfConfig == null) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u5904\u7406\u914d\u7f6e\u5931\u8d25[%1$s]", (Object)this.wfInstance.getWFINSTANCEID()), null);
        }
        WFBaseProcessConfig curProcessConfig = this.wfConfig.FindProcessConfigByName(this.wfInstance.getACTIVESTEPNAME());
        if (curProcessConfig == null) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)this.wfInstance.getACTIVESTEPNAME()), null);
        }
        callResult = this.wfDataCtrlEx.GetEmbedWorkflowReturnValue(this, strWFInstanceId, dataEntity, curProcessConfig);
        if (callResult.IsError()) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u5d4c\u5165\u6d41\u7a0b\u8fd4\u56de\u503c\u5931\u8d25", (Object)this.wfInstance.getACTIVESTEPNAME()), callResult);
        }
        WFBaseEmbedWFConfig baseEmbedConfig = (WFBaseEmbedWFConfig)curProcessConfig;
        WFStepInst stepInst = new WFStepInst();
        stepInst.setWFSTEPINSTID(Helper.GenGuidEx());
        stepInst.setWFSTEPID(wpParam.getStepId());
        stepInst.setWFINSTANCEID(strWFInstanceId);
        if (bNormalClose) {
            stepInst.setCLOSEFLAG(0);
            stepInst.setRETURNDATA(callResult.getUserObject() == null ? "" : callResult.getUserObject().toString());
        } else {
            stepInst.setCLOSEFLAG(1);
            stepInst.setRETURNDATA(EMBEDWFRETURN_USERCLOSE);
        }
        callResult = this.wfDataCtrlEx.CloseWFStepInst(this, stepInst);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u6267\u884c\u5d4c\u5957\u6d41\u7a0b[%1$s]\u5931\u8d25", (Object)wpParam.getStepId()), callResult);
        }
        WFEmbedWFReturnConfig wfReturnConfig = baseEmbedConfig.getEmbedWFReturnsConfig().FindEmbedWFReturnConfigByName(stepInst.getRETURNDATA());
        if (wfReturnConfig == null) {
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5bf9\u5e94\u7684\u503c\u8fd4\u56de[%1$s]\u8fde\u63a5", (Object)stepInst.getRETURNDATA()), null);
        }
        callResult = this.wfDataCtrlEx.GetWFStepInstCount(this, stepInst.getWFSTEPID(), stepInst.getRETURNDATA());
        if (callResult == null || callResult.getRetCode() != 0) {
            this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
            return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u5d4c\u5957\u6d41\u7a0b\u8fd4\u56de\u503c\u6570\u91cf[%1$s]\u5931\u8d25", (Object)stepInst.getWFSTEPID()), callResult);
        }
        boolean bGoNext = false;
        int nCount = (Integer)callResult.getUserObject();
        String strNextCondition = wfReturnConfig.getNextCondition();
        String[] conds = strNextCondition.split("[|]");
        if (conds.length >= 1) {
            strNextCondition = conds[0];
        }
        TreeMap<String, Integer> otherIAMap = new TreeMap<String, Integer>();
        if (conds.length >= 2) {
            String strOtherIA = conds[1];
            if (!StringHelper.IsNullOrEmpty((String)(strOtherIA = strOtherIA.toUpperCase()))) {
                String[] ias = strOtherIA.split("[;]");
                int i = 0;
                while (i < ias.length) {
                    if (StringHelper.Compare((String)ias[i], (String)stepInst.getRETURNDATA(), (boolean)true) != 0) {
                        otherIAMap.put(ias[i], 0);
                    }
                    ++i;
                }
            }
        }
        if (StringHelper.Compare((String)strNextCondition, (String)"ANY", (boolean)true) == 0) {
            if (nCount > 0) {
                bGoNext = true;
            }
        } else {
            for (String strIA : otherIAMap.keySet()) {
                callResult = this.wfDataCtrlEx.GetWFStepInstCount(this, stepInst.getWFSTEPID(), strIA);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                    return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u8fd4\u56de\u503c\u6570\u636e\u6570\u91cf[%1$s]\u5931\u8d25", (Object)stepInst.getWFSTEPID()), callResult);
                }
                int nIAActionCount = (Integer)callResult.getUserObject();
                nCount += nIAActionCount;
            }
            callResult = this.wfDataCtrlEx.GetWFStepInstCount(this, stepInst.getWFSTEPID());
            if (callResult == null || callResult.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u4ea4\u4e92\u64cd\u4f5c\u7528\u6237\u6570\u91cf[%1$s]\u5931\u8d25", (Object)stepInst.getWFSTEPID()), callResult);
            }
            int nActionCount = -1;
            int nActorCount = (Integer)callResult.getUserObject();
            double fPercent = 0.0;
            if (StringHelper.Compare((String)strNextCondition, (String)"ALL", (boolean)true) == 0) {
                nActionCount = nActorCount;
            } else if (strNextCondition.indexOf("%") != -1) {
                strNextCondition = strNextCondition.replaceAll("[%]", "");
                fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
                fPercent /= 100.0;
            } else {
                try {
                    nActionCount = Integer.parseInt(strNextCondition);
                }
                catch (Exception ex) {
                    fPercent = (Double)DataTypeParse.TestDouble((String)strNextCondition);
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
            this.UserCloseUnfinishEmbedWorkflows(wpParam.getStepId(), false, "\u7236\u6d41\u7a0b\u6b65\u9aa4\u5df2\u7ecf\u7ed3\u675f");
            this.activeStep = new WFStep();
            this.activeStep.setWFSTEPID(stepInst.getWFSTEPID());
            callResult = this.InternalExecuteProcess(curProcessConfig);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u6267\u884c\u4ea4\u4e92\u5904\u7406[%1$s]\u5931\u8d25", (Object)stepInst.getWFSTEPID()), callResult);
            }
            callResult = this.InternalFinishProcess(curProcessConfig);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u5b8c\u6210\u4ea4\u4e92\u5904\u7406[%1$s]\u5931\u8d25", (Object)stepInst.getWFSTEPID()), callResult);
            }
            WFBaseProcessConfig nextProcessConfig = this.wfConfig.FindProcessConfigByName(wfReturnConfig.getNext());
            if (nextProcessConfig == null) {
                this.wfDataCtrl.ErrorWFInstance(this.wfInstance, callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo(), wpParam.getOpPersonId());
                return this.LogAndReturn("SubmitEmbedWorkflow", StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u5931\u8d25", (Object)wfReturnConfig.getNext()), null);
            }
            callResult = this.InternalExecute(nextProcessConfig);
            callResult.setUserObject((Object)this.runInfo.toString());
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult UserCloseUnfinishEmbedWorkflows(String strActiveStepId, boolean bSubmitEmbedWF, String strDescription) {
        if (this.wfDataCtrlEx == null) {
            return new CallResult();
        }
        Vector<WFStepInst> wfStepInsts = new Vector<WFStepInst>();
        CallResult callResult = this.wfDataCtrlEx.GetUnfinishWFStepInsts(this, strActiveStepId, wfStepInsts);
        if (callResult.IsError()) {
            this.Log(1, this, StringHelper.Format((String)"\u67e5\u8be2\u672a\u5173\u95ed\u5d4c\u5957\u6d41\u7a0b[%1$s-%2$s]\u5931\u8d25\uff0c%3$s", (Object)this.wfInstance.getWFINSTANCEID(), (Object)strActiveStepId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        if (wfStepInsts.size() == 0) {
            return callResult;
        }
        for (WFStepInst wfStepInst : wfStepInsts) {
            WFInstance tempWFInst = new WFInstance();
            callResult = this.wfDataCtrlEx.GetWFInstance(wfStepInst.getWFINSTANCEID(), tempWFInst);
            if (callResult.IsError()) {
                this.Log(1, this, StringHelper.Format((String)"\u83b7\u53d6\u5d4c\u5957\u6d41\u7a0b\u5b9e\u4f8b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)tempWFInst.getWFINSTANCEID(), (Object)callResult.getErrorInfo()));
                continue;
            }
            WFParam wfParam = new WFParam();
            wfParam.setOpPersonId(this.strCurUserId);
            wfParam.setDescription(strDescription);
            wfParam.setWorkflowId(tempWFInst.getWFWORKFLOWID());
            wfParam.setInstanceId(tempWFInst.getWFINSTANCEID());
            wfParam.setUserData(tempWFInst.getUSERDATA());
            wfParam.setUserData2(tempWFInst.getUSERDATA2());
            wfParam.setUserData3(tempWFInst.getUSERDATA3());
            wfParam.setUserData4(tempWFInst.getUSERDATA4());
            SRFWFDefaultEngine defaultEngine = new SRFWFDefaultEngine();
            callResult = defaultEngine.Init(this.servletContext, this.dbCallerHelper, wfParam.getWorkflowId());
            if (callResult.IsError()) {
                this.Log(1, this, StringHelper.Format((String)"\u521d\u59cb\u5316\u5d4c\u5957\u6d41\u7a0b\u5b9e\u4f8b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)tempWFInst.getWFINSTANCEID(), (Object)callResult.getErrorInfo()));
                continue;
            }
            callResult = defaultEngine.UserClose(wfParam, bSubmitEmbedWF);
            if (!callResult.IsError()) continue;
            this.Log(1, this, StringHelper.Format((String)"\u7528\u6237\u5173\u95ed\u5d4c\u5957\u6d41\u7a0b\u5b9e\u4f8b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)tempWFInst.getWFINSTANCEID(), (Object)callResult.getErrorInfo()));
        }
        callResult.Reset();
        return callResult;
    }

    private class SRFWFDefaultEngineThread
    extends Thread {
        protected WFBaseProcessConfig processConfig = null;

        public SRFWFDefaultEngineThread(WFBaseProcessConfig processConfig) {
            this.processConfig = processConfig;
        }

        @Override
        public void run() {
            SRFWFDefaultEngine.this.bThreadMode = true;
            SRFWFDefaultEngine.this.InternalExecute(this.processConfig);
        }
    }
}

