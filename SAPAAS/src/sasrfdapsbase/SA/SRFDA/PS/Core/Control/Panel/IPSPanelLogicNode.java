/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLink;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNodeParam;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPanelLogicNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSPanelLogicNode
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSPanelLogic var2, PSPanelLogicNode var3) throws Exception;

    public Iterator<IPSPanelLogicLink> getPSPanelLogicLinks();

    public Iterator<IPSPanelLogicNodeParam> getPSPanelLogicNodeParams();

    public String getLogicNodeType();

    public IPSPanelLogic getPSPanelLogic();

    public String getCodeName();

    public boolean isParallelOutput();

    public Object getParam(String var1, Object var2);
}

