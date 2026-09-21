/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSRobotWorkType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSRobotWorkType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSRobotWorkType var2) throws Exception;

    public int getEnergy();
}

