/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.IDBOPDataObject;
import SA.SRFDA.EAI.Ctrl.IDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFDA.EAI.Ctrl.IDBOPSetting;
import SA.SRFDA.EAI.Ctrl.IDBOPTmpTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

public interface IDBOPPKGContext {
    public String getDBType();

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public IDBOPDataObject FindDBDataObject(String var1) throws Exception;

    public IDBOPRecordSet FindDBRecordSet(String var1) throws Exception;

    public IDBOPProcess FindDBOPProcess(String var1) throws Exception;

    public IDBOPTmpTable FindDBOPTmpTable(String var1) throws Exception;

    public IDEDataCtrl FindDEDataCtrl(String var1) throws Exception;

    public String FindDBSchema(String var1) throws Exception;

    public String ParseMacro(String var1) throws Exception;

    public String ParseMacro(Map<String, Object> var1, String var2) throws Exception;

    public String GetUniqueProcId();

    public IDBOPSetting getDBOPSetting();

    public String FindPkgParam(String var1);
}

