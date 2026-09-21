/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDCProcess;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngine;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDEDCEngine
implements IDEDataCtrlEngine,
IDEDataCtrlEngineContext {
    public static final String ENV_INSERT = "INSERT";
    public static final String ENV_ACTIONMODE = "ACTIONMODE";
    public static final String ENV_RETCODE = "RETCODE";
    public static final String ENV_RETERROR = "RETERROR";
    public static final String ENV_RETOBJECT = "RETOBJECT";
    public static final String ENV_RETUSEROBJECT = "RETUSEROBJECT";
    public static final String ENV_LASTRETCODE = "LASTRETCODE";
    public static final String ENV_LASTRETERROR = "LASTRETERROR";
    public static final String ENV_LASTRETOBJECT = "LASTRETOBJECT";
    public static final String ENV = "%ENV%";
    public static final String DEFAULT = "%DEFAULT%";
    public static final String LAST = "%LAST%";
    public static final String GLOBAL = "%GLOBAL";
    protected IDEDataCtrl iDataCtrl;
    protected DEDataCtrl dedc;
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    protected Hashtable<String, BaseDataEntity> deMap = new Hashtable();
    protected String strCurNext = "";
    protected DEDCConfig dedcConfig = null;
    protected int nMaxLoopCount = 100;
    protected boolean bDebugOutput = false;
    private SRFExPage page = null;
    private static final Log log = LogFactory.getLog(BaseDEDCEngine.class);
    private StringBuilder debugInfo = new StringBuilder();
    private Hashtable<String, IDEDataCtrl> deDataCtrlMap = new Hashtable();

    @Override
    public boolean Init(IDEDataCtrl iDataCtrl, ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDataCtrl = iDataCtrl;
        this.iDAGlobalHelper = iDAGlobalHelper;
        return true;
    }

    @Override
    public CallResult TestSave(DEDataCtrl dedc, BaseDataEntity dataEntity, boolean bInsert, String strActionMode, Vector<ValueError> errors) {
        return null;
    }

    @Override
    public Vector<ValueError> GetValueErrors() {
        return null;
    }

    @Override
    public CallResult BeforeSave(DEDataCtrl dedc, BaseDataEntity dataEntity, BaseDataEntity lastEntity, boolean bInsert, String strActionMode) {
        return null;
    }

    @Override
    public CallResult AfterSave(DEDataCtrl dedc, BaseDataEntity dataEntity, BaseDataEntity lastEntity, boolean bInsert, String strActionMode) {
        return null;
    }

    @Override
    public CallResult BeforeRemove(DEDataCtrl dedc, BaseDataEntity dataEntity, String strActionMode) {
        return null;
    }

    @Override
    public CallResult AfterRemove(DEDataCtrl dedc, BaseDataEntity dataEntity, String strActionMode) {
        return null;
    }

    @Override
    public CallResult CustomCall(DEDataCtrl dedc, BaseDataEntity dataEntity, String strCustomCall) {
        long nStartProcessTime = new Date().getTime();
        BaseDataEntity env = new BaseDataEntity();
        this.deMap.put(ENV, env);
        this.deMap.put("", dataEntity);
        this.deMap.put(DEFAULT, dataEntity);
        this.bDebugOutput = dedc.getDEBUGOUTPUT();
        this.dedc = dedc;
        this.dedcConfig = dedc.getDEDCConfig();
        CallResult callResult = this.InternalExecute(null);
        if (this.bDebugOutput) {
            this.OutputDebugInfo(dedc);
        }
        return callResult;
    }

    @Override
    public CallResult GetDefault(DEDataCtrl dedc, BaseDataEntity dataEntity, String strActionMode) {
        return null;
    }

    @Override
    public CallResult InternalCall(DEDataCtrl dedc, BaseDataEntity dataEntity, String strCustomCall) {
        return null;
    }

    @Override
    public CallResult InternalCall(DEDataCtrl dedc, Vector<BaseDataEntity> dataEntities, String strCustomCall) {
        return null;
    }

    protected CallResult InternalExecute(DEDCBaseProcessConfig processConfig) {
        CallResult result = new CallResult();
        try {
            if (processConfig == null) {
                this.nMaxLoopCount = 100;
                processConfig = this.dedcConfig.getProcessesConfig().GetStartProcessConfig();
            }
            if (processConfig == null) {
                return BaseDEDCEngine.LogAndReturn(this, "InternalExecute", "\u6ca1\u6709\u627e\u5230\u8d77\u59cb\u7684\u6267\u884c\u8282\u70b9", null);
            }
            int nLoopCount = 0;
            do {
                if (processConfig.getDEDCProcess() != null) {
                    this.DebugOutput(this, StringHelper.Format((String)"\r\n>>\u5f00\u59cb\u5904\u7406[%1$s][%2$s]\r\n", (Object)processConfig.getDEDCProcess().getDEDCPROCESSNAME(), (Object)processConfig.getDEDCProcess().getDEDCPROCESSID()));
                }
                if (processConfig.isTerminalProcess()) {
                    this.DebugOutput(this, StringHelper.Format((String)"\r\n>>\u5904\u7406\u7ed3\u675f\r\n"));
                    return result;
                }
                this.strCurNext = "";
                result = this.InternalExecuteProcess(processConfig);
                if (result == null || result.getRetCode() != 0) {
                    return BaseDEDCEngine.LogAndReturn(this, "InternalExecute", StringHelper.Format((String)"\u6267\u884c\u5904\u7406[%1$s][%2$s]", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), result);
                }
                if (StringHelper.IsNullOrEmpty((String)this.strCurNext)) {
                    return BaseDEDCEngine.LogAndReturn(this, "InternalExecute", StringHelper.Format((String)"[%1$s][%2$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9", (Object)processConfig.getLogicName(), (Object)processConfig.getName()), null);
                }
                processConfig = this.dedcConfig.getProcessesConfig().FindProcessConfig(this.strCurNext);
                if (processConfig != null) continue;
                return BaseDEDCEngine.LogAndReturn(this, "InternalExecute", StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d[%1$s]\u5904\u7406\u8282\u70b9", (Object)this.strCurNext), null);
            } while (++nLoopCount < this.nMaxLoopCount);
            return BaseDEDCEngine.LogAndReturn(this, "InternalExecute", StringHelper.Format((String)"\u5904\u7406\u5df2\u7ecf\u8d85\u8fc7[%1$s]\u6b21\uff0c\u7cfb\u7edf\u4e2d\u65ad", (Object)this.nMaxLoopCount), null);
        }
        catch (Exception ex) {
            result.setRetCode(1);
            result.setErrorInfo(ex.getMessage());
            return result;
        }
    }

    protected CallResult InternalExecuteProcess(DEDCBaseProcessConfig processConfig) {
        return BaseDEDCEngine.InternalExecuteProcess(this, processConfig);
    }

    protected static CallResult InternalExecuteProcess(IDEDataCtrlEngineContext context, DEDCBaseProcessConfig processConfig) {
        IDEDCProcess iDEDCProcess = context.GetGlobalHelper().getDEDCProcessStorage().FindDEDCProcess(processConfig);
        if (iDEDCProcess == null) {
            return BaseDEDCEngine.LogAndReturn(context, "InternalExecuteProcess", StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]\u6240\u5bf9\u5e94\u7684\u5904\u7406\u5bf9\u8c61", (Object)((Object)((Object)processConfig)).getClass().getName()), null);
        }
        try {
            BaseDataEntity env = context.GetEnv();
            env.RemoveParam(ENV_RETCODE);
            env.RemoveParam(ENV_RETERROR);
            env.RemoveParam(ENV_RETOBJECT);
            CallResult ret = iDEDCProcess.Execute(context, processConfig);
            if (ret == null) {
                ret = new CallResult();
                ret.setRetCode(1);
                ret.setErrorInfo(StringHelper.Format((String)"\u5904\u7406\u8fd4\u56de\u7a7a\u7ed3\u679c"));
            }
            if (ret.IsOk()) {
                if (env.ContainesParam(ENV_RETCODE)) {
                    ret.setRetCode(env.GetParamIntValue(ENV_RETCODE, 0));
                }
                if (env.ContainesParam(ENV_RETERROR)) {
                    ret.setErrorInfo(env.GetParamStringValue(ENV_RETERROR, ""));
                }
                if (env.ContainesParam(ENV_RETOBJECT)) {
                    ret.setUserObject(env.GetParamValue(ENV_RETOBJECT));
                }
            }
            env.SetParamValue(ENV_LASTRETCODE, (Object)ret.getRetCode());
            env.SetParamValue(ENV_LASTRETERROR, (Object)ret.getErrorInfo());
            env.SetParamValue(ENV_LASTRETOBJECT, ret.getUserObject());
            if (ret.IsError() && BaseDEDCEngine.IsIgnoreError(processConfig, ret.getRetCode())) {
                context.DebugOutput(context, StringHelper.Format((String)"\u5904\u7406[%1$s]\u5ffd\u7565\u9519\u8bef[%2$s]\uff0c\u7ee7\u7eed\u6267\u884c", (Object)processConfig.getLogicName(), (Object)ret.getRetCode()));
                log.info((Object)StringHelper.Format((String)"\u5904\u7406[%1$s]\u5ffd\u7565\u9519\u8bef[%2$s]\uff0c\u7ee7\u7eed\u6267\u884c", (Object)processConfig.getLogicName(), (Object)ret.getRetCode()));
                ret.setRetCode(0);
                ret.setErrorInfo("");
                ret.setUserObject(null);
            }
            env.SetParamValue(ENV_RETUSEROBJECT, ret.getUserObject());
            return ret;
        }
        catch (Exception ex) {
            return BaseDEDCEngine.LogAndReturn2(context, "InternalExecuteProcess", "Execute", ex);
        }
    }

    protected static boolean IsIgnoreError(DEDCBaseProcessConfig processConfig, int nRetCode) {
        String strIgnoreError = processConfig.getDEDCProcess().getIGNOREERROR();
        if (StringHelper.IsNullOrEmpty((String)(strIgnoreError = strIgnoreError.replace(" ", "")))) {
            return false;
        }
        String[] parts = strIgnoreError.split("[;]");
        int i = 0;
        while (i < parts.length) {
            block11: {
                int nValue;
                String[] items = parts[i].split("[-]");
                if (items.length == 1) {
                    if (StringHelper.Compare((String)items[0], (String)"*", (boolean)true) == 0) {
                        return true;
                    }
                    try {
                        nValue = Integer.parseInt(items[0]);
                        if (nValue == nRetCode) {
                            return true;
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        break block11;
                    }
                }
                if (items.length == 2) {
                    try {
                        nValue = Integer.parseInt(items[0]);
                        int nValue2 = 0;
                        nValue2 = StringHelper.Compare((String)items[1], (String)"*", (boolean)true) == 0 ? Integer.MAX_VALUE : Integer.parseInt(items[1]);
                        if (nRetCode >= nValue && nRetCode <= nValue2) {
                            return true;
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            ++i;
        }
        return false;
    }

    @Override
    public String GetPersonId() {
        return this.iDataCtrl.getOPPersonId();
    }

    @Override
    public ISRFDAGlobalHelper GetGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public ISRFDAWebContext GetWebContext() {
        return this.iDataCtrl.getWebContext();
    }

    @Override
    public IDEHelper GetDEHelper() {
        return this.iDataCtrl.GetDEHelper();
    }

    @Override
    public IDEDataCtrl GetDataCtrl() {
        return this.iDataCtrl;
    }

    @Override
    public void Log(int nLogLevel, Object obj, String strLogInfo) {
        switch (nLogLevel) {
            case 0: {
                log.info((Object)strLogInfo);
                break;
            }
            case 2: {
                log.fatal((Object)strLogInfo);
                break;
            }
            case 5: {
                log.debug((Object)strLogInfo);
                break;
            }
            case 1: {
                log.error((Object)strLogInfo);
                break;
            }
            case 4: {
                log.warn((Object)strLogInfo);
            }
        }
    }

    @Override
    public void setNext(String strCurNext) {
        this.strCurNext = strCurNext;
    }

    @Override
    public BaseDataEntity GetDataEntity(String strKey) {
        if ((strKey = strKey.toUpperCase()).indexOf(GLOBAL) == 0) {
            Object objValue = this.iDataCtrl.GetAttribute(strKey);
            if (objValue == null) {
                return null;
            }
            if (objValue instanceof BaseDataEntity) {
                return (BaseDataEntity)objValue;
            }
            return null;
        }
        return this.deMap.get(strKey);
    }

    @Override
    public BaseDataEntity GetEnv() {
        return this.GetDataEntity(ENV);
    }

    @Override
    public void Set(String strKey, BaseDataEntity dataEntity) {
        this.SetDataEntity(strKey, dataEntity);
    }

    @Override
    public BaseDataEntity Get(String strKey) {
        return this.GetDataEntity(strKey);
    }

    @Override
    public void SetDataEntity(String strKey, BaseDataEntity dataEntity) {
        if ((strKey = strKey.toUpperCase()).indexOf(GLOBAL) == 0) {
            this.iDataCtrl.SetAttribute(strKey, dataEntity);
        } else if (dataEntity == null) {
            this.deMap.remove(strKey);
        } else {
            this.deMap.put(strKey, dataEntity);
        }
    }

    protected CallResult LogAndReturn(String strFunc, String strErrorInfo, CallResult ret) {
        return BaseDEDCEngine.LogAndReturn(this, strFunc, strErrorInfo, ret);
    }

    protected static CallResult LogAndReturn(IDEDataCtrlEngineContext context, String strFunc, String strErrorInfo, CallResult ret) {
        String strRealErrorInfo = "";
        strRealErrorInfo = !StringHelper.IsNullOrEmpty((String)strErrorInfo) ? StringHelper.Format((String)"%1$s\uff0c%2$s", (Object)strErrorInfo, (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo())) : StringHelper.Format((String)"%1$s", (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()));
        context.Log(1, context, strRealErrorInfo);
        if (ret != null) {
            return ret;
        }
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        callResult.setErrorInfo(strRealErrorInfo);
        return callResult;
    }

    protected static CallResult LogAndReturn2(IDEDataCtrlEngineContext context, String strFunc, String strErrorInfo, Exception ex) {
        String strRealErrorInfo = StringHelper.Format((String)"%1$s\uff0c%2$s", (Object)strErrorInfo, (Object)ex.getMessage());
        context.Log(1, context, strRealErrorInfo);
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        callResult.setErrorInfo(strRealErrorInfo);
        return callResult;
    }

    @Override
    public boolean isDebugOutput() {
        return this.bDebugOutput;
    }

    @Override
    public void DebugOutput(Object obj, String strLogInfo) {
        if (!this.isDebugOutput()) {
            return;
        }
        this.debugInfo.append(strLogInfo);
        this.debugInfo.append("\r\n");
    }

    protected final ISRFDAGlobalHelper GetDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected final DEDCConfig GetDEDCConfig() {
        return this.dedcConfig;
    }

    protected final String getNext() {
        return this.strCurNext;
    }

    protected boolean isLogPODCAction() {
        return this.GetDEHelper().GetProperty("LOGPODCACTION", true);
    }

    @Override
    public SRFExPage GetPage() {
        if (this.page != null) {
            return this.page;
        }
        if (this.iDataCtrl.getWebContext() != null && this.iDataCtrl.getWebContext() instanceof SRFExWebContext) {
            this.page = ((SRFExWebContext)this.iDataCtrl.getWebContext()).getPage();
        }
        return this.page;
    }

    protected void OutputDebugInfo(DEDataCtrl dedc) {
        String strDebugInfoHeader = StringHelper.Format((String)"\r\n\r\n\u5b9e\u4f53 [%1$s]\u5904\u7406\u903b\u8f91\u8c03\u8bd5\u4fe1\u606f ==>[%2$s][%3$s:%4$s]\r\n\r\n", (Object)this.GetDEHelper().getName(), (Object)dedc.getDEDATACTRLNAME(), (Object)dedc.getDCSTEP(), (Object)dedc.getACTIONMODE());
        if (dedc != null) {
            LoggerEx.warn((Log)log, (Object)(String.valueOf(strDebugInfoHeader) + this.debugInfo.toString()), null, (Object)this.GetWebContext(), (Object)this.GetDEHelper().getId(), (Object)dedc.getDEDATACTRLNAME(), (Object)dedc.getDCSTEP(), (Object)dedc.getACTIONMODE());
        } else {
            LoggerEx.warn((Log)log, (Object)(String.valueOf(strDebugInfoHeader) + this.debugInfo.toString()), null, (Object)this.GetWebContext(), (Object)this.GetDEHelper().getId());
        }
        this.debugInfo = null;
        this.debugInfo = new StringBuilder();
    }

    public static CallResult FillDEDCProcesses(ISRFDAGlobalHelper iDAGlobalHelper, DEDataCtrl deDataCtrl) {
        CallResult callResult = new CallResult();
        if (deDataCtrl.getDEDCConfig() == null) {
            return callResult;
        }
        Iterator iterator = deDataCtrl.getDEDCConfig().getProcessesConfig().iterator();
        while (iterator.hasNext()) {
            DEDCBaseProcessConfig processConfig = (DEDCBaseProcessConfig)((Object)iterator.next());
            if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
            DEDCProcess dedcProcess = new DEDCProcess();
            callResult = iDAGlobalHelper.getDAModelHelper().GetDEDCProcess(processConfig.getProcessConfigId(), dedcProcess);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5904\u7406[%1$s]\u5931\u8d25\uff0c%2$s", (Object)processConfig.getProcessConfigId(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            processConfig.setDEDCProcess(dedcProcess);
        }
        return callResult;
    }

    @Override
    public IDEDataCtrl GetDataCtrl(String strDEId, boolean bReload) {
        if (this.deDataCtrlMap.containsKey(strDEId) && !bReload) {
            return this.deDataCtrlMap.get(strDEId);
        }
        IDEHelper iDEHelper = this.GetDEHelper();
        IDEDataCtrl iDEDataCtrl = null;
        if (iDEHelper != null && StringHelper.Compare((String)strDEId, (String)iDEHelper.getId(), (boolean)true) == 0) {
            return this.GetDataCtrl();
        }
        iDEDataCtrl = this.GetGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(strDEId, this.GetDataCtrl());
        if (iDEDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
            return null;
        }
        this.deDataCtrlMap.put(strDEId, iDEDataCtrl);
        return iDEDataCtrl;
    }
}

