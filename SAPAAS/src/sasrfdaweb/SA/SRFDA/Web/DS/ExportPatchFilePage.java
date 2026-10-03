/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.PatchItem
 *  SA.SRFDA.Ctrl.Data.PatchRemoveItem
 *  SA.SRFDA.Ctrl.Data.SqlPatchDetail
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.PatchItem;
import SA.SRFDA.Ctrl.Data.PatchRemoveItem;
import SA.SRFDA.Ctrl.Data.SqlPatchDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import com.jspsmart.upload.SmartUpload;
import java.util.Date;
import java.util.Vector;

public class ExportPatchFilePage
extends SRFDAPage {
    public ExportPatchFilePage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strUpdateDate = this.webContext.GetParamValue("n_updatedate_gtandeq");
        String strPatchGroup = this.webContext.GetParamValue("n_patchgroup_eq");
        try {
            XMLNode xmlNode;
            CallResult callResult;
            CallParamList callParamList;
            Date date = DateParser.Parse((String)strUpdateDate);
            Vector<XMLNode> exportXMLNodes = new Vector<XMLNode>();
            String strSQL = "";
            String strDAModelDB = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DAMODELDB", "");
            if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11110400) {
                callParamList = new CallParamList();
                callParamList.AddDateTime((Object)date);
                strSQL = StringHelper.Compare((String)strDAModelDB, (String)"MSSQL", (boolean)true) == 0 ? StringHelper.Format((String)"select t1.*,t2.SQLPATCHITEMNAME,t2.DEID from t_SRFSQLPATCHDETAIL t1 INNER JOIN T_SRFSQLPATCHITEM t2 on t1.SQLPATCHITEMID = t2.SQLPATCHITEMID where t2.UPDATEDATE >= ? AND t2.VALIDFLAG=1 AND dbo.fu_srfbitand(t2.PATCHGROUP,%1$s)<>0 ORDER BY t2.PATCHORDER,t1.ORDERFLAG  ", (Object)strPatchGroup) : StringHelper.Format((String)"select t1.*,t2.SQLPATCHITEMNAME,t2.DEID from t_SRFSQLPATCHDETAIL t1 INNER JOIN T_SRFSQLPATCHITEM t2 on t1.SQLPATCHITEMID = t2.SQLPATCHITEMID where t2.UPDATEDATE >= ? AND t2.VALIDFLAG=1 AND fu_srfbitand(t2.PATCHGROUP,%1$s)<>0 ORDER BY t2.PATCHORDER,t1.ORDERFLAG ", (Object)strPatchGroup);
                Vector<SqlPatchDetail> sqlPatchDetails = new Vector<SqlPatchDetail>();
                callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (Vector)callParamList.GetList(), sqlPatchDetails, (String)SqlPatchDetail.class.getName());
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u5e93\u8865\u4e01\u9879\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return;
                }
                for (SqlPatchDetail sqlPatchDetail : sqlPatchDetails) {
                    xmlNode = new XMLNode();
                    xmlNode.SetValue("SRFSQLPATCH", "TRUE");
                    xmlNode.SetValue("SRFDEID", sqlPatchDetail.GetParamStringValue("DEID", ""));
                    xmlNode.SetValue("SQLPATCHNAME", StringHelper.Format((String)"%1$s-%2$s", (Object)sqlPatchDetail.getSQLPATCHITEMNAME(), (Object)sqlPatchDetail.getSQLPATCHDETAILNAME()));
                    xmlNode.SetValue("DBTYPE", sqlPatchDetail.getDBTYPE());
                    xmlNode.SetValue("CHECKCODE", sqlPatchDetail.getCHECKCODE());
                    xmlNode.SetValue("SQLCODE", sqlPatchDetail.getSQLCODE());
                    xmlNode.SetValue("SQLCODE2", sqlPatchDetail.getSQLCODE2());
                    exportXMLNodes.add(xmlNode);
                }
            }
            if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 10121400) {
                callParamList = new CallParamList();
                callParamList.AddDateTime((Object)date);
                strSQL = StringHelper.Compare((String)strDAModelDB, (String)"MSSQL", (boolean)true) == 0 ? StringHelper.Format((String)"SELECT * FROM T_SRFPATCHREMOVEITEM WHERE UPDATEDATE >= ? AND VALIDFLAG=1 AND dbo.fu_srfbitand(PATCHGROUP,%1$s)<>0 ORDER BY UPDATEDATE ", (Object)strPatchGroup) : StringHelper.Format((String)"SELECT * FROM T_SRFPATCHREMOVEITEM WHERE UPDATEDATE >= ? AND  VALIDFLAG=1 AND fu_srfbitand(PATCHGROUP,%1$s)<>0 ORDER BY UPDATEDATE", (Object)strPatchGroup);
                Vector<PatchRemoveItem> patchRemoveItems = new Vector<PatchRemoveItem>();
                callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (Vector)callParamList.GetList(), patchRemoveItems, (String)PatchRemoveItem.class.getName());
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5220\u9664\u9879\u9879\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return;
                }
                for (PatchRemoveItem patchRemoveItem : patchRemoveItems) {
                    xmlNode = new XMLNode();
                    xmlNode.SetValue("SRFREMOVE", "TRUE");
                    xmlNode.SetValue("SRFDEID", patchRemoveItem.getDEID());
                    xmlNode.SetValue("SRFARG", patchRemoveItem.getKEYDATA());
                    exportXMLNodes.add(xmlNode);
                }
            }
            strSQL = StringHelper.Compare((String)strDAModelDB, (String)"MSSQL", (boolean)true) == 0 ? StringHelper.Format((String)"SELECT * FROM T_SRFPATCHITEM WHERE VALIDFLAG=1 AND dbo.fu_srfbitand(PATCHGROUP,%1$s)<>0 ORDER BY PATCHORDER", (Object)strPatchGroup) : StringHelper.Format((String)"SELECT * FROM T_SRFPATCHITEM WHERE VALIDFLAG=1 AND fu_srfbitand(PATCHGROUP,%1$s)<>0 ORDER BY PATCHORDER", (Object)strPatchGroup);
            Vector<PatchItem> patchItems = new Vector<PatchItem>();
            CallResult callResult2 = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, null, patchItems, (String)PatchItem.class.getName());
            if (callResult2.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u66f4\u65b0\u9879\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
                return;
            }
            for (PatchItem patchItem : patchItems) {
                this.PageLog((Object)this, 0, StringHelper.Format((String)"\u6b63\u5728\u5904\u7406\u8865\u4e01\u9879[%1$s]", (Object)patchItem.getPATCHITEMNAME()));
                IDEDataCtrl iDataCtrl = this.getDAModelStorage().FindDEDataCtrl(patchItem.getDEID(), (ISRFDAWebContext)this.getWebContext());
                if (iDataCtrl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)patchItem.getDEID()));
                    return;
                }
                String strKeyData = patchItem.getKEYDATA();
                if (patchItem.getISSQLCOND()) {
                    CallParamList callParamList2 = new CallParamList();
                    callParamList2.AddDateTime((Object)date);
                    String strSQL2 = StringHelper.Format((String)"SELECT * FROM %1$s ", (Object)iDataCtrl.GetDEHelper().GetMainTable());
                    if (StringHelper.Compare((String)strKeyData, (String)"*", (boolean)true) != 0) {
                        strSQL2 = String.valueOf(strSQL2) + " WHERE UPDATEDATE >= ? AND ";
                        strSQL2 = String.valueOf(strSQL2) + strKeyData;
                    } else {
                        strSQL2 = String.valueOf(strSQL2) + " WHERE ";
                        strSQL2 = String.valueOf(strSQL2) + "  UPDATEDATE >= ? ";
                    }
                    Vector<BaseDataEntity> items = new Vector<BaseDataEntity>();
                    callResult2 = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)iDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL2, (Vector)callParamList2.GetList(), items, (String)BaseDataEntity.class.getName());
                    if (callResult2.IsError()) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]SQL[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)patchItem.getDEID(), (Object)strSQL2, (Object)callResult2.getErrorInfo()));
                        return;
                    }
                    for (BaseDataEntity dataEntity : items) {
                        java.sql.Date updateDate = dataEntity.GetParamDateValue("UPDATEDATE", null);
                        if (updateDate == null) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u6700\u540e\u66f4\u65b0\u65f6\u95f4\u65e0\u6548\uff0c\u4e3b\u952e\u503c[%2$s]", (Object)patchItem.getDEID(), (Object)dataEntity.GetParamValue(iDataCtrl.GetDEHelper().GetKeyDEFHelper().getName()), (Object)callResult2.getErrorInfo()));
                            return;
                        }
                        if (updateDate.getTime() <= date.getTime()) continue;
                        this.PageLog((Object)this, 0, StringHelper.Format((String)"...\u5bfc\u51fa\u8865\u4e01\u9879[%1$s]", (Object)iDataCtrl.GetDEHelper().GetDataInfo(dataEntity)));
                        callResult2 = iDataCtrl.Export(dataEntity, exportXMLNodes, true, false);
                        if (!callResult2.IsError()) continue;
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f53[%1$s]\u6570\u636e\u4e3b\u952e\u503c[%2$s]\u5931\u8d25\uff0c%3$s", (Object)patchItem.getDEID(), (Object)dataEntity.GetParamValue(iDataCtrl.GetDEHelper().GetKeyDEFHelper().getName()), (Object)callResult2.getErrorInfo()));
                        return;
                    }
                    continue;
                }
                strKeyData = strKeyData.replace("\r", ";");
                strKeyData = strKeyData.replace("\n", ";");
                String[] keys = strKeyData.split("[;]");
                String[] stringArray = keys;
                int n = keys.length;
                int n2 = 0;
                while (n2 < n) {
                    String strKey = stringArray[n2];
                    if (!StringHelper.IsNullOrEmpty((String)strKey)) {
                        Object objKey = iDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(strKey);
                        if (objKey == null) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027\u503c[%2$s]\u65e0\u6548", (Object)patchItem.getDEID(), (Object)strKey));
                            return;
                        }
                        BaseDataEntity dataEntity = new BaseDataEntity();
                        dataEntity.SetParamValue(iDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), objKey);
                        callResult2 = iDataCtrl.Get(dataEntity);
                        if (callResult2.IsError()) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u83b7\u53d6\u4e3b\u952e\u503c[%2$s]\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)patchItem.getDEID(), (Object)strKey, (Object)callResult2.getErrorInfo()));
                            return;
                        }
                        java.sql.Date updateDate = dataEntity.GetParamDateValue("UPDATEDATE", null);
                        if (updateDate == null) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u6700\u540e\u66f4\u65b0\u65f6\u95f4\u65e0\u6548\uff0c\u4e3b\u952e\u503c[%2$s]", (Object)patchItem.getDEID(), (Object)strKey, (Object)callResult2.getErrorInfo()));
                            return;
                        }
                        if (updateDate.getTime() > date.getTime()) {
                            this.PageLog((Object)this, 0, StringHelper.Format((String)"...\u5bfc\u51fa\u8865\u4e01\u9879[%1$s]", (Object)iDataCtrl.GetDEHelper().GetDataInfo(dataEntity)));
                            callResult2 = iDataCtrl.Export(dataEntity, exportXMLNodes, true, false);
                            if (callResult2.IsError()) {
                                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f53[%1$s]\u6570\u636e\u4e3b\u952e\u503c[%2$s]\u5931\u8d25\uff0c%3$s", (Object)patchItem.getDEID(), (Object)strKey, (Object)callResult2.getErrorInfo()));
                                return;
                            }
                        }
                    }
                    ++n2;
                }
            }
            XMLNode rootNode = new XMLNode();
            rootNode.setNodeName("SRFDAXMLEXPORTS");
            for (XMLNode xmlNode2 : exportXMLNodes) {
                xmlNode2.setNodeName("SRFDAXMLEXPORT");
                rootNode.AddNode(xmlNode2);
            }
            String strTempId = Helper.GenGuidEx();
            String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.srfbak", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
            XMLNode.WriteToFile((XMLNode)rootNode, (String)strTempFilePath);
            String strNewFileName = new String(("patch_" + strTempId + ".srfbak").getBytes("GB2312"), "ISO-8859-1");
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.downloadFile(strTempFilePath, "", strNewFileName);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
