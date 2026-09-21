/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Builder.TreePanelBuilder;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.UI.TreePanelConfig;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

public class DefaultTreePanelBuilder
extends TreePanelBuilder {
    @Override
    public void Render(Writer writer, SRFExTreePanel treePanel) {
        try {
            ToolbarConfig bottomToolbarConfig;
            TreePanelConfig treePanelConfig = treePanel.getTreePanelConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", treePanelConfig.getWidthString());
            styleBuilder.AddStyle("height", treePanelConfig.getHeightString());
            writer.write("<DIV");
            DefaultTreePanelBuilder.OutputAttribute(writer, "id", treePanel.getUniqueID());
            String strClass = "sx-panel";
            if (StringHelper.Length((String)treePanelConfig.getCssClass()) > 0) {
                strClass = treePanelConfig.getCssClass();
            }
            DefaultTreePanelBuilder.OutputAttribute(writer, "class", strClass);
            DefaultTreePanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + treePanelConfig.getExtStyle());
            writer.write(" >");
            writer.write("</DIV>");
            String strScript = "";
            String strURL = treePanelConfig.getDataURL();
            if (StringHelper.Length((String)strURL) == 0) {
                strURL = treePanel.getPage().getDefaultBackEndUrl();
            }
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varTreeLoader=new Ext.tree.TreeLoader({dataUrl:'%1$s'});\r\n", (Object)strURL);
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTreeLoader.sparams={actiontype:'treeaction',treeid:'%1$s',action:'load'};\r\n", (Object)treePanel.getUniqueID());
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTreeLoader.dparams={};\r\n");
            strScript = String.valueOf(strScript) + "varTreeLoader.on('loadexception',function(_1,_2,_3){alert('\u52a0\u8f7d\u6811\u8282\u70b9\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c\u8bf7\u786e\u8ba4\u60a8\u7684\u8fde\u63a5\u662f\u5426\u6b63\u5e38\uff01');});\r\n";
            strScript = String.valueOf(strScript) + "varTreeLoader.on('beforeload',function(_1,_2,_3){_1.baseParams={};_1.baseParams.depth = _2.getDepth();Ext.apply(_1.baseParams,_1.sparams);Ext.apply(_1.baseParams,_1.dparams);});\r\n";
            String strTTBCode = "";
            String strBTBCode = "";
            ToolbarConfig topToolbarConfig = treePanelConfig.getTopToolbarConfig();
            if (topToolbarConfig != null) {
                strTTBCode = String.valueOf(strTTBCode) + "[";
                boolean bFirst = true;
                ToolbarItemsConfig toolbarItemsConfig = topToolbarConfig.getToolbarItemsConfig();
                Iterator iterator = toolbarItemsConfig.iterator();
                while (iterator.hasNext()) {
                    BaseToolbarItemConfig baseToolbarItemConfig = (BaseToolbarItemConfig)((Object)iterator.next());
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        strTTBCode = String.valueOf(strTTBCode) + ",";
                    }
                    strTTBCode = String.valueOf(strTTBCode) + baseToolbarItemConfig.GetJSCode(treePanel.getWebContext(), treePanel, false);
                }
                strTTBCode = String.valueOf(strTTBCode) + "]";
            }
            if ((bottomToolbarConfig = treePanelConfig.getBottomToolbarConfig()) != null) {
                strBTBCode = String.valueOf(strBTBCode) + "[";
                boolean bFirst = true;
                ToolbarItemsConfig toolbarItemsConfig = bottomToolbarConfig.getToolbarItemsConfig();
                Iterator iterator = toolbarItemsConfig.iterator();
                while (iterator.hasNext()) {
                    BaseToolbarItemConfig baseToolbarItemConfig = (BaseToolbarItemConfig)((Object)iterator.next());
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        strBTBCode = String.valueOf(strBTBCode) + ",";
                    }
                    strBTBCode = String.valueOf(strBTBCode) + baseToolbarItemConfig.GetJSCode(treePanel.getWebContext(), treePanel, false);
                }
                strBTBCode = String.valueOf(strBTBCode) + "]";
            }
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varTree=new Ext.tree.TreePanel({el:'%1$s',\r\n", (Object)treePanel.getUniqueID());
            if (treePanelConfig.getWidth() > 0) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"width:%1$s,", (Object)treePanelConfig.getWidth());
            }
            strScript = treePanelConfig.getHeight() > 0 ? String.valueOf(strScript) + StringHelper.Format((String)"height:%1$s,", (Object)treePanelConfig.getHeight()) : String.valueOf(strScript) + StringHelper.Format((String)"autoHeight:true,");
            if (!treePanelConfig.getBorder()) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"border:false,");
            }
            if (!treePanelConfig.isRootVisible()) {
                strScript = String.valueOf(strScript) + "rootVisible:false,";
            }
            strScript = String.valueOf(strScript) + "autoScroll:true,animate:true,enableDD:false,containerScroll:true,loader:varTreeLoader";
            if (!StringHelper.IsNullOrEmpty((String)strTTBCode)) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)",tbar:%1$s", (Object)strTTBCode);
            }
            if (!StringHelper.IsNullOrEmpty((String)strBTBCode)) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)",bbar:%1$s", (Object)strBTBCode);
            }
            if (!treePanelConfig.isShowLine()) {
                strScript = String.valueOf(strScript) + ",lines:false";
            }
            strScript = String.valueOf(strScript) + "});\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tree['%1$s'] =varTree;\r\n", (Object)treePanel.getUniqueID());
            TreeNodeConfig rootNodeConfig = treePanelConfig.getRootNodeConfig();
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTree._createRootNode=function(){return %1$s;};\r\n", (Object)rootNodeConfig.ToJSCode());
            String strLastNodeName = "_R";
            if (treePanelConfig.isAutoRender()) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var %1$s=varTree._createRootNode();\r\n", (Object)strLastNodeName);
                strScript = String.valueOf(strScript) + this.OutputTreeNodeCode(strLastNodeName, rootNodeConfig);
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTree.setRootNode(%1$s);\r\n", (Object)strLastNodeName);
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTree.render();%1$s.expand(false,false);\r\n", (Object)strLastNodeName);
            } else {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTree._render=function(){\r\n", (Object)rootNodeConfig.ToJSCode());
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var %1$s=$P.tree['%2$s']._createRootNode();\r\n", (Object)strLastNodeName, (Object)treePanel.getUniqueID());
                strScript = String.valueOf(strScript) + this.OutputTreeNodeCode(strLastNodeName, rootNodeConfig);
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tree['%1$s'].setRootNode(%2$s);\r\n", (Object)treePanel.getUniqueID(), (Object)strLastNodeName);
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tree['%1$s'].render();%2$s.expand(false,false);\r\n", (Object)treePanel.getUniqueID(), (Object)strLastNodeName);
                strScript = String.valueOf(strScript) + "};";
            }
            if (treePanelConfig.isCreateChildFunc()) {
                StringBuilderEx script = new StringBuilderEx();
                script.Append("varTree._createchild=function(_1){");
                script.Append("if(this._transId)return;\r\n");
                script.Append("var node=this.getSelectionModel().getSelectedNode();\r\n");
                script.Append("if(node==null||node==undefined)return;\r\n");
                script.Append("var param={};Ext.apply(param,this.getLoader().sparams);Ext.apply(param,this.getLoader().dparams);Ext.apply(param,_1);\r\n");
                script.Append("param.node=node.id;param.action='create';\r\n");
                script.Append(" this._transId = Ext.Ajax.request({");
                script.Append("  method:'POST',");
                script.Append("  url: this.getLoader().dataUrl,");
                script.Append("  success: this._createchildsuccess,");
                script.Append("  failure: this._createchildfailed,");
                script.Append("  scope: this,");
                script.Append("  argument: {node:node},");
                script.Append("  params:Ext.urlEncode(param)");
                script.Append(" });");
                script.Append("};\r\n");
                script.Append("varTree._createchildsuccess=function(_1){");
                script.Append("this._transId = false;");
                script.Append("var _RT = _1.responseText;\r\n");
                script.Append("if(_RT==undefined || _RT == null || _RT == ''){\r\n");
                script.Append("this._createchildfailed(_1);return;}\r\n");
                script.Append("var _JO = eval(\"(\"+_RT+\")\");\r\n");
                script.Append("if(_JO == undefined ||_JO == null || _JO.ret == undefined){\r\n");
                script.Append("this._createchildfailed(_1);return;}\r\n");
                script.Append("if(_JO.ret!=0){alert(_JO.info);return;}\r\n");
                script.Append("if(_1.argument && _1.argument.node ){_1.argument.node.appendChild(_JO.items);}\r\n");
                script.Append("$ARP(_JO);\r\n");
                script.Append("};\r\n");
                script.Append("varTree._createchildfailed=function(_1){");
                script.Append("this._transId = false;");
                script.Append("alert($P.msg['networkerror']);");
                script.Append("};\r\n");
                strScript = String.valueOf(strScript) + script.toString();
            }
            if (treePanel.getPage().isOptimize()) {
                strScript = strScript.replaceAll("varTreeLoader", "_5");
                strScript = strScript.replaceAll("varTree", "_6");
            }
            treePanel.getPage().RegisterOnReadyScript(2, strScript);
            if (StringHelper.Length((String)treePanelConfig.getSelectedValue()) > 0 && treePanelConfig.isAutoRender()) {
                strScript = "";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var selectedNode=SRFTree.find($P.tree['%1$s'].getRootNode(),'%2$s');\r\n", (Object)treePanel.getUniqueID(), (Object)treePanelConfig.getSelectedValue());
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(selectedNode!=null){selectedNode.ensureVisible(); selectedNode.select();}\r\n");
                treePanel.getPage().RegisterOnReadyScript(6, strScript);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected String OutputTreeNodeCode(String strParentNodeName, TreeNodeConfig node) {
        String strOutput = "";
        ArrayList arrList = node.getChildNodes();
        if (arrList == null) {
            return strOutput;
        }
        int i = 0;
        while (i < arrList.size()) {
            String strTempNodeName = StringHelper.Format((String)"%1$s_%2$s", (Object)strParentNodeName, (Object)i);
            TreeNodeConfig childNode = (TreeNodeConfig)arrList.get(i);
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"var %1$s=%2$s;\r\n", (Object)strTempNodeName, (Object)childNode.ToJSCode());
            strOutput = String.valueOf(strOutput) + this.OutputTreeNodeCode(strTempNodeName, childNode);
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"%1$s.appendChild(%2$s);\r\n", (Object)strParentNodeName, (Object)strTempNodeName);
            ++i;
        }
        if (node.getAlwaysAsyncMode()) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"%1$s.loaded=true;\r\n", (Object)strParentNodeName);
        }
        return strOutput;
    }

    @Override
    public String getBuilderMode() {
        return "";
    }

    @Override
    public String getBuilderName() {
        return "TREEPANEL";
    }
}

