/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;

@PSModelIgnoreMeta
public abstract class PSDEFieldExporterBase
extends PSModelExporterBase {
    public static final String ATTR_DEFTYPE = "deftype";
    public static final String ATTR_DATATYPE = "datatype";
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_PRECISION = "precision";

    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDEField iPSDEField = (IPSDEField)iPSModelObject;
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"codename", (Object)iPSDEField.getCodeName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"logicname", (Object)iPSDEField.getLogicName());
        if (iPSDEField.isPhisicalDEField()) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEFTYPE, (Object)1);
        } else if (iPSDEField.isFormulaDEField()) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEFTYPE, (Object)2);
        } else if (iPSDEField.isLinkDEField()) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DEFTYPE, (Object)3);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DATATYPE, (Object)iPSDEField.getDataType());
        if (iPSDEField.getLength() > 0) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_LENGTH, (Object)iPSDEField.getLength());
        }
        if (iPSDEField.getPrecision() > 0) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_PRECISION, (Object)iPSDEField.getPrecision());
        }
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

