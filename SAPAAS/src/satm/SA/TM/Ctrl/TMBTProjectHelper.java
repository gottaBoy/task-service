/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTPRJ;
import SA.TM.Ctrl.ITMBTMainTaskHelper;
import SA.TM.Ctrl.ITMBTProjectHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTProjectHelper
extends BaseTMObject
implements ITMBTProjectHelper {
    protected TMBTPRJ tmBTPRJ = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPRJ tmBTPRJ) throws Exception {
        this.tmBTPRJ = tmBTPRJ;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(tmBTPRJ.getTMBTPRJID());
        this.setName(tmBTPRJ.getTMBTPRJNAME());
    }

    @Override
    public Timestamp getBeginTime() {
        return this.tmBTPRJ.getBEGINTIME();
    }

    @Override
    public Timestamp getEndTime() {
        if (this.tmBTPRJ.isENDTIMENull()) {
            return null;
        }
        return this.tmBTPRJ.getENDTIME();
    }

    @Override
    public Vector<ITMBTMainTaskHelper> getBTMainTasks() throws Exception {
        return null;
    }
}

