/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DevImage
 *  SA.SRFDA.Ctrl.Data.DevImgDetail
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DevImage;
import SA.SRFDA.Ctrl.Data.DevImgDetail;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.XML.XMLNode;

public abstract class BaseToolbarItemWriter
implements IToolbarItemWriter {
    protected ToolbarItemWriterConfig toolbarWriterConfig = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;

    public CallResult Init(ToolbarItemWriterConfig toolbarWriterConfig, ISRFDAGlobalHelper globalHelperEx) {
        this.toolbarWriterConfig = toolbarWriterConfig;
        this.globalHelperEx = globalHelperEx;
        return new CallResult();
    }

    protected String GetItemCaption(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig, String strDefault) {
        String strCapLanResId = tbItemConfig.getCapLanResId();
        if (!StringHelper.IsNullOrEmpty((String)strCapLanResId)) {
            return this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), strCapLanResId, tbItemConfig.getCaption());
        }
        if (deBehavior != null) {
            if (!StringHelper.IsNullOrEmpty((String)deBehavior.getCAPLANRESID())) {
                return this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), deBehavior.getCAPLANRESID(), deBehavior.getCAPTION());
            }
            return deBehavior.getCAPTION();
        }
        return tbItemConfig.getCaption();
    }

    protected String GetItemToolTip(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig, String strDefault) {
        if (deBehavior != null) {
            if (!StringHelper.IsNullOrEmpty((String)deBehavior.getTIPLANRESID())) {
                return this.globalHelperEx.getLocalizationHelper().GetLocalization(context.getLanguage(), deBehavior.getTIPLANRESID(), deBehavior.getTOOLTIP());
            }
            return deBehavior.getTOOLTIP();
        }
        return strDefault;
    }

    protected String GetItemHandler(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig) {
        return this.toolbarWriterConfig.GetExtValue("HANDLER", "");
    }

    protected String GetItemResourceId(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig) {
        String strResourceId = "";
        if (deBehavior != null) {
            strResourceId = deBehavior.getRESOURCEID();
        }
        if (StringHelper.IsNullOrEmpty((String)strResourceId)) {
            strResourceId = tbItemConfig.GetExtValue("RESOURCEID", "");
        }
        if (StringHelper.IsNullOrEmpty((String)strResourceId)) {
            return "";
        }
        return StringHelper.Format((String)strResourceId, (Object)context.getDEHelper().getId());
    }

    protected String GetItemIconCls(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig, String strDefault) throws Exception {
        String strIconCls = tbItemConfig.getIconCls();
        if (!StringHelper.IsNullOrEmpty((String)strIconCls)) {
            return strIconCls;
        }
        if (StringHelper.IsNullOrEmpty((String)strDefault)) {
            strDefault = "sx-tb-commonaction";
        }
        if (deBehavior != null && !StringHelper.IsNullOrEmpty((String)deBehavior.getDEVIMAGEID())) {
            DevImage devImage = this.globalHelperEx.getDAModelStorage().FindDevImage(deBehavior.getDEVIMAGEID());
            if (devImage == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u56fe\u7247[%1$s]", (Object)deBehavior.getDEVIMAGEID()));
            }
            DevImgDetail devImageDetail = devImage.FindDevImgDetail("ICON16");
            if (devImageDetail != null) {
                strIconCls = devImageDetail.getCSSCLASS();
            }
            if (!StringHelper.IsNullOrEmpty((String)strIconCls)) {
                return strIconCls;
            }
            strIconCls = devImage.getCSSCLASS();
            if (!StringHelper.IsNullOrEmpty((String)strIconCls)) {
                return strIconCls;
            }
        }
        return this.toolbarWriterConfig.GetExtValue("ICONCLS", strDefault);
    }

    protected String GetItemImage(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig, String strDefault) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strDefault)) {
            strDefault = "../sasrfex/images/default/icon_gear.png";
        }
        String strImagePath = "";
        if (deBehavior != null && !StringHelper.IsNullOrEmpty((String)deBehavior.getDEVIMAGEID())) {
            DevImage devImage = this.globalHelperEx.getDAModelStorage().FindDevImage(deBehavior.getDEVIMAGEID());
            if (devImage == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u56fe\u7247[%1$s]", (Object)deBehavior.getDEVIMAGEID()));
            }
            DevImgDetail devImageDetail = devImage.FindDevImgDetail("ICON16");
            if (devImageDetail != null) {
                strImagePath = devImageDetail.getIMAGEPATH();
            }
            if (!StringHelper.IsNullOrEmpty((String)strImagePath)) {
                return strImagePath;
            }
            strImagePath = devImage.getIMAGEPATH();
            if (!StringHelper.IsNullOrEmpty((String)strImagePath)) {
                return strImagePath;
            }
        }
        return this.toolbarWriterConfig.GetExtValue("IMAGEPATH", strDefault);
    }

    public static void AddToolbarSeperator(XMLNode pNode, boolean bMenu) {
        if (bMenu) {
            XMLNode tbMenuItemNode = new XMLNode();
            pNode.AddNode(tbMenuItemNode);
            tbMenuItemNode.setNodeName("SRFEXMENUITEMEX");
            tbMenuItemNode.SetValue("CAPTION", "-");
        } else {
            XMLNode tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR);
            pNode.AddNode(tbItemNode);
        }
    }
}

