/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.TM.Web;

import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.ITMResCatalogHelper;
import SA.TM.Ctrl.ITMResViewActionHelper;
import SA.TM.Ctrl.ITMResViewHelper;
import SA.TM.Ctrl.Model.TMResViewModel;
import SA.TM.Ctrl.TMResViewActionHelper;
import SA.TM.Web.BaseTMPage;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import SA.TM.Web.ViewModel.TMResScheduleViewModel;
import net.sf.json.JSONObject;

public class TMResScheduleViewPage
extends BaseTMPage {
    protected TMResScheduleViewModel tmResScheduleViewModel = null;
    protected ITMResViewHelper iTMResViewHelper = null;
    protected static final String RESVIEWTYPE_RESCATALOG = "RESCATALOG";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean PreparePageEnv() {
        try {
            this.getWebContext().SetParamValue("SRFDEID", "TM0200");
            if (!super.PreparePageEnv()) {
                return false;
            }
            String strResViewType = this.getWebContext().GetParamValue("RESVIEWTYPE");
            String strResId = this.getWebContext().GetParamValue("RESID");
            String strTMResViewId = TMWebCTXHelper.getTMResViewId((ISRFDAWebContext)this.getWebContext());
            if (StringHelper.IsNullOrEmpty((String)strTMResViewId)) {
                TMResView tmResView = new TMResView();
                tmResView.setTMUSERID(this.getWebContext().getCurUserId());
                tmResView.setTMRESVIEWNAME("\u8d44\u6e90\u89c6\u56fe");
                ITMResCatalogHelper iTMResCatalogHelper = null;
                if (StringHelper.Compare((String)strResViewType, (String)RESVIEWTYPE_RESCATALOG, (boolean)true) == 0) {
                    iTMResCatalogHelper = this.getTMModelStorage().FindTMResCatalog(strResId);
                    tmResView.setTMRESVIEWNAME(iTMResCatalogHelper.getName());
                }
                DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                IDEDataCtrl tmResViewDataCtrl = this.getDEDataCtrl2("TM0200");
                transactionManager.Register(tmResViewDataCtrl);
                CallResult callResult = tmResViewDataCtrl.Save(true, (BaseDataEntity)tmResView);
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u89c6\u56fe\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
                strTMResViewId = tmResView.getTMRESVIEWID();
                TMWebCTXHelper.setTMResViewId((ISRFDAWebContext)this.getWebContext(), strTMResViewId);
                IDEDataCtrl tmResViewDetailDataCtrl = tmResViewDataCtrl.GetRelatedDataCtrl("TM0201");
                if (iTMResCatalogHelper != null) {
                    for (TMResCD tmResCD : iTMResCatalogHelper.getResCatalogDetails()) {
                        TMResViewDetail tmResViewDetail = new TMResViewDetail();
                        tmResViewDetail.setTMRESBASEID(tmResCD.getTMRESBASEID());
                        tmResViewDetail.setTMRESVIEWID(strTMResViewId);
                        callResult = tmResViewDetailDataCtrl.Save(true, (BaseDataEntity)tmResViewDetail);
                        if (!callResult.IsError()) continue;
                        transactionManager.Rollback();
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u89c6\u56fe\u660e\u7ec6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return false;
                    }
                }
                transactionManager.Commit();
            }
            this.iTMResViewHelper = this.getTMModelStorage().FindTMResView(strTMResViewId);
            if (StringHelper.Compare((String)this.iTMResViewHelper.getUserId(), (String)this.getWebContext().getCurUserId(), (boolean)true) == 0) return true;
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u975e\u89c6\u56fe\u6240\u6709\u8005\uff0c\u65e0\u6cd5\u52a0\u8f7d"));
            return false;
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
    }

    protected PageModel CreatePageModel() {
        return new TMResScheduleViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.tmResScheduleViewModel = (TMResScheduleViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        try {
            TMResViewModel tmResViewModel = new TMResViewModel(this.iTMResViewHelper);
            this.tmResScheduleViewModel.setTMResViewModel(tmResViewModel);
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
                iTMResViewActionHelper.Process(this.iTMResViewHelper, (SRFDAPageEx)this, strAction);
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
        return this.iTMResViewHelper.getName();
    }
}

