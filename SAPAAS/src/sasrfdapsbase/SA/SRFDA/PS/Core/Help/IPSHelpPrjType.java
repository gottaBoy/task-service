/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSHelpPrj;
import SA.SRFDA.PS.Data.PSHelpPrjType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpPrjType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSHelpPrjType var2) throws Exception;

    public IPSHelpPrj createPSHelpPrj(PSHelpPrj var1) throws Exception;

    public IPSHelpPrjPublisher createPSHelpPrjPublisher() throws Exception;

    public IPSHelpPrjTempl getDefaultPSHelpPrjTempl();
}

