package cn.itcast.service;

import cn.itcast.mapper.BrandMapper;
import cn.itcast.pojo.Brand;
import cn.itcast.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public void insert(Brand brand){
        brandMapper.insert(brand);
    }

    public void update(Brand brand){
        //brandMapper.update(brand);
    }

    public void delete(Integer id){
        //brandMapper.delete(id);
    }

    @RequestMapping("/selectOne")
    public Brand selectOne(Integer id) {
        Brand brand = brandMapper.selectOne(id);
        return brand;
        //return new Brand();
    }

    @RequestMapping("/selectList")
    public List<Brand> selectList(){
        //List<Brand> brandList = brandMapper.selectList();
        //return brandList;
        return new ArrayList<Brand>();
    }


}
