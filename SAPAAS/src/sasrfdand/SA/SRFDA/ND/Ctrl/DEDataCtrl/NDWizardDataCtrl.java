/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDFolder;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.ND.Data.NDWizard;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class NDWizardDataCtrl
extends NDDEDataCtrl {
    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strWizardMode = webContext.GetParamValue("WIZARDMODE");
            NDActionContext iNDActionContext = new NDActionContext((IDEDataCtrl)this);
            INDUserModelStorage iNDUserModelStorage = SRFDANDWebCTXHelper.GetNDUserModelStorage(this.getWebContext());
            NDWizard ndWizard = new NDWizard();
            ndWizard.Proxy(dataEntity);
            dataEntity.SetParamValue("WIZARDMODE", (Object)strWizardMode);
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"CREATEFOLDER", (boolean)true) == 0) {
                NDFSObject pNDFSObject;
                String strRootFSOId = SRFDANDWebCTXHelper.GetNDRootFSOId(this.getWebContext());
                String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath(this.getWebContext());
                String strFolderPath = SRFDANDWebCTXHelper.GetNDFolderPath(this.getWebContext());
                ndWizard.setROOTNDFSOID(strRootFSOId);
                ndWizard.setROOTNDFSONAME(strRootPath);
                ndWizard.setCURPATH(strFolderPath);
                ndWizard.setUSERDATA(strRootFSOId);
                ndWizard.setUSERDATA2(strFolderPath);
                NDFolder ndFolder = new NDFolder();
                ndFolder.setNDFOLDERNAME(ndWizard.getNDWIZARDNAME());
                ndFolder.setROOTNDFSOBJECTID(ndWizard.getUSERDATA());
                ndFolder.setMEMO(ndWizard.getMEMO());
                if (!StringHelper.IsNullOrEmpty((String)strFolderPath) && (pNDFSObject = iNDUserModelStorage.FindNDFSObject(ndFolder.getROOTNDFSOBJECTID(), strFolderPath, false, true)) != null) {
                    ndFolder.setPNDFSOBJECTID(pNDFSObject.getNDFSOBJECTID());
                    ndFolder.setPNDFSOBJECTNAME(pNDFSObject.getNDFSOBJECTNAME());
                }
                NDFSObject ndFSObject = new NDFSObject();
                ndFSObject.setNDFSOBJECTID(ndFolder.getNDFOLDERID());
                ndFSObject.setNDFSOBJECTNAME(ndFolder.getNDFOLDERNAME());
                ndFSObject.setNDFSOBJECTTYPE("FOLDER");
                ndFSObject.setROOTNDFSOBJECTID(ndFolder.getROOTNDFSOBJECTID());
                if (!iNDUserModelStorage.TestFSOAction(iNDActionContext, ndFSObject, INDAccHelper.ACTION_CREATE)) {
                    callResult.setRetCode(2);
                    return callResult;
                }
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"CREATESHARE", (boolean)true) == 0) {
                String strFSOId = this.getWebContext().GetPostValue("srfdakeys");
                if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5171\u4eab\u5bf9\u8c61");
                }
                IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
                NDFSObject ndFSObject = new NDFSObject();
                ndFSObject.setNDFSOBJECTID(strFSOId);
                callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFSOId, (Object)callResult.getErrorInfo()));
                }
                String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
                INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
                String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath(this.getWebContext());
                String strFolderPath = iNDFSOTypeHelper.CalcFSOFullPath(iNDActionContext, ndFSObject);
                ndWizard.setNDWIZARDNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setROOTNDFSOID(strRootFSOId);
                ndWizard.setROOTNDFSONAME(strRootPath);
                ndWizard.setCURPATH(strFolderPath);
                ndWizard.setNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
                ndWizard.setNDFSOBJECTNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setUSERDATA(strRootFSOId);
                ndWizard.setUSERDATA2(strFolderPath);
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"RENAME", (boolean)true) == 0) {
                String strFSOId = this.getWebContext().GetPostValue("srfdakeys");
                if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u91cd\u547d\u540d\u5bf9\u8c61");
                }
                IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
                NDFSObject ndFSObject = new NDFSObject();
                ndFSObject.setNDFSOBJECTID(strFSOId);
                callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFSOId, (Object)callResult.getErrorInfo()));
                }
                String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
                String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath(this.getWebContext());
                ndWizard.setNDWIZARDNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setROOTNDFSOID(strRootFSOId);
                ndWizard.setROOTNDFSONAME(strRootPath);
                ndWizard.setCURPATH(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
                ndWizard.setNDFSOBJECTNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setUSERDATA(strRootFSOId);
                ndWizard.setUSERDATA2(ndFSObject.getNDFSOBJECTTYPE());
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"COPY", (boolean)true) == 0) {
                String strFSOId = this.getWebContext().GetPostValue("srfdakeys");
                if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u62f7\u8d1d\u5bf9\u8c61");
                }
                IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
                NDFSObject ndFSObject = new NDFSObject();
                ndFSObject.setNDFSOBJECTID(strFSOId);
                callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFSOId, (Object)callResult.getErrorInfo()));
                }
                String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
                INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
                String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath(this.getWebContext());
                String strFolderPath = iNDFSOTypeHelper.CalcFSOFullPath(iNDActionContext, ndFSObject);
                ndWizard.setNDWIZARDNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setROOTNDFSOID(strRootFSOId);
                ndWizard.setROOTNDFSONAME(strRootPath);
                ndWizard.setCURPATH(strFolderPath);
                ndWizard.setNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
                ndWizard.setNDFSOBJECTNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setUSERDATA(strRootFSOId);
                ndWizard.setUSERDATA2(strFolderPath);
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"MOVE", (boolean)true) == 0) {
                String strFSOId = this.getWebContext().GetPostValue("srfdakeys");
                if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u79fb\u52a8\u5bf9\u8c61");
                }
                IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
                NDFSObject ndFSObject = new NDFSObject();
                ndFSObject.setNDFSOBJECTID(strFSOId);
                callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFSOId, (Object)callResult.getErrorInfo()));
                }
                String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
                INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
                String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath(this.getWebContext());
                String strFolderPath = iNDFSOTypeHelper.CalcFSOFullPath(iNDActionContext, ndFSObject);
                ndWizard.setNDWIZARDNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setROOTNDFSOID(strRootFSOId);
                ndWizard.setROOTNDFSONAME(strRootPath);
                ndWizard.setCURPATH(strFolderPath);
                ndWizard.setNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
                ndWizard.setNDFSOBJECTNAME(ndFSObject.getNDFSOBJECTNAME());
                ndWizard.setUSERDATA(strRootFSOId);
                ndWizard.setUSERDATA2(strFolderPath);
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u9ed8\u8ba4\u503c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        NDWizard ndWizard = new NDWizard();
        ndWizard.Proxy(dataEntity);
        try {
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"CREATEFOLDER", (boolean)true) == 0) {
                NDFSObject pNDFSObject;
                NDFolder ndFolder = new NDFolder();
                ndFolder.setNDFOLDERNAME(ndWizard.getNDWIZARDNAME());
                ndFolder.setROOTNDFSOBJECTID(ndWizard.getUSERDATA());
                ndFolder.setMEMO(ndWizard.getMEMO());
                String strFolderPath = ndWizard.getUSERDATA2();
                if (!StringHelper.IsNullOrEmpty((String)strFolderPath) && (pNDFSObject = SRFDANDWebCTXHelper.GetNDUserModelStorage(this.getWebContext()).FindNDFSObject(ndFolder.getROOTNDFSOBJECTID(), strFolderPath, false, true)) != null) {
                    ndFolder.setPNDFSOBJECTID(pNDFSObject.getNDFSOBJECTID());
                    ndFolder.setPNDFSOBJECTNAME(pNDFSObject.getNDFSOBJECTNAME());
                }
                IDEDataCtrl ndFolderDataCtrl = this.GetRelatedDataCtrl("ND0012");
                callResult = ndFolderDataCtrl.Save(true, (BaseDataEntity)ndFolder);
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"CREATESHARE", (boolean)true) == 0) {
                NDShare ndShare = new NDShare();
                ndShare.setNDSHARENAME(ndWizard.getNDWIZARDNAME());
                ndShare.setROOTNDFSOBJECTID(ndWizard.getUSERDATA());
                ndShare.setMEMO(ndWizard.getMEMO());
                ndShare.setNDFSOBJECTID(ndWizard.getNDFSOBJECTID());
                IDEDataCtrl ndShareDataCtrl = this.GetRelatedDataCtrl("ND0030");
                callResult = ndShareDataCtrl.Save(true, (BaseDataEntity)ndShare);
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"RENAME", (boolean)true) == 0) {
                INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndWizard.getUSERDATA2());
                IDEDataCtrl realFSODataCtrl = this.GetRelatedDataCtrl(iNDFSOTypeHelper.getRealDEId());
                BaseDataEntity realNDFSObject = realFSODataCtrl.GetDEHelper().CreateDEObject();
                realNDFSObject.SetParamValue(realFSODataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)ndWizard.getNDFSOBJECTID());
                realNDFSObject.SetParamValue(realFSODataCtrl.GetDEHelper().GetMajorDEFHelper().getName(), (Object)ndWizard.getNDWIZARDNAME());
                realNDFSObject.SetParamValue("MEMO", (Object)ndWizard.getMEMO());
                callResult = realFSODataCtrl.Save(false, realNDFSObject);
                return callResult;
            }
            NDActionContext iNDActionContext = new NDActionContext((IDEDataCtrl)this);
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"COPY", (boolean)true) == 0) {
                IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
                NDFSObject copyNDFSObject = new NDFSObject();
                copyNDFSObject.setNDFSOBJECTID(ndWizard.getNDFSOBJECTID());
                callResult = ndFSODataCtrl.Get((BaseDataEntity)copyNDFSObject);
                if (callResult.IsError()) {
                    return callResult;
                }
                NDFSObject dstNDFSObject = new NDFSObject();
                dstNDFSObject.setNDFSOBJECTID(ndWizard.getDSTNDFSOBJECTID());
                callResult = ndFSODataCtrl.Get((BaseDataEntity)dstNDFSObject);
                if (callResult.IsError()) {
                    return callResult;
                }
                INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(copyNDFSObject.getNDFSOBJECTTYPE());
                iNDFSOTypeHelper.CopyFSO(iNDActionContext, copyNDFSObject, dstNDFSObject);
                return callResult;
            }
            if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"MOVE", (boolean)true) == 0) {
                IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
                NDFSObject copyNDFSObject = new NDFSObject();
                copyNDFSObject.setNDFSOBJECTID(ndWizard.getNDFSOBJECTID());
                callResult = ndFSODataCtrl.Get((BaseDataEntity)copyNDFSObject);
                if (callResult.IsError()) {
                    return callResult;
                }
                NDFSObject dstNDFSObject = new NDFSObject();
                dstNDFSObject.setNDFSOBJECTID(ndWizard.getDSTNDFSOBJECTID());
                callResult = ndFSODataCtrl.Get((BaseDataEntity)dstNDFSObject);
                if (callResult.IsError()) {
                    return callResult;
                }
                INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(copyNDFSObject.getNDFSOBJECTTYPE());
                iNDFSOTypeHelper.MoveFSO(iNDActionContext, copyNDFSObject, dstNDFSObject);
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
        return callResult;
    }
}

