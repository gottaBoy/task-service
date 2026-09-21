/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFDBCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleObject;
import SA.SRFDA.PS.Data.PSSFDBTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFDBTempl
extends IPSSFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, IPSSFStyle var3, PSSFDBTempl var4) throws Exception;

    public IPSSFPubCode getPSSFPubCode() throws Exception;

    public IPSSFDBCodePublisher getPSSFDBCodePublisher() throws Exception;

    public void releasePSSFDBCodePublisher(IPSSFDBCodePublisher var1);

    public void resetPSSFDBCodePublishers();

    public PSSFDBTempl getPSSFDBTemplData();

    public String getTemplDocUrl();
}

