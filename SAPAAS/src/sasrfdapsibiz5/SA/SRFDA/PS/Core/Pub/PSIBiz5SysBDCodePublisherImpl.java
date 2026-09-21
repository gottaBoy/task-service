/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.BA.IPSSysBDScheme
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class PSIBiz5SysBDCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    private IPSSysBDScheme iPSSysBDScheme = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysBDSchemes = this.iPSSystem.getAllPSSysBDSchemes();
        if (psSysBDSchemes != null) {
            while (psSysBDSchemes.hasNext()) {
                this.iPSSysBDScheme = (IPSSysBDScheme)psSysBDSchemes.next();
                if (this.iPSSysBDScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)this.iPSSysBDScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(this.iPSSysBDScheme, null);
            }
        }
        this.iPSSysBDScheme = null;
    }

    protected abstract void onGenerateCode(IPSSysBDScheme var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysBDScheme) {
            this.iPSSysBDScheme = (IPSSysBDScheme)iPSObject;
            if (this.iPSSysBDScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)this.iPSSysBDScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysBDScheme, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysBDScheme = null;
        super.onClose();
    }
}

