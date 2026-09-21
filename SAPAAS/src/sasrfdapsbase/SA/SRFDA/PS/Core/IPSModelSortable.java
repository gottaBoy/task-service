/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSModelSortable {
    public static final int DEFAULTORDERVALUE = 99999;
    public static final String DEFAULTORDERVALUE_STRING = "99999";

    public int getOrderValue();

    public String getCodeName();

    public String getName();
}

