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

@CodeList(id="5e1e7722a61c78d0966f1bcc85c24c4e", name="\u76ee\u6807\u503c\u89c4\u5219\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFVALUERULE", text="\u5b9e\u4f53\u503c\u89c4\u5219", realtext="\u5b9e\u4f53\u503c\u89c4\u5219", userdata="\u6307\u5b9a\u6765\u81ea\u5f53\u524d\u5b9e\u4f53\u7684\u5c5e\u6027\u503c\u89c4\u5219\u5bf9\u8c61"), @CodeItem(value="SYSVALUERULE", text="\u7cfb\u7edf\u503c\u89c4\u5219", realtext="\u7cfb\u7edf\u503c\u89c4\u5219", userdata="\u6307\u5b9a\u7cfb\u7edf\u5b9a\u4e49\u7684\u503c\u89c4\u5219\u5bf9\u8c61")})
public class DEFIVRTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFVALUERULE = "DEFVALUERULE";
    public static final String SYSVALUERULE = "SYSVALUERULE";

    public DEFIVRTypeCodeListModel() {
        this.initAnnotation(DEFIVRTypeCodeListModel.class);
        this.setUserData2("TargetVRType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFIVRTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFIVRTypeCodeListModel");
    }
}

