/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSRobotDataCtrl.class);
    public static final String CUSTOMCALL_CLONEROBOT = "CLONEROBOT";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONEROBOT, (boolean)true) == 0) {
            return this.cloneRobot(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult cloneRobot(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSRobot psRobot = new PSRobot();
            psRobot.proxy(dataEntity);
            psRobot.RemoveParam("PSROBOTID");
            psRobot.RemoveParam("PSROBOTNAME");
            psRobot.RemoveParam("PSDEVCENTERID");
            psRobot.RemoveParam("PSDEVCENTERNAME");
            psRobot.RemoveParam("REFFLAG");
            psRobot.RemoveParam("REFOBJID");
            psRobot.RemoveParam("REFOBJNAME");
            psRobot.RemoveParam("REFOBJTYPE");
            this.onInitRobot(psRobot);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u514b\u9686\u5e73\u53f0\u673a\u5668\u4eba\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitRobot(PSRobot srcPSRobot) throws Exception {
        int nCount = 200;
        while (nCount > 0) {
            PSRobot psRobot = new PSRobot();
            srcPSRobot.CopyTo(psRobot, false);
            String strRobotName = "robot_" + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 9);
            psRobot.setPSROBOTNAME(strRobotName);
            psRobot.setROBOTSTATE(20);
            psRobot.setVALIDFLAG(true);
            CallResult callResult = this.Save(true, psRobot);
            if (callResult.isError()) {
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5e73\u53f0\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            --nCount;
        }
    }
}

