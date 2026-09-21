/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkGroupCond;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.PSWFLinkGroupCondImpl;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFLinkImpl
extends PSObjectImpl
implements IPSWFLink {
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
    private IPSWFProcess fromPSWFProcess = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFVersion iPSWFVersion, IPSWFProcess fromPSWFProcess, PSWFLink psWFLink) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFVersion = iPSWFVersion;
            this.fromPSWFProcess = fromPSWFProcess;
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
        groupPSWFLinkCond.setPSWFLINKCONDNAME(StringHelper.format((String)"\u8fde\u63a5\u6761\u4ef6"));
        for (PSWFLinkCond psWFLinkCond : psWFLinkCondList) {
            groupPSWFLinkCond.getChildPSWFLinkConds(true).add(psWFLinkCond);
        }
        this.psWFLinkGroupCondImpl = new PSWFLinkGroupCondImpl();
        this.psWFLinkGroupCondImpl.init(this.getDAGlobalHelper(), this, null, groupPSWFLinkCond);
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6761\u4ef6", child=true, outputdoc="false")
    public IPSWFLinkGroupCond getPSWFLinkGroupCond() {
        if (this.psWFLinkGroupCondImpl == null || this.psWFLinkGroupCondImpl.getPSWFLinkConds() == null) {
            return null;
        }
        return this.psWFLinkGroupCondImpl;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6d41\u7a0b\u5904\u7406", dumpref=true, from="IPSWFVersion", fields={"TOPSWFPROCID"})
    public IPSWFProcess getToPSWFProcess() throws Exception {
        return this.iPSWFVersion.getPSWFProcess(this.psWFLink.getTOPSWFPROCID(), false);
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u6d41\u7a0b\u5904\u7406", dumpref=true, from="IPSWFVersion", fields={"FROMPSWFPROCID"})
    public IPSWFProcess getFromPSWFProcess() throws Exception {
        if (this.fromPSWFProcess == null && this.getPSWFVersion() != null) {
            this.fromPSWFProcess = this.getPSWFVersion().getPSWFProcess(this.psWFLink.getFROMPSWFPROCID(), false);
        }
        return this.fromPSWFProcess;
    }

    @Override
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u8fde\u63a5\u5904\u7406", codelist="WFLinkType", fields={"WFLINKTYPE"})
    public String getWFLinkType() {
        return this.psWFLink.getWFLINKTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
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
        return this.iPSWFVersion.getPSSysModelInstId();
    }

    public String getSrcEndPoint() {
        return this.psWFLink.getSRCENDPOINT();
    }

    public String getDstEndPoint() {
        return this.psWFLink.getDSTENDPOINT();
    }

    @Override
    public String getMemoField() {
        return this.psWFLink.getMEMOFIELD();
    }

    @PSModelRTMeta(description="\u8fde\u63a5\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psWFLink.getUSERDATA();
    }

    @PSModelRTMeta(description="\u8fde\u63a5\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
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

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", fields={"LNPSLANRESID"})
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

    @Override
    public String getModelType() {
        return "PSWFLINK";
    }

    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u6761\u4ef6", doc="\u542f\u7528\u81ea\u5b9a\u4e49\u6761\u4ef6\u65f6{@link #isEnableCustomCond}\u8fd4\u56de\u81ea\u5b9a\u4e49\u6761\u4ef6{@link #getCustomCond}")
    public String getNextCondition() {
        if (this.isEnableCustomCond()) {
            return this.getCustomCond();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u81ea\u5b9a\u4e49\u6761\u4ef6", ignoredumpvalues="false", fields={"CUSTOMCONDFLAG"})
    public boolean isEnableCustomCond() {
        return this.bEnableCustomCond;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.strCustomCond;
    }

    @Override
    public String getModelName() {
        try {
            if (StringHelper.isNullOrEmpty((String)this.getLogicName())) {
                return StringHelper.format((String)"%1$s(%2$s)", (Object)this.getFromPSWFProcess().getModelName(), (Object)this.getName());
            }
            return StringHelper.format((String)"%1$s(%2$s)#%3$s", (Object)this.getFromPSWFProcess().getModelName(), (Object)this.getName(), (Object)this.getLogicName());
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
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
        return KeyValueHelper.genUniqueId((String)this.getPSWFVersion().getDeployId(), (String)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        try {
            return this.getFromPSWFProcess();
        }
        catch (Exception e) {
            log.error((Object)e.getMessage());
            return this.getPSWFVersion();
        }
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSWFVersion();
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }
}

