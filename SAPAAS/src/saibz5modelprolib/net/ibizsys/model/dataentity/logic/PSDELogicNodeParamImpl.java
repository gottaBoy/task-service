/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNode
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNodeParam
 *  net.ibizsys.model.dataentity.logic.IPSDELogicParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeParam;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.model.entity.PSDELogicNodeParam;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeParamImpl
extends PSObjectImpl
implements IPSDELogicNodeParam {
    private static final Log log = LogFactory.getLog(PSDELogicNodeParamImpl.class);
    protected IPSDELogicNode iPSDELogicNode;
    protected PSDELogicNodeParam psDELogicNodeParam;
    protected String strDstFieldName = "";
    protected String strSrcFieldName = "";

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDELogicNode iPSDELogicNode, PSDELogicNodeParam psDELogicNodeParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDELogicNode = iPSDELogicNode;
            this.psDELogicNodeParam = psDELogicNodeParam;
            this.setId(this.psDELogicNodeParam.getPSDELNPARAMID());
            this.setName(this.psDELogicNodeParam.getPSDELNPARAMNAME());
            this.setPSObjectData(this.psDELogicNodeParam);
            this.strDstFieldName = this.psDELogicNodeParam.getCUSTOMDSTPARAM();
            if (StringHelper.isNullOrEmpty((String)this.strDstFieldName)) {
                this.strDstFieldName = this.psDELogicNodeParam.getDSTPSDEFNAME();
            }
            this.strSrcFieldName = this.psDELogicNodeParam.getCUSTOMSRCPARAM();
            if (StringHelper.isNullOrEmpty((String)this.strSrcFieldName)) {
                this.strSrcFieldName = this.psDELogicNodeParam.getSRCPSDEFNAME();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public IPSDELogicNode getPSDELogicNode() {
        return this.iPSDELogicNode;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u5904\u7406\u53c2\u6570\u7c7b\u578b", codelist="DELogicParamType")
    public String getLogicNodeParamType() {
        return this.psDELogicNodeParam.getPARAMTYPE();
    }

    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570", hideempty=true)
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getDSTPSDLPARAMID())) {
            return null;
        }
        return this.iPSDELogicNode.getPSDELogic().getPSDELogicParam(this.psDELogicNodeParam.getDSTPSDLPARAMID());
    }

    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getDstFieldName() throws Exception {
        return this.strDstFieldName;
    }

    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570", hideempty=true)
    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDELogicNodeParam.getSRCPSDLPARAMID())) {
            return null;
        }
        return this.iPSDELogicNode.getPSDELogic().getPSDELogicParam(this.psDELogicNodeParam.getSRCPSDLPARAMID());
    }

    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", hideempty2=true)
    public String getSrcFieldName() throws Exception {
        return this.strSrcFieldName;
    }

    @PSModelRTMeta(description="\u76f4\u63a5\u503c", hideempty=true)
    public String getSrcValue() {
        return this.psDELogicNodeParam.getSRCVALUE();
    }

    public String getDirectCode() {
        return "";
    }

    @PSModelRTMeta(description="\u6e90\u503c\u7c7b\u578b", codelist="DELogicParamValueType")
    public String getSrcValueType() {
        return this.psDELogicNodeParam.getSRCVALUETYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDELogicNode);
    }
}

