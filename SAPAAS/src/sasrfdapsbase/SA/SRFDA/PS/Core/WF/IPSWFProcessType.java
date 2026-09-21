/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Data.PSWFProcess;
import SA.SRFDA.PS.Data.PSWFProcessType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSWFProcessType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSWFProcessType var2) throws Exception;

    public IPSWFProcess createPSWFProcess(PSWFProcess var1) throws Exception;
}

