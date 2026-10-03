/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.lucene.analysis.Analyzer
 *  org.apache.lucene.analysis.standard.StandardAnalyzer
 *  org.apache.lucene.index.CorruptIndexException
 *  org.apache.lucene.index.IndexWriter
 *  org.apache.lucene.index.IndexWriter$MaxFieldLength
 *  org.apache.lucene.store.Directory
 *  org.apache.lucene.store.FSDirectory
 *  org.apache.lucene.util.Version
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.IS.Ctrl.Data.ISGroup;
import SA.SRFDA.IS.Ctrl.Data.ISIndexLog;
import SA.SRFDA.IS.Ctrl.Data.ISItem;
import SA.SRFDA.IS.Ctrl.Data.ISType;
import SA.SRFDA.IS.Ctrl.DefaultIndexContext;
import SA.SRFDA.IS.Ctrl.ISRFISIndexGroupHelper;
import SA.SRFDA.IS.Ctrl.ISRFISIndexItemHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class DefaultIndexGroupHelper
implements ISRFISIndexGroupHelper {
    private static Log log = LogFactory.getLog(DefaultIndexGroupHelper.class);

    @Override
    public CallResult Index(ISRFDAGlobalHelper iGlobalHelper, String strIndexGroupId, boolean bAll, Date fromDate) {
        CallResult callResult = new CallResult();
        DefaultIndexContext defaultIndexContext = new DefaultIndexContext();
        defaultIndexContext.setGlobalHelper(iGlobalHelper);
        IDEDataCtrl iDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0001", "SYSTEM", null);
        if (iDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0001"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl isTypeDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0002", "SYSTEM", null);
        if (isTypeDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0002"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl isIndexLogDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0020", "SYSTEM", null);
        if (isIndexLogDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0020"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl isItemDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0010", "SYSTEM", null);
        if (isItemDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0010"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        ISGroup isGroup = new ISGroup();
        isGroup.setISGROUPID(strIndexGroupId);
        callResult = iDataCtrl.Get((BaseDataEntity)isGroup);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7d22\u5f15\u7ec4\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strISFolder = iGlobalHelper.getWebExConfig().GetValue("SRFIS", "ISFOLDER", "");
        if (StringHelper.IsNullOrEmpty((String)strISFolder)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u7d22\u5f15\u7cfb\u7edf\u5b58\u50a8\u6839\u76ee\u5f55"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        strISFolder = String.valueOf(strISFolder) + strIndexGroupId;
        IndexWriter writer = null;
        try {
            writer = new IndexWriter((Directory)FSDirectory.open((File)new File(strISFolder)), (Analyzer)new StandardAnalyzer(Version.LUCENE_30), bAll, IndexWriter.MaxFieldLength.LIMITED);
            defaultIndexContext.setWriter(writer);
            Vector<ISItem> isItems = new Vector();
            String strSQL = StringHelper.Format((String)"SELECT * from V_SRFISITEM where UPPER(ISGROUPID)='%1$s'", (Object)strIndexGroupId.toUpperCase());
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iGlobalHelper, (String)iDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL, isItems, (String)ISItem.class.getName());
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)callResult.getErrorInfo(), (Object)strSQL));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            TreeMap<String, ISRFISIndexItemHelper> itemIndexHelperMap = new TreeMap<String, ISRFISIndexItemHelper>();
            for (ISItem isItem : isItems) {
                String strISType = isItem.getISITEMTYPE();
                ISRFISIndexItemHelper indexItemHelper = null;
                if (itemIndexHelperMap.containsKey(strISType)) {
                    indexItemHelper = (ISRFISIndexItemHelper)itemIndexHelperMap.get(strISType);
                } else {
                    ISType isType = new ISType();
                    isType.setISTYPEID(strISType);
                    callResult = isTypeDataCtrl.Get((BaseDataEntity)isType);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7d22\u5f15\u6570\u636e\u7c7b\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strISType, (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    String strHelperObject = isType.getHELPEROBJECT();
                    Object objHelper = ObjectHelper.Create((String)strHelperObject);
                    if (objHelper == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7d22\u5f15\u8f85\u52a9\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strHelperObject));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    if (!(objHelper instanceof ISRFISIndexItemHelper)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7d22\u5f15\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strHelperObject));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    indexItemHelper = (ISRFISIndexItemHelper)objHelper;
                    itemIndexHelperMap.put(strISType, indexItemHelper);
                }
                if (bAll) {
                    defaultIndexContext.setLastIndexTag("");
                } else {
                    defaultIndexContext.setLastIndexTag(isItem.getLASTINDEXTAG());
                }
                defaultIndexContext.setFinishAll(true);
                Timestamp startTime = new Timestamp(new Date().getTime());
                String strIndexContent = "";
                int nIndexCount = 0;
                defaultIndexContext.ResetIndexCount();
                callResult = indexItemHelper.Index(defaultIndexContext, isItem, bAll, fromDate, null);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u7d22\u5f15\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                log.info((Object)StringHelper.Format((String)"\u7d22\u5f15\u9879[%1$s]\uff0c\u6570\u91cf[%2$s]\uff0c\u5168\u90e8\u5b8c\u6210[%3$s]", (Object)isItem.getISITEMNAME(), (Object)defaultIndexContext.getIndexCount(), (Object)(defaultIndexContext.isFinishAll() ? "\u662f" : "\u5426")));
                Timestamp endTime = new Timestamp(new Date().getTime());
                ISIndexLog isIndexLog = new ISIndexLog();
                isIndexLog.setISITEMID(isItem.getISITEMID());
                isIndexLog.setINDEXCOUNT(nIndexCount += defaultIndexContext.getIndexCount());
                isIndexLog.setINDEXCONTENT(strIndexContent);
                isIndexLog.SetParamValue("STARTTIME", startTime);
                isIndexLog.SetParamValue("ENDTIME", endTime);
                callResult = isIndexLogDataCtrl.Save(true, (BaseDataEntity)isIndexLog);
                if (callResult.IsError()) {
                    writer.optimize();
                    writer.close();
                    log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u65e5\u5fd7\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                if (defaultIndexContext.isFinishAll()) {
                    isItem.SetParamValue("LASTINDEXTIME", startTime);
                } else if (bAll) {
                    isItem.SetParamValue("LASTINDEXTIME", null);
                }
                isItem.SetParamValue("LASTINDEXTAG", defaultIndexContext.getLastIndexTag());
                callResult = isItemDataCtrl.Save(false, (BaseDataEntity)isItem);
                if (!callResult.IsError()) continue;
                writer.optimize();
                writer.close();
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            writer.optimize();
            writer.close();
        }
        catch (Exception ex) {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (CorruptIndexException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                writer = null;
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u7d22\u5f15\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }
}

