/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEDEDataSetLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEDEDataSetLogicImpl
extends PSDELogicNodeImpl
implements IPSDEDEDataSetLogic {
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getDstPSDataEntity() != null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATASETID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u6570\u636e\u96c6\u5bf9\u8c61");
            }
            this.iPSDEDataSet = this.getDstPSDataEntity().getPSDEDataSet(this.psDELogicNode.getDSTPSDEDATASETID());
        }
        if (this.getDstPSAppDataEntity() != null) {
            this.iPSAppDEDataSet = this.getDstPSAppDataEntity().getPSAppDEDataSet(this.getDstPSDEDataSet(), true);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return super.getDstPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="__self__", from_method="getDstPSAppDataEntityMust().getPSAppDEDataSet")
    public IPSAppDEDataSet getDstPSAppDEDataSet() throws Exception {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
    }
}

