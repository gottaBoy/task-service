/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveLink;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLinkRole;
import SA.SRFDA.PS.Core.WF.PSWFLinkImpl;
import SA.SRFDA.PS.Core.WF.PSWFLinkRoleImpl;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;

@PSModelPFIgnoreMeta
public class PSWFInteractiveLinkImpl
extends PSWFLinkImpl
implements IPSWFInteractiveLink {
    protected ArrayList<IPSWFLinkRole> psWFLinkRoleList = new ArrayList();
    protected String strNextCondition = "";
    private String strPSDEFormId = "";
    private String strMobPSDEFormId = "";
    private String strFormCodeName = "";
    private String strMobFormCodeName = "";
    private String strPSDEViewId = "";
    private String strPSDEViewName = "";
    private String strMobPSDEViewId = "";
    private String strMobPSDEViewName = "";
    private String strViewCodeName = "";
    private String strMobViewCodeName = "";
    private String strPSDEFormName = "";
    private String strMobPSDEFormName = "";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getPSDEVIEWBASEID())) {
            this.strPSDEViewId = this.psWFLink.getPSDEVIEWBASEID();
            this.strViewCodeName = this.psWFLink.getVIEWCODENAME();
            this.strPSDEViewName = this.psWFLink.getPSDEVIEWBASENAME();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getMOBPSDEVIEWID())) {
            this.strMobPSDEViewId = this.psWFLink.getMOBPSDEVIEWID();
            this.strMobViewCodeName = this.psWFLink.getMOBVIEWCODENAME();
            this.strMobPSDEViewName = this.psWFLink.getMOBPSDEVIEWNAME();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getPSDEFORMID())) {
            this.strPSDEFormId = this.psWFLink.getPSDEFORMID();
            this.strFormCodeName = this.psWFLink.getFORMCODENAME();
            this.strPSDEFormName = this.psWFLink.getPSDEFORMNAME();
            if (StringHelper.isNullOrEmpty((String)this.getPSDEViewId()) && this.getFromPSWFProcess() != null && this.getFromPSWFProcess().getPSDEWF() != null) {
                this.strPSDEViewId = this.getFromPSWFProcess().getPSDEWF().getActionPSDEViewId();
                this.strViewCodeName = this.getFromPSWFProcess().getPSDEWF().getActionViewCodeName();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWFLink.getMOBPSDEFORMID())) {
            this.strMobPSDEFormId = this.psWFLink.getMOBPSDEFORMID();
            this.strMobFormCodeName = this.psWFLink.getMOBFORMCODENAME();
            this.strMobPSDEFormName = this.psWFLink.getMOBPSDEFORMNAME();
            if (StringHelper.isNullOrEmpty((String)this.getMobPSDEViewId()) && this.getFromPSWFProcess() != null && this.getFromPSWFProcess().getPSDEWF() != null) {
                this.strMobPSDEViewId = this.getFromPSWFProcess().getPSDEWF().getMobActionPSDEViewId();
                this.strMobViewCodeName = this.getFromPSWFProcess().getPSDEWF().getMobActionViewCodeName();
            }
        }
        super.onInit();
        this.strNextCondition = this.psWFLink.getNEXTCOND();
        if (StringHelper.isNullOrEmpty((String)this.strNextCondition)) {
            this.strNextCondition = "ANY";
        }
        this.preparePSWFLinkRoles();
    }

    protected void preparePSWFLinkRoles() throws Exception {
        this.psWFLinkRoleList.clear();
        ArrayList<PSWFLinkRole> psWFLinkRoleList = this.psWFLink.getPSWFLinkRoles(false);
        if (psWFLinkRoleList == null) {
            return;
        }
        for (PSWFLinkRole psWFLinkRole : psWFLinkRoleList) {
            PSWFLinkRoleImpl iPSWFVersionLinkRole = new PSWFLinkRoleImpl();
            iPSWFVersionLinkRole.init(this.getDAGlobalHelper(), this, psWFLinkRole);
            this.psWFLinkRoleList.add(iPSWFVersionLinkRole);
        }
    }

    public boolean isActorIAActionControl() {
        return false;
    }

    public boolean containsWFProcRole(IWFProcRoleModel iWFProcRoleModel) {
        return false;
    }

    public boolean containsUDActor(String strUDActorId) {
        return false;
    }

    public int getActionCount() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u6761\u4ef6")
    public String getNextCondition() {
        if (this.isEnableCustomCond()) {
            return this.getCustomCond();
        }
        return this.strNextCondition;
    }

    public Iterator<IWFRoleUser> getAddedWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (this.getAddedWFRoleModel() == null) {
            return null;
        }
        return this.getAddedWFRoleModel().getWFRoleUserModels(iWFActionContext);
    }

    @Override
    public String getPSDEFormId() {
        return this.strPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"FORMCODENAME"})
    public String getFormCodeName() {
        return this.strFormCodeName;
    }

    @Override
    public String getMobPSDEFormId() {
        return this.strMobPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBFORMCODENAME"})
    public String getMobFormCodeName() {
        return this.strMobFormCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"PSDEFORMNAME"})
    public String getFormName() {
        return this.strPSDEFormName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u8868\u5355\u540d\u79f0", fields={"MOBPSDEFORMNAME"})
    public String getMobFormName() {
        return this.strMobPSDEFormName;
    }

    @Override
    public String getPSDEViewId() {
        return this.strPSDEViewId;
    }

    @Override
    public String getMobPSDEViewId() {
        return this.strMobPSDEViewId;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u89c6\u56fe\u6807\u8bb0", fields={"VIEWCODENAME"})
    public String getViewCodeName() {
        return this.strViewCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u89c6\u56fe\u6807\u8bb0", fields={"MOBVIEWCODENAME"})
    public String getMobViewCodeName() {
        return this.strMobViewCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u89c6\u56fe\u540d\u79f0", fields={"PSDEVIEWBASENAME"})
    public String getViewName() {
        return this.strPSDEViewName;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u89c6\u56fe\u540d\u79f0", fields={"MOBVIEWCODENAME"})
    public String getMobViewName() {
        return this.strMobPSDEViewName;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u89d2\u8272\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSWFLinkRole> getPSWFLinkRoles() {
        return this.psWFLinkRoleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u6d41\u7a0b\u5904\u7406", dumpref=true, from="IPSWFVersion", from_method="getPSWFProcess", origin="IPSWFInteractiveProcess", fields={"FROMPSWFPROCID"})
    public IPSWFInteractiveProcess getFromPSWFProcess() throws Exception {
        return (IPSWFInteractiveProcess)super.getFromPSWFProcess();
    }
}

