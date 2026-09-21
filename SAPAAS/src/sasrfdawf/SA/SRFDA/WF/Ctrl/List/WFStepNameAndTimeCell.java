/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.BaseListCell
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.List;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.BaseListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFStepNameAndTimeCell
extends BaseListCell {
    private static final Log log = LogFactory.getLog(WFStepNameAndTimeCell.class);

    public String GetValue(IDEHelper iHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        String strPageModel = SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext);
        String strValue = super.GetValue(iHelper, webContext, globalContext, dr, listColumnConfig);
        try {
            String stepName = dr.Get("WFPLOGICNAME").toString();
            String strTime = "";
            Timestamp ti = DateParser.GetTimestampValue((Object)dr.Get("CREATEDATE"));
            long nSend = new Date().getTime() - ti.getTime();
            String strColor = "green";
            if ((nSend /= 1000L) < 60L) {
                strTime = StringHelper.Format((String)webContext.GetLocalization("OTHER.LIST.MYWF.PERIOD.NOW", "", "\u521a\u521a"));
            } else if (nSend < 3600L) {
                strTime = StringHelper.Format((String)webContext.GetLocalization("OTHER.LIST.MYWF.PERIOD.MINUTES", "", "%1$s\u5206\u949f\u524d"), (Object)(nSend / 60L));
            } else if (nSend < 86400L) {
                strTime = StringHelper.Format((String)webContext.GetLocalization("OTHER.LIST.MYWF.PERIOD.HOURS", "", "%1$s\u5c0f\u65f6\u524d"), (Object)(nSend / 3600L));
            } else {
                strTime = StringHelper.Format((String)webContext.GetLocalization("OTHER.LIST.MYWF.PERIOD.DAYS", "", "%1$s\u5929\u524d"), (Object)(nSend / 86400L));
                if (nSend / 86400L >= 3L) {
                    strColor = "red";
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                return StringHelper.Format((String)"%1$s<BR>[<span style='color:%3$s;'>%2$s</span>]", (Object)stepName, (Object)strTime, (Object)strColor);
            }
            JSONObject jo = new JSONObject();
            jo.put("stepname", (Object)stepName);
            jo.put("time", (Object)strTime);
            jo.put("color", (Object)strColor);
            return jo.toString();
        }
        catch (Exception exception) {
            return strValue;
        }
    }
}

