/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSysRefDE;
import SA.SRFDA.PS.Data.PSSysRefDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public class PSSysRefDEImpl
extends PSObjectImpl
implements IPSSysRefDE {
    protected IPSSysRef iPSSysRef = null;
    protected PSSysRefDE psSysRefDE = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysRef iPSSysRef, PSSysRefDE psSysRefDE) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSysRefDE = psSysRefDE;
        this.iPSSysRef = iPSSysRef;
        this.setId(this.psSysRefDE.getPSSYSREFDEID());
        this.setName(this.psSysRefDE.getPSSYSREFDENAME());
        this.setPSObjectData(this.psSysRefDE);
        this.onInit();
    }

    @Override
    public String getServiceCls() {
        return this.psSysRefDE.getSERVICECLS();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysRef.getPSSysModelInstId();
    }
}

