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

@CodeList(id="100BF3CD-C085-4E18-BC81-330906738D4D", name="\u5b9e\u4f53\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528\uff08\u9ed8\u8ba4\uff09", realtext="\u542f\u7528\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="2", text="\u542f\u7528\uff08\u7cfb\u7edf\uff09", realtext="\u542f\u7528\uff08\u7cfb\u7edf\uff09", userdata="\u4f7f\u7528\u7cfb\u7edf\u5168\u5c40\u52a8\u6001\u6269\u5c55\uff0c\u9644\u5c5e\u5b9e\u4f53\u4f9d\u9644\u7236\u5b9e\u4f53"), @CodeItem(value="3", text="\u542f\u7528\uff08\u7cfb\u7edf\u6a21\u578b\u7ec4\uff09", realtext="\u542f\u7528\uff08\u7cfb\u7edf\u6a21\u578b\u7ec4\uff09", userdata="\u4f7f\u7528\u7cfb\u7edf\u6a21\u578b\u7ec4\u6269\u5c55\uff0c\u9644\u5c5e\u5b9e\u4f53\u4f9d\u9644\u7236\u5b9e\u4f53"), @CodeItem(value="4", text="\u542f\u7528\uff08\u7cfb\u7edf\u6a21\u5757\uff09", realtext="\u542f\u7528\uff08\u7cfb\u7edf\u6a21\u5757\uff09", userdata="\u4f7f\u7528\u7cfb\u7edf\u6a21\u5757\u6269\u5c55\uff0c\u9644\u5c5e\u5b9e\u4f53\u4f9d\u9644\u7236\u5b9e\u4f53"), @CodeItem(value="5", text="\u542f\u7528\uff08\u5b9e\u4f53\uff09", realtext="\u542f\u7528\uff08\u5b9e\u4f53\uff09", userdata="\u6bcf\u4e2a\u5b9e\u4f53\u63d0\u4f9b\u72ec\u7acb\u7684\u52a8\u6001\u7cfb\u7edf\u80fd\u529b\uff0c\u9644\u5c5e\u5b9e\u4f53\u4f9d\u9644\u7236\u5b9e\u4f53"), @CodeItem(value="99", text="\u542f\u7528\uff08\u884c\u6570\u636e\uff09", realtext="\u542f\u7528\uff08\u884c\u6570\u636e\uff09", userdata="\u4e3a\u884c\u6570\u636e\u63d0\u4f9b\u52a8\u6001\u7cfb\u7edf\u80fd\u529b\uff0c\u9644\u5c5e\u5b9e\u4f53\u4f9d\u9644\u7236\u6570\u636e")})
public class DEDynaSysModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;
    public static final Integer SYSTEM = 2;
    public static final int INT_SYSTEM = 2;
    public static final Integer MODELGROUP = 3;
    public static final int INT_MODELGROUP = 3;
    public static final Integer MODULE = 4;
    public static final int INT_MODULE = 4;
    public static final Integer DATAENTITY = 5;
    public static final int INT_DATAENTITY = 5;
    public static final Integer DATA = 99;
    public static final int INT_DATA = 99;

    public DEDynaSysModeCodeListModel() {
        this.initAnnotation(DEDynaSysModeCodeListModel.class);
        this.setUserData2("DEDynaSysMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDynaSysModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDynaSysModeCodeListModel");
    }
}

