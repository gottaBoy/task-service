/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.FormBuilder;
import SA.SRFramework.Web.SRFImgButton;
import SA.SRFramework.Web.UI.SearchFormConfig;

public abstract class SearchFormBuilder
extends FormBuilder {
    protected SearchFormConfig curSearchFormConfig = null;
    protected int searchFormShowView = 1;
    protected boolean bShowSearchForm = true;

    public void setShowView(int value) {
        this.searchFormShowView = value;
    }

    public void setSFConfig(SearchFormConfig value) {
        this.curSearchFormConfig = value;
    }

    public void setShowSearchForm(boolean value) {
        this.bShowSearchForm = value;
    }

    public SRFImgButton GetSearchButton(String strButtonId, int searchFormMode) {
        return null;
    }
}

