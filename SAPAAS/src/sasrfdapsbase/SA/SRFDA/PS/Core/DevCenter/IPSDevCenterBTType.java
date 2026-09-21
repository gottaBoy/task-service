/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSDCBKType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDevCenterBTType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDCBKType var2) throws Exception;

    public IPSDevCenterBKTask createPSDevCenterBKTask(PSDCBKTask var1) throws Exception;

    public boolean isUseRobot();
}

