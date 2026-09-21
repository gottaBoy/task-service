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
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFStepActorReminderCell
extends BaseListCell {
    private static final Log log = LogFactory.getLog(WFStepActorReminderCell.class);

    public String GetValue(IDEHelper iHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        String strValue = super.GetValue(iHelper, webContext, globalContext, dr, listColumnConfig);
        String strPageModel = SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext);
        try {
            String strURL = "../srfpage/simpleeditview.jsp?SRFPAGEID=PAGE_WF0015_E001&";
            strURL = String.valueOf(strURL) + "WFSTEPACTORID=" + dr.Get("WFSTEPACTORID").toString();
            String strScript = StringHelper.Format((String)"$U.SMD('%1$s',window,'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0',800,600);", (Object)strURL);
            String strContainer = webContext.GetParamValue("CONTAINERID");
            if (!StringHelper.IsNullOrEmpty((String)strContainer)) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.remotepanel['%1$s'].refresh();", (Object)strContainer);
            }
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                String strRemind = webContext.GetLocalization("OTHER.LIST.MYWF.COL.COUNT.REMIND", "", "\u50ac\u529e");
                String strRemindTips = webContext.GetLocalization("OTHER.LIST.MYWF.COL.COUNT.REMINDTIPS", "", "\u70b9\u51fb\u50ac\u529e");
                return StringHelper.Format((String)"<A HREF=\"javascript:%1$s void 0;\" alt='%4$s'><SPAN class='sx-normaltext'>%2$s</SPAN><SPAN class='sx-normaltext-blue'>[%3$s]</span></A>", (Object)strScript, (Object)strValue, (Object)strRemind, (Object)strRemindTips);
            }
            JSONObject jo = new JSONObject();
            jo.put("value", (Object)strValue);
            jo.put("src", (Object)strURL);
            return jo.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return strValue;
        }
    }
}

