/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDECodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEUIActionModelBaseCodePublisherImpl
extends PSIBiz5SysDECodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDataEntity iPSDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psDEUIActions = iPSDataEntity.getAllPSDEUIActions();
        while (psDEUIActions.hasNext()) {
            IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)psDEUIActions.next();
            if (StringHelper.Compare((String)iPSDEUIAction.getUIActionMode(), (String)"BACKEND", (boolean)true) != 0) continue;
            this.generateCode(iPSDEUIAction, list);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSDEUIAction) {
            IPSDEUIAction iPSDEUIAction = (IPSDEUIAction)iPSObject;
            if (StringHelper.Compare((String)iPSDEUIAction.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0) {
                ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
                this.generateCode(iPSDEUIAction, list);
                return list;
            }
            return null;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSDEUIAction iPSDEUIAction, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSDataEntity> params = new HashMap<String, IPSDataEntity>();
        params.put("de", iPSDEUIAction.getPSDataEntity());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEUIAction, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

