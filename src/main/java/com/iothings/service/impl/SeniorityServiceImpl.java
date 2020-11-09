package com.iothings.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.iothings.dao.SeniorityRepository;
import com.iothings.entity.Business;
import com.iothings.entity.Seniority;
import com.iothings.service.SeniorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/7 15:01
 * @Description
 */
@Service
public class SeniorityServiceImpl implements SeniorityService {

    @Autowired
    private SeniorityRepository repository;
    @Override
    public Seniority save(Seniority Seniority) {
        return repository.save(Seniority);
    }

    @Override
    public List<Seniority> getTree(Integer status) {
        List<Seniority> CourseFrameList=repository.findByStatus(status);
        List<Seniority> CourseFrameList1=new ArrayList<Seniority>();
        for (Seniority business:CourseFrameList) {
            if(business.getParentid()==0){
                List<Seniority> CourseFrameList2= getCourseFrameList2(CourseFrameList,business.getId(),status,"0");
                business.setChildren(CourseFrameList2);
                CourseFrameList1.add(business);
            }
        }
        System.out.println("lieb:"+ JSONObject.toJSONString(CourseFrameList1));
        return CourseFrameList1;
    }

    @Override
    public List<Seniority> getTreeAndCourseCounts(Integer status) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Integer updataByid(Integer id, Integer pid, Integer sort) {
        return repository.updataByid(id,pid,sort);
    }

    /**
     * 获取行业子级分类，判断是否获取课程数量
     * @param list 所有行业分类
     * @param id 当前上级id
     * @param status 上下架
     * @param type 是否获取课程数
     * @return
     */
    public List<Seniority> getCourseFrameList2(List<Seniority> list, Long id, Integer status, String type){
        List<Seniority> CourseFrameList1=new ArrayList<Seniority>();
        for (Seniority CourseFrame:list) {
            if(CourseFrame.getParentid()==Math.toIntExact(id)){
                List<Seniority> CourseFrameList2= getCourseFrameList2(list,CourseFrame.getId(),status,type);
                if(type=="1"){
                    Integer num= repository.findCourseNumByFrame(Math.toIntExact(CourseFrame.getId()));
                    if(num>0){
                        num+= getNumSum(CourseFrameList2);//子级的课程总数和加自身的课程数量
                        CourseFrame.setNum(num);
                    }else{
                        CourseFrame.setNum(0);
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
    public Integer getNumSum(List<Seniority> list){
        Integer num=0;
        for (Seniority CourseFrame:list) {
            num+=CourseFrame.getNum();
        }
        return num;
    }
}