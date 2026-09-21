/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.FormItemModel;
import net.ibizsys.paas.ctrlmodel.IFormItemExModel;

public class FormItemExModel
extends FormItemModel
implements IFormItemExModel {
    private ArrayList<String> itemNameList = null;

    @Override
    public Iterator<String> getItemNames() {
        if (this.itemNameList == null || this.itemNameList.size() == 0) {
            return null;
        }
        return this.itemNameList.iterator();
    }

    @Override
    public void registerItemName(String strItemName) {
        if (this.itemNameList == null) {
            this.itemNameList = new ArrayList();
        }
        this.itemNameList.add(strItemName);
    }
}

