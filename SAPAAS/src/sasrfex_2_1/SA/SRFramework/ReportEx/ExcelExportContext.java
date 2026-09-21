/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.ReportEx;

import java.util.Hashtable;

public class ExcelExportContext {
    protected int nStartRow = 0;
    protected int nStartColumn = 0;
    protected int nCurRow = 0;
    protected int nCurColumn = 0;
    protected boolean bReplace = false;
    protected int nDataRowIndex = 1;
    protected Hashtable paramList = new Hashtable();

    public Object getParam(String strParamName) {
        if (this.paramList.containsKey(strParamName = strParamName.toUpperCase())) {
            return this.paramList.get(strParamName);
        }
        return null;
    }

    public void setParam(String strParamName, Object objValue) {
        strParamName = strParamName.toUpperCase();
        if (objValue == null) {
            this.paramList.remove(strParamName);
        } else {
            this.paramList.put(strParamName, objValue);
        }
    }

    public int getStartRow() {
        return this.nStartRow;
    }

    public void setStartRow(int nStartRow) {
        this.nStartRow = nStartRow;
    }

    public int getStartColumn() {
        return this.nStartColumn;
    }

    public void setStartColumn(int nStartColumn) {
        this.nStartColumn = nStartColumn;
    }

    public int getCurRow() {
        return this.nCurRow;
    }

    public void setCurRow(int nCurRow) {
        this.nCurRow = nCurRow;
    }

    public int getCurColumn() {
        return this.nCurColumn;
    }

    public void setCurColumn(int nCurColumn) {
        this.nCurColumn = nCurColumn;
    }

    public boolean getReplace() {
        return this.bReplace;
    }

    public void setReplace(boolean bReplace) {
        this.bReplace = bReplace;
    }

    public void ResetDataRowIndex() {
        this.nDataRowIndex = 1;
    }

    public int getDataRowIndex() {
        return this.nDataRowIndex;
    }

    public void IncreaseDataRowIndex() {
        ++this.nDataRowIndex;
    }
}

