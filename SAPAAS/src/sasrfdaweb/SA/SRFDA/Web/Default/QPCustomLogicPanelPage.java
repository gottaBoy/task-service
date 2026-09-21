/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExTextBox
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExTextBox;

public class QPCustomLogicPanelPage
extends SRFDAPage {
    protected String strPPanelId = "";
    protected SRFExTextBox tbCustomName = null;
    protected SRFExTextBox tbCustomCode = null;
    protected SRFExButton btnOK = null;

    public QPCustomLogicPanelPage() {
        this.setMainPage(false);
        this.setJSCache(false);
    }

    protected void OnInitComponents() {
        this.strPPanelId = this.getWebContext().GetParamValue("PPANELID");
        this.setID(this.strPPanelId);
        super.OnInitComponents();
        StringBuilderEx script = new StringBuilderEx();
        this.tbCustomName = new SRFExTextBox();
        this.tbCustomName.InitConfig();
        this.tbCustomName.setID("tbCustomName");
        this.tbCustomName.getTextBoxConfig().setWidthEx(200.0);
        this.AddControl((SRFExControl)this.tbCustomName);
        this.tbCustomCode = new SRFExTextBox();
        this.tbCustomCode.InitConfig();
        this.tbCustomCode.setID("tbCustomCode");
        this.tbCustomCode.getTextBoxConfig().setWidthEx(1.0);
        this.tbCustomCode.getTextBoxConfig().setTextMode(1);
        this.tbCustomCode.getTextBoxConfig().setRows(5);
        this.tbCustomCode.getTextBoxConfig().setHeight(40);
        this.AddControl((SRFExControl)this.tbCustomCode);
        this.btnOK = new SRFExButton();
        this.btnOK.InitConfig();
        this.btnOK.setID("btnOK");
        this.btnOK.getButtonConfig().setText("\u786e\u8ba4");
        this.btnOK.getButtonConfig().setTips("\u4fdd\u5b58\u903b\u8f91");
        this.btnOK.setResourceId("");
        script.Reset();
        script.Append("var tree = $P.tree['%1$s'];", (Object)this.getWebContext().GetParamValue("TREEID"));
        script.Append("if (tree == null || tree == undefined) return;\r\n");
        script.Append("var node = tree.getNodeById('%1$s');\r\n", (Object)this.getWebContext().GetParamValue("NODEID"));
        script.Append("if (node == null || node == undefined) return;\r\n");
        script.Append("var varCode = Ext.getDom('%1$s').value;\r\n", (Object)this.tbCustomCode.getUniqueID());
        script.Append("var varName = Ext.getDom('%1$s').value;\r\n", (Object)this.tbCustomName.getUniqueID());
        script.Append("node.xml.condition = varCode;\r\n");
        script.Append("node.xml.logicname = varName;\r\n");
        script.Append("updateNodeText(node);\r\n");
        this.btnOK.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnOK);
        script.Reset();
        script.Append("var tree = $P.tree['%1$s'];", (Object)this.getWebContext().GetParamValue("TREEID"));
        script.Append("if (tree == null || tree == undefined) return;\r\n");
        script.Append("var node = tree.getNodeById('%1$s');\r\n", (Object)this.getWebContext().GetParamValue("NODEID"));
        script.Append("if (node == null || node == undefined) return;\r\n");
        script.Append("var varCode = $V(node.xml.condition,'');\r\n");
        script.Append("var varName = $V(node.xml.logicname,'');\r\n");
        script.Append("Ext.getDom('%1$s').value = varCode;\r\n", (Object)this.tbCustomCode.getUniqueID());
        script.Append("Ext.getDom('%1$s').value = varName;\r\n", (Object)this.tbCustomName.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
    }
}

