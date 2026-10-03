/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.NDBaseObject;
import SA.SRFDA.ND.Data.NDFSOType;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Vector;

public class NDFSOTypeHelper
extends NDBaseObject
implements INDFSOTypeHelper {
    protected NDFSOType ndFSOType = null;
    protected IDEHelper iDEHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, NDFSOType ndFSOType) throws Exception {
        this.ndFSOType = ndFSOType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.ndFSOType.getNDFSOTYPEID());
        this.setName(this.ndFSOType.getNDFSOTYPENAME());
        this.iDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(this.getRealDEId());
        this.OnInit();
    }

    @Override
    public String getRealDEId() {
        return this.ndFSOType.getREALDEID();
    }

    protected IDEHelper getRealDEHelper() {
        return this.iDEHelper;
    }

    @Override
    public boolean isEnableCopy() {
        return this.ndFSOType.getENABLECOPY();
    }

    @Override
    public boolean isEnableMove() {
        return this.ndFSOType.getENABLEMOVE();
    }

    @Override
    public boolean isLeafNode() {
        return this.ndFSOType.getLEAFNODE();
    }

    @Override
    public CallResult MarkFSORemoveFlag(INDActionContext iNDActionContext, NDFSObject ndFSObject, boolean bRemoveFlag) throws Exception {
        IDEDataCtrl ndFSODataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        NDFSObject tempNDFSObject = new NDFSObject();
        tempNDFSObject.setNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
        tempNDFSObject.setREMOVEFLAG(bRemoveFlag);
        CallResult callResult = ndFSODataCtrl.Save(false, (BaseDataEntity)tempNDFSObject);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5220\u9664\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
        }
        NDFSObject cond = new NDFSObject();
        cond.SetParamValue("ROOTNDFSOBJECTID", tempNDFSObject.getROOTNDFSOBJECTID());
        cond.SetParamValue("PNDFSOBJECTID", tempNDFSObject.getNDFSOBJECTID());
        Vector<NDFSObject> childNDFSObjectList = new Vector();
        callResult = ndFSODataCtrl.Select((BaseDataEntity)cond, childNDFSObjectList, NDFSObject.class.getName());
        for (NDFSObject childNDFSObject : childNDFSObjectList) {
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(childNDFSObject.getNDFSOBJECTTYPE());
            callResult = iNDFSOTypeHelper.MarkFSORemoveFlag(iNDActionContext, childNDFSObject, bRemoveFlag);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult RemoveFSO(INDActionContext iNDActionContext, NDFSObject ndFSObject) throws Exception {
        IDEDataCtrl ndFSODataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        NDFSObject cond = new NDFSObject();
        cond.SetParamValue("ROOTNDFSOBJECTID", ndFSObject.getROOTNDFSOBJECTID());
        cond.SetParamValue("PNDFSOBJECTID", ndFSObject.getNDFSOBJECTID());
        Vector<NDFSObject> childNDFSObjectList = new Vector();
        CallResult callResult = ndFSODataCtrl.Select((BaseDataEntity)cond, childNDFSObjectList, NDFSObject.class.getName());
        for (NDFSObject childNDFSObject : childNDFSObjectList) {
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(childNDFSObject.getNDFSOBJECTTYPE());
            callResult = iNDFSOTypeHelper.RemoveFSO(iNDActionContext, childNDFSObject);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        BaseDataEntity curData = this.getRealDEHelper().CreateDEObject();
        curData.SetParamValue(this.getRealDEHelper().GetKeyDEFHelper().getName(), (Object)ndFSObject.getNDFSOBJECTID());
        IDEDataCtrl realNDFSODataCtrl = iNDActionContext.getDEDataCtrl(this.getRealDEId());
        callResult = realNDFSODataCtrl.Remove(curData);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    public String CalcFSOFullPath(INDActionContext iNDActionContext, NDFSObject ndFSObject) throws Exception {
        IDEDataCtrl ndFSODataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        NDFSObject ndFSObject2 = new NDFSObject();
        ndFSObject.CopyTo(ndFSObject2, false);
        CallResult callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject2);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndFSObject2.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
        }
        String strFullPath = ndFSObject2.getNDFSOBJECTNAME();
        String strPFSOId = ndFSObject2.getPNDFSOBJECTID();
        while (!StringHelper.IsNullOrEmpty((String)strPFSOId)) {
            ndFSObject2.setNDFSOBJECTID(strPFSOId);
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
            }
            strFullPath = String.valueOf(ndFSObject2.getNDFSOBJECTNAME()) + "\\" + strFullPath;
            strPFSOId = ndFSObject2.getPNDFSOBJECTID();
        }
        return strFullPath;
    }

    @Override
    public String CalcFSOUniqueName(INDActionContext iNDActionContext, NDFSObject ndFSObject) throws Exception {
        NDFSObject ndFSObject2 = new NDFSObject();
        ndFSObject.CopyTo(ndFSObject2, false);
        String strOriginName = ndFSObject.getNDFSOBJECTNAME();
        if (StringHelper.IsNullOrEmpty((String)strOriginName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u5bf9\u8c61\u540d\u79f0");
        }
        String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
        String strParentFSOId = ndFSObject.getPNDFSOBJECTID();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strRootFSOId);
        String strSQLFormat = "SELECT COUNT(*) as CNT FROM T_SRFNDFSOBJECT t1 WHERE ( t1.NDFSOBJECTTYPE= 'FOLDER' OR t1.NDFSOBJECTTYPE= 'FILE' )  AND t1.ROOTNDFSOBJECTID = ? ";
        if (StringHelper.IsNullOrEmpty((String)strParentFSOId)) {
            strSQLFormat = String.valueOf(strSQLFormat) + "AND t1.PNDFSOBJECTID IS NULL ";
        } else {
            strSQLFormat = String.valueOf(strSQLFormat) + "AND t1.PNDFSOBJECTID = ? ";
            callParamList.Add((Object)strParentFSOId);
        }
        if (!StringHelper.IsNullOrEmpty((String)ndFSObject2.getNDFSOBJECTID())) {
            strSQLFormat = String.valueOf(strSQLFormat) + "AND t1.NDFSOBJECTID <> ? ";
            callParamList.Add((Object)ndFSObject2.getNDFSOBJECTID());
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        int i = 0;
        while (i < 10000) {
            String strNewName = this.CalcFSONewName(strOriginName, i);
            String strSQL = strSQLFormat;
            strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"AND UPPER(t1.NDFSOBJECTNAME) = '%1$s' ", (Object)strNewName.toUpperCase());
            CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iNDActionContext.getDBConnection(""), (String)"", (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)dataEntity);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u68c0\u67e5\u6587\u4ef6\u5bf9\u8c61\u540d\u79f0\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (dataEntity.GetParamIntValue("CNT", 0) == 0) {
                return strNewName;
            }
            ++i;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6709\u6548\u6587\u4ef6\u540d\u79f0"));
    }

    @Override
    public NDFSObject CalcFSObject(INDActionContext iNDActionContext, NDFSObject ndFSObject) throws Exception {
        NDFSObject ndFSObject2 = new NDFSObject();
        ndFSObject.CopyTo(ndFSObject2, false);
        String strOriginName = ndFSObject.getNDFSOBJECTNAME();
        if (StringHelper.IsNullOrEmpty((String)strOriginName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u5bf9\u8c61\u540d\u79f0");
        }
        String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
        String strParentFSOId = ndFSObject.getPNDFSOBJECTID();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strRootFSOId);
        String strSQLFormat = "SELECT t1.* FROM T_SRFNDFSOBJECT t1 WHERE ( t1.NDFSOBJECTTYPE= 'FOLDER' OR t1.NDFSOBJECTTYPE= 'FILE' )  AND t1.ROOTNDFSOBJECTID = ? ";
        if (StringHelper.IsNullOrEmpty((String)strParentFSOId)) {
            strSQLFormat = String.valueOf(strSQLFormat) + "AND t1.PNDFSOBJECTID IS NULL ";
        } else {
            strSQLFormat = String.valueOf(strSQLFormat) + "AND t1.PNDFSOBJECTID = ? ";
            callParamList.Add((Object)strParentFSOId);
        }
        if (!StringHelper.IsNullOrEmpty((String)ndFSObject2.getNDFSOBJECTID())) {
            strSQLFormat = String.valueOf(strSQLFormat) + "AND t1.NDFSOBJECTID <> ? ";
            callParamList.Add((Object)ndFSObject2.getNDFSOBJECTID());
        }
        String strNewName = strOriginName;
        String strSQL = strSQLFormat;
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"AND UPPER(t1.NDFSOBJECTNAME) = '%1$s' ", (Object)strNewName.toUpperCase());
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (Connection)iNDActionContext.getDBConnection(""), (String)"", (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)ndFSObject2);
        if (callResult.IsError()) {
            if (callResult.getRetCode() == 3) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61\u540d\u79f0\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return ndFSObject2;
    }

    protected String CalcFSONewName(String strOriginName, int i) {
        if (i == 0) {
            return strOriginName;
        }
        return StringHelper.Format((String)"%1$s(%2$s)", (Object)strOriginName, (Object)(i + 1));
    }

    @Override
    public void CopyFSO(INDActionContext iNDActionContext, NDFSObject copyNDFSObject, NDFSObject dstNDFSObject) throws Exception {
        if (!this.isEnableCopy()) {
            throw new Exception("\u6587\u4ef6\u5bf9\u8c61\u4e0d\u652f\u6301\u62f7\u8d1d");
        }
        String strDstNDFSOType = dstNDFSObject.getNDFSOBJECTTYPE();
        INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(strDstNDFSOType);
        if (iNDFSOTypeHelper.isLeafNode()) {
            throw new Exception("\u76ee\u6807\u6587\u4ef6\u5bf9\u8c61\u4e0d\u652f\u6301\u653e\u5165\u5185\u5bb9");
        }
        if (this.TestChildOfNDFSObject(iNDActionContext, dstNDFSObject, copyNDFSObject)) {
            throw new Exception("\u65e0\u6cd5\u5c06\u7236\u5185\u5bb9\u590d\u5236\u5230\u5b50\u5185\u5bb9\u4e2d");
        }
        this.OnCopyFSO(iNDActionContext, copyNDFSObject, dstNDFSObject);
    }

    protected boolean TestChildOfNDFSObject(INDActionContext iNDActionContext, NDFSObject testNDFSObject, NDFSObject dstNDFSObject) throws Exception {
        String strDstRootNDFSObjectId;
        String strTestRootNDFSObjectId = testNDFSObject.getROOTNDFSOBJECTID();
        if (StringHelper.IsNullOrEmpty((String)strTestRootNDFSObjectId)) {
            strTestRootNDFSObjectId = testNDFSObject.getNDFSOBJECTID();
        }
        if (StringHelper.IsNullOrEmpty((String)(strDstRootNDFSObjectId = dstNDFSObject.getROOTNDFSOBJECTID()))) {
            strDstRootNDFSObjectId = dstNDFSObject.getNDFSOBJECTID();
        }
        if (StringHelper.Compare((String)strTestRootNDFSObjectId, (String)strDstRootNDFSObjectId, (boolean)false) != 0) {
            return false;
        }
        INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(dstNDFSObject.getNDFSOBJECTTYPE());
        if (iNDFSOTypeHelper.isLeafNode()) {
            return false;
        }
        if (StringHelper.Compare((String)dstNDFSObject.getNDFSOBJECTID(), (String)strDstRootNDFSObjectId, (boolean)false) == 0) {
            return false;
        }
        NDFSObject testNDFSObject2 = new NDFSObject();
        testNDFSObject.CopyTo(testNDFSObject2, false);
        IDEDataCtrl ndFSODataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        String strPFSObjectId = testNDFSObject.getPNDFSOBJECTID();
        while (!StringHelper.IsNullOrEmpty((String)strPFSObjectId)) {
            if (StringHelper.Compare((String)strPFSObjectId, (String)dstNDFSObject.getNDFSOBJECTID(), (boolean)false) == 0) {
                return true;
            }
            testNDFSObject2.setNDFSOBJECTID(strPFSObjectId);
            CallResult callResult = ndFSODataCtrl.Get((BaseDataEntity)testNDFSObject2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)testNDFSObject2.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
            }
            strPFSObjectId = testNDFSObject2.getPNDFSOBJECTID();
        }
        return false;
    }

    protected void OnCopyFSO(INDActionContext iNDActionContext, NDFSObject copyNDFSObject, NDFSObject dstNDFSObject) throws Exception {
        INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(copyNDFSObject.getNDFSOBJECTTYPE());
        if (!iNDFSOTypeHelper.isEnableCopy()) {
            return;
        }
        NDFSObject cloneNDFSObject = iNDFSOTypeHelper.CloneFSOItem(iNDActionContext, copyNDFSObject, dstNDFSObject);
        if (iNDFSOTypeHelper.isLeafNode()) {
            return;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("PNDFSOBJECTID", (Object)copyNDFSObject.getNDFSOBJECTID());
        IDEDataCtrl ndFSODataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        Vector<NDFSObject> childNDFSObjectList = new Vector();
        CallResult callResult = ndFSODataCtrl.Select(cond, childNDFSObjectList, NDFSObject.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5b50\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)copyNDFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
        }
        for (NDFSObject childNDFSObject : childNDFSObjectList) {
            this.OnCopyFSO(iNDActionContext, childNDFSObject, cloneNDFSObject);
        }
    }

    @Override
    public NDFSObject CloneFSOItem(INDActionContext iNDActionContext, NDFSObject copyNDFSObject, NDFSObject dstNDFSObject) throws Exception {
        String strRealNDFSObjectName;
        BaseDataEntity realNDFSObject = this.getRealDEHelper().CreateDEObject();
        realNDFSObject.SetParamValue(this.getRealDEHelper().GetKeyDEFHelper().getName(), (Object)copyNDFSObject.getNDFSOBJECTID());
        IDEDataCtrl realNDFSODataCtrl = iNDActionContext.getDEDataCtrl(this.getRealDEId());
        CallResult callResult = realNDFSODataCtrl.Get(realNDFSObject);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6e90\u6587\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)copyNDFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
        }
        realNDFSObject.RemoveParam(this.getRealDEHelper().GetKeyDEFHelper().getName());
        String strCopyNDFSObjectName = copyNDFSObject.getNDFSOBJECTNAME();
        if (!StringHelper.IsNullOrEmpty((String)strCopyNDFSObjectName) && StringHelper.Compare((String)(strRealNDFSObjectName = realNDFSObject.GetParamStringValue(this.getRealDEHelper().GetMajorDEFHelper().getName(), "")), (String)strCopyNDFSObjectName, (boolean)false) != 0) {
            realNDFSObject.SetParamValue(this.getRealDEHelper().GetMajorDEFHelper().getName(), (Object)strCopyNDFSObjectName);
        }
        if (StringHelper.IsNullOrEmpty((String)dstNDFSObject.getROOTNDFSOBJECTID())) {
            realNDFSObject.SetParamValue("ROOTNDFSOBJECTID", (Object)dstNDFSObject.getNDFSOBJECTID());
            realNDFSObject.SetParamValue("ROOTNDFSOBJECTNAME", (Object)dstNDFSObject.getNDFSOBJECTNAME());
            realNDFSObject.SetParamValue("PNDFSOBJECTID", null);
            realNDFSObject.SetParamValue("PNDFSOBJECTNAME", null);
        } else {
            realNDFSObject.SetParamValue("ROOTNDFSOBJECTID", (Object)dstNDFSObject.getROOTNDFSOBJECTID());
            realNDFSObject.SetParamValue("ROOTNDFSOBJECTNAME", (Object)dstNDFSObject.getROOTNDFSOBJECTNAME());
            if (StringHelper.Compare((String)dstNDFSObject.getNDFSOBJECTID(), (String)dstNDFSObject.getROOTNDFSOBJECTID(), (boolean)false) != 0) {
                realNDFSObject.SetParamValue("PNDFSOBJECTID", (Object)dstNDFSObject.getNDFSOBJECTID());
                realNDFSObject.SetParamValue("PNDFSOBJECTNAME", (Object)dstNDFSObject.getNDFSOBJECTNAME());
            }
        }
        callResult = realNDFSODataCtrl.Save(true, realNDFSObject);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        NDFSObject cloneNDFSObject = new NDFSObject();
        realNDFSObject.CopyTo((BaseDataEntity)cloneNDFSObject, false);
        cloneNDFSObject.setNDFSOBJECTID(realNDFSObject.GetParamStringValue(this.getRealDEHelper().GetKeyDEFHelper().getName(), ""));
        cloneNDFSObject.setNDFSOBJECTNAME(realNDFSObject.GetParamStringValue(this.getRealDEHelper().GetMajorDEFHelper().getName(), ""));
        return cloneNDFSObject;
    }

    @Override
    public void MoveFSO(INDActionContext iNDActionContext, NDFSObject moveNDFSObject, NDFSObject dstNDFSObject) throws Exception {
        String strMoveRootNDFSObject;
        if (!this.isEnableMove()) {
            throw new Exception("\u6587\u4ef6\u5bf9\u8c61\u4e0d\u652f\u6301\u79fb\u52a8");
        }
        String strDstNDFSOType = dstNDFSObject.getNDFSOBJECTTYPE();
        INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(strDstNDFSOType);
        if (iNDFSOTypeHelper.isLeafNode()) {
            throw new Exception("\u76ee\u6807\u6587\u4ef6\u5bf9\u8c61\u4e0d\u652f\u6301\u653e\u5165\u5185\u5bb9");
        }
        String strDstRootNDFSObject = dstNDFSObject.getROOTNDFSOBJECTID();
        if (StringHelper.IsNullOrEmpty((String)strDstRootNDFSObject)) {
            strDstRootNDFSObject = dstNDFSObject.getNDFSOBJECTID();
        }
        if (StringHelper.IsNullOrEmpty((String)(strMoveRootNDFSObject = moveNDFSObject.getROOTNDFSOBJECTID()))) {
            strMoveRootNDFSObject = moveNDFSObject.getNDFSOBJECTID();
        }
        if (StringHelper.Compare((String)strMoveRootNDFSObject, (String)strDstRootNDFSObject, (boolean)false) == 0) {
            if (StringHelper.Compare((String)moveNDFSObject.getNDFSOBJECTID(), (String)dstNDFSObject.getNDFSOBJECTID(), (boolean)false) == 0) {
                throw new Exception("\u65e0\u6cd5\u5c06\u5f53\u524d\u5185\u5bb9\u79fb\u52a8\u5230\u5f53\u524d\u5185\u5bb9\u4e2d");
            }
            if (this.TestChildOfNDFSObject(iNDActionContext, dstNDFSObject, moveNDFSObject)) {
                throw new Exception("\u65e0\u6cd5\u5c06\u7236\u5185\u5bb9\u79fb\u52a8\u5230\u5b50\u5185\u5bb9\u4e2d");
            }
            BaseDataEntity realNDFSObject = this.getRealDEHelper().CreateDEObject();
            realNDFSObject.SetParamValue(this.getRealDEHelper().GetKeyDEFHelper().getName(), (Object)moveNDFSObject.getNDFSOBJECTID());
            if (StringHelper.Compare((String)dstNDFSObject.getNDFSOBJECTID(), (String)strDstRootNDFSObject, (boolean)false) != 0) {
                realNDFSObject.SetParamValue("PNDFSOBJECTID", (Object)dstNDFSObject.getNDFSOBJECTID());
                realNDFSObject.SetParamValue("PNDFSOBJECTNAME", (Object)dstNDFSObject.getNDFSOBJECTNAME());
            } else {
                realNDFSObject.SetParamValue("PNDFSOBJECTID", null);
                realNDFSObject.SetParamValue("PNDFSOBJECTNAME", null);
            }
            IDEDataCtrl realNDFSODataCtrl = iNDActionContext.getDEDataCtrl(this.getRealDEId());
            CallResult callResult = realNDFSODataCtrl.Save(false, realNDFSObject);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u79fb\u52a8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)moveNDFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
            }
        } else {
            this.CopyFSO(iNDActionContext, moveNDFSObject, dstNDFSObject);
            this.RemoveFSO(iNDActionContext, moveNDFSObject);
        }
    }
}

