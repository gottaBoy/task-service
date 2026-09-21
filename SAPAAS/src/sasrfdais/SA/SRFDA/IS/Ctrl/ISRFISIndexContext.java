/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.lucene.index.CorruptIndexException
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.IS.Ctrl.IndexDocument;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.io.IOException;
import java.util.Vector;
import org.apache.lucene.index.CorruptIndexException;

public interface ISRFISIndexContext {
    public ISRFDAGlobalHelper getGlobalHelper();

    public void setLastIndexTag(String var1);

    public String getLastIndexTag();

    public int getMaxIndexCount();

    public void setFinishAll(boolean var1);

    public void IndexDocuments(Vector<IndexDocument> var1) throws CorruptIndexException, IOException;

    public int getIndexCount();

    public void ResetIndexCount();
}

