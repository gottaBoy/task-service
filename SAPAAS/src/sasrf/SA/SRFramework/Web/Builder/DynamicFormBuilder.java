/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.FormBuilder;
import SA.SRFramework.Web.UI.DynamicFormConfig;

public class DynamicFormBuilder
extends FormBuilder {
    protected DynamicFormConfig dynamicFormConfig = null;

    public void setDFConfig(DynamicFormConfig value) {
        this.dynamicFormConfig = value;
    }
}

