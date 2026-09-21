/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.BATableObjectModelBase;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.core.IBATableDEModel;

public class BATableDEModel
extends BATableObjectModelBase
implements IBATableDEModel {
    private IDataEntity iDataEntity = null;
    private int nBATableDEType = 0;
    private String strBAColSetName = null;
    private String strRowKeyFormat = null;
    private String strRowKeyParams = null;
    private String[] rowKeyParams = null;

    public void init(IBATable iBATable) throws Exception {
        this.setBATable(iBATable);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.iDataEntity = DEModelGlobal.getDEModel(this.getName());
        super.onInit();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public int getBATableDEType() {
        return this.nBATableDEType;
    }

    public void setBATableDEType(int nBATableDEType) {
        this.nBATableDEType = nBATableDEType;
    }

    @Override
    public String getBAColSetName() {
        return this.strBAColSetName;
    }

    public void setBAColSetName(String strBAColSetName) {
        this.strBAColSetName = strBAColSetName;
    }

    @Override
    public String getRowKey(ISimpleDataObject iEntity) throws Exception {
        if (StringHelper.isNullOrEmpty(this.getRowKeyFormat()) || this.rowKeyParams == null) {
            return DataObject.getStringValue(iEntity.get(this.getDataEntity().getKeyDEField().getName()));
        }
        Object[] objs = new Object[this.rowKeyParams.length];
        int i = 0;
        while (i < this.rowKeyParams.length) {
            objs[i] = iEntity.get(this.rowKeyParams[i]);
            ++i;
        }
        return StringHelper.format(this.getRowKeyFormat(), objs);
    }

    @Override
    public String getRowKeyFormat() {
        return this.strRowKeyFormat;
    }

    @Override
    public String getRowKeyParams() {
        return this.strRowKeyParams;
    }

    public void setRowKeyFormat(String strRowKeyFormat) {
        this.strRowKeyFormat = strRowKeyFormat;
    }

    public void setRowKeyParams(String strRowKeyParams) {
        this.strRowKeyParams = strRowKeyParams;
        this.rowKeyParams = StringHelper.isNullOrEmpty(this.strRowKeyParams) ? null : this.strRowKeyParams.split("[;]");
    }
}

