/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTPlanResViewActionHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.TMModelStorageFactory;
import SA.TM.Web.TMActionResult;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseTMBTPlanResViewActionHelper
implements ITMBTPlanResViewActionHelper {
    public static final String ACTION_FETCH = "FETCH";
    protected ITMBTPlanHelper iTMBTPlanHelper;
    protected SRFDAPageEx page = null;
    private static final Log log = LogFactory.getLog(BaseTMBTPlanResViewActionHelper.class);

    public void Process(ITMBTPlanHelper iTMBTPlanHelper, SRFDAPageEx page, String strAction) throws Exception {
        this.iTMBTPlanHelper = iTMBTPlanHelper;
        this.page = page;
        this.OnBeforeProcess();
        Date dtBegin = new Date();
        this.OnProcess(strAction);
        Date dtEnd = new Date();
        log.debug((Object)StringHelper.Format((String)"TM \u9884\u7ea6\u8ba1\u5212\u8d44\u6e90\u89c6\u56fe\u5904\u7406[%1$s]\u8017\u65f6[%2$s]\u6beb\u79d2", (Object)strAction, (Object)(dtEnd.getTime() - dtBegin.getTime())));
    }

    protected void OnBeforeProcess() throws Exception {
    }

    protected void OnProcess(String strAction) throws Exception {
        if (StringHelper.Compare((String)strAction, (String)ACTION_FETCH, (boolean)true) == 0) {
            TMActionResult actionResult = this.OnFetch();
            this.getPage().Output(actionResult.ToJSONString());
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5904\u7406\u7c7b\u578b[%1$s]", (Object)strAction));
    }

    protected TMActionResult OnFetch() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0[OnFetch]\u65b9\u6cd5");
    }

    protected SRFDAWebContext getWebContext() {
        return this.page.getWebContext();
    }

    protected SRFDAPageEx getPage() {
        return this.page;
    }

    protected ITMBTPlanHelper getTMBTPlan() {
        return this.iTMBTPlanHelper;
    }

    protected ITMModelStorage getTMModelStorage() throws Exception {
        return TMModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }
}

