/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.DP;

import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;

public interface IDPPlugin {
    public void BeforeRender(SRFExDPEx var1, SRFExForm var2);

    public void Render(SRFExDPEx var1, SRFExForm var2);
}

