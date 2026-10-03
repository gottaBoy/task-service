package SA.SRFDA.IS.Web;

import SA.SRFDA.IS.Ctrl.ISTypeManager;
import SA.SRFDA.IS.Ctrl.Data.ISType;
import SA.SRFDA.IS.Web.ViewModel.SearchResultViewModel;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Vector;
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
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class SearchResultPage extends SRFDAPage {
   private static String TAG_PREFIXHTML = "<font color='red'>";
   private static String TAG_SUFFIXHTML = "</font>";
   private static String TAG_PREFIXSL = "&lt;Run Foreground='Red'>";
   private static String TAG_SUFFIXSL = "&lt;/Run>";
   protected SearchResultViewModel searchResultViewModel = null;

   @Override
   protected PageModel CreatePageModel() {
      return new SearchResultViewModel();
   }

   @Override
   protected void PreparePageModel() {
      super.PreparePageModel();
      this.searchResultViewModel = (SearchResultViewModel)this.pageModel;
   }

   @Override
   protected boolean OnFillPageModel(JSONObject jsonObject) {
      return super.OnFillPageModel(jsonObject);
   }

   @Override
   protected void OnInitComponents() {
      super.OnInitComponents();
      this.OutputResult();
   }

   public String OutputResult() {
      try {
         CodeListConfig isGroupMap = this.getWebContext().getCodeListMgr().GetCodeListConfig("ISCL_0004");
         CodeListConfig isItemMap = this.getWebContext().getCodeListMgr().GetCodeListConfig("ISCL_0005");
         String strISRootFolder = this.getWebContext().getWebExConfig().GetValue("SRFIS", "ISFOLDER", "");
         if (StringHelper.IsNullOrEmpty(strISRootFolder)) {
            this.PageLog(this, 1, StringHelper.Format("没有定义索引系统存储根目录"));
            return "";
         }

         String strISGroup = this.getWebContext().getWebExConfig().GetValue("SRFIS", "ISGROUP", "IS_DEFAULT");
         boolean bEnableUserDP = this.OnGetUserDP();
         String strISGroupRange = this.getWebContext().GetParamValue("ISGROUP");
         if (!StringHelper.IsNullOrEmpty(strISGroupRange)) {
            strISGroup = strISGroupRange;
         }

         Vector<String> isGroups = new Vector<>();
         String[] isgroup = strISGroup.split("[;]");

         for (int i = 0; i < isgroup.length; i++) {
            String strISGroupId = isgroup[i];
            if (isGroupMap != null) {
               CodeItemConfig codeItemConfig = isGroupMap.FindCodeItemConfigByValue(strISGroupId, false);
               if (codeItemConfig != null) {
                  strISGroupId = codeItemConfig.getText();
               }
            }

            if (bEnableUserDP) {
               if (this.TestISGroupDP(strISGroupId)) {
                  isGroups.add(strISGroupId);
               }
            } else {
               isGroups.add(strISGroupId);
            }
         }

         String strKeyword = this.getWebContext().GetParamValue("KEYWORD");
         strKeyword = strKeyword.trim();
         if (StringHelper.IsNullOrEmpty(strKeyword)) {
            return "请输入检索条件";
         }

         if (isGroups.size() == 0) {
            return "请输入检索范围";
         }

         String[] keyItems = strKeyword.split("[ ]");
         if (keyItems.length > 1) {
            strKeyword = "(";

            for (int i = 0; i < keyItems.length; i++) {
               if (i != 0) {
                  strKeyword = strKeyword + " OR ";
               }

               strKeyword = strKeyword + keyItems[i];
            }

            strKeyword = strKeyword + ")";
         }

         String strISItem = this.getWebContext().GetParamValue("ISITEM");
         if (!StringHelper.IsNullOrEmpty(strISItem) && isItemMap != null) {
            String strExtKeyword = "";
            String[] isitem = strISItem.split("[;]");

            for (int i = 0; i < isitem.length; i++) {
               CodeItemConfig codeItemConfig = isItemMap.FindCodeItemConfigByValue(isitem[i], false);
               if (codeItemConfig != null) {
                  if (!StringHelper.IsNullOrEmpty(strExtKeyword)) {
                     strExtKeyword = strExtKeyword + " OR ";
                  }

                  strExtKeyword = strExtKeyword + StringHelper.Format("key:\"%1$s\"", codeItemConfig.getText().replace("|", "\\|"));
               }
            }

            if (!StringHelper.IsNullOrEmpty(strExtKeyword)) {
               strKeyword = strKeyword + StringHelper.Format(" AND (%1$s) ", strExtKeyword);
            }
         }

         if (bEnableUserDP) {
            String strPrivKeys = this.GetPrivKeys();
            if (StringHelper.IsNullOrEmpty(strPrivKeys)) {
               strPrivKeys = "__AABBCCDDEEFFGG__";
            }

            String strExtKeyword = "";
            String[] privkeys = strPrivKeys.split("[;]");

            for (int i = 0; i < privkeys.length; i++) {
               if (!StringHelper.IsNullOrEmpty(privkeys[i])) {
                  if (!StringHelper.IsNullOrEmpty(strExtKeyword)) {
                     strExtKeyword = strExtKeyword + " OR ";
                  }

                  strExtKeyword = strExtKeyword + StringHelper.Format("privkey:\"%1$s\"", privkeys[i]);
               }
            }

            if (!StringHelper.IsNullOrEmpty(strExtKeyword)) {
               strKeyword = strKeyword + StringHelper.Format(" AND (%1$s) ", strExtKeyword);
            }
         }

         String field = "content";
         String queries = null;
         int repeat = 0;
         boolean raw = false;
         String normsField = null;
         int hitsPerPage = 20;
         int nPageNo = 1;
         String strPageNo = this.getWebContext().GetParamValue("PAGE");
         if (!StringHelper.IsNullOrEmpty(strPageNo)) {
            try {
               nPageNo = Integer.parseInt(strPageNo);
               if (nPageNo < 1) {
                  nPageNo = 1;
               }
            } catch (Exception ex) {
               nPageNo = 1;
            }
         }

         String strHitsPerPage = this.getWebContext().GetParamValue("HitsPerPage");
         if (!StringHelper.IsNullOrEmpty(strHitsPerPage)) {
            try {
               hitsPerPage = Integer.parseInt(strHitsPerPage);
               if (hitsPerPage < 1) {
                  hitsPerPage = 20;
               }
            } catch (Exception ex) {
               hitsPerPage = 20;
            }
         }

         Vector<IndexSearcher> searchs = new Vector<>();
         Vector<IndexReader> readers = new Vector<>();

         for (int i = 0; i < isGroups.size(); i++) {
            String strISFolder = strISRootFolder;
            strISFolder = strISFolder + isGroups.get(i);
            IndexReader reader = IndexReader.open(FSDirectory.open(new File(strISFolder)), true);
            if (normsField != null) {
               reader = new SearchResultPage.OneNormsReader(reader, normsField);
            }

            searchs.add(new IndexSearcher(reader));
            readers.add(reader);
         }

         IndexSearcher[] ises = new IndexSearcher[searchs.size()];
         searchs.toArray(ises);
         MultiSearcher searcher = new MultiSearcher(ises);
         Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
         StringBuilderEx sb = new StringBuilderEx();
         QueryParser parser = new QueryParser(Version.LUCENE_30, field, analyzer);
         BooleanQuery.setMaxClauseCount(2048);
         Query query = parser.parse(strKeyword);
         if (this.searchResultViewModel != null && this.searchResultViewModel.getJsonResult() != null) {
            this.searchResultViewModel.setJsonResult(this.DoPagingSearchForSL(searcher, query, nPageNo, hitsPerPage, raw, analyzer));
         } else {
            this.DoPagingSearch(sb, searcher, query, nPageNo, hitsPerPage, raw, analyzer);
         }

         for (IndexReader reader : readers) {
            reader.close();
         }

         return sb.toString();
      } catch (Exception ex) {
         ex.printStackTrace();
         return "";
      }
   }

   public JSONObject DoPagingSearchForSL(Searcher searcher, Query query, int nPageNo, int hitsPerPage, boolean raw, Analyzer analyzer) throws IOException, Exception {
      JSONObject jsonObject = new JSONObject();
      long nStartTime = new Date().getTime();
      ISTypeManager isTypeManager = (ISTypeManager)this.getWebContext().GetGlobalValue("SRFGO:198CE79F-EAAF-4CE4-84DA-7ADC1E144D1D");
      TopScoreDocCollector collector = TopScoreDocCollector.create(nPageNo * hitsPerPage, false);
      searcher.search(query, collector);
      ScoreDoc[] hits = collector.topDocs().scoreDocs;
      int numTotalHits = collector.getTotalHits();
      double fUsedTime = (new Date().getTime() - nStartTime) / 1000.0;
      if (fUsedTime == 0.0) {
         fUsedTime = 0.001;
      }

      jsonObject.put("resCount", String.format("获得  %1$s 条结果，以下为第  %2$s 页（用时 %3$s 秒）", numTotalHits, nPageNo, fUsedTime));
      jsonObject.put("numTotalHits", numTotalHits);
      jsonObject.put("nPageNo", nPageNo);
      jsonObject.put("nPageSize", hitsPerPage);
      int start = (nPageNo - 1) * hitsPerPage;
      int end = Math.min(numTotalHits, nPageNo * hitsPerPage);
      end = Math.min(hits.length, start + hitsPerPage);
      JSONArray jsonArr = new JSONArray();

      for (int i = start; i < end; i++) {
         Document doc = searcher.doc(hits[i].doc);
         String strKey = doc.get("key");
         if (strKey != null) {
            JSONObject jsonContent = new JSONObject();
            String strContent = doc.get("info");
            if (strContent != null) {
               SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(TAG_PREFIXSL, TAG_SUFFIXSL);
               Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
               highlighter.setTextFragmenter(new SimpleFragmenter(400));
               TokenStream tokenStream = analyzer.tokenStream("info", new StringReader(strContent));
               String highLightText = highlighter.getBestFragment(tokenStream, strContent);
               if (StringHelper.IsNullOrEmpty(highLightText)) {
                  highLightText = strContent;
               }

               String[] parts = strKey.split("[|]");
               ISType isType = isTypeManager.FindISType(parts[0]);
               if (isType == null) {
                  this.PageLog(this, 1, StringHelper.Format("无法获取索引数据源类型[%1$s]配置信息", parts[0]));
                  continue;
               }

               String strHyperLinkBtn = "<sasrfis:CustomHyperLinkButton xmlns:sasrfis=\"http://schemas.softanywhere.com/2011/xaml/is\" TargetName = \"_blank\" SearchUrl=\"%1$s?KEY=%2$s\" HyperText=\"%3$s\"></sasrfis:CustomHyperLinkButton>";
               strHyperLinkBtn = String.format(strHyperLinkBtn, isType.getDETAILURL(), strKey, highLightText);
               jsonContent.put("info", strHyperLinkBtn);
               String strType = doc.get("type");
               if (!StringHelper.IsNullOrEmpty(strType)) {
                  jsonContent.put(
                     "type", String.format("<TextBlock xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\">类型：%1$s</TextBlock>", strType)
                  );
               }

               String strLastModified = doc.get("lastmodified2");
               if (!StringHelper.IsNullOrEmpty(strLastModified)) {
                  jsonContent.put(
                     "lastmodified2",
                     String.format("<TextBlock xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\">最后更改：%1$s</TextBlock>", strLastModified)
                  );
               }

               String strDesc = doc.get("desc");
               String strDescAsHtml = doc.get("descashtml");
               if (StringHelper.IsNullOrEmpty(strDescAsHtml)) {
                  strDescAsHtml = "1";
               }

               if (!StringHelper.IsNullOrEmpty(strDesc)) {
                  if (strDesc.length() > 500) {
                     strDesc = strDesc.substring(0, 490) + "...";
                  }

                  jsonContent.put(
                     "desc", String.format("<TextBlock xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\">%1$s</TextBlock>", strDesc)
                  );
               }
            }

            jsonArr.put(jsonContent);
         }
      }

      jsonObject.put("searchlist", jsonArr);
      return jsonObject;
   }

   public void DoPagingSearch(StringBuilderEx sb, Searcher searcher, Query query, int nPageNo, int hitsPerPage, boolean raw, Analyzer analyzer) throws IOException, Exception {
      long nStartTime = new Date().getTime();
      ISTypeManager isTypeManager = (ISTypeManager)this.getWebContext().GetGlobalValue("SRFGO:198CE79F-EAAF-4CE4-84DA-7ADC1E144D1D");
      TopScoreDocCollector collector = TopScoreDocCollector.create(nPageNo * hitsPerPage, false);
      searcher.search(query, collector);
      ScoreDoc[] hits = collector.topDocs().scoreDocs;
      int numTotalHits = collector.getTotalHits();
      double fUsedTime = (new Date().getTime() - nStartTime) / 1000.0;
      if (fUsedTime == 0.0) {
         fUsedTime = 0.001;
      }

      sb.Append("<span class='sx-normaltext'>");
      sb.Append(StringHelper.Format("获得  %1$s 条结果", numTotalHits));
      if (nPageNo != 1) {
         sb.Append(StringHelper.Format("，以下为第  %1$s 页", nPageNo));
      }

      sb.Append(StringHelper.Format("（用时 %1$s 秒）", fUsedTime));
      sb.Append("</span>");
      sb.Append("<BR><BR>");
      int start = (nPageNo - 1) * hitsPerPage;
      int end = Math.min(numTotalHits, nPageNo * hitsPerPage);
      end = Math.min(hits.length, start + hitsPerPage);

      for (int i = start; i < end; i++) {
         Document doc = searcher.doc(hits[i].doc);
         String strKey = doc.get("key");
         if (strKey != null) {
            String strContent = doc.get("info");
            if (strContent != null) {
               SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(TAG_PREFIXHTML, TAG_SUFFIXHTML);
               Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
               highlighter.setTextFragmenter(new SimpleFragmenter(400));
               TokenStream tokenStream = analyzer.tokenStream("info", new StringReader(strContent));
               String highLightText = highlighter.getBestFragment(tokenStream, strContent);
               if (StringHelper.IsNullOrEmpty(highLightText)) {
                  highLightText = strContent;
               }

               String[] parts = strKey.split("[|]");
               ISType isType = isTypeManager.FindISType(parts[0]);
               if (isType == null) {
                  this.PageLog(this, 1, StringHelper.Format("无法获取索引数据源类型[%1$s]配置信息", parts[0]));
               } else {
                  sb.Append("<A target='_blank' href='%1$s?KEY=%2$s'>", isType.getDETAILURL(), URLEncoder.encode(strKey, "UTF-8"));
                  sb.Append(highLightText);
                  sb.Append("</A>");
                  sb.Append("<BR>");
                  String strType = doc.get("type");
                  if (!StringHelper.IsNullOrEmpty(strType)) {
                     sb.Append("<span class='sx-normaltext-gray'>类型：");
                     sb.Append(WebUtility.TextToHTMLWithoutReturn(strType));
                     sb.Append("</span>&nbsp;&nbsp;&nbsp;&nbsp;");
                  }

                  String strLastModified = doc.get("lastmodified2");
                  if (!StringHelper.IsNullOrEmpty(strLastModified)) {
                     sb.Append("<span class='sx-normaltext-gray'>最后更改：");
                     sb.Append(WebUtility.TextToHTMLWithoutReturn(strLastModified));
                     sb.Append("</span>&nbsp;");
                  }

                  String strDesc = doc.get("desc");
                  String strDescAsHtml = doc.get("descashtml");
                  if (StringHelper.IsNullOrEmpty(strDescAsHtml)) {
                     strDescAsHtml = "1";
                  }

                  if (!StringHelper.IsNullOrEmpty(strDesc)) {
                     if (strDesc.length() > 500) {
                        strDesc = strDesc.substring(0, 490) + "...";
                     }

                     sb.Append("<BR>");
                     sb.Append("<span class='sx-normaltext'>");
                     if (StringHelper.Compare(strDescAsHtml, "1", true) == 0) {
                        sb.Append(WebUtility.TextToHTMLWithoutReturn(strDesc));
                     } else {
                        sb.Append(strDesc);
                     }

                     sb.Append("</span>");
                     sb.Append("<BR>");
                  }

                  sb.Append("<BR><BR>");
               }
            }
         }
      }

      if (numTotalHits > 0) {
         String strURL = StringHelper.Format("searchresult.jsp?%1$s", this.getWebContext().GetQueryStringWithout("PAGE"));
         int nTotalPage = numTotalHits / hitsPerPage + (numTotalHits % hitsPerPage == 0 ? 0 : 1);
         sb.Append("<table  width='100%'  border='0' cellspacing='0' cellpadding='0'>");
         sb.Append("<tr>");
         sb.Append("<td align='center'>");
         if (nPageNo != 1) {
            sb.Append("<A href='%1$s&PAGE=%2$s'>", strURL, nPageNo - 1);
            sb.Append("<B>上一页</B>");
            sb.Append("</A>");
            sb.Append("&nbsp;");
         }

         for (int i = -10; i < 10; i++) {
            int nCurPageNo = nPageNo + i;
            if (nCurPageNo >= 1 && nCurPageNo <= nTotalPage) {
               if (nCurPageNo == nPageNo) {
                  sb.Append("<B>%1$s</B>", nPageNo);
                  sb.Append("&nbsp;");
               } else {
                  sb.Append("<A href='%1$s&PAGE=%2$s'>", strURL, nCurPageNo);
                  sb.Append("%1$s", nCurPageNo);
                  sb.Append("</A>");
                  sb.Append("&nbsp;");
               }
            }
         }

         if (nPageNo != nTotalPage) {
            sb.Append("<A href='%1$s&PAGE=%2$s'>", strURL, nPageNo + 1);
            sb.Append("<B>下一页</B>");
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
      String strResId = StringHelper.Format("ISGROUP_%1$s", strISGroupId);
      return this.getWebContext().GetUserPrivilegeMgr().Test(this.getWebContext(), strResId);
   }

   protected String GetPrivKeys() {
      return "[DAPPLYSATAG2SSATAG1A]";
   }

   private static class OneNormsReader extends FilterIndexReader {
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
