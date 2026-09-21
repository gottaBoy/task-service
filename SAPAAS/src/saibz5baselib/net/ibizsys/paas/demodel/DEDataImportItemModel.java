/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEDataImportItemModel;
import net.ibizsys.paas.demodel.IDEDataImportModel;
import net.ibizsys.paas.demodel.IDEFieldModel;

public class DEDataImportItemModel
extends ModelBase3Impl
implements IDEDataImportItemModel {
    private IDEDataImport iDEDataImport = null;
    private IDEDataImportModel iDEDataImportModel = null;
    private String strCaption = null;
    private String strCapLanResTag = null;
    private String strDEFName = null;
    private boolean bUniqueItem = false;
    private IDEFieldModel iDEFieldModel = null;

    public void init(IDEDataImport iDEDataImport) throws Exception {
        this.setDEDataImport(iDEDataImport);
        this.iDEFieldModel = (IDEFieldModel)this.getDEDataImport().getDataEntity().getDEField(this.getDEFName(), false);
        this.onInit();
    }

    @Override
    public IDEDataImport getDEDataImport() {
        return this.iDEDataImport;
    }

    protected IDEDataImportModel getDEDataImportModel() {
        return this.iDEDataImportModel;
    }

    protected void setDEDataImport(IDEDataImport iDEDataImport) {
        this.iDEDataImport = iDEDataImport;
        if (this.iDEDataImport == null) {
            this.iDEDataImportModel = null;
        } else if (this.iDEDataImport instanceof IDEDataImportModel) {
            this.iDEDataImportModel = (IDEDataImportModel)this.iDEDataImport;
        }
    }

    @Override
    public String getCapLanResTag() {
        return this.strCapLanResTag;
    }

    public void setCapLanResTag(String strCapLanResTag) {
        this.strCapLanResTag = strCapLanResTag;
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getDEFName() {
        return this.strDEFName;
    }

    @Override
    public boolean isUniqueItem() {
        return this.bUniqueItem;
    }

    public void setDEFName(String strDEFName) {
        this.strDEFName = strDEFName;
    }

    public void setUniqueItem(boolean bUniqueItem) {
        this.bUniqueItem = bUniqueItem;
    }

    @Override
    public IDEFieldModel getDEFieldModel() {
        return this.iDEFieldModel;
    }

    @Override
    public IDEField getDEField() {
        return this.iDEFieldModel;
    }
}

