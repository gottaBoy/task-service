/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  InitialisationException
 *  MuleContext
 *  MuleException
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.EAIDAGlobalHelper;
import SA.SRFDA.EAI.Ctrl.EAIDBCallerHelperEx;
import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class InstanceMgr
extends TimerTask {
    private Map<String, String> config;
    protected MuleContext context;
    protected EAIDBCallerHelperEx dbCallerHelperEx;
    protected EAIDAGlobalHelper daGlobalHelper;
    protected ISRFEAIDataCtrl eaiDataCtrl;
    protected String strConfigPath;
    protected String strServiceId;
    private Timer refreshTimer;
    private String strRunFile;
    protected IDEDataCtrl eaiServiceDataCtrl;

    public InstanceMgr() {
        throw new Error("Unresolved compilation problems: \n\tThe import org.enhydra cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tMuleContextAware cannot be resolved to a type\n\tLifecycle cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tInitialisationException cannot be resolved to a type\n\tMuleException cannot be resolved to a type\n\tMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n");
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
        throw new Error("Unresolved compilation problems: \n\tMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tDefaultMuleException cannot be resolved to a type\n");
    }

    @Override
    public synchronized void run() {
        throw new Error("Unresolved compilation problem: \n\tMuleContext cannot be resolved to a type\n");
    }
}

