package com.zzyy.study.t1;

/**
 * @auther zzyy
 * @create 2021-05-30 13:56
 */
public class DoubleWriteConsistencyDemo
{



    //===========================================================================================
    //  下面都是伪代码，参考思路，
    /*public void deleteOrderData(Order order)
    {
        try(Jedis jedis = RedisUtils.getJedis())
        {
            //1 线程A先成功删除redis缓存
            jedis.del(order.getId()+"");
            //2 线程A再更新mysql
            orderDao.update(order);
            //暂停20秒钟，其它业务逻辑导致耗时延时，20是随便乱写的，只是为了讲解技术方便
            try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Order selectOrderData(Order order)
    {
        try(Jedis jedis = RedisUtils.getJedis())
        {
            //1 先去redis里面查找,找到返回数据找不到去mysql查找
            String result = jedis.get(order.getId() + "");
            if (result != null) {
                return (Order) JSON.parse(result);
            }else{
                order = orderDao.getOrderById(order.getId());
                //2 线程B会将从mysql查到的旧数据写回到redis
                jedis.set(order.getId()+"",order.toString());
                return order;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteDoubleOrderDelay2(Order order)
    {
        try(Jedis jedis = RedisUtils.getJedis())
        {
            //1 线程A先成功删除redis缓存
            jedis.del(order.getId()+"");
            //2 线程A再更新mysql
            orderDao.update(order);
            //暂停20秒钟
            try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
            CompletableFuture.supplyAsync(() -> {
                //3 将第二次删除作为异步的。自己起一个线程，异步删除。
                // 这样，写的请求就不用沉睡一段时间后了，再返回。这么做，加大吞吐量。
                return jedis.del(order.getId() + "");
            }).whenComplete((t,u) -> {
                System.out.println("------t:"+t);
                System.out.println("------t:"+u);
            }).exceptionally(e ->{
                System.out.println("------e: "+e.getMessage());
                return 44L;
            }).get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: "+(endTime - startTime) +" 毫秒");
    }
}
