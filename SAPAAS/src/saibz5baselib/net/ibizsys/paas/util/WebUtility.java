/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.util.StringHelper;

public class WebUtility {
    private static HashMap<String, String> httpContentTypeMap = new HashMap();
    private static String[] filterkeywords = new String[]{"CREATE ", "UPDATE ", "DELETE ", "INSERT ", "DROP ", "SELECT ", "GRANT ", "OPEN ", "AND ", "OR ", "<IFRAME", "<FRAME", "<SCRIPT>", "<SCRIPT ", "</SCRIPT>", "<IMG "};
    private static String[] filterkeywords3 = new String[]{"CREATE ", "UPDATE ", "DELETE ", "INSERT ", "DROP ", "SELECT ", "GRANT ", "OPEN ", "AND ", "OR "};
    private static String[] filterkeywords2 = new String[]{"EVAL(", "ALERT(", "+'", "+\"", "'+", "\"+", "JAVASCRIPT:"};

    static {
        httpContentTypeMap.put(".001", "application/x-001");
        httpContentTypeMap.put(".323", "text/h323");
        httpContentTypeMap.put(".907", "drawing/907");
        httpContentTypeMap.put(".acp", "audio/x-mei-aac");
        httpContentTypeMap.put(".aif", "audio/aiff");
        httpContentTypeMap.put(".aiff", "audio/aiff");
        httpContentTypeMap.put(".asa", "text/asa");
        httpContentTypeMap.put(".asp", "text/asp");
        httpContentTypeMap.put(".au", "audio/basic");
        httpContentTypeMap.put(".awf", "application/vnd.adobe.workflow");
        httpContentTypeMap.put(".bmp", "application/x-bmp");
        httpContentTypeMap.put(".c4t", "application/x-c4t");
        httpContentTypeMap.put(".cal", "application/x-cals");
        httpContentTypeMap.put(".cdf", "application/x-netcdf");
        httpContentTypeMap.put(".cel", "application/x-cel");
        httpContentTypeMap.put(".cg4", "application/x-g4");
        httpContentTypeMap.put(".cit", "application/x-cit");
        httpContentTypeMap.put(".cml", "text/xml");
        httpContentTypeMap.put(".cmx", "application/x-cmx");
        httpContentTypeMap.put(".crl", "application/pkix-crl");
        httpContentTypeMap.put(".csi", "application/x-csi");
        httpContentTypeMap.put(".cut", "application/x-cut");
        httpContentTypeMap.put(".dbm", "application/x-dbm");
        httpContentTypeMap.put(".dcd", "text/xml");
        httpContentTypeMap.put(".der", "application/x-x509-ca-cert");
        httpContentTypeMap.put(".dib", "application/x-dib");
        httpContentTypeMap.put(".doc", "application/msword");
        httpContentTypeMap.put(".drw", "application/x-drw");
        httpContentTypeMap.put(".dwf", "Model/vnd.dwf");
        httpContentTypeMap.put(".dwg", "application/x-dwg");
        httpContentTypeMap.put(".dxf", "application/x-dxf");
        httpContentTypeMap.put(".emf", "application/x-emf");
        httpContentTypeMap.put(".ent", "text/xml");
        httpContentTypeMap.put(".eps", "application/x-ps");
        httpContentTypeMap.put(".etd", "application/x-ebx");
        httpContentTypeMap.put(".fax", "image/fax");
        httpContentTypeMap.put(".fif", "application/fractals");
        httpContentTypeMap.put(".frm", "application/x-frm");
        httpContentTypeMap.put(".gbr", "application/x-gbr");
        httpContentTypeMap.put(".gif", "image/gif");
        httpContentTypeMap.put(".gp4", "application/x-gp4");
        httpContentTypeMap.put(".hmr", "application/x-hmr");
        httpContentTypeMap.put(".hpl", "application/x-hpl");
        httpContentTypeMap.put(".hrf", "application/x-hrf");
        httpContentTypeMap.put(".htc", "text/x-component");
        httpContentTypeMap.put(".html", "text/html");
        httpContentTypeMap.put(".htx", "text/html");
        httpContentTypeMap.put(".ico", "image/x-icon");
        httpContentTypeMap.put(".iff", "application/x-iff");
        httpContentTypeMap.put(".igs", "application/x-igs");
        httpContentTypeMap.put(".img", "application/x-img");
        httpContentTypeMap.put(".isp", "application/x-internet-signup");
        httpContentTypeMap.put(".java", "java/*");
        httpContentTypeMap.put(".jpe", "image/jpeg");
        httpContentTypeMap.put(".jpeg", "image/jpeg");
        httpContentTypeMap.put(".jpg", "application/x-jpg");
        httpContentTypeMap.put(".jsp", "text/html");
        httpContentTypeMap.put(".lar", "application/x-laplayer-reg");
        httpContentTypeMap.put(".lavs", "audio/x-liquid-secure");
        httpContentTypeMap.put(".lmsff", "audio/x-la-lms");
        httpContentTypeMap.put(".ltr", "application/x-ltr");
        httpContentTypeMap.put(".m2v", "video/x-mpeg");
        httpContentTypeMap.put(".m4e", "video/mpeg4");
        httpContentTypeMap.put(".man", "application/x-troff-man");
        httpContentTypeMap.put(".mdb", "application/msaccess");
        httpContentTypeMap.put(".mfp", "application/x-shockwave-flash");
        httpContentTypeMap.put(".mhtml", "message/rfc822");
        httpContentTypeMap.put(".mid", "audio/mid");
        httpContentTypeMap.put(".mil", "application/x-mil");
        httpContentTypeMap.put(".mnd", "audio/x-musicnet-download");
        httpContentTypeMap.put(".mocha", "application/x-javascript");
        httpContentTypeMap.put(".mp1", "audio/mp1");
        httpContentTypeMap.put(".mp2v", "video/mpeg");
        httpContentTypeMap.put(".mp4", "video/mpeg4");
        httpContentTypeMap.put(".mpd", "application/vnd.ms-project");
        httpContentTypeMap.put(".mpeg", "video/mpg");
        httpContentTypeMap.put(".mpga", "audio/rn-mpeg");
        httpContentTypeMap.put(".mps", "video/x-mpeg");
        httpContentTypeMap.put(".mpv", "video/mpg");
        httpContentTypeMap.put(".mpw", "application/vnd.ms-project");
        httpContentTypeMap.put(".mtx", "text/xml");
        httpContentTypeMap.put(".net", "image/pnetvue");
        httpContentTypeMap.put(".nws", "message/rfc822");
        httpContentTypeMap.put(".out", "application/x-out");
        httpContentTypeMap.put(".p12", "application/x-pkcs12");
        httpContentTypeMap.put(".p7c", "application/pkcs7-mime");
        httpContentTypeMap.put(".p7r", "application/x-pkcs7-certreqresp");
        httpContentTypeMap.put(".pc5", "application/x-pc5");
        httpContentTypeMap.put(".pcl", "application/x-pcl");
        httpContentTypeMap.put(".pdf", "application/pdf");
        httpContentTypeMap.put(".pdx", "application/vnd.adobe.pdx");
        httpContentTypeMap.put(".pgl", "application/x-pgl");
        httpContentTypeMap.put(".pko", "application/vnd.ms-pki.pko");
        httpContentTypeMap.put(".plg", "text/html");
        httpContentTypeMap.put(".plt", "application/x-plt");
        httpContentTypeMap.put(".png", "application/x-png");
        httpContentTypeMap.put(".ppa", "application/vnd.ms-powerpoint");
        httpContentTypeMap.put(".pps", "application/vnd.ms-powerpoint");
        httpContentTypeMap.put(".ppt", "application/x-ppt");
        httpContentTypeMap.put(".prf", "application/pics-rules");
        httpContentTypeMap.put(".prt", "application/x-prt");
        httpContentTypeMap.put(".ps", "application/postscript");
        httpContentTypeMap.put(".pwz", "application/vnd.ms-powerpoint");
        httpContentTypeMap.put(".ra", "audio/vnd.rn-realaudio");
        httpContentTypeMap.put(".ras", "application/x-ras");
        httpContentTypeMap.put(".rdf", "text/xml");
        httpContentTypeMap.put(".red", "application/x-red");
        httpContentTypeMap.put(".rjs", "application/vnd.rn-realsystem-rjs");
        httpContentTypeMap.put(".rlc", "application/x-rlc");
        httpContentTypeMap.put(".rm", "application/vnd.rn-realmedia");
        httpContentTypeMap.put(".rmi", "audio/mid");
        httpContentTypeMap.put(".rmm", "audio/x-pn-realaudio");
        httpContentTypeMap.put(".rms", "application/vnd.rn-realmedia-secure");
        httpContentTypeMap.put(".rmx", "application/vnd.rn-realsystem-rmx");
        httpContentTypeMap.put(".rp", "image/vnd.rn-realpix");
        httpContentTypeMap.put(".rsml", "application/vnd.rn-rsml");
        httpContentTypeMap.put(".rtf", "application/msword");
        httpContentTypeMap.put(".rv", "video/vnd.rn-realvideo");
        httpContentTypeMap.put(".sat", "application/x-sat");
        httpContentTypeMap.put(".sdw", "application/x-sdw");
        httpContentTypeMap.put(".slb", "application/x-slb");
        httpContentTypeMap.put(".slk", "drawing/x-slk");
        httpContentTypeMap.put(".smil", "application/smil");
        httpContentTypeMap.put(".snd", "audio/basic");
        httpContentTypeMap.put(".sor", "text/plain");
        httpContentTypeMap.put(".spl", "application/futuresplash");
        httpContentTypeMap.put(".ssm", "application/streamingmedia");
        httpContentTypeMap.put(".stl", "application/vnd.ms-pki.stl");
        httpContentTypeMap.put(".sty", "application/x-sty");
        httpContentTypeMap.put(".swf", "application/x-shockwave-flash");
        httpContentTypeMap.put(".tg4", "application/x-tg4");
        httpContentTypeMap.put(".tif", "image/tiff");
        httpContentTypeMap.put(".tiff", "image/tiff");
        httpContentTypeMap.put(".top", "drawing/x-top");
        httpContentTypeMap.put(".tsd", "text/xml");
        httpContentTypeMap.put(".uin", "application/x-icq");
        httpContentTypeMap.put(".vcf", "text/x-vcard");
        httpContentTypeMap.put(".vdx", "application/vnd.visio");
        httpContentTypeMap.put(".vpg", "application/x-vpeg005");
        httpContentTypeMap.put(".vsd", "application/x-vsd");
        httpContentTypeMap.put(".vst", "application/vnd.visio");
        httpContentTypeMap.put(".vsw", "application/vnd.visio");
        httpContentTypeMap.put(".vtx", "application/vnd.visio");
        httpContentTypeMap.put(".wav", "audio/wav");
        httpContentTypeMap.put(".wb1", "application/x-wb1");
        httpContentTypeMap.put(".wb3", "application/x-wb3");
        httpContentTypeMap.put(".wiz", "application/msword");
        httpContentTypeMap.put(".wk4", "application/x-wk4");
        httpContentTypeMap.put(".wks", "application/x-wks");
        httpContentTypeMap.put(".wma", "audio/x-ms-wma");
        httpContentTypeMap.put(".wmf", "application/x-wmf");
        httpContentTypeMap.put(".wmv", "video/x-ms-wmv");
        httpContentTypeMap.put(".wmz", "application/x-ms-wmz");
        httpContentTypeMap.put(".wpd", "application/x-wpd");
        httpContentTypeMap.put(".wpl", "application/vnd.ms-wpl");
        httpContentTypeMap.put(".wr1", "application/x-wr1");
        httpContentTypeMap.put(".wrk", "application/x-wrk");
        httpContentTypeMap.put(".ws2", "application/x-ws");
        httpContentTypeMap.put(".wsdl", "text/xml");
        httpContentTypeMap.put(".xdp", "application/vnd.adobe.xdp");
        httpContentTypeMap.put(".xfd", "application/vnd.adobe.xfd");
        httpContentTypeMap.put(".xhtml", "text/html");
        httpContentTypeMap.put(".xls", "application/x-xls");
        httpContentTypeMap.put(".xml", "text/xml");
        httpContentTypeMap.put(".xq", "text/xml");
        httpContentTypeMap.put(".xquery", "text/xml");
        httpContentTypeMap.put(".xsl", "text/xml");
        httpContentTypeMap.put(".xwd", "application/x-xwd");
        httpContentTypeMap.put(".sis", "application/vnd.symbian.install");
        httpContentTypeMap.put(".x_t", "application/x-x_t");
        httpContentTypeMap.put(".apk", "application/vnd.android.package-archive");
        httpContentTypeMap.put(".tif", "image/tiff");
        httpContentTypeMap.put(".301", "application/x-301");
        httpContentTypeMap.put(".906", "application/x-906");
        httpContentTypeMap.put(".a11", "application/x-a11");
        httpContentTypeMap.put(".ai", "application/postscript");
        httpContentTypeMap.put(".aifc", "audio/aiff");
        httpContentTypeMap.put(".anv", "application/x-anv");
        httpContentTypeMap.put(".asf", "video/x-ms-asf");
        httpContentTypeMap.put(".asx", "video/x-ms-asf");
        httpContentTypeMap.put(".avi", "video/avi");
        httpContentTypeMap.put(".biz", "text/xml");
        httpContentTypeMap.put(".bot", "application/x-bot");
        httpContentTypeMap.put(".c90", "application/x-c90");
        httpContentTypeMap.put(".cat", "application/vnd.ms-pki.seccat");
        httpContentTypeMap.put(".cdr", "application/x-cdr");
        httpContentTypeMap.put(".cer", "application/x-x509-ca-cert");
        httpContentTypeMap.put(".cgm", "application/x-cgm");
        httpContentTypeMap.put(".class", "java/*");
        httpContentTypeMap.put(".cmp", "application/x-cmp");
        httpContentTypeMap.put(".cot", "application/x-cot");
        httpContentTypeMap.put(".crt", "application/x-x509-ca-cert");
        httpContentTypeMap.put(".css", "text/css");
        httpContentTypeMap.put(".dbf", "application/x-dbf");
        httpContentTypeMap.put(".dbx", "application/x-dbx");
        httpContentTypeMap.put(".dcx", "application/x-dcx");
        httpContentTypeMap.put(".dgn", "application/x-dgn");
        httpContentTypeMap.put(".dll", "application/x-msdownload");
        httpContentTypeMap.put(".dot", "application/msword");
        httpContentTypeMap.put(".dtd", "text/xml");
        httpContentTypeMap.put(".dwf", "application/x-dwf");
        httpContentTypeMap.put(".dxb", "application/x-dxb");
        httpContentTypeMap.put(".edn", "application/vnd.adobe.edn");
        httpContentTypeMap.put(".eml", "message/rfc822");
        httpContentTypeMap.put(".epi", "application/x-epi");
        httpContentTypeMap.put(".eps", "application/postscript");
        httpContentTypeMap.put(".exe", "application/x-msdownload");
        httpContentTypeMap.put(".fdf", "application/vnd.fdf");
        httpContentTypeMap.put(".fo", "text/xml");
        httpContentTypeMap.put(".g4", "application/x-g4");
        httpContentTypeMap.put(".", "application/x-");
        httpContentTypeMap.put(".gl2", "application/x-gl2");
        httpContentTypeMap.put(".hgl", "application/x-hgl");
        httpContentTypeMap.put(".hpg", "application/x-hpgl");
        httpContentTypeMap.put(".hqx", "application/mac-binhex40");
        httpContentTypeMap.put(".hta", "application/hta");
        httpContentTypeMap.put(".htm", "text/html");
        httpContentTypeMap.put(".htt", "text/webviewhtml");
        httpContentTypeMap.put(".icb", "application/x-icb");
        httpContentTypeMap.put(".ico", "application/x-ico");
        httpContentTypeMap.put(".ig4", "application/x-g4");
        httpContentTypeMap.put(".iii", "application/x-iphone");
        httpContentTypeMap.put(".ins", "application/x-internet-signup");
        httpContentTypeMap.put(".IVF", "video/x-ivf");
        httpContentTypeMap.put(".jfif", "image/jpeg");
        httpContentTypeMap.put(".jpe", "application/x-jpe");
        httpContentTypeMap.put(".jpg", "image/jpeg");
        httpContentTypeMap.put(".js", "application/x-javascript");
        httpContentTypeMap.put(".la1", "audio/x-liquid-file");
        httpContentTypeMap.put(".latex", "application/x-latex");
        httpContentTypeMap.put(".lbm", "application/x-lbm");
        httpContentTypeMap.put(".ls", "application/x-javascript");
        httpContentTypeMap.put(".m1v", "video/x-mpeg");
        httpContentTypeMap.put(".m3u", "audio/mpegurl");
        httpContentTypeMap.put(".mac", "application/x-mac");
        httpContentTypeMap.put(".math", "text/xml");
        httpContentTypeMap.put(".mdb", "application/x-mdb");
        httpContentTypeMap.put(".mht", "message/rfc822");
        httpContentTypeMap.put(".mi", "application/x-mi");
        httpContentTypeMap.put(".midi", "audio/mid");
        httpContentTypeMap.put(".mml", "text/xml");
        httpContentTypeMap.put(".mns", "audio/x-musicnet-stream");
        httpContentTypeMap.put(".movie", "video/x-sgi-movie");
        httpContentTypeMap.put(".mp2", "audio/mp2");
        httpContentTypeMap.put(".mp3", "audio/mp3");
        httpContentTypeMap.put(".mpa", "video/x-mpg");
        httpContentTypeMap.put(".mpe", "video/x-mpeg");
        httpContentTypeMap.put(".mpg", "video/mpg");
        httpContentTypeMap.put(".mpp", "application/vnd.ms-project");
        httpContentTypeMap.put(".mpt", "application/vnd.ms-project");
        httpContentTypeMap.put(".mpv2", "video/mpeg");
        httpContentTypeMap.put(".mpx", "application/vnd.ms-project");
        httpContentTypeMap.put(".mxp", "application/x-mmxp");
        httpContentTypeMap.put(".nrf", "application/x-nrf");
        httpContentTypeMap.put(".odc", "text/x-ms-odc");
        httpContentTypeMap.put(".p10", "application/pkcs10");
        httpContentTypeMap.put(".p7b", "application/x-pkcs7-certificates");
        httpContentTypeMap.put(".p7m", "application/pkcs7-mime");
        httpContentTypeMap.put(".p7s", "application/pkcs7-signature");
        httpContentTypeMap.put(".pci", "application/x-pci");
        httpContentTypeMap.put(".pcx", "application/x-pcx");
        httpContentTypeMap.put(".pdf", "application/pdf");
        httpContentTypeMap.put(".pfx", "application/x-pkcs12");
        httpContentTypeMap.put(".pic", "application/x-pic");
        httpContentTypeMap.put(".pl", "application/x-perl");
        httpContentTypeMap.put(".pls", "audio/scpls");
        httpContentTypeMap.put(".png", "image/png");
        httpContentTypeMap.put(".pot", "application/vnd.ms-powerpoint");
        httpContentTypeMap.put(".ppm", "application/x-ppm");
        httpContentTypeMap.put(".ppt", "application/vnd.ms-powerpoint");
        httpContentTypeMap.put(".pr", "application/x-pr");
        httpContentTypeMap.put(".prn", "application/x-prn");
        httpContentTypeMap.put(".ps", "application/x-ps");
        httpContentTypeMap.put(".ptn", "application/x-ptn");
        httpContentTypeMap.put(".r3t", "text/vnd.rn-realtext3d");
        httpContentTypeMap.put(".ram", "audio/x-pn-realaudio");
        httpContentTypeMap.put(".rat", "application/rat-file");
        httpContentTypeMap.put(".rec", "application/vnd.rn-recording");
        httpContentTypeMap.put(".rgb", "application/x-rgb");
        httpContentTypeMap.put(".rjt", "application/vnd.rn-realsystem-rjt");
        httpContentTypeMap.put(".rle", "application/x-rle");
        httpContentTypeMap.put(".rmf", "application/vnd.adobe.rmf");
        httpContentTypeMap.put(".rmj", "application/vnd.rn-realsystem-rmj");
        httpContentTypeMap.put(".rmp", "application/vnd.rn-rn_music_package");
        httpContentTypeMap.put(".rmvb", "application/vnd.rn-realmedia-vbr");
        httpContentTypeMap.put(".rnx", "application/vnd.rn-realplayer");
        httpContentTypeMap.put(".rpm", "audio/x-pn-realaudio-plugin");
        httpContentTypeMap.put(".rt", "text/vnd.rn-realtext");
        httpContentTypeMap.put(".rtf", "application/x-rtf");
        httpContentTypeMap.put(".sam", "application/x-sam");
        httpContentTypeMap.put(".sdp", "application/sdp");
        httpContentTypeMap.put(".sit", "application/x-stuffit");
        httpContentTypeMap.put(".sld", "application/x-sld");
        httpContentTypeMap.put(".smi", "application/smil");
        httpContentTypeMap.put(".smk", "application/x-smk");
        httpContentTypeMap.put(".sol", "text/plain");
        httpContentTypeMap.put(".spc", "application/x-pkcs7-certificates");
        httpContentTypeMap.put(".spp", "text/xml");
        httpContentTypeMap.put(".sst", "application/vnd.ms-pki.certstore");
        httpContentTypeMap.put(".stm", "text/html");
        httpContentTypeMap.put(".svg", "text/xml");
        httpContentTypeMap.put(".tdf", "application/x-tdf");
        httpContentTypeMap.put(".tga", "application/x-tga");
        httpContentTypeMap.put(".tif", "application/x-tif");
        httpContentTypeMap.put(".tld", "text/xml");
        httpContentTypeMap.put(".torrent", "application/x-bittorrent");
        httpContentTypeMap.put(".txt", "text/plain");
        httpContentTypeMap.put(".uls", "text/iuls");
        httpContentTypeMap.put(".vda", "application/x-vda");
        httpContentTypeMap.put(".vml", "text/xml");
        httpContentTypeMap.put(".vsd", "application/vnd.visio");
        httpContentTypeMap.put(".vss", "application/vnd.visio");
        httpContentTypeMap.put(".vst", "application/x-vst");
        httpContentTypeMap.put(".vsx", "application/vnd.visio");
        httpContentTypeMap.put(".vxml", "text/xml");
        httpContentTypeMap.put(".wax", "audio/x-ms-wax");
        httpContentTypeMap.put(".wb2", "application/x-wb2");
        httpContentTypeMap.put(".wbmp", "image/vnd.wap.wbmp");
        httpContentTypeMap.put(".wk3", "application/x-wk3");
        httpContentTypeMap.put(".wkq", "application/x-wkq");
        httpContentTypeMap.put(".wm", "video/x-ms-wm");
        httpContentTypeMap.put(".wmd", "application/x-ms-wmd");
        httpContentTypeMap.put(".wml", "text/vnd.wap.wml");
        httpContentTypeMap.put(".wmx", "video/x-ms-wmx");
        httpContentTypeMap.put(".wp6", "application/x-wp6");
        httpContentTypeMap.put(".wpg", "application/x-wpg");
        httpContentTypeMap.put(".wq1", "application/x-wq1");
        httpContentTypeMap.put(".wri", "application/x-wri");
        httpContentTypeMap.put(".ws", "application/x-ws");
        httpContentTypeMap.put(".wsc", "text/scriptlet");
        httpContentTypeMap.put(".wvx", "video/x-ms-wvx");
        httpContentTypeMap.put(".xdr", "text/xml");
        httpContentTypeMap.put(".xfdf", "application/vnd.adobe.xfdf");
        httpContentTypeMap.put(".xls", "application/vnd.ms-excel");
        httpContentTypeMap.put(".xlw", "application/x-xlw");
        httpContentTypeMap.put(".xpl", "audio/scpls");
        httpContentTypeMap.put(".xql", "text/xml");
        httpContentTypeMap.put(".xsd", "text/xml");
        httpContentTypeMap.put(".xslt", "text/xml");
        httpContentTypeMap.put(".x_b", "application/x-x_b");
        httpContentTypeMap.put(".sisx", "application/vnd.symbian.install");
        httpContentTypeMap.put(".ipa", "application/vnd.iphone");
        httpContentTypeMap.put(".xap", "application/x-silverlight-app");
    }

