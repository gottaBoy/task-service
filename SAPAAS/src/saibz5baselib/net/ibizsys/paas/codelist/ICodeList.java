/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.codelist;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.ISystemObject;
import net.ibizsys.paas.web.IWebContext;

public interface ICodeList
extends ISystemObject,
ICodeItem {
    public static final String CLTYPE_STATIC = "STATIC";
    public static final String CLTYPE_DYNAMIC = "DYNAMIC";
    public static final String ORMODE_STRING = "STR";
    public static final String ORMODE_NUMBER = "NUM";

    public String getCodeListText(String var1, boolean var2) throws Exception;

    public String getCodeListText(String var1, boolean var2, Object var3, IWebContext var4) throws Exception;

    public String getCodeListType();

    public String getHandler();

    public boolean isUserScope();

    public String getOrMode();

    public String getValueSeparator();

    public String getTextSeparator();

    public String getEmptyText();

    public String getGlobalId();
}

