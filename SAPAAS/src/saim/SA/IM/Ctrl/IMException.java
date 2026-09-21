/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

public class IMException
extends Exception {
    private int nIMError = 0;

    public IMException(int nErrorCode) {
        this.nIMError = nErrorCode;
    }

    public IMException(int nErrorCode, String strInfo) {
        super(strInfo);
        this.nIMError = nErrorCode;
    }

    public int getErrorCode() {
        return this.nIMError;
    }
}

