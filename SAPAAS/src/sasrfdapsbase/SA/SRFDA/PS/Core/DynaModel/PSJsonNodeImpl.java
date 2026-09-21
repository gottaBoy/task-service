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

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNode;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSJsonNodeImpl
extends PSObjectImpl
implements IPSJsonNode {
    private static final Log log = LogFactory.getLog(PSJsonNodeImpl.class);
    private IPSJsonNodeOwner iPSJsonNodeOwner = null;
    private ObjectNode objectNode = null;
    private JsonNode jsonNode = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSJsonNodeOwner iPSJsonNodeOwner, String strName, JsonNode jsonNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSJsonNodeOwner(iPSJsonNodeOwner);
            this.setName(strName);
            this.setJsonNode(jsonNode);
            if (jsonNode instanceof ObjectNode) {
                this.setObjectNode((ObjectNode)jsonNode);
            }
            this.onInit();
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
    public IPSJsonNodeOwner getPSJsonNodeOwner() {
        return this.iPSJsonNodeOwner;
    }

    protected void setPSJsonNodeOwner(IPSJsonNodeOwner iPSJsonNodeOwner) {
        this.iPSJsonNodeOwner = iPSJsonNodeOwner;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public ObjectNode getObjectNode() {
        return this.objectNode;
    }

    protected void setObjectNode(ObjectNode objectNode) {
        this.objectNode = objectNode;
    }

    @Override
    public JsonNode getJsonNode() {
        return this.jsonNode;
    }

    protected void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSJsonNodeOwner().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSJsonNodeOwner().getModelId(), (Object)this.getName());
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSJsonNodeOwner().getPSSystem();
    }
}

