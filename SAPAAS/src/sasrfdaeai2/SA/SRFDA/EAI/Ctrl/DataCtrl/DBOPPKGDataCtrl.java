/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IDBOPPKGDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;
import org.apache.commons.logging.Log;

public class DBOPPKGDataCtrl
extends BaseDEDataCtrl
implements IDBOPPKGDataCtrl {
    private static final Log log;
    public static final String CUSTOMCALL_PUBLISH = "PUBLISH";

    public DBOPPKGDataCtrl() {
        throw new Error("Unresolved compilation problem: \n\tThe type net.sf.json.JSONObject cannot be resolved. It is indirectly referenced from required .class files\n");
    }

    protected CallResult OnCustomCall(String string, BaseDataEntity baseDataEntity) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected CallResult OnPublish(BaseDataEntity baseDataEntity) {
        throw new Error("Unresolved compilation problem: \n");
    }

    @Override
    public CallResult Publish(String string, boolean bl) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public CallResult CopyDetail(BaseDataEntity baseDataEntity, Object object) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> vector, boolean bl) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static String ClonePkgProcModel(String string, IDEDataCtrl iDEDataCtrl) throws Exception {
        throw new Error("Unresolved compilation problem: \n");
    }
}

