/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;

public interface IPSSysCustomPortlet
extends IPSSysPortlet {
    @Override
    public IPSSysPFPlugin getPSSysPFPlugin();
}

