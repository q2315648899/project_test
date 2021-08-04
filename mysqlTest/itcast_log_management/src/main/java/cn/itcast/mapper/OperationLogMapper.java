package cn.itcast.mapper;

import cn.itcast.pojo.OperationLog;
import cn.itcast.pojo.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OperationLogMapper {

    public void insert(OperationLog operationLog);

    /**
     * 查询结果列表
     */
    public List<OperationLog> findByCondition(Map paramMap);

    /**
     * 获取符合条件的总记录数
     * @param paramMap
     * @return
     */
    public Long countByCondition(Map paramMap);

}
