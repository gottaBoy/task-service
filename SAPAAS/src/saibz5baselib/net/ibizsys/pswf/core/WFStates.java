/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

public class WFStates {
    public static final String TAG_NOTSTART = "WFNOTSTART";
    public static final String TAG_NOTFINISH = "WFNOTFINISH";
    public static final String TAG_FINISH = "WFFINISH";
    public static final String TAG_ERROR = "WFERROR";
    public static final String TAG_CANCEL = "WFCANCEL";
    public static final String TAG_CANCELMANUAL = "WFCANCELMANUAL";
    public static final String TAG_CANCELTIMEOUT = "WFCANCELTIMEOUT";
    public static final int NOTSTART = 0;
    public static final int NOTFINISH = 1;
    public static final int FINISH = 2;
    public static final int CANCEL = 3;
    public static final int CANCEL_MANUAL = 31;
    public static final int CANCEL_TIMEOUT = 32;
    public static final int ERROR = 4;

    public static String toString(int nValue) {
        switch (nValue) {
            case 0: {
                return TAG_NOTSTART;
            }
            case 1: {
                return TAG_NOTFINISH;
            }
            case 2: {
                return TAG_FINISH;
            }
            case 3: {
                return TAG_CANCEL;
            }
            case 31: {
                return TAG_CANCELMANUAL;
            }
            case 32: {
                return TAG_CANCELTIMEOUT;
            }
            case 4: {
                return TAG_ERROR;
            }
        }
        return TAG_NOTSTART;
    }
}

