/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemContainer;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSlnPrd;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSlnPrd
extends IPSObject,
IPSSystemContainer {
    public void init(ISRFDAGlobalHelper var1, PSDepSlnPrd var2) throws Exception;

    public String getPSSystemId();

    public IPSSystem getPSSystem() throws Exception;

    public IPSSystem getPSSystem(boolean var1) throws Exception;

    @Override
    public String getPSSysModelInstId();

    public IPSSystem reloadPSSystem(int var1) throws Exception;

    public boolean isEnableDynamicMode();

    public long getLastActiveTime();
}

