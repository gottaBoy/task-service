/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataChangeDispatch;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDataSync;
import SA.SRFDA.Ctrl.Data.DataSyncOut;
import SA.SRFDA.Ctrl.Data.File;
import SA.SRFDA.Ctrl.IDEDataChangeDispatchParam;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDataSyncDispatch
extends BaseDEDataChangeDispatch {
    private static final Log log = LogFactory.getLog(DEDataSyncDispatch.class);

    @Override
    protected void OnDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
        IDEHelper iDEHelper = iDEDataChangeDispatchParam.getDEHelper();
        Vector<DEDataSync> deDataSyncs = iDEHelper.GetDEDataSyncs(false);
        if (deDataSyncs == null || deDataSyncs.size() == 0) {
            return;
        }
        IDEDataCtrl dataSyncOutDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0225", "SA.SRFDA.Ctrl.DEDataSyncDispatch");
        for (DEDataSync deDataSync : deDataSyncs) {
            CallResult callResult;
            String strFileFields;
            if (!this.OnTestDispatch(iDEDataChangeDispatchParam, deDataSync, dataSyncOutDataCtrl)) continue;
            DataSyncOut dataSyncOut = new DataSyncOut();
            iDEDataChangeDispatchParam.getDEDataChg().CopyTo(dataSyncOut, false);
            dataSyncOut.setSYNCAGENT(deDataSync.getSYNCAGENTOUT());
            BaseDEDataCtrl.SetCallParamCheckKey(dataSyncOut, false);
            BaseDEDataCtrl.SetCallParamDALog(dataSyncOut, false);
            BaseDEDataCtrl.SetCallParamRetData(dataSyncOut, false);
            if ((dataSyncOut.getEVENTTYPE() & 3) > 0 && !StringHelper.IsNullOrEmpty((String)(strFileFields = deDataSync.getFILEFIELDS()))) {
                Vector<String> fileIds = new Vector<String>();
                String[] fields = StringHelper.SplitEx((String)strFileFields);
                int i = 0;
                while (i < fields.length) {
                    String strField = fields[i];
                    String strFieldValue = iDEDataChangeDispatchParam.getLogicData().GetParamStringValue(strField, "");
                    if (!StringHelper.IsNullOrEmpty((String)strFieldValue)) {
                        if (strFieldValue.indexOf("<?xml") == 0) {
                            XMLNode fileListNode = new XMLNode();
                            XMLNode.LoadFromXML((String)strFieldValue, (XMLConfig)fileListNode);
                            if (fileListNode.getChildNodes() != null) {
                                for (XMLNode fileNode : fileListNode.getChildNodes()) {
                                    String strFileId = fileNode.GetExtValue("FILEID", "");
                                    if (StringHelper.IsNullOrEmpty((String)strFileId)) continue;
                                    fileIds.add(strFileId);
                                }
                            }
                        } else {
                            fileIds.add(strFieldValue);
                        }
                    }
                    ++i;
                }
                if (fileIds.size() > 0) {
                    String strFilePaths = "";
                    XMLNode dataNode = XMLNode.LoadFromXML((String)dataSyncOut.getDATA());
                    IDEDataCtrl fileDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0010", "SA.SRFDA.Ctrl.DEDataSyncDispatch");
                    for (String strFileId : fileIds) {
                        File file = new File();
                        file.setFILE_ID(strFileId);
                        CallResult callResult2 = fileDataCtrl.Get(file);
                        if (callResult2.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6587\u4ef6[%1$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strFileId, (Object)callResult2.getErrorInfo()));
                            continue;
                        }
                        String strFileData = BaseDataEntity.ToString((BaseDataEntity)file, (boolean)true);
                        XMLNode fileNode = new XMLNode();
                        fileNode.setNodeName("SRFDAXMLEXPORT");
                        fileNode.SetValue("SRFDEID", "DE0010");
                        fileNode.SetValue("SRFVALUE", strFileData);
                        dataNode.getChildNodes().add(fileNode);
                        String strFolder = file.getFOLDER();
                        String strLocalPath = file.getLOCALPATH();
                        if (StringHelper.IsNullOrEmpty((String)strLocalPath)) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strFolder)) {
                            strLocalPath = String.valueOf(strFolder) + java.io.File.separator + strLocalPath;
                        }
                        if (!StringHelper.IsNullOrEmpty((String)strFilePaths)) {
                            strFilePaths = String.valueOf(strFilePaths) + "|";
                        }
                        strFilePaths = String.valueOf(strFilePaths) + strLocalPath;
                    }
                    dataSyncOut.setDATA(XMLNode.Export((XMLNode)dataNode));
                    dataSyncOut.setFILELIST(strFilePaths);
                }
            }
            if (!(callResult = dataSyncOutDataCtrl.Save(true, dataSyncOut)).IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected boolean OnTestDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam, DEDataSync deDataSync, IDEDataCtrl dataSyncOutDataCtrl) throws Exception {
        if ((iDEDataChangeDispatchParam.getDEDataChg().getEVENTTYPE() & deDataSync.getEVENTTYPE()) == 0) {
            return false;
        }
        String strActionMode = deDataSync.GetParamStringValue("ACTIONMODE", "");
        if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
            return true;
        }
        CallResult callResult = dataSyncOutDataCtrl.CustomCall(strActionMode, iDEDataChangeDispatchParam.getLogicData());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u5224\u65ad\u662f\u5426\u540c\u6b65\u5b9e\u4f53\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        if (callResult.getUserObject() == null) {
            return false;
        }
        String strValue = callResult.getUserObject().toString();
        return StringHelper.Compare((String)strValue, (String)"1", (boolean)true) == 0;
    }
}

