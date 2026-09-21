/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPrjPublisher;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSHelpPrjTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpPrjTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSHelpPrjTempl var2) throws Exception;

    public IPSHelpPrjPublisher getPSHelpPrjPublisher() throws Exception;

    public void releasePSHelpPrjPublisher(IPSHelpPrjPublisher var1);

    public PSHelpPrjTempl getPSHelpPrjTemplData();
}

