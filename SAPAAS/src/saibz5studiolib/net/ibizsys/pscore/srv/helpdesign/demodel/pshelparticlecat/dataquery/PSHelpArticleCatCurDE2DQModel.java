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
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelparticlecat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="562C00B9-E7AF-4DBB-BA55-01E7E0EAA9B5", name="CurDE2")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ARTICLETYPE`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSHELPARTICLECATID`, t1.`PSHELPARTICLECATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSHELPARTICLECAT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ARTICLETYPE", expression="t1.`ARTICLETYPE`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=6), @DEDataQueryCodeExp(name="PSHELPARTICLECATID", expression="t1.`PSHELPARTICLECATID`", showorder=7), @DEDataQueryCodeExp(name="PSHELPARTICLECATNAME", expression="t1.`PSHELPARTICLECATNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEID` =  ${srfdatacontext('psdeid','{\"defname\":\"PSDEID\",\"dename\":\"PSHELPARTICLECAT\"}')}  AND  t1.`ARTICLETYPE` =  ${srfdatacontext('articletype','{\"defname\":\"ARTICLETYPE\",\"dename\":\"PSHELPARTICLECAT\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.ARTICLETYPE, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEID, t1.PSDENAME, t1.PSHELPARTICLECATID, t1.PSHELPARTICLECATNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSHELPARTICLECAT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ARTICLETYPE", expression="t1.ARTICLETYPE", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=6), @DEDataQueryCodeExp(name="PSHELPARTICLECATID", expression="t1.PSHELPARTICLECATID", showorder=7), @DEDataQueryCodeExp(name="PSHELPARTICLECATNAME", expression="t1.PSHELPARTICLECATNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEID =  ${srfdatacontext('psdeid','{\"defname\":\"PSDEID\",\"dename\":\"PSHELPARTICLECAT\"}')}  AND  t1.ARTICLETYPE =  ${srfdatacontext('articletype','{\"defname\":\"ARTICLETYPE\",\"dename\":\"PSHELPARTICLECAT\"}')} )")})})
public class PSHelpArticleCatCurDE2DQModel
extends DEDataQueryModelBase {
    public PSHelpArticleCatCurDE2DQModel() {
        this.initAnnotation(PSHelpArticleCatCurDE2DQModel.class);
    }
}

