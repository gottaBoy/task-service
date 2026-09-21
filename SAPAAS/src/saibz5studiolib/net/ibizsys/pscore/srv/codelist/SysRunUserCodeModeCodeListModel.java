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

@CodeList(id="852097EB-19F8-4ABF-86CC-1B8D8A268A59", name="\u7cfb\u7edf\u8fd0\u884c\u7528\u6237\u4ee3\u7801\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u8054\u5408", realtext="\u4e0d\u8054\u5408"), @CodeItem(value="1", text="\u4ec5\u8054\u5408\u5e94\u7528\u4ee3\u7801", realtext="\u4ec5\u8054\u5408\u5e94\u7528\u4ee3\u7801"), @CodeItem(value="2", text="\u4ec5\u8054\u5408\u670d\u52a1\u4ee3\u7801", realtext="\u4ec5\u8054\u5408\u670d\u52a1\u4ee3\u7801"), @CodeItem(value="255", text="\u5168\u90e8\u8054\u5408", realtext="\u5168\u90e8\u8054\u5408")})
public class SysRunUserCodeModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ITEM_0 = 0;
    public static final int INT_ITEM_0 = 0;
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;
    public static final Integer ITEM_255 = 255;
    public static final int INT_ITEM_255 = 255;

    public SysRunUserCodeModeCodeListModel() {
        this.initAnnotation(SysRunUserCodeModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunUserCodeModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunUserCodeModeCodeListModel");
    }
}

