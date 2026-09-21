/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRV;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETreeNodeRVService
extends PSDETreeNodeRVServiceBase {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRVService.class);

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeNodeRV pSDETreeNodeRV, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeNodeRV, string);
        objectNode.remove("psdetreeviewid");
        return objectNode;
    }
}

