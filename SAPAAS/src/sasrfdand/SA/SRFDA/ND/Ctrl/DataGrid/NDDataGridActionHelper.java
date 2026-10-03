/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.DataGrid.INDDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDDataGridActionHelper
extends BaseDADataGridActionHelper
implements INDDataGridActionHelper {
    private static final Log log = LogFactory.getLog(NDDataGridActionHelper.class);
    protected boolean bRemoveFlagCondition = true;
    protected boolean bRootFSObjectIdCondition = true;
    protected boolean bPFSObjectIdCondition = true;
    protected boolean bFSObjectTypeCondition = true;
    protected boolean bFSONameFilterCondition = true;
    public static final String DEBEHAVIOR_MOVETORECYCLE = "UID_20131210091237400212145676";
    public static final String DEBEHAVIOR_CREATEDOWNLOADURL = "UID_201312916583221300212142379";
    public static final String DEBEHAVIOR_MOVE = "UID_201312917245235200112142686";
    public static final String DEBEHAVIOR_COPY = "UID_201312917243634600112142684";

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        String strCondition;
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        if (this.bRootFSObjectIdCondition && !StringHelper.IsNullOrEmpty((String)(strCondition = this.OnGetRootFSObjectIdCondition(daQueryModelHelper)))) {
            userConditions.add(strCondition);
        }
        if (this.bPFSObjectIdCondition && !StringHelper.IsNullOrEmpty((String)(strCondition = this.OnGetPFSObjectIdCondition(daQueryModelHelper)))) {
            userConditions.add(strCondition);
        }
        if (this.bFSObjectTypeCondition && !StringHelper.IsNullOrEmpty((String)(strCondition = this.OnGetFSObjectTypeCondition(daQueryModelHelper)))) {
            userConditions.add(strCondition);
        }
        if (this.bRemoveFlagCondition && !StringHelper.IsNullOrEmpty((String)(strCondition = this.OnGetRemoveFlagCondition(daQueryModelHelper)))) {
            userConditions.add(strCondition);
        }
        if (this.bFSONameFilterCondition && !StringHelper.IsNullOrEmpty((String)(strCondition = this.OnGetFSONameFilterCondition(daQueryModelHelper)))) {
            userConditions.add(strCondition);
        }
    }

    protected String OnGetFSONameFilterCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        String strFilterName = this.getWebContext().GetPostValue("srfdandfilter");
        if (StringHelper.IsNullOrEmpty((String)strFilterName)) {
            return "";
        }
        IDEFHelper iDEFHelper = this.getDEHelper().GetMajorDEFHelper();
        String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "LIKE", strFilterName);
        return strCondition1;
    }

    protected String OnGetRootFSObjectIdCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("ROOTNDFSOBJECTID");
        String strValue = SRFDANDWebCTXHelper.GetNDRootFSOId((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = "INVALID_ROOTFSOBJECT";
        }
        String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strValue);
        return strCondition;
    }

    protected String OnGetPFSObjectIdCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("PNDFSOBJECTID");
        String strValue = SRFDANDWebCTXHelper.GetNDFolderPath((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "ISNULL", "");
            return strCondition;
        }
        try {
            String strRootNDFSObjectId = SRFDANDWebCTXHelper.GetNDRootFSOId((ISRFDAWebContext)this.getWebContext());
            if (StringHelper.IsNullOrEmpty((String)strRootNDFSObjectId)) {
                strRootNDFSObjectId = "INVALID_ROOTFSOBJECT";
            }
            NDFSObject pNDFSObject = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDFSObject(strRootNDFSObjectId, strValue, false, false);
            strValue = pNDFSObject.getNDFSOBJECTID();
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            strValue = "INVALID_PFSOBJECT";
        }
        String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strValue);
        return strCondition;
    }

    protected String OnGetFSObjectTypeCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("NDFSOBJECTTYPE");
        String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "FILE");
        String strCondition2 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "FOLDER");
        return StringHelper.Format((String)"(%1$s) OR (%2$s)", (Object)strCondition1, (Object)strCondition2);
    }

    protected String OnGetRemoveFlagCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("REMOVEFLAG");
        String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "ISNULL", "");
        String strCondition2 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "0");
        return StringHelper.Format((String)"(%1$s) OR (%2$s)", (Object)strCondition1, (Object)strCondition2);
    }

    protected String GetPagingSQL(BaseDAQueryModelHelper daQueryModelHelper, String strScript, int nStartRow, int nPageSize, String strSortParam, String strSortDirection, String strMinor, String strMinorDirection) {
        return super.GetPagingSQL(daQueryModelHelper, strScript, nStartRow, nPageSize, "NDFSOBJECTTYPE", "DESC", strSortParam, strSortDirection);
    }

    protected void OnDEBehavior(String strDEBehaviorId) {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)customActionResult);
        try {
            IDEDataCtrl ndFSODataCtrl = this.getPage().GetDEDataCtrl("ND0010");
            NDActionContext ndActionContext = new NDActionContext(ndFSODataCtrl);
            if (StringHelper.Compare((String)strDEBehaviorId, (String)DEBEHAVIOR_MOVETORECYCLE, (boolean)false) == 0) {
                String strKeys = this.getWebContext().GetPostValue("srfdakeys");
                CallResult callResult = this.OnTestFSObjectAction(ndActionContext, strKeys, INDAccHelper.ACTION_REMOVE);
                if (callResult.getRetCode() != 0) {
                    customActionResult.From(callResult);
                    this.getPage().Output(customActionResult.ToJSONString());
                    return;
                }
                super.OnDEBehavior(strDEBehaviorId);
                return;
            }
            if (StringHelper.Compare((String)strDEBehaviorId, (String)DEBEHAVIOR_MOVE, (boolean)false) == 0) {
                String strKeys = this.getWebContext().GetPostValue("srfdakeys");
                CallResult callResult = this.OnTestFSObjectAction(ndActionContext, strKeys, INDAccHelper.ACTION_WRITE | INDAccHelper.ACTION_REMOVE);
                if (callResult.getRetCode() != 0) {
                    customActionResult.From(callResult);
                    this.getPage().Output(customActionResult.ToJSONString());
                    return;
                }
                String strDstFSOId = this.getWebContext().GetPostValue("dstndfsobjectid");
                callResult = this.OnTestFSObjectAction(ndActionContext, strDstFSOId, INDAccHelper.ACTION_WRITE);
                if (callResult.getRetCode() != 0) {
                    customActionResult.From(callResult);
                    this.getPage().Output(customActionResult.ToJSONString());
                    return;
                }
                super.OnDEBehavior(strDEBehaviorId);
                return;
            }
            if (StringHelper.Compare((String)strDEBehaviorId, (String)DEBEHAVIOR_COPY, (boolean)false) == 0) {
                String strKeys = this.getWebContext().GetPostValue("srfdakeys");
                CallResult callResult = this.OnTestFSObjectAction(ndActionContext, strKeys, INDAccHelper.ACTION_READ);
                if (callResult.getRetCode() != 0) {
                    customActionResult.From(callResult);
                    this.getPage().Output(customActionResult.ToJSONString());
                    return;
                }
                String strDstFSOId = this.getWebContext().GetPostValue("dstndfsobjectid");
                callResult = this.OnTestFSObjectAction(ndActionContext, strDstFSOId, INDAccHelper.ACTION_WRITE);
                if (callResult.getRetCode() != 0) {
                    customActionResult.From(callResult);
                    this.getPage().Output(customActionResult.ToJSONString());
                    return;
                }
                super.OnDEBehavior(strDEBehaviorId);
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (StringHelper.Compare((String)strDEBehaviorId, (String)DEBEHAVIOR_CREATEDOWNLOADURL, (boolean)false) == 0) {
            this.OnCreateDownloadUrl();
            return;
        }
        super.OnDEBehavior(strDEBehaviorId);
    }

    protected CallResult OnTestFSObjectAction(INDActionContext iNDActionContext, String strKeys, int nTestActions) throws Exception {
        CallResult callResult = new CallResult();
        String[] fsoItems = null;
        if (!StringHelper.IsNullOrEmpty((String)strKeys)) {
            fsoItems = strKeys.split("[,]");
        }
        if (fsoItems == null) {
            return callResult;
        }
        IDEDataCtrl ndFSODataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        String[] stringArray = fsoItems;
        int n = fsoItems.length;
        int n2 = 0;
        while (n2 < n) {
            String strFSOItemId = stringArray[n2];
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(strFSOItemId);
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            if (!this.getNDUserModelStorage().TestFSOAction(iNDActionContext, ndFSObject, nTestActions)) {
                callResult.setRetCode(2);
                return callResult;
            }
            ++n2;
        }
        return callResult;
    }

    protected void OnCreateDownloadUrl() {
        String strDownloadURL;
        SRFExAjaxActionResult exportResult;
        block26: {
            Object ndShare;
            exportResult = new SRFExAjaxActionResult();
            strDownloadURL = "";
            ArrayList<NDFSObject> ndFSObjectList = new ArrayList<NDFSObject>();
            String strKeys = this.getWebContext().GetPostValue("srfdakeys");
            String[] keys = strKeys.split("[,]");
            IDEDataCtrl ndFSObjectDataCtrl = this.getPage().GetDEDataCtrl("ND0010");
            if (keys.length == 1) {
                String strNDFSObjectId = keys[0];
                NDFSObject ndFSObject = new NDFSObject();
                ndFSObject.setNDFSOBJECTID(strNDFSObjectId);
                CallResult callResult = ndFSObjectDataCtrl.Get((BaseDataEntity)ndFSObject);
                if (callResult.IsError()) {
                    exportResult.From(callResult);
                    this.getPage().Output(exportResult.ToJSONString());
                    return;
                }
                if (StringHelper.Compare((String)ndFSObject.getNDFSOBJECTTYPE(), (String)"SHARE", (boolean)false) == 0) {
                    ndShare = new NDShare();
                    ((NDShare)((Object)ndShare)).setNDSHAREID(ndFSObject.getNDFSOBJECTID());
                    IDEDataCtrl ndShareDataCtrl = this.getPage().GetDEDataCtrl("ND0030");
                    callResult = ndShareDataCtrl.Get((BaseDataEntity)ndShare);
                    if (callResult.IsError()) {
                        exportResult.From(callResult);
                        this.getPage().Output(exportResult.ToJSONString());
                        return;
                    }
                    ndFSObject.setNDFSOBJECTID(((NDShare)((Object)ndShare)).getNDFSOBJECTID());
                    callResult = ndFSObjectDataCtrl.Get((BaseDataEntity)ndFSObject);
                    if (callResult.IsError()) {
                        exportResult.From(callResult);
                        this.getPage().Output(exportResult.ToJSONString());
                        return;
                    }
                }
                if (StringHelper.Compare((String)ndFSObject.getNDFSOBJECTTYPE(), (String)"FILE", (boolean)false) == 0) {
                    strDownloadURL = StringHelper.Format((String)"'../srfnd/ndexportfile.jsp?NDFILEID=%1$s'", (Object)ndFSObject.getNDFSOBJECTID());
                } else {
                    ndFSObjectList.add(ndFSObject);
                }
            } else {
                String[] ndShareKeys = keys;
                int callResult = keys.length;
                int ndFSObject = 0;
                while (ndFSObject < callResult) {
                    String strKey;
                    String strNDFSObjectId = strKey = ndShareKeys[ndFSObject];
                    NDFSObject ndFSObject2 = new NDFSObject();
                    ndFSObject2.setNDFSOBJECTID(strNDFSObjectId);
                    CallResult callResult2 = ndFSObjectDataCtrl.Get((BaseDataEntity)ndFSObject2);
                    if (callResult2.IsError()) {
                        exportResult.From(callResult2);
                        this.getPage().Output(exportResult.ToJSONString());
                        return;
                    }
                    ndFSObjectList.add(ndFSObject2);
                    ++ndFSObject;
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strDownloadURL) && ndFSObjectList.size() > 0) {
                String strTimeFolder = StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)new Date(), (Object)Character.valueOf(File.separatorChar));
                String strFolder = StringHelper.Format((String)"%1$sRC%2$s%3$s%4$s%5$s%4$s%6$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)Character.valueOf(File.separatorChar), (Object)strTimeFolder, (Object)Character.valueOf(File.separatorChar), (Object)NDDataGridActionHelper.GetPersonIdHashString(this.getWebContext().getCurUserId()), (Object)this.getWebContext().getSessionId());
                String strFullZipName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.zip", (Object)strFolder, (Object)Character.valueOf(File.separatorChar), (Object)((NDFSObject)((Object)ndFSObjectList.get(0))).getNDFSOBJECTNAME(), (Object)(ndFSObjectList.size() > 0 ? "\u7b49" : ""));
                String strZipName = StringHelper.Format((String)"%1$s%2$s.zip", (Object)((NDFSObject)((Object)ndFSObjectList.get(0))).getNDFSOBJECTNAME(), (Object)(ndFSObjectList.size() > 0 ? "\u7b49" : ""));
                FileOutputStream fos = null;
                ZipOutputStream zos = null;
                try {
                    try {
                        fos = new FileOutputStream(strFullZipName);
                        zos = new ZipOutputStream(fos);
                        for (NDFSObject ndFSObject : ndFSObjectList) {
                            this.WriteZip(ndFSObject, "", zos);
                        }
                        strDownloadURL = StringHelper.Format((String)"'../srfnd/ndexportfile.jsp?ZIPFILE=%1$s'", (Object)URLEncoder.encode(strZipName, "UTF-8"));
                    }
                    catch (Exception e) {
                        log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e);
                        try {
                            if (zos != null) {
                                zos.close();
                            }
                            break block26;
                        }
                        catch (IOException e2) {
                            strDownloadURL = "";
                            log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e2);
                        }
                        break block26;
                    }
                }
                catch (Throwable throwable) {
                    try {
                        if (zos != null) {
                            zos.close();
                        }
                    }
                    catch (IOException e) {
                        strDownloadURL = "";
                        log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e);
                    }
                    throw throwable;
                }
                try {
                    if (zos != null) {
                        zos.close();
                    }
                }
                catch (IOException e) {
                    strDownloadURL = "";
                    log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e);
                }
            }
        }
        String strScript = "";
        strScript = StringHelper.IsNullOrEmpty((String)strDownloadURL) ? StringHelper.Format((String)"alert('\u65e0\u6cd5\u6253\u5305\u538b\u7f29\u6587\u4ef6');") : (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel()) ? StringHelper.Format((String)"SRFUtility.root().location=%1$s;", (Object)strDownloadURL) : StringHelper.Format((String)"SRFUtility.download(%1$s);", (Object)strDownloadURL));
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
    }

    private void WriteZip(NDFSObject ndFSObject, String strParentPath, ZipOutputStream zos) throws Exception {
        CallResult callResult;
        if (ndFSObject.getREMOVEFLAG()) {
            return;
        }
        if (StringHelper.Compare((String)ndFSObject.getNDFSOBJECTTYPE(), (String)"SHARE", (boolean)false) == 0) {
            NDShare ndShare = new NDShare();
            ndShare.setNDSHAREID(ndFSObject.getNDFSOBJECTID());
            IDEDataCtrl ndShareDataCtrl = this.getPage().GetDEDataCtrl("ND0030");
            callResult = ndShareDataCtrl.Get((BaseDataEntity)ndShare);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u76d8\u5171\u4eab[%1$s]\u53d1\u751f\u9519\u8bef,%2$s", (Object)ndShare.getNDSHAREID(), (Object)callResult.getErrorInfo()));
            }
            IDEDataCtrl ndFSObjectDataCtrl = this.getPage().GetDEDataCtrl("ND0010");
            ndFSObject.setNDFSOBJECTID(ndShare.getNDFSOBJECTID());
            callResult = ndFSObjectDataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u76d8\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef,%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
            }
        }
        if (StringHelper.Compare((String)ndFSObject.getNDFSOBJECTTYPE(), (String)"FOLDER", (boolean)false) == 0) {
            strParentPath = String.valueOf(strParentPath) + ndFSObject.getNDFSOBJECTNAME() + File.separator;
            NDFSObject cond = new NDFSObject();
            cond.setPNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
            cond.setROOTNDFSOBJECTID(ndFSObject.getROOTNDFSOBJECTID());
            IDEDataCtrl ndFSObjectDataCtrl = this.getPage().GetDEDataCtrl("ND0010");
            Vector<NDFSObject> childList = new Vector();
            CallResult callResult2 = ndFSObjectDataCtrl.Select((BaseDataEntity)cond, childList, NDFSObject.class.getName());
            if (callResult2.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2[%1$s]\u5b50\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult2.getErrorInfo()));
            }
            for (NDFSObject childNDFSObject : childList) {
                if (StringHelper.Compare((String)childNDFSObject.getNDFSOBJECTTYPE(), (String)"FILE", (boolean)false) != 0 && StringHelper.Compare((String)childNDFSObject.getNDFSOBJECTTYPE(), (String)"FOLDER", (boolean)false) != 0) continue;
                this.WriteZip(childNDFSObject, strParentPath, zos);
            }
            return;
        }
        if (StringHelper.Compare((String)ndFSObject.getNDFSOBJECTTYPE(), (String)"FILE", (boolean)false) == 0) {
            NDFile ndFile = new NDFile();
            ndFile.setNDFILEID(ndFSObject.getNDFSOBJECTID());
            IDEDataCtrl ndFileDataCtrl = this.getPage().GetDEDataCtrl("ND0013");
            callResult = ndFileDataCtrl.Get((BaseDataEntity)ndFile);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
            }
            SA.SRFDA.Ctrl.Data.File file = new SA.SRFDA.Ctrl.Data.File();
            file.setFILE_ID(ndFile.getFILEID());
            IDEDataCtrl fileDataCtrl = this.getPage().GetDEDataCtrl("DE0010");
            callResult = fileDataCtrl.Get((BaseDataEntity)file);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)file.getFILE_ID(), (Object)callResult.getErrorInfo()));
            }
            String strFileLocalPath = this.getWebContext().getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
            String strTempFilePath = String.valueOf(strFileLocalPath) + file.getLOCALPATH();
            FileInputStream fis = null;
            try {
                try {
                    int len;
                    fis = new FileInputStream(new File(strTempFilePath));
                    ZipEntry ze = new ZipEntry(String.valueOf(strParentPath) + ndFile.getNDFILENAME());
                    zos.putNextEntry(ze);
                    byte[] content = new byte[1024];
                    while ((len = fis.read(content)) != -1) {
                        zos.write(content, 0, len);
                        zos.flush();
                    }
                }
                catch (FileNotFoundException e) {
                    log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e);
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    }
                    catch (IOException e2) {
                        log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e2);
                    }
                }
                catch (IOException e) {
                    log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e);
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    }
                    catch (IOException e3) {
                        log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e3);
                    }
                }
            }
            finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                }
                catch (IOException e) {
                    log.error((Object)"\u521b\u5efaZIP\u6587\u4ef6\u5931\u8d25", (Throwable)e);
                }
            }
            return;
        }
    }

    private static String GetPersonIdHashString(String strPersonId) {
        if (strPersonId == null) {
            return "NULL";
        }
        int nCode = strPersonId.hashCode();
        return StringHelper.Format((String)"%1$s%2$s", (Object)(nCode >= 0 ? "A" : "B"), (Object)Math.abs(nCode));
    }

    protected boolean OnGetUserDP() {
        return false;
    }

    protected INDUserModelStorage getNDUserModelStorage() throws Exception {
        return SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext());
    }
}

