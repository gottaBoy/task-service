/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
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
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkRole;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSWFLinkRoleImpl
extends PSObjectImpl
implements IPSWFLinkRole {
    private static final Log log = LogFactory.getLog(PSWFLinkRoleImpl.class);
    protected IPSWFLink iPSWFLink;
    protected PSWFLinkRole psWFLinkRole;
    private IPSWFProcessRole iPSWFProcessRole = null;
    private IPSWFInteractiveProcess iPSWFInteractiveProcess = null;
    private IPSSysMsgTempl iPSSysMsgTempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFLink iPSWFLink, PSWFLinkRole psWFLinkRole) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFLink = iPSWFLink;
            this.psWFLinkRole = psWFLinkRole;
            this.setId(this.psWFLinkRole.getPSWFLINKROLEID());
            this.setName(this.psWFLinkRole.getPSWFLINKROLENAME());
            this.setPSObjectData(this.psWFLinkRole);
            if (!StringHelper.isNullOrEmpty((String)psWFLinkRole.getPSWFPROCROLEID())) {
                if (this.iPSWFLink.getFromPSWFProcess() instanceof IPSWFInteractiveProcess) {
                    this.iPSWFInteractiveProcess = (IPSWFInteractiveProcess)this.iPSWFLink.getFromPSWFProcess();
                }
                if (this.iPSWFInteractiveProcess != null) {
                    this.iPSWFProcessRole = this.iPSWFInteractiveProcess.getPSWFProcessRole(psWFLinkRole.getPSWFPROCROLEID());
                } else {
                    throw new Exception(String.format("\u6d41\u7a0b\u5904\u7406\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", new Object[0]));
                }
            }
            if (this.getPSWFProcessRole() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\u89d2\u8272", new Object[0]));
            }
            this.iPSSysMsgTempl = !StringHelper.isNullOrEmpty((String)this.psWFLinkRole.getPSSYSMSGTEMPLID()) ? this.iPSWFLink.getPSWFVersion().getPSWorkflow().getPSSystem().getPSSysMsgTempl(this.psWFLinkRole.getPSSYSMSGTEMPLID()) : this.iPSWFProcessRole.getPSSysMsgTempl();
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
    @PSModelRTMeta(description="\u6d41\u7a0b\u8fde\u63a5")
    public IPSWFLink getPSWFLink() {
        return this.iPSWFLink;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWFLink().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u89d2\u8272", hideempty2=true, dumpref=true, from="IPSWFInteractiveLink", from_method="getFromPSWFProcessMust().getPSWFProcessRole", fields={"PSWFPROCROLEID"})
    public IPSWFProcessRole getPSWFProcessRole() {
        return this.iPSWFProcessRole;
    }

    @Override
    public String getModelType() {
        return "PSWFLINKROLE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFLink().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFLink().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWFLink().getPSWFVersion().getPSWorkflow().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSWFLink().getDeployId(), (String)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u6d88\u606f\u6a21\u677f", hideempty=true, dumpref=true, fields={"PSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getPSSysMsgTempl() {
        return this.iPSSysMsgTempl;
    }
}

