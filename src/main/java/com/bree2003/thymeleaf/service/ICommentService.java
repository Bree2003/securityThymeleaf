package com.bree2003.thymeleaf.service;

import com.bree2003.thymeleaf.entity.CommentEntity;

import java.util.Optional;

public interface ICommentService {

    Optional<CommentEntity> getCommentById(Long id);
    void createComment(CommentEntity comment);
    void updateComment(Long id, CommentEntity comment);
    void deleteComment(Long id);
}
