/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.UIBuilder;

public class TipsBarBuilder
extends UIBuilder {
    protected String strMessage = "";

    public void setMessage(String value) {
        this.strMessage = value;
    }

    public String getMessage() {
        return this.strMessage;
    }
}

