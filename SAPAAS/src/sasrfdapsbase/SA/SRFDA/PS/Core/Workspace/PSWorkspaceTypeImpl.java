/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspaceType;
import SA.SRFDA.PS.Core.Workspace.PSWorkspacePeriod;
import SA.SRFDA.PS.Data.PSWorkspaceType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkspaceTypeImpl
extends PSObjectImpl
implements IPSWorkspaceType {
    private static final Log log = LogFactory.getLog(PSWorkspaceTypeImpl.class);
    public static final String TAG_WORKDAYS = "WORKDAYS";
    public static final String TAG_HOLIDAYS = "HOLIDAYS";
    public static final String TAG_WORKDAYPERIODS = "WORKDAYPERIODS";
    public static final String TAG_HOLIDAYSPERIODS = "HOLIDAYSPERIODS";
    protected PSWorkspaceType psWorkspaceType = null;
    private Map<String, Integer> psModelLimitMap = new HashMap<String, Integer>();
    private String strWorkspaceMode = "B";
    private boolean bBMode = false;
    private boolean bCMode = false;
    private boolean bTMode = false;
    private long nExp = -1L;
    private long nExp2 = -1L;
    private List<String> entityList = new ArrayList<String>();
    private Map<String, String> workdayMap = new HashMap<String, String>();
    private Map<String, String> holidayMap = new HashMap<String, String>();
    private Map<Long, Long> workdayPeriodMap = new TreeMap<Long, Long>();
    private Map<Long, Long> holidayPeriodMap = new TreeMap<Long, Long>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSWorkspaceType psWorkspaceType) throws Exception {
        String strHolidays;
        long nEndTime;
        String[] parts;
        String strDay;
        String[] days;
        String strWorkdays;
        int n;
        Enumeration<Object> keys;
        Properties modelLimitProperties;
        this.psWorkspaceType = psWorkspaceType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psWorkspaceType.getPSWORKSPACETYPEID());
        this.setName(psWorkspaceType.getPSWORKSPACETYPENAME());
        psWorkspaceType.set("USERPARAMS", psWorkspaceType.getTYPEPARAMS());
        this.setPSObjectData(this.psWorkspaceType);
        if (!StringHelper.isNullOrEmpty((String)this.psWorkspaceType.getWORKSPACEMODE())) {
            this.strWorkspaceMode = this.psWorkspaceType.getWORKSPACEMODE();
        }
        if (StringHelper.compare((String)this.getWorkspaceMode(), (String)"B", (boolean)false) == 0) {
            this.bBMode = true;
        } else if (StringHelper.compare((String)this.getWorkspaceMode(), (String)"C", (boolean)false) == 0) {
            this.bCMode = true;
        } else if (StringHelper.compare((String)this.getWorkspaceMode(), (String)"T1", (boolean)false) == 0) {
            this.bTMode = true;
        } else {
            this.bBMode = true;
        }
        if (!this.psWorkspaceType.isEXPNull()) {
            this.nExp = this.psWorkspaceType.getEXP();
        }
        if (!this.psWorkspaceType.isEXP2Null()) {
            this.nExp2 = this.psWorkspaceType.getEXP2();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWorkspaceType.getPSMODELLIMITS()) && (modelLimitProperties = PropertiesHelper.load((String)this.psWorkspaceType.getPSMODELLIMITS())) != null && (keys = modelLimitProperties.keys()) != null) {
            while (keys.hasMoreElements()) {
                String strKey = (String)keys.nextElement();
                Integer nValue = PropertiesHelper.getProperty((Properties)modelLimitProperties, (String)strKey, (int)-1);
                this.psModelLimitMap.put(strKey.toUpperCase(), nValue);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWorkspaceType.getENTITYLIST())) {
            String strTotal = this.psWorkspaceType.getENTITYLIST().replace("\r\n", ";").replace("\r", ";").replace("\n", ";").toUpperCase();
            String[] items = strTotal.split("[;]");
            HashMap<String, String> entityMap = new HashMap<String, String>();
            String[] stringArray = items;
            int n2 = items.length;
            n = 0;
            while (n < n2) {
                String strItem = stringArray[n];
                String strItem2 = strItem.trim();
                if (!StringHelper.isNullOrEmpty((String)strItem2)) {
                    entityMap.put(strItem2, "");
                }
                ++n;
            }
            this.entityList.addAll(entityMap.keySet());
        }
        if (!StringHelper.isNullOrEmpty((String)(strWorkdays = this.getUserParam(TAG_WORKDAYS, null))) && !StringHelper.isNullOrEmpty((String)(strWorkdays = strWorkdays.trim().replace(" ", ""))) && (days = strWorkdays.split("[;]")) != null && days.length > 0) {
            String[] stringArray = days;
            n = days.length;
            int n3 = 0;
            while (n3 < n) {
                strDay = stringArray[n3];
                this.workdayMap.put(strDay, "");
                ++n3;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(strWorkdays = this.getUserParam(TAG_WORKDAYPERIODS, "0000-0800;2000-2400"))) && !StringHelper.isNullOrEmpty((String)(strWorkdays = strWorkdays.trim().replace(" ", ""))) && (days = strWorkdays.split("[;]")) != null && days.length > 0) {
            String[] stringArray = days;
            n = days.length;
            int n4 = 0;
            while (n4 < n) {
                strDay = stringArray[n4];
                parts = strDay.split("[-]");
                if (parts != null && parts.length == 2) {
                    long nBeginTime = Long.parseLong(parts[0]);
                    nEndTime = Long.parseLong(parts[1]);
                    this.workdayPeriodMap.put(nBeginTime / 100L * 60L + nBeginTime % 100L, nEndTime / 100L * 60L + nEndTime % 100L);
                }
                ++n4;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(strHolidays = this.getUserParam(TAG_HOLIDAYS, "1001;1002;1003;1004;1005;1006;1007;1008"))) && !StringHelper.isNullOrEmpty((String)(strHolidays = strHolidays.trim().replace(" ", ""))) && (days = strHolidays.split("[;]")) != null && days.length > 0) {
            String[] stringArray = days;
            n = days.length;
            int n5 = 0;
            while (n5 < n) {
                strDay = stringArray[n5];
                this.holidayMap.put(strDay, "");
                ++n5;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(strHolidays = this.getUserParam(TAG_HOLIDAYSPERIODS, "0000-2400"))) && !StringHelper.isNullOrEmpty((String)(strHolidays = strHolidays.trim().replace(" ", ""))) && (days = strHolidays.split("[;]")) != null && days.length > 0) {
            String[] stringArray = days;
            n = days.length;
            int n6 = 0;
            while (n6 < n) {
                strDay = stringArray[n6];
                parts = strDay.split("[-]");
                if (parts != null && parts.length == 2) {
                    long nBeginTime = Long.parseLong(parts[0]);
                    nEndTime = Long.parseLong(parts[1]);
                    this.holidayPeriodMap.put(nBeginTime / 100L * 60L + nBeginTime % 100L, nEndTime / 100L * 60L + nEndTime % 100L);
                }
                ++n6;
            }
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public int getPSModelLimit(String strModel) {
        Integer nRet = this.psModelLimitMap.get(strModel);
        if (nRet == null) {
            return -1;
        }
        return nRet;
    }

    @Override
    public Iterator<String> getPSModelLimitNames() {
        if (this.psModelLimitMap == null || this.psModelLimitMap.size() == 0) {
            return null;
        }
        return this.psModelLimitMap.keySet().iterator();
    }

    @Override
    public String getWorkspaceMode() {
        return this.strWorkspaceMode;
    }

    @Override
    public boolean isBMode() {
        return this.bBMode;
    }

    @Override
    public boolean isCMode() {
        return this.bCMode;
    }

    @Override
    public long getExp() {
        return this.nExp;
    }

    @Override
    public long getExp2() {
        return this.nExp2;
    }

    @Override
    public Iterator<String> getEntities() {
        if (this.entityList == null || this.entityList.size() == 0) {
            return null;
        }
        return this.entityList.iterator();
    }

    @Override
    public PSWorkspacePeriod calcPSWorkspacePeriod(Timestamp calcTime, boolean bNextValid) throws Exception {
        int nDay;
        if (!this.isCMode()) {
            throw new Exception("\u6b64\u529f\u80fd\u4ec5\u652f\u6301\u793e\u533a\u751f\u4ea7\u7ebf");
        }
        if (calcTime == null) {
            calcTime = new Timestamp(System.currentTimeMillis());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calcTime);
        String strDay = StringHelper.format((String)"%1$tm%1$td", (Object)calcTime);
        boolean bWorkday = false;
        bWorkday = this.workdayMap.containsKey(strDay) ? true : (this.holidayMap.containsKey(strDay) ? false : (nDay = calendar.get(7)) != 1 && nDay != 7);
        int nHour = calendar.get(11);
        int nMinute = calendar.get(12);
        int nValue = nHour * 60 + nMinute;
        Map<Long, Long> periodMap = bWorkday ? this.workdayPeriodMap : this.holidayPeriodMap;
        for (Map.Entry<Long, Long> slot : periodMap.entrySet()) {
            if ((long)nValue < slot.getKey() || (long)nValue >= slot.getValue()) continue;
            PSWorkspacePeriod psWorkspacePeriod = new PSWorkspacePeriod();
            psWorkspacePeriod.setNextMode(false);
            psWorkspacePeriod.setBeginTime(calcTime);
            if (slot.getValue() == 1440L) {
                Calendar nextDay = Calendar.getInstance();
                nextDay.setTime(calcTime);
                nextDay.set(11, 0);
                nextDay.set(12, 0);
                nextDay.set(13, 0);
                nextDay.set(14, 0);
                nextDay.add(6, 1);
                PSWorkspacePeriod nextPeriod = this.calcPSWorkspacePeriod(new Timestamp(nextDay.getTimeInMillis()), false);
                if (nextPeriod == null) {
                    psWorkspacePeriod.setEndTime(new Timestamp(nextDay.getTimeInMillis()));
                } else {
                    psWorkspacePeriod.setEndTime(nextPeriod.getEndTime());
                }
            } else {
                calendar.set(11, (int)(slot.getValue() / 60L));
                calendar.set(12, (int)(slot.getValue() % 60L));
                calendar.set(13, 0);
                calendar.set(14, 0);
                psWorkspacePeriod.setEndTime(new Timestamp(calendar.getTimeInMillis()));
            }
            return psWorkspacePeriod;
        }
        if (bNextValid) {
            for (Map.Entry<Long, Long> slot : periodMap.entrySet()) {
                if ((long)nValue >= slot.getKey() || (long)nValue >= slot.getValue()) continue;
                PSWorkspacePeriod psWorkspacePeriod = new PSWorkspacePeriod();
                psWorkspacePeriod.setNextMode(true);
                calendar.set(11, (int)(slot.getKey() / 60L));
                calendar.set(12, (int)(slot.getKey() % 60L));
                calendar.set(13, 0);
                calendar.set(14, 0);
                psWorkspacePeriod.setBeginTime(new Timestamp(calendar.getTimeInMillis()));
                if (slot.getValue() == 1440L) {
                    Calendar nextDay = Calendar.getInstance();
                    nextDay.setTime(calcTime);
                    nextDay.set(11, 0);
                    nextDay.set(12, 0);
                    nextDay.set(13, 0);
                    nextDay.set(14, 0);
                    nextDay.add(6, 1);
                    PSWorkspacePeriod nextPeriod = this.calcPSWorkspacePeriod(new Timestamp(nextDay.getTimeInMillis()), false);
                    if (nextPeriod == null) {
                        psWorkspacePeriod.setEndTime(new Timestamp(nextDay.getTimeInMillis()));
                    } else {
                        psWorkspacePeriod.setEndTime(nextPeriod.getEndTime());
                    }
                } else {
                    calendar.set(11, (int)(slot.getValue() / 60L));
                    calendar.set(12, (int)(slot.getValue() % 60L));
                    calendar.set(13, 0);
                    calendar.set(14, 0);
                    psWorkspacePeriod.setEndTime(new Timestamp(calendar.getTimeInMillis()));
                }
                return psWorkspacePeriod;
            }
        }
        return null;
    }

    @Override
    public boolean isTMode() {
        return this.bTMode;
    }
}

