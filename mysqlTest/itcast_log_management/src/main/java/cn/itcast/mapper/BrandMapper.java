package cn.itcast.mapper;

import cn.itcast.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    public void insert(Brand brand);

    public void update(Brand brand);

    public void delete(Integer id);

    public Brand selectOne(Integer id);

    public List<Brand> selectList();

}
