/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEDEDataQueryLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEDEDataQueryLogicImpl
extends PSDELogicNodeImpl
implements IPSDEDEDataQueryLogic {
    private IPSDEDataQuery iPSDEDataQuery = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSDEDataQuery();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
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
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
    }
}

