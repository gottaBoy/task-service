/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppSBItemService
extends PSAppSBItemServiceBase {
    private static final Log log = LogFactory.getLog(PSAppSBItemService.class);

    @Override
    public void compileModelV2(PSAppSBItem pSAppSBItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (objectNode != null && JsonNodeHelper.getInt((ObjectNode)objectNode, (String)"userflag", (int)1) != 1) {
            return;
        }
        super.compileModelV2(pSAppSBItem, objectNode, string, string2, n);
    }
}

