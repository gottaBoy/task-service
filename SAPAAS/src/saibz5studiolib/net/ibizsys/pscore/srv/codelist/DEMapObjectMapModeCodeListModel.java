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

@CodeList(id="E7E91C70-5831-4F06-A819-7DE7FBE44BD5", name="\u5b9e\u4f53\u6620\u5c04\u5904\u7406\u6620\u5c04\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4", userdata="\u9ed8\u8ba4\u5904\u7406\uff0c\u5728\u5165\u53e3\u5904\u8fdb\u884c\u6620\u5c04\uff0c\u4e0d\u9644\u52a0\u5f53\u524d\u5b9e\u4f53\u7684\u5904\u7406\u903b\u8f91"), @CodeItem(value="INNER", text="\u5185\u90e8\u5904\u7406", realtext="\u5185\u90e8\u5904\u7406", userdata="\u4ec5\u6620\u5c04\u7684\u5b9e\u9645\u5904\u7406\u64cd\u4f5c\uff0c\u5728\u5f53\u524d\u5b9e\u4f53\u4e2d\u5b8c\u6210\u903b\u8f91\u9644\u52a0\u64cd\u4f5c")})
public class DEMapObjectMapModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String INNER = "INNER";

    public DEMapObjectMapModeCodeListModel() {
        this.initAnnotation(DEMapObjectMapModeCodeListModel.class);
        this.setUserData2("DEMapObjectMapMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMapObjectMapModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMapObjectMapModeCodeListModel");
    }
}

