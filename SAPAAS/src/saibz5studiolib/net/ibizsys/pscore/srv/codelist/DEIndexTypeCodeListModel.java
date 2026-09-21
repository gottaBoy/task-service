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

@CodeList(id="3c8527150efe0eabb851109e0e2535c2", name="\u7d22\u5f15\u5b9e\u4f53\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="INDEX", text="\u7d22\u5f15\u4e3b\u5b9e\u4f53", realtext="\u7d22\u5f15\u4e3b\u5b9e\u4f53", userdata="\u7d22\u5f15\u4ece\u5b9e\u4f53\u90fd\u4e3a\u72ec\u7acb\u5b9e\u4f53\uff0c\u5728\u5efa\u7acb\u3001\u66f4\u65b0\u3001\u5220\u9664\u6570\u636e\u65f6\u90fd\u4f1a\u540c\u6b65\u81f3\u7d22\u5f15\u4e3b\u5b9e\u4f53\uff0c\u7d22\u5f15\u4ece\u5b9e\u4f53\u53ef\u4ee5\u540c\u65f6\u6709\u591a\u4e2a\u7d22\u5f15\u4e3b\u5b9e\u4f53"), @CodeItem(value="INHERIT", text="\u7ee7\u627f\u4e3b\u5b9e\u4f53", realtext="\u7ee7\u627f\u4e3b\u5b9e\u4f53", userdata="\u987e\u540d\u601d\u4e49\uff0c\u7ee7\u627f\u4e3b\u5b9e\u4f53\u662f\u7ee7\u627f\u4ece\u5b9e\u4f53\u7684\u7236\u5b9e\u4f53\uff0c\u7ee7\u627f\u4ece\u5b9e\u4f53\u4e0d\u72ec\u7acb\u5b58\u5728\uff0c\u9700\u8981\u4e0e\u4e3b\u5b9e\u4f53\u4e00\u8d77\u5b8c\u6210\u529f\u80fd\uff0c\u7ee7\u627f\u4ece\u5b9e\u4f53\u53ea\u5141\u8bb8\u6709\u4e00\u4e2a\u7ee7\u627f\u4e3b\u5b9e\u4f53")})
public class DEIndexTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INDEX = "INDEX";
    public static final String INHERIT = "INHERIT";

    public DEIndexTypeCodeListModel() {
        this.initAnnotation(DEIndexTypeCodeListModel.class);
        this.setUserData2("DEIndexType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEIndexTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEIndexTypeCodeListModel");
    }
}

