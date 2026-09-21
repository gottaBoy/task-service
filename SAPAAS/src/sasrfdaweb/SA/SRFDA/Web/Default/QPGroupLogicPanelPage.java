/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;

public class QPGroupLogicPanelPage
extends SRFDAPage {
    protected String strPPanelId = "";
    protected SRFExDropDownList ddlGroupLogic = null;
    protected SRFExDropDownList ddlNotLogic = null;
    protected SRFExButton btnOK = null;

    public QPGroupLogicPanelPage() {
        this.setMainPage(false);
        this.setJSCache(false);
    }

    protected void OnInitComponents() {
        this.strPPanelId = this.getWebContext().GetParamValue("PPANELID");
        this.setID(this.strPPanelId);
        super.OnInitComponents();
        StringBuilderEx script = new StringBuilderEx();
        this.ddlGroupLogic = new SRFExDropDownList();
        this.ddlGroupLogic.InitConfig();
        this.ddlGroupLogic.setID("ddlGroupLogic");
        this.ddlGroupLogic.getDropDownListConfig().setWidthEx(1.0);
        this.ddlGroupLogic.getDropDownListConfig().getListItems().Add(new ListItem("AND \u4e0e\u903b\u8f91", "AND"));
        this.ddlGroupLogic.getDropDownListConfig().getListItems().Add(new ListItem("OR \u6216\u903b\u8f91", "OR"));
        this.ddlGroupLogic.getDropDownListConfig().setSelectedValue("AND");
        this.AddControl((SRFExControl)this.ddlGroupLogic);
        this.ddlNotLogic = new SRFExDropDownList();
        this.ddlNotLogic.InitConfig();
        this.ddlNotLogic.setID("ddlNotLogic");
        this.ddlNotLogic.getDropDownListConfig().setWidthEx(1.0);
        this.ddlNotLogic.getDropDownListConfig().getListItems().Add(new ListItem("\u662f", "1"));
        this.ddlNotLogic.getDropDownListConfig().getListItems().Add(new ListItem("\u5426", "0"));
        this.ddlNotLogic.getDropDownListConfig().setSelectedValue("0");
        this.AddControl((SRFExControl)this.ddlNotLogic);
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
        script.Append("var varNot = Ext.getDom('%1$s').value;\r\n", (Object)this.ddlNotLogic.getUniqueID());
        script.Append("var varLogic = Ext.getDom('%1$s').value;\r\n", (Object)this.ddlGroupLogic.getUniqueID());
        script.Append("node.xml.not = (varNot == '1');\r\n");
        script.Append("node.xml.logic = varLogic;\r\n");
        script.Append("updateNodeText(node);\r\n");
        this.btnOK.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnOK);
        script.Reset();
        script.Append("var tree = $P.tree['%1$s'];", (Object)this.getWebContext().GetParamValue("TREEID"));
        script.Append("if (tree == null || tree == undefined) return;\r\n");
        script.Append("var node = tree.getNodeById('%1$s');\r\n", (Object)this.getWebContext().GetParamValue("NODEID"));
        script.Append("if (node == null || node == undefined) return;\r\n");
        script.Append("var varNot = $V(node.xml.not,false);\r\n");
        script.Append("var varLogic = $V(node.xml.logic,'AND');\r\n");
        script.Append("Ext.getDom('%1$s').value = varNot?'1':'0';\r\n", (Object)this.ddlNotLogic.getUniqueID());
        script.Append("Ext.getDom('%1$s').value = varLogic;\r\n", (Object)this.ddlGroupLogic.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
    }
}

