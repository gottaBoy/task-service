/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9762\u677f\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewPanelItem")
public interface IPSSysPanelItem
extends IPSPanelItem {
    public void init(ISRFDAGlobalHelper var1, IPSSysPanel var2, IPSSysPanelItem var3, PSSysPanelItem var4) throws Exception;

    public IPSSysPanelItem getParentPSSysPanelItem();

    public IPSSysPanel getPSSysPanel();
}

