/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.data;

import net.ibizsys.paas.data.IDataItemParam;

public interface IDataItem
extends IDataItemParam {
    public static final String KEYITEM = "srfkey";
    public static final String MAJORTEXTITEM = "srfmajortext";
    public static final String DATAACCACTIONITEM = "srfdataaccaction";
    public static final String DATATYPEITEM = "srfdatatype";
    public static final String WFSTEPITEM = "srfwfstep";
    public static final String WFVERITEM = "srfwfver";
    public static final String MSTAG = "srfmstag";

    public int getDataType();

    public IDataItemParam[] getDataItemParams();
}

