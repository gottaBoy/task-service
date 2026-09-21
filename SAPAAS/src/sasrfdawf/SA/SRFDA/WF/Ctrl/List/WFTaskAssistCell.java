/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.BaseListCell
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.List;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.BaseListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFTaskAssistCell
extends BaseListCell {
    private static final Log log = LogFactory.getLog(WFTaskAssistCell.class);

    public String GetValue(IDEHelper iHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        String strValue = super.GetValue(iHelper, webContext, globalContext, dr, listColumnConfig);
        String strPageModel = SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext);
        try {
            String strDAParams;
            String strWFStepColumnName;
            String strKeyData = dr.Get("USERDATA").toString();
            String strDEId = dr.Get("USERDATA4").toString();
            String strWFStepActorId = dr.Get("WFSTEPACTORID").toString();
            IDEHelper iRealDEHelper = globalContext.getDAModelStorage().FindDEHelper(strDEId);
            if (iRealDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return strValue;
            }
            DEWF dewf = iRealDEHelper.GetDEWF();
            boolean bShowModal = true;
            int nWidth = 0;
            int nHeight = 0;
            String strURL = "../srfwf/wfinfoview.jsp";
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            String strInfoPageId = iRealDEHelper.GetDEWF().getWFINFOPAGEID();
            if (!StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
                Page editPage = webContext.getGlobalHelper().getDAModelStorage().FindPage(strInfoPageId);
                if (editPage == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strInfoPageId));
                    return strValue;
                }
                if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                    strURL = editPage.GetTotalPagePath();
                }
                if (editPage.getWIDTH() != 0) {
                    nWidth = editPage.getWIDTH();
                }
                if (editPage.getHEIGHT() != 0) {
                    nHeight = editPage.getHEIGHT();
                }
                if (!StringHelper.IsNullOrEmpty((String)editPage.getWINDOWSTYLE())) {
                    strWindowStyle = editPage.getWINDOWSTYLE();
                }
            }
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            TreeMap<String, String> daParams = new TreeMap<String, String>();
            daParams.put("SRFDEID", iRealDEHelper.getId());
            daParams.put(iRealDEHelper.GetKeyDEFHelper().getName(), strKeyData);
            daParams.put("WFSTEPACTORID", strWFStepActorId);
            String strWFStateColumnName = dewf.getWFSTATEDEFID();
            if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
                IDEFHelper iDEFHelper = iRealDEHelper.GetDEFHelper(strWFStateColumnName);
                strWFStateColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
            }
            if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID()))) {
                IDEFHelper iDEFHelper = iRealDEHelper.GetDEFHelper(strWFStepColumnName);
                strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
            }
            BaseDataEntity activeDataEntity = new BaseDataEntity();
            activeDataEntity.SetParamValue(iRealDEHelper.GetKeyDEFHelper().getName(), (Object)strKeyData);
            IDEDataCtrl iRealDataCtrl = iRealDEHelper.GetDEDataCtrl(webContext.getCurUserId(), webContext);
            CallResult callResult = iRealDataCtrl.Get(activeDataEntity);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iRealDEHelper.getId(), (Object)strKeyData, (Object)callResult.getErrorInfo()));
                return strValue;
            }
            if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
                daParams.put("SRFWFSTATE", activeDataEntity.GetParamStringValue(strWFStateColumnName, ""));
            }
            if (!StringHelper.IsNullOrEmpty((String)strWFStepColumnName)) {
                daParams.put("SRFWFSTEP", activeDataEntity.GetParamStringValue(strWFStepColumnName, ""));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            strURL = String.valueOf(strURL) + webContext.GetQueryStringWithoutDAParam(daParams);
            String strScript = BrowserJSHelper.getShowDialogScriptEx((String)("'" + strURL + "'"), (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle);
            String strContainer = webContext.GetParamValue("CONTAINERID");
            if (!StringHelper.IsNullOrEmpty((String)strContainer)) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.remotepanel['%1$s'].refresh();", (Object)strContainer);
            }
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                String strAssist = webContext.GetLocalization("OTHER.LIST.MYWFWORK2.COL.ACTOR.ASSIST", "", "\u4ee3\u529e");
                String strAssistTips = webContext.GetLocalization("OTHER.LIST.MYWFWORK2.COL.ACTOR.ASSISTTIPS", "", "\u70b9\u51fb\u4ee3\u529e");
                return StringHelper.Format((String)"<A HREF='#' onclick=\"%1$s\" alt='%4$s'><SPAN class='sx-normaltext'>%2$s</SPAN><SPAN class='sx-normaltext-blue'>[%3$s]</span></A>", (Object)strScript, (Object)strValue, (Object)strAssist, (Object)strAssistTips);
            }
            JSONObject jo = new JSONObject();
            jo.put("value", (Object)strValue);
            jo.put("src", (Object)strURL);
            return jo.toString();
        }
        catch (Exception exception) {
            return strValue;
        }
    }
}

