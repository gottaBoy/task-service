/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.SP;

import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import java.io.Writer;

public abstract class SPExBuilder
extends BaseBuilder {
    public void Render(Writer writer, SRFExSPEx searchPanel) {
    }

    @Override
    public String getBuilderName() {
        return "SPEX";
    }
}

