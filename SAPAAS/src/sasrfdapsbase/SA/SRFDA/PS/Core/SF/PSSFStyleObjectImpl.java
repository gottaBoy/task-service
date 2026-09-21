/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;

public abstract class PSSFStyleObjectImpl
extends PSSFObjectImpl {
    protected IPSSFStyle iPSSFStyle = null;

    public IPSSFStyle getPSSFStyle() {
        return this.iPSSFStyle;
    }

    protected void setPSSFStyle(IPSSFStyle iPSSFStyle) {
        this.iPSSFStyle = iPSSFStyle;
        if (this.iPSSFStyle != null) {
            this.setPSSF(this.iPSSFStyle.getPSSF());
        }
    }
}

