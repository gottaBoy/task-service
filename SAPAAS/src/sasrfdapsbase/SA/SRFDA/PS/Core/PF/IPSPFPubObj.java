/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.Pub.IPSPubObj;
import SA.SRFDA.PS.Data.PSPFPubObj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFPubObj
extends IPSPFObject,
IPSPubObj {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, PSPFPubObj var3) throws Exception;

    @Override
    public String getTarget();

    public String getPubObj();

    public String getTag();

    public String getTag2();

    public String replaceMacros(String var1) throws Exception;

    public String getTargetType();
}

