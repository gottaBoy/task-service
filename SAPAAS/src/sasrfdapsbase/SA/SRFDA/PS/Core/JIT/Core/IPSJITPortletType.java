/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.JIT.Core;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSPortletType;

@PSModelIgnoreMeta
public interface IPSJITPortletType
extends IPSPortletType {
    public IPSJITCtrlModel createPSJITCtrlModel(IPSControl var1) throws Exception;

    public IPSJITCtrlHandler createPSJITCtrlHandler(IPSControl var1) throws Exception;
}

