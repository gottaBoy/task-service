/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.SRFExSearchPanelEx;
import java.io.Writer;

public abstract class SearchPanelExBuilder
extends BaseBuilder {
    public void Render(Writer writer, SRFExSearchPanelEx searchPanel) {
    }

    @Override
    public String getBuilderName() {
        return "SEARCHPANELEX";
    }
}

