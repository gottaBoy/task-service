/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFramework.Utility.StringHelper;

public class PSTemplLimitException
extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int nLimit = -1;

    public PSTemplLimitException(int nLimit, String strError) {
        super(strError == null ? StringHelper.Format((String)"\u6a21\u677f\u53d1\u5e03\u957f\u5ea6\u9650\u5236[%1$s]", (Object)nLimit) : strError);
        this.nLimit = nLimit;
    }

    public int getLimit() {
        return this.nLimit;
    }
}

