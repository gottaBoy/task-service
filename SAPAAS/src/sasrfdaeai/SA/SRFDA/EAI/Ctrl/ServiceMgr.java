/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  InitialisationException
 *  MuleContext
 *  MuleException
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Ctrl.EAIDAGlobalHelper;
import SA.SRFDA.EAI.Ctrl.EAIDBCallerHelperEx;
import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Map;

public class ServiceMgr {
    private Map<String, String> config;
    protected MuleContext context;
    protected EAIDBCallerHelperEx dbCallerHelperEx;
    protected EAIDAGlobalHelper daGlobalHelper;
    protected ISRFEAIDataCtrl eaiDataCtrl;
    protected String strConfigPath;
    protected IDEDataCtrl eaiServiceDataCtrl;

    public ServiceMgr() {
        throw new Error("Unresolved compilation problems: \n\tThe import org.enhydra cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tMuleContextAware cannot be resolved to a type\n\tLifecycle cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tInitialisationException cannot be resolved to a type\n\tMuleException cannot be resolved to a type\n\tMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n");
    }

    public void setMuleContext(MuleContext muleContext) {
        throw new Error("Unresolved compilation problems: \n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n");
    }

    public Map<String, String> getConfig() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setConfig(Map<String, String> map) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void initialise() throws InitialisationException {
        throw new Error("Unresolved compilation problem: \n\tInitialisationException cannot be resolved to a type\n");
    }

    public void dispose() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void stop() throws MuleException {
        throw new Error("Unresolved compilation problem: \n\tMuleException cannot be resolved to a type\n");
    }

    public void start() throws MuleException {
        throw new Error("Unresolved compilation problems: \n\tMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n");
    }

    protected boolean IsServiceStart(String string) throws Exception {
        throw new Error("Unresolved compilation problem: \n");
    }

    public CallResult StartService(String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected CallResult InternalStartService(EAIService eAIService) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static boolean ExportConfigFile(StringBuilder stringBuilder, String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected CallResult StartServiceProcess(String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public CallResult StopService(String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public CallResult GetStartupServices() {
        throw new Error("Unresolved compilation problem: \n");
    }
}

