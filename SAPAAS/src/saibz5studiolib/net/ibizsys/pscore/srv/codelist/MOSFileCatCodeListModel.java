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

@CodeList(id="5bb0f01a6fd0219a49972a9826b2f974", name="\u6a21\u578b\u7cfb\u7edf\u6587\u4ef6\u7c7b\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYS", text="\u5f53\u524d\u7cfb\u7edf", realtext="\u5f53\u524d\u7cfb\u7edf"), @CodeItem(value="RECENTS", text="\u6700\u8fd1\u8bbf\u95ee", realtext="\u6700\u8fd1\u8bbf\u95ee"), @CodeItem(value="BOOKMARK", text="\u4e66\u7b7e", realtext="\u4e66\u7b7e")})
public class MOSFileCatCodeListModel
extends StaticCodeListModelBase {
    public static final String SYS = "SYS";
    public static final String RECENTS = "RECENTS";
    public static final String BOOKMARK = "BOOKMARK";

    public MOSFileCatCodeListModel() {
        this.initAnnotation(MOSFileCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MOSFileCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MOSFileCatCodeListModel");
    }
}

