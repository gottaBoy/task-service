/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.WF.Web.JSGear.WFDataGridEditJSGear;
import SA.SRFDA.WF.Web.Utility.WFDataGridEditPageHelper;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import net.sf.json.JSONObject;

public class WFGridViewPage
extends GridViewPage {
    protected String strWFStep = "";
    protected String strWFStateValue = "";
    protected boolean bIsMYWFWorkMode = false;
    protected DEWF dewf = null;
    protected boolean bIsWFMgrMode = false;
    protected boolean bWFState = false;

    protected boolean PreparePageEnv() {
        String strQueryModelId;
        if (!super.PreparePageEnv()) {
            return false;
        }
        if (!this.getDEHelper().IsEnableWF()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41", (Object)this.getDEHelper().getName()));
            return false;
        }
        this.dewf = this.getDEHelper().GetDEWF();
        this.strWFStateValue = this.getWebContext().getSRFWFSTATEVALUE();
        this.strWFStep = this.getWebContext().getSRFWFSTEP();
        String strWFGroup = this.getWebContext().getSRFWFDATAGROUP();
        this.bIsMYWFWorkMode = StringHelper.Compare((String)strWFGroup, (String)"MYWFWORK", (boolean)true) == 0;
        boolean bl = this.bIsWFMgrMode = StringHelper.Compare((String)strWFGroup, (String)"PROCESSING", (boolean)true) == 0;
        if (!this.bIsMYWFWorkMode && !this.bIsWFMgrMode && !StringHelper.IsNullOrEmpty((String)(strQueryModelId = this.dewf.getQUERYMODELID())) && StringHelper.IsNullOrEmpty((String)this.getPageParam("PAGE.DATAGRID.QUERYMODEL", ""))) {
            this.setPageParam("PAGE.DATAGRID.QUERYMODEL", strQueryModelId);
        }
        if (!this.IsMYWFWorkMode()) {
            String strWFState = this.dewf.getWFSTATEVALUE();
            String[] states = strWFState.split("[|]");
            int i = 0;
            while (i < states.length) {
                String strState = states[i];
                if (!StringHelper.IsNullOrEmpty((String)(strState = strState.trim())) && StringHelper.Compare((String)this.strWFStateValue, (String)strState, (boolean)true) == 0) {
                    this.bWFState = true;
                    break;
                }
                ++i;
            }
        }
        return true;
    }

    protected void OnInit() {
        super.OnInit();
        if (!this.IsLoadDataGridNewEditJSGear()) {
            boolean bDGEdit = true;
            boolean bDGDBClkEdit = true;
            if (this.ppDataGrid != null) {
                if (!this.ppDataGrid.IsParamNull("ENABLEEDIT")) {
                    bDGEdit = this.ppDataGrid.getENABLEEDIT();
                }
                if (!this.ppDataGrid.IsParamNull("DGDBCLKEDIT")) {
                    bDGDBClkEdit = this.ppDataGrid.getDGDBCLKEDIT();
                }
            }
            bDGEdit = this.getPageParam("PAGE.DATAGRID.EDIT", bDGEdit);
            bDGDBClkEdit = this.getPageParam("PAGE.DATAGRID.DBCLKEDIT", bDGDBClkEdit);
            if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
                WFDataGridEditJSGear.Load((SRFDAPage)this, this.dataGrid);
            } else {
                if (bDGEdit) {
                    this.editPageInfo = new JSONObject();
                    this.editPageInfo.put("dbclkedit", bDGDBClkEdit);
                }
                WFDataGridEditPageHelper.Calc((SRFDAPage)this, this.dataGrid, this.editPageInfo);
            }
        }
    }

    protected boolean IsRefreshPWFTree() {
        return true;
    }

    protected boolean OnGetDataGridEditable() {
        boolean bEnableDGEdit = false;
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("ENABLEROWEDIT")) {
            bEnableDGEdit = this.ppGridView.getENABLEROWEDIT();
        }
        return this.getPageParam("PAGE.DATAGRID.EDITABLE", bEnableDGEdit);
    }

    protected boolean IsLoadDataGridNewEditJSGear() {
        if (this.bIsWFMgrMode) {
            return false;
        }
        return !this.bIsMYWFWorkMode;
    }

    protected String GetDefaultDataGridActionHelper() {
        String strDGActionHelper;
        if (!StringHelper.IsNullOrEmpty((String)this.getDEHelper().GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strDGActionHelper = this.getDAModelStorage().FindDBStorage(this.getDEHelper().GetDBStorage()).GetProperty("WFDGACTIONHELPER")))) {
            return strDGActionHelper;
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFDGACTIONHELPER", "");
    }

    protected boolean OnGetGVTheme() {
        return false;
    }

    protected int OnGetCaptionWidth() {
        return 120;
    }

    protected String OnGetGridViewToolbarConfigId() {
        boolean bWFEditable = false;
        WFGetIAActionsResult wfGetIAActionsResult = null;
        String strRealWFStep = this.strWFStep;
        if (this.IsMYWFWorkMode() && !StringHelper.IsNullOrEmpty((String)this.strWFStep)) {
            String strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
            if (StringHelper.IsNullOrEmpty((String)strDESubWFId)) {
                if (!this.iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.SAVEASIAACTION", false)) {
                    WFClientAPI wfClientAPI = new WFClientAPI();
                    String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
                    CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
                    if (callResult == null || callResult.getRetCode() != 0) {
                        this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return "";
                    }
                    String strWFId = this.getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
                    wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, this.getWebContext().getCurUserId(), "", this.strWFStep, "", "", "", "");
                    if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                        this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
                        return "";
                    }
                    String strEditableWFStep = this.dewf.getEDITABLEWFSTEP();
                    if (!StringHelper.IsNullOrEmpty((String)strEditableWFStep)) {
                        strEditableWFStep = strEditableWFStep.replace(";", "|");
                        String[] editableWFStep = strEditableWFStep.split("[|]");
                        int i = 0;
                        while (i < editableWFStep.length) {
                            if (StringHelper.Compare((String)this.strWFStep, (String)editableWFStep[i], (boolean)true) == 0) {
                                bWFEditable = true;
                                break;
                            }
                            ++i;
                        }
                    }
                }
            } else {
                String strWFSubStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
                if (!StringHelper.IsNullOrEmpty((String)strWFSubStep)) {
                    DESubWF deSubWF = this.getDEHelper().GetDESubWF(strDESubWFId);
                    if (deSubWF == null) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5e76\u884c\u5b50\u6d41\u7a0b[%1$s]", (Object)strDESubWFId));
                        return "";
                    }
                    if (!deSubWF.GetWFParam("WFINFOPAGE.SAVEASIAACTION", false)) {
                        WFClientAPI wfClientAPI = new WFClientAPI();
                        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
                        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
                        if (callResult == null || callResult.getRetCode() != 0) {
                            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            return "";
                        }
                        wfGetIAActionsResult = wfClientAPI.GetIAActions(deSubWF.getWFID(), this.getWebContext().getCurUserId(), "", strWFSubStep, "", "", "", "");
                        if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
                            return "";
                        }
                        String strEditableWFStep = deSubWF.getEDITABLEWFSTEP();
                        if (!StringHelper.IsNullOrEmpty((String)strEditableWFStep)) {
                            strEditableWFStep = strEditableWFStep.replace(";", "|");
                            String[] editableWFStep = strEditableWFStep.split("[|]");
                            int i = 0;
                            while (i < editableWFStep.length) {
                                if (StringHelper.Compare((String)strWFSubStep, (String)editableWFStep[i], (boolean)true) == 0) {
                                    bWFEditable = true;
                                    break;
                                }
                                ++i;
                            }
                        }
                        strRealWFStep = "SRFWFSUBSTEP:" + this.strWFStep + ":" + strDESubWFId + ":" + strWFSubStep;
                    }
                }
            }
        }
        if (this.bIsWFMgrMode) {
            return this.getDAConfigHelper().GetWFMgrGridViewToolbarConfigId(this.getDEHelper(), this.page, this.gridView);
        }
        return this.getDAConfigHelper().GetWFGridViewToolbarConfigId(this.getDEHelper(), this.page, this.gridView, this.strWFStateValue, this.IsMYWFWorkMode(), strRealWFStep, this.bWFState, bWFEditable, bWFEditable && this.bEnableDGEdit, wfGetIAActionsResult);
    }

    public boolean IsRenderCaption() {
        return false;
    }

    protected boolean IsMYWFWorkMode() {
        return this.bIsMYWFWorkMode;
    }
}

