/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDERGroupFolderHelper
 *  SA.SRFDA.Ctrl.IDERTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.ITabViewConfigPublisherContext;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublisher;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Ctrl.IDERTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Properties;

public abstract class BaseTabViewPageConfigPublisher
implements ITabViewPageConfigPublisher {
    protected ITabViewConfigPublisherContext iTabViewConfigPublisherContext = null;
    protected Properties param = null;

    @Override
    public void Init(ITabViewConfigPublisherContext iTabViewConfigPublisherContext) {
        this.iTabViewConfigPublisherContext = iTabViewConfigPublisherContext;
    }

    protected ITabViewConfigPublisherContext getPublisherContext() {
        return this.iTabViewConfigPublisherContext;
    }

    @Override
    public void Publish(ITabViewPageConfigPublishContext iPublishContext) throws Exception {
        this.OnPublish(iPublishContext);
    }

    protected void OnPublish(ITabViewPageConfigPublishContext iPublishContext) throws Exception {
        XMLNode tabViewPageNode = new XMLNode();
        tabViewPageNode.setNodeName("SRFEXTABVIEWPAGE");
        this.FillTabViewPageNode(iPublishContext, tabViewPageNode);
        this.AddTabViewPageNode(iPublishContext, tabViewPageNode);
    }

    protected void FillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        this.OnFillTabViewPageNode(iPublishContext, tabViewPageNode);
        if (!StringHelper.IsNullOrEmpty((String)iPublishContext.getTabViewPageId())) {
            tabViewPageNode.setID(iPublishContext.getTabViewPageId());
        }
        if (!StringHelper.IsNullOrEmpty((String)iPublishContext.getCaption())) {
            tabViewPageNode.SetValue("CAPTION", iPublishContext.getCaption());
        }
    }

    protected void OnFillTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
    }

    protected void AddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode) throws Exception {
        this.OnAddTabViewPageNode(iPublishContext, tabViewPageNode, iPublishContext.getGroupId(), 100);
    }

    protected void OnAddTabViewPageNode(ITabViewPageConfigPublishContext iPublishContext, XMLNode tabViewPageNode, String strGroupId, int nOrder) throws Exception {
        iPublishContext.AddTabViewPageNode(tabViewPageNode, strGroupId, nOrder);
    }

    protected void RegisterDERTypeGroup(ITabViewPageConfigPublishContext iPublishContext, String strDERTypeId) throws Exception {
        IDERTypeHelper iDERTypeHelper = this.getPublisherContext().getDAModelStorage().FindDERType(strDERTypeId);
        String strGroupName = this.getPublisherContext().GetLocalization(iPublishContext.getDEHelper(), iDERTypeHelper.getDERTypeNameLanResId(), iDERTypeHelper.getName());
        XMLNode xmlNode = new XMLNode();
        xmlNode.SetValue("GROUP", strGroupName);
        xmlNode.SetValue("GROUPICON", iDERTypeHelper.getSmallIcon());
        xmlNode.SetValue("ISCOLLAPSE", iDERTypeHelper.isCollapse() ? "TRUE" : "FALSE");
        iPublishContext.RegisterTabViewPageGroup(iDERTypeHelper.getId(), xmlNode, iDERTypeHelper.getOrderFlag());
    }

    protected void RegisterDERGroupFolder(ITabViewPageConfigPublishContext iPublishContext, String strDERGroupFolderId) throws Exception {
        IDERGroupFolderHelper iDERGroupFolderHelper = this.getPublisherContext().getDAModelStorage().FindDERGroupFolder(strDERGroupFolderId);
        String strGroupName = iDERGroupFolderHelper.getName();
        XMLNode xmlNode = new XMLNode();
        xmlNode.SetValue("GROUP", strGroupName);
        xmlNode.SetValue("GROUPICON", iDERGroupFolderHelper.getSmallIcon());
        xmlNode.SetValue("ISCOLLAPSE", iDERGroupFolderHelper.isCollapse() ? "TRUE" : "FALSE");
        iPublishContext.RegisterTabViewPageGroup(iDERGroupFolderHelper.getId(), xmlNode, iDERGroupFolderHelper.getShowOrder());
    }

    @Override
    public void setParams(Properties properties) {
        this.param = properties;
    }

    protected String getParam(String strKey, String strDefault) {
        return PropertiesHelper.GetProperty((Properties)this.param, (String)strKey, (String)strDefault);
    }

    protected int getParam(String strKey, int nDefault) {
        return PropertiesHelper.GetProperty((Properties)this.param, (String)strKey, (int)nDefault);
    }
}

