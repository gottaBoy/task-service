/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFProcess;
import SRFWF.Ctrl.SRFWFBaseProcess;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFEmbedProcessConfig;
import SRFWF.Model.WFGroupProcessConfig;
import java.util.Iterator;

public class SRFWFGroupProcess
extends SRFWFBaseProcess
implements ISRFWFContext {
    protected ISRFWFContext context = null;
    protected WFBaseProcessConfig activeProcessConfig = null;

    @Override
    public CallResult Execute(ISRFWFContext context) {
        CallResult callResult = new CallResult();
        this.context = context;
        WFGroupProcessConfig groupProcessConfig = (WFGroupProcessConfig)context.getCurProcessConfig();
        Iterator iterator = groupProcessConfig.getEmbedProcessesConfig().iterator();
        while (iterator.hasNext()) {
            WFEmbedProcessConfig processConfig = (WFEmbedProcessConfig)((Object)iterator.next());
            String strObject = processConfig.getObject();
            if (StringHelper.IsNullOrEmpty((String)strObject)) {
                context.Log(1, this, "\u6ca1\u6709\u4e3a\u5b50\u5904\u7406\u8bbe\u7f6e\u5904\u7406\u5bf9\u8c61");
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u4e3a\u5b50\u5904\u7406\u8bbe\u7f6e\u5904\u7406\u5bf9\u8c61");
                return callResult;
            }
            Object objProcess = ObjectHelper.Create((String)strObject);
            if (objProcess == null || !(objProcess instanceof ISRFWFProcess)) {
                String strErrorInfo = StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u65e0\u6548\u6216\u6ca1\u6709\u5b9e\u73b0ISRFWFProcess\u63a5\u53e3", (Object)strObject);
                context.Log(1, this, strErrorInfo);
                callResult.setRetCode(1);
                callResult.setErrorInfo(strErrorInfo);
                return callResult;
            }
            ISRFWFProcess iProcess = (ISRFWFProcess)objProcess;
            this.activeProcessConfig = processConfig;
            CallResult ret = iProcess.BeforeExecute(this);
            if (ret == null || ret.getRetCode() != 0) {
                String strErrorInfo = StringHelper.Format((String)"\u5bf9\u8c61[%1$s]BeforeExecute \u51fa\u73b0\u9519\u8bef\uff0c%2%s", (Object)strObject, (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()));
                context.Log(1, this, strErrorInfo);
                callResult.setRetCode(1);
                callResult.setErrorInfo(strErrorInfo);
                return callResult;
            }
            ret = iProcess.Execute(this);
            if (ret == null || ret.getRetCode() != 0) {
                String strErrorInfo = StringHelper.Format((String)"\u5bf9\u8c61[%1$s]Execute \u51fa\u73b0\u9519\u8bef\uff0c%2%s", (Object)strObject, (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()));
                context.Log(1, this, strErrorInfo);
                callResult.setRetCode(1);
                callResult.setErrorInfo(strErrorInfo);
                return callResult;
            }
            ret = iProcess.AfterExecute(this);
            if (ret != null && ret.getRetCode() == 0) continue;
            String strErrorInfo = StringHelper.Format((String)"\u5bf9\u8c61[%1$s]AfterExecute \u51fa\u73b0\u9519\u8bef\uff0c%2%s", (Object)strObject, (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()));
            context.Log(1, this, strErrorInfo);
            callResult.setRetCode(1);
            callResult.setErrorInfo(strErrorInfo);
            return callResult;
        }
        context.setNext(groupProcessConfig.getNext());
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public BaseDataEntity getActiveObject() {
        return this.context.getActiveObject();
    }

    @Override
    public ContextHelper getContextHelper() {
        return this.context.getContextHelper();
    }

    @Override
    public WFBaseProcessConfig getCurProcessConfig() {
        return this.activeProcessConfig;
    }

    @Override
    public String getCurUserId() {
        return this.context.getCurUserId();
    }

    @Override
    public BaseDBCallerHelperEx getDBCallerHelperEx() {
        return this.context.getDBCallerHelperEx();
    }

    @Override
    public String getInteractiveConnection() {
        return "";
    }

    @Override
    public void Log(int logLevel, Object obj, String strLogInfo) {
        this.context.Log(logLevel, obj, strLogInfo);
    }

    @Override
    public void setFinishInteractiveProcess(boolean finish) {
    }

    @Override
    public void setNext(String strCurNext) {
    }

    @Override
    public String GetWorkflowId() {
        return this.context.GetWorkflowId();
    }

    @Override
    public void AppendReturnInfo(String strInfo) {
        this.context.AppendReturnInfo(strInfo);
    }

    @Override
    public WFInstance getInstance() {
        return this.context.getInstance();
    }

    @Override
    public String GetUserTag() {
        return this.context.GetUserTag();
    }

    @Override
    public String GetUserTag2() {
        return this.context.GetUserTag2();
    }

    @Override
    public Object getAttribute(String strName) {
        return this.context.getAttribute(strName);
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
        this.context.setAttribute(strName, objValue);
    }
}

