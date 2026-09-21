/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vladsch.flexmark.ast.Document
 *  com.vladsch.flexmark.ast.Node
 *  com.vladsch.flexmark.ext.tables.TablesExtension
 *  com.vladsch.flexmark.html.HtmlRenderer
 *  com.vladsch.flexmark.parser.Parser
 *  com.vladsch.flexmark.parser.ParserEmulationProfile
 *  com.vladsch.flexmark.util.options.DataHolder
 *  com.vladsch.flexmark.util.options.MutableDataSet
 *  com.vladsch.flexmark.util.options.MutableDataSetter
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Util;

import com.vladsch.flexmark.ast.Document;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.vladsch.flexmark.util.options.MutableDataSetter;
import java.util.Arrays;
import net.ibizsys.paas.util.StringHelper;

public class MarkDownHelper {
    public static String renderHtml(String strMDContent) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strMDContent)) {
            return "";
        }
        MutableDataSet options = new MutableDataSet();
        options.setFrom((MutableDataSetter)ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
        Parser parser = Parser.builder((DataHolder)options).build();
        HtmlRenderer renderer = HtmlRenderer.builder((DataHolder)options).build();
        Document document = parser.parse(strMDContent);
        return renderer.render((Node)document);
    }

    public static String renderHtml2(String strMDContent) {
        try {
            return MarkDownHelper.renderHtml(strMDContent);
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }
}

