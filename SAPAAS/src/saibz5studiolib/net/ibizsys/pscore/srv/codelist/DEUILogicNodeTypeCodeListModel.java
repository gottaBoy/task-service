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

@CodeList(id="A8724BD7-ABF2-421A-9ABA-A4CAE115EFC7", name="\u4e91\u5b9e\u4f53\u903b\u8f91\u5904\u7406\u8282\u70b9\u7c7b\u578b\uff08\u754c\u9762\u903b\u8f91\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BEGIN", text="\u5f00\u59cb", realtext="\u5f00\u59cb", iconpath="psdelntype/icon_beginprocess.png", iconpathx="psdelntype/icon_beginprocess@{0}x.png"), @CodeItem(value="PREPAREJSPARAM", text="\u51c6\u5907\u53c2\u6570", realtext="\u51c6\u5907\u53c2\u6570", iconpath="psdelntype/icon_prepareparam.png", iconpathx="psdelntype/icon_prepareparam@{0}x.png"), @CodeItem(value="RESETPARAM", text="\u91cd\u7f6e\u53c2\u6570", realtext="\u91cd\u7f6e\u53c2\u6570", userdata="\u91cd\u7f6e\u76ee\u6807\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="COPYPARAM", text="\u62f7\u8d1d\u53c2\u6570", realtext="\u62f7\u8d1d\u53c2\u6570", userdata="\u5c06\u6e90\u53c2\u6570\u5bf9\u8c61\u62f7\u8d1d\u81f3\u76ee\u6807\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="BINDPARAM", text="\u7ed1\u5b9a\u53c2\u6570", realtext="\u7ed1\u5b9a\u53c2\u6570", userdata="\u5904\u7406\u903b\u8f91\u53d8\u91cf\u7ed1\u5b9a\u6307\u5b9a\u53d8\u91cf"), @CodeItem(value="APPENDPARAM", text="\u9644\u52a0\u5230\u6570\u7ec4\u53c2\u6570", realtext="\u9644\u52a0\u5230\u6570\u7ec4\u53c2\u6570"), @CodeItem(value="SORTPARAM", text="\u6392\u5e8f\u6570\u7ec4\u53c2\u6570", realtext="\u6392\u5e8f\u6570\u7ec4\u53c2\u6570"), @CodeItem(value="RENEWPARAM", text="\u91cd\u65b0\u5efa\u7acb\u53c2\u6570", realtext="\u91cd\u65b0\u5efa\u7acb\u53c2\u6570"), @CodeItem(value="VIEWCTRLINVOKE", text="\u89c6\u56fe\u90e8\u4ef6\u8c03\u7528", realtext="\u89c6\u56fe\u90e8\u4ef6\u8c03\u7528", iconpath="psdelntype/icon_prepareparam.png", iconpathx="psdelntype/icon_prepareparam@{0}x.png"), @CodeItem(value="VIEWCTRLFIREEVENT", text="\u89c6\u56fe\u90e8\u4ef6\u4e8b\u4ef6\u89e6\u53d1", realtext="\u89c6\u56fe\u90e8\u4ef6\u4e8b\u4ef6\u89e6\u53d1"), @CodeItem(value="PFPLUGIN", text="\u524d\u7aef\u63d2\u4ef6", realtext="\u524d\u7aef\u63d2\u4ef6"), @CodeItem(value="MSGBOX", text="\u6d88\u606f\u5f39\u7a97", realtext="\u6d88\u606f\u5f39\u7a97"), @CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u6570\u636e\u96c6", realtext="\u5b9e\u4f53\u6570\u636e\u96c6"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u903b\u8f91", realtext="\u5b9e\u4f53\u903b\u8f91"), @CodeItem(value="DEUIACTION", text="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", realtext="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a"), @CodeItem(value="THROWEXCEPTION", text="\u629b\u51fa\u5f02\u5e38", realtext="\u629b\u51fa\u5f02\u5e38", iconpath="psdelntype/icon_throwexception.png", iconpathx="psdelntype/icon_throwexception@{0}x.png"), @CodeItem(value="DEBUGPARAM", text="\u8c03\u8bd5\u903b\u8f91\u53c2\u6570", realtext="\u8c03\u8bd5\u903b\u8f91\u53c2\u6570"), @CodeItem(value="DECISION", text="\u51b3\u7b56", realtext="\u51b3\u7b56"), @CodeItem(value="MEMO", text="\u5907\u6ce8", realtext="\u5907\u6ce8"), @CodeItem(value="END", text="\u7ed3\u675f", realtext="\u7ed3\u675f")})
public class DEUILogicNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String BEGIN = "BEGIN";
    public static final String PREPAREJSPARAM = "PREPAREJSPARAM";
    public static final String RESETPARAM = "RESETPARAM";
    public static final String COPYPARAM = "COPYPARAM";
    public static final String BINDPARAM = "BINDPARAM";
    public static final String APPENDPARAM = "APPENDPARAM";
    public static final String SORTPARAM = "SORTPARAM";
    public static final String RENEWPARAM = "RENEWPARAM";
    public static final String VIEWCTRLINVOKE = "VIEWCTRLINVOKE";
    public static final String VIEWCTRLFIREEVENT = "VIEWCTRLFIREEVENT";
    public static final String PFPLUGIN = "PFPLUGIN";
    public static final String MSGBOX = "MSGBOX";
    public static final String DEACTION = "DEACTION";
    public static final String DEDATASET = "DEDATASET";
    public static final String DELOGIC = "DELOGIC";
    public static final String DEUIACTION = "DEUIACTION";
    public static final String THROWEXCEPTION = "THROWEXCEPTION";
    public static final String DEBUGPARAM = "DEBUGPARAM";
    public static final String DECISION = "DECISION";
    public static final String MEMO = "MEMO";
    public static final String END = "END";

    public DEUILogicNodeTypeCodeListModel() {
        this.initAnnotation(DEUILogicNodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUILogicNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUILogicNodeTypeCodeListModel");
    }
}

