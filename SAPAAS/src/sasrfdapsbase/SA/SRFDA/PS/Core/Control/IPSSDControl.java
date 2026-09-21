/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlNavContext;
import SA.SRFDA.PS.Core.Control.IPSControlNavParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5355\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSDControl
extends IPSControl {
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception;

    public boolean isReadOnly();

    public IPSControlAction getCreatePSControlAction();

    public IPSControlAction getUpdatePSControlAction();

    public IPSControlAction getRemovePSControlAction();

    public IPSControlAction getGetPSControlAction();

    public IPSControlAction getGetDraftPSControlAction();

    public IPSControlAction getGetDraftFromPSControlAction();

    public Iterator<IPSControlNavParam> getPSControlNavParams() throws Exception;

    public Iterator<IPSControlNavContext> getPSControlNavContexts() throws Exception;

    public boolean isActiveDataMode();

    public String getActiveDataField();
}

