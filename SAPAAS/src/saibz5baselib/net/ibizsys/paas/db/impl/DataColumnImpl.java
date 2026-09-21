/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.IDataColumn;

public class DataColumnImpl
implements IDataColumn {
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

    @Override
    public String getCatalogName() {
        return this.strCatalogName;
    }

    public void setColumnClassName(String strColumnClassName) {
        this.strColumnClassName = strColumnClassName;
    }

    @Override
    public String getColumnClassName() {
        return this.strColumnClassName;
    }

    public void setDisplaySize(int nDisplaySize) {
        this.nDisplaySize = nDisplaySize;
    }

    @Override
    public int getDisplaySize() {
        return this.nDisplaySize;
    }

    public void setColumnType(int nColumnType) {
        this.nColumnType = nColumnType;
    }

    @Override
    public int getColumnType() {
        return this.nColumnType;
    }

    public void setName(String name) {
        this.strName = name;
    }

    public void setDBDataType(String DBDataType) {
        this.strDBDataType = DBDataType;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public String getDBDataType() {
        return this.strDBDataType;
    }

    public void setIndex(int index) {
        this.nIndex = index;
    }

    @Override
    public int getIndex() {
        return this.nIndex;
    }
}

