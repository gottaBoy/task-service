/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IDynaWFSetting
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;
import net.ibizsys.pswf.core.IDynaWFSetting;

public interface IDynaWFSettingModel
extends IDynaWFSetting {
    public void init(IDynaSystemSettingModel var1) throws Exception;

    public IDynaSystemSettingModel getDynaSystemSettingModel();
}

