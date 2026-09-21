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

@CodeList(id="fd1fbd9abee3bb458ded7098617ed3e6", name="\u4ea7\u54c1\u7248\u672c\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u8ba1\u5212\u4e2d", realtext="\u8ba1\u5212\u4e2d"), @CodeItem(value="20", text="\u5f00\u53d1\u4e2d", realtext="\u5f00\u53d1\u4e2d"), @CodeItem(value="22", text="\u6d4b\u8bd5\u4e2d", realtext="\u6d4b\u8bd5\u4e2d"), @CodeItem(value="30", text="\u5df2\u53d1\u5e03", realtext="\u5df2\u53d1\u5e03"), @CodeItem(value="40", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88"), @CodeItem(value="41", text="\u5df2\u5e9f\u5f03", realtext="\u5df2\u5e9f\u5f03")})
public class DevPrdSubVerStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PLANING = 10;
    public static final int INT_PLANING = 10;
    public static final Integer DEVELOPING = 20;
    public static final int INT_DEVELOPING = 20;
    public static final Integer TESTING = 22;
    public static final int INT_TESTING = 22;
    public static final Integer PUBLISHED = 30;
    public static final int INT_PUBLISHED = 30;
    public static final Integer CANCELLED = 40;
    public static final int INT_CANCELLED = 40;
    public static final Integer OBSOLETE = 41;
    public static final int INT_OBSOLETE = 41;

    public DevPrdSubVerStateCodeListModel() {
        this.initAnnotation(DevPrdSubVerStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSubVerStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSubVerStateCodeListModel");
    }
}

