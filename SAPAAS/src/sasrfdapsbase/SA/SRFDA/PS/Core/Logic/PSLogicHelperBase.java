/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Logic;

import SA.SRFDA.PS.Core.Logic.IPSLogicItem;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSLogicHelperBase<ET extends IPSLogicItem> {
    public ET parse(String strJsonString) throws Exception {
        JsonNode jsonNode = JsonNodeHelper.fromString((String)strJsonString);
        ArrayNode arrayNode = null;
        if (jsonNode instanceof ArrayNode) {
            arrayNode = (ArrayNode)jsonNode;
        }
        if (arrayNode == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5185\u5bb9\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3aJson\u6570\u7ec4\u683c\u5f0f"));
        }
        return null;
    }

    protected ET parse(ArrayNode arrayNode) throws Exception {
        if (arrayNode.size() <= 0) {
            throw new Exception(StringHelper.format((String)"Json\u6570\u7ec4\u957f\u5ea6\u4e0d\u80fd\u4e3a0"));
        }
        JsonNode node1 = arrayNode.get(0);
        return null;
    }
}

