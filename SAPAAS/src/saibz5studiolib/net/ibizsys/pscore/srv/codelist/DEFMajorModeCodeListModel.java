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

@CodeList(id="29C6E017-FECA-4477-A980-AF068B6AB859", name="\u5b9e\u4f53\u5c5e\u6027\u4e3b\u4fe1\u606f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5426", realtext="\u5426"), @CodeItem(value="1", text="\u4e3b\u4fe1\u606f", realtext="\u4e3b\u4fe1\u606f", userdata="\u6570\u636e\u7684\u4e3b\u4fe1\u606f"), @CodeItem(value="2", text="\u952e\u540d", realtext="\u952e\u540d")})
public class DEFMajorModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer MAJOR = 1;
    public static final int INT_MAJOR = 1;
    public static final Integer KEYNAME = 2;
    public static final int INT_KEYNAME = 2;

    public DEFMajorModeCodeListModel() {
        this.initAnnotation(DEFMajorModeCodeListModel.class);
        this.setUserData2("FieldMajorMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFMajorModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFMajorModeCodeListModel");
    }
}

