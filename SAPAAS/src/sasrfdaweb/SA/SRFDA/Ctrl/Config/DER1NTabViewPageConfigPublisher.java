/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDER1NHelper
 *  SA.SRFDA.Ctrl.IDERGroupDetailHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseTabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDER1NHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import java.util.Vector;

public class DER1NTabViewPageConfigPublisher
extends BaseTabViewPageConfigPublisher {
    @Override
    protected void OnFillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        IDERGroupDetailHelper iDERGroupDetailHelper;
        super.OnFillTabViewPageNode(iPublishContext, tabViewPageNode);
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        IDER1NHelper iDER1NHelper = null;
        Object objParam = iPublishContext.getParam();
        if (objParam instanceof IDER1NHelper) {
            iDER1NHelper = (IDER1NHelper)objParam;
        } else if (objParam instanceof IDERGroupDetailHelper) {
            IDERGroupDetailHelper iDERGroupDetailHelper2 = (IDERGroupDetailHelper)objParam;
            if (StringHelper.Compare((String)iDERGroupDetailHelper2.getDetailType(), (String)"DER1N", (boolean)true) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5206\u7ec4\u660e\u7ec6\u7c7b\u578b[%1$s]\u4e0d\u6b63\u786e", (Object)iDERGroupDetailHelper2.getDetailType()));
            }
            String strDER1NId = iDERGroupDetailHelper2.getDER1NId();
            iDER1NHelper = iDEHelper.FindDER1N2(strDER1NId);
        }
        if (iDER1NHelper == null) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
        }
        iPublishContext.setAttribute("DER1N", iDER1NHelper);
        tabViewPageNode.setID(iDER1NHelper.getId());
        IDEHelper iMinorDEHelper = this.getPublisherContext().getDAModelStorage().FindDEHelper2(iDER1NHelper.getMinorDEId());
        tabViewPageNode.setID(iDER1NHelper.getId());
        if (!StringHelper.IsNullOrEmpty((String)iDER1NHelper.getTabViewbarCond())) {
            tabViewPageNode.SetValue("TABVIEWBARCOND", iDER1NHelper.getTabViewbarCond());
        }
        String strCaption = this.getPublisherContext().GetLocalization(iDEHelper, iDER1NHelper.getShowNameLanResId(), iDER1NHelper.getShowName1N());
        tabViewPageNode.SetValue("CAPTION", strCaption);
        String strResourceId = UniResHelper.GetDEDataResId((String)iDER1NHelper.getMinorDEId());
        String strDefaultPage = "../srfpage/ifgridview.jsp?";
        String strPageId = iDER1NHelper.getRelatedPageId();
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            IPageHelper iPageHelper = this.getPublisherContext().getDAModelStorage().FindPage2(strPageId);
            strDefaultPage = String.valueOf(strDefaultPage) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)iPageHelper.getFullPagePath()));
            strResourceId = iPageHelper.getResourceId(iDER1NHelper.getMinorDEId());
        }
        TreeMap<String, String> urlParams = new TreeMap<String, String>();
        urlParams.put("SRFPDEID", iDER1NHelper.getMajorDEId());
        urlParams.put("SRFDEID", iDER1NHelper.getMinorDEId());
        urlParams.put("SRFDERID", iDER1NHelper.getId());
        urlParams.put("SRFCAPTION", strCaption);
        if (StringHelper.Compare((String)iDEHelper.getId(), (String)iDER1NHelper.getMajorDEId(), (boolean)true) != 0) {
            Vector derIndexs = iDEHelper.GetDERINDEXs(false);
            for (DERINDEX derINDEX : derIndexs) {
                if (StringHelper.Compare((String)derINDEX.getINDEXDEID(), (String)iDER1NHelper.getMajorDEId(), (boolean)true) != 0) continue;
                urlParams.put("SRFDERINDEXID", derINDEX.getDERINDEXID());
                break;
            }
        }
        if ((iDER1NHelper.getDERSubType() & 0x10) != 0) {
            urlParams.put("SRFINFOMODE", "TRUE");
        }
        if ((iDER1NHelper.getDERSubType() & 0x20) != 0) {
            urlParams.put("SRFFEWDATAMODE", "TRUE");
        }
        tabViewPageNode.SetValue("REMOTEURL", StringHelper.Format((String)"%1$s%2$s", (Object)strDefaultPage, (Object)URLHelper.GetQueryString(urlParams)));
        tabViewPageNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)iDER1NHelper.getSmallIcon())) {
            tabViewPageNode.SetValue("ICON", iMinorDEHelper.getDataEntity().getSMALLICON());
        } else {
            tabViewPageNode.SetValue("ICON", iDER1NHelper.getSmallIcon());
        }
        if (objParam instanceof IDERGroupDetailHelper && !StringHelper.IsNullOrEmpty((String)(iDERGroupDetailHelper = (IDERGroupDetailHelper)objParam).getResourceId())) {
            strResourceId = iDERGroupDetailHelper.getResourceId();
        }
        tabViewPageNode.SetValue("RESOURCEID", strResourceId);
    }

    @Override
    protected void OnAddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode, String strGroupId, int nOrder) throws Exception {
        IDER1NHelper iDER1NHelper = (IDER1NHelper)iPublishContext.getAttribute("DER1N");
        if (!StringHelper.IsNullOrEmpty((String)iDER1NHelper.getDERTypeId())) {
            this.RegisterDERTypeGroup(iPublishContext, iDER1NHelper.getDERTypeId());
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, iDER1NHelper.getDERTypeId(), iDER1NHelper.getShowOrder());
        } else {
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, strGroupId, iDER1NHelper.getShowOrder());
        }
    }
}

