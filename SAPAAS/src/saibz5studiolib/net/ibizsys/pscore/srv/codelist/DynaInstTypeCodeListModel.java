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

@CodeList(id="122aea802dd1911f7a3e42f16d5bc52e", name="\u52a8\u6001\u5b9e\u4f8b\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u5b9e\u4f8b", realtext="\u9ed8\u8ba4\u5b9e\u4f8b"), @CodeItem(value="MODULE", text="\u529f\u80fd\u6a21\u5757\u526f\u672c", realtext="\u529f\u80fd\u6a21\u5757\u526f\u672c"), @CodeItem(value="CONFTEMPL", text="\u6784\u578b\u6a21\u677f", realtext="\u6784\u578b\u6a21\u677f"), @CodeItem(value="MODULETEMPL", text="\u6a21\u5757\u6a21\u677f", realtext="\u6a21\u5757\u6a21\u677f"), @CodeItem(value="MISCTEMPL", text="\u6742\u9879\u6a21\u677f", realtext="\u6742\u9879\u6a21\u677f")})
public class DynaInstTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String MODULE = "MODULE";
    public static final String CONFTEMPL = "CONFTEMPL";
    public static final String MODULETEMPL = "MODULETEMPL";
    public static final String MISCTEMPL = "MISCTEMPL";

    public DynaInstTypeCodeListModel() {
        this.initAnnotation(DynaInstTypeCodeListModel.class);
        this.setUserData2("DynaInstType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaInstTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaInstTypeCodeListModel");
    }
}

