/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.form;

import java.util.Iterator;
import net.ibizsys.paas.control.form.IFormItem;

public interface IFormItemEx
extends IFormItem {
    public Iterator<String> getItemNames();
}

