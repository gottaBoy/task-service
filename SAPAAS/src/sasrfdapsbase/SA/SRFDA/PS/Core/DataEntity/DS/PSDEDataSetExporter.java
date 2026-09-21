/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;

public class PSDEDataSetExporter
extends PSModelExporterBase {
    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDEDataSet iPSDEDataSet = (IPSDEDataSet)iPSModelObject;
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"codename", (Object)iPSDEDataSet.getCodeName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"logicname", (Object)iPSDEDataSet.getLogicName());
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

