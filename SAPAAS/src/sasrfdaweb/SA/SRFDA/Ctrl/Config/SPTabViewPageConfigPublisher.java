/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Ctrl.ISummaryPageHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseTabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.ISummaryPageHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;

public class SPTabViewPageConfigPublisher
extends BaseTabViewPageConfigPublisher {
    @Override
    protected void OnFillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        super.OnFillTabViewPageNode(iPublishContext, tabViewPageNode);
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        ISummaryPageHelper iSummaryPageHelper = null;
        Object objParam = iPublishContext.getParam();
        if (objParam instanceof ISummaryPageHelper) {
            iSummaryPageHelper = (ISummaryPageHelper)objParam;
        }
        if (iSummaryPageHelper == null) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
        }
        iPublishContext.setAttribute("SUMMARYPAGE", iSummaryPageHelper);
        tabViewPageNode.setID(iSummaryPageHelper.getId());
        String strCaption = this.getPublisherContext().GetLocalization(iDEHelper, iSummaryPageHelper.getNameLanResId(), iSummaryPageHelper.getName());
        tabViewPageNode.SetValue("CAPTION", strCaption);
        String strDefaultPage = "../srfpage/ifgridview.jsp?";
        String strPageId = iSummaryPageHelper.getPageId();
        String strResourceId = "NONE";
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            IPageHelper relatedPage = this.getPublisherContext().getDAModelStorage().FindPage2(strPageId);
            String strPageURL = relatedPage.getFullPagePath();
            if (!StringHelper.IsNullOrEmpty((String)relatedPage.getAppendParam())) {
                strPageURL = URLHelper.AppendURLSeperator((String)strPageURL);
                strPageURL = String.valueOf(strPageURL) + relatedPage.getAppendParam();
                strPageURL = URLHelper.AppendURLSeperator((String)strPageURL);
            }
            strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)strPageURL));
            strResourceId = relatedPage.getResourceId(iDEHelper.getId());
        }
        String strRemoteURL = StringHelper.Format((String)"%1$sSRFPDEID=%2$s&SRFCAPTION=%3$s", (Object)strDefaultPage, (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)strCaption));
        tabViewPageNode.SetValue("REMOTEURL", strRemoteURL);
        tabViewPageNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
        tabViewPageNode.SetValue("ICON", iSummaryPageHelper.getSmallIcon());
        tabViewPageNode.SetValue("RESOURCEID", strResourceId);
    }

    @Override
    protected void OnAddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode, String strGroupId, int nOrder) throws Exception {
        ISummaryPageHelper iSummaryPageHelper = (ISummaryPageHelper)iPublishContext.getAttribute("SUMMARYPAGE");
        if (!StringHelper.IsNullOrEmpty((String)iSummaryPageHelper.getDERTypeId())) {
            this.RegisterDERTypeGroup(iPublishContext, iSummaryPageHelper.getDERTypeId());
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, iSummaryPageHelper.getDERTypeId(), iSummaryPageHelper.getDERShowOrder());
        } else {
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, strGroupId, iSummaryPageHelper.getDERShowOrder());
        }
    }
}

