/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSMQInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMQInst
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSMQInst var2) throws Exception;

    public String getMQType();

    public String getConnUrl();

    public String getUserName();

    public String getPassword();
}

