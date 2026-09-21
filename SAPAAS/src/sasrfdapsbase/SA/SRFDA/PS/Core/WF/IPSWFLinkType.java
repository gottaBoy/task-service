/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSWFLinkType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSWFLinkType var2) throws Exception;

    public IPSWFLink createPSWFLink(PSWFLink var1) throws Exception;
}

