/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.ext.beans.StringModel
 *  freemarker.template.TemplateMethodModelEx
 *  freemarker.template.TemplateModelException
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import freemarker.ext.beans.StringModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.Iterator;
import java.util.List;

public class PSDEServiceExtendMethod
implements TemplateMethodModelEx {
    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            return false;
        }
        try {
            Object objDE = arg0.get(0);
            if (objDE instanceof StringModel && (objDE = ((StringModel)objDE).getWrappedObject()) instanceof IPSDataEntity) {
                Iterator<IPSDEDataSet> psDEDataSets;
                IPSDataEntity psDataEntity = (IPSDataEntity)objDE;
                Iterator<IPSDEAction> psDEActions = psDataEntity.getAllPSDEActions();
                if (psDEActions != null) {
                    while (psDEActions.hasNext()) {
                        IPSDEAction iPSDEAction = psDEActions.next();
                        if (!"USERCUSTOM".equals(iPSDEAction.getActionType()) || iPSDEAction.getPSSysSFPlugin() != null) continue;
                        return true;
                    }
                }
                if ((psDEDataSets = psDataEntity.getAllPSDEDataSets()) != null) {
                    while (psDEDataSets.hasNext()) {
                        IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
                        if (!"USERCUSTOM".equals(iPSDEDataSet.getDataSetType()) || iPSDEDataSet.getPSSysSFPlugin() != null) continue;
                        return true;
                    }
                }
            }
            return false;
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

