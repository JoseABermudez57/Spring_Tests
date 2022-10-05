package com.example.proyecto.services;

import com.example.proyecto.controllers.requests.GetCommentRequest;
import com.example.proyecto.controllers.responses.GetCommentResponse;
import com.example.proyecto.entities.Comment;
import com.example.proyecto.repositories.ICommentRepository;
import com.example.proyecto.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository repository;

    @Override
    public GetCommentResponse create(GetCommentRequest request) {

        Comment save = repository.save(from(request));

        return from(save);
    }

    @Override
    public GetCommentResponse get(long id) {
        Comment comment = findAndEnsureExist(id);
        return from(comment);
    }

    @Override
    public List<GetCommentResponse> list() {
        return repository.findAll().stream().map(comment -> from(comment)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    @Override
    public GetCommentResponse update(Long id, GetCommentRequest request) {
        Comment comment = findAndEnsureExist(id);
        comment.setAuthor(request.getAuthor());
        comment.setText(request.getText());
        comment.setDate(request.getDate());

        Comment save = repository.save(comment);

        return from(save);
    }


    private Comment from(GetCommentRequest request){
        Comment comment = new Comment();
        comment.setText(request.getText());
        comment.setAuthor(request.getAuthor());
        comment.setDate(request.getDate());
        return comment;
    }

    private GetCommentResponse from(Comment comment){
        GetCommentResponse response = new GetCommentResponse();
        response.setId(comment.getId());
        response.setAuthor(comment.getAuthor());
        response.setText(comment.getText());
        response.setDate(comment.getDate());
        return response;
    }

    private Comment findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    };
}
