/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase2Impl
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.pscore.srv.core.IPSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;

public class PSDEFGroupDetailModel
extends ModelBase2Impl
implements IPSDEFGroupDetailModel {
    private String strMemo = null;
    private String strCodeListId = null;
    private IPSDEFieldModel iPSDEFieldModel = null;

    public void setId(String string) {
        this.strId = string;
    }

    public void setName(String string) {
        this.strName = string;
    }

    public void setMemo(String string) {
        this.strMemo = string;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    public void setCodeListId(String string) {
        this.strCodeListId = string;
    }

    @Override
    public String getCodeListId() {
        return this.strCodeListId;
    }

    @Override
    public IPSDEFieldModel getPSDEFieldModel() {
        return this.iPSDEFieldModel;
    }

    public void setPSDEFieldModel(IPSDEFieldModel iPSDEFieldModel) {
        this.iPSDEFieldModel = iPSDEFieldModel;
    }

    @Override
    public String getValueRuleName() {
        return this.getPSDEFieldModel().getValueRuleName();
    }

    @Override
    public Integer getLength() {
        return this.getPSDEFieldModel().getLength();
    }

    @Override
    public Integer getMinValue() {
        return this.getPSDEFieldModel().getMinValue();
    }

    @Override
    public Integer getMaxValue() {
        return this.getPSDEFieldModel().getMaxValue();
    }
}

