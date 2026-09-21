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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysUtilDEService
extends PSSysUtilDEServiceBase {
    private static final Log log = LogFactory.getLog(PSSysUtilDEService.class);

    @Override
    public String getModelV2Tag(PSSysUtilDE pSSysUtilDE) {
        if (!StringHelper.isNullOrEmpty((String)pSSysUtilDE.getUtilType())) {
            if (!StringHelper.isNullOrEmpty((String)pSSysUtilDE.getUtilTag())) {
                return StringHelper.format((String)"%1$s#%2$s", (Object)pSSysUtilDE.getUtilType(), (Object)pSSysUtilDE.getUtilTag());
            }
            return pSSysUtilDE.getUtilType();
        }
        return super.getModelV2Tag(pSSysUtilDE);
    }
}

