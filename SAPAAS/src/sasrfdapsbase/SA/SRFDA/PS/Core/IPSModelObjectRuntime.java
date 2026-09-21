/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSModelObjectRuntime {
    public String info(String var1);

    public String warn(String var1);

    public String error(String var1);

    public String info(String var1, String var2);

    public String warn(String var1, String var2);

    public String error(String var1, String var2);

    public String info(String var1, String var2, Object var3);

    public String warn(String var1, String var2, Object var3);

    public String error(String var1, String var2, Object var3);

    public String command(String var1, String var2);
}

