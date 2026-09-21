/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Data.PSAppPDTView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPDTViewImpl
extends PSApplicationObjectImpl
implements IPSAppPDTView {
    private static final Log log = LogFactory.getLog(PSAppPDTViewImpl.class);
    protected PSAppPDTView psAppPDTView = null;
    private IPSSysPDTView iPSSysPDTView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppPDTView psAppPDTView) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppPDTView = psAppPDTView;
            this.setId(this.psAppPDTView.getPSAPPPDTVIEWID());
            this.setName(this.psAppPDTView.getPSAPPPDTVIEWNAME());
            this.setPSObjectData(this.psAppPDTView);
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
        if (StringHelper.isNullOrEmpty((String)this.getPSAppViewId())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5e94\u7528\u89c6\u56fe");
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAppPDTView.getPSSYSPDTVIEWID())) {
            this.iPSSysPDTView = this.getPSSystem().getPSSysPDTView(this.psAppPDTView.getPSSYSPDTVIEWID());
        }
        if (this.getPSSysPDTView() == null) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u9884\u5b9a\u4e49\u89c6\u56fe", new Object[0]));
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u89c6\u56fe", hideempty=true, dumpref=true, ignorepf=true, dynamodelmode=8, from="IPSApplication", group="\u57fa\u672c", order=225, fields={"PSAPPVIEWID"})
    public IPSAppView getPSAppView() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSAppViewId())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5e94\u7528\u89c6\u56fe");
        }
        return (IPSAppView)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSAppView>(){

            public IPSAppView execute(Object obj) throws Exception {
                return PSAppPDTViewImpl.this.getPSApplication().getPSAppView(PSAppPDTViewImpl.this.getPSAppViewId(), false);
            }
        }, (IPSModelObject)this);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe", hideempty=true, dumpref=true, ignorepf=true, dynamodelmode=8, from="IPSSystem", group="\u57fa\u672c", order=220, fields={"PSSYSPDTVIEWID"})
    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }

    @Override
    public String getPSAppViewId() {
        return this.psAppPDTView.getPSAPPVIEWID();
    }

    @Override
    public String getModelType() {
        return "PSAPPPDTVIEW";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }
}

