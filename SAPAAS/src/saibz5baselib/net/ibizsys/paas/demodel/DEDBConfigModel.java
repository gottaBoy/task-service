/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.IDEDBConfigModel;
import net.ibizsys.paas.util.StringHelper;

public class DEDBConfigModel
extends ModelBaseImpl
implements IDEDBConfigModel {
    private String strTableName = null;
    private String strUserTable = null;
    private String strViewName = null;
    private String strView2Name = null;
    private String strView3Name = null;
    private String strView4Name = null;
    private String strDBType = null;

    @Override
    public String getTableName() {
        return this.strTableName;
    }

    @Override
    public String getUserTable() {
        return this.strUserTable;
    }

    @Override
    public String getViewName() {
        return this.strViewName;
    }

    @Override
    public String getView2Name() {
        return this.strView2Name;
    }

    @Override
    public String getView3Name() {
        return this.strView3Name;
    }

    @Override
    public String getView4Name() {
        return this.strView4Name;
    }

    public void setTableName(String strTableName) {
        this.strTableName = strTableName;
    }

    public void setUserTable(String strUserTable) {
        this.strUserTable = strUserTable;
    }

    public void setViewName(String strViewName) {
        this.strViewName = strViewName;
    }

    public void setView2Name(String strView2Name) {
        this.strView2Name = strView2Name;
    }

    public void setView3Name(String strView3Name) {
        this.strView3Name = strView3Name;
    }

    public void setView4Name(String strView4Name) {
        this.strView4Name = strView4Name;
    }

    @Override
    public String getDBType() {
        return this.strDBType;
    }

    public void setDBType(String strDBType) {
        this.strDBType = strDBType;
    }

    @Override
    public String getViewName(int nViewLevel) {
        switch (nViewLevel) {
            case -1: 
            case 0: {
                return this.getViewName();
            }
            case 3: {
                if (!StringHelper.isNullOrEmpty(this.getView4Name())) {
                    return this.getView4Name();
                }
            }
            case 2: {
                if (!StringHelper.isNullOrEmpty(this.getView3Name())) {
                    return this.getView3Name();
                }
            }
            case 1: {
                if (StringHelper.isNullOrEmpty(this.getView2Name())) break;
                return this.getView2Name();
            }
        }
        return this.getViewName();
    }
}

