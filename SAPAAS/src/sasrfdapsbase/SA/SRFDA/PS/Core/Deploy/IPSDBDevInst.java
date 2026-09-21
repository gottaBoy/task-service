/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Deploy.IPSDBServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDBDevInst
extends IPSObject,
IPSRemoteResObject,
IPSDatabase,
IPSDCResObject {
    public static final String CFG_DB_NAME = "db.name";
    public static final String CFG_DB_TYPE = "db.type";
    public static final String CFG_DB_SCHEME = "db.scheme";
    public static final String CFG_DB_USER = "db.user";
    public static final String CFG_DB_PASS = "db.pass";
    public static final String CFG_DB_PATH = "db.path";
    public static final String CFG_DB_ADDR = "db.addr";

    public void init(ISRFDAGlobalHelper var1, PSDBDevInst var2) throws Exception;

    public String getConnUrl();

    public String getUserName();

    public String getPassword();

    public String getDBClientPath();

    public long getLastActiveTime();

    public void active();

    public boolean isClose();

    public String getPSDBServerId();

    public IPSDBServer getPSDBServer() throws Exception;
}

