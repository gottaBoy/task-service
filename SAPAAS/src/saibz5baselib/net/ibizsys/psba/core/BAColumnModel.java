/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.BAModelBase;
import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBAColumnModel;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.core.IBATableDE;

public class BAColumnModel
extends BAModelBase
implements IBAColumnModel {
    private IBATable iBATable = null;
    private String strDEFieldName = null;
    private String strBAColSetName = null;
    private String strDEName = null;
    private IDEField iDEField = null;
    private IBATableDE iBATableDE = null;
    private IBAColSet iBAColSet = null;
    private String strUnionKeyValue = null;
    private String strBATableDEId = null;

    public void init(IBATable iBATable) throws Exception {
        this.iBATable = iBATable;
        if (!StringHelper.isNullOrEmpty(this.getBAColSetName())) {
            this.iBAColSet = this.getBATable().getBAColSet(this.getBAColSetName());
        }
        this.iBATableDE = this.getBATable().getBATableDE(this.getBATableDEId());
        if (!StringHelper.isNullOrEmpty(this.getDEFieldName())) {
            this.iDEField = this.iBATableDE.getDataEntity().getDEField(this.getDEFieldName(), false);
        }
        if (this.iDEField == null) {
            throw new Exception(StringHelper.format("\u5927\u6570\u636e\u5217[%1$s][%2$s]\u672a\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027", this.iBATable.getName(), this.getName()));
        }
    }

    @Override
    public IBATable getBATable() {
        return this.iBATable;
    }

    @Override
    public IDEField getDEField() {
        return this.iDEField;
    }

    @Override
    public IBAColSet getBAColSet() {
        return this.iBAColSet;
    }

    @Override
    public IBATableDE getBATableDE() {
        return this.iBATableDE;
    }

    @Override
    public String getDBValueFunc() {
        return this.getDEField().getDBValueFunc();
    }

    public void setDEFieldName(String strDEFieldName) {
        this.strDEFieldName = strDEFieldName;
    }

    @Override
    public String getDEFieldName() {
        return this.strDEFieldName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setBAColSetName(String strBAColSetName) {
        this.strBAColSetName = strBAColSetName;
    }

    @Override
    public String getBAColSetName() {
        return this.strBAColSetName;
    }

    @Override
    public String getPreDefinedType() {
        return this.getDEField().getPreDefinedType();
    }

    @Override
    public boolean isEnableTempData() {
        return this.getDEField().isEnableTempData();
    }

    @Override
    public int getStdDataType() {
        return this.getDEField().getStdDataType();
    }

    @Override
    public String getUnionKeyValue() {
        return this.strUnionKeyValue;
    }

    public void setUnionKeyValue(String strUnionKeyValue) {
        this.strUnionKeyValue = strUnionKeyValue;
    }

    @Override
    public String getBATableDEId() {
        return this.strBATableDEId;
    }

    public void setBATableDEId(String strBATableDEId) {
        this.strBATableDEId = strBATableDEId;
    }
}

