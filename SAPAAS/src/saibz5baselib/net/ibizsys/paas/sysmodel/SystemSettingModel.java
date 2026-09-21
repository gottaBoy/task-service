/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.ISystemSettingModel;

public class SystemSettingModel
implements ISystemSettingModel {
    private boolean bEnableDBValueInsertUpdateMode = false;

    @Override
    public boolean isEnableDBValueInsertUpdateMode() {
        return this.bEnableDBValueInsertUpdateMode;
    }

    public void setEnableDBValueInsertUpdateMode(boolean bEnableDBValueInsertUpdateMode) {
        this.bEnableDBValueInsertUpdateMode = bEnableDBValueInsertUpdateMode;
    }
}

