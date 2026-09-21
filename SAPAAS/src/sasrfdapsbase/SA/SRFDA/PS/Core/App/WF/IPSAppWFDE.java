/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.WF.IPSWFDE;

public interface IPSAppWFDE
extends IPSModelObject {
    public IPSAppWF getPSAppWF() throws Exception;

    public IPSAppDataEntity getPSAppDataEntity() throws Exception;

    public IPSWFDE getPSWFDE();

    public String getEntityWFState();

    public IPSAppDEField getWFStatePSAppDEField() throws Exception;
}

