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

@CodeList(id="bd1e6d479b122caa57dbaaa966a7286a", name="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u6838\u5fc3\u7ea7", realtext="\u6838\u5fc3\u7ea7", userdata="\u6838\u5fc3\u7ea7\u63a5\u53e3\u4e00\u822c\u90e8\u7f72\u5728\u4fe1\u4efb\u73af\u5883\uff0c\u4f9b\u5185\u90e8\u7a0b\u5e8f\u4f7f\u7528\uff0c\u53ef\u4ee5\u65e0\u6743\u9650\u63a7\u5236\u6216\u4f4e\u6743\u9650\u63a7\u5236"), @CodeItem(value="1", text="\u5e73\u53f0\u7ba1\u7406\u5458", realtext="\u5e73\u53f0\u7ba1\u7406\u5458", userdata="\u8fd0\u884c\u5e73\u53f0\u7ba1\u7406\u5458"), @CodeItem(value="2", text="\u673a\u6784\u7ba1\u7406\u5458", realtext="\u673a\u6784\u7ba1\u7406\u5458", userdata="\u673a\u6784\u7ba1\u7406\u5458\uff0c\u4e00\u822c\u6307\u79df\u6237\u7ba1\u7406\u5458\uff0c\u7ba1\u7406\u673a\u6784\u7684\u7ec4\u7ec7\u3001\u4eba\u5458\uff0c\u5305\u62ec\u7cfb\u7edf\u7684\u8bbf\u95ee\u6388\u6743\u7b49"), @CodeItem(value="3", text="\u7528\u6237\u7ea7", realtext="\u7528\u6237\u7ea7", userdata="\u7528\u6237\u7ea7\u63a5\u53e3\u9700\u63d0\u4f9b\u5b8c\u6574\u7684\u9274\u6743\u53ca\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb\uff0c\u5b89\u5168\u8981\u6c42\u9ad8"), @CodeItem(value="5", text="\u5f53\u524d\u7cfb\u7edf\u7528\u6237", realtext="\u5f53\u524d\u7cfb\u7edf\u7528\u6237", userdata="\u5982\u4f20\u5165\u8eab\u4efd\u975e\u5f53\u524d\u7cfb\u7edf\u7528\u6237\uff0c\u9700\u8981\u8f6c\u6362\u4e3a\u5f53\u524d\u7cfb\u7edf\u7528\u6237\u3002\u5176\u5b83\u540c\u7528\u6237\u7ea7\u63a5\u53e3"), @CodeItem(value="6", text="\u7cfb\u7edf\u63a5\u53e3\u7528\u6237", realtext="\u7cfb\u7edf\u63a5\u53e3\u7528\u6237", userdata="\u4f20\u5165\u8eab\u4efd\u9700\u8981\u662f\u7cfb\u7edf\u9884\u7f6e\u7684\u63a5\u53e3\u7528\u6237"), @CodeItem(value="4", text="\u533f\u540d\u7528\u6237", realtext="\u533f\u540d\u7528\u6237")})
public class APILevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CORE = 0;
    public static final int INT_CORE = 0;
    public static final Integer CLOUDADMIN = 1;
    public static final int INT_CLOUDADMIN = 1;
    public static final Integer DCADMIN = 2;
    public static final int INT_DCADMIN = 2;
    public static final Integer USER = 3;
    public static final int INT_USER = 3;
    public static final Integer CURSYSTEMUSER = 5;
    public static final int INT_CURSYSTEMUSER = 5;
    public static final Integer APIUSER = 6;
    public static final int INT_APIUSER = 6;
    public static final Integer ANONYMOUSUSER = 4;
    public static final int INT_ANONYMOUSUSER = 4;

    public APILevelCodeListModel() {
        this.initAnnotation(APILevelCodeListModel.class);
        this.setUserData2("ServiceAPILevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.APILevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.APILevelCodeListModel");
    }
}

