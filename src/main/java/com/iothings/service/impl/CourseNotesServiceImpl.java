package com.iothings.service.impl;

import com.iothings.dao.CourseNotesRepository;
import com.iothings.entity.CourseNotes;
import com.iothings.form.CourseNotesForm;
import com.iothings.service.CourseNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alex
 * @time:2020/11/9 10:03
 * @Description
 */
@Service
public class CourseNotesServiceImpl implements CourseNotesService {
    @Autowired
    private CourseNotesRepository repository;

    @Override
    public CourseNotes save(CourseNotesForm courseNotesForm) {
        CourseNotes courseNotes=new CourseNotes();
        if(courseNotesForm.getId()!=null){
            courseNotes =repository.getOne(courseNotesForm.getId());
        }
        if(courseNotesForm.getContent()!=null){
            courseNotes.setContent(courseNotesForm.getContent());
        }
        if(courseNotesForm.getCourseId()!=null){
            courseNotes.setCourseId(courseNotesForm.getCourseId());
        }
        if(courseNotesForm.getLinkCourseTime()!=null){
            courseNotes.setLinkCourseTime(courseNotesForm.getLinkCourseTime());
        }
        if(courseNotesForm.getUserId()!=null){
            courseNotes.setUserId(courseNotesForm.getUserId());
        }
        courseNotes=repository.save(courseNotes);
        return courseNotes;
    }

    @Override
    public List<CourseNotes> findByCourseId(Integer id) {

        List<CourseNotes>  courseNotesList= repository.findByCourseId(id);
        List user=new ArrayList();
        //TOOD 暂时注释，待获取用户表后开放
//        for (CourseNotes courseNotes:courseNotesList) {
//            for (int i = 0; i <user.size(); i++) {
//                if(courseNotes.getUserId()==user.get(i).getId()){
//                    courseNotes.setUserImg(user.get(i).getimg());
//                    courseNotes.setUserName(user.get(i).getName());
//                }
//            }
//        }
        return courseNotesList;
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(Long.valueOf(id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(Long.valueOf(id));
    }
}
