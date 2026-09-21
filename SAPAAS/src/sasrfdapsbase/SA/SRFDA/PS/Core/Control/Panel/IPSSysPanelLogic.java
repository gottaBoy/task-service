/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSSysPanelLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9762\u677f\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewPanelLogic")
public interface IPSSysPanelLogic
extends IPSPanelLogic {
    public void init(ISRFDAGlobalHelper var1, IPSSysPanel var2, PSSysPanelLogic var3) throws Exception;

    public IPSSysPanel getPSSysPanel();
}

