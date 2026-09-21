/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEViewBase")
public interface IPSAppDEWFView
extends IPSAppDEView {
    public IPSDEWF getPSDEWF();

    public IPSWFVersion getPSWFVersion();

    public IPSWorkflow getPSWorkflow();

    public boolean isWFIAMode();

    public IPSAppWF getPSAppWF();

    public IPSAppWFVer getPSAppWFVer();
}

