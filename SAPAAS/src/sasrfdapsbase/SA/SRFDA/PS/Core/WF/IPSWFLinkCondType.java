/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkCondType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSWFLinkCondType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSWFLinkCondType var2) throws Exception;

    public IPSWFLinkCond createPSWFLinkCond(PSWFLinkCond var1) throws Exception;
}

