/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.Pub.PSImportHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSImportHelperMethod
implements TemplateMethodModel {
    public Object exec(List arg0) throws TemplateModelException {
        return PSImportHelper.getCurrent();
    }
}

