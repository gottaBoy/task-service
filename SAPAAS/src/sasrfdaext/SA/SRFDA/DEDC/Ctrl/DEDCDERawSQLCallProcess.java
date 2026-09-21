/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDCDERawSQLCallProcess
extends DEDCProcess {
    private static final Log log = LogFactory.getLog(DEDCDERawSQLCallProcess.class);

    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        boolean bNoResetOrigin = processConfig.getDEDCProcess().getPARAM7() == 1;
        boolean bReturnResult = processConfig.getDEDCProcess().getPARAM9();
        boolean bEnableTran = processConfig.getDEDCProcess().getPARAM10();
        String strDBStorage = processConfig.getDEDCProcess().getPARAM1();
        Connection conn = null;
        String strSQL = processConfig.getDEDCProcess().getPARAM4();
        CallParamList callParamList = new CallParamList();
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8fd4\u56de\u7ed3\u679c[%1$s]\u4e0d\u91cd\u7f6e\u539f\u6709\u6570\u636e[%2$s]", (Object)(bReturnResult ? "\u662f" : "\u5426"), (Object)(bNoResetOrigin ? "\u662f" : "\u5426")));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u542f\u7528\u4e8b\u52a1[%1$s]", (Object)(bEnableTran ? "\u662f" : "\u5426")));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6570\u636e\u5b58\u50a8\u533a\u57df[%1$s]", (Object)strDBStorage));
        if (dedcContext.isDebugOutput()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6267\u884cSQL{\r\n%1$s\r\n}", (Object)strSQL));
        }
        try {
            String strQueryParam = processConfig.getDEDCProcess().getPARAM5();
            strQueryParam = strQueryParam.replace("\r\n", "\n");
            String[] params = strQueryParam.split("[\n]");
            int i = 0;
            while (i < params.length) {
                String strParam = params[i];
                if (!StringHelper.IsNullOrEmpty((String)(strParam = strParam.trim()))) {
                    callResult = MacroHelper.GetValue((String)strParam, (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity);
                    if (callResult.IsError()) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5b8f\u53d8\u91cf[%1$s]", (Object)strParam));
                        return callResult;
                    }
                    callParamList.Add(callResult.getUserObject());
                    if (dedcContext.isDebugOutput()) {
                        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8ba1\u7b97\u53d8\u91cf[%1$s][%2$s]", (Object)strParam, (Object)callResult.getUserObject()));
                    }
                }
                ++i;
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            e.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u52a0\u8f7dSQL\u53d8\u91cf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()));
            return callResult;
        }
        if (bEnableTran && dedcContext.GetDataCtrl().getTransactionManager() != null) {
            conn = dedcContext.GetDataCtrl().getTransactionManager().GetConnection(strDBStorage);
        }
        if (bReturnResult) {
            if (bNoResetOrigin) {
                BaseDataEntity tmpDataEntity = new BaseDataEntity();
                callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (Connection)conn, (String)strDBStorage, (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)tmpDataEntity);
                if (callResult.IsOk()) {
                    tmpDataEntity.CopyTo(srcDataEntity, false);
                }
            } else {
                callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (Connection)conn, (String)strDBStorage, (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)srcDataEntity);
            }
        } else {
            callResult = BaseDEDataCtrl.ExecuteWithoutResultEx((ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (Connection)conn, (String)strDBStorage, (String)strSQL, (Vector)callParamList.GetList());
        }
        return callResult;
    }
}

