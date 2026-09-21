/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import java.util.HashMap;

public class DataGridColumnConfig
extends XMLConfig {
    public static final String TAG_SRFEXDATAGRIDCOLUMN = "SRFEXDATAGRIDCOLUMN";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_EXCELCAPTION = "EXCELCAPTION";
    public static final String TAG_SORTABLE = "SORTABLE";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HIDDEN = "HIDDEN";
    public static final String TAG_LOCKED = "LOCKED";
    public static final String TAG_DSITEM = "DSITEM";
    public static final String TAG_FIXED = "FIXED";
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_EDITOR = "EDITOR";
    public static final String TAG_EDITORID = "EDITORID";
    public static final String TAG_ROWBODY = "ROWBODY";
    public static final String TAG_RENDERER = "RENDERER";
    public static final String TAG_RENDERID = "RENDERID";
    public static final String TAG_XAMLCONTENT = "XAMLCONTENT";
    public static final String TAG_PRIVILEGEID = "PRIVILEGEID";
    public static final String TAG_MENUDISABLED = "MENUDISABLED";
    public static final String TAG_HIDEABLE = "HIDEABLE";
    public static final String TAG_FIUPDATEMODE = "FIUPDATEMODE";
    public static final String TAG_GROUPCOLUMN = "GROUPCOLUMN";
    public static final String TAG_CELLPOS = "CELLPOS";
    public static final String TAG_CELLPADDING = "CELLPADDING";
    public static final String TAG_CELLSTYLE = "CELLSTYLE";
    protected DataGridConfig dataGridConfig = null;
    protected String strCaption = "";
    protected boolean bSortable = false;
    protected String strCssClass = "";
    protected int nWidth = 0;
    protected boolean bHidden = false;
    protected boolean bLocked = false;
    protected String strDSItem = "";
    protected boolean bFixed = false;
    protected String strAlign = "";
    protected String strEditor;
    protected String strEditorId;
    protected boolean bXamlContent = false;
    protected String strRenderer = "";
    protected String strRenderId = "";
    protected String strExcelCaption = "";
    protected boolean bRowBody = false;
    protected String strPrivilegeId = "";
    protected boolean bMenuDisabled = false;
    protected boolean bHideable = true;
    protected String strFIUpdateMode = "";
    protected String strGroupColumn = "";
    protected String strCellPos = "";
    protected String strCellPadding = "";
    protected String strCellStyle = "";

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }

    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_CAPTION);
        if (strValue != null) {
            this.strCaption = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EXCELCAPTION)) != null) {
            this.strExcelCaption = strValue;
        }
        if ((strValue = attrMap.remove(TAG_SORTABLE)) != null) {
            this.bSortable = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bSortable);
        }
        if ((strValue = attrMap.remove(TAG_CSSCLASS)) != null) {
            this.strCssClass = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DSITEM)) != null) {
            this.strDSItem = strValue;
        }
        if ((strValue = attrMap.remove(TAG_WIDTH)) != null) {
            this.nWidth = DataGridColumnConfig.GetValue((String)strValue, (int)this.nWidth);
        }
        if ((strValue = attrMap.remove(TAG_HIDDEN)) != null) {
            this.bHidden = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bHidden);
        }
        if ((strValue = attrMap.remove(TAG_LOCKED)) != null) {
            this.bLocked = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bLocked);
        }
        if ((strValue = attrMap.remove(TAG_FIXED)) != null) {
            this.bFixed = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bFixed);
        }
        if ((strValue = attrMap.remove(TAG_ROWBODY)) != null) {
            this.bRowBody = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bRowBody);
        }
        if ((strValue = attrMap.remove(TAG_ALIGN)) != null) {
            this.strAlign = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EDITOR)) != null) {
            this.strEditor = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EDITORID)) != null) {
            this.strEditorId = strValue;
        }
        if ((strValue = attrMap.remove(TAG_RENDERER)) != null) {
            this.strRenderer = strValue;
        }
        if ((strValue = attrMap.remove(TAG_RENDERID)) != null) {
            this.strRenderId = strValue;
        }
        if ((strValue = attrMap.remove(TAG_XAMLCONTENT)) != null) {
            this.bXamlContent = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bXamlContent);
        }
        if ((strValue = attrMap.remove(TAG_PRIVILEGEID)) != null) {
            this.setPrivilegeId(strValue);
        }
        if ((strValue = attrMap.remove(TAG_MENUDISABLED)) != null) {
            this.bMenuDisabled = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bMenuDisabled);
        }
        if ((strValue = attrMap.remove(TAG_HIDEABLE)) != null) {
            this.bHideable = DataGridColumnConfig.GetValue((String)strValue, (boolean)this.bHideable);
        }
        if ((strValue = attrMap.remove(TAG_FIUPDATEMODE)) != null) {
            this.setFIUpdateMode(strValue);
        }
        if ((strValue = attrMap.remove(TAG_GROUPCOLUMN)) != null) {
            this.setGroupColumn(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CELLPOS)) != null) {
            this.setCellPos(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CELLPADDING)) != null) {
            this.setCellPadding(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CELLSTYLE)) != null) {
            this.setCellStyle(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    public String getAlign() {
        return this.strAlign;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setDSItem(String strDSItem) {
        this.strDSItem = strDSItem;
    }

    public String getDSItem() {
        return this.strDSItem;
    }

    public void setSortable(boolean bSortable) {
        this.bSortable = bSortable;
    }

    public boolean getSortable() {
        return this.bSortable;
    }

    public void setFixed(boolean bFixed) {
        this.bFixed = bFixed;
    }

    public boolean getFixed() {
        return this.bFixed;
    }

    public void setRowBody(boolean bRowBody) {
        this.bRowBody = bRowBody;
    }

    public boolean getRowBody() {
        return this.bRowBody;
    }

    public void setXamlContent(boolean bXamlContent) {
        this.bXamlContent = bXamlContent;
    }

    public boolean getXamlContent() {
        return this.bXamlContent;
    }

    public void setHidden(boolean bHidden) {
        this.bHidden = bHidden;
    }

    public boolean getHidden() {
        return this.bHidden;
    }

    public void setLocked(boolean bLocked) {
        this.bLocked = bLocked;
    }

    public boolean getLocked() {
        return this.bLocked;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public void setEditor(String strEditor) {
        this.strEditor = strEditor;
    }

    public String getEditor() {
        return this.strEditor;
    }

    public void setEditorId(String strEditorId) {
        this.strEditorId = strEditorId;
    }

    public String getEditorId() {
        return this.strEditorId;
    }

    public void setRenderer(String strRenderer) {
        this.strRenderer = strRenderer;
    }

    public String getRenderer() {
        return this.strRenderer;
    }

    public void setRenderId(String strRenderId) {
        this.strRenderId = strRenderId;
    }

    public String getRenderId() {
        return this.strRenderId;
    }

    public String getExcelCaption() {
        if (StringHelper.IsNullOrEmpty((String)this.strExcelCaption)) {
            return this.getCaption();
        }
        return this.strExcelCaption;
    }

    public void setExcelCaption(String strExcelCaption) {
        this.strExcelCaption = strExcelCaption;
    }

    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    public boolean isMenuDisabled() {
        return this.bMenuDisabled;
    }

    public boolean isHideable() {
        return this.bHideable;
    }

    public void setMenuDisabled(boolean bMenuDisabled) {
        this.bMenuDisabled = bMenuDisabled;
    }

    public void setHideable(boolean bHideable) {
        this.bHideable = bHideable;
    }

    public String getFIUpdateMode() {
        return this.strFIUpdateMode;
    }

    public void setFIUpdateMode(String strFIUpdateMode) {
        this.strFIUpdateMode = strFIUpdateMode;
    }

    public String getGroupColumn() {
        return this.strGroupColumn;
    }

    public void setGroupColumn(String strGroupColumn) {
        this.strGroupColumn = strGroupColumn;
    }

    public String getCellPos() {
        return this.strCellPos;
    }

    public void setCellPos(String strCellPos) {
        this.strCellPos = strCellPos;
    }

    public String getCellPadding() {
        return this.strCellPadding;
    }

    public void setCellPadding(String strCellPadding) {
        this.strCellPadding = strCellPadding;
    }

    public String getCellStyle() {
        return this.strCellStyle;
    }

    public void setCellStyle(String strCellStyle) {
        this.strCellStyle = strCellStyle;
    }
}

