/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysIssue;

@PSModelIgnoreMeta
public interface IPSControlContainerRuntime
extends IPSControlContainer {
    public void logPSControlIssue(IPSControl var1, PSSysIssue var2) throws Exception;
}

