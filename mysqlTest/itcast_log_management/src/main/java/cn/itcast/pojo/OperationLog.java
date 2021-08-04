package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationLog {

    private Integer id;

    //返回值
    private String returnValue;

    //返回值类型
    private String returnClass;

    //操作人
    private String operateUser;

    //操作时间
    private String operateTime;

    //参数值 , 键值对形式
    private String paramAndValue;

    //操作的类
    private String operateClass;

    //操作的方法
    private String operateMethod;

    //操作耗时
    private Long costTime;

}
