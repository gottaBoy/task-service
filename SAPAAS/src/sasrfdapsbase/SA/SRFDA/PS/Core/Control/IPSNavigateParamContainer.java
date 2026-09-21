/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5bfc\u822a\u53c2\u6570\u5bb9\u5668\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSNavigateParamContainer {
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception;

    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception;
}

