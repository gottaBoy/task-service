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

@CodeList(id="4a57ef687ace4f5eff3bed30914d2ccb", name="\u4e2d\u5fc3\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ASSIGNSLN", text="\u5206\u914d\u5230\u65b9\u6848", realtext="\u5206\u914d\u5230\u65b9\u6848"), @CodeItem(value="BINDSYS", text="\u7ed1\u5b9a\u7cfb\u7edf", realtext="\u7ed1\u5b9a\u7cfb\u7edf"), @CodeItem(value="UNBINDSYS", text="\u89e3\u7ed1\u7cfb\u7edf", realtext="\u89e3\u7ed1\u7cfb\u7edf"), @CodeItem(value="EXPORTMODEL", text="\u5bfc\u51fa\u5230\u6a21\u578b\u4ed3\u5e93", realtext="\u5bfc\u51fa\u5230\u6a21\u578b\u4ed3\u5e93"), @CodeItem(value="IMPORTMODEL", text="\u4ece\u6a21\u578b\u4ed3\u5e93\u5bfc\u5165", realtext="\u4ece\u6a21\u578b\u4ed3\u5e93\u5bfc\u5165"), @CodeItem(value="UPGRATE", text="\u5347\u7ea7\u6a21\u578b\u4ed3\u5e93", realtext="\u5347\u7ea7\u6a21\u578b\u4ed3\u5e93"), @CodeItem(value="OFFLINESYS", text="\u7cfb\u7edf\u79bb\u7ebf", realtext="\u7cfb\u7edf\u79bb\u7ebf")})
public class DCSysInstActionCodeListModel
extends StaticCodeListModelBase {
    public static final String ASSIGNSLN = "ASSIGNSLN";
    public static final String BINDSYS = "BINDSYS";
    public static final String UNBINDSYS = "UNBINDSYS";
    public static final String EXPORTMODEL = "EXPORTMODEL";
    public static final String IMPORTMODEL = "IMPORTMODEL";
    public static final String UPGRATE = "UPGRATE";
    public static final String OFFLINESYS = "OFFLINESYS";

    public DCSysInstActionCodeListModel() {
        this.initAnnotation(DCSysInstActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSysInstActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCSysInstActionCodeListModel");
    }
}

