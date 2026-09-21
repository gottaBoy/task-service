/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEFilterParam2Logic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDEFilterParam2LogicImpl
extends PSDELogicNodeImpl
implements IPSDEFilterParam2Logic {
    private IPSDEDataSet iPSDEDataSet = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        IPSDEDataSet iPSDEDataSet = this.getDstPSDEDataSet();
        if (iPSDEDataSet == null) {
            throw new Exception("\u672a\u6307\u5b9a\u8fc7\u6ee4\u6570\u636e\u96c6\u6a21\u578b");
        }
        boolean bEmptyPSDEDataQuery = true;
        Iterator<IPSDEDataQuery> psDEDataQueries = iPSDEDataSet.getPSDEDataQueries();
        if (psDEDataQueries != null) {
            while (psDEDataQueries.hasNext()) {
                bEmptyPSDEDataQuery = false;
                IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                if (!iPSDEDataQuery.isCustomCode()) continue;
                throw new Exception(String.format("\u8fc7\u6ee4\u67e5\u8be2\u6a21\u578b[%1$s]\u4e0d\u6b63\u786e\uff0c\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49\u4ee3\u7801\u7684\u67e5\u8be2\u6a21\u578b", iPSDEDataQuery.getName()));
            }
        }
        if (bEmptyPSDEDataQuery) {
            throw new Exception("\u8fc7\u6ee4\u6570\u636e\u96c6\u6a21\u578b\u672a\u5305\u542b\u4efb\u4f55\u67e5\u8be2\u6a21\u578b");
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.iPSDEDataSet == null && this.getDstPSDataEntity() != null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATASETID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u6570\u636e\u96c6\u5bf9\u8c61");
            }
            this.iPSDEDataSet = this.getDstPSDataEntity().getPSDEDataSet(this.psDELogicNode.getDSTPSDEDATASETID());
        }
        return this.iPSDEDataSet;
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

