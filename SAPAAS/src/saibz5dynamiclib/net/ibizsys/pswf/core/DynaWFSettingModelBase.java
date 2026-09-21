/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase3Impl
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;
import net.ibizsys.pswf.core.IDynaWFSettingModel;

public abstract class DynaWFSettingModelBase
extends ModelBase3Impl
implements IDynaWFSettingModel {
    private IDynaSystemSettingModel iDynaSystemSettingModel = null;

    @Override
    public void init(IDynaSystemSettingModel iDynaSystemSettingModel) throws Exception {
        this.iDynaSystemSettingModel = iDynaSystemSettingModel;
        this.onInit();
    }

    @Override
    public IDynaSystemSettingModel getDynaSystemSettingModel() {
        return this.iDynaSystemSettingModel;
    }

    public String getWFDEName() {
        return null;
    }

    public String getWFVersionDEName() {
        return null;
    }
}

