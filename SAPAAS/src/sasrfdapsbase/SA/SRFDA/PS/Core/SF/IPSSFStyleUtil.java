/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;

@PSModelIgnoreMeta
public interface IPSSFStyleUtil {
    public ArrayList<PSSysSFCode> generateCode(IPSPublisherContext var1, IPSSysSFPub var2, String var3, IPSObject var4) throws Exception;
}

