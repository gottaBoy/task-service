/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysModelFolderItemService
extends PSSysModelFolderItemServiceBase {
    private static final Log log = LogFactory.getLog(PSSysModelFolderItemService.class);

    @Override
    public boolean fillModelV2Key(PSSysModelFolderItem pSSysModelFolderItem, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSSysModelFolderItem, objectNode, string, string2, bl);
        if (bl && objectNode != null) {
            try {
                String string3 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"psobjid", null);
                String string4 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"psobjtype", null);
                if (!StringHelper.isNullOrEmpty((String)string3) && !StringHelper.isNullOrEmpty((String)string4)) {
                    string3 = this.getModelV2Key(string4, string3, string, "PSOBJID");
                    pSSysModelFolderItem.setPSObjId(string3);
                }
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
        return bl2;
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysModelFolderItem pSSysModelFolderItem, String string) throws Exception {
        if ((objectNode = super.fillModelV2(objectNode, pSSysModelFolderItem, string)) != null && !StringHelper.isNullOrEmpty((String)pSSysModelFolderItem.getPSObjId()) && !StringHelper.isNullOrEmpty((String)pSSysModelFolderItem.getPSObjType())) {
            try {
                String string2 = this.getModelV2UniqueTag(pSSysModelFolderItem.getPSObjType(), pSSysModelFolderItem.getPSObjId(), string);
                objectNode.remove("psobjid");
                objectNode.put("psobjid", string2);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
        return objectNode;
    }
}

