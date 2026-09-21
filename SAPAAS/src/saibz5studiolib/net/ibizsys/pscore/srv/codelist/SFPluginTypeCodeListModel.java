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

@CodeList(id="c35d620cfe641c8b466525693bbe9f64", name="\u540e\u53f0\u670d\u52a1\u63d2\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="DELOGICNODE", text="\u5b9e\u4f53\u903b\u8f91\u8282\u70b9", realtext="\u5b9e\u4f53\u903b\u8f91\u8282\u70b9"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u6570\u636e\u96c6"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="SYSREF", text="\u7cfb\u7edf\u5f15\u7528", realtext="\u7cfb\u7edf\u5f15\u7528", userdata="\u7cfb\u7edf\u5f15\u7528\u8fd0\u884c\u65f6\u63d2\u4ef6"), @CodeItem(value="MODULE", text="\u7cfb\u7edf\u6a21\u5757", realtext="\u7cfb\u7edf\u6a21\u5757", userdata="\u7cfb\u7edf\u6a21\u5757\u8fd0\u884c\u65f6\u63d2\u4ef6"), @CodeItem(value="STRFUNC", text="\u5b57\u7b26\u4e32\u64cd\u4f5c\uff08\u5e9f\u5f03\uff09", realtext="\u5b57\u7b26\u4e32\u64cd\u4f5c\uff08\u5e9f\u5f03\uff09"), @CodeItem(value="MATHFUNC", text="\u6570\u5b66\u51fd\u6570\uff08\u5e9f\u5f03\uff09", realtext="\u6570\u5b66\u51fd\u6570\uff08\u5e9f\u5f03\uff09"), @CodeItem(value="DOCFUNC", text="\u6587\u6863\u64cd\u4f5c\uff08\u5e9f\u5f03\uff09", realtext="\u6587\u6863\u64cd\u4f5c\uff08\u5e9f\u5f03\uff09")})
public class SFPluginTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEACTION = "DEACTION";
    public static final String DELOGIC = "DELOGIC";
    public static final String DELOGICNODE = "DELOGICNODE";
    public static final String DEDATASET = "DEDATASET";
    public static final String USER = "USER";
    public static final String SYSREF = "SYSREF";
    public static final String MODULE = "MODULE";
    public static final String STRFUNC = "STRFUNC";
    public static final String MATHFUNC = "MATHFUNC";
    public static final String DOCFUNC = "DOCFUNC";

    public SFPluginTypeCodeListModel() {
        this.initAnnotation(SFPluginTypeCodeListModel.class);
        this.setUserData2("SFPluginType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SFPluginTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SFPluginTypeCodeListModel");
    }
}

