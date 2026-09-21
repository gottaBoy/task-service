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

@CodeList(id="26dd4fff6199ef7bf2356906ae87f439", name="Flex\u7eb5\u8f74\u5bf9\u9f50", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="flex-start", text="\u4e0a\u5bf9\u9f50", realtext="\u4e0a\u5bf9\u9f50"), @CodeItem(value="flex-end", text="\u4e0b\u5bf9\u9f50", realtext="\u4e0b\u5bf9\u9f50"), @CodeItem(value="center", text="\u5c45\u4e2d", realtext="\u5c45\u4e2d"), @CodeItem(value="baseline", text="baseline", realtext="baseline"), @CodeItem(value="stretch", text="stretch", realtext="stretch")})
public class FlexVAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String FLEX_START = "flex-start";
    public static final String FLEX_END = "flex-end";
    public static final String CENTER = "center";
    public static final String BASELINE = "baseline";
    public static final String STRETCH = "stretch";

    public FlexVAlignCodeListModel() {
        this.initAnnotation(FlexVAlignCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("FlexVAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel");
    }
}

