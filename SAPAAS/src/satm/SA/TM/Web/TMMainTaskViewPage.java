/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.TM.Web;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.ITMMainTaskHelper;
import SA.TM.Ctrl.ITMMainTaskViewActionHelper;
import SA.TM.Ctrl.TMMainTaskViewActionHelper;
import SA.TM.Web.BaseTMPage;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import SA.TM.Web.ViewModel.TMMainTaskViewModel;
import net.sf.json.JSONObject;

public class TMMainTaskViewPage
extends BaseTMPage {
    protected TMMainTaskViewModel tmMainTaskViewModel = null;
    protected ITMMainTaskHelper iTMMainTaskHelper = null;

    protected boolean PreparePageEnv() {
        String strTMMainTaskId;
        block5: {
            block4: {
                try {
                    this.getWebContext().SetParamValue("SRFDEID", "TM0050");
                    if (super.PreparePageEnv()) break block4;
                    return false;
                }
                catch (Exception ex) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                    return false;
                }
            }
            strTMMainTaskId = TMWebCTXHelper.getTMMainTaskId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)strTMMainTaskId)) break block5;
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u4e3b\u4efb\u52a1\u7f16\u53f7"));
            return false;
        }
        try {
            this.iTMMainTaskHelper = this.getTMUserSessionStorage().FindTMMainTask(strTMMainTaskId);
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
        return true;
    }

    protected PageModel CreatePageModel() {
        return new TMMainTaskViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.tmMainTaskViewModel = (TMMainTaskViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    protected void OnLoadBackEnd() {
        String strActionType = this.webContext.getActionType();
        if (StringHelper.Compare((String)strActionType, (String)"TMMAINTASKVIEWACTION", (boolean)true) == 0) {
            String strAction = this.webContext.getAction();
            ITMMainTaskViewActionHelper iTMMainTaskViewActionHelper = this.OnCreateTMMainTaskViewActionHelper();
            try {
                iTMMainTaskViewActionHelper.Process(this.iTMMainTaskHelper, (SRFDAPageEx)this, strAction);
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"TM\u4e3b\u4efb\u52a1\u89c6\u56fe\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                TMActionResult actionResult = new TMActionResult();
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"TM\u4e3b\u4efb\u52a1\u89c6\u56fe\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                this.Output(actionResult.ToJSONString());
            }
            return;
        }
        super.OnLoadBackEnd();
    }

    protected ITMMainTaskViewActionHelper OnCreateTMMainTaskViewActionHelper() {
        return new TMMainTaskViewActionHelper();
    }

    protected String OnGetPageCaption() {
        return this.iTMMainTaskHelper.getName();
    }
}

