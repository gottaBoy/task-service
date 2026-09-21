/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSObjectRuntime {
    public ISRFDAGlobalHelper getDAGlobalHelper();

    public Object getRTAttribute(String var1);

    public void setRTAttribute(String var1, Object var2);
}

