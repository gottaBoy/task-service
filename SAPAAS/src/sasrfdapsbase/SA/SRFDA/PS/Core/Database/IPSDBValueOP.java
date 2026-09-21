/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Data.IPSValueOP;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDBValueOP;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDBValueOP
extends IPSValueOP {
    public void init(ISRFDAGlobalHelper var1, PSDBValueOP var2) throws Exception;

    @Override
    public String getCaption(boolean var1, String var2);

    @Override
    public String getSimpleName();
}

