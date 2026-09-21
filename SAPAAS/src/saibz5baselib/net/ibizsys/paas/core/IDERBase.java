/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase;

public interface IDERBase
extends IModelBase {
    public static final String DERTYPE_DER1N = "DER1N";
    public static final String DERTYPE_DER11 = "DER11";
    public static final String DERTYPE_DERINDEX = "DERINDEX";
    public static final String DERTYPE_DERINHERIT = "DERINHERIT";
    public static final String DERTYPE_DERMULINH = "DERMULINH";
    public static final String DERTYPE_DERCUSTOM = "DERCUSTOM";
    public static final int REMOVEACTIONTYPE_NONE = 0;
    public static final int REMOVEACTIONTYPE_DELETE = 1;
    public static final int REMOVEACTIONTYPE_RESET = 2;
    public static final int REMOVEACTIONTYPE_REJECT = 3;

    public String getDERType();

    public String getMajorDEId();

    public String getMinorDEId();

    public String getMajorDEName();

    public String getMinorDEName();
}

