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

@CodeList(id="aedef17883d9c3999bbb7789943aa387", name="\u4e91\u5e94\u7528\u7cfb\u7edf\u5dee\u5f02\u5206\u6790\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u5206\u6790", realtext="\u672a\u5206\u6790"), @CodeItem(value="20", text="\u5206\u6790\u4e2d", realtext="\u5206\u6790\u4e2d"), @CodeItem(value="30", text="\u5206\u6790\u7ed3\u675f", realtext="\u5206\u6790\u7ed3\u675f"), @CodeItem(value="40", text="\u5206\u6790\u53d6\u6d88", realtext="\u5206\u6790\u53d6\u6d88")})
public class SysDiffRepStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";
    public static final String ITEM_40 = "40";

    public SysDiffRepStateCodeListModel() {
        this.initAnnotation(SysDiffRepStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffRepStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysDiffRepStateCodeListModel");
    }
}

