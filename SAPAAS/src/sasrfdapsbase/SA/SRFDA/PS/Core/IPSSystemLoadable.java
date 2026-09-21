/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSystemLoadable {
    public String getPSSystemId();

    public IPSSystem getPSSystem() throws Exception;

    public IPSSystem getPSSystem(boolean var1) throws Exception;

    public String getPSSysModelInstId();

    public IPSSystem reloadPSSystem(int var1) throws Exception;

    public IPSSystem reloadPSSystem(int var1, int var2) throws Exception;

    public int getModelInstVer();
}

