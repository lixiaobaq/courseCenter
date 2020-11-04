package com.iothings.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.iothings.dao.CourseFrameRepository;
import com.iothings.entity.CourseFrame;
import com.iothings.service.CourseFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
@Service
public class CourseFrameServiceImpl implements CourseFrameService {

    @Autowired
    private CourseFrameRepository repository;

    @Override
    public CourseFrame save(CourseFrame courseFrame) {
        return repository.save(courseFrame);
    }
    @Override
    public void delete(Integer id){
        repository.deleteById(Long.valueOf(id));
    }

    /**
     * 获取课程分类树
     * @param status
     * @return
     */
    @Override
    public List<CourseFrame> getTree(Integer status){
        List<CourseFrame> CourseFrameList=repository.findByStatus(status);
        List<CourseFrame> CourseFrameList1=new ArrayList<CourseFrame>();
        for (CourseFrame CourseFrame:CourseFrameList) {
            if(CourseFrame.getParentid()==0){
                List<CourseFrame> CourseFrameList2= getCourseFrameList2(CourseFrameList,CourseFrame.getId(),status,"0");
                CourseFrame.setChildren(CourseFrameList2);
                CourseFrameList1.add(CourseFrame);
            }
        }
        System.out.println("lieb:"+ JSONObject.toJSONString(CourseFrameList1));
        return CourseFrameList1;
    };
    @Override
    public List<CourseFrame> getTreeAndCourseCounts(Integer status){
        List<CourseFrame> CourseFrameList=repository.findByStatus(status);
        List<CourseFrame> CourseFrameList1=new ArrayList<CourseFrame>();
        for (CourseFrame CourseFrame:CourseFrameList) {
            if(CourseFrame.getParentid()==0){
                List<CourseFrame> CourseFrameList2= getCourseFrameList2(CourseFrameList,CourseFrame.getId(),status,"1");
                Integer num= repository.findCourseNumByFrame(Math.toIntExact(CourseFrame.getId()));
                CourseFrame.setChildren(CourseFrameList2);
                if(num>0){
                    num+= getNumSum(CourseFrameList2);//子级的课程总数和加自身的课程数量
                    CourseFrame.setCoursenum(num);
                }else{
                    CourseFrame.setCoursenum(0);
                }
                CourseFrameList1.add(CourseFrame);
            }
        }
        System.out.println("lieb:"+ JSONObject.toJSONString(CourseFrameList1));
        return CourseFrameList1;
    };

    /**
     * 获取课程子级分类，判断是否获取课程数量
     * @param list 所有课程分类
     * @param id 当前上级id
     * @param status 上下架
     * @param type 是否获取课程数
     * @return
     */
    public List<CourseFrame> getCourseFrameList2(List<CourseFrame> list,Long id,Integer status,String type){
        List<CourseFrame> CourseFrameList1=new ArrayList<CourseFrame>();
        for (CourseFrame CourseFrame:list) {
            if(CourseFrame.getParentid()==Math.toIntExact(id)){
                List<CourseFrame> CourseFrameList2= getCourseFrameList2(list,CourseFrame.getId(),status,type);
                if(type=="1"){
                    Integer num= repository.findCourseNumByFrame(Math.toIntExact(CourseFrame.getId()));
                    if(num>0){
                        num+= getNumSum(CourseFrameList2);//子级的课程总数和加自身的课程数量
                        CourseFrame.setCoursenum(num);
                    }else{
                        CourseFrame.setCoursenum(0);
                    }
                }
                CourseFrame.setChildren(CourseFrameList2);
                CourseFrameList1.add(CourseFrame);
            }
        }
        return CourseFrameList1;
    }

    /**
     * 循环查询下一子集的所有课程数量
     * @param list
     * @return 返回课程总数
     */
    public Integer getNumSum(List<CourseFrame> list){
        Integer num=0;
        for (CourseFrame CourseFrame:list) {
            num+=CourseFrame.getCoursenum();
        }
        return num;
    }
}
