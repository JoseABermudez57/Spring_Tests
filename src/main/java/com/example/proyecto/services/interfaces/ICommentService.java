package com.example.proyecto.services.interfaces;

import com.example.proyecto.controllers.requests.GetCommentRequest;
import com.example.proyecto.controllers.responses.GetCommentResponse;

import java.util.List;

public interface ICommentService {

    GetCommentResponse create(GetCommentRequest request);

    GetCommentResponse get(long id);

    List<GetCommentResponse> list();

    void delete(Long id);

    GetCommentResponse update(Long id, GetCommentRequest request);
}
