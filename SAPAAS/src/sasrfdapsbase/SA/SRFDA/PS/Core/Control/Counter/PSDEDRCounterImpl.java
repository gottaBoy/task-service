/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSDEDRCounter;
import SA.SRFDA.PS.Core.Control.Counter.PSSysCounterImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSSysCounterItem;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEDRCounterImpl
extends PSSysCounterImpl
implements IPSDEDRCounter {
    private IPSDataEntity iPSDataEntity = null;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSDEID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba1\u6570\u5b9e\u4f53\u6807\u8bc6");
        }
        this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysCounter.getPSDEID());
        this.prepareCounterItems(this.iPSDataEntity);
        super.onInit();
    }

    protected void prepareCounterItems(IPSDataEntity iPSDataEntity) throws Exception {
        Iterator<IPSDER1N> psDER1Ns = iPSDataEntity.getPSDER1Ns(true);
        if (psDER1Ns != null) {
            while (psDER1Ns.hasNext()) {
                IPSDER1N iPSDER1N = psDER1Ns.next();
                if (iPSDER1N.getCountPSDER1NDEFieldMap() == null) continue;
                PSSysCounterItem psSysCounterItem = new PSSysCounterItem();
                psSysCounterItem.setPSSYSCOUNTERITEMID(KeyValueHelper.genUniqueId((String)this.getId(), (String)iPSDER1N.getCountPSDER1NDEFieldMap().getMajorPSDEField().getName()));
                psSysCounterItem.setPSSYSCOUNTERITEMNAME(iPSDER1N.getCountPSDER1NDEFieldMap().getMajorPSDEField().getName());
                psSysCounterItem.setLOGICNAME(iPSDER1N.getCountPSDER1NDEFieldMap().getMajorPSDEField().getLogicName());
                this.registerPSSysCounterItem(psSysCounterItem);
            }
        }
        if (iPSDataEntity.getInheritPSDataEntity() != null) {
            this.prepareCounterItems(iPSDataEntity.getInheritPSDataEntity());
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public int getExtendMode() {
        return 0;
    }
}

