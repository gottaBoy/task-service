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

@CodeList(id="BF920A1A-A79E-44D3-A327-DFF41EF83482", name="\u5b9e\u4f53\u6570\u636e\u96c6\u5206\u7ec4\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u6307\u5b9a\u5206\u7ec4\u53c2\u6570", realtext="\u6307\u5b9a\u5206\u7ec4\u53c2\u6570"), @CodeItem(value="3", text="\u6307\u5b9a\u5206\u7ec4\u53c2\u6570\uff08\u6269\u5c55\uff09", realtext="\u6307\u5b9a\u5206\u7ec4\u53c2\u6570\uff08\u6269\u5c55\uff09"), @CodeItem(value="2", text="\u6307\u5b9a\u805a\u5408\u5173\u7cfb", realtext="\u6307\u5b9a\u805a\u5408\u5173\u7cfb", userdata="\u901a\u8fc7\u805a\u5408\u5173\u7cfb\u4e2d\u7684\u805a\u5408\u5c5e\u6027\u914d\u7f6e\u83b7\u53d6\u5206\u7ec4\u903b\u8f91")})
public class DEDataSetGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer GROUPPARAM = 1;
    public static final int INT_GROUPPARAM = 1;
    public static final Integer GROUPPARAMEX = 3;
    public static final int INT_GROUPPARAMEX = 3;
    public static final Integer DERAGG = 2;
    public static final int INT_DERAGG = 2;

    public DEDataSetGroupModeCodeListModel() {
        this.initAnnotation(DEDataSetGroupModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEDataSetGroupMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetGroupModeCodeListModel");
    }
}

