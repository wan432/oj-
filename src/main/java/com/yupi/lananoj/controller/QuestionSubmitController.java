package com.yupi.lananoj.controller;

import com.yupi.lananoj.common.BaseResponse;
import com.yupi.lananoj.common.ErrorCode;
import com.yupi.lananoj.common.ResultUtils;
import com.yupi.lananoj.exception.BusinessException;
import com.yupi.lananoj.model.dto.postthumb.questionSubmitAddRequest;
import com.yupi.lananoj.model.entity.User;
import com.yupi.lananoj.service.questionSubmitService;
import com.yupi.lananoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/post_thumb")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private questionSubmitService QuestionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param QuestionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Integer> doThumb(@RequestBody questionSubmitAddRequest QuestionSubmitAddRequest,
            HttpServletRequest request) {
        if (QuestionSubmitAddRequest == null || QuestionSubmitAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long postId = QuestionSubmitAddRequest.getPostId();
        int result = QuestionSubmitService.doquestionSubmit(postId, loginUser);
        return ResultUtils.success(result);
    }

}
