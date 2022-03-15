package org.example.controller;


import com.github.pagehelper.PageInfo;
import org.example.pojo.Product;
import org.example.service.ProductService;
import org.example.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ProductComtroller {

    public static final int MEI_YE_XIAN_SHI_JI_TIAO = 5;

    String saveFileName = "";

    @Autowired
    ProductService productService;

    @RequestMapping("/prod/getAll.action")
    public ModelAndView admin_getAll_action() {

        ModelAndView andView = new ModelAndView();
        List<Product> products = productService.selectAllProduct();

        andView.addObject("list", products);
        andView.setViewName("product");

        return andView;
    }

    @RequestMapping("/prod/split.action")
    public ModelAndView prod_split_action() {
        ModelAndView andView = new ModelAndView();

        PageInfo pageInfo = productService.splitPage(1, MEI_YE_XIAN_SHI_JI_TIAO);

        andView.addObject("info", pageInfo);
        andView.setViewName("product");
        return andView;

    }

    @ResponseBody
    @RequestMapping("/prod/ajaxSplit.action")
    public void ajax_split_action(int page, HttpSession session) {
        PageInfo info = productService.splitPage(page, MEI_YE_XIAN_SHI_JI_TIAO);
        session.setAttribute("info", info);
    }


    @ResponseBody
    @RequestMapping("/prod/ajaxImage.action")
    public Object prod_ajaxImage_action(MultipartFile pimage,
                                        HttpServletRequest servletRequest) {
        /*  <input type="file" id="pimage" name="这里要一样！！！pimage" onchange="fileChange()" >*/

        /*
            上传之后 我们要给其生成一个新的文件名 这样可以防止重名文件的 后来者覆盖前者
        * 文件名一般都是120aslkjd8798798bmnbmb.jpg这个样子的
        * 那么120aslkjd8798798bmnbmb是由FileNameUtil.getUUIDFileName()生成
        * .jpg这个是文件的格式 需要从上传过来的文件取得 FileNameUtil.getFileType()
        * 这个函数的作用就是 给我一个xxx.jpg 返回一个 .jpg 或者给我一个xxx.png 返回一个.png
        * */
        saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(pimage.getOriginalFilename());

        /*这一步是指定上传过来的这个文件应该储存在服务器的哪里
         * 我们的服务器下面有很多包 有/admin/xxx  有/css/xxx 等等 那么到底我们需要把上传过来的文件存在哪里呢？
         * */
        String path = servletRequest.getServletContext().getRealPath("/image_big");

        /*转存*/
        try {
            pimage.transferTo(new File(path + File.separator + saveFileName));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgurl", saveFileName);
        return jsonObject.toString();
    }


    @RequestMapping("/prod/save.action")
    public String prod_save_action(Product productInfo, HttpServletRequest request) {

        productInfo.setPimage(saveFileName);
        productInfo.setPdate(new Date());
        int num = -1;
        try {
            num = productService.save(productInfo);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (num > 0) {
            request.setAttribute("msg", "zeng jia cheng gong");
        } else {
            request.setAttribute("msg", "zeng jia shi bai");
        }
        saveFileName = "";
        return "forward:/prod/split.action";
    }

    @RequestMapping("/prod/update.action")
    public ModelAndView prod_update_action(Integer pid) {
        ModelAndView andView = new ModelAndView();
        Product product = productService.getById(pid);
        andView.addObject("prod", product);
        andView.setViewName("update");
        return andView;
    }


    @RequestMapping("/prod/update2.action")
    public ModelAndView prod_update2_action(Product prod) {
        ModelAndView andView = new ModelAndView();
        if (!saveFileName.equals("")){
            /*不等于空 代表 图片发生了更改
            * 把新的图片的名字赋给这个商品*/
            prod.setPimage(saveFileName);
        }
        int num = -1;
        num = productService.updateInfo(prod);

        if (num>0){
            /*更新成功*/
            andView.addObject("msg","cheng gong ");
        }else {
            /*更新失败*/
            andView.addObject("msg","shi bai ");
        }
        saveFileName="";
        andView.setViewName("forward:/prod/split.action");
        System.out.println("nihao1111");
        return andView;


    }

    @RequestMapping("/prod/deleteMultById.action")
    public String prod_delete_mult_by_id(String pids,HttpServletRequest request){
    /*ids 是 1，2，5 这样的形式*/

        System.out.println("kkkkkkk");
        String[]ps=pids.split(",");

        int num= 0;
        try {
            num = productService.deleteMulById(ps);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (num>0){
            request.setAttribute("msg","shan chu cheng gong");
        }else {
            request.setAttribute("msg","shan chu bu cheng gong");
        }
        return "";
    }


}
