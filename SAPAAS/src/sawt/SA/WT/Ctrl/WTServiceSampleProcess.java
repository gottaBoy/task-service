/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.WT.Ctrl.WTServiceCustomProcess;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTServiceSampleProcess
extends WTServiceCustomProcess {
    private static final Log log = LogFactory.getLog(WTServiceSampleProcess.class);
    public static final String PROCESSMODE_SENDCODE = "SENDCODE";
    public static final String PROCESSMODE_VERIFYCODE = "VERIFYCODE";

    @Override
    public CallResult Execute(IDEDataCtrlEngineContext iDEDataCtrlEngineContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = new CallResult();
        BaseDataEntity env = iDEDataCtrlEngineContext.GetDataEntity("%ENV%");
        BaseDataEntity dataEntity = iDEDataCtrlEngineContext.GetDataEntity("");
        BaseDataEntity wtUser = iDEDataCtrlEngineContext.GetDataEntity("%WTUSER%");
        String strProcessMode = PropertiesHelper.GetProperty((Properties)processConfig.getDEDCProcess().getParams(), (String)"PROCESSMODE", (String)"");
        if (StringHelper.Compare((String)strProcessMode, (String)PROCESSMODE_SENDCODE, (boolean)true) == 0) {
            String strId = dataEntity.GetParamStringValue("RECVTEXT", "");
            Random random = new Random();
            String strCode = "";
            while ((strCode = StringHelper.Format((String)"%1$s", (Object)Math.abs(random.nextInt(1000000)))).length() != 6) {
            }
            dataEntity.SetParamValue("UP_S1", (Object)strCode);
            dataEntity.SetParamValue("UP_I1", (Object)3);
            log.debug((Object)strCode);
            env.SetParamValue("CHECKSTATE", (Object)1);
            return callResult;
        }
        if (StringHelper.Compare((String)strProcessMode, (String)PROCESSMODE_VERIFYCODE, (boolean)true) == 0) {
            String strLastCode;
            String strCode = dataEntity.GetParamStringValue("RECVTEXT", "");
            if (StringHelper.Compare((String)strCode, (String)(strLastCode = dataEntity.GetParamStringValue("UP_S1", "")), (boolean)false) == 0) {
                env.SetParamValue("CHECKSTATE", (Object)1);
            } else {
                int nErrorCount = dataEntity.GetParamIntValue("UP_I1", 0);
                if (nErrorCount > 0) {
                    --nErrorCount;
                }
                dataEntity.SetParamValue("UP_I1", (Object)nErrorCount);
                env.SetParamValue("CHECKSTATE", (Object)2);
            }
            return callResult;
        }
        return callResult;
    }
}

