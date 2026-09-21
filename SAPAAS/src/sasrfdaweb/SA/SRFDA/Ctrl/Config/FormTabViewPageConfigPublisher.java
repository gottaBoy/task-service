/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseTabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;

public class FormTabViewPageConfigPublisher
extends BaseTabViewPageConfigPublisher {
    @Override
    protected void OnFillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        super.OnFillTabViewPageNode(iPublishContext, tabViewPageNode);
        BaseDataEntity formParam = null;
        Object objParam = iPublishContext.getParam();
        if (objParam instanceof BaseDataEntity) {
            formParam = (BaseDataEntity)objParam;
        }
        if (formParam == null) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
        }
        String strFormName = "";
        String strFormPageId = "";
        String strFormState = "";
        strFormName = formParam.GetParamStringValue("FORMNAME", strFormName);
        strFormPageId = formParam.GetParamStringValue("FORMPAGEID", strFormPageId);
        strFormState = formParam.GetParamStringValue("FORMSTATE", strFormState);
        tabViewPageNode.setID("EDIT");
        tabViewPageNode.SetValue("CAPTION", iPublishContext.getDEHelper().getLogicName(this.getPublisherContext().getLanguage()));
        String strFormPagePath = "";
        if (!StringHelper.IsNullOrEmpty((String)strFormPageId)) {
            IPageHelper iPageHelper = this.iTabViewConfigPublisherContext.getDAModelStorage().FindPage2(strFormPageId);
            strFormPagePath = iPageHelper.getFullPagePath();
            strFormPagePath = URLHelper.AppendURLSeperator((String)strFormPagePath);
        }
        if (StringHelper.IsNullOrEmpty((String)strFormPagePath)) {
            strFormPagePath = this.getDefaultPagePath(iPublishContext);
        }
        String strEditURL = StringHelper.Format((String)"%3$sSRFMAINFORM=TRUE&SRFDEID=%1$s&SRFFORMVIEW=%2$s", (Object)iPublishContext.getDEHelper().getId(), (Object)strFormName, (Object)strFormPagePath);
        if (!StringHelper.IsNullOrEmpty((String)strFormState)) {
            strEditURL = URLHelper.AppendURLSeperator((String)strEditURL);
            strEditURL = String.valueOf(strEditURL) + StringHelper.Format((String)"SRFFORMSTATE=%1$s", (Object)strFormState);
        }
        tabViewPageNode.SetValue("REMOTEURL", strEditURL);
        tabViewPageNode.SetValue("APPENDPARAMS", "SRFPDEID|SRFDERID|SRFDEMAINSTATE|SRFDEMAINACTION|SRFFORMDIGEST");
        tabViewPageNode.SetValue("APPENDPARAMSEX", SRFDAWebContext.getDAParams());
        tabViewPageNode.SetValue("RESOURCEID", "NONE");
    }

    @Override
    protected void OnAddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode, String strGroupId, int nOrder) throws Exception {
        super.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, strGroupId, nOrder);
    }

    protected String getDefaultPagePath(ITabViewPageConfigPublishContext iPublishContext) {
        return "../srfpage/formview.jsp?";
    }
}

