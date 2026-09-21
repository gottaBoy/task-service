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

@CodeList(id="D35C2554-6A4A-4177-AF0E-D9C8F71B1F08", name="\u5916\u90e8\u63a5\u53e3\u65b9\u6cd5\u7ed1\u5b9a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u7ed1\u5b9a", realtext="\u4e0d\u7ed1\u5b9a"), @CodeItem(value="2", text="\u81ea\u52a8\u7ed1\u5b9a", realtext="\u81ea\u52a8\u7ed1\u5b9a", userdata="\u901a\u8fc7\u4ee3\u7801\u540d\u79f0\u5c1d\u8bd5\u83b7\u53d6\u5bf9\u5e94\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5")})
public class SubSysSADEMethodBindingModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOT = 0;
    public static final int INT_NOT = 0;
    public static final Integer AUTO = 2;
    public static final int INT_AUTO = 2;

    public SubSysSADEMethodBindingModeCodeListModel() {
        this.initAnnotation(SubSysSADEMethodBindingModeCodeListModel.class);
        this.setUserData2("SubSysSADEMethodBindingMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEMethodBindingModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEMethodBindingModeCodeListModel");
    }
}

