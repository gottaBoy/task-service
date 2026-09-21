/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExHidden
 */
package SA.SRFDA.Web;

import SA.SRFDA.Model.ValueFuncConfig;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.UI.SearchConditionDesignerConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExHidden;
import java.io.Writer;
import java.util.Vector;

public class SRFDASearchConditionDesigner
extends SRFExHidden {
    protected SearchConditionDesignerConfig searchConditionDesignerConfig = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new SearchConditionDesignerConfig();
    }

    public SearchConditionDesignerConfig getSearchConditionDesignerConfig() {
        return this.searchConditionDesignerConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.searchConditionDesignerConfig = null;
        if (this.config != null && this.config instanceof SearchConditionDesignerConfig) {
            this.searchConditionDesignerConfig = (SearchConditionDesignerConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            writer.write(StringHelper.Format((String)"<DIV id='GRID_%1$s' ></DIV>", (Object)this.getUniqueID()));
            writer.write(StringHelper.Format((String)"<select name=\"DDL_CONDITION_%1$s\" id=\"DDL_CONDITION_%1$s\" style=\"display: none;\">\r\n", (Object)this.getUniqueID()));
            writer.write("<option value=\"=\">\u7b49\u4e8e</option>\r\n");
            writer.write("<option value=\"==\">\u7edd\u5bf9\u7b49\u4e8e</option>\r\n");
            writer.write("<option value=\"<>\">\u4e0d\u7b49\u4e8e</option>\r\n");
            writer.write("<option value=\">=\">\u5927\u4e8e\u7b49\u4e8e</option>\r\n");
            writer.write("<option value=\">\">\u5927\u4e8e</option>\r\n");
            writer.write("<option value=\"<=\">\u5c0f\u4e8e\u7b49\u4e8e</option>\r\n");
            writer.write("<option value=\"<\">\u5c0f\u4e8e</option>\r\n");
            writer.write("<option value=\"LIKE\">\u6a21\u7cca\u5339\u914d</option>\r\n");
            writer.write("<option value=\"LEFTLIKE\">\u5de6\u4fa7\u5339\u914d</option>\r\n");
            writer.write("<option value=\"RIGHTLIKE\">\u53f3\u4fa7\u5339\u914d</option>\r\n");
            writer.write("<option value=\"IN\">\u5728\u503c\u8303\u56f4\u4e2d</option>\r\n");
            writer.write("<option value=\"NOTIN\">\u4e0d\u5728\u503c\u8303\u56f4\u4e2d</option>\r\n");
            writer.write("<option value=\"TESTNULL\">\u7a7a\u503c\u5224\u65ad</option>\r\n");
            writer.write("</select>");
            writer.write(StringHelper.Format((String)"<select name=\"DDL_FUNCTION_%1$s\" id=\"DDL_FUNCTION_%1$s\" style=\"display: none;\">\r\n", (Object)this.getUniqueID()));
            writer.write("<option value=\"\">\u65e0</option>\r\n");
            Vector<ValueFuncConfig> valueFuncs = this.getDAWebContext().getGlobalHelper().getDAConfigMgr().getValueFuncMgr().FindFuncsByDataType("");
            if (valueFuncs != null) {
                for (ValueFuncConfig valueFuncConfig : valueFuncs) {
                    writer.write(StringHelper.Format((String)"<option value=\"%1$s\">%2$s</option>\r\n", (Object)valueFuncConfig.getID(), (Object)valueFuncConfig.getLogicName()));
                }
            }
            writer.write("</select>");
            writer.write(StringHelper.Format((String)"<select name=\"DDL_FORMCTRL_%1$s\" id=\"DDL_FORMCTRL_%1$s\" style=\"display: none;\">\r\n", (Object)this.getUniqueID()));
            writer.write("<option value=\"\">\u81ea\u52a8\u9009\u62e9</option>\r\n");
            writer.write("<option value=\"SRFEXTEXTBOX\">\u6587\u672c\u6846</option>\r\n");
            writer.write("<option value=\"SRFEXDROPDOWNLIST\">\u4e0b\u62c9\u5217\u8868\u6846</option>\r\n");
            writer.write("<option value=\"SRFEXDATEPICKEREX\">\u65e5\u671f\u9009\u62e9</option>\r\n");
            writer.write("</select>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.object['%1$s']={};\r\n", (Object)this.getUniqueID());
            script.Append("$P.object['%1$s'].renderaction = function(_1){\r\n", (Object)this.getUniqueID());
            script.Append("if (_1 == '=') return '\u7b49\u4e8e';\r\n");
            script.Append("if (_1 == '==')return '\u7edd\u5bf9\u7b49\u4e8e';\r\n");
            script.Append("if (_1 == '<>')return '\u4e0d\u7b49\u4e8e';\r\n");
            script.Append("    if (_1 == '>=')\r\n");
            script.Append("       return '\u5927\u4e8e\u7b49\u4e8e';\r\n");
            script.Append("    if (_1 == '>')\r\n");
            script.Append("        return '\u5927\u4e8e';\r\n");
            script.Append("    if (_1 == '<=')\r\n");
            script.Append("        return '\u5c0f\u4e8e\u7b49\u4e8e';\r\n");
            script.Append("    if (_1 == '<')\r\n");
            script.Append("        return '\u5c0f\u4e8e';\r\n");
            script.Append("    if (_1 == 'LIKE')\r\n");
            script.Append("        return '\u6a21\u7cca\u5339\u914d';\r\n");
            script.Append("    if (_1 == 'LEFTLIKE')\r\n");
            script.Append("        return '\u5de6\u4fa7\u5339\u914d';\r\n");
            script.Append("    if (_1 == 'RIGHTLIKE')\r\n");
            script.Append("        return '\u53f3\u4fa7\u5339\u914d';\r\n");
            script.Append("if(_1 == 'IN')return '\u5728\u503c\u8303\u56f4\u4e2d';\r\n");
            script.Append("if(_1 == 'NOTIN')return '\u4e0d\u5728\u503c\u8303\u56f4\u4e2d';\r\n");
            script.Append("if(_1 == 'TESTNULL')return '\u7a7a\u503c\u5224\u65ad';\r\n");
            script.Append("    return '';\r\n");
            script.Append("};\r\n");
            script.Append("$P.object['%1$s'].renderfunc=function(_1){\r\n", (Object)this.getUniqueID());
            if (valueFuncs != null) {
                for (ValueFuncConfig valueFuncConfig : valueFuncs) {
                    script.Append("if(_1=='%1$s')", (Object)valueFuncConfig.getID());
                    script.Append("return '%1$s';\r\n", (Object)valueFuncConfig.getLogicName());
                }
            }
            script.Append("return '\u65e0';\r\n");
            script.Append("};\r\n");
            script.Append("$P.object['%1$s'].renderformctrl = function(_1){\r\n", (Object)this.getUniqueID());
            script.Append("    if (_1 == 'SRFEXTEXTBOX')\r\n");
            script.Append("        return '\u6587\u672c\u6846';\r\n");
            script.Append("    if (_1 == 'SRFEXDROPDOWNLIST')\r\n");
            script.Append("       return '\u4e0b\u62c9\u5217\u8868\u6846';\r\n");
            script.Append("    if (_1 == 'SRFEXDATEPICKEREX')\r\n");
            script.Append("        return '\u65e5\u671f\u9009\u62e9';\r\n");
            script.Append("    return '\u81ea\u52a8\u9009\u62e9';\r\n");
            script.Append("};\r\n");
            script.Append("$P.object['%1$s'].expsearchitemconfig=function (XML,_1){\r\n", (Object)this.getUniqueID());
            script.Append("if(_1.getCount()==0)return ;\r\n");
            script.Append("XML.BeginNode('SRFDASEARCHMODEL');\r\n");
            script.Append("for(i=0;i< _1.getCount();i++){\r\n");
            script.Append("var rd=_1.getAt(i);\r\n");
            script.Append("XML.BeginNode('SRFDASEARCHITEM');\r\n");
            script.Append("XML.Attrib(\"CAPTION\", rd.get('caption'));\r\n");
            script.Append("XML.Attrib(\"ACTION\", rd.get('cond'));\r\n");
            script.Append("XML.Attrib(\"GROUP\", rd.get('group'));\r\n");
            script.Append("XML.Attrib(\"SHOWORDER\", rd.get('showorder'));\r\n");
            script.Append("XML.Attrib(\"COLSPAN\", rd.get('colspan'));\r\n");
            script.Append("XML.Attrib(\"FUNC\", rd.get('func'));\r\n");
            script.Append("XML.Attrib(\"FORMITEM\", rd.get('formitem'));\r\n");
            script.Append("XML.Attrib(\"FORMITEMPARAM\", rd.get('formitemparam'));\r\n");
            script.Append("XML.Attrib(\"FORMITEMPARAMS\", rd.get('formitemparams'));\r\n");
            script.Append("XML.Attrib(\"CTRLPARAMS\", rd.get('ctrlparams'));\r\n");
            script.Append("XML.EndNode();\r\n");
            script.Append("rd.commit();}\r\n");
            script.Append("XML.EndNode();}\r\n");
            script.Append("var _GRIDWIDTH = Ext.getDom('%1$s').parentNode.clientWidth-4;\r\n", (Object)this.getUniqueID());
            script.Append("var cm = new Ext.grid.ColumnModel([\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u503c\u5904\u7406\",\r\n");
            script.Append("   \tdataIndex: 'func',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append("       renderer: $P.object['%1$s'].renderfunc,\r\n", (Object)this.getUniqueID());
            script.Append("     editor: new Ext.form.ComboBox({\r\n");
            script.Append("          typeAhead: true,\r\n");
            script.Append("          triggerAction: 'all',\r\n");
            script.Append("          transform:'DDL_FUNCTION_%1$s',\r\n", (Object)this.getUniqueID());
            script.Append("          lazyRender:true,\r\n");
            script.Append("     \t allowBlank: false,\r\n");
            script.Append("          listClass: 'x-combo-list-small'\r\n");
            script.Append("         })\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append(" {\r\n");
            script.Append("       id:'cond',\r\n");
            script.Append("       header: \"\u6761\u4ef6\",\r\n");
            script.Append("       dataIndex: 'cond',\r\n");
            script.Append("       width: 100,\r\n");
            script.Append("       renderer: $P.object['%1$s'].renderaction,\r\n", (Object)this.getUniqueID());
            script.Append("       editor: new Ext.form.ComboBox({\r\n");
            script.Append("          typeAhead: true,\r\n");
            script.Append("          triggerAction: 'all',\r\n");
            script.Append("          transform:'DDL_CONDITION_%1$s',\r\n", (Object)this.getUniqueID());
            script.Append("          lazyRender:true,\r\n");
            script.Append("     \t allowBlank: false,\r\n");
            script.Append("          listClass: 'x-combo-list-small'\r\n");
            script.Append("         })\r\n");
            script.Append("}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u5206\u7ec4\",\r\n");
            script.Append("   \tdataIndex: 'group',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u81ea\u5b9a\u4e49\u6807\u9898\",\r\n");
            script.Append("   \tdataIndex: 'caption',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u663e\u793a\u6b21\u5e8f\",\r\n");
            script.Append("   \tdataIndex: 'showorder',\r\n");
            script.Append("     width: 80,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u5355\u5143\u683c\u6570\u91cf\",\r\n");
            script.Append("   \tdataIndex: 'colspan',\r\n");
            script.Append("     width: 80,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u63a7\u4ef6\u7c7b\u578b\",\r\n");
            script.Append("   \tdataIndex: 'formitem',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append("     renderer: $P.object['%1$s'].renderformctrl,\r\n", (Object)this.getUniqueID());
            script.Append("     editor: new Ext.form.ComboBox({\r\n");
            script.Append("          triggerAction: 'all',\r\n");
            script.Append("          transform:'DDL_FORMCTRL_%1$s',\r\n", (Object)this.getUniqueID());
            script.Append("          lazyRender:true,\r\n");
            script.Append("     \t allowBlank: false,\r\n");
            script.Append("          listClass: 'x-combo-list-small'\r\n");
            script.Append("         })\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u9759\u6001\u4ee3\u7801\",\r\n");
            script.Append("   \tdataIndex: 'formitemparam',\r\n");
            script.Append("     width: 200,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u63a7\u4ef6\u53c2\u6570\",\r\n");
            script.Append("   \tdataIndex: 'ctrlparams',\r\n");
            script.Append("     width: 200,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u8868\u5355\u9879\u53c2\u6570\",\r\n");
            script.Append("   \tdataIndex: 'formitemparams',\r\n");
            script.Append("     width: 200,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append("    ]);\r\n");
            script.Append("    cm.defaultSortable = true;\r\n");
            script.Append("\t    var SearchItem = Ext.data.Record.create([\r\n");
            script.Append("\t           {name: 'cond', type: 'string'},\r\n");
            script.Append("\t           {name: 'group', type: 'string'},\r\n");
            script.Append("\t           {name: 'showorder', type: 'string'},\r\n");
            script.Append("\t           {name: 'colspan', type: 'string'},\r\n");
            script.Append("\t           {name: 'func',type: 'string'},\r\n");
            script.Append("\t           {name: 'caption',type: 'string'},\r\n");
            script.Append("\t           {name: 'formitem',type: 'string'},\r\n");
            script.Append("\t           {name: 'formitemparam',type: 'string'},\r\n");
            script.Append("\t           {name: 'formitemparams',type: 'string'},\r\n");
            script.Append("\t           {name: 'ctrlparams',type: 'string'}\r\n");
            script.Append("\t      ]);\r\n");
            script.Append("\t    var store = new Ext.data.Store({\r\n");
            script.Append("\t        url: '../srfds/xml2jsonbackend.jsp?MAJORACTION=SEARCHITEM',\r\n");
            script.Append("\t        reader: new Ext.data.JsonReader({root: \"items\",totalProperty:\"totalrow\"  }\r\n");
            script.Append("\t         ,SearchItem),\r\n");
            script.Append("\t        sortInfo:{field:'cond', direction:'ASC'}\r\n");
            script.Append("\t    });\r\n");
            script.Append("\t    var grid = new Ext.grid.EditorGridPanel({\r\n");
            script.Append("\t        store: store,\r\n");
            script.Append("\t        cm: cm,\r\n");
            script.Append("\t        renderTo: 'GRID_%1$s',\r\n", (Object)this.getUniqueID());
            script.Append("\t   \t\twidth:_GRIDWIDTH,\r\n");
            script.Append("\t        height:200,\r\n");
            script.Append("\t        frame:false,\r\n");
            script.Append("\t\t\tsm: new Ext.grid.RowSelectionModel({singleSelect:true}),\r\n");
            script.Append("\t        clicksToEdit:1,\r\n");
            script.Append("\t        tbar: [{\r\n");
            script.Append("\t            text: '\u589e\u52a0\u6761\u4ef6',\r\n");
            script.Append("\t            handler : function(){\r\n");
            script.Append("\t                var p = new SearchItem({\r\n");
            script.Append("                    cond: '=',\r\n");
            script.Append("                    group: '',\r\n");
            script.Append("                    caption: '',\r\n");
            script.Append("                    showorder: '',\r\n");
            script.Append("                    func: '',\r\n");
            script.Append("                    formitem: ''\r\n");
            script.Append("                });\r\n");
            script.Append("              $P.grid['%1$s'].stopEditing();\r\n", (Object)this.getUniqueID());
            script.Append("             var index = $P.store['%1$s'].getCount();\r\n", (Object)this.getUniqueID());
            script.Append("              $P.store['%1$s'].insert(index, p);\r\n", (Object)this.getUniqueID());
            script.Append("              $P.grid['%1$s'].startEditing(index, 0);\r\n", (Object)this.getUniqueID());
            script.Append("            }}\r\n");
            script.Append("\t           ,{\r\n");
            script.Append("\t            text: '\u5220\u9664\u6761\u4ef6',\r\n");
            script.Append("\t            handler : function(){\r\n");
            script.Append("               var rd =   $P.grid['%1$s'].getSelectionModel().getSelected();\r\n", (Object)this.getUniqueID());
            script.Append("\t              if(rd == null || rd == undefined)return;\r\n");
            script.Append("               $P.store['%1$s'].remove(rd);\r\n", (Object)this.getUniqueID());
            script.Append("            }}\r\n");
            script.Append("        ]\r\n");
            script.Append("\t    });\r\n");
            script.Append("$P.grid['%1$s'] = grid;\r\n", (Object)this.getUniqueID());
            script.Append("$P.store['%1$s'] = store;\r\n", (Object)this.getUniqueID());
            script.Append("store.on('load',function(_1,_2){$P.mainform._LV['%1$s']=$P.mainform.G('%1$s');});\r\n", (Object)this.getUniqueID());
            script.Append("var fu = function(_1){$P.grid['%1$s'].setWidth(Ext.getDom('%1$s').parentNode.clientWidth-4);};", (Object)this.getUniqueID());
            script.Append("if(Ext.isIE){Ext.getDom('%1$s').parentNode.attachEvent('onresize',fu);}else{Ext.EventManager.onWindowResize(fu);}", (Object)this.getUniqueID());
            this.getPage().RegisterOnReadyScript(3, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected SRFDAWebContext getDAWebContext() {
        return (SRFDAWebContext)this.getWebContext();
    }

    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        return script.toString();
    }

    public void setEnabled(boolean bEnabled) {
        super.setEnabled(bEnabled);
    }

    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var XML=new XMLWriter();\r\n");
            script.Append("$P.object['%1$s'].expsearchitemconfig(XML,$P.store['%1$s']);\r\n", (Object)this.getUniqueID());
            script.Append("XML.Close();\r\n");
            script.Append("_V = XML.ToString();\r\n");
            script.Append("if(_V!=''){_V = '<?xml version=\"1.0\" encoding=\"utf-8\" ?>'+_V}\r\n");
            script.Append("$FSV(_ID,_V);\r\n");
            return script.toString();
        }
        return StringHelper.Format((String)"if(_V==$FGV(_ID))break;$FSV(_ID,_V);$P.store['%1$s'].load({params:{xmlcontent:_V}});", (Object)this.getUniqueID());
    }
}

