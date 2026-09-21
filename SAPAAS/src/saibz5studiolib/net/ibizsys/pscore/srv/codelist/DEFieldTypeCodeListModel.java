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

@CodeList(id="83443fd2f73b27c4ddf8f854c1c58d65", name="\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u7269\u7406\u5b57\u6bb5[\u6765\u81ea\u5f53\u524d\u5b9e\u4f53\u7269\u7406\u8868\u5b57\u6bb5]", realtext="\u7269\u7406\u5b57\u6bb5[\u6765\u81ea\u5f53\u524d\u5b9e\u4f53\u7269\u7406\u8868\u5b57\u6bb5]", userdata="\u6765\u81ea\u5b9e\u4f53\u81ea\u8eab\u4e14\u5177\u5907\u6301\u4e45\u5316\u80fd\u529b\u7684\u5c5e\u6027\uff0c\u6301\u4e45\u5316\u80fd\u529b\u6765\u81ea\u5b9e\u4f53\u7684\u9ed8\u8ba4\u5b58\u50a8"), @CodeItem(value="2", text="\u903b\u8f91\u5b57\u6bb5[\u6765\u81ea\u8ba1\u7b97\u5f0f]", realtext="\u903b\u8f91\u5b57\u6bb5[\u6765\u81ea\u8ba1\u7b97\u5f0f]", userdata="\u901a\u8fc7\u5b9e\u4f53\u7684\u5176\u5b83\u5c5e\u6027\u8ba1\u7b97\u5408\u6210\u7684\u5c5e\u6027"), @CodeItem(value="3", text="\u94fe\u63a5\u5b57\u6bb5[\u6765\u81ea\u5173\u7cfb\u5b9e\u4f53\u5b57\u6bb5]", realtext="\u94fe\u63a5\u5b57\u6bb5[\u6765\u81ea\u5173\u7cfb\u5b9e\u4f53\u5b57\u6bb5]", userdata="\u5f15\u7528\u6765\u81ea\u5173\u7cfb\u5b9e\u4f53\u7684\u5c5e\u6027"), @CodeItem(value="4", text="\u6269\u5c55\u7269\u7406\u5b57\u6bb5[\u6765\u81ea\u52a8\u6001\u5b58\u50a8\u5b9e\u4f53\u7269\u7406\u8868\u5b57\u6bb5]", realtext="\u6269\u5c55\u7269\u7406\u5b57\u6bb5[\u6765\u81ea\u52a8\u6001\u5b58\u50a8\u5b9e\u4f53\u7269\u7406\u8868\u5b57\u6bb5]", userdata="\u6765\u81ea\u5b9e\u4f53\u81ea\u8eab\u4e14\u5177\u5907\u6301\u4e45\u5316\u80fd\u529b\u7684\u5c5e\u6027\uff0c\u6301\u4e45\u5316\u80fd\u529b\u6765\u81ea\u5916\u90e8\u7684\u52a8\u6001\u5b58\u50a8"), @CodeItem(value="5", text="\u5e94\u7528\u754c\u9762\u5b57\u6bb5[\u65e0\u5b58\u50a8]", realtext="\u5e94\u7528\u754c\u9762\u5b57\u6bb5[\u65e0\u5b58\u50a8]", userdata="\u7528\u4e8e\u8f85\u52a9\u754c\u9762\u5448\u73b0\uff0c\u65e0\u9ed8\u8ba4\u5904\u7406\u903b\u8f91")})
public class DEFieldTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PHISICAL = 1;
    public static final int INT_PHISICAL = 1;
    public static final Integer FORMULA = 2;
    public static final int INT_FORMULA = 2;
    public static final Integer LINK = 3;
    public static final int INT_LINK = 3;
    public static final Integer DYNASTORAGE = 4;
    public static final int INT_DYNASTORAGE = 4;
    public static final Integer UI = 5;
    public static final int INT_UI = 5;

    public DEFieldTypeCodeListModel() {
        this.initAnnotation(DEFieldTypeCodeListModel.class);
        this.setUserData2("DEFType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFieldTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFieldTypeCodeListModel");
    }
}

