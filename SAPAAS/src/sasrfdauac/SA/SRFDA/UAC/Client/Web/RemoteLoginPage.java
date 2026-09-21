/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.LoginKey
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 */
package SA.SRFDA.UAC.Client.Web;

import SA.SRFDA.Ctrl.Data.LoginKey;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.UAC.Client.Web.BaseLoginPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.io.IOException;
import java.util.Date;

public class RemoteLoginPage
extends BaseLoginPage {
    protected static IDEDataCtrl loginKeyDataCtrl = null;

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getCurUserId())) {
                SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
                actionResult.setRetCode(0);
                String strSessionKeys = this.getWebContext().GetParamValue("SESSIONKEYS");
                this.OnFillExtLoginInfo(actionResult, strSessionKeys);
                try {
                    this.getResponse().getWriter().print(actionResult.ToJSONString());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
            String strLoginName = "";
            String strLoginKey = this.getWebContext().GetParamValue("LOGINKEY");
            if (!StringHelper.IsNullOrEmpty((String)strLoginKey)) {
                int nCnt;
                LoginKey loginKey = new LoginKey();
                loginKey.setLOINGKEYID(strLoginKey);
                CallResult callResult = this.GetLoginKeyDataCtrl().Get((BaseDataEntity)loginKey);
                if (callResult.IsError()) {
                    return;
                }
                if (loginKey.getLIMITCNT() == 0) {
                    this.GetLoginKeyDataCtrl().Remove((BaseDataEntity)loginKey);
                    return;
                }
                strLoginName = "";
                if (!StringHelper.IsNullOrEmpty((String)loginKey.getIPADDRESS())) {
                    String strIpAddr = this.getWebContext().getRemoteAddr();
                    if (loginKey.getIPADDRESS().indexOf(strIpAddr) != -1) {
                        strLoginName = loginKey.getLOINGKEYNAME();
                    }
                } else {
                    strLoginName = loginKey.getLOINGKEYNAME();
                }
                if (!loginKey.IsParamNull("EXPIREDTIME") && new Date().getTime() > loginKey.getEXPIREDTIME().getTime()) {
                    strLoginName = "";
                }
                if ((nCnt = loginKey.getLIMITCNT()) != -1) {
                    if (--nCnt == 0) {
                        this.GetLoginKeyDataCtrl().Remove((BaseDataEntity)loginKey);
                    } else {
                        loginKey.setLIMITCNT(nCnt);
                        this.GetLoginKeyDataCtrl().Save(false, (BaseDataEntity)loginKey);
                    }
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strLoginName)) {
                this.OnLoginUserName(strLoginName);
            }
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    protected synchronized IDEDataCtrl GetLoginKeyDataCtrl() {
        if (loginKeyDataCtrl == null) {
            loginKeyDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0146", "SYSTEM", null);
        }
        return loginKeyDataCtrl;
    }

    @Override
    protected CallResult OnLoginUserName(String strLoginName) {
        SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
        CallResult callResult = super.OnLoginUserName(strLoginName);
        actionResult.From(callResult);
        if (callResult.IsOk()) {
            String strSessionKeys = this.getWebContext().GetParamValue("SESSIONKEYS");
            this.OnFillExtLoginInfo(actionResult, strSessionKeys);
            try {
                this.getResponse().getWriter().print(actionResult.ToJSONString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return callResult;
    }

    protected void OnFillExtLoginInfo(SRFExAjaxActionResult actionResult, String strSessionKeys) {
        actionResult.setExtInfo("userid", this.getWebContext().getCurUserId());
        actionResult.setExtInfo("username", this.getWebContext().getCurUserName());
        actionResult.setExtInfo("usermode", this.getWebContext().getCurUserMode());
        actionResult.setExtInfo("loginname", this.getWebContext().getCurLoginName());
        actionResult.setExtInfo("language", this.getWebContext().getLocalization());
        if (!StringHelper.IsNullOrEmpty((String)strSessionKeys)) {
            String[] items = StringHelper.SplitEx((String)strSessionKeys);
            if (items == null) {
                return;
            }
            int i = 0;
            while (i < items.length) {
                Object objValue = this.getWebContext().GetSessionValue(items[i]);
                if (objValue != null) {
                    actionResult.setExtInfo(items[i], objValue.toString());
                }
                ++i;
            }
        }
    }
}

