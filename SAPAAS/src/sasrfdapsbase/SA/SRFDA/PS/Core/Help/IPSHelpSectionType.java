/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFDA.PS.Data.PSHelpSectionType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpSectionType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSHelpSectionType var2) throws Exception;

    public void initModel(IPSSystem var1, PSHelpSection var2) throws Exception;

    public IPSHelpSection createPSHelpSection(PSHelpSection var1) throws Exception;

    public IPSHelpSectionPublisher createPSHelpSectionPublisher() throws Exception;

    public IPSHelpSectionTempl getDefaultPSHelpSectionTempl();

    public boolean isOutputDir();
}

