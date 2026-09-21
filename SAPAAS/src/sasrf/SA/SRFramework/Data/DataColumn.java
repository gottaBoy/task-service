/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

public class DataColumn {
    private String strName = "";
    private String strDBDataType = "";
    private int nIndex = -1;
    private String strCatalogName = "";
    private String strColumnClassName = "";
    private int nDisplaySize = 20;
    private int nColumnType = 0;

    public void setCatalogName(String strCatalogName) {
        this.strCatalogName = strCatalogName;
    }

    public String getCatalogName() {
        return this.strCatalogName;
    }

    public void setColumnClassName(String strColumnClassName) {
        this.strColumnClassName = strColumnClassName;
    }

    public String getColumnClassName() {
        return this.strColumnClassName;
    }

    public void setDisplaySize(int nDisplaySize) {
        this.nDisplaySize = nDisplaySize;
    }

    public int getDisplaySize() {
        return this.nDisplaySize;
    }

    public void setColumnType(int nColumnType) {
        this.nColumnType = nColumnType;
    }

    public int getColumnType() {
        return this.nColumnType;
    }

    public void setName(String name) {
        this.strName = name;
    }

    public void setDBDataType(String DBDataType) {
        this.strDBDataType = DBDataType;
    }

    public String getName() {
        return this.strName;
    }

    public String getDBDataType() {
        return this.strDBDataType;
    }

    public void setIndex(int index) {
        this.nIndex = index;
    }

    public int getIndex() {
        return this.nIndex;
    }
}

