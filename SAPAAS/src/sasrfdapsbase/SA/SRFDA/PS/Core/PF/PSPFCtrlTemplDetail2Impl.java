/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetailImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisher2Impl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class PSPFCtrlTemplDetail2Impl
extends PSPFCtrlTemplDetailImpl {
    @Override
    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception {
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = null;
        if (StringHelper.IsNullOrEmpty((String)this.psPFCtrlTemplDetail.getPUBOBJ())) {
            if (this.getPSPFCtrlTempl().getPSPFStyle() != null && this.getPSPFCtrlTempl().getPSPFStyle().getPFEngineVer() < 20) {
                return this.getPSPF().createPSPFCtrlPartCodePublisher();
            }
            return new PSPFCtrlPartCodePublisher2Impl();
        }
        iPSPFCtrlPartCodePublisher = (IPSPFCtrlPartCodePublisher)ObjectHelper.Create((String)this.psPFCtrlTemplDetail.getPUBOBJ());
        return iPSPFCtrlPartCodePublisher;
    }
}

