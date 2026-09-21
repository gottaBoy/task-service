/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFDBPartCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFDBTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Data.PSSFDBTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFDBTemplDetail
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFDBTempl2 var2, PSSFDBTemplDetail var3) throws Exception;

    public IPSSFDBTempl2 getPSSFDBTempl();

    public IPSSFPubCode getPSSFPubCode() throws Exception;

    public IPSSFDBPartCodePublisher getPSSFDBPartCodePublisher() throws Exception;

    public void releasePSSFDBPartCodePublisher(IPSSFDBPartCodePublisher var1);

    public void resetPSSFDBPartCodePublishers();

    public PSSFDBTemplDetail getPSSFDBTemplDetailData();

    public IPSSFDBPartCodePublisher createPSSFDBPartCodePublisher() throws Exception;

    public String getTemplDesc();

    public String getDBName();

    public String getTemplDocUrl();
}

