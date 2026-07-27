import java.util.*;

public class Forest {
    List<Tree> forest = new ArrayList<>();


    void plantTree(int x, int y, String color, String texture){
        Tree tree = new Tree(x, y, ForestFactory.get(color, texture));
        forest.add(tree);
    }

    void draw(){
        for(Tree tree : forest){
            tree.draw();
        }
    }

}
