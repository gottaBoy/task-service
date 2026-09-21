/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCodePublisherContext;

public interface IPSPFViewCodePublisherContext
extends IPSPFCodePublisherContext {
    public IPSGenerateCodeResult getCtrlCode(Object var1, String var2) throws Exception;

    public IPSGenerateCodeResult getCtrlCode(Object var1) throws Exception;

    public boolean hasCtrlCode(Object var1, String var2) throws Exception;

    public boolean hasCtrlCode(Object var1) throws Exception;
}

