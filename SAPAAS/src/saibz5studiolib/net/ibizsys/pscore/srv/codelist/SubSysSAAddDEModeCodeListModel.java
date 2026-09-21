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

@CodeList(id="9956d8ad667c872b921baa023a0ca0d7", name="\u5b50\u7cfb\u7edf\u63a5\u53e3\u81ea\u52a8\u6dfb\u52a0\u5b9e\u4f53\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u6392\u9664\u6dfb\u52a0", realtext="\u6392\u9664\u6dfb\u52a0"), @CodeItem(value="2", text="\u9009\u62e9\u6dfb\u52a0", realtext="\u9009\u62e9\u6dfb\u52a0")})
public class SubSysSAAddDEModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer EXCLUDE = 1;
    public static final int INT_EXCLUDE = 1;
    public static final Integer INCLUDE = 2;
    public static final int INT_INCLUDE = 2;

    public SubSysSAAddDEModeCodeListModel() {
        this.initAnnotation(SubSysSAAddDEModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSAAddDEModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSAAddDEModeCodeListModel");
    }
}

