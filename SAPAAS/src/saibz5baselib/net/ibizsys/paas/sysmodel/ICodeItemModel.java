/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.Locale;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.IModelBase3;

public interface ICodeItemModel
extends ICodeItem,
IModelBase3 {
    public String getText(Locale var1);

    public String getRealText(Locale var1);
}

