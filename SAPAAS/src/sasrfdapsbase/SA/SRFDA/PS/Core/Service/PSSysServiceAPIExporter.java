/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporter;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.JsonNodeHelper;

public class PSSysServiceAPIExporter
extends PSModelExporterBase {
    public static final String ATTR_DESERVICEAPIS = "deserviceapis";
    public static final String ATTR_DEVSLNSYSAPIID = "devslnsysapiid";

    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSSysServiceAPI iPSSysServiceAPI = (IPSSysServiceAPI)iPSModelObject;
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEVSLNSYSAPIID, (Object)iPSSysServiceAPI.getPSDevSlnSysAPIId());
        Iterator<IPSDEServiceAPI> psDEServiceAPIs = iPSSysServiceAPI.getPSDEServiceAPIs();
        if (psDEServiceAPIs != null) {
            ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
            while (psDEServiceAPIs.hasNext()) {
                ObjectNode deServiceAPINode = PSModelExporter.toJsonObject(null, psDEServiceAPIs.next(), null);
                objectNodeList.add(deServiceAPINode);
            }
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DESERVICEAPIS, objectNodeList);
        }
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

