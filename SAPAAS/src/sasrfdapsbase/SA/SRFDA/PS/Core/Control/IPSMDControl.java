/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlNavContext;
import SA.SRFDA.PS.Core.Control.IPSControlNavParam;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u591a\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSMDControl
extends IPSControl {
    public static final int EDITMODE_ENABLE = 1;
    public static final int EDITMODE_NONEW = 128;

    public IPSControlAction getFetchPSControlAction();

    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception;

    public boolean isReadOnly();

    public IPSControlAction getCreatePSControlAction();

    public IPSControlAction getUpdatePSControlAction();

    public IPSControlAction getRemovePSControlAction();

    public IPSControlAction getGetPSControlAction();

    public IPSControlAction getGetDraftPSControlAction();

    public IPSControlAction getGetDraftFromPSControlAction();

    public IPSControlAction getMovePSControlAction();

    public IPSDEDataImport getPSDEDataImport() throws Exception;

    public IPSDEDataExport getPSDEDataExport() throws Exception;

    public boolean isBufferRenderer();

    public Iterator<IPSControlNavParam> getPSControlNavParams() throws Exception;

    public Iterator<IPSControlNavContext> getPSControlNavContexts() throws Exception;

    public boolean isActiveDataMode();

    public String getActiveDataField();
}

