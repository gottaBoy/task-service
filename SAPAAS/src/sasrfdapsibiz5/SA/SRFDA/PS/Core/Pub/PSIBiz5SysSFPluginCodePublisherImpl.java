/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysSFPlugin
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysSFPluginCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysSFPlugin iPSSysSFPlugin = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysSFPlugins = this.iPSSystem.getAllPSSysSFPlugins();
        if (psSysSFPlugins != null) {
            while (psSysSFPlugins.hasNext()) {
                IPSSysSFPlugin iPSSysSFPlugin;
                this.iPSSysSFPlugin = iPSSysSFPlugin = (IPSSysSFPlugin)psSysSFPlugins.next();
                this.onGenerateCode(iPSSysSFPlugin, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysSFPlugin iPSSysSFPlugin, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysSFPlugin, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysSFPlugin) {
            this.iPSSysSFPlugin = (IPSSysSFPlugin)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysSFPlugin, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysSFPlugin = null;
        super.onClose();
    }
}

