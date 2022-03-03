package org.example.controller;


import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {


    @Resource
    private StudentService studentService;

    @RequestMapping("/addStudent.do")
    public ModelAndView controller_addStudent(Student student){
        ModelAndView andView=new ModelAndView();
        Integer num=  studentService.service_addStudent(student);
        if (num>0){
            andView.addObject("message",student.getName()+"注册成功");
        }else {
            andView.addObject("message","失败");
        }

        andView.setViewName("result");
        return andView;
    }


    @RequestMapping("/selectStudent.do")
    @ResponseBody   /*加上这个 意思是 转换成 json 数据*/
    public List<Student> controller_selectStudent(){

        List<Student> students=studentService.service_selectStudent();
        return students;
        /*返回的是数组 因为有了   @ResponseBody 这个注解 所以会被转换成json格式的数组*/

    }



}
