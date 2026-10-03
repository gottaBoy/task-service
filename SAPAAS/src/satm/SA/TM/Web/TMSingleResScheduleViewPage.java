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
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.ITMResViewActionHelper;
import SA.TM.Ctrl.Model.TMBTPlanResViewModel;
import SA.TM.Ctrl.TMResViewActionHelper;
import SA.TM.Web.BaseTMPage;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import SA.TM.Web.ViewModel.TMBTPlanResScheduleViewModel;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMSingleResScheduleViewPage
extends BaseTMPage {
    protected TMBTPlanResScheduleViewModel tmResScheduleViewModel = null;
    protected ITMResBaseHelper iTMResBaseHelper = null;
    protected static final String RESVIEWTYPE_RESCATALOG = "RESCATALOG";

    protected boolean PreparePageEnv() {
        String strTMResBaseId;
        block5: {
            block4: {
                try {
                    this.getWebContext().SetParamValue("SRFDEID", "TM0100");
                    if (super.PreparePageEnv()) break block4;
                    return false;
                }
                catch (Exception ex) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                    return false;
                }
            }
            strTMResBaseId = TMWebCTXHelper.getTMResBaseId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)strTMResBaseId)) break block5;
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8d44\u6e90\u6807\u8bc6"));
            return false;
        }
        try {
            this.iTMResBaseHelper = this.getTMModelStorage().FindTMResource(strTMResBaseId);
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
        return true;
    }

    protected PageModel CreatePageModel() {
        return new TMBTPlanResScheduleViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.tmResScheduleViewModel = (TMBTPlanResScheduleViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        try {
            TMBTPlanResViewModel tmResViewModel = new TMBTPlanResViewModel();
            Vector<TMResViewDetail> list = new Vector<TMResViewDetail>();
            TMResViewDetail tmResViewDetail = new TMResViewDetail();
            tmResViewDetail.setTMRESBASEID(this.iTMResBaseHelper.getId());
            tmResViewDetail.setTMRESBASENAME(this.iTMResBaseHelper.getName());
            list.add(tmResViewDetail);
            tmResViewModel.setTMResViewDetails(list);
            this.tmResScheduleViewModel.setTMBTPlanResViewModel(tmResViewModel);
        }
        catch (Exception e) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u586b\u5145\u754c\u9762\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), e);
            return false;
        }
        return true;
    }

    protected void OnLoadBackEnd() {
        String strActionType = this.webContext.getActionType();
        if (StringHelper.Compare((String)strActionType, (String)"TMRESVIEWACTION", (boolean)true) == 0) {
            String strAction = this.webContext.getAction();
            ITMResViewActionHelper iTMResViewActionHelper = this.OnCreateTMResViewActionHelper();
            try {
                iTMResViewActionHelper.Process(null, (SRFDAPageEx)this, strAction);
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"TM\u8d44\u6e90\u89c6\u56fe\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                TMActionResult actionResult = new TMActionResult();
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"TM\u8d44\u6e90\u89c6\u56fe\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                this.Output(actionResult.ToJSONString());
            }
            return;
        }
        super.OnLoadBackEnd();
    }

    protected ITMResViewActionHelper OnCreateTMResViewActionHelper() {
        return new TMResViewActionHelper();
    }

    protected String OnGetPageCaption() {
        return String.valueOf(this.iTMResBaseHelper.getName()) + "-\u8d44\u6e90\u89c6\u56fe";
    }

    protected String OnGetPageTitle() {
        return String.valueOf(this.iTMResBaseHelper.getName()) + "-\u8d44\u6e90\u89c6\u56fe";
    }
}

