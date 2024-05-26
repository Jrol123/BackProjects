package com.example.project.service;

import com.example.project.model.Node;
import com.example.project.exception.*;
import com.example.project.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NodeService {
    private final NodeRepository nodeRepository;

    public void createNode(Node node) {
        nodeRepository.save(node);
    }

    public void deleteNode(Node node) {
        nodeRepository.delete(node);
    }

    public Node getNodeById(Long user_id, Long id) {
        return nodeRepository.findById_User_IdAndId_Id(user_id, id)
                .orElseThrow(() -> new NotFoundException("Записка с указанным id не найдена"));
    }

    public void updateNode(Long user_id, Long id, String text) {
        Node newNode = getNodeById(user_id, id);
        newNode.setText(text);

        nodeRepository.save(newNode);
    }

}
