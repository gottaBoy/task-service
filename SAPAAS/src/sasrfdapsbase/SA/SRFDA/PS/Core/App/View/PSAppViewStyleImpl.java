/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppViewStyle;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppViewStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewStyleImpl
extends PSApplicationObjectImpl
implements IPSAppViewStyle {
    private static final Log log = LogFactory.getLog(PSAppViewStyleImpl.class);
    protected PSAppViewStyle psAppViewStyle = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppViewStyle psAppViewStyle) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppViewStyle = psAppViewStyle;
            this.setId(this.psAppViewStyle.getPSAPPVIEWSTYLEID());
            this.setName(this.psAppViewStyle.getPSAPPVIEWSTYLENAME());
            this.setPSObjectData(this.psAppViewStyle);
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
    public String getModelType() {
        return "PSAPPVIEWSTYLE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }
}

