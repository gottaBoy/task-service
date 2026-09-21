/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Builder.ColumnHeaderGroupDataGridBuilder;
import SA.SRFramework.WebEx.Builder.DataGridBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridACEditor;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridColumnRender;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridComboEditor;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridPickerEditor;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridRowClassHelper;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridTextEditor;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridACEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridBaseEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridComboEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridPickerEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridTextEditorConfig;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorsConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnRendersConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultDataGridBuilder2
extends DataGridBuilder {
    public static final String TAG_SRFEXDATAGRID = "SRFEXDATAGRID";
    private static final Log log = LogFactory.getLog(ColumnHeaderGroupDataGridBuilder.class);

    @Override
    public void Render(Writer writer, SRFExDataGrid dataGrid) {
        try {
            String strScript;
            DataGridConfig dataGridConfig;
            block96: {
                DataGridColumnEditorsConfig dataGridColumnEditorsConfig;
                dataGridConfig = dataGrid.getDataGridConfig();
                StyleBuilder styleBuilder = new StyleBuilder();
                styleBuilder.AddStyle("width", dataGridConfig.getWidthString());
                styleBuilder.AddStyle("height", dataGridConfig.getHeightString());
                writer.write("<DIV");
                DefaultDataGridBuilder2.OutputAttribute(writer, "id", dataGrid.getUniqueID());
                String strClass = "sx-panel";
                if (StringHelper.Length((String)dataGridConfig.getCssClass()) > 0) {
                    strClass = dataGridConfig.getCssClass();
                }
                DefaultDataGridBuilder2.OutputAttribute(writer, "class", strClass);
                DefaultDataGridBuilder2.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + dataGridConfig.getExtStyle());
                writer.write(" >");
                writer.write("</DIV>");
                String strPlugins = "";
                strScript = "";
                ArrayList columns = dataGridConfig.getDataGridColumnsConfig().getList();
                int i = 0;
                while (i < columns.size()) {
                    DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)columns.get(i));
                    if (StringHelper.Length((String)dataGridColumnConfig.getRenderer()) > 0) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"function renderer_%1$s(value){%2$s};\r\n", (Object)i, (Object)dataGridColumnConfig.getRenderer());
                    }
                    ++i;
                }
                DataGridColumnRendersConfig dgColumnRendersConfig = dataGridConfig.getDataGridColumnRendersConfig(false);
                if (dgColumnRendersConfig != null) {
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.gridrender['%1$s']={};\r\n", (Object)dataGrid.getUniqueID());
                    int i2 = 0;
                    while (i2 < dgColumnRendersConfig.getList().size()) {
                        DataGridColumnRenderConfig columnRenderConfig = (DataGridColumnRenderConfig)((Object)dgColumnRendersConfig.getList().get(i2));
                        Object objRender = ObjectHelper.Create(columnRenderConfig.getObject());
                        if (objRender == null) {
                            dataGrid.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u521b\u5efa\u5217\u7ed8\u5236\u5668\u5bf9\u8c61[%1$s]", (Object)columnRenderConfig.getObject()));
                        } else if (!(objRender instanceof SRFExDataGridColumnRender)) {
                            dataGrid.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5217\u7ed8\u5236\u5668\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)columnRenderConfig.getObject()));
                        } else {
                            SRFExDataGridColumnRender render = (SRFExDataGridColumnRender)objRender;
                            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.gridrender['%3$s']['%1$s']=function(value){%2$s};\r\n", (Object)columnRenderConfig.getID(), (Object)render.GetJSCode(dataGrid, columnRenderConfig), (Object)dataGrid.getUniqueID());
                        }
                        ++i2;
                    }
                }
                boolean bSortable = dataGridConfig.getDataGridDSConfig().getSortable();
                boolean bNoDefSort = dataGridConfig.getDataGridDSConfig().getNoDefSort();
                if (dataGridConfig.isRowExpander()) {
                    if (!StringHelper.IsNullOrEmpty((String)strPlugins)) {
                        strPlugins = String.valueOf(strPlugins) + ",";
                    }
                    strPlugins = String.valueOf(strPlugins) + "expander";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var expander=new Ext.ux.grid.RowExpander({tpl:new Ext.Template('%1$s')});", (Object)dataGridConfig.getRowExpanderParam().replaceAll("'", "\""));
                }
                Vector<JSONObject> columnHeaderGroups = new Vector<JSONObject>();
                strScript = String.valueOf(strScript) + "var colModel=new Ext.grid.ColumnModel([\r\n";
                if (dataGridConfig.isRowExpander()) {
                    strScript = String.valueOf(strScript) + "expander,";
                }
                if (dataGridConfig.getSelectColumn()) {
                    strScript = String.valueOf(strScript) + "{";
                    String strAttribute = "";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"header:'%1$s'", (Object)dataGrid.getWebContext().getLocalText(TAG_SRFEXDATAGRID, "COLUMN_SELECT_TEXT", "\u9009\u62e9"));
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"width:34");
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"sortable:false");
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"locked:true");
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"dataIndex:'SELECTCOLUMN'");
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"fixed:true");
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"hideable:false");
                    strAttribute = String.valueOf(strAttribute) + ",";
                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"menuDisabled:true");
                    strScript = String.valueOf(strScript) + strAttribute;
                    strScript = String.valueOf(strScript) + "}";
                    JSONObject columnHeaderGroup = new JSONObject();
                    columnHeaderGroup.put("header", (Object)"");
                    columnHeaderGroup.put("colspan", 1);
                    columnHeaderGroup.put("align", (Object)"center");
                    columnHeaderGroups.add(columnHeaderGroup);
                }
                IUserPrivilegeMgr iUserPrivilegeMgr = dataGrid.getWebContext().GetUserPrivilegeMgr();
                String strRowBodyDSItem = "";
                boolean bFirstColumn = !dataGridConfig.getSelectColumn();
                int i3 = 0;
                while (i3 < columns.size()) {
                    DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)columns.get(i3));
                    if (!dataGrid.isEnableItemPrivilege() || StringHelper.IsNullOrEmpty((String)dataGridColumnConfig.getPrivilegeId()) || iUserPrivilegeMgr.TestColumn(dataGrid.getWebContext(), dataGridColumnConfig.getPrivilegeId()) != 0) {
                        if (dataGridColumnConfig.getRowBody()) {
                            strRowBodyDSItem = dataGridColumnConfig.getDSItem().toLowerCase();
                        } else {
                            JSONObject columnHeaderGroup = null;
                            if (columnHeaderGroups.size() > 0) {
                                columnHeaderGroup = (JSONObject)columnHeaderGroups.get(columnHeaderGroups.size() - 1);
                                String strHeader = columnHeaderGroup.getString("header");
                                if (StringHelper.Compare((String)strHeader, (String)dataGridColumnConfig.getGroupColumn(), (boolean)true) == 0) {
                                    long nColSpan = columnHeaderGroup.getLong("colspan");
                                    columnHeaderGroup.remove("colspan");
                                    columnHeaderGroup.put("colspan", ++nColSpan);
                                } else {
                                    columnHeaderGroup = null;
                                }
                            }
                            if (columnHeaderGroup == null) {
                                columnHeaderGroup = new JSONObject();
                                columnHeaderGroup.put("header", (Object)dataGridColumnConfig.getGroupColumn());
                                columnHeaderGroup.put("colspan", 1);
                                columnHeaderGroup.put("align", (Object)"center");
                                columnHeaderGroups.add(columnHeaderGroup);
                            }
                            if (bFirstColumn) {
                                bFirstColumn = !bFirstColumn;
                            } else {
                                strScript = String.valueOf(strScript) + ",\r\n";
                            }
                            strScript = String.valueOf(strScript) + "{";
                            String strAttribute = "";
                            strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"header:'%1$s'", (Object)dataGridColumnConfig.getCaption());
                            if (dataGridColumnConfig.getWidth() > 0) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"width:%1$s", (Object)dataGridColumnConfig.getWidth());
                            }
                            strAttribute = String.valueOf(strAttribute) + ",";
                            strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"sortable:%1$s", (Object)(dataGridColumnConfig.getSortable() && bSortable ? "true" : "false"));
                            strAttribute = String.valueOf(strAttribute) + ",";
                            strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"locked:%1$s", (Object)(dataGridColumnConfig.getLocked() ? "true" : "false"));
                            strAttribute = String.valueOf(strAttribute) + ",";
                            strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"dataIndex:'%1$s'", (Object)dataGridColumnConfig.getDSItem().toLowerCase());
                            if (StringHelper.Length((String)dataGridColumnConfig.getCssClass()) > 0) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"css:'%1$s'", (Object)dataGridColumnConfig.getCssClass());
                            }
                            if (dataGridColumnConfig.getFixed()) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"fixed:true");
                            }
                            if (StringHelper.Length((String)dataGridColumnConfig.getAlign()) > 0) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"align:'%1$s'", (Object)dataGridColumnConfig.getAlign());
                            }
                            if (!dataGridColumnConfig.isHideable()) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"hideable:false");
                            }
                            if (dataGridColumnConfig.isMenuDisabled()) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"menuDisabled:true");
                            }
                            if (dataGridColumnConfig.getHidden()) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"hidden:%1$s", (Object)(dataGridColumnConfig.getHidden() ? "true" : "false"));
                            }
                            if (StringHelper.Length((String)dataGridColumnConfig.getRenderer()) > 0) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"renderer:renderer_%1$s", (Object)i3);
                            } else if (!StringHelper.IsNullOrEmpty((String)dataGridColumnConfig.getRenderId()) && dgColumnRendersConfig != null) {
                                strAttribute = String.valueOf(strAttribute) + ",";
                                strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)"renderer:$P.gridrender['%1$s']['%2$s']", (Object)dataGrid.getUniqueID(), (Object)dataGridColumnConfig.getRenderId());
                            }
                            if (dataGridConfig.getEditable()) {
                                if (StringHelper.Length((String)dataGridColumnConfig.getEditor()) > 0) {
                                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)",editor:%1$s", (Object)dataGridColumnConfig.getEditor());
                                } else if (StringHelper.Length((String)dataGridColumnConfig.getEditorId()) > 0) {
                                    strAttribute = String.valueOf(strAttribute) + StringHelper.Format((String)",editor:$P.grideditor['%1$s'].%2$s", (Object)dataGrid.getUniqueID(), (Object)dataGridColumnConfig.getEditorId().toLowerCase());
                                }
                            }
                            strScript = String.valueOf(strScript) + strAttribute;
                            strScript = String.valueOf(strScript) + "}";
                        }
                    }
                    ++i3;
                }
                strScript = String.valueOf(strScript) + "]);\r\n";
                if (columnHeaderGroups.size() > 1) {
                    JSONArray ja = JSONArray.fromArray((Object[])columnHeaderGroups.toArray());
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)" var columngroup = new Ext.ux.grid.ColumnHeaderGroup({ rows: [%1$s]});", (Object)ja.toString());
                    if (!StringHelper.IsNullOrEmpty((String)strPlugins)) {
                        strPlugins = String.valueOf(strPlugins) + ",";
                    }
                    strPlugins = String.valueOf(strPlugins) + "columngroup";
                }
                String strKeyItems = "";
                String strURL = dataGridConfig.getDataURL();
                if (StringHelper.Length((String)strURL) == 0) {
                    strURL = dataGrid.getPage().getDefaultBackEndUrl();
                }
                if (StringHelper.Length((String)strURL) > 0) {
                    DataGridDSItemConfig dsItem;
                    SRFExDataGridRowClassHelper rowClassHelper;
                    int nPos = strURL.indexOf("?");
                    if (nPos == -1) {
                        strURL = String.valueOf(strURL) + "?";
                    } else if (nPos != strURL.length() - 1) {
                        strURL = String.valueOf(strURL) + "&";
                    }
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var httpProxy=new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:%2$s,url:'%1$s'}));\r\n", (Object)strURL, (Object)dataGridConfig.getTimeout());
                    strScript = String.valueOf(strScript) + "var RecordDef=Ext.data.Record.create([";
                    if (dataGridConfig.getSelectColumn()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name:'SELECTCOLUMN'}");
                        strScript = String.valueOf(strScript) + ",";
                    }
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name:'KEYS'}");
                    ArrayList dsItems = dataGridConfig.getDataGridDSConfig().getList();
                    int i4 = 0;
                    while (i4 < dsItems.size()) {
                        DataGridDSItemConfig dsItem2 = (DataGridDSItemConfig)((Object)dsItems.get(i4));
                        if (iUserPrivilegeMgr.TestColumn(dataGrid.getWebContext(), dsItem2.getPrivilegeId()) != 0) {
                            strScript = String.valueOf(strScript) + ",";
                            strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name:'%1$s'}", (Object)dsItem2.getID().toLowerCase());
                            if (dsItem2.getKey()) {
                                strScript = String.valueOf(strScript) + ",";
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)"{name:'%1$s'}", (Object)dsItem2.getID().toUpperCase());
                                if (!StringHelper.IsNullOrEmpty((String)strKeyItems)) {
                                    strKeyItems = String.valueOf(strKeyItems) + ",";
                                }
                                strKeyItems = String.valueOf(strKeyItems) + StringHelper.Format((String)"'%1$s'", (Object)dsItem2.getID().toUpperCase());
                            }
                        }
                        ++i4;
                    }
                    strScript = String.valueOf(strScript) + "]);\r\n";
                    strScript = StringHelper.Compare((String)dataGridConfig.getResponseType(), (String)"JSONARRAY", (boolean)true) == 0 ? String.valueOf(strScript) + "var myReader=new Ext.data.ArrayReader({root:\"items\"" : String.valueOf(strScript) + "var myReader=new Ext.data.JsonReader({root:\"items\"";
                    if (dataGridConfig.getPaging()) {
                        strScript = String.valueOf(strScript) + ",totalProperty:\"totalrow\"";
                    }
                    strScript = String.valueOf(strScript) + ",summaryinfo:\"summaryinfo\"";
                    strScript = String.valueOf(strScript) + ",code:\"code\"";
                    strScript = String.valueOf(strScript) + ",url:\"url\"";
                    strScript = String.valueOf(strScript) + "},RecordDef);\r\n";
                    String strGroupItem = "";
                    if (dataGridConfig.isGroup()) {
                        String strGroupDir = "ASC";
                        if (dataGridConfig.getDataGridGroupConfig(false) != null) {
                            strGroupItem = dataGridConfig.getDataGridGroupConfig(false).getGroupItem();
                            strGroupDir = dataGridConfig.getDataGridGroupConfig(false).getGroupDir();
                            if (StringHelper.IsNullOrEmpty((String)strGroupDir)) {
                                strGroupDir = "ASC";
                            }
                        }
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _S=new Ext.data.GroupingStore({groupField:'%1$s',proxy:httpProxy,reader:myReader,remoteSort:true", (Object)strGroupItem.toLowerCase());
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",groupDir:'%1$s'", (Object)strGroupDir);
                        strScript = String.valueOf(strScript) + "});\r\n";
                    } else {
                        strScript = String.valueOf(strScript) + "var _S=new Ext.data.Store({proxy:httpProxy,reader:myReader,remoteSort:true});\r\n";
                    }
                    if (dataGridConfig.getEditable()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_S.on('beforeload',function(_1,_2){return !$P.grid['%1$s'].gridmgr.isloadcancel();});\r\n", (Object)dataGrid.getUniqueID());
                    }
                    strScript = String.valueOf(strScript) + "_S.retryCount=0;\r\n";
                    strScript = String.valueOf(strScript) + "_S.userparams={};\r\n";
                    strScript = String.valueOf(strScript) + "_S.sysparams={};\r\n";
                    if (!bNoDefSort && bSortable && !StringHelper.IsNullOrEmpty((String)dataGridConfig.getDataGridDSConfig().getSortField())) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_S.setDefaultSort('%1$s','%2$s');\r\n", (Object)dataGridConfig.getDataGridDSConfig().getSortField().toLowerCase(), (Object)(dataGridConfig.getDataGridDSConfig().getSortDesc() ? "DESC" : "ASC"));
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_S.sortToggle['%1$s']='%2$s';\r\n", (Object)dataGridConfig.getDataGridDSConfig().getSortField().toLowerCase(), (Object)(dataGridConfig.getDataGridDSConfig().getSortDesc() ? "DESC" : "ASC"));
                    }
                    strScript = dataGridConfig.getPaging() ? String.valueOf(strScript) + StringHelper.Format((String)"_S.loaddefault=function(){var _S=%2$s;if($P.store['%1$s'].lastOptions){_S=$P.store['%1$s'].lastOptions.params.limit;} $P.store['%1$s'].load({params:{start:0, limit:_S}});};\r\n", (Object)dataGrid.getUniqueID(), (Object)dataGridConfig.getDataGridPagingConfig().getPageSize()) : String.valueOf(strScript) + StringHelper.Format((String)"_S.loaddefault=function(){$P.store['%1$s'].load({params:{}});};\r\n", (Object)dataGrid.getUniqueID());
                    strScript = dataGridConfig.getEditable() ? String.valueOf(strScript) + StringHelper.Format((String)"var _G=new Ext.grid.EditorGridPanel({el:'%1$s',\r\n", (Object)dataGrid.getUniqueID()) : String.valueOf(strScript) + StringHelper.Format((String)"var _G=new Ext.grid.GridPanel({el:'%1$s',\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + "store:_S,cm:colModel";
                    if (dataGridConfig.isHideHeader()) {
                        strScript = String.valueOf(strScript) + ",hideHeaders:true";
                    }
                    if (dataGridConfig.isStripeRows()) {
                        strScript = String.valueOf(strScript) + ",stripeRows:true";
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strPlugins)) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",plugins:[%1$s]", (Object)strPlugins);
                    }
                    if (dataGridConfig.getWidth() > 0) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",width:%1$s", (Object)dataGridConfig.getWidth());
                    }
                    if (dataGridConfig.getHeight() > 0) {
                        int nHeight = dataGridConfig.getHeight();
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",height:%1$s", (Object)nHeight);
                    }
                    strScript = dataGridConfig.isMultiSelect() ? String.valueOf(strScript) + ",sm:new Ext.grid.RowSelectionModel({singleSelect:false})" : String.valueOf(strScript) + ",sm:new Ext.grid.RowSelectionModel({singleSelect:true})";
                    if (dataGridConfig.getEditable() && dataGridConfig.getClicksToEdit() != 2) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",clicksToEdit:%1$s", (Object)dataGridConfig.getClicksToEdit());
                    }
                    if (!dataGridConfig.getBorder()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",border:false");
                    }
                    if (!StringHelper.IsNullOrEmpty((String)dataGridConfig.getDataGridColumnsConfig().getAutoExpandColumn())) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",autoExpandColumn:'%1$s'", (Object)dataGridConfig.getDataGridColumnsConfig().getAutoExpandColumn());
                    }
                    if (dataGridConfig.isGroup()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",view:new Ext.grid.GroupingView({forceFit:%1$s,hideGroupedColumn:true,groupTextTpl:'{text}'", (Object)(dataGridConfig.isForceFit() ? "true" : "false"));
                        if (!dataGridConfig.isDeferEmptyText()) {
                            strScript = String.valueOf(strScript) + ",deferEmptyText:false,emptyText:$P.msg['dgnotload']";
                        }
                        if (!StringHelper.IsNullOrEmpty((String)dataGridConfig.getRowClassHelper())) {
                            Object objRowClassHelper = ObjectHelper.Create(dataGridConfig.getRowClassHelper());
                            if (objRowClassHelper == null) {
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)",getRowClass:%1$s", (Object)dataGridConfig.getRowClassHelper());
                            } else if (objRowClassHelper instanceof SRFExDataGridRowClassHelper) {
                                rowClassHelper = (SRFExDataGridRowClassHelper)objRowClassHelper;
                                strScript = rowClassHelper.IsEnableRowBody() ? String.valueOf(strScript) + StringHelper.Format((String)",showPreview:true,enableRowBody:true,getRowClass:function(record,index,rp,ds){var ROWBODY='%2$s'; %1$s}", (Object)rowClassHelper.GetJSCode(dataGrid), (Object)strRowBodyDSItem) : String.valueOf(strScript) + StringHelper.Format((String)",getRowClass:function(record,index){%1$s}", (Object)rowClassHelper.GetJSCode(dataGrid));
                            } else {
                                log.error((Object)StringHelper.Format((String)"\u884c\u6837\u5f0f\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)dataGridConfig.getRowClassHelper()));
                            }
                        }
                        strScript = String.valueOf(strScript) + "})";
                    } else {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",viewConfig:{forceFit:%1$s", (Object)(dataGridConfig.isForceFit() ? "true" : "false"));
                        if (!dataGridConfig.isDeferEmptyText()) {
                            strScript = String.valueOf(strScript) + ",deferEmptyText:false,emptyText:$P.msg['dgnotload']";
                        }
                        if (!StringHelper.IsNullOrEmpty((String)dataGridConfig.getRowClassHelper())) {
                            Object objRowClassHelper = ObjectHelper.Create(dataGridConfig.getRowClassHelper());
                            if (objRowClassHelper == null) {
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)",getRowClass:%1$s", (Object)dataGridConfig.getRowClassHelper());
                            } else if (objRowClassHelper instanceof SRFExDataGridRowClassHelper) {
                                rowClassHelper = (SRFExDataGridRowClassHelper)objRowClassHelper;
                                strScript = rowClassHelper.IsEnableRowBody() ? String.valueOf(strScript) + StringHelper.Format((String)",showPreview:true,enableRowBody:true,getRowClass:function(record,index,rp,ds){var ROWBODY='%2$s';%1$s}", (Object)rowClassHelper.GetJSCode(dataGrid), (Object)strRowBodyDSItem) : String.valueOf(strScript) + StringHelper.Format((String)",getRowClass:function(record,index){%1$s}", (Object)rowClassHelper.GetJSCode(dataGrid));
                            } else {
                                log.error((Object)StringHelper.Format((String)"\u884c\u6837\u5f0f\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)dataGridConfig.getRowClassHelper()));
                            }
                        }
                        strScript = String.valueOf(strScript) + "}";
                    }
                    if (!StringHelper.IsNullOrEmpty((String)dataGridConfig.getLoadingMsg())) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)",loadMask:{msg:'%1$s'}", (Object)dataGridConfig.getLoadingMsg());
                    }
                    strScript = String.valueOf(strScript) + "});\r\n";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _GV=_G.getView();\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_GV.sortAscText='\u4ece\u5c0f\u5230\u5927';\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_GV.sortDescText='\u4ece\u5927\u5230\u5c0f';\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_GV.columnsText='\u5217\u96c6\u5408';\r\n");
                    if (dataGridConfig.isGroup()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_GV.groupByText='\u6309\u6b64\u5217\u5206\u7ec4';\r\n");
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_GV.showGroupsText='\u663e\u793a\u5206\u7ec4';\r\n");
                    }
                    strScript = String.valueOf(strScript) + "_G.render();\r\n";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.grid['%1$s']=_G;\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.store['%1$s']=_S;\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var gridmgr=new SRFGridMgr({gridid:'%1$s',grid:_G,store:_S,sortfield:'%2$s',sortdir:'%3$s',dgurl:'%4$s',gridthemeid:'%5$s',url:'%6$s',rd:RecordDef,editgrid:%7$s,tempdata:%8$s,dgtheme:%9$s});\r\n", (Object)dataGrid.getUniqueID(), (Object)dataGridConfig.getDataGridDSConfig().getSortField().toLowerCase(), (Object)(dataGridConfig.getDataGridDSConfig().getSortDesc() ? "DESC" : "ASC"), (Object)dataGrid.getPage().getWebContext().getWebConfig().GetExtValue("DATAGRIDTHEME", ""), (Object)(String.valueOf(dataGrid.getPage().getWebContext().getCurPageName()) + dataGridConfig.getConfigId()).toUpperCase(), (Object)strURL, (Object)(dataGridConfig.getEditable() ? "true" : "false"), (Object)(dataGridConfig.isTempData() ? "true" : "false"), (Object)(dataGridConfig.isUserTheme() ? "true" : "false"));
                    strScript = String.valueOf(strScript) + "_G.gridmgr=gridmgr;\r\n";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_G.gridmgr.KEYS=[%1$s];\r\n", (Object)strKeyItems);
                    if (dataGridConfig.getEditable()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_G.on('beforeedit',function(_1){$P.grid['%1$s'].gridmgr.AR =_1.record;});\r\n", (Object)dataGrid.getUniqueID());
                    }
                    strScript = String.valueOf(strScript) + "_S._onfillparams=function(_T,_OP){\r\n";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _G=$P.grid['%1$s'];\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(_G.gridmgr.getlastsortfield){\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _CURSORTFIELD = (_T.sortInfo!=null)?_T.sortInfo.field:'';\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _LASTSORTFIELD=_G.gridmgr.getlastsortfield(_CURSORTFIELD);\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _LASTSORTDIR=_G.gridmgr.getlastsortdir(_CURSORTFIELD);\r\n");
                    strScript = String.valueOf(strScript) + "_OP.params['realsort2']='';\r\n";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(_LASTSORTFIELD){\r\n_OP.params['sort2']=_LASTSORTFIELD;_OP.params['dir2']=_LASTSORTDIR;\r\n");
                    boolean bTranslateSortParam = false;
                    int i5 = 0;
                    while (i5 < dsItems.size()) {
                        dsItem = (DataGridDSItemConfig)((Object)dsItems.get(i5));
                        if (StringHelper.Compare((String)dsItem.getID(), (String)dsItem.getSortParam(), (boolean)true) != 0) {
                            strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(_LASTSORTFIELD=='%1$s'){_OP.params['realsort2']='%2$s';}\r\n", (Object)dsItem.getID().toLowerCase(), (Object)dsItem.getSortParam().toLowerCase());
                        }
                        ++i5;
                    }
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"}\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"}\r\n");
                    if (!dataGridConfig.isDeferEmptyText()) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"_G.getView().emptyText=$P.msg['dgnorecord'];", (Object)dataGrid.getUniqueID());
                    }
                    strScript = String.valueOf(strScript) + "_OP.params['realsort']='';\r\n";
                    bTranslateSortParam = false;
                    i5 = 0;
                    while (i5 < dsItems.size()) {
                        dsItem = (DataGridDSItemConfig)((Object)dsItems.get(i5));
                        if (StringHelper.Compare((String)dsItem.getID(), (String)dsItem.getSortParam(), (boolean)true) != 0) {
                            if (!bTranslateSortParam) {
                                bTranslateSortParam = true;
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(_T.sortInfo&&_T.sortInfo.field){\r\n", (Object)dataGrid.getUniqueID());
                            }
                            strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(_T.sortInfo.field=='%1$s'){_OP.params['realsort']='%2$s';}\r\n", (Object)dsItem.getID().toLowerCase(), (Object)dsItem.getSortParam().toLowerCase());
                        }
                        ++i5;
                    }
                    if (bTranslateSortParam) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"}\r\n", (Object)dataGrid.getUniqueID());
                    }
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_OP.params['gridid']='%1$s';\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_OP.params['action']='fetch';\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_OP.params['actiontype']='gridaction';\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"Ext.apply(_OP.params,_T.userparams);\r\n");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"Ext.apply(_OP.params,_T.sysparams);\r\n");
                    strScript = String.valueOf(strScript) + "};\r\n";
                    strScript = String.valueOf(strScript) + "_S._onsearchback=function(_T,_R,_O){_T.retryCount=0;\r\n";
                    strScript = StringHelper.Compare((String)dataGridConfig.getResponseType(), (String)"JSONARRAY", (boolean)true) == 0 ? String.valueOf(strScript) + "var A=_T.reader.arrayData;\r\n" : String.valueOf(strScript) + "var A=_T.reader.jsonData;\r\n";
                    strScript = String.valueOf(strScript) + "if(A.ret!=0)";
                    strScript = String.valueOf(strScript) + "{ alert('\u7cfb\u7edf\u5185\u90e8\u5904\u7406\u51fa\u73b0\u9519\u8bef\uff0c\u9519\u8bef\u539f\u56e0\u4e3a\uff1a'+A.info+'\uff0c\u8bf7\u4e0e\u7ba1\u7406\u5458\u8054\u7cfb!');\r\n";
                    strScript = String.valueOf(strScript) + "}\r\n";
                    strScript = String.valueOf(strScript) + "SRFAjaxResultHelper.process(A);";
                    strScript = String.valueOf(strScript) + "};\r\n";
                    strScript = String.valueOf(strScript) + "_S._onfetcherror=function(_1){\r\n";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var A=$P.store['%1$s'];\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"A.retryCount++;");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(A.retryCount>=3)");
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"{A.retryCount=0;alert($P.msg['networkerror']);}");
                    strScript = String.valueOf(strScript) + "else";
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"{A.reload();}\r\n", (Object)dataGrid.getUniqueID());
                    strScript = String.valueOf(strScript) + "};\r\n";
                    strScript = String.valueOf(strScript) + "_S.on('beforeload',_S._onfillparams);\r\n";
                    strScript = String.valueOf(strScript) + "_S.on('load',_S._onsearchback);\r\n";
                    strScript = String.valueOf(strScript) + "_S.on('loadexception',_S._onfetcherror);\r\n";
                }
                if (!dataGridConfig.getEditable() || (dataGridColumnEditorsConfig = dataGridConfig.getDataGridColumnEditorsConfig()) == null) break block96;
                dataGrid.getPage().RegisterScript(2, StringHelper.Format((String)"$P.grideditor['%1$s']={};", (Object)dataGrid.getUniqueID()));
                int nCount = dataGridColumnEditorsConfig.getList().size();
                int i6 = 0;
                while (i6 < nCount) {
                    block97: {
                        String strJSCode;
                        String strHTMLCode;
                        DataGridColumnEditorConfig dataGridColumnEditorConfig;
                        block99: {
                            block103: {
                                Object obj;
                                block105: {
                                    String strObject;
                                    block104: {
                                        block102: {
                                            block101: {
                                                block100: {
                                                    block98: {
                                                        dataGridColumnEditorConfig = (DataGridColumnEditorConfig)((Object)dataGridColumnEditorsConfig.getList().get(i6));
                                                        if (StringHelper.Length((String)dataGridColumnEditorConfig.getID()) == 0) break block97;
                                                        strHTMLCode = "";
                                                        strJSCode = "";
                                                        if (!(dataGridColumnEditorConfig instanceof DataGridTextEditorConfig)) break block98;
                                                        SRFExDataGridTextEditor textEditor = new SRFExDataGridTextEditor();
                                                        textEditor.setDataGrid(dataGrid);
                                                        textEditor.setConfig((DataGridBaseEditorConfig)dataGridColumnEditorConfig);
                                                        strHTMLCode = textEditor.RenderHTMLCode();
                                                        strJSCode = textEditor.RenderJSCode();
                                                        break block99;
                                                    }
                                                    if (!(dataGridColumnEditorConfig instanceof DataGridACEditorConfig)) break block100;
                                                    SRFExDataGridACEditor acEditor = new SRFExDataGridACEditor();
                                                    acEditor.setDataGrid(dataGrid);
                                                    acEditor.setConfig((DataGridBaseEditorConfig)dataGridColumnEditorConfig);
                                                    strHTMLCode = acEditor.RenderHTMLCode();
                                                    strJSCode = acEditor.RenderJSCode();
                                                    break block99;
                                                }
                                                if (!(dataGridColumnEditorConfig instanceof DataGridComboEditorConfig)) break block101;
                                                SRFExDataGridComboEditor comboEditor = new SRFExDataGridComboEditor();
                                                comboEditor.setDataGrid(dataGrid);
                                                comboEditor.setConfig((DataGridBaseEditorConfig)dataGridColumnEditorConfig);
                                                strHTMLCode = comboEditor.RenderHTMLCode();
                                                strJSCode = comboEditor.RenderJSCode();
                                                break block99;
                                            }
                                            if (!(dataGridColumnEditorConfig instanceof DataGridPickerEditorConfig)) break block102;
                                            SRFExDataGridPickerEditor pickerEditor = new SRFExDataGridPickerEditor();
                                            pickerEditor.setDataGrid(dataGrid);
                                            pickerEditor.setConfig((DataGridBaseEditorConfig)dataGridColumnEditorConfig);
                                            strHTMLCode = pickerEditor.RenderHTMLCode();
                                            strJSCode = pickerEditor.RenderJSCode();
                                            break block99;
                                        }
                                        strObject = dataGridColumnEditorConfig.getObject();
                                        if (StringHelper.Length((String)strObject) == 0) break block103;
                                        obj = ObjectHelper.Create(strObject);
                                        if (obj != null) break block104;
                                        System.out.print(StringHelper.Format((String)"\u5efa\u7acb\u5bf9\u8c61[%1$s]\u5931\u8d25\r\n", (Object)strObject));
                                        break block97;
                                    }
                                    if (obj instanceof SRFExDataGridBaseEditor) break block105;
                                    System.out.print(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u4e0d\u662f\u8868\u683c\u7f16\u8f91\u5bf9\u8c61\u7c7b\u578b\r\n", (Object)strObject));
                                    break block97;
                                }
                                SRFExDataGridBaseEditor baseEditor = (SRFExDataGridBaseEditor)obj;
                                baseEditor.setDataGrid(dataGrid);
                                baseEditor.setConfig(dataGridColumnEditorConfig);
                                strHTMLCode = baseEditor.RenderHTMLCode();
                                strJSCode = baseEditor.RenderJSCode();
                                break block99;
                            }
                            strHTMLCode = dataGridColumnEditorConfig.getHTMLCode();
                            strJSCode = dataGridColumnEditorConfig.getJSCode();
                            if (StringHelper.Length((String)strHTMLCode) > 0) {
                                strHTMLCode = StringHelper.Format((String)strHTMLCode, (Object)dataGrid.getUniqueID(), (Object)(String.valueOf(dataGrid.getUniqueID()) + "_ED_" + dataGridColumnEditorConfig.getID()), (Object)dataGridColumnEditorConfig.getID());
                            }
                            if (StringHelper.Length((String)strJSCode) > 0) {
                                strJSCode = StringHelper.Format((String)strJSCode, (Object)dataGrid.getUniqueID(), (Object)(String.valueOf(dataGrid.getUniqueID()) + "_ED_" + dataGridColumnEditorConfig.getID()), (Object)dataGridColumnEditorConfig.getID());
                            }
                        }
                        if (StringHelper.Length((String)strHTMLCode) > 0) {
                            dataGrid.getPage().RegisterOutput(strHTMLCode);
                        }
                        if (StringHelper.Length((String)strJSCode) > 0) {
                            String strTemp = "var _GRIDEDITOR=null;\r\n";
                            strJSCode = String.valueOf(strTemp) + strJSCode;
                            strJSCode = String.valueOf(strJSCode) + StringHelper.Format((String)"$P.grideditor['%1$s'].%2$s=_GRIDEDITOR;\r\n", (Object)dataGrid.getUniqueID(), (Object)dataGridColumnEditorConfig.getID().toLowerCase());
                            dataGrid.getPage().RegisterOnReadyScript(2, strJSCode);
                        }
                    }
                    ++i6;
                }
            }
            dataGrid.getPage().RegisterOnReadyScript(2, strScript);
            if (dataGridConfig.getLoadDefault()) {
                dataGrid.getPage().RegisterOnReadyScript(5, StringHelper.Format((String)"$P.store['%1$s'].loaddefault();\r\n", (Object)dataGrid.getUniqueID()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return "";
    }

    @Override
    public String getBuilderName() {
        return "DATAGRID";
    }
}

