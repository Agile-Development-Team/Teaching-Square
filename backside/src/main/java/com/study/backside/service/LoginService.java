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
        String[] ns = number.split(",");
        String num = ns[0];
        String[] pws = password.split(",");
        String pw = pws[0];
        log.info(num + "," + pw);
        String correctPassword = userMapper.getPasswordByNumber(num);
        if (correctPassword.equals(pw)) {
            return true;
        }
        return false;
    }

    public int getIdentity(String number) throws IOException {
        String[] ns = number.split(",");
        String num = ns[0];
        return userMapper.getIdentityByNumber(num);
    }

    public Boolean addUser(String number, String password, String name,
                           String college, String major,
                           String email, String tel, int identity) throws IOException {
        String num = number.split(",")[0];
        String pw = password.split(",")[0];
        String nm = name.split(",")[0];
        String clg = college.split(",")[0];
        String mj = major.split(",")[0];
        String em = email.split(",")[0];
        String te = tel.split(",")[0];
        log.info(num + "," + pw + "," + identity);
        int i = 0;
        try {
            i = userMapper.addUser(num, pw, identity);
        } catch (Exception e) {
            log.error("add user error");
        }
        if (identity == IdentityUtil.STUDENT_IDENTITY) {
            try {
                i = studentMapper.addStudent(num, nm, clg, mj, em, te);
            } catch (Exception e) {
                log.error("add student error");
            }
            if (identity == IdentityUtil.TEACHER_IDENTITY) {
                try {
                    i = teacherMapper.addTeacher(num, nm, clg, em, te);
                } catch (Exception e) {
                    log.error("add teacher error");
                }
            }
        }
        return i == 1 ? true : false;
    }
}
