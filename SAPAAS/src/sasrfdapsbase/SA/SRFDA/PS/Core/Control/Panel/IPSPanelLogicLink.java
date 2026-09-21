/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkGroupCond;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPanelLogicLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSPanelLogicLink
extends IPSObject {
    public static final String LINKTYPE_ROUTE = "ROUTE";
    public static final String LINKTYPE_CALLBACK = "CALLBACK";

    public void init(ISRFDAGlobalHelper var1, IPSPanelLogic var2, PSPanelLogicLink var3) throws Exception;

    public IPSPanelLogicLinkGroupCond getPSPanelLogicLinkGroupCond();

    public IPSPanelLogicNode getDstPSPanelLogicNode() throws Exception;

    public IPSPanelLogicNode getSrcPSPanelLogicNode() throws Exception;

    public IPSPanelLogic getPSPanelLogic();

    public Iterator<IPSPanelLogicLinkCond> getAllPSPanelLogicLinkConds();

    public String getLinkType();
}

