/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDBServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_DBS_TYPE = "dbs.type";
    public static final String CFG_DBS_USER = "dbs.user";
    public static final String CFG_DBS_PASS = "dbs.pass";
    public static final String CFG_DBS_ADDR = "dbs.addr";
    public static final String CFG_DBS_PORT = "dbs.port";
    public static final String CFG_DBS_URL = "dbs.url";

    public void init(ISRFDAGlobalHelper var1, PSDBServer var2) throws Exception;

    public String getDBType();

    public String getDBAddress();

    public int getDBPort();

    public String getDBUserName();

    public String getDBPassword();

    public String getDBUrl();

    public String getPSAppServerId();

    public IPSAppServer getPSAppServer() throws Exception;
}

