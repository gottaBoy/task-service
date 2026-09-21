/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Log;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Log.IPSLogItem;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringBuilderEx;

public class PSLogItemImpl
implements IPSLogItem {
    private Timestamp logTime = new Timestamp(new Date().getTime());
    private IPSObject iPSObject = null;
    private int nLogLevel = 0;
    private String strLogInfo = null;
    private String strUserData = null;
    private String strUserData2 = null;

    @Override
    public Timestamp getLogTime() {
        return this.logTime;
    }

    @Override
    public IPSObject getPSObject() {
        return this.iPSObject;
    }

    @Override
    public String getLogInfo() {
        return this.strLogInfo;
    }

    @Override
    public int getLogLevel() {
        return this.nLogLevel;
    }

    @Override
    public String getUserData() {
        return this.strUserData;
    }

    @Override
    public String getUserData2() {
        return this.strUserData2;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    public void setPSObject(IPSObject iPSObject) {
        this.iPSObject = iPSObject;
    }

    public void setLogLevel(int nLogLevel) {
        this.nLogLevel = nLogLevel;
    }

    public void setLogInfo(String strLogInfo) {
        this.strLogInfo = strLogInfo;
    }

    public void setUserData(String strUserData) {
        this.strUserData = strUserData;
    }

    public void setUserData2(String strUserData2) {
        this.strUserData2 = strUserData2;
    }

    public static String toString(IPSLogItem iPSLogItem) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        sb.append("%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)iPSLogItem.getLogTime());
        sb.append(" ");
        switch (iPSLogItem.getLogLevel()) {
            case 0: {
                sb.append("[\u6b63\u5e38]");
                break;
            }
            case 4: {
                sb.append("[\u8b66\u544a]");
                break;
            }
            case 1: {
                sb.append("[\u9519\u8bef]");
            }
        }
        if (iPSLogItem.getPSObject() != null) {
            sb.append(" ");
            IDataEntityModel iDataEntityModel = null;
            if (iPSLogItem.getPSObject() instanceof IPSModelObject) {
                iDataEntityModel = DEModelGlobal.getDEModel((String)((IPSModelObject)iPSLogItem.getPSObject()).getModelType(), (boolean)true);
            }
            if (iDataEntityModel != null) {
                sb.append("[%1$s]", (Object)iDataEntityModel.getLogicName());
            } else {
                sb.append("[\u672a\u77e5\u7c7b\u578b]");
            }
            sb.append(" ");
            sb.append("[%1$s]", (Object)iPSLogItem.getPSObject().getName());
        }
        if (!StringHelper.IsNullOrEmpty((String)iPSLogItem.getLogInfo())) {
            sb.append(" ");
            sb.append(iPSLogItem.getLogInfo());
        }
        return sb.toString();
    }
}

