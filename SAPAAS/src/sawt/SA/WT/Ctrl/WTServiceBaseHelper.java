/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig
 *  SA.SRFDA.Ctrl.Data.DEDCProcess
 *  SA.SRFDA.Ctrl.Data.DEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.DefaultWTDEDCEngine;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.WTBaseObject;
import SA.WT.Ctrl.WTMsgTemplateHelper;
import SA.WT.Data.WTIncomeMessage;
import SA.WT.Data.WTServiceBase;
import SA.WT.Data.WTServiceSession;
import SA.WT.Data.WTServiceStep;
import SA.WT.Data.WTUser;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WTServiceBaseHelper
extends WTBaseObject
implements IWTServiceHelper {
    private static final Log log = LogFactory.getLog(WTServiceBaseHelper.class);
    private WTServiceBase wtServiceBase = new WTServiceBase();
    protected IWTAccountHelper iWTAccountHelper = null;
    protected HashMap<String, WTServiceStep> wtServiceStepMap = new HashMap();
    private Vector<DefaultWTDEDCEngine> dedcEngines = new Vector();
    private DEDataCtrl deDataCtrl = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWTAccountHelper iWTAccountHelper, BaseDataEntity wtServiceBase) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        wtServiceBase.CopyTo((BaseDataEntity)this.wtServiceBase, true);
        this.setId(this.wtServiceBase.getWTSERVICEBASEID());
        this.setName(this.wtServiceBase.getWTSERVICEBASENAME());
        this.setVersion(this.wtServiceBase.getVERSION());
        this.iWTAccountHelper = iWTAccountHelper;
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.deDataCtrl = new DEDataCtrl();
        this.deDataCtrl.setDEDATACTRLID(this.wtServiceBase.getWTSERVICEBASEID());
        this.deDataCtrl.setDEDATACTRLNAME(this.wtServiceBase.getWTSERVICEBASENAME());
        this.deDataCtrl.setPROCESSMODEL(this.wtServiceBase.getACTIONMODEL());
        this.deDataCtrl.setDEBUGOUTPUT(this.wtServiceBase.getDEBUGOUTPUT());
        DEDCConfig dedcConfig = this.deDataCtrl.getDEDCConfig();
        if (dedcConfig == null) {
            throw new Exception(StringHelper.Format((String)"\u5fae\u4fe1[%1$s]\u670d\u52a1\u6a21\u578b\u65e0\u6548", (Object)this.getName()));
        }
        for (DEDCBaseProcessConfig processConfig : this.deDataCtrl.getDEDCConfig().getProcessesConfig()) {
            if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
            DEDCProcess dedcProcess = new DEDCProcess();
            CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetDEDCProcess(processConfig.getProcessConfigId(), dedcProcess);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5904\u7406[%1$s]\u5931\u8d25\uff0c%2$s", (Object)processConfig.getProcessConfigId(), (Object)callResult.getErrorInfo()));
            }
            processConfig.setDEDCProcess(dedcProcess);
        }
        Vector<WTServiceStep> wtServiceStepList = new Vector<WTServiceStep>();
        CallResult callResult = this.getWTModelHelper().GetWTServiceSteps(this.getId(), wtServiceStepList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u670d\u52a1\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (WTServiceStep wtServiceStep : wtServiceStepList) {
            this.wtServiceStepMap.put(wtServiceStep.getSTEPID(), wtServiceStep);
        }
    }

    protected void PrepareWTServiceStep() throws Exception {
        this.wtServiceStepMap.clear();
        Vector<WTServiceStep> wtServiceStepList = new Vector<WTServiceStep>();
        CallResult callResult = this.getWTModelHelper().GetWTServiceSteps(this.getId(), wtServiceStepList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5fae\u4fe1\u670d\u52a1\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (WTServiceStep wtServiceStep : wtServiceStepList) {
            this.wtServiceStepMap.put(wtServiceStep.getSTEPID(), wtServiceStep);
        }
    }

    @Override
    public WTServiceSession StartSession(WTUser wtUser) throws Exception {
        WTServiceSession wtServiceSession = new WTServiceSession();
        wtUser.CopyTo(wtServiceSession, false);
        wtServiceSession.setWTSERVICEBASEID(this.getId());
        wtServiceSession.setWTSERVICEBASENAME(this.getName());
        wtServiceSession.setWTSERVICESESSIONNAME("\u670d\u52a1\u4f1a\u8bdd");
        wtServiceSession.setWTSERVICESESSIONID(Helper.GenGuidEx());
        return wtServiceSession;
    }

    @Override
    public String ContinueSession(WTUser wtUser, WTServiceSession wtServiceSession, WTIncomeMessage wtIncomeMessage) throws Exception {
        DefaultWTDEDCEngine brDEDCEngine;
        wtServiceSession.SetParamValue("MSGTYPE", wtIncomeMessage.getMSGTYPE());
        wtServiceSession.SetParamValue("CONTENT", wtIncomeMessage.getCONTENT());
        wtServiceSession.SetParamValue("REALPERSONID", wtUser.getREALPERSONID());
        wtServiceSession.SetParamValue("REALPERSONNAME", wtUser.getREALPERSONNAME());
        wtServiceSession.SetParamValue("RECVTEXT", wtIncomeMessage.getCONTENT());
        wtServiceSession.SetParamValue("NEXTSVRSN", "");
        wtServiceSession.SetParamValue("NEXTSTEPSN", "");
        wtServiceSession.SetParamValue("STOPSESSION", 0);
        if (wtServiceSession.isCURSTEPSNNull()) {
            wtServiceSession.setCURSTEPSN("");
        }
        if ((brDEDCEngine = this.GetWTDEDCEngine()) == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u6267\u884c\u5f15\u64ce");
        }
        brDEDCEngine.SetDataEntity("%WTUSER%", wtUser);
        CallResult callResult = brDEDCEngine.CustomCall(this.deDataCtrl, wtServiceSession, "");
        this.ReleaseWTDEDCEngine(brDEDCEngine);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u6267\u884c\u670d\u52a1[%1$s]\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
        }
        String strNextStepId = wtServiceSession.getNEXTSTEPSN();
        WTServiceStep wtServiceStep = this.wtServiceStepMap.get(strNextStepId);
        if (wtServiceStep == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u670d\u52a1[%1$s]\u6b65\u9aa4[%2$s]", (Object)this.getName(), (Object)strNextStepId));
        }
        String strSendTime = StringHelper.Format((String)"%1$s", (Object)(new Date().getTime() / 1000L));
        wtServiceSession.SetParamValue("SENDTIME", strSendTime);
        wtServiceSession.SetParamValue("TOUSERNAME", wtIncomeMessage.getFROMUSERNAME());
        wtServiceSession.SetParamValue("FROMUSERNAME", wtIncomeMessage.getTOUSERNAME());
        callResult = WTMsgTemplateHelper.FillWTServiceSession(this.iDAGlobalHelper, this, wtServiceStep, wtUser, wtServiceSession);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u586b\u5145\u670d\u52a1[%1$s]\u53cd\u9988\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getName(), (Object)callResult.getErrorInfo()));
        }
        String strLog = StringHelper.Format((String)"---\u7528\u6237\u8f93\u5165[%1$s]\r\n%2$s\r\n\r\n--\u7cfb\u7edf\u53cd\u9988[%3$s]\r\n%4$s\r\n\r\n", (Object)wtIncomeMessage.getMSGTYPE(), (Object)wtIncomeMessage.getCONTENT(), (Object)wtServiceStep.getMSGFORMAT(), (Object)wtServiceSession.GetParamValue("SENDTEXT"));
        String strLastLog = String.valueOf(wtServiceSession.getSERVICELOG()) + strLog;
        wtServiceSession.setSERVICELOG(strLastLog);
        wtServiceSession.setCURSTEPSN(strNextStepId);
        return wtServiceSession.GetParamStringValue("SENDCONTENT", "");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected DefaultWTDEDCEngine GetWTDEDCEngine() {
        Vector<DefaultWTDEDCEngine> vector = this.dedcEngines;
        synchronized (vector) {
            if (this.dedcEngines.size() > 0) {
                return this.dedcEngines.remove(0);
            }
        }
        DefaultWTDEDCEngine defaultWTDEDCEngine = this.CreateWTDEDCEngine();
        if (defaultWTDEDCEngine != null) {
            return defaultWTDEDCEngine;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void ReleaseWTDEDCEngine(DefaultWTDEDCEngine engine) {
        Vector<DefaultWTDEDCEngine> vector = this.dedcEngines;
        synchronized (vector) {
            if (this.dedcEngines.size() < 20) {
                this.dedcEngines.add(engine);
            }
        }
    }

    protected DefaultWTDEDCEngine CreateWTDEDCEngine() {
        IDEDataCtrl iDEDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("WT0070", "SYSTEM", null);
        if (iDEDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"WT0070"));
            return null;
        }
        DefaultWTDEDCEngine defaultWTDEDCEngine = new DefaultWTDEDCEngine();
        defaultWTDEDCEngine.Init(iDEDataCtrl, this.iDAGlobalHelper);
        return defaultWTDEDCEngine;
    }

    @Override
    public boolean isRequireVerify() {
        return this.wtServiceBase.getREQVERFIY();
    }
}

