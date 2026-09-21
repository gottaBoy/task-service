/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.HashMap;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEMainStateModel;

public class DEMainStateModel
extends ModelBase3Impl
implements IDEMainStateModel {
    private IDataEntity iDataEntity = null;
    private String strLogicName = "";
    private boolean bAllowMode = false;
    private boolean bOPPrivAllowMode = false;
    private boolean bDefault = false;
    private String strMSTag = "";
    private HashMap<String, String> deActionMap = new HashMap();
    private HashMap<String, String> deOPPrivMap = new HashMap();

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.iDataEntity = iDataEntity;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    @Deprecated
    public boolean isAllowMode() {
        return this.bAllowMode;
    }

    @Override
    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    public String getMSTag() {
        return this.strMSTag;
    }

    @Override
    public boolean testDEAction(String strDEActionName) throws Exception {
        if (this.deActionMap.containsKey(strDEActionName.toUpperCase())) {
            return this.bAllowMode;
        }
        return !this.bAllowMode;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public void registerDEAction(String strDEAction) {
        this.deActionMap.put(strDEAction.toUpperCase(), "");
    }

    @Deprecated
    public void setiDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    public void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public void setAllowMode(boolean bAllowMode) {
        this.bAllowMode = bAllowMode;
    }

    public void setDefault(boolean bDefault) {
        this.bDefault = bDefault;
    }

    public void setMSTag(String strMSTag) {
        this.strMSTag = strMSTag;
    }

    @Override
    public boolean isActionAllowMode() {
        return this.bAllowMode;
    }

    @Override
    public boolean isOPPrivAllowMode() {
        return this.bOPPrivAllowMode;
    }

    public void setOPPrivAllowMode(boolean bOPPrivAllowMode) {
        this.bOPPrivAllowMode = bOPPrivAllowMode;
    }

    @Override
    public boolean testDEOPPriv(String strDEOPPrivName) throws Exception {
        if (this.deOPPrivMap.containsKey(strDEOPPrivName.toUpperCase())) {
            return this.bOPPrivAllowMode;
        }
        return !this.bOPPrivAllowMode;
    }

    @Override
    public void registerDEOPPriv(String strDEOPPriv) {
        this.deOPPrivMap.put(strDEOPPriv.toUpperCase(), "");
    }
}

