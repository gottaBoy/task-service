/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBIReportExActionHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.BI.Ctrl.SRFDABIActionResult;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseBIReportExActionHelper
implements IBIReportExActionHelper {
    public static final String ACTION_EXPORTTABLE = "EXPORTTABLE";
    public static final String ACTION_FETCHTABLE = "FETCHTABLE";
    public static final String ACTION_FETCHCHART = "FETCHCHART";
    protected IBIReportExHelper iReportExHelper;
    protected SRFDAPageEx page = null;
    private static final Log log = LogFactory.getLog(BaseBIReportExActionHelper.class);

    @Override
    public void Process(IBIReportExHelper iReportExHelper, SRFDAPageEx page, String strAction) throws Exception {
        this.iReportExHelper = iReportExHelper;
        this.page = page;
        this.OnBeforeProcess();
        Date dtBegin = new Date();
        this.OnProcess(strAction);
        Date dtEnd = new Date();
        log.debug((Object)StringHelper.Format((String)"BI\u62a5\u8868\u5904\u7406[%1$s]\u8017\u65f6[%2$s]\u6beb\u79d2", (Object)strAction, (Object)(dtEnd.getTime() - dtBegin.getTime())));
    }

    protected void OnBeforeProcess() throws Exception {
    }

    protected void OnProcess(String strAction) throws Exception {
        if (StringHelper.Compare((String)strAction, (String)ACTION_FETCHTABLE, (boolean)true) == 0) {
            SRFDABIActionResult actionResult = this.OnFetchTable();
            this.getPage().Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_EXPORTTABLE, (boolean)true) == 0) {
            SRFDABIActionResult actionResult = this.OnExportTable();
            this.getPage().Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_FETCHCHART, (boolean)true) == 0) {
            SRFDABIActionResult actionResult = this.OnFetchChart();
            this.getPage().Output(actionResult.ToJSONString());
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5904\u7406\u7c7b\u578b[%1$s]", (Object)strAction));
    }

    protected SRFDABIActionResult OnFetchTable() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0[OnFetchTable]\u65b9\u6cd5");
    }

    protected SRFDABIActionResult OnExportTable() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0[OnExportTable]\u65b9\u6cd5");
    }

    protected SRFDABIActionResult OnFetchChart() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0[OnFetchChart]\u65b9\u6cd5");
    }

    protected SRFDAWebContext getWebContext() {
        return this.page.getWebContext();
    }

    protected SRFDAPageEx getPage() {
        return this.page;
    }

    protected IBIReportExHelper getIBIReportEx() {
        return this.iReportExHelper;
    }
}

