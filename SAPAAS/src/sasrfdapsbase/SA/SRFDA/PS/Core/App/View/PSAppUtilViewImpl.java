/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppUtilView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.App.View.PSViewAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppUtilView;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.Date;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilViewImpl
extends PSAppViewImpl
implements IPSAppUtilView {
    private static final Log log = LogFactory.getLog(PSAppUtilViewImpl.class);
    protected IPSViewType iPSViewType = null;
    protected PSAppUtilView psAppUtilView = new PSAppUtilView();
    private boolean bEnableDP = false;
    protected String strPSAjaxControlId = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            CallResult callResult = this.getPSModelHelper().getPSAppUtilView(psApplicationView.getPSAPPVIEWID(), this.psAppUtilView);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex, true);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!this.psAppUtilView.isUPDATEDATENull() && (this.psApplicationView.isUPDATEDATENull() || this.psApplicationView.getUPDATEDATE().getTime() < this.psAppUtilView.getUPDATEDATE().getTime())) {
            String strLastModifyTime = DateHelper.toDateTimeString((Date)this.psAppUtilView.getUPDATEDATE());
            this.setLastModifyTimeStr(strLastModifyTime);
        }
        super.onInit();
    }

    @Override
    protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSystem().getPSAjaxControlHandlerData(strPSAjaxHandlerId, false);
        PSViewAjaxHandlerImpl iPSAjaxHandler = new PSViewAjaxHandlerImpl();
        iPSAjaxHandler.init(this.getDAGlobalHelper(), this, psACHandler);
        return iPSAjaxHandler;
    }

    protected BaseDataEntity createRealViewDataEntity() {
        return new PSAppUtilView();
    }

    protected BaseDataEntity createRealViewTemplDataEntity() {
        return new PSAppUtilView();
    }

    @Override
    protected String onGetViewType() {
        return this.iPSViewType.getId();
    }

    @Override
    public void setPSViewType(IPSViewType iPSViewType) {
        this.iPSViewType = iPSViewType;
    }

    @Override
    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return this.bEnableDP;
    }

    public String getPSAjaxControlHandlerId() {
        return this.strPSAjaxControlId;
    }

    protected void setPSAjaxControlHandlerId(String strPSAjaxControlId) {
        this.strPSAjaxControlId = strPSAjaxControlId;
    }

    @Override
    protected boolean isUserRefModeDefault() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSAPPUTILVIEW";
    }
}

