/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysPFPlugin
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysPFPluginCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysPFPlugin iPSSysPFPlugin = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysPFPlugins = this.iPSSystem.getAllPSSysPFPlugins();
        if (psSysPFPlugins != null) {
            while (psSysPFPlugins.hasNext()) {
                IPSSysPFPlugin iPSSysPFPlugin;
                this.iPSSysPFPlugin = iPSSysPFPlugin = (IPSSysPFPlugin)psSysPFPlugins.next();
                this.onGenerateCode(iPSSysPFPlugin, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysPFPlugin iPSSysPFPlugin, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysPFPlugin, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysPFPlugin) {
            this.iPSSysPFPlugin = (IPSSysPFPlugin)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysPFPlugin, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysPFPlugin = null;
        super.onClose();
    }
}

