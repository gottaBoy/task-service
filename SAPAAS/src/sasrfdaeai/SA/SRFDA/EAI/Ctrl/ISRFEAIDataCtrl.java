/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.Data.EAIAppInt;
import SA.SRFDA.EAI.Ctrl.Data.EAIDataSource;
import SA.SRFDA.EAI.Ctrl.Data.EAIInbound;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCIB;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCOB;
import SA.SRFDA.EAI.Ctrl.Data.EAIOutbound;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcess;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessConfig;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessType;
import SA.SRFDA.EAI.Ctrl.Data.EAIProtocol;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface ISRFEAIDataCtrl {
    public CallResult Init(ISRFDAGlobalHelper var1);

    public CallResult MarkAllServiceStop();

    public CallResult MarkServiceStarting(String var1);

    public CallResult MarkServiceStop(String var1);

    public CallResult GetServiceDataSources(String var1, Vector<EAIDataSource> var2);

    public CallResult GetDataSource(String var1, EAIDataSource var2);

    public CallResult GetService(String var1, EAIService var2);

    public CallResult GetAutoStartServices(Vector<EAIService> var1);

    public CallResult GetServices(Vector<EAIService> var1);

    public CallResult GetServiceJDBCInbounds(String var1, Vector<EAIJDBCIB> var2);

    public CallResult GetServiceJDBCOutbounds(String var1, Vector<EAIJDBCOB> var2);

    public CallResult GetServiceProcesses(String var1, Vector<EAIProcess> var2);

    public CallResult GetProcessIBs(String var1, Vector<EAIInbound> var2);

    public CallResult GetProcessOBs(String var1, Vector<EAIOutbound> var2);

    public CallResult GetJDBCIB(String var1, EAIJDBCIB var2);

    public CallResult GetJDBCOB(String var1, EAIJDBCOB var2);

    public CallResult GetProcessConfig(String var1, EAIProcessConfig var2);

    public CallResult GetProtocol(String var1, EAIProtocol var2);

    public CallResult GetAppInt(String var1, EAIAppInt var2);

    public CallResult GetProcessType(String var1, EAIProcessType var2);
}

