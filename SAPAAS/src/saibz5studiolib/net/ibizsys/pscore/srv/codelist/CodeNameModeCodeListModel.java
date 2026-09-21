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

@CodeList(id="2CF8064B-1A61-4945-A2D2-5757B2F43A24", name="\u4ee3\u7801\u6807\u8bc6\u683c\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LOWER_UNDERSCORE", text="\u5c0f\u5199\uff08\u4e0b\u5212\u7ebf\u5206\u9694\uff09", realtext="\u5c0f\u5199\uff08\u4e0b\u5212\u7ebf\u5206\u9694\uff09"), @CodeItem(value="UPPER_UNDERSCORE", text="\u5927\u5199\uff08\u4e0b\u5212\u7ebf\u5206\u9694\uff09", realtext="\u5927\u5199\uff08\u4e0b\u5212\u7ebf\u5206\u9694\uff09"), @CodeItem(value="LOWER_CAMEL", text="\u9a7c\u5cf0\uff08\u9996\u5b57\u6bcd\u5c0f\u5199\uff09", realtext="\u9a7c\u5cf0\uff08\u9996\u5b57\u6bcd\u5c0f\u5199\uff09"), @CodeItem(value="UPPER_CAMEL", text="\u9a7c\u5cf0\uff08\u9996\u5b57\u6bcd\u5927\u5199\uff09", realtext="\u9a7c\u5cf0\uff08\u9996\u5b57\u6bcd\u5927\u5199\uff09"), @CodeItem(value="LOWER", text="\u5c0f\u5199\uff08\u76f4\u63a5\uff0c\u4e0d\u505a\u8f6c\u6362\uff09", realtext="\u5c0f\u5199\uff08\u76f4\u63a5\uff0c\u4e0d\u505a\u8f6c\u6362\uff09"), @CodeItem(value="UPPER", text="\u5927\u5199\uff08\u76f4\u63a5\uff0c\u4e0d\u505a\u8f6c\u6362\uff09", realtext="\u5927\u5199\uff08\u76f4\u63a5\uff0c\u4e0d\u505a\u8f6c\u6362\uff09"), @CodeItem(value="LOWER_HYPHEN", text="\u5c0f\u5199\uff08\u4e2d\u5212\u7ebf\u5206\u9694\uff09", realtext="\u5c0f\u5199\uff08\u4e2d\u5212\u7ebf\u5206\u9694\uff09"), @CodeItem(value="NONE", text="\u65e0\u8f6c\u6362", realtext="\u65e0\u8f6c\u6362")})
public class CodeNameModeCodeListModel
extends StaticCodeListModelBase {
    public static final String LOWER_UNDERSCORE = "LOWER_UNDERSCORE";
    public static final String UPPER_UNDERSCORE = "UPPER_UNDERSCORE";
    public static final String LOWER_CAMEL = "LOWER_CAMEL";
    public static final String UPPER_CAMEL = "UPPER_CAMEL";
    public static final String LOWER = "LOWER";
    public static final String UPPER = "UPPER";
    public static final String LOWER_HYPHEN = "LOWER_HYPHEN";
    public static final String NONE = "NONE";

    public CodeNameModeCodeListModel() {
        this.initAnnotation(CodeNameModeCodeListModel.class);
        this.setUserData2("CodeNameMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeNameModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeNameModeCodeListModel");
    }
}

