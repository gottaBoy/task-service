/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporter;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.JsonNodeHelper;

@PSModelIgnoreMeta
public class PSDEServiceAPIExporter
extends PSModelExporterBase {
    public static final String ATTR_DATAENTITY = "dataentity";
    public static final String ATTR_METHODS = "methods";

    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDEServiceAPI iPSDEServiceAPI = (IPSDEServiceAPI)iPSModelObject;
        IPSDataEntity iPSDataEntity = iPSDEServiceAPI.getPSDataEntity();
        ObjectNode dataEntityJsonNode = PSModelExporter.toJsonObject(iPSDataEntity, "SIMPLE");
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DATAENTITY, (Object)dataEntityJsonNode);
        Iterator<IPSDEServiceAPIMethod> psDEServiceAPIMethods = iPSDEServiceAPI.getPSDEServiceAPIMethods();
        if (psDEServiceAPIMethods != null) {
            ArrayList<ObjectNode> methodObjectNodeList = new ArrayList<ObjectNode>();
            while (psDEServiceAPIMethods.hasNext()) {
                IPSDEServiceAPIMethod iPSDEServiceAPIMethod = psDEServiceAPIMethods.next();
                ObjectNode apiMethodJsonNode = PSModelExporter.toJsonObject(iPSDEServiceAPIMethod);
                methodObjectNodeList.add(apiMethodJsonNode);
            }
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_METHODS, methodObjectNodeList);
        }
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

