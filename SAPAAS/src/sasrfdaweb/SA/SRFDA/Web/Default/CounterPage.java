/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.CounterResult
 *  SA.SRFDA.Ctrl.DAActionContext
 *  SA.SRFDA.Ctrl.ICounterHelper
 *  SA.SRFDA.Ctrl.IDAActionContext
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.CounterResult;
import SA.SRFDA.Ctrl.DAActionContext;
import SA.SRFDA.Ctrl.ICounterHelper;
import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import java.util.HashMap;
import net.sf.json.JSONObject;

public class CounterPage
extends SRFDAPage {
    public CounterPage() {
        this.setMainPage(false);
        this.setOutputDebug(false);
    }

    protected void OnLoad() {
        SRFExAjaxListResult ajaxActionResult = null;
        try {
            ajaxActionResult = this.ProcessCounters();
        }
        catch (Exception ex) {
            ajaxActionResult = new SRFExAjaxListResult();
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            this.PageLog((Object)this, 1, ajaxActionResult.getErrorInfo(), ex);
        }
        this.Output(ajaxActionResult.ToJSONString());
    }

    protected SRFExAjaxListResult ProcessCounters() throws Exception {
        String[] counterIds;
        String strCounters = this.getWebContext().GetPostValue("srfcounters");
        if (StringHelper.IsNullOrEmpty((String)strCounters)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba1\u6570\u6807\u8bc6");
        }
        SRFExAjaxListResult ajaxActionResult = new SRFExAjaxListResult();
        HashMap<String, String> counterMap = new HashMap<String, String>();
        String[] stringArray = counterIds = strCounters.split("[;]");
        int n = counterIds.length;
        int n2 = 0;
        while (n2 < n) {
            String strCounterId = stringArray[n2];
            if (!counterMap.containsKey(strCounterId)) {
                counterMap.put(strCounterId, "");
                DAActionContext iDAActionContext = new DAActionContext((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (ISRFDAWebContext)this.getWebContext(), null);
                ICounterHelper iCounterHelper = this.getDAModelStorage().FindCounter(strCounterId);
                CounterResult result = iCounterHelper.Calc((IDAActionContext)iDAActionContext);
                JSONObject jo = new JSONObject();
                jo.put("id", (Object)strCounterId);
                jo.put("cnt", result.getCount());
                for (String strKey : result.getExtCountMap().keySet()) {
                    jo.put(strKey.toLowerCase(), result.getExtCountMap().get(strKey));
                }
                ajaxActionResult.getItems().add(jo);
            }
            ++n2;
        }
        return ajaxActionResult;
    }
}

