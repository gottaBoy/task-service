/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.EditViewPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Ctrl.SRFWFStates
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.EditViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Ctrl.SRFWFStates;

public class WFInfoViewPage2
extends EditViewPage {
    protected String strWFState = "";
    protected String strWFStep = "";
    protected DEWF dewf = null;
    public static final String TAG_WFFORMNAME_DEFAULT = "DEFAULT";
    protected String strKeyParamValue = "";
    protected boolean bEnableUpdate = false;
    private String strSubWFStepColumnName = "";
    protected DESubWF deSubWF = null;
    protected String strDESubWFId = "";
    protected String strSubWFStep = "";
    private String strKeyData = "";

    public WFInfoViewPage2() {
        this.bProcessDEDataWFMode = false;
    }

    protected boolean PreparePageEnv() {
        String strEditableWFStep;
        IDEFHelper iDEFHelper;
        String strWFStepColumnName;
        String strWFStateColumnName;
        BaseDataEntity activeDataEntity;
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.dewf = this.getDEHelper().GetDEWF();
        if (this.dewf == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
            return false;
        }
        this.strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)this.strDESubWFId)) {
            this.deSubWF = this.getDEHelper().GetDESubWF(this.strDESubWFId);
            if (this.deSubWF == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5e76\u884c\u5b50\u6d41\u7a0b[%1$s]", (Object)this.strDESubWFId));
                return false;
            }
            this.strSubWFStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
        }
        this.strKeyData = this.getWebContext().GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)this.strKeyData)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u4f20\u5165\u6709\u6548\u952e\u503c"));
            return false;
        }
        Object objValue = this.getDEHelper().GetKeyDEFHelper().GetDEFValue(this.strKeyData);
        if (objValue == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4f20\u5165\u952e\u503c\u5b9e\u9645\u7c7b\u578b\u503c\u5931\u8d25"));
            return false;
        }
        try {
            activeDataEntity = this.getActiveData();
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getDEHelper().getId(), (Object)objValue, (Object)ex.getMessage()), ex);
            return false;
        }
        if (activeDataEntity == null) {
            activeDataEntity = new BaseDataEntity();
            activeDataEntity.SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), objValue);
            IDEDataCtrl deDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (deDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u5931\u8d25", (Object)this.getDEHelper().GetFullName()));
                return false;
            }
            CallResult callResult = deDataCtrl.Get(activeDataEntity);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4f20\u5165\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objValue, (Object)callResult.getErrorInfo()));
                return false;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStateColumnName = this.dewf.getWFSTATEDEFID()))) {
            IDEFHelper iDEFHelper2 = this.getDEHelper().GetDEFHelper(strWFStateColumnName);
            strWFStateColumnName = iDEFHelper2 != null ? iDEFHelper2.getName() : "";
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = this.dewf.getWFSTEPDEFID()))) {
            iDEFHelper = this.getDEHelper().GetDEFHelper(strWFStepColumnName);
            strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        this.strWFState = SRFWFStates.ToString((int)activeDataEntity.GetParamIntValue(strWFStateColumnName, 0));
        this.strWFStep = activeDataEntity.GetParamStringValue(strWFStepColumnName, "");
        if (StringHelper.IsNullOrEmpty((String)this.strWFState)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548"));
            this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548');");
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strWFStep)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548"));
            this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548');");
            return false;
        }
        this.getWebContext().SetParamValue("SRFWFSTEP", this.strWFStep);
        if (this.deSubWF != null) {
            this.strSubWFStepColumnName = this.deSubWF.getWFSTEPDEFID();
            if (!StringHelper.IsNullOrEmpty((String)this.strSubWFStepColumnName)) {
                iDEFHelper = this.getDEHelper().GetDEFHelper(this.strSubWFStepColumnName);
                this.strSubWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
                this.strSubWFStep = activeDataEntity.GetParamStringValue(this.strSubWFStepColumnName, "");
            }
            if (StringHelper.IsNullOrEmpty((String)this.strSubWFStep)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5b50\u6d41\u7a0b\u72b6\u6001\u503c\u65e0\u6548"));
                this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5b50\u6d41\u7a0b\u72b6\u6001\u503c\u65e0\u6548');");
                return false;
            }
            this.getWebContext().SetParamValue("SRFWFSUBSTEP", this.strSubWFStep);
        }
        if (this.deSubWF == null) {
            strEditableWFStep = this.dewf.getEDITABLEWFSTEP();
            if (!StringHelper.IsNullOrEmpty((String)strEditableWFStep)) {
                strEditableWFStep = strEditableWFStep.replace(";", "|");
                String[] editableWFStep = strEditableWFStep.split("[|]");
                int i = 0;
                while (i < editableWFStep.length) {
                    if (StringHelper.Compare((String)this.strWFStep, (String)editableWFStep[i], (boolean)true) == 0) {
                        this.bEnableUpdate = true;
                        break;
                    }
                    ++i;
                }
            }
        } else {
            strEditableWFStep = this.deSubWF.getEDITABLEWFSTEP();
            if (!StringHelper.IsNullOrEmpty((String)strEditableWFStep)) {
                strEditableWFStep = strEditableWFStep.replace(";", "|");
                String[] editableWFStep = strEditableWFStep.split("[|]");
                int i = 0;
                while (i < editableWFStep.length) {
                    if (StringHelper.Compare((String)this.strSubWFStep, (String)editableWFStep[i], (boolean)true) == 0) {
                        this.bEnableUpdate = true;
                        break;
                    }
                    ++i;
                }
            }
        }
        this.setPageParam("ENABLEUPDATE", this.bEnableUpdate);
        this.RegisterOnReadyScript(3, StringHelper.Format((String)"$P.keys='%1$s';", (Object)this.strKeyData));
        return true;
    }

    protected String GetToolbarConfigId() {
        return this.OnGetWFInfoViewToolbarConfigId();
    }

    protected String OnGetWFInfoViewToolbarConfigId() {
        String strRealWFStep = this.strWFStep;
        WFGetIAActionsResult wfGetIAActionsResult = null;
        if (StringHelper.Compare((String)this.strWFState, (String)"WFNOTFINISH", (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)this.strWFStep)) {
            String strUserData = "";
            String strUserData4 = "";
            try {
                BaseDataEntity dataEntity = this.getActiveData();
                if (dataEntity != null) {
                    strUserData = dataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
                    strUserData4 = this.getDEHelper().getId();
                }
            }
            catch (Exception e) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5f53\u524d\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            }
            WFClientAPI wfClientAPI = new WFClientAPI();
            String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
            if (this.deSubWF == null) {
                CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                String strWFId = this.getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
                wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, this.getWebContext().getCurUserId(), "", this.strWFStep, strUserData, "", "", strUserData4);
                if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
                    return "";
                }
            } else {
                CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                wfGetIAActionsResult = wfClientAPI.GetIAActions(this.deSubWF.getWFID(), this.getWebContext().getCurUserId(), "", this.strSubWFStep, strUserData, "", "", strUserData4);
                if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
                    return "";
                }
                strRealWFStep = "SRFWFSUBSTEP:" + this.strWFStep + ":" + this.strDESubWFId + ":" + this.strSubWFStep;
            }
        }
        return this.getDAConfigHelper().GetWFInfoViewToolbarConfigId(this.getDEHelper(), this.page, this.strWFState, strRealWFStep, this.bEnableUpdate, wfGetIAActionsResult);
    }

    protected String OnGetTabViewConfigId() {
        return this.getDAConfigHelper().GetWFInfoViewTabViewConfigId(this.getDEHelper(), this.page, this.bEnableUpdate);
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.WFINFOVIEW", "\u6d41\u7a0b\u6570\u636e\u4fe1\u606f\u89c6\u56fe");
    }

    protected boolean OnGetEnableDEMainState() {
        return false;
    }
}

