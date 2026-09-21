/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPanelDetailType;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPanelDetailType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSPanelDetailType var2) throws Exception;

    public IPSSysPanelItem createPSSysPanelItem(PSSysPanelItem var1) throws Exception;

    public boolean isRootPIType();

    public boolean isSupportPPIType(String var1);
}

