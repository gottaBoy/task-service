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

@CodeList(id="147f2dc6dff031d74974832b3413d003", name="\u5907\u4efd\u94fe\u63a5\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u94fe\u63a5", realtext="\u672a\u94fe\u63a5"), @CodeItem(value="30", text="\u5df2\u94fe\u63a5", realtext="\u5df2\u94fe\u63a5"), @CodeItem(value="40", text="\u94fe\u63a5\u672a\u6388\u6743", realtext="\u94fe\u63a5\u672a\u6388\u6743"), @CodeItem(value="41", text="\u94fe\u63a5\u5df2\u5931\u6548", realtext="\u94fe\u63a5\u5df2\u5931\u6548"), @CodeItem(value="42", text="\u6e90\u5907\u4efd\u5df2\u5220\u9664", realtext="\u6e90\u5907\u4efd\u5df2\u5220\u9664"), @CodeItem(value="43", text="\u76ee\u6807\u5907\u4efd\u5df2\u5220\u9664", realtext="\u76ee\u6807\u5907\u4efd\u5df2\u5220\u9664")})
public class DevSlnSysBakLinkStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTLINK = 10;
    public static final int INT_NOTLINK = 10;
    public static final Integer LINKED = 30;
    public static final int INT_LINKED = 30;
    public static final Integer UNAUTHORIZED = 40;
    public static final int INT_UNAUTHORIZED = 40;
    public static final Integer EXPIRED = 41;
    public static final int INT_EXPIRED = 41;
    public static final Integer SRCREMOVED = 42;
    public static final int INT_SRCREMOVED = 42;
    public static final Integer DSTREMOVED = 43;
    public static final int INT_DSTREMOVED = 43;

    public DevSlnSysBakLinkStateCodeListModel() {
        this.initAnnotation(DevSlnSysBakLinkStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysBakLinkStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnSysBakLinkStateCodeListModel");
    }
}

