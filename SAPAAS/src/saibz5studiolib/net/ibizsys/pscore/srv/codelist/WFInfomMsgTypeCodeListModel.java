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

@CodeList(id="82b95f464ed6a8ff7d23516ad8e4356f", name="\u901a\u77e5\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u7cfb\u7edf\u6d88\u606f", realtext="\u7cfb\u7edf\u6d88\u606f"), @CodeItem(value="2", text="\u7535\u5b50\u90ae\u4ef6", realtext="\u7535\u5b50\u90ae\u4ef6"), @CodeItem(value="4", text="\u624b\u673a\u77ed\u4fe1", realtext="\u624b\u673a\u77ed\u4fe1"), @CodeItem(value="8", text="MSN\u6d88\u606f", realtext="MSN\u6d88\u606f"), @CodeItem(value="16", text="\u5185\u90e8IM\u6d88\u606f", realtext="\u5185\u90e8IM\u6d88\u606f"), @CodeItem(value="32", text="\u5fae\u4fe1", realtext="\u5fae\u4fe1"), @CodeItem(value="64", text="\u9489\u9489", realtext="\u9489\u9489"), @CodeItem(value="128", text="\u4f01\u4e1a\u5fae\u4fe1", realtext="\u4f01\u4e1a\u5fae\u4fe1"), @CodeItem(value="256", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="512", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class WFInfomMsgTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer INTERNAL = 1;
    public static final int INT_INTERNAL = 1;
    public static final Integer EMAIL = 2;
    public static final int INT_EMAIL = 2;
    public static final Integer SMS = 4;
    public static final int INT_SMS = 4;
    public static final Integer MSN = 8;
    public static final int INT_MSN = 8;
    public static final Integer SAIM = 16;
    public static final int INT_SAIM = 16;
    public static final Integer WT = 32;
    public static final int INT_WT = 32;
    public static final Integer DT = 64;
    public static final int INT_DT = 64;
    public static final Integer ENTWT = 128;
    public static final int INT_ENTWT = 128;
    public static final Integer USER = 256;
    public static final int INT_USER = 256;
    public static final Integer USER2 = 512;
    public static final int INT_USER2 = 512;

    public WFInfomMsgTypeCodeListModel() {
        this.initAnnotation(WFInfomMsgTypeCodeListModel.class);
        this.setUserData2("InfomMsgType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFInfomMsgTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFInfomMsgTypeCodeListModel");
    }
}

