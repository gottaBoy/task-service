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

@CodeList(id="98c3333c9b9bb1032f936e88fdb972e5", name="\u7cfb\u7edf\u5f15\u64ceBUG\u4fee\u590d", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u8868\u683c\u81ea\u5b9a\u4e49\u6570\u636e\u9879\u540d\u79f0", realtext="\u8868\u683c\u81ea\u5b9a\u4e49\u6570\u636e\u9879\u540d\u79f0", userdata="\u4fee\u590d\u8868\u683c\u6570\u636e\u9879\u540d\u79f0\u65e0\u6cd5\u6307\u5b9a\uff0c\u5fc5\u987b\u4e0e\u6570\u636e\u5217\u4e00\u81f4\u7684\u95ee\u9898"), @CodeItem(value="4", text="\u591a\u6570\u636e\u90e8\u4ef6\u5de5\u4f5c\u6d41\u6570\u636e\u9879", realtext="\u591a\u6570\u636e\u90e8\u4ef6\u5de5\u4f5c\u6d41\u6570\u636e\u9879", userdata="\u4fee\u590d\u591a\u6570\u636e\u90e8\u4ef6\u672a\u8f93\u51fa\u5de5\u4f5c\u6d41\u76f8\u5173\u6570\u636e\u9879\u7684\u95ee\u9898"), @CodeItem(value="2", text="\u8868\u683c\u5c5e\u6027\u5217\u6307\u5b9a\u6570\u636e\u9879", realtext="\u8868\u683c\u5c5e\u6027\u5217\u6307\u5b9a\u6570\u636e\u9879", userdata="\u4fee\u590d\u8868\u683c\u5c5e\u6027\u5217\u65e0\u6cd5\u6307\u5b9a\u6570\u636e\u9879\u95ee\u9898"), @CodeItem(value="8", text="Oracle\u65e5\u671f\u65f6\u95f4\u7c7b\u578b", realtext="Oracle\u65e5\u671f\u65f6\u95f4\u7c7b\u578b", userdata="\u4fee\u590dOracle\u3001PostgreSQL\u65e5\u671f\u7c7b\u578b\u4f7f\u7528DATE\u7c7b\u578b\u5bfc\u81f4\u7684\u7cbe\u5ea6\u95ee\u9898"), @CodeItem(value="16", text="\u5916\u952e\u6587\u672c\u5c5e\u6027\u754c\u9762\u7a7a\u8f93\u5165", realtext="\u5916\u952e\u6587\u672c\u5c5e\u6027\u754c\u9762\u7a7a\u8f93\u5165", userdata="\u4fee\u590d\u5916\u952e\u6587\u672c\u5c5e\u6027\u5728\u8868\u5355\u9879\u53ca\u8868\u683c\u7f16\u8f91\u9879\u672a\u4f7f\u7528\u5916\u952e\u503c\u5c5e\u6027\u5141\u8bb8\u4e3a\u7a7a\u903b\u8f91\u7684\u95ee\u9898"), @CodeItem(value="32", text="\u81ea\u586b\u6a21\u5f0f\u9ed8\u8ba4\u6570\u636e\u9879", realtext="\u81ea\u586b\u6a21\u5f0f\u9ed8\u8ba4\u6570\u636e\u9879", userdata="\u4fee\u590d\u81ea\u586b\u6a21\u5f0f\u65e0\u6cd5\u5b9a\u4e49\u9ed8\u8ba4\u6570\u636e\u9879\u7684\u95ee\u9898"), @CodeItem(value="64", text="\u5c5e\u6027\u641c\u7d22\u9879\u81ea\u5b9a\u4e49\u6807\u9898", realtext="\u5c5e\u6027\u641c\u7d22\u9879\u81ea\u5b9a\u4e49\u6807\u9898", userdata="\u4fee\u590d\u5c5e\u6027\u641c\u7d22\u9879\u81ea\u5b9a\u4e49\u6807\u9898\u65e0\u6548\u7684\u95ee\u9898"), @CodeItem(value="128", text="V2\u6a21\u578b\u8fd0\u884c\u65f6\u6a21\u5f0f", realtext="V2\u6a21\u578b\u8fd0\u884c\u65f6\u6a21\u5f0f"), @CodeItem(value="256", text="\u670d\u52a1\u63a5\u53e3\u6a21\u578b\u589e\u5f3a", realtext="\u670d\u52a1\u63a5\u53e3\u6a21\u578b\u589e\u5f3a", userdata="\u589e\u5f3a\u670d\u52a1\u63a5\u53e3\u6a21\u578b\u63a7\u5236\uff0c\u5305\u62ec\u4e86\u65e0\u9ed8\u8ba4\u4ee3\u7801\u6807\u8bc6\uff0c\u884c\u4e3a\u9ed8\u8ba4\u8bf7\u6c42\u6a21\u5f0f\u7b49"), @CodeItem(value="512", text="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u6a21\u578b\u589e\u5f3a", realtext="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u6a21\u578b\u589e\u5f3a", userdata="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u589e\u5f3a\uff0cIN\uff0cNOTIN\uff0cEXISTS\uff0cNOTEXISTS \u9ed8\u8ba4\u4f7f\u7528\u6570\u7ec4\u4f20\u9012"), @CodeItem(value="1024", text="\u754c\u9762\u6a21\u578b\u589e\u5f3a", realtext="\u754c\u9762\u6a21\u578b\u589e\u5f3a", userdata="\u754c\u9762\u6a21\u578b\u589e\u5f3a\uff0c\u9762\u5411DSL\u8fd0\u884c\u65f6\u8fdb\u884c\u589e\u5f3a"), @CodeItem(value="2048", text="\u4ee3\u7801\u540d\u9996\u5b57\u6bcd\u81ea\u52a8\u5927\u5199", realtext="\u4ee3\u7801\u540d\u9996\u5b57\u6bcd\u81ea\u52a8\u5927\u5199", userdata="\u4ee3\u7801\u540d\u9996\u5b57\u6bcd\u5927\u5199"), @CodeItem(value="8192", text="\u5b9e\u4f53\u4fdd\u5b58\u884c\u4e3a\u6a21\u578b\u589e\u5f3a", realtext="\u5b9e\u4f53\u4fdd\u5b58\u884c\u4e3a\u6a21\u578b\u589e\u5f3a", userdata="\u5b9e\u4f53\u4fdd\u5b58\u884c\u4e3a\u589e\u5f3a\n\uff081\uff09\u65b0\u7684\u884c\u4e3a\u6a21\u5f0f\uff08SAVE\uff09\n\uff082\uff09\u9ed8\u8ba4\u64cd\u4f5c\u6807\u8bc6\uff08CREATE\uff09"), @CodeItem(value="16384", text="\u5b9e\u4f53\u7ee7\u627f\u6a21\u578b\u589e\u5f3a", realtext="\u5b9e\u4f53\u7ee7\u627f\u6a21\u578b\u589e\u5f3a", userdata="\u5b9e\u4f53\u7ee7\u627f\u6a21\u578b\u589e\u5f3a\n\uff081\uff09\u7ee7\u627f\u884c\u4e3a\u4e0d\u518d\u9ed8\u8ba4\u542f\u7528\u5168\u5c40\u4e8b\u52a1"), @CodeItem(value="32768", text="\u5b9e\u4f53\u83b7\u53d6\u8349\u7a3f\u884c\u4e3a\u6a21\u578b\u589e\u5f3a", realtext="\u5b9e\u4f53\u83b7\u53d6\u8349\u7a3f\u884c\u4e3a\u6a21\u578b\u589e\u5f3a", userdata="\u5b9e\u4f53\u83b7\u53d6\u8349\u7a3f\u884c\u4e3a\u589e\u5f3a\n\uff081\uff09\u65b0\u7684\u884c\u4e3a\u6a21\u5f0f\uff08GETDRAFTFROM\uff09")})
public class EngineBugFixCodeListModel
extends StaticCodeListModelBase {
    public static final Integer GRIDDATAITEMNAME = 1;
    public static final int INT_GRIDDATAITEMNAME = 1;
    public static final Integer MDCTRLWFDATAITEMS = 4;
    public static final int INT_MDCTRLWFDATAITEMS = 4;
    public static final Integer GRIDCOLDATAITEM = 2;
    public static final int INT_GRIDCOLDATAITEM = 2;
    public static final Integer ORACLEDATETIME = 8;
    public static final int INT_ORACLEDATETIME = 8;
    public static final Integer PICKUPTEXTALLOWEMPTY = 16;
    public static final int INT_PICKUPTEXTALLOWEMPTY = 16;
    public static final Integer ACMODEITEM = 32;
    public static final int INT_ACMODEITEM = 32;
    public static final Integer DEFSFITEMCAPTION = 64;
    public static final int INT_DEFSFITEMCAPTION = 64;
    public static final Integer V2MODELRT = 128;
    public static final int INT_V2MODELRT = 128;
    public static final Integer SERVICEAPIMODELEX = 256;
    public static final int INT_SERVICEAPIMODELEX = 256;
    public static final Integer DEFSEARCHMODEMODELEX = 512;
    public static final int INT_DEFSEARCHMODEMODELEX = 512;
    public static final Integer UIMODELEX = 1024;
    public static final int INT_UIMODELEX = 1024;
    public static final Integer CODENAMECAPITALIZE = 2048;
    public static final int INT_CODENAMECAPITALIZE = 2048;
    public static final Integer DESAVEACTIONMODELEX = 8192;
    public static final int INT_DESAVEACTIONMODELEX = 8192;
    public static final Integer DEINHERITMODELEX = 16384;
    public static final int INT_DEINHERITMODELEX = 16384;
    public static final Integer DEGETDRAFTACTIONMODELEX = 32768;
    public static final int INT_DEGETDRAFTACTIONMODELEX = 32768;

    public EngineBugFixCodeListModel() {
        this.initAnnotation(EngineBugFixCodeListModel.class);
        this.setUserData2("EngineBugFix");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EngineBugFixCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EngineBugFixCodeListModel");
    }
}

