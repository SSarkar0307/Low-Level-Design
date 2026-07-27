public class Tree {
    int x;
    int y;
    TreeType treeType;

    Tree(int x, int y, TreeType treeType){
        this.x= x;
        this.y= y;
        this.treeType = treeType;
    }

    void draw(){
        treeType.draw(x, y);
    }
}
