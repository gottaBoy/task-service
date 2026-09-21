/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.Deploy.IPSMavenRepo;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSysRefMavenRepo
extends IPSMavenRepo {
    public void init(ISRFDAGlobalHelper var1, IPSSysRef var2, PSMavenRepo var3) throws Exception;

    public IPSSysRef getPSSysRef();
}

