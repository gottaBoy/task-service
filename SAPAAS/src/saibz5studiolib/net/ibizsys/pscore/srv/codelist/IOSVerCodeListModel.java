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

@CodeList(id="106d0859aecf1c86116148426f9ac2c2", name="IOS\u7248\u672c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="I0700", text="7.0\u4ee5\u4e0a", realtext="7.0\u4ee5\u4e0a"), @CodeItem(value="I0800", text="8.0\u4ee5\u4e0a", realtext="8.0\u4ee5\u4e0a"), @CodeItem(value="I0900", text="9.0\u4ee5\u4e0a", realtext="9.0\u4ee5\u4e0a")})
public class IOSVerCodeListModel
extends StaticCodeListModelBase {
    public static final String I0700 = "I0700";
    public static final String I0800 = "I0800";
    public static final String I0900 = "I0900";

    public IOSVerCodeListModel() {
        this.initAnnotation(IOSVerCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.IOSVerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.IOSVerCodeListModel");
    }
}

