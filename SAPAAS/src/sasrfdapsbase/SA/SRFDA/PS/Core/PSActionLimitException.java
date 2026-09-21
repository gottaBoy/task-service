/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSException;

public class PSActionLimitException
extends PSException {
    private static final long serialVersionUID = 1L;
    private String strActionType = "";
    private int nLimit = -1;

    public PSActionLimitException(String strActionType, int nLimit, String strErrorInfo) {
        super(1010, strErrorInfo);
        this.strActionType = strActionType;
        this.nLimit = nLimit;
    }

    public String getActionType() {
        return this.strActionType;
    }

    public int getLimit() {
        return this.nLimit;
    }
}

