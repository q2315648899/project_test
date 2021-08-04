package cn.itcast.controller;

import cn.itcast.aop.OperateLog;
import cn.itcast.pojo.Brand;
import cn.itcast.service.BrandService;
import cn.itcast.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/insert")
    @OperateLog
    public Result insert(@RequestBody Brand brand){
        try {
            brandService.insert(brand);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }


    @RequestMapping("/update")
    @OperateLog
    public Result update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }


    @RequestMapping("/delete")
    @OperateLog
    public Result delete(Integer id){
        try {
            brandService.delete(id);
            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"操作失败");
        }
    }


    @RequestMapping("/selectOne")
    @OperateLog
    public Brand selectOne(Integer id) {
        Brand brand = brandService.selectOne(id);
        return brand;
    }


    @RequestMapping("/selectList")
    @OperateLog
    public List<Brand> selectList(){
        List<Brand> brandList = brandService.selectList();
        return brandList;
    }
}
