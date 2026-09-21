/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcrobotlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="69D13BB0-BFD4-4CBB-BA84-053AC2AF5AA3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CANCELFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENERGY`, t1.`LOGLEVEL`, t1.`LOGLEVEL2`, t1.`LOGTYPE`, t1.`PSDCROBOTID`, t1.`PSDCROBOTLOGID`, t1.`PSDCROBOTLOGNAME`, t1.`PSDCROBOTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSDCROBOTLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGINFO", expression="t1.`LOGINFO`", showorder=-1), @DEDataQueryCodeExp(name="CANCELFLAG", expression="t1.`CANCELFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENERGY", expression="t1.`ENERGY`", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.`LOGLEVEL`", showorder=4), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.`LOGLEVEL2`", showorder=5), @DEDataQueryCodeExp(name="LOGTYPE", expression="t1.`LOGTYPE`", showorder=6), @DEDataQueryCodeExp(name="PSDCROBOTID", expression="t1.`PSDCROBOTID`", showorder=7), @DEDataQueryCodeExp(name="PSDCROBOTLOGID", expression="t1.`PSDCROBOTLOGID`", showorder=8), @DEDataQueryCodeExp(name="PSDCROBOTLOGNAME", expression="t1.`PSDCROBOTLOGNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDCROBOTNAME", expression="t1.`PSDCROBOTNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CANCELFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.ENERGY, t1.LOGLEVEL, t1.LOGLEVEL2, t1.LOGTYPE, t1.PSDCROBOTID, t1.PSDCROBOTLOGID, t1.PSDCROBOTLOGNAME, t1.PSDCROBOTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSDCROBOTLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGINFO", expression="t1.LOGINFO", showorder=-1), @DEDataQueryCodeExp(name="CANCELFLAG", expression="t1.CANCELFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENERGY", expression="t1.ENERGY", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.LOGLEVEL", showorder=4), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.LOGLEVEL2", showorder=5), @DEDataQueryCodeExp(name="LOGTYPE", expression="t1.LOGTYPE", showorder=6), @DEDataQueryCodeExp(name="PSDCROBOTID", expression="t1.PSDCROBOTID", showorder=7), @DEDataQueryCodeExp(name="PSDCROBOTLOGID", expression="t1.PSDCROBOTLOGID", showorder=8), @DEDataQueryCodeExp(name="PSDCROBOTLOGNAME", expression="t1.PSDCROBOTLOGNAME", showorder=9), @DEDataQueryCodeExp(name="PSDCROBOTNAME", expression="t1.PSDCROBOTNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16)}, conds={})})
public class PSDCRobotLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCRobotLogDefaultDQModel() {
        this.initAnnotation(PSDCRobotLogDefaultDQModel.class);
    }
}

