/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSWFProcessRoleImpl
extends PSObjectImpl
implements IPSWFProcessRole {
    private static final Log log = LogFactory.getLog(PSWFProcessRoleImpl.class);
    protected IPSWFProcess iPSWFProcess;
    protected PSWFProcRole psWFProcRole;
    protected String strProcRoleType = "";
    protected String strPSWFRoleId = "";
    protected String strUDField = "";
    private IPSWFRole iPSWFRole = null;
    private IPSSysMsgTempl iPSSysMsgTempl = null;
    private boolean bCCMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFProcess iPSWFProcess, PSWFProcRole psWFProcRole) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFProcess = iPSWFProcess;
            this.psWFProcRole = psWFProcRole;
            this.setId(this.psWFProcRole.getPSWFPROCROLEID());
            this.setName(this.psWFProcRole.getPSWFPROCROLENAME());
            this.setPSObjectData(this.psWFProcRole);
            this.strProcRoleType = this.psWFProcRole.getROLETYPE();
            this.strPSWFRoleId = this.psWFProcRole.getPSWFROLEID();
            this.strUDField = this.psWFProcRole.getUDFIELDS();
            if (!this.psWFProcRole.isCCMODENull()) {
                this.bCCMode = this.psWFProcRole.getCCMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.getWFRoleId())) {
                this.iPSWFRole = this.getPSWFProcess().getPSWFVersion().getPSWorkflow().getPSSystem().getPSWFRole(this.getWFRoleId());
                this.registerToPSModelObject(this.iPSWFRole);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psWFProcRole.getPSSYSMSGTEMPLID())) {
                this.iPSSysMsgTempl = this.getPSWFProcess().getPSWFVersion().getPSWorkflow().getPSSystem().getPSSysMsgTempl(this.psWFProcRole.getPSSYSMSGTEMPLID());
                this.registerToPSModelObject(this.iPSSysMsgTempl);
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
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u89d2\u8272\u7c7b\u578b", codelist="WFProcRoleType", fields={"ROLETYPE"})
    public String getWFProcessRoleType() {
        return this.strProcRoleType;
    }

    public void init(IWFInteractiveProcessModel iWFInteractiveProcessModel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406")
    public IPSWFProcess getPSWFProcess() {
        return this.iPSWFProcess;
    }

    public String getWFProcRoleType() {
        return this.getWFProcessRoleType();
    }

    public String getWFRoleId() {
        return this.strPSWFRoleId;
    }

    public IWFRoleModel getWFRoleModel() {
        return null;
    }

    public IWFInteractiveProcessModel getWFInteractiveProcessModel() {
        return (IWFInteractiveProcessModel)this.iPSWFProcess;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSWFProcess.getPSSysModelInstId();
    }

    public String[] getUDFields() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"UDFIELDS"})
    public String getUDField() {
        return this.strUDField;
    }

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u89d2\u8272\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"PSWFROLEID"})
    public IPSWFRole getPSWFRole() {
        return this.iPSWFRole;
    }

    @Override
    public String getModelType() {
        return "PSWFPROCROLE";
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
        return (IPSSystemUtil)((Object)this.getPSWFProcess().getPSWFVersion().getPSWorkflow().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSWFProcess().getDeployId(), (String)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u89d2\u8272\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psWFProcRole.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u89d2\u8272\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
    public String getUserData2() {
        return this.psWFProcRole.getUSERDATA2();
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u6d88\u606f\u6a21\u677f", hideempty=true, dumpref=true, fields={"PSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getPSSysMsgTempl() {
        if (this.getOriginPSSysMsgTempl() == null) {
            return this.getPSWFProcess().getPSSysMsgTempl();
        }
        return this.getOriginPSSysMsgTempl();
    }

    @Override
    @PSModelRTMeta(description="\u539f\u59cb\u901a\u77e5\u6d88\u606f\u6a21\u677f", hideempty=true)
    public IPSSysMsgTempl getOriginPSSysMsgTempl() {
        return this.iPSSysMsgTempl;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6284\u9001\u6a21\u5f0f", ignoredumpvalues="false", fields={"CCMODE"})
    public boolean isCCMode() {
        return this.bCCMode;
    }
}

