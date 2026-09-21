/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u91cd\u5b9a\u5411\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppRedirectView
extends IPSAppView {
    public static final String VIEWREFMODE_RDITEM = "RDITEM";

    public Iterator<IPSAppView> getRedirectPSAppViews();

    public Iterator<String> getRedirectModes();

    public Iterator<String> getRefRedirectModes();

    public IPSAppView getRedirectPSAppView(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppViewRef> getRedirectPSAppViewRefs();
}

