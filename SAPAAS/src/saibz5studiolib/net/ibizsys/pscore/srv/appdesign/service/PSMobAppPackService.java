/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSMobAppPackService
extends PSMobAppPackServiceBase {
    private static final Log log = LogFactory.getLog(PSMobAppPackService.class);

    @Override
    protected void onBeforeCreate(PSMobAppPack pSMobAppPack) throws Exception {
        this.calcPSMobAppPackOSTypes(pSMobAppPack);
        super.onBeforeCreate(pSMobAppPack);
    }

    @Override
    protected void onBeforeUpdate(PSMobAppPack pSMobAppPack) throws Exception {
        this.calcPSMobAppPackOSTypes(pSMobAppPack);
        super.onBeforeUpdate(pSMobAppPack);
    }

    protected void calcPSMobAppPackOSTypes(PSMobAppPack pSMobAppPack) throws Exception {
        String string = "";
        if (DataObject.getBoolValue((Integer)pSMobAppPack.getEnableAndroid(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "ANDROID";
        }
        if (DataObject.getBoolValue((Integer)pSMobAppPack.getEnableIOS(), (boolean)false)) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + "IOS";
        }
        pSMobAppPack.setOSTypes(string);
    }
}

