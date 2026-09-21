/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;

public interface IPSSysDBValueFunc
extends IPSSystemObject {
    public static final String DBVALUEFUNCTYPE_PS = "PS";
    public static final String DBVALUEFUNCTYPE_UX = "UX";

    public int getInputStdDataType();

    public int getOutputStdDataType();

    public String getDBValueFuncType();

    public String getCodeName();

    public String getOutputValueFormat();
}

