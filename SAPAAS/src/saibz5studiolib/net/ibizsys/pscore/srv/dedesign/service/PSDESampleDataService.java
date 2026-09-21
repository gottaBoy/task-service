/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDESampleDataService
extends PSDESampleDataServiceBase {
    private static final Log log = LogFactory.getLog(PSDESampleDataService.class);

    @Override
    public void getDraft(PSDESampleData pSDESampleData) throws Exception {
        super.getDraft(pSDESampleData);
        if (StringHelper.isNullOrEmpty((String)pSDESampleData.getData()) && !StringHelper.isNullOrEmpty((String)pSDESampleData.getPSDEId())) {
            PSDataEntity pSDataEntity = pSDESampleData.getPSDE();
            ArrayList<PSDEField> arrayList = pSDataEntity.getPSDEFields();
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            for (PSDEField object2 : arrayList) {
                objectNode.putNull(object2.getPSDEFieldName().toLowerCase());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString((Object)objectNode);
            pSDESampleData.setData(string);
        }
    }
}

