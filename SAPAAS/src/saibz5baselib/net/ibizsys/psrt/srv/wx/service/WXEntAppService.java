/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wx.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.service.WXEntAppServiceBase;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.WXGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WXEntAppService
extends WXEntAppServiceBase {
    private static final Log log = LogFactory.getLog(WXEntAppService.class);

    @Override
    protected void onPubMenu(WXEntApp wXEntApp) throws Exception {
        IWXAccountModel accountModel = WXGlobal.getWXAccountModel(wXEntApp.getWXAccountId());
        if (accountModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7\u6a21\u578b\u5bf9\u8c61");
        }
        if (wXEntApp.getAgentId() == null) {
            throw new Exception("\u672a\u914d\u7f6e\u4f01\u4e1a\u5e94\u7528\u6807\u8bc6");
        }
        IWXEntAppModel iEntAppModel = accountModel.getWXEntAppModel(wXEntApp.getAgentId());
        if (iEntAppModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u5e94\u7528\u6a21\u578b\u5bf9\u8c61");
        }
        CallResult callResult = iEntAppModel.publishMenu();
        if (callResult.isError()) {
            throw new Exception(callResult.getErrorInfo());
        }
    }
}

