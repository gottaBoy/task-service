/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.demodel.IDEBATableModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psba.core.IBATableDEModel;

public class DEBATableModel
extends ModelBase3Impl
implements IDEBATableModel {
    private IDataEntity iDataEntity = null;
    private int nBATableDEType = 1;
    private String strBAThemeId = null;
    private String strBATableName = null;
    private String strBAColSetName = null;
    private IDataEntityModel iDataEntityModel = null;
    private IBATableDEModel iBATableDEModel = null;

    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
        this.iDataEntityModel = this.iDataEntity == null ? null : (IDataEntityModel)this.iDataEntity;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public int getBATableDEType() {
        return this.nBATableDEType;
    }

    @Override
    public String getBAThemeId() {
        return this.strBAThemeId;
    }

    @Override
    public String getBATableName() {
        return this.strBATableName;
    }

    @Override
    public String getBAColSetName() {
        return this.strBAColSetName;
    }

    public void setBATableDEType(int nBATableDEType) {
        this.nBATableDEType = nBATableDEType;
    }

    public void setBAThemeId(String strBAThemeId) {
        this.strBAThemeId = strBAThemeId;
    }

    public void setBATableName(String strBATableName) {
        this.strBATableName = strBATableName;
    }

    public void setBAColSetName(String strBAColSetName) {
        this.strBAColSetName = strBAColSetName;
    }

    @Override
    public String getRowKey(ISimpleDataObject iEntity) throws Exception {
        if (this.iBATableDEModel == null) {
            this.iBATableDEModel = (IBATableDEModel)this.iDataEntityModel.getSystemModel().getBASchemeModel(this.getBAThemeId()).getBATable(this.getBATableName(), false).getBATableDE(this.getId());
        }
        return this.iBATableDEModel.getRowKey(iEntity);
    }
}

