/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.lucene.analysis.Analyzer
 *  org.apache.lucene.analysis.TokenStream
 *  org.apache.lucene.analysis.standard.StandardAnalyzer
 *  org.apache.lucene.document.Document
 *  org.apache.lucene.index.FilterIndexReader
 *  org.apache.lucene.index.IndexReader
 *  org.apache.lucene.queryParser.QueryParser
 *  org.apache.lucene.search.BooleanQuery
 *  org.apache.lucene.search.Collector
 *  org.apache.lucene.search.IndexSearcher
 *  org.apache.lucene.search.MultiSearcher
 *  org.apache.lucene.search.Query
 *  org.apache.lucene.search.ScoreDoc
 *  org.apache.lucene.search.Searchable
 *  org.apache.lucene.search.Searcher
 *  org.apache.lucene.search.TopScoreDocCollector
 *  org.apache.lucene.search.highlight.Formatter
 *  org.apache.lucene.search.highlight.Fragmenter
 *  org.apache.lucene.search.highlight.Highlighter
 *  org.apache.lucene.search.highlight.QueryScorer
 *  org.apache.lucene.search.highlight.Scorer
 *  org.apache.lucene.search.highlight.SimpleFragmenter
 *  org.apache.lucene.search.highlight.SimpleHTMLFormatter
 *  org.apache.lucene.store.Directory
 *  org.apache.lucene.store.FSDirectory
 *  org.apache.lucene.util.Version
 */
package SA.SRFDA.IS.Web;

