package com.study.backside.service;

import com.study.backside.mapper.StudentMapper;
import com.study.backside.mapper.TeacherMapper;
import com.study.backside.mapper.UserMapper;
import com.study.backside.util.IdentityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author Carol9s
 * @Classname
 * @Date 2022/2/12 15:20
 */
@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;
    private TeacherMapper teacherMapper;
    private StudentMapper studentMapper;

    private Logger log = LoggerFactory.getLogger("LoginService");

    public Boolean isLogin(String number, String password) throws IOException {
        /*String[] ns = number.split(",");
        String num = ns[1];
        String[] pws = password.split(",");
        String pw = pws[1];
        log.info(num + "," + pw);*/
        String correctPassword = userMapper.getPasswordByNumber(number);
        if (correctPassword.equals(password)) {
            return true;
        }
        return false;
    }

    public int getIdentity(String number) throws IOException {
        /*String[] ns = number.split(",");
        String num = ns[1];*/
        return userMapper.getIdentityByNumber(number);
    }

    public Boolean addUser(String number, String password, String name,
                           String college, String major,
                           String email, String tel, int identity) throws IOException {
        /*String num = number.split(",")[1];
        String pw = password.split(",")[1];
        String nm = name.split(",")[0];
        String clg = college.split(",")[0];
        String mj = major.split(",")[0];
        String em = email.split(",")[0];
        String te = tel.split(",")[0];
        log.info(num + "," + pw + "," + identity);
        log.info(pw);
        log.info(nm);
        log.info(clg);
        log.info(clg);
        log.info(mj);
        log.info(em);
        log.info(te);*/

        int i = 0;
        try {
            i = userMapper.addUser(number, password, identity);  //添加用户
        } catch (Exception e) {
            log.error("add user error");
        }
        if (identity == IdentityUtil.STUDENT_IDENTITY) { //添加学生
            try {
                i = studentMapper.addStudent(number, name, college, major, email, tel);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("add student error");
            }
            if (identity == IdentityUtil.TEACHER_IDENTITY) {  //添加老师
                try {
                    i = teacherMapper.addTeacher(number, name, college, email, tel);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("add teacher error");
                }
            }
        }
        return i == 1 ? true : false;
    }
}
