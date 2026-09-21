/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core.valuetranslator;

import net.ibizsys.paas.core.IValueTranslator;

public abstract class ValueTranslatorBase
implements IValueTranslator {
    private String strParam = "";

    public void setParam(String strParam) {
        this.strParam = strParam;
    }

    public String getParam() {
        return this.strParam;
    }
}

