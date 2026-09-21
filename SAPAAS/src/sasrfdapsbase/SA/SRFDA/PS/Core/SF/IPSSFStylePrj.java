/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Data.PSSFStylePrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFStylePrj
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFStyle var2, PSSFStylePrj var3) throws Exception;

    public String getNameFormat();

    public boolean isReadOnlyMode();

    public String getPrjType();

    public String getProjectName(IPSSysSFPub var1) throws Exception;

    public boolean isMavenPrj();
}

