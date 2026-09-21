/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBDColumn
extends IPSModelObject {
    public static final String UNIONKEYVALUE_KEY1 = "KEY1";
    public static final String UNIONKEYVALUE_KEY2 = "KEY2";
    public static final String UNIONKEYVALUE_KEY3 = "KEY3";
    public static final String UNIONKEYVALUE_KEY4 = "KEY4";

    public String getPredefinedType();

    public int getStdDataType();

    public String getUnionKeyValue();
}

