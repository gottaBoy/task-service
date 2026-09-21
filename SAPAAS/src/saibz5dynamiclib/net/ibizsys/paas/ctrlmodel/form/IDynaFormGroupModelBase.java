/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel.form;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormItemModel;

public interface IDynaFormGroupModelBase
extends IDynaFormDetailModel {
    public Iterator<IDynaFormDetailModel> getItemModels();

    public void fillDynaFormItemModels(ArrayList<IDynaFormItemModel> var1) throws Exception;
}

