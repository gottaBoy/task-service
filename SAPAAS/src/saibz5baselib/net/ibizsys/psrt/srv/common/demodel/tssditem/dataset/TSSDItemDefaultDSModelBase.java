/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssditem.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="7923f282cb5da8b2419d53cb6fc6e9a7",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="DC63C7D0-E4DD-4CAB-BBF9-FE8ECAEE1432",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDItemDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDItemDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDItemDefaultDSModelBase.class);
    }




}