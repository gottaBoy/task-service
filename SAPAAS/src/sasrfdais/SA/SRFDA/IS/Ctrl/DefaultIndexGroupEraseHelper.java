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
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.lucene.analysis.Analyzer
 *  org.apache.lucene.analysis.standard.StandardAnalyzer
 *  org.apache.lucene.index.CorruptIndexException
 *  org.apache.lucene.index.IndexWriter
 *  org.apache.lucene.index.IndexWriter$MaxFieldLength
 *  org.apache.lucene.index.Term
 *  org.apache.lucene.store.Directory
 *  org.apache.lucene.store.FSDirectory
 *  org.apache.lucene.util.Version
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.IS.Ctrl.Data.ISEraseItem;
import SA.SRFDA.IS.Ctrl.Data.ISGroup;
import SA.SRFDA.IS.Ctrl.DefaultEraseItemHelper;
import SA.SRFDA.IS.Ctrl.DefaultIndexContext;
import SA.SRFDA.IS.Ctrl.ISRFISIndexGroupEraseHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class DefaultIndexGroupEraseHelper
implements ISRFISIndexGroupEraseHelper {
    private static Log log = LogFactory.getLog(DefaultIndexGroupEraseHelper.class);

    @Override
    public CallResult Erase(ISRFDAGlobalHelper iGlobalHelper, String strIndexGroupId) {
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
        IDEDataCtrl isEraseItemDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("IS0005", "SYSTEM", null);
        if (isEraseItemDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"IS0005"));
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
            writer = new IndexWriter((Directory)FSDirectory.open((File)new File(strISFolder)), (Analyzer)new StandardAnalyzer(Version.LUCENE_30), false, IndexWriter.MaxFieldLength.LIMITED);
            Vector isEraseItems = new Vector();
            String strSQL = StringHelper.Format((String)"SELECT * from V_SRFISERASEITEM where UPPER(ISGROUPID)='%1$s'", (Object)strIndexGroupId.toUpperCase());
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iGlobalHelper, (String)iDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL, isEraseItems, (String)ISEraseItem.class.getName());
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)callResult.getErrorInfo(), (Object)strSQL));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            DefaultEraseItemHelper eraseItemHelper = new DefaultEraseItemHelper();
            for (ISEraseItem is : isEraseItems) {
                TreeMap<String, String> docMap;
                boolean nIndexCount = false;
                do {
                    if ((callResult = eraseItemHelper.Erase(defaultIndexContext, is, docMap = new TreeMap<String, String>())).IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6e05\u9664\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    for (String strValue : docMap.values()) {
                        writer.deleteDocuments(new Term("key", strValue));
                    }
                    callResult = eraseItemHelper.FinishErase(defaultIndexContext, is, docMap);
                    if (!callResult.IsError()) continue;
                    log.error((Object)StringHelper.Format((String)"\u5220\u9664\u6e05\u9664\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                } while (docMap.size() != 0);
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u6e05\u9664\u7d22\u5f15\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }
}

