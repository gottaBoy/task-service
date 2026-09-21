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
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIDEDataSetLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUIDEDataSetLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIDEDataSetLogic {
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

    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"DSTPSDEID"})
    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return super.getDstPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="__self__", from_method="getDstPSAppDataEntityMust().getPSAppDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSAppDEDataSet getDstPSAppDEDataSet() throws Exception {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"RETPSDLPARAMID"})
    public IPSDEUILogicParam getRetPSDEUILogicParam() throws Exception {
        return super.getRetPSDEUILogicParam();
    }
}

