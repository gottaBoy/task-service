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

@CodeList(id="D557F0F8-6D17-403C-9230-43510B30B60D", name="\u5b9e\u4f53\u65b9\u6cd5DTO\u6765\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DE", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53", userdata="\u6765\u6e90\u4e8e\u5f53\u524d\u5b9e\u4f53\uff0c\u652f\u6301\u8fdb\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u7ec4"), @CodeItem(value="DYNAMODEL", text="\u52a8\u6001\u6a21\u578b", realtext="\u52a8\u6001\u6a21\u578b", userdata="\u4ece\u52a8\u6001\u6a21\u578b\u4e2d\u6784\u5efa\u7684\u57df\u5bf9\u8c61"), @CodeItem(value="DEACTIONINPUT", text="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570", realtext="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570", userdata="\u4ece\u5b9e\u4f53\u884c\u4e3a\u81ea\u5b9a\u4e49\u53c2\u6570\u6784\u5efa"), @CodeItem(value="DEFILTER", text="\u5b9e\u4f53\u8fc7\u6ee4\u5668", realtext="\u5b9e\u4f53\u8fc7\u6ee4\u5668", userdata="\u4ece\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u6784\u5efa\u641c\u7d22\u8fc7\u6ee4\u5668"), @CodeItem(value="REFDE", text="\u5f15\u7528\u5b9e\u4f53", realtext="\u5f15\u7528\u5b9e\u4f53", userdata="\u6765\u6e90\u4e8e\u5f15\u7528\u5b9e\u4f53\uff0c\u652f\u6301\u8fdb\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u7ec4"), @CodeItem(value="DEDATASETINPUT", text="\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570", userdata="\u4ece\u5b9e\u4f53\u6570\u636e\u96c6\u81ea\u5b9a\u4e49\u53c2\u6570\u6784\u5efa")})
public class DEMethodDTOSourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DE = "DE";
    public static final String DYNAMODEL = "DYNAMODEL";
    public static final String DEACTIONINPUT = "DEACTIONINPUT";
    public static final String DEFILTER = "DEFILTER";
    public static final String REFDE = "REFDE";
    public static final String DEDATASETINPUT = "DEDATASETINPUT";

    public DEMethodDTOSourceTypeCodeListModel() {
        this.initAnnotation(DEMethodDTOSourceTypeCodeListModel.class);
        this.setUserData2("DEMethodDTOSourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOSourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOSourceTypeCodeListModel");
    }
}

