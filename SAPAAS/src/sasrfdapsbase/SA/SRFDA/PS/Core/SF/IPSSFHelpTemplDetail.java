/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFHelpPartCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Data.PSSFHelpTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFHelpTemplDetail
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFHelpTempl2 var2, PSSFHelpTemplDetail var3) throws Exception;

    public IPSSFHelpTempl2 getPSSFHelpTempl();

    public IPSSFPubCode getPSSFPubCode() throws Exception;

    public IPSSFHelpPartCodePublisher getPSSFHelpPartCodePublisher() throws Exception;

    public void releasePSSFHelpPartCodePublisher(IPSSFHelpPartCodePublisher var1);

    public void resetPSSFHelpPartCodePublishers();

    public PSSFHelpTemplDetail getPSSFHelpTemplDetailData();

    public IPSSFHelpPartCodePublisher createPSSFHelpPartCodePublisher() throws Exception;

    public String getTemplDesc();

    public String getTypeName();

    public String getTemplDocUrl();
}

