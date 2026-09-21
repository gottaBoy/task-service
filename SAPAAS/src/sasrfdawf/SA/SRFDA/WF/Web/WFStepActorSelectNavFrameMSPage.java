/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.NavFrameMSPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Web.Default.NavFrameMSPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;

public class WFStepActorSelectNavFrameMSPage
extends NavFrameMSPage {
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.getPage().OutputAlertMsg("\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25", true);
            } else if (this.navFrameViewModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.navFrameViewModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript((String)this.getPageModel(), (String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25"));
                    this.navFrameViewModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript((String)this.getPageModel()));
                }
                this.OutputDirect(this.navFrameViewModel.toString());
            }
            return false;
        }
        String strQuerySessionId = Helper.GenGuid();
        String strWFId = this.getWebContext().GetParamValue("SRFWFID");
        String strUserDEId = this.getWebContext().GetParamValue("SRFUSERDEID");
        String strStepName = this.getWebContext().GetParamValue("SRFWFPROCESSNAME");
        String strConnection = this.getWebContext().GetParamValue("SRFWFIAACTIONNAME");
        String strKeyValue = this.getWebContext().GetParamValue("SRFUSERDATA");
        this.getWebContext().SetParamValue("N_SRFQUERYSESSIONID_EQ", strQuerySessionId);
        String[] keys = strKeyValue.split("[,]");
        WFCallResult wfCallResult = wfClientAPI.CalcNextIAProcessActor(strWFId, this.getWebContext().getCurUserId(), keys[0], "", "", strUserDEId, strStepName, strConnection, "", strQuerySessionId, "");
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u8ba1\u7b97\u4e0b\u4e00\u6b65\u4ea4\u4e92\u5904\u7406\u64cd\u4f5c\u8005\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.getPage().OutputAlertMsg(StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u8ba1\u7b97\u4e0b\u4e00\u6b65\u4ea4\u4e92\u5904\u7406\u64cd\u4f5c\u8005\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()), true);
            } else if (this.navFrameViewModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.navFrameViewModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript((String)this.getPageModel(), (String)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u8ba1\u7b97\u4e0b\u4e00\u6b65\u4ea4\u4e92\u5904\u7406\u64cd\u4f5c\u8005\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo())));
                    this.navFrameViewModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript((String)this.getPageModel()));
                }
                this.OutputDirect(this.navFrameViewModel.toString());
            }
            return false;
        }
        return true;
    }

    protected void LoadTabView() {
        String strTabViewConfigId = "SRFDEFAULT.TABVIEW_COMMON_MAIN";
        if (this.getPage().getPageParam("PAGE.TABVIEWID") != null) {
            strTabViewConfigId = this.getPage().getPageParam("PAGE.TABVIEWID").toString();
        }
        if (this.getPage().getPageParam("PAGE.SELECTMODE") != null) {
            this.getWebContext().SetParamValue("SELECTMODE", this.getPage().getPageParam("PAGE.SELECTMODE").toString());
        }
        if (StringHelper.IsNullOrEmpty((String)strTabViewConfigId)) {
            return;
        }
        this.tabView = WFStepActorSelectNavFrameMSPage.CreateTabView((SRFDAPage)this, (String)"tabView", (double)600.0, (double)0.0, (String)strTabViewConfigId);
        if (this.tabView != null) {
            this.tabView.getTabViewConfig().setTopHeader(false);
            this.tabView.getTabViewConfig().setBorder(false);
            this.tabView.getTabViewConfig().setResizeChild(true);
            if (this.navFrameViewModel != null && this.navFrameViewModel.getTabViewModel() != null) {
                this.navFrameViewModel.getTabViewModel().setConfigId(strTabViewConfigId);
            }
        }
    }
}

