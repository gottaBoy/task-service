/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Data.PSViewLogicType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSViewLogicType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSViewLogicType var2) throws Exception;

    public IPSViewLogic createPSViewLogic() throws Exception;

    public String getProcessName();
}

