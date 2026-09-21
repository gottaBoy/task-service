/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.Deploy.PSMavenRepoImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSysRefMavenRepo;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public class PSSysRefMavenRepoImpl
extends PSMavenRepoImpl
implements IPSSysRefMavenRepo {
    private IPSSysRef iPSSysRef = null;
    private PSMavenRepo psMavenRepo = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysRef iPSSysRef, PSMavenRepo psMavenRepo) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysRef = iPSSysRef;
        this.psMavenRepo = psMavenRepo;
        this.init(iDAGlobalHelper, psMavenRepo);
    }

    @Override
    public IPSSysRef getPSSysRef() {
        return this.iPSSysRef;
    }
}

