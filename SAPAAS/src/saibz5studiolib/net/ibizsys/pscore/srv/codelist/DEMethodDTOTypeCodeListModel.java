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

@CodeList(id="59F3B3FC-A318-4F68-A63E-A37BAF12685B", name="\u5b9e\u4f53\u65b9\u6cd5DTO\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u5b9e\u4f53\u9ed8\u8ba4", realtext="\u5b9e\u4f53\u9ed8\u8ba4", userdata="\u4ece\u5b9e\u4f53\u5c5e\u6027\uff08\u5168\u90e8\u6216\u6307\u5b9a\u5c5e\u6027\u7ec4\uff09\u4e2d\u6784\u5efa\u65b9\u6cd5DTO\u5bf9\u8c61"), @CodeItem(value="DEACTIONINPUT", text="\u5b9e\u4f53\u884c\u4e3a\u81ea\u5b9a\u4e49\u53c2\u6570", realtext="\u5b9e\u4f53\u884c\u4e3a\u81ea\u5b9a\u4e49\u53c2\u6570", userdata="\u4ece\u5b9e\u4f53\u884c\u4e3a\u81ea\u5b9a\u4e49\u53c2\u6570\u4e2d\u6784\u5efa\u65b9\u6cd5DTO\u5bf9\u8c61"), @CodeItem(value="DEFILTER", text="\u5b9e\u4f53\u8fc7\u6ee4\u5668", realtext="\u5b9e\u4f53\u8fc7\u6ee4\u5668", userdata="\u4ece\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u4e2d\u6784\u5efa\u65b9\u6cd5DTO\u5bf9\u8c61"), @CodeItem(value="DEDATASETINPUT", text="\u5b9e\u4f53\u6570\u636e\u96c6\u81ea\u5b9a\u4e49\u53c2\u6570", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u81ea\u5b9a\u4e49\u53c2\u6570", userdata="\u4ece\u5b9e\u4f53\u6570\u636e\u96c6\u81ea\u5b9a\u4e49\u53c2\u6570\u4e2d\u6784\u5efa\u65b9\u6cd5DTO\u5bf9\u8c61")})
public class DEMethodDTOTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String DEACTIONINPUT = "DEACTIONINPUT";
    public static final String DEFILTER = "DEFILTER";
    public static final String DEDATASETINPUT = "DEDATASETINPUT";

    public DEMethodDTOTypeCodeListModel() {
        this.initAnnotation(DEMethodDTOTypeCodeListModel.class);
        this.setUserData2("DEMethodDTOType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMethodDTOTypeCodeListModel");
    }
}

