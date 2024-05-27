package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.model.Node;
import com.example.project.service.NodeService;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NodeController {
    private final NodeService nodeService;
    private final UserService userService;

    private final ModelMapper modelMapper;

    @GetMapping("/{id_user}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NodeResponseByIdDto getNodeById(@PathVariable Long id_user, @PathVariable Long id, @RequestBody BasicCredentialsUserDto userDto) {
        var user = userService.getUserById(id_user);
        userService.checkUserCredentials(user, userDto.getUsername(), userDto.getPassword());
        var node = nodeService.getNodeById(id_user, id);
        var nodeDto = new NodeResponseByIdDto(id, node.getText()); // При map-е выбрасывало неверный id. Наверное, из-за особенностей строения node.

        return nodeDto;
    }

    @PostMapping("/add_node")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto createNode(@RequestBody NodeCreationDto creationDto){
        Node node = modelMapper.map(creationDto, Node.class);
        var user = userService.getUserById(creationDto.getUser_id());
        userService.checkUserCredentials(user, creationDto.getUsername(), creationDto.getPassword());
        node.setId(user);
        nodeService.createNode(node);

        ResponseDto response = new ResponseDto("Успех!");
        return response;
    }

    @DeleteMapping("/delete_node")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto deleteNode(@RequestBody NodeDeletionDto deletionDto) {
        Node node = nodeService.getNodeById(deletionDto.getUser_id(), deletionDto.getId());
        var user = userService.getUserById(deletionDto.getUser_id());
        userService.checkUserCredentials(user, deletionDto.getUsername(), deletionDto.getPassword());

        nodeService.deleteNode(node);
        ResponseDto response = new ResponseDto("Успех!");

        return response;
    }

    @PatchMapping("/edit_node")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseDto updateNode(@RequestBody NodeUpdateDto updateDto){
        Node node = nodeService.getNodeById(updateDto.getUser_id(), updateDto.getId());
        var user = userService.getUserById(updateDto.getUser_id());
        userService.checkUserCredentials(user, updateDto.getUsername(), updateDto.getPassword());
//        Node node = nodeService.getNodeById(updateDto.getUser_id(), updateDto.getId());
        nodeService.updateNode(node, updateDto.getUser_id(), updateDto.getId(), updateDto.getName(), updateDto.getText());
//        node.setText(updateDto.getText());

        ResponseDto response = new ResponseDto("Успех!");

        return response;
    }
}
