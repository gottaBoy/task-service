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

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFJoinCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFJoinProcessNode;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEDFJoinCondImpl
extends PSObjectImpl
implements IPSDEDFJoinCond {
    private static final Log log = LogFactory.getLog(PSDEDFJoinCondImpl.class);
    protected IPSDEDFJoinProcessNode iPSDEDFJoinProcessNode = null;
    protected ObjectNode objectNode = null;
    protected IPSDEDFJoinCond parentPSDEDFJoinCond = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDFJoinProcessNode iPSDEDFJoinProcessNode, IPSDEDFJoinCond parentPSDEDFJoinCond, ObjectNode objectNode) throws Exception {
        try {
            JsonNode nameNode;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDFJoinProcessNode = iPSDEDFJoinProcessNode;
            this.parentPSDEDFJoinCond = parentPSDEDFJoinCond;
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
    public IPSDEDFJoinProcessNode getPSDEDFJoinProcessNode() {
        return this.iPSDEDFJoinProcessNode;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDFJoinProcessNode().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDFJOINCOND";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDFJoinProcessNode() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDFJoinProcessNode().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDFJoinProcessNode().getPSDEDataFlow().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

