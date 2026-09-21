/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDE;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEUtilDEService
extends PSDEUtilDEServiceBase {
    private static final Log log = LogFactory.getLog(PSDEUtilDEService.class);

    @Override
    public String getModelV2Tag(PSDEUtilDE pSDEUtilDE) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUtilDE.getUtilType())) {
            if (!StringHelper.isNullOrEmpty((String)pSDEUtilDE.getUtilTag())) {
                return StringHelper.format((String)"%1$s#%2$s", (Object)pSDEUtilDE.getUtilType(), (Object)pSDEUtilDE.getUtilTag());
            }
            return pSDEUtilDE.getUtilType();
        }
        return super.getModelV2Tag(pSDEUtilDE);
    }
}

