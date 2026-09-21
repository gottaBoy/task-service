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

@CodeList(id="d01b85cd8b37ff33c091abf6fac6013e", name="\u5de5\u4f5c\u6d41\u8f85\u52a9\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SENDBACK", text="\u56de\u9000", realtext="\u56de\u9000", userdata="\u5c06\u6d41\u7a0b\u9000\u56de\u5230\u4e0a\u4e00\u6b65\u9aa4"), @CodeItem(value="SUPPLYINFO", text="\u8865\u5145\u4fe1\u606f", realtext="\u8865\u5145\u4fe1\u606f", userdata="\u8981\u6c42\u6d41\u7a0b\u53d1\u8d77\u4eba\u8fdb\u884c\u8865\u5145\u4fe1\u606f"), @CodeItem(value="ADDSTEPBEFORE", text="\u524d\u52a0\u7b7e", realtext="\u524d\u52a0\u7b7e", userdata="\u5728\u5f53\u524d\u6b65\u9aa4\u4e4b\u524d\u6dfb\u52a0\u5ba1\u6838\u6b65\u9aa4"), @CodeItem(value="ADDSTEPAFTER", text="\u540e\u52a0\u7b7e", realtext="\u540e\u52a0\u7b7e", userdata="\u5728\u5f53\u524d\u6b65\u9aa4\u4e4b\u540e\u6dfb\u52a0\u5ba1\u6838\u6b65\u9aa4"), @CodeItem(value="TAKEADVICE", text="\u5f81\u6c42\u610f\u89c1", realtext="\u5f81\u6c42\u610f\u89c1", userdata="\u53d1\u8d77\u5411\u6307\u5b9a\u4eba\u5458\u5f81\u6c42\u610f\u89c1\u7684\u64cd\u4f5c"), @CodeItem(value="SENDCOPY", text="\u6284\u9001", realtext="\u6284\u9001"), @CodeItem(value="REASSIGN", text="\u8f6c\u529e", realtext="\u8f6c\u529e"), @CodeItem(value="USERACTION", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USERACTION2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USERACTION3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USERACTION4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494"), @CodeItem(value="USERACTION5", text="\u7528\u6237\u81ea\u5b9a\u4e495", realtext="\u7528\u6237\u81ea\u5b9a\u4e495"), @CodeItem(value="USERACTION6", text="\u7528\u6237\u81ea\u5b9a\u4e496", realtext="\u7528\u6237\u81ea\u5b9a\u4e496")})
public class WFUtilUIActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SENDBACK = "SENDBACK";
    public static final String SUPPLYINFO = "SUPPLYINFO";
    public static final String ADDSTEPBEFORE = "ADDSTEPBEFORE";
    public static final String ADDSTEPAFTER = "ADDSTEPAFTER";
    public static final String TAKEADVICE = "TAKEADVICE";
    public static final String SENDCOPY = "SENDCOPY";
    public static final String REASSIGN = "REASSIGN";
    public static final String USERACTION = "USERACTION";
    public static final String USERACTION2 = "USERACTION2";
    public static final String USERACTION3 = "USERACTION3";
    public static final String USERACTION4 = "USERACTION4";
    public static final String USERACTION5 = "USERACTION5";
    public static final String USERACTION6 = "USERACTION6";

    public WFUtilUIActionTypeCodeListModel() {
        this.initAnnotation(WFUtilUIActionTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel");
    }
}

