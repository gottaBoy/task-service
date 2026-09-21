/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Locale;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public class Errors {
    public static final int OK = 0;
    public static final int INTERNALERROR = 1;
    public static final int ACCESSDENY = 2;
    public static final int INVALIDDATA = 3;
    public static final int INVALIDDATAKEYS = 4;
    public static final int INPUTERROR = 5;
    public static final int DUPLICATEKEY = 6;
    public static final int DUPLICATEDATA = 7;
    public static final int DELETEREJECT = 8;
    public static final int LOGICERROR = 9;
    public static final int DATANOTMATCH = 10;
    public static final int USERCONFIRM = 19;
    public static final int NOTIMPL = 20;
    public static final int USERERROR = 1000;

    public static final boolean isUserError(int nErrorCode) {
        return nErrorCode >= 1000;
    }

    public static final String getErrorInfo(int nErrorCode) {
        if (Errors.isUserError(nErrorCode)) {
            return "\u4e0d\u660e\u7684\u7528\u6237\u81ea\u5b9a\u4e49\u9519\u8bef";
        }
        switch (nErrorCode) {
            case 1: {
                return "\u7cfb\u7edf\u5185\u90e8\u53d1\u751f\u9519\u8bef";
            }
            case 2: {
                return "\u8bbf\u95ee\u88ab\u62d2\u7edd\uff0c\u53ef\u80fd\u7531\u4e8e\u6743\u9650\u539f\u56e0\u5bfc\u81f4";
            }
            case 3: {
                return "\u6570\u636e\u4e0d\u5b58\u5728";
            }
            case 4: {
                return "\u6570\u636e\u7684\u7d22\u5f15\u6761\u4ef6\u6709\u8bef\u6216\u4e0d\u8db3";
            }
            case 5: {
                return "\u6570\u636e\u7684\u4fe1\u606f\u6709\u8bef\u6216\u4e0d\u8db3";
            }
            case 6: {
                return "\u91cd\u590d\u7684\u6570\u636e\u952e";
            }
            case 7: {
                return "\u91cd\u590d\u7684\u6570\u636e";
            }
            case 8: {
                return "\u5220\u9664\u62d2\u7edd\uff0c\u53ef\u80fd\u7531\u4e8e\u6743\u9650\u539f\u56e0\u5bfc\u81f4";
            }
            case 9: {
                return "\u903b\u8f91\u5904\u7406\u9519\u8bef";
            }
            case 10: {
                return "\u6570\u636e\u4e0d\u4e00\u81f4\uff0c\u53ef\u80fd\u540e\u53f0\u6570\u636e\u5df2\u7ecf\u88ab\u4fee\u6539";
            }
            case 19: {
                return "\u9700\u8981\u7528\u6237\u8fdb\u884c\u786e\u8ba4";
            }
            case 20: {
                return "\u6ca1\u6709\u5b9e\u73b0\u6307\u5b9a\u529f\u80fd";
            }
        }
        return "\u4e0d\u660e\u9519\u8bef";
    }

    public static final String getErrorInfo(int nErrorCode, Locale local) {
        if (WebContext.getCurrent() == null) {
            return Errors.getErrorInfo(nErrorCode);
        }
        IWebContext iWebContext = WebContext.getCurrent();
        if (local == null) {
            local = iWebContext.getLocale();
        }
        if (local == null) {
            return Errors.getErrorInfo(nErrorCode);
        }
        if (Errors.isUserError(nErrorCode)) {
            return iWebContext.getLocalization("ERROR.STD.SYS.UNKNOWNUSERERROR", "\u4e0d\u660e\u7684\u7528\u6237\u81ea\u5b9a\u4e49\u9519\u8bef", local);
        }
        switch (nErrorCode) {
            case 1: {
                return iWebContext.getLocalization("ERROR.STD.SYS.INTERNALERROR", "\u7cfb\u7edf\u5185\u90e8\u53d1\u751f\u9519\u8bef", local);
            }
            case 2: {
                return iWebContext.getLocalization("ERROR.STD.SYS.ACCESSDENY", "\u8bbf\u95ee\u88ab\u62d2\u7edd\uff0c\u53ef\u80fd\u7531\u4e8e\u6743\u9650\u539f\u56e0\u5bfc\u81f4", local);
            }
            case 3: {
                return iWebContext.getLocalization("ERROR.STD.SYS.INVALIDDATA", "\u6570\u636e\u4e0d\u5b58\u5728", local);
            }
            case 4: {
                return iWebContext.getLocalization("ERROR.STD.SYS.INVALIDDATAKEYS", "\u6570\u636e\u7684\u7d22\u5f15\u6761\u4ef6\u6709\u8bef\u6216\u4e0d\u8db3", local);
            }
            case 5: {
                return iWebContext.getLocalization("ERROR.STD.SYS.INPUTERROR", "\u6570\u636e\u7684\u4fe1\u606f\u6709\u8bef\u6216\u4e0d\u8db3", local);
            }
            case 6: {
                return iWebContext.getLocalization("ERROR.STD.SYS.DUPLICATEKEY", "\u91cd\u590d\u7684\u6570\u636e\u952e", local);
            }
            case 7: {
                return iWebContext.getLocalization("ERROR.STD.SYS.DUPLICATEDATA", "\u91cd\u590d\u7684\u6570\u636e", local);
            }
            case 8: {
                return iWebContext.getLocalization("ERROR.STD.SYS.DELETEREJECT", "\u5220\u9664\u62d2\u7edd\uff0c\u53ef\u80fd\u7531\u4e8e\u6743\u9650\u539f\u56e0\u5bfc\u81f4", local);
            }
            case 9: {
                return iWebContext.getLocalization("ERROR.STD.SYS.LOGICERROR", "\u903b\u8f91\u5904\u7406\u9519\u8bef", local);
            }
            case 10: {
                return iWebContext.getLocalization("ERROR.STD.SYS.DATANOTMATCH", "\u6570\u636e\u4e0d\u4e00\u81f4\uff0c\u53ef\u80fd\u540e\u53f0\u6570\u636e\u5df2\u7ecf\u88ab\u4fee\u6539", local);
            }
            case 19: {
                return iWebContext.getLocalization("ERROR.STD.SYS.USERCONFIRM", "\u9700\u8981\u7528\u6237\u786e\u8ba4", local);
            }
            case 20: {
                return iWebContext.getLocalization("ERROR.STD.SYS.NOTIMPL", "\u6ca1\u6709\u5b9e\u73b0\u6307\u5b9a\u529f\u80fd", local);
            }
        }
        return iWebContext.getLocalization("ERROR.STD.SYS.UNKNOWNERROR", "\u4e0d\u660e\u9519\u8bef", local);
    }

    public static final boolean isSpecialError(int nErrorCode, int nSpecialError) {
        return nErrorCode == nSpecialError || nErrorCode == nSpecialError + 1000;
    }
}

