/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.DataGridBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import java.io.Writer;
import java.util.ArrayList;

public class SL2DataGridBuilder
extends DataGridBuilder {
    @Override
    public void Render(Writer writer, SRFExDataGrid dataGrid) {
        try {
            DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            if (dataGridConfig.getWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)dataGridConfig.getWidth()));
            }
            if (dataGridConfig.getHeight() > 0) {
                styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)dataGridConfig.getHeight()));
            }
            writer.write("<DIV");
            String strClass = "sx-panel";
            if (StringHelper.Length((String)dataGridConfig.getCssClass()) > 0) {
                strClass = dataGridConfig.getCssClass();
            }
            SL2DataGridBuilder.OutputAttribute(writer, "class", strClass);
            SL2DataGridBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + dataGridConfig.getExtStyle());
            writer.write(" >");
            SL2DataGridBuilder.OutputScriptBegin(writer);
            String strScript = "";
            strScript = "";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"function func_%1$s_loaded(sender, args){\r\n", (Object)dataGrid.getUniqueID());
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var container = document.getElementById(\"%1$s\");\r\n", (Object)dataGrid.getUniqueID());
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _SL2DataGrid = container.Content.DataGrid;\r\n");
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"_SL2DataGrid.Init();\r\n");
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"_SL2DataGrid.SetSize(%1$s,%2$s);\r\n", (Object)dataGridConfig.getWidth(), (Object)dataGridConfig.getHeight());
            strScript = dataGridConfig.getSelectColumn() ? String.valueOf(strScript) + StringHelper.Format((String)" _SL2DataGrid.EnableRowSelect = true;\r\n") : String.valueOf(strScript) + StringHelper.Format((String)" _SL2DataGrid.EnableRowSelect = false;\r\n");
            strScript = dataGridConfig.getPaging() ? String.valueOf(strScript) + StringHelper.Format((String)" _SL2DataGrid.IsShowPagingBar = true;\r\n") : String.valueOf(strScript) + StringHelper.Format((String)" _SL2DataGrid.IsShowPagingBar = false;\r\n");
            strScript = String.valueOf(strScript) + StringHelper.Format((String)" _SL2DataGrid.SetColumnModel( {columns:[");
            ArrayList columns = dataGridConfig.getDataGridColumnsConfig().getList();
            int i = 0;
            while (i < columns.size()) {
                DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)columns.get(i));
                if (i != 0) {
                    strScript = String.valueOf(strScript) + ",\r\n";
                }
                strScript = String.valueOf(strScript) + "{";
                String strAttribute = "";
                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"caption: '%1$s'", (Object)dataGridColumnConfig.getCaption());
                if (dataGridColumnConfig.getWidth() > 0) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"width: %1$s", (Object)dataGridColumnConfig.getWidth());
                }
                strAttribute = String.valueOf(strAttribute) + ",";
                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"sortable: %1$s", (Object)(dataGridColumnConfig.getSortable() ? "true" : "false"));
                strAttribute = String.valueOf(strAttribute) + ",";
                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"locked: %1$s", (Object)(dataGridColumnConfig.getLocked() ? "true" : "false"));
                strAttribute = String.valueOf(strAttribute) + ",";
                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"dataIndex: '%1$s'", (Object)dataGridColumnConfig.getDSItem().toLowerCase());
                if (StringHelper.Length((String)dataGridColumnConfig.getCssClass()) > 0) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"css: '%1$s'", (Object)dataGridColumnConfig.getCssClass());
                }
                if (dataGridColumnConfig.getFixed()) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"fixed: true");
                }
                if (StringHelper.Length((String)dataGridColumnConfig.getAlign()) > 0) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"align: '%1$s'", (Object)dataGridColumnConfig.getAlign());
                }
                if (dataGridColumnConfig.getHidden()) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"hidden: %1$s", (Object)(dataGridColumnConfig.getHidden() ? "true" : "false"));
                }
                if (dataGridConfig.getEditable() && StringHelper.Length((String)dataGridColumnConfig.getEditor()) > 0) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"editor: %1$s", (Object)dataGridColumnConfig.getEditor());
                }
                if (dataGridColumnConfig.getXamlContent()) {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"cellasxaml: true");
                } else {
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"cellasxaml: false");
                }
                strScript = String.valueOf(strScript) + strAttribute;
                strScript = String.valueOf(strScript) + "}";
                ++i;
            }
            strScript = String.valueOf(strScript) + "]});\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.grid['%1$s'].setgrid(_SL2DataGrid);\r\n", (Object)dataGrid.getUniqueID());
            strScript = String.valueOf(strScript) + "}\r\n";
            writer.write(strScript);
            strScript = "";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"function func_%1$s(){\r\n", (Object)dataGrid.getUniqueID());
            String strURL = dataGridConfig.getDataURL();
            if (StringHelper.Length((String)strURL) == 0) {
                strURL = dataGrid.getPage().getDefaultBackEndUrl();
            }
            if (StringHelper.Length((String)strURL) > 0) {
                int nPos = strURL.indexOf("?");
                if (nPos == -1) {
                    strURL = String.valueOf(strURL) + "?";
                } else if (nPos != strURL.length() - 1) {
                    strURL = String.valueOf(strURL) + "&";
                }
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var httpProxy = new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:30000,url:'%1$s'}));\r\n", (Object)strURL);
                strScript = String.valueOf(strScript) + "var RecordDef = Ext.data.Record.create([";
                if (dataGridConfig.getSelectColumn()) {
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name: 'SELECTCOLUMN'}");
                    strScript = String.valueOf(strScript) + ",";
                }
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name: 'KEYS'}");
                ArrayList dsItems = dataGridConfig.getDataGridDSConfig().getList();
                int i2 = 0;
                while (i2 < dsItems.size()) {
                    DataGridDSItemConfig dsItem = (DataGridDSItemConfig)((Object)dsItems.get(i2));
                    strScript = String.valueOf(strScript) + ",";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name: '%1$s'}", (Object)dsItem.getID().toLowerCase());
                    if (dsItem.getKey()) {
                        strScript = String.valueOf(strScript) + ",";
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name: '%1$s'}", (Object)dsItem.getID().toUpperCase());
                    }
                    ++i2;
                }
                strScript = String.valueOf(strScript) + "]);\r\n";
                strScript = String.valueOf(strScript) + "var myReader = new Ext.data.JsonReader({ root: \"items\"";
                if (dataGridConfig.getPaging()) {
                    strScript = String.valueOf(strScript) + ",totalProperty: \"totalrow\"";
                }
                strScript = String.valueOf(strScript) + "}, RecordDef);\r\n";
                strScript = String.valueOf(strScript) + "var _S = new Ext.data.Store({proxy:httpProxy,reader:myReader,remoteSort:true});\r\n";
                strScript = String.valueOf(strScript) + "_S.userparams = {};\r\n";
                strScript = String.valueOf(strScript) + "_S.on('beforeload',onfillparams);\r\n";
                strScript = String.valueOf(strScript) + "_S.on('load',onsearchback);\r\n";
                strScript = String.valueOf(strScript) + "_S.on('loadexception',onfetcherror);\r\n";
                if (StringHelper.Length((String)dataGridConfig.getDataGridDSConfig().getSortField()) > 0) {
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_S.setDefaultSort('%1$s','%2$s');\r\n", (Object)dataGridConfig.getDataGridDSConfig().getSortField().toLowerCase(), (Object)(dataGridConfig.getDataGridDSConfig().getSortDesc() ? "DESC" : "ASC"));
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_S.sortToggle['%1$s'] = '%2$s';\r\n", (Object)dataGridConfig.getDataGridDSConfig().getSortField().toLowerCase(), (Object)(dataGridConfig.getDataGridDSConfig().getSortDesc() ? "DESC" : "ASC"));
                }
                strScript = dataGridConfig.getPaging() ? String.valueOf(strScript) + StringHelper.Format((String)"_S.loaddefault=function(){$P.store['%1$s'].load({params:{start:0, limit:%2$s}});};\r\n", (Object)dataGrid.getUniqueID(), (Object)dataGridConfig.getDataGridPagingConfig().getPageSize()) : String.valueOf(strScript) + StringHelper.Format((String)"_S.loaddefault=function(){$P.store['%1$s'].load({params:{}});};\r\n", (Object)dataGrid.getUniqueID());
                strScript = dataGridConfig.getEditable() ? String.valueOf(strScript) + StringHelper.Format((String)" var _G = new SRFGridEx( {pagesize:%1$s,\r\n", (Object)dataGridConfig.getDataGridPagingConfig().getPageSize()) : String.valueOf(strScript) + StringHelper.Format((String)" var _G = new SRFGridEx( {pagesize:%1$s,\r\n", (Object)dataGridConfig.getDataGridPagingConfig().getPageSize());
                strScript = String.valueOf(strScript) + "  ds: _S});\r\n";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.grid['%1$s'] = _G;\r\n", (Object)dataGrid.getUniqueID());
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.store['%1$s'] = _S;\r\n", (Object)dataGrid.getUniqueID());
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var gridmgr = new SRFSL2GridMgr({gridid:'%1$s',grid:_G,store:_S,sortfield:'%2$s',sortdir:'%3$s',dgurl:'%4$s',gridthemeid:'%5$s',url:'%6$s',rd:RecordDef});\r\n", (Object)dataGrid.getUniqueID(), (Object)dataGridConfig.getDataGridDSConfig().getSortField().toLowerCase(), (Object)(dataGridConfig.getDataGridDSConfig().getSortDesc() ? "DESC" : "ASC"), (Object)dataGrid.getPage().getWebContext().getWebConfig().GetExtValue("DATAGRIDTHEME", ""), (Object)(String.valueOf(dataGrid.getPage().getWebContext().getCurPageName()) + dataGridConfig.getConfigId()).toUpperCase(), (Object)strURL);
                strScript = String.valueOf(strScript) + "_G.gridmgr = gridmgr;\r\n";
                strScript = String.valueOf(strScript) + "function onfillparams(_T,_OP){\r\n";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"_OP.params['gridid'] = '%1$s';\r\n", (Object)dataGrid.getUniqueID());
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"_OP.params['action'] = 'fetch';\r\n");
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"_OP.params['actiontype'] = 'gridaction';\r\n");
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"Ext.apply( _OP.params,_T.userparams);\r\n");
                strScript = String.valueOf(strScript) + "}\r\n";
                strScript = String.valueOf(strScript) + "function onsearchback(_T,_R,_O){\r\n";
                strScript = String.valueOf(strScript) + "if(_T.reader.jsonData.ret!=0)";
                strScript = String.valueOf(strScript) + "{ alert('\u7cfb\u7edf\u5185\u90e8\u5904\u7406\u51fa\u73b0\u9519\u8bef\uff0c\u9519\u8bef\u539f\u56e0\u4e3a\uff1a'+_T.reader.jsonData.info+'\uff0c\u8bf7\u4e0e\u7ba1\u7406\u5458\u8054\u7cfb!');\r\n";
                strScript = String.valueOf(strScript) + "}\r\n";
                strScript = String.valueOf(strScript) + "}\r\n";
                strScript = String.valueOf(strScript) + "function onfetcherror(){\r\n";
                strScript = String.valueOf(strScript) + "alert('\u65e0\u6cd5\u5411\u670d\u52a1\u5668\u53d1\u9001\u60a8\u7684\u8bf7\u6c42\uff0c\u8bf7\u4e0e\u7ba1\u7406\u5458\u8054\u7cfb!');";
                strScript = String.valueOf(strScript) + "}\r\n";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var container = document.getElementById(\"%1$s\");\r\n", (Object)dataGrid.getUniqueID());
                strScript = String.valueOf(strScript) + "container.source = \"../sasrf_sl2/SRFDataGrid.xap\";";
            }
            strScript = String.valueOf(strScript) + "}\r\n";
            writer.write(strScript);
            strScript = "";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"func_%1$s();\r\n", (Object)dataGrid.getUniqueID());
            dataGrid.getPage().RegisterScript(2, strScript);
            strScript = "";
            SL2DataGridBuilder.OutputScriptEnd(writer);
            writer.write(StringHelper.Format((String)"<object id=\"%1$s\" data=\"data:application/x-silverlight,\" type=\"application/x-silverlight-2\"", (Object)dataGrid.getUniqueID()));
            if (dataGridConfig.getWidth() > 0) {
                writer.write(StringHelper.Format((String)" width=\"%1$s\" ", (Object)dataGridConfig.getWidth()));
            } else {
                writer.write(StringHelper.Format((String)" width=\"100%\" "));
            }
            if (dataGridConfig.getHeight() > 0) {
                writer.write(StringHelper.Format((String)" height=\"%1$s\" ", (Object)dataGridConfig.getHeight()));
            } else {
                writer.write(StringHelper.Format((String)" height=\"100%\" "));
            }
            writer.write(">\r\n");
            writer.write(StringHelper.Format((String)"<param name=\"onload\" value=\"func_%1$s_loaded\"/>\r\n", (Object)dataGrid.getUniqueID()));
            writer.write("<param name=\"background\" value=\"white\" />\r\n");
            writer.write("<param name=\"minRuntimeVersion\" value=\"2.0.31005.0\" />\r\n");
            writer.write("<param name=\"autoUpgrade\" value=\"true\" />\r\n");
            writer.write("<a href=\"http://go.microsoft.com/fwlink/?LinkID=115261\" style=\"text-decoration: none;\">\r\n");
            writer.write("<img src=\"http://go.microsoft.com/fwlink/?LinkId=108181\" alt=\"Get Microsoft Silverlight\" style=\"border-style: none\"/>\r\n");
            writer.write("</a>\r\n");
            writer.write("</object>\r\n");
            writer.write("</DIV>");
            if (dataGridConfig.getLoadDefault()) {
                strScript = "";
                strScript = String.valueOf(strScript) + "Ext.onReady(function(){\r\n";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.store['%1$s'].loaddefault();\r\n", (Object)dataGrid.getUniqueID());
                strScript = String.valueOf(strScript) + "});\r\n";
                dataGrid.getPage().RegisterScript(5, strScript);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return "SL2";
    }

    @Override
    public String getBuilderName() {
        return "DATAGRID";
    }
}

