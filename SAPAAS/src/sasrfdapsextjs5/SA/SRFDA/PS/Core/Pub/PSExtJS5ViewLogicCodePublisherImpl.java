/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCond
 *  SA.SRFDA.PS.Core.Pub.PSPFViewLogicCodePublisherImpl
 *  SA.SRFDA.PS.Core.Pub.Util.PSParamNameMethod
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCond;
import SA.SRFDA.PS.Core.Pub.PSPFViewLogicCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSParamNameMethod;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;

public class PSExtJS5ViewLogicCodePublisherImpl
extends PSPFViewLogicCodePublisherImpl {
    public String getDEViewLogicLinkCode(IPSDELogicLink iPSDELogicLink) throws Exception {
        return this.getPSDELogicLinkGroupCondCode(iPSDELogicLink.getPSDELogicLinkGroupCond());
    }

    protected String getPSDELogicLinkGroupCondCode(IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond) throws Exception {
        if (iPSDELogicLinkGroupCond == null) {
            return "true";
        }
        String strCode = this.getPSDELogicLinkCondCode((IPSDELogicLinkCond)iPSDELogicLinkGroupCond);
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            return "true";
        }
        return strCode;
    }

    protected String getPSDELogicLinkCondCode(IPSDELogicLinkCond iPSDELogicLinkCond) throws Exception {
        if (iPSDELogicLinkCond instanceof IPSDELogicLinkGroupCond) {
            IPSDELogicLinkGroupCond iPSDELogicLinkGroupCond = (IPSDELogicLinkGroupCond)iPSDELogicLinkCond;
            ArrayList<String> codeList = new ArrayList<String>();
            Iterator psDEFDLogics = iPSDELogicLinkGroupCond.getPSDELogicLinkConds();
            if (psDEFDLogics != null) {
                while (psDEFDLogics.hasNext()) {
                    IPSDELogicLinkCond childPSDELogicLinkCond = (IPSDELogicLinkCond)psDEFDLogics.next();
                    String strCode = this.getPSDELogicLinkCondCode(childPSDELogicLinkCond);
                    if (StringHelper.IsNullOrEmpty((String)strCode)) continue;
                    codeList.add(strCode);
                }
            }
            if (codeList.size() == 0) {
                return "";
            }
            if (codeList.size() == 1) {
                if (iPSDELogicLinkGroupCond.isNotMode()) {
                    return "!" + (String)codeList.get(0);
                }
                return (String)codeList.get(0);
            }
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSDELogicLinkGroupCond.isNotMode()) {
                sb.Append("!");
            }
            sb.Append("(");
            int i = 0;
            while (i < codeList.size()) {
                if (i != 0) {
                    if (StringHelper.Compare((String)iPSDELogicLinkGroupCond.getGroupOP(), (String)"AND", (boolean)true) == 0) {
                        sb.Append("&&");
                    } else {
                        sb.Append("||");
                    }
                }
                String strCode = (String)codeList.get(i);
                sb.Append(strCode);
                ++i;
            }
            sb.Append(")");
            return sb.toString();
        }
        if (iPSDELogicLinkCond instanceof IPSDELogicLinkSingleCond) {
            IPSDELogicLinkSingleCond iPSDELogicLinkSingleCond = (IPSDELogicLinkSingleCond)iPSDELogicLinkCond;
            String strParamName = PSParamNameMethod.getValue((String)iPSDELogicLinkSingleCond.getDstLogicParam().getCodeName());
            if (StringHelper.IsNullOrEmpty((String)iPSDELogicLinkSingleCond.getDstFieldName())) {
                return StringHelper.Format((String)"IBiz.testCond(%1$s,\"%3$s\",\"%4$s\")", (Object)strParamName, (Object)iPSDELogicLinkSingleCond.getDstFieldName(), (Object)iPSDELogicLinkSingleCond.getPSDBValueOPId(), (Object)iPSDELogicLinkSingleCond.getValue());
            }
            return StringHelper.Format((String)"IBiz.testCond(%1$s.%2$s,\"%3$s\",\"%4$s\")", (Object)strParamName, (Object)iPSDELogicLinkSingleCond.getDstFieldName(), (Object)iPSDELogicLinkSingleCond.getPSDBValueOPId(), (Object)iPSDELogicLinkSingleCond.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }
}

