/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFDA.PS.Data.PSCounterType;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSCounterType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSCounterType var2) throws Exception;

    public IPSCounter createPSCounter(PSCounter var1) throws Exception;

    public IPSSysCounter createPSSysCounter(PSSysCounter var1) throws Exception;

    public String getBaseClass(String var1) throws Exception;
}

