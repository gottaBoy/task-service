/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53Html\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEHTMLVIEW"})
public interface IPSAppDEHtmlView
extends IPSAppDEView {
    public static final String VIEWPARAM_UI_HTMLURL = "UI.HTMLURL";
    public static final String VIEWPARAM_UI_HTMLURLKEY = "UI.HTMLURLKEY";

    public String getHtmlUrl();

    public boolean isLoadDefault();
}

