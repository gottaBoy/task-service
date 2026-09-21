/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFLinkGroupCond
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFLinkGroupCond;
import net.ibizsys.model.wf.IPSWFLinkRuntime;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.PSWFLinkGroupCondImpl;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class PSWFLinkImpl
extends PSObjectImpl
implements IPSWFLinkRuntime {
    private static final Log log = LogFactory.getLog(PSWFLinkImpl.class);
    protected IPSWFVersion iPSWFVersion;
    protected PSWFLink psWFLink;
    protected ArrayList<IPSWFLink> psWFLinkConds = new ArrayList();
    protected PSWFLinkGroupCondImpl psWFLinkGroupCondImpl = null;
    private String strActionField = null;
    private IPSCodeList actionPSCodeList = null;
    private String strActorFields = null;
    private String[] actorFields = null;
    private String strPSWFRoleId = null;
    private IWFRoleModel iWFRoleModel = null;
    private IPSLanguageRes lnPSLanguageRes = null;
    private int nThreadLinkMode = 1;
    private String strThreadShowName = null;
    private String strModelId = null;
    private boolean bEnableCustomCond = false;
    private String strCustomCond = null;

    PSWFLinkImpl() {
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFVersion iPSWFVersion, PSWFLink psWFLink) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSWFVersion = iPSWFVersion;
            this.psWFLink = psWFLink;
            this.setId(this.psWFLink.getPSWFLINKID());
            this.setName(this.psWFLink.getPSWFLINKNAME());
            this.setPSObjectData(this.psWFLink);
            if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getACTIONFIELD())) {
                this.strActionField = psWFLink.getACTIONFIELD();
                if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getACTIONPSCODELISTID())) {
                    this.actionPSCodeList = this.iPSWFVersion.getPSWorkflow().getPSSystem().getPSCodeList(this.psWFLink.getACTIONPSCODELISTID());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getACTORFIELDS())) {
                this.strActorFields = this.psWFLink.getACTORFIELDS();
                this.actorFields = StringHelper.splitEx((String)this.strActorFields);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getPSWFROLEID())) {
                this.strPSWFRoleId = this.psWFLink.getPSWFROLEID();
                this.iWFRoleModel = this.iPSWFVersion.getPSWorkflow().getPSSystem().getPSWFRole(this.strPSWFRoleId);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getLNPSLANRESID())) {
                this.lnPSLanguageRes = this.getPSWFVersion().getPSWorkflow().getPSSystem().getPSLanguageRes(this.psWFLink.getLNPSLANRESID());
            }
            if (!this.psWFLink.isTHREADFLAGNull()) {
                this.nThreadLinkMode = this.psWFLink.getTHREADFLAG();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getTHREADNAME())) {
                this.strThreadShowName = this.psWFLink.getTHREADNAME();
            }
            this.strModelId = this.psWFLink.getMODELID();
            if (!this.psWFLink.isCUSTOMCONDFLAGNull()) {
                this.bEnableCustomCond = this.psWFLink.getCUSTOMCONDFLAG();
                if (this.bEnableCustomCond) {
                    this.strCustomCond = this.psWFLink.getCUSTOMCOND();
                }
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
        super.onInit();
        this.preparePSWFLinkConds();
    }

    protected void preparePSWFLinkConds() throws Exception {
        this.psWFLinkGroupCondImpl = null;
        ArrayList<PSWFLinkCond> psWFLinkCondList = this.psWFLink.getPSWFLinkConds(false);
        if (psWFLinkCondList == null) {
            return;
        }
        PSWFLinkCond groupPSWFLinkCond = new PSWFLinkCond();
        groupPSWFLinkCond.setLOGICTYPE("GROUP");
        groupPSWFLinkCond.setGROUPNOTFLAG(false);
        groupPSWFLinkCond.setGROUPOP("AND");
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            groupPSWFLinkCond.getChildPSWFLinkConds(true).add(psWFLinkCond);
        }
        this.psWFLinkGroupCondImpl = new PSWFLinkGroupCondImpl();
        this.psWFLinkGroupCondImpl.init(this.getPSModelStorageContext(), this, null, groupPSWFLinkCond);
    }

    @PSModelRTMeta(description="\u8fde\u63a5\u6761\u4ef6")
    public IPSWFLinkGroupCond getPSWFLinkGroupCond() {
        if (this.psWFLinkGroupCondImpl == null || this.psWFLinkGroupCondImpl.getPSWFLinkConds() == null) {
            return null;
        }
        return this.psWFLinkGroupCondImpl;
    }

    @PSModelRTMeta(description="\u76ee\u6807\u6d41\u7a0b\u5904\u7406")
    public IPSWFProcess getToPSWFProcess() throws Exception {
        return this.iPSWFVersion.getPSWFProcess(this.psWFLink.getTOPSWFPROCID(), false);
    }

    @PSModelRTMeta(description="\u6e90\u6d41\u7a0b\u5904\u7406")
    public IPSWFProcess getFromPSWFProcess() throws Exception {
        return this.iPSWFVersion.getPSWFProcess(this.psWFLink.getFROMPSWFPROCID(), false);
    }

    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @PSModelRTMeta(description="\u5904\u7406\u8fde\u63a5\u5904\u7406", codelist="WFLinkType")
    public String getWFLinkType() {
        return this.psWFLink.getWFLINKTYPE();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psWFLink.getLOGICNAME();
    }

    public void init(IWFVersionModel iWFVersionModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IWFVersionModel getWFVersionModel() {
        return this.getPSWFVersion();
    }

    public String getNext() {
        return this.psWFLink.getTOPSWFPROCID();
    }

    public String getFrom() {
        return this.psWFLink.getFROMPSWFPROCID();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSWFVersion);
    }

    public String getSrcEndPoint() {
        return this.psWFLink.getSRCENDPOINT();
    }

    public String getDstEndPoint() {
        return this.psWFLink.getDSTENDPOINT();
    }

    public String getMemoField() {
        return this.psWFLink.getMEMOFIELD();
    }

    public String getUserData() {
        return this.psWFLink.getUSERDATA();
    }

    public String getUserData2() {
        return this.psWFLink.getUSERDATA2();
    }

    public String getActionField() {
        return this.strActionField;
    }

    public ICodeList getActionCodeList() {
        return this.actionPSCodeList;
    }

    public String getActorField() {
        return this.strActorFields;
    }

    public String[] getActorFields() {
        return this.actorFields;
    }

    public String getAddedWFRoleId() {
        return this.strPSWFRoleId;
    }

    public IWFRoleModel getAddedWFRoleModel() {
        return this.iWFRoleModel;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    public String getThreadShowName() {
        return this.strThreadShowName;
    }

    public int getThreadLinkMode() {
        return this.nThreadLinkMode;
    }

    public String getLNLanResTag() {
        if (this.getLNPSLanguageRes() != null) {
            return this.getLNPSLanguageRes().getLanResTag();
        }
        return null;
    }

    public String getBPMNModelId() {
        return this.strModelId;
    }

    public String getNextCondition() {
        if (this.isEnableCustomCond()) {
            return this.getCustomCond();
        }
        return "";
    }

    public boolean isEnableCustomCond() {
        return this.bEnableCustomCond;
    }

    public String getCustomCond() {
        return this.strCustomCond;
    }
}

