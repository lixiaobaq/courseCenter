package com.iothings.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Alex
 * @time:2020/10/29 10:29 PM
 * @Description：课程分类
 */
@Entity
@NamedNativeQueries(value = {
        @NamedNativeQuery(
                name="courseFrameById",
                query="select * from course_frame where parentid = ?",
                resultSetMapping = "courseFrameLsit"
        )
})
@Table(name = "course_frame")
@Data
public class CourseFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer level;
    private Integer parentid;
    private Integer status;
    @Transient
    private Integer coursenum;

    public CourseFrame(){}

    public void chanegParent(){}

    public void changeStatus(){}
}
