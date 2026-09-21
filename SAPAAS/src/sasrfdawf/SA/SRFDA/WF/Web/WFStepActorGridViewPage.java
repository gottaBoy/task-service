/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ErrorViewHelper
 *  SA.SRFDA.Web.ViewModel.LinkModel
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Ctrl.Data.WFInstance
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.WF.Ctrl.DataGrid.WFStepActorDGActionHelper;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ErrorViewHelper;
import SA.SRFDA.Web.ViewModel.LinkModel;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Ctrl.Data.WFInstance;
import java.util.TreeMap;

public class WFStepActorGridViewPage
extends GridViewPage {
    protected DEWF dewf = null;
    protected BaseDataEntity activeDataEntity = new BaseDataEntity();

    protected String GetDefaultPageDataEntityId() {
        return "WF0006";
    }

    protected String OnGetGridView() {
        return "WF0006_DATAGRID_001";
    }

    protected boolean CheckPageCallParam() {
        if (!super.CheckPageCallParam()) {
            return false;
        }
        String strRealDEId = this.getWebContext().GetParamValue("DEID");
        IDEHelper iRealDEHelper = this.getDAModelStorage().FindDEHelper(strRealDEId);
        if (iRealDEHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strRealDEId));
            return false;
        }
        this.dewf = iRealDEHelper.GetDEWF();
        if (this.dewf == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
            return false;
        }
        String strKeyData = this.getWebContext().GetParamValue(iRealDEHelper.GetKeyDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyData)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u4f20\u5165\u6709\u6548\u952e\u503c"));
            ErrorViewHelper.Goto((SRFExPage)this, (String)"WF000001");
            return false;
        }
        Object objValue = DataTypeParse.Parse((String)iRealDEHelper.GetKeyDEFHelper().GetStdDataType(), (String)strKeyData);
        if (objValue == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4f20\u5165\u952e\u503c\u5b9e\u9645\u7c7b\u578b\u503c\u5931\u8d25"));
            return false;
        }
        this.activeDataEntity.SetParamValue(iRealDEHelper.GetKeyDEFHelper().getName(), objValue);
        IDEDataCtrl deDataCtrl = iRealDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (deDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u5931\u8d25", (Object)this.getDEHelper().GetFullName()));
            return false;
        }
        CallResult callResult = deDataCtrl.Get(this.activeDataEntity);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u4f20\u5165\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objValue, (Object)callResult.getErrorInfo()));
            return false;
        }
        String strWFInstColumnName = this.dewf.getWFINSTDEFNAME();
        if (StringHelper.IsNullOrEmpty((String)strWFInstColumnName)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u914d\u7f6e\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5c5e\u6027"));
            return false;
        }
        String strWFInstId = this.activeDataEntity.GetParamStringValue(strWFInstColumnName, "");
        if (StringHelper.IsNullOrEmpty((String)strWFInstId)) {
            String strMessage = StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u4e2d\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u503c\uff0c\u53ef\u80fd\u8be5\u6570\u636e\u672a\u5f00\u59cb\u6d41\u7a0b\u6216\u5df2\u7ecf\u7ed3\u675f\u6d41\u7a0b", (Object)strRealDEId, (Object)objValue);
            this.PageLog((Object)this, 1, strMessage);
            ErrorViewHelper.Goto((SRFExPage)this, (String)"WF000001");
            return false;
        }
        WFInstance wfInst = new WFInstance();
        wfInst.setWFINSTANCEID(strWFInstId);
        IDEDataCtrl wfInstDataCtrl = this.getDAModelStorage().FindDEDataCtrl("WF0002", (ISRFDAWebContext)this.getWebContext());
        callResult = wfInstDataCtrl.Get((BaseDataEntity)wfInst);
        if (callResult.IsError()) {
            String strMessage = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u6570\u636e[%1$s]\uff0c%2$s", (Object)strWFInstId, (Object)callResult.getErrorInfo());
            this.PageLog((Object)this, 1, strMessage);
            ErrorViewHelper.Goto((SRFExPage)this, (String)"WF000002");
            return false;
        }
        if (wfInst.isCLOSE()) {
            String strMessage = StringHelper.Format((String)"\u6307\u5b9a\u5de5\u4f5c\u6d41\u5b9e\u4f8b[%1$s]\u6d41\u7a0b\u5df2\u7ecf\u7ed3\u675f", (Object)strWFInstId);
            this.PageLog((Object)this, 1, strMessage);
            ErrorViewHelper.Goto((SRFExPage)this, (String)"WF000003");
            return false;
        }
        this.setPageParam("WFINSTANCE", wfInst);
        this.setPageParam("ACTIVEDATAENTITY", this.activeDataEntity);
        this.setPageParam("REALDEHELPER", iRealDEHelper);
        if (this.gridViewModel != null) {
            callResult = WFStepActorGridViewPage.CalcWFAssistLink((SRFDAPage)this, wfInst, this.activeDataEntity, iRealDEHelper);
            if (callResult.IsError()) {
                return false;
            }
            LinkModel linkModel = (LinkModel)callResult.getUserObject();
            this.gridViewModel.RegisterLinkModel("wfassist", linkModel);
        }
        return true;
    }

    protected static CallResult CalcWFAssistLink(SRFDAPage daPage, WFInstance wfInst, BaseDataEntity activeDataEntity, IDEHelper iRealDEHelper) {
        String strDAParams;
        String strWFStepColumnName;
        CallResult callResult = new CallResult();
        LinkModel linkModel = new LinkModel();
        DEWF dewf = iRealDEHelper.GetDEWF();
        if (dewf == null) {
            daPage.PageLog((Object)daPage, 1, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
            return callResult;
        }
        boolean bShowModal = true;
        int nWidth = 0;
        int nHeight = 0;
        String strURL = "../srfwf/wfinfoview.jsp";
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        String strInfoPageId = iRealDEHelper.GetDEWF().getWFINFOPAGEID();
        if (!StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
            Page editPage = daPage.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strInfoPageId);
            if (editPage == null) {
                daPage.PageLog((Object)daPage, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strInfoPageId));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strInfoPageId));
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                strURL = editPage.GetTotalPagePath();
            }
            if (editPage.getWIDTH() != 0) {
                nWidth = editPage.getWIDTH();
            }
            if (editPage.getHEIGHT() != 0) {
                nHeight = editPage.getHEIGHT();
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.getWINDOWSTYLE())) {
                strWindowStyle = editPage.getWINDOWSTYLE();
            }
        }
        if (daPage.getWebContext().getGlobalHelper().getDAModelVersion() >= 11071100) {
            strURL = "../srfwf/wfassistredirectview.jsp";
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iRealDEHelper.getId());
        daParams.put(iRealDEHelper.GetKeyDEFHelper().getName(), activeDataEntity.GetParamStringValue(iRealDEHelper.GetKeyDEFHelper().getName(), ""));
        String strWFStateColumnName = dewf.getWFSTATEDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
            IDEFHelper iDEFHelper = iRealDEHelper.GetDEFHelper(strWFStateColumnName);
            strWFStateColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID()))) {
            IDEFHelper iDEFHelper = iRealDEHelper.GetDEFHelper(strWFStepColumnName);
            strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
            daParams.put("SRFWFSTATE", activeDataEntity.GetParamStringValue(strWFStateColumnName, ""));
        }
        if (!StringHelper.IsNullOrEmpty((String)strWFStepColumnName)) {
            daParams.put("SRFWFSTEP", activeDataEntity.GetParamStringValue(strWFStepColumnName, ""));
        }
        if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
            strURL = String.valueOf(strURL) + strDAParams;
            strURL = String.valueOf(strURL) + "&";
        }
        strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam();
        strURL = String.valueOf(strURL) + "&";
        linkModel.setUrl(strURL);
        linkModel.setWidth(nWidth);
        linkModel.setHeight(nHeight);
        linkModel.setShowModal(true);
        callResult.setUserObject((Object)linkModel);
        return callResult;
    }

    protected String GetDataGridActionHelper() {
        return WFStepActorDGActionHelper.class.getName();
    }

    protected void LoadButton() {
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setText("\u5173\u95ed\u7a97\u53e3");
        CancelButton.getButtonConfig().setTips("\u5173\u95ed\u7a97\u53e3");
        CancelButton.setResourceId("");
        this.AddControl((SRFExControl)CancelButton);
        StringBuilderEx script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        CancelButton.getButtonConfig().setJSCode(script.toString());
    }
}

