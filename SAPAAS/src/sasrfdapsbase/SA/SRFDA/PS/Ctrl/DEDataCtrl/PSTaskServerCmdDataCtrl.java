/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.sun.jna.Platform
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Util.CLI.PSStudioCLIUtils;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSTaskServerCmd;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.sun.jna.Platform;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSTaskServerCmdDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSTaskServerCmdDataCtrl.class);
    public static final String CUSTOMCALL_KILLCMD = "KILLCMD";
    public static final String CUSTOMCALL_EXECUTEXCLICMD = "EXECUTEXCLICMD";
    public static final String CUSTOMCALL_EXECUTEDCCLICMD = "EXECUTEDCCLICMD";
    public static final String CUSTOMCALL_EXECUTESLNCLICMD = "EXECUTESLNCLICMD";
    public static final String CUSTOMCALL_EXECUTESYSCLICMD = "EXECUTESYSCLICMD";
    public static final String CUSTOMCALL_EXECUTETEMPLCLICMD = "EXECUTETEMPLCLICMD";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_KILLCMD, (boolean)true) == 0) {
            return this.killCmd(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXECUTEXCLICMD, (boolean)true) == 0) {
            return this.executeCLICmd("X", dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXECUTEDCCLICMD, (boolean)true) == 0) {
            return this.executeCLICmd("DC", dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXECUTESLNCLICMD, (boolean)true) == 0) {
            return this.executeCLICmd("SLN", dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXECUTESYSCLICMD, (boolean)true) == 0) {
            return this.executeCLICmd("SYS", dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXECUTETEMPLCLICMD, (boolean)true) == 0) {
            return this.executeCLICmd("TEMPL", dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult killCmd(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSTaskServerCmd psTaskServerCmd = new PSTaskServerCmd();
            psTaskServerCmd.proxy(dataEntity);
            callResult = this.Get(psTaskServerCmd);
            if (callResult.isOk()) {
                this.onKillCmd(psTaskServerCmd);
            } else {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u7ed3\u675f\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c\u4efb\u52a1\u4e0d\u5b58\u5728");
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u540e\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onKillCmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        if (Platform.isWindows()) {
            String strCmd = String.format("cmd.exe /c taskkill /PID %1$s /T /F ", psTaskServerCmd.getPSTSCMDNAME());
            Runtime.getRuntime().exec(strCmd);
        }
    }

    public CallResult executeCLICmd(final String strType, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (!StringHelper.IsNullOrEmpty((String)dataEntity.getParamStringValue("PSTSCMDID", ""))) {
                this.Get(dataEntity);
            }
            final PSTaskServerCmd psTaskServerCmd = new PSTaskServerCmd();
            psTaskServerCmd.proxy(dataEntity);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (strType.equals("DC")) {
                        PSTaskServerCmdDataCtrl.this.onExecuteDCCLICmd(psTaskServerCmd);
                    } else if (strType.equals("SLN")) {
                        PSTaskServerCmdDataCtrl.this.onExecuteSlnCLICmd(psTaskServerCmd);
                    } else if (strType.equals("SYS")) {
                        PSTaskServerCmdDataCtrl.this.onExecuteSysCLICmd(psTaskServerCmd);
                    } else if (strType.equals("TEMPL")) {
                        PSTaskServerCmdDataCtrl.this.onExecuteTemplCLICmd(psTaskServerCmd);
                    } else if (strType.equals("X")) {
                        PSTaskServerCmdDataCtrl.this.onExecuteCLICmd(psTaskServerCmd);
                    }
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884cCLI\u547d\u4ee4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExecuteCLICmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSStudioCLIUtils.getInstance().executeCmd(psTaskServerCmd);
    }

    protected void onExecuteDCCLICmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSStudioCLIUtils.getInstance().executeDCCmd(psTaskServerCmd);
    }

    protected void onExecuteSlnCLICmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSStudioCLIUtils.getInstance().executeSlnCmd(psTaskServerCmd);
    }

    protected void onExecuteSysCLICmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSStudioCLIUtils.getInstance().executeSysCmd(psTaskServerCmd);
    }

    protected void onExecuteTemplCLICmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        PSStudioCLIUtils.getInstance().executeTemplCmd(psTaskServerCmd);
    }
}

