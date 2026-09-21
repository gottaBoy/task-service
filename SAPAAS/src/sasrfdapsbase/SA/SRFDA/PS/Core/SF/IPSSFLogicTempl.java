/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleObject;
import SA.SRFDA.PS.Data.PSSFLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFLogicTempl
extends IPSSFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, IPSSFStyle var3, PSSFLogicTempl var4) throws Exception;

    public IPSSFPubCode getPSSFPubCode() throws Exception;

    public IPSSFLogicCodePublisher getPSSFLogicCodePublisher() throws Exception;

    public void releasePSSFLogicCodePublisher(IPSSFLogicCodePublisher var1);

    public void resetPSSFLogicCodePublishers();

    public PSSFLogicTempl getPSSFLogicTemplData();

    public String getTemplDocUrl();
}

