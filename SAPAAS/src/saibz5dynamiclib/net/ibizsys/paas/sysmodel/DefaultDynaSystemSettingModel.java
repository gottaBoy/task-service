/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IDynaViewSetting
 *  net.ibizsys.pswf.core.IDynaWFSetting
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.DefaultDynaSystemStorage;
import net.ibizsys.paas.sysmodel.DynaSystemSettingModelBase;
import net.ibizsys.paas.sysmodel.IDynaSystemStorage;
import net.ibizsys.paas.view.DefaultDynaViewSettingModel;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IDynaViewSettingModel;
import net.ibizsys.pswf.core.DefaultDynaWFSettingModel;
import net.ibizsys.pswf.core.IDynaWFSetting;
import net.ibizsys.pswf.core.IDynaWFSettingModel;

public class DefaultDynaSystemSettingModel
extends DynaSystemSettingModelBase {
    private IDynaWFSettingModel iDynaWFSettingModel = null;
    private IDynaViewSettingModel iDynaViewSettingModel = null;
    private IDynaSystemStorage iDynaSystemStorage = null;

    protected void onInit() throws Exception {
        this.iDynaSystemStorage = this.createDynaSystemStorage();
        this.iDynaViewSettingModel = this.createDynaViewSettingModel();
        this.iDynaWFSettingModel = this.createDynaWFSettingModel();
        this.iDynaSystemStorage.init(this);
        this.iDynaViewSettingModel.init(this);
        this.iDynaWFSettingModel.init(this);
        super.onInit();
    }

    @Override
    protected IDynaSystemStorage getDynaSystemStorage() throws Exception {
        return this.iDynaSystemStorage;
    }

    public IDynaViewSetting getDynaViewSetting() {
        return this.iDynaViewSettingModel;
    }

    public IDynaWFSetting getDynaWFSetting() {
        return this.iDynaWFSettingModel;
    }

    protected IDynaSystemStorage createDynaSystemStorage() {
        return new DefaultDynaSystemStorage();
    }

    protected IDynaViewSettingModel createDynaViewSettingModel() {
        return new DefaultDynaViewSettingModel();
    }

    protected IDynaWFSettingModel createDynaWFSettingModel() {
        return new DefaultDynaWFSettingModel();
    }
}

