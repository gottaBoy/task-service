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

@CodeList(id="33bcfea03c9bd22116c1d548989a3ae0", name="Flex\u6a2a\u8f74\u5bf9\u9f50", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="flex-start", text="\u5de6\u5bf9\u9f50", realtext="\u5de6\u5bf9\u9f50"), @CodeItem(value="flex-end", text="\u53f3\u5bf9\u9f50", realtext="\u53f3\u5bf9\u9f50"), @CodeItem(value="center", text="\u5c45\u4e2d", realtext="\u5c45\u4e2d"), @CodeItem(value="space-between", text="space-between", realtext="space-between"), @CodeItem(value="space-around", text="space-around", realtext="space-around")})
public class FlexAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String FLEX_START = "flex-start";
    public static final String FLEX_END = "flex-end";
    public static final String CENTER = "center";
    public static final String SPACE_BETWEEN = "space-between";
    public static final String SPACE_AROUND = "space-around";

    public FlexAlignCodeListModel() {
        this.initAnnotation(FlexAlignCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("FlexAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel");
    }
}

