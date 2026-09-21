/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDynaDEView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.App.View.PSViewAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.Date;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppDynaDEViewImpl
extends PSAppViewImpl
implements IPSAppDynaDEView {
    private static final Log log = LogFactory.getLog(PSAppDynaDEViewImpl.class);
    protected String strPSDynaDEViewTemplId = "";
    protected String strPSDynaDEViewTemplName = "";
    protected IPSViewType iPSViewType = null;
    protected PSDynaDEViewTempl psDynaDEViewTempl = new PSDynaDEViewTempl();
    private IPSDynaDETempl iPSDynaDETempl = null;
    private boolean bEnableDP = true;
    protected String strPSAjaxControlId = "";
    private int nAccUserMode = AccessUserModes.LOGINUSER;
    private IPSSysUniRes iPSSysUniRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.setPSDynaDEViewTemplId(psApplicationView.getPSDYNADEVIEWTEMPLID());
            this.setPSDynaDEViewTemplName(psApplicationView.getPSDYNADEVIEWTEMPLNAME());
            CallResult callResult = this.getPSModelHelper().getPSDynaDEViewTempl(this.getPSDynaDEViewTemplId(), this.psDynaDEViewTempl);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDynaDEViewTempl.getPSDYNADETEMPLID())) {
                this.iPSDynaDETempl = iPSApplication.getPSSystem().getPSDynaDETempl(this.psDynaDEViewTempl.getPSDYNADETEMPLID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDynaDEViewTempl.getACCUSERMODE())) {
                this.nAccUserMode = Integer.parseInt(this.psDynaDEViewTempl.getACCUSERMODE());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDynaDEViewTempl.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSApplication().getPSSystem().getPSSysUniRes(this.psDynaDEViewTempl.getPSSYSUNIRESID());
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
        if (!this.psDynaDEViewTempl.isUPDATEDATENull() && (this.psApplicationView.isUPDATEDATENull() || this.psApplicationView.getUPDATEDATE().getTime() < this.psDynaDEViewTempl.getUPDATEDATE().getTime())) {
            String strLastModifyTime = DateHelper.toDateTimeString((Date)this.psDynaDEViewTempl.getUPDATEDATE());
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
        return new PSDynaDEViewTempl();
    }

    protected BaseDataEntity createRealViewTemplDataEntity() {
        return new PSDynaDEViewTempl();
    }

    @Override
    protected String onGetViewType() {
        return this.iPSViewType.getId();
    }

    @Override
    public String getPSDynaDEViewTemplId() {
        return this.strPSDynaDEViewTemplId;
    }

    @Override
    public String getPSDynaDEViewTemplName() {
        return this.strPSDynaDEViewTemplName;
    }

    protected void setPSDynaDEViewTemplId(String strPSDynaDEViewTemplId) {
        this.strPSDynaDEViewTemplId = strPSDynaDEViewTemplId;
    }

    protected void setPSDynaDEViewTemplName(String strPSDynaDEViewTemplName) {
        this.strPSDynaDEViewTemplName = strPSDynaDEViewTemplName;
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
    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers")
    public int getAccUserMode() {
        if (super.getAccUserMode() != AccessUserModes.UNKNOWN.intValue()) {
            return super.getAccUserMode();
        }
        return this.nAccUserMode;
    }

    @Override
    protected IPSSysUniRes getPSSysUniRes() {
        if (super.getPSSysUniRes() != null) {
            return super.getPSSysUniRes();
        }
        return this.iPSSysUniRes;
    }

    @Override
    protected void logPSModelIssue(PSSysIssue psSysIssueV3) throws Exception {
        psSysIssueV3.setPSOBJ2ID(this.getPSDynaDEViewTemplId());
        psSysIssueV3.setPSOBJ2NAME(this.getPSDynaDEViewTemplName());
        super.logPSModelIssue(psSysIssueV3);
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
    public IPSDynaDETempl getPSDynaDETempl() {
        return this.iPSDynaDETempl;
    }

    @Override
    public boolean isDynamicView() {
        return true;
    }

    @Override
    public String getModelType() {
        return "PSAPPDYNADEVIEW";
    }
}

