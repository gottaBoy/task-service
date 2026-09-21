/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIEngineParam;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u754c\u9762\u5f15\u64ce\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSUIEngine
extends IPSModelObject {
    public static final String ENGINETYPE_PFPLUGIN = "PFPLUGIN";

    public Iterator<? extends IPSUIEngineParam> getPSUIEngineParams();
}

