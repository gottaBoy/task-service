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

@CodeList(id="9e3d6ffc3fdd30061d0209572b64bd3d", name="\u5b9e\u4f53SaaS\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u6807\u51c6SaaS\u6784\u578b", realtext="\u6807\u51c6SaaS\u6784\u578b", userdata="\u6807\u51c6SaaS\u6784\u578b\u5c06\u81ea\u52a8\u8c03\u6574\u6570\u636e\u7ed3\u6784\uff0c\uff081\uff09\u6dfb\u52a0\u81ea\u589e\u5217\u4f5c\u4e3a\u4e3b\u952e\uff0c\u7528\u6237\u4e3b\u952e\u8c03\u6574\u4e3a\u666e\u901a\u5217\uff1b\uff082\uff09\u6dfb\u52a0\u79df\u6237\u5217\uff1b\uff083\uff09\u5b9e\u4f53\u67e5\u8be2SQL\u6dfb\u52a0\u79df\u6237\u6761\u4ef6"), @CodeItem(value="2", text="\u6807\u51c6SaaS\u6784\u578b2", realtext="\u6807\u51c6SaaS\u6784\u578b2", userdata="\u6807\u51c6SaaS\u6784\u578b2\u5c06\u81ea\u52a8\u8c03\u6574\u6570\u636e\u7ed3\u6784\uff0c\uff081\uff09\u6dfb\u52a0\u81ea\u589e\u5217\u4f5c\u4e3a\u4e3b\u952e\uff0c\u7528\u6237\u4e3b\u952e\u8c03\u6574\u4e3a\u666e\u901a\u5217\uff1b\uff082\uff09\u6dfb\u52a0\u79df\u6237\u5217\uff1b\u4e0e\u6807\u51c6\u6784\u578b\u7684\u5dee\u522b\u4e3a\u53d1\u5e03\u7684SQL\u4e3a\u65e0\u79df\u6237\u76f8\u5173\u6027"), @CodeItem(value="3", text="\u6807\u51c6SaaS\u6784\u578b3", realtext="\u6807\u51c6SaaS\u6784\u578b3", userdata="\u6807\u51c6SaaS\u6784\u578b3\u5c06\u81ea\u52a8\u8c03\u6574\u6570\u636e\u7ed3\u6784\uff0c\uff081\uff09\u6dfb\u52a0\u79df\u6237\u5217\uff1b\uff082\uff09\u5b9e\u4f53\u67e5\u8be2SQL\u6dfb\u52a0\u79df\u6237\u6761\u4ef6"), @CodeItem(value="4", text="\u6807\u51c6SaaS\u6784\u578b4", realtext="\u6807\u51c6SaaS\u6784\u578b4", userdata="\u6807\u51c6SaaS\u6784\u578b4\u5c06\u81ea\u52a8\u8c03\u6574\u6570\u636e\u7ed3\u6784\uff0c\uff081\uff09\u6dfb\u52a0\u79df\u6237\u5217\uff1b\u4e0e\u6807\u51c6\u6784\u578b3\u7684\u5dee\u522b\u4e3a\u53d1\u5e03\u7684SQL\u4e3a\u65e0\u79df\u6237\u76f8\u5173\u6027")})
public class DESaaSModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer STANDARD = 1;
    public static final int INT_STANDARD = 1;
    public static final Integer STANDARD2 = 2;
    public static final int INT_STANDARD2 = 2;
    public static final Integer STANDARD3 = 3;
    public static final int INT_STANDARD3 = 3;
    public static final Integer STANDARD4 = 4;
    public static final int INT_STANDARD4 = 4;

    public DESaaSModeCodeListModel() {
        this.initAnnotation(DESaaSModeCodeListModel.class);
        this.setUserData2("DESaaSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESaaSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESaaSModeCodeListModel");
    }
}

