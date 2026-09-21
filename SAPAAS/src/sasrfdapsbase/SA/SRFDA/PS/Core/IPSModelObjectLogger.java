/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSModelObjectLogger {
    public void info(IPSModelObject var1, String var2);

    public void warn(IPSModelObject var1, String var2);

    public void error(IPSModelObject var1, String var2);

    public void info(IPSModelObject var1, String var2, String var3, Object var4);

    public void warn(IPSModelObject var1, String var2, String var3, Object var4);

    public void error(IPSModelObject var1, String var2, String var3, Object var4);
}

