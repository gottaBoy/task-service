/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.Data.DEDataSync;
import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Ctrl.Data.DataSyncIn;
import SA.SRFDA.Ctrl.Data.DataSyncIn2;
import SA.SRFDA.Ctrl.Data.DataSyncOut;
import SA.SRFDA.Ctrl.Data.DataSyncOut2;
import SA.SRFDA.Ctrl.DataSync.DefaultDataSyncEngineParam;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncInEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncOutEngine;
import SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataSyncService
extends BaseService {
    private static Log log = LogFactory.getLog(DataSyncService.class);
    public static final String PARAM_POLLTIMER = "POLLTIMER";
    public static final String PARAM_QUERYSQL = "QUERYSQL";
    private int nPollTimer = 30000;
    private Timer pollTimer = null;
    protected Hashtable<String, IDataSyncOutEngine> deDataSyncOutEngines = new Hashtable();
    protected Hashtable<String, IDataSyncInEngine> deDataSyncInEngines = new Hashtable();
    protected String strQuerySQL = "SELECT t1.* from t_SRFDATASYNCOUT t1 where t1.SYNCAGENT='%1$s' ORDER BY t1.CREATEDATE ";
    private String strFileLocalPath = "";

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.strFileLocalPath = this.getGlobalHelper().getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
        if (StringHelper.IsNullOrEmpty((String)this.strFileLocalPath)) {
            log.warn((Object)"\u6ca1\u6709\u5b9a\u4e49\u672c\u5730\u6587\u4ef6\u5b58\u50a8\u8def\u5f84\uff0c\u6587\u4ef6\u540c\u6b65\u65f6\u4f1a\u53d1\u751f\u9519\u8bef");
        }
        return callResult;
    }

    @Override
    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nPollTimer = Integer.parseInt(this.GetServiceParam(PARAM_POLLTIMER, "30000"));
        this.strQuerySQL = this.GetServiceParam(PARAM_QUERYSQL, this.strQuerySQL);
        try {
            this.PrepareDataSyncEngine();
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u51c6\u5907\u6570\u636e\u540c\u6b65\u5f15\u64ce\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        if (this.pollTimer == null) {
            this.pollTimer = new Timer("DEDATASYNCSERVICETIMER");
            this.pollTimer.schedule((TimerTask)this, this.nPollTimer, (long)this.nPollTimer);
        }
        log.info((Object)StringHelper.Format((String)"DEDataSyncService Start"));
        return callResult;
    }

    protected void PrepareDataSyncEngine() throws Exception {
        this.deDataSyncOutEngines.clear();
        this.deDataSyncInEngines.clear();
        Vector<DataSyncAgent> dataSyncAgents = new Vector<DataSyncAgent>();
        CallResult callResult = this.getGlobalHelper().getDAModelHelper().GetValidDataSyncAgents(dataSyncAgents);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u542f\u7528\u7684\u6570\u636e\u540c\u6b65\u4ee3\u7406\u5f15\u64ce\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DataSyncAgent dataSyncAgent : dataSyncAgents) {
            try {
                ISyncAgentTypeHelper iSyncAgentTypeHelper = this.getGlobalHelper().getDAModelStorage().FindSyncAgentType(dataSyncAgent.getAGENTTYPE());
                IDataSyncEngine iDataSyncEngine = iSyncAgentTypeHelper.CreateDataSyncEngine(dataSyncAgent);
                iDataSyncEngine.Init(this.getGlobalHelper(), dataSyncAgent);
                if (StringHelper.Compare((String)iDataSyncEngine.getSyncDir(), (String)"OUT", (boolean)true) == 0) {
                    this.deDataSyncOutEngines.put(iDataSyncEngine.getId(), (IDataSyncOutEngine)iDataSyncEngine);
                    continue;
                }
                this.deDataSyncInEngines.put(iDataSyncEngine.getId(), (IDataSyncInEngine)iDataSyncEngine);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5f15\u64ce\u5bf9\u8c61[%1$s]\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)dataSyncAgent.getDATASYNCAGENTID(), (Object)ex.getMessage()));
            }
        }
    }

    protected void ResetDataSyncEngine() {
        for (IDataSyncOutEngine iDataSyncOutEngine : this.deDataSyncOutEngines.values()) {
            try {
                iDataSyncOutEngine.Quit();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5f15\u64ce\u5bf9\u8c61[%1$s]\u9000\u51fa\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDataSyncOutEngine.getId(), (Object)ex.getMessage()));
            }
        }
        for (IDataSyncInEngine iDataSyncInEngine : this.deDataSyncInEngines.values()) {
            try {
                iDataSyncInEngine.Quit();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5f15\u64ce\u5bf9\u8c61[%1$s]\u9000\u51fa\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDataSyncInEngine.getId(), (Object)ex.getMessage()));
            }
        }
        this.deDataSyncOutEngines.clear();
        this.deDataSyncInEngines.clear();
    }

    @Override
    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"DEDataSyncService Stop"));
        if (this.pollTimer != null) {
            this.pollTimer.cancel();
            this.pollTimer = null;
        }
        this.ResetDataSyncEngine();
        return super.OnStop();
    }

    @Override
    protected void OnRun() throws Exception {
        for (IDataSyncOutEngine iDataSyncOutEngine : this.deDataSyncOutEngines.values()) {
            try {
                Vector<DataSyncOut> dataSyncOuts;
                block18: {
                    if (!iDataSyncOutEngine.CheckSend()) {
                        log.error((Object)StringHelper.Format((String)"\u6570\u636e\u540c\u6b65\u53d1\u9001\u5f15\u64ce[%1$s]\u53d1\u9001\u6d4b\u8bd5\u5931\u8d25\uff0c\u5ffd\u7565\u672c\u8f6e\u53d1\u9001", (Object)iDataSyncOutEngine.getName()));
                        continue;
                    }
                    String strSQL = StringHelper.Format((String)this.strQuerySQL, (Object)iDataSyncOutEngine.getId());
                    SelectResult2 selectResult = BaseDEDataCtrl.SelectMultiExReturnRS(this.iDAGlobalHelper, null, "", strSQL, null);
                    if (selectResult == null || selectResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)strSQL));
                        continue;
                    }
                    dataSyncOuts = new Vector<DataSyncOut>();
                    try {
                        try {
                            int PAGESIZE = 500;
                            int nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                            int i = 0;
                            while (i < selectResult.getMainTable().GetRowCount()) {
                                DataSyncOut dataSyncOut = new DataSyncOut();
                                DataRow dr = selectResult.getMainTable().GetRow(i);
                                dataSyncOut.FromDataRow(dr, true);
                                dataSyncOuts.add(dataSyncOut);
                                ++i;
                            }
                        }
                        catch (Exception ex) {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                            selectResult.Close();
                            break block18;
                        }
                    }
                    catch (Throwable throwable) {
                        selectResult.Close();
                        throw throwable;
                    }
                    selectResult.Close();
                }
                if (dataSyncOuts.size() == 0) continue;
                IDEDataCtrl dataSyncOut2DataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0226", "SA.SRFDA.Ctrl.DataSync.DataSyncService");
                IDEDataCtrl dataSyncOutDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0225", "SA.SRFDA.Ctrl.DataSync.DataSyncService");
                for (DataSyncOut dataSyncOut : dataSyncOuts) {
                    DefaultDataSyncEngineParam defaultDataSyncEngineParam = new DefaultDataSyncEngineParam();
                    defaultDataSyncEngineParam.setDataSyncOut(dataSyncOut);
                    DataSyncOut2 dataSyncOut2 = new DataSyncOut2();
                    dataSyncOut.CopyTo(dataSyncOut2, false);
                    dataSyncOut2.setDATASYNCOUT2ID(dataSyncOut.getDATASYNCOUTID());
                    dataSyncOut2.setDATASYNCOUT2NAME(dataSyncOut.getDATASYNCOUTNAME());
                    BaseDEDataCtrl.SetCallParamCheckKey(dataSyncOut2, false);
                    BaseDEDataCtrl.SetCallParamDALog(dataSyncOut2, false);
                    BaseDEDataCtrl.SetCallParamRetData(dataSyncOut2, false);
                    try {
                        iDataSyncOutEngine.Send(defaultDataSyncEngineParam);
                    }
                    catch (Exception ex) {
                        dataSyncOut2.setERROR(StringHelper.Format((String)"\u5904\u7406\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                    }
                    CallResult callResult = dataSyncOutDataCtrl.Remove(dataSyncOut);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u79fb\u9664\u5df2\u5904\u7406\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        continue;
                    }
                    callResult = dataSyncOut2DataCtrl.Save(true, dataSyncOut2);
                    if (!callResult.IsError()) continue;
                    log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5df2\u5904\u7406\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u6570\u636e\u540c\u6b65\u63a5\u6536\u5f15\u64ce[%1$s]\u53d1\u9001\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDataSyncOutEngine.getName(), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        for (IDataSyncInEngine iDataSyncInEngine : this.deDataSyncInEngines.values()) {
            try {
                DefaultDataSyncEngineParam defaultDataSyncEngineParam = new DefaultDataSyncEngineParam();
                iDataSyncInEngine.Recv(defaultDataSyncEngineParam);
                this.ProcessDataSyncIns(defaultDataSyncEngineParam.getDataSyncIns());
                defaultDataSyncEngineParam.ResetDataSyncIns();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u6570\u636e\u540c\u6b65\u63a5\u6536\u5f15\u64ce[%1$s]\u63a5\u6536\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDataSyncInEngine.getName(), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    protected void ProcessDataSyncIns(Vector<DataSyncIn> dataSyncInList) throws Exception {
        if (dataSyncInList.size() == 0) {
            return;
        }
        IDEDataCtrl dataSyncIn2DataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0228", "SA.SRFDA.Ctrl.DataSync.DataSyncService");
        for (DataSyncIn dataSyncIn : dataSyncInList) {
            CallResult callResult;
            DataSyncIn2 dataSyncIn2;
            block19: {
                dataSyncIn2 = new DataSyncIn2();
                dataSyncIn.CopyTo(dataSyncIn2, true);
                dataSyncIn2.setDATASYNCIN2NAME(dataSyncIn.getDATASYNCINNAME());
                BaseDEDataCtrl.SetCallParamCheckKey(dataSyncIn2, false);
                BaseDEDataCtrl.SetCallParamDALog(dataSyncIn2, false);
                BaseDEDataCtrl.SetCallParamRetData(dataSyncIn2, false);
                try {
                    String strTempFile;
                    IDEDataCtrl dataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl(dataSyncIn.getDEID(), "SA.SRFDA.Ctrl.DataSync.DataSyncService");
                    Vector<DEDataSync> deDataSyncs = dataCtrl.GetDEHelper().GetDEDataSyncs(true);
                    if (deDataSyncs == null || deDataSyncs.size() == 0) continue;
                    DEDataSync deDataSync = null;
                    for (DEDataSync temp : deDataSyncs) {
                        if (StringHelper.Compare((String)dataSyncIn.getSYNCAGENT(), (String)temp.getSYNCAGENTIN(), (boolean)true) != 0) continue;
                        deDataSync = temp;
                        break;
                    }
                    if (deDataSync == null) continue;
                    if (!this.OnTestDataImport(dataSyncIn, deDataSync, dataCtrl)) {
                        if (!dataSyncIn.getFILEFLAG()) continue;
                        try {
                            File file;
                            strTempFile = dataSyncIn.GetParamStringValue("TEMPFILE", "");
                            if (StringHelper.IsNullOrEmpty((String)strTempFile) || !(file = new File(strTempFile)).exists()) continue;
                            file.delete();
                        }
                        catch (Exception ex) {
                            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u4e34\u65f6\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                        }
                        continue;
                    }
                    if (dataSyncIn.getFILEFLAG()) {
                        try {
                            File file;
                            strTempFile = dataSyncIn.GetParamStringValue("TEMPFILE", "");
                            String strRealPath = String.valueOf(this.strFileLocalPath) + dataSyncIn.getDATA();
                            if (StringHelper.IsNullOrEmpty((String)strTempFile) || !(file = new File(strTempFile)).exists()) break block19;
                            File dstFile = new File(strRealPath);
                            if (dstFile.exists()) {
                                dstFile.delete();
                            } else {
                                File path = dstFile.getParentFile();
                                path.mkdirs();
                            }
                            if (!file.renameTo(dstFile)) {
                                dataSyncIn2.setERROR(StringHelper.Format((String)"\u79fb\u52a8\u6587\u4ef6\u53d1\u751f\u9519\u8bef"));
                            }
                            break block19;
                        }
                        catch (Exception ex) {
                            dataSyncIn2.setERROR(StringHelper.Format((String)"\u79fb\u52a8\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                            log.error((Object)dataSyncIn2.getERROR(), (Throwable)ex);
                        }
                        break block19;
                    }
                    if (dataSyncIn.getEVENTTYPE() == 4) {
                        BaseDataEntity dataEntity = new BaseDataEntity();
                        dataEntity.SetParamValue(dataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), dataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(dataSyncIn2.getDATAKEY()));
                        CallResult callResult2 = dataCtrl.Remove(dataEntity);
                        if (callResult2.IsError()) {
                            dataSyncIn2.setERROR(StringHelper.Format((String)"\u79fb\u9664\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)dataSyncIn.getDEID(), (Object)dataSyncIn.getDATAKEY(), (Object)callResult2.getErrorInfo()));
                            log.error((Object)dataSyncIn2.getERROR());
                        }
                    } else if ((dataSyncIn.getEVENTTYPE() & 3) > 0) {
                        StringBuilderEx processInfo = new StringBuilderEx();
                        this.ProcessDataImport(dataSyncIn, deDataSync, processInfo);
                        String strErrorInfo = processInfo.toString();
                        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                            dataSyncIn2.setERROR(strErrorInfo);
                            log.error((Object)dataSyncIn2.getERROR());
                        }
                    }
                }
                catch (Exception ex) {
                    dataSyncIn2.setERROR(ex.getMessage());
                }
            }
            if (!(callResult = dataSyncIn2DataCtrl.Save(true, dataSyncIn2)).IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u6570\u636e\u540c\u6b65\u8f93\u5165\u961f\u52172\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected boolean OnTestDataImport(DataSyncIn dataSyncIn, DEDataSync deDataSync, IDEDataCtrl dataCtrl) {
        if ((dataSyncIn.getEVENTTYPE() & deDataSync.getEVENTTYPE()) == 0) {
            return false;
        }
        String strActionMode = deDataSync.GetParamStringValue("ACTIONMODE", "");
        if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
            return true;
        }
        CallResult callResult = dataCtrl.CustomCall(strActionMode, BaseDataEntity.FromString((String)dataSyncIn.getLOGICDATA()));
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u5224\u65ad\u662f\u5426\u540c\u6b65\u5b9e\u4f53\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        if (callResult.getUserObject() == null) {
            return false;
        }
        String strValue = callResult.getUserObject().toString();
        return StringHelper.Compare((String)strValue, (String)"1", (boolean)true) == 0;
    }

    protected void ProcessDataImport(DataSyncIn dataSyncIn, DEDataSync deDataSync, StringBuilderEx processInfo) throws Exception {
        XMLNode rootNode = XMLNode.LoadFromXML((String)dataSyncIn.getDATA());
        if (rootNode == null) {
            processInfo.Append("\u6570\u636e\u5185\u5bb9\u65e0\u6548");
            return;
        }
        if (rootNode.getChildNodes() != null) {
            int nIndex = 0;
            for (XMLNode xmlNode : rootNode.getChildNodes()) {
                String strCustomCall;
                CallResult callResult;
                IDEHelper iDEHelper;
                block13: {
                    ++nIndex;
                    String strDEId = xmlNode.GetExtValue("SRFDEID", "");
                    if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                        processInfo.Append("[%1$s]\u6ca1\u6709\u6307\u5b9a\u5bf9\u5e94\u7684\u6570\u636e\u5bf9\u8c61\r\n", (Object)nIndex);
                        continue;
                    }
                    IDEDataCtrl deDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl(strDEId, "SA.SRFDA.Ctrl.DataSync.DataSyncService");
                    if (deDataCtrl == null) {
                        processInfo.Append("[%1$s]\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%2$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\r\n", (Object)nIndex, (Object)strDEId);
                        continue;
                    }
                    iDEHelper = deDataCtrl.GetDEHelper();
                    callResult = null;
                    try {
                        xmlNode.SetValue("SRFACTIONMODE", deDataSync.getIMPORTACTIONMODE());
                        callResult = deDataCtrl.Import(xmlNode);
                        if (callResult.IsError()) {
                            processInfo.Append("[%1$s]\u5bfc\u5165\u6570\u636e\u5931\u8d25\uff1a%2$s\r\n", (Object)nIndex, (Object)callResult.getErrorInfo());
                        }
                        break block13;
                    }
                    catch (Exception ex) {
                        processInfo.Append("[%1$s]\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%2$s\r\n", (Object)nIndex, (Object)ex.getMessage());
                    }
                    continue;
                }
                BaseDataEntity dataEntity = null;
                if (callResult.getUserObject() != null && callResult.getUserObject() instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)callResult.getUserObject();
                }
                if (StringHelper.IsNullOrEmpty((String)(strCustomCall = xmlNode.GetExtValue("SRFCUSTOMCALL", "")))) {
                    String strRemoveCall = xmlNode.GetExtValue("SRFREMOVE", "");
                    if (StringHelper.Compare((String)strRemoveCall, (String)"TRUE", (boolean)true) == 0) {
                        String strKeyData = xmlNode.GetExtValue("SRFARG", "");
                        if (callResult.getRetCode() == 0) continue;
                        processInfo.Append("[%1$s][%2$s:%3$s]\u5220\u9664\u6570\u636e[%4$s]\u5931\u8d25\uff1a%5$s!\r\n", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(), (Object)strKeyData, (Object)callResult.getErrorInfo());
                        continue;
                    }
                    String strSqlPatch = xmlNode.GetExtValue("SRFSQLPATCH", "");
                    if (StringHelper.Compare((String)strSqlPatch, (String)"TRUE", (boolean)true) == 0) {
                        String strPatchName = xmlNode.GetExtValue("SQLPATCHNAME", "");
                        if (callResult.getRetCode() == 0) continue;
                        processInfo.Append("[%1$s][%2$s:%3$s]\u6267\u884c\u6570\u636e\u5e93\u8865\u4e01[%4$s]\u5931\u8d25\uff1a%5$s!\r\n", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(), (Object)strPatchName, (Object)callResult.getErrorInfo());
                        continue;
                    }
                    String strDER1NSYNC = xmlNode.GetExtValue("SRFDER1NSYNC", "");
                    if (StringHelper.Compare((String)strDER1NSYNC, (String)"TRUE", (boolean)true) == 0) {
                        String strDER1NID = xmlNode.GetExtValue("SRFDER1NID", "");
                        if (callResult.getRetCode() == 0) continue;
                        processInfo.Append("[%1$s][%2$s:%3$s]\u540c\u6b651:N\u5173\u7cfb\u6570\u636e[%4$s]\u5931\u8d25\uff1a%5$s!\r\n", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(), (Object)strDER1NID, (Object)callResult.getErrorInfo());
                        continue;
                    }
                    if (callResult.getRetCode() == 0) continue;
                    processInfo.Append("[%1$s][%2$s:%3$s]\u5bfc\u5165\u6570\u636e[%4$s]\u5931\u8d25\uff1a%5$s!\r\n", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)), (Object)callResult.getErrorInfo());
                    continue;
                }
                if (callResult.getRetCode() == 0) continue;
                processInfo.Append("[%1$s][%2$s:%3$s]\u6267\u884c\u81ea\u5b9a\u4e49\u64cd\u4f5c[%5$s](%4$s)\u5931\u8d25\uff1a%5$s!\r\n", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)), (Object)callResult.getErrorInfo(), (Object)strCustomCall);
            }
        }
    }
}

