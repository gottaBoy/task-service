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

@CodeList(id="e15b807e0b27a53bc4935829bd7bbb53", name="\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u63a7\u5236", realtext="\u65e0\u63a7\u5236", userdata="\u5b9e\u4f53\u6ca1\u6709\u542f\u7528\u8bbf\u95ee\u63a7\u5236"), @CodeItem(value="1", text="\u81ea\u63a7\u5236", realtext="\u81ea\u63a7\u5236", userdata="\u5b9e\u4f53\u4f7f\u7528\u81ea\u8eab\u5b9a\u4e49\u7684\u8bbf\u95ee\u63a7\u5236\u7b56\u7565\uff0c\u5373\u9700\u8981\u5728\u6743\u9650\u4f53\u7cfb\u4e2d\u663e\u5f0f\u5b9a\u4e49\u8be5\u5b9e\u4f53\u7684\u8bbf\u95ee\u6388\u6743"), @CodeItem(value="2", text="\u9644\u5c5e\u4e3b\u5b9e\u4f53\u63a7\u5236", realtext="\u9644\u5c5e\u4e3b\u5b9e\u4f53\u63a7\u5236", userdata="\u5b9e\u4f53\u76f8\u5173\u7684\u64cd\u4f5c\u6807\u8bc6\u5c06\u88ab\u6620\u5c04\u5230\u7236\u5b9e\u4f53\u76f8\u5e94\u7684\u64cd\u4f5c\u6807\u8bc6\uff0c\u5bf9\u5f53\u524d\u5b9e\u4f53\u7684\u8bbf\u95ee\u63a7\u5236\u5c06\u8f6c\u5316\u4e3a\u7236\u5b9e\u4f53\u7684\u8bbf\u95ee\u63a7\u5236"), @CodeItem(value="3", text="\u9644\u5c5e\u4e3b\u5b9e\u4f53\u63a7\u5236\uff08\u672a\u6620\u5c04\u81ea\u63a7\uff09", realtext="\u9644\u5c5e\u4e3b\u5b9e\u4f53\u63a7\u5236\uff08\u672a\u6620\u5c04\u81ea\u63a7\uff09", userdata="\u5b9e\u4f53\u76f8\u5173\u7684\u64cd\u4f5c\u6807\u8bc6\u5c06\u88ab\u6620\u5c04\u5230\u7236\u5b9e\u4f53\u76f8\u5e94\u7684\u64cd\u4f5c\u6807\u8bc6\uff0c\u672a\u88ab\u6620\u5c04\u7684\u6807\u8bc6\u5c06\u4f7f\u7528\u81ea\u8eab\u7684\u8bbf\u95ee\u63a7\u5236\u7b56\u7565")})
public class DEDataAccCtrlModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SELF = 1;
    public static final int INT_SELF = 1;
    public static final Integer MASTER = 2;
    public static final int INT_MASTER = 2;
    public static final Integer MASTER_SELF = 3;
    public static final int INT_MASTER_SELF = 3;

    public DEDataAccCtrlModeCodeListModel() {
        this.initAnnotation(DEDataAccCtrlModeCodeListModel.class);
        this.setUserData2("DEDataAccCtrlMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataAccCtrlModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataAccCtrlModeCodeListModel");
    }
}

