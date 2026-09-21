/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSCounter
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSCounter var2) throws Exception;

    public String getCounterType();

    public IPSCounterType getPSCounterType();

    public String getBaseClass(String var1) throws Exception;

    public String getCodeName();
}

