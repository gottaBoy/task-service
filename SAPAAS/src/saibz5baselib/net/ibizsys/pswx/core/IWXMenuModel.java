/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.core;

import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.IWXMenu;
import net.sf.json.JSONObject;

public interface IWXMenuModel
extends IWXMenu {
    public IWXAccountModel getWXAccountModel();

    public IWXEntAppModel getWXEntAppModel();

    public JSONObject toJSON();
}

