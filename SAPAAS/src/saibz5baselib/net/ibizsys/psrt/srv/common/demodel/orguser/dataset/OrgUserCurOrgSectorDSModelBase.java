/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="0752B9A5-1A58-4E0F-A4C9-D8BD88AAB556",name="CurOrgSector",queries= {
    @DEDataSetQuery(queryid="F2F5158B-2435-4A40-90B9-3B5569B793AD",queryname="CurOrgSector")
})

/**
 *  实体数据集合[当前部门]模型基类
 */
public abstract class OrgUserCurOrgSectorDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUserCurOrgSectorDSModelBase() {
        super();

        this.initAnnotation(OrgUserCurOrgSectorDSModelBase.class);
    }




}