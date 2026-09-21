/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View.Plugin;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPlugin;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.ArrayList;

@PSModelPFIgnoreMeta
public abstract class PSAppViewPluginBase
implements IPSAppViewPlugin {
    @Override
    public boolean preparePSAppViewRefs(IPSAppView iPSAppView) throws Exception {
        return false;
    }

    @Override
    public boolean preparePSAppViewLogics(IPSAppView iPSAppView) throws Exception {
        return false;
    }

    @Override
    public boolean fillRelatedPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        return false;
    }
}

