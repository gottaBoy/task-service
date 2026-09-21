/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.ctrlmodel.form.DynaFormGroupModelBase;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormPageModel;

public class DynaFormPageModel
extends DynaFormGroupModelBase
implements IDynaFormPageModel {
    @Override
    public String getDetailType() {
        return "FORMPAGE";
    }
}

