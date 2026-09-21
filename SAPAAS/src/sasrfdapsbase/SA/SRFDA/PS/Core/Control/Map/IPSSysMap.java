/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.Control.Map.IPSMap;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapItem;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u5730\u56fe\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysMap")
public interface IPSSysMap
extends IPSMap {
    public static final String LEGENDPOS_NONE = "NONE";
    public static final String LEGENDPOS_TOP = "TOP";
    public static final String LEGENDPOS_BOTTOM = "BOTTOM";
    public static final String LEGENDPOS_LEFT = "LEFT";
    public static final String LEGENDPOS_RIGHT = "RIGHT";

    public Iterator<IPSSysMapItem> getPSSysMapItems();

    public IPSSysMapItem getPSSysMapItem(String var1) throws Exception;

    public String getLegendPos();

    public Iterator<? extends IPSSysMapLogic> getPSSysMapLogics();
}

