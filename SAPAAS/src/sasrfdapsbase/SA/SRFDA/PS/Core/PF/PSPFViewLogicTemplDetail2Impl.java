/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.PSPFViewLogicTemplDetailImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPFViewLogicPartCodePublisher2Impl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class PSPFViewLogicTemplDetail2Impl
extends PSPFViewLogicTemplDetailImpl {
    @Override
    public IPSPFViewLogicPartCodePublisher createPSPFViewLogicPartCodePublisher() throws Exception {
        IPSPFViewLogicPartCodePublisher iPSPFViewLogicPartCodePublisher = null;
        if (StringHelper.IsNullOrEmpty((String)this.psPFViewLogicTemplDetail.getPUBOBJ())) {
            return new PSPFViewLogicPartCodePublisher2Impl();
        }
        iPSPFViewLogicPartCodePublisher = (IPSPFViewLogicPartCodePublisher)ObjectHelper.Create((String)this.psPFViewLogicTemplDetail.getPUBOBJ());
        return iPSPFViewLogicPartCodePublisher;
    }
}

