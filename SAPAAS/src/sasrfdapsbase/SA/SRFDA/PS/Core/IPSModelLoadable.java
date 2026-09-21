/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSModelLoadable {
    public void load(int var1) throws Exception;

    public int getLoadingLevel();

    public int getLoadedLevel();
}

