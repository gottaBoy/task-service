/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDERExporter
extends PSModelExporterBase {
    public static final String ATTR_DERTYPE = "dertype";
    public static final String ATTR_MINORCODENAME = "minorcodename";
    public static final String ATTR_MAJORDEID = "majordeid";
    public static final String ATTR_MAJORDENAME = "majordename";
    public static final String ATTR_MINORDEID = "minordeid";
    public static final String ATTR_MINORDENAME = "minordename";
    public static final String ATTR_TYPEVALUE = "typevalue";

    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDERBase iPSDERBase = (IPSDERBase)iPSModelObject;
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"codename", (Object)iPSDERBase.getCodeName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"logicname", (Object)iPSDERBase.getLogicName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_DERTYPE, (Object)iPSDERBase.getDERType());
        if (!StringHelper.isNullOrEmpty((String)iPSDERBase.getMinorCodeName())) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_MINORCODENAME, (Object)iPSDERBase.getMinorCodeName());
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_MAJORDEID, (Object)iPSDERBase.getMajorDEId());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_MAJORDENAME, (Object)iPSDERBase.getMajorDEName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_MINORDEID, (Object)iPSDERBase.getMinorDEId());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_MINORDENAME, (Object)iPSDERBase.getMinorDEName());
        if (iPSDERBase instanceof IPSDERIndex) {
            IPSDERIndex iPSDERIndex = (IPSDERIndex)iPSDERBase;
            JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_TYPEVALUE, (Object)iPSDERIndex.getTypeValue());
        }
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

