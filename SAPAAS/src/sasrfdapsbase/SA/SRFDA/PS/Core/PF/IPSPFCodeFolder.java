/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFCodeFolder
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, PSPFCodeFolder var3) throws Exception;

    public String getFolderName();

    public String getPrjType();

    public String getPrjFolder();
}

