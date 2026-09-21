/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroupDetail;

@PSModelPFIgnoreMeta
public interface IPSAppWFUIActionGroupDetail
extends IPSWFUIActionGroupDetail {
    public IPSAppWFUIActionGroup getPSAppWFUIActionGroup();
}

