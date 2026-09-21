/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysEditorStyle
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysEditorStyleCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysEditorStyle iPSSysEditorStyle = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysEditorStyles = this.iPSSystem.getAllPSSysEditorStyles();
        if (psSysEditorStyles != null) {
            while (psSysEditorStyles.hasNext()) {
                IPSSysEditorStyle iPSSysEditorStyle = (IPSSysEditorStyle)psSysEditorStyles.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysEditorStyle.getPSSystemModule() != null && iPSSysEditorStyle.getPSSystemModule().isSubSysModule() && !iPSSysEditorStyle.getPSSystemModule().isSubSysAsCloud()) continue;
                this.iPSSysEditorStyle = iPSSysEditorStyle;
                this.onGenerateCode(iPSSysEditorStyle, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysEditorStyle iPSSysEditorStyle, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysEditorStyle, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysEditorStyle) {
            this.iPSSysEditorStyle = (IPSSysEditorStyle)iPSObject;
            if (this.iPSSysEditorStyle.getPSSystemModule() != null && this.iPSSysEditorStyle.getPSSystemModule().isSubSysModule() && !this.iPSSysEditorStyle.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysEditorStyle, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysEditorStyle = null;
        super.onClose();
    }
}

