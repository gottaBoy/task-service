/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Data.NDConfigType;
import SA.SRFDA.ND.Data.NDConfigValue;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDDiskOwnerType;
import SA.SRFDA.ND.Data.NDFSOType;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface INDModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public String getDBStorage();

    public CallResult GetNDDiskOwnerType(String var1, NDDiskOwnerType var2);

    public CallResult GetNDFSOType(String var1, NDFSOType var2);

    public CallResult GetNDDiskByOwner(String var1, String var2, NDDisk var3);

    public CallResult GetNDFSObject(String var1, String var2, String var3, NDFSObject var4);

    public CallResult GetNDObject(String var1, NDFSObject var2);

    public CallResult GetNDShare(String var1, String var2, NDShare var3);

    public CallResult GetNDShare(String var1, NDShare var2);

    public CallResult GetNDDisk(String var1, NDDisk var2);

    public CallResult GetNDConfigType(String var1, NDConfigType var2);

    public CallResult GetNDConfigValues(String var1, Vector<NDConfigValue> var2);
}

