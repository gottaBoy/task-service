/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dataaudit.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="326125ce130f4bec558c9778daef045c",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="66064FCB-6E42-48DE-A6E0-3DB2F71181C4",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DataAuditDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DataAuditDefaultDSModelBase() {
        super();

        this.initAnnotation(DataAuditDefaultDSModelBase.class);
    }




}