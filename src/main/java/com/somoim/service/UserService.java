package com.somoim.service;

import com.somoim.exception.DuplicateEmailException;
import com.somoim.mapper.UserMapper;
import com.somoim.model.dao.User;
import com.somoim.model.dto.LoginUser;
import com.somoim.model.dto.ResignUser;
import com.somoim.model.dto.SignUpUser;
import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncorder;
    private final HttpSession httpSession;
    private final String USER_ID = "USER_ID";

    @Transactional
    public void insertUser(SignUpUser user) {
        if (checkEmail(user.getEmail())) {
            throw new DuplicateEmailException("This email already registered.");
        }

        LocalDateTime time = LocalDateTime.now();

        User newUser = User.builder()
            .email(user.getEmail())
            .password(passwordEncorder.encode(user.getPassword()))
            .createAt(time)
            .modifyAt(time)
            .disband(false)
            .build();
        userMapper.createUser(newUser);
    }

    @Transactional(readOnly = true)
    public boolean checkEmail(String email) {
        return userMapper.isExistsEmail(email);
    }

    @Transactional
    public void deleteUser(ResignUser user) {
        User resignUser = User.builder()
            .email(user.getEmail())
            .modifyAt(LocalDateTime.now())
            .disband(true)
            .build();
        userMapper.deleteUser(resignUser);
    }

    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    public void loginUser(LoginUser loginUser) {
        User user = findUserByEmail(loginUser.getEmail());
        if (user != null) {
            if (passwordEncorder.matches(loginUser.getPassword(), user.getPassword())) {
                if (!checkDisband(loginUser.getEmail())) {
                    httpSession.setAttribute(USER_ID, user.getId());
                } else {
                    throw new IllegalArgumentException("The retired user.");
                }
            } else {
                throw new IllegalArgumentException("The password is invalid.");
            }
        } else {
            throw new IllegalArgumentException("The user does not exist.");
        }
    }

    public void logoutUser() {
        httpSession.removeAttribute(USER_ID);
    }

    public boolean checkLogin() {
        return httpSession.getAttribute(USER_ID) != null;
    }

    @Transactional(readOnly = true)
    public boolean checkDisband(String email) {
        return userMapper.getDisbandByEmail(email);
    }
}
