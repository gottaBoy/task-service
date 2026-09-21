/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCond
 *  SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.Util.PSParamNameMethod
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SubSysDECodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSParamNameMethod;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SubSysDELogicModelBaseCodePublisherImpl
extends PSIBiz5SubSysDECodePublisherImpl {
    public static final String CODETEMPL_DELOGICCODE = "DELOGICCODE";

    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDELogics = iPSDataEntity.getAllPSDELogics();
        while (psDELogics.hasNext()) {
            IPSDELogic iPSDELogic = (IPSDELogic)psDELogics.next();
            if (iPSDELogic.getExtendMode() != 2) continue;
            this.generateCode(iPSDELogic, list);
        }
    }

    protected void generateCode(IPSDELogic iPSDELogic, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> dedscodes = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDELogicNodes = iPSDELogic.getPSDELogicNodes();
        while (psDELogicNodes.hasNext()) {
            IPSDELogicNode iPSDELogicNode = (IPSDELogicNode)psDELogicNodes.next();
            String strTag = StringHelper.Format((String)"NODE_%1$s", (Object)iPSDELogicNode.getLogicNodeType());
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(strTag, iPSDELogicNode, null);
            dedscodes.add(iPSGenerateCodeResult);
        }
        params.put("delogicnodes", dedscodes);
        params.put("de", iPSDELogic.getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDELogic, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        if (!StringHelper.IsNullOrEmpty((String)strType)) {
            IPSDELogicNode iPSDELogicNode;
            if (strType.indexOf("NODE_") == 0) {
                iPSDELogicNode = (IPSDELogicNode)obj;
                IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode("NODEHEADER", iPSDELogicNode, null);
                params.put("delogicnodeheader", iPSGenerateCodeResult);
                iPSGenerateCodeResult = this.generateCode("NODEBOTTOM", obj, null);
                params.put("delogicnodebottom", iPSGenerateCodeResult);
            }
            if (strType.indexOf("NODEBOTTOM") == 0) {
                iPSDELogicNode = (IPSDELogicNode)obj;
                ArrayList<IPSGenerateCodeResult> delogiclinks = new ArrayList<IPSGenerateCodeResult>();
                Iterator psDELogicLinks = iPSDELogicNode.getPSDELogicLinks();
                if (psDELogicLinks != null) {
                    while (psDELogicLinks.hasNext()) {
                        IPSDELogicLink iPSDELogicLink = (IPSDELogicLink)psDELogicLinks.next();
                        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode("NODELINK", iPSDELogicLink, null);
                        delogiclinks.add(iPSGenerateCodeResult);
                    }
                }
                params.put("delogiclinks", delogiclinks);
            }
            if (strType.indexOf("NODELINK") == 0) {
                IPSDELogicLink iPSDELogicLink = (IPSDELogicLink)obj;
                params.put("linkcond", this.getPSDELogicLinkGroupCondCode(iPSDELogicLink.getPSDELogicLinkGroupCond()));
            }
        }
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
            return StringHelper.Format((String)"testCond(%1$s.get(\"%2$s\"),\"%3$s\",\"%4$s\")", (Object)strParamName, (Object)iPSDELogicLinkSingleCond.getDstFieldName(), (Object)iPSDELogicLinkSingleCond.getPSDBValueOPId(), (Object)iPSDELogicLinkSingleCond.getValue());
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u4ee3\u7801");
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDELogic) {
            IPSDELogic iPSDELogic = (IPSDELogic)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            if (iPSDELogic.getExtendMode() != 2) {
                return null;
            }
            this.generateCode(iPSDELogic, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }
}

