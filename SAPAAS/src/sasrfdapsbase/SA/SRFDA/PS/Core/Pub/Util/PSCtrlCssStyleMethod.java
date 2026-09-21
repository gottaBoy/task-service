/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.ext.beans.StringModel
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 *  net.ibizsys.paas.util.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFramework.Utility.StringHelper;
import freemarker.ext.beans.StringModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.List;
import net.ibizsys.paas.util.StringBuilderEx;

public class PSCtrlCssStyleMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u5bf9\u8c61");
        }
        try {
            Object objCtrl = arg0.get(0);
            if (objCtrl instanceof StringModel && (objCtrl = ((StringModel)objCtrl).getWrappedObject()) instanceof IPSControl) {
                StringBuilderEx sb = new StringBuilderEx();
                IPSControl iPSControl = (IPSControl)objCtrl;
                if (iPSControl.getWidth() > 0.0) {
                    sb.append("width:%1$spx;", (Object)((int)iPSControl.getWidth()));
                }
                if (iPSControl.getHeight() > 0.0) {
                    sb.append("height:%1$spx;", (Object)((int)iPSControl.getHeight()));
                }
                return sb.toString();
            }
            return "";
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

