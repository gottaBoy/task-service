/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Data.PSSysPanelModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysPanelModel
extends IPSPanelModel {
    public void init(ISRFDAGlobalHelper var1, IPSSysPanel var2, PSSysPanelModel var3) throws Exception;

    public IPSSysPanel getPSSysPanel();
}

