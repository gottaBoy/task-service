package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Config.BaseServiceConfigWriter;
import SA.SRFDA.EAI.Config.DefaultConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.DefaultMuleException;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Lifecycle;
import org.mule.context.DefaultMuleContextFactory;

public class ServiceMgr implements MuleContextAware, Lifecycle {
    private static final Log log = LogFactory.getLog(ServiceMgr.class);
    private Map<String, String> config;
    protected MuleContext context;
    protected EAIDBCallerHelperEx dbCallerHelperEx;
    protected EAIDAGlobalHelper daGlobalHelper;
    protected ISRFEAIDataCtrl eaiDataCtrl;
    protected String strConfigPath;
    protected IDEDataCtrl eaiServiceDataCtrl;
    private final Map<String, MuleContext> services = new HashMap<String, MuleContext>();

    public void setMuleContext(MuleContext muleContext) {
        this.context = muleContext;
    }

    public Map<String, String> getConfig() {
        return this.config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public void initialise() throws InitialisationException {
        if (this.context == null || this.context.getRegistry() == null) {
            throw new InitialisationException(new IllegalStateException("Mule registry is required"), this);
        }
        if (this.config != null) {
            this.strConfigPath = this.config.get("CONFIGPATH");
        }
        if (this.strConfigPath == null || this.strConfigPath.length() == 0) {
            throw new InitialisationException(new IllegalArgumentException("CONFIGPATH is required"), this);
        }
    }

    public void dispose() {
        try {
            this.stop();
        } catch (MuleException ex) {
            log.error("Could not stop EAI services during disposal", ex);
        }
    }

    public synchronized void stop() throws MuleException {
        MuleException failure = null;
        for (String serviceId : new Vector<String>(this.services.keySet())) {
            CallResult result = this.StopService(serviceId);
            if (result.IsError() && failure == null) {
                failure = new DefaultMuleException(result.getErrorInfo());
            }
        }
        if (failure != null) {
            throw failure;
        }
    }

    public synchronized void start() throws MuleException {
        if (this.context == null || this.context.getRegistry() == null) {
            throw new DefaultMuleException("Mule registry is required");
        }
        if (this.strConfigPath == null) {
            this.strConfigPath = this.config == null ? null : this.config.get("CONFIGPATH");
        }
        if (this.strConfigPath == null || this.strConfigPath.length() == 0) {
            throw new DefaultMuleException("CONFIGPATH is required");
        }
        if (this.eaiDataCtrl == null) {
            Object helper = this.context.getRegistry().lookupObject("SRFDACONTEXTHELPER");
            if (!(helper instanceof ISRFDAGlobalHelper)) {
                throw new DefaultMuleException("SRFDACONTEXTHELPER must be an ISRFDAGlobalHelper");
            }
            if (helper instanceof EAIDAGlobalHelper) {
                this.daGlobalHelper = (EAIDAGlobalHelper) helper;
            }
            String ctrlName = this.config == null ? null : this.config.get("EAIDATACTRL");
            ISRFEAIDataCtrl dataCtrl;
            try {
                dataCtrl = ctrlName == null || ctrlName.length() == 0
                        ? new DefaultEAIDataCtrl()
                        : (ISRFEAIDataCtrl) Class.forName(ctrlName).newInstance();
            } catch (Exception ex) {
                throw new DefaultMuleException("Could not create EAI data controller", ex);
            }
            CallResult init = dataCtrl.Init((ISRFDAGlobalHelper) helper);
            if (init == null || init.IsError()) {
                throw new DefaultMuleException("Could not initialise EAI data controller: "
                        + (init == null ? "no result" : init.getErrorInfo()));
            }
            this.eaiDataCtrl = dataCtrl;
        }
        this.stop();
        CallResult result = this.eaiDataCtrl.MarkAllServiceStop();
        if (result == null || result.IsError()) {
            throw new DefaultMuleException("Could not reset EAI service states: "
                    + (result == null ? "no result" : result.getErrorInfo()));
        }
        Vector<EAIService> autoServices = new Vector<EAIService>();
        result = this.eaiDataCtrl.GetAutoStartServices(autoServices);
        if (result == null || result.IsError()) {
            throw new DefaultMuleException("Could not load auto-start EAI services: "
                    + (result == null ? "no result" : result.getErrorInfo()));
        }
        for (EAIService service : autoServices) {
            result = this.InternalStartService(service);
            if (result.IsError()) {
                log.error("Could not start EAI service " + service.getEAISERVICEID() + ": " + result.getErrorInfo());
            }
        }
    }

    protected synchronized boolean IsServiceStart(String serviceId) {
        MuleContext serviceContext = this.services.get(key(serviceId));
        return serviceContext != null && serviceContext.isStarted();
    }

    public synchronized CallResult StartService(String serviceId) {
        if (this.eaiDataCtrl == null) {
            return error("EAI service manager is not started");
        }
        if (serviceId == null || serviceId.length() == 0) {
            return error("EAI service ID is required");
        }
        EAIService service = new EAIService();
        CallResult result = this.eaiDataCtrl.GetService(serviceId, service);
        if (result == null || result.IsError()) {
            return result == null ? error("Could not load EAI service " + serviceId) : result;
        }
        if (this.services.containsKey(key(serviceId))) {
            CallResult alreadyStarted = error("EAI service " + serviceId + " is already started");
            alreadyStarted.setRetCode(5);
            return alreadyStarted;
        }
        return this.InternalStartService(service);
    }

    protected CallResult InternalStartService(EAIService service) {
        if (service == null || service.getEAISERVICEID().length() == 0) {
            return error("EAI service ID is required");
        }
        if (service.getSVRMODEL().length() == 0) {
            return error("EAI service model is required");
        }
        try {
            EAIConfig model = new EAIConfig();
            if (!model.LoadXML(service.getSVRMODEL())) {
                return error("Could not load EAI service model");
            }
            Object helper = this.context.getRegistry().lookupObject("SRFDACONTEXTHELPER");
            if (!(helper instanceof ISRFDAGlobalHelper)) {
                return error("SRFDACONTEXTHELPER must be an ISRFDAGlobalHelper");
            }
            DefaultConfigWriterContext writerContext = new DefaultConfigWriterContext();
            writerContext.setEAIDataCtrl(this.eaiDataCtrl);
            writerContext.setGlobalHelper((ISRFDAGlobalHelper) helper);
            writerContext.setServiceId(service.getEAISERVICEID());
            writerContext.setEAIConfig(model);
            Properties params = new Properties();
            if (this.config != null) {
                for (Map.Entry<String, String> entry : this.config.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        params.setProperty(entry.getKey(), entry.getValue());
                    }
                }
            }
            writerContext.setServiceParams(params);
            StringBuilder xml = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(xml);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            CallResult result = new BaseServiceConfigWriter().Export(service, writer, writerContext);
            if (result == null || result.IsError()) {
                return result == null ? error("Could not export EAI service configuration") : result;
            }
            File file = new File(this.strConfigPath, key(service.getEAISERVICEID()) + ".xml");
            if (!ExportConfigFile(xml, file.getPath())) {
                return error("Could not write EAI service configuration: " + file);
            }
        } catch (Exception ex) {
            return error("Could not export EAI service " + service.getEAISERVICEID() + ": " + ex.getMessage());
        }
        return this.StartServiceProcess(service.getEAISERVICEID());
    }

