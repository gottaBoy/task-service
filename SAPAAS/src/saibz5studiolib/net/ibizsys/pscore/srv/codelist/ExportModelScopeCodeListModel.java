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

@CodeList(id="ff9b6226ff1ee57cd9aaa3b3dfef4376", name="\u5b9e\u4f53\u6a21\u578b\u5bfc\u51fa\u7c7b\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u7b80\u5355", realtext="\u7b80\u5355"), @CodeItem(value="17", text="\u6807\u51c6\uff08\u542b\u7b80\u5355\uff09", realtext="\u6807\u51c6\uff08\u542b\u7b80\u5355\uff09"), @CodeItem(value="145", text="\u5b8c\u6574\uff08\u542b\u6807\u51c6\uff09", realtext="\u5b8c\u6574\uff08\u542b\u6807\u51c6\uff09"), @CodeItem(value="2048", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="4096", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="8192", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493")})
public class ExportModelScopeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SIMPLE = 1;
    public static final int INT_SIMPLE = 1;
    public static final Integer STANDARD = 17;
    public static final int INT_STANDARD = 17;
    public static final Integer FULL = 145;
    public static final int INT_FULL = 145;
    public static final Integer USER = 2048;
    public static final int INT_USER = 2048;
    public static final Integer USER2 = 4096;
    public static final int INT_USER2 = 4096;
    public static final Integer USER3 = 8192;
    public static final int INT_USER3 = 8192;

    public ExportModelScopeCodeListModel() {
        this.initAnnotation(ExportModelScopeCodeListModel.class);
        this.setUserData2("DEExportModelScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ExportModelScopeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ExportModelScopeCodeListModel");
    }
}

