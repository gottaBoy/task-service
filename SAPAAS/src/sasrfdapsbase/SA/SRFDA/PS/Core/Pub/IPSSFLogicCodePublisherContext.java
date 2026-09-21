/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSFCodePublisherContext;

public interface IPSSFLogicCodePublisherContext
extends IPSSFCodePublisherContext {
    public boolean hasPartCode(Object var1) throws Exception;

    public IPSGenerateCodeResult getPartCode(Object var1, String var2) throws Exception;
}

