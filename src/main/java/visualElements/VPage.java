package visualElements;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class VPage extends VElement{
	VTitle vTitle;
	List<VLine> lines = new ArrayList<>();
	Rectangle background = new Rectangle();
	double MarginY = VConfig.getInstance().getGlobalConfig().get("MarginY");
	double MarginX = VConfig.getInstance().getGlobalConfig().get("MarginX");

	double PageX = VConfig.getInstance().getGlobalConfig().get("PageX");
	double PageY = VConfig.getInstance().getGlobalConfig().get("PageY");
	double measureDistance = VConfig.getInstance().getGlobalConfig().get("MeasureDistance");
	public VPage(){
		H = MarginY+measureDistance;
		background.setFill(Color.WHEAT);
		background.setWidth(PageX);
		background.setHeight(PageY);
		group.getChildren().add(background);

	}

	@Override
	public void setHighLight(boolean states) {
		for (VLine line:lines){
			line.setHighLight(states);
		}
	}

	@Override
	public Group getShapeGroups() {
		return group;
	}


	public boolean addNewLine(VLine line){
		if (H+measureDistance>PageY-MarginY){
			return false;
		}else {
			line.getShapeGroups().setLayoutY(H);
			line.getShapeGroups().setLayoutX(MarginX);
			lines.add(line);
			line.alignment();
			group.getChildren().add(line.getShapeGroups());
			H += line.getH()+measureDistance;
			return true;
		}
	}
	// must be called before add line
	public void addVTitle(VTitle vTitle){
		this.vTitle = vTitle;
		H += vTitle.getH();
	}
}
