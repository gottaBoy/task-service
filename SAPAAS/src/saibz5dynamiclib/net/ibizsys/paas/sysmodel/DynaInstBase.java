/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase3Impl
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 *  net.ibizsys.paas.sysmodel.ISystemModel
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.IDynaInst;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.ISystemModel;

public abstract class DynaInstBase
extends ModelBase3Impl
implements IDynaInst {
    private IDynaSystemSetting iDynaSystemSetting = null;
    private String strDynaSystemInstId = null;
    private ISystemModel iSystemModel = null;

    @Override
    public void init(ISystemModel iSystemModel, String strDynaSystemInstId) throws Exception {
        this.iSystemModel = iSystemModel;
        this.iDynaSystemSetting = this.iSystemModel.getDynaSystemSetting();
        this.strDynaSystemInstId = strDynaSystemInstId;
        this.strId = strDynaSystemInstId;
        this.onInit();
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    @Override
    public IDynaSystemSetting getDynaSystemSetting() {
        return this.iDynaSystemSetting;
    }

    @Override
    public IDynaInst getParentDynaInst() {
        return null;
    }
}