    public static String textToHTML(String strText) {
        strText = strText.replace("&", "&amp;");
        strText = strText.replace("'", "&apos;");
        strText = strText.replace("\"", "&quot;");
        strText = strText.replace(" ", "&nbsp;");
        strText = strText.replace("<", "&lt;");
        strText = strText.replace(">", "&gt;");
        strText = strText.replace("\r\n", "<br>");
        strText = strText.replace("\n", "<br>");
        strText = strText.replace("\r", "<br>");
        return strText;
    }

    public static String textToHTMLWithoutReturn(String strText) {
        strText = strText.replace("&", "&amp;");
        strText = strText.replace("'", "&apos;");
        strText = strText.replace("\"", "&quot;");
        strText = strText.replace(" ", "&nbsp;");
        strText = strText.replace("<", "&lt;");
        strText = strText.replace(">", "&gt;");
        strText = strText.replace("\r\n", "");
        strText = strText.replace("\n", "");
        strText = strText.replace("\r", "");
        return strText;
    }

    public static String getJSONText(String strText, boolean bConvertNull) {
        return WebUtility.getJSONText(strText, bConvertNull, true);
    }

    public static String getJSONText(String strText, boolean bConvertNull, boolean bConvertQuotation) {
        if (StringHelper.compare(strText, "NULL", true) == 0 && bConvertNull) {
            strText = "'" + strText + "'";
        } else if (!StringHelper.isNullOrEmpty(strText) && bConvertQuotation) {
            strText = strText.replace("'", "\\'");
            strText = strText.replace("\"", "\\\"");
            strText = strText.replace("[", "\\[");
            strText = strText.replace("]", "\\]");
            strText = strText.replace("{", "\\{");
            strText = strText.replace("}", "\\}");
        }
        return strText;
    }

