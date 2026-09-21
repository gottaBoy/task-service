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

@CodeList(id="42fe7e81a5c70b1d520c0769f4b3aedd", name="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GROUP", text="\u6761\u4ef6\u7ec4", realtext="\u6761\u4ef6\u7ec4", userdata="\u7ec4\u6761\u4ef6\uff0c\u4f7f\u7528\u4e0e\uff08AND\uff09\u3001\u6216\uff08OR\uff09\u903b\u8f91\u8ba1\u7b97\u6210\u5458\u6761\u4ef6"), @CodeItem(value="NULLRULE", text="\u7a7a\u503c\u5224\u65ad", realtext="\u7a7a\u503c\u5224\u65ad", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u4e3a\u7a7a\u503c"), @CodeItem(value="VALUERANGE", text="\u6570\u636e\u96c6\u8303\u56f4", realtext="\u6570\u636e\u96c6\u8303\u56f4", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u5728\u6307\u5b9a\u7684\u6570\u636e\u96c6\u5408\u4e2d"), @CodeItem(value="VALUERANGE2", text="\u6570\u503c\u8303\u56f4", realtext="\u6570\u503c\u8303\u56f4", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u5728\u6307\u5b9a\u6570\u503c\u8303\u56f4\u4e2d"), @CodeItem(value="REGEX", text="\u6b63\u5219\u5f0f", realtext="\u6b63\u5219\u5f0f", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u7b26\u5408\u6307\u5b9a\u6b63\u5219\u5f0f\u89c4\u5219"), @CodeItem(value="STRINGLENGTH", text="\u5b57\u7b26\u957f\u5ea6", realtext="\u5b57\u7b26\u957f\u5ea6", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u7684\u957f\u5ea6\u662f\u5426\u5728\u6307\u5b9a\u8303\u56f4\u4e2d"), @CodeItem(value="SIMPLE", text="\u5e38\u89c4\u6761\u4ef6", realtext="\u5e38\u89c4\u6761\u4ef6", userdata="\u8fdb\u884c\u6307\u5b9a\u5c5e\u6027\u503c\u4e0e\u76ee\u6807\u503c\u7684\u903b\u8f91\u5224\u65ad"), @CodeItem(value="VALUERANGE3", text="\u503c\u6e05\u5355", realtext="\u503c\u6e05\u5355", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u5728\u6307\u5b9a\u7684\u503c\u6e05\u5355\u4e2d"), @CodeItem(value="QUERYCOUNT", text="\u67e5\u8be2\u8ba1\u6570", realtext="\u67e5\u8be2\u8ba1\u6570", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u7684\u67e5\u8be2\u8ba1\u6570\u662f\u5426\u5728\u6307\u5b9a\u7684\u8303\u56f4\u4e2d"), @CodeItem(value="VALUERECURSION", text="\u503c\u9012\u5f52\u68c0\u67e5", realtext="\u503c\u9012\u5f52\u68c0\u67e5", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u5b58\u5728\u9012\u5f52\u5f15\u7528"), @CodeItem(value="SYSVALUERULE", text="\u7cfb\u7edf\u503c\u89c4\u5219", realtext="\u7cfb\u7edf\u503c\u89c4\u5219", userdata="\u5224\u65ad\u6307\u5b9a\u5c5e\u6027\u503c\u662f\u5426\u6ee1\u8db3\u6307\u5b9a\u7684\u7cfb\u7edf\u503c\u89c4\u5219")})
public class DEFVRTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String GROUP = "GROUP";
    public static final String NULLRULE = "NULLRULE";
    public static final String VALUERANGE = "VALUERANGE";
    public static final String VALUERANGE2 = "VALUERANGE2";
    public static final String REGEX = "REGEX";
    public static final String STRINGLENGTH = "STRINGLENGTH";
    public static final String SIMPLE = "SIMPLE";
    public static final String VALUERANGE3 = "VALUERANGE3";
    public static final String QUERYCOUNT = "QUERYCOUNT";
    public static final String VALUERECURSION = "VALUERECURSION";
    public static final String SYSVALUERULE = "SYSVALUERULE";

    public DEFVRTypeCodeListModel() {
        this.initAnnotation(DEFVRTypeCodeListModel.class);
        this.setUserData2("DEFVRType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFVRTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFVRTypeCodeListModel");
    }
}

