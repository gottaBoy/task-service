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

@CodeList(id="60843d9597b7104e6426c2a5eee0ff3e", name="\u6a21\u578b\u5bfc\u51fa\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5bfc\u51fa\u64cd\u4f5c\u4fe1\u606f", realtext="\u5bfc\u51fa\u64cd\u4f5c\u4fe1\u606f")})
public class ModelV2ExpModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer OPINFO = 1;
    public static final int INT_OPINFO = 1;

    public ModelV2ExpModeCodeListModel() {
        this.initAnnotation(ModelV2ExpModeCodeListModel.class);
        this.setUserData2("ModelV2ExpMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelV2ExpModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelV2ExpModeCodeListModel");
    }
}

