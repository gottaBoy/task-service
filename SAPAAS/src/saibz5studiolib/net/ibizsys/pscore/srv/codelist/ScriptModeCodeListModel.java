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

@CodeList(id="61915F52-5426-4A9B-8F2B-E3F61833834F", name="\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u542f\u7528", realtext="\u672a\u542f\u7528"), @CodeItem(value="1", text="\u76f4\u63a5\u811a\u672c\u4ee3\u7801", realtext="\u76f4\u63a5\u811a\u672c\u4ee3\u7801"), @CodeItem(value="2", text="\u6a21\u578b\u8fd0\u884c\u65f6\u5bf9\u8c61\u811a\u672c", realtext="\u6a21\u578b\u8fd0\u884c\u65f6\u5bf9\u8c61\u811a\u672c")})
public class ScriptModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer RAWSCRIPT = 1;
    public static final int INT_RAWSCRIPT = 1;
    public static final Integer MODELRTSCRIPT = 2;
    public static final int INT_MODELRTSCRIPT = 2;

    public ScriptModeCodeListModel() {
        this.initAnnotation(ScriptModeCodeListModel.class);
        this.setUserData2("ScriptMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ScriptModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ScriptModeCodeListModel");
    }
}

