/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u4ea4\u4e92\u64cd\u4f5c\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEWFDynaActionView
extends IPSAppDEWFActionView {
    public static final String CONTROL_WFFORM = "wfform";

    public Iterator<IPSWFVersion> getPSWFVersions();

    public Iterator<IPSWFLink> getPSWFLinks();
}

