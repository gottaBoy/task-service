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

@CodeList(id="07A1C268-A168-4C74-AD16-D896AA2074FB", name="\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5185\u90e8\u903b\u8f91", realtext="\u5185\u90e8\u903b\u8f91", userdata="\u9644\u52a0\u6765\u81ea\u5f53\u524d\u5b9e\u4f53\u7684\u5904\u7406\u903b\u8f91"), @CodeItem(value="0", text="\u5916\u90e8\u903b\u8f91", realtext="\u5916\u90e8\u903b\u8f91", userdata="\u9644\u52a0\u6765\u81ea\u6307\u5b9a\u5b9e\u4f53\u7684\u884c\u4e3a"), @CodeItem(value="2", text="\u811a\u672c\u4ee3\u7801", realtext="\u811a\u672c\u4ee3\u7801", userdata="\u9644\u52a0\u81ea\u5b9a\u4e49\u7684\u811a\u672c\u4ee3\u7801"), @CodeItem(value="3", text="\u5b9e\u4f53\u901a\u77e5", realtext="\u5b9e\u4f53\u901a\u77e5", userdata="\u9644\u52a0\u5f53\u524d\u5b9e\u4f53\u7684\u901a\u77e5\u903b\u8f91"), @CodeItem(value="4", text="\u586b\u5145\u5b9e\u4f53\u4e3b\u72b6\u6001", realtext="\u586b\u5145\u5b9e\u4f53\u4e3b\u72b6\u6001", userdata="\u586b\u5145\u5f53\u524d\u5b9e\u4f53\u7684\u4e3b\u72b6\u6001\uff0c\u5305\u62ec\u72b6\u6001\u63a7\u5236\u5c5e\u6027\u53ca\u76f8\u5173\u5c5e\u6027\u8bbe\u7f6e"), @CodeItem(value="5", text="\u5b9e\u4f53\u6570\u636e\u540c\u6b65", realtext="\u5b9e\u4f53\u6570\u636e\u540c\u6b65", userdata="\u9644\u52a0\u5f53\u524d\u5b9e\u4f53\u7684\u6570\u636e\u540c\u6b65\u903b\u8f91"), @CodeItem(value="6", text="\u76ee\u6807\u6570\u636e\u64cd\u4f5c\uff08\u6307\u5b9a\u4e3b\u5173\u7cfb\uff09", realtext="\u76ee\u6807\u6570\u636e\u64cd\u4f5c\uff08\u6307\u5b9a\u4e3b\u5173\u7cfb\uff09", userdata="\u5bf9\u6307\u5b9a\u4e3b\u5173\u7cfb\u7684\u76ee\u6807\u6570\u636e\u8fdb\u884c\u64cd\u4f5c"), @CodeItem(value="7", text="\u76ee\u6807\u6570\u636e\u64cd\u4f5c\uff08\u6307\u5b9a\u6570\u636e\u96c6\uff09", realtext="\u76ee\u6807\u6570\u636e\u64cd\u4f5c\uff08\u6307\u5b9a\u6570\u636e\u96c6\uff09", userdata="\u5bf9\u6307\u5b9a\u6570\u636e\u96c6\u7684\u76ee\u6807\u6570\u636e\u8fdb\u884c\u64cd\u4f5c"), @CodeItem(value="8", text="\u7cfb\u7edf\u9884\u7f6e\u903b\u8f91", realtext="\u7cfb\u7edf\u9884\u7f6e\u903b\u8f91", userdata="\u9644\u52a0\u7cfb\u7edf\u9884\u7f6e\u903b\u8f91"), @CodeItem(value="9", text="\u5c5e\u6027\u503c\u8f6c\u6362", realtext="\u5c5e\u6027\u503c\u8f6c\u6362", userdata="\u9644\u52a0\u7cfb\u7edf\u503c\u8f6c\u6362\u903b\u8f91"), @CodeItem(value="10", text="\u5c5e\u6027\u503c\u5e8f\u5217\u586b\u5145", realtext="\u5c5e\u6027\u503c\u5e8f\u5217\u586b\u5145", userdata="\u9644\u52a0\u7cfb\u7edf\u503c\u5e8f\u5217\u903b\u8f91"), @CodeItem(value="11", text="\u76ee\u6807\u5b9e\u4f53\u903b\u8f91", realtext="\u76ee\u6807\u5b9e\u4f53\u903b\u8f91", userdata="\u89e6\u53d1\u6307\u5b9a\u7684\u76ee\u6807\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="50", text="\u68c0\u67e5\u5c5e\u6027\u503c\u89c4\u5219", realtext="\u68c0\u67e5\u5c5e\u6027\u503c\u89c4\u5219", userdata="\u5bf9\u6307\u5b9a\u503c\u89c4\u5219\u8fdb\u884c\u6821\u9a8c"), @CodeItem(value="51", text="\u68c0\u67e5\u6570\u636e\u4e3b\u72b6\u6001\uff08\u5904\u4e8e\uff09", realtext="\u68c0\u67e5\u6570\u636e\u4e3b\u72b6\u6001\uff08\u5904\u4e8e\uff09", userdata="\u68c0\u67e5\u6570\u636e\u662f\u5426\u5904\u5728\u6307\u5b9a\u6570\u636e\u4e3b\u72b6\u6001"), @CodeItem(value="52", text="\u68c0\u67e5\u6570\u636e\u4e3b\u72b6\u6001\uff08\u4e0d\u5904\u4e8e\uff09", realtext="\u68c0\u67e5\u6570\u636e\u4e3b\u72b6\u6001\uff08\u4e0d\u5904\u4e8e\uff09", userdata="\u68c0\u67e5\u6570\u636e\u662f\u5426\u4e0d\u5904\u4e8e\u6307\u5b9a\u6570\u636e\u4e3b\u72b6\u6001"), @CodeItem(value="53", text="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u5b58\u5728\uff08\u6307\u5b9a\u4e3b\u5173\u7cfb\uff09", realtext="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u5b58\u5728\uff08\u6307\u5b9a\u4e3b\u5173\u7cfb\uff09", userdata="\u68c0\u67e5\u6307\u5b9a\u4e3b\u5173\u7cfb\u7684\u76ee\u6807\u6570\u636e\u5b58\u5728"), @CodeItem(value="54", text="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u4e0d\u5b58\u5728\uff08\u6307\u5b9a\u4e3b\u5173\u7cfb\uff09", realtext="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u4e0d\u5b58\u5728\uff08\u6307\u5b9a\u4e3b\u5173\u7cfb\uff09", userdata="\u68c0\u67e5\u6307\u5b9a\u4e3b\u5173\u7cfb\u7684\u76ee\u6807\u6570\u636e\u4e0d\u5b58\u5728"), @CodeItem(value="55", text="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u5b58\u5728\uff08\u6307\u5b9a\u6570\u636e\u96c6\uff09", realtext="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u5b58\u5728\uff08\u6307\u5b9a\u6570\u636e\u96c6\uff09", userdata="\u68c0\u67e5\u6307\u5b9a\u6570\u636e\u96c6\u7684\u76ee\u6807\u6570\u636e\u5b58\u5728"), @CodeItem(value="56", text="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u4e0d\u5b58\u5728\uff08\u6307\u5b9a\u6570\u636e\u96c6\uff09", realtext="\u68c0\u67e5\u76ee\u6807\u6570\u636e\u4e0d\u5b58\u5728\uff08\u6307\u5b9a\u6570\u636e\u96c6\uff09", userdata="\u68c0\u67e5\u6307\u5b9a\u6570\u636e\u96c6\u7684\u76ee\u6807\u6570\u636e\u4e0d\u5b58\u5728")})
public class DEActionLogicTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer INTERNAL = 1;
    public static final int INT_INTERNAL = 1;
    public static final Integer EXTERNAL = 0;
    public static final int INT_EXTERNAL = 0;
    public static final Integer SCRIPT = 2;
    public static final int INT_SCRIPT = 2;
    public static final Integer NOTIFY = 3;
    public static final int INT_NOTIFY = 3;
    public static final Integer FILLMAINSTATE = 4;
    public static final int INT_FILLMAINSTATE = 4;
    public static final Integer DATASYNC = 5;
    public static final int INT_DATASYNC = 5;
    public static final Integer DSTDATAACTION = 6;
    public static final int INT_DSTDATAACTION = 6;
    public static final Integer DSTDATAACTION2 = 7;
    public static final int INT_DSTDATAACTION2 = 7;
    public static final Integer SYSLOGIC = 8;
    public static final int INT_SYSLOGIC = 8;
    public static final Integer SYSTRANSLATOR = 9;
    public static final int INT_SYSTRANSLATOR = 9;
    public static final Integer SYSSEQUENCE = 10;
    public static final int INT_SYSSEQUENCE = 10;
    public static final Integer DSTDELOGIC = 11;
    public static final int INT_DSTDELOGIC = 11;
    public static final Integer CHECKDEFVALUERULE = 50;
    public static final int INT_CHECKDEFVALUERULE = 50;
    public static final Integer CHECKMAINSTATE = 51;
    public static final int INT_CHECKMAINSTATE = 51;
    public static final Integer CHECKNOTMAINSTATE = 52;
    public static final int INT_CHECKNOTMAINSTATE = 52;
    public static final Integer CHECKDSTDATAEXISTS = 53;
    public static final int INT_CHECKDSTDATAEXISTS = 53;
    public static final Integer CHECKDSTDATANOTEXISTS = 54;
    public static final int INT_CHECKDSTDATANOTEXISTS = 54;
    public static final Integer CHECKDSTDATAEXISTS2 = 55;
    public static final int INT_CHECKDSTDATAEXISTS2 = 55;
    public static final Integer CHECKDSTDATANOTEXISTS2 = 56;
    public static final int INT_CHECKDSTDATANOTEXISTS2 = 56;

    public DEActionLogicTypeCodeListModel() {
        this.initAnnotation(DEActionLogicTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEActionLogicType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionLogicTypeCodeListModel");
    }
}

