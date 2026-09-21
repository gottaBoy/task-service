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

@CodeList(id="a865901f7035d6710adab7027c8b9c1b", name="\u7cfb\u7edf\u5b9e\u4f53\u5c5e\u6027\u9ed8\u8ba4\u6392\u5e8f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NAME", text="\u5c5e\u6027\u540d\u79f0", realtext="\u5c5e\u6027\u540d\u79f0", userdata="\u6309\u5c5e\u6027\u540d\u79f0\u6392\u5e8f"), @CodeItem(value="CREATEDATE", text="\u521b\u5efa\u65f6\u95f4", realtext="\u521b\u5efa\u65f6\u95f4", userdata="\u6309\u5c5e\u6027\u521b\u5efa\u65f6\u95f4\u6392\u5e8f"), @CodeItem(value="NAME_PDT", text="\u5c5e\u6027\u540d\u79f0\uff08\u7cfb\u7edf\u5c5e\u6027\u4f18\u5148\uff09", realtext="\u5c5e\u6027\u540d\u79f0\uff08\u7cfb\u7edf\u5c5e\u6027\u4f18\u5148\uff09", userdata="\u6309\u5c5e\u6027\u540d\u79f0\u6392\u5e8f\uff0c\u7cfb\u7edf\u5c5e\u6027\u4f18\u5148"), @CodeItem(value="CREATEDATE_PDT", text="\u521b\u5efa\u65f6\u95f4\uff08\u7cfb\u7edf\u5c5e\u6027\u4f18\u5148\uff09", realtext="\u521b\u5efa\u65f6\u95f4\uff08\u7cfb\u7edf\u5c5e\u6027\u4f18\u5148\uff09", userdata="\u6309\u5c5e\u6027\u521b\u5efa\u65f6\u95f4\u6392\u5e8f\uff0c\u7cfb\u7edf\u5c5e\u6027\u4f18\u5148")})
public class SysDEFSortModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NAME = "NAME";
    public static final String CREATEDATE = "CREATEDATE";
    public static final String NAME_PDT = "NAME_PDT";
    public static final String CREATEDATE_PDT = "CREATEDATE_PDT";

    public SysDEFSortModeCodeListModel() {
        this.initAnnotation(SysDEFSortModeCodeListModel.class);
        this.setUserData2("DEFSortMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDEFSortModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDEFSortModeCodeListModel");
    }
}

