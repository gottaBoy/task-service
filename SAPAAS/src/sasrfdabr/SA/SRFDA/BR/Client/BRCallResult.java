/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Client;

import SA.SRFDA.BR.Client.BRParam;
import SA.SRFramework.DataEx.CallResult;

public class BRCallResult
extends CallResult {
    public BRParam getParam() {
        if (this.userObject != null && this.userObject instanceof BRParam) {
            return (BRParam)this.userObject;
        }
        return null;
    }
}

