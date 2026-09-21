/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import java.util.Collection;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXEntAppModel;

public interface IWXAccountModel
extends IWXAccount {
    public String getCorpId();

    public void setCropId(String var1);

    public String getCorpSecret();

    public void setCropSecret(String var1);

    public ISystemModel getSystemModel();

    public void processWXMessage(WXMessage var1) throws Exception;

    public IWXEntAppModel getWXEntAppModel(int var1) throws Exception;

    public IWXEntAppModel getWXEntAppModel(String var1) throws Exception;

    public CallResult syncWXDept(Collection<WXDept> var1);

    public CallResult syncWXUsers(Collection<WXUser> var1);

    public void refresh() throws Exception;

    public void setWXEntAppModelRuntimeId(String var1, Object var2) throws Exception;

    public IWXEntAppModel getWXEntAppModelByRuntimeId(Object var1) throws Exception;
}

