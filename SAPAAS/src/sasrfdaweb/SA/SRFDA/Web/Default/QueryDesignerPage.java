/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class QueryDesignerPage
extends SRFDAPage {
    protected boolean bDesignDGColumn = true;
    protected boolean bExtSelect = false;
    protected boolean bLeftOuterJoin = false;
    protected boolean bRightJoin = false;
    protected boolean bExtColumn = false;

    public QueryDesignerPage() {
        this.setJSCache(false);
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    public boolean IsExtColumn() {
        return this.bExtColumn;
    }

    public String GetDEID() {
        return this.getWebContext().getSRFDEID();
    }

    public String GetCtrlID() {
        return this.getWebContext().GetParamValue("SRFCTRLID");
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.bDesignDGColumn = StringHelper.Compare((String)this.getWebContext().GetParamValue("DESIGNDGCOLUMN"), (String)"FALSE", (boolean)true) != 0;
        this.bExtSelect = StringHelper.Compare((String)this.getWebContext().GetParamValue("EXTSELECT"), (String)"FALSE", (boolean)true) != 0;
        this.bLeftOuterJoin = StringHelper.Compare((String)this.getWebContext().GetParamValue("LEFTOUTERJOIN"), (String)"FALSE", (boolean)true) != 0;
        this.bRightJoin = StringHelper.Compare((String)this.getWebContext().GetParamValue("RIGHTJOIN"), (String)"FALSE", (boolean)true) != 0;
        this.bExtColumn = StringHelper.Compare((String)this.getWebContext().GetParamValue("EXTCOLUMN"), (String)"TRUE", (boolean)true) == 0;
        StringBuilderEx script = new StringBuilderEx();
        if (this.bDesignDGColumn) {
            IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.GetDEID());
            if (iDEHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.GetDEID()));
                return;
            }
            script.Reset();
            script.Append("var _GRIDWIDTH = Ext.lib.Dom.getViewWidth(false);\r\n");
            script.Append("var cm = new Ext.ux.grid.LockingColumnModel([");
            boolean bFirst = true;
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(",\r\n");
                }
                script.Append("{locked:false,");
                script.Append("id:'%1$s',", (Object)iDEFHelper.getName().toLowerCase());
                script.Append("header:'%1$s',", (Object)iDEFHelper.getLogicName(this.getLanguage()));
                script.Append("dataIndex:'%1$s',", (Object)iDEFHelper.getName().toLowerCase());
                script.Append("sortable:true,width:100");
                script.Append("}");
            }
            if (this.bExtColumn) {
                int i = 1;
                while (i <= 10) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(",\r\n");
                    }
                    script.Append("{");
                    script.Append("id:'_srfcol%1$s_',", (Object)i);
                    script.Append("header:'[\u7528\u6237\u6269\u5c55%1$s]',", (Object)i);
                    script.Append("dataIndex:'_srfcol%1$s_',", (Object)i);
                    script.Append("hidden:true,menuDisabled:true,sortable:true,width:100");
                    script.Append("}");
                    ++i;
                }
            }
            script.Append("]);\r\n");
            script.Append(" cm.defaultSortable = true;\r\n");
            script.Append("\tvar fieldItem = Ext.data.Record.create([\r\n");
            bFirst = true;
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(",");
                }
                script.Append("{name: '%1$s'}\r\n", (Object)iDEFHelper.getName().toLowerCase());
            }
            if (this.bExtColumn) {
                int i = 1;
                while (i <= 10) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(",");
                    }
                    script.Append("{name: '_srfcol%1$s_'}\r\n", (Object)i);
                    ++i;
                }
            }
            script.Append("]);\r\n");
            script.Append("\t    var store = new Ext.data.Store({\r\n");
            script.Append("\t        url: '../srfds/gridsimpledatabackend.jsp?SRFDEID=%1$s',\r\n", (Object)this.GetDEID());
            script.Append("\t        reader: new Ext.data.JsonReader({root: \"items\",totalProperty:\"totalrow\"  }\r\n");
            script.Append("\t         ,fieldItem),\r\n");
            script.Append("\t        sortInfo:{field:'%1$s', direction:'ASC'}\r\n", (Object)iDEHelper.GetMajorDEFHelper().getName().toLowerCase());
            script.Append("\t    });\r\n");
            script.Append("\t    var grid = new Ext.grid.GridPanel({\r\n");
            script.Append("\t        store: store,\r\n");
            script.Append("\t        cm: cm,\r\n");
            script.Append("\t        renderTo: 'designGrid',\r\n", (Object)this.getUniqueID());
            script.Append("\t   \t\twidth:_GRIDWIDTH,\r\n");
            script.Append("\t        height:80,\r\n");
            script.Append("\t        frame:false,\r\n");
            script.Append("\t        view: new Ext.ux.grid.LockingGridView(),\r\n");
            script.Append("\t\t\tsm: new Ext.grid.CellSelectionModel({singleSelect:true})\r\n");
            script.Append("\t    });\r\n");
            script.Append("grid.getSelectionModel().on('cellselect',oncellselect);\r\n");
            script.Append("$P.grid['designGrid'] = grid;\r\n");
            script.Append("$P.store['designGrid'] = store;\r\n");
            script.Append("store.load({params:{}});\r\n");
            this.RegisterOnReadyScript(3, script.toString());
        }
    }

    public boolean IsDesignDGColumn() {
        return this.bDesignDGColumn;
    }

    public boolean IsExtSelect() {
        return this.bExtSelect;
    }

    public boolean IsLeftOuterJoin() {
        return this.bLeftOuterJoin;
    }

    public boolean IsRightJoin() {
        return this.bRightJoin;
    }
}

