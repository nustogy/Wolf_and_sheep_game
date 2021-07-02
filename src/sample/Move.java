package sample;


import javafx.scene.control.RadioButton;

public class Move {

    private RadioButton sheepMove;
    private RadioButton wolfMove;


    public Move(RadioButton sheepMove, RadioButton wolfMove) {
        this.sheepMove = sheepMove;
        this.wolfMove = wolfMove;
        wolfMove.setSelected(true);
    }


    public void changeMove() {
        if (sheepMove.isSelected()) {
            sheepMove.setSelected(false);
            wolfMove.setSelected(true);
        } else {
            sheepMove.setSelected(true);
            wolfMove.setSelected(false);
        }
    }

    public boolean isSheepMove() {
        return sheepMove.isSelected();
    }
}
