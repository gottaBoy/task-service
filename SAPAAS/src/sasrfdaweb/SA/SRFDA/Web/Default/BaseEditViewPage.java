/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.PP.PPEditView
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TempData
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Ctrl.SRFWFStates
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.PP.PPEditView;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.DefaultPageHelper;
import SA.SRFDA.Web.Default.ViewModel.BaseEditViewModel;
import SA.SRFDA.Web.IDEMainActionPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.PagePathHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Ctrl.SRFWFStates;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONObject;

public abstract class BaseEditViewPage
extends BaseMainPage
implements IDEMainActionPage {
    protected boolean bEnableWFMainState = false;
    protected boolean bShowDataInfoBar = true;
    protected PPEditView ppEditView = null;
    private BaseEditViewModel baseEditViewModel = null;
    private IDEMainActionHelper iDEMainActionHelper = null;
    protected boolean bInfoMode = false;
    protected boolean bProcessDEDataWFMode = true;
    private boolean bCalcShowDataInfoBar = false;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam("PAGE", "PPEDITVIEW")) != null && pageParam instanceof PPEditView) {
            this.ppEditView = (PPEditView)pageParam;
        }
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.baseEditViewModel = (BaseEditViewModel)this.pageModel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean ProcessDEIndexMode() {
        if (!this.getDEHelper().IsIndexDE()) return true;
        try {
            DERINDEX dERINDEX;
            String strKeyData;
            IDEHelper indexDEHelper = this.getDEHelper();
            String strIndexType = "";
            String strRealKey = "";
            BaseDataEntity activeDataEntity = new BaseDataEntity();
            strRealKey = strKeyData = this.getWebContext().GetParamValue(indexDEHelper.GetKeyDEFHelper().getName());
            if (!StringHelper.IsNullOrEmpty((String)strKeyData)) {
                activeDataEntity.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), (Object)strKeyData);
                CallResult callResult = indexDEHelper.GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext()).Get(activeDataEntity);
                if (callResult.getRetCode() != 0) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\uff0c%3$s", (Object)indexDEHelper.getId(), (Object)strKeyData, (Object)callResult.getErrorInfo()));
                    return false;
                }
                strIndexType = activeDataEntity.GetParamStringValue(indexDEHelper.GetIndexTypeDEFHelper().getName(), "");
                if (indexDEHelper.GetIndexMode() == 1) {
                    IDEFHelper realKeyDEFHelper = BaseDEHelper.GetIndexDERealKeyField((IDEHelper)indexDEHelper);
                    strRealKey = activeDataEntity.GetParamStringValue(realKeyDEFHelper.getName(), "");
                }
            } else {
                if (!SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false)) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
                    return false;
                }
                IDEDataCtrl iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", (ISRFDAWebContext)this.getWebContext());
                if (iTempDataCtrl == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                    return false;
                }
                if (StringHelper.IsNullOrEmpty((String)strKeyData)) {
                    strKeyData = SRFDAWebCTXHelper.GetTempKeyId((ISRFDAWebContext)this.getWebContext());
                }
                if (StringHelper.IsNullOrEmpty((String)strKeyData)) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
                    return false;
                }
                TempData tempData = new TempData();
                tempData.setTEMPDATAID(strKeyData);
                CallResult callResult = iTempDataCtrl.Get((BaseDataEntity)tempData);
                if (callResult.getRetCode() != 0) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4e34\u65f6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
                activeDataEntity = BaseDataEntity.FromString((String)tempData.getDEDATA());
                strIndexType = activeDataEntity.GetParamStringValue(indexDEHelper.GetIndexTypeDEFHelper().getName(), "");
                String[] parts = strKeyData.split("[:]");
                if (parts.length >= 2) {
                    strKeyData = String.valueOf(parts[0]) + ":" + parts[1];
                }
                this.getWebContext().SetParamValue("SRFDATEMPKEYID", strKeyData);
            }
            activeDataEntity = null;
            Vector list = indexDEHelper.GetDERINDEXs(true);
            boolean bFindDE = false;
            Iterator iterator = list.iterator();
            do {
                if (iterator.hasNext()) continue;
                if (bFindDE) return true;
                this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u7d22\u5f15\u5b9e\u4f53[%1$s]\u5173\u7cfb\u7c7b\u578b[%2$s]\u5bf9\u5e94\u5b9e\u4f53", (Object)this.getDEHelper().getId(), (Object)strIndexType));
                return false;
            } while (StringHelper.Compare((String)(dERINDEX = (DERINDEX)iterator.next()).getTYPEVALUE(), (String)strIndexType, (boolean)true) != 0);
            this.strPageDataEntityId = dERINDEX.getDEID();
            this.iDEHelper = null;
            if (!this.LoadPageDataEntity()) {
                return false;
            }
            this.getWebContext().SetParamValue("SRFDEID", this.strPageDataEntityId);
            this.getWebContext().SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), strRealKey);
            String strURL = "";
            String strEditPageId = this.iDEHelper.GetEditPageId();
            if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                Page page = this.getDAModelStorage().FindPage(strEditPageId);
                if (page == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5bf9\u8c61", (Object)strEditPageId));
                    return false;
                }
                strURL = page.GetTotalPagePath();
            } else {
                strURL = "../srfpage/editview.jsp";
            }
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            this.getWebContext().RemoveParam("SRFPAGEID");
            strURL = String.valueOf(strURL) + this.getWebContext().GetQueryString();
            try {
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.getResponse().sendRedirect(strURL);
                    return false;
                }
                this.getResponse().getWriter().write(BaseEditViewPage.OutputRedirectModel(strURL));
                return false;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u5904\u7406\u6570\u636e\u7d22\u5f15\u6a21\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%1%s", (Object)ex.getMessage()), ex);
            return false;
        }
    }

    protected boolean ProcessDEDataWFMode() {
        if (this.getDEHelper().IsEnableWF()) {
            BaseDataEntity activeDataEntity;
            DEWF dewf = this.getDEHelper().GetDEWF();
            if (dewf == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
                return false;
            }
            boolean bl = this.bEnableWFMainState = !StringHelper.IsNullOrEmpty((String)dewf.getMSCLID());
            if (this.bEnableWFMainState) {
                this.bEnableWFMainState = this.OnGetEnableWFMainState();
            }
            try {
                activeDataEntity = this.getActiveData();
            }
            catch (Exception ex) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5f53\u524d\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                return false;
            }
            if (activeDataEntity != null) {
                String strWFStep;
                CallResult callResult;
                String strWFState;
                String strWFStepColumnName;
                String strKeyData = activeDataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
                String strWFStateColumnName = dewf.getWFSTATEDEFID();
                if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
                    IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strWFStateColumnName);
                    strWFStateColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
                }
                if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID()))) {
                    IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strWFStepColumnName);
                    strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
                }
                if (StringHelper.Compare((String)(strWFState = SRFWFStates.ToString((int)activeDataEntity.GetParamIntValue(strWFStateColumnName, 0))), (String)"WFNOTFINISH", (boolean)true) == 0 && (callResult = this.TestWFAction(strKeyData, strWFStep = activeDataEntity.GetParamStringValue(strWFStepColumnName, ""))).getRetCode() == 0) {
                    block16: {
                        String strURL = "../srfwf/wfinfoview.jsp?";
                        String strInfoPageId = this.GetWFInfoPageId();
                        if (!StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
                            Page editPage = this.getDAModelStorage().FindPage(strInfoPageId);
                            if (editPage == null) {
                                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762[%1$s]\u4fe1\u606f\u5931\u8d25", (Object)strInfoPageId));
                                return false;
                            }
                            strURL = editPage.GetTotalPagePath();
                        }
                        try {
                            strURL = URLHelper.AppendURLSeperator((String)strURL);
                            strURL = String.valueOf(strURL) + this.getWebContext().GetQueryStringWithout("SRFPAGEID");
                            if (this.getPageParam("PAGE.TESTWFACTION", true)) {
                                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                                    this.getResponse().sendRedirect(strURL);
                                } else {
                                    this.getResponse().getWriter().write(BaseEditViewPage.OutputRedirectModel(strURL));
                                }
                                break block16;
                            }
                            return true;
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean OnGetEnableWFMainState() {
        boolean bEnableWFMainState = true;
        if (this.ppEditView != null && !this.ppEditView.isWFMAINSTATENull()) {
            bEnableWFMainState = this.ppEditView.getWFMAINSTATE();
        }
        return this.getPageParam("PAGE.WFMAINSTATE", bEnableWFMainState);
    }

    protected String GetWFInfoPageId(String strGroup, String strState, String strWFStep) {
        String strSectorName = StringHelper.Format((String)"%1$s.%2$s:%3$s:%4$s", (Object)"WFINFOPAGE", (Object)strGroup, (Object)strState, (Object)strWFStep);
        String strSectorPageId = this.getDEHelper().GetDEWF().GetWFParam(strSectorName);
        if (!StringHelper.IsNullOrEmpty((String)strSectorPageId)) {
            return strSectorPageId;
        }
        return this.getDEHelper().GetDEWF().getWFINFOPAGEID();
    }

    protected String GetWFInfoPageId() {
        String strGroup = this.getWebContext().GetParamValue("SRFWFDATAGROUP");
        String strState = this.getWebContext().GetParamValue("SRFWFSTATEVALUE");
        String strWFStep = this.getWebContext().GetParamValue("SRFWFSTEP");
        return this.GetWFInfoPageId(strGroup, strState, strWFStep);
    }

    protected CallResult TestWFAction(String strKeyValue, String strStepName) {
        return BaseEditViewPage.TestWFAction(this, strKeyValue, strStepName);
    }

    protected static CallResult TestWFAction(BaseEditViewPage page, String strKeyValue, String strStepName) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = page.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            page.getPage().PageLog((Object)page, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFId = page.getDEHelper().GetDEWFId(page.getWebContext().getSRFWFMode());
        WFGetIAActionsResult wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, page.getWebContext().getCurUserId(), "", strStepName, "", "", "", "");
        if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo())));
            page.getPage().PageLog((Object)page, 1, callResult.getErrorInfo());
            return callResult;
        }
        String strProcessName = wfGetIAActionsResult.getProcessName();
        WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, page.getWebContext().getCurUserId(), strKeyValue, "", "", page.getDEHelper().getId(), strProcessName, "", "", "", "");
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            page.getPage().PageLog((Object)page, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return callResult;
        }
        return wfCallResult;
    }

    protected boolean OnGetEditViewInfoMode() {
        if (this.getWebContext().isContainsParam("SRFINFOMODE")) {
            return this.getWebContext().getSRFInfoMode();
        }
        boolean bInfoMode = false;
        if (this.ppEditView != null && !this.ppEditView.isINFOMODENull()) {
            bInfoMode = this.ppEditView.getINFOMODE();
        }
        return this.getPageParam("PAGE.INFOMODE", bInfoMode);
    }

    protected String ProcessMultiFormMode() {
        return BaseEditViewPage.ProcessMultiFormMode(this);
    }

    protected static String ProcessMultiFormMode(BaseEditViewPage page) {
        if (!page.IsBackEndMode() && StringHelper.Compare((String)page.getDEHelper().GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) == 0) {
            String strMultiFormField = page.getDEHelper().GetProperty("MULTIFORMFIELD");
            if (StringHelper.IsNullOrEmpty((String)strMultiFormField)) {
                page.PageLog(page, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u6307\u5b9a\u591a\u8868\u5355\u5c5e\u6027", (Object)page.strPageDataEntityId));
                return "";
            }
            String strKeyValue = page.getWebContext().GetParamValue(page.getDEHelper().GetKeyDEFHelper().getName());
            String strTestValue = "";
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                try {
                    BaseDataEntity dataEntity = page.getActiveData();
                    if (dataEntity != null) {
                        strTestValue = dataEntity.GetParamStringValue(strMultiFormField, "");
                    }
                }
                catch (Exception ex) {
                    page.PageLog(page, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u67e5\u8be2\u6570\u636e[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)page.strPageDataEntityId, (Object)strKeyValue, (Object)ex.getMessage()), ex);
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strTestValue)) {
                strTestValue = page.getWebContext().GetParamValue(strMultiFormField);
            }
            if (!StringHelper.IsNullOrEmpty((String)strTestValue)) {
                String strFormIdFormat = page.getDEHelper().GetProperty("MULTIFORMFORMAT", "FORM_%1$s_%2$s");
                return StringHelper.Format((String)strFormIdFormat, (Object)page.getDEHelper().getId(), (Object)strTestValue);
            }
        }
        return "";
    }

    public boolean IsEnableWFMainState() {
        return this.bEnableWFMainState;
    }

    @Override
    protected String OnGetPageTitle() {
        String strPageTitle = "\u7f16\u8f91\u89c6\u56fe";
        String strPageLanResId = "PAGE.HEADER.EDITVIEW";
        if (StringHelper.Compare((String)this.getPageType(), (String)"ACTIONVIEW", (boolean)true) == 0) {
            strPageTitle = "PAGE.HEADER.ACTIONVIEW";
            strPageLanResId = "\u64cd\u4f5c\u89c6\u56fe";
        }
        if (this.page != null) {
            if (!this.page.isPAGETITLENull()) {
                strPageTitle = this.page.getPAGETITLE();
            }
            if (!this.page.isTITLELANRESIDNull()) {
                strPageLanResId = this.page.getTITLELANRESID();
            }
        }
        return this.GetLocalization(strPageLanResId, strPageTitle);
    }

    @Override
    protected PageModel CreatePageModel() {
        return new BaseEditViewModel();
    }

    protected boolean OnGetShowDataInfoBar() {
        boolean bShowDataInfoBar = true;
        return this.getPageParam("PAGE.DATAINFOBAR", bShowDataInfoBar);
    }

    public final boolean IsShowDataInfoBar() {
        if (!this.bCalcShowDataInfoBar) {
            this.bShowDataInfoBar = this.OnGetShowDataInfoBar();
            this.bCalcShowDataInfoBar = true;
        }
        return this.bShowDataInfoBar;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.baseEditViewModel.setCopyMode(this.isCopyMode());
        if (!this.IsShowDataInfoBar()) {
            this.baseEditViewModel.setShowDataInfoBar(false);
        }
        return true;
    }

    @Override
    public String getPageType() {
        if (this.isEnableDEMainAction()) {
            return "ACTIONVIEW";
        }
        return "EDITVIEW";
    }

    @Override
    public IDEMainActionHelper getDEMainAction() {
        return this.iDEMainActionHelper;
    }

    protected void ResetDEMainAction() {
        this.iDEMainActionHelper = null;
    }

    @Override
    public boolean isEnableDEMainAction() {
        return this.OnGetEnableDEMainAction();
    }

    protected boolean OnGetEnableDEMainAction() {
        return this.getDEMainAction() != null;
    }

    @Override
    protected boolean OnLoadPageDataEntity() {
        if (!super.OnLoadPageDataEntity()) {
            return false;
        }
        this.iDEMainActionHelper = null;
        String strDEMainAction = SRFDAWebCTXHelper.GetDEMainAction((ISRFDAWebContext)this.getWebContext());
        if (!StringHelper.IsNullOrEmpty((String)strDEMainAction)) {
            try {
                this.iDEMainActionHelper = this.getDEHelper().FindDEMainAction(strDEMainAction);
            }
            catch (Exception e) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), e);
            }
        }
        if (this.iDEMainActionHelper != null) {
            this.ResetDEMainState();
        } else if (!this.IsBackEndMode() && this.isEnableDEMainState()) {
            try {
                BaseDataEntity dataEntity = this.getActiveData();
                IDEMainStateHelper curMainStateHelper = null;
                curMainStateHelper = dataEntity != null ? this.getDEHelper().CalcDEMainState(dataEntity) : this.getDEHelper().GetDefaultDEMainState();
                if (curMainStateHelper != this.getDEMainState()) {
                    this.getWebContext().RemoveParam("SRFPAGEID");
                    String strPageId = "";
                    if (curMainStateHelper == null) {
                        strPageId = this.iDEHelper.GetEditPageId();
                        this.getWebContext().RemoveParam("SRFDEMAINSTATE");
                    } else {
                        this.getWebContext().SetParamValue("SRFDEMAINSTATE", curMainStateHelper.getName());
                        strPageId = curMainStateHelper.getSDPageId();
                    }
                    String strPagePath = PagePathHelper.CalcPath((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), strPageId, DefaultPageHelper.GetEditViewPage(), null);
                    strPagePath = String.valueOf(URLHelper.AppendURLSeperator((String)strPagePath)) + this.getWebContext().GetQueryString();
                    if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                        this.getResponse().sendRedirect(strPagePath);
                    } else {
                        this.getResponse().getWriter().write(BaseEditViewPage.OutputRedirectModel(strPagePath));
                    }
                    return false;
                }
            }
            catch (Exception e) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u8ba1\u7b97\u6570\u636e\u5c55\u793a\u8def\u5f84\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), e);
            }
        }
        return true;
    }

    @Override
    protected boolean OnGetEnableDAConfigV2(String strConfigType) {
        if (StringHelper.Compare((String)strConfigType, (String)"TOOLBAR", (boolean)true) == 0 && this.isEnableDEMainAction()) {
            return true;
        }
        return super.OnGetEnableDAConfigV2(strConfigType);
    }

    @Override
    protected void FillDAConfigPublishContext(DAConfigPublishContext daConfigPublishContext) {
        super.FillDAConfigPublishContext(daConfigPublishContext);
        if (this.isEnableDEMainAction()) {
            daConfigPublishContext.setDEMainAction(this.getDEMainAction());
        }
    }

    protected String getCurrentDEMainActionForm() throws Exception {
        if (this.isEnableDEMainAction()) {
            return this.getDEMainAction().getFormId();
        }
        if (this.isEnableDEMainState() && this.getDEMainState().getEditDEMainAction() != null) {
            return this.getDEMainState().getEditDEMainAction().getFormId();
        }
        return "";
    }

    protected boolean OnGetProcessDEDataWFMode() {
        if (this.isCopyMode()) {
            return false;
        }
        return this.bProcessDEDataWFMode;
    }

    @Override
    protected String OnGetDEMainState() {
        String strDEMainState = super.OnGetDEMainState();
        if (!StringHelper.IsNullOrEmpty((String)strDEMainState)) {
            return strDEMainState;
        }
        IDEMainStateHelper defaultDEMainState = this.getDEHelper().GetDefaultDEMainState();
        if (defaultDEMainState != null) {
            this.getWebContext().SetParamValue("SRFDEMAINSTATE", defaultDEMainState.getName());
            return defaultDEMainState.getName();
        }
        return "";
    }
}

