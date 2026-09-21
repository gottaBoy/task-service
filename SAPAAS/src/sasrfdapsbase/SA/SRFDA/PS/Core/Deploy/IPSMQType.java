/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSMQInst;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSMQInst;
import SA.SRFDA.PS.Data.PSMQType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMQType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSMQType var2) throws Exception;

    public IPSMQInst createPSMQInst(PSMQInst var1) throws Exception;
}

