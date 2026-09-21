/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTPRJMT;
import SA.TM.Ctrl.ITMBTMainTaskHelper;
import SA.TM.Ctrl.ITMBTTaskHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTMainTaskHelper
extends BaseTMObject
implements ITMBTMainTaskHelper {
    protected TMBTPRJMT tmBTPRJMT = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPRJMT tmBTPRJMT) throws Exception {
        this.tmBTPRJMT = tmBTPRJMT;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.tmBTPRJMT.getTMBTPRJMTID());
        this.setName(this.tmBTPRJMT.getTMBTPRJMTNAME());
        this.OnInit();
    }

    @Override
    public Vector<ITMBTTaskHelper> getBTTasks() {
        return null;
    }

    @Override
    public boolean isCancelable() {
        return false;
    }

    @Override
    public boolean isExtracted() {
        return false;
    }

    public boolean isMatch(ITMBTMainTaskHelper iTMBTMainTaskHelper) {
        return false;
    }
}

