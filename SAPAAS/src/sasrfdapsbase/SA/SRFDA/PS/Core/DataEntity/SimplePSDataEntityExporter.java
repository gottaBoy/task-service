/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityExporterBase;
import SA.SRFDA.PS.Core.IPSModelObject;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SimplePSDataEntityExporter
extends PSDataEntityExporterBase {
    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDataEntity iPSDataEntity = (IPSDataEntity)iPSModelObject;
        this.fillPSDEFieldsJsonObject(objectNode, iPSDataEntity, "SIMPLE");
        this.fillPSDERsJsonObject(objectNode, iPSDataEntity, "SIMPLE");
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

