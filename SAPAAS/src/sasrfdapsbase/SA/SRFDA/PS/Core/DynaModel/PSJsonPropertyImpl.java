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

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperty;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaHelper;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJsonPropertyImpl
extends PSJsonNodeImpl
implements IPSJsonProperty {
    private static final Log log = LogFactory.getLog(PSJsonPropertyImpl.class);
    private IPSJsonNodeSchema iPSJsonNodeSchema = null;

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
        String strType = null;
        if (this.getObjectNode().has("type")) {
            strType = this.getObjectNode().get("type").textValue();
        }
        this.setPSJsonNodeSchema(this.getPSJsonNodeSchema(strType, this.getName(), this.getObjectNode()));
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="Json\u503c\u7c7b\u578b")
    public IPSJsonNodeSchema getPSJsonNodeSchema() {
        return this.iPSJsonNodeSchema;
    }

    protected void setPSJsonNodeSchema(IPSJsonNodeSchema iPSJsonNodeSchema) {
        this.iPSJsonNodeSchema = iPSJsonNodeSchema;
    }

    protected IPSJsonNodeSchema getPSJsonNodeSchema(String strType, String strName, ObjectNode objData) throws Exception {
        return PSJsonNodeSchemaHelper.getInstance().getPSJsonNodeSchema(this, strType, strName, objData);
    }

    @Override
    public String getModelType() {
        return "PSJSONPROPERTY$" + this.getPSJsonNodeOwner().getModelType();
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

