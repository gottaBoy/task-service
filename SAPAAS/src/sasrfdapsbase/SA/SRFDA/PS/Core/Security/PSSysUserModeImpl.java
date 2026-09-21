/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Security.IPSSysUserMode;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUserMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserModeImpl
extends PSSystemObjectImpl
implements IPSSysUserMode {
    private static final Log log = LogFactory.getLog(PSSysUserModeImpl.class);
    protected PSSysUserMode psSysUserMode = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUserMode psSysUserMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUserMode = psSysUserMode;
            this.setId(this.psSysUserMode.getPSSYSUSERMODEID());
            this.setName(this.psSysUserMode.getPSSYSUSERMODENAME());
            this.setPSObjectData(this.psSysUserMode);
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserMode.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUserMode.getPSMODULEID());
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
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSysUserMode.getLOGICNAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSUSERMODE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psSysUserMode.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6a21\u5f0f\u7f16\u53f7", fields={"USERMODESN"})
    public String getUserModeSN() {
        return this.psSysUserMode.getUSERMODESN();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6a21\u5f0f\u6807\u8bb0", fields={"PSSYSUSERMODENAME"})
    public String getUserModeTag() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }
}

