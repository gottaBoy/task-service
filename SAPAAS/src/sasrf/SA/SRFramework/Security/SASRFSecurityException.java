/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Security;

import SA.SRFramework.SASRFException;

public class SASRFSecurityException
extends SASRFException {
    public SASRFSecurityException(int nType) {
        super(nType);
    }

    @Override
    public String ErrorToMsg() {
        if (this.nExceptionType == 4002) {
            return "\u8bbf\u95ee\u6570\u636e\u88ab\u62d2\u7edd\uff0c\u8bf7\u786e\u8ba4";
        }
        if (this.nExceptionType == 4001) {
            return "\u8bbf\u95ee\u9875\u9762\u88ab\u62d2\u7edd\uff0c\u8bf7\u786e\u8ba4";
        }
        if (this.nExceptionType == 4000) {
            return "\u8bbf\u95ee\u7cfb\u7edf\u88ab\u62d2\u7edd\uff0c\u8bf7\u786e\u8ba4";
        }
        return super.ErrorToMsg();
    }
}

