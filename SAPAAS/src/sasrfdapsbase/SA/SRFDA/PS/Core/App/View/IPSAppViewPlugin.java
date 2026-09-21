/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.ArrayList;

@PSModelIgnoreMeta
public interface IPSAppViewPlugin {
    public boolean preparePSAppViewRefs(IPSAppView var1) throws Exception;

    public boolean preparePSAppViewLogics(IPSAppView var1) throws Exception;

    public boolean fillRelatedPSAppViews(IPSAppView var1, ArrayList<IPSAppView> var2) throws Exception;
}

