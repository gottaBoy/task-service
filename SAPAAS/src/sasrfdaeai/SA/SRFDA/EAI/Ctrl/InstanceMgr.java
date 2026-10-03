package SA.SRFDA.EAI.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.mule.api.DefaultMuleException;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Lifecycle;
import org.mule.config.i18n.MessageFactory;

public class InstanceMgr extends TimerTask implements Lifecycle, MuleContextAware {
    private Map<String, String> config;
    protected MuleContext context;
    protected EAIDAGlobalHelper daGlobalHelper;
    protected ISRFEAIDataCtrl eaiDataCtrl;
    protected String strConfigPath;
    protected String strServiceId;
    private Timer refreshTimer;
    private File runFile;

    public void setMuleContext(MuleContext muleContext) {
        this.context = muleContext;
    }

    public void setGlobalHelper(EAIDAGlobalHelper globalHelper) {
        this.daGlobalHelper = globalHelper;
    }

    public EAIDAGlobalHelper getGlobalHelper() {
        return this.daGlobalHelper;
    }

    public Map<String, String> getConfig() {
        return this.config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public void initialise() throws InitialisationException {
        if (this.context == null || this.context.getRegistry() == null
                || this.daGlobalHelper == null || this.config == null
                || this.config.get("SERVICEID") == null
                || this.config.get("SERVICEID").trim().length() == 0) {
            throw new InitialisationException(
                    MessageFactory.createStaticMessage("EAI requires a Mule registry, global helper and SERVICEID"),
                    this);
        }
        Object registered = this.context.getRegistry().lookupObject("SRFDACONTEXTHELPER");
        if (registered != this.daGlobalHelper
                || !(this.daGlobalHelper.getDBCallerEx() instanceof EAIDBCallerHelperEx)
                || ((EAIDBCallerHelperEx)this.daGlobalHelper.getDBCallerEx()).getDataSource() == null) {
            throw new InitialisationException(
                    MessageFactory.createStaticMessage("EAI global helper or database caller is not registered"),
                    this);
        }
        this.strServiceId = this.config.get("SERVICEID").trim();
        this.strConfigPath = this.config.get("CONFIGPATH");
        if (this.strConfigPath == null || this.strConfigPath.length() == 0) {
            this.strConfigPath = ".";
        }
        this.runFile = new File(this.strConfigPath, this.strServiceId.toLowerCase(java.util.Locale.ROOT) + ".run");
        this.eaiDataCtrl = new DefaultEAIDataCtrl();
        CallResult result = this.eaiDataCtrl.Init(this.daGlobalHelper);
        if (result.IsError()) {
            throw new InitialisationException(
                    MessageFactory.createStaticMessage("EAI data controller initialization failed: " + result.getErrorInfo()),
                    this);
        }
        String appMode = this.config.get("APPMODE");
        if (appMode != null) {
            this.daGlobalHelper.SetGlobalValue("SRFDAAPPMODE", appMode);
        }
    }

    public synchronized void start() throws MuleException {
        if (this.runFile == null) {
            throw new DefaultMuleException("EAI service has not been initialized");
        }
        if (this.refreshTimer != null) {
            return;
        }
        File parent = this.runFile.getParentFile();
        if (parent != null && !parent.isDirectory() && !parent.mkdirs()) {
            throw new DefaultMuleException("Cannot create EAI configuration directory: " + parent);
        }
        try {
            if (!this.runFile.createNewFile() && !this.runFile.isFile()) {
                throw new IOException("EAI run marker is not a file");
            }
        } catch (IOException ex) {
            throw new DefaultMuleException("Cannot create EAI run marker: " + this.runFile, ex);
        }
        this.refreshTimer = new Timer("eai-" + this.strServiceId, true);
        this.refreshTimer.schedule(new TimerTask() {
            public void run() {
                InstanceMgr.this.run();
            }
        }, 10000L, 10000L);
    }

    public synchronized void stop() throws MuleException {
        if (this.refreshTimer != null) {
            this.refreshTimer.cancel();
            this.refreshTimer = null;
        }
        if (this.runFile != null && this.runFile.exists() && !this.runFile.delete()) {
            throw new DefaultMuleException("Cannot remove EAI run marker: " + this.runFile);
        }
        if (this.eaiDataCtrl != null) {
            CallResult result = this.eaiDataCtrl.MarkServiceStop(this.strServiceId);
            if (result.IsError()) {
                throw new DefaultMuleException("Cannot mark EAI service stopped: " + result.getErrorInfo());
            }
        }
    }

    public void dispose() {
        try {
            this.stop();
        } catch (MuleException ex) {
            throw new IllegalStateException("Cannot dispose EAI service " + this.strServiceId, ex);
        }
    }

    public synchronized void run() {
        if (this.runFile != null && !this.runFile.exists()) {
            try {
                this.stop();
            } catch (MuleException ex) {
                throw new IllegalStateException("Cannot stop EAI service " + this.strServiceId, ex);
            }
        }
    }
}
