/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDBTableService
extends PSSysDBTableServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDBTableService.class);

    @Override
    protected boolean isExportRelatedModelV2(String string) {
        if (PSSysDBTableService.isSimpleImportExportMode() && StringHelper.compare((String)"DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return super.isExportRelatedModelV2(string);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysDBTable pSSysDBTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (PSSysDBTableService.isSimpleImportExportMode()) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysDBColumnService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                    pSSysDBColumn.setPSSysDBSchemeId(pSSysDBTable.getPSSysDBSchemeId());
                    pSSysDBColumn.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
                    pSSysDBColumn.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                    pSSysDBColumnService.compileModelV2(pSSysDBColumn, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                        pSSysDBColumn.setPSSysDBSchemeId(pSSysDBTable.getPSSysDBSchemeId());
                        pSSysDBColumn.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
                        pSSysDBColumn.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                        pSSysDBColumnService.compileModelV2(pSSysDBColumn, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysDBTable, objectNode, string, string2, n);
    }
}

