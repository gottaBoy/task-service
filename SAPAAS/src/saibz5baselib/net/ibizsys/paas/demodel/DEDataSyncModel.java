/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEDataSyncModel;

public class DEDataSyncModel
extends ModelBase3Impl
implements IDEDataSyncModel {
    private IDataEntity iDataEntity = null;
    private boolean bInMode = false;
    private String strTestDEActionName = null;
    private ArrayList<String> fileFieldList = new ArrayList();
    private ArrayList<String> deNameList = new ArrayList();
    private String strSyncAgent = null;
    private int nEventType = 0;
    private String strImportDEActionName = null;
    private String strSyncTag = null;

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
    public Iterator<String> getFileFields() {
        if (this.fileFieldList == null || this.fileFieldList.size() == 0) {
            return null;
        }
        return this.fileFieldList.iterator();
    }

    public void addFileField(String strFileField) {
        this.fileFieldList.add(strFileField);
    }

    @Override
    public Iterator<String> getDENames() {
        if (this.deNameList == null || this.deNameList.size() == 0) {
            return null;
        }
        return this.deNameList.iterator();
    }

    public void addDEName(String strDEName) {
        this.deNameList.add(strDEName);
    }

    @Override
    public String getTestDEActionName() {
        return this.strTestDEActionName;
    }

    public void setTestDEActionName(String strTestDEActionName) {
        this.strTestDEActionName = strTestDEActionName;
    }

    @Override
    public String getImportDEActionName() {
        return this.strImportDEActionName;
    }

    public void setImportDEActionName(String strImportDEActionName) {
        this.strImportDEActionName = strImportDEActionName;
    }

    @Override
    public String getSyncAgent() {
        return this.strSyncAgent;
    }

    public void setSyncAgent(String strSyncAgent) {
        this.strSyncAgent = strSyncAgent;
    }

    @Override
    public int getEventType() {
        return this.nEventType;
    }

    public void setEventType(int nEventType) {
        this.nEventType = nEventType;
    }

    @Override
    public boolean isInMode() {
        return this.bInMode;
    }

    public void setInMode(boolean bInMode) {
        this.bInMode = bInMode;
    }

    @Override
    public String getSyncTag() {
        return this.strSyncTag;
    }

    public void setSyncTag(String strSyncTag) {
        this.strSyncTag = strSyncTag;
    }
}

