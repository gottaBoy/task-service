/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction
 *  SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery
 *  SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEDAOBaseCodePublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    public static final String CODETEMPL_DEACTION = "DEACTION";

    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> deActions = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEActions = iPSDataEntity.getAllPSDEActions();
        while (psDEActions.hasNext()) {
            IPSDEAction iPSDEAction = (IPSDEAction)psDEActions.next();
            if (StringHelper.Compare((String)"SYSDBPROC", (String)iPSDEAction.getActionType(), (boolean)true) != 0) continue;
            String strTagName = StringHelper.Format((String)"%1$s_%2$s", (Object)CODETEMPL_DEACTION, (Object)iPSDEAction.getActionType());
            String strMethodName = iPSDEAction.getCodeName();
            String strNewMethodName = String.valueOf(strMethodName.substring(0, 1).toLowerCase()) + strMethodName.substring(1);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("methodname", strNewMethodName);
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(strTagName, iPSDEAction, map);
            deActions.add(iPSGenerateCodeResult);
        }
        params.put("deactions", deActions);
        ArrayList<IPSDEDataQueryCode> psDEDataQueryCodeList = new ArrayList<IPSDEDataQueryCode>();
        Iterator psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
        while (psDEDataQueries.hasNext()) {
            IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)psDEDataQueries.next();
            Iterator psDEDataQueryCodes = iPSDEDataQuery.getAllPSDEDataQueryCodes();
            while (psDEDataQueryCodes.hasNext()) {
                psDEDataQueryCodeList.add((IPSDEDataQueryCode)psDEDataQueryCodes.next());
            }
        }
        params.put("dedqcodes", psDEDataQueryCodeList);
        params.put("de", iPSDataEntity);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDataEntity, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

