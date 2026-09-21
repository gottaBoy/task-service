/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSModelInitStep;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSModelInitStep
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSModelInit var2, PSModelInitStep var3) throws Exception;

    public String getInitDEId();

    public String getInitAction();
}

