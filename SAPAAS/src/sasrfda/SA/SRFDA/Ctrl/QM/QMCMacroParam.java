/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.Ctrl.QM;

import SA.SRFDA.Ctrl.IDAQueryModelContext;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class QMCMacroParam
implements TemplateMethodModel {
    protected IDAQueryModelContext qmc = null;
    public static final int MPTYPE_FIELD = 0;
    public static final int MPTYPE_CURFIELD = 1;
    public static final int MPTYPE_MAINFIELD = 2;
    public static final int MPTYPE_TABLE = 3;
    public static final int MPTYPE_PARAM = 4;
    public static final int MPTYPE_STATICPARAM = 5;
    protected int nMPType = 0;

    public void setDAQueryModelContext(IDAQueryModelContext qmc) {
        this.qmc = qmc;
    }

    public void setMPType(int nMPType) {
        this.nMPType = nMPType;
    }

    public Object exec(List arg0) throws TemplateModelException {
        switch (this.nMPType) {
            case 0: {
                if (arg0.size() != 2) {
                    throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
                }
                return this.qmc.Field(arg0.get(0).toString(), arg0.get(1).toString());
            }
            case 1: {
                if (arg0.size() != 1) {
                    throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
                }
                return this.qmc.CurField(arg0.get(0).toString());
            }
            case 2: {
                if (arg0.size() != 1) {
                    throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
                }
                return this.qmc.MainField(arg0.get(0).toString());
            }
            case 3: {
                if (arg0.size() == 1) {
                    return this.qmc.Table(arg0.get(0).toString(), true);
                }
                if (arg0.size() == 2) {
                    return this.qmc.Table(arg0.get(0).toString(), StringHelper.Compare((String)arg0.get(1).toString(), (String)"TRUE", (boolean)true) == 0);
                }
                throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
            }
            case 4: {
                if (arg0.size() == 1) {
                    return this.qmc.Param(arg0.get(0).toString());
                }
                throw new TemplateModelException("\u53d8\u91cf\u65e0\u6548");
            }
            case 5: {
                if (arg0.size() == 1) {
                    return this.qmc.StaticParam(arg0.get(0).toString());
                }
                throw new TemplateModelException("\u9759\u6001\u53d8\u91cf\u65e0\u6548");
            }
        }
        return "\u672a\u77e5\u7c7b\u578b";
    }
}

