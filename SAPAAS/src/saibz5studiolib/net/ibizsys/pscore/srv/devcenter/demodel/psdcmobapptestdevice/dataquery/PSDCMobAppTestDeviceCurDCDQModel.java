/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmobapptestdevice.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C6F17B26-3D32-4EB8-89D5-053DAEEE16F8", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEVICEID`, t1.`MEMO`, t1.`OSTYPE`, t1.`OSVER`, t1.`PSDCMOBAPPTESTDEVICEID`, t1.`PSDCMOBAPPTESTDEVICENAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`REFCOUNT`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCMOBAPPTESTDEVICE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEVICEID", expression="t1.`DEVICEID`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="OSTYPE", expression="t1.`OSTYPE`", showorder=4), @DEDataQueryCodeExp(name="OSVER", expression="t1.`OSVER`", showorder=5), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICEID", expression="t1.`PSDCMOBAPPTESTDEVICEID`", showorder=6), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICENAME", expression="t1.`PSDCMOBAPPTESTDEVICENAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="REFCOUNT", expression="t1.`REFCOUNT`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCMOBAPPTESTDEVICE\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEVICEID, t1.MEMO, t1.OSTYPE, t1.OSVER, t1.PSDCMOBAPPTESTDEVICEID, t1.PSDCMOBAPPTESTDEVICENAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.REFCOUNT, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCMOBAPPTESTDEVICE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEVICEID", expression="t1.DEVICEID", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="OSTYPE", expression="t1.OSTYPE", showorder=4), @DEDataQueryCodeExp(name="OSVER", expression="t1.OSVER", showorder=5), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICEID", expression="t1.PSDCMOBAPPTESTDEVICEID", showorder=6), @DEDataQueryCodeExp(name="PSDCMOBAPPTESTDEVICENAME", expression="t1.PSDCMOBAPPTESTDEVICENAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="REFCOUNT", expression="t1.REFCOUNT", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCMOBAPPTESTDEVICE\"}')} )")})})
public class PSDCMobAppTestDeviceCurDCDQModel
extends DEDataQueryModelBase {
    public PSDCMobAppTestDeviceCurDCDQModel() {
        this.initAnnotation(PSDCMobAppTestDeviceCurDCDQModel.class);
    }
}

