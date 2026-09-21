/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCMTDEFService
extends PSDCMTDEFServiceBase {
    private static final Log log = LogFactory.getLog(PSDCMTDEFService.class);

    @Override
    public boolean fillModelV2Key(PSDCMTDEF pSDCMTDEF, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        if (!bl) {
            if (StringHelper.isNullOrEmpty((String)pSDCMTDEF.getPSDCMTDEFId())) {
                pSDCMTDEF.setPSDCMTDEFId(KeyValueHelper.genGuidEx());
            }
            return true;
        }
        return super.fillModelV2Key(pSDCMTDEF, objectNode, string, string2, bl);
    }
}

