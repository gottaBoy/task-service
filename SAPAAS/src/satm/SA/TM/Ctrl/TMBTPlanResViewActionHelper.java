/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.TM.Ctrl.BaseTMBTPlanResViewActionHelper;
import SA.TM.Ctrl.Data.TMBTPlanCal;
import SA.TM.Ctrl.TMResViewFilter;
import SA.TM.Web.TMActionResult;
import SA.TM.Web.TMWebCTXHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMBTPlanResViewActionHelper
extends BaseTMBTPlanResViewActionHelper {
    protected DefaultDAQueryModelUserContext qmUserContext = null;

    protected TMActionResult OnFetch() throws Exception {
        TMActionResult tmActionResult = new TMActionResult();
        String strTMResViewFilter = TMWebCTXHelper.getTMResViewActionParam((ISRFDAWebContext)this.getWebContext());
        TMResViewFilter tmResViewFilter = new TMResViewFilter(strTMResViewFilter);
        IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper2("TM0165");
        BaseDAQueryModelHelper daQueryModelHelper = this.getPage().getDAModelStorage().FindDAQueryModelHelper(iDEHelper);
        boolean bUserDP = false;
        if (daQueryModelHelper == null) {
            tmActionResult.setRetCode(1);
            tmActionResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
            return tmActionResult;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        String strCondition = "";
        CallResult callResult = daQueryModelHelper.GetDEFieldExp(iDEHelper.GetDEFHelper("TMRESBASEID"));
        String[] resources = tmResViewFilter.getResources().split("[;]");
        String strResCond = "";
        int i = 0;
        while (i < resources.length) {
            if (i != 0) {
                strResCond = String.valueOf(strResCond) + " OR ";
            }
            strResCond = String.valueOf(strResCond) + StringHelper.Format((String)"%1$s='%2$s'", (Object)callResult.getUserObject(), (Object)resources[i]);
            ++i;
        }
        if (!StringHelper.IsNullOrEmpty((String)strResCond)) {
            userConditions.add(strResCond);
        }
        callResult = daQueryModelHelper.GetDEFieldExp(iDEHelper.GetDEFHelper("BEGINTIME"));
        String strBeginTimeField = callResult.getUserObject().toString();
        callResult = daQueryModelHelper.GetDEFieldExp(iDEHelper.GetDEFHelper("ENDTIME"));
        String strEndTimeField = callResult.getUserObject().toString();
        strCondition = StringHelper.Format((String)"%1$s>=? AND %2$s <=?", (Object)strBeginTimeField, (Object)strEndTimeField);
        userConditions.add(strCondition);
        strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEHelper.GetDEFHelper("TMBTPLANID"), "", "=", this.getTMBTPlan().getId());
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
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        list.add(new CallParam((Object)tmResViewFilter.getBeginTime(), 5));
        list.add(new CallParam((Object)tmResViewFilter.getEndTime(), 5));
        String strSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + script.toString();
        Vector tmBTPlanCals = new Vector();
        CallResult callResult2 = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), null, (String)iDEHelper.GetDBStorage(), (String)strSQL, list, tmBTPlanCals, (String)TMBTPlanCal.class.getName());
        if (callResult2.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8d44\u6e90\u9884\u7ea6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
        }
        Vector<JSONObject> items = new Vector<JSONObject>();
        for (TMBTPlanCal tmBTPlanCal : tmBTPlanCals) {
            JSONObject jo = new JSONObject();
            tmBTPlanCal.FillJSONObject(jo, false);
            items.add(jo);
        }
        tmActionResult.setItems(items);
        return tmActionResult;
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }
}

