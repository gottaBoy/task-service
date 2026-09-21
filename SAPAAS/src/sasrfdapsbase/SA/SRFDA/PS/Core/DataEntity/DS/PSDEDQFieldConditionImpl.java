/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQFieldCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQConditionImpl;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class PSDEDQFieldConditionImpl
extends PSDEDQConditionImpl
implements IPSDEDQFieldCondition {
    private String strVARTypeParam = "";
    private boolean bIgnoreEmpty = false;
    private boolean bIgnoreOthers = false;
    private IPSDEField iPSDEField = null;
    private IPSSysDBValueFunc iPSSysDBValueFunc = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEDataQueryCond.isIGNOREEMPTYNull()) {
            if ((this.psDEDataQueryCond.getIGNOREEMPTY() & 1) == 1) {
                this.bIgnoreEmpty = true;
            }
            if ((this.psDEDataQueryCond.getIGNOREEMPTY() & 2) == 2) {
                this.bIgnoreOthers = true;
            }
        }
        super.onInit();
        JSONObject jo = this.prepareVARTypeParam();
        this.strVARTypeParam = jo.toString();
        if (!StringHelper.isNullOrEmpty((String)this.getPSSysDBVFId())) {
            this.iPSSysDBValueFunc = this.getPSDEDQJoin().getPSDEDataQuery().getPSDataEntity().getPSSystem().getPSSysDBValueFunc(this.getPSSysDBVFId());
        }
    }

    protected JSONObject prepareVARTypeParam() throws Exception {
        JSONObject jo = new JSONObject();
        if (this.getPSDEDQJoin().getJoinPSDataEntity() != null) {
            jo.put("dename", (Object)this.getPSDEDQJoin().getJoinPSDataEntity().getName());
            if (!StringHelper.isNullOrEmpty((String)this.getPSDEFId())) {
                this.iPSDEField = this.getPSDEDQJoin().getJoinPSDataEntity().getPSDEField(this.getPSDEFId(), true);
                if (this.iPSDEField != null) {
                    jo.put("defname", (Object)this.iPSDEField.getName());
                }
            }
        }
        if (this.isIgnoreEmpty()) {
            jo.put("ignoreempty", true);
        }
        return jo;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5904\u7406", dump=false, fields={"PSSYSDBVFID"})
    public String getPSSysDBVFId() {
        return this.psDEDataQueryCond.getPSSYSDBVFID();
    }

    @Override
    public String getPSDBValueOPId() {
        return this.psDEDataQueryCond.getPSDBVALUEOPID();
    }

    @Override
    @PSModelRTMeta(description="\u53d8\u91cf\u7c7b\u578b", fields={"PSVARTYPEID"})
    public String getPSVARTypeId() {
        return this.psDEDataQueryCond.getPSVARTYPEID();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u503c", fields={"CONDVALUE"})
    public String getCondValue() {
        return this.psDEDataQueryCond.getCONDVALUE();
    }

    @Override
    public String getPSDEFId() {
        return this.psDEDataQueryCond.getPSDEFID();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u64cd\u4f5c", fields={"PSDBVALUEOPID"})
    public String getCondOp() {
        return this.getPSDBValueOPId();
    }

    @Override
    public String getVARTypeParam() {
        return this.strVARTypeParam;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u7a7a\u503c", ignoredumpvalues="false", fields={"IGNOREEMPTY"})
    public boolean isIgnoreEmpty() {
        return this.bIgnoreEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5916\u90e8\u53c2\u6570", ignoredumpvalues="false")
    public boolean isIgnoreOthers() {
        return this.bIgnoreOthers;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5bf9\u8c61", ignorepf=true, dumpref=true, from="IPSDEDQJoin", from_method="getJoinPSDataEntityMust().getPSDEField", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u540d\u79f0", doc="\u6765\u6e90{@link #getPSDEField}.getName()")
    public String getFieldName() {
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u51fd\u6570\u6807\u8bb0")
    public String getValueFuncTag() {
        if (this.iPSSysDBValueFunc != null) {
            return this.iPSSysDBValueFunc.getValueFuncTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u51fd\u6570\u6807\u8bb02")
    public String getValueFuncTag2() {
        if (this.iPSSysDBValueFunc != null) {
            return this.iPSSysDBValueFunc.getValueFuncTag2();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u51fd\u6570\u4ee3\u7801\u6807\u8bc6")
    public String getValueFunc() {
        if (this.iPSSysDBValueFunc != null) {
            return this.iPSSysDBValueFunc.getCodeName();
        }
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (PSObjectImpl.getDynaModelPubIgnorePFReal()) {
            objectNode.remove("getPSDEField");
        }
    }
}

