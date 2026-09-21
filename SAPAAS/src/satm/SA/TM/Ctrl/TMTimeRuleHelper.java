/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMTimeItem;
import SA.TM.Ctrl.Data.TMTimeRule;
import SA.TM.Ctrl.ITMTimeItemHelper;
import SA.TM.Ctrl.ITMTimeRuleHelper;
import SA.TM.Ctrl.TMTimeItemHelper;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class TMTimeRuleHelper
extends BaseTMObject
implements ITMTimeRuleHelper {
    protected TMTimeRule tmTimeRule = null;
    protected Vector<ITMTimeItemHelper> tmTimeItemHelperList = new Vector();
    protected boolean bValidDefault = true;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMTimeRule tmTimeRule) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmTimeRule = tmTimeRule;
        this.OnPrepareTMTimeItems();
        this.OnInit();
    }

    protected void OnPrepareTMTimeItems() throws Exception {
        Vector<TMTimeItem> list = new Vector<TMTimeItem>();
        CallResult callResult = this.getTMModelHelper().GetTMTimeItems(this.getId(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u65f6\u95f4\u89c4\u5219\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (TMTimeItem tmTimeItem : list) {
            ITMTimeItemHelper iTMTimeItemHelper = this.OnCreateTMTimeItemHelper(tmTimeItem);
            iTMTimeItemHelper.Init(this.iDAGlobalHelper, this, tmTimeItem);
            this.tmTimeItemHelperList.add(iTMTimeItemHelper);
        }
    }

    protected ITMTimeItemHelper OnCreateTMTimeItemHelper(TMTimeItem tmTimeItem) throws Exception {
        return new TMTimeItemHelper();
    }

    protected void OnInit() throws Exception {
    }

    public String getId() {
        return this.tmTimeRule.getTMTIMERULEID();
    }

    public String getName() {
        return this.tmTimeRule.getTMTIMERULENAME();
    }

    public int getVersion() {
        return this.tmTimeRule.getVERSION();
    }

    public Timestamp CalcValidTime(Timestamp beginTime, long nDuration, boolean bErrorRetNull) throws Exception {
        if (this.tmTimeItemHelperList.size() == 0) {
            return beginTime;
        }
        Timestamp curBeginTime = beginTime;
        Calendar curCal = Calendar.getInstance();
        int nLoopCount = 1000;
        boolean bAllUnknown = true;
        while (nLoopCount > 0) {
            bAllUnknown = true;
            curCal.setTime(curBeginTime);
            --nLoopCount;
            for (ITMTimeItemHelper iTMTimeItemHelper : this.tmTimeItemHelperList) {
                int nRet = iTMTimeItemHelper.CalcValidTime(curBeginTime, nDuration);
                if (nRet == 0) {
                    return curBeginTime;
                }
                if (nRet == -1) {
                    bAllUnknown = false;
                    String strNextDay = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)curBeginTime);
                    Date dtNextDay = DateParser.Parse((String)strNextDay);
                    Calendar calNext = Calendar.getInstance();
                    calNext.setTime(dtNextDay);
                    calNext.add(10, 24);
                    curBeginTime = new Timestamp(calNext.getTime().getTime());
                    break;
                }
                if (nRet == -2) continue;
                bAllUnknown = false;
                curCal.add(12, nRet);
                curBeginTime = new Timestamp(curCal.getTime().getTime());
                break;
            }
            if (!bAllUnknown) continue;
            if (this.bValidDefault) {
                return curBeginTime;
            }
            String strNextDay = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)curBeginTime);
            Date dtNextDay = DateParser.Parse((String)strNextDay);
            Calendar calNext = Calendar.getInstance();
            calNext.setTime(dtNextDay);
            calNext.add(10, 24);
            curBeginTime = new Timestamp(calNext.getTime().getTime());
        }
        if (bErrorRetNull) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65f6\u95f4\u89c4\u5219\u57281000\u6b21\u5faa\u73af\u4e2d\u65e0\u6cd5\u8ba1\u7b97\u51fa\u53ef\u7528\u7684\u65f6\u95f4\uff0c\u65f6\u957f\u4e3a[%1$s]", (Object)nDuration));
    }
}

