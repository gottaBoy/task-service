/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.DP.IDPPlugin
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 */
package SA.SRFDA.Ctrl.DP;

import SA.SRFramework.WebEx.DP.IDPPlugin;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;

public class SimpleDPPlugin
implements IDPPlugin {
    public void BeforeRender(SRFExDPEx dpEx, SRFExForm form) {
    }

    public void Render(SRFExDPEx dpEx, SRFExForm form) {
        dpEx.getPage().RegisterOnReadyScript(6, "alert('load!');");
    }
}

