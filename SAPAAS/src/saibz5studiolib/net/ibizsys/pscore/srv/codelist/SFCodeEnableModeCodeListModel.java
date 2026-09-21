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

@CodeList(id="492bc577d86fd524ff10079aa5b7e038", name="\u540e\u53f0\u670d\u52a1\u4ee3\u7801\u542f\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="2", text="\u542f\u7528\u5e76\u5ffd\u7565", realtext="\u542f\u7528\u5e76\u5ffd\u7565")})
public class SFCodeEnableModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer INVALID = 0;
    public static final int INT_INVALID = 0;
    public static final Integer VALID = 1;
    public static final int INT_VALID = 1;
    public static final Integer REMOVE = 2;
    public static final int INT_REMOVE = 2;

    public SFCodeEnableModeCodeListModel() {
        this.initAnnotation(SFCodeEnableModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SFCodeEnableModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SFCodeEnableModeCodeListModel");
    }
}

