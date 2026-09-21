/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTPlanMT;
import SA.TM.Ctrl.ITMBTMainTaskInstPlanHelper;
import java.sql.Timestamp;
import java.util.Date;

public class TMBTMainTaskInstPlanHelper
extends BaseTMObject
implements ITMBTMainTaskInstPlanHelper {
    protected TMBTPlanMT tmBTPlanMT = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPlanMT tmBTPlanMT) throws Exception {
        this.tmBTPlanMT = tmBTPlanMT;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(tmBTPlanMT.getTMBTPLANMTID());
        this.setName(tmBTPlanMT.getTMBTPLANMTNAME());
    }

    public Timestamp getBeginTime() {
        return this.tmBTPlanMT.getBEGINTIME();
    }

    public Timestamp getEndTime() {
        return this.tmBTPlanMT.getENDTIME();
    }

    public int getScore() {
        String strBeginTime = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)this.getBeginTime().getTime());
        try {
            Date data = DateParser.Parse((String)strBeginTime);
            long nHour = (this.getEndTime().getTime() - data.getTime()) / 3600000L;
            return 10000 - (int)nHour;
        }
        catch (Exception ex) {
            long nHour = (this.getEndTime().getTime() - this.getBeginTime().getTime()) / 3600000L;
            return 10000 - (int)nHour;
        }
    }
}

