/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.KPI.Client;

import SA.SRFDA.KPI.Client.KPIParam;
import SA.SRFramework.DataEx.CallResult;

public class KPICallResult
extends CallResult {
    public KPIParam getParam() {
        if (this.userObject != null && this.userObject instanceof KPIParam) {
            return (KPIParam)this.userObject;
        }
        return null;
    }
}

