/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseTabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.XML.XMLNode;

public class TabViewPageConfigPublisher
extends BaseTabViewPageConfigPublisher {
    public static final String PARAM_CAPTION = "CAPTION";
    public static final String PARAM_CAPLANRESID = "CAPLANRESID";
    public static final String PARAM_ICON = "ICON";
    public static final String PARAM_RESOURCEID = "RESOURCEID";
    public static final String PARAM_REMOTEURL = "REMOTEURL";
    public static final String PARAM_DERGROUPFOLDERID = "DERGROUPFOLDERID";
    public static final String PARAM_SHOWORDER = "SHOWORDER";

    @Override
    protected void OnFillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        super.OnFillTabViewPageNode(iPublishContext, tabViewPageNode);
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        String strCaption = this.getParam(PARAM_CAPTION, "");
        String strCapLanResId = this.getParam(PARAM_CAPLANRESID, "");
        String strIcon = this.getParam(PARAM_ICON, "");
        String strResourceId = this.getParam(PARAM_RESOURCEID, "NONE");
        String strRemoteUrl = this.getParam(PARAM_REMOTEURL, "");
        strCaption = this.getPublisherContext().GetLocalization(iDEHelper, strCapLanResId, strCaption);
        tabViewPageNode.SetValue(PARAM_CAPTION, strCaption);
        String strRemoteURL = StringHelper.Format((String)strRemoteUrl, (Object)iDEHelper.getId(), (Object)SRFExWebContext.EncodeURLParamValue((String)strCaption));
        strResourceId = StringHelper.Format((String)strRemoteUrl, (Object)iDEHelper.getId());
        tabViewPageNode.SetValue(PARAM_REMOTEURL, strRemoteURL);
        tabViewPageNode.SetValue("APPENDPARAMSEX", String.valueOf(SRFDAWebContext.getDAParams()) + "|" + iDEHelper.GetKeyDEFHelper().getName());
        tabViewPageNode.SetValue(PARAM_ICON, strIcon);
        tabViewPageNode.SetValue(PARAM_RESOURCEID, strResourceId);
    }

    @Override
    protected void OnAddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode, String strGroupId, int nOrder) throws Exception {
        String strDERGroupFolderId = this.getParam(PARAM_DERGROUPFOLDERID, "");
        int nShowOrder = this.getParam(PARAM_SHOWORDER, 1000);
        if (!StringHelper.IsNullOrEmpty((String)strDERGroupFolderId)) {
            this.RegisterDERGroupFolder(iPublishContext, strDERGroupFolderId);
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, strDERGroupFolderId, nShowOrder);
        } else {
            super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, strGroupId, nShowOrder);
        }
    }
}

