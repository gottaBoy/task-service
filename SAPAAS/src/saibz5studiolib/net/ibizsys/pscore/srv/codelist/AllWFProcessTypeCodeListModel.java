/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="1109CDEE-5BD6-4F5B-86CB-2CA78798B00A", name="\u4e91\u7cfb\u7edf\u6d41\u7a0b\u5904\u7406\u7c7b\u578b\uff08\u5168\u90e8\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="START", text="\u5f00\u59cb", realtext="\u5f00\u59cb", iconpath="pswfprocesstype/icon_start@{0}2.png", iconpathx="pswfprocesstype/icon_start@{0}2.png"), @CodeItem(value="END", text="\u7ed3\u675f", realtext="\u7ed3\u675f", iconpath="pswfprocesstype/icon_end@{0}2.png", iconpathx="pswfprocesstype/icon_end@{0}2.png"), @CodeItem(value="PROCESS", text="\u5e38\u89c4\u5904\u7406", realtext="\u5e38\u89c4\u5904\u7406", iconpath="pswfprocesstype/icon_process.png", iconpathx="pswfprocesstype/icon_process@{0}x.png"), @CodeItem(value="INTERACTIVE", text="\u4ea4\u4e92\u5904\u7406", realtext="\u4ea4\u4e92\u5904\u7406", iconpath="pswfprocesstype/icon_interactive.png", iconpathx="pswfprocesstype/icon_interactive@{0}x.png"), @CodeItem(value="EMBED", text="\u5d4c\u5957\u5b50\u6d41\u7a0b", realtext="\u5d4c\u5957\u5b50\u6d41\u7a0b", iconpath="pswfprocesstype/icon_embed.png", iconpathx="pswfprocesstype/icon_embed@{0}x.png"), @CodeItem(value="EXCLUSIVEGATEWAY", text="\u6392\u5b83\u7f51\u5173", realtext="\u6392\u5b83\u7f51\u5173"), @CodeItem(value="INCLUSIVEGATEWAY", text="\u5305\u5bb9\u7f51\u5173", realtext="\u5305\u5bb9\u7f51\u5173"), @CodeItem(value="PARALLELGATEWAY", text="\u5e76\u884c\u7f51\u5173", realtext="\u5e76\u884c\u7f51\u5173"), @CodeItem(value="CALLORGACTIVITY", text="\u8c03\u7528\u7ec4\u7ec7\u6d41\u7a0b", realtext="\u8c03\u7528\u7ec4\u7ec7\u6d41\u7a0b")})
public class AllWFProcessTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String START = "START";
    public static final String END = "END";
    public static final String PROCESS = "PROCESS";
    public static final String INTERACTIVE = "INTERACTIVE";
    public static final String EMBED = "EMBED";
    public static final String EXCLUSIVEGATEWAY = "EXCLUSIVEGATEWAY";
    public static final String INCLUSIVEGATEWAY = "INCLUSIVEGATEWAY";
    public static final String PARALLELGATEWAY = "PARALLELGATEWAY";
    public static final String CALLORGACTIVITY = "CALLORGACTIVITY";

    public AllWFProcessTypeCodeListModel() {
        this.initAnnotation(AllWFProcessTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AllWFProcessTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AllWFProcessTypeCodeListModel");
    }
}

