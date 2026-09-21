/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPFEditorTempl
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFStyle var3, PSPFEditorTempl var4) throws Exception;

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFEditorCodePublisher getPSPFEditorCodePublisher() throws Exception;

    public void releasePSPFEditorCodePublisher(IPSPFEditorCodePublisher var1);

    public PSPFEditorTempl getPSPFEditorTemplData();

    public IPSPFStyle getPSPFStyle();

    public String getTemplDocUrl();

    public void resetPSPFEditorCodePublishers();
}

