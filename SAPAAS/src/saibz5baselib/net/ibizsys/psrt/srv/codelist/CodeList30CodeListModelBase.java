/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="f7c4604080f938281b8a473f8ce3ea59", name="\u8865\u5b57\u5e94\u7528\u573a\u5408\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="GG", text="\u516c\u5171", realtext="\u516c\u5171"), @CodeItem(value="SH", text="\u5ba1\u6838", realtext="\u5ba1\u6838", parentvalue="GG"), @CodeItem(value="PG", text="\u6d3e\u5de5", realtext="\u6d3e\u5de5", parentvalue="GG"), @CodeItem(value="SABTYY", text="SABTYY", realtext="SABTYY"), @CodeItem(value="RKDSH", text="\u5165\u5e93\u5355\u5ba1\u6838", realtext="\u5165\u5e93\u5355\u5ba1\u6838", parentvalue="SABTYY"), @CodeItem(value="CKDSH", text="\u51fa\u5e93\u5355\u5ba1\u6838", realtext="\u51fa\u5e93\u5355\u5ba1\u6838", parentvalue="SABTYY"), @CodeItem(value="BSDSH", text="\u62a5\u635f\u5355\u5ba1\u6838", realtext="\u62a5\u635f\u5355\u5ba1\u6838", parentvalue="SABTYY"), @CodeItem(value="SAOA", text="SAOA", realtext="SAOA"), @CodeItem(value="FW", text="\u53d1\u6587", realtext="\u53d1\u6587", parentvalue="SAOA"), @CodeItem(value="SW", text="\u6536\u6587", realtext="\u6536\u6587", parentvalue="SAOA")})
public abstract class CodeList30CodeListModelBase
extends StaticCodeListModelBase {
    public static final String GG = "GG";
    public static final String SH = "SH";
    public static final String PG = "PG";
    public static final String SABTYY = "SABTYY";
    public static final String RKDSH = "RKDSH";
    public static final String CKDSH = "CKDSH";
    public static final String BSDSH = "BSDSH";
    public static final String SAOA = "SAOA";
    public static final String FW = "FW";
    public static final String SW = "SW";

    public CodeList30CodeListModelBase() {
        this.initAnnotation(CodeList30CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList30CodeListModel", this);
    }
}

