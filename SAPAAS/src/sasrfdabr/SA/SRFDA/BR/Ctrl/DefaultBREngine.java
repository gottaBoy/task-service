/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig
 *  SA.SRFDA.Ctrl.Data.DEDCProcess
 *  SA.SRFDA.Ctrl.Data.DEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.BREngineTimer;
import SA.SRFDA.BR.Ctrl.DEDataCtrl.BRTEMPDataCtrl;
import SA.SRFDA.BR.Ctrl.DEDataCtrl.IBREngineDataCtrl;
import SA.SRFDA.BR.Ctrl.Data.BRAction;
import SA.SRFDA.BR.Ctrl.Data.BREngine;
import SA.SRFDA.BR.Ctrl.Data.BRInstParam;
import SA.SRFDA.BR.Ctrl.Data.BRInstance;
import SA.SRFDA.BR.Ctrl.DefaultBRDEDCEngine;
import SA.SRFDA.BR.Ctrl.DefaultBRInstance;
import SA.SRFDA.BR.Ctrl.ISRFBREngine;
import SA.SRFDA.BR.Ctrl.ISRFBREngineContext;
import SA.SRFDA.BR.Ctrl.ISRFBRInstance;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultBREngine
implements ISRFBREngine,
ISRFBREngineContext {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected BREngine brEngine = null;
    protected HashMap<String, ISRFBRInstance> brInstanceMap = new HashMap();
    protected Vector<BRInstParam> brInstParams = new Vector();
    protected HashMap<String, BRInstParam> brInstParamMap = new HashMap();
    protected IBREngineDataCtrl brEngineDataCtrl = null;
    private static final Log log = LogFactory.getLog(DefaultBREngine.class);
    protected BREngineTimer brEngineTimer = new BREngineTimer();
    protected Vector<DefaultBRDEDCEngine> dedcEngines = new Vector();
    protected HashMap<String, DEDataCtrl> brActionMap = new HashMap();
    protected HashMap<String, Object> attributeMap = new HashMap();
    protected HashMap<String, Object> paramMap = new HashMap();
    public static final String MGRACTION_RESETBRINST = "RESETBRINST";

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, BREngine brEngine) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.brEngine = brEngine;
        CallResult callResult = new CallResult();
        IDEDataCtrl iDEDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BR0001", "SYSTEM", null);
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BR0001"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (iDEDataCtrl instanceof IBREngineDataCtrl) {
            this.brEngineDataCtrl = (IBREngineDataCtrl)iDEDataCtrl;
        }
        if (this.brEngineDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u65e0\u6548\uff0c\u5fc5\u987b\u4e3a\u7c7b\u578b[SA.SRFDA.BR.Ctrl.DEDataCtrl.IBREngineDataCtrl]", (Object)"BR0001"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.PrepareBREngine();
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        if (brEngine.getTIMECOUNTER() > 0) {
            return this.brEngineTimer.Start(this, brEngine.getTIMECOUNTER());
        }
        return callResult;
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    @Override
    public Vector<BRInstParam> getInstParams() {
        return this.brInstParams;
    }

    @Override
    public CallResult Execute(String strInstData, String strAction, BaseDataEntity dataEntity, String strOPPersonId) {
        CallResult callResult = new CallResult();
        ISRFBRInstance brInstance = this.GetBRInstance(strInstData);
        if (brInstance == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u89c4\u5219\u5b9e\u4f8b\u6570\u636e[%1$s]", (Object)strInstData));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        brInstance.UpdateInstParam(dataEntity);
        strAction = strAction.toUpperCase();
        if (!this.brActionMap.containsKey(strAction)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u884c\u4e3a[%1$s]", (Object)strAction));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEDataCtrl deDataCtrl = this.brActionMap.get(strAction);
        DefaultBRDEDCEngine brDEDCEngine = this.GetBRDEDCEngine();
        if (brDEDCEngine == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u6267\u884c\u5f15\u64ce");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        brDEDCEngine.SetDataEntity("%BRINST%", brInstance.GetInstParam());
        brDEDCEngine.GetBRTempDataCtrl().setOPPersonId(strOPPersonId);
        callResult = brDEDCEngine.CustomCall(deDataCtrl, dataEntity, strAction);
        this.ReleaseBRDEDCEngine(brDEDCEngine);
        return callResult;
    }

    @Override
    public void Quit() {
        this.OnQuit();
        if (this.brEngine.getTIMECOUNTER() > 0) {
            this.brEngineTimer.Quit();
        }
    }

    protected void OnQuit() {
    }

    @Override
    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void Schedule() {
        Date date = new Date();
        long nTick = date.getTime() / 1000L;
        HashMap<String, Double> paramMap = new HashMap<String, Double>();
        Vector<BRInstParam> vector = this.brInstParams;
        synchronized (vector) {
            for (BRInstParam brInstParam : this.brInstParams) {
                long nTemp;
                if (brInstParam.getRESETCOUNTER() <= 0 || (nTemp = nTick / (long)brInstParam.getRESETCOUNTER()) == brInstParam.getLastTickValue()) continue;
                brInstParam.setLastTickValue(nTemp);
                paramMap.put(brInstParam.getBRINSTPARAMNAME(), brInstParam.getInitValue());
            }
        }
        if (paramMap.size() == 0) {
            return;
        }
        this.ResetBRInstParam(paramMap);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void ResetBRInstParam(HashMap<String, Double> paramMap) {
        for (String strParam : paramMap.keySet()) {
            double fValue = paramMap.get(strParam);
            HashMap<String, ISRFBRInstance> hashMap = this.brInstanceMap;
            synchronized (hashMap) {
                for (ISRFBRInstance brInst : this.brInstanceMap.values()) {
                    brInst.ResetParam(strParam, fValue);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ISRFBRInstance GetBRInstance(String strInstData) {
        Object objInst;
        HashMap<String, ISRFBRInstance> hashMap = this.brInstanceMap;
        synchronized (hashMap) {
            if (this.brInstanceMap.containsKey(strInstData)) {
                return this.brInstanceMap.get(strInstData);
            }
        }
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(this.brEngine.getBRENGINEID());
        callParamList.AddString(strInstData);
        Vector brInstList = new Vector();
        String strSQL = "select * from T_SRFBRINSTANCE WHERE BRENGINEID=? AND INSTDATA=?";
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.brEngineDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), brInstList, (String)BRInstance.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u89c4\u5219\u5b9e\u4f8b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strInstData, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (brInstList.size() == 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u89c4\u5219\u5b9e\u4f8b[%1$s]", (Object)strInstData));
            return null;
        }
        BRInstance brInst = (BRInstance)((Object)brInstList.get(0));
        String strInstObject = brInst.getINSTOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strInstObject)) {
            strInstObject = DefaultBRInstance.class.getName();
        }
        if ((objInst = ObjectHelper.Create((String)strInstObject)) == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u89c4\u5219\u5b9e\u4f8b\u5bf9\u8c61[%1$s]", (Object)strInstObject));
            return null;
        }
        if (!(objInst instanceof ISRFBRInstance)) {
            log.error((Object)StringHelper.Format((String)"\u89c4\u5219\u5b9e\u4f8b\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strInstObject));
            return null;
        }
        ISRFBRInstance iBRInstance = (ISRFBRInstance)objInst;
        iBRInstance.Init(this, brInst);
        HashMap<String, ISRFBRInstance> hashMap2 = this.brInstanceMap;
        synchronized (hashMap2) {
            this.brInstanceMap.put(strInstData, iBRInstance);
        }
        return iBRInstance;
    }

    protected CallResult PrepareBREngine() {
        CallResult callResult = this.brEngineDataCtrl.GetInstParams(this.brEngine.getBRENGINEID(), this.brInstParams);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f8b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        Vector<BRAction> brActions = new Vector<BRAction>();
        callResult = this.brEngineDataCtrl.GetActions(this.brEngine.getBRENGINEID(), brActions);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u89c4\u5219\u64cd\u4f5c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        for (BRAction brAction : brActions) {
            DEDataCtrl deDataCtrl = new DEDataCtrl();
            deDataCtrl.setDEDATACTRLID(brAction.getBRACTIONID());
            deDataCtrl.setDEDATACTRLNAME(brAction.getBRACTIONNAME());
            deDataCtrl.setPROCESSMODEL(brAction.getACTIONMODEL());
            deDataCtrl.setDEBUGOUTPUT(brAction.getDEBUGOUTPUT());
            DEDCConfig dedcConfig = deDataCtrl.getDEDCConfig();
            this.brActionMap.put(brAction.getBRACTIONNAME().toUpperCase(), deDataCtrl);
            for (DEDCBaseProcessConfig processConfig : deDataCtrl.getDEDCConfig().getProcessesConfig()) {
                if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
                DEDCProcess dedcProcess = new DEDCProcess();
                callResult = this.iDAGlobalHelper.getDAModelHelper().GetDEDCProcess(processConfig.getProcessConfigId(), dedcProcess);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5904\u7406[%1$s]\u5931\u8d25\uff0c%2$s", (Object)processConfig.getProcessConfigId(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                processConfig.setDEDCProcess(dedcProcess);
            }
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected DefaultBRDEDCEngine GetBRDEDCEngine() {
        Vector<DefaultBRDEDCEngine> vector = this.dedcEngines;
        synchronized (vector) {
            if (this.dedcEngines.size() > 0) {
                return this.dedcEngines.remove(0);
            }
        }
        DefaultBRDEDCEngine defaultBRDEDCEngine = this.CreateBRDEDCEngine();
        if (defaultBRDEDCEngine != null) {
            return defaultBRDEDCEngine;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void ReleaseBRDEDCEngine(DefaultBRDEDCEngine engine) {
        Vector<DefaultBRDEDCEngine> vector = this.dedcEngines;
        synchronized (vector) {
            if (this.dedcEngines.size() < this.brEngine.getMINOBJCNT()) {
                this.dedcEngines.add(engine);
            }
        }
    }

    protected DefaultBRDEDCEngine CreateBRDEDCEngine() {
        IDEDataCtrl iDEDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BR0006", "SYSTEM", null);
        if (iDEDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BR0006"));
            return null;
        }
        BRTEMPDataCtrl tempDataCtrl = null;
        if (iDEDataCtrl instanceof BRTEMPDataCtrl) {
            tempDataCtrl = (BRTEMPDataCtrl)iDEDataCtrl;
        }
        if (tempDataCtrl == null) {
            return null;
        }
        DefaultBRDEDCEngine defaultBRDEDCEngine = new DefaultBRDEDCEngine();
        defaultBRDEDCEngine.Init((IDEDataCtrl)tempDataCtrl, this.iDAGlobalHelper);
        return defaultBRDEDCEngine;
    }

    @Override
    public Object getAttribute(String strKey) {
        return this.attributeMap.get(strKey);
    }

    @Override
    public Object getParam(String strKey) {
        return this.paramMap.get(strKey);
    }

    @Override
    public void setAttribute(String strKey, Object objValue) {
        if (objValue == null) {
            this.attributeMap.remove(strKey);
        } else {
            this.attributeMap.put(strKey, objValue);
        }
    }

    @Override
    public CallResult Manage(String strAction, BaseDataEntity dataEntity, String strOPPersonId) {
        if (StringHelper.Compare((String)strAction, (String)MGRACTION_RESETBRINST, (boolean)true) == 0) {
            return this.ResetBRInst(dataEntity);
        }
        return new CallResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected CallResult ResetBRInst(BaseDataEntity dataEntity) {
        ISRFBRInstance brInstance = null;
        HashMap<String, ISRFBRInstance> hashMap = this.brInstanceMap;
        synchronized (hashMap) {
            brInstance = this.brInstanceMap.remove(dataEntity.GetParamStringValue("BRINSTANCEID", ""));
        }
        if (brInstance != null) {
            brInstance.Quit();
        }
        return new CallResult();
    }
}