    public static String getJSONText(String strText) {
        return WebUtility.getJSONText(strText, true);
    }

    public static String html2Text(String inputString) {
        String htmlStr = inputString;
        htmlStr = htmlStr.replaceAll("</BR>", "</BR>\r\n");
        htmlStr = htmlStr.replaceAll("</br>", "</BR>\r\n");
        htmlStr = htmlStr.replaceAll("</bR>", "</BR>\r\n");
        htmlStr = htmlStr.replaceAll("</Br>", "</BR>\r\n");
        String textStr = "";
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>";
            Pattern p_script = Pattern.compile(regEx_script, 2);
            Matcher m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll("");
            Pattern p_style = Pattern.compile(regEx_style, 2);
            Matcher m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll("");
            Pattern p_html = Pattern.compile(regEx_html, 2);
            Matcher m_html = p_html.matcher(htmlStr);
            textStr = htmlStr = m_html.replaceAll("");
            textStr = textStr.replace("&amp;", "&");
            textStr = textStr.replace("&apos;", "'");
            textStr = textStr.replace("&quot;", "\"");
            textStr = textStr.replace("&nbsp;", " ");
            textStr = textStr.replace("&lt;", "<");
            textStr = textStr.replace("&gt;", ">");
        }
        catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr;
    }

    public static String appendURLSeperator(String strURL) {
        if (!StringHelper.isNullOrEmpty(strURL)) {
            int nPos = strURL.indexOf("?");
            if (nPos == -1) {
                strURL = String.valueOf(strURL) + "?";
            } else if (nPos != strURL.length() - 1 && strURL.lastIndexOf("&") != strURL.length() - 1) {
                strURL = String.valueOf(strURL) + "&";
            }
        }
        return strURL;
    }

    public static String encodeURLParamValue(String strValue) {
        try {
            return URLEncoder.encode(strValue, "UTF-8");
        }
        catch (Exception ex) {
            return strValue;
        }
    }

    public static String getQueryString(Map<String, String> params) {
        String strURLCall = "";
        for (String strName : params.keySet()) {
            String strValue = params.get(strName);
            if (StringHelper.length(strName) == 0 || StringHelper.length(strValue) == 0) continue;
            if (strURLCall.length() > 0) {
                strURLCall = String.valueOf(strURLCall) + "&";
            }
            strURLCall = String.valueOf(strURLCall) + strName;
            strURLCall = String.valueOf(strURLCall) + "=";
            try {
                strURLCall = String.valueOf(strURLCall) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                strURLCall = String.valueOf(strURLCall) + strValue;
            }
        }
        return strURLCall;
    }

    public static String getQueryString(Map<String, String> params, String strSeparator) {
        String strURLCall = "";
        if (StringHelper.isNullOrEmpty(strSeparator)) {
            strSeparator = "&";
        }
        for (String strName : params.keySet()) {
            String strValue = params.get(strName);
            if (StringHelper.length(strName) == 0 || StringHelper.length(strValue) == 0) continue;
            if (strURLCall.length() > 0) {
                strURLCall = String.valueOf(strURLCall) + strSeparator;
            }
            strURLCall = String.valueOf(strURLCall) + strName;
            strURLCall = String.valueOf(strURLCall) + "=";
            try {
                strURLCall = String.valueOf(strURLCall) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                strURLCall = String.valueOf(strURLCall) + strValue;
            }
        }
        return strURLCall;
    }

    public static void parseQueryString(String strQueryString, Map<String, String> urlParams) {
        if (strQueryString == null) {
            return;
        }
        String[] strLists = strQueryString.split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    if (StringHelper.length(strValue) != 0) {
                        urlParams.put(set[0].toUpperCase(), strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
    }

    public static String filterQueryString(String strQueryString) {
        if (StringHelper.isNullOrEmpty(strQueryString)) {
            return strQueryString;
        }
        String[] strLists = strQueryString.split("&");
        Hashtable<String, String> paramList = new Hashtable<String, String>();
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    strValue = WebUtility.filterRequestValue(strValue);
                    if (StringHelper.length(strValue) != 0) {
                        paramList.put(set[0], strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
        return WebUtility.getQueryString(paramList);
    }

    public static String filterRequestValue(String strValue) {
        if (StringHelper.isNullOrEmpty(strValue)) {
            return strValue;
        }
        String strProcessValue = strValue.toUpperCase();
        strProcessValue = strProcessValue.replace("\r", " ");
        strProcessValue = strProcessValue.replace("\n", " ");
        strProcessValue = strProcessValue.replace("\t", " ");
        int i = 0;
        while (i < filterkeywords.length) {
            if (strProcessValue.indexOf(filterkeywords[i]) != -1) {
                return "";
            }
            ++i;
        }
        strProcessValue = strProcessValue.replace(" ", "");
        i = 0;
        while (i < filterkeywords2.length) {
            if (strProcessValue.indexOf(filterkeywords2[i]) != -1) {
                return "";
            }
            ++i;
        }
        strValue = strValue.replace("'", "");
        strValue = strValue.replace("\"", "");
        return strValue;
    }

    public static String getHttpContentType(String strExt) {
        if (StringHelper.isNullOrEmpty(strExt)) {
            return "application/octet-stream";
        }
        String strType = httpContentTypeMap.get(strExt.toLowerCase());
        if (StringHelper.isNullOrEmpty(strType)) {
            return "application/octet-stream";
        }
        return strType;
    }
}

