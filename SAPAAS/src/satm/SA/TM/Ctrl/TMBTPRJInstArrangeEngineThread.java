/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl;

import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTPRJInstArrangeEngine;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMBTPRJInstArrangeEngineThread
implements Runnable {
    protected ITMBTPRJInstArrangeEngine iTMBTPRJInstArrangeEngine = null;
    protected ITMActionContext iTMActionContext = null;
    private static final Log log = LogFactory.getLog(TMBTPRJInstArrangeEngineThread.class);

    public TMBTPRJInstArrangeEngineThread(ITMBTPRJInstArrangeEngine iTMBTPRJInstArrangeEngine) {
        this.iTMBTPRJInstArrangeEngine = iTMBTPRJInstArrangeEngine;
    }

    public void run() {
        try {
            this.iTMBTPRJInstArrangeEngine.Arrange();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

