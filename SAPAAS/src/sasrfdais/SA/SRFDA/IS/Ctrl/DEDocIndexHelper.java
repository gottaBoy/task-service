/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
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
 *  org.htmlparser.nodes.TextNode
 *  org.htmlparser.tags.ScriptTag
 *  org.htmlparser.util.NodeList
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.IS.Ctrl.Data.ISDEDocItem;
import SA.SRFDA.IS.Ctrl.Data.ISFolder;
import SA.SRFDA.IS.Ctrl.Data.ISItem;
import SA.SRFDA.IS.Ctrl.ISRFISIndexContext;
import SA.SRFDA.IS.Ctrl.ISRFISIndexItemHelper;
import SA.SRFDA.IS.Ctrl.IndexDocument;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeList;

public class DEDocIndexHelper
implements ISRFISIndexItemHelper {
    private static Log log = LogFactory.getLog(DEDocIndexHelper.class);

    @Override
    public CallResult Index(ISRFISIndexContext context, ISItem tsItem, boolean bAll, Date fromDate, Vector<IndexDocument> docs) {
        CallResult callResult;
        block43: {
            SelectResult2 selectResult;
            IDEFHelper updateDateDEFHelper;
            callResult = new CallResult();
            IDEDataCtrl iDataCtrl = context.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IS0012", "SYSTEM", null);
            if (iDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0012"));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            ISDEDocItem deDocItem = new ISDEDocItem();
            deDocItem.setISDEDOCITEMID(tsItem.getISITEMID());
            callResult = iDataCtrl.Get((BaseDataEntity)deDocItem);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u7d22\u5f15\u9879\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEDataCtrl isFolderDataCtrl = context.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IS0003", "SYSTEM", null);
            if (isFolderDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0003"));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            ISFolder isFolder = new ISFolder();
            isFolder.setISFOLDERID(deDocItem.getISFOLDERID());
            callResult = isFolderDataCtrl.Get((BaseDataEntity)isFolder);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7d22\u5f15\u76ee\u5f55[%1$s]\u5931\u8d25\uff0c%2$s", (Object)deDocItem.getISFOLDERID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEHelper iDEHelper = context.getGlobalHelper().getDAModelStorage().FindDEHelper(deDocItem.getDEID());
            if (iDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deDocItem.getDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String strDBStorage = "";
            int nPageSize = deDocItem.getPAGESIZE();
            if (nPageSize <= 0) {
                nPageSize = 500;
            }
            String strSortInfo = deDocItem.getPAGEORDERINFO();
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
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)deDocItem.getDEID()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
            }
            if ((updateDateDEFHelper = iDEHelper.GetDEFHelperByPreDefineType("UPDATEDATE")) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u66f4\u65b0\u65f6\u95f4\u5c5e\u6027", (Object)deDocItem.getDEID()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)deDocItem.getEXTCOND())) {
                if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                    strCond = String.valueOf(strCond) + " AND ";
                }
                strCond = String.valueOf(strCond) + deDocItem.getEXTCOND();
            }
            if (fromDate == null && deDocItem.getLASTINDEXTIME() == null) {
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
                    callParamList.AddDateTime((Object)deDocItem.getLASTINDEXTIME());
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                strSQL = String.valueOf(strSQL) + " WHERE ";
                strSQL = String.valueOf(strSQL) + strCond;
            }
            String[] privFields = deDocItem.getPRIVFIELD().split("[|]");
            TreeMap<String, String> extFieldMap = new TreeMap<String, String>();
            String strExtFields = deDocItem.getEXTFIELD();
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
                            break block43;
                        }
                        i = 0;
                        while (i < nReadSize) {
                            BaseDataEntity dataEntity = (BaseDataEntity)dataEntities.get(i);
                            IndexDocument indexDocument = new IndexDocument();
                            String strKey = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)"DEDOC", (Object)iDEHelper.getId(), (Object)dataEntity.GetParamValue(iDEHelper.GetKeyDEFHelper().getName()));
                            String strMajorInfo = StringHelper.Format((String)"%1$s", (Object)iDEHelper.GetDataInfo(dataEntity));
                            String strType = iDEHelper.getLogicName();
                            indexDocument.setKey(strKey);
                            indexDocument.setDocumentType(strType);
                            indexDocument.setMajorInfo(strMajorInfo);
                            String strContent = "";
                            String strFilePath = dataEntity.GetParamStringValue(deDocItem.getPATHFIELD(), "");
                            String strTotalPath = String.valueOf(isFolder.getFOLDERPATH()) + strFilePath;
                            callResult = this.ExtractFileText(strTotalPath);
                            if (callResult.IsError()) {
                                log.error((Object)StringHelper.Format((String)"\u63d0\u53d6\u6587\u4ef6[%1$s]\u5185\u5bb9\u5931\u8d25\uff0c%2$s", (Object)strTotalPath, (Object)callResult.getErrorInfo()));
                            } else {
                                strContent = (String)callResult.getUserObject();
                                indexDocument.setContent(strContent);
                                indexDocument.setDescription(strContent);
                                if (privFields.length > 0) {
                                    Object[] values = new Object[privFields.length];
                                    int k = 0;
                                    while (k < privFields.length) {
                                        values[k] = dataEntity.GetParamValue(privFields[k]);
                                        ++k;
                                    }
                                    String strPrivFormat = deDocItem.getPRIVFORMAT();
                                    String strPrivKey = StringHelper.Format((String)strPrivFormat, (Object[])values);
                                    indexDocument.setPrivKey(strPrivKey);
                                } else {
                                    indexDocument.setPrivKey(deDocItem.getPRIVFORMAT());
                                }
                                indexDocument.setUpdateDate(dataEntity.GetParamDateValue(updateDateDEFHelper.getName(), null));
                                indexDocument.setDescAsHTML(false);
                                if (extFieldMap.size() > 0) {
                                    for (String strFieldKey : extFieldMap.keySet()) {
                                        String strParam = (String)extFieldMap.get(strFieldKey);
                                        String strValue = dataEntity.GetParamStringValue(strParam, "");
                                        indexDocument.getExtFieldMap().put(strFieldKey, strValue);
                                    }
                                }
                                indexDocuments.add(indexDocument);
                            }
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

    protected CallResult ExtractFileText(String strPath) {
        CallResult callResult = new CallResult();
        int nPos = strPath.lastIndexOf(".");
        if (nPos == -1) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u7d22\u5f15\u6587\u4ef6\u8def\u5f84[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6587\u4ef6\u540e\u7f00", (Object)strPath));
            return callResult;
        }
        String strContent = "";
        String strExt = strPath.substring(nPos + 1);
        if (StringHelper.Compare((String)strExt, (String)"HTML", (boolean)true) == 0 || StringHelper.Compare((String)strExt, (String)"HTM", (boolean)true) == 0 || StringHelper.Compare((String)strExt, (String)"JSP", (boolean)true) == 0 || StringHelper.Compare((String)strExt, (String)"SHTML", (boolean)true) == 0 || StringHelper.Compare((String)strExt, (String)"ASP", (boolean)true) == 0 || StringHelper.Compare((String)strExt, (String)"ASPX", (boolean)true) == 0 || StringHelper.Compare((String)strExt, (String)"DO", (boolean)true) == 0) {
            strContent = DEDocIndexHelper.ExtractHtmlText(strPath);
            callResult.setUserObject((Object)strContent);
            return callResult;
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540e\u7f00[%1$s]", (Object)strExt));
        return callResult;
    }

    private static String ExtractHtmlText(String strPath) {
        StringBuffer text = new StringBuffer();
        try {
            FileInputStream in = new FileInputStream(strPath);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] tmpbuf = new byte[1024];
            int count = 0;
            while ((count = in.read(tmpbuf)) != -1) {
                bout.write(tmpbuf, 0, count);
            }
            in.close();
            byte[] orgData = bout.toByteArray();
            Parser parser = Parser.createParser((String)new String(orgData, "UTF-8"), (String)"8859-1");
            NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter(){

                public boolean accept(Node node) {
                    if (node instanceof TextNode) {
                        TextNode textNode = (TextNode)node;
                        return textNode.getParent() == null || !(textNode.getParent() instanceof ScriptTag);
                    }
                    return false;
                }
            });
            boolean bFirst = true;
            int i = 0;
            while (i < nodes.size()) {
                String strContent;
                TextNode textNode;
                Node node = nodes.elementAt(i);
                if (!(!(node instanceof TextNode) || (textNode = (TextNode)node).getParent() != null && textNode.getParent() instanceof ScriptTag || StringHelper.IsNullOrEmpty((String)(strContent = node.toPlainTextString())))) {
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
            return "";
        }
    }
}

