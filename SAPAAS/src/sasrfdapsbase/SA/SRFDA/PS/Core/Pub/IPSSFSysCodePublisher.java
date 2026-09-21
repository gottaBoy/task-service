/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;

@PSModelIgnoreMeta
public interface IPSSFSysCodePublisher
extends IPSSFCodePublisher {
    public static final String PARAM_SYS = "sys";
    public static final String PARAM_ITEM = "item";
    public static final String PARAM_PUB = "pub";
    public static final String PARAM_DE = "de";
    public static final String PARAM_APP = "app";
    public static final String PARAM_API = "api";

    public void init(ISRFDAGlobalHelper var1, IPSSFCodeType var2) throws Exception;

    public void generateCode(IPSPublisherContext var1, IPSSysSFPub var2) throws Exception;

    public ArrayList<PSSysSFCode> generateCode(IPSPublisherContext var1, IPSSysSFPub var2, IPSObject var3) throws Exception;

    public String getCodePart(String var1, Object var2) throws Exception;

    public boolean hasCodePart(String var1) throws Exception;
}

