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

import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.UI.QueryGroupDesignerConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExHidden;
import java.io.Writer;

public class SRFDAQueryGroupDesigner
extends SRFExHidden {
    protected QueryGroupDesignerConfig queryGroupDesignerConfig = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new QueryGroupDesignerConfig();
    }

    public QueryGroupDesignerConfig getQueryGroupDesignerConfig() {
        return this.queryGroupDesignerConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.queryGroupDesignerConfig = null;
        if (this.config != null && this.config instanceof QueryGroupDesignerConfig) {
            this.queryGroupDesignerConfig = (QueryGroupDesignerConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            writer.write(StringHelper.Format((String)"<DIV id='GRID_%1$s' ></DIV>", (Object)this.getUniqueID()));
            writer.write(StringHelper.Format((String)"<select name=\"DDL_ISGROUP_%1$s\" id=\"DDL_ISGROUP_%1$s\" style=\"display: none;\">\r\n", (Object)this.getUniqueID()));
            writer.write("<option value=\"TRUE\">\u5206\u7ec4</option>\r\n");
            writer.write("<option value=\"FALSE\">\u4e0d\u5206\u7ec4</option>\r\n");
            writer.write("</select>");
            writer.write(StringHelper.Format((String)"<select name=\"DDL_SD_%1$s\" id=\"DDL_SD_%1$s\" style=\"display: none;\">\r\n", (Object)this.getUniqueID()));
            writer.write("<option value=\"\">\u4e0d\u6392\u5e8f</option>\r\n");
            writer.write("<option value=\"ASC\">\u5347\u5e8f</option>\r\n");
            writer.write("<option value=\"DESC\">\u964d\u5e8f</option>\r\n");
            writer.write("</select>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.object['%1$s']={};\r\n", (Object)this.getUniqueID());
            script.Append("$P.object['%1$s'].renderisgroup = function(_1){\r\n", (Object)this.getUniqueID());
            script.Append("    if (_1 == 'TRUE')\r\n");
            script.Append("        return '\u5206\u7ec4';\r\n");
            script.Append("    return '\u4e0d\u5206\u7ec4';\r\n");
            script.Append("};\r\n");
            script.Append("$P.object['%1$s'].rendersd = function(_1){\r\n", (Object)this.getUniqueID());
            script.Append("    if (_1 == 'ASC')\r\n");
            script.Append("        return '\u5347\u5e8f';\r\n");
            script.Append("    if (_1 == 'DESC')\r\n");
            script.Append("        return '\u964d\u5e8f';\r\n");
            script.Append("    return '\u4e0d\u6392\u5e8f';\r\n");
            script.Append("};\r\n");
            script.Append("$P.object['%1$s'].expquerygroupconfig=function (XML,_1) {\r\n", (Object)this.getUniqueID());
            script.Append(" if (_1.getCount() == 0)\r\n");
            script.Append(" \treturn ;\r\n");
            script.Append(" XML.BeginNode('SRFDAQUERYGROUPMODEL');\r\n");
            script.Append(" for(i=0;i< _1.getCount();i++)\r\n");
            script.Append(" {\r\n");
            script.Append("        var rd = _1.getAt(i);\r\n");
            script.Append("        XML.BeginNode('SRFDAQUERYGROUPITEM');\r\n");
            script.Append("        XML.Attrib(\"ALIAS\", rd.get('alias'));\r\n");
            script.Append("        XML.Attrib(\"FORMULAR\", rd.get('formular'));\r\n");
            script.Append("        XML.Attrib(\"DEFIELDS\", rd.get('defields'));\r\n");
            script.Append("        XML.Attrib(\"ISGROUP\", rd.get('isgroup'));\r\n");
            script.Append("        XML.Attrib(\"ORDER\", rd.get('order'));\r\n");
            script.Append("        XML.Attrib(\"ORDERDIRECTION\", rd.get('orderdirection'));\r\n");
            script.Append("        XML.Attrib(\"USERTAG\", rd.get('usertag'));\r\n");
            script.Append("        XML.Attrib(\"USERTAG2\", rd.get('usertag2'));\r\n");
            script.Append("        XML.EndNode();\r\n");
            script.Append("        rd. commit();\r\n");
            script.Append(" }\r\n");
            script.Append("  XML.EndNode();\r\n");
            script.Append("};\r\n");
            script.Append("var _GRIDWIDTH = Ext.getDom('%1$s').parentNode.clientWidth-4;\r\n", (Object)this.getUniqueID());
            script.Append("var cm = new Ext.grid.ColumnModel([\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u522b\u540d\",\r\n");
            script.Append("   \tdataIndex: 'alias',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u516c\u5f0f\",\r\n");
            script.Append("   \tdataIndex: 'formular',\r\n");
            script.Append("     width: 200,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u5c5e\u6027\",\r\n");
            script.Append("   \tdataIndex: 'defields',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u662f\u5426\u5206\u7ec4\",\r\n");
            script.Append("   \tdataIndex: 'isgroup',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append("       renderer: $P.object['%1$s'].renderisgroup,\r\n", (Object)this.getUniqueID());
            script.Append("     editor: new Ext.form.ComboBox({\r\n");
            script.Append("          typeAhead: true,\r\n");
            script.Append("          triggerAction: 'all',\r\n");
            script.Append("          transform:'DDL_ISGROUP_%1$s',\r\n", (Object)this.getUniqueID());
            script.Append("          lazyRender:true,\r\n");
            script.Append("     \t allowBlank: false,\r\n");
            script.Append("          listClass: 'x-combo-list-small'\r\n");
            script.Append("         })\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u6392\u5e8f\u65b9\u5411\",\r\n");
            script.Append("   \tdataIndex: 'orderdirection',\r\n");
            script.Append("     width: 130,\r\n");
            script.Append("       renderer: $P.object['%1$s'].rendersd,\r\n", (Object)this.getUniqueID());
            script.Append("     editor: new Ext.form.ComboBox({\r\n");
            script.Append("          typeAhead: true,\r\n");
            script.Append("          triggerAction: 'all',\r\n");
            script.Append("          transform:'DDL_SD_%1$s',\r\n", (Object)this.getUniqueID());
            script.Append("          lazyRender:true,\r\n");
            script.Append("     \t allowBlank: true,\r\n");
            script.Append("          listClass: 'x-combo-list-small'\r\n");
            script.Append("         })\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u6392\u5e8f\u6b21\u5e8f\",\r\n");
            script.Append("   \tdataIndex: 'order',\r\n");
            script.Append("     width: 80,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u7528\u6237\u6570\u636e\",\r\n");
            script.Append("   \tdataIndex: 'usertag',\r\n");
            script.Append("     width: 80,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(",\r\n");
            script.Append("{\r\n");
            script.Append("     header: \"\u7528\u6237\u6570\u636e2\",\r\n");
            script.Append("   \tdataIndex: 'usertag2',\r\n");
            script.Append("     width: 80,\r\n");
            script.Append(" \teditor: new Ext.form.TextField({\r\n");
            script.Append("     allowBlank: true})\r\n");
            script.Append("\t}\r\n");
            script.Append(" ]);\r\n");
            script.Append("    cm.defaultSortable = true;\r\n");
            script.Append("\t    var QueryGroupItem = Ext.data.Record.create([\r\n");
            script.Append("\t           {name: 'alias', type: 'string'},\r\n");
            script.Append("\t           {name: 'formular', type: 'string'},\r\n");
            script.Append("\t           {name: 'defields', type: 'string'},\r\n");
            script.Append("\t           {name: 'isgroup',type: 'string'},\r\n");
            script.Append("\t           {name: 'orderdirection',type: 'string'},\r\n");
            script.Append("\t           {name: 'order',type: 'string'},\r\n");
            script.Append("\t           {name: 'usertag',type: 'string'},\r\n");
            script.Append("\t           {name: 'usertag2',type: 'string'}\r\n");
            script.Append("\t      ]);\r\n");
            script.Append("\t    var store = new Ext.data.Store({\r\n");
            script.Append("\t        url: '../srfds/xml2jsonbackend.jsp?MAJORACTION=QUERYGROUPITEM',\r\n");
            script.Append("\t        reader: new Ext.data.JsonReader({root: \"items\",totalProperty:\"totalrow\"  }\r\n");
            script.Append("\t         ,QueryGroupItem),\r\n");
            script.Append("\t        sortInfo:{field:'alias', direction:'ASC'}\r\n");
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
            script.Append("\t            text: '\u589e\u52a0\u9879\u76ee',\r\n");
            script.Append("\t            handler : function(){\r\n");
            script.Append("\t                var p = new QueryGroupItem({\r\n");
            script.Append("                    alias: '',\r\n");
            script.Append("                    formular: '',\r\n");
            script.Append("                    defields: '',\r\n");
            script.Append("                    isgroup: '',\r\n");
            script.Append("                    orderdirection: '',\r\n");
            script.Append("                    order: '',\r\n");
            script.Append("                    usertag: '',\r\n");
            script.Append("                    usertag2: ''\r\n");
            script.Append("                });\r\n");
            script.Append("              $P.grid['%1$s'].stopEditing();\r\n", (Object)this.getUniqueID());
            script.Append("             var index = $P.store['%1$s'].getCount();\r\n", (Object)this.getUniqueID());
            script.Append("              $P.store['%1$s'].insert(index, p);\r\n", (Object)this.getUniqueID());
            script.Append("              $P.grid['%1$s'].startEditing(index, 0);\r\n", (Object)this.getUniqueID());
            script.Append("            }}\r\n");
            script.Append("\t           ,{\r\n");
            script.Append("\t            text: '\u5220\u9664\u9879\u76ee',\r\n");
            script.Append("\t            handler : function(){\r\n");
            script.Append("               var rd =   $P.grid['%1$s'].getSelectionModel().getSelected();\r\n", (Object)this.getUniqueID());
            script.Append("\t              if(rd == null || rd == undefined)return;\r\n");
            script.Append("               $P.store['%1$s'].remove(rd);\r\n", (Object)this.getUniqueID());
            script.Append("            }}\r\n");
            script.Append("        ]\r\n");
            script.Append("\t    });\r\n");
            script.Append("$P.grid['%1$s'] = grid;\r\n", (Object)this.getUniqueID());
            script.Append("$P.store['%1$s'] = store;\r\n", (Object)this.getUniqueID());
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
            script.Append("$P.object['%1$s'].expquerygroupconfig(XML,$P.store['%1$s']);\r\n", (Object)this.getUniqueID());
            script.Append("XML.Close();\r\n");
            script.Append("_V = XML.ToString();\r\n");
            script.Append("if(_V!=''){_V = '<?xml version=\"1.0\" encoding=\"utf-8\" ?>'+_V}\r\n");
            script.Append("$FSV(_ID,_V);\r\n");
            return script.toString();
        }
        return StringHelper.Format((String)"if(_V==$FGV(_ID))break;$FSV(_ID,_V);$P.store['%1$s'].load({params:{xmlcontent:_V}});", (Object)this.getUniqueID());
    }
}

