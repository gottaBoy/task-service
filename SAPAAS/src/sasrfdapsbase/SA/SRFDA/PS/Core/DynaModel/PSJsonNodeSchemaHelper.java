/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonArraySchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonBooleanSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonIntegerSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNullSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNumberSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonObjectSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonRefSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonStringSchemaImpl;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;

public class PSJsonNodeSchemaHelper {
    private static PSJsonNodeSchemaHelper instance = null;

    public static PSJsonNodeSchemaHelper getInstance() {
        if (instance == null) {
            instance = new PSJsonNodeSchemaHelper();
        }
        return instance;
    }

    public static void setPSJsonNodeSchemaHelper(PSJsonNodeSchemaHelper instance) {
        PSJsonNodeSchemaHelper.instance = instance;
    }

    public IPSJsonNodeSchema getPSJsonNodeSchema(IPSJsonNodeOwner iPSJsonNodeOwner, String strName, ObjectNode objData) throws Exception {
        return this.getPSJsonNodeSchema(iPSJsonNodeOwner, null, strName, objData);
    }

    public IPSJsonNodeSchema getPSJsonNodeSchema(IPSJsonNodeOwner iPSJsonNodeOwner, String strType, String strName, ObjectNode objData) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strType)) {
            if (objData.has("type")) {
                strType = objData.get("type").textValue();
            } else if (objData.has("properties")) {
                strType = "object";
            }
        }
        if (StringHelper.compare((String)"array", (String)strType, (boolean)false) == 0) {
            PSJsonArraySchemaImpl psJsonArraySchemaImpl = new PSJsonArraySchemaImpl();
            psJsonArraySchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonArraySchemaImpl;
        }
        if (StringHelper.compare((String)"boolean", (String)strType, (boolean)false) == 0) {
            PSJsonBooleanSchemaImpl psJsonBooleanSchemaImpl = new PSJsonBooleanSchemaImpl();
            psJsonBooleanSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonBooleanSchemaImpl;
        }
        if (StringHelper.compare((String)"null", (String)strType, (boolean)false) == 0) {
            PSJsonNullSchemaImpl psJsonNullSchemaImpl = new PSJsonNullSchemaImpl();
            psJsonNullSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonNullSchemaImpl;
        }
        if (StringHelper.compare((String)"number", (String)strType, (boolean)false) == 0) {
            PSJsonNumberSchemaImpl psJsonNumberSchemaImpl = new PSJsonNumberSchemaImpl();
            psJsonNumberSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonNumberSchemaImpl;
        }
        if (StringHelper.compare((String)"integer", (String)strType, (boolean)false) == 0) {
            PSJsonIntegerSchemaImpl psJsonIntegerSchemaImpl = new PSJsonIntegerSchemaImpl();
            psJsonIntegerSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonIntegerSchemaImpl;
        }
        if (StringHelper.compare((String)"string", (String)strType, (boolean)false) == 0) {
            PSJsonStringSchemaImpl psJsonStringSchemaImpl = new PSJsonStringSchemaImpl();
            psJsonStringSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonStringSchemaImpl;
        }
        if (objData.has("$ref")) {
            PSJsonRefSchemaImpl psJsonRefSchemaImpl = new PSJsonRefSchemaImpl();
            psJsonRefSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
            return psJsonRefSchemaImpl;
        }
        PSJsonObjectSchemaImpl psJsonObjectSchemaImpl = new PSJsonObjectSchemaImpl();
        psJsonObjectSchemaImpl.init(GlobalHelperEx.getInstance(), iPSJsonNodeOwner, strName, (JsonNode)objData);
        return psJsonObjectSchemaImpl;
    }
}

