package com.yupi.lananoj.service;

import com.yupi.lananoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.lananoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.lananoj.model.entity.User;

/**
* @author 王
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-06-02 14:46:46
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


}
