/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.lucene.document.DateTools
 *  org.apache.lucene.document.DateTools$Resolution
 *  org.apache.lucene.document.Document
 *  org.apache.lucene.document.Field
 *  org.apache.lucene.document.Field$Index
 *  org.apache.lucene.document.Field$Store
 *  org.apache.lucene.document.Fieldable
 *  org.apache.lucene.index.CorruptIndexException
 *  org.apache.lucene.index.IndexWriter
 *  org.apache.lucene.index.Term
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.IS.Ctrl.ISRFISIndexContext;
import SA.SRFDA.IS.Ctrl.IndexDocument;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

public class DefaultIndexContext
implements ISRFISIndexContext {
    private ISRFDAGlobalHelper globalHelper = null;
    private String strLastIndexTag = "";
    private int nMaxIndexCount = 5000;
    private boolean bFinishAll = true;
    private IndexWriter writer = null;
    private int nIndexCount = 0;

    @Override
    public ISRFDAGlobalHelper getGlobalHelper() {
        return this.globalHelper;
    }

    public void setGlobalHelper(ISRFDAGlobalHelper globalHelper) {
        this.globalHelper = globalHelper;
    }

    @Override
    public void setLastIndexTag(String strLastIndexTag) {
        this.strLastIndexTag = strLastIndexTag;
    }

    @Override
    public String getLastIndexTag() {
        return this.strLastIndexTag;
    }

    @Override
    public int getMaxIndexCount() {
        return this.nMaxIndexCount;
    }

    public boolean isFinishAll() {
        return this.bFinishAll;
    }

    public void setMaxIndexCount(int nMaxIndexCount) {
        this.nMaxIndexCount = nMaxIndexCount;
    }

    @Override
    public void setFinishAll(boolean bFinishAll) {
        this.bFinishAll = bFinishAll;
    }

    public IndexWriter getWriter() {
        return this.writer;
    }

    public void setWriter(IndexWriter writer) {
        this.writer = writer;
    }

    @Override
    public void IndexDocuments(Vector<IndexDocument> indexDocs) throws CorruptIndexException, IOException {
        String strIndexContent = "";
        for (IndexDocument indexdoc : indexDocs) {
            Document doc = new Document();
            doc.add((Fieldable)new Field("key", indexdoc.getKey(), Field.Store.YES, Field.Index.ANALYZED));
            doc.add((Fieldable)new Field("privkey", indexdoc.getPrivKey(), Field.Store.YES, Field.Index.ANALYZED));
            doc.add((Fieldable)new Field("type", indexdoc.getDocumentType(), Field.Store.YES, Field.Index.NOT_ANALYZED));
            doc.add((Fieldable)new Field("info", indexdoc.getMajorInfo(), Field.Store.YES, Field.Index.NOT_ANALYZED));
            doc.add((Fieldable)new Field("desc", indexdoc.getDescription(), Field.Store.YES, Field.Index.ANALYZED));
            doc.add((Fieldable)new Field("descashtml", indexdoc.isDescAsHTML() ? "1" : "0", Field.Store.YES, Field.Index.NOT_ANALYZED));
            doc.add((Fieldable)new Field("content", indexdoc.getContent(), Field.Store.NO, Field.Index.ANALYZED));
            if (indexdoc.getUpdateDate() != null) {
                doc.add((Fieldable)new Field("lastmodified", DateTools.timeToString((long)indexdoc.getUpdateDate().getTime(), (DateTools.Resolution)DateTools.Resolution.MINUTE), Field.Store.YES, Field.Index.NOT_ANALYZED));
                doc.add((Fieldable)new Field("lastmodified2", DateParser.toDateTimeString((Date)indexdoc.getUpdateDate()), Field.Store.YES, Field.Index.NOT_ANALYZED));
            }
            if (indexdoc.getExtFieldMap().size() > 0) {
                for (String strKey : indexdoc.getExtFieldMap().keySet()) {
                    doc.add((Fieldable)new Field(strKey, indexdoc.getExtFieldMap().get(strKey), Field.Store.YES, Field.Index.NOT_ANALYZED));
                }
            }
            this.writer.deleteDocuments(new Term("key", indexdoc.getKey()));
            this.writer.addDocument(doc);
            if (this.nIndexCount < 100) {
                if (!StringHelper.IsNullOrEmpty((String)strIndexContent)) {
                    strIndexContent = String.valueOf(strIndexContent) + "\r\n";
                }
                strIndexContent = String.valueOf(strIndexContent) + indexdoc.getMajorInfo();
            } else if (this.nIndexCount == 100) {
                strIndexContent = String.valueOf(strIndexContent) + "\r\n";
                strIndexContent = String.valueOf(strIndexContent) + "...";
            }
            ++this.nIndexCount;
        }
    }

    @Override
    public int getIndexCount() {
        return this.nIndexCount;
    }

    @Override
    public void ResetIndexCount() {
        this.nIndexCount = 0;
    }
}

