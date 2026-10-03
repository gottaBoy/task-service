/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPDataGrid
 *  SA.SRFDA.Ctrl.Data.PP.PPGridView
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.PP.PPDataGrid;
import SA.SRFDA.Ctrl.Data.PP.PPGridView;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseGridViewPage
extends BaseMainPage {
    public static final String PPCTRLID_DATAGRID = "DATAGRID";
    protected PPGridView ppGridView = null;
    protected PPDataGrid ppDataGrid = null;

    @Override
    protected void PreparePageParam() {
        super.PreparePageParam();
        if (this.page != null) {
            BaseDataEntity pageParam = this.page.getAdvPageParam("PAGE", "PPGRIDVIEW");
            if (pageParam != null && pageParam instanceof PPGridView) {
                this.ppGridView = (PPGridView)pageParam;
            }
            if ((pageParam = this.page.getAdvPageParam(PPCTRLID_DATAGRID, "PP_DATAGRID")) != null && pageParam instanceof PPDataGrid) {
                this.ppDataGrid = (PPDataGrid)pageParam;
            }
        }
    }

    @Override
    protected boolean OnLoadPageDataEntity() {
        block4: {
            if (!super.OnLoadPageDataEntity()) {
                return false;
            }
            try {
                if (this.ProcessPDEMainState()) break block4;
                return false;
            }
            catch (Exception ex) {
                this.PageLog(this, 1, ex.getMessage(), ex);
                return false;
            }
        }
        try {
            return this.ProcessParentDataTag();
        }
        catch (Exception exception) {
            this.PageLog(this, 1, exception.getMessage(), exception);
            return false;
        }
    }

    protected boolean ProcessPDEMainState() throws Exception {
        IDEMainStateHelper iCurDEMainStateHelper;
        if (SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false)) {
            return true;
        }
        if (!this.getDEHelper().IsEnableDEMainState()) {
            return true;
        }
        if (!this.isEnableParentData() || this.getParentDEHelper() == null) {
            return true;
        }
        if (!this.getDEHelper().HasDEMainStateMapTo(this.getParentDEHelper().getId())) {
            return true;
        }
        if (!this.getParentDEHelper().IsEnableDEMainState()) {
            return true;
        }
        IDEMainStateHelper iParentDEMainStateHelper = null;
        Object objParentKey = this.getParentKey();
        String strPDEMainState = SRFDAWebCTXHelper.GetPDEMainState((ISRFDAWebContext)this.getWebContext());
        if (objParentKey == null) {
            if (!StringHelper.IsNullOrEmpty((String)strPDEMainState)) {
                iParentDEMainStateHelper = this.getParentDEHelper().FindDEMainState(strPDEMainState);
            }
        } else {
            iParentDEMainStateHelper = this.getParentDEHelper().CalcDEMainState(objParentKey);
        }
        if (iParentDEMainStateHelper == null) {
            return true;
        }
        if (StringHelper.Compare((String)strPDEMainState, (String)iParentDEMainStateHelper.getName(), (boolean)true) != 0) {
            this.getWebContext().SetParamValue("SRFPDEMAINSTATE", iParentDEMainStateHelper.getName());
        }
        if ((iCurDEMainStateHelper = this.getDEHelper().FindDEMainState(this.getParentDEHelper().getId(), iParentDEMainStateHelper.getId())) != this.getDEMainState()) {
            if (iCurDEMainStateHelper == null) {
                this.getWebContext().RemoveParam("SRFDEMAINSTATE");
            } else {
                this.getWebContext().SetParamValue("SRFDEMAINSTATE", iCurDEMainStateHelper.getName());
            }
            return this.RedirectCurrentPath();
        }
        return true;
    }

    @Override
    protected String OnGetPageType() {
        return "GRIDVIEW";
    }

    protected boolean OnGetGridViewInfoMode() {
        if (this.getWebContext().isContainsParam("SRFINFOMODE")) {
            return this.getWebContext().getSRFInfoMode();
        }
        boolean bInfoMode = false;
        try {
            if (this.isEnableParentData() && StringHelper.Compare((String)this.getPickupDEFHelper().GetDERId(), (String)this.getDEHelper().GetMajorDERId(), (boolean)false) == 0 && this.isParentDataInWorkflow() && !this.isParentDataEnableWFUpdate()) {
                bInfoMode = true;
            }
        }
        catch (Exception e) {
            this.PageLog(this, 1, e.getMessage(), e);
        }
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("INFOMODE")) {
            bInfoMode = this.ppGridView.getINFOMODE();
        }
        return this.getPageParam("PAGE.INFOMODE", bInfoMode);
    }

    @Override
    protected boolean OnGetEnableActiveData() {
        return false;
    }
}

