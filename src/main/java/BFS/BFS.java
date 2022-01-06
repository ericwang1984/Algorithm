package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

  List<List<Integer>> bfs(Node root) {

    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    Queue<Node> nodeQueue = new LinkedList<Node>();
    nodeQueue.add(root);

    while (!nodeQueue.isEmpty()) {
      int count = nodeQueue.size();
      List<Integer> layerList = new ArrayList<Integer>();
      while (count > 0) {
        Node curNode = nodeQueue.poll();
        layerList.add(curNode.getValue());
        if (curNode.leftNode != null) {
          nodeQueue.add(curNode.leftNode);
        }
        if (curNode.rightNode != null) {
          nodeQueue.add(curNode.rightNode);
        }
        count = count - 1;
        ans.add(layerList);
      }

    }

    return ans;
  }

}

class Node {

  int value;
  Node leftNode;
  Node rightNode;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(Node leftNode) {
    this.leftNode = leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public void setRightNode(Node rightNode) {
    this.rightNode = rightNode;
  }
}