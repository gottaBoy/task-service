/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Data.PSHelpResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSHelpResource
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSHelpResource var3) throws Exception;

    public String getResourceType();

    public String getContent();

    public String getResourceSN();

    public String getTitle();

    @Override
    public String getCodeName();

    public String getResTag();

    public String getResTag2();
}

