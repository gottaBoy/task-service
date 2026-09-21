/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Data.PSPFStylePrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFStylePrj
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPFStyle var2, PSPFStylePrj var3) throws Exception;

    public String getNameFormat();

    public boolean isReadOnlyMode();

    public String getPrjType();

    public String getProjectName(IPSApplication var1) throws Exception;

    public boolean isMavenPrj();
}

