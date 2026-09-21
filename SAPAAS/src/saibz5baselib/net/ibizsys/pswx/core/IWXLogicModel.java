/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.IWXLogic;

public interface IWXLogicModel
extends IWXLogic {
    public IWXAccountModel getWXAccountModel();

    public IWXEntAppModel getWXEntAppModel();
}

