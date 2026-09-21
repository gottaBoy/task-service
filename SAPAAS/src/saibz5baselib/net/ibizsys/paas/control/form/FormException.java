/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.form;

import net.ibizsys.paas.control.form.FormError;

public class FormException
extends Exception {
    private static final long serialVersionUID = 1L;
    private FormError formError = null;

    public FormException(FormError formError) {
        this.formError = formError;
    }

    public FormError getFormError() {
        return this.formError;
    }

    @Override
    public String getMessage() {
        if (this.formError != null) {
            return this.formError.toString();
        }
        return super.getMessage();
    }
}

