/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncout.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="c8381accf6c7621d57757a4955ddb504",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="306BDA77-09EE-400D-A64D-A16E2E4BFA43",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DataSyncOutDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DataSyncOutDefaultDSModelBase() {
        super();

        this.initAnnotation(DataSyncOutDefaultDSModelBase.class);
    }




}