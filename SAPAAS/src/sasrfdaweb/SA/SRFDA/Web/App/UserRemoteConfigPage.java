/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEDataImport
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResultEx
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.App;

import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResultEx;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class UserRemoteConfigPage
extends SRFDAPage {
    public static final String TAG_FOLDER_DER1N = "DER1N";
    public static final String TAG_FOLDER_DATAIMPORT = "DATAIMPORT";
    public static final String TAG_FOLDER_USERMODE = "USERMODE";

    public UserRemoteConfigPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoad() {
        String strFolder = this.getWebContext().GetParamValue("FOLDER");
        String strItem = this.getWebContext().GetParamValue("ITEM");
        String strItem2 = this.getWebContext().GetParamValue("ITEM2");
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DER1N, (boolean)true) == 0) {
            SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
            String strDERId = strItem;
            DER1N der1n = new DER1N();
            der1n.setDERID(strDERId);
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDER1N(strDERId, der1n);
            if (callResult.IsError()) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d61\uff1aN\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERId, (Object)callResult.getErrorInfo()));
                this.PageLog((Object)this, 1, actionResult.getErrorInfo());
                this.Output(actionResult.ToJSONString());
                return;
            }
            String strDefaultPage = "../srfpage/gridview.jsp?";
            String strPageId = der1n.getRELATEDPAGEID();
            if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                IDEHelper iMinorDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                if (iMinorDEHelper == null) {
                    actionResult.setRetCode(1);
                    actionResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                    this.PageLog((Object)this, 1, actionResult.getErrorInfo());
                    this.Output(actionResult.ToJSONString());
                    return;
                }
                strPageId = iMinorDEHelper.GetGridPageId();
            }
            if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                Page relatedPage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strPageId);
                if (relatedPage == null) {
                    actionResult.setRetCode(1);
                    actionResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                    this.PageLog((Object)this, 1, actionResult.getErrorInfo());
                    this.Output(actionResult.ToJSONString());
                    return;
                }
                strDefaultPage = relatedPage.GetTotalPagePath();
            }
            TreeMap<String, String> urlParams = new TreeMap<String, String>();
            urlParams.put("SRFPDEID", der1n.getMAJORDEID());
            urlParams.put("SRFDEID", der1n.getMINORDEID());
            urlParams.put("SRFDERID", der1n.getDERID());
            urlParams.put("SRFCAPTION", this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLanguage(), der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
            strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
            strDefaultPage = String.valueOf(strDefaultPage) + URLHelper.GetQueryString(urlParams);
            actionResult.getItemObject().put("derurl", (Object)strDefaultPage);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DATAIMPORT, (boolean)true) == 0) {
            SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
            String strDEId = strItem;
            String strDataImport = strItem2;
            String strImportUrl = "../srfpage/uploaddedataexcelview.jsp";
            boolean bDefault = true;
            if (StringHelper.IsNullOrEmpty((String)strDataImport)) {
                strDataImport = "DEFAULT";
                bDefault = true;
            }
            if (!StringHelper.IsNullOrEmpty((String)strDataImport)) {
                IDEHelper deHelper = this.getDAModelStorage().FindDEHelper(strDEId);
                if (deHelper == null) {
                    if (!bDefault) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u9875\u9762\u6307\u5b9a\u4e86\u6570\u636e\u5bfc\u5165\u6a21\u5f0f\uff0c\u4f46\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548"));
                    }
                } else {
                    DEDataImport dataImport = deHelper.GetDataImport(strDataImport);
                    if (dataImport == null) {
                        if (!bDefault) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", (Object)strDEId, (Object)strDataImport));
                        }
                    } else {
                        if (!StringHelper.IsNullOrEmpty((String)dataImport.getIMPORTVIEW())) {
                            strImportUrl = dataImport.getIMPORTVIEW();
                        }
                        strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
                        strImportUrl = String.valueOf(strImportUrl) + StringHelper.Format((String)"SRFDEDATAIMPORT=%1$s", (Object)strDataImport);
                    }
                }
            }
            strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
            actionResult.getItemObject().put("importurl", (Object)strImportUrl);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_USERMODE, (boolean)true) == 0) {
            SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
            this.getWebContext().setCurUserMode(strItem);
            this.Output(actionResult.ToJSONString());
            return;
        }
    }
}

