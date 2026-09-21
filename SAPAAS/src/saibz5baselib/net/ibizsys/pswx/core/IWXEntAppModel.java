/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.bean.WXOutMsg;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntApp;

public interface IWXEntAppModel
extends IWXEntApp {
    public IWXAccountModel getWXAccountModel();

    public int getAgentId();

    public void setAgentId(int var1);

    public void setReportLocation(boolean var1);

    public void setReportEnter(boolean var1);

    public void setAppURL(String var1);

    public void processWXMessage(WXMessage var1) throws Exception;

    public void setAppSecret(String var1);

    public void setToken(String var1);

    public void setEncodingAESKey(String var1);

    public String getAccessToken();

    public String createJsToken(String var1);

    public CallResult sendMsg(WXOutMsg var1);

    public CallResult downloadMedia(String var1);

    public CallResult publishMenu();

    public CallResult deleteMenu();

    public CallResult getMenu();

    public Object getRuntimeId();

    public void setRuntimeId(Object var1);
}

