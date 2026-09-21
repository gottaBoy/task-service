/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonObjectSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperties;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaHelper;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaImplBase;
import SA.SRFDA.PS.Core.DynaModel.PSJsonPropertiesImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysDynaModelAttr;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJsonObjectSchemaImpl
extends PSJsonNodeSchemaImplBase
implements IPSJsonObjectSchema {
    private static final Log log = LogFactory.getLog(PSJsonObjectSchemaImpl.class);
    private IPSJsonProperties iPSJsonProperties = null;
    private boolean bEnableAdditionalProperties = true;
    private IPSJsonNodeSchema additionalPSJsonNodeSchema = null;
    private List<String> requiredList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSJsonNodeOwner iPSJsonNodeOwner, String strName, ObjectNode objectNode, Vector<PSSysDynaModelAttr> psSysDynaModelAttrList) throws Exception {
        try {
            this.init(iDAGlobalHelper, iPSJsonNodeOwner, strName, (JsonNode)objectNode);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        JsonNode jsonNode = this.getObjectNode().get("properties");
        if (jsonNode != null) {
            if (jsonNode instanceof ObjectNode) {
                this.iPSJsonProperties = this.getPSJsonObjectProperties("properties", (ObjectNode)jsonNode);
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "properties"));
            }
        }
        if (this.getObjectNode().has("additionalProperties")) {
            jsonNode = this.getObjectNode().get("additionalProperties");
            if (jsonNode.isBoolean()) {
                this.setEnableAdditionalProperties(jsonNode.booleanValue());
            } else if (jsonNode instanceof ObjectNode) {
                this.setAdditionalPSJsonNodeSchema(this.getPSJsonNodeSchema("additionalProperties", (ObjectNode)jsonNode));
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "additionalProperties"));
            }
        }
        if (this.getObjectNode().has("required")) {
            jsonNode = this.getObjectNode().get("required");
            this.setRequired(this.getRequired("required", jsonNode));
        }
        super.onInit();
    }

    protected IPSJsonProperties getPSJsonObjectProperties(String strName, ObjectNode objectNode) throws Exception {
        PSJsonPropertiesImpl psJsonPropertiesImpl = new PSJsonPropertiesImpl();
        psJsonPropertiesImpl.init(this.getDAGlobalHelper(), this, strName, objectNode);
        return psJsonPropertiesImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u96c6\u5408")
    public IPSJsonProperties getPSJsonProperties() {
        return this.iPSJsonProperties;
    }

    protected void setPSJsonObjectProperties(IPSJsonProperties iPSJsonProperties) {
        this.iPSJsonProperties = iPSJsonProperties;
    }

    @Override
    @PSModelRTMeta(description="\u5fc5\u987b\u5c5e\u6027\u96c6\u5408")
    public Iterator<String> getRequired() {
        if (this.requiredList == null || this.requiredList.size() == 0) {
            return null;
        }
        return this.requiredList.iterator();
    }

    protected void setRequired(List<String> requiredList) {
        this.requiredList = requiredList;
    }

    protected List<String> getRequired(String strName, JsonNode jsonNode) throws Exception {
        if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode)jsonNode;
            if (arrayNode.size() == 0) {
                return null;
            }
            ArrayList<String> list = new ArrayList<String>();
            int i = 0;
            while (i < arrayNode.size()) {
                JsonNode item = arrayNode.get(i);
                list.add(item.textValue());
                ++i;
            }
            return list;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6269\u5c55\u5c5e\u6027")
    public boolean isEnableAdditionalProperties() {
        return this.bEnableAdditionalProperties;
    }

    protected void setEnableAdditionalProperties(boolean bEnableAdditionalProperties) {
        this.bEnableAdditionalProperties = bEnableAdditionalProperties;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u5c5e\u6027\u7c7b\u578b")
    public IPSJsonNodeSchema getAdditionalPSJsonNodeSchema() {
        return this.additionalPSJsonNodeSchema;
    }

    protected void setAdditionalPSJsonNodeSchema(IPSJsonNodeSchema additionalPSJsonNodeSchema) {
        this.additionalPSJsonNodeSchema = additionalPSJsonNodeSchema;
    }

    protected IPSJsonNodeSchema getPSJsonNodeSchema(String strName, ObjectNode objectNode) throws Exception {
        return PSJsonNodeSchemaHelper.getInstance().getPSJsonNodeSchema(this, strName, objectNode);
    }

    @Override
    protected String onGetType() {
        return "object";
    }
}

