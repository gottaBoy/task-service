/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.view.DynaUIActionModelBase;
import net.ibizsys.paas.view.IDynaFrontUIActionModel;

public class DefaultDynaFrontUIActionModel
extends DynaUIActionModelBase
implements IDynaFrontUIActionModel {
    private String strFrontProcessType = null;
    private String strFrontViewId = null;

    @Override
    public String getFrontProcessType() {
        return this.strFrontProcessType;
    }

    public void setFrontProcessType(String strFrontProcessType) {
        this.strFrontProcessType = strFrontProcessType;
    }

    @Override
    public String getFrontViewId() {
        return this.strFrontViewId;
    }

    public void setFrontViewId(String strFrontViewId) {
        this.strFrontViewId = strFrontViewId;
    }
}

