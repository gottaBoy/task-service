/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;

public class WFAssistRedirectPage
extends SRFDAPage {
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        String strStepActorId = this.getWebContext().GetParamValue("WFSTEPACTORID");
        if (StringHelper.IsNullOrEmpty((String)strStepActorId)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u7528\u6237\u6807\u8bc6"));
            return false;
        }
        String strSQL = StringHelper.Format((String)"\t select t1.*,t3.PARALLELINST, t3.USERTAG as DESUBWFID from T_SRFWFSTEPACTOR t1  LEFT JOIN T_SRFWFSTEP t2 ON t1.WFSTEPID = t2.WFSTEPID  INNER JOIN T_SRFWFINSTANCE t3 ON t3.WFINSTANCEID = t2.WFINSTANCEID WHERE WFSTEPACTORID='%1$s'", (Object)strStepActorId);
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)"", (String)strSQL, (BaseDataEntity)dataEntity);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u6b65\u9aa4\u7528\u6237\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strStepActorId, (Object)callResult.getErrorInfo()));
            return false;
        }
        String strURL = "../srfwf/wfinfoview.jsp";
        String strInfoPageId = this.getDEHelper().GetDEWF().getWFINFOPAGEID();
        if (!StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
            Page editPage = this.getDAModelStorage().FindPage(strInfoPageId);
            if (editPage == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strInfoPageId));
                return false;
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                strURL = editPage.GetTotalPagePath();
            }
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + this.getWebContext().GetQueryString();
        if (dataEntity.GetParamIntValue("PARALLELINST", -1) == 1) {
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFDESUBWFID=%1$s", (Object)dataEntity.GetParamStringValue("DESUBWFID", ""));
        }
        try {
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.getResponse().sendRedirect(strURL);
            } else {
                this.getResponse().getWriter().write(WFAssistRedirectPage.OutputRedirectModel((String)strURL));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

