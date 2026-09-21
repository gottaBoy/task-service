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

@CodeList(id="4e62aad33201c4ba93ca084504fad4cd", name="\u8868\u5355\u6210\u5458\u6a21\u578b\u72b6\u6001\uff08\u65e7\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u6709\u8b66\u544a", realtext="\u6709\u8b66\u544a"), @CodeItem(value="2", text="\u6709\u9519\u8bef", realtext="\u6709\u9519\u8bef"), @CodeItem(value="1024", text="\u6709\u52a8\u6001\u542f\u7528\u903b\u8f91", realtext="\u6709\u52a8\u6001\u542f\u7528\u903b\u8f91"), @CodeItem(value="2048", text="\u6709\u52a8\u6001\u663e\u793a\u903b\u8f91", realtext="\u6709\u52a8\u6001\u663e\u793a\u903b\u8f91"), @CodeItem(value="4096", text="\u6709\u52a8\u6001\u4e3a\u7a7a\u903b\u8f91", realtext="\u6709\u52a8\u6001\u4e3a\u7a7a\u903b\u8f91"), @CodeItem(value="8192", text="\u6709\u8868\u5355\u66f4\u65b0\u903b\u8f91", realtext="\u6709\u8868\u5355\u66f4\u65b0\u903b\u8f91"), @CodeItem(value="16384", text="\u542f\u7528\u6269\u5c55\u63a7\u5236\u903b\u8f91", realtext="\u542f\u7528\u6269\u5c55\u63a7\u5236\u903b\u8f91"), @CodeItem(value="32768", text="\u542f\u7528\u66f4\u65b0\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u66f4\u65b0\uff08\u6269\u5c55\uff09"), @CodeItem(value="65536", text="\u542f\u7528\u5220\u9664\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u5220\u9664\uff08\u6269\u5c55\uff09"), @CodeItem(value="131072", text="\u542f\u7528\u62d6\u52a8\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u62d6\u52a8\uff08\u6269\u5c55\uff09"), @CodeItem(value="262144", text="\u542f\u7528\u62d6\u5165\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u62d6\u5165\uff08\u6269\u5c55\uff09"), @CodeItem(value="524288", text="\u542f\u7528\u5360\u4f4d\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u5360\u4f4d\uff08\u6269\u5c55\uff09")})
public class DEFormDetailStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer WARNING = 1;
    public static final int INT_WARNING = 1;
    public static final Integer ERROR = 2;
    public static final int INT_ERROR = 2;
    public static final Integer ENABLELOGIC = 1024;
    public static final int INT_ENABLELOGIC = 1024;
    public static final Integer VISBLELOGIC = 2048;
    public static final int INT_VISBLELOGIC = 2048;
    public static final Integer EMPTYLOGIC = 4096;
    public static final int INT_EMPTYLOGIC = 4096;
    public static final Integer FIUPDATELOGIC = 8192;
    public static final int INT_FIUPDATELOGIC = 8192;
    public static final Integer ENABLEEXTENSION = 16384;
    public static final int INT_ENABLEEXTENSION = 16384;
    public static final Integer ENABLEUPDATE = 32768;
    public static final int INT_ENABLEUPDATE = 32768;
    public static final Integer ENABLEREMOVE = 65536;
    public static final int INT_ENABLEREMOVE = 65536;
    public static final Integer ENABLEDRAG = 131072;
    public static final int INT_ENABLEDRAG = 131072;
    public static final Integer ENABLEDROP = 262144;
    public static final int INT_ENABLEDROP = 262144;
    public static final Integer ENABLEPLACEHOLDER = 524288;
    public static final int INT_ENABLEPLACEHOLDER = 524288;

    public DEFormDetailStateCodeListModel() {
        this.initAnnotation(DEFormDetailStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFormDetailStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFormDetailStateCodeListModel");
    }
}

