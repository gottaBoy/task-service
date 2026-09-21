/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFProcessBase;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessSubWF;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSWFProcessSubWFImpl
extends PSObjectImpl
implements IPSWFProcessSubWF {
    private static final Log log = LogFactory.getLog(PSWFProcessSubWFImpl.class);
    private IPSWFEmbedWFProcessBase iPSWFEmbedWFProcessBase = null;
    private PSWFProcSubWF psWFProcSubWF = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSWorkflow iPSWorkflow = null;
    private String strCodeName = "";
    private boolean bSuspendDefault = false;
    private IPSWFVersion iPSWFVersion = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFEmbedWFProcessBase iPSWFEmbedWFProcessBase, PSWFProcSubWF psWFProcSubWF) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psWFProcSubWF = psWFProcSubWF;
            this.setId(psWFProcSubWF.getPSWFPROCSUBWFID());
            this.setName(psWFProcSubWF.getPSWFPROCSUBWFNAME());
            this.setPSObjectData(this.psWFProcSubWF);
            this.iPSWFEmbedWFProcessBase = iPSWFEmbedWFProcessBase;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFProcSubWF.getEMBEDPSWFID())) {
                this.iPSWorkflow = iPSWFEmbedWFProcessBase.getPSWFVersion().getPSWorkflow().getPSSystem().getPSWorkflow(this.psWFProcSubWF.getEMBEDPSWFID());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFProcSubWF.getEMBEDPSWFVERID())) {
                    this.iPSWFVersion = this.iPSWorkflow.getPSWFVersion(this.psWFProcSubWF.getEMBEDPSWFVERID());
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFProcSubWF.getEMBEDPSDEID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5d4c\u5165\u6d41\u7a0b\u5b9e\u4f53");
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFProcSubWF.getEMBEDPSDEDSID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5d4c\u5165\u6d41\u7a0b\u5b9e\u4f53\u6570\u636e\u96c6");
            }
            this.iPSDataEntity = this.iPSWorkflow.getPSSystem().getPSDataEntity2(this.psWFProcSubWF.getEMBEDPSDEID());
            this.iPSDEDataSet = this.iPSDataEntity.getPSDEDataSet(psWFProcSubWF.getEMBEDPSDEDSID());
            this.strCodeName = this.psWFProcSubWF.getCODENAME();
            if (!this.psWFProcSubWF.isSUSPENDDEFAULTNull()) {
                this.bSuspendDefault = this.psWFProcSubWF.getSUSPENDDEFAULT();
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
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406")
    public IPSWFProcess getPSWFProcess() {
        return this.iPSWFEmbedWFProcessBase;
    }

    public IWFModel getWFModel() {
        return this.iPSWorkflow;
    }

    public String getWFId() {
        return this.psWFProcSubWF.getEMBEDPSWFID();
    }

    public String getDEName() {
        return this.getPSDataEntity().getName();
    }

    public String getDEDSName() {
        return this.getPSDEDataSet().getName();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSWFEmbedWFProcessBase.getPSWFVersion().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6d41\u7a0b\u5b9e\u4f53", dumpref=true, fields={"EMBEDPSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6d41\u7a0b\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSDataEntity", fields={"EMBEDPSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public void init(IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase) throws Exception {
    }

    public IWFEmbedWFProcessModelBase getWFEmbedWFProcessModelBase() {
        return this.iPSWFEmbedWFProcessBase;
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
        return this.strCodeName;
    }

    public boolean isSuspendDefault() {
        return this.bSuspendDefault;
    }

    public IWFVersionModel getWFVersionModel() {
        return this.iPSWFVersion;
    }

    public String getWFVerId() {
        return this.psWFProcSubWF.getEMBEDPSWFVERID();
    }

    @Override
    public String getModelType() {
        return "PSWFPROCSUBWF";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFProcess().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFProcess().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.iPSWFEmbedWFProcessBase.getPSWFVersion().getPSWorkflow().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.iPSWFEmbedWFProcessBase.getDeployId(), (String)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6d41\u7a0b", dumpref=true, fields={"EMBEDPSWFID"})
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6d41\u7a0b\u7248\u672c", dumpref=true, from="IPSWorkflow", fields={"EMBEDPSWFVERID"})
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

