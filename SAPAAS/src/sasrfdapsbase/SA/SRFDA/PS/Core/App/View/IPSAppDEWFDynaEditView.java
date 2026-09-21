/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFDynaActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFEditView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u7f16\u8f91\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEWFDYNAEDITVIEW"})
public interface IPSAppDEWFDynaEditView
extends IPSAppDEWFEditView,
IPSAppDEWFDynaActionView {
    @Override
    public Iterator<IPSWFVersion> getPSWFVersions();

    public Iterator<IPSWFProcess> getPSWFProcesses();

    public Iterator<IPSUIActionGroup> getPSUIActionGroups();
}

