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

@CodeList(id="28c4ba0645825d7bfb61c7bdada840c4", name="\u5b9e\u4f53\u6a21\u578b\u5bfc\u51fa\u7c7b\u522b2", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u7b80\u5355", realtext="\u7b80\u5355"), @CodeItem(value="16", text="\u6807\u51c6", realtext="\u6807\u51c6"), @CodeItem(value="128", text="\u5b8c\u6574", realtext="\u5b8c\u6574"), @CodeItem(value="2048", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="4096", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="8192", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493")})
public class ExportModelScope2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SIMPLE = 1;
    public static final int INT_SIMPLE = 1;
    public static final Integer STANDARD = 16;
    public static final int INT_STANDARD = 16;
    public static final Integer FULL = 128;
    public static final int INT_FULL = 128;
    public static final Integer USER = 2048;
    public static final int INT_USER = 2048;
    public static final Integer USER2 = 4096;
    public static final int INT_USER2 = 4096;
    public static final Integer USER3 = 8192;
    public static final int INT_USER3 = 8192;

    public ExportModelScope2CodeListModel() {
        this.initAnnotation(ExportModelScope2CodeListModel.class);
        this.setUserData2("DEExportModelScope2");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ExportModelScope2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ExportModelScope2CodeListModel");
    }
}

