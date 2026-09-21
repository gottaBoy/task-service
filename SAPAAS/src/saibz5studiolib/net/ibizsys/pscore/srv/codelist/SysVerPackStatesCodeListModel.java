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

@CodeList(id="c6a30a40b81038410864709d0b942ee7", name="\u4e91\u7cfb\u7edf\u4ea7\u54c1\u6253\u5305\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u6253\u5305", realtext="\u672a\u6253\u5305"), @CodeItem(value="1", text="\u6253\u5305\u4e2d", realtext="\u6253\u5305\u4e2d"), @CodeItem(value="2", text="\u5df2\u6253\u5305", realtext="\u5df2\u6253\u5305")})
public class SysVerPackStatesCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTPACKAGED = 0;
    public static final int INT_NOTPACKAGED = 0;
    public static final Integer PACKAGING = 1;
    public static final int INT_PACKAGING = 1;
    public static final Integer PACKAGED = 2;
    public static final int INT_PACKAGED = 2;

    public SysVerPackStatesCodeListModel() {
        this.initAnnotation(SysVerPackStatesCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysVerPackStatesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysVerPackStatesCodeListModel");
    }
}

