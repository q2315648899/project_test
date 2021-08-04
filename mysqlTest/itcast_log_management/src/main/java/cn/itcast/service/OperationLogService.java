package cn.itcast.service;

import cn.itcast.mapper.OperationLogMapper;
import cn.itcast.pojo.OperationLog;
import cn.itcast.pojo.PageResult;
import cn.itcast.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    public void insert(OperationLog operationLog){
        operationLogMapper.insert(operationLog);
    }

    public PageResult findByPage(Map paramMap , Integer pageNum , Integer rows){
        if(paramMap ==null){
            paramMap = new HashMap();
        }
        paramMap.put("start" , (pageNum-1)*rows);
        paramMap.put("rows",rows);

        Object costTime = paramMap.get("costTime");
        if(costTime != null){
            if("".equals(costTime.toString())){
                paramMap.put("costTime",null);
            }else{
//                paramMap.put("costTime",new Long(costTime.toString()));
            }
        }

        long start_time = System.currentTimeMillis();
        Long count = operationLogMapper.countByCondition(paramMap);
        long end_time = System.currentTimeMillis();
        System.out.println("Count Cost Time : " + (end_time - start_time) + " ms");

        List<OperationLog> list = operationLogMapper.findByCondition(paramMap);
        long end_time2 = System.currentTimeMillis();
        System.out.println("Query Cost Time : " + (end_time2 - end_time) + " ms");

        return new PageResult(count,list);
    }
}
