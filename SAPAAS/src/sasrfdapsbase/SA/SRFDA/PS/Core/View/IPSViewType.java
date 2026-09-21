/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.View.IPSViewTypeCtrl;
import SA.SRFDA.PS.Core.View.IPSViewTypeView;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSViewType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSViewType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSViewType var2) throws Exception;

    public IPSAppView createPSAppView(PSAppView var1) throws Exception;

    public String getViewDEId();

    public Iterator<IPSViewTypeView> getPSViewTypeViews();

    public Iterator<IPSViewTypeCtrl> getPSViewTypeCtrls();

    public boolean isDEViewType();

    public String getCodeName();

    public boolean isEmbeddedView();

    public String getTitle();
}

