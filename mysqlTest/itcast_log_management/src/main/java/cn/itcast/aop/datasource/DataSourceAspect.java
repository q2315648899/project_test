package cn.itcast.aop.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy//配置spring开启注解AOP的支持
@Order(-9999)//设置Bean加载的优先级，值越小优先级越高。通过 @Order(-9999) 注解来控制事务管理器, 与该通知类的加载顺序 , 需要让通知类 , 先加载 , 来判定使用哪个数据源 .
public class DataSourceAspect {

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     */
    @Before("execution(* cn.itcast.service.*.*(..))")
    public void beforeExecute(JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();
        System.out.println("------> 拦截的方法名 : " + name);

        for (String key : ChooseDataSource.METHOD_TYPE_MAP.keySet()) {
            for (String type : ChooseDataSource.METHOD_TYPE_MAP.get(key)) {
                if(name.startsWith(type)){
                    DataSourceHandler.putDataSource(key);
                    System.out.println("---------> 获取当前使用的数据库连接池 : " + key);
                    break;
                }
            }
        }

    }


}
