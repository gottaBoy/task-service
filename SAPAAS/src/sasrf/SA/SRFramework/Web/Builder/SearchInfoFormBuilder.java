/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.FormBuilder;
import SA.SRFramework.Web.UI.SearchFormConfig;

public abstract class SearchInfoFormBuilder
extends FormBuilder {
    protected SearchFormConfig curSearchFormConfig = null;
    protected int searchFormShowView = 1;

    public void setShowView(int value) {
        this.searchFormShowView = value;
    }

    public void setSFConfig(SearchFormConfig value) {
        this.curSearchFormConfig = value;
    }
}

