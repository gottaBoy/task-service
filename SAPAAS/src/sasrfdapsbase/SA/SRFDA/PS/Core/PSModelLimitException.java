/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSException;

public class PSModelLimitException
extends PSException {
    private static final long serialVersionUID = 1L;
    private String strModelType = "";
    private int nLimit = -1;

    public PSModelLimitException(String strModelType, int nLimit, String strErrorInfo) {
        super(1000, strErrorInfo);
        this.strModelType = strModelType;
        this.nLimit = nLimit;
    }

    public String getModelType() {
        return this.strModelType;
    }

    public int getLimit() {
        return this.nLimit;
    }
}

