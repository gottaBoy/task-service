/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFObject;

public abstract class PSSFObjectImpl
extends PSObjectImpl
implements IPSSFObject {
    protected IPSSF iPSSF = null;

    @Override
    public IPSSF getPSSF() {
        return this.iPSSF;
    }

    protected void setPSSF(IPSSF iPSSF) {
        this.iPSSF = iPSSF;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSSF() != null) {
            return this.getPSSF().getPSSysModelInstId();
        }
        return null;
    }
}

