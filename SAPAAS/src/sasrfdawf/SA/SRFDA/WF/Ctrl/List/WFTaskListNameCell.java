/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.BaseListCell
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.List;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.BaseListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Properties;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFTaskListNameCell
extends BaseListCell {
    private static final Log log = LogFactory.getLog(WFTaskListNameCell.class);

    public String GetValue(IDEHelper iHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        String strValue = super.GetValue(iHelper, webContext, globalContext, dr, listColumnConfig);
        String strPageModel = SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext);
        try {
            String strWFId = dr.Get("WFWORKFLOWID").toString();
            String strDEId = dr.Get("USERDATA4").toString();
            String strStepName = dr.Get("WFSTEPNAME").toString();
            IDEHelper wfDEHelper = globalContext.getDAModelStorage().FindDEHelper(strDEId);
            String strSectorName = StringHelper.Format((String)"SRFDA.WFFUNCLINK.%1$s_%2$s", (Object)strWFId, (Object)strDEId);
            String strLink = globalContext.getWebExConfig().GetValue(strSectorName, "LINK", "");
            if (wfDEHelper != null) {
                strValue = PropertiesHelper.GetProperty((Properties)wfDEHelper.GetDEWF().getShortcutLinkParams(), (String)"WFNAME", (String)strValue);
            }
            strValue = globalContext.getWebExConfig().GetValue(strSectorName, "TEXT", strValue);
            if (StringHelper.IsNullOrEmpty((String)strLink)) {
                String strText;
                String strSRCParam;
                if (wfDEHelper == null) {
                    return strValue;
                }
                String strSRC = PropertiesHelper.GetProperty((Properties)wfDEHelper.GetDEWF().getShortcutLinkParams(), (String)"SRC");
                if (StringHelper.IsNullOrEmpty((String)strSRC)) {
                    String strPageId = wfDEHelper.GetDEWF().getWFGRIDPAGEID();
                    if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                        Page page = globalContext.getDAModelStorage().FindPage(strPageId);
                        if (page == null) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5185\u7f6e\u9875\u9762[%1$s]", (Object)strPageId));
                            return strValue;
                        }
                        strSRC = page.GetTotalPagePath();
                        strSRC = URLHelper.AppendURLSeperator((String)strSRC);
                        strSRC = String.valueOf(strSRC) + "SRFDEID=" + wfDEHelper.getId();
                    } else {
                        return strValue;
                    }
                }
                if (StringHelper.IsNullOrEmpty((String)(strSRCParam = PropertiesHelper.GetProperty((Properties)wfDEHelper.GetDEWF().getShortcutLinkParams(), (String)"SRCPARAM")))) {
                    strSRCParam = "SRFAF=MYWFWORK:%1$s";
                }
                if (StringHelper.IsNullOrEmpty((String)(strText = PropertiesHelper.GetProperty((Properties)wfDEHelper.GetDEWF().getShortcutLinkParams(), (String)"TEXT")))) {
                    strText = wfDEHelper.getLogicName(webContext.getLocalization());
                }
                if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                    strLink = StringHelper.Format((String)"{text: '%1$s',src: '%2$s&',srcparam:'%3$s&'}", (Object)strText, (Object)strSRC, (Object)strSRCParam);
                } else {
                    JSONObject jo = new JSONObject();
                    jo.put("text", (Object)strText);
                    jo.put("src", (Object)(String.valueOf(strSRC) + "&"));
                    jo.put("srcparam", (Object)(String.valueOf(strSRCParam) + "&"));
                    jo.put("value", (Object)strValue);
                    strLink = jo.toString();
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strLink)) {
                return strValue;
            }
            strLink = StringHelper.Format((String)strLink, (Object)strStepName);
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                return StringHelper.Format((String)"<A HREF='#' onclick=\"parent.$g(%1$s)\" alt='\u70b9\u51fb\u8fdb\u5165'><SPAN class='sx-normaltext'>%2$s</SPAN></A>", (Object)strLink, (Object)strValue);
            }
            return strLink;
        }
        catch (Exception exception) {
            return strValue;
        }
    }
}

