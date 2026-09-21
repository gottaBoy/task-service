/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Issue;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysIssueEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSysIssueEngine
extends IPSObject {
    public static final int CHECKLEVEL_SYSTEM = 0;
    public static final int CHECKLEVEL_APPLICATION = 1;

    public void init(ISRFDAGlobalHelper var1, PSSysIssueEngine var2) throws Exception;

    public void checkPSSystem(IPSSystem var1) throws Exception;

    public int getCheckLevel();
}

