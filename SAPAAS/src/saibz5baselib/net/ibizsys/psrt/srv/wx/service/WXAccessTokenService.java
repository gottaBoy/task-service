/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wx.service;

import net.ibizsys.psrt.srv.wx.service.WXAccessTokenServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WXAccessTokenService
extends WXAccessTokenServiceBase {
    private static final Log log = LogFactory.getLog(WXAccessTokenService.class);
}

