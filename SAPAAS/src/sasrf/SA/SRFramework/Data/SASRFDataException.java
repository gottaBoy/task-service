/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.SASRFException;

public class SASRFDataException
extends SASRFException {
    public SASRFDataException(int nType) {
        super(nType);
    }

    @Override
    public String ErrorToMsg() {
        if (this.nExceptionType == 2000) {
            return "DB\u8c03\u7528\u8c03\u7528\u5668\u9519\u8bef\uff0c\u8bf7\u786e\u8ba4";
        }
        if (this.nExceptionType == 2001) {
            return "DB\u8c03\u7528\u914d\u7f6e\u6587\u4ef6\u9519\u8bef\uff0c\u8bf7\u786e\u8ba4";
        }
        if (this.nExceptionType == 2002) {
            return "\u6ca1\u6709\u627e\u5230\u6307\u5b9a\u6570\u636e\uff0c\u8bf7\u786e\u8ba4";
        }
        if (this.nExceptionType == 2003) {
            return "\u83b7\u53d6\u8fde\u63a5\u6c60\u9519\u8bef\uff0c\u8bf7\u786e\u8ba4";
        }
        return super.ErrorToMsg();
    }
}

