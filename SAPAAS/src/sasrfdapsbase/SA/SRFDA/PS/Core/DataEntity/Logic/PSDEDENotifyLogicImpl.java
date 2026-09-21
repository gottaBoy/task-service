/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEDENotifyLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDEDENotifyLogicImpl
extends PSDELogicNodeImpl
implements IPSDEDENotifyLogic {
    private IPSDENotify iPSDENotify = null;

    @Override
    protected int onCheck() throws Exception {
        this.assertDstPSDELogicParam();
        return super.onCheck();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getDstPSDataEntity() != null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDENOTIFYID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u901a\u77e5\u5bf9\u8c61");
            }
            this.iPSDENotify = this.getDstPSDataEntity().getPSDENotify(this.psDELogicNode.getDSTPSDENOTIFYID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u901a\u77e5\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDENotify", fields={"DSTPSDENOTIFYID"})
    public IPSDENotify getDstPSDENotify() throws Exception {
        return this.iPSDENotify;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }
}

