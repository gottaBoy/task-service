/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExporter;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.JsonNodeHelper;

public abstract class PSDataEntityExporterBase
extends PSModelExporterBase {
    public static final String ATTR_DEFIELDS = "defields";
    public static final String ATTR_DERS = "ders";

    protected void fillPSDEFieldsJsonObject(ObjectNode objectNode, IPSDataEntity iPSDataEntity, String strMode) throws Exception {
        ArrayList<ObjectNode> defieldList = new ArrayList<ObjectNode>();
        Iterator<IPSDEField> psDEFields = iPSDataEntity.getAllPSDEFields();
        while (psDEFields.hasNext()) {
            ObjectNode defieldObjectNode = PSModelExporter.toJsonObject(psDEFields.next(), strMode);
            defieldList.add(defieldObjectNode);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEFIELDS, defieldList);
    }

    protected void fillPSDERsJsonObject(ObjectNode objectNode, IPSDataEntity iPSDataEntity, String strMode) throws Exception {
        ArrayList<ObjectNode> derList = new ArrayList<ObjectNode>();
        Iterator<IPSDERBase> psDERBases = iPSDataEntity.getPSDERs(true);
        while (psDERBases.hasNext()) {
            ObjectNode derObjectNode = PSModelExporter.toJsonObject(psDERBases.next(), strMode);
            derList.add(derObjectNode);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DERS, derList);
    }
}

