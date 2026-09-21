/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTabPage;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRTab;
import java.util.Iterator;

public interface IPSDEDRTab
extends IPSDRTab,
IPSDEDRCtrl {
    public Iterator<IPSDEDRTabPage> getPSDEDRTabPages();
}

