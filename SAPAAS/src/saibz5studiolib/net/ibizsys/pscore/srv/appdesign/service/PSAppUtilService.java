/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtil;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppUtilService
extends PSAppUtilServiceBase {
    private static final Log log = LogFactory.getLog(PSAppUtilService.class);

    @Override
    public boolean fillEntityKeyValue(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (!bl && StringHelper.compare((String)pSAppUtil.getUtilType(), (String)"USER", (boolean)true) != 0) {
            pSAppUtil.resetUtilTag();
        }
        return super.fillEntityKeyValue(pSAppUtil, bl);
    }
}

