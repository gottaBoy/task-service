/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppUtilPage;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilPageImpl
extends PSApplicationObjectImpl
implements IPSAppUtilPage {
    protected PSAppUtilPage psAppUtilPage = null;
    private static final Log log = LogFactory.getLog(PSAppUtilPageImpl.class);
    private String strTargetType = "PAGEURL";
    private String strPageUrl = null;
    private String strUtilType = null;
    private Properties utilParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppUtilPage psAppUtilPage) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppUtilPage = psAppUtilPage;
            this.setId(this.psAppUtilPage.getPSAPPUTILPAGEID());
            this.setName(this.psAppUtilPage.getPSAPPUTILPAGENAME());
            this.setPSObjectData(this.psAppUtilPage);
            this.strUtilType = this.psAppUtilPage.getUTILTYPE();
            if (StringHelper.isNullOrEmpty((String)this.strUtilType)) {
                this.strUtilType = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppUtilPage.getUTILPARAMS())) {
                this.utilParams = PropertiesHelper.load((String)this.psAppUtilPage.getUTILPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppUtilPage.getTARGETTYPE())) {
                this.strTargetType = this.psAppUtilPage.getTARGETTYPE();
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psAppUtilPage.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="AppUtilPage", fields={"UTILTYPE"})
    public String getUtilType() {
        return this.strUtilType;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u529f\u80fd\u53c2\u6570\u96c6\u5408", hideempty=true, fields={"UTILPARAMS"})
    public Properties getUtilParams() {
        return this.utilParams;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6807\u8bb0", hideempty=true, fields={"UTILTAG"})
    public String getUtilTag() {
        if (StringHelper.isNullOrEmpty((String)this.psAppUtilPage.getUTILTAG())) {
            return null;
        }
        return this.psAppUtilPage.getUTILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9875\u9762\u8def\u5f84")
    public String getPageUrl() {
        if (this.strPageUrl != null) {
            return this.strPageUrl;
        }
        try {
            this.strPageUrl = this.getPSAppView() != null ? this.getPSAppView().getPageUrl() : this.psAppUtilPage.getPAGEURL();
            return this.strPageUrl;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u5e94\u7528\u529f\u80fd\u9875\u9762\u8def\u5f84\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return "";
        }
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u7c7b\u578b", codelist="AppUtilPageTarget")
    public String getTargetType() {
        return this.strTargetType;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u89c6\u56fe", hideempty=true, dumpref=true)
    public IPSAppView getPSAppView() throws Exception {
        if (StringHelper.compare((String)this.getTargetType(), (String)"APPVIEW", (boolean)false) != 0) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.psAppUtilPage.getPSAPPVIEWID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5e94\u7528\u89c6\u56fe");
        }
        return this.getPSApplication().getPSAppView(this.psAppUtilPage.getPSAPPVIEWID(), false);
    }

    @Override
    public String getModelType() {
        return "PSAPPUTILPAGE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }
}

