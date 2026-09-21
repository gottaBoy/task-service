/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.IPSCodePublisherContext;

public abstract class PSCodePublisherContextBase
implements IPSCodePublisherContext {
    @Override
    public boolean exists(String strType) {
        return this.exists(strType, "", "");
    }

    @Override
    public boolean exists(String strType, String strParam) {
        return this.exists(strType, strParam, "");
    }

    @Override
    public abstract boolean exists(String var1, String var2, String var3);

    @Override
    public String get(String strParam) {
        return this.get(strParam, null);
    }

    @Override
    public abstract String get(String var1, String var2);
}

