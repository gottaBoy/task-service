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

@CodeList(id="40049522-858B-42BB-8D71-B32DA5033F1C", name="\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u906e\u7f69\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="-1", text="\u81ea\u52a8\u5224\u65ad", realtext="\u81ea\u52a8\u5224\u65ad"), @CodeItem(value="0", text="\u4e0d\u663e\u793a", realtext="\u4e0d\u663e\u793a"), @CodeItem(value="1", text="\u65b0\u5efa\u6570\u636e\u65f6\u906e\u76d6", realtext="\u65b0\u5efa\u6570\u636e\u65f6\u906e\u76d6")})
public class FormDRUIPartMaskModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer AUTO = -1;
    public static final int INT_AUTO = -1;
    public static final Integer INVISIBLE = 0;
    public static final int INT_INVISIBLE = 0;
    public static final Integer NEWDATA = 1;
    public static final int INT_NEWDATA = 1;

    public FormDRUIPartMaskModeCodeListModel() {
        this.initAnnotation(FormDRUIPartMaskModeCodeListModel.class);
        this.setUserData2("FormDRUIPartMaskMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDRUIPartMaskModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDRUIPartMaskModeCodeListModel");
    }
}

