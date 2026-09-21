/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.lucene.analysis.Analyzer
 *  org.apache.lucene.index.Term
 *  org.apache.lucene.queryParser.QueryParser
 *  org.apache.lucene.search.Query
 *  org.apache.lucene.util.Version
 */
package SA.SRFDA.IS.Util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

public class JSJCQueryParser
extends QueryParser {
    public JSJCQueryParser(Version matchVersion, String f, Analyzer a) {
        super(matchVersion, f, a);
    }

    protected Query newTermQuery(Term term) {
        String strText = term.text();
        strText = strText.replace("srfdatag95", "_");
        strText = strText.replace("srfdatag45", "-");
        return super.newTermQuery(new Term(term.field(), strText));
    }
}

