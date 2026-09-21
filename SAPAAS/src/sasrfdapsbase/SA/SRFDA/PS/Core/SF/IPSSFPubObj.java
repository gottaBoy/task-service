/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSPubObj;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Data.PSSFPubObj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFPubObj
extends IPSSFObject,
IPSPubObj {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, PSSFPubObj var3) throws Exception;

    @Override
    public String getTarget();

    public String getPubObj();

    public String getTag();

    public String getTag2();

    public String replaceMacros(String var1) throws Exception;

    public String getModelList();
}