import SA.SRFDA.IS.Ctrl.Data.ISType;
import SA.SRFDA.IS.Ctrl.ISTypeManager;
import SA.SRFDA.IS.Web.ViewModel.SearchResultViewModel;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Vector;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.FilterIndexReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searchable;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class SearchResultPage
extends SRFDAPage {
    private static String TAG_PREFIXHTML = "<font color='red'>";
    private static String TAG_SUFFIXHTML = "</font>";
    private static String TAG_PREFIXSL = "&lt;Run Foreground='Red'>";
    private static String TAG_SUFFIXSL = "&lt;/Run>";
    protected SearchResultViewModel searchResultViewModel = null;

    protected PageModel CreatePageModel() {
        return new SearchResultViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.searchResultViewModel = (SearchResultViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.OutputResult();
    }

    public String OutputResult() {
        String strKeyword;
        Vector<String> isGroups;
        boolean bEnableUserDP;
        String strISRootFolder;
        CodeListConfig isItemMap;
        block40: {
            block39: {
                CodeListConfig isGroupMap;
                block38: {
                    isGroupMap = this.getWebContext().getCodeListMgr().GetCodeListConfig("ISCL_0004");
                    isItemMap = this.getWebContext().getCodeListMgr().GetCodeListConfig("ISCL_0005");
                    strISRootFolder = this.getWebContext().getWebExConfig().GetValue("SRFIS", "ISFOLDER", "");
                    if (!StringHelper.IsNullOrEmpty((String)strISRootFolder)) break block38;
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u7d22\u5f15\u7cfb\u7edf\u5b58\u50a8\u6839\u76ee\u5f55"));
                    return "";
                }
                String strISGroup = this.getWebContext().getWebExConfig().GetValue("SRFIS", "ISGROUP", "IS_DEFAULT");
                bEnableUserDP = this.OnGetUserDP();
                String strISGroupRange = this.getWebContext().GetParamValue("ISGROUP");
                if (!StringHelper.IsNullOrEmpty((String)strISGroupRange)) {
                    strISGroup = strISGroupRange;
                }
                isGroups = new Vector<String>();
                String[] isgroup = strISGroup.split("[;]");
                int i = 0;
                while (i < isgroup.length) {
                    CodeItemConfig codeItemConfig;
                    String strISGroupId = isgroup[i];
                    if (isGroupMap != null && (codeItemConfig = isGroupMap.FindCodeItemConfigByValue(strISGroupId, false)) != null) {
                        strISGroupId = codeItemConfig.getText();
                    }
                    if (bEnableUserDP) {
                        if (this.TestISGroupDP(strISGroupId)) {
                            isGroups.add(strISGroupId);
                        }
                    } else {
                        isGroups.add(strISGroupId);
                    }
                    ++i;
                }
                strKeyword = this.getWebContext().GetParamValue("KEYWORD");
                if (!StringHelper.IsNullOrEmpty((String)(strKeyword = strKeyword.trim()))) break block39;
                return "\u8bf7\u8f93\u5165\u68c0\u7d22\u6761\u4ef6";
            }
            if (isGroups.size() != 0) break block40;
            return "\u8bf7\u8f93\u5165\u68c0\u7d22\u8303\u56f4";
        }
        try {
            String strHitsPerPage;
            String strISItem;
            String[] keyItems = strKeyword.split("[ ]");
            if (keyItems.length > 1) {
                strKeyword = "(";
                int i = 0;
                while (i < keyItems.length) {
                    if (i != 0) {
                        strKeyword = String.valueOf(strKeyword) + " OR ";
                    }
                    strKeyword = String.valueOf(strKeyword) + keyItems[i];
                    ++i;
                }
                strKeyword = String.valueOf(strKeyword) + ")";
            }
            if (!StringHelper.IsNullOrEmpty((String)(strISItem = this.getWebContext().GetParamValue("ISITEM"))) && isItemMap != null) {
                String strExtKeyword = "";
                String[] isitem = strISItem.split("[;]");
                int i = 0;
                while (i < isitem.length) {
                    CodeItemConfig codeItemConfig = isItemMap.FindCodeItemConfigByValue(isitem[i], false);
                    if (codeItemConfig != null) {
                        if (!StringHelper.IsNullOrEmpty((String)strExtKeyword)) {
                            strExtKeyword = String.valueOf(strExtKeyword) + " OR ";
                        }
                        strExtKeyword = String.valueOf(strExtKeyword) + StringHelper.Format((String)"key:\"%1$s\"", (Object)codeItemConfig.getText().replace("|", "\\|"));
                    }
                    ++i;
                }
                if (!StringHelper.IsNullOrEmpty((String)strExtKeyword)) {
                    strKeyword = String.valueOf(strKeyword) + StringHelper.Format((String)" AND (%1$s) ", (Object)strExtKeyword);
                }
            }
            if (bEnableUserDP) {
                String strPrivKeys = this.GetPrivKeys();
                if (StringHelper.IsNullOrEmpty((String)strPrivKeys)) {
                    strPrivKeys = "__AABBCCDDEEFFGG__";
                }
                String strExtKeyword = "";
                String[] privkeys = strPrivKeys.split("[;]");
                int i = 0;
                while (i < privkeys.length) {
                    if (!StringHelper.IsNullOrEmpty((String)privkeys[i])) {
                        if (!StringHelper.IsNullOrEmpty((String)strExtKeyword)) {
                            strExtKeyword = String.valueOf(strExtKeyword) + " OR ";
                        }
                        strExtKeyword = String.valueOf(strExtKeyword) + StringHelper.Format((String)"privkey:\"%1$s\"", (Object)privkeys[i]);
                    }
                    ++i;
                }
                if (!StringHelper.IsNullOrEmpty((String)strExtKeyword)) {
                    strKeyword = String.valueOf(strKeyword) + StringHelper.Format((String)" AND (%1$s) ", (Object)strExtKeyword);
                }
            }
            String field = "content";
            Object queries = null;
            boolean repeat = false;
            boolean raw = false;
            String normsField = null;
            int hitsPerPage = 20;
            int nPageNo = 1;
            String strPageNo = this.getWebContext().GetParamValue("PAGE");
            if (!StringHelper.IsNullOrEmpty((String)strPageNo)) {
                try {
                    nPageNo = Integer.parseInt(strPageNo);
                    if (nPageNo < 1) {
                        nPageNo = 1;
                    }
                }
                catch (Exception ex) {
                    nPageNo = 1;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)(strHitsPerPage = this.getWebContext().GetParamValue("HitsPerPage")))) {
                try {
                    hitsPerPage = Integer.parseInt(strHitsPerPage);
                    if (hitsPerPage < 1) {
                        hitsPerPage = 20;
                    }
                }
                catch (Exception ex) {
                    hitsPerPage = 20;
                }
            }
            Vector<IndexSearcher> searchs = new Vector<IndexSearcher>();
            Vector<IndexReader> readers = new Vector<IndexReader>();
            int i = 0;
            while (i < isGroups.size()) {
                String strISFolder = strISRootFolder;
                strISFolder = String.valueOf(strISFolder) + (String)isGroups.get(i);
                Object reader = IndexReader.open((Directory)FSDirectory.open((File)new File(strISFolder)), (boolean)true);
                if (normsField != null) {
                    reader = new OneNormsReader((IndexReader)reader, normsField);
                }
                searchs.add(new IndexSearcher(reader));
                readers.add((IndexReader)reader);
                ++i;
            }
            IndexSearcher[] ises = new IndexSearcher[searchs.size()];
            searchs.toArray(ises);
            MultiSearcher searcher = new MultiSearcher((Searchable[])ises);
            StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
            StringBuilderEx sb = new StringBuilderEx();
            QueryParser parser = new QueryParser(Version.LUCENE_30, field, (Analyzer)analyzer);
            BooleanQuery.setMaxClauseCount((int)2048);
            Query query = parser.parse(strKeyword);
            if (this.searchResultViewModel != null && this.searchResultViewModel.getJsonResult() != null) {
                this.searchResultViewModel.setJsonResult(this.DoPagingSearchForSL((Searcher)searcher, query, nPageNo, hitsPerPage, raw, (Analyzer)analyzer));
            } else {
                this.DoPagingSearch(sb, (Searcher)searcher, query, nPageNo, hitsPerPage, raw, (Analyzer)analyzer);
            }
            for (IndexReader reader : readers) {
                reader.close();
            }
            return sb.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    /*
     * Unable to fully structure code
     */
    public JSONObject DoPagingSearchForSL(Searcher searcher, Query query, int nPageNo, int hitsPerPage, boolean raw, Analyzer analyzer) throws IOException, Exception {
        jsonObject = new JSONObject();
        nStartTime = new Date().getTime();
        isTypeManager = (ISTypeManager)this.getWebContext().GetGlobalValue("SRFGO:198CE79F-EAAF-4CE4-84DA-7ADC1E144D1D");
        collector = TopScoreDocCollector.create((int)(nPageNo * hitsPerPage), (boolean)false);
        searcher.search(query, (Collector)collector);
        hits = collector.topDocs().scoreDocs;
        numTotalHits = collector.getTotalHits();
        fUsedTime = (double)(new Date().getTime() - nStartTime) / 1000.0;
        if (fUsedTime == 0.0) {
            fUsedTime = 0.001;
        }
        jsonObject.put("resCount", (Object)String.format("\u83b7\u5f97  %1$s \u6761\u7ed3\u679c\uff0c\u4ee5\u4e0b\u4e3a\u7b2c  %2$s \u9875\uff08\u7528\u65f6 %3$s \u79d2\uff09", new Object[]{numTotalHits, nPageNo, fUsedTime}));
        jsonObject.put("numTotalHits", numTotalHits);
        jsonObject.put("nPageNo", nPageNo);
        jsonObject.put("nPageSize", hitsPerPage);
        start = (nPageNo - 1) * hitsPerPage;
        end = Math.min(numTotalHits, nPageNo * hitsPerPage);
        end = Math.min(hits.length, start + hitsPerPage);
        jsonArr = new JSONArray();
        i = start;
        while (i < end) {
            block10: {
                doc = searcher.doc(hits[i].doc);
                strKey = doc.get("key");
                if (strKey == null) break block10;
                jsonContent = new JSONObject();
                strContent = doc.get("info");
                if (strContent == null) ** GOTO lbl61
                simpleHTMLFormatter = new SimpleHTMLFormatter(SearchResultPage.TAG_PREFIXSL, SearchResultPage.TAG_SUFFIXSL);
                highlighter = new Highlighter((Formatter)simpleHTMLFormatter, (Scorer)new QueryScorer(query));
                highlighter.setTextFragmenter((Fragmenter)new SimpleFragmenter(400));
                tokenStream = analyzer.tokenStream("info", (Reader)new StringReader(strContent));
                highLightText = highlighter.getBestFragment(tokenStream, strContent);
                if (StringHelper.IsNullOrEmpty((String)highLightText)) {
                    highLightText = strContent;
                }
                if ((isType = isTypeManager.FindISType((parts = strKey.split("[|]"))[0])) == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u6570\u636e\u6e90\u7c7b\u578b[%1$s]\u914d\u7f6e\u4fe1\u606f", (Object)parts[0]));
                } else {
                    strHyperLinkBtn = "<sasrfis:CustomHyperLinkButton xmlns:sasrfis=\"http://schemas.softanywhere.com/2011/xaml/is\" TargetName = \"_blank\" SearchUrl=\"%1$s?KEY=%2$s\" HyperText=\"%3$s\"></sasrfis:CustomHyperLinkButton>";
                    strHyperLinkBtn = String.format(strHyperLinkBtn, new Object[]{isType.getDETAILURL(), strKey, highLightText});
                    jsonContent.put("info", (Object)strHyperLinkBtn);
                    strType = doc.get("type");
                    if (!StringHelper.IsNullOrEmpty((String)strType)) {
                        jsonContent.put("type", (Object)String.format("<TextBlock xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\">\u7c7b\u578b\uff1a%1$s</TextBlock>", new Object[]{strType}));
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strLastModified = doc.get("lastmodified2")))) {
                        jsonContent.put("lastmodified2", (Object)String.format("<TextBlock xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\">\u6700\u540e\u66f4\u6539\uff1a%1$s</TextBlock>", new Object[]{strLastModified}));
                    }
                    strDesc = doc.get("desc");
                    strDescAsHtml = doc.get("descashtml");
                    if (StringHelper.IsNullOrEmpty((String)strDescAsHtml)) {
                        strDescAsHtml = "1";
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strDesc)) {
                        if (strDesc.length() > 500) {
                            strDesc = String.valueOf(strDesc.substring(0, 490)) + "...";
                        }
                        jsonContent.put("desc", (Object)String.format("<TextBlock xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\">%1$s</TextBlock>", new Object[]{strDesc}));
                    }
lbl61:
                    // 4 sources

                    jsonArr.put((JSON)jsonContent);
                }
            }
            ++i;
        }
        jsonObject.put("searchlist", (Object)jsonArr);
        return jsonObject;
    }

    public void DoPagingSearch(StringBuilderEx sb, Searcher searcher, Query query, int nPageNo, int hitsPerPage, boolean raw, Analyzer analyzer) throws IOException, Exception {
        long nStartTime = new Date().getTime();
        ISTypeManager isTypeManager = (ISTypeManager)this.getWebContext().GetGlobalValue("SRFGO:198CE79F-EAAF-4CE4-84DA-7ADC1E144D1D");
        TopScoreDocCollector collector = TopScoreDocCollector.create((int)(nPageNo * hitsPerPage), (boolean)false);
        searcher.search(query, (Collector)collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;
        int numTotalHits = collector.getTotalHits();
        double fUsedTime = (double)(new Date().getTime() - nStartTime) / 1000.0;
        if (fUsedTime == 0.0) {
            fUsedTime = 0.001;
        }
        sb.Append("<span class='sx-normaltext'>");
        sb.Append(StringHelper.Format((String)"\u83b7\u5f97  %1$s \u6761\u7ed3\u679c", (Object)numTotalHits));
        if (nPageNo != 1) {
            sb.Append(StringHelper.Format((String)"\uff0c\u4ee5\u4e0b\u4e3a\u7b2c  %1$s \u9875", (Object)nPageNo));
        }
        sb.Append(StringHelper.Format((String)"\uff08\u7528\u65f6 %1$s \u79d2\uff09", (Object)fUsedTime));
        sb.Append("</span>");
        sb.Append("<BR><BR>");
        int start = (nPageNo - 1) * hitsPerPage;
        int end = Math.min(numTotalHits, nPageNo * hitsPerPage);
        end = Math.min(hits.length, start + hitsPerPage);
        int i = start;
        while (i < end) {
            String strContent;
            Document doc = searcher.doc(hits[i].doc);
            String strKey = doc.get("key");
            if (strKey != null && (strContent = doc.get("info")) != null) {
                String[] parts;
                ISType isType;
                SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(TAG_PREFIXHTML, TAG_SUFFIXHTML);
                Highlighter highlighter = new Highlighter((Formatter)simpleHTMLFormatter, (Scorer)new QueryScorer(query));
                highlighter.setTextFragmenter((Fragmenter)new SimpleFragmenter(400));
                TokenStream tokenStream = analyzer.tokenStream("info", (Reader)new StringReader(strContent));
                String highLightText = highlighter.getBestFragment(tokenStream, strContent);
                if (StringHelper.IsNullOrEmpty((String)highLightText)) {
                    highLightText = strContent;
                }
                if ((isType = isTypeManager.FindISType((parts = strKey.split("[|]"))[0])) == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u6570\u636e\u6e90\u7c7b\u578b[%1$s]\u914d\u7f6e\u4fe1\u606f", (Object)parts[0]));
                } else {
                    String strLastModified;
                    sb.Append("<A target='_blank' href='%1$s?KEY=%2$s'>", (Object)isType.getDETAILURL(), (Object)URLEncoder.encode(strKey, "UTF-8"));
                    sb.Append(highLightText);
                    sb.Append("</A>");
                    sb.Append("<BR>");
                    String strType = doc.get("type");
                    if (!StringHelper.IsNullOrEmpty((String)strType)) {
                        sb.Append("<span class='sx-normaltext-gray'>\u7c7b\u578b\uff1a");
                        sb.Append(WebUtility.TextToHTMLWithoutReturn((String)strType));
                        sb.Append("</span>&nbsp;&nbsp;&nbsp;&nbsp;");
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strLastModified = doc.get("lastmodified2")))) {
                        sb.Append("<span class='sx-normaltext-gray'>\u6700\u540e\u66f4\u6539\uff1a");
                        sb.Append(WebUtility.TextToHTMLWithoutReturn((String)strLastModified));
                        sb.Append("</span>&nbsp;");
                    }
                    String strDesc = doc.get("desc");
                    String strDescAsHtml = doc.get("descashtml");
                    if (StringHelper.IsNullOrEmpty((String)strDescAsHtml)) {
                        strDescAsHtml = "1";
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strDesc)) {
                        if (strDesc.length() > 500) {
                            strDesc = String.valueOf(strDesc.substring(0, 490)) + "...";
                        }
                        sb.Append("<BR>");
                        sb.Append("<span class='sx-normaltext'>");
                        if (StringHelper.Compare((String)strDescAsHtml, (String)"1", (boolean)true) == 0) {
                            sb.Append(WebUtility.TextToHTMLWithoutReturn((String)strDesc));
                        } else {
                            sb.Append(strDesc);
                        }
                        sb.Append("</span>");
                        sb.Append("<BR>");
                    }
                    sb.Append("<BR><BR>");
                }
            }
            ++i;
        }
        if (numTotalHits > 0) {
            String strURL = StringHelper.Format((String)"searchresult.jsp?%1$s", (Object)this.getWebContext().GetQueryStringWithout("PAGE"));
            int nTotalPage = numTotalHits / hitsPerPage + (numTotalHits % hitsPerPage == 0 ? 0 : 1);
            sb.Append("<table  width='100%'  border='0' cellspacing='0' cellpadding='0'>");
            sb.Append("<tr>");
            sb.Append("<td align='center'>");
            if (nPageNo != 1) {
                sb.Append("<A href='%1$s&PAGE=%2$s'>", (Object)strURL, (Object)(nPageNo - 1));
                sb.Append("<B>\u4e0a\u4e00\u9875</B>");
                sb.Append("</A>");
                sb.Append("&nbsp;");
            }
            int i2 = -10;
            while (i2 < 10) {
                int nCurPageNo = nPageNo + i2;
                if (nCurPageNo >= 1 && nCurPageNo <= nTotalPage) {
                    if (nCurPageNo == nPageNo) {
                        sb.Append("<B>%1$s</B>", (Object)nPageNo);
                        sb.Append("&nbsp;");
                    } else {
                        sb.Append("<A href='%1$s&PAGE=%2$s'>", (Object)strURL, (Object)nCurPageNo);
                        sb.Append("%1$s", (Object)nCurPageNo);
                        sb.Append("</A>");
                        sb.Append("&nbsp;");
                    }
                }
                ++i2;
            }
            if (nPageNo != nTotalPage) {
                sb.Append("<A href='%1$s&PAGE=%2$s'>", (Object)strURL, (Object)(nPageNo + 1));
                sb.Append("<B>\u4e0b\u4e00\u9875</B>");
                sb.Append("</A>");
                sb.Append("&nbsp;");
            }
            sb.Append("</td>");
            sb.Append("</tr>");
            sb.Append("</table>");
        }
    }

    protected boolean OnGetUserDP() {
        return this.getWebContext().getWebExConfig().GetValue("SRFIS", "USERDP", false);
    }

    protected boolean TestISGroupDP(String strISGroupId) {
        String strResId = StringHelper.Format((String)"ISGROUP_%1$s", (Object)strISGroupId);
        return this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), strResId);
    }

    protected String GetPrivKeys() {
        return "[DAPPLYSATAG2SSATAG1A]";
    }

    private static class OneNormsReader
    extends FilterIndexReader {
        private String field;

        public OneNormsReader(IndexReader in, String field) {
            super(in);
            this.field = field;
        }

        public byte[] norms(String field) throws IOException {
            return this.in.norms(this.field);
        }
    }
}

