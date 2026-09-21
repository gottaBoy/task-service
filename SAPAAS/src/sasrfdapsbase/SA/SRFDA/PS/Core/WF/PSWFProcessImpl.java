/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFProcess
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkType;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessParam;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Core.WF.PSWFProcessParamImpl;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFProcessImpl
extends PSObjectImpl
implements IPSWFProcess {
    private static final Log log = LogFactory.getLog(PSWFProcessImpl.class);
    protected IPSWFVersion iPSWFVersion;
    protected PSWFProcess psWFProcess;
    protected ArrayList<IPSWFLink> psWFLinkList = new ArrayList();
    protected ArrayList<IPSWFProcessParam> psWFProcessParamList = new ArrayList();
    private IPSLanguageRes namePSLanguageRes = null;
    private boolean bEnableTimeout = false;
    private int nTimeout = -1;
    private String strTimeoutField = null;
    private String strTimeoutType = null;
    private String strWorktimeType = null;
    private String strTimeoutNext = null;
    private int nThreadSN = -1;
    private String strThreadShowName = null;
    private boolean bAsynchronousProcess = false;
    private IPSLanguageRes tsnPSLanguageRes = null;
    private String strModelId = null;
    private IPSSysMsgTempl iPSSysMsgTempl = null;
    private IPSWFWorkTime iPSWFWorkTime = null;
    private IPSDEWF iPSDEWF = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFVersion iPSWFVersion, PSWFProcess psWFProcess) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFVersion = iPSWFVersion;
            this.psWFProcess = psWFProcess;
            this.setId(this.psWFProcess.getPSWFPROCESSID());
            this.setName(this.psWFProcess.getPSWFPROCESSNAME());
            this.setPSObjectData(this.psWFProcess);
            if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSWFVersion().getPSWorkflow().getPSSystem().getPSLanguageRes(this.psWFProcess.getNAMEPSLANRESID());
            }
            if (!this.psWFProcess.isENABLETIMEOUTNull()) {
                this.bEnableTimeout = this.psWFProcess.getENABLETIMEOUT();
            }
            if (this.isEnableTimeout()) {
                if (!this.psWFProcess.isTIMEOUTNull()) {
                    this.nTimeout = this.psWFProcess.getTIMEOUT();
                }
                this.strTimeoutField = this.psWFProcess.getTIMEOUTPSDEFNAME();
                this.strTimeoutType = this.psWFProcess.getTIMEOUTTYPE();
                this.strWorktimeType = this.psWFProcess.getPSWFWORKTIMEID();
            }
            if (!this.psWFProcess.isTHREADSNNull()) {
                this.nThreadSN = this.psWFProcess.getTHREADSN();
            }
            if (!StringHelper.isNullOrEmpty((Object)this.psWFProcess.isTHREADNAMENull())) {
                this.strThreadShowName = this.psWFProcess.getTHREADNAME();
            }
            if (!this.psWFProcess.isASYNCMODENull()) {
                this.bAsynchronousProcess = this.psWFProcess.getASYNCMODE();
            }
            this.strModelId = this.psWFProcess.getMODELID();
            if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getPSSYSMSGTEMPLID())) {
                this.iPSSysMsgTempl = this.getPSWFVersion().getPSWorkflow().getPSSystem().getPSSysMsgTempl(this.psWFProcess.getPSSYSMSGTEMPLID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getPSWFWORKTIMEID())) {
                this.iPSWFWorkTime = this.getPSWFVersion().getPSWorkflow().getPSSystem().getPSWFWorkTime(this.psWFProcess.getPSWFWORKTIMEID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psWFProcess.getPSWFDEID())) {
            this.iPSDEWF = this.getPSWFVersion().getPSWorkflow().getPSDEWF(this.psWFProcess.getPSWFDEID(), true);
        }
        super.onInit();
        this.preparePSWFProcessParams();
        this.preparePSWFLinks();
    }

    protected void preparePSWFLinks() throws Exception {
        this.psWFLinkList.clear();
        ArrayList<PSWFLink> psWFLinkList = this.psWFProcess.getPSWFLinks(false);
        if (psWFLinkList == null) {
            return;
        }
        for (PSWFLink psWFLink : psWFLinkList) {
            IPSWFLinkType iPSWFLinkType = this.getPSModelStorage().getPSWFLinkType(psWFLink.getWFLINKTYPE());
            IPSWFLink iPSWFLink = iPSWFLinkType.createPSWFLink(psWFLink);
            iPSWFLink.init(this.getDAGlobalHelper(), this.iPSWFVersion, this, psWFLink);
            this.psWFLinkList.add(iPSWFLink);
            if (!this.isEnableTimeout() || StringHelper.compare((String)psWFLink.getWFLINKTYPE(), (String)"TIMEOUT", (boolean)true) != 0) continue;
            this.strTimeoutNext = iPSWFLink.getNext();
        }
    }

    protected void preparePSWFProcessParams() throws Exception {
        this.psWFProcessParamList.clear();
        ArrayList<PSWFProcParam> psWFProcessParamList = this.psWFProcess.getPSWFProcParams(false);
        if (psWFProcessParamList == null) {
            return;
        }
        for (PSWFProcParam psWFProcParam : psWFProcessParamList) {
            PSWFProcessParamImpl iPSWFVersionProcessParam = new PSWFProcessParamImpl();
            iPSWFVersionProcessParam.init(this.getDAGlobalHelper(), this, psWFProcParam);
            this.psWFProcessParamList.add(iPSWFVersionProcessParam);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u8fde\u51fa\u96c6\u5408", hideempty2=true, dumpref=true, child=true, rtdump=2, outputdoc="false")
    public Iterator<IPSWFLink> getPSWFLinks() {
        if (this.psWFLinkList == null || this.psWFLinkList.size() == 0) {
            return null;
        }
        return this.psWFLinkList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u7c7b\u578b", codelist="AllWFProcessType", fields={"WFPROCESSTYPE"})
    public String getWFProcessType() {
        return this.psWFProcess.getWFPROCESSTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u7248\u672c", outputdoc="false")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psWFProcess.getCODENAME();
    }

    @Override
    public boolean isParallelOutput() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u53c2\u6570\u96c6\u5408", hideempty2=true, child=true, ignorepf=true)
    public Iterator<IPSWFProcessParam> getPSWFProcessParams() {
        if (this.psWFProcessParamList == null || this.psWFProcessParamList.size() == 0) {
            return null;
        }
        return this.psWFProcessParamList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true, fields={"WFSTEPVALUE"})
    public String getWFStepValue() {
        return this.onGetWFStepValue();
    }

    protected String onGetWFStepValue() {
        return this.psWFProcess.getWFSTEPVALUE();
    }

    public void init(IWFVersionModel iWFVersionModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", hideempty2=true, fields={"PSWFPROCESSNAME"})
    public String getLogicName() {
        return this.psWFProcess.getPSWFPROCESSNAME();
    }

    public IWFVersionModel getWFVersionModel() {
        return this.getPSWFVersion();
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u5904\u7406")
    public boolean isAsynchronousProcess() {
        return this.bAsynchronousProcess;
    }

    @Override
    public boolean isSuspendProcess() {
        return false;
    }

    @Override
    public boolean isTerminalProcess() {
        return false;
    }

    @Override
    public boolean isStartProcess() {
        return false;
    }

    public IWFProcess getWFProcess() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5904\u7406\u8d85\u65f6", fields={"ENABLETIMEOUT"})
    public boolean isEnableTimeout() {
        return this.bEnableTimeout;
    }

    @Override
    public String getTimeoutNext() {
        return this.strTimeoutNext;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u8d85\u65f6\u65f6\u957f", fields={"TIMEOUT"})
    public int getTimeout() {
        return this.nTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u8d85\u65f6\u65f6\u957f\u5b58\u653e\u5c5e\u6027", fields={"TIMEOUTPSDEFID"})
    public String getTimeoutField() {
        return this.strTimeoutField;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u8d85\u65f6\u5355\u4f4d", codelist="WFTimeoutType", fields={"TIMEOUTTYPE"})
    public String getTimeoutType() {
        return this.strTimeoutType;
    }

    @Override
    public String getWorkTimeType() {
        return this.strWorktimeType;
    }

    public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public Iterator<IWFLinkModel> getWFLinkModels() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWFVersion().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u4f4d\u7f6e", fields={"LEFTPOS"})
    public int getLeftPos() {
        return this.psWFProcess.getLEFTPOS();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u4f4d\u7f6e", fields={"TOPPOS"})
    public int getTopPos() {
        return this.psWFProcess.getTOPPOS();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6")
    public int getWidth() {
        return this.getDefaultWidth();
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public int getHeight() {
        return this.getDefaultHeight();
    }

    protected int getDefaultWidth() {
        return 100;
    }

    protected int getDefaultHeight() {
        return 80;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psWFProcess.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
    public String getUserData2() {
        return this.psWFProcess.getUSERDATA2();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", fields={"NAMEPSLANRESID"})
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Deprecated
    public String getWorktimeType() {
        return this.getWorkTimeType();
    }

    @Override
    public int getThreadSN() {
        return this.nThreadSN;
    }

    @Override
    public String getThreadShowName() {
        return this.strThreadShowName;
    }

    public String getNameLanResTag() {
        if (this.getNamePSLanguageRes() != null) {
            return this.getNamePSLanguageRes().getLanResTag();
        }
        return null;
    }

    public String getTSNLanResTag() {
        if (this.getTSNPSLanguageRes() != null) {
            return this.getTSNPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public IPSLanguageRes getTSNPSLanguageRes() {
        return this.tsnPSLanguageRes;
    }

    public IWFLinkModel getWFLinkModel(String strWFLinkModelId) throws Exception {
        return null;
    }

    @Override
    public String getBPMNModelId() {
        return this.strModelId;
    }

    @Override
    public String getModelType() {
        return "PSWFPROCESS";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFVersion().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWFVersion().getPSWorkflow().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        if (!StringHelper.isNullOrEmpty((String)this.getCodeName())) {
            return KeyValueHelper.genUniqueId((String)this.getPSWFVersion().getDeployId(), (String)this.getCodeName());
        }
        return KeyValueHelper.genUniqueId((String)this.getPSWFVersion().getDeployId(), (String)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u6d88\u606f\u6a21\u677f", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getPSSysMsgTempl() {
        return this.iPSSysMsgTempl;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5de5\u4f5c\u65f6\u95f4", hideempty=true, dumpref=true, ignorepf=true, fields={"PSWFWORKTIMEID"})
    public IPSWFWorkTime getPSWFWorkTime() {
        return this.iPSWFWorkTime;
    }

    @Override
    public IPSDEWF getPSDEWF() {
        return this.iPSDEWF;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSWFVersion();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSWFVersion();
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return "";
    }
}

