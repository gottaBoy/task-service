/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFProcessParam
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFProcess
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFLinkRuntime;
import net.ibizsys.model.wf.IPSWFLinkType;
import net.ibizsys.model.wf.IPSWFProcessParam;
import net.ibizsys.model.wf.IPSWFProcessRuntime;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.PSWFProcessParamImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFProcessImpl
extends PSObjectImpl
implements IPSWFProcessRuntime {
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

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFVersion iPSWFVersion, PSWFProcess psWFProcess) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
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
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSWFLinks();
        this.preparePSWFProcessParams();
    }

    protected void preparePSWFLinks() throws Exception {
        this.psWFLinkList.clear();
        ArrayList<PSWFLink> psWFLinkList = this.psWFProcess.getPSWFLinks(false);
        if (psWFLinkList == null) {
            return;
        }
        for (PSWFLink psWFLink : psWFLinkList) {
            IPSWFLinkType iPSWFLinkType = this.getPSModelStorageContext().getPSWFLinkType(psWFLink.getWFLINKTYPE());
            IPSWFLink iPSWFLink = iPSWFLinkType.createPSWFLink(psWFLink);
            ((IPSWFLinkRuntime)iPSWFLink).init(this.getPSModelStorageContext(), this.iPSWFVersion, psWFLink);
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
            iPSWFVersionProcessParam.init(this.getPSModelStorageContext(), this, psWFProcParam);
            this.psWFProcessParamList.add(iPSWFVersionProcessParam);
        }
    }

    @PSModelRTMeta(description="\u5904\u7406\u8fde\u51fa\u96c6\u5408", hideempty2=true)
    public Iterator<IPSWFLink> getPSWFLinks() {
        if (this.psWFLinkList == null || this.psWFLinkList.size() == 0) {
            return null;
        }
        return this.psWFLinkList.iterator();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u7c7b\u578b", codelist="WFProcessType")
    public String getWFProcessType() {
        return this.psWFProcess.getWFPROCESSTYPE();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u7248\u672c")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psWFProcess.getCODENAME();
    }

    public boolean isParallelOutput() {
        return false;
    }

    @PSModelRTMeta(description="\u5904\u7406\u53c2\u6570\u96c6\u5408", hideempty2=true)
    public Iterator<IPSWFProcessParam> getPSWFProcessParams() {
        if (this.psWFProcessParamList == null || this.psWFProcessParamList.size() == 0) {
            return null;
        }
        return this.psWFProcessParamList.iterator();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true)
    public String getWFStepValue() {
        return this.psWFProcess.getWFSTEPVALUE();
    }

    public void init(IWFVersionModel iWFVersionModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", hideempty2=true)
    public String getLogicName() {
        return this.psWFProcess.getPSWFPROCESSNAME();
    }

    public IWFVersionModel getWFVersionModel() {
        return this.getPSWFVersion();
    }

    @PSModelRTMeta(description="\u5f02\u6b65\u5904\u7406")
    public boolean isAsynchronousProcess() {
        return this.bAsynchronousProcess;
    }

    public boolean isSuspendProcess() {
        return false;
    }

    public boolean isTerminalProcess() {
        return false;
    }

    public boolean isStartProcess() {
        return false;
    }

    public IWFProcess getWFProcess() {
        return null;
    }

    public boolean isEnableTimeout() {
        return this.bEnableTimeout;
    }

    public String getTimeoutNext() {
        return this.strTimeoutNext;
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public String getTimeoutField() {
        return this.strTimeoutField;
    }

    public String getTimeoutType() {
        return this.strTimeoutType;
    }

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
        return this.getPSSysModelInstId((IPSModelObject)this.getPSWFVersion());
    }

    public int getLeftPos() {
        return this.psWFProcess.getLEFTPOS();
    }

    public int getTopPos() {
        return this.psWFProcess.getTOPPOS();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e", hideempty2=true)
    public String getUserData() {
        return this.psWFProcess.getUSERDATA();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e2", hideempty2=true)
    public String getUserData2() {
        return this.psWFProcess.getUSERDATA2();
    }

    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Deprecated
    public String getWorktimeType() {
        return this.getWorkTimeType();
    }

    public int getThreadSN() {
        return this.nThreadSN;
    }

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

    public IPSLanguageRes getTSNPSLanguageRes() {
        return this.tsnPSLanguageRes;
    }

    public IWFLinkModel getWFLinkModel(String strWFLinkModelId) throws Exception {
        return null;
    }

    public String getBPMNModelId() {
        return this.strModelId;
    }
}

