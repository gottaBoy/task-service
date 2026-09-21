/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Web.UI.BIDimensionSelectorConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDABIDimensionSelector
extends SRFExHidden {
    private static final Log log = LogFactory.getLog(SRFDABIDimensionSelector.class);
    protected BIDimensionSelectorConfig biDimensionSelectorConfig = null;
    protected SRFExDropDownList dropDownList = null;
    protected SRFExTreePanel treePanel = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new BIDimensionSelectorConfig();
    }

    public BIDimensionSelectorConfig getBIDimensionSelectorConfig() {
        return this.biDimensionSelectorConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.biDimensionSelectorConfig = null;
        if (this.config != null && this.config instanceof BIDimensionSelectorConfig) {
            this.biDimensionSelectorConfig = (BIDimensionSelectorConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.biDimensionSelectorConfig != null) {
            this.dropDownList = new SRFExDropDownList();
            this.dropDownList.InitConfig();
            this.dropDownList.getDropDownListConfig().setID("dropDownList");
            this.AddControl((SRFExControl)this.dropDownList);
            this.treePanel = new SRFExTreePanel();
            this.treePanel.InitConfig();
            this.treePanel.getTreePanelConfig().setID("treePanel");
            TreeNodeConfig rootNodeConfig = new TreeNodeConfig();
            rootNodeConfig.setID("root");
            rootNodeConfig.setAsyncMode(true);
            this.treePanel.getTreePanelConfig().setRootNodeConfig(rootNodeConfig);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.AddControl((SRFExControl)this.treePanel);
        }
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            if (this.getForm() == null) {
                writer.write("\u6ca1\u6709\u627e\u5230\u63a7\u4ef6\u7684\u8868\u5355\u5bf9\u8c61");
                log.error((Object)"\u6ca1\u6709\u627e\u5230\u63a7\u4ef6\u7684\u8868\u5355\u5bf9\u8c61");
                return;
            }
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table  border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            String strTreeViewDataUrl = StringHelper.Format((String)"../srfbi/bitreeviewdatabackend.jsp?BITREEVIEW=BICUBEDIMENSION&BICUBEDIMENSIONID=%1$s&BIHIERARCHYID=", (Object)this.getBaseControlConfig().GetExtValue("BICUBEDIMENSIONID", ""));
            String strBIHIERARCHY = this.getBaseControlConfig().GetExtValue("BIHIERARCHY", "");
            String[] biHierarchies = strBIHIERARCHY.split("[;]");
            if (biHierarchies.length > 1) {
                writer.write(StringHelper.Format((String)"<tr><td style=\"padding-top:4px;\">"));
                this.dropDownList.Render(writer);
                writer.write("</td></tr>");
                if (this.getBaseControlConfig().getHeightEx() > 1.0) {
                    this.treePanel.getTreePanelConfig().setHeightEx(this.getBaseControlConfig().getHeightEx() - 28.0);
                }
                this.treePanel.getTreePanelConfig().setDataURL(strTreeViewDataUrl);
            } else {
                String[] items = biHierarchies[0].split("[|]");
                strTreeViewDataUrl = String.valueOf(strTreeViewDataUrl) + items[1];
                if (this.getBaseControlConfig().getHeightEx() > 1.0) {
                    this.treePanel.getTreePanelConfig().setHeightEx(this.getBaseControlConfig().getHeightEx() - 8.0);
                }
                this.treePanel.getTreePanelConfig().setDataURL(strTreeViewDataUrl);
            }
            writer.write("<tr><td style=\"padding-top:4px;\">");
            if (this.getBaseControlConfig().getWidthEx() > 1.0) {
                this.treePanel.getTreePanelConfig().setWidthEx(this.getBaseControlConfig().getWidthEx() - 8.0);
            }
            this.treePanel.Render(writer);
            writer.write("</td></tr>");
            writer.write("</table>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.tree['%1$s'].on('checkchange',treecheckchange);", (Object)this.treePanel.getUniqueID());
            script.Append("$P.tree['%1$s'].on('beforeappend',treebeforeappend);", (Object)this.treePanel.getUniqueID());
            this.getPage().RegisterOnReadyScript(3, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setEnabled(boolean bEnabled) {
        super.setEnabled(bEnabled);
    }

    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("_V='NORMAL%%|SRF2|%%'+gettreevalue($P.tree['%1$s'],null);", (Object)this.treePanel.getUniqueID());
            script.Append("$FSV(_ID,_V);\r\n");
            return script.toString();
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append(super.getItemValueJSCall(bGetMode));
        script.Append("if(_V==''){$P.tree['%1$s'].getRootNode().reload();}\r\n", (Object)this.treePanel.getUniqueID());
        return script.toString();
    }
}

