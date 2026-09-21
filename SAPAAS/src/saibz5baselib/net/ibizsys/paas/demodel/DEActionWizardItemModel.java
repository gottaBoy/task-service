/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEActionWizardItemModel;

public class DEActionWizardItemModel
extends ModelBase3Impl
implements IDEActionWizardItemModel {
    private String strContent = null;
    private String strMoreUrl = null;
    private String strActionValue = null;
    private IDEActionWizard iDEActionWizard = null;

    public void init(IDEActionWizard iDEActionWizard) throws Exception {
        this.iDEActionWizard = iDEActionWizard;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public void setMoreUrl(String strMoreUrl) {
        this.strMoreUrl = strMoreUrl;
    }

    public void setActionValue(String strActionValue) {
        this.strActionValue = strActionValue;
    }

    @Override
    public String getContent() {
        return this.strContent;
    }

    @Override
    public String getMoreUrl() {
        return this.strMoreUrl;
    }

    @Override
    public String getActionValue() {
        return this.strActionValue;
    }

    @Override
    public IDEActionWizard getDEActionWizard() {
        return this.iDEActionWizard;
    }
}

