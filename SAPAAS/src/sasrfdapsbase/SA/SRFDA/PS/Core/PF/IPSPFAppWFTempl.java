/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFStyleObject;
import SA.SRFDA.PS.Core.Pub.IPSPFAppWFCodePublisher;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFAppWFTempl
extends IPSPFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSPFStyle2 var2, IPSPFPubCode2 var3, PSPFAppTempl var4) throws Exception;

    public PSPFAppTempl getPSPFAppTemplData();

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFAppWFCodePublisher getPSPFAppWFCodePublisher() throws Exception;

    public void releasePSPFAppWFCodePublisher(IPSPFAppWFCodePublisher var1);

    public void resetPSPFAppWFCodePublishers();

    public String getFileName();

    public String getFilePath();

    public String getTemplFilePath();

    public String getTemplDocUrl();
}

