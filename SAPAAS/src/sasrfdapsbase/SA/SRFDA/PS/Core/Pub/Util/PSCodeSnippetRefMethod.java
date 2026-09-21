/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSCodeSnippetRefMethod
implements TemplateMethodModelEx {
    private IPSCodeSnippetPublisher iPSCodeSnippetPublisher = null;

    public PSCodeSnippetRefMethod(IPSCodeSnippetPublisher iPSCodeSnippetPublisher) {
        this.iPSCodeSnippetPublisher = iPSCodeSnippetPublisher;
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() != 2) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e");
        }
        try {
            return this.iPSCodeSnippetPublisher.getRef(arg0.get(0).toString(), arg0.get(1));
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

