/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelRTServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSModelRTService
extends PSModelRTServiceBase {
    private static final Log log = LogFactory.getLog(PSModelRTService.class);

    @Override
    protected void getRemoteCallUrlParams(Map<String, String> map, String string, IEntity iEntity) throws Exception {
        super.getRemoteCallUrlParams(map, string, iEntity);
        map.put("action", "preview");
    }
}

