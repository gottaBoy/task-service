/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.UpdatePanel;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSUpdatePanel
extends IPSControl {
    public IPSSysMsgTempl getPSSysMsgTempl();

    public IPSDEAction getPSDEAction();

    public int getTimer();
}

