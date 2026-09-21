/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.pswx.core.IWXAccount
 *  net.ibizsys.pswx.core.IWXAccountModel
 *  net.ibizsys.pswx.core.IWXEntApp
 *  net.ibizsys.pswx.core.IWXEntAppModel
 *  net.ibizsys.pswx.core.IWXMenuItem
 *  net.ibizsys.pswx.core.IWXMenuModel
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.core;

import java.util.Iterator;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.IWXMenuItem;
import net.ibizsys.pswx.core.IWXMenuModel;
import net.ibizsys.pswx.core.WXMenuRootItem;
import net.sf.json.JSONObject;

public class WXMenuModel
extends ModelBaseImpl
implements IWXMenuModel {
    private WXMenuRootItem wxMenuRootItem = new WXMenuRootItem();
    private IWXAccountModel iWXAccountModel = null;
    private IWXEntAppModel iWXEntAppModel = null;

    public void init(IWXAccountModel iWXAccountModel, IWXEntAppModel iWXEntAppModel) throws Exception {
        this.iWXAccountModel = iWXAccountModel;
        this.iWXEntAppModel = iWXEntAppModel;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public WXMenuRootItem getRootItem() {
        return this.wxMenuRootItem;
    }

    public Iterator<IWXMenuItem> getWXMenuItems() {
        return this.getRootItem().getItems().iterator();
    }

    public IWXAccount getWXAccount() {
        return this.getWXAccountModel();
    }

    public IWXEntApp getWXEntApp() {
        return this.getWXEntAppModel();
    }

    public IWXAccountModel getWXAccountModel() {
        return this.iWXAccountModel;
    }

    public IWXEntAppModel getWXEntAppModel() {
        return this.iWXEntAppModel;
    }

    public JSONObject toJSON() {
        return this.wxMenuRootItem.toJSON();
    }
}

