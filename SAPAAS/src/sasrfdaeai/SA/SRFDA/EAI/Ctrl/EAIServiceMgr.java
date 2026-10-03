/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Config.BaseServiceConfigWriter;
import SA.SRFDA.EAI.Config.DefaultConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Ctrl.DefaultEAIDataCtrl;
import SA.SRFDA.EAI.Ctrl.EAIServiceInstance;
import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EAIServiceMgr {
    private static Log log = LogFactory.getLog(EAIServiceMgr.class);
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    protected String strEAIDataCtrl = "";
    protected ISRFEAIDataCtrl eaiDataCtrl;
    protected String strConfigPath = "";
    protected String strEAICommand = "";
    protected boolean bWindowOS = true;
    protected Properties serviceParams = null;

    public EAIServiceMgr(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    public CallResult Start() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.strEAIDataCtrl)) {
            this.strEAIDataCtrl = DefaultEAIDataCtrl.class.getName();
        }
        this.eaiDataCtrl = (ISRFEAIDataCtrl)ObjectHelper.Create((String)this.strEAIDataCtrl);
        if (this.eaiDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u96c6\u6210\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61[%1$s]", (Object)this.strEAIDataCtrl));
        }
        this.eaiDataCtrl.Init(this.iDAGlobalHelper);
        CallResult callResult = this.eaiDataCtrl.MarkAllServiceStop();
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u91cd\u7f6e\u670d\u52a1\u72b6\u6001\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.Stop();
        Vector<EAIService> autoServices = new Vector<EAIService>();
        callResult = this.eaiDataCtrl.GetAutoStartServices(autoServices);
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u81ea\u52a8\u542f\u52a8\u670d\u52a1\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (EAIService eaiService : autoServices) {
            callResult = this.InternalStartService(eaiService);
            if (!callResult.IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u542f\u52a8\u670d\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)eaiService.getEAISERVICEID(), (Object)callResult.getErrorInfo()));
        }
        return callResult;
    }

    public CallResult Stop() {
        Vector<EAIService> autoServices = new Vector<EAIService>();
        CallResult callResult = this.eaiDataCtrl.GetServices(autoServices);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        for (EAIService eaiService : autoServices) {
            this.StopService(eaiService.getEAISERVICEID());
        }
        return new CallResult();
    }

    public CallResult StartService(String strServiceId) {
        EAIService eaiService = new EAIService();
        CallResult callResult = this.eaiDataCtrl.GetService(strServiceId, eaiService);
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.IsServiceStart(strServiceId)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u96c6\u6210\u670d\u52a1[%1$s][%2$s]\u5df2\u7ecf\u542f\u52a8\uff0c\u65e0\u6cd5\u518d\u6b21\u542f\u52a8.", (Object)eaiService.getEAISERVICENAME(), (Object)eaiService.getEAISERVICEID()));
            return callResult;
        }
        return this.InternalStartService(eaiService);
    }

    protected CallResult InternalStartService(EAIService eaiService) {
        Object objWriter;
        CallResult callResult = new CallResult();
        DefaultConfigWriterContext configWriterContext = new DefaultConfigWriterContext();
        configWriterContext.setEAIDataCtrl(this.eaiDataCtrl);
        configWriterContext.setGlobalHelper(this.iDAGlobalHelper);
        configWriterContext.setServiceId(eaiService.getEAISERVICEID());
        configWriterContext.setServiceParams(this.serviceParams);
        String strEAIModel = eaiService.getSVRMODEL();
        if (StringHelper.IsNullOrEmpty((String)strEAIModel)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u96c6\u6210\u670d\u52a1\u6a21\u578b\u65e0\u6548");
            return callResult;
        }
        EAIConfig eaiConfig = new EAIConfig();
        if (!eaiConfig.LoadXML(strEAIModel)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u52a0\u8f7d\u96c6\u6210\u670d\u52a1\u6a21\u578b\u5931\u8d25");
            return callResult;
        }
        configWriterContext.setEAIConfig(eaiConfig);
        String strConfigWriter = eaiService.getCONFIGWRITER();
        if (StringHelper.IsNullOrEmpty((String)strConfigWriter)) {
            strConfigWriter = BaseServiceConfigWriter.class.getName();
        }
        if ((objWriter = ObjectHelper.Create((String)strConfigWriter)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u670d\u52a1\u914d\u7f6e\u7f16\u5199\u5668\u5bf9\u8c61[%1$s]", (Object)strConfigWriter));
            return callResult;
        }
        if (!(objWriter instanceof BaseServiceConfigWriter)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u670d\u52a1\u914d\u7f6e\u7f16\u5199\u5668\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strConfigWriter));
            return callResult;
        }
        BaseServiceConfigWriter serviceConfigWriter = (BaseServiceConfigWriter)objWriter;
        StringBuilder sb = new StringBuilder();
        SimpleXMLWriter writer = new SimpleXMLWriter(sb);
        writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
        callResult = serviceConfigWriter.Export(eaiService, writer, configWriterContext);
        if (callResult.IsError()) {
            return callResult;
        }
        String strServiceConfigFile = new File(this.strConfigPath,
                eaiService.getEAISERVICEID().toLowerCase(Locale.ROOT) + ".xml").getPath();
        if (!EAIServiceMgr.ExportConfigFile(sb, strServiceConfigFile)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5bfc\u51fa\u670d\u52a1\u914d\u7f6e\u6587\u4ef6\u5931\u8d25[%1$s]", (Object)strServiceConfigFile));
            return callResult;
        }
        callResult = this.StartServiceProcess(eaiService.getEAISERVICEID());
        return callResult;
    }

    public static boolean ExportConfigFile(StringBuilder sb, String strConfigPath) {
        try {
            File parent = new File(strConfigPath).getParentFile();
            if (parent != null && !parent.isDirectory() && !parent.mkdirs()) {
                return false;
            }
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strConfigPath), "UTF-8");
            out.write(sb.toString());
            out.flush();
            out.close();
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    protected CallResult StartServiceProcess(String strEAIServiceId) {
        CallResult callResult = new CallResult();
        try {
            callResult = this.eaiDataCtrl.MarkServiceStarting(strEAIServiceId);
            if (callResult.IsError()) {
                return callResult;
            }
            EAIServiceInstance eaiInstance = new EAIServiceInstance();
            eaiInstance.setConfigPath(this.strConfigPath);
            eaiInstance.setServiceId(strEAIServiceId);
            eaiInstance.setEAICommand(this.strEAICommand);
            eaiInstance.setEAIDataCtrl(this.eaiDataCtrl);
            Thread th = new Thread(eaiInstance);
            th.start();
        }
        catch (Exception ex) {
            this.eaiDataCtrl.MarkServiceStop(strEAIServiceId);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    public boolean IsServiceStart(String strServiceId) {
        try {
            return this.runFile(strServiceId).isFile();
        }
        catch (Exception ex) {
            return false;
        }
    }

    public CallResult StopService(String strServiceId) {
        CallResult callResult = new CallResult();
        try {
            File file = this.runFile(strServiceId);
            if (file.exists() && !file.delete()) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("Cannot remove EAI run marker: " + file);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private File runFile(String serviceId) {
        return new File(this.strConfigPath, serviceId.toLowerCase(Locale.ROOT) + ".run");
    }

    public String getEAIDataCtrl() {
        return this.strEAIDataCtrl;
    }

    public String getConfigPath() {
        return this.strConfigPath;
    }

    public String getEAICommand() {
        return this.strEAICommand;
    }

    public void setEAIDataCtrl(String strEAIDataCtrl) {
        this.strEAIDataCtrl = strEAIDataCtrl;
    }

    public void setConfigPath(String strConfigPath) {
        this.strConfigPath = strConfigPath;
    }

    public void setEAICommand(String strEAICommand) {
        this.strEAICommand = strEAICommand;
    }

    public Properties getServiceParams() {
        return this.serviceParams;
    }

    public void setServiceParams(Properties serviceParams) {
        this.serviceParams = serviceParams;
    }
}
