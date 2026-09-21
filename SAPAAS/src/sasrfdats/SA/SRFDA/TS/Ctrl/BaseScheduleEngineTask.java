/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskType;
import SA.SRFDA.TS.Ctrl.IScheduleEngineContext;
import SA.SRFDA.TS.Ctrl.IScheduleEngineTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseScheduleEngineTask
implements IScheduleEngineTask {
    protected TSSDTaskType taskType = null;
    protected IScheduleEngineContext iScheduleEngineContext = null;
    private static Log log = LogFactory.getLog(BaseScheduleEngineTask.class);

    @Override
    public void Init(IScheduleEngineContext iScheduleEngineContext, TSSDTaskType taskType) {
        this.taskType = taskType;
        this.iScheduleEngineContext = iScheduleEngineContext;
        this.OnInit();
    }

    protected void OnInit() {
    }

    protected String getTaskTypeParam(String strName, String strDefault) {
        return PropertiesHelper.GetProperty((Properties)this.taskType.getTaskTypeParam(), (String)strName, (String)strDefault);
    }

    protected static CallResult GetCallParam(IScheduleEngineContext iScheduleEngineContext, IDEHelper iDEHelper, String strUserData) {
        CallResult callResult = new CallResult();
        if (StringHelper.IsNullOrEmpty((String)strUserData)) {
            return callResult;
        }
        Properties properties = null;
        try {
            properties = PropertiesHelper.Load((String)strUserData);
            if (properties == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u4efb\u52a1\u53c2\u65705\u5230\u5c5e\u6027\u5bf9\u8c61\u4e2d\u5931\u8d25"));
                return callResult;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u4efb\u52a1\u53c2\u65705\u5230\u5c5e\u6027\u5bf9\u8c61\u4e2d\u5931\u8d25 \uff0c%1$s", (Object)e.getMessage()));
            return callResult;
        }
        BaseDataEntity dstDataEntity = new BaseDataEntity();
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            callResult = MacroHelper.GetValue((String)strValue, null, (ISRFDAGlobalHelper)iScheduleEngineContext.getDAGlobalHelper(), (String)"SYSTEM", null);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    dstDataEntity.SetParamValue(strKey, null);
                    continue;
                }
                IDEFHelper iDEFHelper = null;
                if (iDEHelper != null) {
                    iDEFHelper = iDEHelper.GetDEFHelper(strKey);
                }
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            dstDataEntity.SetParamValue(strKey, obj);
        }
        callResult.Reset();
        callResult.setUserObject((Object)dstDataEntity);
        return callResult;
    }
}

