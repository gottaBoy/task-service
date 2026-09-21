/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSException;

public class PSRecursionException
extends PSException {
    private static final long serialVersionUID = 1L;

    public PSRecursionException(int nErrorCode, String strErrorInfo) {
        super(nErrorCode, strErrorInfo);
    }
}

