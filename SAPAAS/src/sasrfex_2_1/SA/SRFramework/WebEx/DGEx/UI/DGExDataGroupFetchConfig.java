/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGExDataGroupFetchConfig
extends XMLConfig {
    public static final String TAG_SRFEXDGEXDATAGROUPFETCH = "SRFEXDGEXDATAGROUPFETCH";
    public static final String TAG_SQL = "SQL";
    public static final String TAG_DBSTORAGE = "DBSTORAGE";
    public static final String TAG_SQLPARAMS = "SQLPARAMS";
    public static final String TAG_SORTFIELD = "SORTFIELD";
    public static final String TAG_SORTDESC = "SORTDESC";
    public static final String TAG_SORTABLE = "SORTABLE";
    public static final String TAG_NODEFSORT = "NODEFSORT";
    protected String strSQL = "";
    protected String strDBStroage = "";
    protected String strSQLParams = "";
    protected String strSortField = "";
    protected boolean bSortDesc = false;
    protected boolean bSortable = true;
    protected boolean bNoDefSort = false;

    public String getSQL() {
        return this.strSQL;
    }

    public String getDBStroage() {
        return this.strDBStroage;
    }

    public void setSQL(String strSQL) {
        this.strSQL = strSQL;
    }

    public void setDBStroage(String strDBStroage) {
        this.strDBStroage = strDBStroage;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_SQL, (boolean)true) == 0) {
            this.setSQL(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DBSTORAGE, (boolean)true) == 0) {
            this.setDBStroage(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SQLPARAMS, (boolean)true) == 0) {
            this.setSQLParams(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTFIELD, (boolean)true) == 0) {
            this.strSortField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTDESC, (boolean)true) == 0) {
            this.bSortDesc = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTABLE, (boolean)true) == 0) {
            this.bSortable = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NODEFSORT, (boolean)true) == 0) {
            this.bNoDefSort = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getSQLParams() {
        return this.strSQLParams;
    }

    public void setSQLParams(String strSQLParams) {
        this.strSQLParams = strSQLParams;
    }

    public void setSortField(String strSortField) {
        this.strSortField = strSortField;
    }

    public String getSortField() {
        return this.strSortField;
    }

    public void setSortDesc(boolean bSortDesc) {
        this.bSortDesc = bSortDesc;
    }

    public boolean getSortDesc() {
        return this.bSortDesc;
    }

    public void setSortable(boolean bSortable) {
        this.bSortable = bSortable;
    }

    public boolean getSortable() {
        return this.bSortable;
    }

    public boolean getNoDefSort() {
        return this.bNoDefSort;
    }

    public void setNoDefSort(boolean bNoDefSort) {
        this.bNoDefSort = bNoDefSort;
    }
}

