package com.example.proyecto.controllers;

import com.example.proyecto.controllers.requests.GetCommentRequest;
import com.example.proyecto.controllers.responses.GetCommentResponse;
import com.example.proyecto.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @PostMapping
    public GetCommentResponse create(@RequestBody GetCommentRequest request){
        return service.create(request);
    }

    @GetMapping
    public List<GetCommentResponse> list(){
        return service.list();
    }

    @GetMapping("{id}")
    public GetCommentResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("{id}")
    public GetCommentResponse update(@PathVariable Long id, @RequestBody GetCommentRequest request){
        return service.update(id, request);
    }

}
