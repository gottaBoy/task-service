/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.htmlparser.Node
 *  org.htmlparser.NodeFilter
 *  org.htmlparser.Parser
 *  org.htmlparser.util.NodeList
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.IS.Ctrl.Data.ISDEDataItem;
import SA.SRFDA.IS.Ctrl.Data.ISItem;
import SA.SRFDA.IS.Ctrl.ISRFISIndexContext;
import SA.SRFDA.IS.Ctrl.ISRFISIndexItemHelper;
import SA.SRFDA.IS.Ctrl.IndexDocument;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;

public class DEDataIndexHelper
implements ISRFISIndexItemHelper {
    private static Log log = LogFactory.getLog(DEDataIndexHelper.class);

    @Override
    public CallResult Index(ISRFISIndexContext context, ISItem tsItem, boolean bAll, Date fromDate, Vector<IndexDocument> docs) {
        CallResult callResult;
        block51: {
            SelectResult2 selectResult;
            IDEFHelper updateDateDEFHelper;
            callResult = new CallResult();
            IDEDataCtrl iDataCtrl = context.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IS0011", "SYSTEM", null);
            if (iDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0011"));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            ISDEDataItem deDataItem = new ISDEDataItem();
            deDataItem.setISDEDATAITEMID(tsItem.getISITEMID());
            callResult = iDataCtrl.Get((BaseDataEntity)deDataItem);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u7d22\u5f15\u9879\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEHelper iDEHelper = context.getGlobalHelper().getDAModelStorage().FindDEHelper(deDataItem.getDEID());
            if (iDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deDataItem.getDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String strDBStorage = "";
            int nPageSize = deDataItem.getPAGESIZE();
            if (nPageSize <= 0) {
                nPageSize = 500;
            }
            String strSortInfo = deDataItem.getPAGEORDERINFO();
            strSortInfo = strSortInfo.trim();
            CallParamList callParamList = new CallParamList();
            String strSQL = StringHelper.Format((String)"select * from %1$s ", (Object)iDEHelper.GetDEViewName());
            String strCond = "";
            if (iDEHelper.IsLogicValid()) {
                IDEFHelper iDEFHelper = iDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
                if (iDEFHelper != null) {
                    strCond = StringHelper.Format((String)" %1$s = %2$s ", (Object)iDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iDEHelper.GetProperty("VALIDVALUE"));
                } else {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)deDataItem.getDEID()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
            }
            if ((updateDateDEFHelper = iDEHelper.GetDEFHelperByPreDefineType("UPDATEDATE")) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u66f4\u65b0\u65f6\u95f4\u5c5e\u6027", (Object)deDataItem.getDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)deDataItem.getEXTCOND())) {
                if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                    strCond = String.valueOf(strCond) + " AND ";
                }
                strCond = String.valueOf(strCond) + deDataItem.getEXTCOND();
            }
            if (fromDate == null && deDataItem.getLASTINDEXTIME() == null) {
                bAll = true;
            }
            if (!bAll) {
                if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                    strCond = String.valueOf(strCond) + " AND ";
                }
                strCond = String.valueOf(strCond) + StringHelper.Format((String)" %1$s >= ? ", (Object)updateDateDEFHelper.GetDTColumn().GetFormalColumnName());
                if (fromDate != null) {
                    callParamList.AddDateTime((Object)fromDate);
                } else {
                    callParamList.AddDateTime((Object)deDataItem.getLASTINDEXTIME());
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                strSQL = String.valueOf(strSQL) + " WHERE ";
                strSQL = String.valueOf(strSQL) + strCond;
            }
            String[] indexFields = deDataItem.getINDEXFIELD().split("[|]");
            String[] descFields = deDataItem.getDESCFIELD().split("[|]");
            String[] privFields = deDataItem.getPRIVFIELD().split("[|]");
            TreeMap<String, String> extFieldMap = new TreeMap<String, String>();
            String strExtFields = deDataItem.getEXTFIELD();
            if (!StringHelper.IsNullOrEmpty((String)strExtFields)) {
                String[] extFields = strExtFields.split("[|]");
                int i = 0;
                while (i < extFields.length) {
                    String strExtField = extFields[i];
                    if (!StringHelper.IsNullOrEmpty((String)strExtField)) {
                        String[] fields = strExtField.split("[:]");
                        if (fields.length == 1) {
                            extFieldMap.put(fields[0].toLowerCase(), fields[0].toUpperCase());
                        } else {
                            extFieldMap.put(fields[0].toLowerCase(), fields[1].toUpperCase());
                        }
                    }
                    ++i;
                }
            }
            int nTotalRowCount = 0;
            if (!StringHelper.IsNullOrEmpty((String)strSortInfo)) {
                strSQL = String.valueOf(strSQL) + StringHelper.Format((String)" ORDER BY %1$s", (Object)strSortInfo);
            }
            if ((selectResult = BaseDEDataCtrl.SelectMultiExReturnRS((ISRFDAGlobalHelper)context.getGlobalHelper(), null, (String)strDBStorage, (String)strSQL, (Vector)callParamList.GetList())) == null || selectResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo())));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            try {
                try {
                    int nReadSize;
                    int PAGESIZE = nPageSize;
                    Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
                    Vector<IndexDocument> indexDocuments = new Vector<IndexDocument>();
                    BaseDataEntity[] cacheDataEntities = null;
                    do {
                        int i;
                        indexDocuments.clear();
                        dataEntities.clear();
                        nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                        if (nReadSize > 0 && cacheDataEntities == null) {
                            cacheDataEntities = new BaseDataEntity[nReadSize];
                            i = 0;
                            while (i < nReadSize) {
                                cacheDataEntities[i] = new BaseDataEntity();
                                ++i;
                            }
                        }
                        i = 0;
                        while (i < selectResult.getMainTable().GetRowCount()) {
                            DataRow dr = selectResult.getMainTable().GetRow(i);
                            BaseDataEntity dataEntity = cacheDataEntities[i];
                            dataEntity.FromDataRow(dr, true);
                            dataEntities.add(dataEntity);
                            ++i;
                        }
                        log.debug((Object)StringHelper.Format((String)"\u8bfb\u53d6\u8bb0\u5f55\u6570[%1$s]\uff0c\u603b\u8bb0\u5f55\u6570[%2$s]", (Object)nReadSize, (Object)(nTotalRowCount += nReadSize)));
                        if (nReadSize == 0) {
                            context.setFinishAll(true);
                            context.setLastIndexTag("");
                            break block51;
                        }
                        i = 0;
                        while (i < nReadSize) {
                            String strValue;
                            BaseDataEntity dataEntity = (BaseDataEntity)dataEntities.get(i);
                            IndexDocument indexDocument = new IndexDocument();
                            String strKey = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)"DEDATA", (Object)iDEHelper.getId(), (Object)dataEntity.GetParamValue(iDEHelper.GetKeyDEFHelper().getName()));
                            String strMajorInfo = StringHelper.Format((String)"%1$s", (Object)iDEHelper.GetDataInfo(dataEntity));
                            String strType = iDEHelper.getLogicName();
                            indexDocument.setKey(strKey);
                            indexDocument.setDocumentType(strType);
                            indexDocument.setMajorInfo(strMajorInfo);
                            String strContent = "";
                            int j = 0;
                            while (j < indexFields.length) {
                                String strIndexField = indexFields[j];
                                if (!StringHelper.IsNullOrEmpty((String)strIndexField)) {
                                    IDEFHelper iDEFHelper;
                                    String strObjectValue = dataEntity.GetParamStringValue(strIndexField, "");
                                    if (!StringHelper.IsNullOrEmpty((String)strContent)) {
                                        strContent = String.valueOf(strContent) + " ";
                                    }
                                    if ((iDEFHelper = iDEHelper.GetDEFHelper(strIndexField)) != null && !StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                                        CodeListConfig codeListConfig = context.getGlobalHelper().getCodeListMgr().GetCodeListConfig(iDEFHelper.GetCodeList());
                                        if (codeListConfig == null) {
                                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)iDEFHelper.GetCodeList()));
                                        }
                                        strObjectValue = codeListConfig.GetCodeListValue(strObjectValue, true);
                                    }
                                    if (!StringHelper.IsNullOrEmpty((String)strObjectValue)) {
                                        strObjectValue = DEDataIndexHelper.ExtractText(strObjectValue);
                                    }
                                    strContent = String.valueOf(strContent) + strObjectValue;
                                }
                                ++j;
                            }
                            indexDocument.setContent(strContent);
                            if (descFields.length > 0) {
                                Object[] values = new Object[descFields.length];
                                int k = 0;
                                while (k < descFields.length) {
                                    values[k] = dataEntity.GetParamValue(descFields[k]);
                                    if (values[k] != null) {
                                        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(descFields[k]);
                                        if (iDEFHelper != null && !StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                                            CodeListConfig codeListConfig = context.getGlobalHelper().getCodeListMgr().GetCodeListConfig(iDEFHelper.GetCodeList());
                                            if (codeListConfig == null) {
                                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)iDEFHelper.GetCodeList()));
                                            }
                                            values[k] = codeListConfig.GetCodeListValue(values[k].toString(), true);
                                        }
                                        if (values[k] instanceof String) {
                                            strValue = (String)values[k];
                                            strValue = DEDataIndexHelper.ExtractText(strValue);
                                            values[k] = strValue;
                                        }
                                    }
                                    ++k;
                                }
                                String strDescFormat = deDataItem.getDESCFORMAT();
                                String strDesc = StringHelper.Format((String)strDescFormat, (Object[])values);
                                indexDocument.setDescription(strDesc);
                            }
                            if (privFields.length > 0) {
                                Object[] values = new Object[privFields.length];
                                int k = 0;
                                while (k < privFields.length) {
                                    values[k] = dataEntity.GetParamValue(privFields[k]);
                                    ++k;
                                }
                                String strPrivFormat = deDataItem.getPRIVFORMAT();
                                String strPrivKey = StringHelper.Format((String)strPrivFormat, (Object[])values);
                                indexDocument.setPrivKey(strPrivKey);
                            } else {
                                indexDocument.setPrivKey(deDataItem.getPRIVFORMAT());
                            }
                            indexDocument.setUpdateDate(dataEntity.GetParamDateValue(updateDateDEFHelper.getName(), null));
                            indexDocument.setDescAsHTML(deDataItem.getDESCASHTML());
                            if (extFieldMap.size() > 0) {
                                for (String strFieldKey : extFieldMap.keySet()) {
                                    String strParam = (String)extFieldMap.get(strFieldKey);
                                    strValue = dataEntity.GetParamStringValue(strParam, "");
                                    indexDocument.getExtFieldMap().put(strFieldKey, strValue);
                                }
                            }
                            indexDocuments.add(indexDocument);
                            ++i;
                        }
                        context.IndexDocuments(indexDocuments);
                    } while (nReadSize >= PAGESIZE);
                    context.setFinishAll(true);
                    context.setLastIndexTag("");
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8bbf\u95ee\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
                    log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                    selectResult.Close();
                }
            }
            finally {
                selectResult.Close();
            }
        }
        return callResult;
    }

    private static String ExtractText(String inputHtml) {
        StringBuffer text = new StringBuffer();
        try {
            Parser parser = Parser.createParser((String)new String(inputHtml.getBytes(), "8859_1"), (String)"8859-1");
            NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter(){

                public boolean accept(Node node) {
                    return true;
                }
            });
            boolean bFirst = true;
            int i = 0;
            while (i < nodes.size()) {
                Node node = nodes.elementAt(i);
                String strContent = new String(node.toPlainTextString().getBytes("8859_1"));
                if (!StringHelper.IsNullOrEmpty((String)strContent)) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        text.append(" ");
                    }
                    text.append(strContent);
                }
                ++i;
            }
            return text.toString();
        }
        catch (Exception ex) {
            return inputHtml;
        }
    }
}

