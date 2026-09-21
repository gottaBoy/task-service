/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.UpdatePanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSUpdatePanelParam
extends IPSControlParam {
    @Override
    public String getPSDEId();

    public String getPSSysMsgTemplId();

    public String getPSDEActionId();

    public Integer getTimer();
}

