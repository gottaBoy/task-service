/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.wf.IPSWFEmbedWFProcessBase
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.wf.IPSWFEmbedWFProcessBase;
import net.ibizsys.model.wf.IPSWFProcessSubWFRuntime;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFProcessSubWFImpl
extends PSObjectImpl
implements IPSWFProcessSubWFRuntime {
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
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFEmbedWFProcessBase iPSWFEmbedWFProcessBase, PSWFProcSubWF psWFProcSubWF) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psWFProcSubWF = psWFProcSubWF;
            this.setId(psWFProcSubWF.getPSWFPROCSUBWFID());
            this.setName(psWFProcSubWF.getPSWFPROCSUBWFNAME());
            this.setPSObjectData(this.psWFProcSubWF);
            this.iPSWFEmbedWFProcessBase = iPSWFEmbedWFProcessBase;
            if (!StringHelper.isNullOrEmpty((String)this.psWFProcSubWF.getEMBEDPSWFID())) {
                this.iPSWorkflow = iPSWFEmbedWFProcessBase.getPSWFVersion().getPSWorkflow().getPSSystem().getPSWorkflow(this.psWFProcSubWF.getEMBEDPSWFID());
                if (!StringHelper.isNullOrEmpty((String)this.psWFProcSubWF.getEMBEDPSWFVERID())) {
                    this.iPSWFVersion = this.iPSWorkflow.getPSWFVersion(this.psWFProcSubWF.getEMBEDPSWFVERID());
                }
            }
            this.iPSDataEntity = this.iPSWorkflow.getPSSystem().getPSDataEntity(this.psWFProcSubWF.getEMBEDPSDEID());
            this.iPSDEDataSet = this.iPSDataEntity.getPSDEDataSet(psWFProcSubWF.getEMBEDPSDEDSID());
            this.strCodeName = this.psWFProcSubWF.getCODENAME();
            if (!this.psWFProcSubWF.isSUSPENDDEFAULTNull()) {
                this.bSuspendDefault = this.psWFProcSubWF.getSUSPENDDEFAULT();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
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
        return this.getPSSysModelInstId((IPSModelObject)this.iPSWFEmbedWFProcessBase.getPSWFVersion());
    }

    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public void init(IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase) throws Exception {
    }

    public IWFEmbedWFProcessModelBase getWFEmbedWFProcessModelBase() {
        return this.iPSWFEmbedWFProcessBase;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
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
}

