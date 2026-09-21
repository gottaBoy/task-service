/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Data.NDConfigType;
import SA.SRFDA.ND.Data.NDConfigValue;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDDiskOwnerType;
import SA.SRFDA.ND.Data.NDFSOType;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;

public class NDModelHelper
implements INDModelHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strDBType = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strDBType = this.iDAGlobalHelper.getDAModelDB();
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getDBStorage() {
        return "";
    }

    public String getDBType() {
        return this.strDBType;
    }

    @Override
    public CallResult GetNDDiskOwnerType(String strNDDiskOwnerTypeId, NDDiskOwnerType ndDiskOwnerType) {
        return this.SelectSingle(this.GetSQL_GetNDDiskOwnerType(strNDDiskOwnerTypeId), ndDiskOwnerType, "SYSTEM");
    }

    protected String GetSQL_GetNDDiskOwnerType(String strNDDiskOwnerTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFNDDISKOWNERTYPE t1 where t1.NDDISKOWNERTYPEID='%1$s'  ", (Object)strNDDiskOwnerTypeId);
    }

    @Override
    public CallResult GetNDFSOType(String strNDFSOTypeId, NDFSOType ndFSOType) {
        return this.SelectSingle(this.GetSQL_GetNDFSOType(strNDFSOTypeId), ndFSOType, "SYSTEM");
    }

    protected String GetSQL_GetNDFSOType(String strNDFSOTypeId) {
        return StringHelper.Format((String)"select t1.* from V_SRFNDFSOTYPE t1 where t1.NDFSOTYPEID='%1$s'  ", (Object)strNDFSOTypeId);
    }

    @Override
    public CallResult GetNDDiskByOwner(String strOwnerType, String strOwnerId, NDDisk ndDisk) {
        return this.SelectSingle(this.GetSQL_GetNDDiskByOwner(strOwnerType, strOwnerId), ndDisk, "SYSTEM");
    }

    protected String GetSQL_GetNDDiskByOwner(String strOwnerType, String strOwnerId) {
        return StringHelper.Format((String)"select t1.* from V_SRFNDDISK t1 where t1.OWNERTYPE='%1$s' AND t1.OWNERID='%2$s' ", (Object)strOwnerType, (Object)strOwnerId);
    }

    @Override
    public CallResult GetNDFSObject(String strRootFSObjectId, String strPFSObjectId, String strName, NDFSObject ndFSObject) {
        return this.SelectSingle(this.GetSQL_GetNDFSObject(strRootFSObjectId, strPFSObjectId, strName), ndFSObject, "SYSTEM");
    }

    protected String GetSQL_GetNDFSObject(String strRootFSObjectId, String strPFSObjectId, String strName) {
        if (StringHelper.IsNullOrEmpty((String)strPFSObjectId)) {
            return StringHelper.Format((String)"select t1.* from T_SRFNDFSOBJECT t1 where t1.ROOTNDFSOBJECTID='%1$s' AND t1.NDFSOBJECTNAME='%2$s' AND t1.PNDFSOBJECTID IS NULL AND (t1.NDFSOBJECTTYPE='FOLDER' OR t1.NDFSOBJECTTYPE='FILE') ", (Object)strRootFSObjectId, (Object)strName);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFNDFSOBJECT t1 where t1.ROOTNDFSOBJECTID='%1$s' AND t1.NDFSOBJECTNAME='%2$s' AND t1.PNDFSOBJECTID = '%3$s' AND (t1.NDFSOBJECTTYPE='FOLDER' OR t1.NDFSOBJECTTYPE='FILE')  ", (Object)strRootFSObjectId, (Object)strName, (Object)strPFSObjectId);
    }

    @Override
    public CallResult GetNDShare(String strRootFSObjectId, String strName, NDShare ndShare) {
        return this.SelectSingle(this.GetSQL_GetNDShare(strRootFSObjectId, strName), ndShare, "SYSTEM");
    }

    protected String GetSQL_GetNDShare(String strRootFSObjectId, String strName) {
        return StringHelper.Format((String)"select t1.* from V_SRFNDSHARE t1 where t1.ROOTNDFSOBJECTID='%1$s' AND t1.NDSHARENAME='%2$s'  ", (Object)strRootFSObjectId, (Object)strName);
    }

    @Override
    public CallResult GetNDShare(String strNDShareId, NDShare ndShare) {
        return this.SelectSingle(this.GetSQL_GetNDShare(strNDShareId), ndShare, "SYSTEM");
    }

    protected String GetSQL_GetNDShare(String strNDShareId) {
        return StringHelper.Format((String)"select t1.* from V_SRFNDSHARE t1 where t1.NDSHAREID='%1$s'", (Object)strNDShareId);
    }

    @Override
    public CallResult GetNDDisk(String strNDDiskId, NDDisk ndDisk) {
        return this.SelectSingle(this.GetSQL_GetNDDisk(strNDDiskId), ndDisk, "SYSTEM");
    }

    protected String GetSQL_GetNDDisk(String strNDDiskId) {
        return StringHelper.Format((String)"select t1.* from V_SRFNDDISK t1 where t1.NDDISKID='%1$s'", (Object)strNDDiskId);
    }

    @Override
    public CallResult GetNDObject(String strNDFSObjectId, NDFSObject ndFSObject) {
        return this.SelectSingle(this.GetSQL_GetNDFSObject(strNDFSObjectId), ndFSObject, "SYSTEM");
    }

    protected String GetSQL_GetNDFSObject(String strNDFSObjectId) {
        return StringHelper.Format((String)"select t1.* from T_SRFNDFSOBJECT t1 where t1.NDFSOBJECTID='%1$s'", (Object)strNDFSObjectId);
    }

    @Override
    public CallResult GetNDConfigType(String strNDConfigTypeId, NDConfigType NDConfigType2) {
        return this.SelectSingle(this.GetSQL_GetNDConfigType(strNDConfigTypeId), NDConfigType2, "SYSTEM");
    }

    protected String GetSQL_GetNDConfigType(String strNDConfigTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFV_NDCONFIGTYPE t1 where t1.NDCONFIGTYPEID='%1$s'  ", (Object)strNDConfigTypeId);
    }

    @Override
    public CallResult GetNDConfigValues(String strNDConfigTypeId, Vector<NDConfigValue> ndConfigValues) {
        return this.SelectMulti(this.GetSQL_GetNDConfigValues(strNDConfigTypeId), ndConfigValues, NDConfigValue.class, "SYSTEM");
    }

    protected String GetSQL_GetNDConfigValues(String strNDConfigTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_NDCONFIGVALUE_BASE t1 WHERE t1.NDCONFIGTYPEID= '%1$s'  ORDER BY t1.ORDERFLAG", (Object)strNDConfigTypeId);
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

