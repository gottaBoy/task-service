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

@CodeList(id="8AF8FFC6-1DC2-46DD-A77F-962E8A29DFED", name="\u7cfb\u7edf\u6d88\u606f\u6a21\u677f\u5f15\u64ce", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FREEMARKER", text="FreeMarker", realtext="FreeMarker"), @CodeItem(value="GROOVY", text="Groovy", realtext="Groovy"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class MsgTemplEngineCodeListModel
extends StaticCodeListModelBase {
    public static final String FREEMARKER = "FREEMARKER";
    public static final String GROOVY = "GROOVY";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public MsgTemplEngineCodeListModel() {
        this.initAnnotation(MsgTemplEngineCodeListModel.class);
        this.setUserData2("MsgTemplEngine");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MsgTemplEngineCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MsgTemplEngineCodeListModel");
    }
}

