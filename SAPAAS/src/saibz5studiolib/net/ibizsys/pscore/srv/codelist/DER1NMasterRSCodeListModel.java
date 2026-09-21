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

@CodeList(id="b583bc322e0ad750cd834133613e04ec", name="\u5b9e\u4f531\uff1aN\u5173\u7cfb\u4e3b\u4ece\u5173\u7cfb\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u9644\u5c5e\u5173\u7cfb", realtext="\u9644\u5c5e\u5173\u7cfb", userdata="\u4ece\u5b9e\u4f53\u662f\u4e3b\u5b9e\u4f53\u7684\u9644\u5c5e\u5b9e\u4f53"), @CodeItem(value="2", text="\u9644\u5c5e\u5173\u7cfb(N:N\u8fde\u63a5)", realtext="\u9644\u5c5e\u5173\u7cfb(N:N\u8fde\u63a5)", userdata="\u4ece\u5b9e\u4f53\u662f\u4e3b\u5b9e\u4f53\u7684\u9644\u5c5e\u5b9e\u4f53\uff0c\u662fN:N\u5173\u7cfb\u7684\u4e00\u8fb9"), @CodeItem(value="4", text="\u6570\u636e\u8bbf\u95ee\u63a7\u5236", realtext="\u6570\u636e\u8bbf\u95ee\u63a7\u5236", userdata="\u4ece\u5b9e\u4f53\u7684\u64cd\u4f5c\u6807\u8bc6\u5c06\u6620\u5c04\u5230\u4e3b\u5b9e\u4f53\uff0c\u7531\u4e3b\u5b9e\u4f53\u8fdb\u884c\u8bbf\u95ee\u63a7\u5236"), @CodeItem(value="8", text="\u5d4c\u5957\u64cd\u4f5c", realtext="\u5d4c\u5957\u64cd\u4f5c", userdata="\u4ece\u5b9e\u4f53\u662f\u4e3b\u5b9e\u4f53\u7684\u5d4c\u5957\u6570\u636e\u6210\u5458"), @CodeItem(value="16", text="\u9012\u5f52\u5173\u7cfb", realtext="\u9012\u5f52\u5173\u7cfb", userdata="\u4ece\u5b9e\u4f53\u4e0e\u4e3b\u5b9e\u4f53\u662f\u9012\u5f52\u5173\u7cfb"), @CodeItem(value="32", text="\u5173\u8054\u901a\u77e5", realtext="\u5173\u8054\u901a\u77e5", userdata="\u4ece\u5b9e\u4f53\u89e6\u53d1\u7236\u5b9e\u4f53\u901a\u77e5"), @CodeItem(value="64", text="\u9644\u5c5e\u6269\u5c55", realtext="\u9644\u5c5e\u6269\u5c55"), @CodeItem(value="128", text="\u9650\u5b9a\u7248\u672c", realtext="\u9650\u5b9a\u7248\u672c"), @CodeItem(value="256", text="\u5f15\u7528\u68c0\u67e5", realtext="\u5f15\u7528\u68c0\u67e5"), @CodeItem(value="1024", text="\u7ee7\u627f\u6a21\u5f0f", realtext="\u7ee7\u627f\u6a21\u5f0f"), @CodeItem(value="1048576", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="2097152", text="\u81ea\u5b9a\u4e492", realtext="\u81ea\u5b9a\u4e492"), @CodeItem(value="4194304", text="\u81ea\u5b9a\u4e493", realtext="\u81ea\u5b9a\u4e493"), @CodeItem(value="8388608", text="\u81ea\u5b9a\u4e494", realtext="\u81ea\u5b9a\u4e494")})
public class DER1NMasterRSCodeListModel
extends StaticCodeListModelBase {
    public static final Integer RELATED = 1;
    public static final int INT_RELATED = 1;
    public static final Integer NN = 2;
    public static final int INT_NN = 2;
    public static final Integer DAC = 4;
    public static final int INT_DAC = 4;
    public static final Integer NESTED = 8;
    public static final int INT_NESTED = 8;
    public static final Integer RECURSIVE = 16;
    public static final int INT_RECURSIVE = 16;
    public static final Integer NOTIFY = 32;
    public static final int INT_NOTIFY = 32;
    public static final Integer EXTENSION = 64;
    public static final int INT_EXTENSION = 64;
    public static final Integer VERSION = 128;
    public static final int INT_VERSION = 128;
    public static final Integer REFCHECK = 256;
    public static final int INT_REFCHECK = 256;
    public static final Integer INHERIT = 1024;
    public static final int INT_INHERIT = 1024;
    public static final Integer USER = 0x100000;
    public static final int INT_USER = 0x100000;
    public static final Integer USER2 = 0x200000;
    public static final int INT_USER2 = 0x200000;
    public static final Integer USER3 = 0x400000;
    public static final int INT_USER3 = 0x400000;
    public static final Integer USER4 = 0x800000;
    public static final int INT_USER4 = 0x800000;

    public DER1NMasterRSCodeListModel() {
        this.initAnnotation(DER1NMasterRSCodeListModel.class);
        this.setUserData2("DER1NMasterRS");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DER1NMasterRSCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DER1NMasterRSCodeListModel");
    }
}

