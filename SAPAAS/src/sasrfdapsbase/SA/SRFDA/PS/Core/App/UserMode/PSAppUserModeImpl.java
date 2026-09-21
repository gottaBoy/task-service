/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.UserMode;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Security.IPSSysUserMode;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUserModeImpl
extends PSApplicationObjectImpl
implements IPSAppUserMode {
    private static final Log log = LogFactory.getLog(PSAppUserModeImpl.class);
    protected PSAppUserMode psAppUserMode = null;
    private IPSAppMenuModel iPSAppMenuModel = null;
    private IPSSysUserMode iPSSysUserMode = null;
    private boolean bDefaultMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppUserMode psAppUserMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppUserMode = psAppUserMode;
            this.setId(this.psAppUserMode.getPSAPPUSERMODEID());
            this.setName(this.psAppUserMode.getPSAPPUSERMODENAME());
            this.setPSObjectData(psAppUserMode);
            if (!StringHelper.IsNullOrEmpty((String)this.psAppUserMode.getPSSYSUSERMODEID())) {
                this.iPSSysUserMode = this.getPSSystem().getPSSysUserMode(this.psAppUserMode.getPSSYSUSERMODEID());
            }
            if (!this.psAppUserMode.isDEFAULTFLAGNull()) {
                this.bDefaultMode = this.psAppUserMode.getDEFAULTFLAG();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppUserMode.getPSAPPMENUID())) {
                this.iPSAppMenuModel = this.getPSApplication().getPSAppMenuModel(this.psAppUserMode.getPSAPPMENUID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7528\u6237\u6a21\u5f0f", group="\u57fa\u672c", order=110)
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u83dc\u5355\u6a21\u578b", group="\u57fa\u672c", order=114)
    public IPSAppMenuModel getPSAppMenuModel() {
        return this.iPSAppMenuModel;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7528\u6237\u6a21\u5f0f", group="\u57fa\u672c", order=112)
    public IPSSysUserMode getPSSysUserMode() {
        return this.iPSSysUserMode;
    }

    @Override
    public String getModelType() {
        return "PSAPPUSERMODE";
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }
}

