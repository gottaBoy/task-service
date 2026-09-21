/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DataLock;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.ISRFDAExtTransaction;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public interface IDEDataCtrl {
    public void Init(IDEHelper var1, ISRFDAGlobalHelper var2, String var3, ISRFDAWebContext var4);

    public void setTransactionManager(ISRFDATransactionManager var1);

    public ISRFDATransactionManager getTransactionManager();

    public String getLanguage();

    public void setLanguage(String var1);

    public String getOPPersonId();

    public String getOrgUnitId();

    public String getOrgUnitName();

    public ISRFDAWebContext getWebContext();

    public ISRFDAGlobalHelper getGlobalHelper();

    public CallResult GetDefault(ISRFDAWebContext var1, BaseDataEntity var2);

    public CallResult GetDefault(String var1, ISRFDAWebContext var2, BaseDataEntity var3);

    public CallResult Get(BaseDataEntity var1);

    public CallResult Get(String var1, BaseDataEntity var2);

    public int CheckKeyState2(BaseDataEntity var1) throws Exception;

    public CallResult CheckKeyState(BaseDataEntity var1);

    public CallResult Select(BaseDataEntity var1);

    public CallResult Select(BaseDataEntity var1, String var2, String var3);

    public CallResult Select(BaseDataEntity var1, Vector<BaseDataEntity> var2);

    public CallResult Select(String var1, BaseDataEntity var2, Vector<BaseDataEntity> var3);

    public CallResult Select(BaseDataEntity var1, Vector var2, String var3);

    public CallResult Select(BaseDataEntity var1, Vector var2, String var3, String var4);

    public CallResult Select(BaseDataEntity var1, Vector var2, String var3, String var4, String var5);

    public CallResult Select(String var1, BaseDataEntity var2, Vector var3, String var4);

    public CallResult TestSave(boolean var1, BaseDataEntity var2, Vector<ValueError> var3);

    public CallResult TestSave(boolean var1, String var2, BaseDataEntity var3, Vector<ValueError> var4);

    public CallResult AutoSave(BaseDataEntity var1);

    public CallResult AutoSave(String var1, BaseDataEntity var2);

    public CallResult Save(boolean var1, BaseDataEntity var2);

    public CallResult Save(boolean var1, String var2, BaseDataEntity var3);

    public CallResult SaveTempData(TempData var1, BaseDataEntity var2);

    public CallResult RemoveTempData(TempData var1);

    public CallResult Remove(String var1, BaseDataEntity var2);

    public CallResult Remove(BaseDataEntity var1);

    public CallResult Remove(String var1, BaseDataEntity var2, TreeMap<String, Boolean> var3);

    public CallResult Remove(BaseDataEntity var1, TreeMap<String, Boolean> var2);

    public CallResult TestRemove(String var1, BaseDataEntity var2);

    public CallResult TestRemove(BaseDataEntity var1);

    public CallResult TestRemove(String var1, BaseDataEntity var2, TreeMap<String, Boolean> var3);

    public CallResult TestRemove(BaseDataEntity var1, TreeMap<String, Boolean> var2);

    public CallResult RemoveMulti(String var1, BaseDataEntity var2);

    public CallResult RemoveMulti(BaseDataEntity var1);

    public CallResult CustomCall(String var1, BaseDataEntity var2);

    public CallResult CustomSaveCall(String var1, BaseDataEntity var2);

    public CallResult CustomProcCall(String var1, BaseDataEntity var2);

    public CallResult CustomRawProcCall(String var1, BaseDataEntity var2);

    public CallResult Export(BaseDataEntity var1, Vector<XMLNode> var2, boolean var3, boolean var4);

    public CallResult Import(XMLNode var1);

    public void SetDataLockKey(String var1);

    public String GetDataLockKey();

    public String GetDataLockKey(BaseDataEntity var1);

    public CallResult GetDataLock(BaseDataEntity var1, DataLock var2);

    public CallResult TestDataLock(BaseDataEntity var1, String var2);

    public IDEHelper GetDEHelper();

    public void RemoveUncopyValue(BaseDataEntity var1);

    public CallResult CopyDetail(BaseDataEntity var1, Object var2);

    public CallResult PrepareMethod(boolean var1);

    public void SetAttribute(String var1, Object var2);

    public Object GetAttribute(String var1);

    public void ResetAttributes();

    public CallResult Execute(DEAction var1, BaseDataEntity var2);

    public CallResult Execute(String var1, BaseDataEntity var2);

    public CallResult FillDetails(String var1, BaseDataEntity var2);

    public CallResult FillDetails(BaseDataEntity var1);

    public IDEDataCtrl GetRelatedDataCtrl(String var1) throws Exception;

    public IDEDataCtrl getReferDataCtrl();

    public void setReferDataCtrl(IDEDataCtrl var1);

    public void CommitExtTransaction(ISRFDAExtTransaction var1);

    public void RollbackExtTransaction(ISRFDAExtTransaction var1);

    public void ResetRelatedData(String var1, Object var2) throws Exception;

    public BaseDataEntity GetRelatedData(String var1, Object var2, boolean var3) throws Exception;

    public CallResult GetDataLastVersion(BaseDataEntity var1, ArrayList<JSONObject> var2, HashMap<String, BaseDataEntity> var3, boolean var4);

    public CallResult CheckoutData(BaseDataEntity var1, ArrayList<JSONObject> var2, HashMap<String, BaseDataEntity> var3);

    public CallResult AutoCheckoutData(BaseDataEntity var1, ArrayList<JSONObject> var2, HashMap<String, BaseDataEntity> var3);

    public CallResult CheckinData(JSONObject var1);

    public CallResult UndoCheckoutData(BaseDataEntity var1, HashMap<String, BaseDataEntity> var2);
}

