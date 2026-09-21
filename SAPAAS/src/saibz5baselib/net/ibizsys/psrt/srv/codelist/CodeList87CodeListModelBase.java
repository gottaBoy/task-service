/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="11d8d830d8c4a615d926b43ad2df1f70", name="\u65f6\u95f4\u7ef4\u5ea6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="YM", text="\u5e74\u3001\u6708", realtext="\u5e74\u3001\u6708"), @CodeItem(value="YMW", text="\u5e74\u3001\u6708\u3001\u5468", realtext="\u5e74\u3001\u6708\u3001\u5468"), @CodeItem(value="YMWD", text="\u5e74\u3001\u6708\u3001\u5468\u3001\u5929", realtext="\u5e74\u3001\u6708\u3001\u5468\u3001\u5929"), @CodeItem(value="YMWDH", text="\u5e74\u3001\u6708\u3001\u5468\u3001\u5929\u3001\u5c0f\u65f6", realtext="\u5e74\u3001\u6708\u3001\u5468\u3001\u5929\u3001\u5c0f\u65f6"), @CodeItem(value="YMD", text="\u5e74\u3001\u6708\u3001\u5929", realtext="\u5e74\u3001\u6708\u3001\u5929"), @CodeItem(value="YMDH", text="\u5e74\u3001\u6708\u3001\u5929\u3001\u5c0f\u65f6", realtext="\u5e74\u3001\u6708\u3001\u5929\u3001\u5c0f\u65f6"), @CodeItem(value="YW", text="\u5e74\u3001\u5468", realtext="\u5e74\u3001\u5468"), @CodeItem(value="YWD", text="\u5e74\u3001\u5468\u3001\u5929", realtext="\u5e74\u3001\u5468\u3001\u5929"), @CodeItem(value="YWDH", text="\u5e74\u3001\u5468\u3001\u5929\u3001\u5c0f\u65f6", realtext="\u5e74\u3001\u5468\u3001\u5929\u3001\u5c0f\u65f6")})
public abstract class CodeList87CodeListModelBase
extends StaticCodeListModelBase {
    public static final String YM = "YM";
    public static final String YMW = "YMW";
    public static final String YMWD = "YMWD";
    public static final String YMWDH = "YMWDH";
    public static final String YMD = "YMD";
    public static final String YMDH = "YMDH";
    public static final String YW = "YW";
    public static final String YWD = "YWD";
    public static final String YWDH = "YWDH";

    public CodeList87CodeListModelBase() {
        this.initAnnotation(CodeList87CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList87CodeListModel", this);
    }
}

