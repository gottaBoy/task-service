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

@CodeList(id="018e61ebc4b04f41405c5e29d5356a42", name="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u6307\u5b9a\u5b9e\u4f53\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\uff08\u6307\u5b9a\u5b9e\u4f53\uff09\uff08\u9ed8\u8ba4\uff09", realtext="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\uff08\u6307\u5b9a\u5b9e\u4f53\uff09\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="1", text="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\uff08\u5168\u90e8\u975e\u5b50\u7cfb\u7edf\u5b9e\u4f53\uff09", realtext="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\uff08\u5168\u90e8\u975e\u5b50\u7cfb\u7edf\u5b9e\u4f53\uff09"), @CodeItem(value="2", text="\u5e73\u53f0\u9884\u7f6e\u670d\u52a1\u63a5\u53e3", realtext="\u5e73\u53f0\u9884\u7f6e\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="10", text="\u81ea\u5b9a\u4e49\u63a5\u53e3", realtext="\u81ea\u5b9a\u4e49\u63a5\u53e3")})
public class ServiceAPIModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SOMEDE = 0;
    public static final int INT_SOMEDE = 0;
    public static final Integer ALLDE = 1;
    public static final int INT_ALLDE = 1;
    public static final Integer PREDEFINED = 2;
    public static final int INT_PREDEFINED = 2;
    public static final Integer CUSTOM = 10;
    public static final int INT_CUSTOM = 10;

    public ServiceAPIModeCodeListModel() {
        this.initAnnotation(ServiceAPIModeCodeListModel.class);
        this.setUserData2("ServiceAPIMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceAPIModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceAPIModeCodeListModel");
    }
}

