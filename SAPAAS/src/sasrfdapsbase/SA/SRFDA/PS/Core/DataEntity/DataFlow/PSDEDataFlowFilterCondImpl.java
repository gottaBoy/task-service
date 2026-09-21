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
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterCondContainer;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEDataFlowFilterCondImpl
extends PSObjectImpl
implements IPSDEDataFlowFilterCond {
    private static final Log log = LogFactory.getLog(PSDEDataFlowFilterCondImpl.class);
    protected IPSDEDataFlowFilterCondContainer iPSDEDataFlowFilterCondContainer = null;
    protected ObjectNode objectNode = null;
    protected IPSDEDataFlowFilterCond parentPSDEDataFlowFilterCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataFlowFilterCondContainer iPSDEDataFlowFilterCondContainer, IPSDEDataFlowFilterCond parentPSDEDataFlowFilterCond, ObjectNode objectNode) throws Exception {
        try {
            JsonNode nameNode;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataFlowFilterCondContainer = iPSDEDataFlowFilterCondContainer;
            this.parentPSDEDataFlowFilterCond = parentPSDEDataFlowFilterCond;
            this.objectNode = objectNode;
            JsonNode idNode = this.objectNode.get("id");
            if (idNode != null) {
                this.setId(idNode.textValue());
            }
            if ((nameNode = this.objectNode.get("name")) != null) {
                this.setName(nameNode.textValue());
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
    public IPSDEDataFlowFilterCondContainer getPSDEDataFlowFilterCondContainer() {
        return this.iPSDEDataFlowFilterCondContainer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataFlowFilterCondContainer().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDFFILTERCOND";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataFlowFilterCondContainer() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDataFlowFilterCondContainer().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataFlowFilterCondContainer().getPSSystem());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

