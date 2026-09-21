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

@CodeList(id="04d48e29a58a05068b31bf0c7f8ef89c", name="\u5fae\u4fe1\u83dc\u5355\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="click", text="\u70b9\u51fb\u63a8\u4e8b\u4ef6", realtext="\u70b9\u51fb\u63a8\u4e8b\u4ef6"), @CodeItem(value="view", text="\u8df3\u8f6cURL", realtext="\u8df3\u8f6cURL"), @CodeItem(value="scancode_push", text="\u626b\u7801\u63a8\u4e8b\u4ef6", realtext="\u626b\u7801\u63a8\u4e8b\u4ef6"), @CodeItem(value="scancode_waitmsg", text="\u626b\u7801\u63a8\u4e8b\u4ef6\uff08\u4e14\u5f39\u51fa\u201c\u6d88\u606f\u63a5\u6536\u4e2d\u201d\u63d0\u793a\u6846\uff09", realtext="\u626b\u7801\u63a8\u4e8b\u4ef6\uff08\u4e14\u5f39\u51fa\u201c\u6d88\u606f\u63a5\u6536\u4e2d\u201d\u63d0\u793a\u6846\uff09"), @CodeItem(value="pic_sysphoto", text="\u5f39\u51fa\u7cfb\u7edf\u62cd\u7167\u53d1\u56fe", realtext="\u5f39\u51fa\u7cfb\u7edf\u62cd\u7167\u53d1\u56fe"), @CodeItem(value="pic_photo_or_album", text="\u5f39\u51fa\u62cd\u7167\u6216\u8005\u76f8\u518c\u53d1\u56fe", realtext="\u5f39\u51fa\u62cd\u7167\u6216\u8005\u76f8\u518c\u53d1\u56fe"), @CodeItem(value="pic_weixin", text="\u5f39\u51fa\u4f01\u4e1a\u5fae\u4fe1\u76f8\u518c\u53d1\u56fe\u5668", realtext="\u5f39\u51fa\u4f01\u4e1a\u5fae\u4fe1\u76f8\u518c\u53d1\u56fe\u5668"), @CodeItem(value="location_select", text="\u5f39\u51fa\u5730\u7406\u4f4d\u7f6e\u9009\u62e9\u5668", realtext="\u5f39\u51fa\u5730\u7406\u4f4d\u7f6e\u9009\u62e9\u5668")})
public class WXMenuFuncTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CLICK = "click";
    public static final String VIEW = "view";
    public static final String SCANCODE_PUSH = "scancode_push";
    public static final String SCANCODE_WAITMSG = "scancode_waitmsg";
    public static final String PIC_SYSPHOTO = "pic_sysphoto";
    public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    public static final String PIC_WEIXIN = "pic_weixin";
    public static final String LOCATION_SELECT = "location_select";

    public WXMenuFuncTypeCodeListModel() {
        this.initAnnotation(WXMenuFuncTypeCodeListModel.class);
        this.setUserData2("WXMenuFuncType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WXMenuFuncTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WXMenuFuncTypeCodeListModel");
    }
}

