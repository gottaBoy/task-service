/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.DP.IDPUserItem
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPRawItemConfig
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDADPIFrame;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.DP.IDPUserItem;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPRawItemConfig;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Properties;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDADPIframeItem
implements IDPUserItem {
    private static final Log log = LogFactory.getLog(SRFDADPIframeItem.class);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SRFExControl CreateControl(SRFExDPEx dpEx, DPRawItemConfig dpRawItemConfig) {
        try {
            SRFDAPage page = (SRFDAPage)dpEx.getPage();
            SRFDADPIFrame iFrame = new SRFDADPIFrame();
            iFrame.InitConfig();
            String strControlId = dpRawItemConfig.getID();
            if (StringHelper.IsNullOrEmpty((String)strControlId)) {
                strControlId = Helper.GenGuid();
            }
            iFrame.getIFrameConfig().setID(strControlId);
            Properties properties = PropertiesHelper.Load((String)dpRawItemConfig.getContent());
            String strWidth = PropertiesHelper.GetProperty((Properties)properties, (String)"WIDTH", (String)"1");
            iFrame.getIFrameConfig().setWidthEx(Double.parseDouble(strWidth));
            String strHeight = PropertiesHelper.GetProperty((Properties)properties, (String)"HEIGHT", (String)"300");
            iFrame.getIFrameConfig().setHeightEx(Double.parseDouble(strHeight));
            String strBorder = PropertiesHelper.GetProperty((Properties)properties, (String)"FRAMEBORDER", (String)"0");
            iFrame.getIFrameConfig().setFrameBorder(Integer.parseInt(strBorder));
            String strScroll = PropertiesHelper.GetProperty((Properties)properties, (String)"SCROLL", (String)"no");
            iFrame.getIFrameConfig().setScroll(strScroll);
            String strFrameAlias = PropertiesHelper.GetProperty((Properties)properties, (String)"FRAMEALIAS", (String)"");
            iFrame.getIFrameConfig().setFrameAlias(strFrameAlias);
            String strFormItem = PropertiesHelper.GetProperty((Properties)properties, (String)"FORMITEM", (String)"");
            if (StringHelper.IsNullOrEmpty((String)strFormItem) && page.getDEHelper() != null) {
                strFormItem = page.getDEHelper().GetKeyDEFHelper().getName();
            }
            iFrame.getIFrameConfig().SetValue("FORMITEM", strFormItem);
            String strIFMode = PropertiesHelper.GetProperty((Properties)properties, (String)"IFMODE", (String)"NORMAL");
            iFrame.getIFrameConfig().SetValue("IFMODE", strIFMode);
            if (StringHelper.Compare((String)strIFMode, (String)"NORMAL", (boolean)true) == 0) {
                String strHref = PropertiesHelper.GetProperty((Properties)properties, (String)"SRC", (String)"");
                strHref = URLHelper.AppendURLSeperator((String)strHref);
                iFrame.getIFrameConfig().setURL(strHref);
            }
            if (StringHelper.Compare((String)strIFMode, (String)"DER1N", (boolean)true) == 0) {
                String strDERId = PropertiesHelper.GetProperty((Properties)properties, (String)"DERID", (String)"");
                if (StringHelper.IsNullOrEmpty((String)strDERId)) {
                    log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u76841\uff1aN\u5173\u7cfb");
                    return null;
                }
                DER1N der1n = new DER1N();
                der1n.setDERID(strDERId);
                CallResult callResult = page.getWebContext().getGlobalHelper().getDAModelHelper().GetDER1N(strDERId, der1n);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d61\uff1aN\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERId, (Object)callResult.getErrorInfo()));
                    return null;
                }
                String strDefaultPage = "../srfpage/gridview.jsp?";
                String strPageId = der1n.getRELATEDPAGEID();
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    IDEHelper iMinorDEHelper = page.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                    if (iMinorDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                        return null;
                    }
                    strPageId = iMinorDEHelper.GetGridPageId();
                }
                if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                    Page relatedPage = page.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strPageId);
                    if (relatedPage == null) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strPageId));
                        return null;
                    }
                    strDefaultPage = relatedPage.GetTotalPagePath();
                }
                TreeMap<String, String> urlParams = new TreeMap<String, String>();
                urlParams.put("SRFPDEID", der1n.getMAJORDEID());
                urlParams.put("SRFDEID", der1n.getMINORDEID());
                urlParams.put("SRFDERID", der1n.getDERID());
                urlParams.put("SRFCAPTION", page.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(page.getLanguage(), der1n.getSHOWNAMELANRESID(), der1n.getSHOWNAME1N()));
                strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                strDefaultPage = String.valueOf(strDefaultPage) + URLHelper.GetQueryString(urlParams);
                strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                String strAppendParams = PropertiesHelper.GetProperty((Properties)properties, (String)"APPENDPARAMS", (String)"");
                if (!StringHelper.IsNullOrEmpty((String)strAppendParams)) {
                    strDefaultPage = String.valueOf(strDefaultPage) + strAppendParams;
                    strDefaultPage = URLHelper.AppendURLSeperator((String)strDefaultPage);
                }
                iFrame.getIFrameConfig().setURL(strDefaultPage);
            }
            return iFrame;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

