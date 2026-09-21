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

@CodeList(id="3EE84D25-7528-4E93-AA0A-04DA3E534BD9", name="\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ENTITYFIELD", text="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5c5e\u6027", realtext="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5c5e\u6027", userdata="\u503c\u6765\u81ea\u5f53\u524d\u6570\u636e\u5bf9\u8c61\u7684\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="SRCENTITYFIELD", text="\u6e90\u903b\u8f91\u53c2\u6570\u5c5e\u6027", realtext="\u6e90\u903b\u8f91\u53c2\u6570\u5c5e\u6027", userdata="\u503c\u6765\u81ea\u6e90\u5bf9\u8c61\u7684\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="SRCDLPARAM", text="\u6e90\u903b\u8f91\u53c2\u6570", realtext="\u6e90\u903b\u8f91\u53c2\u6570"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4", userdata="\u503c\u4e3a\u5f53\u524d\u65f6\u95f4"), @CodeItem(value="LASTRETURN", text="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de", realtext="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de")})
public class DELLCondParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ENTITYFIELD = "ENTITYFIELD";
    public static final String SRCENTITYFIELD = "SRCENTITYFIELD";
    public static final String SRCDLPARAM = "SRCDLPARAM";
    public static final String CURTIME = "CURTIME";
    public static final String LASTRETURN = "LASTRETURN";

    public DELLCondParamTypeCodeListModel() {
        this.initAnnotation(DELLCondParamTypeCodeListModel.class);
        this.setUserData2("DELLCondParamType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELLCondParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELLCondParamTypeCodeListModel");
    }
}

