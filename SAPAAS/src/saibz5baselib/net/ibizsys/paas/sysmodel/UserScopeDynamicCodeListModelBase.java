/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;
import net.ibizsys.paas.sysmodel.IUserCodeListModel;

public abstract class UserScopeDynamicCodeListModelBase
extends DynamicCodeListModelBase
implements IUserCodeListModel {
    private String strUserId = null;

    @Override
    public void setCurUserId(String strUserId) {
        this.strUserId = strUserId;
    }

    @Override
    public String getCurUserId() {
        return this.strUserId;
    }
}

