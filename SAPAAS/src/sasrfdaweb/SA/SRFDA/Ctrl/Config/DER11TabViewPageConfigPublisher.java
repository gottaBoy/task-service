/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDER11Helper
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
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDER11Helper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;

public class DER11TabViewPageConfigPublisher
extends BaseTabViewPageConfigPublisher {
    @Override
    protected void OnFillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        super.OnFillTabViewPageNode(iPublishContext, tabViewPageNode);
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        IDER11Helper iDER11Helper = null;
        Object objParam = iPublishContext.getParam();
        if (objParam instanceof IDER11Helper) {
            iDER11Helper = (IDER11Helper)objParam;
        } else if (objParam instanceof IDERGroupDetailHelper) {
            IDERGroupDetailHelper iDERGroupDetailHelper = (IDERGroupDetailHelper)objParam;
            if (StringHelper.Compare((String)iDERGroupDetailHelper.getDetailType(), (String)"DER11", (boolean)true) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5206\u7ec4\u660e\u7ec6\u7c7b\u578b[%1$s]\u4e0d\u6b63\u786e", (Object)iDERGroupDetailHelper.getDetailType()));
            }
            String strDER11Id = iDERGroupDetailHelper.getDER11Id();
            iDER11Helper = iDEHelper.FindDER11(strDER11Id);
        }
        if (iDER11Helper == null) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
        }
        iPublishContext.setAttribute("DER11", iDER11Helper);
        tabViewPageNode.setID(iDER11Helper.getId());
        tabViewPageNode.SetValue("CAPTION", iDER11Helper.getShowName());
        IDEHelper iMinorDEHelper = this.getPublisherContext().getDAModelStorage().FindDEHelper2(iDER11Helper.getMinorDEId());
        if (StringHelper.IsNullOrEmpty((String)iDER11Helper.getSmallIcon())) {
            tabViewPageNode.SetValue("ICON", iMinorDEHelper.getDataEntity().getSMALLICON());
        } else {
            tabViewPageNode.SetValue("ICON", iDER11Helper.getSmallIcon());
        }
        String strRemoteURL = StringHelper.Format((String)"../srfpage/ifformview.jsp?SRFPDEID=%1$s&SRFDEID=%2$s&SRFDERID=%3$s&SRFCAPTION=%4$s", (Object)iDER11Helper.getMajorDEId(), (Object)iDER11Helper.getMinorDEId(), (Object)iDER11Helper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)iDER11Helper.getShowName()));
        String strEditPageId = iDER11Helper.getEditPageId();
        if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
            IPageHelper iPageHelper = this.getPublisherContext().getDAModelStorage().FindPage2(strEditPageId);
            strRemoteURL = URLHelper.AppendURLSeperator((String)strRemoteURL);
            strRemoteURL = String.valueOf(strRemoteURL) + StringHelper.Format((String)"REALURL=%1$s&", (Object)SRFExWebContext.EncodeURLParamValue((String)iPageHelper.getFullPagePath()));
        }
        tabViewPageNode.SetValue("REMOTEURL", strRemoteURL);
        tabViewPageNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
        tabViewPageNode.SetValue("RESOURCEID", UniResHelper.GetDEDataResId((String)iDER11Helper.getMinorDEId()));
    }

    @Override
    protected void OnAddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode, String strGroupId, int nOrder) throws Exception {
        IDER11Helper iDER11Helper = (IDER11Helper)iPublishContext.getAttribute("DER11");
        if (!StringHelper.IsNullOrEmpty((String)iDER11Helper.getDERTypeId())) {
            this.RegisterDERTypeGroup(iPublishContext, iDER11Helper.getDERTypeId());
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, iDER11Helper.getDERTypeId(), iDER11Helper.getShowOrder());
        } else {
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, strGroupId, iDER11Helper.getShowOrder());
        }
    }
}

