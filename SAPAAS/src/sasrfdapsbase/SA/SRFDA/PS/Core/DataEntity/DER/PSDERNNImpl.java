/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public class PSDERNNImpl
extends PSDataEntityObjectImpl
implements IPSDERNN {
    private IPSDER1NBase[] list = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDER1NBase[] list) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDataEntity(iPSDataEntity);
        this.setId(iPSDataEntity.getId());
        this.setName(iPSDataEntity.getName());
        this.list = list;
    }

    public PSDERNNImpl() {
    }

    public PSDERNNImpl(IPSDER1NBase[] list) {
        this.list = list;
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb1")
    public IPSDER1N getFirstPSDER1N() {
        if (this.getFirstPSDER() instanceof IPSDER1N) {
            return (IPSDER1N)this.getFirstPSDER();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb2")
    public IPSDER1N getSecondPSDER1N() {
        if (this.getSecondPSDER() instanceof IPSDER1N) {
            return (IPSDER1N)this.getSecondPSDER();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb1")
    public IPSDER1NBase getFirstPSDER() {
        return this.list[0];
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb2")
    public IPSDER1NBase getSecondPSDER() {
        return this.list[1];
    }

    @Override
    public String getModelType() {
        return "PSDERNN";
    }

    @Override
    public String getModelId() {
        return super.getModelId();
    }
}

