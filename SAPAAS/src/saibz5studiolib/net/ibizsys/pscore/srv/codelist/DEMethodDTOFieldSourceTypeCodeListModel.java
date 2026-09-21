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

@CodeList(id="DAF4EEF2-21DB-4662-93BF-A512812F4082", name="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61\u5c5e\u6027\u6765\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFIELD", text="\u5b9e\u4f53\u5c5e\u6027", realtext="\u5b9e\u4f53\u5c5e\u6027", userdata="\u6765\u6e90\u4e8e\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027"), @CodeItem(value="DEFGROUPDETAIL", text="\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458", realtext="\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458", userdata="\u6765\u6e90\u662f\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458"), @CodeItem(value="DER", text="\u5b9e\u4f53\u5173\u7cfb", realtext="\u5b9e\u4f53\u5173\u7cfb", userdata="\u6765\u6e90\u4e8e\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb"), @CodeItem(value="DYNAMODELATTR", text="\u52a8\u6001\u6a21\u578b\u5c5e\u6027", realtext="\u52a8\u6001\u6a21\u578b\u5c5e\u6027", userdata="\u4ece\u52a8\u6001\u6a21\u578b\u5c5e\u6027\u4e2d\u6784\u5efa\u7684\u5c5e\u6027\u5bf9\u8c61"), @CodeItem(value="DEACTIONPARAM", text="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570", realtext="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570", userdata="\u4ece\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570\u6784\u5efa\u7684\u5c5e\u6027\u5bf9\u8c61"), @CodeItem(value="DEFSEARCHMODE", text="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", realtext="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", userdata="\u4ece\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u6784\u5efa\u7684\u5c5e\u6027\u5bf9\u8c61"), @CodeItem(value="DEDATASETPARAM", text="\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570", userdata="\u4ece\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570\u6784\u5efa\u7684\u5c5e\u6027\u5bf9\u8c61")})
public class DEMethodDTOFieldSourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFIELD = "DEFIELD";
    public static final String DEFGROUPDETAIL = "DEFGROUPDETAIL";
    public static final String DER = "DER";
    public static final String DYNAMODELATTR = "DYNAMODELATTR";
    public static final String DEACTIONPARAM = "DEACTIONPARAM";
    public static final String DEFSEARCHMODE = "DEFSEARCHMODE";
    public static final String DEDATASETPARAM = "DEDATASETPARAM";

    public DEMethodDTOFieldSourceTypeCodeListModel() {
        this.initAnnotation(DEMethodDTOFieldSourceTypeCodeListModel.class);
        this.setUserData2("DEMethodDTOFieldSourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOFieldSourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOFieldSourceTypeCodeListModel");
    }
}

