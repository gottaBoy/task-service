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

@CodeList(id="df7262562d15aeafa81f2809442d90c1", name="\u5b9e\u4f53\u7ed3\u679c\u96c6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="CODELIST", text="\u4ee3\u7801\u8868", realtext="\u4ee3\u7801\u8868", userdata="\u6570\u636e\u96c6\u6765\u81ea\u6307\u5b9a\u7684\u4ee3\u7801\u8868"), @CodeItem(value="INDEXDE", text="\u7d22\u5f15\u5b9e\u4f53", realtext="\u7d22\u5f15\u5b9e\u4f53", userdata="\u6570\u636e\u96c6\u6765\u81ea\u5f53\u524d\u5b9e\u4f53\u7684\u7d22\u5f15\u503c\u8bc6\u522b\u5c5e\u6027\u7ed1\u5b9a\u7684\u4ee3\u7801\u8868"), @CodeItem(value="MULTIFORM", text="\u591a\u8868\u5355", realtext="\u591a\u8868\u5355", userdata="\u6570\u636e\u96c6\u6765\u81ea\u5f53\u524d\u5b9e\u4f53\u7684\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027\u7ed1\u5b9a\u7684\u4ee3\u7801\u8868"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", realtext="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", userdata="\u6570\u636e\u96c6\u6765\u81ea\u5b9e\u4f53\u5904\u7406\u903b\u8f91"), @CodeItem(value="SCRIPT", text="\u811a\u672c\u4ee3\u7801", realtext="\u811a\u672c\u4ee3\u7801", userdata="\u6570\u636e\u96c6\u6765\u81ea\u81ea\u5b9a\u4e49\u811a\u672c\u4ee3\u7801\u5904\u7406"), @CodeItem(value="REMOTE", text="\u8fdc\u7a0b\u63a5\u53e3\u6570\u636e\u96c6", realtext="\u8fdc\u7a0b\u63a5\u53e3\u6570\u636e\u96c6", userdata="\u6570\u636e\u96c6\u6765\u81ea\u8fdc\u7a0b\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5")})
public class DEDSPDTCodeListModel
extends StaticCodeListModelBase {
    public static final String CODELIST = "CODELIST";
    public static final String INDEXDE = "INDEXDE";
    public static final String MULTIFORM = "MULTIFORM";
    public static final String DELOGIC = "DELOGIC";
    public static final String SCRIPT = "SCRIPT";
    public static final String REMOTE = "REMOTE";

    public DEDSPDTCodeListModel() {
        this.initAnnotation(DEDSPDTCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEDataSetPredefinedType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDSPDTCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDSPDTCodeListModel");
    }
}

