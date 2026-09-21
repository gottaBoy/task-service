/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefs;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefsOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNode;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSJsonNodeSchemaImplBase
extends PSJsonNodeImpl
implements IPSJsonNodeSchema {
    private static final Log log = LogFactory.getLog(PSJsonNodeSchemaImplBase.class);
    private String strRefSchemaId = null;
    private IPSJsonNodeSchema refPSJsonNodeSchema = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSJsonNodeOwner iPSJsonNodeOwner, String strName, Object objData) throws Exception {
        try {
            if (!(objData instanceof ObjectNode)) {
                throw new Exception(String.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8282\u70b9\u6570\u636e", new Object[0]));
            }
            ObjectNode objectNode = (ObjectNode)objData;
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
        JsonNode refJsonNode = this.getObjectNode().get("$ref");
        if (refJsonNode != null) {
            this.setRefSchemaId(refJsonNode.textValue());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u63cf\u8ff0\u4fe1\u606f")
    public String getDescription() {
        if (this.getObjectNode().has("description")) {
            return this.getObjectNode().get("description").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b", codelist="JsonNodeType")
    public String getType() {
        return this.onGetType();
    }

    protected abstract String onGetType();

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u578b\u5bf9\u8c61")
    public IPSJsonNodeSchema getRefPSJsonNodeSchema() throws Exception {
        if (!this.isRefMode()) {
            return null;
        }
        if (this.refPSJsonNodeSchema == null) {
            IPSJsonDefs iPSJsonDefs = this.getPSJsonDefs(this.getPSJsonNodeOwner());
            if (iPSJsonDefs == null) {
                throw new Exception(String.format("\u4e0a\u4e0b\u6587\u672a\u5b58\u5728Json\u9884\u5b9a\u4e49\u5bf9\u8c61", new Object[0]));
            }
            this.refPSJsonNodeSchema = (IPSJsonNodeSchema)iPSJsonDefs.getItem(this.getRefSchemaId(), false);
        }
        return this.refPSJsonNodeSchema;
    }

    protected void setRefPSJsonNodeSchema(IPSJsonNodeSchema refPSJsonNodeSchema) {
        this.refPSJsonNodeSchema = refPSJsonNodeSchema;
    }

    protected IPSJsonDefs getPSJsonDefs(IPSJsonNodeOwner iPSJsonNodeOwner) {
        if (iPSJsonNodeOwner == null) {
            return null;
        }
        if (iPSJsonNodeOwner instanceof IPSJsonDefs) {
            return (IPSJsonDefs)iPSJsonNodeOwner;
        }
        if (iPSJsonNodeOwner instanceof IPSJsonDefsOwner) {
            return ((IPSJsonDefsOwner)((Object)iPSJsonNodeOwner)).getPSJsonDefs();
        }
        if (iPSJsonNodeOwner instanceof IPSJsonNode) {
            return this.getPSJsonDefs(((IPSJsonNode)iPSJsonNodeOwner).getPSJsonNodeOwner());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u578b\u6a21\u5f0f")
    public boolean isRefMode() {
        return !StringHelper.isNullOrEmpty((String)this.getRefSchemaId());
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u578b\u6807\u8bc6")
    public String getRefSchemaId() {
        return this.strRefSchemaId;
    }

    protected void setRefSchemaId(String strRefSchemaId) {
        this.strRefSchemaId = strRefSchemaId;
    }

    @Override
    public String getModelType() {
        return "PSJSONNODESCHEMA$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSJsonNodeOwner().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSJsonNodeOwner().getModelId(), (Object)this.getName());
    }
}

