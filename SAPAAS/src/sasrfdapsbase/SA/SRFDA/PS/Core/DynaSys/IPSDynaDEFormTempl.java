/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDynaDEFormTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSDynaDETempl var2, PSDynaDEFormTempl var3) throws Exception;

    public IPSDynaDETempl getPSDynaDETempl();

    public String getPSDEFormId();
}

