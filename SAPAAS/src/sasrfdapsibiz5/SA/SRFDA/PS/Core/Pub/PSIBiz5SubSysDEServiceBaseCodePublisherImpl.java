/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition
 *  SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition
 *  SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule
 *  SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction
 *  SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SubSysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SubSysDEServiceBaseCodePublisherImpl
extends PSIBiz5SubSysDECodePublisherImpl {
    public static final String CODETEMPL_FETCHDEDATASET = "FETCHDEDATASET";
    public static final String CODETEMPL_DEACTION = "DEACTION";
    public static final String CODETEMPL_DEFVR_VALUERANGE2 = "DEFVR_VALUERANGE2";
    public static final String CODETEMPL_DEFVR_VALUERANGE3 = "DEFVR_VALUERANGE3";
    public static final String CODETEMPL_DEFVR_SIMPLE = "DEFVR_SIMPLE";
    public static final String CODETEMPL_DEFVR_STRINGLENGTH = "DEFVR_STRINGLENGTH";
    public static final String CODETEMPL_DEFVR_REGEX = "DEFVR_REGEX";
    public static final String CODETEMPL_DEFVR_GROUP = "DEFVR_GROUP";

    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("de", iPSDataEntity);
        ArrayList<IPSGenerateCodeResult> deDataSets = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEDataSets = iPSDataEntity.getAllPSDEDataSets();
        while (psDEDataSets.hasNext()) {
            IPSDEDataSet iPSDEDataSet = (IPSDEDataSet)psDEDataSets.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_FETCHDEDATASET, iPSDEDataSet, null);
            deDataSets.add(iPSGenerateCodeResult);
        }
        params.put("fetchdedatasets", deDataSets);
        ArrayList<IPSGenerateCodeResult> deActions = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEActions = iPSDataEntity.getAllPSDEActions();
        while (psDEActions.hasNext()) {
            IPSDEAction iPSDEAction = (IPSDEAction)psDEActions.next();
            if (StringHelper.Compare((String)"SYSDBPROC", (String)iPSDEAction.getActionType(), (boolean)true) != 0) continue;
            String strTagName = StringHelper.Format((String)"%1$s_%2$s", (Object)CODETEMPL_DEACTION, (Object)iPSDEAction.getActionType());
            String strMethodName = iPSDEAction.getCodeName();
            String strNewMethodName = String.valueOf(strMethodName.substring(0, 1).toLowerCase()) + strMethodName.substring(1);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("methodname", strNewMethodName);
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(strTagName, iPSDEAction, map);
            deActions.add(iPSGenerateCodeResult);
        }
        params.put("dbprocs", deActions);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDataEntity, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    public String getDEFVRCode(Object obj) throws Exception {
        if (!(obj instanceof IPSDEFValueRule)) {
            throw new Exception("\u5bf9\u8c61\u65e0\u6548");
        }
        IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)obj;
        if (iPSDEFValueRule.getPSDEFVRGroupCondition() == null) {
            return "true";
        }
        String strCode = this.getDEFVRCondCode((IPSDEFVRCondition)iPSDEFValueRule.getPSDEFVRGroupCondition());
        if (StringHelper.IsNullOrEmpty((String)strCode)) {
            return "true";
        }
        return strCode;
    }

    protected String getDEFVRCondCode(IPSDEFVRCondition iPSDEFVRCondition) throws Exception {
        if (iPSDEFVRCondition instanceof IPSDEFVRGroupCondition) {
            IPSDEFVRGroupCondition iPSDEFVRGroupCondition = (IPSDEFVRGroupCondition)iPSDEFVRCondition;
            if (iPSDEFVRGroupCondition.getPSDEFVRConditions() == null) {
                return "true";
            }
            boolean bFirst = true;
            StringBuilderEx sb = new StringBuilderEx();
            if (iPSDEFVRGroupCondition.isNotMode()) {
                sb.Append("!");
            }
            sb.Append("(");
            Iterator childPSDEFVRConditions = iPSDEFVRGroupCondition.getPSDEFVRConditions();
            while (childPSDEFVRConditions.hasNext()) {
                IPSDEFVRCondition childPSDEFVRCondition = (IPSDEFVRCondition)childPSDEFVRConditions.next();
                if (bFirst) {
                    bFirst = false;
                } else if (StringHelper.Compare((String)iPSDEFVRGroupCondition.getCondOp(), (String)"AND", (boolean)true) == 0) {
                    sb.Append("\r\n&&");
                } else {
                    sb.Append("\r\n||");
                }
                sb.Append(this.getDEFVRCondCode(childPSDEFVRCondition));
            }
            sb.Append(")");
            return sb.toString();
        }
        String strTemplName = StringHelper.Format((String)"DEFVR_%1$s", (Object)iPSDEFVRCondition.getCondType()).toUpperCase();
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(strTemplName, iPSDEFVRCondition, null);
        return iPSGenerateCodeResult.getCode();
    }
}

