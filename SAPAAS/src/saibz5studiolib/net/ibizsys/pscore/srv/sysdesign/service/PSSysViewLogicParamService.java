/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicParam;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicParamServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysViewLogicParamService
extends PSSysViewLogicParamServiceBase {
    private static final Log log = LogFactory.getLog(PSSysViewLogicParamService.class);

    @Override
    protected void onBeforeCreate(PSSysViewLogicParam pSSysViewLogicParam) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysViewLogicParam.getParamSubKey())) {
            pSSysViewLogicParam.setPSSysViewLogicParamName(pSSysViewLogicParam.getParamKey());
        } else {
            pSSysViewLogicParam.setPSSysViewLogicParamName(StringHelper.format((String)"%1$s.%2$s", (Object)pSSysViewLogicParam.getParamKey(), (Object)pSSysViewLogicParam.getParamSubKey()));
        }
        super.onBeforeCreate(pSSysViewLogicParam);
    }

    @Override
    protected void onBeforeCreateTemp(PSSysViewLogicParam pSSysViewLogicParam) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysViewLogicParam.getParamSubKey())) {
            pSSysViewLogicParam.setPSSysViewLogicParamName(pSSysViewLogicParam.getParamKey());
        } else {
            pSSysViewLogicParam.setPSSysViewLogicParamName(StringHelper.format((String)"%1$s.%2$s", (Object)pSSysViewLogicParam.getParamKey(), (Object)pSSysViewLogicParam.getParamSubKey()));
        }
        super.onBeforeCreateTemp(pSSysViewLogicParam);
    }
}

