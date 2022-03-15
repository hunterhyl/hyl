package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> selectAllProduct();

    PageInfo splitPage(int pageNum,int pageSize);

    int save(Product product);

    Product getById(int pid);

    int updateInfo(Product product);

    int deleteMulById(String[] pids);
}
