/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFLogicPartCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Data.PSSFLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFLogicTemplDetail
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFLogicTempl2 var2, PSSFLogicTemplDetail var3) throws Exception;

    public IPSSFLogicTempl2 getPSSFLogicTempl();

    public IPSSFPubCode getPSSFPubCode() throws Exception;

    public IPSSFLogicPartCodePublisher getPSSFLogicPartCodePublisher() throws Exception;

    public void releasePSSFLogicPartCodePublisher(IPSSFLogicPartCodePublisher var1);

    public void resetPSSFLogicPartCodePublishers();

    public PSSFLogicTemplDetail getPSSFLogicTemplDetailData();

    public IPSSFLogicPartCodePublisher createPSSFLogicPartCodePublisher() throws Exception;

    public String getTemplDesc();

    public String getLogicName();

    public String getTemplDocUrl();
}

