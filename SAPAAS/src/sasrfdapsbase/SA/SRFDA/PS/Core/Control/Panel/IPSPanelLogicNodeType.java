/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.PS.Data.PSPanelLogicNodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPanelLogicNodeType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSPanelLogicNodeType var2) throws Exception;

    public IPSPanelLogicNode createPSPanelLogicNode(PSPanelLogicNode var1) throws Exception;
}

