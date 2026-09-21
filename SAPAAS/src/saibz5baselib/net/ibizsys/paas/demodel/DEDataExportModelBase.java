/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEDataExportModel;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DEDataExportModelBase
extends ModelBase3Impl
implements IDEDataExportModel {
    private static final Log log = LogFactory.getLog(DEDataExportModelBase.class);
    private IDataEntity iDataEntity = null;
    protected ArrayList<IDEDataExportItem> deDataExportItemList = new ArrayList();

    @Override
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
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareDEDataExportItemModels();
    }

    protected void prepareDEDataExportItemModels() throws Exception {
    }

    protected IDEDataExportItem createDEDataExportItem(String strName) throws Exception {
        return null;
    }

    @Override
    public Iterator<IDEDataExportItem> getDEDataExportItems() {
        return this.deDataExportItemList.iterator();
    }

    protected void registerDEDataExportItem(IDEDataExportItem iDEDataExportItem) {
        this.deDataExportItemList.add(iDEDataExportItem);
    }

    @Override
    public String getItemText(IDEDataExportItem iDEDataExportItem, IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        return iDEDataExportItem.getText(iWebContext, object, bEnableItemPrivilege);
    }
}

