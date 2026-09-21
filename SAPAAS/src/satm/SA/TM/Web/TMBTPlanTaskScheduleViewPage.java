/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.sf.json.JSONObject
 */
package SA.TM.Web;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.TM.Ctrl.Data.TMBTPlan;
import SA.TM.Ctrl.Data.TMBTPlanMT;
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTPlanTaskViewActionHelper;
import SA.TM.Ctrl.Model.TMBTPlanTaskViewModel;
import SA.TM.Ctrl.TMBTPlanTaskViewActionHelper;
import SA.TM.Ctrl.TMObjectFactory;
import SA.TM.Web.BaseTMPage;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import SA.TM.Web.ViewModel.TMBTPlanTaskScheduleViewModel;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMBTPlanTaskScheduleViewPage
extends BaseTMPage {
    protected TMBTPlanTaskScheduleViewModel tmResScheduleViewModel = null;
    protected ITMBTPlanHelper iTMBTPlanHelper = null;

    protected boolean PreparePageEnv() {
        String strTMBTPlanId;
        block6: {
            block5: {
                try {
                    this.getWebContext().SetParamValue("SRFDEID", "TM0162");
                    if (super.PreparePageEnv()) break block5;
                    return false;
                }
                catch (Exception ex) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                    return false;
                }
            }
            strTMBTPlanId = TMWebCTXHelper.getTMBTPlanId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)strTMBTPlanId)) break block6;
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u8bd5\u7b97\u8ba1\u5212"));
            return false;
        }
        TMBTPlan tmBTPlan = new TMBTPlan();
        tmBTPlan.setTMBTPLANID(strTMBTPlanId);
        IDEDataCtrl tmBTPlanDataCtrl = this.getDAModelStorage().FindDEDataCtrl2("TM0160", (ISRFDAWebContext)this.getWebContext());
        CallResult callResult = tmBTPlanDataCtrl.Get((BaseDataEntity)tmBTPlan);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u8ba1\u5212[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strTMBTPlanId, (Object)callResult.getErrorInfo()));
        }
        this.iTMBTPlanHelper = TMObjectFactory.getCurrent().CreateBTPlanHelper((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), tmBTPlan);
        return true;
    }

    protected PageModel CreatePageModel() {
        return new TMBTPlanTaskScheduleViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.tmResScheduleViewModel = (TMBTPlanTaskScheduleViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        try {
            IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper2("TM0164");
            BaseDAQueryModelHelper daQueryModelHelper = this.getDAModelStorage().FindDAQueryModelHelper(iDEHelper);
            DefaultDAQueryModelUserContext qmUserContext = new DefaultDAQueryModelUserContext();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(daQueryModelHelper.GetQueryModelScript());
            Vector<String> userConditions = new Vector<String>();
            daQueryModelHelper.FillMajorConditions(userConditions);
            String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)qmUserContext, iDEHelper.GetDEFHelper("TMBTPLANID"), "", "=", this.iTMBTPlanHelper.getId());
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                userConditions.add(strCondition);
            }
            if (userConditions.size() != 0) {
                script.Append(" WHERE ");
                boolean bFirst = true;
                for (String strCondition2 : userConditions) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(" AND ");
                    }
                    script.Append("(%1$s)", (Object)strCondition2);
                }
            }
            Vector paramList = new Vector();
            daQueryModelHelper.FillQMDeclareParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            qmUserContext.FillQMDeclareParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            daQueryModelHelper.FillCallParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            String strSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + qmUserContext.GetQMDeclareScript();
            strSQL = String.valueOf(strSQL) + script.toString();
            Vector tmBTPlanMTList = new Vector();
            CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)iDEHelper.GetDBStorage(), (String)strSQL, paramList, tmBTPlanMTList, (String)TMBTPlanMT.class.getName());
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Vector<TMResViewDetail> list = new Vector<TMResViewDetail>();
            for (TMBTPlanMT tmBTPlanMT : tmBTPlanMTList) {
                TMResViewDetail tmResViewDetail = new TMResViewDetail();
                tmResViewDetail.setTMRESBASEID(tmBTPlanMT.getTMBOOKINGTESTID());
                tmResViewDetail.setTMRESBASENAME(tmBTPlanMT.getTMBOOKINGTESTNAME());
                list.add(tmResViewDetail);
            }
            TMBTPlanTaskViewModel tmResViewModel = new TMBTPlanTaskViewModel();
            tmResViewModel.setTMResViewDetails(list);
            this.tmResScheduleViewModel.setTMBTPlanTaskViewModel(tmResViewModel);
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
            ITMBTPlanTaskViewActionHelper iTMBTPlanTaskViewActionHelper = this.OnCreateTMBTPlanTaskViewActionHelper();
            try {
                iTMBTPlanTaskViewActionHelper.Process(this.iTMBTPlanHelper, (SRFDAPageEx)this, strAction);
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"TM\u9884\u7ea6\u8ba1\u5212\u4efb\u52a1\u89c6\u56fe\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                TMActionResult actionResult = new TMActionResult();
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"TM\u9884\u7ea6\u8ba1\u5212\u4efb\u52a1\u89c6\u56fe\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                this.Output(actionResult.ToJSONString());
            }
            return;
        }
        super.OnLoadBackEnd();
    }

    protected ITMBTPlanTaskViewActionHelper OnCreateTMBTPlanTaskViewActionHelper() {
        return new TMBTPlanTaskViewActionHelper();
    }

    protected String OnGetPageCaption() {
        return String.valueOf(this.iTMBTPlanHelper.getName()) + "\u4efb\u52a1\u89c6\u56fe";
    }

    protected String OnGetPageTitle() {
        return String.valueOf(this.iTMBTPlanHelper.getName()) + " \u4efb\u52a1\u89c6\u56fe";
    }
}

