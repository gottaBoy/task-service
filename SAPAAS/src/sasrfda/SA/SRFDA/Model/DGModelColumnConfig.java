/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGModelColumnConfig
extends XMLConfig {
    public static final String TAG_DGMODELCOLUMN = "SRFDADGMODELCOLUMN";
    public static final String TAG_DEFIELD = "DEFIELD";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_SORT = "SORT";
    public static final String TAG_LOCKED = "LOCKED";
    public static final String TAG_FIUPDATEMODE = "FIUPDATEMODE";
    public static final String TAG_GROUPCOLUMN = "GROUPCOLUMN";
    public static final String TAG_SORTCOLUMN = "SORTCOLUMN";
    public static final String TAG_CELLPOS = "CELLPOS";
    public static final String TAG_CELLPADDING = "CELLPADDING";
    public static final String TAG_CELLSTYLE = "CELLSTYLE";
    public static final String TAG_CELLSTYLEID = "CELLSTYLEID";
    public static final String TAG_HIDDEN = "HIDDEN";
    protected String strDEField = "";
    protected int nWidth = 100;
    protected String strSort = "";
    protected String strFIUpdateMode = "";
    protected boolean bLocked = false;
    protected boolean bHidden = false;
    protected String strGroupColumn = "";
    protected String strSortColumn = "";
    protected String strCellPos = "";
    protected String strCellPadding = "";
    protected String strCellStyle = "";
    protected String strCellStyleId = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEFIELD, (boolean)true) == 0) {
            this.strDEField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WIDTH, (boolean)true) == 0) {
            this.nWidth = DGModelColumnConfig.GetValue((String)strValue, (int)this.nWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORT, (boolean)true) == 0) {
            this.strSort = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FIUPDATEMODE, (boolean)true) == 0) {
            this.setFIUpdateMode(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPCOLUMN, (boolean)true) == 0) {
            this.setGroupColumn(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTCOLUMN, (boolean)true) == 0) {
            this.setSortColumn(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOCKED, (boolean)true) == 0) {
            this.setLocked(DGModelColumnConfig.GetValue((String)strValue, (boolean)this.isLocked()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIDDEN, (boolean)true) == 0) {
            this.setHidden(DGModelColumnConfig.GetValue((String)strValue, (boolean)this.isHidden()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CELLPOS, (boolean)true) == 0) {
            this.setCellPos(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CELLPADDING, (boolean)true) == 0) {
            this.setCellPadding(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CELLSTYLE, (boolean)true) == 0) {
            this.setCellStyle(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CELLSTYLEID, (boolean)true) == 0) {
            this.setCellStyleId(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDEField() {
        return this.strDEField;
    }

    public void setDEField(String strDEField) {
        this.strDEField = strDEField;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int width) {
        this.nWidth = width;
    }

    public String getSort() {
        return this.strSort;
    }

    public void setSort(String strSort) {
        this.strSort = strSort;
    }

    public String getFIUpdateMode() {
        return this.strFIUpdateMode;
    }

    public void setFIUpdateMode(String strFIUpdateMode) {
        this.strFIUpdateMode = strFIUpdateMode;
    }

    public boolean isLocked() {
        return this.bLocked;
    }

    public void setLocked(boolean bLocked) {
        this.bLocked = bLocked;
    }

    public String getGroupColumn() {
        return this.strGroupColumn;
    }

    public void setGroupColumn(String strGroupColumn) {
        this.strGroupColumn = strGroupColumn;
    }

    public String getSortColumn() {
        return this.strSortColumn;
    }

    public void setSortColumn(String strSortColumn) {
        this.strSortColumn = strSortColumn;
    }

    public boolean isHidden() {
        return this.bHidden;
    }

    public void setHidden(boolean bHidden) {
        this.bHidden = bHidden;
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

    public String getCellStyleId() {
        return this.strCellStyleId;
    }

    public void setCellStyleId(String strCellStyleId) {
        this.strCellStyleId = strCellStyleId;
    }
}

