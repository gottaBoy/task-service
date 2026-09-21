/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTimeRule;
import SA.TM.Ctrl.ITMBTTypeHelper;
import SA.TM.Ctrl.ITMRBRuleHelper;
import SA.TM.Ctrl.ITMRBRuleTypeHelper;
import SA.TM.Ctrl.ITMResBTHelper;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.ITMResCatalogHelper;
import SA.TM.Ctrl.ITMResTypeHelper;
import SA.TM.Ctrl.ITMResViewHelper;
import SA.TM.Ctrl.ITMTaskResAETypeHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;
import SA.TM.Ctrl.ITMTaskTypeHelper;
import SA.TM.Ctrl.ITMTimeRuleHelper;

public interface ITMModelStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public ITMTaskTypeHelper FindTMTaskType(String var1) throws Exception;

    public ITMResTypeHelper FindTMResType(String var1) throws Exception;

    public ITMResBTHelper FindTMResBT(String var1) throws Exception;

    public TMTaskBase FindTMTask(String var1) throws Exception;

    public TMTaskBase FindTMTask(String var1, int var2) throws Exception;

    public ITMResBaseHelper FindTMResource(String var1) throws Exception;

    public ITMRBRuleTypeHelper FindTMRBRuleType(String var1) throws Exception;

    public ITMRBRuleHelper FindTMRBRule(String var1) throws Exception;

    public ITMRBRuleHelper FindTMRBRule(TMRBRule var1) throws Exception;

    public ITMTimeRuleHelper FindTMTimeRule(String var1) throws Exception;

    public ITMTimeRuleHelper FindTMTimeRule(TMTimeRule var1) throws Exception;

    public ITMResCatalogHelper FindTMResCatalog(String var1) throws Exception;

    public ITMResViewHelper FindTMResView(String var1) throws Exception;

    public ITMResViewHelper FindTMResView(TMResView var1) throws Exception;

    public ITMBTTypeHelper FindTMBTType(String var1) throws Exception;

    public ITMTaskResArrangeEngine CreateTMTaskResArrangeEngine(String var1) throws Exception;

    public ITMTaskResAETypeHelper FindTMTaskResAEType(String var1) throws Exception;

    public void RunTMBTPrjInst(String var1) throws Exception;

    public void CancelRunTMBTPrjInst(String var1) throws Exception;
}

