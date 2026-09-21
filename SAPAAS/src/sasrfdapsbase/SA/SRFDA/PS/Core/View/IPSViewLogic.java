/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.View.IPSViewLogicParam;
import java.util.Iterator;

public interface IPSViewLogic
extends IPSModelObject {
    public static final String LOGICTYPE_PREDEFINED = "PREDEFINED";
    public static final String LOGICTYPE_DEUILOGIC = "DEUILOGIC";
    public static final String LOGICTYPE_PFPLUGIN = "PFPLUGIN";
    public static final String LOGICTYPE_UNKNOWN = "UNKNOWN";

    public String getLogicType();

    public String getViewLogicType();

    public String getViewLogicStyle();

    public Iterator<? extends IPSViewLogicParam> getPSViewLogicParams();

    public Iterator<? extends IPSViewLogicParam> getPSViewLogicParams(String var1);
}

