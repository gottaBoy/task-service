/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.WF.IPSWorkflowObject;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelObjectLoggerImpl
implements IPSModelObjectLogger {
    private static final Log log = LogFactory.getLog(PSModelObjectLoggerImpl.class);
    public static final int MAXLIMIT = 99999999;
    private int nLimit = 10000;
    private int nTotal = 0;
    private IPSSysDevBKTask iPSSysDevBKTask = null;
    private String strPSDevSlnSysId = null;
    private String strPSSysModelInstId = null;
    private String strConsoleLogger = null;
    private String strPSSystemId = null;
    private String strPSDevCenterId = null;
    private String strPSDynaInstId = null;
    private String strPSDSConsoleId = null;
    private boolean bLogSysConsole = false;
    private String strFilePath = null;
    private boolean bSendToDSConsole = false;

    public PSModelObjectLoggerImpl(IPSSysDevBKTask iPSSysDevBKTask, String strPSDevCenterId, String strConsoleLogger, int nLimit) {
        if (nLimit > 0) {
            this.nLimit = nLimit;
        }
        this.iPSSysDevBKTask = iPSSysDevBKTask;
        this.strPSDevCenterId = strPSDevCenterId;
        if (!StringHelper.IsNullOrEmpty((String)this.getPSSysDevBKTask().getPSDevSlnSysId())) {
            this.strPSDevSlnSysId = this.getPSSysDevBKTask().getPSDevSlnSysId();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSSysDevBKTask().getPSDynaInstId())) {
            this.strPSDynaInstId = this.getPSSysDevBKTask().getPSDynaInstId();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSSysDevBKTask().getPSSystemId())) {
            this.strPSSystemId = this.getPSSysDevBKTask().getPSSystemId();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSSysDevBKTask().getPSDSConsoleId())) {
            this.strPSDSConsoleId = this.getPSSysDevBKTask().getPSDSConsoleId();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSSysDevBKTask().getPSSysModelInstId())) {
            this.strPSSysModelInstId = this.getPSSysDevBKTask().getPSSysModelInstId();
        }
        this.strConsoleLogger = strConsoleLogger;
        this.strFilePath = !StringHelper.IsNullOrEmpty((String)this.getPSDynaInstId()) ? String.format("%1$s%2$s%3$s%2$s%4$s", PSTaskServerEnvImpl.getCurrent().getSysLogFolder(), File.separator, this.getPSDevCenterId(), this.getPSDynaInstId()) : String.format("%1$s%2$s%3$s%2$s%4$s", PSTaskServerEnvImpl.getCurrent().getSysLogFolder(), File.separator, this.getPSDevCenterId(), this.getPSDevSlnSysId());
        File file = new File(this.strFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.strFilePath = String.valueOf(this.strFilePath) + File.separator;
        this.strFilePath = String.valueOf(this.strFilePath) + String.format("%1$tY%1$tm%1$td.log", new Date());
    }

    public String getPSDevSlnSysId() {
        return this.strPSDevSlnSysId;
    }

    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    public String getConsoleLogger() {
        return this.strConsoleLogger;
    }

    public String getPSSystemId() {
        return this.strPSSystemId;
    }

    public String getPSDevCenterId() {
        return this.strPSDevCenterId;
    }

    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    public IPSSysDevBKTask getPSSysDevBKTask() {
        return this.iPSSysDevBKTask;
    }

    public String getPSDSConsoleId() {
        return this.strPSDSConsoleId;
    }

    @Override
    public void info(IPSModelObject iPSModelObject, String strInfo) {
        this.logSysConsole("INFO", iPSModelObject, strInfo, null, null);
    }

    @Override
    public void warn(IPSModelObject iPSModelObject, String strInfo) {
        this.logSysConsole("WARN", iPSModelObject, strInfo, null, null);
    }

    @Override
    public void error(IPSModelObject iPSModelObject, String strInfo) {
        this.logSysConsole("ERROR", iPSModelObject, strInfo, null, null);
    }

    protected final void logSysConsole(String strLogType, IPSModelObject iPSModelObject, String strLogInfo, String strIssueSN, Object objTag) {
        try {
            if (StringHelper.IsNullOrEmpty((String)strLogInfo)) {
                return;
            }
            ++this.nTotal;
            if (this.nTotal > this.nLimit) {
                return;
            }
            if (this.isSendToDSConsole() && !StringHelper.IsNullOrEmpty((String)this.getPSDSConsoleId()) && PSStudioConsoleHelper.getCurrent() != null) {
                String strContent;
                if (StringHelper.Compare((String)strLogType, (String)"ERROR", (boolean)false) == 0) {
                    strContent = PSStudioConsoleHelper.getContent((String)strLogInfo, (int)31, (int)-1, (int)0);
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), strContent, this.getConsoleLogger());
                } else if (StringHelper.Compare((String)strLogType, (String)"WARN", (boolean)false) == 0) {
                    strContent = PSStudioConsoleHelper.getContent((String)strLogInfo, (int)33, (int)-1, (int)0);
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), strContent, this.getConsoleLogger());
                }
            }
            this.appendLog(strLogType, iPSModelObject, strLogInfo, strIssueSN, objTag);
            if (this.isLogSysConsole() && StringHelper.Compare((String)strLogType, (String)"INFO", (boolean)false) != 0) {
                final PSSysConsole psSysConsole = new PSSysConsole();
                psSysConsole.setLogTime(new Timestamp(System.currentTimeMillis()));
                psSysConsole.setPSSysConsoleName(this.getConsoleLogger());
                psSysConsole.setLogLevel(strLogType);
                psSysConsole.setLogInfo(strLogInfo);
                psSysConsole.setPSSystemId(this.getPSSystemId());
                psSysConsole.setPSSystemName("Sys");
                final PSSysConsoleService psSysConsoleService = (PSSysConsoleService)ServiceGlobal.getService(PSSysConsoleService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                    psSysConsoleService.create(psSysConsole, false);
                    }
                });
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public void info(IPSModelObject iPSModelObject, String strInfo, String strIssueSN, Object objTag) {
        this.logSysConsole("INFO", iPSModelObject, strInfo, strIssueSN, objTag);
    }

    @Override
    public void warn(IPSModelObject iPSModelObject, String strInfo, String strIssueSN, Object objTag) {
        this.logSysConsole("WARN", iPSModelObject, strInfo, strIssueSN, objTag);
    }

    @Override
    public void error(IPSModelObject iPSModelObject, String strInfo, String strIssueSN, Object objTag) {
        this.logSysConsole("ERROR", iPSModelObject, strInfo, strIssueSN, objTag);
    }

    public boolean isLogSysConsole() {
        return this.bLogSysConsole;
    }

    public void setLogSysConsole(boolean bLogSysConsole) {
        this.bLogSysConsole = bLogSysConsole;
    }

    public boolean isSendToDSConsole() {
        return this.bSendToDSConsole;
    }

    public void setSendToDSConsole(boolean bSendToDSConsole) {
        this.bSendToDSConsole = bSendToDSConsole;
    }

    protected void appendLog(String strLogType, IPSModelObject iPSModelObject, String strLogInfo, String strIssueSN, Object objTag) {
        ObjectNode objNode = null;
        if (objTag != null && objTag instanceof ObjectNode) {
            objNode = (ObjectNode)objTag;
        }
        if (objNode == null) {
            objNode = JsonNodeHelper.createObjectNode();
        }
        objNode.put("logtype", strLogType);
        objNode.put("loginfo", strLogInfo);
        objNode.put("logtime", System.currentTimeMillis());
        if (!StringHelper.IsNullOrEmpty((String)strIssueSN)) {
            objNode.put("issueid", strIssueSN);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDevCenterId())) {
            objNode.put("psdevcenterid", this.getPSDevCenterId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDynaInstId())) {
            objNode.put("psdynainstid", this.getPSDynaInstId());
        } else if (!StringHelper.IsNullOrEmpty((String)this.getPSDevSlnSysId())) {
            objNode.put("psdevslnsysid", this.getPSDevSlnSysId());
        }
        if (this.getPSSysDevBKTask() != null) {
            objNode.put("pstaskid", this.getPSSysDevBKTask().getId());
            objNode.put("pstaskname", this.getPSSysDevBKTask().getName());
        }
        if (iPSModelObject != null) {
            IPSApplicationObject iPSApplicationObject;
            IPSWorkflowObject iPSWorkflowObject;
            IPSDataEntityObject iPSDataEntityObject;
            if (!StringHelper.IsNullOrEmpty((String)iPSModelObject.getModelType())) {
                objNode.put("psmodeltype", iPSModelObject.getModelType());
                objNode.put("psmodelid", iPSModelObject.getId());
                objNode.put("psmodelname", iPSModelObject.getName());
            }
            if (iPSModelObject instanceof IPSDataEntityObject && (iPSDataEntityObject = (IPSDataEntityObject)iPSModelObject).getPSDataEntity() != null) {
                objNode.put("psdeid", iPSDataEntityObject.getPSDataEntity().getId());
                objNode.put("psdename", iPSDataEntityObject.getPSDataEntity().getName());
            }
            if (iPSModelObject instanceof IPSWorkflowObject && (iPSWorkflowObject = (IPSWorkflowObject)((Object)iPSModelObject)).getPSWorkflow() != null) {
                objNode.put("pswfid", iPSWorkflowObject.getPSWorkflow().getId());
                objNode.put("pswfname", iPSWorkflowObject.getPSWorkflow().getName());
            }
            if (iPSModelObject instanceof IPSApplicationObject && (iPSApplicationObject = (IPSApplicationObject)iPSModelObject).getPSApplication() != null) {
                objNode.put("pssysappid", iPSApplicationObject.getPSApplication().getId());
                objNode.put("pssysappname", iPSApplicationObject.getPSApplication().getName());
            }
        }
        FileWriter fw = null;
        try {
            File f = new File(this.strFilePath);
            fw = new FileWriter(f, true);
        }
        catch (IOException e) {
            log.error((Object)e);
            return;
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(objNode.toString());
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        }
        catch (IOException e) {
            log.error((Object)e);
            return;
        }
    }
}
