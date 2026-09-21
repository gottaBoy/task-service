/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelExporter;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;

@PSModelIgnoreMeta
public abstract class PSModelExporterBase
implements IPSModelExporter {
    public static final String ATTR_ID = "id";
    public static final String ATTR_NAME = "name";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_CODENAME = "codename";
    public static final String ATTR_LOGICNAME = "logicname";

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode, iPSModelObject, strMode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_ID, (Object)iPSModelObject.getId());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_NAME, (Object)iPSModelObject.getName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_TYPE, (Object)iPSModelObject.getModelType());
    }
}

