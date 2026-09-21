/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition
 *  SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition
 *  SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule
 *  SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEModelPublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    public static final String CODETEMPL_DEFIELD = "DEFIELD";
    public static final String CODETEMPL_DEDATASET = "DEDATASET";
    public static final String CODETEMPL_DEFVALUERULE = "DEFVALUERULE";
    public static final String CODETEMPL_DEFVRCOND = "DEFVRCOND";

    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> fields = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEFields = iPSDataEntity.getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            iPSGenerateCodeResult = this.generateCode(CODETEMPL_DEFIELD, iPSDEField, null);
            fields.add(iPSGenerateCodeResult);
        }
        params.put("defields", fields);
        fields = new ArrayList();
        Iterator psDEDataSets = iPSDataEntity.getAllPSDEDataSets();
        while (psDEDataSets.hasNext()) {
            IPSDEDataSet iPSDEDataSet = (IPSDEDataSet)psDEDataSets.next();
            iPSGenerateCodeResult = this.generateCode(CODETEMPL_DEDATASET, iPSDEDataSet, null);
            fields.add(iPSGenerateCodeResult);
        }
        params.put("dedatasets", fields);
        params.put("de", iPSDataEntity);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDataEntity, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        IPSDEFVRCondition iPSDEFVRCondition;
        super.onFillGenerateCodeParams(strType, obj, params);
        if (StringHelper.Compare((String)strType, (String)CODETEMPL_DEFIELD, (boolean)true) == 0) {
            IPSDEField iPSDEField = (IPSDEField)obj;
            ArrayList<IPSGenerateCodeResult> defvrs = new ArrayList<IPSGenerateCodeResult>();
            Iterator psDEFValueRules = iPSDEField.getAllPSDEFValueRules();
            while (psDEFValueRules.hasNext()) {
                IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)psDEFValueRules.next();
                IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_DEFVALUERULE, iPSDEFValueRule, null);
                defvrs.add(iPSGenerateCodeResult);
            }
            params.put("defvrs", defvrs);
        }
        if (StringHelper.Compare((String)strType, (String)CODETEMPL_DEFVALUERULE, (boolean)true) == 0) {
            IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)obj;
            IPSDEFVRGroupCondition iPSDEFVRGroupCondition = iPSDEFValueRule.getPSDEFVRGroupCondition();
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_DEFVRCOND, iPSDEFVRGroupCondition, null);
            params.put("groupcond", iPSGenerateCodeResult);
        }
        if (StringHelper.Compare((String)strType, (String)CODETEMPL_DEFVRCOND, (boolean)true) == 0 && (iPSDEFVRCondition = (IPSDEFVRCondition)obj) instanceof IPSDEFVRGroupCondition) {
            ArrayList<IPSGenerateCodeResult> childconds = new ArrayList<IPSGenerateCodeResult>();
            IPSDEFVRGroupCondition iPSDEFVRGroupCondition = (IPSDEFVRGroupCondition)iPSDEFVRCondition;
            Iterator psDEFVRConditions = iPSDEFVRGroupCondition.getPSDEFVRConditions();
            while (psDEFVRConditions.hasNext()) {
                IPSDEFVRCondition childCond = (IPSDEFVRCondition)psDEFVRConditions.next();
                IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_DEFVALUERULE, childCond, null);
                childconds.add(iPSGenerateCodeResult);
            }
            params.put("childconds", childconds);
        }
    }
}

