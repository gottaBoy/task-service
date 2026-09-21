/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Pub.Base.PSLogicMethod;
import SA.SRFDA.PS.Core.Pub.Base.PSLogicNodeMethod;
import SA.SRFDA.PS.Core.Pub.Base.PSPanelItemLogicMethod;
import SA.SRFDA.PS.Core.Pub.Base.PSTemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSCtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    private static PSLogicMethod psIonic4LogicMethod = new PSLogicMethod();
    private static PSLogicNodeMethod psIonic4LogicNodeMethod = new PSLogicNodeMethod();
    private static PSPanelItemLogicMethod psIonic4PanelItemLogicMethod = new PSPanelItemLogicMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        params.put("srfpanellogic", psIonic4LogicMethod);
        params.put("srflogicnode", psIonic4LogicNodeMethod);
        params.put("srfpanelitemlogic", psIonic4PanelItemLogicMethod);
        PSTemplHelper.fillParams(params);
    }
}