    public static boolean ExportConfigFile(StringBuilder xml, String path) {
        try {
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
            try {
                output.write(xml.toString());
            } finally {
                output.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    protected MuleContext createServiceContext(String configFile) throws Exception {
        return new DefaultMuleContextFactory().createMuleContext(configFile);
    }

    protected synchronized CallResult StartServiceProcess(String serviceId) {
        if (serviceId == null || serviceId.length() == 0) {
            return error("EAI service ID is required");
        }
        if (this.services.containsKey(key(serviceId))) {
            CallResult duplicate = error("EAI service " + serviceId + " is already started");
            duplicate.setRetCode(5);
            return duplicate;
        }
        CallResult result = this.eaiDataCtrl.MarkServiceStarting(serviceId);
        if (result == null || result.IsError()) {
            return result == null ? error("Could not mark EAI service starting") : result;
        }
        MuleContext child = null;
        try {
            child = this.createServiceContext(new File(this.strConfigPath,
                    key(serviceId) + ".xml").getPath());
            if (child == null) {
                throw new IllegalStateException("Mule context factory returned null");
            }
            child.start();
            this.services.put(key(serviceId), child);
            return new CallResult();
        } catch (Exception ex) {
            if (child != null) {
                try {
                    child.dispose();
                } catch (Exception disposeFailure) {
                    log.error("Could not dispose failed EAI service " + serviceId, disposeFailure);
                }
            }
            String message = "Could not start EAI service " + serviceId + ": " + ex.getMessage();
            try {
                CallResult stopped = this.eaiDataCtrl.MarkServiceStop(serviceId);
                if (stopped == null || stopped.IsError()) {
                    message += "; could not mark service stopped: "
                            + (stopped == null ? "no result" : stopped.getErrorInfo());
                }
            } catch (Exception statusFailure) {
                message += "; could not mark service stopped: " + statusFailure.getMessage();
            }
            return error(message);
        }
    }

    public synchronized CallResult StopService(String serviceId) {
        if (serviceId == null || serviceId.length() == 0) {
            return error("EAI service ID is required");
        }
        MuleContext child = this.services.get(key(serviceId));
        String stopFailure = null;
        if (child != null) {
            try {
                if (child.isStarted()) {
                    child.stop();
                }
            } catch (Exception ex) {
                stopFailure = ex.getMessage();
            }
            try {
                child.dispose();
                this.services.remove(key(serviceId));
            } catch (Exception ex) {
                return error("Could not dispose EAI service " + serviceId + ": " + ex.getMessage());
            }
        }
        if (this.eaiDataCtrl == null) {
            return error("EAI service manager is not started");
        }
        try {
            CallResult result = this.eaiDataCtrl.MarkServiceStop(serviceId);
            if (result == null || result.IsError()) {
                return result == null ? error("Could not mark EAI service stopped") : result;
            }
            return stopFailure == null ? result : error("Could not stop EAI service " + serviceId + ": " + stopFailure);
        } catch (Exception ex) {
            return error("Could not mark EAI service stopped: " + ex.getMessage());
        }
    }

    public CallResult GetStartupServices() {
        if (this.eaiDataCtrl == null) {
            return error("EAI service manager is not started");
        }
        Vector<EAIService> services = new Vector<EAIService>();
        CallResult result = this.eaiDataCtrl.GetAutoStartServices(services);
        if (result != null && !result.IsError()) {
            result.setUserObject(services);
        }
        return result == null ? error("Could not load auto-start EAI services") : result;
    }

    private static CallResult error(String message) {
        CallResult result = new CallResult();
        result.setRetCode(1);
        result.setErrorInfo(message);
        return result;
    }

    private static String key(String serviceId) {
        return serviceId == null ? null : serviceId.toLowerCase(Locale.ROOT);
    }
}
