/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.pswx.core.IWXAccount
 *  net.ibizsys.pswx.core.IWXAccountModel
 *  net.ibizsys.pswx.core.IWXEntApp
 *  net.ibizsys.pswx.core.IWXEntAppModel
 *  net.ibizsys.pswx.core.IWXLogicModel
 */
package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.IWXLogicModel;

public class WXLogicModel
extends ModelBaseImpl
implements IWXLogicModel {
    private IWXAccountModel iWXAccountModel = null;
    private IWXEntAppModel iWXEntAppModel = null;
    private String strDEName = null;
    private String strDEActionName = null;
    private String strEventType = null;
    private String strWXFunc = null;
    private String strClickTag = null;
    private String strUserTag = null;

    public void init(IWXAccountModel iWXAccountModel, IWXEntAppModel iWXEntAppModel) throws Exception {
        this.iWXAccountModel = iWXAccountModel;
        this.iWXEntAppModel = iWXEntAppModel;
        this.onInit();
    }

    public IWXAccount getWXAccount() {
        return this.iWXAccountModel;
    }

    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public String getDEActionName() {
        return this.strDEActionName;
    }

    public void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    public String getEventType() {
        return this.strEventType;
    }

    public void setEventType(String strEventType) {
        this.strEventType = strEventType;
    }

    public String getWXFunc() {
        return this.strWXFunc;
    }

    public void setWXFunc(String strWXFunc) {
        this.strWXFunc = strWXFunc;
    }

    public String getClickTag() {
        return this.strClickTag;
    }

    public void setClickTag(String strClickTag) {
        this.strClickTag = strClickTag;
    }

    public IWXAccountModel getWXAccountModel() {
        return this.iWXAccountModel;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public IWXEntAppModel getWXEntAppModel() {
        return this.iWXEntAppModel;
    }

    public IWXEntApp getWXEntApp() {
        return this.getWXEntAppModel();
    }

    public String getUserTag() {
        return this.strUserTag;
    }

    public void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }
}

