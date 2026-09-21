/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Client;

import SA.SRFramework.DataEx.CallResult;
import SRFWF.Client.WFParam;

public class WFCallResult
extends CallResult {
    protected String strRunInfo = "";

    public WFParam getParam() {
        if (this.userObject != null && this.userObject instanceof WFParam) {
            return (WFParam)this.userObject;
        }
        return null;
    }

    public String getRunInfo() {
        return this.strRunInfo;
    }

    public void setRunInfo(String strRunInfo) {
        this.strRunInfo = strRunInfo;
    }
}

