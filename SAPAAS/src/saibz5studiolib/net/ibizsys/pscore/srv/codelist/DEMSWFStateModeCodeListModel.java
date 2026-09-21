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

@CodeList(id="BE79ABE4-5AB1-469B-933B-52C5DEA14A73", name="\u5b9e\u4f53\u4e3b\u72b6\u6001\u6d41\u7a0b\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u6d41\u7a0b\u4e2d", realtext="\u6d41\u7a0b\u4e2d"), @CodeItem(value="2", text="\u6d41\u7a0b\u6b63\u5e38\u7ed3\u675f", realtext="\u6d41\u7a0b\u6b63\u5e38\u7ed3\u675f"), @CodeItem(value="3", text="\u6d41\u7a0b\u5f02\u5e38\u9000\u51fa", realtext="\u6d41\u7a0b\u5f02\u5e38\u9000\u51fa")})
public class DEMSWFStateModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer PROCESSING = 1;
    public static final int INT_PROCESSING = 1;
    public static final Integer FINISH = 2;
    public static final int INT_FINISH = 2;
    public static final Integer ERROR = 3;
    public static final int INT_ERROR = 3;

    public DEMSWFStateModeCodeListModel() {
        this.initAnnotation(DEMSWFStateModeCodeListModel.class);
        this.setUserData2("DEMSWFStateMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSWFStateModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSWFStateModeCodeListModel");
    }
}

