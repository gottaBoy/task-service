/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wf.IPSDEWFRuntime;
import net.ibizsys.model.entity.PSWFDE;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEWFImpl
extends PSDataEntityObjectImpl
implements IPSDEWFRuntime {
    private static final Log log = LogFactory.getLog(PSDEWFImpl.class);
    protected PSWFDE psWFDE = null;
    private boolean bValidFlag = true;
    private IPSWorkflow iPSWorkflow = null;
    private String strCodeName = "";
    private IPSDEField wfStepPSDEField = null;
    private IPSDEField wfStatePSDEField = null;
    private IPSDEField udStatePSDEField = null;
    private IPSDEField wfInstPSDEField = null;
    private IPSDEField wfActorsPSDEField = null;
    private IPSDEField wfRetPSDEField = null;
    private boolean bEnableUserStart = true;
    private IPSDEAction initPSDEAction = null;
    private IPSDEAction finishPSDEAction = null;
    private boolean bDefaultMode = true;
    private IPSDEField wfVerPSDEField = null;
    private IPSDEField workflowPSDEField = null;
    private String strWFMode = "";
    private String strWFStartName = "";
    private String strMyWFWorkCaption = "";
    private String strMyWFDataCaption = "";
    private IPSLanguageRes myWFWorkCapPSLanguageRes = null;
    private IPSLanguageRes myWFDataCapPSLanguageRes = null;
    private int nWFProxyMode = 0;
    private IPSDEField proxyModulePSDEField = null;
    private IPSDEField proxyDataPSDEField = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSWFDE psWFDE) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(iPSDataEntity);
            this.psWFDE = psWFDE;
            this.setId(this.psWFDE.getPSWFDEID());
            this.setName(this.psWFDE.getPSWFDENAME());
            this.setPSObjectData(this.psWFDE);
            if (!psWFDE.isVALIDFLAGNull()) {
                this.bValidFlag = psWFDE.getVALIDFLAG();
            }
            this.strCodeName = psWFDE.getCODENAME();
            if (!this.psWFDE.isUSERSTARTNull()) {
                this.bEnableUserStart = this.psWFDE.getUSERSTART();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getINITPSDEACTIONID())) {
                this.initPSDEAction = this.getPSDataEntity().getPSDEAction(this.psWFDE.getINITPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getFINISHPSDEACTIONID())) {
                this.finishPSDEAction = this.getPSDataEntity().getPSDEAction(this.psWFDE.getFINISHPSDEACTIONID());
            }
            if (!this.psWFDE.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psWFDE.getDEFAULTMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFMODE())) {
                this.strWFMode = this.psWFDE.getWFMODE();
            }
            this.strMyWFDataCaption = this.psWFDE.getMYWFDATA();
            this.strMyWFWorkCaption = this.psWFDE.getMYWFWORK();
            if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getMYWFWORKPSLANRESID())) {
                this.myWFWorkCapPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psWFDE.getMYWFWORKPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getMYWFDATAPSLANRESID())) {
                this.myWFDataCapPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psWFDE.getMYWFDATAPSLANRESID());
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

    @Override
    protected void onInit() throws Exception {
        this.iPSWorkflow = this.getPSDataEntity().getPSSystem().getPSWorkflow(this.psWFDE.getPSWFID());
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFSTEPPSDEFID())) {
            this.wfStepPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFSTEPPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFSTATEPSDEFID())) {
            this.wfStatePSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFSTATEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getSTATEPSDEFID())) {
            this.udStatePSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getSTATEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFINSTPSDEFID())) {
            this.wfInstPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFINSTPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFACTORPSDEFID())) {
            this.wfActorsPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFACTORPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFRETPSDEFID())) {
            this.wfRetPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFRETPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFVERPSDEFID())) {
            this.wfVerPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFVERPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getWFIDPSDEFID())) {
            this.workflowPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFIDPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getPROXYMODULEPSDEFID())) {
            this.proxyModulePSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getPROXYMODULEPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFDE.getPROXYDATAPSDEFID())) {
            this.proxyDataPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getPROXYDATAPSDEFID());
        }
        super.onInit();
    }

    public boolean isValid() {
        return this.bValidFlag;
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61")
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u5c5e\u6027")
    public IPSDEField getWFStepPSDEField() {
        return this.wfStepPSDEField;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u5c5e\u6027")
    public IPSDEField getWFStatePSDEField() {
        return this.wfStatePSDEField;
    }

    @PSModelRTMeta(description="\u7528\u6237\u72b6\u6001\u5c5e\u6027")
    public IPSDEField getUDStatePSDEField() {
        return this.udStatePSDEField;
    }

    public String getWorkflowId() {
        return this.psWFDE.getPSWFID();
    }

    public String getWFStepField() {
        return this.psWFDE.getWFSTEPPSDEFNAME();
    }

    public String getWFStateField() {
        return this.psWFDE.getWFSTATEPSDEFNAME();
    }

    public String getUDStateField() {
        return this.psWFDE.getSTATEPSDEFNAME();
    }

    public String getWFInstField() {
        if (this.getWFInstPSDEField() != null) {
            return this.getWFInstPSDEField().getName();
        }
        return "";
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u503c")
    public String getEntityWFState() {
        return this.getPSWorkflow().getEntityWFState();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5b9e\u4f8b\u5c5e\u6027")
    public IPSDEField getWFInstPSDEField() {
        return this.wfInstPSDEField;
    }

    public String getWFActorsField() {
        if (this.getWFActorsPSDEField() == null) {
            return "";
        }
        return this.getWFActorsPSDEField().getName();
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u64cd\u4f5c\u8005\u5c5e\u6027")
    public IPSDEField getWFActorsPSDEField() {
        return this.wfActorsPSDEField;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868")
    public IPSCodeList getWFStepPSCodeList() throws Exception {
        if (this.getWFStepPSDEField() != null && this.getWFStepPSDEField().getPSCodeList() != null) {
            return this.getWFStepPSDEField().getPSCodeList();
        }
        return this.getPSWorkflow().getWFStepPSCodeList();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u72b6\u6001\u4ee3\u7801\u8868")
    public IPSCodeList getEntityStatePSCodeList() throws Exception {
        if (this.getUDStatePSDEField() != null && this.getUDStatePSDEField().getPSCodeList() != null) {
            return this.getUDStatePSDEField().getPSCodeList();
        }
        return this.getPSWorkflow().getEntityStatePSCodeList();
    }

    @PSModelRTMeta(description="\u652f\u6301\u7528\u6237\u542f\u52a8")
    public boolean isEnableUserStart() {
        return this.bEnableUserStart;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u521d\u59cb\u5316\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getInitPSDEAction() {
        return this.initPSDEAction;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u5b8c\u6210\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getFinishPSDEAction() {
        return this.finishPSDEAction;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6d41\u7a0b\u5b9e\u4f53")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @PSModelRTMeta(description="\u5d4c\u5165\u6d41\u7a0b\u8fd4\u56de\u503c\u5b58\u653e\u5c5e\u6027")
    public IPSDEField getWFRetPSDEField() {
        return this.wfRetPSDEField;
    }

    public String getWFRetField() {
        if (this.getWFRetPSDEField() != null) {
            return this.getWFRetPSDEField().getName();
        }
        return "";
    }

    public boolean testDataInWF(IEntity iEntity) throws Exception {
        String strValue = DataObject.getStringValue((IDataObject)iEntity, (String)this.getUDStateField(), null);
        return StringHelper.compare((String)strValue, (String)this.getEntityWFState(), (boolean)false) == 0;
    }

    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @PSModelRTMeta(description="\u5f00\u59cb\u6d41\u7a0b\u540d\u79f0")
    public String getWFStartName() {
        return this.strWFStartName;
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u7248\u672c\u5b58\u653e\u5c5e\u6027")
    public IPSDEField getWFVerPSDEField() {
        return this.wfVerPSDEField;
    }

    public String getWFVerField() {
        if (this.getWFVerPSDEField() != null) {
            return this.getWFVerPSDEField().getName();
        }
        return "";
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5b58\u653e\u5c5e\u6027")
    public IPSDEField getWorkflowPSDEField() {
        return this.workflowPSDEField;
    }

    public String getWorkflowField() {
        if (this.getWorkflowPSDEField() != null) {
            return this.getWorkflowPSDEField().getName();
        }
        return "";
    }

    @PSModelRTMeta(description="\u6d41\u7a0b\u6a21\u5f0f")
    public String getWFMode() {
        return this.strWFMode;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @PSModelRTMeta(description="\u6211\u7684\u5de5\u4f5c\u6807\u9898")
    public String getMyWFWorkCaption() {
        return this.strMyWFWorkCaption;
    }

    @PSModelRTMeta(description="\u6211\u7684\u5de5\u4f5c\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getMyWFWorkCapPSLanguageRes() {
        return this.myWFWorkCapPSLanguageRes;
    }

    @PSModelRTMeta(description="\u6211\u7684\u6570\u636e\u6807\u9898")
    public String getMyWFDataCaption() {
        return this.strMyWFDataCaption;
    }

    @PSModelRTMeta(description="\u6211\u7684\u6570\u636e\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getMyWFDataCapPSLanguageRes() {
        return this.myWFDataCapPSLanguageRes;
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u4ee3\u7406\u6a21\u5f0f", codelist="WFProxyMode")
    public int getWFProxyMode() {
        return this.nWFProxyMode;
    }

    @PSModelRTMeta(description="\u4ee3\u7406\u6a21\u5757\u5b58\u50a8\u5c5e\u6027", hideempty=true)
    public IPSDEField getProxyModulePSDEField() {
        return this.proxyModulePSDEField;
    }

    @PSModelRTMeta(description="\u4ee3\u7406\u6570\u636e\u5b58\u50a8\u5c5e\u6027", hideempty=true)
    public IPSDEField getProxyDataPSDEField() {
        return this.proxyDataPSDEField;
    }
}

