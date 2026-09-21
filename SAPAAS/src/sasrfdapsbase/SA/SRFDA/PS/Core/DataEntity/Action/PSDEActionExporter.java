/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelExporterBase;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;

public class PSDEActionExporter
extends PSModelExporterBase {
    public static final String ATTR_ACTIONTYPE = "actiontype";

    @Override
    protected void onFillJsonObject(ObjectNode objectNode, IPSModelObject iPSModelObject, String strMode) throws Exception {
        IPSDEAction iPSDEAction = (IPSDEAction)iPSModelObject;
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"codename", (Object)iPSDEAction.getCodeName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"logicname", (Object)iPSDEAction.getLogicName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)ATTR_ACTIONTYPE, (Object)iPSDEAction.getActionType());
        super.onFillJsonObject(objectNode, iPSModelObject, strMode);
    }
}

