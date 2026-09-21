/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSysSFUserCode
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysSFPub var2, PSSysSFCode var3) throws Exception;

    public String getProjectType();

    public String getUserCode();

    public String getFilePath();

    public IPSSysSFPub getPSSysSFPub();
}

