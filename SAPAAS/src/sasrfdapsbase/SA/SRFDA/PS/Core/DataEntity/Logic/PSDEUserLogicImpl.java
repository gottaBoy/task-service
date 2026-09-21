/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUserLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDEUserLogicImpl
extends PSDELogicNodeImpl
implements IPSDEUserLogic {
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEDataQuery iPSDEDataQuery = null;
    private IPSDELogic iPSDELogic = null;

    @Override
    protected int onCheck() throws Exception {
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEAction", fields={"DSTPSDEACTIONID"})
    public IPSDEAction getDstPSDEAction() throws Exception {
        return super.getDstPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.iPSDEDataSet == null && !StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATASETID()) && this.getDstPSDataEntity() != null) {
            this.iPSDEDataSet = this.getDstPSDataEntity().getPSDEDataSet(this.psDELogicNode.getDSTPSDEDATASETID());
        }
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDELogic", fields={"DSTPSDELOGICID"})
    public IPSDELogic getDstPSDELogic() throws Exception {
        if (this.iPSDELogic == null && !StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDELOGICID()) && this.getDstPSDataEntity() != null) {
            this.iPSDELogic = this.getDstPSDataEntity().getPSDELogic(this.psDELogicNode.getDSTPSDELOGICID());
        }
        return this.iPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataQuery", fields={"DSTPSDEDATAQUERYID"})
    public IPSDEDataQuery getDstPSDEDataQuery() throws Exception {
        if (this.iPSDEDataQuery == null && !StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATAQUERYID()) && this.getDstPSDataEntity() != null) {
            this.iPSDEDataQuery = this.getDstPSDataEntity().getPSDEDataQuery(this.psDELogicNode.getDSTPSDEDATAQUERYID());
        }
        return this.iPSDEDataQuery;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65701", hideempty=true, fields={"PARAM1"})
    public String getParam1() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65702", hideempty=true, fields={"PARAM2"})
    public String getParam2() {
        return this.psDELogicNode.getPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65703", hideempty=true, fields={"PARAM3"})
    public String getParam3() {
        return this.psDELogicNode.getPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65704", hideempty=true, fields={"PARAM4"})
    public String getParam4() {
        return this.psDELogicNode.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65705", hideempty=true, fields={"PARAM5"})
    public String getParam5() {
        return this.psDELogicNode.getPARAM5();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65706", hideempty=true, fields={"PARAM6"})
    public String getParam6() {
        return this.psDELogicNode.getPARAM6();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65707", hideempty=true, fields={"PARAM7"})
    public Integer getParam7() {
        if (!this.psDELogicNode.isPARAM7Null()) {
            return this.psDELogicNode.GetParamIntValue("PARAM7", 0);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65708", hideempty=true, fields={"PARAM8"})
    public Integer getParam8() {
        if (!this.psDELogicNode.isPARAM8Null()) {
            return this.psDELogicNode.GetParamIntValue("PARAM8", 0);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65709", hideempty=true, fields={"PARAM9"})
    public Integer getParam9() {
        if (!this.psDELogicNode.isPARAM9Null()) {
            return this.psDELogicNode.GetParamIntValue("PARAM9", 0);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u657010", hideempty=true, fields={"PARAM10"})
    public Integer getParam10() {
        if (!this.psDELogicNode.isPARAM10Null()) {
            return this.psDELogicNode.GetParamIntValue("PARAM10", 0);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u657011", hideempty=true, fields={"PARAM11"})
    public String getParam11() {
        return this.psDELogicNode.getPARAM11();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u657012", hideempty=true, fields={"PARAM12"})
    public String getParam12() {
        return this.psDELogicNode.getPARAM12();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u657013", hideempty=true, fields={"PARAM13"})
    public String getParam13() {
        return this.psDELogicNode.getPARAM13();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u657014", hideempty=true, fields={"PARAM14"})
    public String getParam14() {
        return this.psDELogicNode.getPARAM14();
    }
}

