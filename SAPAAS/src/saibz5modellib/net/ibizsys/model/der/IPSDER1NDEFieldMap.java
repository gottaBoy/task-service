/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.der;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERDEFieldMap;

public interface IPSDER1NDEFieldMap
extends IPSDERDEFieldMap {
    public static final String MAPTYPE_DIGEST = "DIGEST";
    public static final String MAPTYPE_SUM = "SUM";
    public static final String MAPTYPE_AVG = "AVG";
    public static final String MAPTYPE_MAX = "MAX";
    public static final String MAPTYPE_MIN = "MIN";
    public static final String MAPTYPE_COUNT = "COUNT";

    public String getMapType();

    public IPSDEField getMajorPSDEField() throws Exception;

    public IPSDEField getMinorPSDEField() throws Exception;

    public IPSDER1N getPSDER1N();

    public IPSDEDataQuery getMinorPSDEDataQuery() throws Exception;

    public String getMinorPSDEDataQueryId();
}

