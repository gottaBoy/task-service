/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSSysDevBKTask;
import SA.SRFDA.PS.Data.PSSysDevBTType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysDevBTType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSSysDevBTType var2) throws Exception;

    public IPSSysDevBKTask createPSSysDevBKTask(PSSysDevBKTask var1) throws Exception;

    public boolean isUseRobot();
}

