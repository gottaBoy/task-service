/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSubSysServiceAPIService
extends PSSubSysServiceAPIServiceBase {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIService.class);
    public static final String IMPORTSCHEMA = "IMPORTSCHEMA";

    @Override
    protected void onImportSchema(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        Object object = pSSubSysServiceAPI.get(IMPORTSCHEMA);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            throw new Exception("\u672a\u4f20\u5165\u5bfc\u5165\u6a21\u578b");
        }
        PSSubSysServiceAPI pSSubSysServiceAPI2 = new PSSubSysServiceAPI();
        pSSubSysServiceAPI2.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        this.get(pSSubSysServiceAPI2);
        if (StringHelper.isNullOrEmpty((String)pSSubSysServiceAPI2.getServicePath())) {
            throw new Exception("\u5916\u90e8\u63a5\u53e3\u672a\u6307\u5b9a\u670d\u52a1\u9ed8\u8ba4\u8def\u5f84");
        }
        String string = (String)object;
        this.onImportSwaggerV2(string, pSSubSysServiceAPI2);
    }

    protected void onImportSwaggerV2(String string, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ObjectNode objectNode = null;
        try {
            objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string);
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u6a21\u578b\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        String string2 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"host", null);
        String string3 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"basePath", null);
        JsonNode jsonNode = objectNode.get("paths");
        if (jsonNode instanceof ObjectNode) {
            ObjectNode objectNode2 = (ObjectNode)jsonNode;
        }
    }
}

