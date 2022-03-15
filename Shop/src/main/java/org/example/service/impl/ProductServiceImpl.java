package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.ProductMapper;
import org.example.pojo.Product;
import org.example.pojo.ProductExample;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    /*业务层 业务层要有持久层的对象
     * 同样的 显示层要有 业务层的对象*/
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> selectAllProduct() {
        /*select * from product 不需要添加条件 所以直接调用方法即可*/
        return productMapper.selectByExample(null);
    }


    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        /*这个函数就是 传入参数后 就给你返回一个PageInfo 最重要的是里面的集合 里面的集合是第几页开始 显示几条数据*/
        /*使用分页插件*/
        PageHelper.startPage(pageNum, pageSize);/*这里一定要先设置*/
        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause("pid desc");

        List<Product> products= productMapper.selectByExample(productExample);/*此时查到了集合*/

        PageInfo<Product> productPageInfo=new PageInfo<>(products);
                                                    /*把集合放入到pageinfo的对象中*/

        return productPageInfo;
    }

    @Override
    public int save(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public Product getById(int pid) {
        return productMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int updateInfo(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public int deleteMulById(String[] pids) {
        return productMapper.deleteMulById(pids);
    }
}
