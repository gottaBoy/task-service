/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;

public class PSDEFColumnMethod
implements TemplateMethodModel {
    private IPSDataEntity iPSDataEntity = null;
    private IPSDBType iPSDBType = null;

    public PSDEFColumnMethod(IPSDataEntity iPSDataEntity, IPSDBType iPSDBType) {
        this.iPSDataEntity = iPSDataEntity;
        this.iPSDBType = iPSDBType;
    }

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return StringHelper.Format((String)"/*%1$s*/", (Object)"\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u540d\u79f0");
        }
        try {
            IPSDEField iPSDEField = this.iPSDataEntity.getPSDEField((String)arg0.get(0));
            return iPSDEField.getPSDTColumn(this.iPSDBType.getId());
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

