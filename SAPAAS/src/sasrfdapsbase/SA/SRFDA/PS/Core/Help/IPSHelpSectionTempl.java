/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpSectionPublisher;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSHelpSectionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpSectionTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSHelpSectionTempl var2) throws Exception;

    public IPSHelpSectionPublisher getPSHelpSectionPublisher() throws Exception;

    public void releasePSHelpSectionPublisher(IPSHelpSectionPublisher var1);

    public PSHelpSectionTempl getPSHelpSectionTemplData();
}

