/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFHelpCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleObject;
import SA.SRFDA.PS.Data.PSSFHelpTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFHelpTempl
extends IPSSFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, IPSSFStyle var3, PSSFHelpTempl var4) throws Exception;

    public IPSSFPubCode getPSSFPubCode() throws Exception;

    public IPSSFHelpCodePublisher getPSSFHelpCodePublisher() throws Exception;

    public void releasePSSFHelpCodePublisher(IPSSFHelpCodePublisher var1);

    public void resetPSSFHelpCodePublishers();

    public PSSFHelpTempl getPSSFHelpTemplData();

    public String getTemplDocUrl();
}

