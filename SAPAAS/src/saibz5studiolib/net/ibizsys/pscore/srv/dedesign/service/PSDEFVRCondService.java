/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DEFVRParamTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DEFVRTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCond;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFVRCondService
extends PSDEFVRCondServiceBase {
    private static final Log log = LogFactory.getLog(PSDEFVRCondService.class);

    @Override
    protected void onFillEntityFullInfo(PSDEFVRCond pSDEFVRCond, boolean bl) throws Exception {
        if (bl && pSDEFVRCond.getPSDEFVRCondName() == null) {
            pSDEFVRCond.setPSDEFVRCondName(this.calcPSDEFVRCondName(pSDEFVRCond));
        }
        super.onFillEntityFullInfo(pSDEFVRCond, bl);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEFVRCond pSDEFVRCond) throws Exception {
        pSDEFVRCond.setPSDEFVRCondName(this.calcPSDEFVRCondName(pSDEFVRCond));
        super.onBeforeCreateTemp(pSDEFVRCond);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEFVRCond pSDEFVRCond) throws Exception {
        pSDEFVRCond.setPSDEFVRCondName(this.calcPSDEFVRCondName(pSDEFVRCond));
        super.onBeforeUpdateTemp(pSDEFVRCond);
    }

    public void getTemp(PSDEFVRCond pSDEFVRCond) throws Exception {
        super.getTemp(pSDEFVRCond);
        if ((StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"SIMPLE", (boolean)true) == 0 || StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"REGEX", (boolean)true) == 0 || StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"STRINGLENGTH", (boolean)true) == 0 || StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"VALUERANGE2", (boolean)true) == 0 || StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"VALUERANGE3", (boolean)true) == 0 || StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"SYSVALUERULE", (boolean)true) == 0) && StringHelper.isNullOrEmpty((String)pSDEFVRCond.getCustomDEFName()) && !StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFName())) {
            pSDEFVRCond.setCustomDEFName(pSDEFVRCond.getPSDEFName());
            pSDEFVRCond.setPSDEFId(null);
            pSDEFVRCond.setPSDEFName(null);
        }
    }

    public String calcPSDEFVRCondName(PSDEFVRCond pSDEFVRCond) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEFVRCond.getCondType())) {
            return "\u503c\u89c4\u5219\u6761\u4ef6\u9879";
        }
        ICodeList iCodeList = CodeListGlobal.getCodeList(DEFVRTypeCodeListModel.class);
        String string = iCodeList.getCodeListText(pSDEFVRCond.getCondType(), true);
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (pSDEFVRCond.getGroupNotFlag() != null && pSDEFVRCond.getGroupNotFlag() == 1) {
            stringBuilderEx.append("[!]");
        }
        stringBuilderEx.append("[%1$s]", (Object)string);
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"GROUP", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getGroupOP());
            return stringBuilderEx.toString();
        }
        String string2 = pSDEFVRCond.getCondValue();
        if (!StringHelper.isNullOrEmpty((String)string2) && string2.length() > 10) {
            string2 = string2.substring(0, 10) + "...";
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "";
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"SIMPLE", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getPSDEFName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDBValueOPName())) {
                stringBuilderEx.append(" %1$s ", (Object)pSDEFVRCond.getPSDBValueOPName());
            }
            String string3 = null;
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getParamType())) {
                ICodeList iCodeList2 = CodeListGlobal.getCodeList(DEFVRParamTypeCodeListModel.class);
                string3 = iCodeList2.getCodeListText(pSDEFVRCond.getParamType(), true);
            }
            if (StringHelper.isNullOrEmpty((String)string2)) {
                if (StringHelper.isNullOrEmpty(string3)) {
                    stringBuilderEx.append("", (Object)string2);
                } else {
                    stringBuilderEx.append("%2$s", (Object)string2, (Object)string3);
                }
            } else if (StringHelper.isNullOrEmpty(string3)) {
                stringBuilderEx.append("(%1$s)", (Object)string2);
            } else {
                stringBuilderEx.append("%2$s(%1$s)", (Object)string2, (Object)string3);
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"REGEX", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getPSDEFName());
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                stringBuilderEx.append("(%1$s)", (Object)string2);
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"VALUERANGE2", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getPSDEFName());
            }
            if (pSDEFVRCond.getParam7() != null) {
                stringBuilderEx.append(" \u5927\u4e8e");
                if (DataObject.getBoolValue((Integer)pSDEFVRCond.getParam5(), (boolean)false)) {
                    stringBuilderEx.append("\u7b49\u4e8e");
                }
                stringBuilderEx.append(" %1$s", (Object)pSDEFVRCond.getParam7());
            }
            if (pSDEFVRCond.getParam8() != null) {
                if (pSDEFVRCond.getParam7() != null) {
                    stringBuilderEx.append(" \u4e14 ");
                }
                stringBuilderEx.append(" \u5c0f\u4e8e");
                if (DataObject.getBoolValue((Integer)pSDEFVRCond.getParam6(), (boolean)false)) {
                    stringBuilderEx.append("\u7b49\u4e8e");
                }
                stringBuilderEx.append(" %1$s", (Object)pSDEFVRCond.getParam8());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"VALUERANGE3", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getPSDEFName());
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                stringBuilderEx.append("(%1$s)", (Object)string2);
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"STRINGLENGTH", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPSDEFName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getPSDEFName());
            }
            if (pSDEFVRCond.getParam3() != null) {
                stringBuilderEx.append(" \u5927\u4e8e");
                if (DataObject.getBoolValue((Integer)pSDEFVRCond.getParam5(), (boolean)false)) {
                    stringBuilderEx.append("\u7b49\u4e8e");
                }
                stringBuilderEx.append(" %1$s", (Object)pSDEFVRCond.getParam3());
            }
            if (pSDEFVRCond.getParam4() != null) {
                if (pSDEFVRCond.getParam3() != null) {
                    stringBuilderEx.append(" \u4e14 ");
                }
                stringBuilderEx.append(" \u5c0f\u4e8e");
                if (DataObject.getBoolValue((Integer)pSDEFVRCond.getParam6(), (boolean)false)) {
                    stringBuilderEx.append("\u7b49\u4e8e");
                }
                stringBuilderEx.append(" %1$s", (Object)pSDEFVRCond.getParam4());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"QUERYCOUNT", (boolean)true) == 0) {
            stringBuilderEx.append("\u67e5\u8be2[%1$s]\u8bb0\u5f55\u6570", (Object)pSDEFVRCond.getPSDEDQName());
            if (pSDEFVRCond.getParam3() != null) {
                stringBuilderEx.append(" \u5927\u4e8e");
                if (DataObject.getBoolValue((Integer)pSDEFVRCond.getParam5(), (boolean)false)) {
                    stringBuilderEx.append("\u7b49\u4e8e");
                }
                stringBuilderEx.append(" %1$s", (Object)pSDEFVRCond.getParam3());
            }
            if (pSDEFVRCond.getParam4() != null) {
                if (pSDEFVRCond.getParam3() != null) {
                    stringBuilderEx.append(" \u4e14 ");
                }
                stringBuilderEx.append(" \u5c0f\u4e8e");
                if (DataObject.getBoolValue((Integer)pSDEFVRCond.getParam6(), (boolean)false)) {
                    stringBuilderEx.append("\u7b49\u4e8e");
                }
                stringBuilderEx.append(" %1$s", (Object)pSDEFVRCond.getParam4());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"VALUERANGE", (boolean)true) == 0) {
            stringBuilderEx.append("\u5b9e\u4f53[%1$s]\u6570\u636e\u96c6\u5408[%2$s]", (Object)pSDEFVRCond.getMajorPSDEName(), (Object)pSDEFVRCond.getMajorPSDEDSName());
            if (!StringHelper.isNullOrEmpty((String)pSDEFVRCond.getExtMajorPSDEFName())) {
                stringBuilderEx.append("(");
                stringBuilderEx.append("[%1$s]\u7b49\u4e8e[%2$s]", (Object)pSDEFVRCond.getExtMajorPSDEFName(), (Object)pSDEFVRCond.getExtMinorPSDEFName());
                stringBuilderEx.append(")");
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"VALUERECURSION", (boolean)true) == 0) {
            stringBuilderEx.append("\u5f15\u7528\u5b9e\u4f53[%1$s]\u9012\u5f52\u68c0\u67e5", (Object)pSDEFVRCond.getMajorPSDEName());
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFVRCond.getCondType(), (String)"SYSVALUERULE", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s", (Object)pSDEFVRCond.getPSSysValueRuleName());
            return stringBuilderEx.toString();
        }
        return "?";
    }
}

