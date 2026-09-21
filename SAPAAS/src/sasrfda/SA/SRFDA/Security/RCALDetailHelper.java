/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.RCALDetail;
import SA.SRFDA.Security.IRCALDetailHelper;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;

public class RCALDetailHelper
extends BaseDAObjectHelper
implements IRCALDetailHelper {
    protected IRCAccListHelper iRCAccListHelper = null;
    protected RCALDetail rcALDetail = null;
    protected HashMap<String, String> allowActionMap = new HashMap();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IRCAccListHelper iRCAccListHelper, RCALDetail rcALDetail) throws Exception {
        String strCustomCallDetail;
        this.iRCAccListHelper = iRCAccListHelper;
        this.rcALDetail = rcALDetail;
        this.setId(rcALDetail.getRCALDETAILID());
        this.setName(rcALDetail.getRCALDETAILNAME());
        this.setDAGlobalHelper(iDAGlobalHelper);
        if (this.rcALDetail.getENABLEINSERT()) {
            this.allowActionMap.put("INSERT:", "");
            this.allowActionMap.put("INSERT:DEFAULT", "");
        }
        if (this.rcALDetail.getENABLEUPDATE()) {
            this.allowActionMap.put("UPDATE:", "");
            this.allowActionMap.put("UPDATE:DEFAULT", "");
        }
        if (this.rcALDetail.getENABLEREMOVE()) {
            this.allowActionMap.put("REMOVE:", "");
            this.allowActionMap.put("REMOVE:DEFAULT", "");
        }
        if (this.rcALDetail.getENABLECUSTOMCALL() && !StringHelper.IsNullOrEmpty((String)(strCustomCallDetail = rcALDetail.getCUSTOMCALLDETAIL()))) {
            String[] items = strCustomCallDetail.split("[;]");
            int i = 0;
            while (i < items.length) {
                this.allowActionMap.put(StringHelper.Format((String)"CUSTOMCALL:%1$s", (Object)items[i]), "");
                ++i;
            }
        }
        if (this.rcALDetail.getENABLESELECT()) {
            this.allowActionMap.put("GET:", "");
            this.allowActionMap.put("GET:DEFAULT", "");
            this.allowActionMap.put("SELECT:", "");
            this.allowActionMap.put("SELECT:DEFAULT", "");
            this.allowActionMap.put("SELECT1:", "");
            this.allowActionMap.put("SELECT1:DEFAULT", "");
            this.allowActionMap.put("SELECTEX:", "");
            this.allowActionMap.put("SELECTEX:DEFAULT", "");
        }
        this.OnInit();
    }

    @Override
    public boolean TestRemoteCall(String strAction, String strActionMode, String strArg, String strArg2) throws Exception {
        String strFullAction = StringHelper.Format((String)"%1$s:%2$s", (Object)strAction, (Object)strActionMode);
        return this.allowActionMap.containsKey(strFullAction);
    }

    @Override
    public String getDEId() {
        return this.rcALDetail.getDEID();
    }
}

